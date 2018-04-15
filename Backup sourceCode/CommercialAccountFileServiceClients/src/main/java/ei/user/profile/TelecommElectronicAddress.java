
package ei.user.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TelecommElectronicAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TelecommElectronicAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CommDeviceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommDeviceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommDeviceValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactUsageTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactUsageTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommContactPreferenceOrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TelecommElectronicAddress", namespace = "http://ei/core/telecomm_electronic_address", propOrder = {
    "commDeviceCode",
    "commDeviceName",
    "commDeviceValue",
    "contactUsageTypeCode",
    "contactUsageTypeName",
    "commContactPreferenceOrderNumber"
})
public class TelecommElectronicAddress {

    @XmlElement(name = "CommDeviceCode")
    protected String commDeviceCode;
    @XmlElement(name = "CommDeviceName")
    protected String commDeviceName;
    @XmlElement(name = "CommDeviceValue")
    protected String commDeviceValue;
    @XmlElement(name = "ContactUsageTypeCode")
    protected String contactUsageTypeCode;
    @XmlElement(name = "ContactUsageTypeName")
    protected String contactUsageTypeName;
    @XmlElement(name = "CommContactPreferenceOrderNumber")
    protected String commContactPreferenceOrderNumber;

    /**
     * Gets the value of the commDeviceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommDeviceCode() {
        return commDeviceCode;
    }

    /**
     * Sets the value of the commDeviceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommDeviceCode(String value) {
        this.commDeviceCode = value;
    }

    /**
     * Gets the value of the commDeviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommDeviceName() {
        return commDeviceName;
    }

    /**
     * Sets the value of the commDeviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommDeviceName(String value) {
        this.commDeviceName = value;
    }

    /**
     * Gets the value of the commDeviceValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommDeviceValue() {
        return commDeviceValue;
    }

    /**
     * Sets the value of the commDeviceValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommDeviceValue(String value) {
        this.commDeviceValue = value;
    }

    /**
     * Gets the value of the contactUsageTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactUsageTypeCode() {
        return contactUsageTypeCode;
    }

    /**
     * Sets the value of the contactUsageTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactUsageTypeCode(String value) {
        this.contactUsageTypeCode = value;
    }

    /**
     * Gets the value of the contactUsageTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactUsageTypeName() {
        return contactUsageTypeName;
    }

    /**
     * Sets the value of the contactUsageTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactUsageTypeName(String value) {
        this.contactUsageTypeName = value;
    }

    /**
     * Gets the value of the commContactPreferenceOrderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommContactPreferenceOrderNumber() {
        return commContactPreferenceOrderNumber;
    }

    /**
     * Sets the value of the commContactPreferenceOrderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommContactPreferenceOrderNumber(String value) {
        this.commContactPreferenceOrderNumber = value;
    }

}
