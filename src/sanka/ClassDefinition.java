package sanka;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser.ClassBodyDeclarationContext;
import sanka.antlr4.SankaParser.ClassDeclarationContext;
import sanka.antlr4.SankaParser.ClassModifierContext;
import sanka.antlr4.SankaParser.ConstDeclarationContext;
import sanka.antlr4.SankaParser.ExpressionContext;
import sanka.antlr4.SankaParser.FieldDeclarationContext;
import sanka.antlr4.SankaParser.FieldModifierContext;
import sanka.antlr4.SankaParser.InterfaceBodyDeclarationContext;
import sanka.antlr4.SankaParser.InterfaceDeclarationContext;
import sanka.antlr4.SankaParser.InterfaceMethodDeclarationContext;

class ClassDefinition {
    public static final String SUPER_FIELD_NAME = "super";

    static class FieldDefinition {
        String name;
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
    boolean isAbstract;
    boolean isSerializable;
    String packageName;
    String name;
    ClassDefinition superclass;
    List<FieldDefinition> fieldList;
    List<String> exports;
    List<MethodDefinition> methodList;
    List<String> c_includes;
    List<String> c_fields;
    int exportStatus;

    ClassDefinition() {
        this.fieldList = new LinkedList<>();
        this.methodList = new LinkedList<>();
        this.exports = new LinkedList<>();
    }

    String qualifiedName() {
        return this.packageName == null ? this.name : this.packageName + "." + this.name;
    }

    void parse(ClassDeclarationContext ctx) {
        Environment env = Environment.getInstance();
        this.name = ctx.Identifier().getText();
        ClassModifierContext mod = ctx.classModifier();
        if (mod != null && mod.getStart().getType() == SankaLexer.ABSTRACT) {
            this.isAbstract = true;
        }
        if (mod != null && mod.getStart().getType() == SankaLexer.SERIALIZABLE) {
            this.isSerializable = true;
        }
        if (ctx.extendsClass() != null) {
            TypeDefinition type = new TypeDefinition();
            type.parse(ctx.extendsClass().typeType());
            if (!type.isPrimitiveType && type.arrayOf == null) {
                this.superclass = env.getClassDefinition(type);
                if (this.superclass == null) {
                    ImportManager.getInstance().doImport(ctx, type.packageName, type.name);
                    this.superclass = env.getClassDefinition(type);
                }
            }
            if (this.superclass == null) {
                env.printError(ctx, "superclass " + type + " not found");
            }
        }
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
                    env.printError(ctx, "method " + name + " missing return type");
                    continue;
                }
                if (this.isAbstract) {
                    env.printError(ctx, "abstract class cannot have constructor");
                    continue;
                }
                MethodDefinition method = new MethodDefinition();
                method.parse(null, null, name,
                        item.constructorDeclaration().formalParameters(),
                        item.constructorDeclaration().block());
                int numArgs = method.parameters.size();
                MethodDefinition prevMethod = getMethod(method.name, numArgs);
                if (prevMethod != null) {
                    env.printError(ctx, "class " + this.name + " constructor already defined" +
                            " with " + numArgs + " parameters");
                }
                prevMethod = getMethod(method.name, null);
                if (prevMethod != null) {
                    prevMethod.isOverloaded = true;
                    method.isOverloaded = true;
                }
                this.methodList.add(method);
            }
            if (item.methodDeclaration() != null) {
                MethodDefinition method = new MethodDefinition();
                method.parse(item.methodDeclaration());
                if (method.name.equals(this.name)) {
                    env.printError(ctx, "class " + this.name +
                            " constructor cannot have return type");
                }
                int numArgs = method.parameters.size();
                MethodDefinition prevMethod = getMethod(method.name, numArgs);
                if (prevMethod != null) {
                    env.printError(ctx, "class " + this.name + " method " + method.name +
                            " already defined with " + numArgs + " parameters");
                }
                prevMethod = getMethod(method.name, null);
                if (prevMethod != null) {
                    prevMethod.isOverloaded = true;
                    method.isOverloaded = true;
                }
                if (method.blockContext == null && !this.isAbstract) {
                    env.printError(item, "class " + this.name + " is not abstract; " +
                            "method " + method.name + " missing body");
                }
                if (method.blockContext == null && method.isPrivate) {
                    env.printError(item, "abstract method " + method.name + " must be public");
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
        if (this.isSerializable) {
            SerializableUtils.addMethodsToClass(this);
        }
    }

    MethodDefinition getMethod(String name, Integer numArgs) {
        for (MethodDefinition method : this.methodList) {
            if (method.name.equals(name)) {
                if (numArgs == null || numArgs == method.parameters.size()) {
                    return method;
                }
            }
        }
        return null;
    }

    MethodDefinition getMethodWithBody(String name, Integer numArgs) {
        ClassDefinition current = this;
        while (current != null) {
            MethodDefinition method = current.getMethod(name, numArgs);
            if (method == null || method.hasBody()) {
                return method;
            }
            current = current.superclass;
        }
        return null;
    }

    /**
     * Get a non-contructor method.
     */
    MethodDefinition getNamedMethod(String methodName) {
        return methodName.equals(this.name) ? null : getMethod(methodName, null);
    }

    FieldDefinition getField(String name) {
        for (FieldDefinition field : this.fieldList) {
            if (field.name.equals(name)) {
                return field;
            }
        }
        return null;
    }

    void parseConstDeclaration(ConstDeclarationContext ctx) {
        String name = ctx.Identifier().getText();
        if (getField(name) != null) {
            Environment env = Environment.getInstance();
            env.printError(ctx, "class " + this.name + " field " + name + " declared twice");
        }
        FieldDefinition field = new FieldDefinition();
        field.name = name;
        field.isStatic = true;
        field.isConst = true;
        field.expression = ctx.expression();
        this.fieldList.add(field);
    }

    void parseFields(FieldDeclarationContext ctx) {
        Environment env = Environment.getInstance();
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
        if (this.isAbstract && !isPrivate) {
            env.printError(ctx, "abstract class fields must be private");
        }
        List<TerminalNode> identifierList = ctx.Identifier();
        FieldDefinition field = null;
        for (TerminalNode identifier : identifierList) {
            String name = identifier.getText();
            if (getField(name) != null) {
                env.printError(ctx, "class " + this.name + " field " + name + " declared twice");
            }
            field = new FieldDefinition();
            field.name = name;
            field.type = new TypeDefinition();
            field.type.parse(ctx.typeType());
            field.isPrivate = isPrivate;
            field.isStatic = isStatic;
            field.isInline = isInline;
            this.fieldList.add(field);
        }
        if (ctx.expression() == null) {
            return;
        }
        assert(identifierList.size() == 1);
        field.expression = ctx.expression();
        if (field.expression != null && !field.isStatic) {
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
                MethodDefinition prevMethod = getMethod(method.name, method.parameters.size());
                if (prevMethod != null) {
                    env.printError(ctx, "interface " + this.name + " method " + method.name +
                            " already defined");
                }
                prevMethod = getMethod(method.name, null);
                if (prevMethod != null) {
                    prevMethod.isOverloaded = true;
                    method.isOverloaded = true;
                }
                this.methodList.add(method);
            }
        }
    }

