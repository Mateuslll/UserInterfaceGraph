/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author limam
 */
public class Computador {

    private String identificador;
    private boolean isFinal = false;
    
    public Computador(String identificador){
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.identificador.hashCode();
        return hash;
    }

  
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "Computador{" + "identificador=" + identificador +'}';
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Computador){
            Computador a = (Computador) obj;
            return a.getIdentificador().equals(this.identificador);
        }
        return false;
    }

}
