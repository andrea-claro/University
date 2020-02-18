
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pezzo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pezzo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="categoria" type="{http://bussiness.server/}categoria" minOccurs="0"/&gt;
 *         &lt;element name="disponibilita" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nomePezzo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pezziVenduti" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="prezzo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pezzo", propOrder = {
    "categoria",
    "disponibilita",
    "id",
    "nomePezzo",
    "pezziVenduti",
    "prezzo"
})
public class Pezzo {

    @XmlSchemaType(name = "string")
    protected Categoria categoria;
    protected boolean disponibilita;
    protected String id;
    protected String nomePezzo;
    protected int pezziVenduti;
    protected int prezzo;

    /**
     * Gets the value of the categoria property.
     * 
     * @return
     *     possible object is
     *     {@link Categoria }
     *     
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Sets the value of the categoria property.
     * 
     * @param value
     *     allowed object is
     *     {@link Categoria }
     *     
     */
    public void setCategoria(Categoria value) {
        this.categoria = value;
    }

    /**
     * Gets the value of the disponibilita property.
     * 
     */
    public boolean isDisponibilita() {
        return disponibilita;
    }

    /**
     * Sets the value of the disponibilita property.
     * 
     */
    public void setDisponibilita(boolean value) {
        this.disponibilita = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the nomePezzo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomePezzo() {
        return nomePezzo;
    }

    /**
     * Sets the value of the nomePezzo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomePezzo(String value) {
        this.nomePezzo = value;
    }

    /**
     * Gets the value of the pezziVenduti property.
     * 
     */
    public int getPezziVenduti() {
        return pezziVenduti;
    }

    /**
     * Sets the value of the pezziVenduti property.
     * 
     */
    public void setPezziVenduti(int value) {
        this.pezziVenduti = value;
    }

    /**
     * Gets the value of the prezzo property.
     * 
     */
    public int getPrezzo() {
        return prezzo;
    }

    /**
     * Sets the value of the prezzo property.
     * 
     */
    public void setPrezzo(int value) {
        this.prezzo = value;
    }

}
