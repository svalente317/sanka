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
		PACKAGE=24, PRIVATE=25, RETURN=26, SHORT=27, STATIC=28, SWITCH=29, THIS=30, 
		SUPER=31, VAR=32, VOID=33, WHILE=34, C__INCLUDE=35, C__FIELD=36, C__STMT=37, 
		IntegerLiteral=38, FloatingPointLiteral=39, BooleanLiteral=40, CharacterLiteral=41, 
		StringLiteral=42, NullLiteral=43, LPAREN=44, RPAREN=45, LBRACE=46, RBRACE=47, 
		LBRACK=48, RBRACK=49, SEMI=50, COMMA=51, DOT=52, ASSIGN=53, GT=54, LT=55, 
		BANG=56, TILDE=57, QUESTION=58, COLON=59, EQUAL=60, LE=61, GE=62, NOTEQUAL=63, 
		AND=64, OR=65, INC=66, DEC=67, ADD=68, SUB=69, MUL=70, DIV=71, BITAND=72, 
		BITOR=73, CARET=74, MOD=75, Identifier=76, ELLIPSIS=77, WS=78, COMMENT=79, 
		LINE_COMMENT=80;
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
			"'short'", "'static'", "'switch'", "'this'", "'super'", "'var'", "'void'", 
			"'while'", "'c__include'", "'c__field'", "'c__stmt'", null, null, null, 
			null, null, "'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", 
			"','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'=='", 
			"'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", 
			"'*'", "'/'", "'&'", "'|'", "'^'", "'%'", null, "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "BOOLEAN", "BREAK", "BYTE", "CASE", "CLASS", "CONST", 
			"CONTINUE", "DEFAULT", "DOUBLE", "ELSE", "EXPORT", "EXTENDS", "FLOAT", 
			"FOR", "IF", "IMPORT", "INLINE", "INT", "INTERFACE", "LONG", "NEW", "PACKAGE", 
			"PRIVATE", "RETURN", "SHORT", "STATIC", "SWITCH", "THIS", "SUPER", "VAR", 
			"VOID", "WHILE", "C__INCLUDE", "C__FIELD", "C__STMT", "IntegerLiteral", 
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

			setState(182);
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
			setState(184);
			match(LBRACE);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CONST) | (1L << DOUBLE) | (1L << EXPORT) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << PRIVATE) | (1L << SHORT) | (1L << STATIC) | (1L << VOID) | (1L << C__INCLUDE) | (1L << C__FIELD))) != 0) || _la==Identifier) {
				{
				{
				setState(185);
				classBodyDeclaration();
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(191);
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
			setState(193);
			match(LBRACE);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CONST) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << PRIVATE) | (1L << SHORT) | (1L << STATIC) | (1L << VOID))) != 0) || _la==Identifier) {
				{
				{
				setState(194);
				interfaceBodyDeclaration();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200);
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
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				constDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				fieldDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				match(EXPORT);
				setState(205);
				match(Identifier);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(206);
					match(DOT);
					setState(207);
					match(Identifier);
					}
				}

				setState(210);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(211);
				constructorDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(212);
				methodDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(213);
				match(C__INCLUDE);
				setState(214);
				match(StringLiteral);
				setState(215);
				match(SEMI);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(216);
				match(C__FIELD);
				setState(217);
				match(StringLiteral);
				setState(218);
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
			setState(221);
			match(CONST);
			setState(222);
			match(Identifier);
			setState(223);
			match(ASSIGN);
			setState(224);
			expression(0);
			setState(225);
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
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) {
					{
					{
					setState(227);
					fieldModifier();
					}
					}
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(233);
				typeType(0);
				setState(234);
				match(Identifier);
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(235);
					match(ASSIGN);
					setState(236);
					expression(0);
					}
				}

				setState(239);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) {
					{
					{
					setState(241);
					fieldModifier();
					}
					}
					setState(246);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(247);
				typeType(0);
				setState(248);
				match(Identifier);
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(249);
					match(COMMA);
					setState(250);
					match(Identifier);
					}
					}
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(256);
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
			setState(260);
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
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				match(Identifier);
				setState(263);
				formalParameters();
				setState(264);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				match(Identifier);
				setState(267);
				match(LPAREN);
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(268);
					identifierList();
					}
				}

				setState(271);
				match(RPAREN);
				setState(272);
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
			setState(275);
			match(Identifier);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(276);
				match(COMMA);
				setState(277);
				match(Identifier);
				}
				}
				setState(282);
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
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) {
				{
				{
				setState(283);
				fieldModifier();
				}
				}
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(291);
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
				setState(289);
				typeType(0);
				}
				break;
			case VOID:
				{
				setState(290);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(293);
			match(Identifier);
			setState(294);
			formalParameters();
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(295);
				block();
				}
				break;
			case SEMI:
				{
				setState(296);
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
			setState(301);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				block();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
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
			setState(305);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
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
				setState(304);
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
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE) | (1L << PRIVATE) | (1L << STATIC))) != 0)) {
				{
				{
				setState(307);
				fieldModifier();
				}
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(315);
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
				setState(313);
				typeType(0);
				}
				break;
			case VOID:
				{
				setState(314);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(317);
			match(Identifier);
			setState(318);
			formalParameters();
			setState(319);
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
			setState(324);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(322);
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
				setState(323);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(336);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(334);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new TypeTypeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_typeType);
						setState(326);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(327);
						match(LBRACK);
						setState(328);
						match(RBRACK);
						}
						break;
					case 2:
						{
						_localctx = new TypeTypeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_typeType);
						setState(329);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(330);
						match(LBRACK);
						setState(331);
						typeType(0);
						setState(332);
						match(RBRACK);
						}
						break;
					}
					} 
				}
				setState(338);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
			setState(343);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(339);
					match(Identifier);
					setState(340);
					match(DOT);
					}
					} 
				}
				setState(345);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			setState(346);
			match(Identifier);
			setState(348);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(347);
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
			setState(350);
			match(LT);
			setState(351);
			typeType(0);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(352);
				match(COMMA);
				setState(353);
				typeType(0);
				}
				}
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(359);
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
			setState(361);
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
			setState(363);
			match(LPAREN);
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || _la==Identifier) {
				{
				setState(364);
				formalParameterList();
				}
			}

			setState(367);
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
			setState(369);
			formalParameter();
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(370);
				match(COMMA);
				setState(371);
				formalParameter();
				}
				}
				setState(376);
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
			setState(377);
			typeType(0);
			setState(378);
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
			setState(380);
			match(Identifier);
			setState(385);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(381);
					match(DOT);
					setState(382);
					match(Identifier);
					}
					} 
				}
				setState(387);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
			setState(388);
			match(LBRACE);
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << FOR) | (1L << IF) | (1L << INLINE) | (1L << NEW) | (1L << RETURN) | (1L << SWITCH) | (1L << THIS) | (1L << SUPER) | (1L << VAR) | (1L << WHILE) | (1L << C__STMT) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << BANG) | (1L << TILDE))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (ADD - 68)) | (1L << (SUB - 68)) | (1L << (Identifier - 68)))) != 0)) {
				{
				{
				setState(389);
				statement();
				}
				}
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(395);
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
			setState(436);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(397);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				variableDeclaration();
				setState(399);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(401);
				variableAssignment();
				setState(402);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(404);
				ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(405);
				match(FOR);
				setState(406);
				match(LPAREN);
				setState(407);
				forControl();
				setState(408);
				match(RPAREN);
				setState(409);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(411);
				match(WHILE);
				setState(412);
				parExpression();
				setState(413);
				block();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(415);
				match(SWITCH);
				setState(416);
				parExpression();
				setState(417);
				block();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(419);
				switchLabel();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(420);
				match(RETURN);
				setState(422);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (THIS - 23)) | (1L << (SUPER - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
					{
					setState(421);
					expression(0);
					}
				}

				setState(424);
				match(SEMI);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(425);
				match(BREAK);
				setState(426);
				match(SEMI);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(427);
				match(CONTINUE);
				setState(428);
				match(SEMI);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(429);
				expression(0);
				setState(430);
				match(SEMI);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(432);
				match(C__STMT);
				setState(433);
				match(StringLiteral);
				setState(434);
				match(SEMI);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(435);
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
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INLINE) {
				{
				setState(438);
				match(INLINE);
				}
			}

			setState(441);
			match(VAR);
			setState(442);
			match(Identifier);
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(443);
				match(ASSIGN);
				setState(444);
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
			setState(454);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(447);
				assignable();
				setState(448);
				match(ASSIGN);
				setState(449);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(451);
				assignable();
				setState(452);
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
			setState(467);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(459);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(456);
					expression(0);
					setState(457);
					match(DOT);
					}
					break;
				}
				setState(461);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(462);
				expression(0);
				setState(463);
				match(LBRACK);
				setState(464);
				expression(0);
				setState(465);
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
			setState(469);
			match(IF);
			setState(470);
			parExpression();
			setState(471);
			block();
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(472);
				match(ELSE);
				setState(473);
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
			setState(478);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(476);
				block();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(477);
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
			setState(490);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(480);
				enhancedForControl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(482);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (INLINE - 19)) | (1L << (NEW - 19)) | (1L << (THIS - 19)) | (1L << (SUPER - 19)) | (1L << (VAR - 19)) | (1L << (IntegerLiteral - 19)) | (1L << (FloatingPointLiteral - 19)) | (1L << (BooleanLiteral - 19)) | (1L << (CharacterLiteral - 19)) | (1L << (StringLiteral - 19)) | (1L << (NullLiteral - 19)) | (1L << (LPAREN - 19)) | (1L << (BANG - 19)) | (1L << (TILDE - 19)) | (1L << (ADD - 19)) | (1L << (SUB - 19)) | (1L << (Identifier - 19)))) != 0)) {
					{
					setState(481);
					forInit();
					}
				}

				setState(484);
				match(SEMI);
				setState(485);
				expression(0);
				setState(486);
				match(SEMI);
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (THIS - 23)) | (1L << (SUPER - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
					{
					setState(487);
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
			setState(495);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(492);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(493);
				variableAssignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(494);
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
			setState(499);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(497);
				variableAssignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(498);
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
			setState(501);
			match(VAR);
			setState(502);
			match(Identifier);
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(503);
				match(COMMA);
				setState(504);
				match(Identifier);
				}
			}

			setState(507);
			match(COLON);
			setState(508);
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
			setState(521);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(510);
				match(CASE);
				setState(511);
				expression(0);
				setState(512);
				match(COLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(514);
				match(CASE);
				setState(515);
				typeType(0);
				setState(516);
				match(Identifier);
				setState(517);
				match(COLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(519);
				match(DEFAULT);
				setState(520);
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
			setState(523);
			match(LPAREN);
			setState(524);
			expression(0);
			setState(525);
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
			setState(527);
			expression(0);
			setState(532);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(528);
				match(COMMA);
				setState(529);
				expression(0);
				}
				}
				setState(534);
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
			setState(546);
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
				setState(536);
				primary();
				}
				break;
			case NEW:
				{
				setState(537);
				match(NEW);
				setState(538);
				creator();
				}
				break;
			case ADD:
			case SUB:
				{
				setState(539);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(540);
				expression(14);
				}
				break;
			case BANG:
			case TILDE:
				{
				setState(541);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(542);
				expression(13);
				}
				break;
			case SUPER:
				{
				setState(543);
				match(SUPER);
				setState(544);
				match(DOT);
				setState(545);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(600);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(598);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(548);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(549);
						_la = _input.LA(1);
						if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (MUL - 70)) | (1L << (DIV - 70)) | (1L << (MOD - 70)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(550);
						expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(551);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(552);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(553);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(554);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(555);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__1) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(556);
						expression(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(557);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(558);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << LE) | (1L << GE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(559);
						expression(10);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(560);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(561);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(562);
						expression(9);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(563);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(564);
						match(BITAND);
						setState(565);
						expression(8);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(566);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(567);
						match(CARET);
						setState(568);
						expression(7);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(569);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(570);
						match(BITOR);
						setState(571);
						expression(6);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(572);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(573);
						match(AND);
						setState(574);
						expression(5);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(575);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(576);
						match(OR);
						setState(577);
						expression(4);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(578);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(579);
						match(QUESTION);
						setState(580);
						expression(0);
						setState(581);
						match(COLON);
						setState(582);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(584);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(585);
						match(DOT);
						setState(586);
						match(Identifier);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(587);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(588);
						match(LBRACK);
						setState(589);
						expression(0);
						setState(590);
						match(RBRACK);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(592);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(593);
						match(LPAREN);
						setState(595);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (THIS - 23)) | (1L << (SUPER - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
							{
							setState(594);
							expressionList();
							}
						}

						setState(597);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(602);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
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
			setState(607);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(603);
				parExpression();
				}
				break;
			case THIS:
				enterOuterAlt(_localctx, 2);
				{
				setState(604);
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
				setState(605);
				literal();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(606);
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
			setState(615);
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
				setState(609);
				typeType(0);
				setState(612);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACK:
					{
					setState(610);
					arrayCreatorRest();
					}
					break;
				case LPAREN:
					{
					setState(611);
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
				setState(614);
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
			setState(635);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(617);
				match(LBRACK);
				setState(618);
				match(RBRACK);
				setState(619);
				match(LBRACE);
				setState(621);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (THIS - 23)) | (1L << (SUPER - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
					{
					setState(620);
					expressionList();
					}
				}

				setState(623);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(624);
				match(LBRACK);
				setState(625);
				expression(0);
				setState(626);
				match(RBRACK);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(628);
				match(LBRACK);
				setState(629);
				match(CLASS);
				setState(630);
				typeType(0);
				setState(631);
				match(RBRACK);
				setState(633);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(632);
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
			setState(637);
			match(LPAREN);
			setState(639);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (NEW - 23)) | (1L << (THIS - 23)) | (1L << (SUPER - 23)) | (1L << (IntegerLiteral - 23)) | (1L << (FloatingPointLiteral - 23)) | (1L << (BooleanLiteral - 23)) | (1L << (CharacterLiteral - 23)) | (1L << (StringLiteral - 23)) | (1L << (NullLiteral - 23)) | (1L << (LPAREN - 23)) | (1L << (BANG - 23)) | (1L << (TILDE - 23)) | (1L << (ADD - 23)) | (1L << (SUB - 23)) | (1L << (Identifier - 23)))) != 0)) {
				{
				setState(638);
				expressionList();
				}
			}

			setState(641);
			match(RPAREN);
			setState(643);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(642);
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
			setState(658);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(645);
				match(LBRACE);
				setState(646);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(647);
				match(LBRACE);
				setState(648);
				mapEntry();
				setState(653);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(649);
					match(COMMA);
					setState(650);
					mapEntry();
					}
					}
					setState(655);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(656);
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
			setState(660);
			expression(0);
			setState(661);
			match(COLON);
			setState(662);
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
			setState(664);
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
			setState(666);
			match(LBRACE);
			setState(670);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CONST) | (1L << DOUBLE) | (1L << EXPORT) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << PRIVATE) | (1L << SHORT) | (1L << STATIC) | (1L << VOID) | (1L << C__INCLUDE) | (1L << C__FIELD))) != 0) || _la==Identifier) {
				{
				{
				setState(667);
				anonymousClassBodyDeclaration();
				}
				}
				setState(672);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(673);
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
			setState(681);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(675);
				match(Identifier);
				setState(676);
				match(COLON);
				setState(677);
				expression(0);
				setState(678);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(680);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3R\u02ae\4\2\t\2\4"+
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
		"\u00af\n\n\f\n\16\n\u00b2\13\n\3\n\3\n\3\n\5\n\u00b7\n\n\3\n\3\n\3\13"+
		"\3\13\7\13\u00bd\n\13\f\13\16\13\u00c0\13\13\3\13\3\13\3\f\3\f\7\f\u00c6"+
		"\n\f\f\f\16\f\u00c9\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d3\n\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00de\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\7\17\u00e7\n\17\f\17\16\17\u00ea\13\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00f0\n\17\3\17\3\17\3\17\7\17\u00f5\n\17\f\17\16\17\u00f8"+
		"\13\17\3\17\3\17\3\17\3\17\7\17\u00fe\n\17\f\17\16\17\u0101\13\17\3\17"+
		"\3\17\5\17\u0105\n\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u0110\n\21\3\21\3\21\5\21\u0114\n\21\3\22\3\22\3\22\7\22\u0119\n\22\f"+
		"\22\16\22\u011c\13\22\3\23\7\23\u011f\n\23\f\23\16\23\u0122\13\23\3\23"+
		"\3\23\5\23\u0126\n\23\3\23\3\23\3\23\3\23\5\23\u012c\n\23\3\24\3\24\5"+
		"\24\u0130\n\24\3\25\3\25\5\25\u0134\n\25\3\26\7\26\u0137\n\26\f\26\16"+
		"\26\u013a\13\26\3\26\3\26\5\26\u013e\n\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\5\27\u0147\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0151"+
		"\n\27\f\27\16\27\u0154\13\27\3\30\3\30\7\30\u0158\n\30\f\30\16\30\u015b"+
		"\13\30\3\30\3\30\5\30\u015f\n\30\3\31\3\31\3\31\3\31\7\31\u0165\n\31\f"+
		"\31\16\31\u0168\13\31\3\31\3\31\3\32\3\32\3\33\3\33\5\33\u0170\n\33\3"+
		"\33\3\33\3\34\3\34\3\34\7\34\u0177\n\34\f\34\16\34\u017a\13\34\3\35\3"+
		"\35\3\35\3\36\3\36\3\36\7\36\u0182\n\36\f\36\16\36\u0185\13\36\3\37\3"+
		"\37\7\37\u0189\n\37\f\37\16\37\u018c\13\37\3\37\3\37\3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u01a9\n"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u01b7\n \3!\5!\u01ba\n!\3!\3"+
		"!\3!\3!\5!\u01c0\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01c9\n\"\3#\3#\3"+
		"#\5#\u01ce\n#\3#\3#\3#\3#\3#\3#\5#\u01d6\n#\3$\3$\3$\3$\3$\5$\u01dd\n"+
		"$\3%\3%\5%\u01e1\n%\3&\3&\5&\u01e5\n&\3&\3&\3&\3&\5&\u01eb\n&\5&\u01ed"+
		"\n&\3\'\3\'\3\'\5\'\u01f2\n\'\3(\3(\5(\u01f6\n(\3)\3)\3)\3)\5)\u01fc\n"+
		")\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u020c\n*\3+\3+\3+\3+\3"+
		",\3,\3,\7,\u0215\n,\f,\16,\u0218\13,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-"+
		"\5-\u0225\n-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-"+
		"\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-"+
		"\3-\3-\3-\3-\3-\5-\u0256\n-\3-\7-\u0259\n-\f-\16-\u025c\13-\3.\3.\3.\3"+
		".\5.\u0262\n.\3/\3/\3/\5/\u0267\n/\3/\5/\u026a\n/\3\60\3\60\3\60\3\60"+
		"\5\60\u0270\n\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60"+
		"\u027c\n\60\5\60\u027e\n\60\3\61\3\61\5\61\u0282\n\61\3\61\3\61\5\61\u0286"+
		"\n\61\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u028e\n\62\f\62\16\62\u0291\13"+
		"\62\3\62\3\62\5\62\u0295\n\62\3\63\3\63\3\63\3\63\3\64\3\64\3\65\3\65"+
		"\7\65\u029f\n\65\f\65\16\65\u02a2\13\65\3\65\3\65\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\5\66\u02ac\n\66\3\66\2\4,X\67\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhj\2\f\5\2\25\25"+
		"\33\33\36\36\t\2\5\5\7\7\r\r\21\21\26\26\30\30\35\35\3\2DE\3\2FG\3\2:"+
		";\4\2HIMM\3\2\3\4\4\289?@\4\2>>AA\3\2(-\2\u02e6\2m\3\2\2\2\4}\3\2\2\2"+
		"\6\u0081\3\2\2\2\b\u008b\3\2\2\2\n\u0090\3\2\2\2\f\u009d\3\2\2\2\16\u009f"+
		"\3\2\2\2\20\u00aa\3\2\2\2\22\u00b0\3\2\2\2\24\u00ba\3\2\2\2\26\u00c3\3"+
		"\2\2\2\30\u00dd\3\2\2\2\32\u00df\3\2\2\2\34\u0104\3\2\2\2\36\u0106\3\2"+
		"\2\2 \u0113\3\2\2\2\"\u0115\3\2\2\2$\u0120\3\2\2\2&\u012f\3\2\2\2(\u0133"+
		"\3\2\2\2*\u0138\3\2\2\2,\u0146\3\2\2\2.\u0159\3\2\2\2\60\u0160\3\2\2\2"+
		"\62\u016b\3\2\2\2\64\u016d\3\2\2\2\66\u0173\3\2\2\28\u017b\3\2\2\2:\u017e"+
		"\3\2\2\2<\u0186\3\2\2\2>\u01b6\3\2\2\2@\u01b9\3\2\2\2B\u01c8\3\2\2\2D"+
		"\u01d5\3\2\2\2F\u01d7\3\2\2\2H\u01e0\3\2\2\2J\u01ec\3\2\2\2L\u01f1\3\2"+
		"\2\2N\u01f5\3\2\2\2P\u01f7\3\2\2\2R\u020b\3\2\2\2T\u020d\3\2\2\2V\u0211"+
		"\3\2\2\2X\u0224\3\2\2\2Z\u0261\3\2\2\2\\\u0269\3\2\2\2^\u027d\3\2\2\2"+
		"`\u027f\3\2\2\2b\u0294\3\2\2\2d\u0296\3\2\2\2f\u029a\3\2\2\2h\u029c\3"+
		"\2\2\2j\u02ab\3\2\2\2ln\5\4\3\2ml\3\2\2\2mn\3\2\2\2nr\3\2\2\2oq\5\6\4"+
		"\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2sx\3\2\2\2tr\3\2\2\2uw\5\b\5"+
		"\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7\2\2"+
		"\3|\3\3\2\2\2}~\7\32\2\2~\177\5:\36\2\177\u0080\7\64\2\2\u0080\5\3\2\2"+
		"\2\u0081\u0082\7\24\2\2\u0082\u0085\5:\36\2\u0083\u0084\7\66\2\2\u0084"+
		"\u0086\7H\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\u0088\7\64\2\2\u0088\7\3\2\2\2\u0089\u008c\5\n\6\2\u008a\u008c"+
		"\5\22\n\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\t\3\2\2\2\u008d"+
		"\u008f\5\f\7\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093"+
		"\u0094\7\t\2\2\u0094\u0096\7N\2\2\u0095\u0097\5\16\b\2\u0096\u0095\3\2"+
		"\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u009a\5\20\t\2\u0099"+
		"\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\5\24"+
		"\13\2\u009c\13\3\2\2\2\u009d\u009e\7N\2\2\u009e\r\3\2\2\2\u009f\u00a0"+
		"\79\2\2\u00a0\u00a5\7N\2\2\u00a1\u00a2\7\65\2\2\u00a2\u00a4\7N\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\78\2\2\u00a9"+
		"\17\3\2\2\2\u00aa\u00ab\7\20\2\2\u00ab\u00ac\5,\27\2\u00ac\21\3\2\2\2"+
		"\u00ad\u00af\5\f\7\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3"+
		"\u00b4\7\27\2\2\u00b4\u00b6\7N\2\2\u00b5\u00b7\5\16\b\2\u00b6\u00b5\3"+
		"\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\5\26\f\2\u00b9"+
		"\23\3\2\2\2\u00ba\u00be\7\60\2\2\u00bb\u00bd\5\30\r\2\u00bc\u00bb\3\2"+
		"\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7\61\2\2\u00c2\25\3\2\2"+
		"\2\u00c3\u00c7\7\60\2\2\u00c4\u00c6\5(\25\2\u00c5\u00c4\3\2\2\2\u00c6"+
		"\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7\61\2\2\u00cb\27\3\2\2\2\u00cc\u00de"+
		"\5\32\16\2\u00cd\u00de\5\34\17\2\u00ce\u00cf\7\17\2\2\u00cf\u00d2\7N\2"+
		"\2\u00d0\u00d1\7\66\2\2\u00d1\u00d3\7N\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00de\7\64\2\2\u00d5\u00de\5 \21\2"+
		"\u00d6\u00de\5$\23\2\u00d7\u00d8\7%\2\2\u00d8\u00d9\7,\2\2\u00d9\u00de"+
		"\7\64\2\2\u00da\u00db\7&\2\2\u00db\u00dc\7,\2\2\u00dc\u00de\7\64\2\2\u00dd"+
		"\u00cc\3\2\2\2\u00dd\u00cd\3\2\2\2\u00dd\u00ce\3\2\2\2\u00dd\u00d5\3\2"+
		"\2\2\u00dd\u00d6\3\2\2\2\u00dd\u00d7\3\2\2\2\u00dd\u00da\3\2\2\2\u00de"+
		"\31\3\2\2\2\u00df\u00e0\7\n\2\2\u00e0\u00e1\7N\2\2\u00e1\u00e2\7\67\2"+
		"\2\u00e2\u00e3\5X-\2\u00e3\u00e4\7\64\2\2\u00e4\33\3\2\2\2\u00e5\u00e7"+
		"\5\36\20\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2"+
		"\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec"+
		"\5,\27\2\u00ec\u00ef\7N\2\2\u00ed\u00ee\7\67\2\2\u00ee\u00f0\5X-\2\u00ef"+
		"\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\7\64"+
		"\2\2\u00f2\u0105\3\2\2\2\u00f3\u00f5\5\36\20\2\u00f4\u00f3\3\2\2\2\u00f5"+
		"\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\3\2"+
		"\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\5,\27\2\u00fa\u00ff\7N\2\2\u00fb"+
		"\u00fc\7\65\2\2\u00fc\u00fe\7N\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0101\3\2"+
		"\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0102\u0103\7\64\2\2\u0103\u0105\3\2\2\2\u0104\u00e8\3"+
		"\2\2\2\u0104\u00f6\3\2\2\2\u0105\35\3\2\2\2\u0106\u0107\t\2\2\2\u0107"+
		"\37\3\2\2\2\u0108\u0109\7N\2\2\u0109\u010a\5\64\33\2\u010a\u010b\5<\37"+
		"\2\u010b\u0114\3\2\2\2\u010c\u010d\7N\2\2\u010d\u010f\7.\2\2\u010e\u0110"+
		"\5\"\22\2\u010f\u010e\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\3\2\2\2"+
		"\u0111\u0112\7/\2\2\u0112\u0114\7\64\2\2\u0113\u0108\3\2\2\2\u0113\u010c"+
		"\3\2\2\2\u0114!\3\2\2\2\u0115\u011a\7N\2\2\u0116\u0117\7\65\2\2\u0117"+
		"\u0119\7N\2\2\u0118\u0116\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2"+
		"\2\2\u011a\u011b\3\2\2\2\u011b#\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011f"+
		"\5\36\20\2\u011e\u011d\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2"+
		"\u0120\u0121\3\2\2\2\u0121\u0125\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0126"+
		"\5,\27\2\u0124\u0126\7#\2\2\u0125\u0123\3\2\2\2\u0125\u0124\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0128\7N\2\2\u0128\u012b\5\64\33\2\u0129\u012c\5"+
		"<\37\2\u012a\u012c\7\64\2\2\u012b\u0129\3\2\2\2\u012b\u012a\3\2\2\2\u012c"+
		"%\3\2\2\2\u012d\u0130\5<\37\2\u012e\u0130\7\64\2\2\u012f\u012d\3\2\2\2"+
		"\u012f\u012e\3\2\2\2\u0130\'\3\2\2\2\u0131\u0134\5\32\16\2\u0132\u0134"+
		"\5*\26\2\u0133\u0131\3\2\2\2\u0133\u0132\3\2\2\2\u0134)\3\2\2\2\u0135"+
		"\u0137\5\36\20\2\u0136\u0135\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3"+
		"\2\2\2\u0138\u0139\3\2\2\2\u0139\u013d\3\2\2\2\u013a\u0138\3\2\2\2\u013b"+
		"\u013e\5,\27\2\u013c\u013e\7#\2\2\u013d\u013b\3\2\2\2\u013d\u013c\3\2"+
		"\2\2\u013e\u013f\3\2\2\2\u013f\u0140\7N\2\2\u0140\u0141\5\64\33\2\u0141"+
		"\u0142\7\64\2\2\u0142+\3\2\2\2\u0143\u0144\b\27\1\2\u0144\u0147\5.\30"+
		"\2\u0145\u0147\5\62\32\2\u0146\u0143\3\2\2\2\u0146\u0145\3\2\2\2\u0147"+
		"\u0152\3\2\2\2\u0148\u0149\f\4\2\2\u0149\u014a\7\62\2\2\u014a\u0151\7"+
		"\63\2\2\u014b\u014c\f\3\2\2\u014c\u014d\7\62\2\2\u014d\u014e\5,\27\2\u014e"+
		"\u014f\7\63\2\2\u014f\u0151\3\2\2\2\u0150\u0148\3\2\2\2\u0150\u014b\3"+
		"\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153"+
		"-\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0156\7N\2\2\u0156\u0158\7\66\2\2"+
		"\u0157\u0155\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a"+
		"\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u015e\7N\2\2\u015d"+
		"\u015f\5\60\31\2\u015e\u015d\3\2\2\2\u015e\u015f\3\2\2\2\u015f/\3\2\2"+
		"\2\u0160\u0161\79\2\2\u0161\u0166\5,\27\2\u0162\u0163\7\65\2\2\u0163\u0165"+
		"\5,\27\2\u0164\u0162\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\u0169\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u016a\78"+
		"\2\2\u016a\61\3\2\2\2\u016b\u016c\t\3\2\2\u016c\63\3\2\2\2\u016d\u016f"+
		"\7.\2\2\u016e\u0170\5\66\34\2\u016f\u016e\3\2\2\2\u016f\u0170\3\2\2\2"+
		"\u0170\u0171\3\2\2\2\u0171\u0172\7/\2\2\u0172\65\3\2\2\2\u0173\u0178\5"+
		"8\35\2\u0174\u0175\7\65\2\2\u0175\u0177\58\35\2\u0176\u0174\3\2\2\2\u0177"+
		"\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\67\3\2\2"+
		"\2\u017a\u0178\3\2\2\2\u017b\u017c\5,\27\2\u017c\u017d\7N\2\2\u017d9\3"+
		"\2\2\2\u017e\u0183\7N\2\2\u017f\u0180\7\66\2\2\u0180\u0182\7N\2\2\u0181"+
		"\u017f\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2"+
		"\2\2\u0184;\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u018a\7\60\2\2\u0187\u0189"+
		"\5> \2\u0188\u0187\3\2\2\2\u0189\u018c\3\2\2\2\u018a\u0188\3\2\2\2\u018a"+
		"\u018b\3\2\2\2\u018b\u018d\3\2\2\2\u018c\u018a\3\2\2\2\u018d\u018e\7\61"+
		"\2\2\u018e=\3\2\2\2\u018f\u01b7\5<\37\2\u0190\u0191\5@!\2\u0191\u0192"+
		"\7\64\2\2\u0192\u01b7\3\2\2\2\u0193\u0194\5B\"\2\u0194\u0195\7\64\2\2"+
		"\u0195\u01b7\3\2\2\2\u0196\u01b7\5F$\2\u0197\u0198\7\22\2\2\u0198\u0199"+
		"\7.\2\2\u0199\u019a\5J&\2\u019a\u019b\7/\2\2\u019b\u019c\5<\37\2\u019c"+
		"\u01b7\3\2\2\2\u019d\u019e\7$\2\2\u019e\u019f\5T+\2\u019f\u01a0\5<\37"+
		"\2\u01a0\u01b7\3\2\2\2\u01a1\u01a2\7\37\2\2\u01a2\u01a3\5T+\2\u01a3\u01a4"+
		"\5<\37\2\u01a4\u01b7\3\2\2\2\u01a5\u01b7\5R*\2\u01a6\u01a8\7\34\2\2\u01a7"+
		"\u01a9\5X-\2\u01a8\u01a7\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa\3\2\2"+
		"\2\u01aa\u01b7\7\64\2\2\u01ab\u01ac\7\6\2\2\u01ac\u01b7\7\64\2\2\u01ad"+
		"\u01ae\7\13\2\2\u01ae\u01b7\7\64\2\2\u01af\u01b0\5X-\2\u01b0\u01b1\7\64"+
		"\2\2\u01b1\u01b7\3\2\2\2\u01b2\u01b3\7\'\2\2\u01b3\u01b4\7,\2\2\u01b4"+
		"\u01b7\7\64\2\2\u01b5\u01b7\7\64\2\2\u01b6\u018f\3\2\2\2\u01b6\u0190\3"+
		"\2\2\2\u01b6\u0193\3\2\2\2\u01b6\u0196\3\2\2\2\u01b6\u0197\3\2\2\2\u01b6"+
		"\u019d\3\2\2\2\u01b6\u01a1\3\2\2\2\u01b6\u01a5\3\2\2\2\u01b6\u01a6\3\2"+
		"\2\2\u01b6\u01ab\3\2\2\2\u01b6\u01ad\3\2\2\2\u01b6\u01af\3\2\2\2\u01b6"+
		"\u01b2\3\2\2\2\u01b6\u01b5\3\2\2\2\u01b7?\3\2\2\2\u01b8\u01ba\7\25\2\2"+
		"\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc"+
		"\7\"\2\2\u01bc\u01bf\7N\2\2\u01bd\u01be\7\67\2\2\u01be\u01c0\5X-\2\u01bf"+
		"\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0A\3\2\2\2\u01c1\u01c2\5D#\2\u01c2"+
		"\u01c3\7\67\2\2\u01c3\u01c4\5X-\2\u01c4\u01c9\3\2\2\2\u01c5\u01c6\5D#"+
		"\2\u01c6\u01c7\t\4\2\2\u01c7\u01c9\3\2\2\2\u01c8\u01c1\3\2\2\2\u01c8\u01c5"+
		"\3\2\2\2\u01c9C\3\2\2\2\u01ca\u01cb\5X-\2\u01cb\u01cc\7\66\2\2\u01cc\u01ce"+
		"\3\2\2\2\u01cd\u01ca\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf"+
		"\u01d6\7N\2\2\u01d0\u01d1\5X-\2\u01d1\u01d2\7\62\2\2\u01d2\u01d3\5X-\2"+
		"\u01d3\u01d4\7\63\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01cd\3\2\2\2\u01d5\u01d0"+
		"\3\2\2\2\u01d6E\3\2\2\2\u01d7\u01d8\7\23\2\2\u01d8\u01d9\5T+\2\u01d9\u01dc"+
		"\5<\37\2\u01da\u01db\7\16\2\2\u01db\u01dd\5H%\2\u01dc\u01da\3\2\2\2\u01dc"+
		"\u01dd\3\2\2\2\u01ddG\3\2\2\2\u01de\u01e1\5<\37\2\u01df\u01e1\5F$\2\u01e0"+
		"\u01de\3\2\2\2\u01e0\u01df\3\2\2\2\u01e1I\3\2\2\2\u01e2\u01ed\5P)\2\u01e3"+
		"\u01e5\5L\'\2\u01e4\u01e3\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\3\2"+
		"\2\2\u01e6\u01e7\7\64\2\2\u01e7\u01e8\5X-\2\u01e8\u01ea\7\64\2\2\u01e9"+
		"\u01eb\5N(\2\u01ea\u01e9\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ed\3\2\2"+
		"\2\u01ec\u01e2\3\2\2\2\u01ec\u01e4\3\2\2\2\u01edK\3\2\2\2\u01ee\u01f2"+
		"\5@!\2\u01ef\u01f2\5B\"\2\u01f0\u01f2\5X-\2\u01f1\u01ee\3\2\2\2\u01f1"+
		"\u01ef\3\2\2\2\u01f1\u01f0\3\2\2\2\u01f2M\3\2\2\2\u01f3\u01f6\5B\"\2\u01f4"+
		"\u01f6\5X-\2\u01f5\u01f3\3\2\2\2\u01f5\u01f4\3\2\2\2\u01f6O\3\2\2\2\u01f7"+
		"\u01f8\7\"\2\2\u01f8\u01fb\7N\2\2\u01f9\u01fa\7\65\2\2\u01fa\u01fc\7N"+
		"\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd"+
		"\u01fe\7=\2\2\u01fe\u01ff\5X-\2\u01ffQ\3\2\2\2\u0200\u0201\7\b\2\2\u0201"+
		"\u0202\5X-\2\u0202\u0203\7=\2\2\u0203\u020c\3\2\2\2\u0204\u0205\7\b\2"+
		"\2\u0205\u0206\5,\27\2\u0206\u0207\7N\2\2\u0207\u0208\7=\2\2\u0208\u020c"+
		"\3\2\2\2\u0209\u020a\7\f\2\2\u020a\u020c\7=\2\2\u020b\u0200\3\2\2\2\u020b"+
		"\u0204\3\2\2\2\u020b\u0209\3\2\2\2\u020cS\3\2\2\2\u020d\u020e\7.\2\2\u020e"+
		"\u020f\5X-\2\u020f\u0210\7/\2\2\u0210U\3\2\2\2\u0211\u0216\5X-\2\u0212"+
		"\u0213\7\65\2\2\u0213\u0215\5X-\2\u0214\u0212\3\2\2\2\u0215\u0218\3\2"+
		"\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217W\3\2\2\2\u0218\u0216"+
		"\3\2\2\2\u0219\u021a\b-\1\2\u021a\u0225\5Z.\2\u021b\u021c\7\31\2\2\u021c"+
		"\u0225\5\\/\2\u021d\u021e\t\5\2\2\u021e\u0225\5X-\20\u021f\u0220\t\6\2"+
		"\2\u0220\u0225\5X-\17\u0221\u0222\7!\2\2\u0222\u0223\7\66\2\2\u0223\u0225"+
		"\7N\2\2\u0224\u0219\3\2\2\2\u0224\u021b\3\2\2\2\u0224\u021d\3\2\2\2\u0224"+
		"\u021f\3\2\2\2\u0224\u0221\3\2\2\2\u0225\u025a\3\2\2\2\u0226\u0227\f\16"+
		"\2\2\u0227\u0228\t\7\2\2\u0228\u0259\5X-\17\u0229\u022a\f\r\2\2\u022a"+
		"\u022b\t\5\2\2\u022b\u0259\5X-\16\u022c\u022d\f\f\2\2\u022d\u022e\t\b"+
		"\2\2\u022e\u0259\5X-\r\u022f\u0230\f\13\2\2\u0230\u0231\t\t\2\2\u0231"+
		"\u0259\5X-\f\u0232\u0233\f\n\2\2\u0233\u0234\t\n\2\2\u0234\u0259\5X-\13"+
		"\u0235\u0236\f\t\2\2\u0236\u0237\7J\2\2\u0237\u0259\5X-\n\u0238\u0239"+
		"\f\b\2\2\u0239\u023a\7L\2\2\u023a\u0259\5X-\t\u023b\u023c\f\7\2\2\u023c"+
		"\u023d\7K\2\2\u023d\u0259\5X-\b\u023e\u023f\f\6\2\2\u023f\u0240\7B\2\2"+
		"\u0240\u0259\5X-\7\u0241\u0242\f\5\2\2\u0242\u0243\7C\2\2\u0243\u0259"+
		"\5X-\6\u0244\u0245\f\4\2\2\u0245\u0246\7<\2\2\u0246\u0247\5X-\2\u0247"+
		"\u0248\7=\2\2\u0248\u0249\5X-\5\u0249\u0259\3\2\2\2\u024a\u024b\f\24\2"+
		"\2\u024b\u024c\7\66\2\2\u024c\u0259\7N\2\2\u024d\u024e\f\23\2\2\u024e"+
		"\u024f\7\62\2\2\u024f\u0250\5X-\2\u0250\u0251\7\63\2\2\u0251\u0259\3\2"+
		"\2\2\u0252\u0253\f\22\2\2\u0253\u0255\7.\2\2\u0254\u0256\5V,\2\u0255\u0254"+
		"\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0259\7/\2\2\u0258"+
		"\u0226\3\2\2\2\u0258\u0229\3\2\2\2\u0258\u022c\3\2\2\2\u0258\u022f\3\2"+
		"\2\2\u0258\u0232\3\2\2\2\u0258\u0235\3\2\2\2\u0258\u0238\3\2\2\2\u0258"+
		"\u023b\3\2\2\2\u0258\u023e\3\2\2\2\u0258\u0241\3\2\2\2\u0258\u0244\3\2"+
		"\2\2\u0258\u024a\3\2\2\2\u0258\u024d\3\2\2\2\u0258\u0252\3\2\2\2\u0259"+
		"\u025c\3\2\2\2\u025a\u0258\3\2\2\2\u025a\u025b\3\2\2\2\u025bY\3\2\2\2"+
		"\u025c\u025a\3\2\2\2\u025d\u0262\5T+\2\u025e\u0262\7 \2\2\u025f\u0262"+
		"\5f\64\2\u0260\u0262\7N\2\2\u0261\u025d\3\2\2\2\u0261\u025e\3\2\2\2\u0261"+
		"\u025f\3\2\2\2\u0261\u0260\3\2\2\2\u0262[\3\2\2\2\u0263\u0266\5,\27\2"+
		"\u0264\u0267\5^\60\2\u0265\u0267\5`\61\2\u0266\u0264\3\2\2\2\u0266\u0265"+
		"\3\2\2\2\u0267\u026a\3\2\2\2\u0268\u026a\5h\65\2\u0269\u0263\3\2\2\2\u0269"+
		"\u0268\3\2\2\2\u026a]\3\2\2\2\u026b\u026c\7\62\2\2\u026c\u026d\7\63\2"+
		"\2\u026d\u026f\7\60\2\2\u026e\u0270\5V,\2\u026f\u026e\3\2\2\2\u026f\u0270"+
		"\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u027e\7\61\2\2\u0272\u0273\7\62\2\2"+
		"\u0273\u0274\5X-\2\u0274\u0275\7\63\2\2\u0275\u027e\3\2\2\2\u0276\u0277"+
		"\7\62\2\2\u0277\u0278\7\t\2\2\u0278\u0279\5,\27\2\u0279\u027b\7\63\2\2"+
		"\u027a\u027c\5b\62\2\u027b\u027a\3\2\2\2\u027b\u027c\3\2\2\2\u027c\u027e"+
		"\3\2\2\2\u027d\u026b\3\2\2\2\u027d\u0272\3\2\2\2\u027d\u0276\3\2\2\2\u027e"+
		"_\3\2\2\2\u027f\u0281\7.\2\2\u0280\u0282\5V,\2\u0281\u0280\3\2\2\2\u0281"+
		"\u0282\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0285\7/\2\2\u0284\u0286\5\24"+
		"\13\2\u0285\u0284\3\2\2\2\u0285\u0286\3\2\2\2\u0286a\3\2\2\2\u0287\u0288"+
		"\7\60\2\2\u0288\u0295\7\61\2\2\u0289\u028a\7\60\2\2\u028a\u028f\5d\63"+
		"\2\u028b\u028c\7\65\2\2\u028c\u028e\5d\63\2\u028d\u028b\3\2\2\2\u028e"+
		"\u0291\3\2\2\2\u028f\u028d\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0292\3\2"+
		"\2\2\u0291\u028f\3\2\2\2\u0292\u0293\7\61\2\2\u0293\u0295\3\2\2\2\u0294"+
		"\u0287\3\2\2\2\u0294\u0289\3\2\2\2\u0295c\3\2\2\2\u0296\u0297\5X-\2\u0297"+
		"\u0298\7=\2\2\u0298\u0299\5X-\2\u0299e\3\2\2\2\u029a\u029b\t\13\2\2\u029b"+
		"g\3\2\2\2\u029c\u02a0\7\60\2\2\u029d\u029f\5j\66\2\u029e\u029d\3\2\2\2"+
		"\u029f\u02a2\3\2\2\2\u02a0\u029e\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a3"+
		"\3\2\2\2\u02a2\u02a0\3\2\2\2\u02a3\u02a4\7\61\2\2\u02a4i\3\2\2\2\u02a5"+
		"\u02a6\7N\2\2\u02a6\u02a7\7=\2\2\u02a7\u02a8\5X-\2\u02a8\u02a9\7\64\2"+
		"\2\u02a9\u02ac\3\2\2\2\u02aa\u02ac\5\30\r\2\u02ab\u02a5\3\2\2\2\u02ab"+
		"\u02aa\3\2\2\2\u02ack\3\2\2\2Kmrx\u0085\u008b\u0090\u0096\u0099\u00a5"+
		"\u00b0\u00b6\u00be\u00c7\u00d2\u00dd\u00e8\u00ef\u00f6\u00ff\u0104\u010f"+
		"\u0113\u011a\u0120\u0125\u012b\u012f\u0133\u0138\u013d\u0146\u0150\u0152"+
		"\u0159\u015e\u0166\u016f\u0178\u0183\u018a\u01a8\u01b6\u01b9\u01bf\u01c8"+
		"\u01cd\u01d5\u01dc\u01e0\u01e4\u01ea\u01ec\u01f1\u01f5\u01fb\u020b\u0216"+
		"\u0224\u0255\u0258\u025a\u0261\u0266\u0269\u026f\u027b\u027d\u0281\u0285"+
		"\u028f\u0294\u02a0\u02ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}