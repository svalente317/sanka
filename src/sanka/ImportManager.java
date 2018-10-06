package sanka;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser;
import sanka.antlr4.SankaParser.CompilationUnitContext;
import sanka.antlr4.SankaParser.QualifiedNameContext;
import sanka.antlr4.SankaParser.TypeDeclarationContext;

public class ImportManager {
    /**
     * Find the sanka source file for the given class. Read the structure of the file -
     * the class's public fields and methods. Store the class in env.classList.
     *
     * Do not recursively import classes. We don't need to know the structure of classes
     * that are used by the imported class, because we're not parsing or evaluating the
     * code of the imported class. We're just reading signatures.
     *
     * If the given class is defined in one of the source files that we're translating,
     * then don't look for it in the class path.
     */
    void doImport(QualifiedNameContext importctx) {
        Environment env = Environment.getInstance();
        List<TerminalNode> ids = importctx.Identifier();
        int idCount = ids.size();
        if (idCount < 2) {
            env.printError(importctx, "imported class requires package name and class name");
            return;
        }
        String packageName = ids.get(0).getText();
        for (int idx = 1; idx < (idCount-1); idx++) {
            packageName = packageName + "." + ids.get(idx).getText();
        }
        doImport(importctx, packageName, ids.get(idCount-1).getText());
    }

    void doImport(ParserRuleContext importctx, String packageName, String className) {
        Environment env = Environment.getInstance();
        if (env.getClassDefinition(packageName, className) != null) {
            return;
        }
        String filename = TranslationUtils.replaceDot(packageName, File.separatorChar) +
                File.separatorChar + className + ".san";
        String pathname = null;
        if (env.importPath == null) {
            File file = new File(filename);
            if (file.exists()) {
                pathname = filename;
            }
        } else {
            for (String importDir : env.importPath) {
                File file = new File(importDir, filename);
                if (file.exists()) {
                    pathname = file.getPath();
                    break;
                }
            }
        }
        if (pathname == null) {
            env.printError(importctx, "class " + packageName + "." + className +
                    " not found for import");
            return;
        }
        SankaLexer lexer = null;
        try {
            lexer = new SankaLexer(new ANTLRFileStream(pathname));
        } catch (IOException ioe) {
            if (importctx != null) {
                env.printError(importctx, pathname + ": " + ioe);
            }
            return;
        }
        SankaParser parser = new SankaParser(new CommonTokenStream(lexer));
        CompilationUnitContext ctx = parser.compilationUnit();
        // Push the environment into local variables so it can be restored after import.
        String origCurrentPackage = env.currentPackage;
        Map<String, String> origClassPackageMap = env.classPackageMap;
        env.currentPackage = packageName;
        env.classPackageMap = env.baseClassPackageMap(false);
        for (TypeDeclarationContext item : ctx.typeDeclaration()) {
            if (item.classDeclaration() != null) {
                ClassDefinition classdef = new ClassDefinition();
                classdef.isImport = true;
                classdef.packageName = env.currentPackage;
                classdef.name = item.classDeclaration().Identifier().getText();
                env.classList.add(classdef);
                classdef.parse(item.classDeclaration());
            }
        }
        env.currentPackage = origCurrentPackage;
        env.classPackageMap = origClassPackageMap;
        if (env.classPackageMap != null) {
            env.classPackageMap.put(className, packageName);
        }
    }

    static ImportManager instance = null;

    static ImportManager getInstance() {
        if (instance == null) {
            instance = new ImportManager();
        }
        return instance;
    }
}
