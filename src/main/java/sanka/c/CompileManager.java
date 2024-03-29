package sanka.c;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import sanka.ClassDefinition;
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
        if (env.libraries != null) {
            linkcommand.addAll(env.libraries);
        }
        for (String libPath : env.libPath) {
            linkcommand.add("-L" + libPath);
        }
        linkcommand.add("-lsankaruntime");
        linkcommand.add("-lgc");
        linkcommand.add("-lpthread");
        if (env.cLibraries != null) {
            linkcommand.addAll(env.cLibraries);
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

    public void compileFile(String filename, List<String> ofileList) throws Exception {
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

    public int executeCommand(List<String> command) throws Exception {
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

    private static CompileManager instance = null;

    public static CompileManager getInstance() {
        if (instance == null) {
            instance = new CompileManager();
        }
        return instance;
    }
}
