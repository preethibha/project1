//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.crm.commercial_customer_search_crm4x4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ei.crm.name_search_by_all_names_request_crm4x4.NameSearchByAllNamesRequest;


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
 *         &lt;element name="NameSearchByAllNamesRequest" type="{http://ei/crm/name_search_by_all_names_request_crm4x4}NameSearchByAllNamesRequest"/>
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
    "nameSearchByAllNamesRequest"
})
@XmlRootElement(name = "NameSearchByAllNames")
public class NameSearchByAllNames {

    @XmlElement(name = "NameSearchByAllNamesRequest", required = true, nillable = true)
    protected NameSearchByAllNamesRequest nameSearchByAllNamesRequest;

    /**
     * Gets the value of the nameSearchByAllNamesRequest property.
     * 
     * @return
     *     possible object is
     *     {@link NameSearchByAllNamesRequest }
     *     
     */
    public NameSearchByAllNamesRequest getNameSearchByAllNamesRequest() {
        return nameSearchByAllNamesRequest;
    }

    /**
     * Sets the value of the nameSearchByAllNamesRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameSearchByAllNamesRequest }
     *     
     */
    public void setNameSearchByAllNamesRequest(NameSearchByAllNamesRequest value) {
        this.nameSearchByAllNamesRequest = value;
    }

}
