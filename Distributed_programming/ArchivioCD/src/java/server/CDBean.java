/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

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
    @NamedQuery(name = CDBean.FIND_ALL, query = "SELECT cd FROM CDBean cd"),
    @NamedQuery(name = CDBean.FIND_BYID, query = "SELECT cd FROM CDBean cd WHERE cd.id = ?1")
})
public class CDBean implements Serializable{
    
    public static final String FIND_BYID = "CDBean.findById";
    public static final String FIND_ALL = "CDBean.findAll";
            
    @Id
    @GeneratedValue
    private String id;
    
    private String titolo;
    private String autore;
    private int prezzo;

    public CDBean(String titolo, String autore, Integer prezzo) {
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
    }
    
    public CDBean(){
        
    }

    public String getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public Integer getPrezzo() {
        return prezzo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }
    
    
}
