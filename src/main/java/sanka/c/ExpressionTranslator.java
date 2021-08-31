package sanka.c;

import java.util.ArrayList;
import java.util.List;

import sanka.ClassDefinition;
import sanka.Environment;
import sanka.ExpressionDefinition;
import sanka.ExpressionDefinition.ExpressionType;
import sanka.MethodDefinition;
import sanka.TypeDefinition;
import sanka.TypeUtils;

class ExpressionTranslator extends TranslationBase {
    /**
     * Write any C statements necessary to setup the expression. Then, return a string of C code
     * that evaluates to the expression, given the setup.
     * Generate the C string such that it can be evaluated multiple times without side effects.
     *
     * variableName is an optional C variable which has been declared to the correct type.
     * It can be used to store the evaluated expression if necessary.
     */
    static String translate(ExpressionDefinition expr, String variableName) {
        switch (expr.expressionType) {
        case LITERAL:
            return translateLiteral(expr);
        case IDENTIFIER:
            return expr.name;
        case CLASS_IDENTIFIER:
            return expr.name;
        case NEW_INSTANCE:
            return translateNewInstance(expr, variableName);
        case NEW_ARRAY_WITH_VALUES:
            return translateNewArrayWithValues(expr, variableName);
        case NEW_ARRAY:
            return translateNewArray(expr, variableName);
        case NEW_MAP:
            return translateNewMap(expr, variableName);
        case UNARY:
            return translateUnary(expr);
        case FIELD_ACCESS:
            return translateFieldAccess(expr);
        case BINARY:
            return translateBinary(expr, variableName);
        case ARRAY_ACCESS:
            return translateArrayAccess(expr, variableName);
        case FUNCTION_CALL:
            return translateFunctionCall(expr, variableName);
        case TERNARY:
            return translateTernary(expr, variableName);
        case SUPERCLASS:
            return translateSuperclass(expr);
        case SUPER_DOT_METHOD:
            return translateSuperDotMethod(expr);
        case TYPE_CAST:
            return translateTypeCast(expr, variableName);
        }
        return null;
    }

    static String translate(ExpressionDefinition expr) {
        return translate(expr, null);
    }

    static String translateLiteral(ExpressionDefinition expr) {
        if (expr.type == TypeDefinition.BYTE_TYPE) {
            return expr.value;
        }
        if (expr.type == TypeDefinition.SHORT_TYPE ||
            expr.type == TypeDefinition.INT_TYPE) {
            return expr.value;
        }
        if (expr.type == TypeDefinition.LONG_TYPE) {
            return "(long)" + expr.value;
        }
        if (expr.type == TypeDefinition.DOUBLE_TYPE) {
            return expr.value;
        }
        if (expr.type == TypeDefinition.BOOLEAN_TYPE) {
            return expr.value.equals("true") ? "1" : (expr.value.equals("false") ? "0" : "error");
        }
        if (expr.type == TypeDefinition.STRING_TYPE) {
            return "\"" + expr.value + "\"";
        }
        if (expr.type == TypeDefinition.NULL_TYPE) {
            return "NULL";
        }
        return "error";
    }

