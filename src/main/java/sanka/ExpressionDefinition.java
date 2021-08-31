package sanka;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.ClassDefinition.FieldDefinition;
import sanka.MethodDefinition.ParameterDefinition;
import sanka.antlr4.SankaParser.AnonymousClassBodyContext;
import sanka.antlr4.SankaParser.AnonymousClassBodyDeclarationContext;
import sanka.antlr4.SankaParser.ArrayDefinitionContext;
import sanka.antlr4.SankaParser.CreatorContext;
import sanka.antlr4.SankaParser.ExpressionContext;
import sanka.antlr4.SankaParser.ExpressionListContext;
import sanka.antlr4.SankaParser.LiteralContext;
import sanka.antlr4.SankaParser.MapDefinitionContext;
import sanka.antlr4.SankaParser.MapEntryContext;
import sanka.antlr4.SankaParser.PrimaryContext;
import sanka.antlr4.SankaParser.ScalarTypeContext;

public class ExpressionDefinition {

    public enum ExpressionType {
        LITERAL, IDENTIFIER, CLASS_IDENTIFIER, NEW_INSTANCE, NEW_ARRAY_WITH_VALUES,
        NEW_ARRAY, NEW_MAP, UNARY, FIELD_ACCESS, BINARY, ARRAY_ACCESS, FUNCTION_CALL,
        TERNARY, SUPERCLASS, SUPER_DOT_METHOD, TYPE_CAST
    }

    public ExpressionType expressionType;
    public TypeDefinition type;
    public String name;
    public String operator;
    public ExpressionDefinition expression1;
    public ExpressionDefinition expression2;
    public MethodDefinition method;
    public boolean isStatic;
    public String value;
    public TypeDefinition identifiedClass;
    public ExpressionDefinition[] argList;
    public String[] fieldList;
    public String translatedThis;

