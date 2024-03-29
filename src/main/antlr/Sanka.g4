/*
 [The "BSD licence"]
 Copyright (c) 2013 Terence Parr, Sam Harwell
 Copyright (c) 2017 Sal Valente
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/**
 * Sanka 1.0 grammar for ANTLR v4.
 * Based on Java 1.7 grammar for ANTLR v4.
 */
grammar Sanka;

@header {
    package sanka.antlr4;
}

// starting point for parsing a sanka file
compilationUnit
    :   packageDeclaration? importDeclaration* typeDeclaration* EOF
    ;

packageDeclaration
    :   'package' qualifiedName ';'
    ;

importDeclaration
    :   'import' qualifiedName ('.' '*')? ';'
    ;

typeDeclaration
    :   classDeclaration
    |   interfaceDeclaration
    ;

classDeclaration
    :   classModifier* 'class' Identifier typeParameters? extendsClass? classBody
    ;

classModifier
    :   Identifier
    ;

typeParameters
    :   '<' Identifier (',' Identifier)* '>'
    ;

extendsClass
    :   'extends' classType
    ;

interfaceDeclaration
    :   classModifier* 'interface' Identifier typeParameters? extendsClass? interfaceBody
    ;

classBody
    :   '{' classBodyDeclaration* '}'
    ;

interfaceBody
    :   '{' interfaceBodyDeclaration* '}'
    ;

classBodyDeclaration
    :   constDeclaration
    |   fieldDeclaration
    |   'export' Identifier ('.' Identifier)? ';'
    |   constructorDeclaration
    |   methodDeclaration
    |   'c__include' StringLiteral ';'
    |   'c__field' StringLiteral ';'
    ;

constDeclaration
    :   'const' Identifier '=' expression ';'
    ;

fieldDeclaration
    :   fieldModifier* typeType Identifier ('=' expression)? ';'
    |   fieldModifier* typeType Identifier (',' Identifier)* ';'
    ;

fieldModifier
    :   'private'
    |   'static'
    |   'inline'
    ;

constructorDeclaration
    :   Identifier formalParameters block
    |   Identifier '(' identifierList? ')' ';'
    ;

identifierList
    :   Identifier (',' Identifier)*
    ;

methodDeclaration
    :   fieldModifier* (typeType|'void') Identifier formalParameters
        (block | ';')
    ;

interfaceBodyDeclaration
    :   constDeclaration
    |   interfaceMethodDeclaration
    ;

interfaceMethodDeclaration
    :   fieldModifier* (typeType|'void') Identifier formalParameters
        ';'
    ;

typeType
    :   scalarType
    |   arrayType
    |   mapType
    ;

scalarType
    :   primitiveType
    |   classType
    ;

primitiveType
    :   'boolean'
    |   'byte'
    |   'short'
    |   'int'
    |   'long'
    |   'float'
    |   'double'
    ;

classType
    :   ( Identifier '.' )* Identifier
    ;

arrayType
    :    scalarType '[' ']'
    |   arrayType '[' ']'
    ;

mapType
    :   Identifier '[' scalarType ']' typeType
    ;

formalParameters
    :   '(' formalParameterList? ')'
    ;

formalParameterList
    :   formalParameter (',' formalParameter)*
    ;

formalParameter
    :   typeType Identifier
    ;

qualifiedName
    :   Identifier ('.' Identifier)*
    ;

// STATEMENTS / BLOCKS

block
    :   '{' statement* '}'
    ;

statement
    :   block
    |   variableDeclaration ';'
    |   variableAssignment ';'
    |   ifStatement
    |   'for' '(' forControl ')' block
    |   'for' forControl block
    |   'while' expression block
    |   'switch' expression block
    |   'typeswitch' expression block
    |   switchLabel
    |   'return' expression? ';'
    |   'break' ';'
    |   'continue' ';'
    |   expression ';'
    |   'c__stmt' StringLiteral ';'
    |   ';'
    ;

variableDeclaration
    :   ('inline')? 'var' Identifier ('=' expression)?
    ;

variableAssignment
    :   assignable '=' expression
    |   assignable ('++' | '--')
    ;

assignable
    :   (expression '.')? Identifier
    |   expression '[' expression ']'
    ;

ifStatement
    :   'if' expression block ('else' elseStatement)?
    ;

elseStatement
    :   block
    |   ifStatement
    ;

forControl
    :   enhancedForControl
    |   forInit? ';' expression ';' forIncrement?
    ;

forInit
    :   variableDeclaration
    |   variableAssignment
    |   expression
    ;

forIncrement
    :   variableAssignment
    |   expression
    ;

enhancedForControl
    :   'var' Identifier (',' Identifier)? ':' expression
    ;

switchLabel
    :   'case' expression ':'
    |   'case' classType Identifier ':'
    |   'default' ':'
    ;

// EXPRESSIONS

expressionList
    :   expression (',' expression)*
    ;

