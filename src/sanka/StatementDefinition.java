package sanka;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.ClassDefinition.FieldDefinition;
import sanka.ExpressionDefinition.ExpressionType;
import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser.AssignableContext;
import sanka.antlr4.SankaParser.BlockContext;
import sanka.antlr4.SankaParser.EnhancedForControlContext;
import sanka.antlr4.SankaParser.ExpressionContext;
import sanka.antlr4.SankaParser.ForControlContext;
import sanka.antlr4.SankaParser.ForIncrementContext;
import sanka.antlr4.SankaParser.ForInitContext;
import sanka.antlr4.SankaParser.IfStatementContext;
import sanka.antlr4.SankaParser.StatementContext;
import sanka.antlr4.SankaParser.VariableAssignmentContext;
import sanka.antlr4.SankaParser.VariableDeclarationContext;

public class StatementDefinition {

    public static enum StatementType {
        DECLARATION, ASSIGNMENT, INC, DEC, IF, WHILE, FOR, ENHANCED_FOR, SWITCH, CASE, DEFAULT,
        RETURN, BREAK, CONTINUE, EXPRESSION, SEMI, C__STMT, BLOCK
    }

    public StatementType statementType;
    public ExpressionDefinition lhsExpression;
    public String name;
    public ExpressionDefinition expression;
    public BlockDefinition block;
    public BlockDefinition elseBlock;
    public StatementDefinition[] forStatements;
    public String valueName;

    /**
     * Pass 2 (of 3): Evaluate the statement. Calculate the type of all expressions
     * in the statement, and report compile-time errors.
     */
    void evaluate(StatementContext ctx) {
        Environment env = Environment.getInstance();
        int lexerType = ctx.getStart().getType();
        if (ctx.variableDeclaration() != null) {
            evaluateVariableDeclaration(ctx.variableDeclaration());
            return;
        }
        if (ctx.variableAssignment() != null) {
            evaluateVariableAssignment(ctx.variableAssignment());
            return;
        }
        if (ctx.switchLabel() != null) {
            if (ctx.switchLabel().expression() != null) {
                this.statementType = StatementType.CASE;
                this.expression = new ExpressionDefinition();
                this.expression.evaluate(ctx.switchLabel().expression());
                if (this.expression.type != null && this.expression.value == null) {
                    env.printError(ctx, "constant expression required");
                }
            } else if (ctx.switchLabel().typeType() != null) {
                // TODO this.statementType = StatementType.TYPECASE ?
                this.expression = new ExpressionDefinition();
                this.expression.type = new TypeDefinition();
                this.expression.type.parse(ctx.switchLabel().typeType());
                this.name = ctx.switchLabel().Identifier().getText();
                verifyVariableNotDefined(ctx.switchLabel(), this.name);
                env.symbolTable.put(this.name, this.expression.type);
            } else {
                this.statementType = StatementType.DEFAULT;
            }
            return;
        }
        if (ctx.getChildCount() == 2) {
            ParseTree child0 = ctx.getChild(0);
            ParseTree child1 = ctx.getChild(1);
            if (child0 instanceof ExpressionContext && child1 instanceof TerminalNode) {
                evaluateExpressionStatement((ExpressionContext) child0);
                if (!child1.getText().equals(";")) {
                    env.printError(ctx, "unrecognized statement");
                }
                return;
            }
        }
        if (ctx.ifStatement() != null) {
            evaluateIf(ctx.ifStatement());
            return;
        }
        switch (lexerType) {
        case SankaLexer.WHILE:
            this.statementType = StatementType.WHILE;
            evaluateBooleanExpression(ctx.parExpression().expression());
            this.block = new BlockDefinition();
            this.block.evaluate(ctx.block());
            return;
        case SankaLexer.FOR:
            evaluateFor(ctx.forControl(), ctx.block());
            return;
        case SankaLexer.SWITCH:
            evaluateSwitch(ctx);
            return;
        case SankaLexer.RETURN:
            this.statementType = StatementType.RETURN;
            if (ctx.expression() == null) {
                TypeDefinition desired = env.currentMethod.returnType;
                if (!desired.isVoidType()) {
                    env.printError(ctx, "incompatible types: missing return value " +
                            "of type " + desired);
                }
                return;
            }
            this.expression = new ExpressionDefinition();
            this.expression.evaluate(ctx.expression());
            if (this.expression.type != null) {
                TypeDefinition desired = env.currentMethod.returnType;
                if (!TypeUtils.isCompatible(desired, this.expression)) {
                    env.printError(ctx, "incompatible types: " + this.expression.type +
                            " cannot be converted to " + desired);
                }
            }
            return;
        case SankaLexer.BREAK:
            this.statementType = StatementType.BREAK;
            return;
        case SankaLexer.CONTINUE:
            this.statementType = StatementType.CONTINUE;
            return;
        case SankaLexer.SEMI:
            this.statementType = StatementType.SEMI;
            return;
        case SankaLexer.C__STMT:
            this.statementType = StatementType.C__STMT;
            String literal = ctx.StringLiteral().getText();
            this.name = LiteralUtils.evaluateStringLiteral(literal);
            this.expression = new ExpressionDefinition();
            this.expression.type = env.currentClass.toTypeDefinition();
            return;
        }
        if (ctx.block() != null) {
            this.statementType = StatementType.BLOCK;
            this.block = new BlockDefinition();
            this.block.evaluate(ctx.block());
            return;
        }
        env.printError(ctx, "unrecognized statement");
    }

