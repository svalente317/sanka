package sanka;

import java.util.ArrayList;
import java.util.List;

import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser.BlockContext;
import sanka.antlr4.SankaParser.FieldModifierContext;
import sanka.antlr4.SankaParser.FormalParameterContext;
import sanka.antlr4.SankaParser.FormalParameterListContext;
import sanka.antlr4.SankaParser.FormalParametersContext;
import sanka.antlr4.SankaParser.MethodDeclarationContext;
import sanka.antlr4.SankaParser.StatementContext;
import sanka.antlr4.SankaParser.TypeTypeContext;

class MethodDefinition {

    static class ParameterDefinition {
        TypeDefinition type;
        String name;
    }

    boolean isPrivate;
    boolean isStatic;
    TypeDefinition returnType;
    String name;
    List<ParameterDefinition> parameters;
    StatementDefinition[] body;
    SymbolTable.Frame endSymbols;

    MethodDefinition() {
        this.parameters = new ArrayList<>();
        this.body = null;
    }

    void parse(MethodDeclarationContext ctx) {
        parse(ctx.fieldModifier(), ctx.typeType(), ctx.Identifier().getText(),
                ctx.formalParameters(), ctx.block());
    }

    void parse(List<FieldModifierContext> fieldModifier, TypeTypeContext returnTypeCtx,
            String name, FormalParametersContext formalParameters, BlockContext block) {
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
        if (block == null) {
            return;
        }
        this.body = new StatementDefinition[block.statement().size()];
        int idx = 0;
        for (StatementContext item : block.statement()) {
            this.body[idx] = new StatementDefinition();
            this.body[idx].parse(item);
            idx++;
        }
    }

    void evaluate() {
        Environment env = Environment.getInstance();
        env.currentMethod = this;
        env.symbolTable.push(null);
        for (ParameterDefinition param : this.parameters) {
            env.symbolTable.put(param.name, param.type);
        }
        for (StatementDefinition stmtdef : this.body) {
            stmtdef.evaluate();
        }
        this.endSymbols = env.symbolTable.pop();
    }

    void translate(ClassDefinition classdef, boolean isHeader) {
        Environment env = Environment.getInstance();
        env.symbolTable.push(this.endSymbols);
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
            // Instead of hardcoding "struct" here, we could convert
            // ClassDefinition -> TypeDefinition -> translate().
            builder.append("struct " + classdef.name + " *this");
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
        builder.append(" {");
        env.print(builder.toString());
        env.level++;
        for (StatementDefinition stmtdef : this.body) {
            stmtdef.translate();
        }
        env.level--;
        env.print("}");
        env.symbolTable.pop();
    }
}
