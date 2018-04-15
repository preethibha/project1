
package ei.core.producer.prd2X6;

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
 *         &lt;element name="ProducerDataSourceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MasterProducerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MasterProducerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubMasterProducerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PASNationalProducerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "ProducerIdentifier", namespace = "http://ei/core/producer_identifierx4", propOrder = {
    "producerName",
    "producerNumber",
    "producerSubNumber",
    "naicNationalProducerNumber",
    "producerId",
    "producerDataSourceName",
    "masterProducerNumber",
    "masterProducerName",
    "subMasterProducerNumber",
    "pasNationalProducerCode",
    "pasSourceProducerCode"
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
    @XmlElement(name = "ProducerDataSourceName")
    protected String producerDataSourceName;
    @XmlElement(name = "MasterProducerNumber")
    protected String masterProducerNumber;
    @XmlElement(name = "MasterProducerName")
    protected String masterProducerName;
    @XmlElement(name = "SubMasterProducerNumber")
    protected String subMasterProducerNumber;
    @XmlElement(name = "PASNationalProducerCode")
    protected String pasNationalProducerCode;
    @XmlElement(name = "PASSourceProducerCode")
    protected String pasSourceProducerCode;

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

    /**
     * Gets the value of the producerDataSourceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerDataSourceName() {
        return producerDataSourceName;
    }

    /**
     * Sets the value of the producerDataSourceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerDataSourceName(String value) {
        this.producerDataSourceName = value;
    }

    /**
     * Gets the value of the masterProducerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterProducerNumber() {
        return masterProducerNumber;
    }

    /**
     * Sets the value of the masterProducerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterProducerNumber(String value) {
        this.masterProducerNumber = value;
    }

    /**
     * Gets the value of the masterProducerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterProducerName() {
        return masterProducerName;
    }

    /**
     * Sets the value of the masterProducerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterProducerName(String value) {
        this.masterProducerName = value;
    }

    /**
     * Gets the value of the subMasterProducerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubMasterProducerNumber() {
        return subMasterProducerNumber;
    }

    /**
     * Sets the value of the subMasterProducerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubMasterProducerNumber(String value) {
        this.subMasterProducerNumber = value;
    }

    /**
     * Gets the value of the pasNationalProducerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPASNationalProducerCode() {
        return pasNationalProducerCode;
    }

    /**
     * Sets the value of the pasNationalProducerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPASNationalProducerCode(String value) {
        this.pasNationalProducerCode = value;
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
