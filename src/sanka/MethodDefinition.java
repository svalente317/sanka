package sanka;

import java.util.ArrayList;
import java.util.List;

import sanka.ClassDefinition.FieldDefinition;
import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser.BlockContext;
import sanka.antlr4.SankaParser.FieldModifierContext;
import sanka.antlr4.SankaParser.FormalParameterContext;
import sanka.antlr4.SankaParser.FormalParameterListContext;
import sanka.antlr4.SankaParser.FormalParametersContext;
import sanka.antlr4.SankaParser.MethodDeclarationContext;
import sanka.antlr4.SankaParser.TypeTypeContext;

class MethodDefinition {

    static class ParameterDefinition {
        TypeDefinition type;
        String name;
    }

    static interface MethodGenerator {
        public void evaluate();
        public void translate();
    }

    boolean isPrivate;
    boolean isStatic;
    TypeDefinition returnType;
    String name;
    List<ParameterDefinition> parameters;
    boolean isOverloaded;
    BlockContext blockContext;
    BlockDefinition block;
    SymbolTable.Frame frame;
    String exportFrom;
    MethodGenerator generator;
    int overrideCount;

    MethodDefinition() {
        this.parameters = new ArrayList<>();
    }

    void parse(MethodDeclarationContext ctx) {
        parse(ctx.fieldModifier(), ctx.typeType(), ctx.Identifier().getText(),
                ctx.formalParameters(), ctx.block());
    }

    void parse(List<FieldModifierContext> fieldModifier, TypeTypeContext returnTypeCtx,
            String name, FormalParametersContext formalParameters, BlockContext blockContext) {
        if (fieldModifier != null) {
            for (FieldModifierContext item : fieldModifier) {
                int modifier = item.getStart().getType();
                if (modifier == SankaLexer.PRIVATE) {
                    this.isPrivate = true;
                }
                if (modifier == SankaLexer.STATIC) {
                    this.isStatic = true;
                }
            }
        }
        if (returnTypeCtx == null) {
            this.returnType = TypeDefinition.VOID_TYPE;
        } else {
            this.returnType = new TypeDefinition();
            this.returnType.parse(returnTypeCtx);
        }
        this.name = name;
        FormalParameterListContext fpc = formalParameters.formalParameterList();
        if (fpc != null) {
            if (fpc.formalParameter() != null) {
                for (FormalParameterContext item : fpc.formalParameter()) {
                    ParameterDefinition pd = new ParameterDefinition();
                    pd.type = new TypeDefinition();
                    pd.type.parse(item.typeType());
                    pd.name = item.Identifier().getText();
                    this.parameters.add(pd);
                }
            }
        }
        this.blockContext = blockContext;
    }

    boolean hasBody() {
        return this.blockContext != null || this.exportFrom != null || this.generator != null;
    }

    void evaluate() {
        Environment env = Environment.getInstance();
        env.currentMethod = this;
        env.symbolTable.push(null);
        for (ParameterDefinition param : this.parameters) {
            env.symbolTable.put(param.name, param.type);
        }
        if (this.blockContext != null) {
            this.block = new BlockDefinition();
            this.block.evaluate(this.blockContext);
        } else if (this.generator != null) {
            this.generator.evaluate();
        }
        this.frame = env.symbolTable.pop();
    }

    void translate(ClassDefinition classdef, boolean isHeader) {
        translate(classdef, isHeader, false);
        if (classdef.isAbstract && this.hasBody()) {
            if (!isHeader) {
                Environment.getInstance().print("");
            }
            translate(classdef, isHeader, true);
        }
    }

