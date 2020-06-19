package sanka.c;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.archivers.ar.ArArchiveOutputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

import sanka.ClassDefinition;
import sanka.ClassWriter;
import sanka.Environment;
import sanka.MethodDefinition;
import sanka.TypeDefinition;

public class CompileManager {

    static final String GCC = "gcc";
    static final String DBG = "-g";

    public void compile(String mainClass, String exeName) throws Exception {
        Environment env = Environment.getInstance();
        String packageName = null;
        String className = mainClass;
        int idx = mainClass.lastIndexOf('.');
        if (idx >= 0) {
            packageName = mainClass.substring(0,  idx);
            className = className.substring(idx+1);
        }
        ClassDefinition mcd = env.getClassDefinition(packageName, className);
        if (mcd == null) {
            env.printError(null, mainClass + ": class not found");
            return;
        }
        if (mcd.isAbstract || mcd.isInterface) {
            env.printError(null, mainClass + ": class cannot be instantiated");
            return;
        }
        List<String> linkcommand = new ArrayList<>();
        for (ClassDefinition classdef : env.classList) {
            if (classdef.isImport) {
                continue;
            }
            File cfile = ClassTranslator.getClassFilename(classdef, false);
            compileFile(cfile.getPath(), linkcommand);
        }
        String filename = generateMainFile(mcd);
        if (filename == null) {
            return;
        }
        compileFile(filename, linkcommand);
        String ofilename = linkcommand.get(linkcommand.size()-1);
        if (env.errorCount > 0) {
            return;
        }
        linkcommand.add(0, GCC);
        for (String libPath : env.libPath) {
            linkcommand.add("-L" + libPath);
        }
        linkcommand.add("-lsankaruntime");
        linkcommand.add("-lgc");
        linkcommand.add("-lpthread");
        if (env.libraries != null) {
            linkcommand.addAll(env.libraries);
        }
        linkcommand.add("-o");
        linkcommand.add(exeName);
        int status = executeCommand(linkcommand);
        if (status == 0) {
            new File(filename).delete();
            new File(ofilename).delete();
        } else {
            env.printError(null, exeName + ": compiler exited with status " + status);
        }
    }

    private void compileFile(String filename, List<String> ofileList) throws Exception {
        Environment env = Environment.getInstance();
        List<String> command = new ArrayList<>();
        command.add(GCC);
        command.add(DBG);
        for (String importPath : env.importPath) {
            command.add("-I" + importPath);
        }
        String top = env.topDirectory == null ? "." : env.topDirectory;
        command.add("-I" + top);
        String objfilename = filename.substring(0, filename.length()-1) + "o";
        command.add("-o");
        command.add(objfilename);
        command.add("-c");
        command.add(filename);
        int status = executeCommand(command);
        if (status != 0) {
            env.printError(null, filename + ": compiler exited with status " + status);
        }
        ofileList.add(objfilename);
    }

    private int executeCommand(List<String> command) throws Exception {
        String[] args = command.toArray(new String[0]);
        printCommand(args);
        Process process = Runtime.getRuntime().exec(args);
        return process.waitFor();
    }

    private void printCommand(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (String arg : args) {
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(arg);
        }
        System.out.println(builder.toString());
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

    public void createLibrary(String filename) throws Exception {
        Environment env = Environment.getInstance();
        List<String> ofileList = new ArrayList<>();
        for (ClassDefinition classdef : env.classList) {
            if (classdef.isImport) {
                continue;
            }
            File cfile = ClassTranslator.getClassFilename(classdef, false);
            compileFile(cfile.getPath(), ofileList);
        }
        if (env.errorCount > 0) {
            return;
        }

        // Create the lib[name].a file containing the .o files.
        // This will be used by gcc to link executables using this library.
        InputStream istream;
        String name;
        File tmpfile = File.createTempFile("sanka", ".tmp");
        FileOutputStream arFile = new FileOutputStream(tmpfile);
        ArArchiveOutputStream arStream = new ArArchiveOutputStream(arFile);
        int counter = 1;
        for (String ofilename : ofileList) {
            File ofile = new File(ofilename);
            name = getShortName(ofile, counter);
            arStream.putArchiveEntry(arStream.createArchiveEntry(ofile, name));
            istream = new FileInputStream(ofile);
            IOUtils.copy(istream, arStream);
            istream.close();
            arStream.closeArchiveEntry();
            counter++;
        }
        arStream.close();

        // Create the [name].tar file with everything that sanka needs to use this library.
        // This includes sanka headers, C headers, and object files.
        FileOutputStream tarFile = new FileOutputStream(filename);
        TarArchiveOutputStream tarStream = new TarArchiveOutputStream(tarFile);

        // Include lib[name].a in the library.
        name = new File(filename).getName();
        int idx = name.lastIndexOf('.');
        name = (idx > 0) ? name.substring(0, idx) : name;
        tarStream.putArchiveEntry(tarStream.createArchiveEntry(tmpfile, "lib" + name + ".a"));
        istream = new FileInputStream(tmpfile);
        IOUtils.copy(istream, tarStream);
        istream.close();
        tarStream.closeArchiveEntry();

        // Include skeleton .san files for all classes in the library.
        for (ClassDefinition classdef : env.classList) {
            if (classdef.isImport || classdef.isAnonymous) {
                continue;
            }
            ClassWriter.writeFile(classdef, tmpfile);
            name = ClassTranslator.getSankaImportFileName(classdef);
            tarStream.putArchiveEntry(tarStream.createArchiveEntry(tmpfile, name));
            istream = new FileInputStream(tmpfile);
            IOUtils.copy(istream, tarStream);
            istream.close();
            tarStream.closeArchiveEntry();
        }

        // Include all .h files in the library.
        for (ClassDefinition classdef : env.classList) {
            if (classdef.isImport || classdef.isAnonymous) {
                continue;
            }
            File hfile = ClassTranslator.getClassFilename(classdef, true);
            name = ClassTranslator.getHeaderFileName(classdef.packageName, classdef.name);
            tarStream.putArchiveEntry(tarStream.createArchiveEntry(hfile, name));
            istream = new FileInputStream(hfile);
            IOUtils.copy(istream, tarStream);
            istream.close();
            tarStream.closeArchiveEntry();
        }
        tarStream.close();
    }

    private static String getShortName(File file, int counter) {
        String name = file.getName();
        if (name.length() < 16) {
            return name;
        }
        int idx = name.indexOf('.');
        String part1 = (idx < 0) ? name : name.substring(0, idx);
        String part2 = "" + counter;
        String part3 = (idx < 0) ? "" : name.substring(idx);
        return part1.substring(0, 15-part2.length()-part3.length()) + part2 + part3;
    }

    private static CompileManager instance = null;

    public static CompileManager getInstance() {
        if (instance == null) {
            instance = new CompileManager();
        }
        return instance;
    }
}
