package sanka;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.ClassDefinition.FieldDefinition;
import sanka.MethodDefinition.ParameterDefinition;
import sanka.antlr4.SankaParser.ArrayCreatorRestContext;
import sanka.antlr4.SankaParser.CreatedNameContext;
import sanka.antlr4.SankaParser.CreatorContext;
import sanka.antlr4.SankaParser.ExpressionContext;
import sanka.antlr4.SankaParser.ExpressionListContext;
import sanka.antlr4.SankaParser.LiteralContext;
import sanka.antlr4.SankaParser.PrimaryContext;

class ExpressionDefinition {

    static enum ExpressionType {
        LITERAL, IDENTIFIER, NEW_INSTANCE, NEW_ARRAY_WITH_VALUES, NEW_ARRAY_WITH_LENGTHS,
        UNARY, FIELD_ACCESS, BINARY, ARRAY_ACCESS, FUNCTION_CALL, TERNARY
    };

    ExpressionType expressionType;
    TypeDefinition type;
    String name;
    String operator;
    ExpressionDefinition expression1;
    ExpressionDefinition expression2;
    MethodDefinition method;
    boolean isStatic;
    ExpressionDefinition[] argList;
    String translatedThis;

    /**
     * Run expression through pass 2 (of 3). Check for any type errors, and calculate the type
     * of the expression.
     */
    void evaluate(ExpressionContext ctx) {
        if (ctx.primary() != null) {
            evaluatePrimary(ctx.primary());
            return;
        }
        if (ctx.creator() != null) {
            evaluateCreator(ctx.creator());
            return;
        }
        int count = ctx.getChildCount();
        switch (count) {
        case 2:
            this.operator = ((TerminalNode) ctx.getChild(0)).getSymbol().getText();
            evaluateUnaryOp(ctx.expression(0));
            return;
        case 3:
            String middle = ((TerminalNode) ctx.getChild(1)).getSymbol().getText();
            if (middle.equals(".")) {
                evaluateFieldAccess(ctx.expression(0), ctx.Identifier());
            } else if (middle.equals("(")) {
                evaluateFunctionCall(ctx.expression(0), null);
            } else {
                this.operator = middle;
                evaluateBinaryOp(ctx.expression(0), ctx.expression(1));
            }
            return;
        case 4:
            String left_op = ((TerminalNode) ctx.getChild(1)).getSymbol().getText();
            String right_op = ((TerminalNode) ctx.getChild(3)).getSymbol().getText();
            if (left_op.equals("[") && right_op.equals("]")) {
                evaluateArrayAccess(ctx.expression(0), ctx.expression(1));
                return;
            }
            else if (left_op.equals("(") && right_op.equals(")")) {
                evaluateFunctionCall(ctx.expression(0), ctx.expressionList());
                return;
            }
            break;
        case 5:
            String op1 = ((TerminalNode) ctx.getChild(1)).getSymbol().getText();
            String op2 = ((TerminalNode) ctx.getChild(3)).getSymbol().getText();
            if (op1.equals("?") && op2.equals(":")) {
                evaluateTernaryConditional(ctx.expression(0), ctx.expression(1), ctx.expression(2));
                return;
            }
            break;
        }
        Environment env = Environment.getInstance();
        env.printError(ctx, "unrecognized expression");
    }

