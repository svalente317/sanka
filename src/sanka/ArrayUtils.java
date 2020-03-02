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
}
