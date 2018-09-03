package sanka;

import java.util.Map;
import java.util.TreeMap;

import org.antlr.v4.runtime.ParserRuleContext;

class Environment {

    Map<String, ClassDefinition> classMap;
    String currentPackage;
    int errorCount = 0;

    ClassDefinition currentClass;
    MethodDefinition currentMethod;
    Map<String, TypeDefinition> symbolTable;

    int level = 0;

    Environment() {
        this.classMap = new TreeMap<>();
    }

    void printError(ParserRuleContext ctx, String error) {
        int line = ctx.getStart().getLine();
        System.out.println("" + line + ": " + error);
        this.errorCount++;
    }

    void print(String text) {
        for (int i = 0; i < this.level; i++) {
            System.out.print("    ");
        }
        System.out.println(text);
    }

    ClassDefinition getClassDefinition(TypeDefinition typeDefinition) {
        // TODO implicit package?
        if (typeDefinition.typeName == null) {
            return null;
        }
        return this.classMap.get(typeDefinition.typeName);
    }

    static Environment instance = null;

    static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }
}
