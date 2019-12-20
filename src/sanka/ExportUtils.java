package sanka;


import sanka.ClassDefinition.FieldDefinition;

class ExportUtils {
    // Use a reserved word that can never be a field name.
    public static final String EXTENDS_FROM = "extends";

    /**
     * Recursive function to add all exported methods to class methodList.
     */
    static boolean parseExports(ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        if (classdef.exportStatus > 0) {
            return true;
        }
        if (classdef.exportStatus < 0) {
            env.printError(null, classdef.qualifiedName() + ": export loop detected");
            return false;
        }
        classdef.exportStatus = -1;
        for (String fieldName : classdef.exports) {
            String methodName = null;
            int idx = fieldName.indexOf('.');
            if (idx > 0) {
                methodName = fieldName.substring(idx+1);
                fieldName = fieldName.substring(0, idx);
            }
            FieldDefinition fielddef = classdef.getField(fieldName);
            if (fielddef == null) {
                env.printError(null, "export in " + classdef.qualifiedName() +
                        ": field " + fieldName + " not found");
                continue;
            }
            TypeDefinition type = fielddef.type;
            ClassDefinition superclass = env.getClassDefinition(type.packageName, type.name);
            if (superclass == null) {
                env.printError(null, "export " + classdef.qualifiedName() + "." + fieldName +
                        ": type " + type + " not found");
                continue;
            }
            if (!parseExports(superclass)) {
                continue;
            }
            // Export all public methods with the given name.
            int count = 0;
            for (MethodDefinition method : superclass.methodList) {
                if (!method.isPrivate) {
                    if (methodName == null || methodName.equals(method.name)) {
                        count++;
                        addMethodToClass(classdef, fieldName, method, methodName == null);
                    }
                }
            }
            if (methodName != null && count == 0) {
                env.printError(null, "export " + classdef.qualifiedName() + "." + fieldName +
                        ": public method " + methodName + " not found");
                continue;
            }
        }
        if (classdef.superclass != null && parseExports(classdef.superclass)) {
            if (!classdef.superclass.isAbstract) {
                env.printError(null, "cannot extend " + classdef.superclass.qualifiedName() +
                        " because it is not abstract");
                return false;
            }
            for (MethodDefinition method : classdef.superclass.methodList) {
                if (method.isPrivate || method.isStatic) {
                    continue;
                }
                if (method.isAbstract(classdef) && !classdef.isAbstract) {
                    verifyMethodDefined(classdef, method);
                } else {
                    addMethodToClass(classdef, EXTENDS_FROM, method, false);
                }
            }
        }
        classdef.exportStatus = 1;
        return true;
    }

    private static void addMethodToClass(ClassDefinition classdef, String fieldName,
            MethodDefinition method, boolean isImplicit) {
        Environment env = Environment.getInstance();
        MethodDefinition existing = classdef.getMethod(method.name, method.parameters.size());
        if (existing != null) {
            if (fieldName.equals(EXTENDS_FROM)) {
                if (!sameSignature(method, existing)) {
                    env.printError(null, "class " + classdef.name + " method " + existing.name +
                            ": signature incompatible with " + classdef.superclass.name);
                }
                return;
            }
            // Implicit exported methods do not override explicitly defined methods.
            if (isImplicit && existing.exportFrom == null && sameSignature(method, existing)) {
                return;
            }
            if (existing.exportFrom != null) {
                env.printError(null, "export failed: class " + classdef.name +
                        " method " + method.name + " exported from " + existing.exportFrom +
                        " and " + fieldName);
            } else {
                env.printError(null, "export failed: class " + classdef.name +
                        " method " + method.name + " already defined");
            }
            return;
        }
        // TODO set isOverloaded?
        MethodDefinition clone = new MethodDefinition();
        clone.isPrivate = method.isPrivate;
        clone.isStatic = method.isStatic;
        clone.returnType = method.returnType;
        clone.name = method.name;
        clone.parameters.addAll(method.parameters);
        clone.exportFrom = fieldName;
        classdef.methodList.add(clone);
    }

    private static void verifyMethodDefined(ClassDefinition classdef, MethodDefinition method) {
        MethodDefinition existing = classdef.getMethod(method.name, method.parameters.size());
        if (existing == null || !sameSignature(method, existing)) {
            Environment env = Environment.getInstance();
            env.printError(null, "class " + classdef.name + " must define method " + method.name);
        }
    }

    private static boolean sameSignature(MethodDefinition md1, MethodDefinition md2) {
        if (!(md1.isStatic == md2.isStatic && md1.returnType.equals(md2.returnType))) {
            return false;
        }
        int count = md1.parameters.size();
        for (int idx = 0; idx < count; idx++) {
            if (!md1.parameters.get(idx).equals(md2.parameters.get(idx))) {
                return false;
            }
        }
        return true;
    }

    static void translateSuperclasses(ClassDefinition classdef, String variableName) {
        Environment env = Environment.getInstance();
        String prefix = variableName + "->" + ClassDefinition.SUPER_FIELD_NAME;
        while (classdef.superclass != null) {
            env.print(prefix + ".object = " + variableName + ";");
            for (MethodDefinition method : classdef.superclass.methodList) {
                if (method.isPrivate || method.isStatic) {
                    continue;
                }
                MethodDefinition override = classdef.getMethod(
                        method.name, method.parameters.size());
                if (override == null || override.isInherited()) {
                    continue;
                }
                String cName = TranslationUtils.translateMethodName(classdef.name, override);
                env.print(prefix + "." + method.name + " = " + cName + ";");
            }
            prefix = prefix + "." + ClassDefinition.SUPER_FIELD_NAME;
            classdef = classdef.superclass;
        }
    }
}
