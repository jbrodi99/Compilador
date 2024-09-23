import java_cup.runtime.Symbol;

%%

%cup
%class Lexico
%line
%column
%char

DIGITO = [1-9]
ZERO = 0
NUMERO = {ZERO}|{DIGITO}+ 
LETRA = [a-zA-Z]
ESPACIO = [ \t\f\n\r]+
ID = {LETRA}({LETRA}|{NUMERO}|_{LETRA}|_{NUMERO})*
CTE_REAL = ({NUMERO}* {NUMERO}+)|({NUMERO}+ {NUMERO}*)
CTE_INT = {NUMERO}+
CTE_STR = \"({LETRA}|[^\"])*\"
CTE_BIN = 0b(0|1)+
COMMENT = "//\\*([^*]|\\*+[^/])*\\*//"

%%

<YYINITIAL> {

    "while"         { return new Symbol(sym.OP_WHILE, yytext()); }
    "if"            { return new Symbol(sym.OP_IF, yytext()); }
    "else"          { return new Symbol(sym.OP_ELSE, yytext()); }
    "WRITE"         { return new Symbol(sym.OP_WRITE, yytext()); }
    "DECLARE.SECTION" { return new Symbol(sym.OP_DECSEC, yytext()); }
    "ENDDECLARE.SECTION" { return new Symbol(sym.OP_ENDECSEC, yytext()); }
    "PROGRAM.SECTION" { return new Symbol(sym.OP_PROSEC, yytext()); }
    "ENDPROGRAM.SECTION" { return new Symbol(sym.OP_ENDPROSEC, yytext()); }
    "BETWEEN"       { return new Symbol(sym.OP_BETWEEN, yytext()); }
    "INT"           { return new Symbol(sym.OP_INT, yytext()); }
    "FLOAT"         { return new Symbol(sym.OP_FLOAT, yytext()); }
    "CHAR"          { return new Symbol(sym.OP_CHAR, yytext()); }

    "+"             { return new Symbol(sym.OP_SUM, yytext()); }
    "-"             { return new Symbol(sym.OP_LESS, yytext()); }
    "*"             { return new Symbol(sym.OP_MUL, yytext()); }
    "/"             { return new Symbol(sym.OP_DIV, yytext()); }
    "::="           { return new Symbol(sym.ASIGN, yytext()); }
    ":="            { return new Symbol(sym.DECLA, yytext()); }
    "("             { return new Symbol(sym.PAR_OP, yytext()); }
    ")"             { return new Symbol(sym.PAR_CL, yytext()); }
    "["             { return new Symbol(sym.SQR_OP, yytext()); }
    "]"             { return new Symbol(sym.SQR_CL, yytext()); }
    "{"             { return new Symbol(sym.BRA_OP, yytext()); }
    "}"             { return new Symbol(sym.BRA_CL, yytext()); }
    ";"             { return new Symbol(sym.DOTCOM, yytext()); }
    "."             { return new Symbol(sym.DOT, yytext()); }
    ","             { return new Symbol(sym.COMA, yytext()); }
    ":"             { return new Symbol(sym.DOUBLEDOT, yytext()); }
    "<"             { return new Symbol(sym.MINUS, yytext()); }
    "<="            { return new Symbol(sym.MINUS_EQ, yytext()); }
    ">"             { return new Symbol(sym.MAY, yytext()); }
    ">="            { return new Symbol(sym.MAY_EQ, yytext()); }
    "=="            { return new Symbol(sym.EQ, yytext()); }
    "!="            { return new Symbol(sym.NEQ, yytext()); }
    "!"             { return new Symbol(sym.NOT, yytext()); }
    "&&"            { return new Symbol(sym.AND, yytext()); }
    "||"            { return new Symbol(sym.OR, yytext()); }

    {ID}            { return new Symbol(sym.ID, yytext()); }
    {CTE_INT}       { return new Symbol(sym.CTE_INT, yytext()); }
    {CTE_REAL}      { return new Symbol(sym.CTE_REAL, yytext()); }
    {CTE_STR}       { return new Symbol(sym.CTE_STR, yytext()); }
    {CTE_BIN}       { return new Symbol(sym.CTE_BIN, yytext()); }
    {ESPACIO}       { /* No se realiza acción */ }
    {COMMENT}       { /* No se realiza acción */ }

}

[^]     { throw new Error("Caracter no permitido: <" + yytext() + "> en la línea " + yyline); }