    static String translateNewInstance(ExpressionDefinition expr, String variableName) {
        Environment env = Environment.getInstance();
        env.addType(expr.type);
        StringBuilder builder = new StringBuilder();
        if (variableName == null) {
            builder.append(translateTypeSpace(expr.type));
            variableName = env.getTmpVariable();
        }
        builder.append(variableName);
        if (expr.type.isStringType()) {
            finishTranslateNewString(expr, builder);
            return variableName;
        }
        builder.append(" = GC_MALLOC(sizeof(");
        builder.append(translateTypeDeref(expr.type));
        builder.append("));");
        env.print(builder.toString());
        ClassDefinition classdef = getClassDefinition(expr.type);
        int numArgs = expr.argList == null ? 0 : expr.argList.length;
        MethodDefinition constructor = classdef.getMethod(classdef.name, numArgs);
        translateSuperclasses(classdef, variableName);
        if (constructor != null) {
            builder = new StringBuilder();
            builder.append(translateMethodName(classdef.name, constructor));
            builder.append("(");
            builder.append(variableName);
            if (expr.argList != null) {
               for (ExpressionDefinition arg : expr.argList) {
                   builder.append(", ");
                   builder.append(translate(arg));
               }
            }
            builder.append(");");
            env.print(builder.toString());
        }
        if (classdef.isInterface) {
            ClassDefinition baseClass = getClassDefinition(expr.expression1.type);
            String baseExpr = translate(expr.expression1);
            env.print(variableName + "->object = " + baseExpr + ";");
            String text = baseClass.isInterface ? baseExpr + "->base" : variableName + "->object";
            env.print(variableName + "->base = " + text + ";");
            text = baseClass.isInterface ? baseExpr + "->baseType" :
                "\"" + expr.expression1.type.toString() + "\"";
            env.print(variableName + "->baseType = " + text + ";");
            String typeName = expr.expression1.type.name;
            for (MethodDefinition method : classdef.methodList) {
                builder = new StringBuilder();
                builder.append(variableName);
                builder.append("->" + method.name + " = (void *) ");
                builder.append(translateMethodName(typeName, method));
                builder.append(";");
                env.print(builder.toString());
            }
        }
        if (expr.fieldList != null) {
            for (int idx = 0; idx < expr.fieldList.length; idx++) {
                String value = translate(expr.argList[idx]);
                env.print(variableName + "->" + expr.fieldList[idx] + " = " + value + ";");
            }
        }
        return variableName;
    }

    static void finishTranslateNewString(ExpressionDefinition expr, StringBuilder builder) {
        Environment env = Environment.getInstance();
        builder.append(" = NEW_STRING(");
        if (expr.argList != null) {
            String comma = "";
            for (ExpressionDefinition arg : expr.argList) {
                builder.append(comma);
                builder.append(translate(arg));
                comma = ", ";
            }
        }
        builder.append(");");
        env.print(builder.toString());
    }

    static void translateSuperclasses(ClassDefinition classdef, String variableName) {
        if (classdef.superclass == null) {
            return;
        }
        Environment env = Environment.getInstance();
        String prefix = variableName + "->";
        env.print(prefix + supers(classdef.depth()) + "object = " + variableName + ";");
        for (MethodDefinition method : classdef.methodList) {
            if (method.isPrivate || method.isStatic || method.overrideCount == 0) {
                continue;
            }
            String lhs = prefix + supers(method.overrideCount) + method.name;
            String cName = translateMethodName(classdef.name, method);
            env.print(lhs + " = (void *) " + cName + ";");
        }
    }

    static String translateNewArrayWithValues(ExpressionDefinition expr, String variableName) {
        Environment env = Environment.getInstance();
        String count = Integer.toString(expr.argList.length);
        variableName = translateNewArrayWithCount(expr, variableName, count);
        for (int idx = 0; idx < expr.argList.length; idx++) {
            // Promote RHS numeric type / interface type?
            env.print("ARRCAST(" + variableName + ", " + translateType(expr.type.arrayOf) +
                      ")[" + idx + "] = " + translate(expr.argList[idx], null) + ";");
        }
        return variableName;
    }

    static String translateNewArray(ExpressionDefinition expr, String variableName) {
        return translateNewArrayWithCount(expr, variableName, translate(expr.expression1));
    }

    static String translateNewArrayWithCount(ExpressionDefinition expr, String variableName,
            String count) {
        Environment env = Environment.getInstance();
        StringBuilder builder = new StringBuilder();
        if (variableName == null) {
            builder.append(translateTypeSpace(expr.type));
            variableName = env.getTmpVariable();
        }
        builder.append(variableName);
        builder.append(" = NEW_ARRAY(");
        builder.append(count);
        builder.append(", sizeof(");
        builder.append(translateType(expr.type.arrayOf));
        builder.append("));");
        env.print(builder.toString());
        return variableName;
    }

