package com.compilador.controller.editor;

import com.compilador.model.Lexico; // Asegúrate de que este es el nombre del lexer generado
import com.compilador.model.sym;
import com.compilador.model.parser;
import com.compilador.model.Simbolos;
import java_cup.runtime.Symbol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.IOException;
import javax.swing.JTextArea;

import java.awt.Font;

public class AnalyzeCodeAction implements ActionListener {
    private final JTextArea textArea;
    private final JTextArea resultLexicalArea;
    private final JTextArea resultSyntacticArea;

    /*
    public AnalyzeCodeAction(JTextArea textArea, JTextArea resultArea) {
        this.textArea = textArea;
        this.resultArea = resultArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String code = textArea.getText();
        StringBuilder result = new StringBuilder();
        try {
            // Crear el Lexer con el código ingresado en el JTextArea
            Lexico lexico = new Lexico(new StringReader(code));
            Symbol token;
            while ((token = lexico.next_token()).sym != sym.EOF) {
                // Agregar el token al resultado
                String tokenName = Simbolos.values()[token.sym].name();
                result.append("Token: '").append(tokenName)
                        .append("' encontrado, Lexema: '").append(lexico.yytext())
                        .append("'\n");
            }
            // Mostrar los resultados en el JTextArea de resultados
            resultArea.setText(result.toString());
        } catch (Error ex) {
            // Manejar el error de caracteres no permitidos
            //JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            resultArea.setText("Error: " + ex.getMessage());
        } catch (Exception ex) {
            // Manejar otros posibles errores
            //JOptionPane.showMessageDialog(null, "Error durante el análisis: " + ex.getMessage());
            resultArea.setText("Error durante el análisis: " + ex.getMessage());
        }
    }*/

    /*
    public AnalyzeCodeAction(JTextArea textArea, JTextArea resultArea) {
        this.textArea = textArea;
        this.resultArea = resultArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String code = textArea.getText(); // Leer el texto del área de código
        resultArea.setText(""); // Limpiar el área de resultados

        // Redirigir la salida estándar a JTextArea
        PrintStream printStream = new JTextAreaPrintStream(resultArea);
        PrintStream originalOut = System.out; // Guardar el valor original de System.out
        System.setOut(printStream); // Redirigir System.out

        try {
            // Crear un lector para el código
            StringReader reader = new StringReader(code);

            // Instanciar el lexer y parser
            Lexico lexer = new Lexico(reader);
            parser parser = new parser(lexer);

            // Ejecutar el parser y capturar el resultado
            Symbol parseResult = parser.parse();
            resultArea.append("Análisis sintáctico completado sin errores.\n");

            // Imprimir el árbol de análisis o cualquier otro detalle que desees
            resultArea.append("Resultado del parser: " + parseResult.value);
        } catch (Exception ex) {
            resultArea.append("Error durante el análisis: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            // Restaurar la salida estándar
            System.setOut(originalOut);
        }
    }*/

    public AnalyzeCodeAction(JTextArea textArea, JTextArea lexicalResultArea, JTextArea syntacticResultArea) {
        this.textArea = textArea;
        this.resultLexicalArea = lexicalResultArea;
        this.resultSyntacticArea = syntacticResultArea;

        // Cambiar el tamaño de la fuente de los JTextAreas que van a mostrar los resultados
        Font font = new Font("Arial", Font.PLAIN, 16);
        resultLexicalArea.setFont(font);
        resultSyntacticArea.setFont(font);
    }

    public void actionPerformed(ActionEvent e) {
        String code = textArea.getText(); // Leer el texto del área de código
        resultLexicalArea.setText(""); // Limpiar el área de resultados léxicos
        resultSyntacticArea.setText(""); // Limpiar el área de resultados sintácticos

        // Redirigir System.out a las áreas de resultado
        PrintStream lexOutput = new JTextAreaPrintStream(resultLexicalArea);
        PrintStream synOutput = new JTextAreaPrintStream(resultSyntacticArea);

        // Guardar el PrintStream original (por si quieres restaurarlo después)
        PrintStream originalSystemOut = System.out;

        // Redirigir System.out a las áreas de texto
        System.setOut(lexOutput);

        resultLexicalArea.append("*** Resultados Lexicos ***\n\n");

        try {
            // Crear un lector para el código
            StringReader reader = new StringReader(code);

            // Instanciar el lexer y parser
            Lexico lexer = new Lexico(reader);
            // Realizar análisis léxico e imprimir tokens en lexicalResultArea
            Symbol token;
            while ((token = lexer.next_token()).sym != sym.EOF) {
                String tokenName = Simbolos.values()[token.sym - 2].name();
                System.out.println("Token Reconocido: " + tokenName); // Se imprimirá en lexOutput
            }

            // Reiniciar el lector para el análisis sintáctico
            reader = new StringReader(code);
            lexer = new Lexico(reader); // Crear un nuevo lexer con el lector reiniciado

            // Redirigir System.out a la salida sintáctica
            System.setOut(synOutput);

            resultSyntacticArea.append("*** Resultados Sintacticos ***\n\n");

            parser parser = new parser(lexer);

            // Ejecutar el parser y capturar el resultado
            Symbol parseResult = parser.parse();
            System.out.println("Analisis sintactico completado sin errores."); // Salida a synOutput
        } catch (Exception ex) {
            System.out.println("Error durante el analisis sintactico"); // Salida a synOutput
        } finally {
            // Restaurar el System.out original al finalizar
            System.setOut(originalSystemOut);
        }
    }
}
