//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.crm.commercial_customer_search_crm4x4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ei.crm.name_search_by_all_names_reply_crm4x4.NameSearchByAllNamesReply;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NameSearchByAllNamesReply" type="{http://ei/crm/name_search_by_all_names_reply_crm4x4}NameSearchByAllNamesReply"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nameSearchByAllNamesReply"
})
@XmlRootElement(name = "NameSearchByAllNamesResponse")
public class NameSearchByAllNamesResponse {

    @XmlElement(name = "NameSearchByAllNamesReply", required = true, nillable = true)
    protected NameSearchByAllNamesReply nameSearchByAllNamesReply;

    /**
     * Gets the value of the nameSearchByAllNamesReply property.
     * 
     * @return
     *     possible object is
     *     {@link NameSearchByAllNamesReply }
     *     
     */
    public NameSearchByAllNamesReply getNameSearchByAllNamesReply() {
        return nameSearchByAllNamesReply;
    }

    /**
     * Sets the value of the nameSearchByAllNamesReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameSearchByAllNamesReply }
     *     
     */
    public void setNameSearchByAllNamesReply(NameSearchByAllNamesReply value) {
        this.nameSearchByAllNamesReply = value;
    }

}