    static String translateNewMap(ExpressionDefinition expr, String variableName) {
        Environment env = Environment.getInstance();
        StringBuilder builder = new StringBuilder();
        if (variableName == null) {
            builder.append(translateTypeSpace(expr.type));
            variableName = env.getTmpVariable();
        }
        builder.append(variableName);
        builder.append(" = rb_create(");
        builder.append(expr.type.keyType.isStringType() ? "1" : "0");
        builder.append(");");
        env.print(builder.toString());
        if (expr.argList != null) {
            String valueName = null;
            for (ExpressionDefinition arg : expr.argList) {
                valueName = StatementTranslator.translateMapAssignment(
                        variableName, arg.expression1, arg.expression2, valueName);
            }
        }
        return variableName;
    }

    static String translateUnary(ExpressionDefinition expr) {
        return expr.operator + translate(expr.expression1);
    }

    static String translateFieldAccess(ExpressionDefinition expr) {
        Environment env = Environment.getInstance();
        boolean isClassAccess = expr.expression1.expressionType == ExpressionType.CLASS_IDENTIFIER;
        String text = null;
        if (isClassAccess) {
            env.addType(expr.expression1.identifiedClass);
        } else {
            text = translate(expr.expression1);
            if (!text.equals("this")) {
                env.print("NULLCHECK(" + text + ");");
            }
        }
        if (expr.isStatic || expr.type == TypeDefinition.METHOD_TYPE) {
            expr.translatedThis = text;
            if (expr.expression1.type.arrayOf != null) {
                return null;
            }
            String className = isClassAccess ? expr.expression1.identifiedClass.name :
                expr.expression1.type.name;
            if (expr.method == null) {
                return translateStaticField(className, expr.name);
            }
            return translateMethodName(className, expr.method);
        }
        return text + "->" + expr.name;
    }

    static String translateBinary(ExpressionDefinition expr, String variableName) {
        Environment env = Environment.getInstance();
        if (expr.operator.equals("&&") || expr.operator.equals("||")) {
            StringBuilder builder = new StringBuilder();
            if (variableName == null) {
                builder.append(translateTypeSpace(expr.type));
                variableName = env.getTmpVariable();
            }
            builder.append(variableName);
            builder.append(" = ");
            builder.append(translate(expr.expression1));
            builder.append(";");
            env.print(builder.toString());
            builder.setLength(0);
            builder.append("if (");
            if (expr.operator.equals("||")) {
                builder.append("!");
            }
            builder.append(variableName);
            builder.append(") {");
            env.print(builder.toString());
            env.level++;
            String text = translate(expr.expression2, variableName);
            setTextToVariable(text, variableName);
            env.level--;
            env.print("}");
            return variableName;
        }
        if (expr.operator.equals("+") && expr.type.isStringType()) {
            return translateStringAdd(expr, variableName);
        }
        String text1 = translate(expr.expression1);
        String text2 = translate(expr.expression2);
        if (expr.operator.equals("==") || expr.operator.equals("!=")) {
            if (TypeUtils.isInterface(expr.expression1.type)) {
                text1 = translateInterfaceForComparison(text1);
            }
            if (TypeUtils.isInterface(expr.expression2.type)) {
                text2 = translateInterfaceForComparison(text2);
            }
            // If either expression type is an abstract class, then add "->object"
            // or "->super.object". Or at least a cast to the common type.
        }
        if (expr.expression1.type.isStringType()) {
            String translation = translateStringComparison(expr, text1, text2, expr.operator);
            if (translation != null) {
                return translation;
            }
        }
        if (expr.operator.equals("/")) {
            env.print("DIVISIONCHECK(" + text2 + ");");
        }
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        builder.append(text1);
        builder.append(" ");
        builder.append(expr.operator);
        builder.append(" ");
        builder.append(text2);
        builder.append(")");
        return builder.toString();
    }

    static String translateInterfaceForComparison(String text) {
        Environment env = Environment.getInstance();
        String variableName = env.getTmpVariable();
        env.print("void *" + variableName + " = " +
                text + " != NULL ? " + text + "->base : NULL;");
        return variableName;
    }

