// Generated from Sanka.g4 by ANTLR 4.5.1

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
		T__0=1, T__1=2, BOOLEAN=3, BREAK=4, BYTE=5, CASE=6, CLASS=7, CONST=8, 
		CONTINUE=9, DEFAULT=10, DOUBLE=11, ELSE=12, EXPORT=13, FLOAT=14, FOR=15, 
		IF=16, IMPORT=17, INLINE=18, INT=19, INTERFACE=20, LONG=21, NEW=22, PACKAGE=23, 
		PRIVATE=24, RETURN=25, SHORT=26, STATIC=27, SWITCH=28, THIS=29, VAR=30, 
		VOID=31, WHILE=32, C__INCLUDE=33, C__FIELD=34, C__STMT=35, IntegerLiteral=36, 
		FloatingPointLiteral=37, BooleanLiteral=38, CharacterLiteral=39, StringLiteral=40, 
		NullLiteral=41, LPAREN=42, RPAREN=43, LBRACE=44, RBRACE=45, LBRACK=46, 
		RBRACK=47, SEMI=48, COMMA=49, DOT=50, ASSIGN=51, GT=52, LT=53, BANG=54, 
		TILDE=55, QUESTION=56, COLON=57, EQUAL=58, LE=59, GE=60, NOTEQUAL=61, 
		AND=62, OR=63, INC=64, DEC=65, ADD=66, SUB=67, MUL=68, DIV=69, BITAND=70, 
		BITOR=71, CARET=72, MOD=73, Identifier=74, ELLIPSIS=75, WS=76, COMMENT=77, 
		LINE_COMMENT=78;
	public static final int
		RULE_compilationUnit = 0, RULE_packageDeclaration = 1, RULE_importDeclaration = 2, 
		RULE_typeDeclaration = 3, RULE_classDeclaration = 4, RULE_typeParameters = 5, 
		RULE_interfaceDeclaration = 6, RULE_classBody = 7, RULE_interfaceBody = 8, 
		RULE_classBodyDeclaration = 9, RULE_constDeclaration = 10, RULE_fieldDeclaration = 11, 
		RULE_fieldModifier = 12, RULE_constructorDeclaration = 13, RULE_methodDeclaration = 14, 
		RULE_interfaceBodyDeclaration = 15, RULE_interfaceMethodDeclaration = 16, 
		RULE_typeType = 17, RULE_classOrInterfaceType = 18, RULE_typeArguments = 19, 
		RULE_primitiveType = 20, RULE_formalParameters = 21, RULE_formalParameterList = 22, 
		RULE_formalParameter = 23, RULE_qualifiedName = 24, RULE_block = 25, RULE_statement = 26, 
		RULE_variableDeclaration = 27, RULE_variableAssignment = 28, RULE_assignable = 29, 
		RULE_ifStatement = 30, RULE_elseStatement = 31, RULE_forControl = 32, 
		RULE_forInit = 33, RULE_forIncrement = 34, RULE_enhancedForControl = 35, 
		RULE_switchLabel = 36, RULE_parExpression = 37, RULE_expressionList = 38, 
		RULE_expression = 39, RULE_primary = 40, RULE_creator = 41, RULE_arrayCreatorRest = 42, 
		RULE_classCreatorRest = 43, RULE_mapDefinition = 44, RULE_mapEntry = 45, 
		RULE_literal = 46;
	public static final String[] ruleNames = {
		"compilationUnit", "packageDeclaration", "importDeclaration", "typeDeclaration", 
		"classDeclaration", "typeParameters", "interfaceDeclaration", "classBody", 
		"interfaceBody", "classBodyDeclaration", "constDeclaration", "fieldDeclaration", 
		"fieldModifier", "constructorDeclaration", "methodDeclaration", "interfaceBodyDeclaration", 
		"interfaceMethodDeclaration", "typeType", "classOrInterfaceType", "typeArguments", 
		"primitiveType", "formalParameters", "formalParameterList", "formalParameter", 
		"qualifiedName", "block", "statement", "variableDeclaration", "variableAssignment", 
		"assignable", "ifStatement", "elseStatement", "forControl", "forInit", 
		"forIncrement", "enhancedForControl", "switchLabel", "parExpression", 
		"expressionList", "expression", "primary", "creator", "arrayCreatorRest", 
		"classCreatorRest", "mapDefinition", "mapEntry", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'<<'", "'>>'", "'boolean'", "'break'", "'byte'", "'case'", "'class'", 
		"'const'", "'continue'", "'default'", "'double'", "'else'", "'export'", 
		"'float'", "'for'", "'if'", "'import'", "'inline'", "'int'", "'interface'", 
		"'long'", "'new'", "'package'", "'private'", "'return'", "'short'", "'static'", 
		"'switch'", "'this'", "'var'", "'void'", "'while'", "'c__include'", "'c__field'", 
		"'c__stmt'", null, null, null, null, null, "'null'", "'('", "')'", "'{'", 
		"'}'", "'['", "']'", "';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", 
		"'~'", "'?'", "':'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", 
		"'--'", "'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", null, 
		"'...'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "BOOLEAN", "BREAK", "BYTE", "CASE", "CLASS", "CONST", 
		"CONTINUE", "DEFAULT", "DOUBLE", "ELSE", "EXPORT", "FLOAT", "FOR", "IF", 
		"IMPORT", "INLINE", "INT", "INTERFACE", "LONG", "NEW", "PACKAGE", "PRIVATE", 
		"RETURN", "SHORT", "STATIC", "SWITCH", "THIS", "VAR", "VOID", "WHILE", 
		"C__INCLUDE", "C__FIELD", "C__STMT", "IntegerLiteral", "FloatingPointLiteral", 
		"BooleanLiteral", "CharacterLiteral", "StringLiteral", "NullLiteral", 
		"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", 
		"DOT", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", 
		"LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", 
		"DIV", "BITAND", "BITOR", "CARET", "MOD", "Identifier", "ELLIPSIS", "WS", 
		"COMMENT", "LINE_COMMENT"
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
			setState(95);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(94);
				packageDeclaration();
				}
			}

			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(97);
				importDeclaration();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS || _la==INTERFACE) {
				{
				{
				setState(103);
				typeDeclaration();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
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
			setState(111);
			match(PACKAGE);
			setState(112);
			qualifiedName();
			setState(113);
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
			setState(115);
			match(IMPORT);
			setState(116);
			qualifiedName();
			setState(119);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(117);
				match(DOT);
				setState(118);
				match(MUL);
				}
			}

			setState(121);
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
			setState(125);
			switch (_input.LA(1)) {
			case CLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				classDeclaration();
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
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
		enterRule(_localctx, 8, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(CLASS);
			setState(128);
			match(Identifier);
			setState(130);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(129);
				typeParameters();
				}
			}

			setState(132);
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
		enterRule(_localctx, 10, RULE_typeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(LT);
			setState(135);
			match(Identifier);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(136);
				match(COMMA);
				setState(137);
				match(Identifier);
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143);
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
		enterRule(_localctx, 12, RULE_interfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(INTERFACE);
			setState(146);
			match(Identifier);
			setState(148);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(147);
				typeParameters();
				}
			}

			setState(150);
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
		enterRule(_localctx, 14, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(LBRACE);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CONST) | (1L << DOUBLE) | (1L << EXPORT) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << PRIVATE) | (1L << SHORT) | (1L << STATIC) | (1L << VOID) | (1L << C__INCLUDE) | (1L << C__FIELD))) != 0) || _la==Identifier) {
				{
				{
				setState(153);
				classBodyDeclaration();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
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
		enterRule(_localctx, 16, RULE_interfaceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(LBRACE);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CONST) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << PRIVATE) | (1L << SHORT) | (1L << STATIC) | (1L << VOID))) != 0) || _la==Identifier) {
				{
				{
				setState(162);
				interfaceBodyDeclaration();
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(168);
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
		public TerminalNode StringLiteral() { return getToken(SankaParser.StringLiteral, 0); }
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
		enterRule(_localctx, 18, RULE_classBodyDeclaration);
		try {
			setState(182);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				constDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				fieldDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				match(EXPORT);
				setState(173);
				match(Identifier);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				constructorDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				methodDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(176);
				match(C__INCLUDE);
				setState(177);
				match(StringLiteral);
				setState(178);
				match(SEMI);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(179);
				match(C__FIELD);
				setState(180);
				match(StringLiteral);
				setState(181);
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
		enterRule(_localctx, 20, RULE_constDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(CONST);
			setState(185);
			match(Identifier);
			setState(186);
			match(ASSIGN);
			setState(187);
			expression(0);
			setState(188);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 22, RULE_fieldDeclaration);
		int _la;
		try {
			setState(221);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) {
					{
					{
					setState(190);
					fieldModifier();
					}
					}
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(196);
				typeType(0);
				setState(197);
				match(Identifier);
				setState(200);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(198);
					match(ASSIGN);
					setState(199);
					expression(0);
					}
				}

				setState(202);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) {
					{
					{
					setState(204);
					fieldModifier();
					}
					}
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(210);
				typeType(0);
				setState(211);
				match(Identifier);
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(212);
					match(COMMA);
					setState(213);
					match(Identifier);
					}
					}
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(219);
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

	public static class FieldModifierContext extends ParserRuleContext {
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
		enterRule(_localctx, 24, RULE_fieldModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) ) {
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
		enterRule(_localctx, 26, RULE_constructorDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
		public List<FieldModifierContext> fieldModifier() {
			return getRuleContexts(FieldModifierContext.class);
		}
		public FieldModifierContext fieldModifier(int i) {
			return getRuleContext(FieldModifierContext.class,i);
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
		enterRule(_localctx, 28, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) {
				{
				{
				setState(229);
				fieldModifier();
				}
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(237);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				{
				setState(235);
				typeType(0);
				}
				break;
			case VOID:
				{
				setState(236);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(239);
			match(Identifier);
			setState(240);
			formalParameters();
			setState(241);
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
		enterRule(_localctx, 30, RULE_interfaceBodyDeclaration);
		try {
			setState(245);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				constDeclaration();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case DOUBLE:
			case FLOAT:
			case INLINE:
			case INT:
			case LONG:
			case PRIVATE:
			case SHORT:
			case STATIC:
			case VOID:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
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
		public List<FieldModifierContext> fieldModifier() {
			return getRuleContexts(FieldModifierContext.class);
		}
		public FieldModifierContext fieldModifier(int i) {
			return getRuleContext(FieldModifierContext.class,i);
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
		enterRule(_localctx, 32, RULE_interfaceMethodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) {
				{
				{
				setState(247);
				fieldModifier();
				}
				}
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(255);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				{
				setState(253);
				typeType(0);
				}
				break;
			case VOID:
				{
				setState(254);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(257);
			match(Identifier);
			setState(258);
			formalParameters();
			setState(259);
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
		public List<TypeTypeContext> typeType() {
			return getRuleContexts(TypeTypeContext.class);
		}
		public TypeTypeContext typeType(int i) {
			return getRuleContext(TypeTypeContext.class,i);
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
		return typeType(0);
	}

	private TypeTypeContext typeType(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeTypeContext _localctx = new TypeTypeContext(_ctx, _parentState);
		TypeTypeContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_typeType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(262);
				classOrInterfaceType();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				{
				setState(263);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(274);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new TypeTypeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_typeType);
						setState(266);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(267);
						match(LBRACK);
						setState(268);
						match(RBRACK);
						}
						break;
					case 2:
						{
						_localctx = new TypeTypeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_typeType);
						setState(269);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(270);
						match(LBRACK);
						setState(271);
						typeType(0);
						setState(272);
						match(RBRACK);
						}
						break;
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		enterRule(_localctx, 36, RULE_classOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(279);
					match(Identifier);
					setState(280);
					match(DOT);
					}
					} 
				}
				setState(285);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(286);
			match(Identifier);
			setState(288);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(287);
				typeArguments();
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
		enterRule(_localctx, 38, RULE_typeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(LT);
			setState(291);
			typeType(0);
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(292);
				match(COMMA);
				setState(293);
				typeType(0);
				}
				}
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(299);
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
		enterRule(_localctx, 40, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0)) ) {
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
		enterRule(_localctx, 42, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(LPAREN);
			setState(305);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || _la==Identifier) {
				{
				setState(304);
				formalParameterList();
				}
			}

			setState(307);
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
		enterRule(_localctx, 44, RULE_formalParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			formalParameter();
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(310);
				match(COMMA);
				setState(311);
				formalParameter();
				}
				}
				setState(316);
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
		enterRule(_localctx, 46, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			typeType(0);
			setState(318);
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
		enterRule(_localctx, 48, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(Identifier);
			setState(325);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(321);
					match(DOT);
					setState(322);
					match(Identifier);
					}
					} 
				}
				setState(327);
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
		enterRule(_localctx, 50, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(LBRACE);
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << FOR) | (1L << IF) | (1L << INLINE) | (1L << NEW) | (1L << RETURN) | (1L << SWITCH) | (1L << THIS) | (1L << VAR) | (1L << WHILE) | (1L << C__STMT) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << BANG) | (1L << TILDE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (ADD - 66)) | (1L << (SUB - 66)) | (1L << (Identifier - 66)))) != 0)) {
				{
				{
				setState(329);
				statement();
				}
				}
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(335);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public SwitchLabelContext switchLabel() {
			return getRuleContext(SwitchLabelContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode StringLiteral() { return getToken(SankaParser.StringLiteral, 0); }
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
		enterRule(_localctx, 52, RULE_statement);
		int _la;
		try {
			setState(376);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				variableDeclaration();
				setState(339);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(341);
				variableAssignment();
				setState(342);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(344);
				ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(345);
				match(FOR);
				setState(346);
				match(LPAREN);
				setState(347);
				forControl();
				setState(348);
				match(RPAREN);
				setState(349);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(351);
				match(WHILE);
				setState(352);
				parExpression();
				setState(353);
				block();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(355);
				match(SWITCH);
				setState(356);
				parExpression();
				setState(357);
				block();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(359);
				switchLabel();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(360);
				match(RETURN);
				setState(362);
				_la = _input.LA(1);
				if (((((_la - 22)) & ~0x3f) == 0 && ((1L << (_la - 22)) & ((1L << (NEW - 22)) | (1L << (THIS - 22)) | (1L << (IntegerLiteral - 22)) | (1L << (FloatingPointLiteral - 22)) | (1L << (BooleanLiteral - 22)) | (1L << (CharacterLiteral - 22)) | (1L << (StringLiteral - 22)) | (1L << (NullLiteral - 22)) | (1L << (LPAREN - 22)) | (1L << (BANG - 22)) | (1L << (TILDE - 22)) | (1L << (ADD - 22)) | (1L << (SUB - 22)) | (1L << (Identifier - 22)))) != 0)) {
					{
					setState(361);
					expression(0);
					}
				}

				setState(364);
				match(SEMI);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(365);
				match(BREAK);
				setState(366);
				match(SEMI);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(367);
				match(CONTINUE);
				setState(368);
				match(SEMI);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(369);
				expression(0);
				setState(370);
				match(SEMI);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(372);
				match(C__STMT);
				setState(373);
				match(StringLiteral);
				setState(374);
				match(SEMI);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(375);
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
		enterRule(_localctx, 54, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			_la = _input.LA(1);
			if (_la==INLINE) {
				{
				setState(378);
				match(INLINE);
				}
			}

			setState(381);
			match(VAR);
			setState(382);
			match(Identifier);
			setState(385);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(383);
				match(ASSIGN);
				setState(384);
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
		enterRule(_localctx, 56, RULE_variableAssignment);
		int _la;
		try {
			setState(394);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				assignable();
				setState(388);
				match(ASSIGN);
				setState(389);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(391);
				assignable();
				setState(392);
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
		enterRule(_localctx, 58, RULE_assignable);
		try {
			setState(407);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(399);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(396);
					expression(0);
					setState(397);
					match(DOT);
					}
					break;
				}
				setState(401);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
				expression(0);
				setState(403);
				match(LBRACK);
				setState(404);
				expression(0);
				setState(405);
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

	public static class IfStatementContext extends ParserRuleContext {
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			match(IF);
			setState(410);
			parExpression();
			setState(411);
			block();
			setState(414);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(412);
				match(ELSE);
				setState(413);
				elseStatement();
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

	public static class ElseStatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitElseStatement(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_elseStatement);
		try {
			setState(418);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(416);
				block();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(417);
				ifStatement();
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
		enterRule(_localctx, 64, RULE_forControl);
		int _la;
		try {
			setState(430);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(420);
				enhancedForControl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(422);
				_la = _input.LA(1);
				if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (INLINE - 18)) | (1L << (NEW - 18)) | (1L << (THIS - 18)) | (1L << (VAR - 18)) | (1L << (IntegerLiteral - 18)) | (1L << (FloatingPointLiteral - 18)) | (1L << (BooleanLiteral - 18)) | (1L << (CharacterLiteral - 18)) | (1L << (StringLiteral - 18)) | (1L << (NullLiteral - 18)) | (1L << (LPAREN - 18)) | (1L << (BANG - 18)) | (1L << (TILDE - 18)) | (1L << (ADD - 18)) | (1L << (SUB - 18)) | (1L << (Identifier - 18)))) != 0)) {
					{
					setState(421);
					forInit();
					}
				}

				setState(424);
				match(SEMI);
				setState(425);
				expression(0);
				setState(426);
				match(SEMI);
				setState(428);
				_la = _input.LA(1);
				if (((((_la - 22)) & ~0x3f) == 0 && ((1L << (_la - 22)) & ((1L << (NEW - 22)) | (1L << (THIS - 22)) | (1L << (IntegerLiteral - 22)) | (1L << (FloatingPointLiteral - 22)) | (1L << (BooleanLiteral - 22)) | (1L << (CharacterLiteral - 22)) | (1L << (StringLiteral - 22)) | (1L << (NullLiteral - 22)) | (1L << (LPAREN - 22)) | (1L << (BANG - 22)) | (1L << (TILDE - 22)) | (1L << (ADD - 22)) | (1L << (SUB - 22)) | (1L << (Identifier - 22)))) != 0)) {
					{
					setState(427);
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
		enterRule(_localctx, 66, RULE_forInit);
		try {
			setState(435);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(432);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(433);
				variableAssignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(434);
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
		enterRule(_localctx, 68, RULE_forIncrement);
		try {
			setState(439);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(437);
				variableAssignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
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
		public List<TerminalNode> Identifier() { return getTokens(SankaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SankaParser.Identifier, i);
		}
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
		enterRule(_localctx, 70, RULE_enhancedForControl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(441);
			match(VAR);
			setState(442);
			match(Identifier);
			setState(445);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(443);
				match(COMMA);
				setState(444);
				match(Identifier);
				}
			}

			setState(447);
			match(COLON);
			setState(448);
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
		enterRule(_localctx, 72, RULE_switchLabel);
		try {
			setState(456);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(450);
				match(CASE);
				setState(451);
				expression(0);
				setState(452);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(454);
				match(DEFAULT);
				setState(455);
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
		enterRule(_localctx, 74, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(LPAREN);
			setState(459);
			expression(0);
			setState(460);
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
		enterRule(_localctx, 76, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			expression(0);
			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(463);
				match(COMMA);
				setState(464);
				expression(0);
				}
				}
				setState(469);
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
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			switch (_input.LA(1)) {
			case ADD:
			case SUB:
				{
				setState(471);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(472);
				expression(13);
				}
				break;
			case BANG:
			case TILDE:
				{
				setState(473);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(474);
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
				setState(475);
				primary();
				}
				break;
			case NEW:
				{
				setState(476);
				match(NEW);
				setState(477);
				creator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(532);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(530);
					switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(480);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(481);
						_la = _input.LA(1);
						if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (MUL - 68)) | (1L << (DIV - 68)) | (1L << (MOD - 68)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(482);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(483);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(484);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(485);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(486);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(487);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__1) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(488);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(489);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(490);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << LE) | (1L << GE))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(491);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(492);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(493);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(494);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(495);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(496);
						match(BITAND);
						setState(497);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(498);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(499);
						match(CARET);
						setState(500);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(501);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(502);
						match(BITOR);
						setState(503);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(504);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(505);
						match(AND);
						setState(506);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(507);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(508);
						match(OR);
						setState(509);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(510);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(511);
						match(QUESTION);
						setState(512);
						expression(0);
						setState(513);
						match(COLON);
						setState(514);
						expression(2);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(516);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(517);
						match(DOT);
						setState(518);
						match(Identifier);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(519);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(520);
						match(LBRACK);
						setState(521);
						expression(0);
						setState(522);
						match(RBRACK);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(524);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(525);
						match(LPAREN);
						setState(527);
						_la = _input.LA(1);
						if (((((_la - 22)) & ~0x3f) == 0 && ((1L << (_la - 22)) & ((1L << (NEW - 22)) | (1L << (THIS - 22)) | (1L << (IntegerLiteral - 22)) | (1L << (FloatingPointLiteral - 22)) | (1L << (BooleanLiteral - 22)) | (1L << (CharacterLiteral - 22)) | (1L << (StringLiteral - 22)) | (1L << (NullLiteral - 22)) | (1L << (LPAREN - 22)) | (1L << (BANG - 22)) | (1L << (TILDE - 22)) | (1L << (ADD - 22)) | (1L << (SUB - 22)) | (1L << (Identifier - 22)))) != 0)) {
							{
							setState(526);
							expressionList();
							}
						}

						setState(529);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(534);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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
		enterRule(_localctx, 80, RULE_primary);
		try {
			setState(539);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(535);
				parExpression();
				}
				break;
			case THIS:
				enterOuterAlt(_localctx, 2);
				{
				setState(536);
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
				setState(537);
				literal();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(538);
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
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
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
		enterRule(_localctx, 82, RULE_creator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			typeType(0);
			setState(544);
			switch (_input.LA(1)) {
			case LBRACK:
				{
				setState(542);
				arrayCreatorRest();
				}
				break;
			case LPAREN:
				{
				setState(543);
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

	public static class ArrayCreatorRestContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public MapDefinitionContext mapDefinition() {
			return getRuleContext(MapDefinitionContext.class,0);
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
		enterRule(_localctx, 84, RULE_arrayCreatorRest);
		int _la;
		try {
			setState(564);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(546);
				match(LBRACK);
				setState(547);
				match(RBRACK);
				setState(548);
				match(LBRACE);
				setState(550);
				_la = _input.LA(1);
				if (((((_la - 22)) & ~0x3f) == 0 && ((1L << (_la - 22)) & ((1L << (NEW - 22)) | (1L << (THIS - 22)) | (1L << (IntegerLiteral - 22)) | (1L << (FloatingPointLiteral - 22)) | (1L << (BooleanLiteral - 22)) | (1L << (CharacterLiteral - 22)) | (1L << (StringLiteral - 22)) | (1L << (NullLiteral - 22)) | (1L << (LPAREN - 22)) | (1L << (BANG - 22)) | (1L << (TILDE - 22)) | (1L << (ADD - 22)) | (1L << (SUB - 22)) | (1L << (Identifier - 22)))) != 0)) {
					{
					setState(549);
					expressionList();
					}
				}

				setState(552);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(553);
				match(LBRACK);
				setState(554);
				expression(0);
				setState(555);
				match(RBRACK);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(557);
				match(LBRACK);
				setState(558);
				match(CLASS);
				setState(559);
				typeType(0);
				setState(560);
				match(RBRACK);
				setState(562);
				switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
				case 1:
					{
					setState(561);
					mapDefinition();
					}
					break;
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
		enterRule(_localctx, 86, RULE_classCreatorRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			match(LPAREN);
			setState(568);
			_la = _input.LA(1);
			if (((((_la - 22)) & ~0x3f) == 0 && ((1L << (_la - 22)) & ((1L << (NEW - 22)) | (1L << (THIS - 22)) | (1L << (IntegerLiteral - 22)) | (1L << (FloatingPointLiteral - 22)) | (1L << (BooleanLiteral - 22)) | (1L << (CharacterLiteral - 22)) | (1L << (StringLiteral - 22)) | (1L << (NullLiteral - 22)) | (1L << (LPAREN - 22)) | (1L << (BANG - 22)) | (1L << (TILDE - 22)) | (1L << (ADD - 22)) | (1L << (SUB - 22)) | (1L << (Identifier - 22)))) != 0)) {
				{
				setState(567);
				expressionList();
				}
			}

			setState(570);
			match(RPAREN);
			setState(572);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(571);
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

	public static class MapDefinitionContext extends ParserRuleContext {
		public List<MapEntryContext> mapEntry() {
			return getRuleContexts(MapEntryContext.class);
		}
		public MapEntryContext mapEntry(int i) {
			return getRuleContext(MapEntryContext.class,i);
		}
		public MapDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterMapDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitMapDefinition(this);
		}
	}

	public final MapDefinitionContext mapDefinition() throws RecognitionException {
		MapDefinitionContext _localctx = new MapDefinitionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_mapDefinition);
		int _la;
		try {
			setState(587);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(574);
				match(LBRACE);
				setState(575);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(576);
				match(LBRACE);
				setState(577);
				mapEntry();
				setState(582);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(578);
					match(COMMA);
					setState(579);
					mapEntry();
					}
					}
					setState(584);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(585);
				match(RBRACE);
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

	public static class MapEntryContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MapEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterMapEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitMapEntry(this);
		}
	}

	public final MapEntryContext mapEntry() throws RecognitionException {
		MapEntryContext _localctx = new MapEntryContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_mapEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			expression(0);
			setState(590);
			match(COLON);
			setState(591);
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
		enterRule(_localctx, 92, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
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
		case 17:
			return typeType_sempred((TypeTypeContext)_localctx, predIndex);
		case 39:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typeType_sempred(TypeTypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		case 13:
			return precpred(_ctx, 17);
		case 14:
			return precpred(_ctx, 16);
		case 15:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3P\u0256\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\5\2b\n\2\3\2\7\2e\n\2\f\2\16\2h\13"+
		"\2\3\2\7\2k\n\2\f\2\16\2n\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\5\4z\n\4\3\4\3\4\3\5\3\5\5\5\u0080\n\5\3\6\3\6\3\6\5\6\u0085\n\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\7\7\u008d\n\7\f\7\16\7\u0090\13\7\3\7\3\7\3\b\3\b"+
		"\3\b\5\b\u0097\n\b\3\b\3\b\3\t\3\t\7\t\u009d\n\t\f\t\16\t\u00a0\13\t\3"+
		"\t\3\t\3\n\3\n\7\n\u00a6\n\n\f\n\16\n\u00a9\13\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00b9\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\7\r\u00c2\n\r\f\r\16\r\u00c5\13\r\3\r\3\r\3\r\3\r"+
		"\5\r\u00cb\n\r\3\r\3\r\3\r\7\r\u00d0\n\r\f\r\16\r\u00d3\13\r\3\r\3\r\3"+
		"\r\3\r\7\r\u00d9\n\r\f\r\16\r\u00dc\13\r\3\r\3\r\5\r\u00e0\n\r\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\20\7\20\u00e9\n\20\f\20\16\20\u00ec\13\20\3"+
		"\20\3\20\5\20\u00f0\n\20\3\20\3\20\3\20\3\20\3\21\3\21\5\21\u00f8\n\21"+
		"\3\22\7\22\u00fb\n\22\f\22\16\22\u00fe\13\22\3\22\3\22\5\22\u0102\n\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\5\23\u010b\n\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\7\23\u0115\n\23\f\23\16\23\u0118\13\23\3\24\3\24"+
		"\7\24\u011c\n\24\f\24\16\24\u011f\13\24\3\24\3\24\5\24\u0123\n\24\3\25"+
		"\3\25\3\25\3\25\7\25\u0129\n\25\f\25\16\25\u012c\13\25\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\5\27\u0134\n\27\3\27\3\27\3\30\3\30\3\30\7\30\u013b\n"+
		"\30\f\30\16\30\u013e\13\30\3\31\3\31\3\31\3\32\3\32\3\32\7\32\u0146\n"+
		"\32\f\32\16\32\u0149\13\32\3\33\3\33\7\33\u014d\n\33\f\33\16\33\u0150"+
		"\13\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u016d\n\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\5\34\u017b\n\34\3\35\5\35\u017e\n\35\3\35\3\35\3\35\3\35\5\35\u0184"+
		"\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u018d\n\36\3\37\3\37\3\37"+
		"\5\37\u0192\n\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u019a\n\37\3 \3 \3"+
		" \3 \3 \5 \u01a1\n \3!\3!\5!\u01a5\n!\3\"\3\"\5\"\u01a9\n\"\3\"\3\"\3"+
		"\"\3\"\5\"\u01af\n\"\5\"\u01b1\n\"\3#\3#\3#\5#\u01b6\n#\3$\3$\5$\u01ba"+
		"\n$\3%\3%\3%\3%\5%\u01c0\n%\3%\3%\3%\3&\3&\3&\3&\3&\3&\5&\u01cb\n&\3\'"+
		"\3\'\3\'\3\'\3(\3(\3(\7(\u01d4\n(\f(\16(\u01d7\13(\3)\3)\3)\3)\3)\3)\3"+
		")\3)\5)\u01e1\n)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\5)\u0212\n)\3)\7)\u0215\n)\f)\16)\u0218\13)\3*\3*"+
		"\3*\3*\5*\u021e\n*\3+\3+\3+\5+\u0223\n+\3,\3,\3,\3,\5,\u0229\n,\3,\3,"+
		"\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0235\n,\5,\u0237\n,\3-\3-\5-\u023b\n-\3-"+
		"\3-\5-\u023f\n-\3.\3.\3.\3.\3.\3.\7.\u0247\n.\f.\16.\u024a\13.\3.\3.\5"+
		".\u024e\n.\3/\3/\3/\3/\3\60\3\60\3\60\2\4$P\61\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^\2\f\5\2\24\24"+
		"\32\32\35\35\t\2\5\5\7\7\r\r\20\20\25\25\27\27\34\34\3\2BC\3\2DE\3\28"+
		"9\4\2FGKK\3\2\3\4\4\2\66\67=>\4\2<<??\3\2&+\u0286\2a\3\2\2\2\4q\3\2\2"+
		"\2\6u\3\2\2\2\b\177\3\2\2\2\n\u0081\3\2\2\2\f\u0088\3\2\2\2\16\u0093\3"+
		"\2\2\2\20\u009a\3\2\2\2\22\u00a3\3\2\2\2\24\u00b8\3\2\2\2\26\u00ba\3\2"+
		"\2\2\30\u00df\3\2\2\2\32\u00e1\3\2\2\2\34\u00e3\3\2\2\2\36\u00ea\3\2\2"+
		"\2 \u00f7\3\2\2\2\"\u00fc\3\2\2\2$\u010a\3\2\2\2&\u011d\3\2\2\2(\u0124"+
		"\3\2\2\2*\u012f\3\2\2\2,\u0131\3\2\2\2.\u0137\3\2\2\2\60\u013f\3\2\2\2"+
		"\62\u0142\3\2\2\2\64\u014a\3\2\2\2\66\u017a\3\2\2\28\u017d\3\2\2\2:\u018c"+
		"\3\2\2\2<\u0199\3\2\2\2>\u019b\3\2\2\2@\u01a4\3\2\2\2B\u01b0\3\2\2\2D"+
		"\u01b5\3\2\2\2F\u01b9\3\2\2\2H\u01bb\3\2\2\2J\u01ca\3\2\2\2L\u01cc\3\2"+
		"\2\2N\u01d0\3\2\2\2P\u01e0\3\2\2\2R\u021d\3\2\2\2T\u021f\3\2\2\2V\u0236"+
		"\3\2\2\2X\u0238\3\2\2\2Z\u024d\3\2\2\2\\\u024f\3\2\2\2^\u0253\3\2\2\2"+
		"`b\5\4\3\2a`\3\2\2\2ab\3\2\2\2bf\3\2\2\2ce\5\6\4\2dc\3\2\2\2eh\3\2\2\2"+
		"fd\3\2\2\2fg\3\2\2\2gl\3\2\2\2hf\3\2\2\2ik\5\b\5\2ji\3\2\2\2kn\3\2\2\2"+
		"lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7\2\2\3p\3\3\2\2\2qr\7\31\2"+
		"\2rs\5\62\32\2st\7\62\2\2t\5\3\2\2\2uv\7\23\2\2vy\5\62\32\2wx\7\64\2\2"+
		"xz\7F\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7\62\2\2|\7\3\2\2\2}\u0080\5"+
		"\n\6\2~\u0080\5\16\b\2\177}\3\2\2\2\177~\3\2\2\2\u0080\t\3\2\2\2\u0081"+
		"\u0082\7\t\2\2\u0082\u0084\7L\2\2\u0083\u0085\5\f\7\2\u0084\u0083\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\5\20\t\2\u0087"+
		"\13\3\2\2\2\u0088\u0089\7\67\2\2\u0089\u008e\7L\2\2\u008a\u008b\7\63\2"+
		"\2\u008b\u008d\7L\2\2\u008c\u008a\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091"+
		"\u0092\7\66\2\2\u0092\r\3\2\2\2\u0093\u0094\7\26\2\2\u0094\u0096\7L\2"+
		"\2\u0095\u0097\5\f\7\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\u0099\5\22\n\2\u0099\17\3\2\2\2\u009a\u009e\7.\2\2\u009b"+
		"\u009d\5\24\13\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3"+
		"\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u00a2\7/\2\2\u00a2\21\3\2\2\2\u00a3\u00a7\7.\2\2\u00a4\u00a6\5 \21\2"+
		"\u00a5\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\7/\2\2\u00ab"+
		"\23\3\2\2\2\u00ac\u00b9\5\26\f\2\u00ad\u00b9\5\30\r\2\u00ae\u00af\7\17"+
		"\2\2\u00af\u00b9\7L\2\2\u00b0\u00b9\5\34\17\2\u00b1\u00b9\5\36\20\2\u00b2"+
		"\u00b3\7#\2\2\u00b3\u00b4\7*\2\2\u00b4\u00b9\7\62\2\2\u00b5\u00b6\7$\2"+
		"\2\u00b6\u00b7\7*\2\2\u00b7\u00b9\7\62\2\2\u00b8\u00ac\3\2\2\2\u00b8\u00ad"+
		"\3\2\2\2\u00b8\u00ae\3\2\2\2\u00b8\u00b0\3\2\2\2\u00b8\u00b1\3\2\2\2\u00b8"+
		"\u00b2\3\2\2\2\u00b8\u00b5\3\2\2\2\u00b9\25\3\2\2\2\u00ba\u00bb\7\n\2"+
		"\2\u00bb\u00bc\7L\2\2\u00bc\u00bd\7\65\2\2\u00bd\u00be\5P)\2\u00be\u00bf"+
		"\7\62\2\2\u00bf\27\3\2\2\2\u00c0\u00c2\5\32\16\2\u00c1\u00c0\3\2\2\2\u00c2"+
		"\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2"+
		"\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\5$\23\2\u00c7\u00ca\7L\2\2\u00c8"+
		"\u00c9\7\65\2\2\u00c9\u00cb\5P)\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\7\62\2\2\u00cd\u00e0\3\2\2\2\u00ce"+
		"\u00d0\5\32\16\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3"+
		"\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4"+
		"\u00d5\5$\23\2\u00d5\u00da\7L\2\2\u00d6\u00d7\7\63\2\2\u00d7\u00d9\7L"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7\62"+
		"\2\2\u00de\u00e0\3\2\2\2\u00df\u00c3\3\2\2\2\u00df\u00d1\3\2\2\2\u00e0"+
		"\31\3\2\2\2\u00e1\u00e2\t\2\2\2\u00e2\33\3\2\2\2\u00e3\u00e4\7L\2\2\u00e4"+
		"\u00e5\5,\27\2\u00e5\u00e6\5\64\33\2\u00e6\35\3\2\2\2\u00e7\u00e9\5\32"+
		"\16\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\u00ef\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\5$"+
		"\23\2\u00ee\u00f0\7!\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00f2\7L\2\2\u00f2\u00f3\5,\27\2\u00f3\u00f4\5\64"+
		"\33\2\u00f4\37\3\2\2\2\u00f5\u00f8\5\26\f\2\u00f6\u00f8\5\"\22\2\u00f7"+
		"\u00f5\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8!\3\2\2\2\u00f9\u00fb\5\32\16"+
		"\2\u00fa\u00f9\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd"+
		"\3\2\2\2\u00fd\u0101\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0102\5$\23\2\u0100"+
		"\u0102\7!\2\2\u0101\u00ff\3\2\2\2\u0101\u0100\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0104\7L\2\2\u0104\u0105\5,\27\2\u0105\u0106\7\62\2\2\u0106"+
		"#\3\2\2\2\u0107\u0108\b\23\1\2\u0108\u010b\5&\24\2\u0109\u010b\5*\26\2"+
		"\u010a\u0107\3\2\2\2\u010a\u0109\3\2\2\2\u010b\u0116\3\2\2\2\u010c\u010d"+
		"\f\4\2\2\u010d\u010e\7\60\2\2\u010e\u0115\7\61\2\2\u010f\u0110\f\3\2\2"+
		"\u0110\u0111\7\60\2\2\u0111\u0112\5$\23\2\u0112\u0113\7\61\2\2\u0113\u0115"+
		"\3\2\2\2\u0114\u010c\3\2\2\2\u0114\u010f\3\2\2\2\u0115\u0118\3\2\2\2\u0116"+
		"\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117%\3\2\2\2\u0118\u0116\3\2\2\2"+
		"\u0119\u011a\7L\2\2\u011a\u011c\7\64\2\2\u011b\u0119\3\2\2\2\u011c\u011f"+
		"\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u0120\u0122\7L\2\2\u0121\u0123\5(\25\2\u0122\u0121\3\2"+
		"\2\2\u0122\u0123\3\2\2\2\u0123\'\3\2\2\2\u0124\u0125\7\67\2\2\u0125\u012a"+
		"\5$\23\2\u0126\u0127\7\63\2\2\u0127\u0129\5$\23\2\u0128\u0126\3\2\2\2"+
		"\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d"+
		"\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\7\66\2\2\u012e)\3\2\2\2\u012f"+
		"\u0130\t\3\2\2\u0130+\3\2\2\2\u0131\u0133\7,\2\2\u0132\u0134\5.\30\2\u0133"+
		"\u0132\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\7-"+
		"\2\2\u0136-\3\2\2\2\u0137\u013c\5\60\31\2\u0138\u0139\7\63\2\2\u0139\u013b"+
		"\5\60\31\2\u013a\u0138\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2"+
		"\u013c\u013d\3\2\2\2\u013d/\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\5"+
		"$\23\2\u0140\u0141\7L\2\2\u0141\61\3\2\2\2\u0142\u0147\7L\2\2\u0143\u0144"+
		"\7\64\2\2\u0144\u0146\7L\2\2\u0145\u0143\3\2\2\2\u0146\u0149\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\63\3\2\2\2\u0149\u0147\3\2\2"+
		"\2\u014a\u014e\7.\2\2\u014b\u014d\5\66\34\2\u014c\u014b\3\2\2\2\u014d"+
		"\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2"+
		"\2\2\u0150\u014e\3\2\2\2\u0151\u0152\7/\2\2\u0152\65\3\2\2\2\u0153\u017b"+
		"\5\64\33\2\u0154\u0155\58\35\2\u0155\u0156\7\62\2\2\u0156\u017b\3\2\2"+
		"\2\u0157\u0158\5:\36\2\u0158\u0159\7\62\2\2\u0159\u017b\3\2\2\2\u015a"+
		"\u017b\5> \2\u015b\u015c\7\21\2\2\u015c\u015d\7,\2\2\u015d\u015e\5B\""+
		"\2\u015e\u015f\7-\2\2\u015f\u0160\5\64\33\2\u0160\u017b\3\2\2\2\u0161"+
		"\u0162\7\"\2\2\u0162\u0163\5L\'\2\u0163\u0164\5\64\33\2\u0164\u017b\3"+
		"\2\2\2\u0165\u0166\7\36\2\2\u0166\u0167\5L\'\2\u0167\u0168\5\64\33\2\u0168"+
		"\u017b\3\2\2\2\u0169\u017b\5J&\2\u016a\u016c\7\33\2\2\u016b\u016d\5P)"+
		"\2\u016c\u016b\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u017b"+
		"\7\62\2\2\u016f\u0170\7\6\2\2\u0170\u017b\7\62\2\2\u0171\u0172\7\13\2"+
		"\2\u0172\u017b\7\62\2\2\u0173\u0174\5P)\2\u0174\u0175\7\62\2\2\u0175\u017b"+
		"\3\2\2\2\u0176\u0177\7%\2\2\u0177\u0178\7*\2\2\u0178\u017b\7\62\2\2\u0179"+
		"\u017b\7\62\2\2\u017a\u0153\3\2\2\2\u017a\u0154\3\2\2\2\u017a\u0157\3"+
		"\2\2\2\u017a\u015a\3\2\2\2\u017a\u015b\3\2\2\2\u017a\u0161\3\2\2\2\u017a"+
		"\u0165\3\2\2\2\u017a\u0169\3\2\2\2\u017a\u016a\3\2\2\2\u017a\u016f\3\2"+
		"\2\2\u017a\u0171\3\2\2\2\u017a\u0173\3\2\2\2\u017a\u0176\3\2\2\2\u017a"+
		"\u0179\3\2\2\2\u017b\67\3\2\2\2\u017c\u017e\7\24\2\2\u017d\u017c\3\2\2"+
		"\2\u017d\u017e\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\7 \2\2\u0180\u0183"+
		"\7L\2\2\u0181\u0182\7\65\2\2\u0182\u0184\5P)\2\u0183\u0181\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u01849\3\2\2\2\u0185\u0186\5<\37\2\u0186\u0187\7\65\2\2"+
		"\u0187\u0188\5P)\2\u0188\u018d\3\2\2\2\u0189\u018a\5<\37\2\u018a\u018b"+
		"\t\4\2\2\u018b\u018d\3\2\2\2\u018c\u0185\3\2\2\2\u018c\u0189\3\2\2\2\u018d"+
		";\3\2\2\2\u018e\u018f\5P)\2\u018f\u0190\7\64\2\2\u0190\u0192\3\2\2\2\u0191"+
		"\u018e\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u019a\7L"+
		"\2\2\u0194\u0195\5P)\2\u0195\u0196\7\60\2\2\u0196\u0197\5P)\2\u0197\u0198"+
		"\7\61\2\2\u0198\u019a\3\2\2\2\u0199\u0191\3\2\2\2\u0199\u0194\3\2\2\2"+
		"\u019a=\3\2\2\2\u019b\u019c\7\22\2\2\u019c\u019d\5L\'\2\u019d\u01a0\5"+
		"\64\33\2\u019e\u019f\7\16\2\2\u019f\u01a1\5@!\2\u01a0\u019e\3\2\2\2\u01a0"+
		"\u01a1\3\2\2\2\u01a1?\3\2\2\2\u01a2\u01a5\5\64\33\2\u01a3\u01a5\5> \2"+
		"\u01a4\u01a2\3\2\2\2\u01a4\u01a3\3\2\2\2\u01a5A\3\2\2\2\u01a6\u01b1\5"+
		"H%\2\u01a7\u01a9\5D#\2\u01a8\u01a7\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa"+
		"\3\2\2\2\u01aa\u01ab\7\62\2\2\u01ab\u01ac\5P)\2\u01ac\u01ae\7\62\2\2\u01ad"+
		"\u01af\5F$\2\u01ae\u01ad\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b1\3\2\2"+
		"\2\u01b0\u01a6\3\2\2\2\u01b0\u01a8\3\2\2\2\u01b1C\3\2\2\2\u01b2\u01b6"+
		"\58\35\2\u01b3\u01b6\5:\36\2\u01b4\u01b6\5P)\2\u01b5\u01b2\3\2\2\2\u01b5"+
		"\u01b3\3\2\2\2\u01b5\u01b4\3\2\2\2\u01b6E\3\2\2\2\u01b7\u01ba\5:\36\2"+
		"\u01b8\u01ba\5P)\2\u01b9\u01b7\3\2\2\2\u01b9\u01b8\3\2\2\2\u01baG\3\2"+
		"\2\2\u01bb\u01bc\7 \2\2\u01bc\u01bf\7L\2\2\u01bd\u01be\7\63\2\2\u01be"+
		"\u01c0\7L\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\3\2"+
		"\2\2\u01c1\u01c2\7;\2\2\u01c2\u01c3\5P)\2\u01c3I\3\2\2\2\u01c4\u01c5\7"+
		"\b\2\2\u01c5\u01c6\5P)\2\u01c6\u01c7\7;\2\2\u01c7\u01cb\3\2\2\2\u01c8"+
		"\u01c9\7\f\2\2\u01c9\u01cb\7;\2\2\u01ca\u01c4\3\2\2\2\u01ca\u01c8\3\2"+
		"\2\2\u01cbK\3\2\2\2\u01cc\u01cd\7,\2\2\u01cd\u01ce\5P)\2\u01ce\u01cf\7"+
		"-\2\2\u01cfM\3\2\2\2\u01d0\u01d5\5P)\2\u01d1\u01d2\7\63\2\2\u01d2\u01d4"+
		"\5P)\2\u01d3\u01d1\3\2\2\2\u01d4\u01d7\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5"+
		"\u01d6\3\2\2\2\u01d6O\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01d9\b)\1\2\u01d9"+
		"\u01da\t\5\2\2\u01da\u01e1\5P)\17\u01db\u01dc\t\6\2\2\u01dc\u01e1\5P)"+
		"\16\u01dd\u01e1\5R*\2\u01de\u01df\7\30\2\2\u01df\u01e1\5T+\2\u01e0\u01d8"+
		"\3\2\2\2\u01e0\u01db\3\2\2\2\u01e0\u01dd\3\2\2\2\u01e0\u01de\3\2\2\2\u01e1"+
		"\u0216\3\2\2\2\u01e2\u01e3\f\r\2\2\u01e3\u01e4\t\7\2\2\u01e4\u0215\5P"+
		")\16\u01e5\u01e6\f\f\2\2\u01e6\u01e7\t\5\2\2\u01e7\u0215\5P)\r\u01e8\u01e9"+
		"\f\13\2\2\u01e9\u01ea\t\b\2\2\u01ea\u0215\5P)\f\u01eb\u01ec\f\n\2\2\u01ec"+
		"\u01ed\t\t\2\2\u01ed\u0215\5P)\13\u01ee\u01ef\f\t\2\2\u01ef\u01f0\t\n"+
		"\2\2\u01f0\u0215\5P)\n\u01f1\u01f2\f\b\2\2\u01f2\u01f3\7H\2\2\u01f3\u0215"+
		"\5P)\t\u01f4\u01f5\f\7\2\2\u01f5\u01f6\7J\2\2\u01f6\u0215\5P)\b\u01f7"+
		"\u01f8\f\6\2\2\u01f8\u01f9\7I\2\2\u01f9\u0215\5P)\7\u01fa\u01fb\f\5\2"+
		"\2\u01fb\u01fc\7@\2\2\u01fc\u0215\5P)\6\u01fd\u01fe\f\4\2\2\u01fe\u01ff"+
		"\7A\2\2\u01ff\u0215\5P)\5\u0200\u0201\f\3\2\2\u0201\u0202\7:\2\2\u0202"+
		"\u0203\5P)\2\u0203\u0204\7;\2\2\u0204\u0205\5P)\4\u0205\u0215\3\2\2\2"+
		"\u0206\u0207\f\23\2\2\u0207\u0208\7\64\2\2\u0208\u0215\7L\2\2\u0209\u020a"+
		"\f\22\2\2\u020a\u020b\7\60\2\2\u020b\u020c\5P)\2\u020c\u020d\7\61\2\2"+
		"\u020d\u0215\3\2\2\2\u020e\u020f\f\21\2\2\u020f\u0211\7,\2\2\u0210\u0212"+
		"\5N(\2\u0211\u0210\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213"+
		"\u0215\7-\2\2\u0214\u01e2\3\2\2\2\u0214\u01e5\3\2\2\2\u0214\u01e8\3\2"+
		"\2\2\u0214\u01eb\3\2\2\2\u0214\u01ee\3\2\2\2\u0214\u01f1\3\2\2\2\u0214"+
		"\u01f4\3\2\2\2\u0214\u01f7\3\2\2\2\u0214\u01fa\3\2\2\2\u0214\u01fd\3\2"+
		"\2\2\u0214\u0200\3\2\2\2\u0214\u0206\3\2\2\2\u0214\u0209\3\2\2\2\u0214"+
		"\u020e\3\2\2\2\u0215\u0218\3\2\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2"+
		"\2\2\u0217Q\3\2\2\2\u0218\u0216\3\2\2\2\u0219\u021e\5L\'\2\u021a\u021e"+
		"\7\37\2\2\u021b\u021e\5^\60\2\u021c\u021e\7L\2\2\u021d\u0219\3\2\2\2\u021d"+
		"\u021a\3\2\2\2\u021d\u021b\3\2\2\2\u021d\u021c\3\2\2\2\u021eS\3\2\2\2"+
		"\u021f\u0222\5$\23\2\u0220\u0223\5V,\2\u0221\u0223\5X-\2\u0222\u0220\3"+
		"\2\2\2\u0222\u0221\3\2\2\2\u0223U\3\2\2\2\u0224\u0225\7\60\2\2\u0225\u0226"+
		"\7\61\2\2\u0226\u0228\7.\2\2\u0227\u0229\5N(\2\u0228\u0227\3\2\2\2\u0228"+
		"\u0229\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u0237\7/\2\2\u022b\u022c\7\60"+
		"\2\2\u022c\u022d\5P)\2\u022d\u022e\7\61\2\2\u022e\u0237\3\2\2\2\u022f"+
		"\u0230\7\60\2\2\u0230\u0231\7\t\2\2\u0231\u0232\5$\23\2\u0232\u0234\7"+
		"\61\2\2\u0233\u0235\5Z.\2\u0234\u0233\3\2\2\2\u0234\u0235\3\2\2\2\u0235"+
		"\u0237\3\2\2\2\u0236\u0224\3\2\2\2\u0236\u022b\3\2\2\2\u0236\u022f\3\2"+
		"\2\2\u0237W\3\2\2\2\u0238\u023a\7,\2\2\u0239\u023b\5N(\2\u023a\u0239\3"+
		"\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023e\7-\2\2\u023d"+
		"\u023f\5\20\t\2\u023e\u023d\3\2\2\2\u023e\u023f\3\2\2\2\u023fY\3\2\2\2"+
		"\u0240\u0241\7.\2\2\u0241\u024e\7/\2\2\u0242\u0243\7.\2\2\u0243\u0248"+
		"\5\\/\2\u0244\u0245\7\63\2\2\u0245\u0247\5\\/\2\u0246\u0244\3\2\2\2\u0247"+
		"\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024b\3\2"+
		"\2\2\u024a\u0248\3\2\2\2\u024b\u024c\7/\2\2\u024c\u024e\3\2\2\2\u024d"+
		"\u0240\3\2\2\2\u024d\u0242\3\2\2\2\u024e[\3\2\2\2\u024f\u0250\5P)\2\u0250"+
		"\u0251\7;\2\2\u0251\u0252\5P)\2\u0252]\3\2\2\2\u0253\u0254\t\13\2\2\u0254"+
		"_\3\2\2\2?afly\177\u0084\u008e\u0096\u009e\u00a7\u00b8\u00c3\u00ca\u00d1"+
		"\u00da\u00df\u00ea\u00ef\u00f7\u00fc\u0101\u010a\u0114\u0116\u011d\u0122"+
		"\u012a\u0133\u013c\u0147\u014e\u016c\u017a\u017d\u0183\u018c\u0191\u0199"+
		"\u01a0\u01a4\u01a8\u01ae\u01b0\u01b5\u01b9\u01bf\u01ca\u01d5\u01e0\u0211"+
		"\u0214\u0216\u021d\u0222\u0228\u0234\u0236\u023a\u023e\u0248\u024d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}