    /**
     * primary is parExpression or 'this' or literal or Identifier
     */
    void evaluatePrimary(PrimaryContext primary) {
        Environment env = Environment.getInstance();
        if (primary.parExpression() != null) {
            this.evaluate(primary.parExpression().expression());
            return;
        }
        this.expressionType = ExpressionType.LITERAL;
        this.name = primary.getText();
        if (primary.literal() != null) {
            // Parse all of the complex literals, such as:
            // * integers in binary, octal, hex
            // * floating points in hex and/or exp mode
            // * characters in octal mode
            // * integer and floating point suffixes - L, F, D, etc.
            // * integer overflow
            // * character overflow
            LiteralContext literal = primary.literal();
            if (literal.IntegerLiteral() != null) {
                this.type = TypeDefinition.INT_TYPE;
                return;
            }
            if (literal.FloatingPointLiteral() != null) {
                this.type = TypeDefinition.DOUBLE_TYPE;
                return;
            }
            if (literal.CharacterLiteral() != null) {
                this.type = TypeDefinition.CHAR_TYPE;
                return;
            }
            if (literal.BooleanLiteral() != null) {
                this.type = TypeDefinition.BOOLEAN_TYPE;
                return;
            }
            if (literal.StringLiteral() != null) {
                this.type = TypeDefinition.STRING_TYPE;
                return;
            }
            if (this.name.equals("null")) {
                this.type = TypeDefinition.NULL_TYPE;
                return;
            }
        }
        if (primary.Identifier() != null) {
            this.type = env.symbolTable.get(this.name);
            if (this.type != null) {
                this.expressionType = ExpressionType.IDENTIFIER;
                return;
            }
            this.method = env.currentClass.getMethod(this.name);
            if (this.method != null) {
                this.expressionType = ExpressionType.FIELD_ACCESS;
                this.type = TypeDefinition.METHOD_TYPE;
                this.expression1 = new ExpressionDefinition();
                this.expression1.evaluateThis();
                return;
            }
            env.printError(primary, "undefined variable: " + this.name);
            return;
        }
        if (this.name.equals("this")) {
            evaluateThis();
            return;
        }
        env.printError(primary, "unknown primary expression");
    }

    void evaluateThis() {
        Environment env = Environment.getInstance();
        this.expressionType = ExpressionType.IDENTIFIER;
        this.name = "this";
        this.type = new TypeDefinition();
        this.type.packageName = env.currentClass.packageName;
        this.type.name = env.currentClass.name;
    }

    /**
     * Evaluate an expression like "new Class()" or "new Class[x]" or "new Class[]{...}".
     */
    void evaluateCreator(CreatorContext creator) {
        Environment env = Environment.getInstance();
        CreatedNameContext namectx = creator.createdName();
        this.type = new TypeDefinition();
        this.type.parse(namectx.primitiveType(), namectx.classOrInterfaceType());
        ClassDefinition classdef = null;
        if (!this.type.isPrimitiveType) {
            classdef = env.getClassDefinition(this.type);
            if (classdef == null) {
                env.printError(creator, "class " + this.type + " undefined");
                this.type = null;
                return;
            }
        }
        if (creator.arrayCreatorRest() != null) {
            evaluateArrayCreator(creator.arrayCreatorRest());
            return;
        }
        this.expressionType = ExpressionType.NEW_INSTANCE;
        if (classdef == null) {
            env.printError(creator, "cannot create new instance of primitive type " + this.type);
            return;
        }
        ExpressionListContext exprlist = creator.classCreatorRest().expressionList();
        if (classdef.constructor == null) {
            if (exprlist != null && exprlist.expression().size() > 0) {
                env.printError(creator, "class " + this.type + " constructor takes no arguments");
            }
            return;
        }
        evaluateFunctionArguments(creator, classdef.constructor, exprlist);
    }

