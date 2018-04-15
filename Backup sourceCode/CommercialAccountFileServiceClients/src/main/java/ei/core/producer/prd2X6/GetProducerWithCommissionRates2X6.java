
package ei.core.producer.prd2X6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="GetProducerWithCommissionRatesRequest" type="{http://ei/producer/get_producer_with_commission_rates_request_prd2x6}GetProducerWithCommissionRatesRequest"/>
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
    "getProducerWithCommissionRatesRequest"
})
@XmlRootElement(name = "GetProducerWithCommissionRates2X6")
public class GetProducerWithCommissionRates2X6 {

    @XmlElement(name = "GetProducerWithCommissionRatesRequest", required = true, nillable = true)
    protected GetProducerWithCommissionRatesRequest getProducerWithCommissionRatesRequest;

    /**
     * Gets the value of the getProducerWithCommissionRatesRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetProducerWithCommissionRatesRequest }
     *     
     */
    public GetProducerWithCommissionRatesRequest getGetProducerWithCommissionRatesRequest() {
        return getProducerWithCommissionRatesRequest;
    }

    /**
     * Sets the value of the getProducerWithCommissionRatesRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetProducerWithCommissionRatesRequest }
     *     
     */
    public void setGetProducerWithCommissionRatesRequest(GetProducerWithCommissionRatesRequest value) {
        this.getProducerWithCommissionRatesRequest = value;
    }

}
