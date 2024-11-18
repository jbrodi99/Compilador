package com.compilador.controller.editor;

import java.io.PrintStream;
import javax.swing.JTextArea;

/**
 * La clase JTextAreaPrintStream extiende PrintStream para redirigir la salida
 * a un JTextArea en una interfaz gráfica. En lugar de enviar la salida a la consola,
 * esta clase envía los datos a un JTextArea, permitiendo visualizar mensajes de salida
 * en la interfaz gráfica.
 */
public class JTextAreaPrintStream extends PrintStream {
    /**
     * Constructor de JTextAreaPrintStream que toma un JTextArea como parámetro.
     * Utiliza un TextAreaOutputStream para redirigir la salida a este JTextArea.
     *
     * @param textArea el JTextArea donde se mostrará la salida.
     */
    public JTextAreaPrintStream(JTextArea textArea) {
        // Llama al constructor de PrintStream con un TextAreaOutputStream,
        // que redirige la salida a textArea.
        super(new TextAreaOutputStream(textArea)); // Redirige la salida a un flujo personalizado
    }
}
