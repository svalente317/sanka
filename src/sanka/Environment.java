package sanka;

import java.io.BufferedWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.antlr.v4.runtime.ParserRuleContext;

class Environment {

    // Pass 1.
    List<ClassDefinition> classList;
    String currentPackage;
    Map<String, String> classPackageMap;
    int errorCount = 0;

    // Pass 2.
    ClassDefinition currentClass;
    MethodDefinition currentMethod;
    SymbolTable symbolTable;
    SortedSet<TypeDefinition> typeList;

    // Pass 3.
    BufferedWriter writer = null;
    int level = 0;
    int tmpVariableCount = 0;

    Environment() {
        this.classList = new LinkedList<>();
        this.classPackageMap = new TreeMap<>();
        this.symbolTable = new SymbolTable();
        this.typeList = new TreeSet<>();
    }

    // Pass 1

    void printError(ParserRuleContext ctx, String error) {
        int line = ctx == null ? 0 : ctx.getStart().getLine();
        System.out.println("" + line + ": " + error);
        this.errorCount++;
    }

    ClassDefinition getClassDefinition(String packageName, String name) {
        if (name == null) {
            return null;
        }
        for (ClassDefinition classdef : this.classList) {
            boolean samePackage = classdef.packageName == null ?
                    packageName == null : classdef.packageName.equals(packageName);
            if (samePackage && classdef.name.equals(name)) {
                return classdef;
            }
        }
        return null;
    }

    // Pass 2

    ClassDefinition getClassDefinition(TypeDefinition typeDefinition) {
        return getClassDefinition(typeDefinition.packageName, typeDefinition.name);
    }

    // Pass 3

    void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }

    void print(String text) {
        String prefix = "";
        for (int i = 0; i < this.level; i++) {
            prefix = "    " + prefix;
        }
        text = prefix + text;
        if (this.writer == null) {
            System.out.println(text);
        } else {
            try {
                this.writer.write(text);
                this.writer.newLine();
            } catch (Exception exception) {
                printError(null, "write failure: " + exception);
            }
        }
    }

    void addType(TypeDefinition type) {
        type = type.baseType();
        if (!type.isPrimitiveType) {
            this.typeList.add(type);
        }
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
