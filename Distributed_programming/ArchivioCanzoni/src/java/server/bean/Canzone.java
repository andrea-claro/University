/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andrea-claro
 */
@XmlRootElement
@Entity
@NamedQueries({
    @NamedQuery(name = Canzone.FIND_ALL, query = "SELECT c FROM Canzone c"),
    @NamedQuery(name = Canzone.FIND_BY_ID, query = "SELECT c FROM Canzone c WHERE c.id = :id"),
    @NamedQuery(name = Canzone.FIND_BY_CAT, query = "SELECT c FROM Canzone c WHERE c.categoria = ?1")
})
public class Canzone implements Serializable {
    
    public static final String FIND_ALL= "Canzone.findAll";
    public static final String FIND_BY_ID = "Canzone.findById";
    public static final String FIND_BY_CAT = "Canzone.findByCat";
    
    @Id
    @GeneratedValue
    private int id;
    
    private String nomeCantante;
    private Categoria categoria;
    private String incipit;
    private boolean cantato;
    private int votiRicevuti;

    public Canzone() {
    }

    public Canzone(String nomeCantante, Categoria categoria, String incipit, boolean cantato, int votiRicevuti) {
        this.nomeCantante = nomeCantante;
        this.categoria = categoria;
        this.incipit = incipit;
        this.cantato = cantato;
        this.votiRicevuti = votiRicevuti;
    }

    public static String getFIND_ALL() {
        return FIND_ALL;
    }

    public static String getFIND_BY_ID() {
        return FIND_BY_ID;
    }

    public static String getFIND_BY_CAT() {
        return FIND_BY_CAT;
    }

    public int getId() {
        return id;
    }

    public String getNomeCantante() {
        return nomeCantante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getIncipit() {
        return incipit;
    }

    public boolean isCantato() {
        return cantato;
    }

    public int getVotiRicevuti() {
        return votiRicevuti;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeCantante(String nomeCantante) {
        this.nomeCantante = nomeCantante;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setIncipit(String incipit) {
        this.incipit = incipit;
    }

    public void setCantato(boolean cantato) {
        this.cantato = cantato;
    }

    public void setVotiRicevuti(int votiRicevuti) {
        this.votiRicevuti = votiRicevuti;
    }

    @Override
    public String toString() {
        return "Canzone{" + "id=" + id + ", nomeCantante=" + nomeCantante + ", categoria=" + categoria + ", incipit=" + incipit + ", cantato=" + cantato + ", votiRicevuti=" + votiRicevuti + '}';
    }
}