    int depth() {
        int result = 0;
        ClassDefinition current = this.superclass;
        while (current != null) {
            result++;
            current = current.superclass;
        }
        return result;
    }

    void evaluate() {
        Environment env = Environment.getInstance();
        env.currentClass = this;
        for (FieldDefinition field : this.fieldList) {
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
        for (MethodDefinition method : this.methodList) {
            method.evaluate();
        }
    }

    void evaluateConstants() {
        Environment env = Environment.getInstance();
        ClassDefinition oldCurrentClass = env.currentClass;
        env.currentClass = this;
        for (FieldDefinition field : this.fieldList) {
            if (field.isConst && field.expression != null) {
                field.value = new ExpressionDefinition();
                field.value.evaluate(field.expression);
                if (field.value.value == null) {
                    env.printError(field.expression, "initial value must be simple constant");
                }
                field.type = field.value.type;
            }
        }
        env.currentClass = oldCurrentClass;
    }

    TypeDefinition toTypeDefinition() {
        TypeDefinition type = new TypeDefinition();
        type.packageName = this.packageName;
        type.name = this.name;
        return type;
    }

    void translateHeader() {
        Environment env = Environment.getInstance();
        env.typeList.clear();
        env.print("struct " + this.name + " {");
        env.level++;
        if (this.superclass != null) {
            env.addType(this.superclass.toTypeDefinition());
            env.print(this.superclass.toTypeDefinition().translateDereference() + " " +
                    SUPER_FIELD_NAME + ";");
        }
        if (this.isAbstract) {
            if (this.superclass == null) {
                env.print("void *object;");
            }
            for (MethodDefinition method : this.methodList) {
                if (!(method.isPrivate || method.isStatic || method.overrideCount > 0)) {
                    method.translateInterface(this);
                }
            }
        }
        else if (this.isInterface) {
            env.print("void *object;");
            env.print("void *base;");
            for (MethodDefinition method : this.methodList) {
                if (!(method.isPrivate || method.isStatic)) {
                    method.translateInterface(this);
                }
            }
        }
        for (FieldDefinition field : this.fieldList) {
            if (field.isStatic) {
                continue;
            }
            env.addType(field.type);
            env.print(field.type.translateSpace() + field.name + ";");
        }
        if (this.c_fields != null) {
            for (String cfield : this.c_fields) {
                env.print(cfield + ";");
            }
        }
        env.level--;
        env.print("};");
        env.print("");
        for (FieldDefinition field : this.fieldList) {
            if (field.isStatic) {
                StringBuilder builder = new StringBuilder();
                builder.append("extern ");
                if (field.isConst) {
                    builder.append("const ");
                }
                env.addType(field.type);
                builder.append(field.type.translateSpace());
                builder.append(TranslationUtils.translateStaticField(this.name, field.name));
                builder.append(";");
                env.print(builder.toString());
            }
        }
        for (MethodDefinition method : this.methodList) {
            method.translate(this, true);
        }
    }


    void translateForward() {
        Environment env = Environment.getInstance();
        env.print("struct " + this.name + ";");
    }

    void translate() {
        Environment env = Environment.getInstance();
        env.typeList.clear();
        boolean printedSomething = false;
        for (FieldDefinition field: this.fieldList) {
            if (field.isStatic) {
                StringBuilder builder = new StringBuilder();
                if (field.isConst) {
                    builder.append("const ");
                }
                env.addType(field.type);
                builder.append(field.type.translateSpace());
                builder.append(TranslationUtils.translateStaticField(this.name, field.name));
                builder.append(" = ");
                builder.append(field.value == null ? "0" : field.value.translate(null));
                builder.append(";");
                env.print(builder.toString());
                printedSomething = true;
            }
        }
        for (MethodDefinition method : this.methodList) {
            if (printedSomething) {
                env.print("");
            }
            method.translate(this, false);
            printedSomething = true;
        }
    }
}
