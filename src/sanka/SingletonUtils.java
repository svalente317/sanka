package sanka;

import sanka.ClassDefinition.FieldDefinition;
import sanka.ExpressionDefinition.ExpressionType;
import sanka.MethodDefinition.BlockGenerator;
import sanka.StatementDefinition.StatementType;

class SingletonUtils {
    /**
     * Add MethodDefinition for get().
     */
    static void addMethodsToClass(final ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        String name = "get";
        MethodDefinition method = classdef.getMethod(name, 0);
        if (method != null) {
            env.printError(null, "singleton class " + classdef.name +
                    " must not define method " + name);
            return;
        }
        method = new MethodDefinition();
        method.isStatic = true;
        method.returnType = classdef.toTypeDefinition();
        method.name = name;
        method.generator = new BlockGenerator() {
            @Override
            public StatementDefinition[] generate() {
                return SingletonUtils.generateMethod(classdef);
            }
        };
        classdef.methodList.add(method);

        name = "INSTANCE";
        FieldDefinition field = classdef.getField(name);
        if (field != null) {
            // This variable is private and not part of the language specification.
            // So we should simply use an available name. But who cares?
            env.printError(null, "singleton class " + classdef.name +
                    " must not define field " + name);
            return;
        }
        field = new FieldDefinition();
        field.name = name;
        field.type = classdef.toTypeDefinition();
        field.isStatic = true;
        classdef.fieldList.add(field);
    }

    static StatementDefinition[] generateMethod(ClassDefinition classdef) {
        TypeDefinition type = classdef.toTypeDefinition();
        StatementDefinition[] statements = new StatementDefinition[2];
        StatementDefinition stmt = new StatementDefinition();
        stmt.statementType = StatementType.IF;
        stmt.expression = generateInstanceEqualsNullExpression(type);
        stmt.block = new BlockDefinition();
        stmt.block.block = generateInnerStatements(type);
        statements[0] = stmt;
        stmt = new StatementDefinition();
        stmt.statementType = StatementType.RETURN;
        stmt.expression = generateStaticInstanceExpression(type);
        statements[1] = stmt;
        return statements;
    }

    private static ExpressionDefinition generateInstanceEqualsNullExpression(TypeDefinition type) {
        ExpressionDefinition expr = new ExpressionDefinition();
        expr.expressionType = ExpressionType.BINARY;
        expr.type = TypeDefinition.BOOLEAN_TYPE;
        expr.operator = "==";
        expr.expression1 = generateStaticInstanceExpression(type);
        expr.expression2 = new ExpressionDefinition();
        expr.expression2.expressionType = ExpressionType.LITERAL;
        expr.expression2.type = TypeDefinition.NULL_TYPE;
        return expr;
    }

    private static ExpressionDefinition generateStaticInstanceExpression(TypeDefinition type) {
        ExpressionDefinition expr = new ExpressionDefinition();
        expr.expressionType = ExpressionType.FIELD_ACCESS;
        expr.type = type;
        expr.expression1 = new ExpressionDefinition();
        expr.expression1.expressionType = ExpressionType.CLASS_IDENTIFIER;
        expr.expression1.type = TypeDefinition.VOID_TYPE;
        expr.expression1.identifiedClass = expr.type;
        expr.isStatic = true;
        expr.name = "INSTANCE";
        return expr;
    }

    private static StatementDefinition[] generateInnerStatements(TypeDefinition type) {
        StatementDefinition[] statements = new StatementDefinition[3];
        StatementDefinition stmt = new StatementDefinition();
        stmt.statementType = StatementType.LOCK_CLASS;
        stmt.expression = new ExpressionDefinition();
        stmt.expression.type = type;
        statements[0] = stmt;
        stmt = new StatementDefinition();
        stmt.statementType = StatementType.IF;
        stmt.expression = generateInstanceEqualsNullExpression(type);
        stmt.block = new BlockDefinition();
        stmt.block.block = new StatementDefinition[1];
        stmt.block.block[0] = generateAssignmentStatement(type);
        statements[1] = stmt;
        stmt = new StatementDefinition();
        stmt.statementType = StatementType.UNLOCK_CLASS;
        stmt.expression = new ExpressionDefinition();
        stmt.expression.type = type;
        statements[2] = stmt;
        return statements;
    }

    private static StatementDefinition generateAssignmentStatement(TypeDefinition type) {
        StatementDefinition stmt = new StatementDefinition();
        stmt.statementType = StatementType.ASSIGNMENT;
        stmt.lhsExpression = generateStaticInstanceExpression(type);
        stmt.expression = new ExpressionDefinition();
        stmt.expression.expressionType = ExpressionType.NEW_INSTANCE;
        stmt.expression.type = type;
        return stmt;
    }
}
