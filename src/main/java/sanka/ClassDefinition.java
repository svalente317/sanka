package sanka;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser.ClassBodyDeclarationContext;
import sanka.antlr4.SankaParser.ClassDeclarationContext;
import sanka.antlr4.SankaParser.ClassModifierContext;
import sanka.antlr4.SankaParser.ConstDeclarationContext;
import sanka.antlr4.SankaParser.ConstructorDeclarationContext;
import sanka.antlr4.SankaParser.ExpressionContext;
import sanka.antlr4.SankaParser.FieldDeclarationContext;
import sanka.antlr4.SankaParser.FieldModifierContext;
import sanka.antlr4.SankaParser.InterfaceBodyDeclarationContext;
import sanka.antlr4.SankaParser.InterfaceDeclarationContext;
import sanka.antlr4.SankaParser.InterfaceMethodDeclarationContext;

public class ClassDefinition {
    public static final String SUPER_FIELD_NAME = "super";

    public static class FieldDefinition {
        ExpressionContext expression;
        public String name;
        public TypeDefinition type;
        public boolean isPrivate;
        public boolean isStatic;
        public boolean isInline;
        public boolean isConst;

        // This is the initial value for static fields, and the constant value for const fields.
        // It is always a compile-time constant stored as a String in value.value.
        // For numeric constants, the expressionType is LITERAL.
        // For String constants, it may be either LITERAL or a FIELD_ACCESS that refers to
        // another constant field.
        public ExpressionDefinition value;
    }

    Map<String, String> classPackageMap;
    public boolean isImport;
    public boolean isInterface;
    public boolean isAbstract;
    public boolean isSerializable;
    public boolean isSingleton;
    public boolean isAnonymous;
    public String packageName;
    public String name;
    public ClassDefinition superclass;
    public List<FieldDefinition> fieldList;
    public List<MethodDefinition> methodList;
    public List<String> c_includes;
    public List<String> c_fields;
    public String c_repr;
    public List<String> c_stmts;
    public TypeDefinition atThisType;
    int parseStatus;
    int constantsStatus;
    int anonymousCount;

    ClassDefinition() {
        this.fieldList = new LinkedList<>();
        this.methodList = new LinkedList<>();
    }

    String qualifiedName() {
        return this.packageName == null ? this.name : this.packageName + "." + this.name;
    }

    void parse(ClassDeclarationContext ctx) {
        Environment env = Environment.getInstance();
        this.name = ctx.Identifier().getText();
        if (ctx.classModifier() != null) {
             for (ClassModifierContext item : ctx.classModifier()) {
                 String modifier = item.Identifier().getText();
                 switch (modifier) {
                 case "abstract":
                     this.isAbstract = true;
                     break;
                 case "serializable":
                     this.isSerializable = true;
                     break;
                 case "singleton":
                     this.isSingleton = true;
                     break;
                 default:
                     env.printError(item, "class modifier " + modifier + " undefined");
                     break;
                 }
             }
        }
        if (ctx.extendsClass() != null) {
            TypeDefinition type = new TypeDefinition();
            type.parse(ctx.extendsClass().classType());
            if (!type.isPrimitiveType && type.arrayOf == null) {
                this.superclass = env.loadClassDefinition(type);
            }
            if (this.superclass == null) {
                env.printError(ctx, "superclass " + type + " not found");
            }
        }
        if (ctx.classBody().classBodyDeclaration() == null) {
            return;
        }
        for (ClassBodyDeclarationContext item : ctx.classBody().classBodyDeclaration()) {
            parseClassBodyDeclaration(item);
        }
        if (this.isSerializable) {
            SerializableUtils.addMethodsToClass(this);
        }
        if (this.isSingleton) {
            SingletonUtils.addMethodsToClass(this);
        }
    }

