
package ei.user.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypedAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypedAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SourceSystemAddressId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreferredAddressIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AddressDefaultIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AddressValidatedIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="StandardizedAddress" type="{http://ei/core/standardized_addressx5}StandardizedAddress" minOccurs="0"/>
 *         &lt;element name="PrimaryResidenceIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrimaryAddressMemberIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressTypeAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactUsageTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactUsageTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypedAddress", namespace = "http://ei/core/typed_addressx3", propOrder = {
    "sourceSystemAddressId",
    "addressTypeName",
    "addressTypeDescription",
    "preferredAddressIndicator",
    "addressDefaultIndicator",
    "addressValidatedIndicator",
    "standardizedAddress",
    "primaryResidenceIndicator",
    "primaryAddressMemberIndicator",
    "addressTypeCode",
    "addressTypeAbbreviation",
    "contactUsageTypeCode",
    "contactUsageTypeName"
})
public class TypedAddress {

    @XmlElement(name = "SourceSystemAddressId")
    protected String sourceSystemAddressId;
    @XmlElement(name = "AddressTypeName")
    protected String addressTypeName;
    @XmlElement(name = "AddressTypeDescription")
    protected String addressTypeDescription;
    @XmlElement(name = "PreferredAddressIndicator")
    protected Boolean preferredAddressIndicator;
    @XmlElement(name = "AddressDefaultIndicator")
    protected Boolean addressDefaultIndicator;
    @XmlElement(name = "AddressValidatedIndicator")
    protected Boolean addressValidatedIndicator;
    @XmlElement(name = "StandardizedAddress")
    protected StandardizedAddress standardizedAddress;
    @XmlElement(name = "PrimaryResidenceIndicator")
    protected String primaryResidenceIndicator;
    @XmlElement(name = "PrimaryAddressMemberIndicator")
    protected String primaryAddressMemberIndicator;
    @XmlElement(name = "AddressTypeCode")
    protected String addressTypeCode;
    @XmlElement(name = "AddressTypeAbbreviation")
    protected String addressTypeAbbreviation;
    @XmlElement(name = "ContactUsageTypeCode")
    protected String contactUsageTypeCode;
    @XmlElement(name = "ContactUsageTypeName")
    protected String contactUsageTypeName;

    /**
     * Gets the value of the sourceSystemAddressId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceSystemAddressId() {
        return sourceSystemAddressId;
    }

    /**
     * Sets the value of the sourceSystemAddressId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceSystemAddressId(String value) {
        this.sourceSystemAddressId = value;
    }

    /**
     * Gets the value of the addressTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressTypeName() {
        return addressTypeName;
    }

    /**
     * Sets the value of the addressTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressTypeName(String value) {
        this.addressTypeName = value;
    }

    /**
     * Gets the value of the addressTypeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressTypeDescription() {
        return addressTypeDescription;
    }

    /**
     * Sets the value of the addressTypeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressTypeDescription(String value) {
        this.addressTypeDescription = value;
    }

    /**
     * Gets the value of the preferredAddressIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPreferredAddressIndicator() {
        return preferredAddressIndicator;
    }

    /**
     * Sets the value of the preferredAddressIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPreferredAddressIndicator(Boolean value) {
        this.preferredAddressIndicator = value;
    }

    /**
     * Gets the value of the addressDefaultIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAddressDefaultIndicator() {
        return addressDefaultIndicator;
    }

    /**
     * Sets the value of the addressDefaultIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAddressDefaultIndicator(Boolean value) {
        this.addressDefaultIndicator = value;
    }

    /**
     * Gets the value of the addressValidatedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAddressValidatedIndicator() {
        return addressValidatedIndicator;
    }

    /**
     * Sets the value of the addressValidatedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAddressValidatedIndicator(Boolean value) {
        this.addressValidatedIndicator = value;
    }

    /**
     * Gets the value of the standardizedAddress property.
     * 
     * @return
     *     possible object is
     *     {@link StandardizedAddress }
     *     
     */
    public StandardizedAddress getStandardizedAddress() {
        return standardizedAddress;
    }

    /**
     * Sets the value of the standardizedAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardizedAddress }
     *     
     */
    public void setStandardizedAddress(StandardizedAddress value) {
        this.standardizedAddress = value;
    }

    /**
     * Gets the value of the primaryResidenceIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryResidenceIndicator() {
        return primaryResidenceIndicator;
    }

    /**
     * Sets the value of the primaryResidenceIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryResidenceIndicator(String value) {
        this.primaryResidenceIndicator = value;
    }

    /**
     * Gets the value of the primaryAddressMemberIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryAddressMemberIndicator() {
        return primaryAddressMemberIndicator;
    }

    /**
     * Sets the value of the primaryAddressMemberIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryAddressMemberIndicator(String value) {
        this.primaryAddressMemberIndicator = value;
    }

    /**
     * Gets the value of the addressTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressTypeCode() {
        return addressTypeCode;
    }

    /**
     * Sets the value of the addressTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressTypeCode(String value) {
        this.addressTypeCode = value;
    }

    /**
     * Gets the value of the addressTypeAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressTypeAbbreviation() {
        return addressTypeAbbreviation;
    }

    /**
     * Sets the value of the addressTypeAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressTypeAbbreviation(String value) {
        this.addressTypeAbbreviation = value;
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

}
