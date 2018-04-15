
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
 *         &lt;element name="GetProducerListReply" type="{http://ei/producer/get_producer_list_reply_prd2x6}GetProducerListReply"/>
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
    "getProducerListReply"
})
@XmlRootElement(name = "GetProducerList2X6Response")
public class GetProducerList2X6Response {

    @XmlElement(name = "GetProducerListReply", required = true, nillable = true)
    protected GetProducerListReply getProducerListReply;

    /**
     * Gets the value of the getProducerListReply property.
     * 
     * @return
     *     possible object is
     *     {@link GetProducerListReply }
     *     
     */
    public GetProducerListReply getGetProducerListReply() {
        return getProducerListReply;
    }

    /**
     * Sets the value of the getProducerListReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetProducerListReply }
     *     
     */
    public void setGetProducerListReply(GetProducerListReply value) {
        this.getProducerListReply = value;
    }

}
