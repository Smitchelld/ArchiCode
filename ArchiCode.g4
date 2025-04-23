grammar ArchiCode;

program: statement+ EOF;

statement:showStatement
         |defineStatement
         |assignStatement
         |requestStatement;

showStatement: 'show' expr;

defineStatement: 'Define' VarName '=' expr;

assignStatement: VarName '=' expr;

requestStatement: 'request' VarName;

expr: expr '+' expr      # addExpr
    | expr '-' expr      # subExpr
    | expr '*' expr      # mulExpr
    | expr '/' expr      # divExpr
    | INT                # intExpr
    | STRING             # stringExpr
    | VarName            # varExpr;

VarName: [a-z][a-zA-Z0-9_]*;
INT: [0-9]+;
STRING: '"' ( ~["\r\n] | '""' )* '"';
WS: [ \t\r\n]+ -> skip;
