package sanka;

import java.util.LinkedList;
import java.util.List;

import sanka.antlr4.SankaLexer;
import sanka.antlr4.SankaParser.BlockContext;
import sanka.antlr4.SankaParser.FormalParameterContext;
import sanka.antlr4.SankaParser.FormalParameterListContext;
import sanka.antlr4.SankaParser.FormalParametersContext;
import sanka.antlr4.SankaParser.MethodDeclarationContext;
import sanka.antlr4.SankaParser.MethodModifierContext;
import sanka.antlr4.SankaParser.StatementContext;
import sanka.antlr4.SankaParser.TypeTypeContext;

class MethodDefinition {

    class ParameterDefinition {
        TypeDefinition type;
        String name;
        boolean dotdotdot;
    }

    boolean isPrivate;
    boolean isStatic;
    TypeDefinition returnType;
    String name;
    List<ParameterDefinition> parameters;
    List<String> throwsList;
    StatementDefinition[] body;

    MethodDefinition() {
        this.throwsList = new LinkedList<>();
        this.parameters = new LinkedList<>();
        this.body = null;
    }

    void parse(MethodDeclarationContext ctx) {
        parse(ctx.methodModifier(), ctx.typeType(), ctx.Identifier().getText(),
                ctx.formalParameters(), ctx.block());
    }

    void parse(List<MethodModifierContext> methodModifier, TypeTypeContext returnTypeCtx,
            String name, FormalParametersContext formalParameters, BlockContext block) {
        if (methodModifier != null) {
            for (MethodModifierContext item : methodModifier) {
                int modifier = item.getStart().getType();
                if (modifier == SankaLexer.PRIVATE) {
                    this.isPrivate = true;
                }
                if (modifier == SankaLexer.STATIC) {
                    this.isStatic = true;
                }
            }
        }
        if (returnTypeCtx != null) {
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
            if (fpc.lastFormalParameter() != null) {
                ParameterDefinition pd = new ParameterDefinition();
                pd.type = new TypeDefinition();
                pd.type.parse(fpc.lastFormalParameter().typeType());
                pd.dotdotdot = true;
                pd.name = fpc.lastFormalParameter().Identifier().getText();
                this.parameters.add(pd);
            }
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
        for (ParameterDefinition param : this.parameters) {
            env.symbolTable.put(param.name, param.type);
        }
        for (StatementDefinition stmtdef : this.body) {
            stmtdef.evaluate();
        }
    }

    String parametersToString(String className) {
        String code = "struct " + className + " *this";
        if (this.parameters == null || this.parameters.isEmpty()) {
            return code;
        }
        for (ParameterDefinition param : this.parameters) {
            // TODO dotdotdot?
            String typeName = param.type.translate();
            code = code + ", " + typeName + param.name;
        }
        return code;
    }

    void translate(String className) {
        Environment env = Environment.getInstance();
        String tag = this.isStatic ? "static " : "";
        // TODO void return type fails?
        env.print(tag + this.returnType.translate() + className + "__" + this.name + "(" +
                  parametersToString(className) + ") {");
        env.level++;
        for (StatementDefinition stmtdef : this.body) {
            stmtdef.translate();
        }
        env.level--;
        env.print("}");
    }
}
