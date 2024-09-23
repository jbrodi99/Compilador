package com.compilador.view;

import java.awt.*;
import javax.swing.*;
import com.compilador.controller.editor.AnalyzeCodeAction;
import com.compilador.controller.editor.LoadFileAction;
import com.compilador.controller.editor.SaveFileAction;
import com.compilador.controller.editor.ShowTableAction;

public class CodeEditor extends JFrame {
    private JTextArea textArea;
    private JTextArea resultArea;
    private JButton loadButton, analyzeButton, saveButton, showTableButton;

    public CodeEditor() {
        setTitle("IDE");
        setSize(1000, 1000); // Aumentar el tamaño para acomodar el resultArea
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Área de texto para escribir el código
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Área de texto para mostrar los resultados del análisis
        resultArea = new JTextArea();
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false); // El área de resultados no debería ser editable

        // Panel con barra de desplazamiento para el área de texto
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Panel con barra de desplazamiento para el área de resultados
        JScrollPane resultScrollPane = new JScrollPane(resultArea);
        resultScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Botón para cargar un archivo
        loadButton = new JButton("Cargar Archivo");
        loadButton.addActionListener(new LoadFileAction(this.textArea));

        // Botón para analizar el código
        analyzeButton = new JButton("Analizar Código");
        analyzeButton.addActionListener(new AnalyzeCodeAction(this.textArea,this.resultArea));

        // Botón para guardar el contenido del área de texto en un archivo
        saveButton = new JButton("Guardar Archivo");
        saveButton.addActionListener(new SaveFileAction(this.textArea));

        // Botón para mostrar una tabla
        showTableButton = new JButton("Mostrar Tabla de Simbolos");
        showTableButton.addActionListener(new ShowTableAction());

        // Panel para los botones con un GridLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 5, 5)); // 4 filas, 1 columna, espacio entre botones
        panel.add(loadButton); // Añadir el botón de cargar
        panel.add(saveButton); // Añadir el botón de guardar
        panel.add(showTableButton); // Añadir el botón de mostrar tabla
        panel.add(analyzeButton); // Añadir el botón de analizar

        // Panel dividido para mostrar el código y los resultados
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane, resultScrollPane);
        splitPane.setDividerLocation(500);

        // Añadir los componentes al marco
        getContentPane().add(splitPane, BorderLayout.CENTER);
        getContentPane().add(panel, BorderLayout.EAST);
    }
}