    static String translateStringComparison(ExpressionDefinition expr, String text1, String text2,
            String operator) {
        if (operator.equals("==")) {
            return "STRING_EQUALS(" + text1 + ", " + text2 + ")";
        }
        if (operator.equals("!=")) {
            return "(!STRING_EQUALS(" + text1 + ", " + text2 + "))";
        }
        if (operator.equals("<") || operator.equals("<=") ||
            operator.equals(">") || operator.equals(">=")) {
            Environment env = Environment.getInstance();
            env.print("NULLCHECK(" + text1 + ");");
            env.print("NULLCHECK(" + text2 + ");");
            return "(strcmp(" + text1 + ", " + text2 + ") " + operator + " 0)";
        }
        return null;
    }

    static void setTextToVariable(String text, String variableName) {
        Environment env = Environment.getInstance();
        if (!text.equals(variableName)) {
            StringBuilder builder = new StringBuilder();
            builder.append(variableName);
            builder.append(" = ");
            builder.append(text);
            builder.append(";");
            env.print(builder.toString());
        }
    }

    static String translateArrayAccess(ExpressionDefinition expr, String variableName) {
        Environment env = Environment.getInstance();
        String text1 = translate(expr.expression1);
        String text2 = translate(expr.expression2);
        if (expr.expression1.type.isStringType()) {
            env.print("NULLCHECK(" + text1 + ");");
            return text1 + "[" + text2 + "]";
        }
        if (expr.expression1.type.keyType == null) {
            env.print("BOUNDSCHECK(" + text1 + ", " + text2 + ");");
            return "ARRCAST(" + text1 + ", " + translateType(expr.type) + ")[" + text2 + "]";
        }
        env.print("NULLCHECK(" + text1 + ");");
        if (expr.expression1.type.keyType.isStringType()) {
            if (expr.expression2.expressionType == ExpressionType.LITERAL) {
                text2 = "(" + translateType(TypeDefinition.STRING_TYPE) + ")" + text2;
            } else {
                env.print("NULLCHECK(" + text2 + ");");
            }
        }
        if (variableName == null) {
            variableName = env.getTmpVariable();
            env.print(translateTypeSpace(expr.type) + variableName + ";");
        }
        String valueName = env.getTmpVariable();
        env.print("union rb_value " + valueName + ";");
        String valueField = valueName + "." + typeToMapFieldName(expr.type);
        env.print(valueField + " = 0;");
        env.print("rb_find(" + text1 + ", (union rb_key) " + text2 + ", &" + valueName + ");");
        env.print(variableName + " = " + valueField + ";");
        return variableName;
    }

    static String translateFunctionCall(ExpressionDefinition expr, String variableName) {
        if (expr.expression1.expressionType == ExpressionType.FIELD_ACCESS &&
            expr.expression1.expression1.type.arrayOf != null) {
            return translateArrayFunctionCall(expr, variableName);
        }
        Environment env = Environment.getInstance();
        StringBuilder builder = new StringBuilder();
        if (!expr.type.isVoidType()) {
            if (variableName == null) {
                builder.append(translateTypeSpace(expr.type));
                variableName = env.getTmpVariable();
            }
            builder.append(variableName);
            builder.append(" = ");
        }
        builder.append(translate(expr.expression1));
        builder.append("(");
        boolean needComma = false;
        if (!expr.expression1.method.isStatic) {
            builder.append(expr.expression1.translatedThis);
            needComma = true;
        }
        for (ExpressionDefinition arg : expr.argList) {
            if (needComma) {
                builder.append(", ");
            }
            builder.append(translate(arg));
            needComma = true;
        }
        builder.append(");");
        env.print(builder.toString());
        return variableName;
    }