    private void translate(ClassDefinition classdef, boolean isHeader, boolean isBase) {
        Environment env = Environment.getInstance();
        String name = TranslationUtils.translateMethodName(classdef.name, this);
        if (isBase) {
            name = TranslationUtils.getBaseTranslatedName(name);
        }
        StringBuilder builder = new StringBuilder();
        if (this.isPrivate) {
            builder.append("/* private */ ");
        }
        env.addType(this.returnType);
        builder.append(this.returnType.translateSpace());
        builder.append(name);
        builder.append("(");
        boolean needComma = false;
        if (!this.isStatic) {
            builder.append(classdef.toTypeDefinition().translateSpace() + "this");
            needComma = true;
        }
        addParameters(builder, true, needComma);
        builder.append(")");
        if (isHeader) {
            builder.append(";");
            env.print(builder.toString());
            return;
        }
        env.print(builder.toString());
        env.print("{");
        env.level++;
        if (this.exportFrom != null) {
            builder.setLength(0);
            if (!this.returnType.equals(TypeDefinition.VOID_TYPE)) {
                builder.append("return ");
            }
            FieldDefinition fielddef = classdef.getField(this.exportFrom);
            builder.append(TranslationUtils.translateMethodName(fielddef.type.name, this));
            builder.append("(this->");
            builder.append(this.exportFrom);
            addParameters(builder, false, true);
            builder.append(");");
            env.print(builder.toString());
        }
        else if (classdef.isInterface || (classdef.isAbstract && !isBase)) {
            translateInterfaceBody(classdef);
        }
        else if (this.block != null) {
            env.symbolTable.push(this.frame);
            this.block.translate(false);
            env.symbolTable.pop();
        } else if (this.generator != null) {
            env.symbolTable.push(this.frame);
            this.generator.translate();
            env.symbolTable.pop();
        } else if (this.overrideCount > 0) {
            translateCallSuperclass(classdef);
        }
        env.level--;
        env.print("}");
    }

    private void addParameters(StringBuilder builder, boolean withTypes, boolean needComma) {
        Environment env = Environment.getInstance();
        if (this.parameters != null) {
            for (ParameterDefinition param : this.parameters) {
                if (needComma) {
                    builder.append(", ");
                }
                if (withTypes) {
                    env.addType(param.type);
                    builder.append(param.type.translateSpace());
                }
                builder.append(param.name);
                needComma = true;
            }
        }
    }

    void translateInterface(ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        StringBuilder builder = new StringBuilder();
        env.addType(this.returnType);
        builder.append(this.returnType.translateSpace());
        builder.append("(*");
        builder.append(this.name);
        builder.append(")(");
        boolean needComma = false;
        if (!this.isStatic) {
            builder.append("void *object");
            needComma = true;
        }
        addParameters(builder, true, needComma);
        builder.append(");");
        env.print(builder.toString());
    }

    void translateInterfaceBody(ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        StringBuilder builder = new StringBuilder();
        if (!this.returnType.isVoidType()) {
            builder.append("return ");
        }
        builder.append("this->" + ExportUtils.supers(this.overrideCount));
        builder.append(this.name);
        builder.append("(");
        boolean needComma = false;
        if (!this.isStatic) {
            String supers = ExportUtils.supers(classdef.depth());
            builder.append("this->" + supers + "object");
            needComma = true;
        }
        addParameters(builder, false, needComma);
        builder.append(");");
        env.print(builder.toString());
    }

    void translateCallSuperclass(ClassDefinition classdef) {
        Environment env = Environment.getInstance();
        ClassDefinition candidate = classdef.superclass;
        MethodDefinition method = null;
        int superCount = 1;
        while (candidate != null) {
            method = candidate.getMethod(this.name, this.parameters.size());
            if (method == null || method.hasBody()) {
                break;
            }
            candidate = candidate.superclass;
            superCount++;
        }
        if (method == null) {
            env.printError(null, "class " + classdef.name + " concrete method " +
                    this.name + " not found");
            return;
        }
        StringBuilder builder = new StringBuilder();
        if (!method.returnType.isVoidType()) {
            builder.append("return ");
        }
        String name = TranslationUtils.translateMethodName(candidate.name, method);
        builder.append(TranslationUtils.getBaseTranslatedName(name));
        builder.append("(&this->" + ClassDefinition.SUPER_FIELD_NAME);
        for (int idx = 1; idx < superCount; idx++) {
            builder.append("." + ClassDefinition.SUPER_FIELD_NAME);
        }
        addParameters(builder, false, true);
        builder.append(");");
        env.print(builder.toString());
    }
}