    /**
     * Evaluate a variable declaration statement.
     */
    void evaluateVariableDeclaration(VariableDeclarationContext vc) {
        Environment env = Environment.getInstance();
        this.statementType = StatementType.DECLARATION;
        this.name = vc.Identifier().getText();
        verifyVariableNotDefined(vc, this.name);
        if (vc.expression() == null) {
            env.symbolTable.put(this.name, TypeDefinition.NULL_TYPE);
        } else {
            this.expression = new ExpressionDefinition();
            this.expression.evaluate(vc.expression());
            if (this.expression.type != null) {
                if (this.expression.type.isVoidType()) {
                    env.printError(vc, "variable may not have type void");
                }
            }
            env.symbolTable.put(this.name, this.expression.type);
        }
    }

    void verifyVariableNotDefined(ParserRuleContext ctx, String name) {
        Environment env = Environment.getInstance();
        if (env.symbolTable.get(name) != null) {
            env.printError(ctx, "variable " + this.name + " is already defined");
        }
    }

    /**
     * Evaluate a variable assignment statement.
     */
    void evaluateVariableAssignment(VariableAssignmentContext assignment) {
        Environment env = Environment.getInstance();
        String operator = ((TerminalNode) assignment.getChild(1)).getSymbol().getText();
        if (operator.equals("=")) {
            this.statementType = StatementType.ASSIGNMENT;
        } else if (operator.equals("++")) {
            this.statementType = StatementType.INC;
        } else if (operator.equals("--")) {
            this.statementType = StatementType.DEC;
        } else {
            env.printError(assignment, "unrecognized variable assignment statement");
        }
        if (assignment.expression() != null) {
            this.expression = new ExpressionDefinition();
            this.expression.evaluate(assignment.expression());
            if (this.expression.type == null) {
                return;
            }
        }
        TypeDefinition lhsType = null;
        AssignableContext assignable = assignment.assignable();
        if (assignable.Identifier() == null) {
            // The LHS is made of two expressions: The array and index.
            // Read them into a single ExpressionDefinition.
            this.lhsExpression = new ExpressionDefinition();
            this.lhsExpression.evaluateArrayAccess(assignable.expression(0),
                    assignable.expression(1));
            lhsType = this.lhsExpression.type;
            TypeDefinition containerType = this.lhsExpression.expression1.type;
            if (containerType != null && containerType.isStringType()) {
                env.printError(assignable, "String instance cannot be modified");
                return;
            }
        }
        else if (assignable.expression(0) != null) {
            // The LHS is made of two expressions: The context and field.
            // Read them into a single ExpressionDefinition.
            this.lhsExpression = new ExpressionDefinition();
            this.lhsExpression.evaluateFieldAccess(assignable.expression(0),
                    assignable.Identifier());
            lhsType = this.lhsExpression.type;
        }
        else {
            this.name = assignable.Identifier().getText();
            lhsType = env.symbolTable.get(this.name);
            if (lhsType == null) {
                FieldDefinition fielddef = env.currentClass.getField(this.name);
                if (fielddef == null || !fielddef.isStatic || fielddef.isConst) {
                    env.printError(assignment, "variable " + this.name + " undefined");
                    return;
                }
                this.lhsExpression = new ExpressionDefinition();
                this.lhsExpression.expressionType = ExpressionType.FIELD_ACCESS;
                this.lhsExpression.type = fielddef.type;
                this.lhsExpression.name = this.name;
                this.lhsExpression.expression1 = new ExpressionDefinition();
                this.lhsExpression.expression1.evaluateThisClass();
                this.lhsExpression.isStatic = true;
                lhsType = fielddef.type;
            }
            if (this.statementType == StatementType.ASSIGNMENT && lhsType.isNullType()) {
                lhsType = this.expression.type;
                env.symbolTable.promote(this.name, lhsType);
            }
        }
        if (lhsType == null) {
            return;
        }
        if (this.statementType == StatementType.ASSIGNMENT) {
            if (!TypeUtils.isCompatible(lhsType, this.expression)) {
                env.printError(assignment, "incompatible types: " + this.expression.type +
                        " cannot be converted to " + lhsType);
                return;
            }
        } else {
            if (!lhsType.isIntegralType()) {
                env.printError(assignment, "incompatible types: " + lhsType +
                        " cannot be incremented");
                return;
            }
        }
    }

