
package ei.core.producer.prd2X6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetProducerListInputs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetProducerListInputs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProducerNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProducerSubNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PASSourceProducerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetProducerListInputs", namespace = "http://ei/producer/get_producer_list_inputs_prd2x6", propOrder = {
    "producerNumber",
    "producerSubNumber",
    "pasSourceProducerCode"
})
public class GetProducerListInputs {

    @XmlElement(name = "ProducerNumber", required = true)
    protected String producerNumber;
    @XmlElement(name = "ProducerSubNumber")
    protected String producerSubNumber;
    @XmlElement(name = "PASSourceProducerCode")
    protected String pasSourceProducerCode;

    /**
     * Gets the value of the producerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerNumber() {
        return producerNumber;
    }

    /**
     * Sets the value of the producerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerNumber(String value) {
        this.producerNumber = value;
    }

    /**
     * Gets the value of the producerSubNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerSubNumber() {
        return producerSubNumber;
    }

    /**
     * Sets the value of the producerSubNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerSubNumber(String value) {
        this.producerSubNumber = value;
    }

    /**
     * Gets the value of the pasSourceProducerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPASSourceProducerCode() {
        return pasSourceProducerCode;
    }

    /**
     * Sets the value of the pasSourceProducerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPASSourceProducerCode(String value) {
        this.pasSourceProducerCode = value;
    }

}
