package sanka;

import java.io.File;
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
            List<String> command = new ArrayList<>();
            command.add(GCC);
            command.add(DBG);
            for (String importPath : env.importPath) {
                command.add("-I" + importPath);
            }
            command.add("-I.");
            String filename = TranslationUtils.replaceDot(
                    classdef.packageName, File.separatorChar) +
                    File.separatorChar + classdef.name;
            String cfilename = filename + ".c";
            filename = filename + ".o";
            command.add("-o");
            command.add(filename);
            command.add("-c");
            command.add(cfilename);
            int status = executeCommand(command);
            if (status != 0) {
                String name = classdef.name;
                if (classdef.packageName != null) {
                    name = classdef.packageName + "." + name;
                }
                env.printError(null, classdef.name +
                        ": compiler exited with status " + status);
            }
            linkcommand.add(filename);
        }
        if (env.errorCount > 0) {
            return;
        }
        linkcommand.add(0, GCC);
        // TODO fix this!
        linkcommand.add("-L/opt/sanka/lib");
        linkcommand.add("-lsankaruntime");
        linkcommand.add("-o");
        linkcommand.add(exeName);
        int status = executeCommand(linkcommand);
        if (status != 0) {
            env.printError(null, exeName + ": compiler exited with status " + status);
        }
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

    static CompileManager instance = null;

    static CompileManager getInstance() {
        if (instance == null) {
            instance = new CompileManager();
        }
        return instance;
    }
}
