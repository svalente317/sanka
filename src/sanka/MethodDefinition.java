
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
import sanka.antlr4.SankaParser.TypeTypeContext;

public class MethodDefinition {

    public static class ParameterDefinition {
        public TypeDefinition type;
        public String name;
    }

    static interface BlockGenerator {
        public StatementDefinition[] generate();
    }

    BlockContext blockContext;
    BlockGenerator generator;
    public boolean isPrivate;
    public boolean isStatic;
    public TypeDefinition returnType;
    public String name;
    public List<ParameterDefinition> parameters;
    public boolean isOverloaded;
    public BlockDefinition block;
    public SymbolTable.Frame frame;
    public String exportFrom;
    public int overrideCount;

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

    boolean sameSignature(MethodDefinition that) {
        if (!(this.isStatic == that.isStatic && this.returnType.equals(that.returnType))) {
            return false;
        }
        int count = this.parameters.size();
        if (count != that.parameters.size()) {
            return false;
        }
        for (int idx = 0; idx < count; idx++) {
            if (!this.parameters.get(idx).type.equals(that.parameters.get(idx).type)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasBody() {
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
            this.block = new BlockDefinition();
            this.block.evaluate(this.generator);
        }
        this.frame = env.symbolTable.pop();
    }
}
