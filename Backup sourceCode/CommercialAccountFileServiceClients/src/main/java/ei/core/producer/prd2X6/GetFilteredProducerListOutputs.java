
package ei.core.producer.prd2X6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetFilteredProducerListOutputs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilteredProducerListOutputs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestedProducerIdentifier" type="{http://ei/core/producer_identifierx4}ProducerIdentifier" minOccurs="0"/>
 *         &lt;element name="ExtendedProducer" type="{http://ei/producer/extended_producerx4}ExtendedProducer" minOccurs="0"/>
 *         &lt;element name="StatusInformation" type="{http://ei/core/status_informationx1}StatusInformation" minOccurs="0"/>
 *         &lt;element name="ProducerFoundIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ProducerReplacedIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ProducerSubNumberFlipIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ProducerAppointmentStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFilteredProducerListOutputs", namespace = "http://ei/producer/get_filtered_producer_list_outputs_prd2x6", propOrder = {
    "requestedProducerIdentifier",
    "extendedProducer",
    "statusInformation",
    "producerFoundIndicator",
    "producerReplacedIndicator",
    "producerSubNumberFlipIndicator",
    "producerAppointmentStatusCode"
})
public class GetFilteredProducerListOutputs {

    @XmlElement(name = "RequestedProducerIdentifier")
    protected ProducerIdentifier requestedProducerIdentifier;
    @XmlElement(name = "ExtendedProducer")
    protected ExtendedProducer extendedProducer;
    @XmlElement(name = "StatusInformation")
    protected StatusInformation statusInformation;
    @XmlElement(name = "ProducerFoundIndicator")
    protected Boolean producerFoundIndicator;
    @XmlElement(name = "ProducerReplacedIndicator")
    protected Boolean producerReplacedIndicator;
    @XmlElement(name = "ProducerSubNumberFlipIndicator")
    protected Boolean producerSubNumberFlipIndicator;
    @XmlElement(name = "ProducerAppointmentStatusCode")
    protected String producerAppointmentStatusCode;

    /**
     * Gets the value of the requestedProducerIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link ProducerIdentifier }
     *     
     */
    public ProducerIdentifier getRequestedProducerIdentifier() {
        return requestedProducerIdentifier;
    }

    /**
     * Sets the value of the requestedProducerIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProducerIdentifier }
     *     
     */
    public void setRequestedProducerIdentifier(ProducerIdentifier value) {
        this.requestedProducerIdentifier = value;
    }

    /**
     * Gets the value of the extendedProducer property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedProducer }
     *     
     */
    public ExtendedProducer getExtendedProducer() {
        return extendedProducer;
    }

    /**
     * Sets the value of the extendedProducer property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedProducer }
     *     
     */
    public void setExtendedProducer(ExtendedProducer value) {
        this.extendedProducer = value;
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

    /**
     * Gets the value of the producerFoundIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isProducerFoundIndicator() {
        return producerFoundIndicator;
    }

    /**
     * Sets the value of the producerFoundIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setProducerFoundIndicator(Boolean value) {
        this.producerFoundIndicator = value;
    }

    /**
     * Gets the value of the producerReplacedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isProducerReplacedIndicator() {
        return producerReplacedIndicator;
    }

    /**
     * Sets the value of the producerReplacedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setProducerReplacedIndicator(Boolean value) {
        this.producerReplacedIndicator = value;
    }

    /**
     * Gets the value of the producerSubNumberFlipIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isProducerSubNumberFlipIndicator() {
        return producerSubNumberFlipIndicator;
    }

    /**
     * Sets the value of the producerSubNumberFlipIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setProducerSubNumberFlipIndicator(Boolean value) {
        this.producerSubNumberFlipIndicator = value;
    }

    /**
     * Gets the value of the producerAppointmentStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerAppointmentStatusCode() {
        return producerAppointmentStatusCode;
    }

    /**
     * Sets the value of the producerAppointmentStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerAppointmentStatusCode(String value) {
        this.producerAppointmentStatusCode = value;
    }

}
