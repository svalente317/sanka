package sanka;

import sanka.ClassDefinition.FieldDefinition;
import sanka.MethodDefinition.BlockGenerator;
import sanka.MethodDefinition.ParameterDefinition;

class SerializableUtils {

    static final TypeDefinition JSON_OBJECT_TYPE =
            new TypeDefinition("sanka.json", "JsonObject");
    static final TypeDefinition JSON_ELEMENT_TYPE =
            new TypeDefinition("sanka.json", "JsonElement");
    static final TypeDefinition SERIALIZABLE_TYPE =
            new TypeDefinition("sanka.json", "Serializable");

    static final String FROM_JSON_ARG = "obj";

    /**
     * Add MethodDefinitions for toJson() and fromJson().
     */
    static void addMethodsToClass(final ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        ImportManager.getInstance().importClass(JSON_OBJECT_TYPE.packageName, JSON_OBJECT_TYPE.name);
        ImportManager.getInstance().importClass(JSON_ELEMENT_TYPE.packageName, JSON_ELEMENT_TYPE.name);
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
                public String generate() {
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
        param.name = FROM_JSON_ARG;
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
                public String generate() {
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
     * Generate the Sanka code for writing public fields to JSON.
     */
    static String generateToJson(ClassDefinition classdef) {
        StringBuilder builder = new StringBuilder();
        builder.append("{var obj = new sanka.json.JsonObject();");
        for (FieldDefinition field : classdef.fieldList) {
            if (field.isPrivate || field.isStatic) {
                continue;
            }
            String fn = "this." + field.name;
            if (field.type.arrayOf != null) {
                TypeDefinition type = field.type.arrayOf;
                builder.append("if (" + fn + " != null) {");
                builder.append("var arr = new sanka.json.JsonElement[" + fn + ".length];");
                builder.append("for (var i=0; i < " + fn + ".length; i++) {");
                builder.append("arr[i] = new sanka.json.JsonElement()");
                if (type.isStringType() || type.isPrimitiveType) {
                    builder.append("." + get_makeJson_method(type) + "(" + fn + "[i]);");
                } else {
                    builder.append(";if (" + fn + "[i] != null) {");
                    builder.append("arr[i].makeObject(" + fn + "[i].toJson());}");
                }
                builder.append("} obj.setArray(\"" + field.name + "\", arr);}");
            } else if (field.type.isStringType() || field.type.isPrimitiveType) {
                builder.append("obj." + get_toJson_method(field.type));
                builder.append("(\"" + field.name + "\", " + fn + ");");
            } else {
                builder.append("if (" + fn + " != null) {");
                builder.append("obj.setObject(\"" + field.name + "\", " + fn + ".toJson());}");
            }
        }
        builder.append("return obj;}");
        return builder.toString();
    }

    static String get_toJson_method(TypeDefinition type) {
        if (type.isStringType()) {
            return "setString";
        }
        if (!type.isPrimitiveType) {
            return "setObject";
        }
        if (type.equals(TypeDefinition.BOOLEAN_TYPE)) {
            return "setBoolean";
        }
        if (type.equals(TypeDefinition.SHORT_TYPE)) {
            return "setShort";
        }
        if (type.equals(TypeDefinition.INT_TYPE)) {
            return "setInt";
        }
        if (type.equals(TypeDefinition.LONG_TYPE)) {
            return "setLong";
        }
        if (type.equals(TypeDefinition.FLOAT_TYPE)) {
            return "setFloat";
        }
        if (type.equals(TypeDefinition.DOUBLE_TYPE)) {
            return "setDouble";
        }
        Environment env = Environment.getInstance();
        env.printError(null, "cannot convert type to json: " + type.toString());
        return "";
    }

    static String get_makeJson_method(TypeDefinition type) {
        if (type.isStringType()) {
            return "makeString";
        }
        if (type.equals(TypeDefinition.BOOLEAN_TYPE)) {
            return "makeBoolean";
        }
        if (type.equals(TypeDefinition.SHORT_TYPE)) {
            return "makeShort";
        }
        if (type.equals(TypeDefinition.INT_TYPE)) {
            return "makeInt";
        }
        if (type.equals(TypeDefinition.LONG_TYPE)) {
            return "makeLong";
        }
        if (type.equals(TypeDefinition.FLOAT_TYPE)) {
            return "makeFloat";
        }
        if (type.equals(TypeDefinition.DOUBLE_TYPE)) {
            return "makeDouble";
        }
        Environment env = Environment.getInstance();
        env.printError(null, "cannot convert array type to json: " + type.toString());
        return "";
    }

    /**
     * Generate the list of statements for setting public fields from JSON.
     */
    static String generateFromJson(ClassDefinition classdef) {
        StringBuilder builder = new StringBuilder();
        String obj = FROM_JSON_ARG;
        String tmparr = null, tmpobj = null;
        builder.append("{");
        for (FieldDefinition field : classdef.fieldList) {
            if (field.isPrivate || field.isStatic) {
                continue;
            }
            String fn = "this." + field.name;
            if (field.type.arrayOf != null) {
                TypeDefinition type = field.type.arrayOf;
                if (tmparr == null) {
                    tmparr = "tmparr";
                    builder.append("var " + tmparr + ";");
                }
                builder.append(tmparr + " = " + obj + ".getAsArray(\"" + field.name + "\");");
                builder.append("if (" + tmparr + " != null) { ");
                builder.append(fn + " = new " + type + "[" + tmparr + ".length];");
                builder.append("for (var i=0; i < " + tmparr + ".length; i++) {");
                if (type.isStringType() || type.isPrimitiveType) {
                    builder.append(fn + "[i] = " + tmparr + "[i].");
                    builder.append(get_fromJson_method(type) + "(); }");
                } else {
                    builder.append("if (" + tmparr + "[i] != null) { ");
                    builder.append("var item = " + tmparr + "[i].getAsObject();");
                    builder.append("if (item != null) { ");
                    builder.append(fn + "[i] = new " + type + "();");
                    builder.append(fn + "[i].fromJson(item);}}");
                }
                builder.append("} else { " + fn + " = null; }");
            } else if (!(field.type.isStringType() || field.type.isPrimitiveType)) {
                if (tmpobj == null) {
                    tmpobj = "tmpobj";
                    builder.append("var " + tmpobj + ";");
                }
                builder.append(tmpobj + " = " + obj + ".getAsObject(\"" + field.name + "\");");
                builder.append("if (" + tmpobj + " != null) { ");
                builder.append(fn + " = new " + field.type + "();");
                builder.append(fn + ".fromJson(" + tmpobj + ");");
                builder.append("} else { " + fn + " = null; }");
            } else {
                builder.append(fn + " = " + obj + "." + get_fromJson_method(field.type));
                builder.append("(\"" + field.name + "\");");
            }
        }
        builder.append("}");
        return builder.toString();
    }

    static String get_fromJson_method(TypeDefinition type) {
        if (type.isStringType()) {
            return "getAsString";
        }
        if (!type.isPrimitiveType) {
            return "getAsObject";
        }
        if (type.equals(TypeDefinition.BOOLEAN_TYPE)) {
            return "getAsBoolean";
        }
        if (type.equals(TypeDefinition.SHORT_TYPE)) {
            return "getAsShort";
        }
        if (type.equals(TypeDefinition.INT_TYPE)) {
            return "getAsInt";
        }
        if (type.equals(TypeDefinition.LONG_TYPE)) {
            return "getAsLong";
        }
        if (type.equals(TypeDefinition.FLOAT_TYPE)) {
            return "getAsFloat";
        }
        if (type.equals(TypeDefinition.DOUBLE_TYPE)) {
            return "getAsDouble";
        }
        Environment env = Environment.getInstance();
        env.printError(null, "cannot convert type to json: " + type.toString());
        return "";
    }
}
