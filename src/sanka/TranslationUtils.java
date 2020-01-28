package sanka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class TranslationUtils {
    static final String INCLUDE_SANKA_HEADER = "#include <sanka_header.h>";

    /**
     * @return the translated C name of a static field.
     */
    static String translateStaticField(String className, String itemName) {
        return className + "__" + itemName;
    }

    /**
     * @return the translated C name of a method or constructor that is definitely not
     *         overloaded, like String.length(), or main(), or an interface constructor.
     */
    static String translateMethodName(String className, String methodName) {
        return translateStaticField(className, methodName);
    }

    /**
     * @return the translated C name of a method or constructor.
     */
    static String translateMethodName(String className, MethodDefinition method) {
        String name = translateMethodName(className, method.name);
        return method.isOverloaded ? name + "__" + method.parameters.size() : name;
    }

    static String getBaseTranslatedName(String name) {
        return name + "__BASE";
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
     * @return the C or H file for a class
     */
    static File getClassFilename(ClassDefinition classdef, boolean isHeader) {
        Environment env = Environment.getInstance();
        String suffix = isHeader ? ".h" : ".c";
        String filename = classdef.name + suffix;
        if (classdef.packageName == null) {
            return env.topDirectory == null ? new File(filename) :
                new File(env.topDirectory, filename);
        }
        String path = replaceDot(classdef.packageName, File.separatorChar);
        File packageDirectory = env.topDirectory == null ? new File(path) :
            new File(env.topDirectory, path);
        packageDirectory.mkdirs();
        return new File(packageDirectory, filename);
    }

    /**
     * Write Class.h and/or Class.c files in the output directory.
     */
    static void translateClass(ClassDefinition classdef, boolean isHeader) throws IOException {
        Environment env = Environment.getInstance();
        File tmpfile = File.createTempFile("sankaclass", "txt");
        env.writer = new BufferedWriter(new FileWriter(tmpfile));
        if (isHeader) {
            classdef.translateHeader();
        } else {
            classdef.translate();
        }
        env.writer.close();
        env.writer = null;

        File destFile = getClassFilename(classdef, isHeader);
        String symbol = classdef.packageName == null ? classdef.name :
                replaceDot(classdef.packageName, '_') + "_" + classdef.name;
        env.writer = new BufferedWriter(new FileWriter(destFile));
        if (classdef.c_includes != null) {
            for (String c_include : classdef.c_includes) {
                env.print("#include <" + c_include + ">");
            }
        }
        if (isHeader) {
            symbol = symbol + "_h_INCLUDED";
            env.print("#ifndef " + symbol);
            env.print("#define " + symbol + " 1");
            classdef.translateForward();
            env.print("");
            env.typeList.remove(classdef.toTypeDefinition());
        } else {
            env.print(INCLUDE_SANKA_HEADER);
            env.typeList.add(classdef.toTypeDefinition());
        }
        for (TypeDefinition type : env.typeList) {
            env.print("#include <" + getHeaderFileName(type.packageName, type.name) + ">");
        }
        env.print("");
        copyFileContents(tmpfile, env.writer);
        if (isHeader) {
            env.print("");
            env.print("#endif");
        }
        env.writer.close();
        env.writer = null;
        tmpfile.delete();
    }

    static String getHeaderFileName(String packageName, String className) {
        String dirName = "";
        if (packageName != null) {
            dirName = replaceDot(packageName, '/') + "/";
        }
        return dirName + className + ".h";
    }

    static void copyFileContents(File src, BufferedWriter writer) throws IOException {
        int length = (int) src.length();
        char[] contents = new char[length];
        BufferedReader reader = new BufferedReader(new FileReader(src));
        reader.read(contents);
        reader.close();
        writer.write(contents);
    }

    /**
     * Hardcode information about "union rb_value" in rb.h. If you change rb.h, then change
     * this too.
     */
    static String typeToMapFieldName(TypeDefinition type) {
        if (!type.isPrimitiveType) {
            return "vp";
        }
        if (type.equals(TypeDefinition.LONG_TYPE)) {
            return "ln";
        }
        if (type.equals(TypeDefinition.DOUBLE_TYPE)) {
            return "d";
        }
        if (type.equals(TypeDefinition.FLOAT_TYPE)) {
            return "f";
        }
        return "i";
    }

    static String typeToMapKeyFieldName(TypeDefinition type) {
        return type.equals(TypeDefinition.STRING_TYPE) ? "cp" : "i";
    }

    /**
     * Generate code that puts a string representation of the given primitive on the stack.
     * The string does not go on the heap because it's part of a string add operation, so
     * it's completely transient.
     * (The result of the string add will be permanent, unlike the pieces of the string add.)
     */
    static String translateToString(ExpressionDefinition expr) {
        Environment env = Environment.getInstance();
        String text = expr.translate(null);
        if (expr.type.equals(TypeDefinition.STRING_TYPE)) {
            return text;
        }
        if (expr.type.equals(TypeDefinition.BOOLEAN_TYPE)) {
            return "(" + text + " ? \"true\" : \"false\")";
        }
        if (expr.type.equals(TypeDefinition.NULL_TYPE)) {
            return "NULL";
        }
        if (expr.type.isNumericType()) {
            String variableName = env.getTmpVariable();
            if (expr.type.equals(TypeDefinition.LONG_TYPE)) {
                env.print("char " + variableName + "[22];");
                env.print("LONG_TO_STRING(" + text + ", " + variableName + ");");
            } else if (expr.type.equals(TypeDefinition.BYTE_TYPE)) {
                env.print("char " + variableName + "[2];");
                env.print(variableName + "[0] = " + text + ";");
                env.print(variableName + "[1] = 0;");
            } else if (expr.type.isIntegralType()) {
                env.print("char " + variableName + "[12];");
                env.print("INT_TO_STRING(" + text + ", " + variableName + ");");
            } else {
                env.print("char " + variableName + "[32];");
                env.print("DOUBLE_TO_STRING(" + text + ", " + variableName + ");");
            }
            return variableName;
        }
        return "not_implemented";
    }
}
