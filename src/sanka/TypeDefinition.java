package sanka;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
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
    static final TypeDefinition STRING_TYPE = new TypeDefinition("String");

    ParserRuleContext parserCtx;
    boolean isPrimitiveType;
    String packageName;
    String name;
    int arrayCount;

    TypeDefinition() {
    }

    private TypeDefinition(String name) {
        this.isPrimitiveType = !name.equals("String");
        this.name = name;
    }

    TypeDefinition copy() {
        TypeDefinition copy = new TypeDefinition();
        copy.isPrimitiveType = this.isPrimitiveType;
        copy.packageName = this.packageName;
        copy.name = this.name;
        copy.arrayCount = this.arrayCount;
        return copy;
    }

    @Override
    public String toString() {
        String text = "undefined";
        if (this.name != null) {
            if (this.packageName != null) {
                text = this.packageName + "." + this.name;
            } else {
                text = this.name;
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
        this.parserCtx = primitiveCtx;
        if (primitiveCtx != null) {
            Token token = primitiveCtx.getStart();
            this.isPrimitiveType = true;
            this.name = token.getText();
        }
        if (classCtx != null) {
            List<TerminalNode> ids = classCtx.Identifier();
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
    }

    boolean isNullType() {
        return this.isPrimitiveType && this.arrayCount == 0 && this.name.equals("null");
    }

    boolean isBooleanType() {
        return this.isPrimitiveType && this.arrayCount == 0 && this.name.equals("boolean");
    }

    boolean isIntegralType() {
        return this.isPrimitiveType && this.arrayCount == 0 &&
                (this.name.equals("int") || this.name.equals("long"));
    }

    boolean isNumericType() {
        return this.isPrimitiveType && this.arrayCount == 0 &&
                (this.name.equals("int") || this.name.equals("long") ||
                        this.name.equals("float") || this.name.equals("double") ||
                        this.name.equals("char"));
    }

    void evaluate() {
        if (this.isPrimitiveType || this.packageName != null || this.name == null) {
            return;
        }
        Environment env = Environment.getInstance();
        boolean found = false;
        for (ClassDefinition classdef : env.classList) {
             if (this.name.equals(classdef.name)) {
                 if (found) {
                     env.printError(this.parserCtx, "type " + this.name + " in package " +
                             this.packageName + " and " + classdef.packageName);
                        return;
                 }
                 this.packageName = classdef.packageName;
                 found = true;
             }
         }
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
            return this.isNullType() || !this.isPrimitiveType || this.arrayCount > 0;
        }
        if (this.arrayCount != that.arrayCount) {
            return false;
        }
        if (this.isPrimitiveType != that.isPrimitiveType) {
            return false;
        }
        boolean samePackage = this.packageName == null ? that.packageName == null :
            this.packageName.equals(that.packageName);
        return samePackage && this.name.equals(that.name);
    }

    String translate() {
        if (this.arrayCount > 0) {
            return "struct array *";
        }
        if (this.isPrimitiveType) {
            return this.name.equals("boolean") ? "int" : this.name;
        }
        return "struct " + this.name + " *";
    }

    String translateSpace() {
        String text = translate();
        return text.endsWith("*") ? text : text + " ";
    }

    String translateDereference() {
        if (this.arrayCount > 1) {
            return "struct array *";
        }
        if (this.isPrimitiveType) {
            return null;
        }
        return "struct " + this.name;
    }
}
