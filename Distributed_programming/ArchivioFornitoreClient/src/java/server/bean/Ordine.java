/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.bean;

import java.io.Serializable;

/**
 *
 * @author andrea-claro
 */
public class Ordine implements Serializable{
    
    int quantita;
    int valore;

    public Ordine() {
    }

    public Ordine(int quantita, int valore) {
        this.quantita = quantita;
        this.valore = valore;
    }

    public int getQuantita() {
        return quantita;
    }

    public int getValore() {
        return valore;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    @Override
    public String toString() {
        return "Ordine{" + "quantita=" + quantita + ", valore=" + valore + '}';
    }
    
    
}
