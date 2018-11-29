package sanka;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

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

    int statementType;
    ExpressionDefinition lhsExpression;
    String name;
    ExpressionDefinition expression;
    BlockDefinition block;
    BlockDefinition elseBlock;
    StatementDefinition[] forStatements;
    String valueName;

    /**
     * Pass 2 (of 3): Evaluate the statement. Calculate the type of all expressions
     * in the statement, and report compile-time errors.
     */
    void evaluate(StatementContext ctx) {
        Environment env = Environment.getInstance();
        this.statementType = ctx.getStart().getType();
        if (ctx.constDeclaration() != null) {
            this.statementType = SankaLexer.CONST;
            env.printError(ctx, "const support not implemented");
            return;
        }
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
                this.statementType = SankaLexer.CASE;
                this.expression = new ExpressionDefinition();
                this.expression.evaluate(ctx.switchLabel().expression());
                if (this.expression.type != null &&
                    this.expression.expressionType != ExpressionType.LITERAL) {
                    env.printError(ctx, "constant expression required");
                }
            } else {
                this.statementType = SankaLexer.DEFAULT;
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
        switch (this.statementType) {
        case SankaLexer.WHILE:
            evaluateBooleanExpression(ctx.parExpression().expression());
            this.block = new BlockDefinition();
            this.block.evaluate(ctx.block());
            return;
        case SankaLexer.FOR:
            evaluateFor(ctx.forControl(), ctx.block());
            return;
        case SankaLexer.SWITCH:
            this.expression = new ExpressionDefinition();
            this.expression.evaluate(ctx.parExpression().expression());
            TypeDefinition type = this.expression.type;
            if (type != null && !(type.isIntegralType() || type.isStringType())) {
                env.printError(ctx, "incompatible types: switch statement must use " +
                        "integral type or String");
            }
            this.block = new BlockDefinition();
            this.block.evaluate(ctx.block());
            SwitchUtils.evaluateSwitchStatement(ctx, this);
            return;
        case SankaLexer.RETURN:
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
        case SankaLexer.CONTINUE:
        case SankaLexer.SEMI:
            return;
        case SankaLexer.C__STMT:
            String literal = ctx.StringLiteral().getText();
            this.name = LiteralUtils.evaluateStringLiteral(literal);
            return;
        }
        if (ctx.block() != null) {
            this.statementType = SankaLexer.LBRACE;
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
        this.statementType = SankaLexer.VAR;
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
            env.printError(ctx, "variable " + this.name + " is already defined in method " +
                    env.currentMethod.name + "()");
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
        TypeDefinition lhsType = null;
        AssignableContext assignable = assignment.assignable();
        if (assignable.Identifier() == null) {
            // The LHS is made of two expressions: The array and index.
            // Read them into a single ExpressionDefinition.
            this.lhsExpression = new ExpressionDefinition();
            this.lhsExpression.evaluateArrayAccess(assignable.expression(0),
                    assignable.expression(1));
            lhsType = this.lhsExpression.type;
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
                env.printError(assignment, "variable " + this.name + " undefined");
                return;
            }
            if (this.statementType == SankaLexer.EQUAL && lhsType.isNullType()) {
                lhsType = this.expression.type;
                env.symbolTable.promote(this.name, lhsType);
            }
        }
        if (lhsType == null) {
            return;
        }
        if (this.statementType == SankaLexer.EQUAL) {
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
     * Evaluate an expression as a standalone statement. Use BOOLEAN as the statement type
     * simply because it's a constant that's available for usage.
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
     * Evaluate an "if" statement.
     */
    void evaluateIf(IfStatementContext ictx) {
        this.statementType = SankaLexer.IF;
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
        this.statementType = SankaLexer.COLON;
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
            if (this.expression.type.arrayOf == null) {
                env.printError(forControl, "can only iterate over array or map");
            }
            else if (this.expression.type.keyType == null) {
                type = this.expression.type.arrayOf;
                if (this.valueName != null) {
                    env.printError(forControl, "only specify one variable " +
                            "to iterate over " + type);
                }
            }
            else {
                type = this.expression.type.keyType;
                valueType = this.expression.type.arrayOf;
            }
        }
        env.symbolTable.put(this.name, type);
        if (this.valueName != null) {
            env.symbolTable.put(this.valueName, valueType);
        }
    }

    void evaluateClassicFor(ForControlContext forControl) {
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
                if (this.lhsExpression.isMapAccess()) {
                    translateMapAssignment();
                    return;
                }
                // Set builder to either "LHS[idx]" or "LHS->field".
                builder.append(this.lhsExpression.translate(null));
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
            text = this.expression.translate(null);
            if (this.expression.expressionType != ExpressionType.BINARY || text.charAt(0) != '(') {
                text = "(" + text + ")";
            }
            env.print("if " + text);
            this.block.translate(true);
            if (this.elseBlock != null) {
                env.print("else");
                this.elseBlock.translate(true);
            }
            return;
        case SankaLexer.WHILE:
            env.print("while (1) {");
            env.level++;
            builder = new StringBuilder();
            builder.append("if (!");
            builder.append(this.expression.translate(null));
            builder.append(") break;");
            env.print(builder.toString());
            this.block.translate(false);
            env.level--;
            env.print("}");
            return;
        case SankaLexer.FOR:
            if (this.forStatements[0] != null) {
                this.forStatements[0].translate();
            }
            // Optimization TODO:
            // Generate different code for loops that don't use "continue".
            text = null;
            if (this.forStatements[1] != null) {
                text = env.getTmpVariable();
                env.print("int " + text + " = 0;");
            }
            env.print("while (1) {");
            env.level++;
            if (text != null) {
                env.print("if (" + text + " != 0) {");
                env.level++;
                this.forStatements[1].translate();
                env.level--;
                env.print("}");
                env.print(text + " = 1;");
            }
            builder = new StringBuilder();
            builder.append("if (!");
            builder.append(this.expression.translate(null));
            builder.append(") break;");
            env.print(builder.toString());
            this.block.translate(false);
            env.level--;
            env.print("}");
            return;
        case SankaLexer.COLON:
            TypeDefinition arrayType = this.expression.type;
            if (arrayType.keyType == null) {
                String arrayVar = env.getTmpVariable();
                env.print(arrayType.translateSpace() + arrayVar + ";");
                text = this.expression.translate(arrayVar);
                if (!text.equals(arrayVar)) {
                    env.print(arrayVar + " = " + text + ";");
                }
                env.print("NULLCHECK(" + arrayVar + ");");
                String indexVar = env.getTmpVariable();
                env.print("for (int " + indexVar + " = 0; " +
                        indexVar + " < " + arrayVar + "->length; " + indexVar + "++) {");
                env.level++;
                env.print(arrayType.arrayOf.translateSpace() + this.name + " = " +
                         "ARRCAST(" + arrayVar + ", " + arrayType.arrayOf.translate() +
                         ")[" + indexVar + "];");
                this.block.translate(false);
                env.level--;
                env.print("}");
                return;
            }
            String traverserVar = env.getTmpVariable();
            String keyVar = env.getTmpVariable();
            String valueVar = env.getTmpVariable();
            env.print("struct rb_traverser " + traverserVar + ";");
            env.print("union rb_key " + keyVar + ";");
            env.print("union rb_value " + valueVar + ";");
            String exprText = this.expression.translate(null);
            env.print("rb_t_init(&" + traverserVar + ", " + exprText + ");");
            env.print("while (rb_t_next(&" + traverserVar + ", &" + keyVar + ", &" +
                    valueVar + ")) {");
            env.level++;
            env.print(this.expression.type.keyType.translateSpace() + this.name + ";");
            String field = TranslationUtils.typeToMapKeyFieldName(this.expression.type.keyType);
            env.print(this.name +" = " + keyVar + "." + field + ";");
            if (this.valueName != null) {
                env.print(this.expression.type.arrayOf.translateSpace() + this.valueName + ";");
                field = TranslationUtils.typeToMapFieldName(this.expression.type.arrayOf);
                env.print(this.valueName + " = " + valueVar + "." + field + ";");
            }
            this.block.translate(false);
            env.level--;
            env.print("}");
            return;
        case SankaLexer.SWITCH:
            SwitchUtils.translateSwitchStatement(this);
            return;
        case SankaLexer.CASE:
            env.printError(null, "case statement must be inside a switch block");
            return;
        case SankaLexer.DEFAULT:
            env.printError(null, "default statement must be inside a switch block");
            return;
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
            return;
        case SankaLexer.BREAK:
            env.print("break;");
            return;
        case SankaLexer.CONTINUE:
            env.print("continue;");
            return;
        case SankaLexer.BOOLEAN:
            this.expression.translate(null);
            // Since the returned expression has no side-effects,
            // there's no reason to write it to the output stream.
            return;
        case SankaLexer.SEMI:
            env.print(";");
            return;
        case SankaLexer.C__STMT:
            env.print(this.name + ";");
            return;
        }
    }

    void translateMapAssignment() {
        Environment env = Environment.getInstance();
        ExpressionDefinition ts = this.lhsExpression;
        String text1 = ts.expression1.translate(null);
        String text2 = ts.expression2.translate(null);
        env.print("NULLCHECK(" + text1 + ");");
        if (ts.expression1.type.keyType.isStringType()) {
            env.print("NULLCHECK(" + text2 + ");");
        }
        String valueName = env.getTmpVariable();
        env.print("union rb_value " + valueName + ";");
        // TODO inc and dec
        String field = TranslationUtils.typeToMapFieldName(this.expression.type);
        env.print(valueName + "." + field + " = " + this.expression.translate(null) + ";");
        env.print("rb_put(" + text1 + ", (union rb_key) " + text2 + ", " + valueName + ", 0);");
    }
}
