package sanka;

import sanka.ClassDefinition.FieldDefinition;
import sanka.MethodDefinition.BlockGenerator;

public class SingletonUtils {
    public static final String LOCK_CLASS = "LOCK_CLASS";
    public static final String UNLOCK_CLASS = "UNLOCK_CLASS";

    private static final String METHOD_NAME = "get";
    private static final String INSTANCE_NAME = "INSTANCE";

    /**
     * Add MethodDefinition for get().
     */
    static void addMethodsToClass(final ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        MethodDefinition method = classdef.getMethod(METHOD_NAME, 0);
        if (method != null) {
            env.printError(null, "singleton class " + classdef.name +
                    " must not define method " + METHOD_NAME);
            return;
        }
        FieldDefinition field = classdef.getField(INSTANCE_NAME);
        if (field != null) {
            // This variable is private and not part of the language specification.
            // So we should simply use an available name. But who cares?
            env.printError(null, "singleton class " + classdef.name +
                    " must not define field " + INSTANCE_NAME);
            return;
        }

        method = new MethodDefinition();
        method.isStatic = true;
        method.returnType = classdef.toTypeDefinition();
        method.name = METHOD_NAME;
        method.generator = new BlockGenerator() {
            @Override
            public String generate() {
                return SingletonUtils.generateMethod(classdef);
            }
        };
        classdef.methodList.add(method);

        field = new FieldDefinition();
        field.name = INSTANCE_NAME;
        field.type = classdef.toTypeDefinition();
        field.type.nullable = true;
        field.isStatic = true;
        classdef.fieldList.add(field);
    }

    static String generateMethod(ClassDefinition classdef) {
        if (classdef.hasConstructor()) {
            if (classdef.getMethod(classdef.name, 0) == null) {
                Environment env = Environment.getInstance();
                env.printError(null, "singleton class " + classdef.name +
                        " requires no argument constructor");
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append("{var q = " + INSTANCE_NAME + "; if q != null {return q;}");
        builder.append("c__stmt\"" + LOCK_CLASS + "\";");
        builder.append("if " + INSTANCE_NAME + " == null {");
        builder.append(INSTANCE_NAME + " = new " + classdef.qualifiedName() + "();}");
        builder.append("c__stmt\"" + UNLOCK_CLASS + "\";");
        builder.append("return assert " + INSTANCE_NAME + ";}");
        return builder.toString();
    }
}
