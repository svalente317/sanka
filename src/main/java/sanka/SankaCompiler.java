package sanka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser;
import sanka.antlr4.SankaParser.CompilationUnitContext;
import sanka.antlr4.SankaParser.ImportDeclarationContext;
import sanka.antlr4.SankaParser.TypeDeclarationContext;
import sanka.c.ClassTranslator;
import sanka.c.CompileManager;
import sanka.c.LibraryManager;

public class SankaCompiler {

    // On an uncaught exception, the system exits with status 1;
    // don't use that status for a more specific error.
    public static final int INVALID_ARGUMENT = 2;
    public static final int CANNOT_PARSE = 3;
    public static final int CANNOT_EVALUATE = 4;
    public static final int CANNOT_TRANSLATE = 5;

    boolean skipImports;

    public static void main(String[] argv) throws Exception {
        Environment env = Environment.getInstance();
        CompileManager compileManager = new CompileManager();
        LibraryManager libraryManager = new LibraryManager();
        SankaCompiler compiler = new SankaCompiler();
        String mainClass = null;
        String exeName = null;
        String libName = null;
        List<String> libraryList = new ArrayList<>();
        List<String> pkgList = new ArrayList<>();
        List<String> sankaList = new ArrayList<>();
        for (int idx = 0; idx < argv.length; idx++) {
            String arg = argv[idx];
            if (arg.equals("-I")) {
                idx++;
                env.addImportPath(argv[idx]);
                continue;
            }
            if (arg.equals("-L")) {
                idx++;
                env.addLibPath(argv[idx]);
                continue;
            }
            if (arg.equals("--top")) {
                idx++;
                env.topDirectory = argv[idx];
                continue;
            }
            if (arg.equals("--main")) {
                idx++;
                mainClass = argv[idx];
                continue;
            }
            if (arg.equals("--exe")) {
                idx++;
                exeName = argv[idx];
                continue;
            }
            if (arg.equals("--skip-imports")) {
                compiler.skipImports = true;
                continue;
            }
            if (arg.equals("--create-library")) {
                idx++;
                libName = argv[idx];
                continue;
            }
            if (arg.equals("--lib")) {
                idx++;
                libraryList.add(argv[idx]);
                continue;
            }
            if (arg.equals("--pkg-config")) {
              idx++;
              pkgList.add(argv[idx]);
              continue;
            }
            if (arg.startsWith("-l")) {
                compileManager.addCLibrary(arg);
                continue;
            }
            sankaList.add(arg);
        }
        if ((mainClass != null && exeName == null) || (mainClass == null && exeName != null)) {
            System.err.println("Specify --main and --exe together");
            System.exit(INVALID_ARGUMENT);
        }
        for (String library : libraryList) {
            libraryManager.unpackLibrary(library, compileManager);
        }
        for (String pkgName : pkgList) {
            compileManager.runPkgConfig(pkgName);
        }
        List<CompilationUnitContext> contextList = new ArrayList<>();
        for (String filename : sankaList) {
            SankaLexer lexer = new SankaLexer(CharStreams.fromFileName(filename));
            SankaParser parser = makeSankaParser(filename, lexer);
            contextList.add(parser.compilationUnit());
        }
        if (env.errorCount > 0) {
            System.exit(CANNOT_PARSE);
        }
        compiler.parse(contextList);
        if (env.errorCount > 0) {
            System.exit(CANNOT_PARSE);
        }
        compiler.evaluate();
        if (env.errorCount > 0) {
            System.exit(CANNOT_EVALUATE);
        }
        compiler.translate();
        if (env.errorCount > 0) {
            System.exit(CANNOT_TRANSLATE);
        }
        if (libName != null) {
            libraryManager.createLibrary(libName, compileManager);
        }
        if (mainClass != null) {
            compileManager.compile(mainClass, exeName);
        }
        libraryManager.cleanup();
    }

    public static SankaParser makeSankaParser(String filename, SankaLexer lexer) {
        SankaParser parser = new SankaParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(new MyParseErrorListener(filename));
        return parser;
    }

