package sanka;

import sanka.ExpressionDefinition.ExpressionType;

class LiteralUtils {
    /**
     * Reformat the integer literal as a simple decimal literal, and determine if
     * its type is int or long.
     * Literals of type 'int' may be automatically cast to byte or short if necessary.
     * Literals of type 'long' are never automatically cast.
     *
     * For example, if a function takes an argument of type 'byte', then you may
     * pass the literal "0", but not "0L".
     */
    static void evaluateIntegerLiteral(ExpressionDefinition expr) {
        expr.type = TypeDefinition.INT_TYPE;
        String text = expr.name.replace("_", "");
        int length = text.length();
        char ch = text.charAt(length-1);
        if (ch == 'L' || ch == 'l') {
            expr.type = TypeDefinition.LONG_TYPE;
            text = text.substring(0, length - 1);
        }
        long value;
        if (text.startsWith("0b") || text.startsWith("0B")) {
            value = Long.parseLong(text.substring(2), 2);
        } else {
            value = Long.decode(text);
        }
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            expr.type = TypeDefinition.LONG_TYPE;
        }
        expr.name = Long.toString(value);
    }

    static String evaluateStringLiteral(String literal) {
        String quote = "\"";
        if (literal.startsWith(quote) && literal.endsWith(quote)) {
            return literal.substring(1, literal.length()-1);
        }
        return null;
    }

    /**
     * @param text a literal of type int
     * @return true if this literal can be used as a byte.
     */
    static boolean isByte(String text) {
        int value = Integer.parseInt(text);
        return Byte.MIN_VALUE <= value && value <= Byte.MAX_VALUE;
    }

    /**
     * @param text a literal of type int
     * @return true if this literal can be used as a short.
     */
    static boolean isShort(String text) {
        int value = Integer.parseInt(text);
        return Short.MIN_VALUE <= value && value <= Short.MAX_VALUE;
    }

    static void foldUnaryOp(ExpressionDefinition expr) {
        if (expr.expression1.expressionType == ExpressionType.LITERAL && expr.expression1.type != null) {
            if (expr.expression1.type.isIntegralType()) {
                if (expr.operator.equals("+") || expr.operator.equals("-")) {
                    expr.expressionType = expr.expression1.expressionType;
                    expr.type = expr.expression1.type;
                    expr.name = expr.expression1.name;
                    if (expr.operator.equals("-")) {
                        expr.name = Long.toString(-Long.parseLong(expr.name));
                    }
                    expr.operator = null;
                    expr.expression1 = null;
                }
            }
        }
    }

    static void foldBinaryOp(ExpressionDefinition expr) {
        if (expr.expression1.expressionType != ExpressionType.LITERAL ||
            expr.expression2.expressionType != ExpressionType.LITERAL) {
            return;
        }
        if (expr.expression1.type == null || expr.expression2.type == null) {
            return;
        }
        String newValue = null;
        if (expr.expression1.type.isStringType() && expr.expression2.type.isStringType()) {
            if (expr.operator.equals("+")) {
                newValue = expr.expression1.name + expr.expression2.name;
            }
        }
        if (expr.expression1.type.isIntegralType() && expr.expression2.type.isIntegralType()) {
            long v1 = Long.parseLong(expr.expression1.name);
            long v2 = Long.parseLong(expr.expression2.name);
            Long value = null;
            switch (expr.operator) {
            case "+":
                value = v1 + v2;
                break;
            case "-":
                value = v1 - v2;
                break;
            case "*":
                value = v1 * v2;
                break;
            case "/":
                value = v1 / v2;
                break;
            case "%":
                value = v1 % v2;
                break;
            case "<<":
                value = v1 << v2;
                break;
            case ">>":
                value = v1 >> v2;
                break;
            case "|":
                value = v1 | v2;
                break;
            case "&":
                value = v1 & v2;
                break;
            }
            if (value != null) {
                newValue = value.toString();
            }
        }
        if (newValue == null) {
            return;
        }
        expr.expressionType = expr.expression1.expressionType;
        expr.type = expr.expression1.type;
        if (expr.expression2.type.equals(TypeDefinition.LONG_TYPE)) {
            expr.type = expr.expression2.type;
        }
        expr.name = newValue;
        expr.operator = null;
        expr.expression1 = null;
        expr.expression2 = null;
    }

    static String translateLiteral(ExpressionDefinition expr) {
        if (expr.type == TypeDefinition.BYTE_TYPE) {
            return expr.name;
        }
        if (expr.type == TypeDefinition.SHORT_TYPE ||
            expr.type == TypeDefinition.INT_TYPE) {
            return expr.name;
        }
        if (expr.type == TypeDefinition.LONG_TYPE) {
            return "(long)" + expr.name;
        }
        if (expr.type == TypeDefinition.DOUBLE_TYPE) {
            return expr.name;
        }
        if (expr.type == TypeDefinition.BOOLEAN_TYPE) {
            return expr.name.equals("true") ? "1" : (expr.name.equals("false") ? "0" : "error");
        }
        if (expr.type == TypeDefinition.STRING_TYPE) {
            return "\"" + expr.name + "\"";
        }
        if (expr.type == TypeDefinition.NULL_TYPE) {
            return "NULL";
        }
        return "error";
    }
}
