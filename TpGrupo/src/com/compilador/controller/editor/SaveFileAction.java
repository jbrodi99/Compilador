package com.compilador.controller.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFileAction implements ActionListener {
    private JTextArea textArea;

    // Constructor que recibe el área de texto
    public SaveFileAction(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Crear un JFileChooser para que el usuario elija la ubicación de guardado
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            // Obtiene el archivo seleccionado por el usuario
            File file = fileChooser.getSelectedFile();

            // Guarda el contenido del JTextArea en el archivo
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(textArea.getText());
                fileWriter.flush();  // Flush se aseguro de que todo el contenido se escribe en el archivo sin que se cierre el FileWriter
                System.out.println("Archivo guardado exitosamente en: " + file.getAbsolutePath());
            } catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("Error al guardar el archivo: " + ex.getMessage());
            }
        }
    }
}
