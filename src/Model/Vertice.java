package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author limam
 * @param <T>
 */
public class Vertice<T> implements Comparable{
    
    private boolean isFinal = false;
    String descricao;
    private Vertice pai;
    private int distancia;
    private boolean visitado = false;
    private List<Borda> arestas;
    private Map<Integer, Vertice> vizinhos;
    private T conteudo; 

    public Vertice(T conteudo ){
        this.conteudo = conteudo;
        vizinhos = new HashMap<>();
        arestas = new ArrayList<>();
    }
    
    public T getConteudo(){
        return this.conteudo;
    }
    
    

    public HashMap getVizinhos() {

        return (HashMap) this.vizinhos;
    }

    public Vertice(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public boolean isIsFinal() {
        return isFinal;
    }

    public void setIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getDistancia() {
        return this.distancia;
    }

    public void setPai(Vertice pai) {

        this.pai = pai;

    }

    public Vertice getPai() {

        return this.pai;
    }

    public List<Borda> getArestas() {

        return this.arestas;
    }

    public void visitar() {

        this.visitado = true;
    }

    public boolean verificarVisita() {

        return visitado;
    }

    @Override
    public int compareTo(Object ob) {
       if(this.getDistancia() < ((Vertice)ob).getDistancia()) {
           return -1;
       }else if(this.getDistancia() == ((Vertice)ob).getDistancia()){
           return 0;
       }
       return 1;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.conteudo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
       return this.conteudo.equals(obj);
    }
    
    

    @Override
    public String toString() {
        return conteudo.toString();
    }
    
    
}
