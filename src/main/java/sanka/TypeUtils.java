package sanka;

import java.util.ArrayList;
import java.util.List;

import sanka.ExpressionDefinition.ExpressionType;

public class TypeUtils {
    /**
     * Determine if an expression can be promoted to a type.
     *
     * @param type is an empty slot with a well defined type, such as a declared
     * variable, or an object's field, or a method parameter, or a return type.
     *
     * @param expr is the expression to be stored in the slot, such as the RHS of
     * an assignment, or an argument to pass to a method, or a value to return.
     * If expr must be converted or promoted, then modify it as necessary.
     *
     * @return true if the expression's type is equal to the given type (after
     * optional conversion or promotion)
     */
    static boolean isCompatible(TypeDefinition type, ExpressionDefinition expr) {
        return isCompatibleExt(type, expr, false);
    }

    static boolean isCompatibleRO(TypeDefinition type, ExpressionDefinition expr) {
        return isCompatibleExt(type, expr, true);
    }

    private static boolean isCompatibleExt(TypeDefinition type, ExpressionDefinition expr,
                                           boolean isReadOnly) {
        if (expr.type == null) {
            // We've already printed an error. We won't continue to the next pass.
            // Finish this pass.
            return true;
        }
        if (expr.type.isNullType()) {
            // Match null and non-primitive classes and arrays and maps.
            return type.isNullType() || type.nullable;
        }
        boolean match = expr.type.equals(type);
        if (!match && type.nullable && !expr.type.nullable) {
            type.nullable = false;
            match = expr.type.equals(type);
            type.nullable = true;
        }
        if (match) {
            return true;
        }
        if (expr.type.arrayOf != null || type.arrayOf != null) {
            // With arrays and maps, there's no promotion.
            // If the expression is an array of ints, then the parameter must be
            // an array of ints. An array of shorts is not a match.
            // That's why this function is not recursive.
            return false;
        }
        if (expr.type.isNumericType()) {
            return type.isNumericType() && isCompatibleNumeric(type, expr);
        }
        if (expr.type.isPrimitiveType || type.isPrimitiveType) {
            return false;
        }
        if (!type.nullable && expr.type.nullable) {
            return false;
        }
        Environment env = Environment.getInstance();
        ClassDefinition exprClass = env.loadClassDefinition(expr.type);
        ClassDefinition typeClass = env.loadClassDefinition(type);
        if (exprClass == null || typeClass == null) {
            return false;
        }
        // Decide if exprClass implements the interface.
        // Should we keep a cache of what classes have matched interfaces?
        if (typeClass.isInterface && isInterfaceImplemented(typeClass, exprClass)) {
            if (!isReadOnly) {
                ExpressionDefinition copy = expr.copyAndClear();
                expr.expressionType = ExpressionType.NEW_INSTANCE;
                expr.type = type;
                expr.expression1 = copy;
            }
            return true;
        }
        if (typeClass.isAbstract && isSubclassOf(typeClass, exprClass)) {
            if (!isReadOnly) {
                ExpressionDefinition copy = expr.copyAndClear();
                expr.expressionType = ExpressionType.SUPERCLASS;
                expr.type = type;
                expr.expression1 = copy;
            }
            return true;
        }
        return false;
    }

    /**
     * Determine if an expression can be promoted to a numeric type.
     *
     * @return true if the expression can be promoted to the type.
     */
    static boolean isCompatibleNumeric(TypeDefinition type, ExpressionDefinition expr) {
        if (expr.type.equals(TypeDefinition.BYTE_TYPE)) {
            return true;
        }
        if (expr.type.equals(TypeDefinition.SHORT_TYPE)) {
            return !(type.equals(TypeDefinition.BYTE_TYPE));
        }
        if (expr.type.equals(TypeDefinition.INT_TYPE)) {
            if (expr.value != null) {
                if (type.equals(TypeDefinition.BYTE_TYPE) && LiteralUtils.isByte(expr.value)) {
                    expr.type = TypeDefinition.BYTE_TYPE;
                    return true;
                }
                if (type.equals(TypeDefinition.SHORT_TYPE) && LiteralUtils.isShort(expr.value)) {
                    expr.type = TypeDefinition.SHORT_TYPE;
                    return true;
                }
            }
            return !(type.equals(TypeDefinition.BYTE_TYPE) ||
                    type.equals(TypeDefinition.SHORT_TYPE));
        }
        // long, float, and double can be converted to themselves and double.
        return type.equals(expr.type) || type.equals(TypeDefinition.DOUBLE_TYPE);
    }

    /**
     * @return true if the given class implements all the methods in the given interface
     */
    static boolean isInterfaceImplemented(ClassDefinition interfaceDef,
                                          ClassDefinition classDef) {
        List<String> failureList = new ArrayList<>();
        for (MethodDefinition method : interfaceDef.methodList) {
            MethodDefinition implementer = classDef.getMethod(method.name,
                    method.parameters.size());
            if (implementer == null ||
                implementer.isPrivate ||
                !method.sameSignature(implementer)) {
                failureList.add(method.name);
            }
        }
        return failureList.isEmpty();
        /*
        StringBuilder builder = new StringBuilder();
        builder.append("class ");
        builder.append(classDef.name);
        builder.append(" does not implement interface ");
        builder.append(interfaceDef.name);
        builder.append(" methods:");
        for (String name : failureList) {
            builder.append(" ");
            builder.append(name);
        }
        */
    }

    /**
     * @return true if the concrete class inherits the abstract class
     */
    static boolean isSubclassOf(ClassDefinition abstractClass, ClassDefinition concreteClass) {
        if (concreteClass.superclass == null) {
            return false;
        }
        if (concreteClass.superclass == abstractClass) {
            return true;
        }
        return isSubclassOf(abstractClass, concreteClass.superclass);
    }

    public static boolean isInterface(TypeDefinition type) {
        if (type == null) {
            return false;
        }
        Environment env = Environment.getInstance();
        ClassDefinition classdef = env.loadClassDefinition(type);
        return classdef != null && classdef.isInterface;
    }
}
