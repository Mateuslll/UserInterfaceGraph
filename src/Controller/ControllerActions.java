/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Borda;
import Model.Computador;
import Model.Grafo;
import Model.Roteador;
import Model.Vertice;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import javafx.stage.FileChooser;

/**
 *
 * @author limam
 */
public class ControllerActions {

    Grafo grafo;
    LinkedList<Borda> listaBordas;

    public ControllerActions() {
        this.grafo = new Grafo();
        this.listaBordas = new LinkedList<>();
    }

    public Grafo getGrafo() {
        return grafo;
    }
    public LinkedList getConexoes(){
        return this.listaBordas;
    }

    public void inicializarGrafo() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterTXT = new FileChooser.ExtensionFilter("TEXT FILES", "*.txt", "*.text");
        fileChooser.getExtensionFilters().addAll(extFilterTXT);
        File file = fileChooser.showOpenDialog(null);
        String aux_text = null;

        if (file != null) {

            System.out.println("File diferente de null");
            System.out.println();
            Scanner leitor = new Scanner(file);

            String linhasDoArquivo = null;

            while (leitor.hasNext()) {

                linhasDoArquivo = leitor.nextLine();
                String[] a;
                System.out.println(linhasDoArquivo);
                a = linhasDoArquivo.split(",");
                String inicial = a[0];
                String terminal = a[1];

                switch (terminal) {

                    case "sim":
                        Computador computador = new Computador(inicial);
                        boolean flag = grafo.getVertices().containsKey(inicial);
                        if (!flag) {
                            grafo.adcionaVertice(computador, inicial);
                        }
                        break;

                    case "não":
                        Roteador roteador = new Roteador(inicial);
                        boolean flag2 = grafo.getVertices().containsKey(inicial);
                        if (!flag2) {
                            grafo.adcionaVertice(roteador, inicial);
                        }
                        break;
                }

            }
            System.out.println(Arrays.asList(grafo.getVertices())); // method 1
        }
    }

    public void carregarConexoes() throws FileNotFoundException {
        File file = new File("C:\\Users\\limam\\Desktop\\Pbl3\\DestinoPeso.txt");
        String aux_text = null;

        if (file != null) {

            System.out.println("File diferente de null");
            System.out.println();
            Scanner leitor = new Scanner(file);

            String linhasDoArquivo = null;

            while (leitor.hasNext()) {

                linhasDoArquivo = leitor.nextLine();
                String[] a;
                System.out.println(linhasDoArquivo);
                a = linhasDoArquivo.split(",");
                String inicial = a[0];
                String terminal = a[1];
                String e = a[2];
                int peso = Integer.valueOf(e);
                Vertice vertice = new Vertice(inicial);
                Vertice s = new Vertice(terminal);
                Borda edge = new Borda(vertice, s, peso);
                listaBordas.add(edge);
            }
        }
    }

}
