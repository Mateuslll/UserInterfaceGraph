/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Map;

/**
 *
 * @author limam
 */
public class Borda <T> {
    private Vertice origem;
    private Vertice fim;
    private int peso;         
    
    public Borda(Vertice origem, Vertice fim, int peso){
        this.origem = origem;
        this.fim = fim;
        this.peso = peso;
    }    

 
    
    @Override
    public String toString(){ //define como o objeto deve ser mostrado no console!
        return "ç";
    }

    /**
     * @return the origem
     */
    public Vertice getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    /**
     * @return the fim
     */
    public Vertice getFim() {
        return fim;
    }

    /**
     * @param fim the fim to set
     */
    public void setFim(Vertice fim) {
        this.fim = fim;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
}
