
package ei.producer.get_producer_cross_reference_reply_prd6x1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ei.core.status_informationx2.StatusInformation;
import ei.producer.producer_cross_reference.ProducerCrossReference;


/**
 * <p>Java class for GetProducerCrossReferenceReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetProducerCrossReferenceReply">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProducerCrossReference" type="{http://ei/producer/producer_cross_reference}ProducerCrossReference" minOccurs="0"/>
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
@XmlType(name = "GetProducerCrossReferenceReply", propOrder = {
    "producerCrossReference",
    "statusInformation"
})
public class GetProducerCrossReferenceReply {

    @XmlElement(name = "ProducerCrossReference")
    protected ProducerCrossReference producerCrossReference;
    @XmlElement(name = "StatusInformation")
    protected StatusInformation statusInformation;

    /**
     * Gets the value of the producerCrossReference property.
     * 
     * @return
     *     possible object is
     *     {@link ProducerCrossReference }
     *     
     */
    public ProducerCrossReference getProducerCrossReference() {
        return producerCrossReference;
    }

    /**
     * Sets the value of the producerCrossReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProducerCrossReference }
     *     
     */
    public void setProducerCrossReference(ProducerCrossReference value) {
        this.producerCrossReference = value;
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
