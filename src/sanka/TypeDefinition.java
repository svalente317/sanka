package sanka;

import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.antlr4.SankaParser.ClassOrInterfaceTypeContext;
import sanka.antlr4.SankaParser.PrimitiveTypeContext;
import sanka.antlr4.SankaParser.TypeTypeContext;

class TypeDefinition {

    static final TypeDefinition NULL_TYPE = new TypeDefinition("null");
    static final TypeDefinition VOID_TYPE = new TypeDefinition("void");
    static final TypeDefinition BOOLEAN_TYPE = new TypeDefinition("boolean");
    static final TypeDefinition CHAR_TYPE = new TypeDefinition("char");
    static final TypeDefinition INT_TYPE = new TypeDefinition("int");
    static final TypeDefinition DOUBLE_TYPE = new TypeDefinition("double");
    static final TypeDefinition METHOD_TYPE = new TypeDefinition("method");
    static final TypeDefinition STRING_TYPE = new TypeDefinition(null, "String");

    String primitiveType;
    String packageName;
    String typeName;
    int arrayCount;

    TypeDefinition() {
    }

    TypeDefinition(String primitiveType) {
        this.primitiveType = primitiveType;
    }

    TypeDefinition(String primitiveType, String typeName) {
        this.primitiveType = primitiveType;
        this.typeName = typeName;
    }

    TypeDefinition copy() {
        TypeDefinition copy = new TypeDefinition(this.primitiveType, this.typeName);
        copy.packageName = this.packageName;
        copy.arrayCount = this.arrayCount;
        return copy;
    }

    public boolean equals(TypeDefinition that) {
        return true;
    }

    @Override
    public String toString() {
        String text = "undefined";
        if (this.primitiveType != null) {
            text = this.primitiveType;
        }
        else if (this.typeName != null) {
            if (this.packageName != null) {
                text = this.packageName + "." + this.typeName;
            } else {
                text = this.typeName;
            }
        }
        if (this.arrayCount > 0) {
            for (int i = 0; i < this.arrayCount; i++) {
                text += "[]";
            }
        }
        return text;
    }

    void parse(TypeTypeContext ctx) {
        Environment env = Environment.getInstance();
        parse(ctx.primitiveType(), ctx.classOrInterfaceType());
        int childCount = ctx.getChildCount();
        if (childCount > 1) {
            // Verify that all remaining tokens are [].
            for (int i = 1; i < childCount; i+= 2) {
                String ls = ctx.getChild(i).getText();
                String rs = ctx.getChild(i+1).getText();
                if (!(ls.equals("[") && rs.equals("]"))) {
                    env.printError(ctx, "unrecognized type");
                }
                this.arrayCount++;
            }
        }
    }

    void parse(PrimitiveTypeContext primitiveCtx, ClassOrInterfaceTypeContext classCtx) {
        if (primitiveCtx != null) {
            Token token = primitiveCtx.getStart();
            this.primitiveType = token.getText();
        }
        if (classCtx != null) {
            List<TerminalNode> ids = classCtx.Identifier();
            int idCount = ids.size();
            if (idCount == 1) {
                this.typeName = ids.get(0).getText();
            } else {
                this.packageName = ids.get(0).getText();
                for (int i = 1; i < idCount-1; i++) {
                    this.packageName += "." + ids.get(i).getText();
                }
                this.typeName = ids.get(idCount-1).getText();
            }
        }
    }

    boolean isNullType() {
        return this.primitiveType != null && this.arrayCount == 0 &&
                this.primitiveType.equals("null");
    }

    boolean isBooleanType() {
        return this.primitiveType != null && this.arrayCount == 0 &&
                this.primitiveType.equals("boolean");
    }

    boolean isIntegralType() {
        return this.primitiveType != null && this.arrayCount == 0 &&
                (this.primitiveType.equals("int") || this.primitiveType.equals("long"));
    }

    boolean isNumericType() {
        return this.primitiveType != null && this.arrayCount == 0 &&
                (this.primitiveType.equals("int") ||
                        this.primitiveType.equals("long") ||
                        this.primitiveType.equals("float") ||
                        this.primitiveType.equals("double") ||
                        this.primitiveType.equals("char"));
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
            return this.typeName != null || this.arrayCount > 0;
        }
        if (this.arrayCount != that.arrayCount) {
            return false;
        }
        if (this.primitiveType != null) {
            // TODO promotions of primitive types?
            return this.primitiveType.equals(that.primitiveType);
        }
        // TODO package names - relative, absolute?
        // TODO interfaces?
        return this.typeName.equals(that.typeName);
    }

    String translate() {
        if (this.arrayCount > 0) {
            return "struct array ";
        }
        if (this.primitiveType != null) {
            return this.primitiveType + " ";
        }
        // TODO packageName
        return "struct " + this.typeName + " *";
    }
}
