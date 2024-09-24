package com.compilador.controller.lexico;

import com.compilador.model.COLUMNA;

import java.io.*;
import java.util.*;

public class TablaSimbolos {
    private final int lenFormat = 100;
    private List<Map<COLUMNA,String>> symtabla = new ArrayList<>();
    private final String FILENAME;
    private final String formato = "|%35s|%10s|%10s|%35s|%4s|";

    public TablaSimbolos(String filename){
        this.FILENAME = filename;
        this.inicializar();
    }

    public List<Map<COLUMNA, String>> getSymtabla() {
        return symtabla;
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public String getFormato(){
        return this.formato;
    }

    public void addLine(Map<COLUMNA,String> line){
        this.symtabla.add(line);
    }

    public void inicializar(){
        //inicializar archivo
        this.escribirArchivo(null,false);
    }

    public void agregarSimbolo(String nombre, String token, String tipo){
        List<Map<COLUMNA, String>> tabla = getSymtabla();
        boolean encontrado = false;
        int i = 0;
        while (!encontrado && i < tabla.size()) {
            encontrado = tabla.get(i++).get(COLUMNA.NOMBRE).equals(nombre);
        }
        if (!encontrado) {
            Map<COLUMNA, String> sym = new HashMap<COLUMNA, String>();
            sym.put(COLUMNA.NOMBRE, nombre);
            sym.put(COLUMNA.TOKEN, token);
            sym.put(COLUMNA.TIPO, tipo);
            this.addLine(sym);
            this.escribirArchivo(Arrays.asList(sym),true);
        }
    }

    public void agregarSimbolo(String nombre, String token, String valor, String len){
        List<Map<COLUMNA, String>> tabla = getSymtabla();
        boolean encontrado = false;
        int i = 0;
        while(!encontrado && i < tabla.size()){
            encontrado = tabla.get(i++).get(COLUMNA.NOMBRE).equals(nombre);//Verificar si comparar nombres o Object ID
        }
        if(!encontrado){
            Map<COLUMNA,String> sym = new HashMap<COLUMNA,String>();
            sym.put(COLUMNA.NOMBRE, nombre);
            sym.put(COLUMNA.TOKEN, token);
            sym.put(COLUMNA.VALOR, valor);
            if(len != null) sym.put(COLUMNA.LEN, String.valueOf(len));
            this.addLine(sym);
            this.escribirArchivo(Arrays.asList(sym),true);
        }
    }

    public boolean escribirArchivo(List<Map<COLUMNA, String>> filas, boolean append){

            PrintWriter out = null;
            try {
                out = new PrintWriter(new FileWriter(getFILENAME(), append));

                if (!append) {
                    out.println(String.format(this.getFormato(), COLUMNA.NOMBRE, COLUMNA.TOKEN, COLUMNA.TIPO, COLUMNA.VALOR, COLUMNA.LEN));
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < this.lenFormat; i++) {
                        stringBuilder.append("-");
                    }
                    out.println(stringBuilder.toString());
                }

                if (filas != null) {
                    Iterator iterador = filas.iterator();

                    while (iterador.hasNext()) {
                        Map<COLUMNA, String> linea = (Map) iterador.next();
                        String nombre = linea.get(COLUMNA.NOMBRE) == null ? "" : (String) linea.get(COLUMNA.NOMBRE);
                        String token = linea.get(COLUMNA.TOKEN) == null ? "" : (String) linea.get(COLUMNA.TOKEN);
                        String tipo = linea.get(COLUMNA.TIPO) == null ? "" : (String) linea.get(COLUMNA.TIPO);
                        String valor = linea.get(COLUMNA.VALOR) == null ? "" : (String) linea.get(COLUMNA.VALOR);
                        String len = linea.get(COLUMNA.LEN) == null ? "" : (String) linea.get(COLUMNA.LEN);
                        out.println(String.format(this.getFormato(), nombre, token, tipo, valor, len));
                    }
                }

                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                if (out != null) {
                    out.close();
                }
            }
    }

    public void leerArchivo() throws IOException {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(this.getFILENAME()));
            //Leemos las primeras dos lineas que son la cabecera.
            in.readLine();
            in.readLine();
            String linea;
            while((linea = in.readLine()) != null){
                String[] splitLine = linea.split("\\|");
                Map<COLUMNA, String> fila = new HashMap();
                COLUMNA[] columnas;
                int cant = (columnas = COLUMNA.values()).length;

                for(int i = 0; i < cant; i++) {
                    COLUMNA c = columnas[i];
                    fila.put(c, splitLine[c.ordinal()+1].trim());
                }

                this.addLine(fila);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            if( in != null){
                in.close();
            }
        }
    }
}
