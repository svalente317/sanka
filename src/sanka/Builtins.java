package sanka;

class Builtins {
    static void importBuiltins() {
        Environment env = Environment.getInstance();
        ClassDefinition stringClass = new ClassDefinition();
        stringClass.isImport = true;
        // stringClass.packageName = "sanka";
        stringClass.name = "String";
        MethodDefinition md = new MethodDefinition();
        md.returnType = TypeDefinition.INT_TYPE;
        md.name = "size";
        stringClass.methodList.add(md);
        env.classList.add(stringClass);
    }
}