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

    static interface MethodTranslator {
        public void translate();
    }

    boolean isPrivate;
    boolean isStatic;
    TypeDefinition returnType;
    String name;
    List<ParameterDefinition> parameters;
    BlockContext blockContext;
    BlockDefinition block;
    SymbolTable.Frame frame;
    String exportFrom;
    MethodTranslator translator;

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
        }
        this.frame = env.symbolTable.pop();
    }

    void translate(ClassDefinition classdef, boolean isHeader) {
        Environment env = Environment.getInstance();
        StringBuilder builder = new StringBuilder();
        if (this.isPrivate) {
            builder.append("/* private */ ");
        }
        env.addType(this.returnType);
        builder.append(this.returnType.translateSpace());
        builder.append(TranslationUtils.translateClassItem(classdef.name, this.name));
        builder.append("(");
        boolean needComma = false;
        if (!this.isStatic) {
            builder.append(classdef.toTypeDefinition().translateSpace() + "this");
            needComma = true;
        }
        if (this.parameters != null) {
            for (ParameterDefinition param : this.parameters) {
                if (needComma) {
                    builder.append(", ");
                }
                env.addType(param.type);
                builder.append(param.type.translateSpace());
                builder.append(param.name);
                needComma = true;
            }
        }
        builder.append(")");
        if (isHeader) {
            builder.append(";");
            env.print(builder.toString());
            return;
        }
        env.print(builder.toString());
        if (this.block != null) {
            env.symbolTable.push(this.frame);
            this.block.translate(true);
            env.symbolTable.pop();
        } else {
            env.print("{");
            env.level++;
            if (this.exportFrom != null) {
                builder.setLength(0);
                if (!this.returnType.equals(TypeDefinition.VOID_TYPE)) {
                    builder.append("return ");
                }
                FieldDefinition fielddef = classdef.getField(this.exportFrom);
                builder.append(TranslationUtils.translateClassItem(fielddef.type.name, this.name));
                builder.append("(this->");
                builder.append(this.exportFrom);
                for (ParameterDefinition param : this.parameters) {
                    builder.append(", ");
                    builder.append(param.name);
                }
                builder.append(");");
                env.print(builder.toString());
            } else if (this.translator != null) {
                this.translator.translate();
            } else if (classdef.isInterface) {
                translateInterfaceBody();
            }
            env.level--;
            env.print("}");
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
        if (this.parameters != null) {
            for (ParameterDefinition param : this.parameters) {
                if (needComma) {
                    builder.append(", ");
                }
                env.addType(param.type);
                builder.append(param.type.translateSpace());
                builder.append(param.name);
                needComma = true;
            }
        }
        builder.append(");");
        env.print(builder.toString());
    }

    void translateInterfaceBody() {
        Environment env = Environment.getInstance();
        StringBuilder builder = new StringBuilder();
        if (!this.returnType.isVoidType()) {
            builder.append("return ");
        }
        builder.append("this->");
        builder.append(this.name);
        builder.append("(");
        boolean needComma = false;
        if (!this.isStatic) {
            builder.append("this->object");
            needComma = true;
        }
        if (this.parameters != null) {
            for (ParameterDefinition param : this.parameters) {
                if (needComma) {
                    builder.append(", ");
                }
                builder.append(param.name);
                needComma = true;
            }
        }
        builder.append(");");
        env.print(builder.toString());
    }
}
