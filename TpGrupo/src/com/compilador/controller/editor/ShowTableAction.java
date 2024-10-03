package com.compilador.controller.editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.File;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//MODIFICAR CON LA LOGICA PARA MOSTRAR TABLA
public class ShowTableAction implements ActionListener {
    private final String filename;

    // Constructor que recibe el área de texto
    public ShowTableAction(String filename){
        this.filename = filename;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Mostrar tabla
        BufferedReader in = null;

        // Crea un path para verificar si existe el archivo te la tabla de símbolos
        Path path = Paths.get(this.filename);
        if (!Files.exists(path)) return;

        try {
            FileReader reader = new FileReader(this.getFilename());
            in = new BufferedReader(reader);
            StringBuilder tabla = new StringBuilder();
            String linea;
            while((linea = in.readLine()) != null){
                tabla.append(linea).append("\n");
            }

            //Crear JText Are con fuente monoespaciada
            JTextArea textArea = new JTextArea(tabla.toString());
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
            textArea.setEditable(false);

            //Mostrar en JScroll por si la tabla es muy grande
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(565,300));

            //Mostrar en JOptionPane
            JOptionPane.showMessageDialog(null,scrollPane,"Tabla de simbolos!",JOptionPane.INFORMATION_MESSAGE);

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

    }

    private String getFilename() {
        return this.filename;
    }
}
