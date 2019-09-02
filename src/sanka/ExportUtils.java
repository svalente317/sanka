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
            if (methodName != null) {
                MethodDefinition method = superclass.getMethod(methodName, null);
                if (method == null) {
                    env.printError(null, "export " + classdef.qualifiedName() + "." + fieldName +
                            ": method " + methodName + " not found");
                    continue;
                }
                if (method.isPrivate) {
                    env.printError(null, "cannot export " + classdef.qualifiedName() +
                            "." + fieldName + ": method is private");
                    continue;
                }
                if (method.isOverloaded) {
                    for (MethodDefinition imethod : classdef.methodList) {
                        if (imethod.name.equals(methodName)) {
                            addMethodToClass(classdef, fieldName, imethod, true);
                        }
                    }
                } else {
                    addMethodToClass(classdef, fieldName, method, true);
                }
            } else {
                for (MethodDefinition method : superclass.methodList) {
                    if (!method.isPrivate) {
                        addMethodToClass(classdef, fieldName, method, false);
                    }
                }
            }
        }
        classdef.exportStatus = 1;
        return true;
    }

    static void addMethodToClass(ClassDefinition classdef, String fieldName,
            MethodDefinition method, boolean force) {
        Environment env = Environment.getInstance();
        MethodDefinition existing = classdef.getMethod(method.name, method.parameters.size());
        if (existing != null) {
            // Implicit exported methods do not override explicitly defined methods.
            if (force == false && existing.exportFrom == null) {
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
}
