// Generated from src/sanka/Sanka.g4 by ANTLR 4.5.1

    package sanka.antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SankaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, BOOLEAN=3, BREAK=4, BYTE=5, CASE=6, CHAR=7, CLASS=8, CONST=9, 
		CONTINUE=10, DEFAULT=11, DOUBLE=12, ELSE=13, EXPORT=14, FLOAT=15, FOR=16, 
		IF=17, IMPORT=18, INLINE=19, INT=20, INTERFACE=21, LONG=22, NEW=23, PACKAGE=24, 
		PRIVATE=25, RETURN=26, SHORT=27, STATIC=28, SWITCH=29, THIS=30, VAR=31, 
		VOID=32, WHILE=33, IntegerLiteral=34, FloatingPointLiteral=35, BooleanLiteral=36, 
		CharacterLiteral=37, StringLiteral=38, NullLiteral=39, LPAREN=40, RPAREN=41, 
		LBRACE=42, RBRACE=43, LBRACK=44, RBRACK=45, SEMI=46, COMMA=47, DOT=48, 
		ASSIGN=49, GT=50, LT=51, BANG=52, TILDE=53, QUESTION=54, COLON=55, EQUAL=56, 
		LE=57, GE=58, NOTEQUAL=59, AND=60, OR=61, INC=62, DEC=63, ADD=64, SUB=65, 
		MUL=66, DIV=67, BITAND=68, BITOR=69, CARET=70, MOD=71, Identifier=72, 
		ELLIPSIS=73, WS=74, COMMENT=75, LINE_COMMENT=76;
	public static final int
		RULE_compilationUnit = 0, RULE_packageDeclaration = 1, RULE_importDeclaration = 2, 
		RULE_typeDeclaration = 3, RULE_methodModifier = 4, RULE_variableModifier = 5, 
		RULE_fieldModifier = 6, RULE_classDeclaration = 7, RULE_typeParameters = 8, 
		RULE_interfaceDeclaration = 9, RULE_classBody = 10, RULE_interfaceBody = 11, 
		RULE_classBodyDeclaration = 12, RULE_constDeclaration = 13, RULE_fieldDeclaration = 14, 
		RULE_constructorDeclaration = 15, RULE_methodDeclaration = 16, RULE_interfaceBodyDeclaration = 17, 
		RULE_interfaceMethodDeclaration = 18, RULE_typeType = 19, RULE_classOrInterfaceType = 20, 
		RULE_typeArguments = 21, RULE_primitiveType = 22, RULE_formalParameters = 23, 
		RULE_formalParameterList = 24, RULE_formalParameter = 25, RULE_lastFormalParameter = 26, 
		RULE_qualifiedName = 27, RULE_block = 28, RULE_statement = 29, RULE_variableDeclaration = 30, 
		RULE_variableAssignment = 31, RULE_assignable = 32, RULE_forControl = 33, 
		RULE_forInit = 34, RULE_forIncrement = 35, RULE_enhancedForControl = 36, 
		RULE_switchBlockStatementGroup = 37, RULE_switchLabel = 38, RULE_parExpression = 39, 
		RULE_expressionList = 40, RULE_expression = 41, RULE_primary = 42, RULE_creator = 43, 
		RULE_createdName = 44, RULE_arrayCreatorRest = 45, RULE_classCreatorRest = 46, 
		RULE_literal = 47;
	public static final String[] ruleNames = {
		"compilationUnit", "packageDeclaration", "importDeclaration", "typeDeclaration", 
		"methodModifier", "variableModifier", "fieldModifier", "classDeclaration", 
		"typeParameters", "interfaceDeclaration", "classBody", "interfaceBody", 
		"classBodyDeclaration", "constDeclaration", "fieldDeclaration", "constructorDeclaration", 
		"methodDeclaration", "interfaceBodyDeclaration", "interfaceMethodDeclaration", 
		"typeType", "classOrInterfaceType", "typeArguments", "primitiveType", 
		"formalParameters", "formalParameterList", "formalParameter", "lastFormalParameter", 
		"qualifiedName", "block", "statement", "variableDeclaration", "variableAssignment", 
		"assignable", "forControl", "forInit", "forIncrement", "enhancedForControl", 
		"switchBlockStatementGroup", "switchLabel", "parExpression", "expressionList", 
		"expression", "primary", "creator", "createdName", "arrayCreatorRest", 
		"classCreatorRest", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'<<'", "'>>'", "'boolean'", "'break'", "'byte'", "'case'", "'char'", 
		"'class'", "'const'", "'continue'", "'default'", "'double'", "'else'", 
		"'export'", "'float'", "'for'", "'if'", "'import'", "'inline'", "'int'", 
		"'interface'", "'long'", "'new'", "'package'", "'private'", "'return'", 
		"'short'", "'static'", "'switch'", "'this'", "'var'", "'void'", "'while'", 
		null, null, null, null, null, "'null'", "'('", "')'", "'{'", "'}'", "'['", 
		"']'", "';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", 
		"':'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", 
		"'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", null, "'...'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "BOOLEAN", "BREAK", "BYTE", "CASE", "CHAR", "CLASS", 
		"CONST", "CONTINUE", "DEFAULT", "DOUBLE", "ELSE", "EXPORT", "FLOAT", "FOR", 
		"IF", "IMPORT", "INLINE", "INT", "INTERFACE", "LONG", "NEW", "PACKAGE", 
		"PRIVATE", "RETURN", "SHORT", "STATIC", "SWITCH", "THIS", "VAR", "VOID", 
		"WHILE", "IntegerLiteral", "FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", 
		"StringLiteral", "NullLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", "GT", "LT", "BANG", 
		"TILDE", "QUESTION", "COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", 
		"OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", 
		"MOD", "Identifier", "ELLIPSIS", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Sanka.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SankaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SankaParser.EOF, 0); }
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitCompilationUnit(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(96);
				packageDeclaration();
				}
			}

			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(99);
				importDeclaration();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS || _la==INTERFACE) {
				{
				{
				setState(105);
				typeDeclaration();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageDeclarationContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterPackageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitPackageDeclaration(this);
		}
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_packageDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(PACKAGE);
			setState(114);
			qualifiedName();
			setState(115);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportDeclarationContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitImportDeclaration(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(IMPORT);
			setState(118);
			qualifiedName();
			setState(121);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(119);
				match(DOT);
				setState(120);
				match(MUL);
				}
			}

			setState(123);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitTypeDeclaration(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typeDeclaration);
		try {
			setState(127);
			switch (_input.LA(1)) {
			case CLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				classDeclaration();
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				interfaceDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodModifierContext extends ParserRuleContext {
		public MethodModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterMethodModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitMethodModifier(this);
		}
	}

	public final MethodModifierContext methodModifier() throws RecognitionException {
		MethodModifierContext _localctx = new MethodModifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_la = _input.LA(1);
			if ( !(_la==PRIVATE || _la==STATIC) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableModifierContext extends ParserRuleContext {
		public VariableModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterVariableModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitVariableModifier(this);
		}
	}

	public final VariableModifierContext variableModifier() throws RecognitionException {
		VariableModifierContext _localctx = new VariableModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(INLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldModifierContext extends ParserRuleContext {
		public VariableModifierContext variableModifier() {
			return getRuleContext(VariableModifierContext.class,0);
		}
		public MethodModifierContext methodModifier() {
			return getRuleContext(MethodModifierContext.class,0);
		}
		public FieldModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterFieldModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitFieldModifier(this);
		}
	}

	public final FieldModifierContext fieldModifier() throws RecognitionException {
		FieldModifierContext _localctx = new FieldModifierContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldModifier);
		try {
			setState(135);
			switch (_input.LA(1)) {
			case INLINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				variableModifier();
				}
				break;
			case PRIVATE:
			case STATIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				methodModifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(CLASS);
			setState(138);
			match(Identifier);
			setState(140);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(139);
				typeParameters();
				}
			}

			setState(142);
			classBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParametersContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(SankaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SankaParser.Identifier, i);
		}
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitTypeParameters(this);
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(LT);
			setState(145);
			match(Identifier);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(146);
				match(COMMA);
				setState(147);
				match(Identifier);
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public InterfaceBodyContext interfaceBody() {
			return getRuleContext(InterfaceBodyContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public InterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitInterfaceDeclaration(this);
		}
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_interfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(INTERFACE);
			setState(156);
			match(Identifier);
			setState(158);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(157);
				typeParameters();
				}
			}

			setState(160);
			interfaceBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitClassBody(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(LBRACE);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << EXPORT) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << PRIVATE) | (1L << SHORT) | (1L << STATIC) | (1L << VOID))) != 0) || _la==Identifier) {
				{
				{
				setState(163);
				classBodyDeclaration();
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceBodyContext extends ParserRuleContext {
		public List<InterfaceBodyDeclarationContext> interfaceBodyDeclaration() {
			return getRuleContexts(InterfaceBodyDeclarationContext.class);
		}
		public InterfaceBodyDeclarationContext interfaceBodyDeclaration(int i) {
			return getRuleContext(InterfaceBodyDeclarationContext.class,i);
		}
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterInterfaceBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitInterfaceBody(this);
		}
	}

	public final InterfaceBodyContext interfaceBody() throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_interfaceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(LBRACE);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << EXPORT) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << PRIVATE) | (1L << SHORT) | (1L << STATIC) | (1L << VOID))) != 0) || _la==Identifier) {
				{
				{
				setState(172);
				interfaceBodyDeclaration();
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public ConstDeclarationContext constDeclaration() {
			return getRuleContext(ConstDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitClassBodyDeclaration(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_classBodyDeclaration);
		try {
			setState(186);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				constDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				fieldDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				match(EXPORT);
				setState(183);
				match(Identifier);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
				constructorDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(185);
				methodDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterConstDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitConstDeclaration(this);
		}
	}

	public final ConstDeclarationContext constDeclaration() throws RecognitionException {
		ConstDeclarationContext _localctx = new ConstDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(CONST);
			setState(189);
			match(Identifier);
			setState(190);
			match(ASSIGN);
			setState(191);
			expression(0);
			setState(192);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclarationContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(SankaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SankaParser.Identifier, i);
		}
		public List<FieldModifierContext> fieldModifier() {
			return getRuleContexts(FieldModifierContext.class);
		}
		public FieldModifierContext fieldModifier(int i) {
			return getRuleContext(FieldModifierContext.class,i);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitFieldDeclaration(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) {
				{
				{
				setState(194);
				fieldModifier();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200);
			typeType();
			setState(201);
			match(Identifier);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(202);
				match(COMMA);
				setState(203);
				match(Identifier);
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(209);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitConstructorDeclaration(this);
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constructorDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(Identifier);
			setState(212);
			formalParameters();
			setState(213);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public List<MethodModifierContext> methodModifier() {
			return getRuleContexts(MethodModifierContext.class);
		}
		public MethodModifierContext methodModifier(int i) {
			return getRuleContext(MethodModifierContext.class,i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PRIVATE || _la==STATIC) {
				{
				{
				setState(215);
				methodModifier();
				}
				}
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(223);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				{
				setState(221);
				typeType();
				}
				break;
			case VOID:
				{
				setState(222);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(225);
			match(Identifier);
			setState(226);
			formalParameters();
			setState(227);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceBodyDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public ConstDeclarationContext constDeclaration() {
			return getRuleContext(ConstDeclarationContext.class,0);
		}
		public InterfaceMethodDeclarationContext interfaceMethodDeclaration() {
			return getRuleContext(InterfaceMethodDeclarationContext.class,0);
		}
		public InterfaceBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterInterfaceBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitInterfaceBodyDeclaration(this);
		}
	}

	public final InterfaceBodyDeclarationContext interfaceBodyDeclaration() throws RecognitionException {
		InterfaceBodyDeclarationContext _localctx = new InterfaceBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_interfaceBodyDeclaration);
		try {
			setState(233);
			switch (_input.LA(1)) {
			case EXPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				match(EXPORT);
				setState(230);
				match(Identifier);
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				constDeclaration();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case PRIVATE:
			case SHORT:
			case STATIC:
			case VOID:
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				interfaceMethodDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMethodDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public List<MethodModifierContext> methodModifier() {
			return getRuleContexts(MethodModifierContext.class);
		}
		public MethodModifierContext methodModifier(int i) {
			return getRuleContext(MethodModifierContext.class,i);
		}
		public InterfaceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterInterfaceMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitInterfaceMethodDeclaration(this);
		}
	}

	public final InterfaceMethodDeclarationContext interfaceMethodDeclaration() throws RecognitionException {
		InterfaceMethodDeclarationContext _localctx = new InterfaceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_interfaceMethodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PRIVATE || _la==STATIC) {
				{
				{
				setState(235);
				methodModifier();
				}
				}
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(243);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				{
				setState(241);
				typeType();
				}
				break;
			case VOID:
				{
				setState(242);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(245);
			match(Identifier);
			setState(246);
			formalParameters();
			setState(247);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeTypeContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TypeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterTypeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitTypeType(this);
		}
	}

	public final TypeTypeContext typeType() throws RecognitionException {
		TypeTypeContext _localctx = new TypeTypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeType);
		int _la;
		try {
			setState(265);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				classOrInterfaceType();
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(250);
					match(LBRACK);
					setState(251);
					match(RBRACK);
					}
					}
					setState(256);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				primitiveType();
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(258);
					match(LBRACK);
					setState(259);
					match(RBRACK);
					}
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(SankaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SankaParser.Identifier, i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitClassOrInterfaceType(this);
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_classOrInterfaceType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(267);
					match(Identifier);
					setState(268);
					match(DOT);
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(274);
			match(Identifier);
			setState(276);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(275);
				typeArguments();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentsContext extends ParserRuleContext {
		public List<TypeTypeContext> typeType() {
			return getRuleContexts(TypeTypeContext.class);
		}
		public TypeTypeContext typeType(int i) {
			return getRuleContext(TypeTypeContext.class,i);
		}
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitTypeArguments(this);
		}
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_typeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(LT);
			setState(279);
			typeType();
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(280);
				match(COMMA);
				setState(281);
				typeType();
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(287);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitPrimitiveType(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParametersContext extends ParserRuleContext {
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitFormalParameters(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(LPAREN);
			setState(293);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || _la==Identifier) {
				{
				setState(292);
				formalParameterList();
				}
			}

			setState(295);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterListContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public LastFormalParameterContext lastFormalParameter() {
			return getRuleContext(LastFormalParameterContext.class,0);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitFormalParameterList(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_formalParameterList);
		int _la;
		try {
			int _alt;
			setState(310);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				formalParameter();
				setState(302);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(298);
						match(COMMA);
						setState(299);
						formalParameter();
						}
						} 
					}
					setState(304);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				}
				setState(307);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(305);
					match(COMMA);
					setState(306);
					lastFormalParameter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(309);
				lastFormalParameter();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitFormalParameter(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			typeType();
			setState(313);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LastFormalParameterContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public LastFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastFormalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterLastFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitLastFormalParameter(this);
		}
	}

	public final LastFormalParameterContext lastFormalParameter() throws RecognitionException {
		LastFormalParameterContext _localctx = new LastFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_lastFormalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			typeType();
			setState(316);
			match(ELLIPSIS);
			setState(317);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(SankaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SankaParser.Identifier, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitQualifiedName(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(Identifier);
			setState(324);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(320);
					match(DOT);
					setState(321);
					match(Identifier);
					}
					} 
				}
				setState(326);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(LBRACE);
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONST) | (1L << CONTINUE) | (1L << FOR) | (1L << IF) | (1L << INLINE) | (1L << NEW) | (1L << RETURN) | (1L << SWITCH) | (1L << THIS) | (1L << VAR) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << BANG) | (1L << TILDE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(328);
				statement();
				}
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(334);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public ConstDeclarationContext constDeclaration() {
			return getRuleContext(ConstDeclarationContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public List<SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
			return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
			return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(391);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
				constDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(338);
				variableDeclaration();
				setState(339);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(341);
				variableAssignment();
				setState(342);
				match(SEMI);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(344);
				match(IF);
				setState(345);
				parExpression();
				setState(346);
				block();
				setState(349);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(347);
					match(ELSE);
					setState(348);
					block();
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(351);
				match(FOR);
				setState(352);
				match(LPAREN);
				setState(353);
				forControl();
				setState(354);
				match(RPAREN);
				setState(355);
				block();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(357);
				match(WHILE);
				setState(358);
				parExpression();
				setState(359);
				block();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(361);
				match(SWITCH);
				setState(362);
				parExpression();
				setState(363);
				match(LBRACE);
				setState(367);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(364);
						switchBlockStatementGroup();
						}
						} 
					}
					setState(369);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(370);
					switchLabel();
					}
					}
					setState(375);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(376);
				match(RBRACE);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(378);
				match(RETURN);
				setState(380);
				_la = _input.LA(1);
				if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (THIS - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
					{
					setState(379);
					expression(0);
					}
				}

				setState(382);
				match(SEMI);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(383);
				match(BREAK);
				setState(384);
				match(SEMI);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(385);
				match(CONTINUE);
				setState(386);
				match(SEMI);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(387);
				expression(0);
				setState(388);
				match(SEMI);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(390);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitVariableDeclaration(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INLINE) {
				{
				{
				setState(393);
				variableModifier();
				}
				}
				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(399);
			match(VAR);
			setState(400);
			match(Identifier);
			setState(403);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(401);
				match(ASSIGN);
				setState(402);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableAssignmentContext extends ParserRuleContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterVariableAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitVariableAssignment(this);
		}
	}

	public final VariableAssignmentContext variableAssignment() throws RecognitionException {
		VariableAssignmentContext _localctx = new VariableAssignmentContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_variableAssignment);
		int _la;
		try {
			setState(412);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(405);
				assignable();
				setState(406);
				match(ASSIGN);
				setState(407);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(409);
				assignable();
				setState(410);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignableContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterAssignable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitAssignable(this);
		}
	}

	public final AssignableContext assignable() throws RecognitionException {
		AssignableContext _localctx = new AssignableContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_assignable);
		try {
			setState(425);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(417);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(414);
					expression(0);
					setState(415);
					match(DOT);
					}
					break;
				}
				setState(419);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
				expression(0);
				setState(421);
				match(LBRACK);
				setState(422);
				expression(0);
				setState(423);
				match(RBRACK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForControlContext extends ParserRuleContext {
		public EnhancedForControlContext enhancedForControl() {
			return getRuleContext(EnhancedForControlContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ForIncrementContext forIncrement() {
			return getRuleContext(ForIncrementContext.class,0);
		}
		public ForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitForControl(this);
		}
	}

	public final ForControlContext forControl() throws RecognitionException {
		ForControlContext _localctx = new ForControlContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_forControl);
		int _la;
		try {
			setState(437);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(427);
				enhancedForControl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(429);
				_la = _input.LA(1);
				if (((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (INLINE - 19)) | (1L << (NEW - 19)) | (1L << (THIS - 19)) | (1L << (VAR - 19)) | (1L << (IntegerLiteral - 19)) | (1L << (FloatingPointLiteral - 19)) | (1L << (BooleanLiteral - 19)) | (1L << (CharacterLiteral - 19)) | (1L << (StringLiteral - 19)) | (1L << (NullLiteral - 19)) | (1L << (LPAREN - 19)) | (1L << (BANG - 19)) | (1L << (TILDE - 19)) | (1L << (ADD - 19)) | (1L << (SUB - 19)) | (1L << (Identifier - 19)))) != 0)) {
					{
					setState(428);
					forInit();
					}
				}

				setState(431);
				match(SEMI);
				setState(432);
				expression(0);
				setState(433);
				match(SEMI);
				setState(435);
				_la = _input.LA(1);
				if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (THIS - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
					{
					setState(434);
					forIncrement();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInitContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitForInit(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_forInit);
		try {
			setState(442);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(439);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(440);
				variableAssignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(441);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForIncrementContext extends ParserRuleContext {
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForIncrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forIncrement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterForIncrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitForIncrement(this);
		}
	}

	public final ForIncrementContext forIncrement() throws RecognitionException {
		ForIncrementContext _localctx = new ForIncrementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_forIncrement);
		try {
			setState(446);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(444);
				variableAssignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(445);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnhancedForControlContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EnhancedForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterEnhancedForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitEnhancedForControl(this);
		}
	}

	public final EnhancedForControlContext enhancedForControl() throws RecognitionException {
		EnhancedForControlContext _localctx = new EnhancedForControlContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_enhancedForControl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(448);
				match(VAR);
				}
			}

			setState(451);
			match(Identifier);
			setState(452);
			match(COLON);
			setState(453);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchBlockStatementGroupContext extends ParserRuleContext {
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SwitchBlockStatementGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterSwitchBlockStatementGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitSwitchBlockStatementGroup(this);
		}
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_switchBlockStatementGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(455);
				switchLabel();
				}
				}
				setState(458); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(461); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(460);
				statement();
				}
				}
				setState(463); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONST) | (1L << CONTINUE) | (1L << FOR) | (1L << IF) | (1L << INLINE) | (1L << NEW) | (1L << RETURN) | (1L << SWITCH) | (1L << THIS) | (1L << VAR) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << BANG) | (1L << TILDE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchLabelContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterSwitchLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitSwitchLabel(this);
		}
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_switchLabel);
		try {
			setState(471);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(465);
				match(CASE);
				setState(466);
				expression(0);
				setState(467);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(469);
				match(DEFAULT);
				setState(470);
				match(COLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterParExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitParExpression(this);
		}
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			match(LPAREN);
			setState(474);
			expression(0);
			setState(475);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitExpressionList(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			expression(0);
			setState(482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(478);
				match(COMMA);
				setState(479);
				expression(0);
				}
				}
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			switch (_input.LA(1)) {
			case ADD:
			case SUB:
				{
				setState(486);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(487);
				expression(13);
				}
				break;
			case BANG:
			case TILDE:
				{
				setState(488);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(489);
				expression(12);
				}
				break;
			case THIS:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case Identifier:
				{
				setState(490);
				primary();
				}
				break;
			case NEW:
				{
				setState(491);
				match(NEW);
				setState(492);
				creator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(547);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(545);
					switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(495);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(496);
						_la = _input.LA(1);
						if ( !(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (MUL - 66)) | (1L << (DIV - 66)) | (1L << (MOD - 66)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(497);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(498);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(499);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(500);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(501);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(502);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__1) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(503);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(504);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(505);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << LE) | (1L << GE))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(506);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(507);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(508);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(509);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(510);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(511);
						match(BITAND);
						setState(512);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(513);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(514);
						match(CARET);
						setState(515);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(516);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(517);
						match(BITOR);
						setState(518);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(519);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(520);
						match(AND);
						setState(521);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(522);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(523);
						match(OR);
						setState(524);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(525);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(526);
						match(QUESTION);
						setState(527);
						expression(0);
						setState(528);
						match(COLON);
						setState(529);
						expression(2);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(531);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(532);
						match(DOT);
						setState(533);
						match(Identifier);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(534);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(535);
						match(LBRACK);
						setState(536);
						expression(0);
						setState(537);
						match(RBRACK);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(539);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(540);
						match(LPAREN);
						setState(542);
						_la = _input.LA(1);
						if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (THIS - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
							{
							setState(541);
							expressionList();
							}
						}

						setState(544);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(549);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_primary);
		try {
			setState(554);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(550);
				parExpression();
				}
				break;
			case THIS:
				enterOuterAlt(_localctx, 2);
				{
				setState(551);
				match(THIS);
				}
				break;
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(552);
				literal();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(553);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatorContext extends ParserRuleContext {
		public CreatedNameContext createdName() {
			return getRuleContext(CreatedNameContext.class,0);
		}
		public ArrayCreatorRestContext arrayCreatorRest() {
			return getRuleContext(ArrayCreatorRestContext.class,0);
		}
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitCreator(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_creator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			createdName();
			setState(559);
			switch (_input.LA(1)) {
			case LBRACK:
				{
				setState(557);
				arrayCreatorRest();
				}
				break;
			case LPAREN:
				{
				setState(558);
				classCreatorRest();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatedNameContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public CreatedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createdName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterCreatedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitCreatedName(this);
		}
	}

	public final CreatedNameContext createdName() throws RecognitionException {
		CreatedNameContext _localctx = new CreatedNameContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_createdName);
		try {
			setState(563);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(561);
				classOrInterfaceType();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(562);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayCreatorRestContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreatorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterArrayCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitArrayCreatorRest(this);
		}
	}

	public final ArrayCreatorRestContext arrayCreatorRest() throws RecognitionException {
		ArrayCreatorRestContext _localctx = new ArrayCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_arrayCreatorRest);
		int _la;
		try {
			int _alt;
			setState(598);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(565);
				match(LBRACK);
				setState(566);
				match(RBRACK);
				setState(571);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(567);
					match(LBRACK);
					setState(568);
					match(RBRACK);
					}
					}
					setState(573);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(574);
				match(LBRACE);
				setState(576);
				_la = _input.LA(1);
				if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (THIS - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
					{
					setState(575);
					expressionList();
					}
				}

				setState(578);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(579);
				match(LBRACK);
				setState(580);
				expression(0);
				setState(581);
				match(RBRACK);
				setState(588);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(582);
						match(LBRACK);
						setState(583);
						expression(0);
						setState(584);
						match(RBRACK);
						}
						} 
					}
					setState(590);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				}
				setState(595);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(591);
						match(LBRACK);
						setState(592);
						match(RBRACK);
						}
						} 
					}
					setState(597);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassCreatorRestContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classCreatorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterClassCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitClassCreatorRest(this);
		}
	}

	public final ClassCreatorRestContext classCreatorRest() throws RecognitionException {
		ClassCreatorRestContext _localctx = new ClassCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_classCreatorRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			match(LPAREN);
			setState(602);
			_la = _input.LA(1);
			if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (THIS - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
				{
				setState(601);
				expressionList();
				}
			}

			setState(604);
			match(RPAREN);
			setState(606);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(605);
				classBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(SankaParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(SankaParser.FloatingPointLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(SankaParser.CharacterLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(SankaParser.StringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(SankaParser.BooleanLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 41:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		case 11:
			return precpred(_ctx, 17);
		case 12:
			return precpred(_ctx, 16);
		case 13:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3N\u0265\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\5\2d\n\2\3\2\7\2g\n\2\f"+
		"\2\16\2j\13\2\3\2\7\2m\n\2\f\2\16\2p\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\5\4|\n\4\3\4\3\4\3\5\3\5\5\5\u0082\n\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\5\b\u008a\n\b\3\t\3\t\3\t\5\t\u008f\n\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\7\n\u0097\n\n\f\n\16\n\u009a\13\n\3\n\3\n\3\13\3\13\3\13\5\13\u00a1\n"+
		"\13\3\13\3\13\3\f\3\f\7\f\u00a7\n\f\f\f\16\f\u00aa\13\f\3\f\3\f\3\r\3"+
		"\r\7\r\u00b0\n\r\f\r\16\r\u00b3\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u00bd\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\7\20\u00c6\n"+
		"\20\f\20\16\20\u00c9\13\20\3\20\3\20\3\20\3\20\7\20\u00cf\n\20\f\20\16"+
		"\20\u00d2\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\7\22\u00db\n\22\f\22"+
		"\16\22\u00de\13\22\3\22\3\22\5\22\u00e2\n\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\5\23\u00ec\n\23\3\24\7\24\u00ef\n\24\f\24\16\24\u00f2"+
		"\13\24\3\24\3\24\5\24\u00f6\n\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\7"+
		"\25\u00ff\n\25\f\25\16\25\u0102\13\25\3\25\3\25\3\25\7\25\u0107\n\25\f"+
		"\25\16\25\u010a\13\25\5\25\u010c\n\25\3\26\3\26\7\26\u0110\n\26\f\26\16"+
		"\26\u0113\13\26\3\26\3\26\5\26\u0117\n\26\3\27\3\27\3\27\3\27\7\27\u011d"+
		"\n\27\f\27\16\27\u0120\13\27\3\27\3\27\3\30\3\30\3\31\3\31\5\31\u0128"+
		"\n\31\3\31\3\31\3\32\3\32\3\32\7\32\u012f\n\32\f\32\16\32\u0132\13\32"+
		"\3\32\3\32\5\32\u0136\n\32\3\32\5\32\u0139\n\32\3\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\7\35\u0145\n\35\f\35\16\35\u0148\13\35\3"+
		"\36\3\36\7\36\u014c\n\36\f\36\16\36\u014f\13\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0160\n\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\7\37\u0170\n\37\f\37\16\37\u0173\13\37\3\37\7\37\u0176\n\37\f\37\16\37"+
		"\u0179\13\37\3\37\3\37\3\37\3\37\5\37\u017f\n\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\5\37\u018a\n\37\3 \7 \u018d\n \f \16 \u0190\13"+
		" \3 \3 \3 \3 \5 \u0196\n \3!\3!\3!\3!\3!\3!\3!\5!\u019f\n!\3\"\3\"\3\""+
		"\5\"\u01a4\n\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01ac\n\"\3#\3#\5#\u01b0\n"+
		"#\3#\3#\3#\3#\5#\u01b6\n#\5#\u01b8\n#\3$\3$\3$\5$\u01bd\n$\3%\3%\5%\u01c1"+
		"\n%\3&\5&\u01c4\n&\3&\3&\3&\3&\3\'\6\'\u01cb\n\'\r\'\16\'\u01cc\3\'\6"+
		"\'\u01d0\n\'\r\'\16\'\u01d1\3(\3(\3(\3(\3(\3(\5(\u01da\n(\3)\3)\3)\3)"+
		"\3*\3*\3*\7*\u01e3\n*\f*\16*\u01e6\13*\3+\3+\3+\3+\3+\3+\3+\3+\5+\u01f0"+
		"\n+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+"+
		"\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+"+
		"\3+\3+\5+\u0221\n+\3+\7+\u0224\n+\f+\16+\u0227\13+\3,\3,\3,\3,\5,\u022d"+
		"\n,\3-\3-\3-\5-\u0232\n-\3.\3.\5.\u0236\n.\3/\3/\3/\3/\7/\u023c\n/\f/"+
		"\16/\u023f\13/\3/\3/\5/\u0243\n/\3/\3/\3/\3/\3/\3/\3/\3/\7/\u024d\n/\f"+
		"/\16/\u0250\13/\3/\3/\7/\u0254\n/\f/\16/\u0257\13/\5/\u0259\n/\3\60\3"+
		"\60\5\60\u025d\n\60\3\60\3\60\5\60\u0261\n\60\3\61\3\61\3\61\2\3T\62\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL"+
		"NPRTVXZ\\^`\2\f\4\2\33\33\36\36\n\2\5\5\7\7\t\t\16\16\21\21\26\26\30\30"+
		"\35\35\3\2@A\3\2BC\3\2\66\67\4\2DEII\3\2\3\4\4\2\64\65;<\4\2::==\3\2$"+
		")\u0295\2c\3\2\2\2\4s\3\2\2\2\6w\3\2\2\2\b\u0081\3\2\2\2\n\u0083\3\2\2"+
		"\2\f\u0085\3\2\2\2\16\u0089\3\2\2\2\20\u008b\3\2\2\2\22\u0092\3\2\2\2"+
		"\24\u009d\3\2\2\2\26\u00a4\3\2\2\2\30\u00ad\3\2\2\2\32\u00bc\3\2\2\2\34"+
		"\u00be\3\2\2\2\36\u00c7\3\2\2\2 \u00d5\3\2\2\2\"\u00dc\3\2\2\2$\u00eb"+
		"\3\2\2\2&\u00f0\3\2\2\2(\u010b\3\2\2\2*\u0111\3\2\2\2,\u0118\3\2\2\2."+
		"\u0123\3\2\2\2\60\u0125\3\2\2\2\62\u0138\3\2\2\2\64\u013a\3\2\2\2\66\u013d"+
		"\3\2\2\28\u0141\3\2\2\2:\u0149\3\2\2\2<\u0189\3\2\2\2>\u018e\3\2\2\2@"+
		"\u019e\3\2\2\2B\u01ab\3\2\2\2D\u01b7\3\2\2\2F\u01bc\3\2\2\2H\u01c0\3\2"+
		"\2\2J\u01c3\3\2\2\2L\u01ca\3\2\2\2N\u01d9\3\2\2\2P\u01db\3\2\2\2R\u01df"+
		"\3\2\2\2T\u01ef\3\2\2\2V\u022c\3\2\2\2X\u022e\3\2\2\2Z\u0235\3\2\2\2\\"+
		"\u0258\3\2\2\2^\u025a\3\2\2\2`\u0262\3\2\2\2bd\5\4\3\2cb\3\2\2\2cd\3\2"+
		"\2\2dh\3\2\2\2eg\5\6\4\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2in\3\2"+
		"\2\2jh\3\2\2\2km\5\b\5\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2"+
		"\2\2pn\3\2\2\2qr\7\2\2\3r\3\3\2\2\2st\7\32\2\2tu\58\35\2uv\7\60\2\2v\5"+
		"\3\2\2\2wx\7\24\2\2x{\58\35\2yz\7\62\2\2z|\7D\2\2{y\3\2\2\2{|\3\2\2\2"+
		"|}\3\2\2\2}~\7\60\2\2~\7\3\2\2\2\177\u0082\5\20\t\2\u0080\u0082\5\24\13"+
		"\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082\t\3\2\2\2\u0083\u0084\t"+
		"\2\2\2\u0084\13\3\2\2\2\u0085\u0086\7\25\2\2\u0086\r\3\2\2\2\u0087\u008a"+
		"\5\f\7\2\u0088\u008a\5\n\6\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a"+
		"\17\3\2\2\2\u008b\u008c\7\n\2\2\u008c\u008e\7J\2\2\u008d\u008f\5\22\n"+
		"\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091"+
		"\5\26\f\2\u0091\21\3\2\2\2\u0092\u0093\7\65\2\2\u0093\u0098\7J\2\2\u0094"+
		"\u0095\7\61\2\2\u0095\u0097\7J\2\2\u0096\u0094\3\2\2\2\u0097\u009a\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009b\u009c\7\64\2\2\u009c\23\3\2\2\2\u009d\u009e\7\27"+
		"\2\2\u009e\u00a0\7J\2\2\u009f\u00a1\5\22\n\2\u00a0\u009f\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\5\30\r\2\u00a3\25\3\2\2"+
		"\2\u00a4\u00a8\7,\2\2\u00a5\u00a7\5\32\16\2\u00a6\u00a5\3\2\2\2\u00a7"+
		"\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2"+
		"\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\7-\2\2\u00ac\27\3\2\2\2\u00ad\u00b1"+
		"\7,\2\2\u00ae\u00b0\5$\23\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b4\u00b5\7-\2\2\u00b5\31\3\2\2\2\u00b6\u00bd\5\34\17\2\u00b7\u00bd"+
		"\5\36\20\2\u00b8\u00b9\7\20\2\2\u00b9\u00bd\7J\2\2\u00ba\u00bd\5 \21\2"+
		"\u00bb\u00bd\5\"\22\2\u00bc\u00b6\3\2\2\2\u00bc\u00b7\3\2\2\2\u00bc\u00b8"+
		"\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\33\3\2\2\2\u00be"+
		"\u00bf\7\13\2\2\u00bf\u00c0\7J\2\2\u00c0\u00c1\7\63\2\2\u00c1\u00c2\5"+
		"T+\2\u00c2\u00c3\7\60\2\2\u00c3\35\3\2\2\2\u00c4\u00c6\5\16\b\2\u00c5"+
		"\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\5(\25\2\u00cb"+
		"\u00d0\7J\2\2\u00cc\u00cd\7\61\2\2\u00cd\u00cf\7J\2\2\u00ce\u00cc\3\2"+
		"\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d3\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\7\60\2\2\u00d4\37\3\2\2"+
		"\2\u00d5\u00d6\7J\2\2\u00d6\u00d7\5\60\31\2\u00d7\u00d8\5:\36\2\u00d8"+
		"!\3\2\2\2\u00d9\u00db\5\n\6\2\u00da\u00d9\3\2\2\2\u00db\u00de\3\2\2\2"+
		"\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00e1\3\2\2\2\u00de\u00dc"+
		"\3\2\2\2\u00df\u00e2\5(\25\2\u00e0\u00e2\7\"\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\7J\2\2\u00e4\u00e5\5\60"+
		"\31\2\u00e5\u00e6\5:\36\2\u00e6#\3\2\2\2\u00e7\u00e8\7\20\2\2\u00e8\u00ec"+
		"\7J\2\2\u00e9\u00ec\5\34\17\2\u00ea\u00ec\5&\24\2\u00eb\u00e7\3\2\2\2"+
		"\u00eb\u00e9\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec%\3\2\2\2\u00ed\u00ef\5"+
		"\n\6\2\u00ee\u00ed\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00f5\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f6\5("+
		"\25\2\u00f4\u00f6\7\"\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00f8\7J\2\2\u00f8\u00f9\5\60\31\2\u00f9\u00fa\7"+
		"\60\2\2\u00fa\'\3\2\2\2\u00fb\u0100\5*\26\2\u00fc\u00fd\7.\2\2\u00fd\u00ff"+
		"\7/\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\u010c\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0108\5."+
		"\30\2\u0104\u0105\7.\2\2\u0105\u0107\7/\2\2\u0106\u0104\3\2\2\2\u0107"+
		"\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010c\3\2"+
		"\2\2\u010a\u0108\3\2\2\2\u010b\u00fb\3\2\2\2\u010b\u0103\3\2\2\2\u010c"+
		")\3\2\2\2\u010d\u010e\7J\2\2\u010e\u0110\7\62\2\2\u010f\u010d\3\2\2\2"+
		"\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0114"+
		"\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0116\7J\2\2\u0115\u0117\5,\27\2\u0116"+
		"\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117+\3\2\2\2\u0118\u0119\7\65\2\2"+
		"\u0119\u011e\5(\25\2\u011a\u011b\7\61\2\2\u011b\u011d\5(\25\2\u011c\u011a"+
		"\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\7\64\2\2\u0122-\3\2\2\2"+
		"\u0123\u0124\t\3\2\2\u0124/\3\2\2\2\u0125\u0127\7*\2\2\u0126\u0128\5\62"+
		"\32\2\u0127\u0126\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\u012a\7+\2\2\u012a\61\3\2\2\2\u012b\u0130\5\64\33\2\u012c\u012d\7\61"+
		"\2\2\u012d\u012f\5\64\33\2\u012e\u012c\3\2\2\2\u012f\u0132\3\2\2\2\u0130"+
		"\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0135\3\2\2\2\u0132\u0130\3\2"+
		"\2\2\u0133\u0134\7\61\2\2\u0134\u0136\5\66\34\2\u0135\u0133\3\2\2\2\u0135"+
		"\u0136\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0139\5\66\34\2\u0138\u012b\3"+
		"\2\2\2\u0138\u0137\3\2\2\2\u0139\63\3\2\2\2\u013a\u013b\5(\25\2\u013b"+
		"\u013c\7J\2\2\u013c\65\3\2\2\2\u013d\u013e\5(\25\2\u013e\u013f\7K\2\2"+
		"\u013f\u0140\7J\2\2\u0140\67\3\2\2\2\u0141\u0146\7J\2\2\u0142\u0143\7"+
		"\62\2\2\u0143\u0145\7J\2\2\u0144\u0142\3\2\2\2\u0145\u0148\3\2\2\2\u0146"+
		"\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u01479\3\2\2\2\u0148\u0146\3\2\2\2"+
		"\u0149\u014d\7,\2\2\u014a\u014c\5<\37\2\u014b\u014a\3\2\2\2\u014c\u014f"+
		"\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0150\3\2\2\2\u014f"+
		"\u014d\3\2\2\2\u0150\u0151\7-\2\2\u0151;\3\2\2\2\u0152\u018a\5:\36\2\u0153"+
		"\u018a\5\34\17\2\u0154\u0155\5> \2\u0155\u0156\7\60\2\2\u0156\u018a\3"+
		"\2\2\2\u0157\u0158\5@!\2\u0158\u0159\7\60\2\2\u0159\u018a\3\2\2\2\u015a"+
		"\u015b\7\23\2\2\u015b\u015c\5P)\2\u015c\u015f\5:\36\2\u015d\u015e\7\17"+
		"\2\2\u015e\u0160\5:\36\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160"+
		"\u018a\3\2\2\2\u0161\u0162\7\22\2\2\u0162\u0163\7*\2\2\u0163\u0164\5D"+
		"#\2\u0164\u0165\7+\2\2\u0165\u0166\5:\36\2\u0166\u018a\3\2\2\2\u0167\u0168"+
		"\7#\2\2\u0168\u0169\5P)\2\u0169\u016a\5:\36\2\u016a\u018a\3\2\2\2\u016b"+
		"\u016c\7\37\2\2\u016c\u016d\5P)\2\u016d\u0171\7,\2\2\u016e\u0170\5L\'"+
		"\2\u016f\u016e\3\2\2\2\u0170\u0173\3\2\2\2\u0171\u016f\3\2\2\2\u0171\u0172"+
		"\3\2\2\2\u0172\u0177\3\2\2\2\u0173\u0171\3\2\2\2\u0174\u0176\5N(\2\u0175"+
		"\u0174\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2"+
		"\2\2\u0178\u017a\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017b\7-\2\2\u017b"+
		"\u018a\3\2\2\2\u017c\u017e\7\34\2\2\u017d\u017f\5T+\2\u017e\u017d\3\2"+
		"\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u018a\7\60\2\2\u0181"+
		"\u0182\7\6\2\2\u0182\u018a\7\60\2\2\u0183\u0184\7\f\2\2\u0184\u018a\7"+
		"\60\2\2\u0185\u0186\5T+\2\u0186\u0187\7\60\2\2\u0187\u018a\3\2\2\2\u0188"+
		"\u018a\7\60\2\2\u0189\u0152\3\2\2\2\u0189\u0153\3\2\2\2\u0189\u0154\3"+
		"\2\2\2\u0189\u0157\3\2\2\2\u0189\u015a\3\2\2\2\u0189\u0161\3\2\2\2\u0189"+
		"\u0167\3\2\2\2\u0189\u016b\3\2\2\2\u0189\u017c\3\2\2\2\u0189\u0181\3\2"+
		"\2\2\u0189\u0183\3\2\2\2\u0189\u0185\3\2\2\2\u0189\u0188\3\2\2\2\u018a"+
		"=\3\2\2\2\u018b\u018d\5\f\7\2\u018c\u018b\3\2\2\2\u018d\u0190\3\2\2\2"+
		"\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0191\3\2\2\2\u0190\u018e"+
		"\3\2\2\2\u0191\u0192\7!\2\2\u0192\u0195\7J\2\2\u0193\u0194\7\63\2\2\u0194"+
		"\u0196\5T+\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196?\3\2\2\2\u0197"+
		"\u0198\5B\"\2\u0198\u0199\7\63\2\2\u0199\u019a\5T+\2\u019a\u019f\3\2\2"+
		"\2\u019b\u019c\5B\"\2\u019c\u019d\t\4\2\2\u019d\u019f\3\2\2\2\u019e\u0197"+
		"\3\2\2\2\u019e\u019b\3\2\2\2\u019fA\3\2\2\2\u01a0\u01a1\5T+\2\u01a1\u01a2"+
		"\7\62\2\2\u01a2\u01a4\3\2\2\2\u01a3\u01a0\3\2\2\2\u01a3\u01a4\3\2\2\2"+
		"\u01a4\u01a5\3\2\2\2\u01a5\u01ac\7J\2\2\u01a6\u01a7\5T+\2\u01a7\u01a8"+
		"\7.\2\2\u01a8\u01a9\5T+\2\u01a9\u01aa\7/\2\2\u01aa\u01ac\3\2\2\2\u01ab"+
		"\u01a3\3\2\2\2\u01ab\u01a6\3\2\2\2\u01acC\3\2\2\2\u01ad\u01b8\5J&\2\u01ae"+
		"\u01b0\5F$\2\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\3\2\2"+
		"\2\u01b1\u01b2\7\60\2\2\u01b2\u01b3\5T+\2\u01b3\u01b5\7\60\2\2\u01b4\u01b6"+
		"\5H%\2\u01b5\u01b4\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b8\3\2\2\2\u01b7"+
		"\u01ad\3\2\2\2\u01b7\u01af\3\2\2\2\u01b8E\3\2\2\2\u01b9\u01bd\5> \2\u01ba"+
		"\u01bd\5@!\2\u01bb\u01bd\5T+\2\u01bc\u01b9\3\2\2\2\u01bc\u01ba\3\2\2\2"+
		"\u01bc\u01bb\3\2\2\2\u01bdG\3\2\2\2\u01be\u01c1\5@!\2\u01bf\u01c1\5T+"+
		"\2\u01c0\u01be\3\2\2\2\u01c0\u01bf\3\2\2\2\u01c1I\3\2\2\2\u01c2\u01c4"+
		"\7!\2\2\u01c3\u01c2\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5"+
		"\u01c6\7J\2\2\u01c6\u01c7\79\2\2\u01c7\u01c8\5T+\2\u01c8K\3\2\2\2\u01c9"+
		"\u01cb\5N(\2\u01ca\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01ca\3\2\2"+
		"\2\u01cc\u01cd\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01d0\5<\37\2\u01cf\u01ce"+
		"\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2"+
		"M\3\2\2\2\u01d3\u01d4\7\b\2\2\u01d4\u01d5\5T+\2\u01d5\u01d6\79\2\2\u01d6"+
		"\u01da\3\2\2\2\u01d7\u01d8\7\r\2\2\u01d8\u01da\79\2\2\u01d9\u01d3\3\2"+
		"\2\2\u01d9\u01d7\3\2\2\2\u01daO\3\2\2\2\u01db\u01dc\7*\2\2\u01dc\u01dd"+
		"\5T+\2\u01dd\u01de\7+\2\2\u01deQ\3\2\2\2\u01df\u01e4\5T+\2\u01e0\u01e1"+
		"\7\61\2\2\u01e1\u01e3\5T+\2\u01e2\u01e0\3\2\2\2\u01e3\u01e6\3\2\2\2\u01e4"+
		"\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5S\3\2\2\2\u01e6\u01e4\3\2\2\2"+
		"\u01e7\u01e8\b+\1\2\u01e8\u01e9\t\5\2\2\u01e9\u01f0\5T+\17\u01ea\u01eb"+
		"\t\6\2\2\u01eb\u01f0\5T+\16\u01ec\u01f0\5V,\2\u01ed\u01ee\7\31\2\2\u01ee"+
		"\u01f0\5X-\2\u01ef\u01e7\3\2\2\2\u01ef\u01ea\3\2\2\2\u01ef\u01ec\3\2\2"+
		"\2\u01ef\u01ed\3\2\2\2\u01f0\u0225\3\2\2\2\u01f1\u01f2\f\r\2\2\u01f2\u01f3"+
		"\t\7\2\2\u01f3\u0224\5T+\16\u01f4\u01f5\f\f\2\2\u01f5\u01f6\t\5\2\2\u01f6"+
		"\u0224\5T+\r\u01f7\u01f8\f\13\2\2\u01f8\u01f9\t\b\2\2\u01f9\u0224\5T+"+
		"\f\u01fa\u01fb\f\n\2\2\u01fb\u01fc\t\t\2\2\u01fc\u0224\5T+\13\u01fd\u01fe"+
		"\f\t\2\2\u01fe\u01ff\t\n\2\2\u01ff\u0224\5T+\n\u0200\u0201\f\b\2\2\u0201"+
		"\u0202\7F\2\2\u0202\u0224\5T+\t\u0203\u0204\f\7\2\2\u0204\u0205\7H\2\2"+
		"\u0205\u0224\5T+\b\u0206\u0207\f\6\2\2\u0207\u0208\7G\2\2\u0208\u0224"+
		"\5T+\7\u0209\u020a\f\5\2\2\u020a\u020b\7>\2\2\u020b\u0224\5T+\6\u020c"+
		"\u020d\f\4\2\2\u020d\u020e\7?\2\2\u020e\u0224\5T+\5\u020f\u0210\f\3\2"+
		"\2\u0210\u0211\78\2\2\u0211\u0212\5T+\2\u0212\u0213\79\2\2\u0213\u0214"+
		"\5T+\4\u0214\u0224\3\2\2\2\u0215\u0216\f\23\2\2\u0216\u0217\7\62\2\2\u0217"+
		"\u0224\7J\2\2\u0218\u0219\f\22\2\2\u0219\u021a\7.\2\2\u021a\u021b\5T+"+
		"\2\u021b\u021c\7/\2\2\u021c\u0224\3\2\2\2\u021d\u021e\f\21\2\2\u021e\u0220"+
		"\7*\2\2\u021f\u0221\5R*\2\u0220\u021f\3\2\2\2\u0220\u0221\3\2\2\2\u0221"+
		"\u0222\3\2\2\2\u0222\u0224\7+\2\2\u0223\u01f1\3\2\2\2\u0223\u01f4\3\2"+
		"\2\2\u0223\u01f7\3\2\2\2\u0223\u01fa\3\2\2\2\u0223\u01fd\3\2\2\2\u0223"+
		"\u0200\3\2\2\2\u0223\u0203\3\2\2\2\u0223\u0206\3\2\2\2\u0223\u0209\3\2"+
		"\2\2\u0223\u020c\3\2\2\2\u0223\u020f\3\2\2\2\u0223\u0215\3\2\2\2\u0223"+
		"\u0218\3\2\2\2\u0223\u021d\3\2\2\2\u0224\u0227\3\2\2\2\u0225\u0223\3\2"+
		"\2\2\u0225\u0226\3\2\2\2\u0226U\3\2\2\2\u0227\u0225\3\2\2\2\u0228\u022d"+
		"\5P)\2\u0229\u022d\7 \2\2\u022a\u022d\5`\61\2\u022b\u022d\7J\2\2\u022c"+
		"\u0228\3\2\2\2\u022c\u0229\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022b\3\2"+
		"\2\2\u022dW\3\2\2\2\u022e\u0231\5Z.\2\u022f\u0232\5\\/\2\u0230\u0232\5"+
		"^\60\2\u0231\u022f\3\2\2\2\u0231\u0230\3\2\2\2\u0232Y\3\2\2\2\u0233\u0236"+
		"\5*\26\2\u0234\u0236\5.\30\2\u0235\u0233\3\2\2\2\u0235\u0234\3\2\2\2\u0236"+
		"[\3\2\2\2\u0237\u0238\7.\2\2\u0238\u023d\7/\2\2\u0239\u023a\7.\2\2\u023a"+
		"\u023c\7/\2\2\u023b\u0239\3\2\2\2\u023c\u023f\3\2\2\2\u023d\u023b\3\2"+
		"\2\2\u023d\u023e\3\2\2\2\u023e\u0240\3\2\2\2\u023f\u023d\3\2\2\2\u0240"+
		"\u0242\7,\2\2\u0241\u0243\5R*\2\u0242\u0241\3\2\2\2\u0242\u0243\3\2\2"+
		"\2\u0243\u0244\3\2\2\2\u0244\u0259\7-\2\2\u0245\u0246\7.\2\2\u0246\u0247"+
		"\5T+\2\u0247\u024e\7/\2\2\u0248\u0249\7.\2\2\u0249\u024a\5T+\2\u024a\u024b"+
		"\7/\2\2\u024b\u024d\3\2\2\2\u024c\u0248\3\2\2\2\u024d\u0250\3\2\2\2\u024e"+
		"\u024c\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0255\3\2\2\2\u0250\u024e\3\2"+
		"\2\2\u0251\u0252\7.\2\2\u0252\u0254\7/\2\2\u0253\u0251\3\2\2\2\u0254\u0257"+
		"\3\2\2\2\u0255\u0253\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u0259\3\2\2\2\u0257"+
		"\u0255\3\2\2\2\u0258\u0237\3\2\2\2\u0258\u0245\3\2\2\2\u0259]\3\2\2\2"+
		"\u025a\u025c\7*\2\2\u025b\u025d\5R*\2\u025c\u025b\3\2\2\2\u025c\u025d"+
		"\3\2\2\2\u025d\u025e\3\2\2\2\u025e\u0260\7+\2\2\u025f\u0261\5\26\f\2\u0260"+
		"\u025f\3\2\2\2\u0260\u0261\3\2\2\2\u0261_\3\2\2\2\u0262\u0263\t\13\2\2"+
		"\u0263a\3\2\2\2Cchn{\u0081\u0089\u008e\u0098\u00a0\u00a8\u00b1\u00bc\u00c7"+
		"\u00d0\u00dc\u00e1\u00eb\u00f0\u00f5\u0100\u0108\u010b\u0111\u0116\u011e"+
		"\u0127\u0130\u0135\u0138\u0146\u014d\u015f\u0171\u0177\u017e\u0189\u018e"+
		"\u0195\u019e\u01a3\u01ab\u01af\u01b5\u01b7\u01bc\u01c0\u01c3\u01cc\u01d1"+
		"\u01d9\u01e4\u01ef\u0220\u0223\u0225\u022c\u0231\u0235\u023d\u0242\u024e"+
		"\u0255\u0258\u025c\u0260";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}