package com.compilador.model;

import com.compilador.model.Simbolos;
import com.compilador.controller.lexico.TablaSimbolos;

import java_cup.runtime.Symbol;


%%

%cup
%class Lexico
%line
%column
%char
%public

%{
    private final int MAX_LEN_STR = 30;
    private final int MAX_LEN_INT = 16;
%}


DIGITO = [1-9]
ZERO = 0
NUMERO = {ZERO}|{DIGITO}+ 
LETRA = [a-zA-Z]
ESPACIO = [ \t\f\n\r]+
SYMBOL = "+"|"-"|"_"|"*"|"/"|"="|"=="|"!="|"<"|">"|"<="|">="|"("|")"|"{"|"}"|"["|"]"|","|";"|"."
ID = {LETRA}({LETRA}|{NUMERO}|_{LETRA}|_{NUMERO})*
CTE_INT = {NUMERO}+
CTE_REAL = ({NUMERO}*"."{NUMERO}+)|({NUMERO}+"."{NUMERO}*)
CTE_STR = \"({LETRA}|[^\"])*\"
CTE_BIN = 0b(0|1)+
COMMENT = "//*"({LETRA}|{NUMERO}|{ESPACIO}|{SYMBOL})*"*//"

%{
/**
*   Instancia de tabla de simbolos
*
*/
TablaSimbolos symtbl = new TablaSimbolos("ts.txt");


%}

%%

/*
<YYINITIAL> {
    "while"         { return new Symbol(Simbolos.OP_WHILE.ordinal(), yytext()); }
    "if"            { return new Symbol(Simbolos.OP_IF.ordinal(), yytext()); }
    "else"          { return new Symbol(Simbolos.OP_ELSE.ordinal(), yytext()); }
    "WRITE"         { return new Symbol(Simbolos.OP_WRITE.ordinal(), yytext()); }
    "DECLARE.SECTION" {
            enDeclaracion = true;
            symtbl.leerArchivo();
            return new Symbol(Simbolos.OP_DECSEC.ordinal(), yytext());
        }
    "ENDDECLARE.SECTION" {
            if(!enDeclaracion){
                throw new Error("Cierra de DECLARACION sin una seccion de apertura en la línea " + (yyline + 1));
            }else{
                enDeclaracion = false;  // Salimos de sección de declaraciones
                return new Symbol(Simbolos.OP_ENDECSEC.ordinal(), yytext());
            }
        }

    "PROGRAM.SECTION" {
            if(enDeclaracion){
                throw new Error("Seccion de PROGRAMA dentro del area de DECLARACION en la línea " + (yyline + 1));
            }else{
                enPrograma = true;
                return new Symbol(Simbolos.OP_PROSEC.ordinal(), yytext());
            }
         }
    "ENDPROGRAM.SECTION" {
            if(!enPrograma){
                throw new Error("Cierra de DECLARACION sin una seccion de apertura en la línea " + (yyline + 1));
            }else{
                enPrograma = false;
                return new Symbol(Simbolos.OP_ENDPROSEC.ordinal(), yytext());
            }
         }
    "BETWEEN"       { return new Symbol(Simbolos.OP_BETWEEN.ordinal(), yytext()); }
    "INT"           { return new Symbol(Simbolos.OP_INT.ordinal(), yytext()); }
    "FLOAT"         { return new Symbol(Simbolos.OP_FLOAT.ordinal(), yytext()); }
    "STRING"         { return new Symbol(Simbolos.OP_STRING.ordinal(), yytext()); }

    "+"             { return new Symbol(Simbolos.OP_SUM.ordinal(), yytext()); }
    "-"             { return new Symbol(Simbolos.OP_LESS.ordinal(), yytext()); }
    "*"             { return new Symbol(Simbolos.OP_MUL.ordinal(), yytext()); }
    "/"             { return new Symbol(Simbolos.OP_DIV.ordinal(), yytext()); }
    "::="           { return new Symbol(Simbolos.ASIGN.ordinal(), yytext()); }
    ":="            {
            if(enDeclaracion){
                return new Symbol(Simbolos.DECLA.ordinal(), yytext());
            }else{
                throw new Error("Declaracion fuera de la seccion en la línea " + (yyline + 1));
            }
    }

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

    {ID}            {   symtbl.agregarSimbolo("_" + yytext(), "ID", null, null);
                        return new Symbol(Simbolos.ID.ordinal(), yytext()); }
    {CTE_INT} {

        if (yytext().length() - 2 > MAX_LEN_INT) {
            throw new Error("CTE_INT excede el máximo de 16 bits: <" + yytext() + "> en la línea " + (yyline + 1));
        }

        symtbl.agregarSimbolo("_" + yytext(), "CTE_INT", yytext(), null);
        return new Symbol(Simbolos.CTE_INT.ordinal(), yytext());
    }

    {CTE_REAL} {
        try {
            Float valor = Float.parseFloat(yytext());

            // Verificar si el valor está dentro del rango de float de 32 bits
            if (valor > Float.MAX_VALUE || valor < -Float.MAX_VALUE) {
                throw new Error("CTE_REAL excede el máximo de 32 bits: <" + yytext() + "> en la línea " + (yyline + 1));
            }

            // Verificar si el valor es demasiado pequeño para ser representado como float
            if (valor != 0 && Math.abs(valor) < Float.MIN_NORMAL) {
                throw new Error("CTE_REAL es demasiado pequeño para 32 bits: <" + yytext() + "> en la línea " + (yyline + 1));
            }

        } catch (NumberFormatException e) {
            throw new Error("CTE_REAL no es un número válido: <" + yytext() + "> en la línea " + (yyline + 1));
        }

        symtbl.agregarSimbolo("_" + yytext(), "CTE_REAL", yytext(), null);
        return new Symbol(Simbolos.CTE_REAL.ordinal(), yytext());
    }


    {CTE_STR} {
        if (yytext().length() - 2 > MAX_LEN_STR) {  // Se resta 2 para descontar las comillas
            throw new Error("CTE_STR muy larga (máximo 30 caracteres): <" + yytext() + "> en la línea " + (yyline + 1));
        }
        symtbl.agregarSimbolo("_" + yytext(), "CTE_STR", yytext(), yytext().length() - 2);
        return new Symbol(Simbolos.CTE_STR.ordinal(), yytext());
    }

    {CTE_BIN} {
            if (yytext().length() - 2 > 16) { // Se resta 2 para descontar el 0b
                throw new Error("CTE_BIN excede el máximo de 16 bits: <" + yytext() + "> en la línea " + (yyline + 1));
            }
            symtbl.agregarSimbolo("_" + yytext(), "CTE_BIN", yytext(), null);
            return new Symbol(Simbolos.CTE_BIN.ordinal(), yytext());
    }

    {ESPACIO}  { /* No se realiza acción */ }
    {COMMENT}  { /* No se realiza acción */ }
}


