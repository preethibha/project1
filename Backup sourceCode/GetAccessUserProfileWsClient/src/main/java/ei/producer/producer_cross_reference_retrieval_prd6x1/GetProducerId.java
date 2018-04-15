
package ei.producer.producer_cross_reference_retrieval_prd6x1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ei.producer.get_producer_id_request_prd6x1.GetProducerIdRequest;


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
 *         &lt;element name="GetProducerIdRequest" type="{http://ei/producer/get_producer_id_request_prd6x1}GetProducerIdRequest"/>
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
    "getProducerIdRequest"
})
@XmlRootElement(name = "GetProducerId")
public class GetProducerId {

    @XmlElement(name = "GetProducerIdRequest", required = true, nillable = true)
    protected GetProducerIdRequest getProducerIdRequest;

    /**
     * Gets the value of the getProducerIdRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetProducerIdRequest }
     *     
     */
    public GetProducerIdRequest getGetProducerIdRequest() {
        return getProducerIdRequest;
    }

    /**
     * Sets the value of the getProducerIdRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetProducerIdRequest }
     *     
     */
    public void setGetProducerIdRequest(GetProducerIdRequest value) {
        this.getProducerIdRequest = value;
    }

}
