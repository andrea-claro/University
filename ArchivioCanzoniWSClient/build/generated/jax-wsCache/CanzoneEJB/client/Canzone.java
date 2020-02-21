
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for canzone complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="canzone"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cantato" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="categoria" type="{http://bussiness.server/}categoria" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="incipit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nomeCantante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="votiRicevuti" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "canzone", propOrder = {
    "cantato",
    "categoria",
    "id",
    "incipit",
    "nomeCantante",
    "votiRicevuti"
})
public class Canzone {

    protected boolean cantato;
    @XmlSchemaType(name = "string")
    protected Categoria categoria;
    protected int id;
    protected String incipit;
    protected String nomeCantante;
    protected int votiRicevuti;

    /**
     * Gets the value of the cantato property.
     * 
     */
    public boolean isCantato() {
        return cantato;
    }

    /**
     * Sets the value of the cantato property.
     * 
     */
    public void setCantato(boolean value) {
        this.cantato = value;
    }

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
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the incipit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncipit() {
        return incipit;
    }

    /**
     * Sets the value of the incipit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncipit(String value) {
        this.incipit = value;
    }

    /**
     * Gets the value of the nomeCantante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeCantante() {
        return nomeCantante;
    }

    /**
     * Sets the value of the nomeCantante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeCantante(String value) {
        this.nomeCantante = value;
    }

    /**
     * Gets the value of the votiRicevuti property.
     * 
     */
    public int getVotiRicevuti() {
        return votiRicevuti;
    }

    /**
     * Sets the value of the votiRicevuti property.
     * 
     */
    public void setVotiRicevuti(int value) {
        this.votiRicevuti = value;
    }

}
