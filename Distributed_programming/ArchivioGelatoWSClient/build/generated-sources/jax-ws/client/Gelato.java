
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for gelato complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="gelato"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="calorie" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="prezzo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ricetta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gelato", propOrder = {
    "calorie",
    "id",
    "nome",
    "prezzo",
    "ricetta"
})
public class Gelato {

    protected int calorie;
    protected String id;
    protected String nome;
    protected int prezzo;
    protected String ricetta;

    /**
     * Gets the value of the calorie property.
     * 
     */
    public int getCalorie() {
        return calorie;
    }

    /**
     * Sets the value of the calorie property.
     * 
     */
    public void setCalorie(int value) {
        this.calorie = value;
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
     * Gets the value of the nome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the value of the nome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
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

    /**
     * Gets the value of the ricetta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRicetta() {
        return ricetta;
    }

    /**
     * Sets the value of the ricetta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRicetta(String value) {
        this.ricetta = value;
    }

}