    void parseClassBodyDeclaration(ClassBodyDeclarationContext item) {
        Environment env = Environment.getInstance();
        if (item.constDeclaration() != null) {
            parseConstDeclaration(item.constDeclaration());
        }
        if (item.fieldDeclaration() != null) {
            parseFields(item.fieldDeclaration());
        }
        if (item.constructorDeclaration() != null) {
            ConstructorDeclarationContext ctx = item.constructorDeclaration();
            String name = ctx.Identifier().getText();
            if (!this.name.equals(name)) {
                env.printError(item, "method " + name + " missing return type");
                return;
            }
            if (this.isAbstract) {
                env.printError(item, "abstract class cannot have constructor");
                return;
            }
            if (this.isAnonymous) {
                env.printError(item, "anonymous class cannot have constructor");
                return;
            }
            MethodDefinition method;
            if (ctx.formalParameters() != null) {
                method = new MethodDefinition();
                method.parse(null, null, name, ctx.formalParameters(), ctx.block());
            } else {
                method = ConstructorUtils.makeAutoConstructor(this, ctx.identifierList());
                if (method == null) {
                    return;
                }
            }
            int numArgs = method.parameters.size();
            MethodDefinition prevMethod = getMethod(method.name, numArgs);
            if (prevMethod != null) {
                env.printError(item, "ctx " + this.name + " constructor already defined" +
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
                env.printError(item, "class " + this.name +
                        " constructor cannot have return type");
            }
            int numArgs = method.parameters.size();
            MethodDefinition prevMethod = getMethod(method.name, numArgs);
            if (prevMethod != null) {
                env.printError(item, "class " + this.name + " method " + method.name +
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
        if (item.getStart().getType() == SankaLexer.C__REPR) {
            if (this.c_repr != null) {
                env.printError(item, "class may only have one c__repr");
            }
            if (this.isInterface || this.isSerializable || this.isAnonymous) {
                env.printError(item, "invalid use of c__repr");
            }
            String literal = item.StringLiteral().getText();
            this.c_repr = LiteralUtils.evaluateStringLiteral(literal);
        }
        if (item.getStart().getType() == SankaLexer.C__STMT) {
            if (this.c_stmts == null) {
                this.c_stmts = new LinkedList<>();
            }
            String literal = item.StringLiteral().getText();
            this.c_stmts.add(LiteralUtils.evaluateStringLiteral(literal));
        }
    }

    boolean hasConstructor() {
        for (MethodDefinition method : this.methodList) {
            if (method.name.equals(this.name)) {
                return true;
            }
        }
        return false;
    }

    public MethodDefinition getMethod(String name, Integer numArgs) {
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
     * Get a non-constructor method.
     */
    MethodDefinition getNamedMethod(String methodName) {
        return methodName.equals(this.name) ? null : getMethod(methodName, null);
    }

    public FieldDefinition getField(String name) {
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
        ClassDefinition halfInterface = null;
        if (ctx.extendsClass() != null) {
            TypeDefinition type = new TypeDefinition();
            type.parse(ctx.extendsClass().classType());
            if (type.isPrimitiveType || type.arrayOf != null) {
                env.printError(ctx, "interface must extend interface, not " + type);
            } else {
                halfInterface = env.loadClassDefinition(type);
                if (halfInterface == null) {
                    env.printError(ctx, "interface " + type + " not defined");
                } else if (!halfInterface.isInterface) {
                    env.printError(ctx, "interface must extend interface, not " + type);
                }
            }
        }
        if (halfInterface != null) {
            // Maybe we should clone the fields and methods?
            this.fieldList.addAll(halfInterface.fieldList);
            this.methodList.addAll(halfInterface.methodList);
        }
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

    /**
     * Recursive function to add inherited methods to methodList.
     */
    boolean finalizeParse() {
        Environment env = Environment.getInstance();
        if (this.parseStatus > 0) {
            return true;
        }
        if (this.parseStatus < 0) {
            env.printError(null, qualifiedName() + ": class parse loop detected");
            return false;
        }
        this.parseStatus = -1;
        if (this.superclass != null && this.superclass.finalizeParse()) {
            if (!this.superclass.isAbstract) {
                env.printError(null, "cannot extend " + this.superclass.qualifiedName() +
                        " because it is not abstract");
                return false;
            }
            for (MethodDefinition method : this.superclass.methodList) {
                if (method.isPrivate || method.isStatic) {
                    continue;
                }
                addMethodToClass(method);
            }
        }
        this.parseStatus = 1;
        return true;
    }

    private void addMethodToClass(MethodDefinition method) {
        Environment env = Environment.getInstance();
        int numArgs = method.parameters.size();
        MethodDefinition existing = getMethod(method.name, numArgs);
        if (existing != null) {
            if (!method.sameSignature(existing)) {
                env.printError(null, "class " + this.name + " method " + existing.name +
                        ": signature incompatible with " + this.superclass.name);
            }
            existing.overrideCount = method.overrideCount + 1;
            return;
        }
        // TODO What if base class defines method(1 arg) and superclass defines method(2 args)?
        MethodDefinition clone = new MethodDefinition();
        clone.isPrivate = method.isPrivate;
        clone.isStatic = method.isStatic;
        clone.returnType = method.returnType;
        clone.name = method.name;
        clone.parameters.addAll(method.parameters);
        clone.overrideCount = method.overrideCount + 1;
        this.methodList.add(clone);
        if (!this.isAbstract && getMethodWithBody(method.name, numArgs) == null) {
            env.printError(null, "class " + this.name + " must define method " + method.name);
        }
    }

    public void addPublicField(ParserRuleContext ctx, String name, TypeDefinition type) {
        Environment env = Environment.getInstance();
        if (getField(name) != null) {
            env.printError(ctx, "field " + name + " declared twice");
            return;
        }
        FieldDefinition field = new FieldDefinition();
        field.name = name;
        field.type = type;
        this.fieldList.add(field);
    }

    public int depth() {
        int result = 0;
        ClassDefinition current = this.superclass;
        while (current != null) {
            result++;
            current = current.superclass;
        }
        return result;
    }

    void evaluateConstants() {
        Environment env = Environment.getInstance();
        if (this.constantsStatus > 0) {
            return;
        }
        if (this.constantsStatus < 0) {
            env.printError(null, qualifiedName() + ": detected loop between constant values");
            return;
        }
        this.constantsStatus = -1;
        ClassDefinition oldCurrentClass = env.currentClass;
        Map<String, String> oldClassPackageMap = env.classPackageMap;
        env.currentClass = this;
        env.classPackageMap = this.classPackageMap;
        for (FieldDefinition field : this.fieldList) {
            if (field.isConst && field.expression != null) {
                ExpressionDefinition expr = new ExpressionDefinition();
                expr.evaluate(field.expression);
                if (expr.value == null) {
                    env.printError(field.expression, "initial value must be simple constant");
                }
                field.type = expr.type;
                field.value = expr;
            }
        }
        env.currentClass = oldCurrentClass;
        env.classPackageMap = oldClassPackageMap;
        this.constantsStatus = 1;
    }

    void evaluate() {
        Environment env = Environment.getInstance();
        // TODO is this the right place to define env.currentPackage?
        env.currentPackage = this.packageName;
        var parentClass = env.currentClass;
        env.currentClass = this;
        var parentThisClass = env.atThisClass;
        env.atThisClass = parentClass;
        env.classPackageMap = this.classPackageMap;
        if (this.c_repr != null && (this.c_fields != null || hasVariableField())) {
            env.printError(null, "cannot use c__repr with non-constant field");
        }
        // TODO c_repr != null && superclass != null ? must have same c_repr
        for (FieldDefinition field : this.fieldList) {
            if (!field.isConst && field.expression != null) {
                ExpressionDefinition expr = new ExpressionDefinition();
                expr.evaluate(field.expression);
                if (expr.value == null) {
                    env.printError(field.expression, "initial value must be simple constant");
                } else if (!TypeUtils.isCompatible(field.type, expr)) {
                     env.printError(field.expression, "incompatible types: " +
                             expr.type + " cannot be converted to " + field.type);
                }
                field.value = expr;
            }
        }
        if (!this.isInterface) {
            for (MethodDefinition method : this.methodList) {
                method.evaluate();
            }
        }
        env.atThisClass = parentThisClass;
        env.currentClass = parentClass;
    }

    private boolean hasVariableField() {
        for (FieldDefinition field : this.fieldList) {
            if (!field.isConst) {
                return true;
            }
        }
        if (this.superclass != null) {
            return this.superclass.hasVariableField();
        }
        return false;
    }

    public TypeDefinition toTypeDefinition() {
        TypeDefinition type = new TypeDefinition();
        type.packageName = this.packageName;
        type.name = this.name;
        return type;
    }
}
