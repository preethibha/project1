
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
 *         &lt;element name="GetProducerRequest" type="{http://ei/producer/get_producer_request_prd2x6}GetProducerRequest"/>
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
    "getProducerRequest"
})
@XmlRootElement(name = "GetProducer2X6")
public class GetProducer2X6 {

    @XmlElement(name = "GetProducerRequest", required = true, nillable = true)
    protected GetProducerRequest getProducerRequest;

    /**
     * Gets the value of the getProducerRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetProducerRequest }
     *     
     */
    public GetProducerRequest getGetProducerRequest() {
        return getProducerRequest;
    }

    /**
     * Sets the value of the getProducerRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetProducerRequest }
     *     
     */
    public void setGetProducerRequest(GetProducerRequest value) {
        this.getProducerRequest = value;
    }

}
