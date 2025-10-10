package sanka;

import java.io.Writer;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Environment {
    public static final String SANKA_LANG = "sanka.lang";

    // Pass 1.
    public List<String> importPath;
    public List<String> libPath;
    public List<ClassDefinition> classList;
    String currentPackage;
    Map<String, String> classPackageMap;
    public int errorCount = 0;

    // Pass 2.
    public ClassDefinition currentClass;
    public MethodDefinition currentMethod;
    public SymbolTable symbolTable;

    // Pass 3.
    public String topDirectory;
    public Writer writer = null;
    public int level = 0;
    public int tmpVariableCount = 0;
    public SortedSet<TypeDefinition> referencedTypes;


    Environment() {
        this.classList = new LinkedList<>();
        this.symbolTable = new SymbolTable();
        this.referencedTypes = new TreeSet<>();
    }

    // Pass 1

    public void addImportPath(String importDir) {
        if (this.importPath == null) {
            this.importPath = new LinkedList<>();
        }
        this.importPath.add(importDir);
    }

    public void addLibPath(String libDir) {
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

    public void printError(ParserRuleContext ctx, String error) {
        String prefix = "error";
        if (ctx != null) {
            Token token = ctx.getStart();
            prefix = token.getTokenSource().getSourceName() + ":" + token.getLine();
        }
        System.out.println(prefix + ": " + error);
        this.errorCount++;
    }

    public ClassDefinition getClassDefinition(String packageName, String name) {
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

    public ClassDefinition loadClassDefinition(TypeDefinition type) {
        if (type.isPrimitiveType || type.arrayOf != null) {
            return null;
        }
        ClassDefinition classdef = getClassDefinition(type.packageName, type.name);
        if (classdef != null || type.packageName == null) {
            return classdef;
        }
        ImportManager.getInstance().importClass(type.packageName, type.name);
        return getClassDefinition(type.packageName, type.name);
    }

    // Pass 3

    public void print(String text) {
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
                this.writer.write(System.getProperty("line.separator"));
            } catch (Exception exception) {
                printError(null, "write failure: " + exception);
            }
        }
    }

    public void addType(TypeDefinition type) {
        type = type.baseType();
        if (!type.isPrimitiveType) {
            this.referencedTypes.add(type);
        }
    }

    public String getTmpVariable() {
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

    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }
}
