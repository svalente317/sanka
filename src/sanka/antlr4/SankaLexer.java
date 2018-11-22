// Generated from Sanka.g4 by ANTLR 4.5.1

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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "BOOLEAN", "BREAK", "BYTE", "CASE", "CLASS", "CONST", 
		"CONTINUE", "DEFAULT", "DOUBLE", "ELSE", "EXPORT", "FLOAT", "FOR", "IF", 
		"IMPORT", "INLINE", "INT", "INTERFACE", "LONG", "NEW", "PACKAGE", "PRIVATE", 
		"RETURN", "SHORT", "STATIC", "SWITCH", "THIS", "VAR", "VOID", "WHILE", 
		"C__INCLUDE", "C__FIELD", "C__STMT", "IntegerLiteral", "DecimalIntegerLiteral", 
		"HexIntegerLiteral", "OctalIntegerLiteral", "BinaryIntegerLiteral", "IntegerTypeSuffix", 
		"DecimalNumeral", "Digits", "Digit", "NonZeroDigit", "DigitOrUnderscore", 
		"Underscores", "HexNumeral", "HexDigits", "HexDigit", "HexDigitOrUnderscore", 
		"OctalNumeral", "OctalDigits", "OctalDigit", "OctalDigitOrUnderscore", 
		"BinaryNumeral", "BinaryDigits", "BinaryDigit", "BinaryDigitOrUnderscore", 
		"FloatingPointLiteral", "DecimalFloatingPointLiteral", "ExponentPart", 
		"ExponentIndicator", "SignedInteger", "Sign", "FloatTypeSuffix", "HexadecimalFloatingPointLiteral", 
		"HexSignificand", "BinaryExponent", "BinaryExponentIndicator", "BooleanLiteral", 
		"CharacterLiteral", "SingleCharacter", "StringLiteral", "StringCharacters", 
		"StringCharacter", "EscapeSequence", "OctalEscape", "UnicodeEscape", "ZeroToThree", 
		"NullLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", 
		"SEMI", "COMMA", "DOT", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", 
		"COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", 
		"SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", "Identifier", 
		"JavaLetter", "JavaLetterOrDigit", "ELLIPSIS", "WS", "COMMENT", "LINE_COMMENT"
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
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2P\u0355\b\1\4\2\t"+
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
		"w\tw\4x\tx\4y\ty\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3%\3%\3%\3%\5%\u01d3\n%\3&\3&\5&\u01d7\n&\3\'\3\'\5\'\u01db\n\'\3(\3"+
		"(\5(\u01df\n(\3)\3)\5)\u01e3\n)\3*\3*\3+\3+\3+\5+\u01ea\n+\3+\3+\3+\5"+
		"+\u01ef\n+\5+\u01f1\n+\3,\3,\7,\u01f5\n,\f,\16,\u01f8\13,\3,\5,\u01fb"+
		"\n,\3-\3-\5-\u01ff\n-\3.\3.\3/\3/\5/\u0205\n/\3\60\6\60\u0208\n\60\r\60"+
		"\16\60\u0209\3\61\3\61\3\61\3\61\3\62\3\62\7\62\u0212\n\62\f\62\16\62"+
		"\u0215\13\62\3\62\5\62\u0218\n\62\3\63\3\63\3\64\3\64\5\64\u021e\n\64"+
		"\3\65\3\65\5\65\u0222\n\65\3\65\3\65\3\66\3\66\7\66\u0228\n\66\f\66\16"+
		"\66\u022b\13\66\3\66\5\66\u022e\n\66\3\67\3\67\38\38\58\u0234\n8\39\3"+
		"9\39\39\3:\3:\7:\u023c\n:\f:\16:\u023f\13:\3:\5:\u0242\n:\3;\3;\3<\3<"+
		"\5<\u0248\n<\3=\3=\5=\u024c\n=\3>\3>\3>\5>\u0251\n>\3>\5>\u0254\n>\3>"+
		"\5>\u0257\n>\3>\3>\3>\5>\u025c\n>\3>\5>\u025f\n>\3>\3>\3>\5>\u0264\n>"+
		"\3>\3>\3>\5>\u0269\n>\3?\3?\3?\3@\3@\3A\5A\u0271\nA\3A\3A\3B\3B\3C\3C"+
		"\3D\3D\3D\5D\u027c\nD\3E\3E\5E\u0280\nE\3E\3E\3E\5E\u0285\nE\3E\3E\5E"+
		"\u0289\nE\3F\3F\3F\3G\3G\3H\3H\3H\3H\3H\3H\3H\3H\3H\5H\u0299\nH\3I\3I"+
		"\3I\3I\3I\3I\3I\3I\5I\u02a3\nI\3J\3J\3K\3K\5K\u02a9\nK\3K\3K\3L\6L\u02ae"+
		"\nL\rL\16L\u02af\3M\3M\5M\u02b4\nM\3N\3N\3N\3N\5N\u02ba\nN\3O\3O\3O\3"+
		"O\3O\3O\3O\3O\3O\3O\3O\5O\u02c7\nO\3P\3P\3P\3P\3P\3P\3P\3Q\3Q\3R\3R\3"+
		"R\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3\\\3\\"+
		"\3]\3]\3^\3^\3_\3_\3`\3`\3a\3a\3b\3b\3c\3c\3c\3d\3d\3d\3e\3e\3e\3f\3f"+
		"\3f\3g\3g\3g\3h\3h\3h\3i\3i\3i\3j\3j\3j\3k\3k\3l\3l\3m\3m\3n\3n\3o\3o"+
		"\3p\3p\3q\3q\3r\3r\3s\3s\7s\u0321\ns\fs\16s\u0324\13s\3t\3t\3t\3t\5t\u032a"+
		"\nt\3u\3u\3u\3u\5u\u0330\nu\3v\3v\3v\3v\3w\6w\u0337\nw\rw\16w\u0338\3"+
		"w\3w\3x\3x\3x\3x\7x\u0341\nx\fx\16x\u0344\13x\3x\3x\3x\3x\3x\3y\3y\3y"+
		"\3y\7y\u034f\ny\fy\16y\u0352\13y\3y\3y\3\u0342\2z\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\2M\2"+
		"O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\'{\2"+
		"}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f"+
		"(\u0091)\u0093\2\u0095*\u0097\2\u0099\2\u009b\2\u009d\2\u009f\2\u00a1"+
		"\2\u00a3+\u00a5,\u00a7-\u00a9.\u00ab/\u00ad\60\u00af\61\u00b1\62\u00b3"+
		"\63\u00b5\64\u00b7\65\u00b9\66\u00bb\67\u00bd8\u00bf9\u00c1:\u00c3;\u00c5"+
		"<\u00c7=\u00c9>\u00cb?\u00cd@\u00cfA\u00d1B\u00d3C\u00d5D\u00d7E\u00d9"+
		"F\u00dbG\u00ddH\u00dfI\u00e1J\u00e3K\u00e5L\u00e7\2\u00e9\2\u00ebM\u00ed"+
		"N\u00efO\u00f1P\3\2\30\4\2NNnn\3\2\63;\4\2ZZzz\5\2\62;CHch\3\2\629\4\2"+
		"DDdd\3\2\62\63\4\2GGgg\4\2--//\6\2FFHHffhh\4\2RRrr\6\2\f\f\17\17))^^\4"+
		"\2$$^^\n\2$$))^^ddhhppttvv\3\2\62\65\6\2&&C\\aac|\4\2\2\u0081\ud802\udc01"+
		"\3\2\ud802\udc01\3\2\udc02\ue001\7\2&&\62;C\\aac|\5\2\13\f\16\17\"\"\4"+
		"\2\f\f\17\17\u0363\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2y\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2"+
		"\2\2\2\u0095\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2"+
		"\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1"+
		"\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2"+
		"\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3"+
		"\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2"+
		"\2\2\u00cd\3\2\2\2\2\u00cf\3\2\2\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5"+
		"\3\2\2\2\2\u00d7\3\2\2\2\2\u00d9\3\2\2\2\2\u00db\3\2\2\2\2\u00dd\3\2\2"+
		"\2\2\u00df\3\2\2\2\2\u00e1\3\2\2\2\2\u00e3\3\2\2\2\2\u00e5\3\2\2\2\2\u00eb"+
		"\3\2\2\2\2\u00ed\3\2\2\2\2\u00ef\3\2\2\2\2\u00f1\3\2\2\2\3\u00f3\3\2\2"+
		"\2\5\u00f6\3\2\2\2\7\u00f9\3\2\2\2\t\u0101\3\2\2\2\13\u0107\3\2\2\2\r"+
		"\u010c\3\2\2\2\17\u0111\3\2\2\2\21\u0117\3\2\2\2\23\u011d\3\2\2\2\25\u0126"+
		"\3\2\2\2\27\u012e\3\2\2\2\31\u0135\3\2\2\2\33\u013a\3\2\2\2\35\u0141\3"+
		"\2\2\2\37\u0147\3\2\2\2!\u014b\3\2\2\2#\u014e\3\2\2\2%\u0155\3\2\2\2\'"+
		"\u015c\3\2\2\2)\u0160\3\2\2\2+\u016a\3\2\2\2-\u016f\3\2\2\2/\u0173\3\2"+
		"\2\2\61\u017b\3\2\2\2\63\u0183\3\2\2\2\65\u018a\3\2\2\2\67\u0190\3\2\2"+
		"\29\u0197\3\2\2\2;\u019e\3\2\2\2=\u01a3\3\2\2\2?\u01a7\3\2\2\2A\u01ac"+
		"\3\2\2\2C\u01b2\3\2\2\2E\u01bd\3\2\2\2G\u01c6\3\2\2\2I\u01d2\3\2\2\2K"+
		"\u01d4\3\2\2\2M\u01d8\3\2\2\2O\u01dc\3\2\2\2Q\u01e0\3\2\2\2S\u01e4\3\2"+
		"\2\2U\u01f0\3\2\2\2W\u01f2\3\2\2\2Y\u01fe\3\2\2\2[\u0200\3\2\2\2]\u0204"+
		"\3\2\2\2_\u0207\3\2\2\2a\u020b\3\2\2\2c\u020f\3\2\2\2e\u0219\3\2\2\2g"+
		"\u021d\3\2\2\2i\u021f\3\2\2\2k\u0225\3\2\2\2m\u022f\3\2\2\2o\u0233\3\2"+
		"\2\2q\u0235\3\2\2\2s\u0239\3\2\2\2u\u0243\3\2\2\2w\u0247\3\2\2\2y\u024b"+
		"\3\2\2\2{\u0268\3\2\2\2}\u026a\3\2\2\2\177\u026d\3\2\2\2\u0081\u0270\3"+
		"\2\2\2\u0083\u0274\3\2\2\2\u0085\u0276\3\2\2\2\u0087\u0278\3\2\2\2\u0089"+
		"\u0288\3\2\2\2\u008b\u028a\3\2\2\2\u008d\u028d\3\2\2\2\u008f\u0298\3\2"+
		"\2\2\u0091\u02a2\3\2\2\2\u0093\u02a4\3\2\2\2\u0095\u02a6\3\2\2\2\u0097"+
		"\u02ad\3\2\2\2\u0099\u02b3\3\2\2\2\u009b\u02b9\3\2\2\2\u009d\u02c6\3\2"+
		"\2\2\u009f\u02c8\3\2\2\2\u00a1\u02cf\3\2\2\2\u00a3\u02d1\3\2\2\2\u00a5"+
		"\u02d6\3\2\2\2\u00a7\u02d8\3\2\2\2\u00a9\u02da\3\2\2\2\u00ab\u02dc\3\2"+
		"\2\2\u00ad\u02de\3\2\2\2\u00af\u02e0\3\2\2\2\u00b1\u02e2\3\2\2\2\u00b3"+
		"\u02e4\3\2\2\2\u00b5\u02e6\3\2\2\2\u00b7\u02e8\3\2\2\2\u00b9\u02ea\3\2"+
		"\2\2\u00bb\u02ec\3\2\2\2\u00bd\u02ee\3\2\2\2\u00bf\u02f0\3\2\2\2\u00c1"+
		"\u02f2\3\2\2\2\u00c3\u02f4\3\2\2\2\u00c5\u02f6\3\2\2\2\u00c7\u02f9\3\2"+
		"\2\2\u00c9\u02fc\3\2\2\2\u00cb\u02ff\3\2\2\2\u00cd\u0302\3\2\2\2\u00cf"+
		"\u0305\3\2\2\2\u00d1\u0308\3\2\2\2\u00d3\u030b\3\2\2\2\u00d5\u030e\3\2"+
		"\2\2\u00d7\u0310\3\2\2\2\u00d9\u0312\3\2\2\2\u00db\u0314\3\2\2\2\u00dd"+
		"\u0316\3\2\2\2\u00df\u0318\3\2\2\2\u00e1\u031a\3\2\2\2\u00e3\u031c\3\2"+
		"\2\2\u00e5\u031e\3\2\2\2\u00e7\u0329\3\2\2\2\u00e9\u032f\3\2\2\2\u00eb"+
		"\u0331\3\2\2\2\u00ed\u0336\3\2\2\2\u00ef\u033c\3\2\2\2\u00f1\u034a\3\2"+
		"\2\2\u00f3\u00f4\7>\2\2\u00f4\u00f5\7>\2\2\u00f5\4\3\2\2\2\u00f6\u00f7"+
		"\7@\2\2\u00f7\u00f8\7@\2\2\u00f8\6\3\2\2\2\u00f9\u00fa\7d\2\2\u00fa\u00fb"+
		"\7q\2\2\u00fb\u00fc\7q\2\2\u00fc\u00fd\7n\2\2\u00fd\u00fe\7g\2\2\u00fe"+
		"\u00ff\7c\2\2\u00ff\u0100\7p\2\2\u0100\b\3\2\2\2\u0101\u0102\7d\2\2\u0102"+
		"\u0103\7t\2\2\u0103\u0104\7g\2\2\u0104\u0105\7c\2\2\u0105\u0106\7m\2\2"+
		"\u0106\n\3\2\2\2\u0107\u0108\7d\2\2\u0108\u0109\7{\2\2\u0109\u010a\7v"+
		"\2\2\u010a\u010b\7g\2\2\u010b\f\3\2\2\2\u010c\u010d\7e\2\2\u010d\u010e"+
		"\7c\2\2\u010e\u010f\7u\2\2\u010f\u0110\7g\2\2\u0110\16\3\2\2\2\u0111\u0112"+
		"\7e\2\2\u0112\u0113\7n\2\2\u0113\u0114\7c\2\2\u0114\u0115\7u\2\2\u0115"+
		"\u0116\7u\2\2\u0116\20\3\2\2\2\u0117\u0118\7e\2\2\u0118\u0119\7q\2\2\u0119"+
		"\u011a\7p\2\2\u011a\u011b\7u\2\2\u011b\u011c\7v\2\2\u011c\22\3\2\2\2\u011d"+
		"\u011e\7e\2\2\u011e\u011f\7q\2\2\u011f\u0120\7p\2\2\u0120\u0121\7v\2\2"+
		"\u0121\u0122\7k\2\2\u0122\u0123\7p\2\2\u0123\u0124\7w\2\2\u0124\u0125"+
		"\7g\2\2\u0125\24\3\2\2\2\u0126\u0127\7f\2\2\u0127\u0128\7g\2\2\u0128\u0129"+
		"\7h\2\2\u0129\u012a\7c\2\2\u012a\u012b\7w\2\2\u012b\u012c\7n\2\2\u012c"+
		"\u012d\7v\2\2\u012d\26\3\2\2\2\u012e\u012f\7f\2\2\u012f\u0130\7q\2\2\u0130"+
		"\u0131\7w\2\2\u0131\u0132\7d\2\2\u0132\u0133\7n\2\2\u0133\u0134\7g\2\2"+
		"\u0134\30\3\2\2\2\u0135\u0136\7g\2\2\u0136\u0137\7n\2\2\u0137\u0138\7"+
		"u\2\2\u0138\u0139\7g\2\2\u0139\32\3\2\2\2\u013a\u013b\7g\2\2\u013b\u013c"+
		"\7z\2\2\u013c\u013d\7r\2\2\u013d\u013e\7q\2\2\u013e\u013f\7t\2\2\u013f"+
		"\u0140\7v\2\2\u0140\34\3\2\2\2\u0141\u0142\7h\2\2\u0142\u0143\7n\2\2\u0143"+
		"\u0144\7q\2\2\u0144\u0145\7c\2\2\u0145\u0146\7v\2\2\u0146\36\3\2\2\2\u0147"+
		"\u0148\7h\2\2\u0148\u0149\7q\2\2\u0149\u014a\7t\2\2\u014a \3\2\2\2\u014b"+
		"\u014c\7k\2\2\u014c\u014d\7h\2\2\u014d\"\3\2\2\2\u014e\u014f\7k\2\2\u014f"+
		"\u0150\7o\2\2\u0150\u0151\7r\2\2\u0151\u0152\7q\2\2\u0152\u0153\7t\2\2"+
		"\u0153\u0154\7v\2\2\u0154$\3\2\2\2\u0155\u0156\7k\2\2\u0156\u0157\7p\2"+
		"\2\u0157\u0158\7n\2\2\u0158\u0159\7k\2\2\u0159\u015a\7p\2\2\u015a\u015b"+
		"\7g\2\2\u015b&\3\2\2\2\u015c\u015d\7k\2\2\u015d\u015e\7p\2\2\u015e\u015f"+
		"\7v\2\2\u015f(\3\2\2\2\u0160\u0161\7k\2\2\u0161\u0162\7p\2\2\u0162\u0163"+
		"\7v\2\2\u0163\u0164\7g\2\2\u0164\u0165\7t\2\2\u0165\u0166\7h\2\2\u0166"+
		"\u0167\7c\2\2\u0167\u0168\7e\2\2\u0168\u0169\7g\2\2\u0169*\3\2\2\2\u016a"+
		"\u016b\7n\2\2\u016b\u016c\7q\2\2\u016c\u016d\7p\2\2\u016d\u016e\7i\2\2"+
		"\u016e,\3\2\2\2\u016f\u0170\7p\2\2\u0170\u0171\7g\2\2\u0171\u0172\7y\2"+
		"\2\u0172.\3\2\2\2\u0173\u0174\7r\2\2\u0174\u0175\7c\2\2\u0175\u0176\7"+
		"e\2\2\u0176\u0177\7m\2\2\u0177\u0178\7c\2\2\u0178\u0179\7i\2\2\u0179\u017a"+
		"\7g\2\2\u017a\60\3\2\2\2\u017b\u017c\7r\2\2\u017c\u017d\7t\2\2\u017d\u017e"+
		"\7k\2\2\u017e\u017f\7x\2\2\u017f\u0180\7c\2\2\u0180\u0181\7v\2\2\u0181"+
		"\u0182\7g\2\2\u0182\62\3\2\2\2\u0183\u0184\7t\2\2\u0184\u0185\7g\2\2\u0185"+
		"\u0186\7v\2\2\u0186\u0187\7w\2\2\u0187\u0188\7t\2\2\u0188\u0189\7p\2\2"+
		"\u0189\64\3\2\2\2\u018a\u018b\7u\2\2\u018b\u018c\7j\2\2\u018c\u018d\7"+
		"q\2\2\u018d\u018e\7t\2\2\u018e\u018f\7v\2\2\u018f\66\3\2\2\2\u0190\u0191"+
		"\7u\2\2\u0191\u0192\7v\2\2\u0192\u0193\7c\2\2\u0193\u0194\7v\2\2\u0194"+
		"\u0195\7k\2\2\u0195\u0196\7e\2\2\u01968\3\2\2\2\u0197\u0198\7u\2\2\u0198"+
		"\u0199\7y\2\2\u0199\u019a\7k\2\2\u019a\u019b\7v\2\2\u019b\u019c\7e\2\2"+
		"\u019c\u019d\7j\2\2\u019d:\3\2\2\2\u019e\u019f\7v\2\2\u019f\u01a0\7j\2"+
		"\2\u01a0\u01a1\7k\2\2\u01a1\u01a2\7u\2\2\u01a2<\3\2\2\2\u01a3\u01a4\7"+
		"x\2\2\u01a4\u01a5\7c\2\2\u01a5\u01a6\7t\2\2\u01a6>\3\2\2\2\u01a7\u01a8"+
		"\7x\2\2\u01a8\u01a9\7q\2\2\u01a9\u01aa\7k\2\2\u01aa\u01ab\7f\2\2\u01ab"+
		"@\3\2\2\2\u01ac\u01ad\7y\2\2\u01ad\u01ae\7j\2\2\u01ae\u01af\7k\2\2\u01af"+
		"\u01b0\7n\2\2\u01b0\u01b1\7g\2\2\u01b1B\3\2\2\2\u01b2\u01b3\7e\2\2\u01b3"+
		"\u01b4\7a\2\2\u01b4\u01b5\7a\2\2\u01b5\u01b6\7k\2\2\u01b6\u01b7\7p\2\2"+
		"\u01b7\u01b8\7e\2\2\u01b8\u01b9\7n\2\2\u01b9\u01ba\7w\2\2\u01ba\u01bb"+
		"\7f\2\2\u01bb\u01bc\7g\2\2\u01bcD\3\2\2\2\u01bd\u01be\7e\2\2\u01be\u01bf"+
		"\7a\2\2\u01bf\u01c0\7a\2\2\u01c0\u01c1\7h\2\2\u01c1\u01c2\7k\2\2\u01c2"+
		"\u01c3\7g\2\2\u01c3\u01c4\7n\2\2\u01c4\u01c5\7f\2\2\u01c5F\3\2\2\2\u01c6"+
		"\u01c7\7e\2\2\u01c7\u01c8\7a\2\2\u01c8\u01c9\7a\2\2\u01c9\u01ca\7u\2\2"+
		"\u01ca\u01cb\7v\2\2\u01cb\u01cc\7o\2\2\u01cc\u01cd\7v\2\2\u01cdH\3\2\2"+
		"\2\u01ce\u01d3\5K&\2\u01cf\u01d3\5M\'\2\u01d0\u01d3\5O(\2\u01d1\u01d3"+
		"\5Q)\2\u01d2\u01ce\3\2\2\2\u01d2\u01cf\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2"+
		"\u01d1\3\2\2\2\u01d3J\3\2\2\2\u01d4\u01d6\5U+\2\u01d5\u01d7\5S*\2\u01d6"+
		"\u01d5\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7L\3\2\2\2\u01d8\u01da\5a\61\2"+
		"\u01d9\u01db\5S*\2\u01da\u01d9\3\2\2\2\u01da\u01db\3\2\2\2\u01dbN\3\2"+
		"\2\2\u01dc\u01de\5i\65\2\u01dd\u01df\5S*\2\u01de\u01dd\3\2\2\2\u01de\u01df"+
		"\3\2\2\2\u01dfP\3\2\2\2\u01e0\u01e2\5q9\2\u01e1\u01e3\5S*\2\u01e2\u01e1"+
		"\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3R\3\2\2\2\u01e4\u01e5\t\2\2\2\u01e5"+
		"T\3\2\2\2\u01e6\u01f1\7\62\2\2\u01e7\u01ee\5[.\2\u01e8\u01ea\5W,\2\u01e9"+
		"\u01e8\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ef\3\2\2\2\u01eb\u01ec\5_"+
		"\60\2\u01ec\u01ed\5W,\2\u01ed\u01ef\3\2\2\2\u01ee\u01e9\3\2\2\2\u01ee"+
		"\u01eb\3\2\2\2\u01ef\u01f1\3\2\2\2\u01f0\u01e6\3\2\2\2\u01f0\u01e7\3\2"+
		"\2\2\u01f1V\3\2\2\2\u01f2\u01fa\5Y-\2\u01f3\u01f5\5]/\2\u01f4\u01f3\3"+
		"\2\2\2\u01f5\u01f8\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7"+
		"\u01f9\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f9\u01fb\5Y-\2\u01fa\u01f6\3\2\2"+
		"\2\u01fa\u01fb\3\2\2\2\u01fbX\3\2\2\2\u01fc\u01ff\7\62\2\2\u01fd\u01ff"+
		"\5[.\2\u01fe\u01fc\3\2\2\2\u01fe\u01fd\3\2\2\2\u01ffZ\3\2\2\2\u0200\u0201"+
		"\t\3\2\2\u0201\\\3\2\2\2\u0202\u0205\5Y-\2\u0203\u0205\7a\2\2\u0204\u0202"+
		"\3\2\2\2\u0204\u0203\3\2\2\2\u0205^\3\2\2\2\u0206\u0208\7a\2\2\u0207\u0206"+
		"\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a"+
		"`\3\2\2\2\u020b\u020c\7\62\2\2\u020c\u020d\t\4\2\2\u020d\u020e\5c\62\2"+
		"\u020eb\3\2\2\2\u020f\u0217\5e\63\2\u0210\u0212\5g\64\2\u0211\u0210\3"+
		"\2\2\2\u0212\u0215\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214"+
		"\u0216\3\2\2\2\u0215\u0213\3\2\2\2\u0216\u0218\5e\63\2\u0217\u0213\3\2"+
		"\2\2\u0217\u0218\3\2\2\2\u0218d\3\2\2\2\u0219\u021a\t\5\2\2\u021af\3\2"+
		"\2\2\u021b\u021e\5e\63\2\u021c\u021e\7a\2\2\u021d\u021b\3\2\2\2\u021d"+
		"\u021c\3\2\2\2\u021eh\3\2\2\2\u021f\u0221\7\62\2\2\u0220\u0222\5_\60\2"+
		"\u0221\u0220\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0224"+
		"\5k\66\2\u0224j\3\2\2\2\u0225\u022d\5m\67\2\u0226\u0228\5o8\2\u0227\u0226"+
		"\3\2\2\2\u0228\u022b\3\2\2\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a"+
		"\u022c\3\2\2\2\u022b\u0229\3\2\2\2\u022c\u022e\5m\67\2\u022d\u0229\3\2"+
		"\2\2\u022d\u022e\3\2\2\2\u022el\3\2\2\2\u022f\u0230\t\6\2\2\u0230n\3\2"+
		"\2\2\u0231\u0234\5m\67\2\u0232\u0234\7a\2\2\u0233\u0231\3\2\2\2\u0233"+
		"\u0232\3\2\2\2\u0234p\3\2\2\2\u0235\u0236\7\62\2\2\u0236\u0237\t\7\2\2"+
		"\u0237\u0238\5s:\2\u0238r\3\2\2\2\u0239\u0241\5u;\2\u023a\u023c\5w<\2"+
		"\u023b\u023a\3\2\2\2\u023c\u023f\3\2\2\2\u023d\u023b\3\2\2\2\u023d\u023e"+
		"\3\2\2\2\u023e\u0240\3\2\2\2\u023f\u023d\3\2\2\2\u0240\u0242\5u;\2\u0241"+
		"\u023d\3\2\2\2\u0241\u0242\3\2\2\2\u0242t\3\2\2\2\u0243\u0244\t\b\2\2"+
		"\u0244v\3\2\2\2\u0245\u0248\5u;\2\u0246\u0248\7a\2\2\u0247\u0245\3\2\2"+
		"\2\u0247\u0246\3\2\2\2\u0248x\3\2\2\2\u0249\u024c\5{>\2\u024a\u024c\5"+
		"\u0087D\2\u024b\u0249\3\2\2\2\u024b\u024a\3\2\2\2\u024cz\3\2\2\2\u024d"+
		"\u024e\5W,\2\u024e\u0250\7\60\2\2\u024f\u0251\5W,\2\u0250\u024f\3\2\2"+
		"\2\u0250\u0251\3\2\2\2\u0251\u0253\3\2\2\2\u0252\u0254\5}?\2\u0253\u0252"+
		"\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0256\3\2\2\2\u0255\u0257\5\u0085C"+
		"\2\u0256\u0255\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0269\3\2\2\2\u0258\u0259"+
		"\7\60\2\2\u0259\u025b\5W,\2\u025a\u025c\5}?\2\u025b\u025a\3\2\2\2\u025b"+
		"\u025c\3\2\2\2\u025c\u025e\3\2\2\2\u025d\u025f\5\u0085C\2\u025e\u025d"+
		"\3\2\2\2\u025e\u025f\3\2\2\2\u025f\u0269\3\2\2\2\u0260\u0261\5W,\2\u0261"+
		"\u0263\5}?\2\u0262\u0264\5\u0085C\2\u0263\u0262\3\2\2\2\u0263\u0264\3"+
		"\2\2\2\u0264\u0269\3\2\2\2\u0265\u0266\5W,\2\u0266\u0267\5\u0085C\2\u0267"+
		"\u0269\3\2\2\2\u0268\u024d\3\2\2\2\u0268\u0258\3\2\2\2\u0268\u0260\3\2"+
		"\2\2\u0268\u0265\3\2\2\2\u0269|\3\2\2\2\u026a\u026b\5\177@\2\u026b\u026c"+
		"\5\u0081A\2\u026c~\3\2\2\2\u026d\u026e\t\t\2\2\u026e\u0080\3\2\2\2\u026f"+
		"\u0271\5\u0083B\2\u0270\u026f\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0272"+
		"\3\2\2\2\u0272\u0273\5W,\2\u0273\u0082\3\2\2\2\u0274\u0275\t\n\2\2\u0275"+
		"\u0084\3\2\2\2\u0276\u0277\t\13\2\2\u0277\u0086\3\2\2\2\u0278\u0279\5"+
		"\u0089E\2\u0279\u027b\5\u008bF\2\u027a\u027c\5\u0085C\2\u027b\u027a\3"+
		"\2\2\2\u027b\u027c\3\2\2\2\u027c\u0088\3\2\2\2\u027d\u027f\5a\61\2\u027e"+
		"\u0280\7\60\2\2\u027f\u027e\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u0289\3"+
		"\2\2\2\u0281\u0282\7\62\2\2\u0282\u0284\t\4\2\2\u0283\u0285\5c\62\2\u0284"+
		"\u0283\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0286\3\2\2\2\u0286\u0287\7\60"+
		"\2\2\u0287\u0289\5c\62\2\u0288\u027d\3\2\2\2\u0288\u0281\3\2\2\2\u0289"+
		"\u008a\3\2\2\2\u028a\u028b\5\u008dG\2\u028b\u028c\5\u0081A\2\u028c\u008c"+
		"\3\2\2\2\u028d\u028e\t\f\2\2\u028e\u008e\3\2\2\2\u028f\u0290\7v\2\2\u0290"+
		"\u0291\7t\2\2\u0291\u0292\7w\2\2\u0292\u0299\7g\2\2\u0293\u0294\7h\2\2"+
		"\u0294\u0295\7c\2\2\u0295\u0296\7n\2\2\u0296\u0297\7u\2\2\u0297\u0299"+
		"\7g\2\2\u0298\u028f\3\2\2\2\u0298\u0293\3\2\2\2\u0299\u0090\3\2\2\2\u029a"+
		"\u029b\7)\2\2\u029b\u029c\5\u0093J\2\u029c\u029d\7)\2\2\u029d\u02a3\3"+
		"\2\2\2\u029e\u029f\7)\2\2\u029f\u02a0\5\u009bN\2\u02a0\u02a1\7)\2\2\u02a1"+
		"\u02a3\3\2\2\2\u02a2\u029a\3\2\2\2\u02a2\u029e\3\2\2\2\u02a3\u0092\3\2"+
		"\2\2\u02a4\u02a5\n\r\2\2\u02a5\u0094\3\2\2\2\u02a6\u02a8\7$\2\2\u02a7"+
		"\u02a9\5\u0097L\2\u02a8\u02a7\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02aa"+
		"\3\2\2\2\u02aa\u02ab\7$\2\2\u02ab\u0096\3\2\2\2\u02ac\u02ae\5\u0099M\2"+
		"\u02ad\u02ac\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02ad\3\2\2\2\u02af\u02b0"+
		"\3\2\2\2\u02b0\u0098\3\2\2\2\u02b1\u02b4\n\16\2\2\u02b2\u02b4\5\u009b"+
		"N\2\u02b3\u02b1\3\2\2\2\u02b3\u02b2\3\2\2\2\u02b4\u009a\3\2\2\2\u02b5"+
		"\u02b6\7^\2\2\u02b6\u02ba\t\17\2\2\u02b7\u02ba\5\u009dO\2\u02b8\u02ba"+
		"\5\u009fP\2\u02b9\u02b5\3\2\2\2\u02b9\u02b7\3\2\2\2\u02b9\u02b8\3\2\2"+
		"\2\u02ba\u009c\3\2\2\2\u02bb\u02bc\7^\2\2\u02bc\u02c7\5m\67\2\u02bd\u02be"+
		"\7^\2\2\u02be\u02bf\5m\67\2\u02bf\u02c0\5m\67\2\u02c0\u02c7\3\2\2\2\u02c1"+
		"\u02c2\7^\2\2\u02c2\u02c3\5\u00a1Q\2\u02c3\u02c4\5m\67\2\u02c4\u02c5\5"+
		"m\67\2\u02c5\u02c7\3\2\2\2\u02c6\u02bb\3\2\2\2\u02c6\u02bd\3\2\2\2\u02c6"+
		"\u02c1\3\2\2\2\u02c7\u009e\3\2\2\2\u02c8\u02c9\7^\2\2\u02c9\u02ca\7w\2"+
		"\2\u02ca\u02cb\5e\63\2\u02cb\u02cc\5e\63\2\u02cc\u02cd\5e\63\2\u02cd\u02ce"+
		"\5e\63\2\u02ce\u00a0\3\2\2\2\u02cf\u02d0\t\20\2\2\u02d0\u00a2\3\2\2\2"+
		"\u02d1\u02d2\7p\2\2\u02d2\u02d3\7w\2\2\u02d3\u02d4\7n\2\2\u02d4\u02d5"+
		"\7n\2\2\u02d5\u00a4\3\2\2\2\u02d6\u02d7\7*\2\2\u02d7\u00a6\3\2\2\2\u02d8"+
		"\u02d9\7+\2\2\u02d9\u00a8\3\2\2\2\u02da\u02db\7}\2\2\u02db\u00aa\3\2\2"+
		"\2\u02dc\u02dd\7\177\2\2\u02dd\u00ac\3\2\2\2\u02de\u02df\7]\2\2\u02df"+
		"\u00ae\3\2\2\2\u02e0\u02e1\7_\2\2\u02e1\u00b0\3\2\2\2\u02e2\u02e3\7=\2"+
		"\2\u02e3\u00b2\3\2\2\2\u02e4\u02e5\7.\2\2\u02e5\u00b4\3\2\2\2\u02e6\u02e7"+
		"\7\60\2\2\u02e7\u00b6\3\2\2\2\u02e8\u02e9\7?\2\2\u02e9\u00b8\3\2\2\2\u02ea"+
		"\u02eb\7@\2\2\u02eb\u00ba\3\2\2\2\u02ec\u02ed\7>\2\2\u02ed\u00bc\3\2\2"+
		"\2\u02ee\u02ef\7#\2\2\u02ef\u00be\3\2\2\2\u02f0\u02f1\7\u0080\2\2\u02f1"+
		"\u00c0\3\2\2\2\u02f2\u02f3\7A\2\2\u02f3\u00c2\3\2\2\2\u02f4\u02f5\7<\2"+
		"\2\u02f5\u00c4\3\2\2\2\u02f6\u02f7\7?\2\2\u02f7\u02f8\7?\2\2\u02f8\u00c6"+
		"\3\2\2\2\u02f9\u02fa\7>\2\2\u02fa\u02fb\7?\2\2\u02fb\u00c8\3\2\2\2\u02fc"+
		"\u02fd\7@\2\2\u02fd\u02fe\7?\2\2\u02fe\u00ca\3\2\2\2\u02ff\u0300\7#\2"+
		"\2\u0300\u0301\7?\2\2\u0301\u00cc\3\2\2\2\u0302\u0303\7(\2\2\u0303\u0304"+
		"\7(\2\2\u0304\u00ce\3\2\2\2\u0305\u0306\7~\2\2\u0306\u0307\7~\2\2\u0307"+
		"\u00d0\3\2\2\2\u0308\u0309\7-\2\2\u0309\u030a\7-\2\2\u030a\u00d2\3\2\2"+
		"\2\u030b\u030c\7/\2\2\u030c\u030d\7/\2\2\u030d\u00d4\3\2\2\2\u030e\u030f"+
		"\7-\2\2\u030f\u00d6\3\2\2\2\u0310\u0311\7/\2\2\u0311\u00d8\3\2\2\2\u0312"+
		"\u0313\7,\2\2\u0313\u00da\3\2\2\2\u0314\u0315\7\61\2\2\u0315\u00dc\3\2"+
		"\2\2\u0316\u0317\7(\2\2\u0317\u00de\3\2\2\2\u0318\u0319\7~\2\2\u0319\u00e0"+
		"\3\2\2\2\u031a\u031b\7`\2\2\u031b\u00e2\3\2\2\2\u031c\u031d\7\'\2\2\u031d"+
		"\u00e4\3\2\2\2\u031e\u0322\5\u00e7t\2\u031f\u0321\5\u00e9u\2\u0320\u031f"+
		"\3\2\2\2\u0321\u0324\3\2\2\2\u0322\u0320\3\2\2\2\u0322\u0323\3\2\2\2\u0323"+
		"\u00e6\3\2\2\2\u0324\u0322\3\2\2\2\u0325\u032a\t\21\2\2\u0326\u032a\n"+
		"\22\2\2\u0327\u0328\t\23\2\2\u0328\u032a\t\24\2\2\u0329\u0325\3\2\2\2"+
		"\u0329\u0326\3\2\2\2\u0329\u0327\3\2\2\2\u032a\u00e8\3\2\2\2\u032b\u0330"+
		"\t\25\2\2\u032c\u0330\n\22\2\2\u032d\u032e\t\23\2\2\u032e\u0330\t\24\2"+
		"\2\u032f\u032b\3\2\2\2\u032f\u032c\3\2\2\2\u032f\u032d\3\2\2\2\u0330\u00ea"+
		"\3\2\2\2\u0331\u0332\7\60\2\2\u0332\u0333\7\60\2\2\u0333\u0334\7\60\2"+
		"\2\u0334\u00ec\3\2\2\2\u0335\u0337\t\26\2\2\u0336\u0335\3\2\2\2\u0337"+
		"\u0338\3\2\2\2\u0338\u0336\3\2\2\2\u0338\u0339\3\2\2\2\u0339\u033a\3\2"+
		"\2\2\u033a\u033b\bw\2\2\u033b\u00ee\3\2\2\2\u033c\u033d\7\61\2\2\u033d"+
		"\u033e\7,\2\2\u033e\u0342\3\2\2\2\u033f\u0341\13\2\2\2\u0340\u033f\3\2"+
		"\2\2\u0341\u0344\3\2\2\2\u0342\u0343\3\2\2\2\u0342\u0340\3\2\2\2\u0343"+
		"\u0345\3\2\2\2\u0344\u0342\3\2\2\2\u0345\u0346\7,\2\2\u0346\u0347\7\61"+
		"\2\2\u0347\u0348\3\2\2\2\u0348\u0349\bx\3\2\u0349\u00f0\3\2\2\2\u034a"+
		"\u034b\7\61\2\2\u034b\u034c\7\61\2\2\u034c\u0350\3\2\2\2\u034d\u034f\n"+
		"\27\2\2\u034e\u034d\3\2\2\2\u034f\u0352\3\2\2\2\u0350\u034e\3\2\2\2\u0350"+
		"\u0351\3\2\2\2\u0351\u0353\3\2\2\2\u0352\u0350\3\2\2\2\u0353\u0354\by"+
		"\3\2\u0354\u00f2\3\2\2\2\64\2\u01d2\u01d6\u01da\u01de\u01e2\u01e9\u01ee"+
		"\u01f0\u01f6\u01fa\u01fe\u0204\u0209\u0213\u0217\u021d\u0221\u0229\u022d"+
		"\u0233\u023d\u0241\u0247\u024b\u0250\u0253\u0256\u025b\u025e\u0263\u0268"+
		"\u0270\u027b\u027f\u0284\u0288\u0298\u02a2\u02a8\u02af\u02b3\u02b9\u02c6"+
		"\u0322\u0329\u032f\u0338\u0342\u0350\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}