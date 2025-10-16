package sanka;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import sanka.ClassDefinition.FieldDefinition;
import sanka.MethodDefinition.ParameterDefinition;

public class ClassWriter {
    /**
     * Write a skeleton of a Sanka class so that other Sanka files can import the skeleton
     * to compile-time check that they are using the class correctly.
     */
    public static String write(ClassDefinition classdef) {
        StringBuilder builder = new StringBuilder();
        if (classdef.packageName != null) {
            builder.append("package " + classdef.packageName + ";\n");
        }
        if (classdef.isAbstract) {
            builder.append("abstract ");
        }
        builder.append(classdef.isInterface ? "interface " : "class ");
        builder.append(classdef.name);
        if (classdef.superclass != null) {
            builder.append(" extends " + classdef.superclass.qualifiedName());
        }
        builder.append(" {\n");
        if (classdef.c_repr != null) {
            builder.append("c__repr \"" + classdef.c_repr + "\";\n\n");
        }
        for (FieldDefinition field : classdef.fieldList) {
            if (field.isPrivate) {
                continue;
            }
            if (!field.isConst) {
                if (field.isStatic) {
                    builder.append("static ");
                }
                if (field.isInline) {
                    builder.append("inline ");
                }
                builder.append(field.type.toString() + " " + field.name + ";\n");
            } else {
                builder.append("const " + field.name + " = ");
                builder.append(writeConstantValue(field.value));
                builder.append(";\n");
            }
        }
        for (MethodDefinition method : classdef.methodList) {
            if (method.isPrivate) {
                continue;
            }
            if (classdef.isAbstract && !method.hasBody()) {
                continue;
            }
            if (method.isStatic) {
                builder.append("static ");
            }
            if (!classdef.name.equals(method.name)) {
                builder.append(method.returnType.toString() + " ");
            }
            builder.append(method.name);
            builder.append("(");
            String comma = "";
            for (ParameterDefinition param : method.parameters) {
                builder.append(comma + param.type.toString() + " " + param.name);
                comma = ",";
            }
            builder.append(")");
            builder.append((classdef.isInterface ? ";" : " {}") + "\n");
        }
        builder.append("}\n");
        return builder.toString();
    }

    private static String writeConstantValue(ExpressionDefinition expr) {
        String value = expr.value;
        return expr.type.isStringType() ? "\"" + value + "\"" : value;
    }

    public static void writeFile(ClassDefinition classdef, File file) throws IOException {
        String text = write(classdef);
        FileOutputStream ostream = new FileOutputStream(file);
        ostream.write(text.getBytes());
        ostream.close();
    }
}
