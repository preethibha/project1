//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.corporate.contact_retrieval_crp30x1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ei.corporate.get_default_contact_request_crp30x1.GetDefaultContactRequest;


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
 *         &lt;element name="GetDefaultContactRequest" type="{http://ei/corporate/get_default_contact_request_crp30x1}GetDefaultContactRequest"/>
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
    "getDefaultContactRequest"
})
@XmlRootElement(name = "GetDefaultContact")
public class GetDefaultContact {

    @XmlElement(name = "GetDefaultContactRequest", required = true, nillable = true)
    protected GetDefaultContactRequest getDefaultContactRequest;

    /**
     * Gets the value of the getDefaultContactRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetDefaultContactRequest }
     *     
     */
    public GetDefaultContactRequest getGetDefaultContactRequest() {
        return getDefaultContactRequest;
    }

    /**
     * Sets the value of the getDefaultContactRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetDefaultContactRequest }
     *     
     */
    public void setGetDefaultContactRequest(GetDefaultContactRequest value) {
        this.getDefaultContactRequest = value;
    }

}
