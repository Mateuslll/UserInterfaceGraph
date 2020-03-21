/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Grafo <T>{
    
    private Map <String,Vertice<T>> vertices;  //Integer = classe envolucro
    private int keyCount = 0;
    private LinkedList<Borda> arestas;

    public LinkedList<Borda> getArestas() {
        return arestas;
    }

    public void setArestas(LinkedList<Borda> arestas) {
        this.arestas = arestas;
    }
    public Grafo(){
       this.vertices = new HashMap <>();
       this.arestas = new LinkedList<>();
    } 
            
    public boolean adcionaVertice(T conteudo, String identificador){
        keyCount++;
        Vertice nova = new Vertice (conteudo);
        vertices.put(identificador, nova);
        return true;
    }
    
   
    public boolean removerVertice(String key){
        Vertice vertice = vertices.get(key);
        return vertices.remove(key, vertice);
    }
    
    public Map<String, Vertice <T>> getVertices(){
        return vertices;
    }
    
}
