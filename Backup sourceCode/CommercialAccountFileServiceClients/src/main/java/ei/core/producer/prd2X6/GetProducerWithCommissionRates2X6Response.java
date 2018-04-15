
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
 *         &lt;element name="GetProducerWithCommissionRatesReply" type="{http://ei/producer/get_producer_with_commission_rates_reply_prd2x6}GetProducerWithCommissionRatesReply"/>
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
    "getProducerWithCommissionRatesReply"
})
@XmlRootElement(name = "GetProducerWithCommissionRates2X6Response")
public class GetProducerWithCommissionRates2X6Response {

    @XmlElement(name = "GetProducerWithCommissionRatesReply", required = true, nillable = true)
    protected GetProducerWithCommissionRatesReply getProducerWithCommissionRatesReply;

    /**
     * Gets the value of the getProducerWithCommissionRatesReply property.
     * 
     * @return
     *     possible object is
     *     {@link GetProducerWithCommissionRatesReply }
     *     
     */
    public GetProducerWithCommissionRatesReply getGetProducerWithCommissionRatesReply() {
        return getProducerWithCommissionRatesReply;
    }

    /**
     * Sets the value of the getProducerWithCommissionRatesReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetProducerWithCommissionRatesReply }
     *     
     */
    public void setGetProducerWithCommissionRatesReply(GetProducerWithCommissionRatesReply value) {
        this.getProducerWithCommissionRatesReply = value;
    }

}
