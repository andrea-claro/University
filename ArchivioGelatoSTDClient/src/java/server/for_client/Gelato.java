/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.for_client;

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
        @NamedQuery(name = Gelato.FIND_BY_NAME, query = "SELECT g FROM Gelato g WHERE g.nome = :nome"),
        @NamedQuery(name = Gelato.FIND_BY_PRICE, query = "SELECT g FROM Gelato g WHERE g.prezzo = ?1"),
        @NamedQuery(name = Gelato.FIND_ALL, query = "SELECT g FROM Gelato g")
})
public class Gelato implements Serializable {
    
    public static final String FIND_BY_NAME = "Gelato.findByName";
    public static final String FIND_BY_PRICE = "Gelato.findByPrice";
    public static final String FIND_ALL = "Gelato.findAll";
    
    @Id
    @GeneratedValue
    private String id;
    
    private String nome;
    private String ricetta;
    private int prezzo;
    private int calorie;

    public Gelato() {
    }

    public Gelato(String nome, String ricetta, int prezzo, int calorie) {
        this.nome = nome;
        this.ricetta = ricetta;
        this.prezzo = prezzo;
        this.calorie = calorie;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRicetta() {
        return ricetta;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRicetta(String ricetta) {
        this.ricetta = ricetta;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    @Override
    public String toString() {
        return "Gelato{" + "id=" + id + ", nome=" + nome + ", ricetta=" + ricetta + ", prezzo=" + prezzo + ", calorie=" + calorie + '}';
    }
}
