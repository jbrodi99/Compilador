package com.compilador.model;

import com.compilador.model.Simbolos;
import com.compilador.controller.lexico.TablaSimbolos;

import java_cup.runtime.Symbol;



%%

%cup
%cupsym Simbolos
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

%{
/**
*   Instancia de tabla de simbolos
*
*/
TablaSimbolos symtbl = new TablaSimbolos("ts.txt");

%}

%%

<YYINITIAL> {

    "while"         { return new Symbol(Simbolos.OP_WHILE.ordinal(), yytext()); }
    "if"            { return new Symbol(Simbolos.OP_IF.ordinal(), yytext()); }
    "else"          { return new Symbol(Simbolos.OP_ELSE.ordinal(), yytext()); }
    "WRITE"         { return new Symbol(Simbolos.OP_WRITE.ordinal(), yytext()); }
    "DECLARE.SECTION" {symtbl.leerArchivo();
                       return new Symbol(Simbolos.OP_DECSEC.ordinal(), yytext()); }
    "ENDDECLARE.SECTION" { return new Symbol(Simbolos.OP_ENDECSEC.ordinal(), yytext()); }
    "PROGRAM.SECTION" { return new Symbol(Simbolos.OP_PROSEC.ordinal(), yytext()); }
    "ENDPROGRAM.SECTION" { return new Symbol(Simbolos.OP_ENDPROSEC.ordinal(), yytext()); }
    "BETWEEN"       { return new Symbol(Simbolos.OP_BETWEEN.ordinal(), yytext()); }
    "INT"           { return new Symbol(Simbolos.OP_INT.ordinal(), yytext()); }
    "FLOAT"         { return new Symbol(Simbolos.OP_FLOAT.ordinal(), yytext()); }
    "CHAR"          { return new Symbol(Simbolos.OP_CHAR.ordinal(), yytext()); }

    "+"             { return new Symbol(Simbolos.OP_SUM.ordinal(), yytext()); }
    "-"             { return new Symbol(Simbolos.OP_LESS.ordinal(), yytext()); }
    "*"             { return new Symbol(Simbolos.OP_MUL.ordinal(), yytext()); }
    "/"             { return new Symbol(Simbolos.OP_DIV.ordinal(), yytext()); }
    "::="           { return new Symbol(Simbolos.ASIGN.ordinal(), yytext()); }
    ":="            { return new Symbol(Simbolos.DECLA.ordinal(), yytext()); }
    "("             { return new Symbol(Simbolos.PAR_OP.ordinal(), yytext()); }
    ")"             { return new Symbol(Simbolos.PAR_CL.ordinal(), yytext()); }
    "["             { return new Symbol(Simbolos.SQR_OP.ordinal(), yytext()); }
    "]"             { return new Symbol(Simbolos.SQR_CL.ordinal(), yytext()); }
    "{"             { return new Symbol(Simbolos.BRA_OP.ordinal(), yytext()); }
    "}"             { return new Symbol(Simbolos.BRA_CL.ordinal(), yytext()); }
    ";"             { return new Symbol(Simbolos.DOTCOM.ordinal(), yytext()); }
    "."             { return new Symbol(Simbolos.DOT.ordinal(), yytext()); }
    ","             { return new Symbol(Simbolos.COMA.ordinal(), yytext()); }
    ":"             { return new Symbol(Simbolos.DOUBLEDOT.ordinal(), yytext()); }
    "<"             { return new Symbol(Simbolos.MINUS.ordinal(), yytext()); }
    "<="            { return new Symbol(Simbolos.MINUS_EQ.ordinal(), yytext()); }
    ">"             { return new Symbol(Simbolos.MAY.ordinal(), yytext()); }
    ">="            { return new Symbol(Simbolos.MAY_EQ.ordinal(), yytext()); }
    "=="            { return new Symbol(Simbolos.EQ.ordinal(), yytext()); }
    "!="            { return new Symbol(Simbolos.NEQ.ordinal(), yytext()); }
    "!"             { return new Symbol(Simbolos.NOT.ordinal(), yytext()); }
    "&&"            { return new Symbol(Simbolos.AND.ordinal(), yytext()); }
    "||"            { return new Symbol(Simbolos.OR.ordinal(), yytext()); }

    {ID}            {   symtbl.agregarSimbolo("_" + yytext(), "ID", yytext(), null);
                        return new Symbol(Simbolos.ID.ordinal(), yytext()); }
    {CTE_INT}       {   symtbl.agregarSimbolo("_" + yytext(), "CTE_INT", yytext(), null);
                        return new Symbol(Simbolos.CTE_INT.ordinal(), yytext()); }
    {CTE_REAL}      {   symtbl.agregarSimbolo("_" + yytext(), "CTE_REAL", yytext(),null);
                        return new Symbol(Simbolos.CTE_REAL.ordinal(), yytext()); }
    {CTE_STR}       {    return new Symbol(Simbolos.CTE_STR.ordinal(), yytext()); }
    {CTE_BIN}       {   symtbl.agregarSimbolo("_" + yytext(), "CTE_BIN", yytext(), null);
                        return new Symbol(Simbolos.CTE_BIN.ordinal(), yytext()); }
    {ESPACIO}       { /* No se realiza acción */ }
    {COMMENT}       { /* No se realiza acción */ }

}


[^]     { throw new Error("Caracter no permitido: <" + yytext() + "> en la línea " + yyline); }
