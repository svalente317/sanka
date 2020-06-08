package sanka.c;

import java.util.ArrayList;
import java.util.List;

import sanka.Environment;
import sanka.ExpressionDefinition;
import sanka.ExpressionDefinition.ExpressionType;
import sanka.SingletonUtils;
import sanka.StatementDefinition;
import sanka.StatementDefinition.StatementType;
import sanka.TypeDefinition;

class StatementTranslator extends TranslationBase {
    /**
     * Statement pass 3 of 3. Generate C code for the evaluated statements and expressions.
     */
    static void translate(StatementDefinition statement) {
        Environment env = Environment.getInstance();
        StringBuilder builder;
        String text, exprText;
        StatementType statementType = statement.statementType;
        switch (statementType) {
        case DECLARATION:
            TypeDefinition type = env.symbolTable.get(statement.name);
            if (type == null || type.isNullType()) {
                // This variable never has a non-null value. Drop it.
                return;
            }
            env.addType(type);
            builder = new StringBuilder();
            builder.append(translateTypeSpace(type));
            builder.append(statement.name);
            if (statement.expression == null) {
                builder.append(" = 0;");
                env.print(builder.toString());
                return;
            }
            builder.append(";");
            env.print(builder.toString());
            text = translateExpression(statement.expression, statement.name);
            if (!text.equals(statement.name)) {
                builder.setLength(0);
                builder.append(statement.name);
                builder.append(" = ");
                builder.append(text);
                builder.append(";");
                env.print(builder.toString());
            }
            return;
        case ASSIGNMENT:
        case INC:
        case DEC:
            builder = new StringBuilder();
            text = null;
            if (statement.lhsExpression != null) {
                if (statement.lhsExpression.isMapAccess()) {
                    translateMapAssignment(statement);
                    return;
                }
                // Set builder to either "LHS[idx]" or "LHS->field".
                builder.append(translateExpression(statement.lhsExpression));
                if (statement.expression != null) {
                    text = translateExpression(statement.expression);
                }
            } else {
                // Try to directly write "var = value".
                if (statement.expression != null) {
                    text = translateExpression(statement.expression, statement.name);
                    if (text.equals(statement.name)) {
                        return;
                    }
                }
                builder.append(statement.name);
            }
            switch (statementType) {
            case ASSIGNMENT:
                builder.append(" = ");
                builder.append(text);
                break;
            case INC:
                builder.append("++");
                break;
            case DEC:
                builder.append("--");
                break;
            default:
            }
            builder.append(";");
            env.print(builder.toString());
            return;
        case IF:
            text = translateExpression(statement.expression);
            if (statement.expression.expressionType != ExpressionType.BINARY || text.charAt(0) != '(') {
                text = "(" + text + ")";
            }
            env.print("if " + text);
            translateBlock(statement.block, true);
            if (statement.elseBlock != null) {
                env.print("else");
                translateBlock(statement.elseBlock, true);
            }
            return;
        case WHILE:
            env.print("while (1) {");
            env.level++;
            builder = new StringBuilder();
            builder.append("if (!");
            builder.append(translateExpression(statement.expression));
            builder.append(") break;");
            env.print(builder.toString());
            translateBlock(statement.block, false);
            env.level--;
            env.print("}");
            return;
        case FOR:
            StatementDefinition initStatement = statement.forBlock.block[0];
            StatementDefinition incStatement = statement.forBlock.block[1];
            if (!statement.forBlock.frame.isEmpty()) {
                env.symbolTable.push(statement.forBlock.frame);
                env.print("{");
                env.level++;
            }
            if (initStatement != null) {
                translate(initStatement);
            }
            // Should generate different code for loops that don't use "continue".
            text = null;
            if (incStatement != null) {
                text = env.getTmpVariable();
                env.print("int " + text + " = 0;");
            }
            env.print("while (1) {");
            env.level++;
            if (text != null) {
                env.print("if (" + text + " != 0) {");
                env.level++;
                translate(incStatement);
                env.level--;
                env.print("}");
                env.print(text + " = 1;");
            }
            builder = new StringBuilder();
            builder.append("if (!");
            builder.append(translateExpression(statement.expression));
            builder.append(") break;");
            env.print(builder.toString());
            translateBlock(statement.block, false);
            env.level--;
            env.print("}");
            if (!statement.forBlock.frame.isEmpty()) {
                env.level--;
                env.print("}");
                env.symbolTable.pop();
            }
            return;
        case ENHANCED_FOR:
            TypeDefinition exprType = statement.expression.type;
            if (exprType.keyType == null) {
                // Expression is String or array.
                String exprVar = env.getTmpVariable();
                env.print(translateTypeSpace(exprType) + exprVar + ";");
                text = translateExpression(statement.expression, exprVar);
                if (!text.equals(exprVar)) {
                    env.print(exprVar + " = " + text + ";");
                }
                env.print("NULLCHECK(" + exprVar + ");");
                String lenCode;
                if (exprType.isStringType()) {
                    lenCode = env.getTmpVariable();
                    env.print(translateTypeSpace(TypeDefinition.INT_TYPE) + lenCode + " = " +
                            translateMethodName(exprType.name, "length") + "(" + exprVar + ");");
                } else {
                    lenCode = exprVar + "->length";
                }
                String indexVar = env.getTmpVariable();
                env.print("for (int " + indexVar + " = 0; " +
                        indexVar + " < " + lenCode + "; " + indexVar + "++) {");
                env.level++;
                if (exprType.isStringType()) {
                    env.print(translateTypeSpace(TypeDefinition.BYTE_TYPE) + statement.name +
                            " = " + exprVar + "[" + indexVar + "];");
                } else {
                    env.print(translateTypeSpace(exprType.arrayOf) + statement.name + " = " +
                            "ARRCAST(" + exprVar + ", " + translateType(exprType.arrayOf) +
                            ")[" + indexVar + "];");
                }
                translateBlock(statement.block, false);
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
            exprText = translateExpression(statement.expression);
            env.print("NULLCHECK(" + exprText + ");");
            env.print("rb_t_init(&" + traverserVar + ", " + exprText + ");");
            env.print("while (rb_t_next(&" + traverserVar + ", &" + keyVar + ", &" +
                    valueVar + ")) {");
            env.level++;
            env.print(translateTypeSpace(statement.expression.type.keyType) + statement.name + ";");
            String field = typeToMapKeyFieldName(statement.expression.type.keyType);
            env.print(statement.name +" = " + keyVar + "." + field + ";");
            if (statement.valueName != null) {
                env.print(translateTypeSpace(statement.expression.type.arrayOf) +
                        statement.valueName + ";");
                field = typeToMapFieldName(statement.expression.type.arrayOf);
                env.print(statement.valueName + " = " + valueVar + "." + field + ";");
            }
            translateBlock(statement.block, false);
            env.level--;
            env.print("}");
            return;
        case SWITCH:
            exprText = null;
            if (statement.expression.type.isStringType()) {
                exprText = env.getTmpVariable();
                List<String> labels = new ArrayList<>();
                for (StatementDefinition item : statement.block.block) {
                    if (item.statementType == StatementType.CASE) {
                        labels.add(translateExpression(item.expression));
                        item.expression.expressionType = ExpressionType.LITERAL;
                        item.expression.type = TypeDefinition.INT_TYPE;
                        item.expression.name = null;
                        item.expression.value = Integer.toString(labels.size());
                    }
                }
                String name = translateExpression(statement.expression);
                env.print("NULLCHECK(" + name + ");");
                env.print("int " + exprText + " = 0;");
                boolean doElse = false;
                for (int idx = 0; idx < labels.size(); idx++) {
                    text = "if (strcmp(" + name + ", " + labels.get(idx) + ") == 0) " +
                            exprText + " = " + (idx+1) + ";";
                    env.print(doElse ? "else " + text : text);
                    doElse = true;
                }
            } else {
                exprText = translateExpression(statement.expression);
            }
            env.print("switch (" + exprText + ")");
            translateBlock(statement.block, true);
            return;
        case CASE:
            if (statement.valueName == null) {
                env.printError(null, "case statement must be inside a switch block");
            } else {
                // TODO typecase
                env.print("case " + translateExpression(statement.expression) + ":;");
            }
            return;
        case DEFAULT:
            if (statement.valueName == null) {
                env.printError(null, "default statement must be inside a switch block");
            } else {
                env.print("default:;");
            }
            return;
        case RETURN:
            builder = new StringBuilder();
            builder.append("return");
            if (statement.expression != null) {
                if (statement.expression.type.isVoidType()) {
                    translateExpression(statement.expression);
                } else {
                    builder.append(" ");
                    builder.append(translateExpression(statement.expression));
                }
            }
            builder.append(";");
            env.print(builder.toString());
            return;
        case BREAK:
            env.print("break;");
            return;
        case CONTINUE:
            env.print("continue;");
            return;
        case EXPRESSION:
            translateExpression(statement.expression);
            // Since the returned expression has no side-effects,
            // there's no reason to write it to the output stream.
            return;
        case SEMI:
            env.print(";");
            return;
        case C__STMT:
            translateCStatement(statement.expression.type, statement.name);
            return;
        case BLOCK:
            translateBlock(statement.block, true);
            return;
        }
    }

    static void translateMapAssignment(StatementDefinition statement) {
        Environment env = Environment.getInstance();
        ExpressionDefinition lhs = statement.lhsExpression;
        String text1 = translateExpression(lhs.expression1);
        String text2 = translateExpression(lhs.expression2);
        env.print("NULLCHECK(" + text1 + ");");
        if (lhs.expression1.type.keyType.isStringType()) {
            if (lhs.expression2.expressionType == ExpressionType.LITERAL) {
                text2 = "(" + translateType(TypeDefinition.STRING_TYPE) + ")" + text2;
            } else {
                env.print("NULLCHECK(" + text2 + ");");
            }
        }
        String valueName = env.getTmpVariable();
        env.print("union rb_value " + valueName + ";");
        String field = typeToMapFieldName(statement.expression.type);
        String value = translateExpression(statement.expression);
        env.print(valueName + "." + field + " = " + value + ";");
        env.print("rb_put(" + text1 + ", (union rb_key) " + text2 + ", " + valueName + ", 0);");
    }

    static String translateMapAssignment(String mapName, ExpressionDefinition keyExpr,
            ExpressionDefinition valueExpr, String valueName) {
        Environment env = Environment.getInstance();
        String keyText = translateExpression(keyExpr);
        String valueText = translateExpression(valueExpr);
        if (keyExpr.type.isStringType()) {
            if (keyExpr.expressionType == ExpressionType.LITERAL) {
                keyText = "(" + translateType(TypeDefinition.STRING_TYPE) + ")" + keyText;
            } else {
                env.print("NULLCHECK(" + keyText + ");");
            }
        }
        if (valueName == null) {
            valueName = env.getTmpVariable();
            env.print("union rb_value " + valueName + ";");
        }
        String field = typeToMapFieldName(valueExpr.type);
        env.print(valueName + "." + field + " = " + valueText + ";");
        env.print("rb_put(" + mapName + ", (union rb_key) " + keyText + ", " + valueName + ", 0);");
        return valueName;
    }

    static void translateCStatement(TypeDefinition type, String stmt) {
        Environment env = Environment.getInstance();
        if (stmt.equals(SingletonUtils.LOCK_CLASS)) {
            stmt = "pthread_mutex_lock(&" + translateStaticField(type.name, "MUTEX") + ")";
        }
        else if (stmt.equals(SingletonUtils.UNLOCK_CLASS)) {
            stmt = "pthread_mutex_unlock(&" + translateStaticField(type.name, "MUTEX") + ")";
        }
        env.print(stmt + ";");

    }
}
