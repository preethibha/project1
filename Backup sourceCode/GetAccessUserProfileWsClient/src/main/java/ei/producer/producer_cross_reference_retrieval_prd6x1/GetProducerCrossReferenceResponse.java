
package ei.producer.producer_cross_reference_retrieval_prd6x1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ei.producer.get_producer_cross_reference_reply_prd6x1.GetProducerCrossReferenceReply;


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
 *         &lt;element name="GetProducerCrossReferenceReply" type="{http://ei/producer/get_producer_cross_reference_reply_prd6x1}GetProducerCrossReferenceReply"/>
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
    "getProducerCrossReferenceReply"
})
@XmlRootElement(name = "GetProducerCrossReferenceResponse")
public class GetProducerCrossReferenceResponse {

    @XmlElement(name = "GetProducerCrossReferenceReply", required = true, nillable = true)
    protected GetProducerCrossReferenceReply getProducerCrossReferenceReply;

    /**
     * Gets the value of the getProducerCrossReferenceReply property.
     * 
     * @return
     *     possible object is
     *     {@link GetProducerCrossReferenceReply }
     *     
     */
    public GetProducerCrossReferenceReply getGetProducerCrossReferenceReply() {
        return getProducerCrossReferenceReply;
    }

    /**
     * Sets the value of the getProducerCrossReferenceReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetProducerCrossReferenceReply }
     *     
     */
    public void setGetProducerCrossReferenceReply(GetProducerCrossReferenceReply value) {
        this.getProducerCrossReferenceReply = value;
    }

}
