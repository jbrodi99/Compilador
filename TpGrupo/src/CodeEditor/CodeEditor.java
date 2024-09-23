package CodeEditor;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import Lexico.Lexico;
import Lexico.Lexicosym;
import java_cup.sym;
import java_cup.runtime.Symbol;


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
        loadButton.addActionListener(new LoadFileAction());

        // Botón para analizar el código
        analyzeButton = new JButton("Analizar Código");
        analyzeButton.addActionListener(new AnalyzeCodeAction());

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

    // Clase interna para cargar un archivo
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

    // Clase interna para analizar el código
    private class AnalyzeCodeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = textArea.getText();
            StringBuilder result = new StringBuilder();
            try {
                // Crear el Lexer con el código ingresado en el JTextArea
                Lexico lexico = new Lexico(new StringReader(code));
                Symbol token;
                while ((token = lexico.next_token()).sym != sym.EOF) {
                    // Agregar el token al resultado
                	String tokenName = Lexicosym.getTokenName(token.sym);
                    result.append("Token: '").append(tokenName)
                          .append("' encontrado, Lexema: '").append(lexico.yytext())
                          .append("'\n");
                }
                // Mostrar los resultados en el JTextArea de resultados
                resultArea.setText(result.toString());
            } catch (Error ex) {
                // Manejar el error de caracteres no permitidos
                //JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                resultArea.setText("Error: " + ex.getMessage());
            } catch (Exception ex) {
                // Manejar otros posibles errores
                //JOptionPane.showMessageDialog(null, "Error durante el análisis: " + ex.getMessage());
                resultArea.setText("Error durante el análisis: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CodeEditor editor = new CodeEditor();
            editor.setVisible(true);
        });
    }
}
