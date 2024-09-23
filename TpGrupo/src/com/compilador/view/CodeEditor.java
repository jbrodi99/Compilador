package com.compilador.view;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import com.compilador.controller.editor.AnalyzeCodeAction;
import com.compilador.controller.editor.LoadFileAction;


public class CodeEditor extends JFrame {
    private JTextArea textArea;
    private JTextArea resultArea;
    private JButton loadButton, analyzeButton;

    public CodeEditor() {
        setTitle("Editor de Código");
        setSize(800, 400); // Aumentar el tamaño para acomodar el resultArea
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

        // Panel para los botones
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(loadButton, BorderLayout.NORTH);
        panel.add(analyzeButton, BorderLayout.SOUTH);

        // Panel dividido para mostrar el código y los resultados
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane, resultScrollPane);
        splitPane.setDividerLocation(200);

        // Añadir los componentes al marco
        getContentPane().add(splitPane, BorderLayout.CENTER);
        getContentPane().add(panel, BorderLayout.EAST);
    }

}
