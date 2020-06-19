// Generated from Sanka.g4 by ANTLR 4.7.2

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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, BOOLEAN=3, BREAK=4, BYTE=5, CASE=6, CLASS=7, CONST=8, 
		CONTINUE=9, DEFAULT=10, DOUBLE=11, ELSE=12, EXPORT=13, EXTENDS=14, FLOAT=15, 
		FOR=16, IF=17, IMPORT=18, INLINE=19, INT=20, INTERFACE=21, LONG=22, NEW=23, 
		PACKAGE=24, PRIVATE=25, RETURN=26, SHORT=27, STATIC=28, SUPER=29, SWITCH=30, 
		THIS=31, TYPESWITCH=32, VAR=33, VOID=34, WHILE=35, C__INCLUDE=36, C__FIELD=37, 
		C__STMT=38, IntegerLiteral=39, FloatingPointLiteral=40, BooleanLiteral=41, 
		CharacterLiteral=42, StringLiteral=43, NullLiteral=44, LPAREN=45, RPAREN=46, 
		LBRACE=47, RBRACE=48, LBRACK=49, RBRACK=50, SEMI=51, COMMA=52, DOT=53, 
		ASSIGN=54, GT=55, LT=56, BANG=57, TILDE=58, QUESTION=59, COLON=60, EQUAL=61, 
		LE=62, GE=63, NOTEQUAL=64, AND=65, OR=66, INC=67, DEC=68, ADD=69, SUB=70, 
		MUL=71, DIV=72, BITAND=73, BITOR=74, CARET=75, MOD=76, Identifier=77, 
		ELLIPSIS=78, WS=79, COMMENT=80, LINE_COMMENT=81;
	public static final int
		RULE_compilationUnit = 0, RULE_packageDeclaration = 1, RULE_importDeclaration = 2, 
		RULE_typeDeclaration = 3, RULE_classDeclaration = 4, RULE_classModifier = 5, 
		RULE_typeParameters = 6, RULE_extendsClass = 7, RULE_interfaceDeclaration = 8, 
		RULE_classBody = 9, RULE_interfaceBody = 10, RULE_classBodyDeclaration = 11, 
		RULE_constDeclaration = 12, RULE_fieldDeclaration = 13, RULE_fieldModifier = 14, 
		RULE_constructorDeclaration = 15, RULE_identifierList = 16, RULE_methodDeclaration = 17, 
		RULE_blockOrSemi = 18, RULE_interfaceBodyDeclaration = 19, RULE_interfaceMethodDeclaration = 20, 
		RULE_typeType = 21, RULE_classOrInterfaceType = 22, RULE_typeArguments = 23, 
		RULE_primitiveType = 24, RULE_formalParameters = 25, RULE_formalParameterList = 26, 
		RULE_formalParameter = 27, RULE_qualifiedName = 28, RULE_block = 29, RULE_statement = 30, 
		RULE_variableDeclaration = 31, RULE_variableAssignment = 32, RULE_assignable = 33, 
		RULE_ifStatement = 34, RULE_elseStatement = 35, RULE_forControl = 36, 
		RULE_forInit = 37, RULE_forIncrement = 38, RULE_enhancedForControl = 39, 
		RULE_switchLabel = 40, RULE_parExpression = 41, RULE_expressionList = 42, 
		RULE_expression = 43, RULE_primary = 44, RULE_creator = 45, RULE_arrayCreatorRest = 46, 
		RULE_classCreatorRest = 47, RULE_mapDefinition = 48, RULE_mapEntry = 49, 
		RULE_literal = 50, RULE_anonymousClassBody = 51, RULE_anonymousClassBodyDeclaration = 52;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "packageDeclaration", "importDeclaration", "typeDeclaration", 
			"classDeclaration", "classModifier", "typeParameters", "extendsClass", 
			"interfaceDeclaration", "classBody", "interfaceBody", "classBodyDeclaration", 
			"constDeclaration", "fieldDeclaration", "fieldModifier", "constructorDeclaration", 
			"identifierList", "methodDeclaration", "blockOrSemi", "interfaceBodyDeclaration", 
			"interfaceMethodDeclaration", "typeType", "classOrInterfaceType", "typeArguments", 
			"primitiveType", "formalParameters", "formalParameterList", "formalParameter", 
			"qualifiedName", "block", "statement", "variableDeclaration", "variableAssignment", 
			"assignable", "ifStatement", "elseStatement", "forControl", "forInit", 
			"forIncrement", "enhancedForControl", "switchLabel", "parExpression", 
			"expressionList", "expression", "primary", "creator", "arrayCreatorRest", 
			"classCreatorRest", "mapDefinition", "mapEntry", "literal", "anonymousClassBody", 
			"anonymousClassBodyDeclaration"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<<'", "'>>'", "'boolean'", "'break'", "'byte'", "'case'", "'class'", 
			"'const'", "'continue'", "'default'", "'double'", "'else'", "'export'", 
			"'extends'", "'float'", "'for'", "'if'", "'import'", "'inline'", "'int'", 
			"'interface'", "'long'", "'new'", "'package'", "'private'", "'return'", 
			"'short'", "'static'", "'super'", "'switch'", "'this'", "'typeswitch'", 
			"'var'", "'void'", "'while'", "'c__include'", "'c__field'", "'c__stmt'", 
			null, null, null, null, null, "'null'", "'('", "')'", "'{'", "'}'", "'['", 
			"']'", "';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", 
			"':'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", 
			"'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", null, "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "BOOLEAN", "BREAK", "BYTE", "CASE", "CLASS", "CONST", 
			"CONTINUE", "DEFAULT", "DOUBLE", "ELSE", "EXPORT", "EXTENDS", "FLOAT", 
			"FOR", "IF", "IMPORT", "INLINE", "INT", "INTERFACE", "LONG", "NEW", "PACKAGE", 
			"PRIVATE", "RETURN", "SHORT", "STATIC", "SUPER", "SWITCH", "THIS", "TYPESWITCH", 
			"VAR", "VOID", "WHILE", "C__INCLUDE", "C__FIELD", "C__STMT", "IntegerLiteral", 
			"FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", "StringLiteral", 
			"NullLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", 
			"SEMI", "COMMA", "DOT", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", 
			"COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", 
			"ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", "Identifier", 
			"ELLIPSIS", "WS", "COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(106);
				packageDeclaration();
				}
			}

			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(109);
				importDeclaration();
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS || _la==INTERFACE || _la==Identifier) {
				{
				{
				setState(115);
				typeDeclaration();
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
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
		public TerminalNode PACKAGE() { return getToken(SankaParser.PACKAGE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SankaParser.SEMI, 0); }
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
			setState(123);
			match(PACKAGE);
			setState(124);
			qualifiedName();
			setState(125);
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
		public TerminalNode IMPORT() { return getToken(SankaParser.IMPORT, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SankaParser.SEMI, 0); }
		public TerminalNode DOT() { return getToken(SankaParser.DOT, 0); }
		public TerminalNode MUL() { return getToken(SankaParser.MUL, 0); }
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
			setState(127);
			match(IMPORT);
			setState(128);
			qualifiedName();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(129);
				match(DOT);
				setState(130);
				match(MUL);
				}
			}

			setState(133);
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
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				classDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				interfaceDeclaration();
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(SankaParser.CLASS, 0); }
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public List<ClassModifierContext> classModifier() {
			return getRuleContexts(ClassModifierContext.class);
		}
		public ClassModifierContext classModifier(int i) {
			return getRuleContext(ClassModifierContext.class,i);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ExtendsClassContext extendsClass() {
			return getRuleContext(ExtendsClassContext.class,0);
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
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(139);
				classModifier();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			match(CLASS);
			setState(146);
			match(Identifier);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(147);
				typeParameters();
				}
			}

			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(150);
				extendsClass();
				}
			}

			setState(153);
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

	public static class ClassModifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public ClassModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterClassModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitClassModifier(this);
		}
	}

	public final ClassModifierContext classModifier() throws RecognitionException {
		ClassModifierContext _localctx = new ClassModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
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

	public static class TypeParametersContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(SankaParser.LT, 0); }
		public List<TerminalNode> Identifier() { return getTokens(SankaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SankaParser.Identifier, i);
		}
		public TerminalNode GT() { return getToken(SankaParser.GT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SankaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SankaParser.COMMA, i);
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
		enterRule(_localctx, 12, RULE_typeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(LT);
			setState(158);
			match(Identifier);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(159);
				match(COMMA);
				setState(160);
				match(Identifier);
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(166);
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

	public static class ExtendsClassContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(SankaParser.EXTENDS, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public ExtendsClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extendsClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterExtendsClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitExtendsClass(this);
		}
	}

	public final ExtendsClassContext extendsClass() throws RecognitionException {
		ExtendsClassContext _localctx = new ExtendsClassContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_extendsClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(EXTENDS);
			setState(169);
			typeType(0);
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
		public TerminalNode INTERFACE() { return getToken(SankaParser.INTERFACE, 0); }
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public InterfaceBodyContext interfaceBody() {
			return getRuleContext(InterfaceBodyContext.class,0);
		}
		public List<ClassModifierContext> classModifier() {
			return getRuleContexts(ClassModifierContext.class);
		}
		public ClassModifierContext classModifier(int i) {
			return getRuleContext(ClassModifierContext.class,i);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ExtendsClassContext extendsClass() {
			return getRuleContext(ExtendsClassContext.class,0);
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
		enterRule(_localctx, 16, RULE_interfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(171);
				classModifier();
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(177);
			match(INTERFACE);
			setState(178);
			match(Identifier);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(179);
				typeParameters();
				}
			}

			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(182);
				extendsClass();
				}
			}

			setState(185);
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
		public TerminalNode LBRACE() { return getToken(SankaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SankaParser.RBRACE, 0); }
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
		enterRule(_localctx, 18, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(LBRACE);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CONST) | (1L << DOUBLE) | (1L << EXPORT) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << PRIVATE) | (1L << SHORT) | (1L << STATIC) | (1L << VOID) | (1L << C__INCLUDE) | (1L << C__FIELD))) != 0) || _la==Identifier) {
				{
				{
				setState(188);
				classBodyDeclaration();
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(194);
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
		public TerminalNode LBRACE() { return getToken(SankaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SankaParser.RBRACE, 0); }
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
		enterRule(_localctx, 20, RULE_interfaceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(LBRACE);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CONST) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << PRIVATE) | (1L << SHORT) | (1L << STATIC) | (1L << VOID))) != 0) || _la==Identifier) {
				{
				{
				setState(197);
				interfaceBodyDeclaration();
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(203);
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
		public TerminalNode EXPORT() { return getToken(SankaParser.EXPORT, 0); }
		public List<TerminalNode> Identifier() { return getTokens(SankaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SankaParser.Identifier, i);
		}
		public TerminalNode SEMI() { return getToken(SankaParser.SEMI, 0); }
		public TerminalNode DOT() { return getToken(SankaParser.DOT, 0); }
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public TerminalNode C__INCLUDE() { return getToken(SankaParser.C__INCLUDE, 0); }
		public TerminalNode StringLiteral() { return getToken(SankaParser.StringLiteral, 0); }
		public TerminalNode C__FIELD() { return getToken(SankaParser.C__FIELD, 0); }
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
		enterRule(_localctx, 22, RULE_classBodyDeclaration);
		int _la;
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				constDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				fieldDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				match(EXPORT);
				setState(208);
				match(Identifier);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(209);
					match(DOT);
					setState(210);
					match(Identifier);
					}
				}

				setState(213);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(214);
				constructorDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(215);
				methodDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(216);
				match(C__INCLUDE);
				setState(217);
				match(StringLiteral);
				setState(218);
				match(SEMI);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(219);
				match(C__FIELD);
				setState(220);
				match(StringLiteral);
				setState(221);
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
		public TerminalNode CONST() { return getToken(SankaParser.CONST, 0); }
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public TerminalNode ASSIGN() { return getToken(SankaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SankaParser.SEMI, 0); }
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
		enterRule(_localctx, 24, RULE_constDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(CONST);
			setState(225);
			match(Identifier);
			setState(226);
			match(ASSIGN);
			setState(227);
			expression(0);
			setState(228);
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
		public TerminalNode SEMI() { return getToken(SankaParser.SEMI, 0); }
		public List<FieldModifierContext> fieldModifier() {
			return getRuleContexts(FieldModifierContext.class);
		}
		public FieldModifierContext fieldModifier(int i) {
			return getRuleContext(FieldModifierContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(SankaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SankaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SankaParser.COMMA, i);
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
		enterRule(_localctx, 26, RULE_fieldDeclaration);
		int _la;
		try {
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) {
					{
					{
					setState(230);
					fieldModifier();
					}
					}
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(236);
				typeType(0);
				setState(237);
				match(Identifier);
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(238);
					match(ASSIGN);
					setState(239);
					expression(0);
					}
				}

				setState(242);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) {
					{
					{
					setState(244);
					fieldModifier();
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(250);
				typeType(0);
				setState(251);
				match(Identifier);
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(252);
					match(COMMA);
					setState(253);
					match(Identifier);
					}
					}
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(259);
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
		public TerminalNode PRIVATE() { return getToken(SankaParser.PRIVATE, 0); }
		public TerminalNode STATIC() { return getToken(SankaParser.STATIC, 0); }
		public TerminalNode INLINE() { return getToken(SankaParser.INLINE, 0); }
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
		enterRule(_localctx, 28, RULE_fieldModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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
		public TerminalNode LPAREN() { return getToken(SankaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SankaParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(SankaParser.SEMI, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
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
		int _la;
		try {
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				match(Identifier);
				setState(266);
				formalParameters();
				setState(267);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				match(Identifier);
				setState(270);
				match(LPAREN);
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(271);
					identifierList();
					}
				}

				setState(274);
				match(RPAREN);
				setState(275);
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

	public static class IdentifierListContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(SankaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SankaParser.Identifier, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SankaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SankaParser.COMMA, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitIdentifierList(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(Identifier);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(279);
				match(COMMA);
				setState(280);
				match(Identifier);
				}
				}
				setState(285);
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

	public static class MethodDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(SankaParser.VOID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SankaParser.SEMI, 0); }
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
		enterRule(_localctx, 34, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) {
				{
				{
				setState(286);
				fieldModifier();
				}
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(294);
			_errHandler.sync(this);
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
				setState(292);
				typeType(0);
				}
				break;
			case VOID:
				{
				setState(293);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(296);
			match(Identifier);
			setState(297);
			formalParameters();
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(298);
				block();
				}
				break;
			case SEMI:
				{
				setState(299);
				match(SEMI);
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

	public static class BlockOrSemiContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SankaParser.SEMI, 0); }
		public BlockOrSemiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockOrSemi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterBlockOrSemi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitBlockOrSemi(this);
		}
	}

	public final BlockOrSemiContext blockOrSemi() throws RecognitionException {
		BlockOrSemiContext _localctx = new BlockOrSemiContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_blockOrSemi);
		try {
			setState(304);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				block();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				match(SEMI);
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
		enterRule(_localctx, 38, RULE_interfaceBodyDeclaration);
		try {
			setState(308);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
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
				setState(307);
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
		public TerminalNode SEMI() { return getToken(SankaParser.SEMI, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(SankaParser.VOID, 0); }
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
		enterRule(_localctx, 40, RULE_interfaceMethodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) {
				{
				{
				setState(310);
				fieldModifier();
				}
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(318);
			_errHandler.sync(this);
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
				setState(316);
				typeType(0);
				}
				break;
			case VOID:
				{
				setState(317);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(320);
			match(Identifier);
			setState(321);
			formalParameters();
			setState(322);
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
		public TerminalNode LBRACK() { return getToken(SankaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(SankaParser.RBRACK, 0); }
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_typeType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(325);
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
				setState(326);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(339);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(337);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new TypeTypeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_typeType);
						setState(329);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(330);
						match(LBRACK);
						setState(331);
						match(RBRACK);
						}
						break;
					case 2:
						{
						_localctx = new TypeTypeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_typeType);
						setState(332);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(333);
						match(LBRACK);
						setState(334);
						typeType(0);
						setState(335);
						match(RBRACK);
						}
						break;
					}
					} 
				}
				setState(341);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		public List<TerminalNode> DOT() { return getTokens(SankaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SankaParser.DOT, i);
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
		enterRule(_localctx, 44, RULE_classOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(342);
					match(Identifier);
					setState(343);
					match(DOT);
					}
					} 
				}
				setState(348);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(349);
			match(Identifier);
			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(350);
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
		public TerminalNode LT() { return getToken(SankaParser.LT, 0); }
		public List<TypeTypeContext> typeType() {
			return getRuleContexts(TypeTypeContext.class);
		}
		public TypeTypeContext typeType(int i) {
			return getRuleContext(TypeTypeContext.class,i);
		}
		public TerminalNode GT() { return getToken(SankaParser.GT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SankaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SankaParser.COMMA, i);
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
		enterRule(_localctx, 46, RULE_typeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(LT);
			setState(354);
			typeType(0);
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(355);
				match(COMMA);
				setState(356);
				typeType(0);
				}
				}
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(362);
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
		public TerminalNode BOOLEAN() { return getToken(SankaParser.BOOLEAN, 0); }
		public TerminalNode BYTE() { return getToken(SankaParser.BYTE, 0); }
		public TerminalNode SHORT() { return getToken(SankaParser.SHORT, 0); }
		public TerminalNode INT() { return getToken(SankaParser.INT, 0); }
		public TerminalNode LONG() { return getToken(SankaParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(SankaParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(SankaParser.DOUBLE, 0); }
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
		enterRule(_localctx, 48, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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
		public TerminalNode LPAREN() { return getToken(SankaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SankaParser.RPAREN, 0); }
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
		enterRule(_localctx, 50, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(LPAREN);
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || _la==Identifier) {
				{
				setState(367);
				formalParameterList();
				}
			}

			setState(370);
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
		public List<TerminalNode> COMMA() { return getTokens(SankaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SankaParser.COMMA, i);
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
		enterRule(_localctx, 52, RULE_formalParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			formalParameter();
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(373);
				match(COMMA);
				setState(374);
				formalParameter();
				}
				}
				setState(379);
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
		enterRule(_localctx, 54, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			typeType(0);
			setState(381);
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
		public List<TerminalNode> DOT() { return getTokens(SankaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SankaParser.DOT, i);
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
		enterRule(_localctx, 56, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(Identifier);
			setState(388);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(384);
					match(DOT);
					setState(385);
					match(Identifier);
					}
					} 
				}
				setState(390);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
		public TerminalNode LBRACE() { return getToken(SankaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SankaParser.RBRACE, 0); }
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
		enterRule(_localctx, 58, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(LBRACE);
			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << FOR) | (1L << IF) | (1L << INLINE) | (1L << NEW) | (1L << RETURN) | (1L << SUPER) | (1L << SWITCH) | (1L << THIS) | (1L << TYPESWITCH) | (1L << VAR) | (1L << WHILE) | (1L << C__STMT) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << BANG) | (1L << TILDE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)))) != 0)) {
				{
				{
				setState(392);
				statement();
				}
				}
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(398);
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
		public TerminalNode SEMI() { return getToken(SankaParser.SEMI, 0); }
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public TerminalNode FOR() { return getToken(SankaParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(SankaParser.LPAREN, 0); }
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SankaParser.RPAREN, 0); }
		public TerminalNode WHILE() { return getToken(SankaParser.WHILE, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public TerminalNode SWITCH() { return getToken(SankaParser.SWITCH, 0); }
		public TerminalNode TYPESWITCH() { return getToken(SankaParser.TYPESWITCH, 0); }
		public SwitchLabelContext switchLabel() {
			return getRuleContext(SwitchLabelContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(SankaParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(SankaParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(SankaParser.CONTINUE, 0); }
		public TerminalNode C__STMT() { return getToken(SankaParser.C__STMT, 0); }
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
		enterRule(_localctx, 60, RULE_statement);
		int _la;
		try {
			setState(443);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(401);
				variableDeclaration();
				setState(402);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(404);
				variableAssignment();
				setState(405);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(407);
				ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(408);
				match(FOR);
				setState(409);
				match(LPAREN);
				setState(410);
				forControl();
				setState(411);
				match(RPAREN);
				setState(412);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(414);
				match(WHILE);
				setState(415);
				parExpression();
				setState(416);
				block();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(418);
				match(SWITCH);
				setState(419);
				parExpression();
				setState(420);
				block();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(422);
				match(TYPESWITCH);
				setState(423);
				parExpression();
				setState(424);
				block();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(426);
				switchLabel();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(427);
				match(RETURN);
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (SUPER - 23)) | (1L << (THIS - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
					{
					setState(428);
					expression(0);
					}
				}

				setState(431);
				match(SEMI);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(432);
				match(BREAK);
				setState(433);
				match(SEMI);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(434);
				match(CONTINUE);
				setState(435);
				match(SEMI);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(436);
				expression(0);
				setState(437);
				match(SEMI);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(439);
				match(C__STMT);
				setState(440);
				match(StringLiteral);
				setState(441);
				match(SEMI);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(442);
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
		public TerminalNode VAR() { return getToken(SankaParser.VAR, 0); }
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public TerminalNode INLINE() { return getToken(SankaParser.INLINE, 0); }
		public TerminalNode ASSIGN() { return getToken(SankaParser.ASSIGN, 0); }
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
		enterRule(_localctx, 62, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INLINE) {
				{
				setState(445);
				match(INLINE);
				}
			}

			setState(448);
			match(VAR);
			setState(449);
			match(Identifier);
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(450);
				match(ASSIGN);
				setState(451);
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
		public TerminalNode ASSIGN() { return getToken(SankaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INC() { return getToken(SankaParser.INC, 0); }
		public TerminalNode DEC() { return getToken(SankaParser.DEC, 0); }
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
		enterRule(_localctx, 64, RULE_variableAssignment);
		int _la;
		try {
			setState(461);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(454);
				assignable();
				setState(455);
				match(ASSIGN);
				setState(456);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(458);
				assignable();
				setState(459);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
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
		public TerminalNode DOT() { return getToken(SankaParser.DOT, 0); }
		public TerminalNode LBRACK() { return getToken(SankaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(SankaParser.RBRACK, 0); }
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
		enterRule(_localctx, 66, RULE_assignable);
		try {
			setState(474);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(466);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(463);
					expression(0);
					setState(464);
					match(DOT);
					}
					break;
				}
				setState(468);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(469);
				expression(0);
				setState(470);
				match(LBRACK);
				setState(471);
				expression(0);
				setState(472);
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
		public TerminalNode IF() { return getToken(SankaParser.IF, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(SankaParser.ELSE, 0); }
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
		enterRule(_localctx, 68, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			match(IF);
			setState(477);
			parExpression();
			setState(478);
			block();
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(479);
				match(ELSE);
				setState(480);
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
		enterRule(_localctx, 70, RULE_elseStatement);
		try {
			setState(485);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(483);
				block();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(484);
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
		public List<TerminalNode> SEMI() { return getTokens(SankaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(SankaParser.SEMI, i);
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
		enterRule(_localctx, 72, RULE_forControl);
		int _la;
		try {
			setState(497);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(487);
				enhancedForControl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (INLINE - 19)) | (1L << (NEW - 19)) | (1L << (SUPER - 19)) | (1L << (THIS - 19)) | (1L << (VAR - 19)) | (1L << (IntegerLiteral - 19)) | (1L << (FloatingPointLiteral - 19)) | (1L << (BooleanLiteral - 19)) | (1L << (CharacterLiteral - 19)) | (1L << (StringLiteral - 19)) | (1L << (NullLiteral - 19)) | (1L << (LPAREN - 19)) | (1L << (BANG - 19)) | (1L << (TILDE - 19)) | (1L << (ADD - 19)) | (1L << (SUB - 19)) | (1L << (Identifier - 19)))) != 0)) {
					{
					setState(488);
					forInit();
					}
				}

				setState(491);
				match(SEMI);
				setState(492);
				expression(0);
				setState(493);
				match(SEMI);
				setState(495);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (SUPER - 23)) | (1L << (THIS - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
					{
					setState(494);
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
		enterRule(_localctx, 74, RULE_forInit);
		try {
			setState(502);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(500);
				variableAssignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(501);
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
		enterRule(_localctx, 76, RULE_forIncrement);
		try {
			setState(506);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(504);
				variableAssignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(505);
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
		public TerminalNode VAR() { return getToken(SankaParser.VAR, 0); }
		public List<TerminalNode> Identifier() { return getTokens(SankaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SankaParser.Identifier, i);
		}
		public TerminalNode COLON() { return getToken(SankaParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(SankaParser.COMMA, 0); }
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
		enterRule(_localctx, 78, RULE_enhancedForControl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			match(VAR);
			setState(509);
			match(Identifier);
			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(510);
				match(COMMA);
				setState(511);
				match(Identifier);
				}
			}

			setState(514);
			match(COLON);
			setState(515);
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
		public TerminalNode CASE() { return getToken(SankaParser.CASE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(SankaParser.COLON, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public TerminalNode DEFAULT() { return getToken(SankaParser.DEFAULT, 0); }
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
		enterRule(_localctx, 80, RULE_switchLabel);
		try {
			setState(528);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(517);
				match(CASE);
				setState(518);
				expression(0);
				setState(519);
				match(COLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(521);
				match(CASE);
				setState(522);
				typeType(0);
				setState(523);
				match(Identifier);
				setState(524);
				match(COLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(526);
				match(DEFAULT);
				setState(527);
				match(COLON);
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

	public static class ParExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(SankaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SankaParser.RPAREN, 0); }
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
		enterRule(_localctx, 82, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			match(LPAREN);
			setState(531);
			expression(0);
			setState(532);
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
		public List<TerminalNode> COMMA() { return getTokens(SankaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SankaParser.COMMA, i);
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
		enterRule(_localctx, 84, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			expression(0);
			setState(539);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(535);
				match(COMMA);
				setState(536);
				expression(0);
				}
				}
				setState(541);
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
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode NEW() { return getToken(SankaParser.NEW, 0); }
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(SankaParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(SankaParser.SUB, 0); }
		public TerminalNode TILDE() { return getToken(SankaParser.TILDE, 0); }
		public TerminalNode BANG() { return getToken(SankaParser.BANG, 0); }
		public TerminalNode SUPER() { return getToken(SankaParser.SUPER, 0); }
		public TerminalNode DOT() { return getToken(SankaParser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public TerminalNode MUL() { return getToken(SankaParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(SankaParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(SankaParser.MOD, 0); }
		public TerminalNode LE() { return getToken(SankaParser.LE, 0); }
		public TerminalNode GE() { return getToken(SankaParser.GE, 0); }
		public TerminalNode GT() { return getToken(SankaParser.GT, 0); }
		public TerminalNode LT() { return getToken(SankaParser.LT, 0); }
		public TerminalNode EQUAL() { return getToken(SankaParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(SankaParser.NOTEQUAL, 0); }
		public TerminalNode BITAND() { return getToken(SankaParser.BITAND, 0); }
		public TerminalNode CARET() { return getToken(SankaParser.CARET, 0); }
		public TerminalNode BITOR() { return getToken(SankaParser.BITOR, 0); }
		public TerminalNode AND() { return getToken(SankaParser.AND, 0); }
		public TerminalNode OR() { return getToken(SankaParser.OR, 0); }
		public TerminalNode QUESTION() { return getToken(SankaParser.QUESTION, 0); }
		public TerminalNode COLON() { return getToken(SankaParser.COLON, 0); }
		public TerminalNode LBRACK() { return getToken(SankaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(SankaParser.RBRACK, 0); }
		public TerminalNode LPAREN() { return getToken(SankaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SankaParser.RPAREN, 0); }
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
		int _startState = 86;
		enterRecursionRule(_localctx, 86, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
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
				setState(543);
				primary();
				}
				break;
			case NEW:
				{
				setState(544);
				match(NEW);
				setState(545);
				creator();
				}
				break;
			case ADD:
			case SUB:
				{
				setState(546);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(547);
				expression(14);
				}
				break;
			case BANG:
			case TILDE:
				{
				setState(548);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(549);
				expression(13);
				}
				break;
			case SUPER:
				{
				setState(550);
				match(SUPER);
				setState(551);
				match(DOT);
				setState(552);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(607);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(605);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(555);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(556);
						_la = _input.LA(1);
						if ( !(((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (MUL - 71)) | (1L << (DIV - 71)) | (1L << (MOD - 71)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(557);
						expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(558);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(559);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(560);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(561);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(562);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__1) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(563);
						expression(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(564);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(565);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << LE) | (1L << GE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(566);
						expression(10);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(567);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(568);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(569);
						expression(9);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(570);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(571);
						match(BITAND);
						setState(572);
						expression(8);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(573);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(574);
						match(CARET);
						setState(575);
						expression(7);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(576);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(577);
						match(BITOR);
						setState(578);
						expression(6);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(579);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(580);
						match(AND);
						setState(581);
						expression(5);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(582);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(583);
						match(OR);
						setState(584);
						expression(4);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(585);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(586);
						match(QUESTION);
						setState(587);
						expression(0);
						setState(588);
						match(COLON);
						setState(589);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(591);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(592);
						match(DOT);
						setState(593);
						match(Identifier);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(594);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(595);
						match(LBRACK);
						setState(596);
						expression(0);
						setState(597);
						match(RBRACK);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(599);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(600);
						match(LPAREN);
						setState(602);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (SUPER - 23)) | (1L << (THIS - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
							{
							setState(601);
							expressionList();
							}
						}

						setState(604);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(609);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
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
		public TerminalNode THIS() { return getToken(SankaParser.THIS, 0); }
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
		enterRule(_localctx, 88, RULE_primary);
		try {
			setState(614);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(610);
				parExpression();
				}
				break;
			case THIS:
				enterOuterAlt(_localctx, 2);
				{
				setState(611);
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
				setState(612);
				literal();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(613);
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
		public AnonymousClassBodyContext anonymousClassBody() {
			return getRuleContext(AnonymousClassBodyContext.class,0);
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
		enterRule(_localctx, 90, RULE_creator);
		try {
			setState(622);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(616);
				typeType(0);
				setState(619);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACK:
					{
					setState(617);
					arrayCreatorRest();
					}
					break;
				case LPAREN:
					{
					setState(618);
					classCreatorRest();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(621);
				anonymousClassBody();
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
		public TerminalNode LBRACK() { return getToken(SankaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(SankaParser.RBRACK, 0); }
		public TerminalNode LBRACE() { return getToken(SankaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SankaParser.RBRACE, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLASS() { return getToken(SankaParser.CLASS, 0); }
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
		enterRule(_localctx, 92, RULE_arrayCreatorRest);
		int _la;
		try {
			setState(642);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(624);
				match(LBRACK);
				setState(625);
				match(RBRACK);
				setState(626);
				match(LBRACE);
				setState(628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (SUPER - 23)) | (1L << (THIS - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
					{
					setState(627);
					expressionList();
					}
				}

				setState(630);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(631);
				match(LBRACK);
				setState(632);
				expression(0);
				setState(633);
				match(RBRACK);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(635);
				match(LBRACK);
				setState(636);
				match(CLASS);
				setState(637);
				typeType(0);
				setState(638);
				match(RBRACK);
				setState(640);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(639);
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
		public TerminalNode LPAREN() { return getToken(SankaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SankaParser.RPAREN, 0); }
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
		enterRule(_localctx, 94, RULE_classCreatorRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(644);
			match(LPAREN);
			setState(646);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (SUPER - 23)) | (1L << (THIS - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
				{
				setState(645);
				expressionList();
				}
			}

			setState(648);
			match(RPAREN);
			setState(650);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(649);
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
		public TerminalNode LBRACE() { return getToken(SankaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SankaParser.RBRACE, 0); }
		public List<MapEntryContext> mapEntry() {
			return getRuleContexts(MapEntryContext.class);
		}
		public MapEntryContext mapEntry(int i) {
			return getRuleContext(MapEntryContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SankaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SankaParser.COMMA, i);
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
		enterRule(_localctx, 96, RULE_mapDefinition);
		int _la;
		try {
			setState(665);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(652);
				match(LBRACE);
				setState(653);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(654);
				match(LBRACE);
				setState(655);
				mapEntry();
				setState(660);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(656);
					match(COMMA);
					setState(657);
					mapEntry();
					}
					}
					setState(662);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(663);
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
		public TerminalNode COLON() { return getToken(SankaParser.COLON, 0); }
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
		enterRule(_localctx, 98, RULE_mapEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(667);
			expression(0);
			setState(668);
			match(COLON);
			setState(669);
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
		public TerminalNode NullLiteral() { return getToken(SankaParser.NullLiteral, 0); }
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
		enterRule(_localctx, 100, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class AnonymousClassBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(SankaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SankaParser.RBRACE, 0); }
		public List<AnonymousClassBodyDeclarationContext> anonymousClassBodyDeclaration() {
			return getRuleContexts(AnonymousClassBodyDeclarationContext.class);
		}
		public AnonymousClassBodyDeclarationContext anonymousClassBodyDeclaration(int i) {
			return getRuleContext(AnonymousClassBodyDeclarationContext.class,i);
		}
		public AnonymousClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousClassBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterAnonymousClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitAnonymousClassBody(this);
		}
	}

	public final AnonymousClassBodyContext anonymousClassBody() throws RecognitionException {
		AnonymousClassBodyContext _localctx = new AnonymousClassBodyContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_anonymousClassBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(673);
			match(LBRACE);
			setState(677);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CONST) | (1L << DOUBLE) | (1L << EXPORT) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << PRIVATE) | (1L << SHORT) | (1L << STATIC) | (1L << VOID) | (1L << C__INCLUDE) | (1L << C__FIELD))) != 0) || _la==Identifier) {
				{
				{
				setState(674);
				anonymousClassBodyDeclaration();
				}
				}
				setState(679);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(680);
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

	public static class AnonymousClassBodyDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SankaParser.Identifier, 0); }
		public TerminalNode COLON() { return getToken(SankaParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SankaParser.SEMI, 0); }
		public ClassBodyDeclarationContext classBodyDeclaration() {
			return getRuleContext(ClassBodyDeclarationContext.class,0);
		}
		public AnonymousClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousClassBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).enterAnonymousClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SankaListener ) ((SankaListener)listener).exitAnonymousClassBodyDeclaration(this);
		}
	}

	public final AnonymousClassBodyDeclarationContext anonymousClassBodyDeclaration() throws RecognitionException {
		AnonymousClassBodyDeclarationContext _localctx = new AnonymousClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_anonymousClassBodyDeclaration);
		try {
			setState(688);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(682);
				match(Identifier);
				setState(683);
				match(COLON);
				setState(684);
				expression(0);
				setState(685);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(687);
				classBodyDeclaration();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return typeType_sempred((TypeTypeContext)_localctx, predIndex);
		case 43:
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
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
		case 13:
			return precpred(_ctx, 18);
		case 14:
			return precpred(_ctx, 17);
		case 15:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3S\u02b5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\3\2\5\2n\n\2\3\2\7\2q\n\2\f\2\16\2t\13\2\3\2\7"+
		"\2w\n\2\f\2\16\2z\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4\u0086"+
		"\n\4\3\4\3\4\3\5\3\5\5\5\u008c\n\5\3\6\7\6\u008f\n\6\f\6\16\6\u0092\13"+
		"\6\3\6\3\6\3\6\5\6\u0097\n\6\3\6\5\6\u009a\n\6\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\7\b\u00a4\n\b\f\b\16\b\u00a7\13\b\3\b\3\b\3\t\3\t\3\t\3\n\7\n"+
		"\u00af\n\n\f\n\16\n\u00b2\13\n\3\n\3\n\3\n\5\n\u00b7\n\n\3\n\5\n\u00ba"+
		"\n\n\3\n\3\n\3\13\3\13\7\13\u00c0\n\13\f\13\16\13\u00c3\13\13\3\13\3\13"+
		"\3\f\3\f\7\f\u00c9\n\f\f\f\16\f\u00cc\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\5\r\u00d6\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00e1\n\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\7\17\u00ea\n\17\f\17\16\17\u00ed\13"+
		"\17\3\17\3\17\3\17\3\17\5\17\u00f3\n\17\3\17\3\17\3\17\7\17\u00f8\n\17"+
		"\f\17\16\17\u00fb\13\17\3\17\3\17\3\17\3\17\7\17\u0101\n\17\f\17\16\17"+
		"\u0104\13\17\3\17\3\17\5\17\u0108\n\17\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u0113\n\21\3\21\3\21\5\21\u0117\n\21\3\22\3\22\3\22"+
		"\7\22\u011c\n\22\f\22\16\22\u011f\13\22\3\23\7\23\u0122\n\23\f\23\16\23"+
		"\u0125\13\23\3\23\3\23\5\23\u0129\n\23\3\23\3\23\3\23\3\23\5\23\u012f"+
		"\n\23\3\24\3\24\5\24\u0133\n\24\3\25\3\25\5\25\u0137\n\25\3\26\7\26\u013a"+
		"\n\26\f\26\16\26\u013d\13\26\3\26\3\26\5\26\u0141\n\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\5\27\u014a\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\7\27\u0154\n\27\f\27\16\27\u0157\13\27\3\30\3\30\7\30\u015b\n\30"+
		"\f\30\16\30\u015e\13\30\3\30\3\30\5\30\u0162\n\30\3\31\3\31\3\31\3\31"+
		"\7\31\u0168\n\31\f\31\16\31\u016b\13\31\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\5\33\u0173\n\33\3\33\3\33\3\34\3\34\3\34\7\34\u017a\n\34\f\34\16\34\u017d"+
		"\13\34\3\35\3\35\3\35\3\36\3\36\3\36\7\36\u0185\n\36\f\36\16\36\u0188"+
		"\13\36\3\37\3\37\7\37\u018c\n\37\f\37\16\37\u018f\13\37\3\37\3\37\3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \5 \u01b0\n \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u01be"+
		"\n \3!\5!\u01c1\n!\3!\3!\3!\3!\5!\u01c7\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\5\"\u01d0\n\"\3#\3#\3#\5#\u01d5\n#\3#\3#\3#\3#\3#\3#\5#\u01dd\n#\3$\3"+
		"$\3$\3$\3$\5$\u01e4\n$\3%\3%\5%\u01e8\n%\3&\3&\5&\u01ec\n&\3&\3&\3&\3"+
		"&\5&\u01f2\n&\5&\u01f4\n&\3\'\3\'\3\'\5\'\u01f9\n\'\3(\3(\5(\u01fd\n("+
		"\3)\3)\3)\3)\5)\u0203\n)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*"+
		"\u0213\n*\3+\3+\3+\3+\3,\3,\3,\7,\u021c\n,\f,\16,\u021f\13,\3-\3-\3-\3"+
		"-\3-\3-\3-\3-\3-\3-\3-\5-\u022c\n-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3"+
		"-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3"+
		"-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u025d\n-\3-\7-\u0260\n-\f-\16"+
		"-\u0263\13-\3.\3.\3.\3.\5.\u0269\n.\3/\3/\3/\5/\u026e\n/\3/\5/\u0271\n"+
		"/\3\60\3\60\3\60\3\60\5\60\u0277\n\60\3\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\5\60\u0283\n\60\5\60\u0285\n\60\3\61\3\61\5\61\u0289"+
		"\n\61\3\61\3\61\5\61\u028d\n\61\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u0295"+
		"\n\62\f\62\16\62\u0298\13\62\3\62\3\62\5\62\u029c\n\62\3\63\3\63\3\63"+
		"\3\63\3\64\3\64\3\65\3\65\7\65\u02a6\n\65\f\65\16\65\u02a9\13\65\3\65"+
		"\3\65\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u02b3\n\66\3\66\2\4,X\67\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP"+
		"RTVXZ\\^`bdfhj\2\f\5\2\25\25\33\33\36\36\t\2\5\5\7\7\r\r\21\21\26\26\30"+
		"\30\35\35\3\2EF\3\2GH\3\2;<\4\2IJNN\3\2\3\4\4\29:@A\4\2??BB\3\2).\2\u02ef"+
		"\2m\3\2\2\2\4}\3\2\2\2\6\u0081\3\2\2\2\b\u008b\3\2\2\2\n\u0090\3\2\2\2"+
		"\f\u009d\3\2\2\2\16\u009f\3\2\2\2\20\u00aa\3\2\2\2\22\u00b0\3\2\2\2\24"+
		"\u00bd\3\2\2\2\26\u00c6\3\2\2\2\30\u00e0\3\2\2\2\32\u00e2\3\2\2\2\34\u0107"+
		"\3\2\2\2\36\u0109\3\2\2\2 \u0116\3\2\2\2\"\u0118\3\2\2\2$\u0123\3\2\2"+
		"\2&\u0132\3\2\2\2(\u0136\3\2\2\2*\u013b\3\2\2\2,\u0149\3\2\2\2.\u015c"+
		"\3\2\2\2\60\u0163\3\2\2\2\62\u016e\3\2\2\2\64\u0170\3\2\2\2\66\u0176\3"+
		"\2\2\28\u017e\3\2\2\2:\u0181\3\2\2\2<\u0189\3\2\2\2>\u01bd\3\2\2\2@\u01c0"+
		"\3\2\2\2B\u01cf\3\2\2\2D\u01dc\3\2\2\2F\u01de\3\2\2\2H\u01e7\3\2\2\2J"+
		"\u01f3\3\2\2\2L\u01f8\3\2\2\2N\u01fc\3\2\2\2P\u01fe\3\2\2\2R\u0212\3\2"+
		"\2\2T\u0214\3\2\2\2V\u0218\3\2\2\2X\u022b\3\2\2\2Z\u0268\3\2\2\2\\\u0270"+
		"\3\2\2\2^\u0284\3\2\2\2`\u0286\3\2\2\2b\u029b\3\2\2\2d\u029d\3\2\2\2f"+
		"\u02a1\3\2\2\2h\u02a3\3\2\2\2j\u02b2\3\2\2\2ln\5\4\3\2ml\3\2\2\2mn\3\2"+
		"\2\2nr\3\2\2\2oq\5\6\4\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2sx\3\2"+
		"\2\2tr\3\2\2\2uw\5\b\5\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2"+
		"\2\2zx\3\2\2\2{|\7\2\2\3|\3\3\2\2\2}~\7\32\2\2~\177\5:\36\2\177\u0080"+
		"\7\65\2\2\u0080\5\3\2\2\2\u0081\u0082\7\24\2\2\u0082\u0085\5:\36\2\u0083"+
		"\u0084\7\67\2\2\u0084\u0086\7I\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\65\2\2\u0088\7\3\2\2\2\u0089\u008c"+
		"\5\n\6\2\u008a\u008c\5\22\n\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2"+
		"\u008c\t\3\2\2\2\u008d\u008f\5\f\7\2\u008e\u008d\3\2\2\2\u008f\u0092\3"+
		"\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\u0094\7\t\2\2\u0094\u0096\7O\2\2\u0095\u0097\5\16"+
		"\b\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u009a\5\20\t\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3"+
		"\2\2\2\u009b\u009c\5\24\13\2\u009c\13\3\2\2\2\u009d\u009e\7O\2\2\u009e"+
		"\r\3\2\2\2\u009f\u00a0\7:\2\2\u00a0\u00a5\7O\2\2\u00a1\u00a2\7\66\2\2"+
		"\u00a2\u00a4\7O\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8"+
		"\u00a9\79\2\2\u00a9\17\3\2\2\2\u00aa\u00ab\7\20\2\2\u00ab\u00ac\5,\27"+
		"\2\u00ac\21\3\2\2\2\u00ad\u00af\5\f\7\2\u00ae\u00ad\3\2\2\2\u00af\u00b2"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\u00b4\7\27\2\2\u00b4\u00b6\7O\2\2\u00b5\u00b7\5\16"+
		"\b\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8"+
		"\u00ba\5\20\t\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3"+
		"\2\2\2\u00bb\u00bc\5\26\f\2\u00bc\23\3\2\2\2\u00bd\u00c1\7\61\2\2\u00be"+
		"\u00c0\5\30\r\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3"+
		"\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4"+
		"\u00c5\7\62\2\2\u00c5\25\3\2\2\2\u00c6\u00ca\7\61\2\2\u00c7\u00c9\5(\25"+
		"\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb"+
		"\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\7\62\2\2"+
		"\u00ce\27\3\2\2\2\u00cf\u00e1\5\32\16\2\u00d0\u00e1\5\34\17\2\u00d1\u00d2"+
		"\7\17\2\2\u00d2\u00d5\7O\2\2\u00d3\u00d4\7\67\2\2\u00d4\u00d6\7O\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00e1\7\65"+
		"\2\2\u00d8\u00e1\5 \21\2\u00d9\u00e1\5$\23\2\u00da\u00db\7&\2\2\u00db"+
		"\u00dc\7-\2\2\u00dc\u00e1\7\65\2\2\u00dd\u00de\7\'\2\2\u00de\u00df\7-"+
		"\2\2\u00df\u00e1\7\65\2\2\u00e0\u00cf\3\2\2\2\u00e0\u00d0\3\2\2\2\u00e0"+
		"\u00d1\3\2\2\2\u00e0\u00d8\3\2\2\2\u00e0\u00d9\3\2\2\2\u00e0\u00da\3\2"+
		"\2\2\u00e0\u00dd\3\2\2\2\u00e1\31\3\2\2\2\u00e2\u00e3\7\n\2\2\u00e3\u00e4"+
		"\7O\2\2\u00e4\u00e5\78\2\2\u00e5\u00e6\5X-\2\u00e6\u00e7\7\65\2\2\u00e7"+
		"\33\3\2\2\2\u00e8\u00ea\5\36\20\2\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2"+
		"\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ee\u00ef\5,\27\2\u00ef\u00f2\7O\2\2\u00f0\u00f1\78\2"+
		"\2\u00f1\u00f3\5X-\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4\u00f5\7\65\2\2\u00f5\u0108\3\2\2\2\u00f6\u00f8\5\36\20"+
		"\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa"+
		"\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\5,\27\2\u00fd"+
		"\u0102\7O\2\2\u00fe\u00ff\7\66\2\2\u00ff\u0101\7O\2\2\u0100\u00fe\3\2"+
		"\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0105\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\7\65\2\2\u0106\u0108\3"+
		"\2\2\2\u0107\u00eb\3\2\2\2\u0107\u00f9\3\2\2\2\u0108\35\3\2\2\2\u0109"+
		"\u010a\t\2\2\2\u010a\37\3\2\2\2\u010b\u010c\7O\2\2\u010c\u010d\5\64\33"+
		"\2\u010d\u010e\5<\37\2\u010e\u0117\3\2\2\2\u010f\u0110\7O\2\2\u0110\u0112"+
		"\7/\2\2\u0111\u0113\5\"\22\2\u0112\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0115\7\60\2\2\u0115\u0117\7\65\2\2\u0116\u010b\3"+
		"\2\2\2\u0116\u010f\3\2\2\2\u0117!\3\2\2\2\u0118\u011d\7O\2\2\u0119\u011a"+
		"\7\66\2\2\u011a\u011c\7O\2\2\u011b\u0119\3\2\2\2\u011c\u011f\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e#\3\2\2\2\u011f\u011d\3\2\2\2"+
		"\u0120\u0122\5\36\20\2\u0121\u0120\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121"+
		"\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0128\3\2\2\2\u0125\u0123\3\2\2\2\u0126"+
		"\u0129\5,\27\2\u0127\u0129\7$\2\2\u0128\u0126\3\2\2\2\u0128\u0127\3\2"+
		"\2\2\u0129\u012a\3\2\2\2\u012a\u012b\7O\2\2\u012b\u012e\5\64\33\2\u012c"+
		"\u012f\5<\37\2\u012d\u012f\7\65\2\2\u012e\u012c\3\2\2\2\u012e\u012d\3"+
		"\2\2\2\u012f%\3\2\2\2\u0130\u0133\5<\37\2\u0131\u0133\7\65\2\2\u0132\u0130"+
		"\3\2\2\2\u0132\u0131\3\2\2\2\u0133\'\3\2\2\2\u0134\u0137\5\32\16\2\u0135"+
		"\u0137\5*\26\2\u0136\u0134\3\2\2\2\u0136\u0135\3\2\2\2\u0137)\3\2\2\2"+
		"\u0138\u013a\5\36\20\2\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139"+
		"\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u0140\3\2\2\2\u013d\u013b\3\2\2\2\u013e"+
		"\u0141\5,\27\2\u013f\u0141\7$\2\2\u0140\u013e\3\2\2\2\u0140\u013f\3\2"+
		"\2\2\u0141\u0142\3\2\2\2\u0142\u0143\7O\2\2\u0143\u0144\5\64\33\2\u0144"+
		"\u0145\7\65\2\2\u0145+\3\2\2\2\u0146\u0147\b\27\1\2\u0147\u014a\5.\30"+
		"\2\u0148\u014a\5\62\32\2\u0149\u0146\3\2\2\2\u0149\u0148\3\2\2\2\u014a"+
		"\u0155\3\2\2\2\u014b\u014c\f\4\2\2\u014c\u014d\7\63\2\2\u014d\u0154\7"+
		"\64\2\2\u014e\u014f\f\3\2\2\u014f\u0150\7\63\2\2\u0150\u0151\5,\27\2\u0151"+
		"\u0152\7\64\2\2\u0152\u0154\3\2\2\2\u0153\u014b\3\2\2\2\u0153\u014e\3"+
		"\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156"+
		"-\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0159\7O\2\2\u0159\u015b\7\67\2\2"+
		"\u015a\u0158\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d"+
		"\3\2\2\2\u015d\u015f\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0161\7O\2\2\u0160"+
		"\u0162\5\60\31\2\u0161\u0160\3\2\2\2\u0161\u0162\3\2\2\2\u0162/\3\2\2"+
		"\2\u0163\u0164\7:\2\2\u0164\u0169\5,\27\2\u0165\u0166\7\66\2\2\u0166\u0168"+
		"\5,\27\2\u0167\u0165\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169"+
		"\u016a\3\2\2\2\u016a\u016c\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u016d\79"+
		"\2\2\u016d\61\3\2\2\2\u016e\u016f\t\3\2\2\u016f\63\3\2\2\2\u0170\u0172"+
		"\7/\2\2\u0171\u0173\5\66\34\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2"+
		"\u0173\u0174\3\2\2\2\u0174\u0175\7\60\2\2\u0175\65\3\2\2\2\u0176\u017b"+
		"\58\35\2\u0177\u0178\7\66\2\2\u0178\u017a\58\35\2\u0179\u0177\3\2\2\2"+
		"\u017a\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\67"+
		"\3\2\2\2\u017d\u017b\3\2\2\2\u017e\u017f\5,\27\2\u017f\u0180\7O\2\2\u0180"+
		"9\3\2\2\2\u0181\u0186\7O\2\2\u0182\u0183\7\67\2\2\u0183\u0185\7O\2\2\u0184"+
		"\u0182\3\2\2\2\u0185\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2"+
		"\2\2\u0187;\3\2\2\2\u0188\u0186\3\2\2\2\u0189\u018d\7\61\2\2\u018a\u018c"+
		"\5> \2\u018b\u018a\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018b\3\2\2\2\u018d"+
		"\u018e\3\2\2\2\u018e\u0190\3\2\2\2\u018f\u018d\3\2\2\2\u0190\u0191\7\62"+
		"\2\2\u0191=\3\2\2\2\u0192\u01be\5<\37\2\u0193\u0194\5@!\2\u0194\u0195"+
		"\7\65\2\2\u0195\u01be\3\2\2\2\u0196\u0197\5B\"\2\u0197\u0198\7\65\2\2"+
		"\u0198\u01be\3\2\2\2\u0199\u01be\5F$\2\u019a\u019b\7\22\2\2\u019b\u019c"+
		"\7/\2\2\u019c\u019d\5J&\2\u019d\u019e\7\60\2\2\u019e\u019f\5<\37\2\u019f"+
		"\u01be\3\2\2\2\u01a0\u01a1\7%\2\2\u01a1\u01a2\5T+\2\u01a2\u01a3\5<\37"+
		"\2\u01a3\u01be\3\2\2\2\u01a4\u01a5\7 \2\2\u01a5\u01a6\5T+\2\u01a6\u01a7"+
		"\5<\37\2\u01a7\u01be\3\2\2\2\u01a8\u01a9\7\"\2\2\u01a9\u01aa\5T+\2\u01aa"+
		"\u01ab\5<\37\2\u01ab\u01be\3\2\2\2\u01ac\u01be\5R*\2\u01ad\u01af\7\34"+
		"\2\2\u01ae\u01b0\5X-\2\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1"+
		"\3\2\2\2\u01b1\u01be\7\65\2\2\u01b2\u01b3\7\6\2\2\u01b3\u01be\7\65\2\2"+
		"\u01b4\u01b5\7\13\2\2\u01b5\u01be\7\65\2\2\u01b6\u01b7\5X-\2\u01b7\u01b8"+
		"\7\65\2\2\u01b8\u01be\3\2\2\2\u01b9\u01ba\7(\2\2\u01ba\u01bb\7-\2\2\u01bb"+
		"\u01be\7\65\2\2\u01bc\u01be\7\65\2\2\u01bd\u0192\3\2\2\2\u01bd\u0193\3"+
		"\2\2\2\u01bd\u0196\3\2\2\2\u01bd\u0199\3\2\2\2\u01bd\u019a\3\2\2\2\u01bd"+
		"\u01a0\3\2\2\2\u01bd\u01a4\3\2\2\2\u01bd\u01a8\3\2\2\2\u01bd\u01ac\3\2"+
		"\2\2\u01bd\u01ad\3\2\2\2\u01bd\u01b2\3\2\2\2\u01bd\u01b4\3\2\2\2\u01bd"+
		"\u01b6\3\2\2\2\u01bd\u01b9\3\2\2\2\u01bd\u01bc\3\2\2\2\u01be?\3\2\2\2"+
		"\u01bf\u01c1\7\25\2\2\u01c0\u01bf\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c2"+
		"\3\2\2\2\u01c2\u01c3\7#\2\2\u01c3\u01c6\7O\2\2\u01c4\u01c5\78\2\2\u01c5"+
		"\u01c7\5X-\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7A\3\2\2\2\u01c8"+
		"\u01c9\5D#\2\u01c9\u01ca\78\2\2\u01ca\u01cb\5X-\2\u01cb\u01d0\3\2\2\2"+
		"\u01cc\u01cd\5D#\2\u01cd\u01ce\t\4\2\2\u01ce\u01d0\3\2\2\2\u01cf\u01c8"+
		"\3\2\2\2\u01cf\u01cc\3\2\2\2\u01d0C\3\2\2\2\u01d1\u01d2\5X-\2\u01d2\u01d3"+
		"\7\67\2\2\u01d3\u01d5\3\2\2\2\u01d4\u01d1\3\2\2\2\u01d4\u01d5\3\2\2\2"+
		"\u01d5\u01d6\3\2\2\2\u01d6\u01dd\7O\2\2\u01d7\u01d8\5X-\2\u01d8\u01d9"+
		"\7\63\2\2\u01d9\u01da\5X-\2\u01da\u01db\7\64\2\2\u01db\u01dd\3\2\2\2\u01dc"+
		"\u01d4\3\2\2\2\u01dc\u01d7\3\2\2\2\u01ddE\3\2\2\2\u01de\u01df\7\23\2\2"+
		"\u01df\u01e0\5T+\2\u01e0\u01e3\5<\37\2\u01e1\u01e2\7\16\2\2\u01e2\u01e4"+
		"\5H%\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4G\3\2\2\2\u01e5\u01e8"+
		"\5<\37\2\u01e6\u01e8\5F$\2\u01e7\u01e5\3\2\2\2\u01e7\u01e6\3\2\2\2\u01e8"+
		"I\3\2\2\2\u01e9\u01f4\5P)\2\u01ea\u01ec\5L\'\2\u01eb\u01ea\3\2\2\2\u01eb"+
		"\u01ec\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ee\7\65\2\2\u01ee\u01ef\5"+
		"X-\2\u01ef\u01f1\7\65\2\2\u01f0\u01f2\5N(\2\u01f1\u01f0\3\2\2\2\u01f1"+
		"\u01f2\3\2\2\2\u01f2\u01f4\3\2\2\2\u01f3\u01e9\3\2\2\2\u01f3\u01eb\3\2"+
		"\2\2\u01f4K\3\2\2\2\u01f5\u01f9\5@!\2\u01f6\u01f9\5B\"\2\u01f7\u01f9\5"+
		"X-\2\u01f8\u01f5\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8\u01f7\3\2\2\2\u01f9"+
		"M\3\2\2\2\u01fa\u01fd\5B\"\2\u01fb\u01fd\5X-\2\u01fc\u01fa\3\2\2\2\u01fc"+
		"\u01fb\3\2\2\2\u01fdO\3\2\2\2\u01fe\u01ff\7#\2\2\u01ff\u0202\7O\2\2\u0200"+
		"\u0201\7\66\2\2\u0201\u0203\7O\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2"+
		"\2\2\u0203\u0204\3\2\2\2\u0204\u0205\7>\2\2\u0205\u0206\5X-\2\u0206Q\3"+
		"\2\2\2\u0207\u0208\7\b\2\2\u0208\u0209\5X-\2\u0209\u020a\7>\2\2\u020a"+
		"\u0213\3\2\2\2\u020b\u020c\7\b\2\2\u020c\u020d\5,\27\2\u020d\u020e\7O"+
		"\2\2\u020e\u020f\7>\2\2\u020f\u0213\3\2\2\2\u0210\u0211\7\f\2\2\u0211"+
		"\u0213\7>\2\2\u0212\u0207\3\2\2\2\u0212\u020b\3\2\2\2\u0212\u0210\3\2"+
		"\2\2\u0213S\3\2\2\2\u0214\u0215\7/\2\2\u0215\u0216\5X-\2\u0216\u0217\7"+
		"\60\2\2\u0217U\3\2\2\2\u0218\u021d\5X-\2\u0219\u021a\7\66\2\2\u021a\u021c"+
		"\5X-\2\u021b\u0219\3\2\2\2\u021c\u021f\3\2\2\2\u021d\u021b\3\2\2\2\u021d"+
		"\u021e\3\2\2\2\u021eW\3\2\2\2\u021f\u021d\3\2\2\2\u0220\u0221\b-\1\2\u0221"+
		"\u022c\5Z.\2\u0222\u0223\7\31\2\2\u0223\u022c\5\\/\2\u0224\u0225\t\5\2"+
		"\2\u0225\u022c\5X-\20\u0226\u0227\t\6\2\2\u0227\u022c\5X-\17\u0228\u0229"+
		"\7\37\2\2\u0229\u022a\7\67\2\2\u022a\u022c\7O\2\2\u022b\u0220\3\2\2\2"+
		"\u022b\u0222\3\2\2\2\u022b\u0224\3\2\2\2\u022b\u0226\3\2\2\2\u022b\u0228"+
		"\3\2\2\2\u022c\u0261\3\2\2\2\u022d\u022e\f\16\2\2\u022e\u022f\t\7\2\2"+
		"\u022f\u0260\5X-\17\u0230\u0231\f\r\2\2\u0231\u0232\t\5\2\2\u0232\u0260"+
		"\5X-\16\u0233\u0234\f\f\2\2\u0234\u0235\t\b\2\2\u0235\u0260\5X-\r\u0236"+
		"\u0237\f\13\2\2\u0237\u0238\t\t\2\2\u0238\u0260\5X-\f\u0239\u023a\f\n"+
		"\2\2\u023a\u023b\t\n\2\2\u023b\u0260\5X-\13\u023c\u023d\f\t\2\2\u023d"+
		"\u023e\7K\2\2\u023e\u0260\5X-\n\u023f\u0240\f\b\2\2\u0240\u0241\7M\2\2"+
		"\u0241\u0260\5X-\t\u0242\u0243\f\7\2\2\u0243\u0244\7L\2\2\u0244\u0260"+
		"\5X-\b\u0245\u0246\f\6\2\2\u0246\u0247\7C\2\2\u0247\u0260\5X-\7\u0248"+
		"\u0249\f\5\2\2\u0249\u024a\7D\2\2\u024a\u0260\5X-\6\u024b\u024c\f\4\2"+
		"\2\u024c\u024d\7=\2\2\u024d\u024e\5X-\2\u024e\u024f\7>\2\2\u024f\u0250"+
		"\5X-\5\u0250\u0260\3\2\2\2\u0251\u0252\f\24\2\2\u0252\u0253\7\67\2\2\u0253"+
		"\u0260\7O\2\2\u0254\u0255\f\23\2\2\u0255\u0256\7\63\2\2\u0256\u0257\5"+
		"X-\2\u0257\u0258\7\64\2\2\u0258\u0260\3\2\2\2\u0259\u025a\f\22\2\2\u025a"+
		"\u025c\7/\2\2\u025b\u025d\5V,\2\u025c\u025b\3\2\2\2\u025c\u025d\3\2\2"+
		"\2\u025d\u025e\3\2\2\2\u025e\u0260\7\60\2\2\u025f\u022d\3\2\2\2\u025f"+
		"\u0230\3\2\2\2\u025f\u0233\3\2\2\2\u025f\u0236\3\2\2\2\u025f\u0239\3\2"+
		"\2\2\u025f\u023c\3\2\2\2\u025f\u023f\3\2\2\2\u025f\u0242\3\2\2\2\u025f"+
		"\u0245\3\2\2\2\u025f\u0248\3\2\2\2\u025f\u024b\3\2\2\2\u025f\u0251\3\2"+
		"\2\2\u025f\u0254\3\2\2\2\u025f\u0259\3\2\2\2\u0260\u0263\3\2\2\2\u0261"+
		"\u025f\3\2\2\2\u0261\u0262\3\2\2\2\u0262Y\3\2\2\2\u0263\u0261\3\2\2\2"+
		"\u0264\u0269\5T+\2\u0265\u0269\7!\2\2\u0266\u0269\5f\64\2\u0267\u0269"+
		"\7O\2\2\u0268\u0264\3\2\2\2\u0268\u0265\3\2\2\2\u0268\u0266\3\2\2\2\u0268"+
		"\u0267\3\2\2\2\u0269[\3\2\2\2\u026a\u026d\5,\27\2\u026b\u026e\5^\60\2"+
		"\u026c\u026e\5`\61\2\u026d\u026b\3\2\2\2\u026d\u026c\3\2\2\2\u026e\u0271"+
		"\3\2\2\2\u026f\u0271\5h\65\2\u0270\u026a\3\2\2\2\u0270\u026f\3\2\2\2\u0271"+
		"]\3\2\2\2\u0272\u0273\7\63\2\2\u0273\u0274\7\64\2\2\u0274\u0276\7\61\2"+
		"\2\u0275\u0277\5V,\2\u0276\u0275\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0278"+
		"\3\2\2\2\u0278\u0285\7\62\2\2\u0279\u027a\7\63\2\2\u027a\u027b\5X-\2\u027b"+
		"\u027c\7\64\2\2\u027c\u0285\3\2\2\2\u027d\u027e\7\63\2\2\u027e\u027f\7"+
		"\t\2\2\u027f\u0280\5,\27\2\u0280\u0282\7\64\2\2\u0281\u0283\5b\62\2\u0282"+
		"\u0281\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0285\3\2\2\2\u0284\u0272\3\2"+
		"\2\2\u0284\u0279\3\2\2\2\u0284\u027d\3\2\2\2\u0285_\3\2\2\2\u0286\u0288"+
		"\7/\2\2\u0287\u0289\5V,\2\u0288\u0287\3\2\2\2\u0288\u0289\3\2\2\2\u0289"+
		"\u028a\3\2\2\2\u028a\u028c\7\60\2\2\u028b\u028d\5\24\13\2\u028c\u028b"+
		"\3\2\2\2\u028c\u028d\3\2\2\2\u028da\3\2\2\2\u028e\u028f\7\61\2\2\u028f"+
		"\u029c\7\62\2\2\u0290\u0291\7\61\2\2\u0291\u0296\5d\63\2\u0292\u0293\7"+
		"\66\2\2\u0293\u0295\5d\63\2\u0294\u0292\3\2\2\2\u0295\u0298\3\2\2\2\u0296"+
		"\u0294\3\2\2\2\u0296\u0297\3\2\2\2\u0297\u0299\3\2\2\2\u0298\u0296\3\2"+
		"\2\2\u0299\u029a\7\62\2\2\u029a\u029c\3\2\2\2\u029b\u028e\3\2\2\2\u029b"+
		"\u0290\3\2\2\2\u029cc\3\2\2\2\u029d\u029e\5X-\2\u029e\u029f\7>\2\2\u029f"+
		"\u02a0\5X-\2\u02a0e\3\2\2\2\u02a1\u02a2\t\13\2\2\u02a2g\3\2\2\2\u02a3"+
		"\u02a7\7\61\2\2\u02a4\u02a6\5j\66\2\u02a5\u02a4\3\2\2\2\u02a6\u02a9\3"+
		"\2\2\2\u02a7\u02a5\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02aa\3\2\2\2\u02a9"+
		"\u02a7\3\2\2\2\u02aa\u02ab\7\62\2\2\u02abi\3\2\2\2\u02ac\u02ad\7O\2\2"+
		"\u02ad\u02ae\7>\2\2\u02ae\u02af\5X-\2\u02af\u02b0\7\65\2\2\u02b0\u02b3"+
		"\3\2\2\2\u02b1\u02b3\5\30\r\2\u02b2\u02ac\3\2\2\2\u02b2\u02b1\3\2\2\2"+
		"\u02b3k\3\2\2\2Lmrx\u0085\u008b\u0090\u0096\u0099\u00a5\u00b0\u00b6\u00b9"+
		"\u00c1\u00ca\u00d5\u00e0\u00eb\u00f2\u00f9\u0102\u0107\u0112\u0116\u011d"+
		"\u0123\u0128\u012e\u0132\u0136\u013b\u0140\u0149\u0153\u0155\u015c\u0161"+
		"\u0169\u0172\u017b\u0186\u018d\u01af\u01bd\u01c0\u01c6\u01cf\u01d4\u01dc"+
		"\u01e3\u01e7\u01eb\u01f1\u01f3\u01f8\u01fc\u0202\u0212\u021d\u022b\u025c"+
		"\u025f\u0261\u0268\u026d\u0270\u0276\u0282\u0284\u0288\u028c\u0296\u029b"+
		"\u02a7\u02b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}