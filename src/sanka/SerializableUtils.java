package sanka;

import java.util.ArrayList;
import java.util.List;

import sanka.ClassDefinition.FieldDefinition;
import sanka.ExpressionDefinition.ExpressionType;
import sanka.MethodDefinition.BlockGenerator;
import sanka.MethodDefinition.ParameterDefinition;
import sanka.StatementDefinition.StatementType;

class SerializableUtils {

    static final TypeDefinition JSON_OBJECT_TYPE =
            new TypeDefinition("sanka.json", "JsonObject");
    static final TypeDefinition SERIALIZABLE_TYPE =
            new TypeDefinition("sanka.json", "Serializable");

    /**
     * Add MethodDefinitions for toJson() and fromJson().
     */
    static void addMethodsToClass(final ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        ImportManager.getInstance().importClass(JSON_OBJECT_TYPE.packageName, JSON_OBJECT_TYPE.name);
        MethodDefinition method, current;
        final boolean[] isEvaluated = new boolean[1];
        method = new MethodDefinition();
        method.isPrivate = false;
        method.isStatic = false;
        method.returnType = JSON_OBJECT_TYPE;
        method.name = "toJson";
        current = classdef.getMethod(method.name, 0);
        if (current != null) {
            if (!method.sameSignature(current)) {
                env.printError(null, "serializable class " + classdef.name +
                        ": wrong signature for method " + method.name);
            }
        } else {
            method.generator = new BlockGenerator() {
                @Override
                public StatementDefinition[] generate() {
                    if (!isEvaluated[0]) {
                        SerializableUtils.evaluateClass(classdef);
                        isEvaluated[0] = true;
                    }
                    return SerializableUtils.generateToJson(classdef);
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
        current = classdef.getMethod(method.name, 1);
        if (current != null) {
            if (!method.sameSignature(current)) {
                env.printError(null, "serializable class " + classdef.name +
                        ": wrong signature for method " + method.name);
            }
        } else {
            method.generator = new BlockGenerator() {
                @Override
                public StatementDefinition[] generate() {
                    if (!isEvaluated[0]) {
                        SerializableUtils.evaluateClass(classdef);
                        isEvaluated[0] = true;
                    }
                    return SerializableUtils.generateFromJson(classdef);
                }
            };
            classdef.methodList.add(method);
        }
    }

    /**
     * Verify that each public instance field is primitive, or a String, or implements
     * the Serializable interface.
     */
    static void evaluateClass(ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        ImportManager.getInstance().importClass(
                SERIALIZABLE_TYPE.packageName, SERIALIZABLE_TYPE.name);
        ClassDefinition serializableClass = env.getClassDefinition(SERIALIZABLE_TYPE);
        if (serializableClass == null) {
            env.printError(null, "interface " + SERIALIZABLE_TYPE + " not found");
            return;
        }
        for (FieldDefinition field : classdef.fieldList) {
            if (field.isPrivate || field.isStatic) {
                continue;
            }
            TypeDefinition type = field.type;
            // Find out what this field is an array of.
            while (type.arrayOf != null && type.keyType == null) {
                type = type.arrayOf;
            }
            if (type.isPrimitiveType || type.isStringType()) {
                continue;
            }
            boolean error;
            if (type.keyType != null) {
                // We do not yet support translation of maps to json.
                error = true;
            } else {
                ClassDefinition fieldClass = env.getClassDefinition(type);
                error = (fieldClass == null ||
                        !TypeUtils.isInterfaceImplemented(serializableClass, fieldClass));
            }
            if (error) {
                env.printError(null, "class " + classdef.name + " field " + field.name +
                        " does not implement interface " + SERIALIZABLE_TYPE);
            }
        }
    }

    /**
     * Generate the list of statements for writing public fields to JSON.
     * The line "expr.value = field.name" is basically reflection.
     * TODO: Support setArray()
     */
    static StatementDefinition[] generateToJson(ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        ClassDefinition joClass = env.getClassDefinition(JSON_OBJECT_TYPE);
        List<StatementDefinition> statements = new ArrayList<>();

        // 1. generate `var obj = new JsonObject()`
        StatementDefinition stmt;
        stmt = new StatementDefinition();
        stmt.statementType = StatementType.DECLARATION;
        stmt.name = "obj";
        stmt.expression = new ExpressionDefinition();
        stmt.expression.expressionType = ExpressionType.NEW_INSTANCE;
        stmt.expression.type = JSON_OBJECT_TYPE;
        env.symbolTable.put(stmt.name, stmt.expression.type);
        statements.add(stmt);
        for (FieldDefinition field : classdef.fieldList) {
            if (field.isPrivate || field.isStatic) {
                continue;
            }
            // 2. generate `obj.setInt([field.name], this.field)`
            //    or        `obj.setObject([field.name], this.field.toJson())`
            ExpressionDefinition expr = new ExpressionDefinition();
            expr.expressionType = ExpressionType.FIELD_ACCESS;
            expr.expression1 = new ExpressionDefinition();
            expr.expression1.expressionType = ExpressionType.IDENTIFIER;
            expr.expression1.name = "obj";
            expr.expression1.type = JSON_OBJECT_TYPE;
            expr.name = get_toJson_method(field.type);
            expr.type = TypeDefinition.METHOD_TYPE;
            expr.method = joClass.getMethod(expr.name, 2);
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
            if (!(field.type.isStringType() || field.type.isPrimitiveType)) {
                // Instead of adding `this.field` to the argument list,
                // generate the expression `this.field.toJson()`.
                ExpressionDefinition tmp = new ExpressionDefinition();
                tmp.expressionType = ExpressionType.FIELD_ACCESS;
                tmp.expression1 = expr;
                tmp.name = "toJson";
                tmp.type = TypeDefinition.METHOD_TYPE;
                ClassDefinition fieldClass = env.getClassDefinition(field.type);
                tmp.method = fieldClass.getMethod(tmp.name, 0);
                expr = new ExpressionDefinition();
                expr.expressionType = ExpressionType.FUNCTION_CALL;
                expr.expression1 = tmp;
                expr.type = JSON_OBJECT_TYPE;
                expr.argList = new ExpressionDefinition[0];
            }
            func.argList[1] = expr;
            stmt = new StatementDefinition();
            stmt.statementType = StatementType.EXPRESSION;
            stmt.expression = func;
            statements.add(stmt);
        }
        // 3. generate `return obj`
        stmt = new StatementDefinition();
        stmt.statementType = StatementType.RETURN;
        stmt.expression = new ExpressionDefinition();
        stmt.expression.expressionType = ExpressionType.IDENTIFIER;
        stmt.expression.type = JSON_OBJECT_TYPE;
        stmt.expression.name = "obj";
        statements.add(stmt);
        return statements.toArray(new StatementDefinition[statements.size()]);
    }

    static String get_toJson_method(TypeDefinition type) {
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

    /**
     * Generate the list of statements for setting public fields from JSON.
     */
    static StatementDefinition[] generateFromJson(ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        ClassDefinition joClass = env.getClassDefinition(JSON_OBJECT_TYPE);
        List<StatementDefinition> statements = new ArrayList<>();

        for (FieldDefinition field : classdef.fieldList) {
            if (field.isPrivate || field.isStatic) {
                continue;
            }
            // generate `this.field = obj.getAsInt([field.name])`
            // TODO if (!(field.type.isStringType() || field.type.isPrimitiveType)) {
            // recursively get object }
            StatementDefinition stmt = new StatementDefinition();
            stmt.statementType = StatementType.ASSIGNMENT;
            ExpressionDefinition expr = new ExpressionDefinition();
            expr.expressionType = ExpressionType.FIELD_ACCESS;
            expr.expression1 = new ExpressionDefinition();
            expr.expression1.expressionType = ExpressionType.IDENTIFIER;
            expr.expression1.name = "this";
            expr.expression1.type = classdef.toTypeDefinition();
            expr.name = field.name;
            expr.type = field.type;
            stmt.lhsExpression = expr;
            // TODO cast int to short.
            // TODO cast double to float.
            // TODO get long from json?
            expr = new ExpressionDefinition();
            expr.expressionType = ExpressionType.FIELD_ACCESS;
            expr.expression1 = new ExpressionDefinition();
            expr.expression1.expressionType = ExpressionType.IDENTIFIER;
            expr.expression1.name = "obj";
            expr.expression1.type = JSON_OBJECT_TYPE;
            expr.name = get_fromJson_method(field.type);
            expr.type = TypeDefinition.METHOD_TYPE;
            expr.method = joClass.getMethod(expr.name, 1);
            ExpressionDefinition func = new ExpressionDefinition();
            func.expressionType = ExpressionType.FUNCTION_CALL;
            func.expression1 = expr;
            func.type = expr.method.returnType;
            func.argList = new ExpressionDefinition[1];
            expr = new ExpressionDefinition();
            expr.expressionType = ExpressionType.LITERAL;
            expr.value = field.name;
            expr.type = TypeDefinition.STRING_TYPE;
            func.argList[0] = expr;
            stmt.expression = func;
            statements.add(stmt);
        }
        return statements.toArray(new StatementDefinition[statements.size()]);
    }

    static String get_fromJson_method(TypeDefinition type) {
        if (type.isStringType()) {
            return "getAsString";
        }
        if (!type.isPrimitiveType) {
            return "getAsObject";
        }
        if (type.isBooleanType()) {
            return "getAsBoolean";
        }
        if (type.isIntegralType()) {
            return "getAsInt";
        }
        if (type.isNumericType()) {
            return "getAsDouble";
        }
        Environment env = Environment.getInstance();
        env.printError(null, "cannot convert type to json: " + type.toString());
        return "";
    }
}
