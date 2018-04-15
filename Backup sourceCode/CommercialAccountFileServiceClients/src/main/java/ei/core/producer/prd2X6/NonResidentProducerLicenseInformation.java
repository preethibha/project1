
package ei.core.producer.prd2X6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NonResidentProducerLicenseInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NonResidentProducerLicenseInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PostalStateAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NonResidentProducerStateLicenseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LicenseTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecialArrangementProducerRequiredIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NonResidentProducerLicenseInformation", namespace = "http://ei/producer/non_resident_producer_license_information", propOrder = {
    "postalStateAbbreviation",
    "nonResidentProducerStateLicenseNumber",
    "licenseTypeCode",
    "specialArrangementProducerRequiredIndicator"
})
public class NonResidentProducerLicenseInformation {

    @XmlElement(name = "PostalStateAbbreviation")
    protected String postalStateAbbreviation;
    @XmlElement(name = "NonResidentProducerStateLicenseNumber")
    protected String nonResidentProducerStateLicenseNumber;
    @XmlElement(name = "LicenseTypeCode")
    protected String licenseTypeCode;
    @XmlElement(name = "SpecialArrangementProducerRequiredIndicator")
    protected Boolean specialArrangementProducerRequiredIndicator;

    /**
     * Gets the value of the postalStateAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalStateAbbreviation() {
        return postalStateAbbreviation;
    }

    /**
     * Sets the value of the postalStateAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalStateAbbreviation(String value) {
        this.postalStateAbbreviation = value;
    }

    /**
     * Gets the value of the nonResidentProducerStateLicenseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonResidentProducerStateLicenseNumber() {
        return nonResidentProducerStateLicenseNumber;
    }

    /**
     * Sets the value of the nonResidentProducerStateLicenseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonResidentProducerStateLicenseNumber(String value) {
        this.nonResidentProducerStateLicenseNumber = value;
    }

    /**
     * Gets the value of the licenseTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseTypeCode() {
        return licenseTypeCode;
    }

    /**
     * Sets the value of the licenseTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseTypeCode(String value) {
        this.licenseTypeCode = value;
    }

    /**
     * Gets the value of the specialArrangementProducerRequiredIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSpecialArrangementProducerRequiredIndicator() {
        return specialArrangementProducerRequiredIndicator;
    }

    /**
     * Sets the value of the specialArrangementProducerRequiredIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSpecialArrangementProducerRequiredIndicator(Boolean value) {
        this.specialArrangementProducerRequiredIndicator = value;
    }

}
