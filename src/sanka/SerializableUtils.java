package sanka;

import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.ClassDefinition.FieldDefinition;
import sanka.ExpressionDefinition.ExpressionType;
import sanka.MethodDefinition.MethodGenerator;
import sanka.MethodDefinition.ParameterDefinition;
import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser.AssignableContext;

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
        ImportManager.getInstance().doImport(null,
        		JSON_OBJECT_TYPE.packageName, JSON_OBJECT_TYPE.name);
        MethodDefinition method, current;
        boolean isEvaluated = false;
        method = new MethodDefinition();
        method.isPrivate = false;
        method.isStatic = false;
        method.returnType = JSON_OBJECT_TYPE;
        method.name = "toJson";
        current = classdef.getMethod(method.name);
        if (current != null) {
            if (!sameSignature(method, current)) {
                env.printError(null, "serializable class " + classdef.name +
                        ": wrong signature for method " + method.name);
            }
        } else {
            isEvaluated = true;
            method.generator = new MethodGenerator() {
                @Override
                public void evaluate() {
                    SerializableUtils.evaluateClass(classdef);
                }

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
            if (!sameSignature(method, current)) {
                env.printError(null, "serializable class " + classdef.name +
                        ": wrong signature for method " + method.name);
            }
        } else {
            final boolean finalIsEvaluated = isEvaluated;
            method.generator = new MethodGenerator() {
                @Override
                public void evaluate() {
                    // If this class passed evaluation for toJson(),
                    // then don't evaluate it again.
                    if (!finalIsEvaluated) {
                        SerializableUtils.evaluateClass(classdef);
                    }
                }

                @Override
                public void translate() {
                    SerializableUtils.translateFromJson(classdef);
                }
            };
            classdef.methodList.add(method);
        }
    }

    static boolean sameSignature(MethodDefinition m1, MethodDefinition m2) {
        boolean ok = m1.isPrivate == m2.isPrivate &&
                m1.isStatic == m2.isStatic &&
                m1.returnType.equals(m2.returnType) &&
                m1.parameters.size() == m2.parameters.size();
        if (!ok) {
            return false;
        }
        for (int idx = 0; idx < m1.parameters.size(); idx++) {
            if (!m1.parameters.get(idx).type.equals(m2.parameters.get(idx).type)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verify that each public instance field is primitive, or a String, or implements
     * the Serializable interface.
     */
    static void evaluateClass(ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        ImportManager.getInstance().doImport(null,
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
     * Generate C code for writing public fields to JSON.
     * The line "expr.value = field.name" is basically reflection.
     * TODO: Support setArray()
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
            expr.name = get_toJson_method(field.type);
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
            if (!(field.type.isStringType() || field.type.isPrimitiveType)) {
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

    static void translateFromJson(ClassDefinition classdef) {
    	Environment env = Environment.getInstance();
        ClassDefinition joClass = env.getClassDefinition(JSON_OBJECT_TYPE);
        for (FieldDefinition field : classdef.fieldList) {
            if (field.isPrivate || field.isStatic) {
                continue;
            }
            // translate `this.field = obj.getAsInt([field.name])`
            // TODO if (!(field.type.isStringType() || field.type.isPrimitiveType)) {
            // recursively get object }
            StatementDefinition stmt = new StatementDefinition();
            stmt.statementType = SankaLexer.EQUAL;
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
            expr.method = joClass.getMethod(expr.name);
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
            stmt.translate();
        }
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
