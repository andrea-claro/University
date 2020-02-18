package server.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = Pezzo.FIND_ALL, query = "SELECT p FROM Pezzo p"),
        @NamedQuery(name = Pezzo.FIND_BY_ID, query = "SELECT p FROM Pezzo p WHERE p.id= :id"),
        @NamedQuery(name = Pezzo.FIND_BY_CATEGORY, query = "SELECT p FROM Pezzo p WHERE p.categoria= ?1")
})
public class Pezzo implements Serializable{
    
    public static final String FIND_ALL = "Pezzo.findAll";
    public static final String FIND_BY_ID = "Pezzo.findById";
    public static final String FIND_BY_CATEGORY = "Pezzo.findByCategory";
    
    @Id
    @GeneratedValue
    private String id;
    
    private String nomePezzo;
    private int prezzo;
    private int pezziVenduti;
    private boolean disponibilita;
    private Categoria categoria;

    public Pezzo() {
    }

    public Pezzo(String nomePezzo, int prezzo, int pezziVenduti, boolean disponibilita, Categoria categoria) {
        this.nomePezzo = nomePezzo;
        this.prezzo = prezzo;
        this.pezziVenduti = pezziVenduti;
        this.disponibilita = disponibilita;
        this.categoria = categoria;
    }

    public static String getFIND_ALL() {
        return FIND_ALL;
    }

    public static String getFIND_BY_ID() {
        return FIND_BY_ID;
    }

    public static String getFIND_BY_CATEGORY() {
        return FIND_BY_CATEGORY;
    }

    public String getId() {
        return id;
    }

    public String getNomePezzo() {
        return nomePezzo;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public int getPezziVenduti() {
        return pezziVenduti;
    }

    public boolean isDisponibilita() {
        return disponibilita;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNomePezzo(String nomePezzo) {
        this.nomePezzo = nomePezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public void setPezziVenduti(int pezziVenduti) {
        this.pezziVenduti = pezziVenduti;
    }

    public void setDisponibilita(boolean disponibilita) {
        this.disponibilita = disponibilita;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Pezzo{" + "id=" + id + ", nomePezzo=" + nomePezzo + ", prezzo=" + prezzo + ", pezziVenduti=" + pezziVenduti + ", disponibilita=" + disponibilita + ", categoria=" + categoria + '}';
    }
   
    
}