
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
 *     &lt;enumeration value="ROCK"/&gt;
 *     &lt;enumeration value="POP"/&gt;
 *     &lt;enumeration value="TRAP"/&gt;
 *     &lt;enumeration value="RAP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "categoria")
@XmlEnum
public enum Categoria {

    ROCK,
    POP,
    TRAP,
    RAP;

    public String value() {
        return name();
    }

    public static Categoria fromValue(String v) {
        return valueOf(v);
    }

}
