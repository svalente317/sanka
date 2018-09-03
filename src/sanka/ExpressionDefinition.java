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

    TypeDefinition type;
    String name;
    String operator;
    ExpressionDefinition expression1;
    ExpressionDefinition expression2;
    MethodDefinition method;
    ExpressionDefinition[] argList;

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
        this.name = primary.getText();
        if (primary.literal() != null) {
            // TODO Parse all of the complex literals, such as:
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
            if (env.symbolTable.containsKey(this.name)) {
                this.type = env.symbolTable.get(this.name);
                if (this.type == null) {
                    env.printError(primary, "variable " + this.name + " used before defined");
                }
                return;
            }
            this.method = env.currentClass.getMethod(this.name);
            if (this.method != null) {
                this.type = TypeDefinition.METHOD_TYPE;
                return;
            }
            // TODO class name and package name are valid
            env.printError(primary, "undefined variable: " + this.name);
            return;
        }
        if (this.name.equals("this")) {
            this.type = new TypeDefinition();
            this.type.packageName = env.currentClass.packageName;
            this.type.typeName = env.currentClass.name;
            return;
        }
        env.printError(primary, "unknown primary expression");
    }

    void evaluateCreator(CreatorContext creator) {
        Environment env = Environment.getInstance();
        System.out.println(creator.getText());
        CreatedNameContext namectx = creator.createdName();
        this.type = new TypeDefinition();
        this.type.parse(namectx.primitiveType(), namectx.classOrInterfaceType());
        ClassDefinition classdef = env.getClassDefinition(this.type);
        if (this.type.primitiveType == null && classdef == null) {
            env.printError(creator, "class " + this.type + " undefined");
            this.type = null;
            return;
        }
        ArrayCreatorRestContext arrayCreator = creator.arrayCreatorRest();
        if (arrayCreator != null) {
            if (arrayCreator.expression() == null) {
                // Case 1: Count the number of [] pairs, and then evaluate the optional
                // list of expressions as the array's value.
                int childCount = arrayCreator.getChildCount();
                for (int i = 0; i < childCount; i+= 2) {
                    String ls = arrayCreator.getChild(i).getText();
                    String rs = arrayCreator.getChild(i+1).getText();
                    if (ls.equals("[") && rs.equals("]")) {
                        this.type.arrayCount++;
                    } else if (!ls.equals("{")) {
                        env.printError(arrayCreator, "unrecognized array creator");
                    }
                }
                // TODO evaluate expressionList
                return;
            }
            // Case 2: Count the number of [] pairs, and also evaluate the lengths
            // of the first one or more arrays.
            int childCount = arrayCreator.getChildCount();
            List<ExpressionDefinition> arrayLengths = new ArrayList<>();
            for (int i = 0; i < childCount; i++) {
                String ls = arrayCreator.getChild(i).getText();
                if (!ls.equals("[")) {
                    env.printError(arrayCreator, "unrecognized array creator");
                    break;
                }
                i++;
                if (arrayCreator.getChild(i) instanceof ExpressionContext) {
                    ExpressionDefinition arrayLength = new ExpressionDefinition();
                    arrayLength.evaluate((ExpressionContext) arrayCreator.getChild(i));
                    arrayLengths.add(arrayLength);
                    i++;
                }
                String rs = arrayCreator.getChild(i).getText();
                if (!rs.equals("]")) {
                    env.printError(arrayCreator, "unrecognized array creator");
                    break;
                }
                this.type.arrayCount++;
            }
            // TODO Do something with arrayLengths
            return;
        }
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
        // TODO evaluate classBody() for adapter expressions?
    }

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
     * If one of these types could be promoted to be stored in a variable of the
     * other type, then return the storage type.
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
                env.printError(expr, "type " + this.expression1.type + " undefined");
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
                 env.printError(expr, "type " + this.type + " does not have field " + this.name);
                 return;
             }
             this.type = TypeDefinition.METHOD_TYPE;
             isPrivate = this.method.isPrivate;
        } else {
            this.type = fielddef.type;
            isPrivate = fielddef.isPrivate;
        }
        if (isPrivate && classdef != env.currentClass) {
            env.printError(expr, "type " + this.expression1.type + " field " + this.name + " is private");
        }
    }

    void evaluateBinaryOp(ExpressionContext lhs, ExpressionContext rhs) {
        this.expression1 = new ExpressionDefinition();
        this.expression1.evaluate(lhs);
        this.expression2 = new ExpressionDefinition();
        this.expression2.evaluate(rhs);
        if (this.expression1.type != null && this.expression2.type != null) {
            // TODO character addition and subtraction
            if (this.operator.equals("*") || this.operator.equals("/") ||
                    this.operator.equals("+") || this.operator.equals("-")) {
                checkNumericType(lhs, this.expression1.type);
                checkNumericType(rhs, this.expression2.type);
                // If either side is a char, then:
                // 1. the other side must be a char or int.
                // 2. the operator must be plus or minus.
                // 3. the expression type is demoted to char.
                // TODO
                this.type = promoteType(this.expression1.type, this.expression2.type);
            }
            else if (this.operator.equals("<=") || this.operator.equals(">=") ||
                    this.operator.equals("<") || this.operator.equals(">")) {
                    // TODO characters again
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
                // TODO Check that types are the same or comparable or null?
                this.type = TypeDefinition.BOOLEAN_TYPE;
            }
        }
    }

    void evaluateArrayAccess(ExpressionContext expr, ExpressionContext itemExpr) {
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
        // TODO support dot-dot-dot functions
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
        Environment env = Environment.getInstance();
        ExpressionDefinition exprdef1 = new ExpressionDefinition();
        exprdef1.evaluate(expr1);
        ExpressionDefinition exprdef2 = new ExpressionDefinition();
        exprdef2.evaluate(expr2);
        ExpressionDefinition exprdef3 = new ExpressionDefinition();
        exprdef3.evaluate(expr3);
        if (exprdef1.type != null && !exprdef1.type.isBooleanType()) {
            env.printError(expr1, "incompatible types: " + exprdef1.type +
                    " cannot be converted to boolean");
        }
        if (exprdef2.type == null || exprdef3.type == null) {
            return;
        }
        if (!exprdef2.type.equals(exprdef3.type)) {
            env.printError(expr2, "expression has ambiguous type: " +
                    exprdef2.type + " or " + exprdef3.type);
            return;
        }
        this.expression1 = exprdef1;
        this.argList = new ExpressionDefinition[] { exprdef2, exprdef3 };
        this.type = exprdef2.type;
    }
}
