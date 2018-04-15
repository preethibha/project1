
package ei.core.addressx5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * This business object contains address elements.
 * 		
 * 
 * <p>Java class for Address complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Address">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddressLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressLine3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StateOrProvinceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StateOrProvinceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StateOrProvinceAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalStateAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOCountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocationPlaceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POBoxIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Zip4Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POBoxNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZipCodeFirst5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Address", propOrder = {
    "addressLine1",
    "addressLine2",
    "addressLine3",
    "cityName",
    "countyName",
    "stateOrProvinceCode",
    "stateOrProvinceName",
    "stateOrProvinceAbbreviation",
    "postalStateAbbreviation",
    "postalCode",
    "countryCode",
    "countryName",
    "countryAbbreviation",
    "isoCountryCode",
    "locationPlaceCode",
    "poBoxIndicator",
    "zip4Code",
    "poBoxNumber",
    "zipCodeFirst5"
})
public class Address {

    @XmlElement(name = "AddressLine1")
    protected String addressLine1;
    @XmlElement(name = "AddressLine2")
    protected String addressLine2;
    @XmlElement(name = "AddressLine3")
    protected String addressLine3;
    @XmlElement(name = "CityName")
    protected String cityName;
    @XmlElement(name = "CountyName")
    protected String countyName;
    @XmlElement(name = "StateOrProvinceCode")
    protected String stateOrProvinceCode;
    @XmlElement(name = "StateOrProvinceName")
    protected String stateOrProvinceName;
    @XmlElement(name = "StateOrProvinceAbbreviation")
    protected String stateOrProvinceAbbreviation;
    @XmlElement(name = "PostalStateAbbreviation")
    protected String postalStateAbbreviation;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "CountryCode")
    protected String countryCode;
    @XmlElement(name = "CountryName")
    protected String countryName;
    @XmlElement(name = "CountryAbbreviation")
    protected String countryAbbreviation;
    @XmlElement(name = "ISOCountryCode")
    protected String isoCountryCode;
    @XmlElement(name = "LocationPlaceCode")
    protected String locationPlaceCode;
    @XmlElement(name = "POBoxIndicator")
    protected Boolean poBoxIndicator;
    @XmlElement(name = "Zip4Code")
    protected String zip4Code;
    @XmlElement(name = "POBoxNumber")
    protected String poBoxNumber;
    @XmlElement(name = "ZipCodeFirst5")
    protected String zipCodeFirst5;

    /**
     * Gets the value of the addressLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the value of the addressLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine1(String value) {
        this.addressLine1 = value;
    }

    /**
     * Gets the value of the addressLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the value of the addressLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine2(String value) {
        this.addressLine2 = value;
    }

    /**
     * Gets the value of the addressLine3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine3() {
        return addressLine3;
    }

    /**
     * Sets the value of the addressLine3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine3(String value) {
        this.addressLine3 = value;
    }

    /**
     * Gets the value of the cityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the value of the cityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityName(String value) {
        this.cityName = value;
    }

    /**
     * Gets the value of the countyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountyName() {
        return countyName;
    }

    /**
     * Sets the value of the countyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountyName(String value) {
        this.countyName = value;
    }

    /**
     * Gets the value of the stateOrProvinceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateOrProvinceCode() {
        return stateOrProvinceCode;
    }

    /**
     * Sets the value of the stateOrProvinceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateOrProvinceCode(String value) {
        this.stateOrProvinceCode = value;
    }

    /**
     * Gets the value of the stateOrProvinceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateOrProvinceName() {
        return stateOrProvinceName;
    }

    /**
     * Sets the value of the stateOrProvinceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateOrProvinceName(String value) {
        this.stateOrProvinceName = value;
    }

    /**
     * Gets the value of the stateOrProvinceAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateOrProvinceAbbreviation() {
        return stateOrProvinceAbbreviation;
    }

    /**
     * Sets the value of the stateOrProvinceAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateOrProvinceAbbreviation(String value) {
        this.stateOrProvinceAbbreviation = value;
    }

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
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the countryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the countryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

    /**
     * Gets the value of the countryAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    /**
     * Sets the value of the countryAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryAbbreviation(String value) {
        this.countryAbbreviation = value;
    }

    /**
     * Gets the value of the isoCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOCountryCode() {
        return isoCountryCode;
    }

    /**
     * Sets the value of the isoCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOCountryCode(String value) {
        this.isoCountryCode = value;
    }

    /**
     * Gets the value of the locationPlaceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationPlaceCode() {
        return locationPlaceCode;
    }

    /**
     * Sets the value of the locationPlaceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationPlaceCode(String value) {
        this.locationPlaceCode = value;
    }

    /**
     * Gets the value of the poBoxIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPOBoxIndicator() {
        return poBoxIndicator;
    }

    /**
     * Sets the value of the poBoxIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPOBoxIndicator(Boolean value) {
        this.poBoxIndicator = value;
    }

    /**
     * Gets the value of the zip4Code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZip4Code() {
        return zip4Code;
    }

    /**
     * Sets the value of the zip4Code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZip4Code(String value) {
        this.zip4Code = value;
    }

    /**
     * Gets the value of the poBoxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOBoxNumber() {
        return poBoxNumber;
    }

    /**
     * Sets the value of the poBoxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOBoxNumber(String value) {
        this.poBoxNumber = value;
    }

    /**
     * Gets the value of the zipCodeFirst5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipCodeFirst5() {
        return zipCodeFirst5;
    }

    /**
     * Sets the value of the zipCodeFirst5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipCodeFirst5(String value) {
        this.zipCodeFirst5 = value;
    }

}