    /**
     * Evaluate the array part of an expression like "new Class[x]" or "new Class[]{...}".
     */
    void evaluateArrayCreator(ArrayCreatorRestContext ctx) {
        Environment env = Environment.getInstance();
        if (ctx.expression() == null) {
            // Case 1: Count the number of [] pairs, and then evaluate the optional
            // list of expressions as the array's value.
            this.expressionType = ExpressionType.NEW_ARRAY_WITH_VALUES;
            int childCount = ctx.getChildCount();
            for (int i = 0; i < childCount; i+= 2) {
                String ls = ctx.getChild(i).getText();
                String rs = ctx.getChild(i+1).getText();
                if (ls.equals("[") && rs.equals("]")) {
                    this.type.arrayCount++;
                } else if (!ls.equals("{")) {
                    env.printError(ctx, "unrecognized array creator");
                }
            }
            return;
        }
        // Case 2: Count the number of [] pairs, and also evaluate the lengths
        // of the first one or more arrays.
        this.expressionType = ExpressionType.NEW_ARRAY_WITH_LENGTHS;
        int childCount = ctx.getChildCount();
        List<ExpressionDefinition> arrayLengths = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            String ls = ctx.getChild(i).getText();
            if (!ls.equals("[")) {
                env.printError(ctx, "unrecognized array creator");
                break;
            }
            i++;
            if (ctx.getChild(i) instanceof ExpressionContext) {
                ExpressionDefinition arrayLength = new ExpressionDefinition();
                arrayLength.evaluate((ExpressionContext) ctx.getChild(i));
                arrayLengths.add(arrayLength);
                i++;
            }
            String rs = ctx.getChild(i).getText();
            if (!rs.equals("]")) {
                env.printError(ctx, "unrecognized array creator");
                break;
            }
            this.type.arrayCount++;
        }
        this.argList = arrayLengths.toArray(new ExpressionDefinition[0]);
        return;
    }

    /**
     * Check the expression has the necessary primitive type.
     */
    void checkBooleanType(ParserRuleContext ctx, TypeDefinition type) {
        if (type != null) {
            if (!type.isBooleanType()) {
                Environment env = Environment.getInstance();
                env.printError(ctx, "expression type must be boolean");
            }
        }
    }

    void checkIntegralType(ParserRuleContext ctx, TypeDefinition type) {
        if (type != null) {
            if (!type.isIntegralType()) {
                Environment env = Environment.getInstance();
                env.printError(ctx, "expression type must be an integral type");
            }
        }
    }

    void checkNumericType(ParserRuleContext ctx, TypeDefinition type) {
        if (type != null) {
            if (!type.isNumericType()) {
                Environment env = Environment.getInstance();
                env.printError(ctx, "expression type must be a numeric type");
            }
        }
    }

    /**
     * If one of these types could be promoted to be stored in a variable of the other type,
     * then return the storage type.
     */
    TypeDefinition promoteType(TypeDefinition type1, TypeDefinition type2) {
        if (type1.isCompatible(type2)) {
            return type1;
        }
        if (type2.isCompatible(type1)) {
            return type2;
        }
        return null;
    }

    void evaluateUnaryOp(ExpressionContext ctx) {
        this.expressionType = ExpressionType.UNARY;
        this.expression1 = new ExpressionDefinition();
        this.expression1.evaluate(ctx);
        if (this.operator.equals("!")) {
            checkBooleanType(ctx, this.expression1.type);
        } else if (this.operator.equals("~")) {
            checkIntegralType(ctx, this.expression1.type);
        } else if (this.operator.equals("+") || this.operator.equals("-")) {
            checkNumericType(ctx, this.expression1.type);
        }
        this.type = this.expression1.type;
    }

    void evaluateFieldAccess(ExpressionContext expr, TerminalNode identifier) {
        Environment env = Environment.getInstance();
        this.expressionType = ExpressionType.FIELD_ACCESS;
        this.expression1 = new ExpressionDefinition();
        this.expression1.evaluate(expr);
        this.name = identifier.getText();
        if (this.expression1.type == null) {
            return;
        }
        // This is similar code to the code in StatementDefinition.java
        // when the field access is the LHS of the statement.
        ClassDefinition classdef;
        if (this.expression1.type.arrayCount == 0) {
            classdef = env.getClassDefinition(this.expression1.type);
            if (classdef == null) {
                env.printError(expr, "class " + this.expression1.type + " undefined");
                return;
            }
        } else {
            classdef = ClassDefinition.arrayClassDefinition();
        }
        FieldDefinition fielddef = classdef.fieldMap.get(this.name);
        boolean isPrivate;
        if (fielddef == null) {
             this.method = classdef.getMethod(this.name);
             if (this.method == null) {
                 env.printError(expr, "class " + this.type + " does not have field " + this.name);
                 return;
             }
             this.type = TypeDefinition.METHOD_TYPE;
             isPrivate = this.method.isPrivate;
        } else {
            this.type = fielddef.type;
            this.isStatic = fielddef.isStatic;
            isPrivate = fielddef.isPrivate;
            if (fielddef.isConst) {
                // TODO replace all of this with fielddef.value
            }
        }
        if (isPrivate && classdef != env.currentClass) {
            env.printError(expr, "class " + this.expression1.type + " field " + this.name +
                    " is private");
        }
    }

    void evaluateBinaryOp(ExpressionContext lhs, ExpressionContext rhs) {
        this.expressionType = ExpressionType.BINARY;
        this.expression1 = new ExpressionDefinition();
        this.expression1.evaluate(lhs);
        this.expression2 = new ExpressionDefinition();
        this.expression2.evaluate(rhs);
        if (this.expression1.type != null && this.expression2.type != null) {
            if (this.operator.equals("*") || this.operator.equals("/") ||
                    this.operator.equals("+") || this.operator.equals("-")) {
                checkNumericType(lhs, this.expression1.type);
                checkNumericType(rhs, this.expression2.type);
                this.type = promoteType(this.expression1.type, this.expression2.type);
            }
            else if (this.operator.equals("<=") || this.operator.equals(">=") ||
                    this.operator.equals("<") || this.operator.equals(">")) {
                checkNumericType(lhs, this.expression1.type);
                checkNumericType(rhs, this.expression2.type);
                this.type = TypeDefinition.BOOLEAN_TYPE;
            }
            else if (this.operator.equals("%") || this.operator.equals("<<") ||
                    this.operator.equals(">>") || this.operator.equals("&") ||
                    this.operator.equals("^") || this.operator.equals("|")) {
                checkIntegralType(lhs, this.expression1.type);
                checkIntegralType(rhs, this.expression2.type);
                this.type = promoteType(this.expression1.type, this.expression2.type);
            }
            else if (this.operator.equals("&&") || this.operator.equals("||")) {
                checkBooleanType(lhs, this.expression1.type);
                checkBooleanType(rhs, this.expression2.type);
                this.type = this.expression1.type;
            }
            else if (this.operator.equals("==") || this.operator.equals("!=")) {
                this.type = TypeDefinition.BOOLEAN_TYPE;
            }
        }
    }

    void evaluateArrayAccess(ExpressionContext expr, ExpressionContext itemExpr) {
        this.expressionType = ExpressionType.ARRAY_ACCESS;
        Environment env = Environment.getInstance();
        this.expression1 = new ExpressionDefinition();
        this.expression1.evaluate(expr);
        this.expression2 = new ExpressionDefinition();
        this.expression2.evaluate(itemExpr);
        if (this.expression1.type == null || this.expression2.type == null) {
            return;
        }
        if (this.expression1.type.arrayCount == 0) {
            env.printError(expr, "expression of type " + this.expression1.type +
                    " cannot be used as an array");
            return;
        }
        if (!this.expression2.type.isIntegralType()) {
            env.printError(expr, "array index must be an int, not type " +
                    this.expression2.type);
            return;
        }
        this.type = this.expression1.type.copy();
        this.type.arrayCount--;
    }

    void evaluateFunctionCall(ExpressionContext expr, ExpressionListContext argumentList) {
        this.expressionType = ExpressionType.FUNCTION_CALL;
        Environment env = Environment.getInstance();
        this.expression1 = new ExpressionDefinition();
        this.expression1.evaluate(expr);
        if (this.expression1.type == null) {
            return;
        }
        if (this.expression1.method == null) {
            env.printError(expr, "expression of type " + this.expression1.type +
                    " cannot be called as a function");
            return;
        }
        evaluateFunctionArguments(expr, this.expression1.method, argumentList);
        this.type = this.expression1.method.returnType;
    }

    void evaluateFunctionArguments(ParserRuleContext expr, MethodDefinition method,
            ExpressionListContext exprList) {
        Environment env = Environment.getInstance();
        if (exprList != null) {
            this.argList = new ExpressionDefinition[exprList.expression().size()];
            for (int idx = 0; idx < this.argList.length; idx++) {
                this.argList[idx] = new ExpressionDefinition();
                this.argList[idx].evaluate(exprList.expression(idx));
            }
        } else {
            this.argList = new ExpressionDefinition[0];
        }
        int paramCount = method.parameters.size();
        if (this.argList.length != paramCount) {
            env.printError(expr, "function takes " + paramCount + " arguments, " +
                    this.argList.length + " given");
            return;
        }
        for (int idx = 0; idx < paramCount; idx++) {
            ParameterDefinition param = method.parameters.get(idx);
            if (param.type != null) {
                if (!param.type.isCompatible(this.argList[idx].type)) {
                    env.printError(exprList.expression(idx),
                            "incompatible types: " + this.argList[idx].type +
                            " cannot be converted to " + param.type);
                }
            }
        }
    }

    void evaluateTernaryConditional(ExpressionContext expr1, ExpressionContext expr2,
            ExpressionContext expr3) {
        this.expressionType = ExpressionType.TERNARY;
        ExpressionDefinition exprdef1 = new ExpressionDefinition();
        exprdef1.evaluate(expr1);
        ExpressionDefinition exprdef2 = new ExpressionDefinition();
        exprdef2.evaluate(expr2);
        ExpressionDefinition exprdef3 = new ExpressionDefinition();
        exprdef3.evaluate(expr3);
        checkBooleanType(expr1, exprdef1.type);
        if (exprdef2.type == null || exprdef3.type == null) {
            return;
        }
        this.expression1 = exprdef1;
        this.argList = new ExpressionDefinition[] { exprdef2, exprdef3 };
        this.type = exprdef2.type;
    }

    // --------------------------------------------------------------------------------

    /**
     * Write any C statements necessary to setup the expression. Then, return a string of C code
     * that evaluates to the expression, given the setup.
     * Generate the C string such that it can be evaluated multiple times without side effects.
     *
     * variableName is an optional C variable which has been declared to the correct type.
     * It can be used to store the evaluated expression if necessary.
     */
    String translate(String variableName) {
        switch (this.expressionType) {
        case LITERAL:
            return translateLiteral();
        case IDENTIFIER:
            return this.name;
        case NEW_INSTANCE:
            return translateNewInstance(variableName);
        case NEW_ARRAY_WITH_VALUES:
            break;
        case NEW_ARRAY_WITH_LENGTHS:
            return translateNewArrayWithLengths(variableName);
        case UNARY:
            return translateUnary();
        case FIELD_ACCESS:
            return translateFieldAccess();
        case BINARY:
            return translateBinary();
        case ARRAY_ACCESS:
            return translateArrayAccess();
        case FUNCTION_CALL:
            return translateFunctionCall(variableName);
        case TERNARY:
            return translateTernary(variableName);
        }
        return null;
    }

    String translateLiteral() {
        if (this.type == TypeDefinition.INT_TYPE || this.type == TypeDefinition.DOUBLE_TYPE) {
            return this.name;
        }
        if (this.type == TypeDefinition.CHAR_TYPE) {
            return this.name;
        }
        if (this.type == TypeDefinition.BOOLEAN_TYPE) {
            return this.name.equals("true") ? "1" : (this.name.equals("false") ? "0" : "error");
        }
        if (this.type == TypeDefinition.STRING_TYPE) {
            return "STRINGLITERAL(" + this.name + ")";
        }
        if (this.type == TypeDefinition.NULL_TYPE) {
            return "NULL";
        }
        return "error";
    }

    String translateNewInstance(String variableName) {
        Environment env = Environment.getInstance();
        StringBuilder builder = new StringBuilder();
        if (variableName == null) {
            builder.append(this.type.translateSpace());
            variableName = env.getTmpVariable();
        }
        builder.append(variableName);
        builder.append(" = calloc(1, sizeof(");
        builder.append(this.type.translateDereference());
        builder.append("));");
        StringBuilder builder2 = null;
        ClassDefinition classdef = env.getClassDefinition(this.type);
        if (classdef.constructor != null) {
            builder2 = new StringBuilder();
            builder2.append(TranslationUtils.translateClassItem(classdef.name, classdef.name));
            builder2.append("(");
            builder2.append(variableName);
            if (this.argList != null) {
               for (ExpressionDefinition arg : this.argList) {
                   builder2.append(", ");
                   builder2.append(arg.translate(null));
               }
            }
            builder2.append(");");
        }
        env.print(builder.toString());
        if (builder2 != null) {
            env.print(builder2.toString());
        }
        return variableName;
    }

    String translateNewArrayWithLengths(String variableName) {
        Environment env = Environment.getInstance();
        StringBuilder builder = new StringBuilder();
        if (variableName == null) {
            builder.append(this.type.translateSpace());
            variableName = env.getTmpVariable();
        }
        builder.append(variableName);
        builder.append(" = NEWARRAY(");
        builder.append(this.argList[0].translate(null));
        builder.append(", sizeof(");
        TypeDefinition itemType = this.type.copy();
        itemType.arrayCount--;
        builder.append(itemType.translate());
        builder.append("));");
        env.print(builder.toString());
        return variableName;
    }

    String translateUnary() {
        return this.operator + this.expression1.translate(null);
    }

    String translateFieldAccess() {
        Environment env = Environment.getInstance();
        String text = this.expression1.translate(null);
        if (!text.equals("this")) {
            env.print("NULLCHECK(" + text + ");");
        }
        if (this.type == TypeDefinition.METHOD_TYPE) {
            this.translatedThis = text;
            return TranslationUtils.translateClassItem(this.expression1.type.name, this.name);
        }
        if (this.isStatic) {
            return TranslationUtils.translateClassItem(this.expression1.type.name, this.name);
        }
        return text + "->" + this.name;
    }

    String translateBinary() {
        Environment env = Environment.getInstance();
        if (this.operator.equals("&&") || this.operator.equals("||")) {
            StringBuilder builder = new StringBuilder();
            String variableName = env.getTmpVariable();
            builder.append("int ");
            builder.append(variableName);
            builder.append(" = ");
            builder.append(this.expression1.translate(null));
            builder.append(";");
            env.print(builder.toString());
            builder.setLength(0);
            builder.append("if (");
            if (this.operator.equals("||")) {
                builder.append("!");
            }
            builder.append(variableName);
            builder.append(") {");
            env.print(builder.toString());
            env.level++;
            String text = this.expression2.translate(variableName);
            setTextToVariable(text, variableName);
            env.level--;
            env.print("}");
            return variableName;
        }
        String text1 = this.expression1.translate(null);
        String text2 = this.expression2.translate(null);
        if (this.operator.equals("/")) {
            env.print("DIVISIONCHECK(" + text2 + ");");
        }
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        builder.append(text1);
        builder.append(" ");
        builder.append(this.operator);
        builder.append(" ");
        builder.append(text2);
        builder.append(")");
        return builder.toString();
    }

    void setTextToVariable(String text, String variableName) {
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

    String translateArrayAccess() {
        Environment env = Environment.getInstance();
        String text1 = this.expression1.translate(null);
        String text2 = this.expression2.translate(null);
        env.print("BOUNDSCHECK(" + text1 + ", " + text2 + ");");
        return "ARRCAST(" + text1 + ", " + this.type.translate() + ")[" + text2 + "]";
    }

    String translateFunctionCall(String variableName) {
        Environment env = Environment.getInstance();
        StringBuilder builder = new StringBuilder();
        if (!this.type.isVoidType()) {
            if (variableName == null) {
                builder.append(this.type.translateSpace());
                variableName = env.getTmpVariable();
            }
            builder.append(variableName);
            builder.append(" = ");
        }
        builder.append(this.expression1.translate(null));
        builder.append("(");
        boolean needComma = false;
        if (!this.expression1.method.isStatic) {
            builder.append(this.expression1.translatedThis);
            needComma = true;
        }
        for (ExpressionDefinition arg : this.argList) {
            if (needComma) {
                builder.append(", ");
            }
            builder.append(arg.translate(null));
            needComma = true;
        }
        builder.append(");");
        env.print(builder.toString());
        return variableName;
    }

    String translateTernary(String variableName) {
        Environment env = Environment.getInstance();
        String text;
        StringBuilder builder = new StringBuilder();
        if (variableName == null) {
            variableName = env.getTmpVariable();
            builder.append(this.type.translateSpace());
            builder.append(variableName);
            builder.append(";");
            env.print(builder.toString());
        }
        builder.setLength(0);
        builder.append("if (");
        builder.append(this.expression1.translate(null));
        builder.append(") {");
        env.print(builder.toString());
        env.level++;
        text = this.argList[0].translate(variableName);
        setTextToVariable(text, variableName);
        env.level--;
        env.print("} else {");
        env.level++;
        text = this.argList[1].translate(variableName);
        setTextToVariable(text, variableName);
        env.level--;
        env.print("}");
        return variableName;
    }
}
