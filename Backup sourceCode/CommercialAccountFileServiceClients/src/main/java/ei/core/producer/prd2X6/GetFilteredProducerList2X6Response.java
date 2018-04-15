
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
 *         &lt;element name="GetFilteredProducerListReply" type="{http://ei/producer/get_filtered_producer_list_reply_prd2x6}GetFilteredProducerListReply"/>
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
    "getFilteredProducerListReply"
})
@XmlRootElement(name = "GetFilteredProducerList2X6Response")
public class GetFilteredProducerList2X6Response {

    @XmlElement(name = "GetFilteredProducerListReply", required = true, nillable = true)
    protected GetFilteredProducerListReply getFilteredProducerListReply;

    /**
     * Gets the value of the getFilteredProducerListReply property.
     * 
     * @return
     *     possible object is
     *     {@link GetFilteredProducerListReply }
     *     
     */
    public GetFilteredProducerListReply getGetFilteredProducerListReply() {
        return getFilteredProducerListReply;
    }

    /**
     * Sets the value of the getFilteredProducerListReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFilteredProducerListReply }
     *     
     */
    public void setGetFilteredProducerListReply(GetFilteredProducerListReply value) {
        this.getFilteredProducerListReply = value;
    }

}
