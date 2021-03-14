package sanka;

import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.antlr4.SankaParser;
import sanka.antlr4.SankaParser.TypeTypeContext;

public class TypeDefinition implements Comparable<TypeDefinition> {

    public static final TypeDefinition NULL_TYPE = new TypeDefinition("null");
    public static final TypeDefinition VOID_TYPE = new TypeDefinition("void");
    public static final TypeDefinition BOOLEAN_TYPE = new TypeDefinition("boolean");
    public static final TypeDefinition BYTE_TYPE = new TypeDefinition("byte");
    public static final TypeDefinition SHORT_TYPE = new TypeDefinition("short");
    public static final TypeDefinition INT_TYPE = new TypeDefinition("int");
    public static final TypeDefinition LONG_TYPE = new TypeDefinition("long");
    public static final TypeDefinition FLOAT_TYPE = new TypeDefinition("float");
    public static final TypeDefinition DOUBLE_TYPE = new TypeDefinition("double");
    public static final TypeDefinition STRING_TYPE = new TypeDefinition("String");
    public static final TypeDefinition METHOD_TYPE = new TypeDefinition("method");

    public boolean isPrimitiveType;
    public String packageName;
    public String name;
    public TypeDefinition arrayOf;
    public TypeDefinition keyType;

    TypeDefinition() {
    }

    private TypeDefinition(String name) {
        if (!name.equals("String")) {
            this.isPrimitiveType = true;
        } else {
            this.packageName = Environment.SANKA_LANG;
        }
        this.name = name;
    }

    TypeDefinition(String packageName, String name) {
        this.packageName = packageName;
        this.name = name;
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
            return;
        }
        if (ctx.classOrInterfaceType() != null) {
            parse(ctx.classOrInterfaceType());
        }
    }

    void parse(SankaParser.ClassOrInterfaceTypeContext ctx) {
        List<TerminalNode> ids = ctx.Identifier();
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
        if (this.packageName != null || this.name == null) {
            return;
        }
        Environment env = Environment.getInstance();
        this.packageName = env.classPackageMap.get(this.name);
        if (this.packageName == null) {
            this.packageName = env.currentPackage;
        }
    }

    public boolean isNullType() {
        return this.equals(NULL_TYPE);
    }

    public boolean isVoidType() {
        return this.equals(VOID_TYPE);
    }

    public boolean isBooleanType() {
        return this.equals(BOOLEAN_TYPE);
    }

    public boolean isIntegralType() {
        return this.isPrimitiveType &&
                (this.name.equals("int") || this.name.equals("long") ||
                 this.name.equals("short") || this.name.equals("byte"));
    }

    public boolean isNumericType() {
        return this.isPrimitiveType &&
                (this.name.equals("int") || this.name.equals("long") ||
                 this.name.equals("float") || this.name.equals("double") ||
                 this.name.equals("short") || this.name.equals("byte"));
    }

    public boolean isStringType() {
        return this.equals(STRING_TYPE);
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
