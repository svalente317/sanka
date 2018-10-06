package sanka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser;
import sanka.antlr4.SankaParser.CompilationUnitContext;
import sanka.antlr4.SankaParser.ImportDeclarationContext;
import sanka.antlr4.SankaParser.TypeDeclarationContext;

class Translator {

    public static void main(String[] argv) throws Exception {
        Environment env = Environment.getInstance();
        Translator translator = new Translator();
        List<CompilationUnitContext> contextList = new ArrayList<>();
        for (int idx = 0; idx < argv.length; idx++) {
            String filename = argv[idx];
            if (filename.equals("-I")) {
                idx++;
                env.addImportPath(argv[idx]);
                continue;
            }
            SankaLexer lexer = new SankaLexer(new ANTLRFileStream(filename));
            SankaParser parser = new SankaParser(new CommonTokenStream(lexer));
            contextList.add(parser.compilationUnit());
        }
        translator.parse(contextList);
        if (env.errorCount > 0) {
            return;
        }
        translator.evaluate();
        if (env.errorCount > 0) {
            return;
        }
        translator.translate();
    }

    /**
     * Pass 1: Parse each class. For each class, note the defined methods and signatures.
     */
    void parse(List<CompilationUnitContext> contextList) {
        ImportManager.getInstance().doImport(null, Environment.SANKA_LANG, "String");
        ImportManager.getInstance().doImport(null, Environment.SANKA_LANG, "System");
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
        for (ClassDefinition classdef : env.classList) {
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
        for (ClassDefinition classdef : env.classList) {
            if (!classdef.isImport) {
                TranslationUtils.translateClass(classdef, true);
                TranslationUtils.translateClass(classdef, false);
            }
        }
    }
}