    /**
     * Generate C code for int[].add(), etc.
     */
    static String translateArrayFunctionCall(ExpressionDefinition expr, String variableName) {
        ExpressionDefinition arrayExpr = expr.expression1.expression1;
        if (arrayExpr.type.keyType != null) {
            return translateMapFunctionCall(expr, variableName);
        }
        String arrayName = translate(arrayExpr);
        String typeName = translateType(arrayExpr.type.arrayOf);
        String methodName = expr.expression1.name;
        String index, value;
        Environment env = Environment.getInstance();
        switch (methodName) {
        case "add":
            env.print("GROW_ARRAY(" + arrayName + ", sizeof(" + typeName + "));");
            index = arrayName + "->length-1";
            value = translate(expr.argList[0]);
            env.print("ARRCAST(" + arrayName + ", " + typeName + ")[" + index + "] = " +
                      value + ";");
            return null;
        case "insert":
            index = translate(expr.argList[0]);
            env.print("GROW_AND_MOVE_ARRAY(" + arrayName + ", " + index +
                      ", sizeof(" + typeName + "));");
            value = translate(expr.argList[1]);
            env.print("ARRCAST(" + arrayName + ", " + typeName + ")[" + index + "] = " +
                      value + ";");
            return null;
        case "delete":
            env.print("SHRINK_ARRAY(" + arrayName + ", " +
                      translate(expr.argList[0]) + ", " +
                      translate(expr.argList[1]) + ", " +
                      "sizeof(" + typeName + "));");
            return null;
        case "pop":
            env.print("BOUNDSCHECK(" + arrayName + ", 0);");
            String text = "";
            if (variableName == null) {
                text = translateTypeSpace(arrayExpr.type.arrayOf);
                variableName = env.getTmpVariable();
            }
            text += variableName + " =  ARRCAST(" + arrayName + ", " + typeName + ")[" +
                    arrayName + "->length-1];";
            env.print(text);
            env.print(arrayName + "->length--;");
            return variableName;
        case "setLength":
            index = translate(expr.argList[0]);
            env.print("SET_ARRAY_LENGTH(" + arrayName + ", " + index +
                      ", sizeof(" + typeName + "));");
            return null;
        case "addAll":
            value = translate(expr.argList[0]);
            env.print("ADD_ALL_ARRAY(" + arrayName + ", " + value +
                      ", sizeof(" + typeName + "));");
            return null;
        }
        env.printError(null, "array method not implemented: " + methodName);
        return null;
    }

    static String translateMapFunctionCall(ExpressionDefinition expr, String variableName) {
        ExpressionDefinition arrayExpr = expr.expression1.expression1;
        String arrayName = translate(arrayExpr);
        String methodName = expr.expression1.name;
        Environment env = Environment.getInstance();
        String decl = "";
        switch (methodName) {
        case "size":
            env.print("NULLCHECK(" + arrayName + ");");
            if (variableName == null) {
                decl = translateTypeSpace(TypeDefinition.INT_TYPE);
                variableName = env.getTmpVariable();
            }
            env.print(decl + variableName + " =  rb_count(" + arrayName + ");");
            return variableName;
        case "contains":
        case "remove":
            String function = methodName.equals("remove") ? "rb_delete" : "rb_find";
            env.print("NULLCHECK(" + arrayName + ");");
            if (variableName == null) {
                decl = translateTypeSpace(TypeDefinition.BOOLEAN_TYPE);
                variableName = env.getTmpVariable();
            }
            String keyName = translate(expr.argList[0]);
            if (expr.argList[0].expressionType == ExpressionType.LITERAL) {
                keyName = "(" + translateType(TypeDefinition.STRING_TYPE) + ")" + keyName;
            }
            String valueName = env.getTmpVariable();
            env.print("union rb_value " + valueName + ";");
            env.print(decl + variableName + " = " + function + "(" + arrayName +
                      ", (union rb_key) " + keyName + ", &" + valueName + ");");
            return variableName;
        case "clear":
            env.print("NULLCHECK(" + arrayName + ");");
            env.print("rb_clear(" + arrayName + ");");
            return variableName;
        }
        env.printError(null, "map method not implemented: " + methodName);
        return null;
    }


