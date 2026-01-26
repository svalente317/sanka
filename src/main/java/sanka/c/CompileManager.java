package sanka.c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import sanka.ClassDefinition;
import sanka.Environment;
import sanka.MethodDefinition;
import sanka.StringUtils;
import sanka.TypeDefinition;

public class CompileManager {

    static final String GCC = "gcc";
    static final String DBG = "-g";

    private final List<String> cFlags;
    private final List<String> cLibs;
    private final List<String> cHeaders;
    private final List<String> cFiles;

    public CompileManager() {
        this.cFlags = new ArrayList<>();
        this.cLibs = new ArrayList<>();
        this.cHeaders = new ArrayList<>();
        this.cFiles = new ArrayList<>();
    }

    public void addCLibrary(String path) {
        this.cLibs.add(path);
    }

    public void addCHeader(String path) {
        this.cHeaders.add(path);
    }

    public void addCFile(String path) {
        this.cFiles.add(path);
    }

    public void compile(String mainClass, String exeName) throws Exception {
        Environment env = Environment.getInstance();
        String mainPackage = null;
        String className = mainClass;
        int idx = mainClass.lastIndexOf('.');
        if (idx >= 0) {
            mainPackage = mainClass.substring(0,  idx);
            className = className.substring(idx+1);
        }
        ClassDefinition mcd = env.getClassDefinition(mainPackage, className);
        if (mcd == null) {
            env.printError(null, mainClass + ": class not found");
            return;
        }
        if (mcd.isAbstract || mcd.isInterface) {
            env.printError(null, mainClass + ": class cannot be instantiated");
            return;
        }
        List<String> linkCommand = new ArrayList<>();
        compileClassesToObjects(linkCommand);
        String filename = generateMainFile(mcd);
        if (filename == null) {
            return;
        }
        compileFile(filename, null, linkCommand);
        String ofilename = linkCommand.get(linkCommand.size()-1);
        if (env.errorCount > 0) {
            return;
        }
        linkCommand.add(0, GCC);
        for (String libPath : env.libPath) {
            linkCommand.add("-L" + libPath);
        }
        linkCommand.add("-lsankaruntime");
        linkCommand.add("-lgc");
        linkCommand.add("-lpthread");
        linkCommand.add("-lm");
        linkCommand.addAll(this.cLibs);
        linkCommand.add("-o");
        linkCommand.add(exeName);
        int status = executeCommand(linkCommand);
        if (status == 0) {
            new File(filename).delete();
            new File(ofilename).delete();
        } else {
            env.printError(null, exeName + ": compiler exited with status " + status);
        }
    }

