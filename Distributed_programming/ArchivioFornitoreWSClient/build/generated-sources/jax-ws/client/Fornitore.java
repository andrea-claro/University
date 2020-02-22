
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fornitore complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fornitore"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cognome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="maxOrd" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nomeSocieta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="totOrd" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="valTotOrd" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fornitore", propOrder = {
    "cognome",
    "id",
    "maxOrd",
    "nome",
    "nomeSocieta",
    "numTel",
    "totOrd",
    "valTotOrd"
})
public class Fornitore {

    protected String cognome;
    protected String id;
    protected int maxOrd;
    protected String nome;
    protected String nomeSocieta;
    protected String numTel;
    protected int totOrd;
    protected int valTotOrd;

    /**
     * Gets the value of the cognome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Sets the value of the cognome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognome(String value) {
        this.cognome = value;
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
     * Gets the value of the maxOrd property.
     * 
     */
    public int getMaxOrd() {
        return maxOrd;
    }

    /**
     * Sets the value of the maxOrd property.
     * 
     */
    public void setMaxOrd(int value) {
        this.maxOrd = value;
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
     * Gets the value of the nomeSocieta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeSocieta() {
        return nomeSocieta;
    }

    /**
     * Sets the value of the nomeSocieta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeSocieta(String value) {
        this.nomeSocieta = value;
    }

    /**
     * Gets the value of the numTel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumTel() {
        return numTel;
    }

    /**
     * Sets the value of the numTel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumTel(String value) {
        this.numTel = value;
    }

    /**
     * Gets the value of the totOrd property.
     * 
     */
    public int getTotOrd() {
        return totOrd;
    }

    /**
     * Sets the value of the totOrd property.
     * 
     */
    public void setTotOrd(int value) {
        this.totOrd = value;
    }

    /**
     * Gets the value of the valTotOrd property.
     * 
     */
    public int getValTotOrd() {
        return valTotOrd;
    }

    /**
     * Sets the value of the valTotOrd property.
     * 
     */
    public void setValTotOrd(int value) {
        this.valTotOrd = value;
    }

}
