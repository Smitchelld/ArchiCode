grammar ArchiCode;

program: statement+ EOF;

statement
    : showStatement
    | defineStatement
    | defineCollectionStatement
    | assignStatement
    | requestStatement
    | repeatStatement
    | checkStatement
    | blueprintStatement
    | blueprintCallStatement
    | coreStatement
    ;

coreStatement
    : 'Core' '(' paramList? ')' 'delivers' type VarName block
    ;

showStatement
    : 'show' expr
    ;

defineStatement
    : 'define' type? VarName '=' expr
    ;

defineCollectionStatement
    : 'define' ('box' | 'chain' | 'catalog') type VarName ('[' expr ']')? ('=' expr)?
    ;

assignStatement
    : VarName '=' expr
    ;

requestStatement
    : 'request' VarName
    ;

blueprintStatement
    : 'blueprint' CapitalVarName '(' paramList? ')' 'delivers' type VarName ('=' expr)? block
    ;

blueprintCallStatement
    : CapitalVarName expr+ ';'?
    ;

paramList
    : param (',' param)*
    ;

param
    : type? VarName
    ;

repeatStatement
    : 'repeat' INT block                            # repeatFixed
    | 'repeat' 'until' expr block                   # repeatUntil
    | 'repeat' 'for' VarName 'in' VarName block     # repeatFor
    ;

checkStatement
    : 'check' expr 'then' block ( 'otherwise' ( checkStatement | block ) )?
    ;

block
    : '{' statement* '}'
    ;

expr
    : orExpr
    ;
orExpr
    : andExpr ('or' andExpr)*
    ;
andExpr
    : equalityExpr ('and' equalityExpr)*
    ;
equalityExpr
    : relationalExpr (('==' | '!=') relationalExpr )*
    ;
relationalExpr
    : addSubExpr (('<' | '>' |'<=' | '>=') addSubExpr)*
    ;
addSubExpr
    : mulDivExpr (('+' | '-') mulDivExpr)*
    ;
mulDivExpr
    : unaryExpr (('*' | '/') unaryExpr)*
    ;
unaryExpr
    : '-' unaryExpr
    | '+' unaryExpr
    | 'not' unaryExpr
    | atom
    ;
atom
    : CapitalVarName expr+ ';'?                     # funcCallExpr
    | INT                                           # intExpr
    | FLOAT                                         # floatExpr
    | STRING                                        # stringExpr
    | CHAR                                          # charExpr
    | 'true'                                        # boolTrueExpr
    | 'false'                                       # boolFalseExpr
    | 'step' ('@' INT)?                             # stepExpr
    | VarName                                       # varExpr
    | '(' expr ')'                                  # parenExpr
    ;

exprList
    : expr (',' expr)*
    ;

type
    : 'int' | 'float' | 'bool' | 'char' | 'string'
    ;

VarName
    : [a-z][a-zA-Z0-9_]*
    ;

CapitalVarName
    : [A-Z][a-zA-Z0-9_]*
    ;

INT
    : [0-9]+
    ;

FLOAT
    : [0-9]+ '.' [0-9]+
    ;

CHAR
    : '\'' (ESC | ~['\\]) '\''
    ;

STRING
    : '"' (ESC|.)*? '"' ;

fragment ESC
    : '\\"' | '\\\\' ; // 2-znakowa sekwencja \" oraz \\

INLINE_COMMENT
    : '>>' .*? '<<' -> skip
    ;

LINE_COMMENT
    : '>>' ~[\r\n]* -> skip
    ;

MULTILINE_COMMENT
    : '>>>' .*? '<<<' -> skip
    ;

WS
    : [ \t\r\n]+ -> skip
    ;
