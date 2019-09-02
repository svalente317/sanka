package sanka;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import sanka.ExpressionDefinition.ExpressionType;
import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser.StatementContext;

public class SwitchUtils {

    static void evaluateSwitchStatement(StatementContext ctx, StatementDefinition stmt,
            boolean isInterface) {
        Environment env = Environment.getInstance();
        if (stmt.expression.type == null) {
            return;
        }
        if (stmt.block.block.length == 0) {
            return;
        }
        StatementDefinition first = stmt.block.block[0];
        if (first.statementType != SankaLexer.CASE && first.statementType != SankaLexer.DEFAULT) {
            env.printError(ctx, "switch block must begin with a case statement");
            return;
        }
        Set<String> labels = new TreeSet<>();
        boolean haveDefault = false;
        for (StatementDefinition item : stmt.block.block) {
            // Approve the "case" statements that are directly in the block. This is not
            // recursive. You cannot have a "case" statement inside an "if" statement.
            if (item.statementType == SankaLexer.CASE && item.expression.type != null) {
                item.valueName = "approved";
                if (isInterface) {
                    if (item.name == null) {
                        env.printError(ctx, "case statement must include variable declaration");
                    }
                    continue;
                }
                if (item.name != null) {
                    env.printError(ctx, "case statement must include constant " +
                            stmt.expression.type);
                    continue;
                }
                if (item.expression.value != null && !labels.add(item.expression.value)) {
                    env.printError(ctx, "duplicate case label: " + item.expression.value);
                }
                if (!TypeUtils.isCompatible(stmt.expression.type, item.expression)) {
                    env.printError(ctx, "incompatible types: " + item.expression.type +
                            " cannot be converted to " + stmt.expression.type);
                }
            }
            else if (item.statementType == SankaLexer.DEFAULT) {
                if (haveDefault) {
                    env.printError(ctx, "duplicate default label");
                }
                haveDefault = true;
                item.valueName = "approved";
            }
        }
    }

    static void translateSwitchStatement(StatementDefinition stmt) {
        Environment env = Environment.getInstance();
        String exprText = null;
        if (stmt.expression.type.isStringType()) {
            exprText = env.getTmpVariable();
            List<String> labels = new ArrayList<>();
            for (StatementDefinition item : stmt.block.block) {
                if (item.statementType == SankaLexer.CASE) {
                    labels.add(item.expression.translate(null));
                    item.expression.expressionType = ExpressionType.LITERAL;
                    item.expression.type = TypeDefinition.INT_TYPE;
                    item.expression.name = null;
                    item.expression.value = Integer.toString(labels.size());
                }
            }
            String name = stmt.expression.translate(null);
            env.print("NULLCHECK(" + name + ");");
            env.print("int " + exprText + " = 0;");
            boolean doElse = false;
            for (int idx = 0; idx < labels.size(); idx++) {
                String text = "if (strcmp(" + name + ", " + labels.get(idx) + ") == 0) " +
                        exprText + " = " + (idx+1) + ";";
                env.print(doElse ? "else " + text : text);
                doElse = true;
            }
        } else {
            exprText = stmt.expression.translate(null);
        }
        env.print("switch (" + exprText + ")");
        stmt.block.translate(true);
    }
}
