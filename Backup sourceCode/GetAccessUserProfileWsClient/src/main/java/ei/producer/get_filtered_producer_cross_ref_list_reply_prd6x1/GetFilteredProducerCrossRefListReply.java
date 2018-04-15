
package ei.producer.get_filtered_producer_cross_ref_list_reply_prd6x1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ei.core.status_informationx2.StatusInformation;
import ei.producer.producer_cross_reference.ProducerCrossReference;


/**
 * <p>Java class for GetFilteredProducerCrossRefListReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilteredProducerCrossRefListReply">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProducerCrossReference" type="{http://ei/producer/producer_cross_reference}ProducerCrossReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StatusInformation" type="{http://ei/core/status_informationx2}StatusInformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFilteredProducerCrossRefListReply", propOrder = {
    "producerCrossReference",
    "statusInformation"
})
public class GetFilteredProducerCrossRefListReply {

    @XmlElement(name = "ProducerCrossReference")
    protected List<ProducerCrossReference> producerCrossReference;
    @XmlElement(name = "StatusInformation")
    protected StatusInformation statusInformation;

    /**
     * Gets the value of the producerCrossReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the producerCrossReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducerCrossReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProducerCrossReference }
     * 
     * 
     */
    public List<ProducerCrossReference> getProducerCrossReference() {
        if (producerCrossReference == null) {
            producerCrossReference = new ArrayList<ProducerCrossReference>();
        }
        return this.producerCrossReference;
    }

    /**
     * Gets the value of the statusInformation property.
     * 
     * @return
     *     possible object is
     *     {@link StatusInformation }
     *     
     */
    public StatusInformation getStatusInformation() {
        return statusInformation;
    }

    /**
     * Sets the value of the statusInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusInformation }
     *     
     */
    public void setStatusInformation(StatusInformation value) {
        this.statusInformation = value;
    }

}
