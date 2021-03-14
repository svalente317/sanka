package sanka;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser;
import sanka.antlr4.SankaParser.CompilationUnitContext;
import sanka.antlr4.SankaParser.ImportDeclarationContext;
import sanka.antlr4.SankaParser.QualifiedNameContext;
import sanka.antlr4.SankaParser.TypeDeclarationContext;

public class ImportManager {
    /**
     * Find the sanka source file for the given class. Read the structure of the file -
     * the class's public fields and methods. Store the class in env.classList.
     *
     * Do not recursively import classes. We don't need to know the structure of classes
     * that are used by the imported class, because we're not parsing or evaluating the
     * code of the imported class. We're just reading signatures. (Unfortunately, this is
     * not really true. We may need to recursively import classes to evaluate the imported
     * class's constants.)
     *
     * If the given class is defined in one of the source files that we're translating,
     * then don't look for it in the class path.
     */
    void doImport(QualifiedNameContext importctx) {
        processImportContext(importctx, true);
    }

    private void processImportContext(QualifiedNameContext importctx, boolean doImport) {
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
        String className = ids.get(idCount-1).getText();
        if (doImport) {
            importFile(importctx, packageName, className, false);
        }
        env.classPackageMap.put(className, packageName);
    }

    /**
     * Read a class definition so that we can compare interfaces, etc. to it.
     */
    void importClass(String packageName, String className) {
        importFile(null, packageName, className, true);
    }

    /**
     * Read a class into env.classList during the parse or evaluate phase.
     */
    private void importFile(ParserRuleContext importctx, String packageName, String className,
            boolean evaluate) {
        Environment env = Environment.getInstance();
        if (env.getClassDefinition(packageName, className) != null) {
            return;
        }
        String filename = StringUtils.replaceDot(packageName, File.separatorChar) +
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
        SankaLexer lexer;
        try {
            lexer = new SankaLexer(CharStreams.fromFileName(pathname));
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
        if (ctx.importDeclaration() != null) {
            for (ImportDeclarationContext item : ctx.importDeclaration()) {
                processImportContext(item.qualifiedName(), false);
            }
        }
        for (TypeDeclarationContext item : ctx.typeDeclaration()) {
            if (item.classDeclaration() != null || item.interfaceDeclaration() != null) {
                ClassDefinition classdef = new ClassDefinition();
                classdef.isImport = true;
                classdef.packageName = env.currentPackage;
                if (item.classDeclaration() != null) {
                    classdef.parse(item.classDeclaration());
                }
                if (item.interfaceDeclaration() != null) {
                    classdef.parseInterface(item.interfaceDeclaration());
                }
                if (evaluate) {
                    classdef.evaluateConstants();
                }
                env.classList.add(classdef);
            }
        }
        env.currentPackage = origCurrentPackage;
        env.classPackageMap = origClassPackageMap;
    }

    static ImportManager instance = null;

    static ImportManager getInstance() {
        if (instance == null) {
            instance = new ImportManager();
        }
        return instance;
    }
}
