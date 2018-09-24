package sanka;

import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.antlr4.SankaParser.TypeTypeContext;

class TypeDefinition implements Comparable<TypeDefinition> {

    static final TypeDefinition NULL_TYPE = new TypeDefinition("null");
    static final TypeDefinition VOID_TYPE = new TypeDefinition("void");
    static final TypeDefinition BOOLEAN_TYPE = new TypeDefinition("boolean");
    static final TypeDefinition BYTE_TYPE = new TypeDefinition("byte");
    static final TypeDefinition INT_TYPE = new TypeDefinition("int");
    static final TypeDefinition DOUBLE_TYPE = new TypeDefinition("double");
    static final TypeDefinition METHOD_TYPE = new TypeDefinition("method");
    static final TypeDefinition STRING_TYPE = new TypeDefinition("String");

    boolean isPrimitiveType;
    String packageName;
    String name;
    TypeDefinition arrayOf;
    TypeDefinition keyType;

    TypeDefinition() {
    }

    private TypeDefinition(String name) {
        if (!name.equals("String")) {
            this.isPrimitiveType = true;
        } else {
            this.packageName = "sanka.lang";
        }
        this.name = name;
    }

    TypeDefinition copy() {
        TypeDefinition copy = new TypeDefinition();
        copy.isPrimitiveType = this.isPrimitiveType;
        copy.packageName = this.packageName;
        copy.name = this.name;
        copy.arrayOf = this.arrayOf == null ? null : this.arrayOf.copy();
        copy.keyType = this.keyType;
        return copy;
    }

    @Override
    public String toString() {
        if (this.keyType != null) {
            return this.arrayOf.toString() + "[" + this.keyType.toString() + "]";
        }
        if (this.arrayOf != null) {
            return this.arrayOf.toString() + "[]";
        }
        if (this.name == null) {
            return "null";
        }
        if (this.packageName != null) {
            return this.packageName + "." + this.name;
        }
        return this.name;
    }

    void parse(TypeTypeContext ctx) {
        List<TypeTypeContext> subctx = ctx.typeType();
        if (subctx != null && !subctx.isEmpty()) {
            this.arrayOf = new TypeDefinition();
            this.arrayOf.parse(subctx.get(0));
            if (subctx.size() > 1) {
                this.keyType = new TypeDefinition();
                this.keyType.parse(subctx.get(1));
            }
            return;
        }
        if (ctx.primitiveType() != null) {
            Token token = ctx.primitiveType().getStart();
            this.isPrimitiveType = true;
            this.name = token.getText();
        }
        if (ctx.classOrInterfaceType() != null) {
            List<TerminalNode> ids = ctx.classOrInterfaceType().Identifier();
            int idCount = ids.size();
            if (idCount == 1) {
                this.name = ids.get(0).getText();
            } else {
                this.packageName = ids.get(0).getText();
                for (int i = 1; i < idCount-1; i++) {
                    this.packageName += "." + ids.get(i).getText();
                }
                this.name = ids.get(idCount-1).getText();
            }
        }
        if (this.isPrimitiveType || this.packageName != null || this.name == null) {
            return;
        }
        Environment env = Environment.getInstance();
        this.packageName = env.classPackageMap.get(this.name);
        if (this.packageName == null) {
            this.packageName = env.currentPackage;
        }
    }

    boolean isNullType() {
        return this.isPrimitiveType && this.name.equals("null");
    }

    boolean isVoidType() {
        return this.isPrimitiveType && this.name.equals("void");
    }

    boolean isBooleanType() {
        return this.isPrimitiveType && this.name.equals("boolean");
    }

    boolean isIntegralType() {
        return this.isPrimitiveType &&
                (this.name.equals("int") || this.name.equals("long") || this.name.equals("short"));
    }

    boolean isNumericType() {
        return this.isPrimitiveType &&
                (this.name.equals("int") || this.name.equals("long") ||
                        this.name.equals("float") || this.name.equals("double") ||
                        this.name.equals("short") || this.name.equals("byte"));
    }

    boolean isStringType() {
        return this.equals(STRING_TYPE);
    }

    /**
     * isCompatible() is part of the evaluate pass.
     *
     * "this" is an empty slot with a well defined type, such as a declared
     * variable, or an object's field, or a method parameter, or a return type.
     *
     * "that" is the expression to be stored in the slot, such as the RHS of
     * an assignment, or an argument to pass to a method, or a value to return.
     */
    boolean isCompatible(TypeDefinition that) {
        if (that == null) {
            // We've already printed an error. We won't continue to the next pass.
            // Finish this pass.
            return true;
        }
        if (that.isNullType()) {
            // Match null and non-primitive classes and arrays and maps.
            return this.isNullType() || !this.isPrimitiveType;
        }
        if (this.arrayOf != null) {
            if (that.arrayOf == null) {
                return false;
            }
            // With arrays and maps, there's no promotion.
            // If the parameter is an array of ints, then the expression must be
            // an array of ints. An array of shorts is not a match.
            // That's why this function is not recursive.
            if (!this.arrayOf.equals(that.arrayOf)) {
                return false;
            }
            if (this.keyType != null) {
                if (that.keyType == null) {
                    return false;
                }
                if (!this.keyType.equals(that.keyType)) {
                    return false;
                }
            } else {
                if (that.keyType != null) {
                    return false;
                }
            }
            return true;
        }
        if (this.isPrimitiveType != that.isPrimitiveType) {
            return false;
        }
        boolean samePackage = this.packageName == null ? that.packageName == null :
            this.packageName.equals(that.packageName);
        return samePackage && this.name.equals(that.name);
    }

    String translate() {
        if (this.keyType != null) {
            return "struct rb_table *";
        }
        if (this.arrayOf != null) {
            return "struct array *";
        }
        if (this.isPrimitiveType) {
            if (this.name.equals("boolean")) {
                return "int";
            }
            if (this.name.equals("byte")) {
                return "char";
            }
            return this.name;
        }
        return "struct " + this.name + " *";
    }

    String translateSpace() {
        String text = translate();
        return text.endsWith("*") ? text : text + " ";
    }

    String translateDereference() {
        if (this.keyType != null) {
            return "struct rb_table";
        }
        if (this.arrayOf != null) {
            return this.arrayOf.translate();
        }
        if (this.isPrimitiveType) {
            return null;
        }
        return "struct " + this.name;
    }

    static private <T> int compareObjects(Comparable<T> o1, T o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.compareTo(o2);
    }

    @Override
    public int compareTo(TypeDefinition that) {
        int value = compareObjects(this.packageName, that.packageName);
        if (value != 0) {
            return value;
        }
        value = compareObjects(this.name, that.name);
        if (value != 0) {
            return value;
        }
        value = compareObjects(this.arrayOf, that.arrayOf);
        if (value != 0) {
            return value;
        }
        return compareObjects(this.keyType, that.keyType);
    }

    @Override
    public boolean equals(Object that) {
        return this.compareTo((TypeDefinition) that) == 0;
    }

    TypeDefinition baseType() {
        return this.arrayOf == null ? this : this.arrayOf.baseType();
    }
}
