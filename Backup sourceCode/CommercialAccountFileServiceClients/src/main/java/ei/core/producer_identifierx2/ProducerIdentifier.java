//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.core.producer_identifierx2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProducerIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProducerIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProducerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerSubNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NAICNationalProducerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProducerIdentifier", namespace = "http://ei/core/producer_identifierx2", propOrder = {
    "producerName",
    "producerNumber",
    "producerSubNumber",
    "naicNationalProducerNumber",
    "producerId"
})
public class ProducerIdentifier {

    @XmlElement(name = "ProducerName")
    protected String producerName;
    @XmlElement(name = "ProducerNumber")
    protected String producerNumber;
    @XmlElement(name = "ProducerSubNumber")
    protected String producerSubNumber;
    @XmlElement(name = "NAICNationalProducerNumber")
    protected String naicNationalProducerNumber;
    @XmlElement(name = "ProducerId")
    protected String producerId;

    /**
     * Gets the value of the producerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerName() {
        return producerName;
    }

    /**
     * Sets the value of the producerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerName(String value) {
        this.producerName = value;
    }

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
     * Gets the value of the naicNationalProducerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAICNationalProducerNumber() {
        return naicNationalProducerNumber;
    }

    /**
     * Sets the value of the naicNationalProducerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAICNationalProducerNumber(String value) {
        this.naicNationalProducerNumber = value;
    }

    /**
     * Gets the value of the producerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerId() {
        return producerId;
    }

    /**
     * Sets the value of the producerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerId(String value) {
        this.producerId = value;
    }

    @Override
	public String toString() {
		return "ProducerIdentifier [ ProducerName="
				+ this.getProducerName()
				+ ", ProducerNumber="
				+ this.getProducerNumber()
				+ ", ProducerSubNumber="
				+ this.getProducerSubNumber()
				+ ", NAICNationalProducerNumber="
				+ this.getNAICNationalProducerNumber()
				+ ", producerId="
				+ this.getProducerId() 
				+ "]";
	}

}