    static String translateTernary(ExpressionDefinition expr, String variableName) {
        Environment env = Environment.getInstance();
        String text;
        StringBuilder builder = new StringBuilder();
        if (variableName == null) {
            variableName = env.getTmpVariable();
            builder.append(translateTypeSpace(expr.type));
            builder.append(variableName);
            builder.append(";");
            env.print(builder.toString());
        }
        builder.setLength(0);
        builder.append("if (");
        builder.append(translate(expr.expression1));
        builder.append(") {");
        env.print(builder.toString());
        env.level++;
        text = translate(expr.argList[0], variableName);
        setTextToVariable(text, variableName);
        env.level--;
        env.print("} else {");
        env.level++;
        text = translate(expr.argList[1], variableName);
        setTextToVariable(text, variableName);
        env.level--;
        env.print("}");
        return variableName;
    }

    /**
     * Recursively build the list of expressions being added.
     */
    static void
    addLeftAndRightToList(List<ExpressionDefinition> exprList, ExpressionDefinition expr) {
        if (expr.expressionType == ExpressionType.BINARY && expr.operator.equals("+") &&
                expr.type.isStringType()) {
            addLeftAndRightToList(exprList, expr.expression1);
            addLeftAndRightToList(exprList, expr.expression2);
        } else {
            exprList.add(expr);
        }
    }

    static String translateStringAdd(ExpressionDefinition expr, String variableName) {
        Environment env = Environment.getInstance();
        List<ExpressionDefinition> exprList = new ArrayList<>();
        addLeftAndRightToList(exprList, expr);
        String arrayName = env.getTmpVariable();
        env.print("const char *" + arrayName + "[" + exprList.size() + "];");
        for (int idx = 0; idx < exprList.size(); idx++) {
            String text = translateToString(exprList.get(idx));
            env.print(arrayName + "[" + idx + "]" + " = " + text + ";");
        }
        StringBuilder builder = new StringBuilder();
        if (variableName == null) {
            builder.append(translateTypeSpace(expr.type));
            variableName = env.getTmpVariable();
        }
        builder.append(variableName);
        builder.append(" = STRING_ADD(");
        builder.append(arrayName);
        builder.append(", " + exprList.size());
        builder.append(");");
        env.print(builder.toString());
        return variableName;
    }

    /**
     * Generate code that puts a string representation of the given primitive on the stack.
     * The string does not go on the heap because it's part of a string add operation, so
     * it's completely transient.
     * (The result of the string add will be permanent, unlike the pieces of the string add.)
     */
    static String translateToString(ExpressionDefinition expr) {
        Environment env = Environment.getInstance();
        String text = translate(expr);
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

    static String translateSuperclass(ExpressionDefinition expr) {
        String text = translate(expr.expression1);
        // Technically, the correct expression is "&expr.super.super.super..."
        // That is: Walk up the correct number of superclass levels, and take a pointer.
        // However, because C is close to machine language, and we control the layout of
        // C structures in memory, we know that each ".super" moves the pointer zero bytes,
        // so we simply cast the pointer.
        return "((" + translateType(expr.type) + ")" + text + ")";
    }

    static String translateSuperDotMethod(ExpressionDefinition expr) {
        String className = expr.expression1.type.name;
        // Technically, the correct expression is "&this->super.super.super..."
        // But this works. See translateSuperclass().
        expr.translatedThis = "this"; // TODO add cast
        String name = translateMethodName(className, expr.method);
        return getBaseTranslatedName(name);
    }

    static String translateTypeCast(ExpressionDefinition expr, String variableName) {
        Environment env = Environment.getInstance();
        String text = translate(expr.expression1);
        if (expr.type.isNumericType()) {
            return "((" + translateType(expr.type) + ")" + text + ")";
        }
        StringBuilder builder = new StringBuilder();
        if (variableName == null) {
            builder.append(translateTypeSpace(expr.type));
            variableName = env.getTmpVariable();
        }
        builder.append(variableName);
        builder.append(" = (");
        builder.append(text);
        builder.append(" != NULL && strcmp(");
        builder.append(text);
        builder.append("->baseType, \"");
        builder.append(expr.type.toString());
        builder.append("\") == 0) ? (");
        builder.append(translateType(expr.type));
        builder.append(") ");
        builder.append(text);
        builder.append("->object : NULL;");
        env.print(builder.toString());
        return variableName;
    }
}
