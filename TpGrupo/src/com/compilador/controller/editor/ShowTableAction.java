package com.compilador.controller.editor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//MODIFICAR CON LA LOGICA PARA MOSTRAR TABLA
public class ShowTableAction implements ActionListener {
    private JTextArea textArea;

    // Constructor que recibe el área de texto
    public ShowTableAction(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Crear un JFileChooser para que el usuario elija la ubicación de guardado
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado por el usuario
            File file = fileChooser.getSelectedFile();

            // Guardar el contenido del JTextArea en el archivo
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(textArea.getText());
                fileWriter.flush();  // Asegurarse de que todo el contenido se escribe en el archivo
                System.out.println("Archivo guardado exitosamente en: " + file.getAbsolutePath());
            } catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("Error al guardar el archivo: " + ex.getMessage());
            }
        }
    }
}
