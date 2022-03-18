package sanka;

import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.antlr4.SankaParser.ArrayTypeContext;
import sanka.antlr4.SankaParser.ClassTypeContext;
import sanka.antlr4.SankaParser.MapTypeContext;
import sanka.antlr4.SankaParser.ScalarTypeContext;
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
            return "map[" + this.keyType.toString() + "]" + this.arrayOf.toString();
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

    public boolean parse(TypeTypeContext ctx) {
        if (ctx.scalarType() != null) {
            return parse(ctx.scalarType());
        }
        if (ctx.arrayType() != null) {
            return parse(ctx.arrayType());
        }
        if (ctx.mapType() != null) {
            return parse(ctx.mapType());
        }
        return false;
    }

    public boolean parse(ScalarTypeContext ctx) {
        if (ctx.primitiveType() != null) {
            Token token = ctx.primitiveType().getStart();
            this.isPrimitiveType = true;
            this.name = token.getText();
            return true;
        }
        if (ctx.classType() != null) {
            return parse(ctx.classType());
        }
        return false;
    }

    public boolean parse(ClassTypeContext ctx) {
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
        if (this.packageName == null && this.name != null) {
            Environment env = Environment.getInstance();
            this.packageName = env.classPackageMap.get(this.name);
            if (this.packageName == null) {
                this.packageName = env.currentPackage;
            }
        }
        return this.name != null;
    }

    public boolean parse(ArrayTypeContext ctx) {
        this.arrayOf = new TypeDefinition();
        if (ctx.arrayType() != null) {
            return this.arrayOf.parse(ctx.arrayType());
        }
        return this.arrayOf.parse(ctx.scalarType());
    }

    public boolean parse(MapTypeContext ctx) {
        Environment env = Environment.getInstance();
        String keyword = ctx.Identifier().getText();
        if (!keyword.equals("map")) {
            env.printError(ctx, "syntax error at: " + keyword);
            return false;
        }
        this.keyType = new TypeDefinition();
        this.keyType.parse(ctx.scalarType());
        this.arrayOf = new TypeDefinition();
        this.arrayOf.parse(ctx.typeType());
        return true;
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
