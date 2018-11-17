package sanka;

import java.util.ArrayList;
import java.util.List;

import sanka.ExpressionDefinition.ExpressionType;
import sanka.MethodDefinition.ParameterDefinition;

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

    static boolean isCompatibleExt(TypeDefinition type, ExpressionDefinition expr,
                                   boolean isReadOnly) {
        if (expr.type == null) {
            // We've already printed an error. We won't continue to the next pass.
            // Finish this pass.
            return true;
        }
        if (expr.type.isNullType()) {
            // Match null and non-primitive classes and arrays and maps.
            return type.isNullType() || !type.isPrimitiveType;
        }
        if (expr.type.equals(type)) {
            return true;
        }
        if (expr.type.arrayOf != null) {
            // With arrays and maps, there's no promotion.
            // If the expression is an array of ints, then the parameter must be
            // an array of ints. An array of shorts is not a match.
            // That's why this function is not recursive.
            return false;
        }
        if (expr.type.isNumericType()) {
            return type.isNumericType() && isCompatibleNumeric(type, expr);
        }
        if (expr.type.isPrimitiveType) {
            return false;
        }
        Environment env = Environment.getInstance();
        ClassDefinition exprClass = env.getClassDefinition(expr.type);
        ClassDefinition typeClass = env.getClassDefinition(type);
        if (typeClass == null) {
            ImportManager.getInstance().doImport(null, type.packageName, type.name);
            typeClass = env.getClassDefinition(type);
        }
        if (exprClass == null || typeClass == null || !typeClass.isInterface) {
            return false;
        }
        // Decide if exprClass implements the interface.
        // Should we keep a cache of what classes have matched interfaces?
        if (!isInterfaceImplemented(typeClass, exprClass)) {
            return false;
        }
        if (!isReadOnly) {
            ExpressionDefinition copy = expr.copyAndClear();
            expr.expressionType = ExpressionType.NEW_INSTANCE;
            expr.type = type;
            expr.expression1 = copy;
        }
        return true;
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
            if (expr.expressionType == ExpressionType.LITERAL) {
                if (type.equals(TypeDefinition.BYTE_TYPE) && LiteralUtils.isByte(expr.name)) {
                    expr.type = TypeDefinition.BYTE_TYPE;
                    return true;
                }
                if (type.equals(TypeDefinition.SHORT_TYPE) && LiteralUtils.isShort(expr.name)) {
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
            MethodDefinition implementer = classDef.getMethod(method.name);
            if (implementer == null ||
                implementer.isPrivate ||
                implementer.isStatic != method.isStatic ||
                !sameParameterList(method.parameters, implementer.parameters)) {
                failureList.add(method.name);
            }
        }
        if (failureList.isEmpty()) {
            return true;
        }
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
        Environment env = Environment.getInstance();
        env.printError(null, builder.toString());
        return false;
    }

    static boolean sameParameterList(List<ParameterDefinition> mp,
                                     List<ParameterDefinition> ip) {
        if (mp.size() != ip.size()) {
            return false;
        }
        for (int idx = 0; idx < mp.size(); idx++) {
            ParameterDefinition p1 = mp.get(idx);
            ParameterDefinition p2 = ip.get(idx);
            if (!p1.type.equals(p2.type)) {
                return false;
            }
        }
        return true;
    }
}
