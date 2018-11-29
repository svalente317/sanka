package sanka;

import java.util.Set;
import java.util.TreeSet;

import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser.StatementContext;

public class SwitchUtils {

    static void evaluateSwitchStatement(StatementContext ctx, StatementDefinition stmt) {
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
                if (item.expression.name != null && !labels.add(item.expression.name)) {
                    env.printError(ctx, "duplicate case label: " + item.expression.name);
                }
                if (!TypeUtils.isCompatible(stmt.expression.type, item.expression)) {
                    env.printError(ctx, "incompatible types: " + item.expression.type +
                            " cannot be converted to " + stmt.expression.type);
                }
                item.valueName = "approved";
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
        // TODO string to int
        env.print("switch (" + stmt.expression.translate(null) + ")");
        stmt.block.translate(true);
    }
}
