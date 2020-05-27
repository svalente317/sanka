package sanka;

import org.antlr.v4.runtime.tree.TerminalNode;

import sanka.ClassDefinition.FieldDefinition;
import sanka.MethodDefinition.BlockGenerator;
import sanka.MethodDefinition.ParameterDefinition;
import sanka.antlr4.SankaParser.IdentifierListContext;

public class ConstructorUtils {
    /**
     * Generate the constructor method that takes initial values for a given set of fields.
     */
    static MethodDefinition makeAutoConstructor(ClassDefinition classdef,
            IdentifierListContext ctx) {
        Environment env = Environment.getInstance();
        MethodDefinition method = new MethodDefinition();
        method.returnType = TypeDefinition.VOID_TYPE;
        method.name = classdef.name;
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (TerminalNode terminal : ctx.Identifier()) {
            String name = terminal.getText();
            FieldDefinition field = classdef.getField(name);
            if (field == null || field.type == null) {
                env.printError(ctx, "class " + classdef.name +
                        " does not have field " + name);
                return null;
            }
            if (field.isStatic) {
                env.printError(ctx, "class " + classdef.name + " field " + name + " is static");
                return null;
            }
            ParameterDefinition param = new ParameterDefinition();
            param.type = field.type;
            param.name = "p" + method.parameters.size();
            method.parameters.add(param);
            builder.append("this." + name + " = " + param.name + ";");
        }
        builder.append("}");
        final String body = builder.toString();
        method.generator = new BlockGenerator() {
            @Override
            public String generate() {
                return body;
            }
        };
        return method;
    }
}
