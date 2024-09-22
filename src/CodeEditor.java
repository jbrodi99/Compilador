import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;

public class CodeEditor extends JFrame {
    private JTextArea textArea;
    private JButton loadButton, analyzeButton;

    public CodeEditor() {
        setTitle("Editor de Código");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        loadButton = new JButton("Cargar Archivo");
        loadButton.addActionListener(new LoadFileAction());

        analyzeButton = new JButton("Analizar Código");
        analyzeButton.addActionListener(new AnalyzeCodeAction());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(loadButton, BorderLayout.NORTH);
        panel.add(analyzeButton, BorderLayout.SOUTH);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panel, BorderLayout.EAST);
    }

    private class LoadFileAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    String content = new String(Files.readAllBytes(selectedFile.toPath()));
                    textArea.setText(content);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al cargar el archivo: " + ex.getMessage());
                }
            }
        }
    }

    private class AnalyzeCodeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = textArea.getText();
            // Acá se llama al lexer y se le pasa el codigo para analizarlo
            // Por ejemplo:
            // Lexer lexer = new Lexer(new StringReader(code));
            // Procesa el analisis y muestra los resultados
            JOptionPane.showMessageDialog(null, "Código analizado: \n" + code);
           
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CodeEditor editor = new CodeEditor();
            editor.setVisible(true);
        });
    }
}
