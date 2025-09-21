package sanka.c;

import sanka.BlockDefinition;
import sanka.ClassDefinition;
import sanka.Environment;
import sanka.ExpressionDefinition;
import sanka.MethodDefinition;
import sanka.StatementDefinition;
import sanka.TypeDefinition;

abstract class TranslationBase {
    /**
     * @return the translated C name of a static field.
     */
    static String translateStaticField(String className, String itemName) {
        return className + "__" + itemName;
    }

    /**
     * @return the translated C name of a method or constructor that is not overloaded,
     *         like String.length(), or main(), or an interface constructor.
     */
    static String translateMethodName(String className, String methodName) {
        return translateStaticField(className, methodName);
    }

    /**
     * @return the translated C name of a method or constructor.
     */
    static String translateMethodName(String className, MethodDefinition method) {
        String name = translateMethodName(className, method.name);
        return method.isOverloaded ? name + "__" + method.parameters.size() : name;
    }

    /**
     * @return the name of the C function with the code from a method in an abstract class
     */
    static String getBaseTranslatedName(String name) {
        return name + "__BASE";
    }

    /**
     * @return the C type to represent the given Sanka type
     */
    static String translateType(TypeDefinition type) {
        if (type.keyType != null) {
            return "struct rb_table *";
        }
        if (type.arrayOf != null) {
            return "struct array *";
        }
        if (type.isPrimitiveType) {
            if (type.name.equals("boolean")) {
                return "int";
            }
            if (type.name.equals("byte")) {
                return "char";
            }
            return type.name;
        }
        if (type.isStringType()) {
            return "const char *";
        }
        ClassDefinition classdef = getClassDefinition(type);
        if (classdef != null && classdef.c_repr != null) {
            return classdef.c_repr + " ";
        }
        return "struct " + type.name + " *";
    }

    /**
     * @return the C type followed by a space if necessary between the type and variable name
     */
    static String translateTypeSpace(TypeDefinition type) {
        String text = translateType(type);
        return text.endsWith("*") ? text : text + " ";
    }

    /**
     * @return the C type behind the pointer for the given Sanka type
     */
    static String translateTypeDeref(TypeDefinition type) {
        if (type.keyType != null) {
            return "struct rb_table";
        }
        if (type.arrayOf != null) {
            return translateType(type.arrayOf);
        }
        if (type.isPrimitiveType || type.isStringType()) {
            return null;
        }
        return "struct " + type.name;
    }

    /**
     * Translate a list of statements.
     */
    static void translateBlock(BlockDefinition block, boolean printBraces) {
        Environment env = Environment.getInstance();
        env.symbolTable.push(block.frame);
        if (printBraces) {
            env.print("{");
            env.level++;
        }
        for (StatementDefinition statement : block.block) {
            StatementTranslator.translate(statement);
        }
        if (printBraces) {
            env.level--;
            env.print("}");
        }
        env.symbolTable.pop();
    }

    /**
     * Shortcut to ExpressionTranslator.translate().
     */
    static String translateExpression(ExpressionDefinition expr) {
        return translateExpression(expr, null);
    }

    static String translateExpression(ExpressionDefinition expr, String variableName) {
        return ExpressionTranslator.translate(expr, variableName);
    }

    static String supers(int count) {
        String result = "";
        for (int idx = 0; idx < count; idx++) {
            result = result + ClassDefinition.SUPER_FIELD_NAME + ".";
        }
        return result;
    }

    /**
     * Hardcode information about "union rb_value" in rb.h. If you change rb.h, then change
     * this too.
     */
    static String typeToMapFieldName(TypeDefinition type) {
        if (!type.isPrimitiveType) {
            return "vp";
        }
        if (type.equals(TypeDefinition.LONG_TYPE)) {
            return "ln";
        }
        if (type.equals(TypeDefinition.DOUBLE_TYPE)) {
            return "d";
        }
        if (type.equals(TypeDefinition.FLOAT_TYPE)) {
            return "f";
        }
        return "i";
    }

    static String typeToMapKeyFieldName(TypeDefinition type) {
        return type.equals(TypeDefinition.STRING_TYPE) ? "cp" : "i";
    }

    static ClassDefinition getClassDefinition(TypeDefinition type) {
        Environment env = Environment.getInstance();
        return env.getClassDefinition(type.packageName, type.name);
    }
}
