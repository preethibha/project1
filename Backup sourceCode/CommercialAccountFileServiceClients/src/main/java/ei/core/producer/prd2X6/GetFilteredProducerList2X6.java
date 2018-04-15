
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
 *         &lt;element name="GetFilteredProducerListRequest" type="{http://ei/producer/get_filtered_producer_list_request_prd2x6}GetFilteredProducerListRequest"/>
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
    "getFilteredProducerListRequest"
})
@XmlRootElement(name = "GetFilteredProducerList2X6")
public class GetFilteredProducerList2X6 {

    @XmlElement(name = "GetFilteredProducerListRequest", required = true, nillable = true)
    protected GetFilteredProducerListRequest getFilteredProducerListRequest;

    /**
     * Gets the value of the getFilteredProducerListRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetFilteredProducerListRequest }
     *     
     */
    public GetFilteredProducerListRequest getGetFilteredProducerListRequest() {
        return getFilteredProducerListRequest;
    }

    /**
     * Sets the value of the getFilteredProducerListRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFilteredProducerListRequest }
     *     
     */
    public void setGetFilteredProducerListRequest(GetFilteredProducerListRequest value) {
        this.getFilteredProducerListRequest = value;
    }

}