expression
    :   primary
    |   expression '.' Identifier
    |   expression '[' expression ']'
    |   expression '(' expressionList? ')'
    |   'new' creator
    |   ('+'|'-') expression
    |   ('~'|'!') expression
    |   expression ('*'|'/'|'%') expression
    |   expression ('+'|'-') expression
    |   expression ('<<' | '>>') expression
    |   expression ('<=' | '>=' | '>' | '<') expression
    |   expression ('==' | '!=') expression
    |   expression '&' expression
    |   expression '^' expression
    |   expression '|' expression
    |   expression '&&' expression
    |   expression '||' expression
    |   expression '?' expression ':' expression
    |   'super' '.' Identifier
    |   '(' scalarType ')' expression
    |   arrayDefinition
    |   mapDefinition
    ;

primary
    :   '(' expression ')'
    |   'this'
    |   literal
    |   Identifier
    ;

creator
    :   classType '(' expressionList? ')' fieldValues?
    |   arrayType '(' expression ')'
    |   arrayType arrayDefinition?
    |   mapType mapDefinition?
    |   anonymousClassBody
    ;

arrayDefinition
    :    '{' expressionList? '}'
    ;

mapDefinition
    :    '{' '}'
    |    '{' mapEntry (',' mapEntry)* '}'
    ;

mapEntry
    :    expression ':' expression
    ;

literal
    :   IntegerLiteral
    |   FloatingPointLiteral
    |   CharacterLiteral
    |   StringLiteral
    |   BooleanLiteral
    |   'null'
    ;

anonymousClassBody
    :   '{' anonymousClassBodyDeclaration* '}'
    ;

anonymousClassBodyDeclaration
    :   Identifier ':' expression ';'
    |   classBodyDeclaration
    ;

fieldValues
    :    '{' '}'
    |    '{' fieldValue (',' fieldValue)* '}'
    ;

fieldValue
    :    Identifier ':' expression
    ;

// LEXER

// 3.9 Keywords

BOOLEAN       : 'boolean';
BREAK         : 'break';
BYTE          : 'byte';
CASE          : 'case';
CLASS         : 'class';
CONST         : 'const';
CONTINUE      : 'continue';
DEFAULT       : 'default';
DOUBLE        : 'double';
ELSE          : 'else';
EXPORT        : 'export';
EXTENDS       : 'extends';
FLOAT         : 'float';
FOR           : 'for';
IF            : 'if';
IMPORT        : 'import';
INLINE        : 'inline';
INT           : 'int';
INTERFACE     : 'interface';
LONG          : 'long';
NEW           : 'new';
PACKAGE       : 'package';
PRIVATE       : 'private';
RETURN        : 'return';
SHORT         : 'short';
STATIC        : 'static';
SUPER         : 'super';
SWITCH        : 'switch';
THIS          : 'this';
TYPESWITCH    : 'typeswitch';
VAR           : 'var';
VOID          : 'void';
WHILE         : 'while';
C__INCLUDE    : 'c__include';
C__FIELD      : 'c__field';
C__STMT       : 'c__stmt';

// 3.10.1 Integer Literals

IntegerLiteral
    :   DecimalIntegerLiteral
    |   HexIntegerLiteral
    |   OctalIntegerLiteral
    |   BinaryIntegerLiteral
    ;

fragment
DecimalIntegerLiteral
    :   DecimalNumeral IntegerTypeSuffix?
    ;

fragment
HexIntegerLiteral
    :   HexNumeral IntegerTypeSuffix?
    ;

fragment
OctalIntegerLiteral
    :   OctalNumeral IntegerTypeSuffix?
    ;

fragment
BinaryIntegerLiteral
    :   BinaryNumeral IntegerTypeSuffix?
    ;

fragment
IntegerTypeSuffix
    :   [lL]
    ;

fragment
DecimalNumeral
    :   '0'
    |   NonZeroDigit (Digits? | Underscores Digits)
    ;

fragment
Digits
    :   Digit (DigitOrUnderscore* Digit)?
    ;

fragment
Digit
    :   '0'
    |   NonZeroDigit
    ;

fragment
NonZeroDigit
    :   [1-9]
    ;

fragment
DigitOrUnderscore
    :   Digit
    |   '_'
    ;

fragment
Underscores
    :   '_'+
    ;

fragment
HexNumeral
    :   '0' [xX] HexDigits
    ;

fragment
HexDigits
    :   HexDigit (HexDigitOrUnderscore* HexDigit)?
    ;

fragment
HexDigit
    :   [0-9a-fA-F]
    ;

fragment
HexDigitOrUnderscore
    :   HexDigit
    |   '_'
    ;

fragment
OctalNumeral
    :   '0' Underscores? OctalDigits
    ;

fragment
OctalDigits
    :   OctalDigit (OctalDigitOrUnderscore* OctalDigit)?
    ;

fragment
OctalDigit
    :   [0-7]
    ;

fragment
OctalDigitOrUnderscore
    :   OctalDigit
    |   '_'
    ;

