
package ei.core.producer.prd2X6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetProducerListReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetProducerListReply">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetProducerListOutputs" type="{http://ei/producer/get_producer_list_outputs_prd2x6}GetProducerListOutputs" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetProducerListReply", namespace = "http://ei/producer/get_producer_list_reply_prd2x6", propOrder = {
    "getProducerListOutputs"
})
public class GetProducerListReply {

    @XmlElement(name = "GetProducerListOutputs")
    protected List<GetProducerListOutputs> getProducerListOutputs;

    /**
     * Gets the value of the getProducerListOutputs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getProducerListOutputs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetProducerListOutputs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetProducerListOutputs }
     * 
     * 
     */
    public List<GetProducerListOutputs> getGetProducerListOutputs() {
        if (getProducerListOutputs == null) {
            getProducerListOutputs = new ArrayList<GetProducerListOutputs>();
        }
        return this.getProducerListOutputs;
    }

}
