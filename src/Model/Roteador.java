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
public class Roteador {

    private String identificador;

    public Roteador(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.identificador.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Roteador) {
               Roteador other = (Roteador) obj;
            return other.getIdentificador().equals(this.identificador);
        }
        return false;
    }
   

    @Override
        public String toString() {
        return "Roteador{" + "identificador=" + identificador + '}';
    }
    
    
}
