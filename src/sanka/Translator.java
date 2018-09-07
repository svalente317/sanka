package sanka;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser;
import sanka.antlr4.SankaParser.CompilationUnitContext;
import sanka.antlr4.SankaParser.TypeDeclarationContext;

class Translator {
    /**
     * Pass 1: Parse each class. For each class, note the defined methods and signatures.
     */
    void parse(CompilationUnitContext ctx) {
        Builtins.importBuiltins();
        Environment env = Environment.getInstance();
        if (ctx.packageDeclaration() != null) {
            env.currentPackage = ctx.packageDeclaration().qualifiedName().getText();
        }
        if (ctx.typeDeclaration() == null) {
            return;
        }
        for (TypeDeclarationContext item : ctx.typeDeclaration()) {
            parseTypeDeclaration(item);
        }
    }

    void parseTypeDeclaration(TypeDeclarationContext ctx) {
        Environment env = Environment.getInstance();
        if (ctx.classDeclaration() != null) {
            ClassDefinition classdef = new ClassDefinition();
            classdef.packageName = env.currentPackage;
            classdef.parse(ctx.classDeclaration());
            env.classList.add(classdef);
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
    void translate() {
        Environment env = Environment.getInstance();
        env.print("#include <sanka_header.h>");
        for (ClassDefinition classdef : env.classList) {
            if (!classdef.isImport) {
                env.print("");
                classdef.translate();
            }
        }
    }

    public static void main(String[] argv) throws Exception {
        String filename = argv[0];
        SankaLexer lexer = new SankaLexer(new ANTLRFileStream(filename));
        SankaParser parser = new SankaParser(new CommonTokenStream(lexer));
        Environment env = Environment.getInstance();
        CompilationUnitContext top = parser.compilationUnit();
        Translator translator = new Translator();
        translator.parse(top);
        if (env.errorCount > 0) {
            return;
        }
        translator.evaluate();
        if (env.errorCount > 0) {
            return;
        }
        translator.translate();
    }
}
