
package ei.producer.producer_cross_reference_retrieval_prd6x1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ei.producer.get_filtered_producer_cross_ref_list_reply_prd6x1.GetFilteredProducerCrossRefListReply;


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
 *         &lt;element name="GetFilteredProducerCrossRefListReply" type="{http://ei/producer/get_filtered_producer_cross_ref_list_reply_prd6x1}GetFilteredProducerCrossRefListReply"/>
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
    "getFilteredProducerCrossRefListReply"
})
@XmlRootElement(name = "GetFilteredProducerCrossRefListResponse")
public class GetFilteredProducerCrossRefListResponse {

    @XmlElement(name = "GetFilteredProducerCrossRefListReply", required = true, nillable = true)
    protected GetFilteredProducerCrossRefListReply getFilteredProducerCrossRefListReply;

    /**
     * Gets the value of the getFilteredProducerCrossRefListReply property.
     * 
     * @return
     *     possible object is
     *     {@link GetFilteredProducerCrossRefListReply }
     *     
     */
    public GetFilteredProducerCrossRefListReply getGetFilteredProducerCrossRefListReply() {
        return getFilteredProducerCrossRefListReply;
    }

    /**
     * Sets the value of the getFilteredProducerCrossRefListReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFilteredProducerCrossRefListReply }
     *     
     */
    public void setGetFilteredProducerCrossRefListReply(GetFilteredProducerCrossRefListReply value) {
        this.getFilteredProducerCrossRefListReply = value;
    }

}
