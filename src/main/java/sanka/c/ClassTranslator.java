package sanka.c;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import sanka.ClassDefinition;
import sanka.ClassDefinition.FieldDefinition;
import sanka.Environment;
import sanka.MethodDefinition;
import sanka.StringUtils;
import sanka.TypeDefinition;

/**
 * Treat ClassDefinition and the objects it contains -- MethodDefinition, StatementDefinition,
 * ExpressionDefinition, etc. -- as POJOs. They are raw data that represent a Sanka class.
 * Translate the raw data to a C source files.
 */
public class ClassTranslator extends TranslationBase {
    static final String INCLUDE_SANKA_HEADER = "#include <sanka_header.h>";
    static final String SUPER_FIELD_NAME = "super";
    static final String AT_THIS_FIELD_NAME = "_at_this";

    /**
     * Write Class.h and Class.c files in the output directory.
     */
    public static void translate(ClassDefinition classdef) throws IOException {
        translate(classdef, true);
        translate(classdef, false);
    }

    private static void translate(ClassDefinition classdef, boolean isHeader) throws IOException {
        // Translate the class before writing the #include lines, because translating
        // the class modifies env.referencedTypes.
        Environment env = Environment.getInstance();
        env.writer = new StringWriter();
        if (isHeader) {
            translateHeader(classdef);
        } else {
            translateClass(classdef);
        }
        env.writer.close();
        String contents = env.writer.toString();
        env.writer = null;

        File destFile = getClassFilename(classdef, isHeader);
        String symbol = classdef.packageName == null ? classdef.name :
                StringUtils.replaceDot(classdef.packageName, '_') + "_" + classdef.name;
        env.writer = new BufferedWriter(new FileWriter(destFile));
        if (isHeader) {
            symbol = symbol + "_h_INCLUDED";
            env.print("#ifndef " + symbol);
            env.print("#define " + symbol + " 1");
            translateForward(classdef);
            env.print("");
            env.referencedTypes.remove(classdef.toTypeDefinition());
        } else {
            env.print(INCLUDE_SANKA_HEADER);
            env.referencedTypes.add(classdef.toTypeDefinition());
        }
        if (classdef.c_includes != null) {
            for (String c_include : classdef.c_includes) {
                env.print("#include <" + c_include + ">");
            }
        }
        for (TypeDefinition type : env.referencedTypes) {
            env.print("#include <" + getHeaderFileName(type.packageName, type.name) + ">");
        }
        env.print("");
        env.writer.write(contents);
        if (isHeader) {
            env.print("");
            env.print("#endif");
        }
        env.writer.close();
        env.writer = null;
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
        String path = StringUtils.replaceDot(classdef.packageName, File.separatorChar);
        File packageDirectory = env.topDirectory == null ? new File(path) :
            new File(env.topDirectory, path);
        packageDirectory.mkdirs();
        return new File(packageDirectory, filename);
    }

    static String getHeaderFileName(String packageName, String className) {
        String dirName = "";
        if (packageName != null) {
            dirName = StringUtils.replaceDot(packageName, '/') + "/";
        }
        return dirName + className + ".h";
    }

    static String getSankaImportFileName(ClassDefinition classdef) {
        String dirName = "";
        if (classdef.packageName != null) {
            dirName = StringUtils.replaceDot(classdef.packageName, '/') + "/";
        }
        return dirName + classdef.name + ".san";
    }

    /**
     * Translate ClassDefinition object data to a C header file.
     */
    private static void translateHeader(ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        env.referencedTypes.clear();
        translateClassRep(classdef);
        for (FieldDefinition field : classdef.fieldList) {
            if (field.isStatic) {
                StringBuilder builder = new StringBuilder();
                builder.append("extern ");
                if (field.isConst && !field.type.isStringType()) {
                    builder.append("const ");
                }
                env.addType(field.type);
                builder.append(translateTypeSpace(field.type));
                builder.append(translateStaticField(classdef.name, field.name));
                builder.append(";");
                env.print(builder.toString());
            }
        }
        for (MethodDefinition method : classdef.methodList) {
            MethodTranslator.translate(classdef, method, true);
        }
    }

    private static void translateClassRep(ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        TypeDefinition superType = null;
        if (classdef.superclass != null) {
            superType = classdef.superclass.toTypeDefinition();
            env.addType(superType);
        }
        if (classdef.c_repr != null) {
            return;
        }
        env.print("struct " + classdef.name + " {");
        env.level++;
        if (superType != null) {
            env.print(translateTypeDeref(superType) + " " + SUPER_FIELD_NAME + ";");
        }
        if (classdef.isAbstract) {
            if (classdef.superclass == null) {
                env.print("void *object;");
            }
            for (MethodDefinition method : classdef.methodList) {
                if (method.canOverride() && method.overrideCount == 0) {
                    MethodTranslator.translateInterface(classdef, method);
                }
            }
        }
        else if (classdef.isInterface) {
            env.print("void *object;");
            env.print("void *base;");
            env.print("const char *baseType;");
            for (MethodDefinition method : classdef.methodList) {
                if (!(method.isPrivate || method.isStatic)) {
                    MethodTranslator.translateInterface(classdef, method);
                }
            }
        }
        for (FieldDefinition field : classdef.fieldList) {
            if (field.isStatic) {
                continue;
            }
            env.addType(field.type);
            env.print(translateTypeSpace(field.type) + field.name + ";");
        }
        if (classdef.atThisType != null) {
            env.print(translateTypeSpace(classdef.atThisType) + AT_THIS_FIELD_NAME + ";");
        }
        if (classdef.c_fields != null) {
            for (String cfield : classdef.c_fields) {
                env.print(cfield + ";");
            }
        }
        env.level--;
        env.print("};");
        env.print("");
    }

    private static void translateForward(ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        env.print("struct " + classdef.name + ";");
    }

    /**
     * Translate ClassDefinition object data to a C source file.
     */
    private static void translateClass(ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        env.referencedTypes.clear();
        boolean printedSomething = false;
        for (FieldDefinition field: classdef.fieldList) {
            if (field.isStatic) {
                StringBuilder builder = new StringBuilder();
                if (field.isConst && !field.type.isStringType()) {
                    builder.append("const ");
                }
                env.addType(field.type);
                builder.append(translateTypeSpace(field.type));
                builder.append(translateStaticField(classdef.name, field.name));
                builder.append(" = ");
                builder.append(field.value == null ? "0" : translateExpression(field.value));
                builder.append(";");
                env.print(builder.toString());
                printedSomething = true;
            }
        }
        if (classdef.isSingleton) {
            String name = translateStaticField(classdef.name, "MUTEX");
            env.print("static pthread_mutex_t " + name + " = PTHREAD_MUTEX_INITIALIZER;");
            printedSomething = true;
        }
        if (classdef.c_stmts != null) {
            for (String stmt : classdef.c_stmts) {
                env.print(stmt);
                printedSomething = true;
            }
        }
        for (MethodDefinition method : classdef.methodList) {
            if (printedSomething) {
                env.print("");
            }
            MethodTranslator.translate(classdef, method, false);
            printedSomething = true;
        }
    }
}
