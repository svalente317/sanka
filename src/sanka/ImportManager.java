package sanka;

import sanka.antlr4.SankaParser.QualifiedNameContext;

public class ImportManager {
    /**
     * Add an entry to ClassPackageMap indicating that the given short name refers to
     * the given qualified name.
     */
    void parse(QualifiedNameContext ctx) {

    }

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
    void doImport(QualifiedNameContext ctx) {

    }

    static ImportManager instance = null;

    static ImportManager getInstance() {
        if (instance == null) {
            instance = new ImportManager();
        }
        return instance;
    }
}
