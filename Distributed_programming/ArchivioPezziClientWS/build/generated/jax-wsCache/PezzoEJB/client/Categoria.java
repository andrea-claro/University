
package client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for categoria.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="categoria"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="MOTORE"/&gt;
 *     &lt;enumeration value="FRENI"/&gt;
 *     &lt;enumeration value="FILTRI"/&gt;
 *     &lt;enumeration value="CARROZZERIA"/&gt;
 *     &lt;enumeration value="ACCENSIONE"/&gt;
 *     &lt;enumeration value="SOSPENSIONI"/&gt;
 *     &lt;enumeration value="IMPIANTO_ELETTRICO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "categoria")
@XmlEnum
public enum Categoria {

    MOTORE,
    FRENI,
    FILTRI,
    CARROZZERIA,
    ACCENSIONE,
    SOSPENSIONI,
    IMPIANTO_ELETTRICO;

    public String value() {
        return name();
    }

    public static Categoria fromValue(String v) {
        return valueOf(v);
    }

}