[^]     { throw new Error("Caracter no permitido: <" + yytext() + "> en la línea " + (yyline + 1)); }
%%
 */

 <YYINITIAL> {
     "while"         { return new Symbol(sym.OP_WHILE, yytext()); }
     "if"            { return new Symbol(sym.OP_IF, yytext()); }
     "else"          { return new Symbol(sym.OP_ELSE, yytext()); }
     "WRITE"         { return new Symbol(sym.OP_WRITE, yytext()); }
     "DECLARE.SECTION" {
          symtbl.leerArchivo();
          return new Symbol(sym.OP_DECSEC, yytext());
      }
     "ENDDECLARE.SECTION" { return new Symbol(sym.OP_ENDECSEC, yytext()); }

     "PROGRAM.SECTION" { return new Symbol(sym.OP_PROSEC, yytext()); }
     "ENDPROGRAM.SECTION" { return new Symbol(sym.OP_ENDPROSEC, yytext()); }
     "BETWEEN"       { return new Symbol(sym.OP_BETWEEN, yytext()); }
     "INT"           { return new Symbol(sym.OP_INT, yytext()); }
     "FLOAT"         { return new Symbol(sym.OP_FLOAT, yytext()); }
     "STRING"         { return new Symbol(sym.OP_STRING, yytext()); }

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
     ","             { return new Symbol(sym.COMA, yytext()); }
     "<"             { return new Symbol(sym.MINUS, yytext()); }
     "<="            { return new Symbol(sym.MINUS_EQ, yytext()); }
     ">"             { return new Symbol(sym.MAY, yytext()); }
     ">="            { return new Symbol(sym.MAY_EQ, yytext()); }
     "=="            { return new Symbol(sym.EQ, yytext()); }
     "!="            { return new Symbol(sym.NEQ, yytext()); }
     "!"             { return new Symbol(sym.NOT, yytext()); }
     "&&"            { return new Symbol(sym.AND, yytext()); }
     "||"            { return new Symbol(sym.OR, yytext()); }

     {ID}            {   symtbl.agregarSimbolo(yytext(), "ID", null, null);
                         return new Symbol(sym.ID, yytext()); }
     {CTE_INT} {

         if (yytext().length() - 2 > MAX_LEN_INT) {
             System.out.println("CTE_INT excede el máximo de 16 bits: <" + yytext() + "> en la línea " + (yyline + 1));
             throw new Error("CTE_INT excede el máximo de 16 bits: <" + yytext() + "> en la línea " + (yyline + 1));
         }

         symtbl.agregarSimbolo("_" + yytext(), "CTE_INT", yytext(), null);
         return new Symbol(sym.CTE_INT, yytext());
     }

     {CTE_REAL} {
         try {
             Float valor = Float.parseFloat(yytext());

             // Verificar si el valor está dentro del rango de float de 32 bits
             if (valor > Float.MAX_VALUE || valor < -Float.MAX_VALUE) {
                 System.out.println("CTE_REAL excede el máximo de 32 bits: <" + yytext() + "> en la línea " + (yyline + 1));
                 throw new Error("CTE_REAL excede el máximo de 32 bits: <" + yytext() + "> en la línea " + (yyline + 1));
             }

             // Verificar si el valor es demasiado pequeño para ser representado como float
             if (valor != 0 && Math.abs(valor) < Float.MIN_NORMAL) {
                 System.out.println("CTE_REAL es demasiado pequeño para 32 bits: <" + yytext() + "> en la línea " + (yyline + 1));
                 throw new Error("CTE_REAL es demasiado pequeño para 32 bits: <" + yytext() + "> en la línea " + (yyline + 1));
             }

         } catch (NumberFormatException e) {
             System.out.println("CTE_REAL no es un número válido: <" + yytext() + "> en la línea " + (yyline + 1));
             throw new Error("CTE_REAL no es un número válido: <" + yytext() + "> en la línea " + (yyline + 1));
         }

         symtbl.agregarSimbolo("_" + yytext(), "CTE_REAL", yytext(), null);
         return new Symbol(sym.CTE_REAL, yytext());
     }


     {CTE_STR} {
         if (yytext().length() - 2 > MAX_LEN_STR) {  // Se resta 2 para descontar las comillas
             System.out.println("CTE_STR muy larga (máximo 30 caracteres): <" + yytext() + "> en la línea " + (yyline + 1));
             throw new Error("CTE_STR muy larga (máximo 30 caracteres): <" + yytext() + "> en la línea " + (yyline + 1));
         }
         symtbl.agregarSimbolo("_" + yytext(), "CTE_STR", yytext(), yytext().length() - 2);
         return new Symbol(sym.CTE_STR, yytext());
     }

     {CTE_BIN} {
             if (yytext().length() - 2 > 16) { // Se resta 2 para descontar el 0b
                 System.out.println("CTE_BIN excede el máximo de 16 bits: <" + yytext() + "> en la línea " + (yyline + 1));
                 throw new Error("CTE_BIN excede el máximo de 16 bits: <" + yytext() + "> en la línea " + (yyline + 1));
             }
             symtbl.agregarSimbolo("_" + yytext(), "CTE_BIN", yytext(), null);
             return new Symbol(sym.CTE_BIN, yytext());
     }

     {ESPACIO}  { /* No se realiza acción */ }
     {COMMENT}  { /* No se realiza acción */ }
 }


 [^]  {
          System.out.println("Caracter no permitido: <" + yytext() + "> en la linea " + (yyline + 1));
          throw new Error("Caracter no permitido: <" + yytext() + "> en la linea " + (yyline + 1));
      }