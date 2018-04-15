
package ei.producer.producer_cross_reference_retrieval_prd6x1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ei.producer.get_producer_cross_reference_request_prd6x1.GetProducerCrossReferenceRequest;


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
 *         &lt;element name="GetProducerCrossReferenceRequest" type="{http://ei/producer/get_producer_cross_reference_request_prd6x1}GetProducerCrossReferenceRequest"/>
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
    "getProducerCrossReferenceRequest"
})
@XmlRootElement(name = "GetProducerCrossReference")
public class GetProducerCrossReference {

    @XmlElement(name = "GetProducerCrossReferenceRequest", required = true, nillable = true)
    protected GetProducerCrossReferenceRequest getProducerCrossReferenceRequest;

    /**
     * Gets the value of the getProducerCrossReferenceRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetProducerCrossReferenceRequest }
     *     
     */
    public GetProducerCrossReferenceRequest getGetProducerCrossReferenceRequest() {
        return getProducerCrossReferenceRequest;
    }

    /**
     * Sets the value of the getProducerCrossReferenceRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetProducerCrossReferenceRequest }
     *     
     */
    public void setGetProducerCrossReferenceRequest(GetProducerCrossReferenceRequest value) {
        this.getProducerCrossReferenceRequest = value;
    }

}
