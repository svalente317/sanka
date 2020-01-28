package sanka;

import sanka.ClassDefinition.FieldDefinition;

class ExportUtils {
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
                addMethodToClass(classdef, null, method, false);
            }
        }
        classdef.exportStatus = 1;
        return true;
    }

    private static void addMethodToClass(ClassDefinition classdef, String fieldName,
            MethodDefinition method, boolean isImplicit) {
        Environment env = Environment.getInstance();
        int numArgs = method.parameters.size();
        MethodDefinition existing = classdef.getMethod(method.name, numArgs);
        if (existing != null) {
            if (fieldName == null) {
                if (!sameSignature(method, existing)) {
                    env.printError(null, "class " + classdef.name + " method " + existing.name +
                            ": signature incompatible with " + classdef.superclass.name);
                }
                existing.overrideCount = method.overrideCount + 1;
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
        if (fieldName == null) {
            clone.overrideCount = method.overrideCount + 1;
        }
        classdef.methodList.add(clone);
        if (!classdef.isAbstract && fieldName == null &&
             classdef.getMethodWithBody(method.name, numArgs) == null) {
            env.printError(null, "class " + classdef.name + " must define method " + method.name);
        }
    }

    private static boolean sameSignature(MethodDefinition md1, MethodDefinition md2) {
        if (!(md1.isStatic == md2.isStatic && md1.returnType.equals(md2.returnType))) {
            return false;
        }
        int count = md1.parameters.size();
        for (int idx = 0; idx < count; idx++) {
            if (!md1.parameters.get(idx).type.equals(md2.parameters.get(idx).type)) {
                return false;
            }
        }
        return true;
    }

    static void translateSuperclasses(ClassDefinition classdef, String variableName) {
        if (classdef.superclass == null) {
            return;
        }
        Environment env = Environment.getInstance();
        String prefix = variableName + "->";
        env.print(prefix + supers(classdef.depth()) + "object = " + variableName + ";");
        for (MethodDefinition method : classdef.methodList) {
            if (method.isPrivate || method.isStatic || method.overrideCount == 0) {
                continue;
            }
            String lhs = prefix + supers(method.overrideCount) + method.name;
            String cName = TranslationUtils.translateMethodName(classdef.name, method);
            env.print(lhs + " = (void *) " + cName + ";");
        }
    }

    static String supers(int count) {
        String result = "";
        for (int idx = 0; idx < count; idx++) {
            result = result + ClassDefinition.SUPER_FIELD_NAME + ".";
        }
        return result;
    }
}
