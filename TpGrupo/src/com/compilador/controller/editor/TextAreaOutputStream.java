package com.compilador.controller.editor;
import java.io.OutputStream;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 * Clase TextAreaOutputStream.
 *
 * Esta clase permite redirigir la salida de texto (por ejemplo, `System.out` o `System.err`) hacia un
 * componente `JTextArea` en una interfaz gráfica. En lugar de enviar el texto a la consola, el texto se
 * mostrará en el área de texto especificada.
 */

public class TextAreaOutputStream extends OutputStream {
    // JTextArea en la cual se mostrarán los mensajes redirigidos
    private JTextArea textArea;

    /**
     * Constructor de la clase TextAreaOutputStream.
     *
     * @param textArea El `JTextArea` donde se redirigirá la salida de texto.
     *                 Todos los mensajes que se envíen a este flujo de salida
     *                 se agregarán a este `JTextArea`.
     */
    public TextAreaOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    /**
     * Función write.
     *
     * Esta función es requerida al extender `OutputStream`. Convierte el byte recibido
     * en un carácter y lo agrega al `JTextArea`. Esto permite que cada carácter que se
     * envía al flujo se muestre inmediatamente en el área de texto.
     *
     * @param b El byte que representa un carácter a escribir en el `JTextArea`.
     */
    @Override
    public void write(int b) throws IOException {
        textArea.append(String.valueOf((char) b)); // Agrega el carácter al JTextArea
    }
}
