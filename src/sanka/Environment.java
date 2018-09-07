package sanka;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;

class Environment {

    List<ClassDefinition> classList;
    String currentPackage;
    int errorCount = 0;

    ClassDefinition currentClass;
    MethodDefinition currentMethod;
    Map<String, TypeDefinition> symbolTable;

    int level = 0;
    int tmpVariableCount = 0;

    Environment() {
        this.classList = new LinkedList<>();
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
        if (typeDefinition.name == null) {
            return null;
        }
        for (ClassDefinition classdef : this.classList) {
            if (classdef.qualifiedName().equals(typeDefinition.name)) {
                return classdef;
            }
        }
        return null;
    }

    String getTmpVariable() {
        this.tmpVariableCount++;
        return "tmp" + this.tmpVariableCount;
    }

    static Environment instance = null;

    static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }
}
