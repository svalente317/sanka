package sanka;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.ClassDefinition.FieldDefinition;
import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser.AssignableContext;
import sanka.antlr4.SankaParser.BlockContext;
import sanka.antlr4.SankaParser.ExpressionContext;
import sanka.antlr4.SankaParser.ForControlContext;
import sanka.antlr4.SankaParser.ForIncrementContext;
import sanka.antlr4.SankaParser.ForInitContext;
import sanka.antlr4.SankaParser.StatementContext;
import sanka.antlr4.SankaParser.VariableAssignmentContext;
import sanka.antlr4.SankaParser.VariableDeclarationContext;

public class StatementDefinition {

    StatementContext ctx;
    int statementType;
    ExpressionDefinition lhsExpression;
    String name;
    ExpressionDefinition expression;
    BlockDefinition block;
    BlockDefinition elseBlock;
    StatementDefinition[] forStatements;

    void parse(StatementContext ctx) {
        this.ctx = ctx;
    }

    void evaluate(StatementContext ctx) {
        this.ctx = ctx;
        evaluate();
    }

    void evaluate() {
        Environment env = Environment.getInstance();
        this.statementType = this.ctx.getStart().getType();
        if (this.ctx.constDeclaration() != null) {
            this.statementType = SankaLexer.CONST;
            env.printError(this.ctx, "const support not implemented");
            return;
        }
        if (this.ctx.variableDeclaration() != null) {
            evaluateVariableDeclaration(this.ctx.variableDeclaration());
            return;
        }
        if (this.ctx.variableAssignment() != null) {
            evaluateVariableAssignment(this.ctx.variableAssignment());
            return;
        }
        if (this.ctx.getChildCount() == 2) {
            ParseTree child0 = this.ctx.getChild(0);
            ParseTree child1 = this.ctx.getChild(1);
            if (child0 instanceof ExpressionContext && child1 instanceof TerminalNode) {
                evaluateExpressionStatement((ExpressionContext) child0);
                if (!child1.getText().equals(";")) {
                    env.printError(this.ctx, "unrecognized statement");
                }
                return;
            }
        }
        switch (this.statementType) {
        case SankaLexer.IF:
            evaluateBooleanExpression(this.ctx.parExpression().expression());
            this.block = new BlockDefinition();
            this.block.evaluate(this.ctx.block(0));
            if (this.ctx.block(1) != null) {
                this.elseBlock = new BlockDefinition();
                this.elseBlock.evaluate(this.ctx.block(1));
            }
            return;
        case SankaLexer.WHILE:
            evaluateBooleanExpression(this.ctx.parExpression().expression());
            this.block = new BlockDefinition();
            this.block.evaluate(this.ctx.block(0));
            return;
        case SankaLexer.FOR:
            evaluateFor(this.ctx.forControl(), this.ctx.block(0));
            return;
        case SankaLexer.SWITCH:
            env.printError(this.ctx, "switch support not implemented");
            return;
        case SankaLexer.RETURN:
            if (this.ctx.expression() == null) {
                TypeDefinition desired = env.currentMethod.returnType;
                if (!desired.isVoidType()) {
                    env.printError(this.ctx, "method must return a value of type " + desired);
                }
                return;
            }
            this.expression = new ExpressionDefinition();
            this.expression.evaluate(this.ctx.expression());
            if (this.expression.type != null) {
                TypeDefinition desired = env.currentMethod.returnType;
                if (!desired.isCompatible(this.expression.type)) {
                    env.printError(this.ctx, "incompatible types: " + this.expression.type +
                            " cannot be converted to " + desired);
                }
            }
            return;
        case SankaLexer.BREAK:
        case SankaLexer.CONTINUE:
        case SankaLexer.SEMI:
            return;
        }
        if (this.ctx.block(0) != null) {
            this.statementType = SankaLexer.LBRACE;
            this.block = new BlockDefinition();
            this.block.evaluate(this.ctx.block(0));
            return;
        }
        env.printError(this.ctx, "unrecognized statement");
    }

