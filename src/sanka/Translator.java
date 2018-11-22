package sanka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser;
import sanka.antlr4.SankaParser.CompilationUnitContext;
import sanka.antlr4.SankaParser.ImportDeclarationContext;
import sanka.antlr4.SankaParser.TypeDeclarationContext;

class Translator {

    // On an uncaught exception, the system exits with status 1;
    // don't use that status for a more specific error.
    public static final int INVALID_ARGUMENT = 2;
    public static final int CANNOT_PARSE = 3;
    public static final int CANNOT_EVALUATE = 4;
    public static final int CANNOT_TRANSLATE = 5;

    boolean skipImports;

    public static void main(String[] argv) throws Exception {
        Environment env = Environment.getInstance();
        Translator translator = new Translator();
        List<CompilationUnitContext> contextList = new ArrayList<>();
        String mainClass = null;
        String exeName = null;
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
                translator.skipImports = true;
                continue;
            }
            if ((mainClass != null && exeName == null) ||
                (mainClass == null && exeName != null)) {
                System.err.println("Specify --main and --exe together");
                System.exit(INVALID_ARGUMENT);
            }
            SankaLexer lexer = new SankaLexer(new ANTLRFileStream(arg));
            SankaParser parser = new SankaParser(new CommonTokenStream(lexer));
            contextList.add(parser.compilationUnit());
        }
        translator.parse(contextList);
        if (env.errorCount > 0) {
            System.exit(CANNOT_PARSE);
        }
        translator.evaluate();
        if (env.errorCount > 0) {
            System.exit(CANNOT_EVALUATE);
        }
        translator.translate();
        if (env.errorCount > 0) {
            System.exit(CANNOT_TRANSLATE);
        }
        if (mainClass != null) {
            CompileManager.getInstance().compile(mainClass, exeName);
        }
    }

    /**
     * Pass 1: Parse each class. For each class, note the defined methods and signatures.
     */
    void parse(List<CompilationUnitContext> contextList) {
        if (!this.skipImports) {
            ImportManager.getInstance().doImport(null, Environment.SANKA_LANG, "String");
            ImportManager.getInstance().doImport(null, Environment.SANKA_LANG, "System");
        }
        for (CompilationUnitContext ctx : contextList) {
            parseClassNames(ctx);
        }
        for (CompilationUnitContext ctx : contextList) {
            parse(ctx);
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
                env.classList.add(classdef);
            }
        }
    }

    void parse(CompilationUnitContext ctx) {
        Environment env = Environment.getInstance();
        env.classPackageMap = env.baseClassPackageMap(true);
        if (ctx.packageDeclaration() != null) {
            env.currentPackage = ctx.packageDeclaration().qualifiedName().getText();
        }
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
                classdef.parse(item.classDeclaration());
            }
            if (item.interfaceDeclaration() != null) {
                String name = item.interfaceDeclaration().Identifier().getText();
                ClassDefinition classdef = env.getClassDefinition(env.currentPackage, name);
                classdef.parseInterface(item.interfaceDeclaration());
            }
        }
    }

    /**
     * Pass 2: Evaluate the type of each expression.
     */
    void evaluate() {
        Environment env = Environment.getInstance();
        // Take a snapshot of the classes to evaluate.
        // Do this now because env.classList can change while evaluating classes.
        List<ClassDefinition> toEvaluate = new LinkedList<>();
        for (ClassDefinition classdef : env.classList) {
            if (!classdef.isImport) {
                toEvaluate.add(classdef);
            }
        }
        for (ClassDefinition classdef : toEvaluate) {
            classdef.evaluate();
        }
    }

    /**
     * Pass 3: Translate to C code.
     */
    void translate() throws IOException {
        Environment env = Environment.getInstance();
        for (ClassDefinition classdef : env.classList) {
            if (!classdef.isImport) {
                TranslationUtils.translateClass(classdef, true);
                TranslationUtils.translateClass(classdef, false);
            }
        }
    }
}
