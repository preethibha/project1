//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.country.country_retrieval_crp10x1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ei.corporate.get_country_request_crp10x1.GetCountryRequest;


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
 *         &lt;element name="GetCountryRequest" type="{http://ei/corporate/get_country_request_crp10x1}GetCountryRequest"/>
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
    "getCountryRequest"
})
@XmlRootElement(name = "GetCountry")
public class GetCountry {

    @XmlElement(name = "GetCountryRequest", required = true, nillable = true)
    protected GetCountryRequest getCountryRequest;

    /**
     * Gets the value of the getCountryRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetCountryRequest }
     *     
     */
    public GetCountryRequest getGetCountryRequest() {
        return getCountryRequest;
    }

    /**
     * Sets the value of the getCountryRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCountryRequest }
     *     
     */
    public void setGetCountryRequest(GetCountryRequest value) {
        this.getCountryRequest = value;
    }

}
