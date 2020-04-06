// Generated from Sanka.g4 by ANTLR 4.7.2

    package sanka.antlr4;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SankaLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "BOOLEAN", "BREAK", "BYTE", "CASE", "CLASS", "CONST", 
			"CONTINUE", "DEFAULT", "DOUBLE", "ELSE", "EXPORT", "EXTENDS", "FLOAT", 
			"FOR", "IF", "IMPORT", "INLINE", "INT", "INTERFACE", "LONG", "NEW", "PACKAGE", 
			"PRIVATE", "RETURN", "SHORT", "STATIC", "SWITCH", "THIS", "SUPER", "VAR", 
			"VOID", "WHILE", "C__INCLUDE", "C__FIELD", "C__STMT", "IntegerLiteral", 
			"DecimalIntegerLiteral", "HexIntegerLiteral", "OctalIntegerLiteral", 
			"BinaryIntegerLiteral", "IntegerTypeSuffix", "DecimalNumeral", "Digits", 
			"Digit", "NonZeroDigit", "DigitOrUnderscore", "Underscores", "HexNumeral", 
			"HexDigits", "HexDigit", "HexDigitOrUnderscore", "OctalNumeral", "OctalDigits", 
			"OctalDigit", "OctalDigitOrUnderscore", "BinaryNumeral", "BinaryDigits", 
			"BinaryDigit", "BinaryDigitOrUnderscore", "FloatingPointLiteral", "DecimalFloatingPointLiteral", 
			"ExponentPart", "ExponentIndicator", "SignedInteger", "Sign", "FloatTypeSuffix", 
			"HexadecimalFloatingPointLiteral", "HexSignificand", "BinaryExponent", 
			"BinaryExponentIndicator", "BooleanLiteral", "CharacterLiteral", "SingleCharacter", 
			"StringLiteral", "StringCharacters", "StringCharacter", "EscapeSequence", 
			"OctalEscape", "UnicodeEscape", "ZeroToThree", "NullLiteral", "LPAREN", 
			"RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", 
			"ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", 
			"LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", 
			"DIV", "BITAND", "BITOR", "CARET", "MOD", "Identifier", "JavaLetter", 
			"JavaLetterOrDigit", "ELLIPSIS", "WS", "COMMENT", "LINE_COMMENT"
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


	public SankaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Sanka.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2R\u0367\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!"+
		"\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\5\'\u01e5\n\'\3(\3(\5(\u01e9\n(\3)\3)\5)\u01ed\n)\3*\3*\5*\u01f1"+
		"\n*\3+\3+\5+\u01f5\n+\3,\3,\3-\3-\3-\5-\u01fc\n-\3-\3-\3-\5-\u0201\n-"+
		"\5-\u0203\n-\3.\3.\7.\u0207\n.\f.\16.\u020a\13.\3.\5.\u020d\n.\3/\3/\5"+
		"/\u0211\n/\3\60\3\60\3\61\3\61\5\61\u0217\n\61\3\62\6\62\u021a\n\62\r"+
		"\62\16\62\u021b\3\63\3\63\3\63\3\63\3\64\3\64\7\64\u0224\n\64\f\64\16"+
		"\64\u0227\13\64\3\64\5\64\u022a\n\64\3\65\3\65\3\66\3\66\5\66\u0230\n"+
		"\66\3\67\3\67\5\67\u0234\n\67\3\67\3\67\38\38\78\u023a\n8\f8\168\u023d"+
		"\138\38\58\u0240\n8\39\39\3:\3:\5:\u0246\n:\3;\3;\3;\3;\3<\3<\7<\u024e"+
		"\n<\f<\16<\u0251\13<\3<\5<\u0254\n<\3=\3=\3>\3>\5>\u025a\n>\3?\3?\5?\u025e"+
		"\n?\3@\3@\3@\5@\u0263\n@\3@\5@\u0266\n@\3@\5@\u0269\n@\3@\3@\3@\5@\u026e"+
		"\n@\3@\5@\u0271\n@\3@\3@\3@\5@\u0276\n@\3@\3@\3@\5@\u027b\n@\3A\3A\3A"+
		"\3B\3B\3C\5C\u0283\nC\3C\3C\3D\3D\3E\3E\3F\3F\3F\5F\u028e\nF\3G\3G\5G"+
		"\u0292\nG\3G\3G\3G\5G\u0297\nG\3G\3G\5G\u029b\nG\3H\3H\3H\3I\3I\3J\3J"+
		"\3J\3J\3J\3J\3J\3J\3J\5J\u02ab\nJ\3K\3K\3K\3K\3K\3K\3K\3K\5K\u02b5\nK"+
		"\3L\3L\3M\3M\5M\u02bb\nM\3M\3M\3N\6N\u02c0\nN\rN\16N\u02c1\3O\3O\5O\u02c6"+
		"\nO\3P\3P\3P\3P\5P\u02cc\nP\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\5Q\u02d9"+
		"\nQ\3R\3R\3R\3R\3R\3R\3R\3S\3S\3T\3T\3T\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X"+
		"\3Y\3Y\3Z\3Z\3[\3[\3\\\3\\\3]\3]\3^\3^\3_\3_\3`\3`\3a\3a\3b\3b\3c\3c\3"+
		"d\3d\3e\3e\3e\3f\3f\3f\3g\3g\3g\3h\3h\3h\3i\3i\3i\3j\3j\3j\3k\3k\3k\3"+
		"l\3l\3l\3m\3m\3n\3n\3o\3o\3p\3p\3q\3q\3r\3r\3s\3s\3t\3t\3u\3u\7u\u0333"+
		"\nu\fu\16u\u0336\13u\3v\3v\3v\3v\5v\u033c\nv\3w\3w\3w\3w\5w\u0342\nw\3"+
		"x\3x\3x\3x\3y\6y\u0349\ny\ry\16y\u034a\3y\3y\3z\3z\3z\3z\7z\u0353\nz\f"+
		"z\16z\u0356\13z\3z\3z\3z\3z\3z\3{\3{\3{\3{\7{\u0361\n{\f{\16{\u0364\13"+
		"{\3{\3{\3\u0354\2|\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2"+
		"c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2})\177\2\u0081\2\u0083\2\u0085"+
		"\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093*\u0095+\u0097"+
		"\2\u0099,\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a5\2\u00a7-\u00a9"+
		".\u00ab/\u00ad\60\u00af\61\u00b1\62\u00b3\63\u00b5\64\u00b7\65\u00b9\66"+
		"\u00bb\67\u00bd8\u00bf9\u00c1:\u00c3;\u00c5<\u00c7=\u00c9>\u00cb?\u00cd"+
		"@\u00cfA\u00d1B\u00d3C\u00d5D\u00d7E\u00d9F\u00dbG\u00ddH\u00dfI\u00e1"+
		"J\u00e3K\u00e5L\u00e7M\u00e9N\u00eb\2\u00ed\2\u00efO\u00f1P\u00f3Q\u00f5"+
		"R\3\2\30\4\2NNnn\3\2\63;\4\2ZZzz\5\2\62;CHch\3\2\629\4\2DDdd\3\2\62\63"+
		"\4\2GGgg\4\2--//\6\2FFHHffhh\4\2RRrr\6\2\f\f\17\17))^^\4\2$$^^\n\2$$)"+
		")^^ddhhppttvv\3\2\62\65\6\2&&C\\aac|\4\2\2\u0081\ud802\udc01\3\2\ud802"+
		"\udc01\3\2\udc02\ue001\7\2&&\62;C\\aac|\5\2\13\f\16\17\"\"\4\2\f\f\17"+
		"\17\2\u0375\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2}\3\2\2\2\2\u0093\3\2\2"+
		"\2\2\u0095\3\2\2\2\2\u0099\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab"+
		"\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2"+
		"\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd"+
		"\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2"+
		"\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf"+
		"\3\2\2\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2\2\2\u00d7\3\2\2"+
		"\2\2\u00d9\3\2\2\2\2\u00db\3\2\2\2\2\u00dd\3\2\2\2\2\u00df\3\2\2\2\2\u00e1"+
		"\3\2\2\2\2\u00e3\3\2\2\2\2\u00e5\3\2\2\2\2\u00e7\3\2\2\2\2\u00e9\3\2\2"+
		"\2\2\u00ef\3\2\2\2\2\u00f1\3\2\2\2\2\u00f3\3\2\2\2\2\u00f5\3\2\2\2\3\u00f7"+
		"\3\2\2\2\5\u00fa\3\2\2\2\7\u00fd\3\2\2\2\t\u0105\3\2\2\2\13\u010b\3\2"+
		"\2\2\r\u0110\3\2\2\2\17\u0115\3\2\2\2\21\u011b\3\2\2\2\23\u0121\3\2\2"+
		"\2\25\u012a\3\2\2\2\27\u0132\3\2\2\2\31\u0139\3\2\2\2\33\u013e\3\2\2\2"+
		"\35\u0145\3\2\2\2\37\u014d\3\2\2\2!\u0153\3\2\2\2#\u0157\3\2\2\2%\u015a"+
		"\3\2\2\2\'\u0161\3\2\2\2)\u0168\3\2\2\2+\u016c\3\2\2\2-\u0176\3\2\2\2"+
		"/\u017b\3\2\2\2\61\u017f\3\2\2\2\63\u0187\3\2\2\2\65\u018f\3\2\2\2\67"+
		"\u0196\3\2\2\29\u019c\3\2\2\2;\u01a3\3\2\2\2=\u01aa\3\2\2\2?\u01af\3\2"+
		"\2\2A\u01b5\3\2\2\2C\u01b9\3\2\2\2E\u01be\3\2\2\2G\u01c4\3\2\2\2I\u01cf"+
		"\3\2\2\2K\u01d8\3\2\2\2M\u01e4\3\2\2\2O\u01e6\3\2\2\2Q\u01ea\3\2\2\2S"+
		"\u01ee\3\2\2\2U\u01f2\3\2\2\2W\u01f6\3\2\2\2Y\u0202\3\2\2\2[\u0204\3\2"+
		"\2\2]\u0210\3\2\2\2_\u0212\3\2\2\2a\u0216\3\2\2\2c\u0219\3\2\2\2e\u021d"+
		"\3\2\2\2g\u0221\3\2\2\2i\u022b\3\2\2\2k\u022f\3\2\2\2m\u0231\3\2\2\2o"+
		"\u0237\3\2\2\2q\u0241\3\2\2\2s\u0245\3\2\2\2u\u0247\3\2\2\2w\u024b\3\2"+
		"\2\2y\u0255\3\2\2\2{\u0259\3\2\2\2}\u025d\3\2\2\2\177\u027a\3\2\2\2\u0081"+
		"\u027c\3\2\2\2\u0083\u027f\3\2\2\2\u0085\u0282\3\2\2\2\u0087\u0286\3\2"+
		"\2\2\u0089\u0288\3\2\2\2\u008b\u028a\3\2\2\2\u008d\u029a\3\2\2\2\u008f"+
		"\u029c\3\2\2\2\u0091\u029f\3\2\2\2\u0093\u02aa\3\2\2\2\u0095\u02b4\3\2"+
		"\2\2\u0097\u02b6\3\2\2\2\u0099\u02b8\3\2\2\2\u009b\u02bf\3\2\2\2\u009d"+
		"\u02c5\3\2\2\2\u009f\u02cb\3\2\2\2\u00a1\u02d8\3\2\2\2\u00a3\u02da\3\2"+
		"\2\2\u00a5\u02e1\3\2\2\2\u00a7\u02e3\3\2\2\2\u00a9\u02e8\3\2\2\2\u00ab"+
		"\u02ea\3\2\2\2\u00ad\u02ec\3\2\2\2\u00af\u02ee\3\2\2\2\u00b1\u02f0\3\2"+
		"\2\2\u00b3\u02f2\3\2\2\2\u00b5\u02f4\3\2\2\2\u00b7\u02f6\3\2\2\2\u00b9"+
		"\u02f8\3\2\2\2\u00bb\u02fa\3\2\2\2\u00bd\u02fc\3\2\2\2\u00bf\u02fe\3\2"+
		"\2\2\u00c1\u0300\3\2\2\2\u00c3\u0302\3\2\2\2\u00c5\u0304\3\2\2\2\u00c7"+
		"\u0306\3\2\2\2\u00c9\u0308\3\2\2\2\u00cb\u030b\3\2\2\2\u00cd\u030e\3\2"+
		"\2\2\u00cf\u0311\3\2\2\2\u00d1\u0314\3\2\2\2\u00d3\u0317\3\2\2\2\u00d5"+
		"\u031a\3\2\2\2\u00d7\u031d\3\2\2\2\u00d9\u0320\3\2\2\2\u00db\u0322\3\2"+
		"\2\2\u00dd\u0324\3\2\2\2\u00df\u0326\3\2\2\2\u00e1\u0328\3\2\2\2\u00e3"+
		"\u032a\3\2\2\2\u00e5\u032c\3\2\2\2\u00e7\u032e\3\2\2\2\u00e9\u0330\3\2"+
		"\2\2\u00eb\u033b\3\2\2\2\u00ed\u0341\3\2\2\2\u00ef\u0343\3\2\2\2\u00f1"+
		"\u0348\3\2\2\2\u00f3\u034e\3\2\2\2\u00f5\u035c\3\2\2\2\u00f7\u00f8\7>"+
		"\2\2\u00f8\u00f9\7>\2\2\u00f9\4\3\2\2\2\u00fa\u00fb\7@\2\2\u00fb\u00fc"+
		"\7@\2\2\u00fc\6\3\2\2\2\u00fd\u00fe\7d\2\2\u00fe\u00ff\7q\2\2\u00ff\u0100"+
		"\7q\2\2\u0100\u0101\7n\2\2\u0101\u0102\7g\2\2\u0102\u0103\7c\2\2\u0103"+
		"\u0104\7p\2\2\u0104\b\3\2\2\2\u0105\u0106\7d\2\2\u0106\u0107\7t\2\2\u0107"+
		"\u0108\7g\2\2\u0108\u0109\7c\2\2\u0109\u010a\7m\2\2\u010a\n\3\2\2\2\u010b"+
		"\u010c\7d\2\2\u010c\u010d\7{\2\2\u010d\u010e\7v\2\2\u010e\u010f\7g\2\2"+
		"\u010f\f\3\2\2\2\u0110\u0111\7e\2\2\u0111\u0112\7c\2\2\u0112\u0113\7u"+
		"\2\2\u0113\u0114\7g\2\2\u0114\16\3\2\2\2\u0115\u0116\7e\2\2\u0116\u0117"+
		"\7n\2\2\u0117\u0118\7c\2\2\u0118\u0119\7u\2\2\u0119\u011a\7u\2\2\u011a"+
		"\20\3\2\2\2\u011b\u011c\7e\2\2\u011c\u011d\7q\2\2\u011d\u011e\7p\2\2\u011e"+
		"\u011f\7u\2\2\u011f\u0120\7v\2\2\u0120\22\3\2\2\2\u0121\u0122\7e\2\2\u0122"+
		"\u0123\7q\2\2\u0123\u0124\7p\2\2\u0124\u0125\7v\2\2\u0125\u0126\7k\2\2"+
		"\u0126\u0127\7p\2\2\u0127\u0128\7w\2\2\u0128\u0129\7g\2\2\u0129\24\3\2"+
		"\2\2\u012a\u012b\7f\2\2\u012b\u012c\7g\2\2\u012c\u012d\7h\2\2\u012d\u012e"+
		"\7c\2\2\u012e\u012f\7w\2\2\u012f\u0130\7n\2\2\u0130\u0131\7v\2\2\u0131"+
		"\26\3\2\2\2\u0132\u0133\7f\2\2\u0133\u0134\7q\2\2\u0134\u0135\7w\2\2\u0135"+
		"\u0136\7d\2\2\u0136\u0137\7n\2\2\u0137\u0138\7g\2\2\u0138\30\3\2\2\2\u0139"+
		"\u013a\7g\2\2\u013a\u013b\7n\2\2\u013b\u013c\7u\2\2\u013c\u013d\7g\2\2"+
		"\u013d\32\3\2\2\2\u013e\u013f\7g\2\2\u013f\u0140\7z\2\2\u0140\u0141\7"+
		"r\2\2\u0141\u0142\7q\2\2\u0142\u0143\7t\2\2\u0143\u0144\7v\2\2\u0144\34"+
		"\3\2\2\2\u0145\u0146\7g\2\2\u0146\u0147\7z\2\2\u0147\u0148\7v\2\2\u0148"+
		"\u0149\7g\2\2\u0149\u014a\7p\2\2\u014a\u014b\7f\2\2\u014b\u014c\7u\2\2"+
		"\u014c\36\3\2\2\2\u014d\u014e\7h\2\2\u014e\u014f\7n\2\2\u014f\u0150\7"+
		"q\2\2\u0150\u0151\7c\2\2\u0151\u0152\7v\2\2\u0152 \3\2\2\2\u0153\u0154"+
		"\7h\2\2\u0154\u0155\7q\2\2\u0155\u0156\7t\2\2\u0156\"\3\2\2\2\u0157\u0158"+
		"\7k\2\2\u0158\u0159\7h\2\2\u0159$\3\2\2\2\u015a\u015b\7k\2\2\u015b\u015c"+
		"\7o\2\2\u015c\u015d\7r\2\2\u015d\u015e\7q\2\2\u015e\u015f\7t\2\2\u015f"+
		"\u0160\7v\2\2\u0160&\3\2\2\2\u0161\u0162\7k\2\2\u0162\u0163\7p\2\2\u0163"+
		"\u0164\7n\2\2\u0164\u0165\7k\2\2\u0165\u0166\7p\2\2\u0166\u0167\7g\2\2"+
		"\u0167(\3\2\2\2\u0168\u0169\7k\2\2\u0169\u016a\7p\2\2\u016a\u016b\7v\2"+
		"\2\u016b*\3\2\2\2\u016c\u016d\7k\2\2\u016d\u016e\7p\2\2\u016e\u016f\7"+
		"v\2\2\u016f\u0170\7g\2\2\u0170\u0171\7t\2\2\u0171\u0172\7h\2\2\u0172\u0173"+
		"\7c\2\2\u0173\u0174\7e\2\2\u0174\u0175\7g\2\2\u0175,\3\2\2\2\u0176\u0177"+
		"\7n\2\2\u0177\u0178\7q\2\2\u0178\u0179\7p\2\2\u0179\u017a\7i\2\2\u017a"+
		".\3\2\2\2\u017b\u017c\7p\2\2\u017c\u017d\7g\2\2\u017d\u017e\7y\2\2\u017e"+
		"\60\3\2\2\2\u017f\u0180\7r\2\2\u0180\u0181\7c\2\2\u0181\u0182\7e\2\2\u0182"+
		"\u0183\7m\2\2\u0183\u0184\7c\2\2\u0184\u0185\7i\2\2\u0185\u0186\7g\2\2"+
		"\u0186\62\3\2\2\2\u0187\u0188\7r\2\2\u0188\u0189\7t\2\2\u0189\u018a\7"+
		"k\2\2\u018a\u018b\7x\2\2\u018b\u018c\7c\2\2\u018c\u018d\7v\2\2\u018d\u018e"+
		"\7g\2\2\u018e\64\3\2\2\2\u018f\u0190\7t\2\2\u0190\u0191\7g\2\2\u0191\u0192"+
		"\7v\2\2\u0192\u0193\7w\2\2\u0193\u0194\7t\2\2\u0194\u0195\7p\2\2\u0195"+
		"\66\3\2\2\2\u0196\u0197\7u\2\2\u0197\u0198\7j\2\2\u0198\u0199\7q\2\2\u0199"+
		"\u019a\7t\2\2\u019a\u019b\7v\2\2\u019b8\3\2\2\2\u019c\u019d\7u\2\2\u019d"+
		"\u019e\7v\2\2\u019e\u019f\7c\2\2\u019f\u01a0\7v\2\2\u01a0\u01a1\7k\2\2"+
		"\u01a1\u01a2\7e\2\2\u01a2:\3\2\2\2\u01a3\u01a4\7u\2\2\u01a4\u01a5\7y\2"+
		"\2\u01a5\u01a6\7k\2\2\u01a6\u01a7\7v\2\2\u01a7\u01a8\7e\2\2\u01a8\u01a9"+
		"\7j\2\2\u01a9<\3\2\2\2\u01aa\u01ab\7v\2\2\u01ab\u01ac\7j\2\2\u01ac\u01ad"+
		"\7k\2\2\u01ad\u01ae\7u\2\2\u01ae>\3\2\2\2\u01af\u01b0\7u\2\2\u01b0\u01b1"+
		"\7w\2\2\u01b1\u01b2\7r\2\2\u01b2\u01b3\7g\2\2\u01b3\u01b4\7t\2\2\u01b4"+
		"@\3\2\2\2\u01b5\u01b6\7x\2\2\u01b6\u01b7\7c\2\2\u01b7\u01b8\7t\2\2\u01b8"+
		"B\3\2\2\2\u01b9\u01ba\7x\2\2\u01ba\u01bb\7q\2\2\u01bb\u01bc\7k\2\2\u01bc"+
		"\u01bd\7f\2\2\u01bdD\3\2\2\2\u01be\u01bf\7y\2\2\u01bf\u01c0\7j\2\2\u01c0"+
		"\u01c1\7k\2\2\u01c1\u01c2\7n\2\2\u01c2\u01c3\7g\2\2\u01c3F\3\2\2\2\u01c4"+
		"\u01c5\7e\2\2\u01c5\u01c6\7a\2\2\u01c6\u01c7\7a\2\2\u01c7\u01c8\7k\2\2"+
		"\u01c8\u01c9\7p\2\2\u01c9\u01ca\7e\2\2\u01ca\u01cb\7n\2\2\u01cb\u01cc"+
		"\7w\2\2\u01cc\u01cd\7f\2\2\u01cd\u01ce\7g\2\2\u01ceH\3\2\2\2\u01cf\u01d0"+
		"\7e\2\2\u01d0\u01d1\7a\2\2\u01d1\u01d2\7a\2\2\u01d2\u01d3\7h\2\2\u01d3"+
		"\u01d4\7k\2\2\u01d4\u01d5\7g\2\2\u01d5\u01d6\7n\2\2\u01d6\u01d7\7f\2\2"+
		"\u01d7J\3\2\2\2\u01d8\u01d9\7e\2\2\u01d9\u01da\7a\2\2\u01da\u01db\7a\2"+
		"\2\u01db\u01dc\7u\2\2\u01dc\u01dd\7v\2\2\u01dd\u01de\7o\2\2\u01de\u01df"+
		"\7v\2\2\u01dfL\3\2\2\2\u01e0\u01e5\5O(\2\u01e1\u01e5\5Q)\2\u01e2\u01e5"+
		"\5S*\2\u01e3\u01e5\5U+\2\u01e4\u01e0\3\2\2\2\u01e4\u01e1\3\2\2\2\u01e4"+
		"\u01e2\3\2\2\2\u01e4\u01e3\3\2\2\2\u01e5N\3\2\2\2\u01e6\u01e8\5Y-\2\u01e7"+
		"\u01e9\5W,\2\u01e8\u01e7\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9P\3\2\2\2\u01ea"+
		"\u01ec\5e\63\2\u01eb\u01ed\5W,\2\u01ec\u01eb\3\2\2\2\u01ec\u01ed\3\2\2"+
		"\2\u01edR\3\2\2\2\u01ee\u01f0\5m\67\2\u01ef\u01f1\5W,\2\u01f0\u01ef\3"+
		"\2\2\2\u01f0\u01f1\3\2\2\2\u01f1T\3\2\2\2\u01f2\u01f4\5u;\2\u01f3\u01f5"+
		"\5W,\2\u01f4\u01f3\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5V\3\2\2\2\u01f6\u01f7"+
		"\t\2\2\2\u01f7X\3\2\2\2\u01f8\u0203\7\62\2\2\u01f9\u0200\5_\60\2\u01fa"+
		"\u01fc\5[.\2\u01fb\u01fa\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u0201\3\2\2"+
		"\2\u01fd\u01fe\5c\62\2\u01fe\u01ff\5[.\2\u01ff\u0201\3\2\2\2\u0200\u01fb"+
		"\3\2\2\2\u0200\u01fd\3\2\2\2\u0201\u0203\3\2\2\2\u0202\u01f8\3\2\2\2\u0202"+
		"\u01f9\3\2\2\2\u0203Z\3\2\2\2\u0204\u020c\5]/\2\u0205\u0207\5a\61\2\u0206"+
		"\u0205\3\2\2\2\u0207\u020a\3\2\2\2\u0208\u0206\3\2\2\2\u0208\u0209\3\2"+
		"\2\2\u0209\u020b\3\2\2\2\u020a\u0208\3\2\2\2\u020b\u020d\5]/\2\u020c\u0208"+
		"\3\2\2\2\u020c\u020d\3\2\2\2\u020d\\\3\2\2\2\u020e\u0211\7\62\2\2\u020f"+
		"\u0211\5_\60\2\u0210\u020e\3\2\2\2\u0210\u020f\3\2\2\2\u0211^\3\2\2\2"+
		"\u0212\u0213\t\3\2\2\u0213`\3\2\2\2\u0214\u0217\5]/\2\u0215\u0217\7a\2"+
		"\2\u0216\u0214\3\2\2\2\u0216\u0215\3\2\2\2\u0217b\3\2\2\2\u0218\u021a"+
		"\7a\2\2\u0219\u0218\3\2\2\2\u021a\u021b\3\2\2\2\u021b\u0219\3\2\2\2\u021b"+
		"\u021c\3\2\2\2\u021cd\3\2\2\2\u021d\u021e\7\62\2\2\u021e\u021f\t\4\2\2"+
		"\u021f\u0220\5g\64\2\u0220f\3\2\2\2\u0221\u0229\5i\65\2\u0222\u0224\5"+
		"k\66\2\u0223\u0222\3\2\2\2\u0224\u0227\3\2\2\2\u0225\u0223\3\2\2\2\u0225"+
		"\u0226\3\2\2\2\u0226\u0228\3\2\2\2\u0227\u0225\3\2\2\2\u0228\u022a\5i"+
		"\65\2\u0229\u0225\3\2\2\2\u0229\u022a\3\2\2\2\u022ah\3\2\2\2\u022b\u022c"+
		"\t\5\2\2\u022cj\3\2\2\2\u022d\u0230\5i\65\2\u022e\u0230\7a\2\2\u022f\u022d"+
		"\3\2\2\2\u022f\u022e\3\2\2\2\u0230l\3\2\2\2\u0231\u0233\7\62\2\2\u0232"+
		"\u0234\5c\62\2\u0233\u0232\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0235\3\2"+
		"\2\2\u0235\u0236\5o8\2\u0236n\3\2\2\2\u0237\u023f\5q9\2\u0238\u023a\5"+
		"s:\2\u0239\u0238\3\2\2\2\u023a\u023d\3\2\2\2\u023b\u0239\3\2\2\2\u023b"+
		"\u023c\3\2\2\2\u023c\u023e\3\2\2\2\u023d\u023b\3\2\2\2\u023e\u0240\5q"+
		"9\2\u023f\u023b\3\2\2\2\u023f\u0240\3\2\2\2\u0240p\3\2\2\2\u0241\u0242"+
		"\t\6\2\2\u0242r\3\2\2\2\u0243\u0246\5q9\2\u0244\u0246\7a\2\2\u0245\u0243"+
		"\3\2\2\2\u0245\u0244\3\2\2\2\u0246t\3\2\2\2\u0247\u0248\7\62\2\2\u0248"+
		"\u0249\t\7\2\2\u0249\u024a\5w<\2\u024av\3\2\2\2\u024b\u0253\5y=\2\u024c"+
		"\u024e\5{>\2\u024d\u024c\3\2\2\2\u024e\u0251\3\2\2\2\u024f\u024d\3\2\2"+
		"\2\u024f\u0250\3\2\2\2\u0250\u0252\3\2\2\2\u0251\u024f\3\2\2\2\u0252\u0254"+
		"\5y=\2\u0253\u024f\3\2\2\2\u0253\u0254\3\2\2\2\u0254x\3\2\2\2\u0255\u0256"+
		"\t\b\2\2\u0256z\3\2\2\2\u0257\u025a\5y=\2\u0258\u025a\7a\2\2\u0259\u0257"+
		"\3\2\2\2\u0259\u0258\3\2\2\2\u025a|\3\2\2\2\u025b\u025e\5\177@\2\u025c"+
		"\u025e\5\u008bF\2\u025d\u025b\3\2\2\2\u025d\u025c\3\2\2\2\u025e~\3\2\2"+
		"\2\u025f\u0260\5[.\2\u0260\u0262\7\60\2\2\u0261\u0263\5[.\2\u0262\u0261"+
		"\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u0265\3\2\2\2\u0264\u0266\5\u0081A"+
		"\2\u0265\u0264\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0268\3\2\2\2\u0267\u0269"+
		"\5\u0089E\2\u0268\u0267\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u027b\3\2\2"+
		"\2\u026a\u026b\7\60\2\2\u026b\u026d\5[.\2\u026c\u026e\5\u0081A\2\u026d"+
		"\u026c\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u0270\3\2\2\2\u026f\u0271\5\u0089"+
		"E\2\u0270\u026f\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u027b\3\2\2\2\u0272"+
		"\u0273\5[.\2\u0273\u0275\5\u0081A\2\u0274\u0276\5\u0089E\2\u0275\u0274"+
		"\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u027b\3\2\2\2\u0277\u0278\5[.\2\u0278"+
		"\u0279\5\u0089E\2\u0279\u027b\3\2\2\2\u027a\u025f\3\2\2\2\u027a\u026a"+
		"\3\2\2\2\u027a\u0272\3\2\2\2\u027a\u0277\3\2\2\2\u027b\u0080\3\2\2\2\u027c"+
		"\u027d\5\u0083B\2\u027d\u027e\5\u0085C\2\u027e\u0082\3\2\2\2\u027f\u0280"+
		"\t\t\2\2\u0280\u0084\3\2\2\2\u0281\u0283\5\u0087D\2\u0282\u0281\3\2\2"+
		"\2\u0282\u0283\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0285\5[.\2\u0285\u0086"+
		"\3\2\2\2\u0286\u0287\t\n\2\2\u0287\u0088\3\2\2\2\u0288\u0289\t\13\2\2"+
		"\u0289\u008a\3\2\2\2\u028a\u028b\5\u008dG\2\u028b\u028d\5\u008fH\2\u028c"+
		"\u028e\5\u0089E\2\u028d\u028c\3\2\2\2\u028d\u028e\3\2\2\2\u028e\u008c"+
		"\3\2\2\2\u028f\u0291\5e\63\2\u0290\u0292\7\60\2\2\u0291\u0290\3\2\2\2"+
		"\u0291\u0292\3\2\2\2\u0292\u029b\3\2\2\2\u0293\u0294\7\62\2\2\u0294\u0296"+
		"\t\4\2\2\u0295\u0297\5g\64\2\u0296\u0295\3\2\2\2\u0296\u0297\3\2\2\2\u0297"+
		"\u0298\3\2\2\2\u0298\u0299\7\60\2\2\u0299\u029b\5g\64\2\u029a\u028f\3"+
		"\2\2\2\u029a\u0293\3\2\2\2\u029b\u008e\3\2\2\2\u029c\u029d\5\u0091I\2"+
		"\u029d\u029e\5\u0085C\2\u029e\u0090\3\2\2\2\u029f\u02a0\t\f\2\2\u02a0"+
		"\u0092\3\2\2\2\u02a1\u02a2\7v\2\2\u02a2\u02a3\7t\2\2\u02a3\u02a4\7w\2"+
		"\2\u02a4\u02ab\7g\2\2\u02a5\u02a6\7h\2\2\u02a6\u02a7\7c\2\2\u02a7\u02a8"+
		"\7n\2\2\u02a8\u02a9\7u\2\2\u02a9\u02ab\7g\2\2\u02aa\u02a1\3\2\2\2\u02aa"+
		"\u02a5\3\2\2\2\u02ab\u0094\3\2\2\2\u02ac\u02ad\7)\2\2\u02ad\u02ae\5\u0097"+
		"L\2\u02ae\u02af\7)\2\2\u02af\u02b5\3\2\2\2\u02b0\u02b1\7)\2\2\u02b1\u02b2"+
		"\5\u009fP\2\u02b2\u02b3\7)\2\2\u02b3\u02b5\3\2\2\2\u02b4\u02ac\3\2\2\2"+
		"\u02b4\u02b0\3\2\2\2\u02b5\u0096\3\2\2\2\u02b6\u02b7\n\r\2\2\u02b7\u0098"+
		"\3\2\2\2\u02b8\u02ba\7$\2\2\u02b9\u02bb\5\u009bN\2\u02ba\u02b9\3\2\2\2"+
		"\u02ba\u02bb\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02bd\7$\2\2\u02bd\u009a"+
		"\3\2\2\2\u02be\u02c0\5\u009dO\2\u02bf\u02be\3\2\2\2\u02c0\u02c1\3\2\2"+
		"\2\u02c1\u02bf\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u009c\3\2\2\2\u02c3\u02c6"+
		"\n\16\2\2\u02c4\u02c6\5\u009fP\2\u02c5\u02c3\3\2\2\2\u02c5\u02c4\3\2\2"+
		"\2\u02c6\u009e\3\2\2\2\u02c7\u02c8\7^\2\2\u02c8\u02cc\t\17\2\2\u02c9\u02cc"+
		"\5\u00a1Q\2\u02ca\u02cc\5\u00a3R\2\u02cb\u02c7\3\2\2\2\u02cb\u02c9\3\2"+
		"\2\2\u02cb\u02ca\3\2\2\2\u02cc\u00a0\3\2\2\2\u02cd\u02ce\7^\2\2\u02ce"+
		"\u02d9\5q9\2\u02cf\u02d0\7^\2\2\u02d0\u02d1\5q9\2\u02d1\u02d2\5q9\2\u02d2"+
		"\u02d9\3\2\2\2\u02d3\u02d4\7^\2\2\u02d4\u02d5\5\u00a5S\2\u02d5\u02d6\5"+
		"q9\2\u02d6\u02d7\5q9\2\u02d7\u02d9\3\2\2\2\u02d8\u02cd\3\2\2\2\u02d8\u02cf"+
		"\3\2\2\2\u02d8\u02d3\3\2\2\2\u02d9\u00a2\3\2\2\2\u02da\u02db\7^\2\2\u02db"+
		"\u02dc\7w\2\2\u02dc\u02dd\5i\65\2\u02dd\u02de\5i\65\2\u02de\u02df\5i\65"+
		"\2\u02df\u02e0\5i\65\2\u02e0\u00a4\3\2\2\2\u02e1\u02e2\t\20\2\2\u02e2"+
		"\u00a6\3\2\2\2\u02e3\u02e4\7p\2\2\u02e4\u02e5\7w\2\2\u02e5\u02e6\7n\2"+
		"\2\u02e6\u02e7\7n\2\2\u02e7\u00a8\3\2\2\2\u02e8\u02e9\7*\2\2\u02e9\u00aa"+
		"\3\2\2\2\u02ea\u02eb\7+\2\2\u02eb\u00ac\3\2\2\2\u02ec\u02ed\7}\2\2\u02ed"+
		"\u00ae\3\2\2\2\u02ee\u02ef\7\177\2\2\u02ef\u00b0\3\2\2\2\u02f0\u02f1\7"+
		"]\2\2\u02f1\u00b2\3\2\2\2\u02f2\u02f3\7_\2\2\u02f3\u00b4\3\2\2\2\u02f4"+
		"\u02f5\7=\2\2\u02f5\u00b6\3\2\2\2\u02f6\u02f7\7.\2\2\u02f7\u00b8\3\2\2"+
		"\2\u02f8\u02f9\7\60\2\2\u02f9\u00ba\3\2\2\2\u02fa\u02fb\7?\2\2\u02fb\u00bc"+
		"\3\2\2\2\u02fc\u02fd\7@\2\2\u02fd\u00be\3\2\2\2\u02fe\u02ff\7>\2\2\u02ff"+
		"\u00c0\3\2\2\2\u0300\u0301\7#\2\2\u0301\u00c2\3\2\2\2\u0302\u0303\7\u0080"+
		"\2\2\u0303\u00c4\3\2\2\2\u0304\u0305\7A\2\2\u0305\u00c6\3\2\2\2\u0306"+
		"\u0307\7<\2\2\u0307\u00c8\3\2\2\2\u0308\u0309\7?\2\2\u0309\u030a\7?\2"+
		"\2\u030a\u00ca\3\2\2\2\u030b\u030c\7>\2\2\u030c\u030d\7?\2\2\u030d\u00cc"+
		"\3\2\2\2\u030e\u030f\7@\2\2\u030f\u0310\7?\2\2\u0310\u00ce\3\2\2\2\u0311"+
		"\u0312\7#\2\2\u0312\u0313\7?\2\2\u0313\u00d0\3\2\2\2\u0314\u0315\7(\2"+
		"\2\u0315\u0316\7(\2\2\u0316\u00d2\3\2\2\2\u0317\u0318\7~\2\2\u0318\u0319"+
		"\7~\2\2\u0319\u00d4\3\2\2\2\u031a\u031b\7-\2\2\u031b\u031c\7-\2\2\u031c"+
		"\u00d6\3\2\2\2\u031d\u031e\7/\2\2\u031e\u031f\7/\2\2\u031f\u00d8\3\2\2"+
		"\2\u0320\u0321\7-\2\2\u0321\u00da\3\2\2\2\u0322\u0323\7/\2\2\u0323\u00dc"+
		"\3\2\2\2\u0324\u0325\7,\2\2\u0325\u00de\3\2\2\2\u0326\u0327\7\61\2\2\u0327"+
		"\u00e0\3\2\2\2\u0328\u0329\7(\2\2\u0329\u00e2\3\2\2\2\u032a\u032b\7~\2"+
		"\2\u032b\u00e4\3\2\2\2\u032c\u032d\7`\2\2\u032d\u00e6\3\2\2\2\u032e\u032f"+
		"\7\'\2\2\u032f\u00e8\3\2\2\2\u0330\u0334\5\u00ebv\2\u0331\u0333\5\u00ed"+
		"w\2\u0332\u0331\3\2\2\2\u0333\u0336\3\2\2\2\u0334\u0332\3\2\2\2\u0334"+
		"\u0335\3\2\2\2\u0335\u00ea\3\2\2\2\u0336\u0334\3\2\2\2\u0337\u033c\t\21"+
		"\2\2\u0338\u033c\n\22\2\2\u0339\u033a\t\23\2\2\u033a\u033c\t\24\2\2\u033b"+
		"\u0337\3\2\2\2\u033b\u0338\3\2\2\2\u033b\u0339\3\2\2\2\u033c\u00ec\3\2"+
		"\2\2\u033d\u0342\t\25\2\2\u033e\u0342\n\22\2\2\u033f\u0340\t\23\2\2\u0340"+
		"\u0342\t\24\2\2\u0341\u033d\3\2\2\2\u0341\u033e\3\2\2\2\u0341\u033f\3"+
		"\2\2\2\u0342\u00ee\3\2\2\2\u0343\u0344\7\60\2\2\u0344\u0345\7\60\2\2\u0345"+
		"\u0346\7\60\2\2\u0346\u00f0\3\2\2\2\u0347\u0349\t\26\2\2\u0348\u0347\3"+
		"\2\2\2\u0349\u034a\3\2\2\2\u034a\u0348\3\2\2\2\u034a\u034b\3\2\2\2\u034b"+
		"\u034c\3\2\2\2\u034c\u034d\by\2\2\u034d\u00f2\3\2\2\2\u034e\u034f\7\61"+
		"\2\2\u034f\u0350\7,\2\2\u0350\u0354\3\2\2\2\u0351\u0353\13\2\2\2\u0352"+
		"\u0351\3\2\2\2\u0353\u0356\3\2\2\2\u0354\u0355\3\2\2\2\u0354\u0352\3\2"+
		"\2\2\u0355\u0357\3\2\2\2\u0356\u0354\3\2\2\2\u0357\u0358\7,\2\2\u0358"+
		"\u0359\7\61\2\2\u0359\u035a\3\2\2\2\u035a\u035b\bz\3\2\u035b\u00f4\3\2"+
		"\2\2\u035c\u035d\7\61\2\2\u035d\u035e\7\61\2\2\u035e\u0362\3\2\2\2\u035f"+
		"\u0361\n\27\2\2\u0360\u035f\3\2\2\2\u0361\u0364\3\2\2\2\u0362\u0360\3"+
		"\2\2\2\u0362\u0363\3\2\2\2\u0363\u0365\3\2\2\2\u0364\u0362\3\2\2\2\u0365"+
		"\u0366\b{\3\2\u0366\u00f6\3\2\2\2\64\2\u01e4\u01e8\u01ec\u01f0\u01f4\u01fb"+
		"\u0200\u0202\u0208\u020c\u0210\u0216\u021b\u0225\u0229\u022f\u0233\u023b"+
		"\u023f\u0245\u024f\u0253\u0259\u025d\u0262\u0265\u0268\u026d\u0270\u0275"+
		"\u027a\u0282\u028d\u0291\u0296\u029a\u02aa\u02b4\u02ba\u02c1\u02c5\u02cb"+
		"\u02d8\u0334\u033b\u0341\u034a\u0354\u0362\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}