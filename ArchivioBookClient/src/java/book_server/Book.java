package book_server;

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
    @NamedQuery(name = Book.FIND_ALL, query = "SELECT b FROM Book b"),
    @NamedQuery(name = Book.FIND_BYID, query = "SELECT b FROM Book b WHERE b.id = ?1")
})
public class Book implements Serializable{
    public static final String FIND_ALL = "Book.findAll";
    public static final String FIND_BYID = "Book.findById";
    
    @Id
    @GeneratedValue
    private String id;
    
    private String titolo;
    private String autore;
    private int prezzo;

    public Book(){
        
    }
    
    public Book(String titolo, String autore, int prezzo) {
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

    public int getPrezzo() {
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

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
    
    
}