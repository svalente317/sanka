package sanka;

import sanka.ClassDefinition.FieldDefinition;
import sanka.ExpressionDefinition.ExpressionType;
import sanka.MethodDefinition.MethodTranslator;
import sanka.MethodDefinition.ParameterDefinition;
import sanka.antlr4.SankaLexer;

class SerializableUtils {

    static final TypeDefinition JSON_OBJECT_TYPE = new TypeDefinition("sanka.json", "JsonObject");

    /**
     * Add MethodDefinitions for toJson() and fromJson().
     */
    static void addMethodsToClass(final ClassDefinition classdef) {
        MethodDefinition method, current;
        method = new MethodDefinition();
        method.isPrivate = false;
        method.isStatic = false;
        method.returnType = JSON_OBJECT_TYPE;
        method.name = "toJson";
        current = classdef.getMethod(method.name);
        if (current != null) {
            // TODO verify
        } else {
            method.translator = new MethodTranslator() {
                @Override
                public void translate() {
                    SerializableUtils.translateToJson(classdef);
                }
            };
            classdef.methodList.add(method);
        }
        method = new MethodDefinition();
        method.isPrivate = false;
        method.isStatic = false;
        method.returnType = TypeDefinition.VOID_TYPE;
        method.name = "fromJson";
        ParameterDefinition param = new ParameterDefinition();
        param.type = JSON_OBJECT_TYPE;
        param.name = "obj";
        method.parameters.add(param);
        current = classdef.getMethod(method.name);
        if (current != null) {
            // TODO verify
        } else {
            method.translator = new MethodTranslator() {
                @Override
                public void translate() {
                    // TODO SerializableUtils.translateFromJson(classdef);
                }
            };
            classdef.methodList.add(method);
        }
    }

    /**
     * TODO: Support setArray()
     * TODO: Support raw Map to JSON
     */
    static void translateToJson(ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        ClassDefinition joClass = env.getClassDefinition(JSON_OBJECT_TYPE);

        // 1. translate `var obj = new JsonObject()`
        StatementDefinition stmt;
        stmt = new StatementDefinition();
        stmt.statementType = SankaLexer.VAR;
        stmt.name = "obj";
        stmt.expression = new ExpressionDefinition();
        stmt.expression.expressionType = ExpressionType.NEW_INSTANCE;
        stmt.expression.type = JSON_OBJECT_TYPE;
        stmt.translate();
        for (FieldDefinition field : classdef.fieldList) {
            if (field.isPrivate || field.isStatic) {
                continue;
            }
            // 2. translate `obj.setInt([field.name], this.field)`
            //    or        `obj.setObject([field.name], this.field.toJson())`
            ExpressionDefinition expr = new ExpressionDefinition();
            expr.expressionType = ExpressionType.FIELD_ACCESS;
            expr.expression1 = new ExpressionDefinition();
            expr.expression1.expressionType = ExpressionType.IDENTIFIER;
            expr.expression1.name = "obj";
            expr.expression1.type = JSON_OBJECT_TYPE;
            expr.name = getMethodName(field.type);
            expr.type = TypeDefinition.METHOD_TYPE;
            expr.method = joClass.getMethod(expr.name);
            ExpressionDefinition func = new ExpressionDefinition();
            func.expressionType = ExpressionType.FUNCTION_CALL;
            func.expression1 = expr;
            func.type = TypeDefinition.VOID_TYPE;
            func.argList = new ExpressionDefinition[2];
            expr = new ExpressionDefinition();
            expr.expressionType = ExpressionType.LITERAL;
            expr.value = field.name;
            expr.type = TypeDefinition.STRING_TYPE;
            func.argList[0] = expr;
            expr = new ExpressionDefinition();
            expr.expressionType = ExpressionType.FIELD_ACCESS;
            expr.expression1 = new ExpressionDefinition();
            expr.expression1.expressionType = ExpressionType.IDENTIFIER;
            expr.expression1.name = "this";
            expr.expression1.type = classdef.toTypeDefinition();
            expr.name = field.name;
            expr.type = field.type;
            if (field.type.isStringType()) {
                // TODO add nullcheck
            }
            else if (!field.type.isPrimitiveType) {
                // Instead of adding `this.field` to the argument list,
                // generate the expression `this.field.toJson()`.
                ExpressionDefinition tmp = new ExpressionDefinition();
                tmp.expressionType = ExpressionType.FIELD_ACCESS;
                tmp.expression1 = expr;
                tmp.name = "toJson";
                tmp.type = TypeDefinition.METHOD_TYPE;
                ClassDefinition fieldClass = env.getClassDefinition(field.type);
                tmp.method = fieldClass.getMethod(tmp.name);
                expr = new ExpressionDefinition();
                expr.expressionType = ExpressionType.FUNCTION_CALL;
                expr.expression1 = tmp;
                expr.type = JSON_OBJECT_TYPE;
                expr.argList = new ExpressionDefinition[0];
            }
            func.argList[1] = expr;
            stmt = new StatementDefinition();
            stmt.statementType = SankaLexer.BOOLEAN;
            stmt.expression = func;
            stmt.translate();
        }
        // 3. translate `return obj`
        stmt = new StatementDefinition();
        stmt.statementType = SankaLexer.RETURN;
        stmt.expression = new ExpressionDefinition();
        stmt.expression.expressionType = ExpressionType.IDENTIFIER;
        stmt.expression.type = JSON_OBJECT_TYPE;
        stmt.expression.name = "obj";
        stmt.translate();
    }

    static String getMethodName(TypeDefinition type) {
        if (type.isStringType()) {
            return "setString";
        }
        if (!type.isPrimitiveType) {
            return "setObject";
        }
        if (type.isBooleanType()) {
            return "setBoolean";
        }
        if (type.isIntegralType()) {
            return "setInt";
        }
        if (type.isNumericType()) {
            return "setDouble";
        }
        Environment env = Environment.getInstance();
        env.printError(null, "cannot convert type to json: " + type.toString());
        return "";
    }
}
