
package ei.user.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for IndividualIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndividualIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SocialSecurityNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IndividualBirthDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="GenderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DriverLicenseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OccupationDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IndividualsAge" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DriverPostalStateAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DriverStateOrProvinceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DriverLicenseCountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DriverLicenseCountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EnterpriseGenderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndividualIdentifier", namespace = "http://ei/core/individual_identifierx1", propOrder = {
    "socialSecurityNumber",
    "individualBirthDate",
    "genderCode",
    "driverLicenseNumber",
    "occupationDescription",
    "individualsAge",
    "driverPostalStateAbbreviation",
    "driverStateOrProvinceName",
    "driverLicenseCountryCode",
    "driverLicenseCountryName",
    "enterpriseGenderCode"
})
public class IndividualIdentifier {

    @XmlElement(name = "SocialSecurityNumber")
    protected String socialSecurityNumber;
    @XmlElement(name = "IndividualBirthDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar individualBirthDate;
    @XmlElement(name = "GenderCode")
    protected String genderCode;
    @XmlElement(name = "DriverLicenseNumber")
    protected String driverLicenseNumber;
    @XmlElement(name = "OccupationDescription")
    protected String occupationDescription;
    @XmlElement(name = "IndividualsAge")
    protected Integer individualsAge;
    @XmlElement(name = "DriverPostalStateAbbreviation")
    protected String driverPostalStateAbbreviation;
    @XmlElement(name = "DriverStateOrProvinceName")
    protected String driverStateOrProvinceName;
    @XmlElement(name = "DriverLicenseCountryCode")
    protected String driverLicenseCountryCode;
    @XmlElement(name = "DriverLicenseCountryName")
    protected String driverLicenseCountryName;
    @XmlElement(name = "EnterpriseGenderCode")
    protected String enterpriseGenderCode;

    /**
     * Gets the value of the socialSecurityNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * Sets the value of the socialSecurityNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSocialSecurityNumber(String value) {
        this.socialSecurityNumber = value;
    }

    /**
     * Gets the value of the individualBirthDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIndividualBirthDate() {
        return individualBirthDate;
    }

    /**
     * Sets the value of the individualBirthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIndividualBirthDate(XMLGregorianCalendar value) {
        this.individualBirthDate = value;
    }

    /**
     * Gets the value of the genderCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenderCode() {
        return genderCode;
    }

    /**
     * Sets the value of the genderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenderCode(String value) {
        this.genderCode = value;
    }

    /**
     * Gets the value of the driverLicenseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    /**
     * Sets the value of the driverLicenseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverLicenseNumber(String value) {
        this.driverLicenseNumber = value;
    }

    /**
     * Gets the value of the occupationDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccupationDescription() {
        return occupationDescription;
    }

    /**
     * Sets the value of the occupationDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccupationDescription(String value) {
        this.occupationDescription = value;
    }

    /**
     * Gets the value of the individualsAge property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIndividualsAge() {
        return individualsAge;
    }

    /**
     * Sets the value of the individualsAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIndividualsAge(Integer value) {
        this.individualsAge = value;
    }

    /**
     * Gets the value of the driverPostalStateAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverPostalStateAbbreviation() {
        return driverPostalStateAbbreviation;
    }

    /**
     * Sets the value of the driverPostalStateAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverPostalStateAbbreviation(String value) {
        this.driverPostalStateAbbreviation = value;
    }

    /**
     * Gets the value of the driverStateOrProvinceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverStateOrProvinceName() {
        return driverStateOrProvinceName;
    }

    /**
     * Sets the value of the driverStateOrProvinceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverStateOrProvinceName(String value) {
        this.driverStateOrProvinceName = value;
    }

    /**
     * Gets the value of the driverLicenseCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverLicenseCountryCode() {
        return driverLicenseCountryCode;
    }

    /**
     * Sets the value of the driverLicenseCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverLicenseCountryCode(String value) {
        this.driverLicenseCountryCode = value;
    }

    /**
     * Gets the value of the driverLicenseCountryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverLicenseCountryName() {
        return driverLicenseCountryName;
    }

    /**
     * Sets the value of the driverLicenseCountryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverLicenseCountryName(String value) {
        this.driverLicenseCountryName = value;
    }

    /**
     * Gets the value of the enterpriseGenderCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnterpriseGenderCode() {
        return enterpriseGenderCode;
    }

    /**
     * Sets the value of the enterpriseGenderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnterpriseGenderCode(String value) {
        this.enterpriseGenderCode = value;
    }

}
