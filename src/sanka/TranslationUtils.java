package sanka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class TranslationUtils {
    /**
     * @return the translated C name of a static field, constructor, or method.
     */
    static String translateClassItem(String className, String itemName) {
        return className + "__" + itemName;
    }

    static String replaceDot(String s, char ch) {
        int prev = 0;
        while (true) {
            int idx = s.indexOf('.', prev);
            if (idx < 0) {
                break;
            }
            s = s.substring(0, idx) + ch + s.substring(idx+1);
            prev = idx+1;
        }
        return s;
    }

    /**
     * Write Class.h and/or Class.c files in the output directory.
     */
    static void translateClass(ClassDefinition classdef, boolean isHeader) throws IOException {
        Environment env = Environment.getInstance();
        File tmpfile = File.createTempFile("sankaclass", "txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tmpfile));
        env.setWriter(writer);
        if (isHeader) {
            classdef.translateHeader();
        } else {
            classdef.translate();
        }
        writer.close();
        writer = null;
        env.setWriter(null);

        // TODO append prefix directory
        String suffix = isHeader ? ".h" : ".c";
        String filename = classdef.name + suffix;
        File destFile;
        String symbol;
        if (classdef.packageName != null) {
            String path = replaceDot(classdef.packageName, File.separatorChar);
            File packageDirectory = new File(path);
            packageDirectory.mkdirs();
            destFile = new File(packageDirectory, filename);
            symbol = replaceDot(classdef.packageName, '_') + "_" + classdef.name;
        } else {
            destFile = new File(filename);
            symbol = classdef.name;
        }
        writer = new BufferedWriter(new FileWriter(destFile));
        env.setWriter(writer);
        if (isHeader) {
            symbol = symbol + "_h_INCLUDED";
            env.print("#ifndef " + symbol);
            env.print("#define " + symbol + " 1");
            env.print("");
            env.typeList.remove(classdef.toTypeDefinition());
        } else {
            env.print("#include <sanka_header.h>");
            env.typeList.add(classdef.toTypeDefinition());
        }
        for (TypeDefinition type : env.typeList) {
            String dirName = "";
            if (type.packageName != null) {
                dirName = replaceDot(type.packageName, '/') + "/";
            }
            env.print("#include <" + dirName + type.name + ".h>");
        }
        env.print("");
        copyFileContents(tmpfile, writer);
        if (isHeader) {
            env.print("");
            env.print("#endif");
        }
        writer.close();
        writer = null;
        env.setWriter(null);
        tmpfile.delete();
    }

    static void copyFileContents(File src, BufferedWriter writer) throws IOException {
        int length = (int) src.length();
        char[] contents = new char[length];
        BufferedReader reader = new BufferedReader(new FileReader(src));
        reader.read(contents);
        reader.close();
        writer.write(contents);
    }
}