fragment
BinaryNumeral
    :   '0' [bB] BinaryDigits
    ;

fragment
BinaryDigits
    :   BinaryDigit (BinaryDigitOrUnderscore* BinaryDigit)?
    ;

fragment
BinaryDigit
    :   [01]
    ;

fragment
BinaryDigitOrUnderscore
    :   BinaryDigit
    |   '_'
    ;

// 3.10.2 Floating-Point Literals

FloatingPointLiteral
    :   DecimalFloatingPointLiteral
    |   HexadecimalFloatingPointLiteral
    ;

fragment
DecimalFloatingPointLiteral
    :   Digits '.' Digits? ExponentPart? FloatTypeSuffix?
    |   '.' Digits ExponentPart? FloatTypeSuffix?
    |   Digits ExponentPart FloatTypeSuffix?
    |   Digits FloatTypeSuffix
    ;

fragment
ExponentPart
    :   ExponentIndicator SignedInteger
    ;

fragment
ExponentIndicator
    :   [eE]
    ;

fragment
SignedInteger
    :   Sign? Digits
    ;

fragment
Sign
    :   [+-]
    ;

fragment
FloatTypeSuffix
    :   [fFdD]
    ;

fragment
HexadecimalFloatingPointLiteral
    :   HexSignificand BinaryExponent FloatTypeSuffix?
    ;

fragment
HexSignificand
    :   HexNumeral '.'?
    |   '0' [xX] HexDigits? '.' HexDigits
    ;

fragment
BinaryExponent
    :   BinaryExponentIndicator SignedInteger
    ;

fragment
BinaryExponentIndicator
    :   [pP]
    ;

// 3.10.3 Boolean Literals

BooleanLiteral
    :   'true'
    |   'false'
    ;

// 3.10.4 Character Literals

CharacterLiteral
    :   '\'' SingleCharacter '\''
    |   '\'' EscapeSequence '\''
    ;

fragment
SingleCharacter
    :   ~['\\\r\n]
    ;

// 3.10.5 String Literals

StringLiteral
    :   '"' StringCharacters? '"'
    ;

fragment
StringCharacters
    :   StringCharacter+
    ;

fragment
StringCharacter
    :   ~["\\]
    |   EscapeSequence
    ;

// 3.10.6 Escape Sequences for Character and String Literals

fragment
EscapeSequence
    :   '\\' [btnfr"'\\]
    |   OctalEscape
    |   UnicodeEscape
    ;

fragment
OctalEscape
    :   '\\' OctalDigit
    |   '\\' OctalDigit OctalDigit
    |   '\\' ZeroToThree OctalDigit OctalDigit
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

fragment
ZeroToThree
    :   [0-3]
    ;

// 3.10.7 The Null Literal

NullLiteral
    :   'null'
    ;

// 3.11 Separators

LPAREN          : '(';
RPAREN          : ')';
LBRACE          : '{';
RBRACE          : '}';
LBRACK          : '[';
RBRACK          : ']';
SEMI            : ';';
COMMA           : ',';
DOT             : '.';

// 3.12 Operators

ASSIGN          : '=';
GT              : '>';
LT              : '<';
BANG            : '!';
TILDE           : '~';
QUESTION        : '?';
COLON           : ':';
EQUAL           : '==';
LE              : '<=';
GE              : '>=';
NOTEQUAL        : '!=';
AND             : '&&';
OR              : '||';
INC             : '++';
DEC             : '--';
ADD             : '+';
SUB             : '-';
MUL             : '*';
DIV             : '/';
BITAND          : '&';
BITOR           : '|';
CARET           : '^';
MOD             : '%';

//ADD_ASSIGN      : '+=';
//SUB_ASSIGN      : '-=';
//MUL_ASSIGN      : '*=';
//DIV_ASSIGN      : '/=';
//AND_ASSIGN      : '&=';
//OR_ASSIGN       : '|=';
//XOR_ASSIGN      : '^=';
//MOD_ASSIGN      : '%=';
//LSHIFT_ASSIGN   : '<<=';
//RSHIFT_ASSIGN   : '>>=';

// 3.8 Identifiers (must appear after all keywords in the grammar)

Identifier
    :   JavaLetter JavaLetterOrDigit*
    ;

fragment
JavaLetter
    :   [a-zA-Z$_] // these are the "java letters" below 0x7F
    |   // covers all characters above 0x7F which are not a surrogate
        ~[\u0000-\u007F\uD800-\uDBFF]
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
    ;

fragment
JavaLetterOrDigit
    :   [a-zA-Z0-9$_] // these are the "java letters or digits" below 0x7F
    |   // covers all characters above 0x7F which are not a surrogate
        ~[\u0000-\u007F\uD800-\uDBFF]
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
    ;

//
// Additional symbols not defined in the lexical specification
//

ELLIPSIS : '...';

//
// Whitespace and comments
//

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> channel(HIDDEN)
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> channel(HIDDEN)
    ;
