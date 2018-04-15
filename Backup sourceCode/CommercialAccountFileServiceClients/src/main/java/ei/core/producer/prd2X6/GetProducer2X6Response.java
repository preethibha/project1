
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
 *         &lt;element name="GetProducerReply" type="{http://ei/producer/get_producer_reply_prd2x6}GetProducerReply"/>
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
    "getProducerReply"
})
@XmlRootElement(name = "GetProducer2X6Response")
public class GetProducer2X6Response {

    @XmlElement(name = "GetProducerReply", required = true, nillable = true)
    protected GetProducerReply getProducerReply;

    /**
     * Gets the value of the getProducerReply property.
     * 
     * @return
     *     possible object is
     *     {@link GetProducerReply }
     *     
     */
    public GetProducerReply getGetProducerReply() {
        return getProducerReply;
    }

    /**
     * Sets the value of the getProducerReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetProducerReply }
     *     
     */
    public void setGetProducerReply(GetProducerReply value) {
        this.getProducerReply = value;
    }

}