    ExpressionDefinition copyAndClear() {
        ExpressionDefinition copy = new ExpressionDefinition();
        copy.expressionType = this.expressionType;
        copy.type = this.type;
        copy.name = this.name;
        copy.operator = this.operator;
        copy.expression1 = this.expression1;
        copy.expression2 = this.expression2;
        copy.method = this.method;
        copy.isStatic = this.isStatic;
        copy.value = this.value;
        copy.identifiedClass = this.identifiedClass;
        copy.argList = this.argList;
        copy.fieldList = this.fieldList;
        copy.translatedThis = this.translatedThis;

        this.expressionType = null;
        this.type = null;
        this.name = null;
        this.operator = null;
        this.expression1 = null;
        this.expression2 = null;
        this.method = null;
        this.isStatic = false;
        this.value = null;
        this.identifiedClass = null;
        this.argList = null;
        this.fieldList = null;
        this.translatedThis = null;
        return copy;
    }

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
        if (ctx.arrayDefinition() != null) {
            evaluateArrayDefinition(ctx.arrayDefinition());
            return;
        }
        if (ctx.mapDefinition() != null) {
            evaluateMapDefinition(ctx.mapDefinition());
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
            if (ctx.expression(0) == null) {
                evaluateSuperDotMethod(ctx);
            } else if (middle.equals(".")) {
                evaluateFieldAccess(ctx.expression(0), ctx.Identifier());
            } else if (middle.equals("(")) {
                evaluateFunctionCall(ctx.expression(0), null);
            } else {
                this.operator = middle;
                evaluateBinaryOp(ctx.expression(0), ctx.expression(1));
            }
            return;
        case 4:
            if (ctx.scalarType() != null) {
                evaluateTypeCast(ctx.scalarType(), ctx.expression(0));
                return;
            }
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
     * Assuming that this.expressionType is FIELD_ACCESS, and that this accesses a
     * field or method of a regular class (as opposed to an array or map), return
     * the ClassDefinition of the accessed field.
     */
    ClassDefinition getAccessedClass() {
        Environment env = Environment.getInstance();
        if (this.expression1.expressionType == ExpressionType.CLASS_IDENTIFIER) {
            return env.loadClassDefinition(this.expression1.identifiedClass);
        }
        return env.loadClassDefinition(this.expression1.type);
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
        String text = primary.getText();
        if (primary.literal() != null) {
            this.value = text;
            // Parse all of the complex literals, such as:
            // * integers in binary, octal, hex
            // * floating points in hex and/or exp mode
            // * characters in octal mode
            // * integer and floating point suffixes - L, F, D, etc.
            // * integer overflow
            // * character overflow
            LiteralContext literal = primary.literal();
            if (literal.IntegerLiteral() != null) {
                LiteralUtils.evaluateIntegerLiteral(this);
                return;
            }
            if (literal.FloatingPointLiteral() != null) {
                this.type = TypeDefinition.DOUBLE_TYPE;
                return;
            }
            if (literal.CharacterLiteral() != null) {
                this.type = TypeDefinition.BYTE_TYPE;
                return;
            }
            if (literal.BooleanLiteral() != null) {
                this.type = TypeDefinition.BOOLEAN_TYPE;
                return;
            }
            if (literal.StringLiteral() != null) {
                this.type = TypeDefinition.STRING_TYPE;
                this.value = LiteralUtils.evaluateStringLiteral(this.value);
                return;
            }
            if (this.value.equals("null")) {
                this.type = TypeDefinition.NULL_TYPE;
                return;
            }
        }
        if (primary.Identifier() != null) {
            this.name = text;
            this.type = env.symbolTable.get(this.name);
            if (this.type != null) {
                this.expressionType = ExpressionType.IDENTIFIER;
                return;
            }
            this.method = env.currentClass.getNamedMethod(this.name);
            if (this.method != null) {
                this.expressionType = ExpressionType.FIELD_ACCESS;
                this.type = TypeDefinition.METHOD_TYPE;
                this.expression1 = new ExpressionDefinition();
                if (this.method.isStatic) {
                    this.expression1.evaluateThisClass();
                } else {
                    this.expression1.evaluateThis(primary);
                }
                return;
            }
            FieldDefinition fielddef = env.currentClass.getField(this.name);
            if (fielddef != null && fielddef.isStatic) {
                this.expressionType = ExpressionType.FIELD_ACCESS;
                this.type = fielddef.type;
                this.expression1 = new ExpressionDefinition();
                this.expression1.evaluateThisClass();
                this.isStatic = true;
                if (fielddef.isConst && fielddef.value != null) {
                    if (this.type != null && !this.type.isStringType()) {
                        this.expressionType = ExpressionType.LITERAL;
                    }
                    this.value = fielddef.value.value;
                }
                return;
            }
            if (env.classPackageMap.containsKey(this.name)) {
                String packageName = env.classPackageMap.get(this.name);
                // Type is void because this expression has no value when evaluated
                // as part of an arithmetic operation, function call, etc.
                // It must be followed by a field access, or else it is a compile-time error.
                this.expressionType = ExpressionType.CLASS_IDENTIFIER;
                this.type = TypeDefinition.VOID_TYPE;
                this.identifiedClass = new TypeDefinition(packageName, this.name);
                return;
            }
            env.printError(primary, "undefined: " + this.name);
            return;
        }
        if (text.equals("this")) {
            evaluateThis(primary);
            return;
        }
        env.printError(primary, "unknown primary expression");
    }

    void evaluateThis(PrimaryContext primary) {
        Environment env = Environment.getInstance();
        this.expressionType = ExpressionType.IDENTIFIER;
        this.name = "this";
        this.type = new TypeDefinition();
        this.type.packageName = env.currentClass.packageName;
        this.type.name = env.currentClass.name;
        if (env.currentMethod.isStatic) {
            env.printError(primary, "'this' cannot be referenced from a static context");
        }
    }

    void evaluateThisClass() {
        Environment env = Environment.getInstance();
        this.expressionType = ExpressionType.CLASS_IDENTIFIER;
        this.type = TypeDefinition.VOID_TYPE;
        this.identifiedClass = env.currentClass.toTypeDefinition();
    }

    /**
     * Evaluate an expression like "new Class()" or "new Class[x]" or "new Class[]{...}".
     */
    void evaluateCreator(CreatorContext creator) {
        if (creator.classType() != null) {
            evaluateNewInstance(creator);
            return;
        }
        if (creator.typeType() != null) {
            evaluateArrayCreator(creator);
            return;
        }
        if (creator.mapType() != null) {
            evaluateMapCreator(creator);
            return;
        }
        if (creator.anonymousClassBody() != null) {
            evaluateAnonymousCreator(creator.anonymousClassBody());
            return;
        }
    }

    private void evaluateNewInstance(CreatorContext creator) {
        Environment env = Environment.getInstance();
        this.expressionType = ExpressionType.NEW_INSTANCE;
        this.type = new TypeDefinition();
        this.type.parse(creator.classType());
        if (this.type.isPrimitiveType) {
            env.printError(creator, "cannot create new instance of primitive type " + this.type);
            return;
        }
        ClassDefinition classdef = env.loadClassDefinition(this.type);
        if (classdef == null) {
            env.printError(creator, "class " + this.type + " undefined");
            return;
        }
        if (classdef.isAbstract) {
            env.printError(creator, "cannot create new instance of abstract class " + this.type);
            return;
        }
        ExpressionListContext exprlist = creator.expressionList();
        int numArgs = exprlist == null ? 0 : exprlist.expression().size();
        MethodDefinition method = classdef.getMethod(classdef.name, numArgs);
        if (method == null) {
            if (numArgs > 0) {
                env.printError(creator, "class " + this.type + " constructor does not take " +
                        numArgs + " parameters");
            }
            if (numArgs == 0 && classdef.hasConstructor()) {
                env.printError(creator, "class " + this.type +
                        " does not have no argument constructor");
            }
            return;
        }
        evaluateFunctionArguments(creator, method, exprlist);
    }

    /**
     * Evaluate the array part of an expression.
     */
    private void evaluateArrayCreator(CreatorContext creator) {
        Environment env = Environment.getInstance();
        this.type = new TypeDefinition();
        this.type.parse(creator.typeType());
        TypeDefinition baseType = this.type;
        while (baseType.arrayOf != null) {
            baseType = baseType.arrayOf;
        }
        if (!baseType.isPrimitiveType) {
            ClassDefinition classdef = env.loadClassDefinition(baseType);
            if (classdef == null) {
                env.printError(creator, "class " + baseType + " undefined");
                return;
            }
        }
        // "new type[size]"
        if (creator.expression() != null) {
            this.expressionType = ExpressionType.NEW_ARRAY;
            TypeDefinition arrayType = new TypeDefinition();
            arrayType.arrayOf = this.type;
            this.type = arrayType;
            this.expression1 = new ExpressionDefinition();
            this.expression1.evaluate(creator.expression());
            checkIntegralType(creator.expression(), this.expression1.type);
            return;
        }
        // "new type[]{ value, ... }"
        if (creator.arrayDefinition() != null) {
            this.expressionType = ExpressionType.NEW_ARRAY_WITH_VALUES;
            TypeDefinition arrayType = new TypeDefinition();
            arrayType.arrayOf = this.type;
            this.type = arrayType;
            ExpressionListContext expressionList = creator.arrayDefinition().expressionList();
            if (expressionList != null) {
                List<ExpressionContext> exprList = expressionList.expression();
                this.argList = new ExpressionDefinition[exprList.size()];
                for (int idx = 0; idx < this.argList.length; idx++) {
                    this.argList[idx] = new ExpressionDefinition();
                    this.argList[idx].evaluate(exprList.get(idx));
                    checkRequiredType(exprList.get(idx), this.type.arrayOf, this.argList[idx]);
                }
            } else {
                this.argList = new ExpressionDefinition[0];
            }
            return;
        }
    }

    private void evaluateMapCreator(CreatorContext creator) {
        this.expressionType = ExpressionType.NEW_MAP;
        this.type = new TypeDefinition();
        this.type.parse(creator.mapType());
        checkMapKeyType(creator, this.type.keyType);
        if (creator.mapDefinition() != null && creator.mapDefinition().mapEntry() != null) {
            List<MapEntryContext> entryList = creator.mapDefinition().mapEntry();
            this.argList = new ExpressionDefinition[entryList.size()];
            for (int idx = 0; idx < this.argList.length; idx++) {
                MapEntryContext entry = entryList.get(idx);
                ExpressionDefinition arg = new ExpressionDefinition();
                arg.expression1 = new ExpressionDefinition();
                arg.expression1.evaluate(entry.expression(0));
                checkRequiredType(entry, this.type.keyType, arg.expression1);
                arg.expression2 = new ExpressionDefinition();
                arg.expression2.evaluate(entry.expression(1));
                checkRequiredType(entry, this.type.arrayOf, arg.expression2);
                this.argList[idx] = arg;
            }
        }
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

    void checkMapKeyType(ParserRuleContext ctx, TypeDefinition type) {
        if (type != null) {
            if (!(type.isStringType() || type.equals(TypeDefinition.INT_TYPE))) {
                Environment env = Environment.getInstance();
                env.printError(ctx, "invalid type for map key: " + type);
            }
        }
    }

    void checkRequiredType(ParserRuleContext ctx, TypeDefinition type, ExpressionDefinition expr) {
        if (!TypeUtils.isCompatible(type, expr)) {
            Environment env = Environment.getInstance();
            env.printError(ctx, "incompatible types: " + expr.type + " cannot be converted to " + type);
        }
    }

    /**
     * If one of these types could be promoted to be stored in a variable of the other type,
     * then return the storage type.
     */
    private TypeDefinition promoteNumericType(ExpressionDefinition expr1, ExpressionDefinition expr2) {
        if (TypeUtils.isCompatibleNumeric(expr1.type, expr2) ||
            TypeUtils.isCompatibleNumeric(expr2.type, expr1)) {
            return expr1.type;
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
        LiteralUtils.foldUnaryOp(this);
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
        ClassDefinition classdef;
        if (this.expression1.type.arrayOf == null) {
            classdef = getAccessedClass();
            if (classdef == null) {
                if (this.expression1.type.isPrimitiveType) {
                    env.printError(expr, "" + this.expression1.type + " cannot be dereferenced");
                } else {
                    env.printError(expr, "class " + this.expression1.type + " undefined");
                }
                return;
            }
        } else if (this.expression1.type.keyType == null) {
            classdef = ArrayUtils.arrayClassDefinition(this.expression1.type.arrayOf);
        } else {
            classdef = ArrayUtils.mapClassDefinition(this.expression1.type.keyType);
        }
        FieldDefinition fielddef = classdef.getField(this.name);
        boolean isPrivate;
        if (fielddef == null) {
             this.method = classdef.getMethod(this.name, null);
             if (this.method == null) {
                 env.printError(expr, "class " + classdef.name +
                         " does not have field " + this.name);
                 return;
             }
             this.type = TypeDefinition.METHOD_TYPE;
             this.isStatic = this.method.isStatic;
             isPrivate = this.method.isPrivate;
        } else {
            if (classdef != env.currentClass) {
                classdef.evaluateConstants();
            }
            this.type = fielddef.type;
            this.isStatic = fielddef.isStatic;
            isPrivate = fielddef.isPrivate;
        }
        if (isPrivate && classdef != env.currentClass) {
            env.printError(expr, "class " + this.expression1.type + " field " + this.name +
                    " is private");
        }
        if (this.expression1.expressionType == ExpressionType.CLASS_IDENTIFIER) {
            if (!this.isStatic) {
                env.printError(expr, "non-static field " + this.name +
                        " cannot be referenced from a static context");
            }
            if (fielddef != null && fielddef.isConst && fielddef.value != null) {
                if (this.type != null && !this.type.isStringType()) {
                    this.expressionType = ExpressionType.LITERAL;
                }
                this.value = fielddef.value.value;
            }
        }
    }

    void evaluateBinaryOp(ExpressionContext lhs, ExpressionContext rhs) {
        Environment env = Environment.getInstance();
        this.expressionType = ExpressionType.BINARY;
        this.expression1 = new ExpressionDefinition();
        this.expression1.evaluate(lhs);
        this.expression2 = new ExpressionDefinition();
        this.expression2.evaluate(rhs);
        if (this.expression1.type != null && this.expression2.type != null) {
            if (this.operator.equals("+") && this.expression1.type.isStringType()) {
                if (!(this.expression2.type.isStringType() ||
                        this.expression2.type.isPrimitiveType)) {
                    env.printError(rhs, "incompatible types: " + this.expression2.type +
                         " cannot be converted to " + this.expression1.type);
                }
                this.type = TypeDefinition.STRING_TYPE;
            }
            else if (this.operator.equals("*") || this.operator.equals("/") ||
                    this.operator.equals("+") || this.operator.equals("-")) {
                checkNumericType(lhs, this.expression1.type);
                checkNumericType(rhs, this.expression2.type);
                this.type = promoteNumericType(this.expression1, this.expression2);
            }
            else if (this.operator.equals("<=") || this.operator.equals(">=") ||
                    this.operator.equals("<") || this.operator.equals(">")) {
                if (this.expression1.type.isStringType()) {
                    if (!this.expression2.type.isStringType()) {
                        env.printError(rhs, "incompatible types: " + this.expression2.type +
                             " cannot be converted to " + this.expression1.type);
                    }
                } else {
                    checkNumericType(lhs, this.expression1.type);
                    checkNumericType(rhs, this.expression2.type);
                }
                this.type = TypeDefinition.BOOLEAN_TYPE;
            }
            else if (this.operator.equals("%") || this.operator.equals("<<") ||
                    this.operator.equals(">>") || this.operator.equals("&") ||
                    this.operator.equals("^") || this.operator.equals("|")) {
                checkIntegralType(lhs, this.expression1.type);
                checkIntegralType(rhs, this.expression2.type);
                this.type = promoteNumericType(this.expression1, this.expression2);
            }
            else if (this.operator.equals("&&") || this.operator.equals("||")) {
                checkBooleanType(lhs, this.expression1.type);
                checkBooleanType(rhs, this.expression2.type);
                this.type = this.expression1.type;
            }
            else if (this.operator.equals("==") || this.operator.equals("!=")) {
                if (!(TypeUtils.isCompatibleRO(this.expression1.type, this.expression2) ||
                      TypeUtils.isCompatibleRO(this.expression2.type, this.expression1))) {
                    if (!(TypeUtils.isInterface(this.expression1.type) &&
                          TypeUtils.isInterface(this.expression2.type))) {
                        env.printError(rhs, "incompatible types: " + this.expression1.type +
                                " cannot be compared to " + this.expression2.type);
                    }
                }
                this.type = TypeDefinition.BOOLEAN_TYPE;
            }
        }
        LiteralUtils.foldBinaryOp(this);
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
        if (this.expression1.type.isStringType()) {
            checkRequiredType(expr, TypeDefinition.INT_TYPE, this.expression2);
            this.type = TypeDefinition.BYTE_TYPE;
            return;
        }
        if (this.expression1.type.arrayOf == null) {
            env.printError(expr, "array required, but " + this.expression1.type + " found");
            return;
        }
        TypeDefinition keyType = this.expression1.type.keyType;
        if (keyType == null) {
            keyType = TypeDefinition.INT_TYPE;
        }
        checkRequiredType(expr, keyType, this.expression2);
        this.type = this.expression1.type.arrayOf;
    }

    void evaluateFunctionCall(ExpressionContext expr, ExpressionListContext argumentList) {
        this.expressionType = ExpressionType.FUNCTION_CALL;
        Environment env = Environment.getInstance();
        ExpressionDefinition methodExpr = new ExpressionDefinition();
        this.expression1 = methodExpr;
        methodExpr.evaluate(expr);
        if (methodExpr.type == null) {
            return;
        }
        if (methodExpr.method == null) {
            env.printError(expr, "expression of type " + methodExpr.type +
                    " cannot be called as a function");
            return;
        }
        if (methodExpr.method.isOverloaded) {
            ClassDefinition classdef = methodExpr.getAccessedClass();
            if (classdef != null) {
                int numArgs = argumentList == null ? 0 : argumentList.expression().size();
                methodExpr.method = classdef.getMethod(methodExpr.method.name, numArgs);
            }
        }
        evaluateFunctionArguments(expr, methodExpr.method, argumentList);
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
            checkRequiredType(exprList.expression(idx), param.type, this.argList[idx]);
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
        if (TypeUtils.isCompatible(exprdef2.type, exprdef3)) {
            this.type = exprdef2.type;
        }
        else if (TypeUtils.isCompatible(exprdef3.type, exprdef2)) {
            this.type = exprdef3.type;
        }
        else {
            Environment env = Environment.getInstance();
            env.printError(expr2, "incompatible types: " + exprdef2.type + " and " +
                    exprdef3.type);
        }
    }

    public boolean isMapAccess() {
        return this.expressionType == ExpressionType.ARRAY_ACCESS &&
                this.expression1.type.keyType != null;
    }

    void evaluateSuperDotMethod(ExpressionContext ctx) {
        Environment env = Environment.getInstance();
        ClassDefinition classdef = env.currentClass.superclass;
        if (classdef == null) {
            String name = env.currentClass.qualifiedName();
            env.printError(ctx, "class " + name + " has no superclass");
            return;
        }
        this.expressionType = ExpressionType.SUPER_DOT_METHOD;
        this.type = TypeDefinition.METHOD_TYPE;
        this.name = ctx.Identifier().getText();
        this.method = classdef.getMethod(this.name, null);
        if (this.method == null) {
            env.printError(ctx, "class " + classdef.qualifiedName() +
                    " does not have field " + this.name);
            return;
        }
        if (this.method.isPrivate) {
            env.printError(ctx, "class " + classdef.qualifiedName() + " method " +
                    this.name + " is private");
            return;
        }
        while (!this.method.hasBody()) {
            this.method = null;
            if (classdef.superclass != null) {
                classdef = classdef.superclass;
                this.method = classdef.getMethod(this.name, null);
            }
            if (this.method == null || this.method.isPrivate) {
                env.printError(ctx, "method super." + this.name + " not defined");
                return;
            }
        }
        this.expression1 = new ExpressionDefinition();
        this.expression1.type = classdef.toTypeDefinition();
        this.isStatic = this.method.isStatic;
        if (env.currentMethod.isStatic && !this.isStatic) {
            env.printError(ctx, "'super' method cannot be referenced from a static method");
        }
    }

    void evaluateAnonymousCreator(AnonymousClassBodyContext creator) {
        Environment env = Environment.getInstance();
        ClassDefinition parentClass = env.currentClass;
        this.expressionType = ExpressionType.NEW_INSTANCE;
        ClassDefinition classdef = new ClassDefinition();
        classdef.packageName = env.currentPackage;
        parentClass.anonymousCount++;
        classdef.name = parentClass.name + "__" + parentClass.anonymousCount;
        classdef.classPackageMap = new TreeMap<>();
        classdef.classPackageMap.putAll(env.classPackageMap);
        classdef.isAnonymous = true;
        List<String> fieldList = new ArrayList<>();
        List<ExpressionDefinition> valueList = new ArrayList<>();
        for (AnonymousClassBodyDeclarationContext decl : creator.anonymousClassBodyDeclaration()) {
            if (decl.classBodyDeclaration() != null) {
                classdef.parseClassBodyDeclaration(decl.classBodyDeclaration());
            } else if (decl.Identifier() != null) {
                String name = decl.Identifier().getText();
                ExpressionDefinition expression = new ExpressionDefinition();
                expression.evaluate(decl.expression());
                if (expression.type != null) {
                    classdef.addPublicField(decl, name, expression.type);
                    fieldList.add(name);
                    valueList.add(expression);
                }
            }
        }
        env.classList.add(classdef);
        classdef.evaluateConstants();
        MethodDefinition parentMethod = env.currentMethod;
        classdef.evaluate();
        env.currentMethod = parentMethod;
        env.currentClass = parentClass;
        this.type = classdef.toTypeDefinition();
        this.fieldList = fieldList.toArray(new String[0]);
        this.argList = valueList.toArray(new ExpressionDefinition[0]);
    }

    void evaluateTypeCast(ScalarTypeContext classCtx, ExpressionContext ctx) {
        Environment env = Environment.getInstance();
        this.type = new TypeDefinition();
        this.type.parse(classCtx);
        this.expressionType = ExpressionType.TYPE_CAST;
        this.expression1 = new ExpressionDefinition();
        this.expression1.evaluate(ctx);
        if (this.expression1.type == null) {
            return;
        }
        if (this.type.isPrimitiveType) {
            if (!(this.type.isNumericType() && this.expression1.type.isNumericType())) {
                env.printError(classCtx, "incompatible types: cast must be numeric");
            }
            return;
        }
        ClassDefinition classdef = env.loadClassDefinition(this.type);
        if (classdef == null) {
            env.printError(classCtx, "class " + this.type + " undefined");
            return;
        }
        if (classdef.isInterface || classdef.isAbstract) {
            env.printError(classCtx, "cannot cast to " + this.type +
                    " because it is not concrete");
            return;
        }
        ClassDefinition interfaceDef = env.loadClassDefinition(this.expression1.type);
        if (interfaceDef == null) {
            env.printError(classCtx, "class " + this.expression1.type + " undefined");
            return;
        }
        if (!interfaceDef.isInterface) {
            env.printError(classCtx, "cannot cast " + this.expression1.type +
                    " because it is not an interface");
            return;
        }
        if (!TypeUtils.isInterfaceImplemented(interfaceDef, classdef)) {
            env.printError(classCtx, "class " + classdef + " does not implement " + interfaceDef);
        }
    }

    void evaluateArrayDefinition(ArrayDefinitionContext ctx) {
        Environment env = Environment.getInstance();
        this.expressionType = ExpressionType.NEW_ARRAY_WITH_VALUES;
        TypeDefinition reqType = null;
        if (ctx.expressionList() == null) {
            env.printError(ctx, "empty array type cannot be determined");
            return;
        }
        List<ExpressionContext> exprList = ctx.expressionList().expression();
        this.argList = new ExpressionDefinition[exprList.size()];
        boolean haveNull = false;
        for (int idx = 0; idx < this.argList.length; idx++) {
            ExpressionContext ec = exprList.get(idx);
            ExpressionDefinition arg = new ExpressionDefinition();
            arg.evaluate(ec);
            if (arg.type == null) {
                return;
            }
            this.argList[idx] = arg;
            if (arg.type.isNullType()) {
                haveNull = true;
                continue;
            }
            if (reqType == null) {
                if (arg.type.isVoidType() || arg.type.equals(TypeDefinition.METHOD_TYPE)) {
                    env.printError(ec, "type " + arg.type + " not legal array type");
                    return;
                }
                reqType = arg.type;
            } else if (!reqType.equals(arg.type)) {
                env.printError(ec, "array type is " + reqType + ", arg type is " + arg.type);
                return;
            }
        }
        if (reqType == null) {
            env.printError(ctx, "array type cannot be determined");
            return;
        }
        if (reqType.isPrimitiveType && haveNull) {
            env.printError(ctx, "array type is " + reqType + ", arg type is null");
            return;
        }
        this.type = new TypeDefinition();
        this.type.arrayOf = reqType;
    }

    void evaluateMapDefinition(MapDefinitionContext ctx) {
        Environment env = Environment.getInstance();
        this.expressionType = ExpressionType.NEW_MAP;
        TypeDefinition keyType = null;
        TypeDefinition valueType = null;
        List<MapEntryContext> entryList = ctx.mapEntry();
        if (entryList == null || entryList.isEmpty()) {
            env.printError(ctx, "empty map type cannot be determined");
            return;
        }
        this.argList = new ExpressionDefinition[entryList.size()];
        for (int idx = 0; idx < this.argList.length; idx++) {
            MapEntryContext entry = entryList.get(idx);
            ExpressionDefinition arg = new ExpressionDefinition();
            arg.expression1 = new ExpressionDefinition();
            arg.expression1.evaluate(entry.expression(0));
            arg.expression2 = new ExpressionDefinition();
            arg.expression2.evaluate(entry.expression(1));
            if (arg.expression1.type == null || arg.expression2.type == null) {
                return;
            }
            if (keyType == null) {
                keyType = arg.expression1.type;
                checkMapKeyType(entry.expression(0), keyType);
            } else {
                checkRequiredType(entry.expression(0), keyType, arg.expression1);
            }
            if (valueType == null) {
                valueType = arg.expression2.type;
                if (valueType.isVoidType() || valueType.isNullType() ||
                        valueType.equals(TypeDefinition.METHOD_TYPE)) {
                    env.printError(entry, "type " + valueType + " not legal array type");
                    return;
                }
            } else {
                checkRequiredType(entry, valueType, arg.expression2);
            }
            this.argList[idx] = arg;
        }
        this.type = new TypeDefinition();
        this.type.arrayOf = valueType;
        this.type.keyType = keyType;
    }
}
