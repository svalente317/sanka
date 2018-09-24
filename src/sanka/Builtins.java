package sanka;

class Builtins {
    static void importBuiltins() {
        Environment env = Environment.getInstance();
        ClassDefinition stringClass = new ClassDefinition();
        stringClass.isImport = true;
        stringClass.packageName = TypeDefinition.STRING_TYPE.packageName;
        stringClass.name = TypeDefinition.STRING_TYPE.name;
        MethodDefinition md = new MethodDefinition();
        md.returnType = TypeDefinition.INT_TYPE;
        md.name = "size";
        stringClass.methodList.add(md);
        env.classList.add(stringClass);
    }
}