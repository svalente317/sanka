package sanka;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

class CompileManager {

    static final String GCC = "gcc";
    static final String DBG = "-O6";

    void compile(String mainClass, String exeName) throws Exception {
        Environment env = Environment.getInstance();
        List<String> linkcommand = new ArrayList<>();
        for (ClassDefinition classdef : env.classList) {
            if (classdef.isImport) {
                continue;
            }
            // Should use TranslationUtils to get generated file name including $top.
            String filename = classdef.name + ".c";
            if (classdef.packageName != null) {
                filename = TranslationUtils.replaceDot(classdef.packageName, File.separatorChar) +
                    File.separatorChar + filename;
            }
            compileFile(filename, linkcommand);
        }
        String filename = generateMainFile(mainClass);
        compileFile(filename, linkcommand);
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
        linkcommand.add("-o");
        linkcommand.add(exeName);
        int status = executeCommand(linkcommand);
        if (status != 0) {
            env.printError(null, exeName + ": compiler exited with status " + status);
        }
    }

    void compileFile(String filename, List<String> ofileList) throws Exception {
        Environment env = Environment.getInstance();
        List<String> command = new ArrayList<>();
        command.add(GCC);
        command.add(DBG);
        for (String importPath : env.importPath) {
            command.add("-I" + importPath);
        }
        command.add("-I.");
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

    int executeCommand(List<String> command) throws Exception {
        String[] args = command.toArray(new String[0]);
        printCommand(args);
        Process process = Runtime.getRuntime().exec(args);
        return process.waitFor();
    }

    void printCommand(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (String arg : args) {
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(arg);
        }
        System.out.println(builder.toString());
    }

    String generateMainFile(String mainClass) throws Exception {
        Environment env = Environment.getInstance();
        String packageName = null;
        String className = mainClass;
        int idx = mainClass.lastIndexOf('.');
        if (idx >= 0) {
            packageName = mainClass.substring(0,  idx);
            className = className.substring(idx+1);
        }
        File tmpfile = File.createTempFile("main", ".c");
        env.writer = new BufferedWriter(new FileWriter(tmpfile));
        env.print(TranslationUtils.INCLUDE_SANKA_HEADER);
        env.print("#include <" + TranslationUtils.getHeaderFileName(packageName, className) + ">");
        env.print("");
        env.print("int main(int argc, char *const *argv) {");
        env.level++;
        env.print("GC_INIT();");
        env.print("struct array arr;");
        env.print("arr.data = argv;");
        env.print("arr.length = argc;");
        env.print(TranslationUtils.translateClassItem(className, "main") + "(&arr);");
        env.print("return 0;");
        env.level--;
        env.print("}");
        env.writer.close();
        env.writer = null;
        return tmpfile.getAbsolutePath();
    }

    static CompileManager instance = null;

    static CompileManager getInstance() {
        if (instance == null) {
            instance = new CompileManager();
        }
        return instance;
    }
}
