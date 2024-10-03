package com.compilador.controller.editor;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class LineNumbering extends JTextArea{
    private JTextArea textArea;

    public LineNumbering(JTextArea textArea) {
        // Constructor
        this.textArea = textArea;
        setEditable(false); // El área de los números no es editable
        setBackground(Color.LIGHT_GRAY); // Fondo del área de los números de línea
        setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12)); // Fuente
        setForeground(Color.BLACK); // Color del texto

        // Eventos para mantener actualizada el área de números
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            // Verifica si se inserta algo en el documento
            public void insertUpdate(DocumentEvent e) { updateLineNumbers(); }
            // Verifica si se elimina una porción del documento
            public void removeUpdate(DocumentEvent e) { updateLineNumbers(); }
            // Verifica si se realiza algún cambio en el documento
            public void changedUpdate(DocumentEvent e) { updateLineNumbers(); }
        });

        textArea.addCaretListener(new CaretListener() {
            // Verifica la posición del cursor para actualizar el área de números
            public void caretUpdate(CaretEvent e) { updateLineNumbers(); }
        });

        textArea.addComponentListener(new ComponentAdapter() {
            // Verifica si hay algún cambio de tamaño en la interfaz
            public void componentResized(ComponentEvent e) { updateLineNumbers(); }
        });

        updateLineNumbers();
    }

    // Método que actualiza los números de las líneas
    public void updateLineNumbers() {
        // Obtiene la longitud del texto
        int caretPosition = textArea.getDocument().getLength();
        // Representa al documento completo
        Element root = textArea.getDocument().getDefaultRootElement();
        // Contruye los números de las líneas
        StringBuilder lineNumbersText = new StringBuilder();
        for (int i = 1; i <= root.getElementIndex(caretPosition) + 1; i++) {
            lineNumbersText.append(i).append(System.lineSeparator());
        }
        // Actualiza el texto de la numeración
        setText(lineNumbersText.toString());
    }
}