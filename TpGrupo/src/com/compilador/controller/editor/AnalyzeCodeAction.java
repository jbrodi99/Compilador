package com.compilador.controller.editor;

import com.compilador.model.Lexico;
import com.compilador.model.Simbolos;
import java_cup.runtime.Symbol;
import java_cup.sym;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;

public class AnalyzeCodeAction implements ActionListener {
    private final JTextArea textArea;
    private final JTextArea resultArea;

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
    }
}