    /**
     * Evaluate an expression as a standalone statement.
     */
    void evaluateExpressionStatement(ExpressionContext expr) {
        this.statementType = StatementType.EXPRESSION;
        this.expression = new ExpressionDefinition();
        this.expression.evaluate(expr);
    }

    /**
     * Check the clause of an "if", "while", or "for" statement.
     */
    void evaluateBooleanExpression(ExpressionContext exprCtx) {
        Environment env = Environment.getInstance();
        this.expression = new ExpressionDefinition();
        this.expression.evaluate(exprCtx);
        if (this.expression.type != null && !this.expression.type.isBooleanType()) {
            env.printError(exprCtx, "incompatible types: " + this.expression.type +
                    " cannot be converted to boolean");
        }
    }

    /**
     * Evaluate an "if" statement.
     */
    void evaluateIf(IfStatementContext ictx) {
        this.statementType = StatementType.IF;
        evaluateBooleanExpression(ictx.parExpression().expression());
        this.block = new BlockDefinition();
        this.block.evaluate(ictx.block());
        if (ictx.elseStatement() != null) {
            this.elseBlock = new BlockDefinition();
            if (ictx.elseStatement().block() != null) {
                this.elseBlock.evaluate(ictx.elseStatement().block());
            } else {
                this.elseBlock.evaluate(ictx.elseStatement().ifStatement());
            }
        }
    }

    /**
     * Evaluate a "for" statement.
     */
    void evaluateFor(ForControlContext forControl, BlockContext blockCtx) {
        if (forControl.enhancedForControl() != null) {
            evaluateEnhancedFor(forControl.enhancedForControl());
        } else {
            evaluateClassicFor(forControl);
        }
        this.block = new BlockDefinition();
        this.block.evaluate(blockCtx);
    }

    void evaluateEnhancedFor(EnhancedForControlContext forControl) {
        this.statementType = StatementType.ENHANCED_FOR;
        Environment env = Environment.getInstance();
        List<TerminalNode> vars = forControl.Identifier();
        this.name = vars.get(0).getText();
        verifyVariableNotDefined(forControl, this.name);
        if (vars.size() > 1) {
            this.valueName = vars.get(1).getText();
            verifyVariableNotDefined(forControl, this.valueName);
        }
        this.expression = new ExpressionDefinition();
        this.expression.evaluate(forControl.expression());
        TypeDefinition type = null;
        TypeDefinition valueType = null;
        if (this.expression.type != null) {
            if (this.expression.type.keyType != null) {
                type = this.expression.type.keyType;
                valueType = this.expression.type.arrayOf;
            } else if (this.expression.type.arrayOf != null) {
                type = this.expression.type.arrayOf;
            } else if (this.expression.type.isStringType()) {
                type = TypeDefinition.BYTE_TYPE;
            } else {
                env.printError(forControl, "can only iterate over array, map, or string");
            }
            if (this.valueName != null && type != null && valueType == null) {
                env.printError(forControl, "only specify one variable " +
                        "to iterate over " + type);
            }
        }
        env.symbolTable.put(this.name, type);
        if (this.valueName != null) {
            env.symbolTable.put(this.valueName, valueType);
        }
    }