    /**
     * Evaluate a variable declaration statement.
     */
    void evaluateVariableDeclaration(VariableDeclarationContext vc) {
        Environment env = Environment.getInstance();
        this.statementType = SankaLexer.VAR;
        this.name = vc.Identifier().getText();
        if (env.symbolTable.get(this.name) != null) {
            env.printError(vc, "variable " + this.name + " declared twice");
        }
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

    /**
     * Evaluate a variable assignment statement.
     */
    void evaluateVariableAssignment(VariableAssignmentContext assignment) {
        Environment env = Environment.getInstance();
        String operator = ((TerminalNode) assignment.getChild(1)).getSymbol().getText();
        if (operator.equals("=")) {
            this.statementType = SankaLexer.EQUAL;
        } else if (operator.equals("++")) {
            this.statementType = SankaLexer.INC;
        } else if (operator.equals("--")) {
            this.statementType = SankaLexer.DEC;
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
        AssignableContext assignable = assignment.assignable();
        if (assignable.Identifier() == null) {
            // The LHS is made of two expressions: The array and index.
            // Read them into a single ExpressionDefinition.
            this.lhsExpression = new ExpressionDefinition();
            this.lhsExpression.evaluateArrayAccess(assignable.expression(0),
                    assignable.expression(1));
            return;
        }
        this.name = assignable.Identifier().getText();
        if (assignable.expression(0) != null) {
            this.lhsExpression = new ExpressionDefinition();
            this.lhsExpression.evaluate(assignable.expression(0));
            TypeDefinition type = this.lhsExpression.type;
            if (type == null) {
                return;
            }
            if (type.arrayCount > 0) {
                env.printError(assignment, "array type " + type +
                        ": cannot modify fields (" + this.name + ")");
                return;
            }
            if (type.isPrimitiveType) {
                env.printError(assignment, "primitive type " + type +
                        ": cannot modify fields (" + this.name + ")");
                return;
            }
            ClassDefinition classdef = env.getClassDefinition(type);
            if (classdef == null) {
                env.printError(assignment, "class " + type + " undefined");
                return;
            }
            FieldDefinition fielddef = classdef.fieldMap.get(this.name);
            if (fielddef == null) {
                env.printError(assignment, "class " + type + " does not have field " + this.name);
                return;
            }
            if (fielddef.isPrivate && classdef != env.currentClass) {
                env.printError(assignment, "class " + type + " field " + this.name +
                        " is private");
            }
            if (this.statementType == SankaLexer.EQUAL) {
                if (!fielddef.type.isCompatible(this.expression.type)) {
                    env.printError(assignment, "incompatible types: " + this.expression.type +
                            " cannot be converted to " + fielddef.type);
                    return;
                }
            } else {
                if (!fielddef.type.isIntegralType()) {
                    env.printError(assignment, "incompatible types: " + fielddef.type +
                            " cannot be incremented");
                    return;
                }
            }
            // Ok, we allow this field assignment.
            return;
        }
        TypeDefinition varType = env.symbolTable.get(this.name);
        if (varType == null) {
            env.printError(assignment, "variable " + this.name + " undefined");
            return;
        }
        if (this.statementType == SankaLexer.EQUAL) {
            if (varType.isNullType()) {
                varType = this.expression.type;
                env.symbolTable.promote(this.name, varType);
            }
            if (!varType.isCompatible(this.expression.type)) {
                env.printError(assignment, "incompatible types: " + this.expression.type +
                        " cannot be converted to " + varType);
                return;
            }
        } else {
            if (!varType.isIntegralType()) {
                env.printError(assignment, "incompatible types: " + varType +
                        " cannot be incremented");
                return;
            }
        }
        // Ok, we allow this variable assignment.
        return;
    }

    /**
     * Evaluate an expression as a standalone statement. Use BOOLEAN as the statement type simply because
     * it's a constant that's available for usage.
     */
    void evaluateExpressionStatement(ExpressionContext expr) {
        this.statementType = SankaLexer.BOOLEAN;
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
     * Evaluate a "for" statement.
     */
    void evaluateFor(ForControlContext forControl, BlockContext blockCtx) {
        if (forControl.enhancedForControl() != null) {
            return;
        }
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
        this.block = new BlockDefinition();
        this.block.evaluate(blockCtx);
    }

    /**
     * Pass 3 (of 3). Generate C code for the evaluated statements and expressions.
     */
    void translate() {
        Environment env = Environment.getInstance();
        StringBuilder builder;
        String text;
        switch (this.statementType) {
        case SankaLexer.CONST:
            break;
        case SankaLexer.VAR:
            builder = new StringBuilder();
            if (this.expression == null) {
                TypeDefinition type = env.symbolTable.get(this.name);
                if (type != null && !type.isNullType()) {
                    env.addType(type);
                    builder.append(type.translateSpace());
                    builder.append(this.name);
                    builder.append(" = 0;");
                    env.print(builder.toString());
                }
                return;
            }
            env.addType(this.expression.type);
            builder.append(this.expression.type.translateSpace());
            builder.append(this.name);
            builder.append(";");
            env.print(builder.toString());
            text = this.expression.translate(this.name);
            if (!text.equals(this.name)) {
                builder.setLength(0);
                builder.append(this.name);
                builder.append(" = ");
                builder.append(text);
                builder.append(";");
                env.print(builder.toString());
            }
            return;
        case SankaLexer.LBRACE:
            this.block.translate(true);
            return;
        case SankaLexer.EQUAL:
        case SankaLexer.INC:
        case SankaLexer.DEC:
            builder = new StringBuilder();
            text = null;
            if (this.lhsExpression != null) {
                // Set builder to either "LHS[idx]" or "LHS->field".
                text = this.lhsExpression.translate(null);
                builder.append(text);
                if (this.name != null) {
                    if (!text.equals("this")) {
                        env.print("NULLCHECK(" + text + ");");
                    }
                    builder.append("->");
                    builder.append(this.name);
                }
                if (this.expression != null) {
                    text = this.expression.translate(null);
                }
            } else {
                // Try to directly write "var = value".
                if (this.expression != null) {
                    text = this.expression.translate(this.name);
                    if (text.equals(this.name)) {
                        return;
                    }
                }
                builder.append(this.name);
            }
            switch (this.statementType) {
            case SankaLexer.EQUAL:
                builder.append(" = ");
                builder.append(text);
                break;
            case SankaLexer.INC:
                builder.append("++");
                break;
            case SankaLexer.DEC:
                builder.append("--");
                break;
            }
            builder.append(";");
            env.print(builder.toString());
            return;
        case SankaLexer.IF:
        case SankaLexer.WHILE:
            builder = new StringBuilder();
            builder.append(this.statementType == SankaLexer.IF ? "if" : "while");
            builder.append(" (");
            builder.append(this.expression.translate(null));
            builder.append(") {");
            env.print(builder.toString());
            env.level++;
            this.block.translate(false);
            env.level--;
            if (this.statementType == SankaLexer.IF && this.elseBlock != null) {
                env.print("} else {");
                env.level++;
                this.elseBlock.translate(false);
                env.level--;
            }
            env.print("}");
            return;
        case SankaLexer.FOR:
            if (this.forStatements[0] != null) {
                this.forStatements[0].translate();
            }
            builder = new StringBuilder();
            builder.append("while (1) {");
            env.print(builder.toString());
            env.level++;
            builder.setLength(0);
            builder.append("if (!");
            builder.append(this.expression.translate(null));
            builder.append(") break;");
            env.print(builder.toString());
            this.block.translate(false);
            if (this.forStatements[1] != null) {
                this.forStatements[1].translate();
            }
            env.level--;
            env.print("}");
            return;
        case SankaLexer.SWITCH:
            break;
        case SankaLexer.RETURN:
            builder = new StringBuilder();
            builder.append("return");
            if (this.expression != null) {
                if (this.expression.type.isVoidType()) {
                    this.expression.translate(null);
                } else {
                    builder.append(" ");
                    builder.append(this.expression.translate(null));
                }
            }
            builder.append(";");
            env.print(builder.toString());
            break;
        case SankaLexer.BREAK:
            env.print("break;");
            break;
        case SankaLexer.CONTINUE:
            break;
        case SankaLexer.BOOLEAN:
            this.expression.translate(null);
            // Since the returned expression has no side-effects,
            // there's no reason to write it to the output stream.
            return;
        case SankaLexer.SEMI:
            env.print(";");
            return;
        }
    }
}
