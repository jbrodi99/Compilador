package com.compilador.controller;

import com.compilador.view.CodeEditor;

import javax.swing.*;

public class Main {
    /*
    * Aqui se deberia invocar al main y llamar a los demas metodos...*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CodeEditor editor = new CodeEditor();
            editor.setVisible(true);
            //Comentario de prueba para verificar que estoy en rama separada
        });
    }
}
