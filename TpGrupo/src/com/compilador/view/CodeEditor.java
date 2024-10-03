package com.compilador.view;

import java.awt.*;
import javax.swing.*;
import com.compilador.controller.editor.LineNumbering;
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
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Área de texto para escribir el código
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Crear un JTextArea para mostrar los números de línea
        LineNumbering lineNumbering = new LineNumbering(textArea);

        // Añadir el área de números de línea y el área de texto al JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setRowHeaderView(lineNumbering); // Añadir números de línea como cabecera de fila
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Área de texto para mostrar los resultados del análisis
        resultArea = new JTextArea();
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);

        // Panel con barra de desplazamiento para el área de resultados
        JScrollPane resultScrollPane = new JScrollPane(resultArea);
        resultScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Botón para cargar un archivo
        loadButton = new JButton("Cargar Archivo");
        loadButton.addActionListener(new LoadFileAction(this.textArea));

        // Botón para analizar el código
        analyzeButton = new JButton("Analizar Código");
        analyzeButton.addActionListener(new AnalyzeCodeAction(this.textArea, this.resultArea));

        // Botón para guardar el contenido del área de texto en un archivo
        saveButton = new JButton("Guardar Archivo");
        saveButton.addActionListener(new SaveFileAction(this.textArea));

        // Botón para mostrar una tabla
        showTableButton = new JButton("Mostrar Tabla de Simbolos");
        showTableButton.addActionListener(new ShowTableAction("ts.txt"));

        // Panel para los botones con un GridLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 5, 5));
        panel.add(loadButton);
        panel.add(saveButton);
        panel.add(showTableButton);
        panel.add(analyzeButton);

        // Panel dividido para mostrar el código y los resultados
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane, resultScrollPane);
        splitPane.setDividerLocation(500);

        // Añadir los componentes al marco
        getContentPane().add(splitPane, BorderLayout.CENTER);
        getContentPane().add(panel, BorderLayout.EAST);
    }
}
