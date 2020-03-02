package sanka.c;

import sanka.ClassDefinition;
import sanka.ClassDefinition.FieldDefinition;
import sanka.Environment;
import sanka.MethodDefinition;
import sanka.MethodDefinition.ParameterDefinition;
import sanka.TypeDefinition;

class MethodTranslator extends TranslationBase {
    /**
     * Write the C code for the given method.
     *
     * Note that if the method is in an abstract class, then we write two C functions.
     * One is an auto-generated entry-point, and the other is the code from the abstract class.
     */
    public static void translate(ClassDefinition classdef, MethodDefinition method, boolean isHeader) {
        translate(classdef, method, isHeader, false);
        if (classdef.isAbstract && method.hasBody()) {
            if (!isHeader) {
                Environment.getInstance().print("");
            }
            translate(classdef, method, isHeader, true);
        }
    }

    private static void translate(ClassDefinition classdef, MethodDefinition method,
            boolean isHeader, boolean isBase) {
        Environment env = Environment.getInstance();
        String name = translateMethodName(classdef.name, method);
        if (isBase) {
            name = getBaseTranslatedName(name);
        }
        StringBuilder builder = new StringBuilder();
        if (method.isPrivate) {
            builder.append("/* private */ ");
        }
        env.addType(method.returnType);
        builder.append(translateTypeSpace(method.returnType));
        builder.append(name);
        builder.append("(");
        boolean needComma = false;
        if (!method.isStatic) {
            builder.append(translateTypeSpace(classdef.toTypeDefinition()) + "this");
            needComma = true;
        }
        addParameters(method, builder, true, needComma);
        builder.append(")");
        if (isHeader) {
            builder.append(";");
            env.print(builder.toString());
            return;
        }
        env.print(builder.toString());
        env.print("{");
        env.level++;
        if (method.exportFrom != null) {
            builder.setLength(0);
            if (!method.returnType.equals(TypeDefinition.VOID_TYPE)) {
                builder.append("return ");
            }
            FieldDefinition fielddef = classdef.getField(method.exportFrom);
            builder.append(translateMethodName(fielddef.type.name, method));
            builder.append("(this->");
            builder.append(method.exportFrom);
            addParameters(method, builder, false, true);
            builder.append(");");
            env.print(builder.toString());
        }
        else if (classdef.isInterface || (classdef.isAbstract && !isBase)) {
            translateInterfaceBody(classdef, method);
        }
        else if (method.block != null) {
            env.symbolTable.push(method.frame);
            translateBlock(method.block, false);
            env.symbolTable.pop();
        }
        else if (method.overrideCount > 0) {
            translateCallSuperclass(classdef, method);
        }
        env.level--;
        env.print("}");
    }

    private static void addParameters(MethodDefinition method, StringBuilder builder,
            boolean withTypes, boolean needComma) {
        Environment env = Environment.getInstance();
        if (method.parameters != null) {
            for (ParameterDefinition param : method.parameters) {
                if (needComma) {
                    builder.append(", ");
                }
                if (withTypes) {
                    env.addType(param.type);
                    builder.append(translateTypeSpace(param.type));
                }
                builder.append(param.name);
                needComma = true;
            }
        }
    }

    /**
     * Write the C code for the field that represents a single method in the structure that
     * represents an Interface.
     *
     * This method needs a better name and better documentation.
     */
    public static void translateInterface(ClassDefinition classdef, MethodDefinition method) {
        Environment env = Environment.getInstance();
        StringBuilder builder = new StringBuilder();
        env.addType(method.returnType);
        builder.append(translateTypeSpace(method.returnType));
        builder.append("(*");
        builder.append(method.name);
        builder.append(")(");
        boolean needComma = false;
        if (!method.isStatic) {
            builder.append("void *object");
            needComma = true;
        }
        addParameters(method, builder, true, needComma);
        builder.append(");");
        env.print(builder.toString());
    }

    /**
     * Write the C function that gets called when Sanka code calls "x.method()" where x is a
     * variable of an interface type.
     */
    private static void translateInterfaceBody(ClassDefinition classdef, MethodDefinition method) {
        Environment env = Environment.getInstance();
        StringBuilder builder = new StringBuilder();
        if (!method.returnType.isVoidType()) {
            builder.append("return ");
        }
        builder.append("this->" + supers(method.overrideCount));
        builder.append(method.name);
        builder.append("(");
        boolean needComma = false;
        if (!method.isStatic) {
            String supers = supers(classdef.depth());
            builder.append("this->" + supers + "object");
            needComma = true;
        }
        addParameters(method, builder, false, needComma);
        builder.append(");");
        env.print(builder.toString());
    }

    /**
     * Given that [class].[method] is not explicitly defined, write the C function that represents
     * this method and calls the appropriate superclass method.
     */
    private static void translateCallSuperclass(ClassDefinition classdef, MethodDefinition method) {
        Environment env = Environment.getInstance();
        ClassDefinition candidate = classdef.superclass;
        MethodDefinition superMethod = null;
        int superCount = 1;
        while (candidate != null) {
            superMethod = candidate.getMethod(method.name, method.parameters.size());
            if (superMethod == null || superMethod.hasBody()) {
                break;
            }
            candidate = candidate.superclass;
            superCount++;
        }
        if (superMethod == null) {
            env.printError(null, "class " + classdef.name + " concrete method " +
                    method.name + " not found");
            return;
        }
        StringBuilder builder = new StringBuilder();
        if (!method.returnType.isVoidType()) {
            builder.append("return ");
        }
        String name = translateMethodName(candidate.name, method);
        builder.append(getBaseTranslatedName(name));
        builder.append("(&this->" + ClassDefinition.SUPER_FIELD_NAME);
        for (int idx = 1; idx < superCount; idx++) {
            builder.append("." + ClassDefinition.SUPER_FIELD_NAME);
        }
        addParameters(method, builder, false, true);
        builder.append(");");
        env.print(builder.toString());
    }
}
