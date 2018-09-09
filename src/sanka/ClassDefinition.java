package sanka;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser.ClassBodyDeclarationContext;
import sanka.antlr4.SankaParser.ClassDeclarationContext;
import sanka.antlr4.SankaParser.FieldDeclarationContext;
import sanka.antlr4.SankaParser.FieldModifierContext;

class ClassDefinition {

    static class FieldDefinition {
        TypeDefinition type;
        boolean isPrivate;
        boolean isStatic;
        boolean isInline;
    }

    boolean isImport;
    boolean isInterface;
    String packageName;
    String name;
    String[] typeParameters;
    Map<String, FieldDefinition> fieldMap;
    List<String> exports;
    MethodDefinition constructor;
    List<MethodDefinition> methodList;

    ClassDefinition() {
        this.fieldMap = new TreeMap<>();
        this.methodList = new LinkedList<>();
        this.exports = new LinkedList<>();
    }

    String qualifiedName() {
        return this.packageName == null ? this.name : this.packageName + "." + this.name;
    }

    void parse(ClassDeclarationContext ctx) {
        Environment env = Environment.getInstance();
        this.name = ctx.Identifier().getText();
        if (ctx.classBody().classBodyDeclaration() == null) {
            return;
        }
        for (ClassBodyDeclarationContext item : ctx.classBody().classBodyDeclaration()) {
            if (item.fieldDeclaration() != null) {
                parseFields(item.fieldDeclaration());
            }
            if (item.Identifier() != null) {
                this.exports.add(item.Identifier().getText());
            }
            if (item.constructorDeclaration() != null) {
                String name = item.constructorDeclaration().Identifier().getText();
                if (!this.name.equals(name)) {
                    env.printError(ctx, "method " + this.name + "." + name + " missing return type");
                    continue;
                }
                if (this.constructor != null) {
                    env.printError(ctx, "class " + this.name + " constructor already defined");
                    continue;
                }
                MethodDefinition method = new MethodDefinition();
                method.parse(null, null, name,
                        item.constructorDeclaration().formalParameters(),
                        item.constructorDeclaration().block());
                this.constructor = method;
            }
            if (item.methodDeclaration() != null) {
                MethodDefinition method = new MethodDefinition();
                method.parse(item.methodDeclaration());
                if (method.name.equals(this.name)) {
                    env.printError(ctx, "class " + this.name +
                            " constructor cannot have return type");
                }
                if (getMethod(method.name) != null) {
                    env.printError(ctx, "class " + this.name + " method " + method.name +
                            " already defined");
                }
                this.methodList.add(method);
            }
        }
    }

    MethodDefinition getMethod(String name) {
        for (MethodDefinition method : this.methodList) {
            if (method.name.equals(name)) {
                return method;
            }
        }
        return null;
    }

    private void parseFields(FieldDeclarationContext ctx) {
        boolean isPrivate = false;
        boolean isStatic = false;
        boolean isInline = false;
        if (ctx.fieldModifier() != null) {
            for (FieldModifierContext item : ctx.fieldModifier()) {
                int modifier = item.getStart().getType();
                if (modifier == SankaLexer.PRIVATE) {
                    isPrivate = true;
                }
                if (modifier == SankaLexer.STATIC) {
                    isStatic = true;
                }
                if (modifier == SankaLexer.INLINE) {
                    isInline = true;
                }
            }
        }
        for (TerminalNode item : ctx.Identifier()) {
            String name = item.getText();
            FieldDefinition field = new FieldDefinition();
            field.type = new TypeDefinition();
            field.type.parse(ctx.typeType());
            field.isPrivate = isPrivate;
            field.isStatic = isStatic;
            field.isInline = isInline;
            FieldDefinition prev = this.fieldMap.put(name, field);
            if (prev != null) {
                Environment env = Environment.getInstance();
                env.printError(ctx, "class " + this.name + " field " + name + " declared twice");
            }
        }
    }

    static ClassDefinition arrayClassDefinition() {
        ClassDefinition classdef = new ClassDefinition();
        FieldDefinition field = new FieldDefinition();
        field.type = TypeDefinition.INT_TYPE;
        classdef.fieldMap.put("length", field);
        return classdef;
    }

    void evaluate() {
        Environment env = Environment.getInstance();
        env.currentClass = this;
        for (FieldDefinition field : this.fieldMap.values()) {
            field.type.evaluate();
        }
        if (this.constructor != null) {
            this.constructor.evaluate();
        }
        for (MethodDefinition method : this.methodList) {
            method.evaluate();
        }
    }

    void translate() {
        Environment env = Environment.getInstance();
        env.print("struct " + this.name + " {");
        env.level++;
        for (Map.Entry<String, FieldDefinition> entry : this.fieldMap.entrySet()) {
            FieldDefinition field = entry.getValue();
            if (field.isStatic) {
                continue;
            }
            env.print(field.type.translateSpace() + entry.getKey() + ";");
        }
        env.level--;
        env.print("};");
        if (this.constructor != null) {
            this.constructor.returnType = TypeDefinition.VOID_TYPE;
            env.print("");
            this.constructor.translate(this.name);
        }
        for (MethodDefinition method : this.methodList) {
            env.print("");
            method.translate(this.name);
        }
    }
}