    void evaluateClassicFor(ForControlContext forControl) {
        this.statementType = StatementType.FOR;
        this.forStatements = new StatementDefinition[2];
        ForInitContext forInit = forControl.forInit();
        if (forInit != null) {
            this.forStatements[0] = new StatementDefinition();
            if (forInit.variableDeclaration() != null) {
                this.forStatements[0].evaluateVariableDeclaration(forInit.variableDeclaration());
            }
            else if (forInit.variableAssignment() != null) {
                this.forStatements[0].evaluateVariableAssignment(forInit.variableAssignment());
            }
            else if (forInit.expression() != null) {
                this.forStatements[0].evaluateExpressionStatement(forInit.expression());
            }
        }
        evaluateBooleanExpression(forControl.expression());
        ForIncrementContext forIncrement = forControl.forIncrement();
        if (forIncrement != null) {
            this.forStatements[1] = new StatementDefinition();
            if (forIncrement.variableAssignment() != null) {
                this.forStatements[1].evaluateVariableAssignment(forIncrement.variableAssignment());
            }
            else if (forIncrement.expression() != null) {
                this.forStatements[1].evaluateExpressionStatement(forIncrement.expression());
            }
        }
    }

    /**
     * Evaluate a "switch" block with labels and statements.
     */
    void evaluateSwitch(StatementContext ctx) {
        Environment env = Environment.getInstance();
        this.statementType = StatementType.SWITCH;
        this.expression = new ExpressionDefinition();
        this.expression.evaluate(ctx.parExpression().expression());
        TypeDefinition type = this.expression.type;
        boolean isInterface = false;
        if (type != null && !(type.isIntegralType() || type.isStringType())) {
            ClassDefinition classdef = env.getClassDefinition(type);
            isInterface = classdef != null && classdef.isInterface;
            if (!isInterface) {
                env.printError(ctx, "incompatible types: switch statement must use " +
                        "integral type or String or interface");
            }
        }
        this.block = new BlockDefinition();
        this.block.evaluate(ctx.block());
        if (this.expression.type == null) {
            return;
        }
        if (this.block.block.length == 0) {
            return;
        }
        StatementDefinition first = this.block.block[0];
        if (first.statementType != StatementType.CASE &&
            first.statementType != StatementType.DEFAULT) {
            env.printError(ctx, "switch block must begin with a case statement");
            return;
        }
        Set<String> labels = new TreeSet<>();
        boolean haveDefault = false;
        for (StatementDefinition item : this.block.block) {
            // Approve the "case" statements that are directly in the block. This is not
            // recursive. You cannot have a "case" statement inside an "if" statement.
            if (item.statementType == StatementType.CASE && item.expression.type != null) {
                item.valueName = "approved";
                if (isInterface) {
                    if (item.name == null) {
                        env.printError(ctx, "case statement must include variable declaration");
                    }
                    continue;
                }
                if (item.name != null) {
                    env.printError(ctx, "case statement must include constant " +
                            this.expression.type);
                    continue;
                }
                if (item.expression.value != null && !labels.add(item.expression.value)) {
                    env.printError(ctx, "duplicate case label: " + item.expression.value);
                }
                if (!TypeUtils.isCompatible(this.expression.type, item.expression)) {
                    env.printError(ctx, "incompatible types: " + item.expression.type +
                            " cannot be converted to " + this.expression.type);
                }
            }
            else if (item.statementType == StatementType.DEFAULT) {
                if (haveDefault) {
                    env.printError(ctx, "duplicate default label");
                }
                haveDefault = true;
                item.valueName = "approved";
            }
        }
    }
}
