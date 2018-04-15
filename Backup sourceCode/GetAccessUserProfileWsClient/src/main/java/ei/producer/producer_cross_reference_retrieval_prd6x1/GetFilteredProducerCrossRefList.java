
package ei.producer.producer_cross_reference_retrieval_prd6x1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ei.producer.get_filtered_producer_cross_ref_list_request_prd6x1.GetFilteredProducerCrossRefListRequest;


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
 *         &lt;element name="GetFilteredProducerCrossRefListRequest" type="{http://ei/producer/get_filtered_producer_cross_ref_list_request_prd6x1}GetFilteredProducerCrossRefListRequest"/>
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
    "getFilteredProducerCrossRefListRequest"
})
@XmlRootElement(name = "GetFilteredProducerCrossRefList")
public class GetFilteredProducerCrossRefList {

    @XmlElement(name = "GetFilteredProducerCrossRefListRequest", required = true, nillable = true)
    protected GetFilteredProducerCrossRefListRequest getFilteredProducerCrossRefListRequest;

    /**
     * Gets the value of the getFilteredProducerCrossRefListRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetFilteredProducerCrossRefListRequest }
     *     
     */
    public GetFilteredProducerCrossRefListRequest getGetFilteredProducerCrossRefListRequest() {
        return getFilteredProducerCrossRefListRequest;
    }

    /**
     * Sets the value of the getFilteredProducerCrossRefListRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFilteredProducerCrossRefListRequest }
     *     
     */
    public void setGetFilteredProducerCrossRefListRequest(GetFilteredProducerCrossRefListRequest value) {
        this.getFilteredProducerCrossRefListRequest = value;
    }

}
