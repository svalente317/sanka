// Generated from Sanka.g4 by ANTLR 4.7.2

    package sanka.antlr4;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SankaParser}.
 */
public interface SankaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SankaParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(SankaParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(SankaParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(SankaParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(SankaParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(SankaParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(SankaParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(SankaParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(SankaParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(SankaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(SankaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(SankaParser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(SankaParser.ClassModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(SankaParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(SankaParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(SankaParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(SankaParser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(SankaParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(SankaParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(SankaParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(SankaParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(SankaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(SankaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclaration(SankaParser.ConstDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclaration(SankaParser.ConstDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(SankaParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(SankaParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldModifier(SankaParser.FieldModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldModifier(SankaParser.FieldModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(SankaParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(SankaParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(SankaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(SankaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBodyDeclaration(SankaParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBodyDeclaration(SankaParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(SankaParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(SankaParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#typeType}.
	 * @param ctx the parse tree
	 */
	void enterTypeType(SankaParser.TypeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#typeType}.
	 * @param ctx the parse tree
	 */
	void exitTypeType(SankaParser.TypeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(SankaParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(SankaParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(SankaParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(SankaParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(SankaParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(SankaParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(SankaParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(SankaParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(SankaParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(SankaParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(SankaParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(SankaParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(SankaParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(SankaParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SankaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SankaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SankaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SankaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(SankaParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(SankaParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssignment(SankaParser.VariableAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssignment(SankaParser.VariableAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#assignable}.
	 * @param ctx the parse tree
	 */
	void enterAssignable(SankaParser.AssignableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#assignable}.
	 * @param ctx the parse tree
	 */
	void exitAssignable(SankaParser.AssignableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SankaParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SankaParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(SankaParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(SankaParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(SankaParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(SankaParser.ForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(SankaParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(SankaParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#forIncrement}.
	 * @param ctx the parse tree
	 */
	void enterForIncrement(SankaParser.ForIncrementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#forIncrement}.
	 * @param ctx the parse tree
	 */
	void exitForIncrement(SankaParser.ForIncrementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForControl(SankaParser.EnhancedForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForControl(SankaParser.EnhancedForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(SankaParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(SankaParser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(SankaParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(SankaParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(SankaParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(SankaParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SankaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SankaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(SankaParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(SankaParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(SankaParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(SankaParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreatorRest(SankaParser.ArrayCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreatorRest(SankaParser.ArrayCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterClassCreatorRest(SankaParser.ClassCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitClassCreatorRest(SankaParser.ClassCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#mapDefinition}.
	 * @param ctx the parse tree
	 */
	void enterMapDefinition(SankaParser.MapDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#mapDefinition}.
	 * @param ctx the parse tree
	 */
	void exitMapDefinition(SankaParser.MapDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#mapEntry}.
	 * @param ctx the parse tree
	 */
	void enterMapEntry(SankaParser.MapEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#mapEntry}.
	 * @param ctx the parse tree
	 */
	void exitMapEntry(SankaParser.MapEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SankaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SankaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SankaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SankaParser.LiteralContext ctx);
}