    /**
     * Pass 1: Parse each class. For each class, note the defined methods and
     * signatures.
     */
    void parse(List<CompilationUnitContext> contextList) {
        if (!this.skipImports) {
            ImportManager.getInstance().importClass(Environment.SANKA_LANG, "String");
            ImportManager.getInstance().importClass(Environment.SANKA_LANG, "System");
        }
        for (CompilationUnitContext ctx : contextList) {
            parseClassNames(ctx);
        }
        for (CompilationUnitContext ctx : contextList) {
            parse(ctx);
        }
        Environment env = Environment.getInstance();
        for (ClassDefinition classdef : env.classList) {
            // TODO set currentPackage?
            classdef.finalizeParse();
        }
    }

    void parseClassNames(CompilationUnitContext ctx) {
        Environment env = Environment.getInstance();
        if (ctx.packageDeclaration() != null) {
            env.currentPackage = ctx.packageDeclaration().qualifiedName().getText();
        }
        if (ctx.typeDeclaration() == null) {
            return;
        }
        for (TypeDeclarationContext item : ctx.typeDeclaration()) {
            String name = null;
            if (item.classDeclaration() != null) {
                name = item.classDeclaration().Identifier().getText();
            }
            if (item.interfaceDeclaration() != null) {
                name = item.interfaceDeclaration().Identifier().getText();
            }
            if (name != null) {
                ClassDefinition classdef = new ClassDefinition();
                classdef.packageName = env.currentPackage;
                classdef.name = name;
                if (env.getClassDefinition(classdef.packageName, classdef.name) != null) {
                    env.printError(item, "class " + classdef.qualifiedName() + " defined twice");
                }
                env.classList.add(classdef);
            }
        }
    }

    void parse(CompilationUnitContext ctx) {
        Environment env = Environment.getInstance();
        if (ctx.packageDeclaration() != null) {
            env.currentPackage = ctx.packageDeclaration().qualifiedName().getText();
        }
        env.classPackageMap = env.baseClassPackageMap(true);
        if (ctx.importDeclaration() != null) {
            for (ImportDeclarationContext item : ctx.importDeclaration()) {
                ImportManager.getInstance().doImport(item.qualifiedName());
            }
        }
        if (ctx.typeDeclaration() == null) {
            return;
        }
        for (TypeDeclarationContext item : ctx.typeDeclaration()) {
            if (item.classDeclaration() != null) {
                String name = item.classDeclaration().Identifier().getText();
                ClassDefinition classdef = env.getClassDefinition(env.currentPackage, name);
                classdef.classPackageMap = env.classPackageMap;
                classdef.parse(item.classDeclaration());
            }
            if (item.interfaceDeclaration() != null) {
                String name = item.interfaceDeclaration().Identifier().getText();
                ClassDefinition classdef = env.getClassDefinition(env.currentPackage, name);
                classdef.parseInterface(item.interfaceDeclaration());
            }
        }
        env.classPackageMap = null;
    }

    /**
     * Pass 2: Evaluate the type of each expression.
     */
    void evaluate() {
        Environment env = Environment.getInstance();
        // Take a snapshot of the classes to evaluate.
        // Do this now because env.classList can change while evaluating classes.
        ClassDefinition[] toEvaluate = env.classList.toArray(new ClassDefinition[0]);
        for (ClassDefinition classdef : toEvaluate) {
            classdef.evaluateConstants();
        }
        for (ClassDefinition classdef : toEvaluate) {
            if (!classdef.isImport) {
                classdef.evaluate();
            }
        }
    }

    /**
     * Pass 3: Translate to C code.
     */
    void translate() throws IOException {
        Environment env = Environment.getInstance();
        // Take a snapshot of the classes to evaluate.
        // Do this now because env.classList can change while translating classes --
        // ImportManager can import classes from libraries.
        ClassDefinition[] toTranslate = env.classList.toArray(new ClassDefinition[0]);
        for (ClassDefinition classdef : toTranslate) {
            if (!classdef.isImport) {
                ClassTranslator.translate(classdef);
            }
        }
    }
}
