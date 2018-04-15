
package ei.core.producer.prd2X6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetFilteredProducerListInputs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilteredProducerListInputs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProducerIdentifier" type="{http://ei/core/producer_identifierx4}ProducerIdentifier" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PolicyTypeIdentifier" type="{http://ei/core/policy_type_identifierx1}PolicyTypeIdentifier" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFilteredProducerListInputs", namespace = "http://ei/producer/get_filtered_producer_list_inputs_prd2x6", propOrder = {
    "producerIdentifier",
    "policyTypeIdentifier"
})
public class GetFilteredProducerListInputs {

    @XmlElement(name = "ProducerIdentifier")
    protected List<ProducerIdentifier> producerIdentifier;
    @XmlElement(name = "PolicyTypeIdentifier")
    protected List<PolicyTypeIdentifier> policyTypeIdentifier;

    /**
     * Gets the value of the producerIdentifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the producerIdentifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducerIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProducerIdentifier }
     * 
     * 
     */
    public List<ProducerIdentifier> getProducerIdentifier() {
        if (producerIdentifier == null) {
            producerIdentifier = new ArrayList<ProducerIdentifier>();
        }
        return this.producerIdentifier;
    }

    /**
     * Gets the value of the policyTypeIdentifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the policyTypeIdentifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPolicyTypeIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PolicyTypeIdentifier }
     * 
     * 
     */
    public List<PolicyTypeIdentifier> getPolicyTypeIdentifier() {
        if (policyTypeIdentifier == null) {
            policyTypeIdentifier = new ArrayList<PolicyTypeIdentifier>();
        }
        return this.policyTypeIdentifier;
    }

}
