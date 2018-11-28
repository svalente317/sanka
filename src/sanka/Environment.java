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
    public static final String SANKA_LANG = "sanka.lang";

    // Pass 1.
    List<String> importPath;
    List<String> libPath;
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
    String topDirectory;
    BufferedWriter writer = null;
    int level = 0;
    int tmpVariableCount = 0;

    Environment() {
        this.classList = new LinkedList<>();
        this.symbolTable = new SymbolTable();
        this.typeList = new TreeSet<>();
    }

    // Pass 1

    void addImportPath(String importDir) {
        if (this.importPath == null) {
            this.importPath = new LinkedList<>();
        }
        this.importPath.add(importDir);
    }

    void addLibPath(String libDir) {
        if (this.libPath == null) {
            this.libPath = new LinkedList<>();
        }
        this.libPath.add(libDir);
    }

    /**
     * The classes in the sanka.lang package are pre-imported.
     */
    Map<String, String> baseClassPackageMap(boolean includeCurrentPackage) {
        Map<String, String> cpm = new TreeMap<>();
        for (ClassDefinition classdef : this.classList) {
            if (isSankaLangPackage(classdef) ||
                includeCurrentPackage && isCurrentPackage(classdef)) {
                cpm.put(classdef.name, classdef.packageName);
            }
        }
        return cpm;
    }

    boolean isSankaLangPackage(ClassDefinition classdef) {
        return classdef.packageName != null && classdef.packageName.equals(SANKA_LANG);
    }

    boolean isCurrentPackage(ClassDefinition classdef) {
        return (this.currentPackage == null ? classdef.packageName == null :
                this.currentPackage.equals(classdef.packageName));
    }

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
        if (typeDefinition.isPrimitiveType || typeDefinition.arrayOf != null) {
            return null;
        }
        return getClassDefinition(typeDefinition.packageName, typeDefinition.name);
    }

    // Pass 3

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
        String name = null;
        while (name == null) {
            this.tmpVariableCount++;
            name = "tmp" + this.tmpVariableCount;
            if (this.symbolTable.get(name) != null) {
                name = null;
            }
        }
        return name;
    }

    static Environment instance = null;

    static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }
}