    /**
     * env.classList is a list of classes that have already been compiled into .c files.
     * Compile these .c files into one or more .o files.
     * Add all generated .o files to outputList.
     */
    public void compileClassesToObjects(List<String> outputList) throws Exception {
        Environment env = Environment.getInstance();
        for (String filename : this.cHeaders) {
            if (env.topDirectory != null) {
                Path path = Paths.get(filename);
                Files.copy(path, Paths.get(env.topDirectory, path.getFileName().toString()),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        Set<String> packageSet = new TreeSet<>();
        for (ClassDefinition classdef : env.classList) {
            if (!classdef.isImport) {
                packageSet.add(classdef.packageName);
            }
        }
        for (String packageName : packageSet) {
            File pkgFile = getPackageFilename(packageName);
            Writer writer = new FileWriter(pkgFile);
            Set<String> includeSet = new TreeSet<>();
            for (ClassDefinition classdef : env.classList) {
                if (classdef.isImport || !classdef.packageName.equals(packageName)) {
                    continue;
                }
                File cfile = ClassTranslator.getClassFilename(classdef, false);
                BufferedReader reader = new BufferedReader(new FileReader(cfile));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("#include ")) {
                        if (!includeSet.add(line)) {
                            continue;
                        }
                    }
                    writer.write(line + "\n");
                }
                reader.close();
            }
            writer.close();
            compileFile(pkgFile.getPath(), null, outputList);
        }
        if (env.topDirectory != null) {
            for (String filename : this.cFiles) {
                String objFilename = filename.substring(0, filename.length() - 1) + "o";
                objFilename = new File(env.topDirectory, new File(objFilename).getName()).getPath();
                compileFile(filename, objFilename, outputList);
            }
        }
    }


    public static File getPackageFilename(String packageName) {
        // See ClassTranslator.getClassFilename
        Environment env = Environment.getInstance();
        if (packageName == null) {
            packageName = "sanka";
        }
        String filename = "pkg_" +  StringUtils.replaceDot(packageName, '_') + ".c";
        return env.topDirectory == null ? new File(filename) :
                    new File(env.topDirectory, filename);
    }

    public void compileFile(String filename, String objFilename, List<String> ofileList) throws Exception {
        Environment env = Environment.getInstance();
        List<String> command = new ArrayList<>();
        command.add(GCC);
        command.add(DBG);
        for (String importPath : env.importPath) {
            command.add("-I" + importPath);
        }
        String top = env.topDirectory == null ? "." : env.topDirectory;
        command.add("-I" + top);
        command.addAll(this.cFlags);
        if (objFilename == null) {
            objFilename = filename.substring(0, filename.length() - 1) + "o";
        }
        command.add("-o");
        command.add(objFilename);
        command.add("-c");
        command.add(filename);
        int status = executeCommand(command);
        if (status != 0) {
            env.printError(null, filename + ": compiler exited with status " + status);
        }
        ofileList.add(objFilename);
    }

    public int executeCommand(List<String> command) throws Exception {
        String[] args = command.toArray(new String[0]);
        printCommand(args);
        Process process = Runtime.getRuntime().exec(args);
        StreamGobbler stdoutGobbler =
            new StreamGobbler(process.getInputStream(), System.out);
        stdoutGobbler.start();
        StreamGobbler stderrGobbler =
            new StreamGobbler(process.getErrorStream(), System.err);
        stderrGobbler.start();
        int exitCode = process.waitFor();
        stdoutGobbler.join();
        stderrGobbler.join();
        return exitCode;
    }

    private void printCommand(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (String arg : args) {
            if (!builder.isEmpty()) {
                builder.append(" ");
            }
            builder.append(arg);
        }
        System.out.println(builder);
    }

    private String generateMainFile(ClassDefinition classdef) throws Exception {
        Environment env = Environment.getInstance();
        MethodDefinition method = classdef.getMethod("main", 1);
        if (method == null || !method.isStatic || method.isPrivate) {
            env.printError(null, "class " + classdef.name + " must define public " +
                    "static main() function");
            return null;
        }
        if (method.isOverloaded) {
            env.printError(null, "class " + classdef.name + " must not overload main()");
            return null;
        }
        if (!(method.returnType.equals(TypeDefinition.INT_TYPE) ||
              method.returnType.equals(TypeDefinition.VOID_TYPE))) {
            env.printError(null,  "class " + classdef.name + " main() must return int");
            return null;
        }
        File tmpfile = File.createTempFile("main", ".c");
        env.writer = new BufferedWriter(new FileWriter(tmpfile));
        env.print(ClassTranslator.INCLUDE_SANKA_HEADER);
        String fname = ClassTranslator.getHeaderFileName(classdef.packageName, classdef.name);
        env.print("#include <" + fname + ">");
        env.print("");
        env.print("int main(int argc, char *const *argv) {");
        env.level++;
        env.print("GC_INIT();");
        env.print("struct array arr;");
        env.print("arr.data = argv;");
        env.print("arr.length = argc;");
        String call = TranslationBase.translateMethodName(classdef.name, "main") + "(&arr);";
        if (method.returnType.equals(TypeDefinition.VOID_TYPE)) {
            env.print(call);
            env.print("return 0;");
        } else {
            env.print("return " + call);
        }
        env.level--;
        env.print("}");
        env.writer.close();
        env.writer = null;
        return tmpfile.getAbsolutePath();
    }

    public void runPkgConfig(String pkgName) throws IOException, InterruptedException {
        runPkgConfigOnce(pkgName, "--cflags", this.cFlags);
        runPkgConfigOnce(pkgName, "--libs", this.cLibs);
    }

    private void runPkgConfigOnce(String pkgName, String arg, List<String> results)
            throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("pkg-config", arg, pkgName);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = reader.readLine();
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            System.err.println("pkg-config exited code " + exitCode);
        }
        for (String result : line.split("\\s+")) {
            if (!result.isEmpty()) {
                results.add(result);
            }
        }
    }
}
