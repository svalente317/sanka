package sanka;

import java.util.ArrayList;

import sanka.ClassDefinition.FieldDefinition;
import sanka.ExpressionDefinition.ExpressionType;
import sanka.MethodDefinition.ParameterDefinition;

/**
 * ArrayUtils supports built-in methods on arrays in both the evaluate pass and the
 * translate pass. For example:
 *
 * var arr = new String[0];
 * arr.add("Hello");
 * arr.add("World");
 *
 * For the evaluate pass, specify that String[] has a method named "add"
 * that takes one parameter of type String.
 *
 * For the translate pass, specify that add() calls the C function
 * GROW_ARRAY() and then it does `arr[arr->length-1] = value`.
 */
public class ArrayUtils {
    /**
     * Generate the ClassDefinition for an array of the given type.
     */
    static ClassDefinition arrayClassDefinition(TypeDefinition elementType) {
        ClassDefinition classdef = new ClassDefinition();
        FieldDefinition field = new FieldDefinition();
        field.name = "length";
        field.type = TypeDefinition.INT_TYPE;
        classdef.fieldList.add(field);

        addMethod(classdef, TypeDefinition.VOID_TYPE, "add", elementType);
        addMethod(classdef, TypeDefinition.VOID_TYPE, "insert",
                  TypeDefinition.INT_TYPE, elementType);
        addMethod(classdef, TypeDefinition.VOID_TYPE, "delete",
                TypeDefinition.INT_TYPE, TypeDefinition.INT_TYPE);
        addMethod(classdef, elementType, "pop");
        addMethod(classdef, elementType, "setLength", TypeDefinition.INT_TYPE);
        TypeDefinition arrayType = new TypeDefinition();
        arrayType.arrayOf = elementType;
        addMethod(classdef, TypeDefinition.VOID_TYPE, "addAll", arrayType);
        return classdef;
    }

    /**
     * Generate the ClassDefinition for a map of the given key type.
     */
    static ClassDefinition mapClassDefinition(TypeDefinition keyType) {
        ClassDefinition classdef = new ClassDefinition();
        addMethod(classdef, TypeDefinition.INT_TYPE, "size");
        addMethod(classdef, TypeDefinition.BOOLEAN_TYPE, "contains", keyType);
        addMethod(classdef, TypeDefinition.BOOLEAN_TYPE, "remove", keyType);
        addMethod(classdef, TypeDefinition.VOID_TYPE, "clear");
        return classdef;
    }

    static void addMethod(ClassDefinition classdef, TypeDefinition returnType,
            String name, TypeDefinition... paramTypes) {
        MethodDefinition method = new MethodDefinition();
        method.returnType = returnType;
        method.name = name;
        method.parameters = new ArrayList<>();
        for (TypeDefinition type : paramTypes) {
            ParameterDefinition parameter = new ParameterDefinition();
            parameter.type = type;
            parameter.name = "arg" + method.parameters.size();
            method.parameters.add(parameter);
        }
        classdef.methodList.add(method);
    }

    /**
     * Generate C code for int[].add(), etc.
     */
    static String translateFunctionCall(ExpressionDefinition expr, String variableName) {
        ExpressionDefinition arrayExpr = expr.expression1.expression1;
        if (arrayExpr.type.keyType != null) {
            return translateMapFunctionCall(expr, variableName);
        }
        String arrayName = arrayExpr.translate(null);
        String typeName = arrayExpr.type.arrayOf.translate();
        String methodName = expr.expression1.name;
        String index, value;
        Environment env = Environment.getInstance();
        switch (methodName) {
        case "add":
            env.print("GROW_ARRAY(" + arrayName + ", sizeof(" + typeName + "));");
            index = arrayName + "->length-1";
            value = expr.argList[0].translate(null);
            env.print("ARRCAST(" + arrayName + ", " + typeName + ")[" + index + "] = " +
                      value + ";");
            return null;
        case "insert":
            index = expr.argList[0].translate(null);
            env.print("GROW_AND_MOVE_ARRAY(" + arrayName + ", " + index +
                      ", sizeof(" + typeName + "));");
            value = expr.argList[1].translate(null);
            env.print("ARRCAST(" + arrayName + ", " + typeName + ")[" + index + "] = " +
                      value + ";");
            return null;
        case "delete":
            env.print("SHRINK_ARRAY(" + arrayName + ", " +
                      expr.argList[0].translate(null) + ", " +
                      expr.argList[1].translate(null) + ", " +
                      "sizeof(" + typeName + "));");
            return null;
        case "pop":
            env.print("BOUNDSCHECK(" + arrayName + ", 0);");
            String text = "";
            if (variableName == null) {
                text = arrayExpr.type.arrayOf.translateSpace();
                variableName = env.getTmpVariable();
            }
            text += variableName + " =  ARRCAST(" + arrayName + ", " + typeName + ")[" +
                    arrayName + "->length-1];";
            env.print(text);
            env.print(arrayName + "->length--;");
            return variableName;
        case "setLength":
            index = expr.argList[0].translate(null);
            env.print("SET_ARRAY_LENGTH(" + arrayName + ", " + index +
                      ", sizeof(" + typeName + "));");
            return null;
        case "addAll":
            value = expr.argList[0].translate(null);
            env.print("ADD_ALL_ARRAY(" + arrayName + ", " + value +
                      ", sizeof(" + typeName + "));");
            return null;
        }
        env.printError(null, "array method not implemented: " + methodName);
        return null;
    }

    static String translateMapFunctionCall(ExpressionDefinition expr, String variableName) {
        ExpressionDefinition arrayExpr = expr.expression1.expression1;
        String arrayName = arrayExpr.translate(null);
        String methodName = expr.expression1.name;
        Environment env = Environment.getInstance();
        String decl = "";
        switch (methodName) {
        case "size":
            env.print("NULLCHECK(" + arrayName + ");");
            if (variableName == null) {
                decl = TypeDefinition.INT_TYPE.translateSpace();
                variableName = env.getTmpVariable();
            }
            env.print(decl + variableName + " =  rb_count(" + arrayName + ");");
            return variableName;
        case "contains":
        case "remove":
            String function = methodName.equals("remove") ? "rb_delete" : "rb_find";
            env.print("NULLCHECK(" + arrayName + ");");
            if (variableName == null) {
                decl = TypeDefinition.BOOLEAN_TYPE.translateSpace();
                variableName = env.getTmpVariable();
            }
            String keyName = expr.argList[0].translate(null);
            if (expr.argList[0].expressionType == ExpressionType.LITERAL) {
                keyName = "(" + TypeDefinition.STRING_TYPE.translate() + ")" + keyName;
            }
            String valueName = env.getTmpVariable();
            env.print("union rb_value " + valueName + ";");
            env.print(decl + variableName + " = " + function + "(" + arrayName +
                      ", (union rb_key) " + keyName + ", &" + valueName + ");");
            return variableName;
        case "clear":
            return null;
        }
        env.printError(null, "map method not implemented: " + methodName);
        return null;
    }
}
