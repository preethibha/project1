
package ei.producer.producer_cross_reference_retrieval_prd6x1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ei.producer.get_producer_id_reply_prd6x1.GetProducerIdReply;


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
 *         &lt;element name="GetProducerIdReply" type="{http://ei/producer/get_producer_id_reply_prd6x1}GetProducerIdReply"/>
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
    "getProducerIdReply"
})
@XmlRootElement(name = "GetProducerIdResponse")
public class GetProducerIdResponse {

    @XmlElement(name = "GetProducerIdReply", required = true, nillable = true)
    protected GetProducerIdReply getProducerIdReply;

    /**
     * Gets the value of the getProducerIdReply property.
     * 
     * @return
     *     possible object is
     *     {@link GetProducerIdReply }
     *     
     */
    public GetProducerIdReply getGetProducerIdReply() {
        return getProducerIdReply;
    }

    /**
     * Sets the value of the getProducerIdReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetProducerIdReply }
     *     
     */
    public void setGetProducerIdReply(GetProducerIdReply value) {
        this.getProducerIdReply = value;
    }

}
