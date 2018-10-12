package sanka;

import java.util.ArrayList;

import sanka.ClassDefinition.FieldDefinition;
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
        field.type = TypeDefinition.INT_TYPE;
        classdef.fieldMap.put("length", field);

        addMethod(classdef, TypeDefinition.VOID_TYPE, "add", elementType);
        addMethod(classdef, TypeDefinition.VOID_TYPE, "insert",
                  TypeDefinition.INT_TYPE, elementType);
        addMethod(classdef, elementType, "delete", TypeDefinition.INT_TYPE);
        addMethod(classdef, elementType, "pop");
        addMethod(classdef, elementType, "setLength", TypeDefinition.INT_TYPE);
        TypeDefinition arrayType = new TypeDefinition();
        arrayType.arrayOf = elementType;
        addMethod(classdef, TypeDefinition.VOID_TYPE, "addAll", arrayType);
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
        Environment env = Environment.getInstance();
        ExpressionDefinition arrayExpr = expr.expression1.expression1;
        String arrayName = arrayExpr.translate(null);
        String typeName = arrayExpr.type.arrayOf.translate();
        String methodName = expr.expression1.name;
        String index, value;
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
        case "pop":
            if (methodName.equals("delete")) {
                index = expr.argList[0].translate(null);
            } else {
                index = arrayName + "->length-1";
            }
            env.print("BOUNDSCHECK(" + arrayName + ", " + index + ");");
            String text = "";
            if (variableName == null) {
                text = arrayExpr.type.arrayOf.translateSpace();
                variableName = env.getTmpVariable();
            }
            text += variableName + " =  ARRCAST(" + arrayName + ", " + typeName + ")[" +
                    index + "];";
            env.print(text);
            env.print("SHRINK_ARRAY(" + arrayName + ", " + index + ", sizeof(" + typeName + "));");
            return variableName;
        case "setLength":
            index = expr.argList[0].translate(null);
            env.print("SET_ARRAY_LENGTH(" + arrayName + ", " + index +
                      ", sizeof(" + typeName + ");");
            return null;
        case "addAll":
            // TODO
            break;
        }
        env.printError(null, "array method not implemented: " + methodName);
        return null;
    }
}
