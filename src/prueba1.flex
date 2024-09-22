import java_cup.runtime.Symbol;

%%
%cup
%class Lexer
%line
%column
%char

DIGITO = [1-9]
ZERO = 0
NUMERO = {ZERO}|{DIGITO}+
LETRA = [a-zA-Z]
ESPACIO = [ \t\f\n\r]+
ID = {LETRA}({LETRA}|{NUMERO}|_{LETRA}|{NUMERO})*
CTE_REAL = ({NUMERO}* {NUMERO}+)|({NUMERO}+ {NUMERO}*)
CTE_INT = {NUMERO}+
CTE_STR = \"({LETRA}|[^\"])*\"
CTE_BIN = 0b(0|1)+
COMMENT = "//\\*([^*]|\\*+[^/])*\\*//"

%%

<YYINITIAL> {

    "while"         {System.out.println("Token OP_WHILE encontrado, Lexema"+ yytext());}
    "if"            {System.out.println("Token OP_IF encontrado, Lexema"+ yytext());}
    "else"          {System.out.println("Token OP_ELSE encontrado, Lexema"+ yytext());}
    "WRITE"         {System.out.println("Token OP_WRITE encontrado, Lexema"+ yytext());}
    "DECLARE.SECTION" {System.out.println("Token OP_DECSEC encontrado, Lexema"+ yytext());}
    "ENDDECLARE.SECTION" {System.out.println("Token OP_ENDECSEC encontrado, Lexema"+ yytext());}
    "PROGRAM.SECTION" {System.out.println("Token OP_PROSEC encontrado, Lexema"+ yytext());}
    "ENDPROGRAM.SECTION" {System.out.println("Token OP_ENDPROSEC encontrado, Lexema"+ yytext());}
    "BETWEEN"       {System.out.println("Token OP_BETWEEN encontrado, Lexema"+ yytext());}
    "INT"           {System.out.println("Token OP_INT encontrado, Lexema"+ yytext());}
    "FLOAT"         {System.out.println("Token OP_FLOAT encontrado, Lexema"+ yytext());}
    "CHAR"          {System.out.println("Token OP_CHAR encontrado, Lexema"+ yytext());}

    "+"             {System.out.println("Token OP_SUM encontrado, Lexema"+ yytext());}
    "-"             {System.out.println("Token OP_LESS encontrado, Lexema"+ yytext());}
    "*"             {System.out.println("Token OP_MUL encontrado, Lexema"+ yytext());}
    "/"             {System.out.println("Token OP_DIV encontrado, Lexema"+ yytext());}
    "::="           {System.out.println("Token ASIGN encontrado, Lexema"+ yytext());}
    ":="            {System.out.println("Token DECLA encontrado, Lexema"+ yytext());}
    "("             {System.out.println("Token PAR_OP encontrado, Lexema"+ yytext());}
    ")"             {System.out.println("Token PAR_CL encontrado, Lexema"+ yytext());}
    "["             {System.out.println("Token SQR_OP encontrado, Lexema"+ yytext());}
    "]"             {System.out.println("Token SQR_CL encontrado, Lexema"+ yytext());}
    "{"             {System.out.println("Token BRA_OP encontrado, Lexema"+ yytext());}
    "}"             {System.out.println("Token BRA_CL encontrado, Lexema"+ yytext());}
    ";"             {System.out.println("Token DOTCOM encontrado, Lexema"+ yytext());}
    "."             {System.out.println("Token DOT encontrado, Lexema"+ yytext());}
    ","             {System.out.println("Token COMA encontrado, Lexema"+ yytext());}
    ":"             {System.out.println("Token DOUBLEDOT encontrado, Lexema"+ yytext());}
    "<"             {System.out.println("Token MINUS encontrado, Lexema"+ yytext());}
    "<="            {System.out.println("Token MINUS_EQ encontrado, Lexema"+ yytext());}
    ">"             {System.out.println("Token MAY encontrado, Lexema"+ yytext());}
    ">="            {System.out.println("Token MAY_EQ encontrado, Lexema"+ yytext());}
    "=="            {System.out.println("Token EQ encontrado, Lexema"+ yytext());}
    "!="            {System.out.println("Token NEQ encontrado, Lexema"+ yytext());}
    "!"             {System.out.println("Token NOT encontrado, Lexema"+ yytext());}
    "&&"            {System.out.println("Token AND encontrado, Lexema"+ yytext());}
    "||"            {System.out.println("Token OR encontrado, Lexema"+ yytext());}

    {ID}            {yytext();}
    {CTE_INT}       {System.out.println("Token CTE_INT encontrado, Lexema"+ yytext());}
    {CTE_REAL}      {System.out.println("Token CTE_REAL encontrado, Lexema"+ yytext());}
    {CTE_STR}       {System.out.println("Token CTE_STR encontrado, Lexema"+ yytext());}
    {CTE_BIN}       {System.out.println("Token CTE_BIN encontrado, Lexema"+ yytext());}
    {ESPACIO}       {/* No se realiza accion */}
    {COMMENT}       {/* No se realiza accion */}

}

[^]     { throw new Error("Caracter no permitido: <" + yytext() + "> en la linea " + yyline); }
