grammar ArchiCode;

program: statement+ EOF;

statement
    : showStatement
    | defineStatement
    | assignStatement
    | requestStatement
    | repeatStatement
    | checkStatement
    | blueprintStatement
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

assignStatement
    : VarName '=' expr
    ;

requestStatement
    : 'request' VarName
    ;

blueprintStatement
    : 'blueprint' CapitalVarName '(' paramList? ')' 'delivers' VarName ('=' expr)? block
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
    : expr op=('*'|'/') expr     # mulDivExpr
    | expr op=('+'|'-') expr     # addSubExpr
    | expr '==' expr             # eqExpr
    | expr '<' expr              # ltExpr
    | expr '>' expr              # gtExpr
    | expr '(' exprList? ')'     # funcCallExpr
    | INT                        # intExpr
    | STRING                     # stringExpr
    | VarName                   # varExpr
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

STRING
    : '"' (ESC|.)*? '"' ;

fragment ESC
    : '\\"' | '\\\\' ; // 2-znakowa sekwencja \" oraz \\

LINE_COMMENT
    : '>>' ~[\r\n]* -> skip
    ;

MULTILINE_COMMENT
    : '>>>' .*? '<<<' -> skip
    ;

INLINE_COMMENT
    : '>>' .*? '<<' -> skip
    ;

WS
    : [ \t\r\n]+ -> skip
    ;
returnStatement
    : 'return' expr
    ;
