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
    @NamedQuery(name = Fornitore.FIND_ALL, query = "SELECT f FROM Fornitore f"),
    @NamedQuery(name = Fornitore.FIND_BY_ID, query = "SELECT f FROM Fornitore f WHERE f.id = :id"),
    @NamedQuery(name = Fornitore.FIND_BY_SURNAME, query = "SELECT f FROM Fornitore f WHERE f.cognome = :cognome"),
    @NamedQuery(name = Fornitore.FIND_BY_MAXORD, query = "SELECT f FROM Fornitore f WHERE f.maxOrd > :max")
    })
public class Fornitore implements Serializable{
    
    public static final String FIND_ALL = "Fornitore.findAll";
    public static final String FIND_BY_ID = "Fornitore.findById";
    public static final String FIND_BY_SURNAME = "Fornitore.findBySurname";
    public static final String FIND_BY_MAXORD = "Fornitore.findByMaxOrd";
    
            
    @Id
    @GeneratedValue
    private String id;
    
    private String nome;
    private String cognome;
    private String nomeSocieta;
    private String numTel;  //numero di telefono
    private int maxOrd; //massimo degli ordini
    private int valTotOrd;  //valore totale degli ordini
    private int totOrd; //totale degli ordini

    public Fornitore() {
    }

    public Fornitore(String nome, String cognome, String nomeSocieta, String numTel, int maxOrd, int valTotOrd, int totOrd) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomeSocieta = nomeSocieta;
        this.numTel = numTel;
        this.maxOrd = maxOrd;
        this.valTotOrd = valTotOrd;
        this.totOrd = totOrd;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNomeSocieta() {
        return nomeSocieta;
    }

    public String getNumTel() {
        return numTel;
    }

    public int getMaxOrd() {
        return maxOrd;
    }

    public int getValTotOrd() {
        return valTotOrd;
    }

    public int getTotOrd() {
        return totOrd;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNomeSocieta(String nomeSocieta) {
        this.nomeSocieta = nomeSocieta;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setMaxOrd(int maxOrd) {
        this.maxOrd = maxOrd;
    }

    public void setValTotOrd(int valTotOrd) {
        this.valTotOrd = valTotOrd;
    }

    public void setTotOrd(int totOrd) {
        this.totOrd = totOrd;
    }

    @Override
    public String toString() {
        return "Fornitore{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", nomeSocieta=" + nomeSocieta + ", numTel=" + numTel + ", maxOrd=" + maxOrd + ", valTotOrd=" + valTotOrd + ", totOrd=" + totOrd + '}';
    } 
    
    public boolean isOrdOk(int nOrd) {
        return (totOrd+nOrd) < maxOrd;
    }
    
    public boolean addOrd(int nOrd, int valOrd) {
        if(isOrdOk(nOrd)){
            totOrd += nOrd;
            valTotOrd += valOrd;
            return true;
        }
        return false;
    }
}
