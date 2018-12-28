package sanka;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser.ClassBodyDeclarationContext;
import sanka.antlr4.SankaParser.ClassDeclarationContext;
import sanka.antlr4.SankaParser.ConstDeclarationContext;
import sanka.antlr4.SankaParser.ExpressionContext;
import sanka.antlr4.SankaParser.FieldDeclarationContext;
import sanka.antlr4.SankaParser.FieldModifierContext;
import sanka.antlr4.SankaParser.InterfaceBodyDeclarationContext;
import sanka.antlr4.SankaParser.InterfaceDeclarationContext;
import sanka.antlr4.SankaParser.InterfaceMethodDeclarationContext;

class ClassDefinition {

    static class FieldDefinition {
        TypeDefinition type;
        boolean isPrivate;
        boolean isStatic;
        boolean isInline;
        boolean isConst;
        ExpressionContext expression;
        ExpressionDefinition value;
    }

    Map<String, String> classPackageMap;
    boolean isImport;
    boolean isInterface;
    String packageName;
    String name;
    Map<String, FieldDefinition> fieldMap;
    List<String> exports;
    MethodDefinition constructor;
    List<MethodDefinition> methodList;
    List<String> c_includes;
    List<String> c_fields;

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
            if (item.constDeclaration() != null) {
                parseConstDeclaration(item.constDeclaration());
            }
            if (item.fieldDeclaration() != null) {
                parseFields(item.fieldDeclaration());
            }
            if (item.getStart().getType() == SankaLexer.EXPORT) {
                List<TerminalNode> nodes = item.Identifier();
                String name = nodes.get(0).getText();
                if (nodes.size() > 1) {
                    name = name + "." + nodes.get(1).getText();
                }
                this.exports.add(name);
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
            if (item.getStart().getType() == SankaLexer.C__INCLUDE) {
                if (this.c_includes == null) {
                    this.c_includes = new LinkedList<>();
                }
                String literal = item.StringLiteral().getText();
                this.c_includes.add(LiteralUtils.evaluateStringLiteral(literal));
            }
            if (item.getStart().getType() == SankaLexer.C__FIELD) {
                if (this.c_fields == null) {
                    this.c_fields = new LinkedList<>();
                }
                String literal = item.StringLiteral().getText();
                this.c_fields.add(LiteralUtils.evaluateStringLiteral(literal));
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

    void parseConstDeclaration(ConstDeclarationContext ctx) {
        String name = ctx.Identifier().getText();
        FieldDefinition field = new FieldDefinition();
        field.isStatic = true;
        field.isConst = true;
        field.expression = ctx.expression();
        FieldDefinition prev = this.fieldMap.put(name, field);
        if (prev != null) {
            Environment env = Environment.getInstance();
            env.printError(ctx, "class " + this.name + " field " + name + " declared twice");
        }
    }

    void parseFields(FieldDeclarationContext ctx) {
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
        List<TerminalNode> identifierList = ctx.Identifier();
        FieldDefinition field = null;
        for (TerminalNode identifier : identifierList) {
            String name = identifier.getText();
            field = new FieldDefinition();
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
        if (ctx.expression() == null) {
            return;
        }
        assert(identifierList.size() == 1);
        field.expression = ctx.expression();
        if (field.expression != null && !field.isStatic) {
            Environment env = Environment.getInstance();
            env.printError(ctx, "only static fields may have initial values outside " +
                    "the constructor.");
        }
    }

    void parseInterface(InterfaceDeclarationContext ctx) {
        Environment env = Environment.getInstance();
        this.isInterface = true;
        this.name = ctx.Identifier().getText();
        if (ctx.interfaceBody().interfaceBodyDeclaration() == null) {
            return;
        }
        for (InterfaceBodyDeclarationContext item : ctx.interfaceBody().interfaceBodyDeclaration()) {
            if (item.constDeclaration() != null) {
                parseConstDeclaration(item.constDeclaration());
            }
            if (item.interfaceMethodDeclaration() != null) {
                MethodDefinition method = new MethodDefinition();
                InterfaceMethodDeclarationContext im = item.interfaceMethodDeclaration();
                method.parse(im.fieldModifier(), im.typeType(), im.Identifier().getText(),
                        im.formalParameters(), null);
                if (method.isPrivate) {
                    env.printError(ctx, "interface " + this.name + " methods cannot be private");
                }
                if (getMethod(method.name) != null) {
                    env.printError(ctx, "interface " + this.name + " method " + method.name +
                            " already defined");
                }
                this.methodList.add(method);
            }
        }
    }

    void evaluate() {
        Environment env = Environment.getInstance();
        env.currentClass = this;
        for (FieldDefinition field : this.fieldMap.values()) {
            if (field.expression != null) {
                field.value = new ExpressionDefinition();
                field.value.evaluate(field.expression);
                if (field.value.value == null) {
                    env.printError(field.expression, "initial value must be simple constant");
                }
                if (field.isConst) {
                    field.type = field.value.type;
                } else if (!TypeUtils.isCompatible(field.type, field.value)) {
                     env.printError(field.expression, "incompatible types: " +
                             field.value.type + " cannot be converted to " + field.type);
                }
            }
        }
        if (this.isInterface) {
            return;
        }
        if (this.constructor != null) {
            this.constructor.evaluate();
        }
        for (MethodDefinition method : this.methodList) {
            method.evaluate();
        }
    }

    TypeDefinition toTypeDefinition() {
        TypeDefinition type = new TypeDefinition();
        type.packageName = this.packageName;
        type.name = this.name;
        return type;
    }

    void translateHeader() {
        if (this.isInterface) {
            translateInterfaceHeader();
            return;
        }
        Environment env = Environment.getInstance();
        env.typeList.clear();
        env.print("struct " + this.name + " {");
        env.level++;
        for (Map.Entry<String, FieldDefinition> entry : this.fieldMap.entrySet()) {
            FieldDefinition field = entry.getValue();
            if (field.isStatic) {
                continue;
            }
            env.addType(field.type);
            env.print(field.type.translateSpace() + entry.getKey() + ";");
        }
        if (this.c_fields != null) {
            for (String cfield : this.c_fields) {
                env.print(cfield + ";");
            }
        }
        env.level--;
        env.print("};");
        for (Map.Entry<String, FieldDefinition> entry : this.fieldMap.entrySet()) {
            FieldDefinition field = entry.getValue();
            if (field.isStatic) {
                StringBuilder builder = new StringBuilder();
                builder.append("extern ");
                if (field.isConst) {
                    builder.append("const ");
                }
                env.addType(field.type);
                builder.append(field.type.translateSpace());
                builder.append(TranslationUtils.translateClassItem(this.name, entry.getKey()));
                builder.append(";");
                env.print(builder.toString());
            }
        }
        if (this.constructor != null) {
            this.constructor.returnType = TypeDefinition.VOID_TYPE;
            this.constructor.translate(this, true);
        }
        for (MethodDefinition method : this.methodList) {
            method.translate(this, true);
        }
    }

    void translateInterfaceHeader() {
        Environment env = Environment.getInstance();
        env.typeList.clear();
        env.print("struct " + this.name + " {");
        env.level++;
        env.print("void *object;");
        for (MethodDefinition method : this.methodList) {
            method.translateInterface(this);
        }
        env.level--;
        env.print("};");
        env.print("");
        StringBuilder builder = makeInterfaceConstructor();
        builder.append(";");
        env.print(builder.toString());
        for (MethodDefinition method : this.methodList) {
            method.translate(this, true);
        }
    }

    StringBuilder makeInterfaceConstructor() {
        StringBuilder builder = new StringBuilder();
        builder.append("void ");
        builder.append(TranslationUtils.translateClassItem(this.name, this.name));
        builder.append("(");
        builder.append(toTypeDefinition().translateSpace());
        builder.append("this, void *object");
        for (MethodDefinition method : this.methodList) {
            builder.append(", void *");
            builder.append(method.name);
        }
        builder.append(")");
        return builder;
    }

    void translate() {
        if (this.isInterface) {
            translateInterface();
            return;
        }
        Environment env = Environment.getInstance();
        env.typeList.clear();
        boolean printedSomething = false;
        for (Map.Entry<String, FieldDefinition> entry : this.fieldMap.entrySet()) {
            FieldDefinition field = entry.getValue();
            if (field.isStatic) {
                StringBuilder builder = new StringBuilder();
                if (field.isConst) {
                    builder.append("const ");
                }
                env.addType(field.type);
                builder.append(field.type.translateSpace());
                builder.append(TranslationUtils.translateClassItem(this.name, entry.getKey()));
                builder.append(" = ");
                builder.append(field.value == null ? "0" : field.value.translate(null));
                builder.append(";");
                env.print(builder.toString());
                printedSomething = true;
            }
        }
        if (this.constructor != null) {
            if (printedSomething) {
                env.print("");
            }
            this.constructor.translate(this, false);
            printedSomething = true;
        }
        for (MethodDefinition method : this.methodList) {
            if (printedSomething) {
                env.print("");
            }
            method.translate(this, false);
            printedSomething = true;
        }
    }

    void translateInterface() {
        Environment env = Environment.getInstance();
        env.typeList.clear();
        StringBuilder builder = makeInterfaceConstructor();
        builder.append(" {");
        env.print(builder.toString());
        env.level++;
        env.print("this->object = object;");
        for (MethodDefinition method : this.methodList) {
            env.print("this->" + method.name + " = " + method.name + ";");
        }
        env.level--;
        env.print("}");
        for (MethodDefinition method : this.methodList) {
            env.print("");
            method.translate(this, false);
        }
    }
}
