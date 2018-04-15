
package ei.user.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StandardizedAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StandardizedAddress">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ei/core/addressx5}Address">
 *       &lt;sequence>
 *         &lt;element name="BuildingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StreetNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreDirectionalAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StreetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StreetSuffixAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostDirectionalAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressUnitNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressUnitTypeAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeliveryPointNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FIPSCountyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FIPSStateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EnclosingPostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GeoCodingStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandardizedAddress", namespace = "http://ei/core/standardized_addressx5", propOrder = {
    "buildingName",
    "streetNumber",
    "preDirectionalAbbreviation",
    "streetName",
    "streetSuffixAbbreviation",
    "postDirectionalAbbreviation",
    "addressUnitNumber",
    "addressUnitTypeAbbreviation",
    "deliveryPointNumber",
    "latitude",
    "longitude",
    "fipsCountyCode",
    "fipsStateCode",
    "enclosingPostalCode",
    "geoCodingStatusCode"
})
public class StandardizedAddress
    extends Address
{

    @XmlElement(name = "BuildingName")
    protected String buildingName;
    @XmlElement(name = "StreetNumber")
    protected String streetNumber;
    @XmlElement(name = "PreDirectionalAbbreviation")
    protected String preDirectionalAbbreviation;
    @XmlElement(name = "StreetName")
    protected String streetName;
    @XmlElement(name = "StreetSuffixAbbreviation")
    protected String streetSuffixAbbreviation;
    @XmlElement(name = "PostDirectionalAbbreviation")
    protected String postDirectionalAbbreviation;
    @XmlElement(name = "AddressUnitNumber")
    protected String addressUnitNumber;
    @XmlElement(name = "AddressUnitTypeAbbreviation")
    protected String addressUnitTypeAbbreviation;
    @XmlElement(name = "DeliveryPointNumber")
    protected String deliveryPointNumber;
    @XmlElement(name = "Latitude")
    protected String latitude;
    @XmlElement(name = "Longitude")
    protected String longitude;
    @XmlElement(name = "FIPSCountyCode")
    protected String fipsCountyCode;
    @XmlElement(name = "FIPSStateCode")
    protected String fipsStateCode;
    @XmlElement(name = "EnclosingPostalCode")
    protected String enclosingPostalCode;
    @XmlElement(name = "GeoCodingStatusCode")
    protected String geoCodingStatusCode;

    /**
     * Gets the value of the buildingName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * Sets the value of the buildingName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuildingName(String value) {
        this.buildingName = value;
    }

    /**
     * Gets the value of the streetNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * Sets the value of the streetNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNumber(String value) {
        this.streetNumber = value;
    }

    /**
     * Gets the value of the preDirectionalAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreDirectionalAbbreviation() {
        return preDirectionalAbbreviation;
    }

    /**
     * Sets the value of the preDirectionalAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreDirectionalAbbreviation(String value) {
        this.preDirectionalAbbreviation = value;
    }

    /**
     * Gets the value of the streetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the value of the streetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetName(String value) {
        this.streetName = value;
    }

    /**
     * Gets the value of the streetSuffixAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetSuffixAbbreviation() {
        return streetSuffixAbbreviation;
    }

    /**
     * Sets the value of the streetSuffixAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetSuffixAbbreviation(String value) {
        this.streetSuffixAbbreviation = value;
    }

    /**
     * Gets the value of the postDirectionalAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostDirectionalAbbreviation() {
        return postDirectionalAbbreviation;
    }

    /**
     * Sets the value of the postDirectionalAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostDirectionalAbbreviation(String value) {
        this.postDirectionalAbbreviation = value;
    }

    /**
     * Gets the value of the addressUnitNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressUnitNumber() {
        return addressUnitNumber;
    }

    /**
     * Sets the value of the addressUnitNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressUnitNumber(String value) {
        this.addressUnitNumber = value;
    }

    /**
     * Gets the value of the addressUnitTypeAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressUnitTypeAbbreviation() {
        return addressUnitTypeAbbreviation;
    }

    /**
     * Sets the value of the addressUnitTypeAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressUnitTypeAbbreviation(String value) {
        this.addressUnitTypeAbbreviation = value;
    }

    /**
     * Gets the value of the deliveryPointNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryPointNumber() {
        return deliveryPointNumber;
    }

    /**
     * Sets the value of the deliveryPointNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryPointNumber(String value) {
        this.deliveryPointNumber = value;
    }

    /**
     * Gets the value of the latitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatitude(String value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongitude(String value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the fipsCountyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIPSCountyCode() {
        return fipsCountyCode;
    }

    /**
     * Sets the value of the fipsCountyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIPSCountyCode(String value) {
        this.fipsCountyCode = value;
    }

    /**
     * Gets the value of the fipsStateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIPSStateCode() {
        return fipsStateCode;
    }

    /**
     * Sets the value of the fipsStateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIPSStateCode(String value) {
        this.fipsStateCode = value;
    }

    /**
     * Gets the value of the enclosingPostalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnclosingPostalCode() {
        return enclosingPostalCode;
    }

    /**
     * Sets the value of the enclosingPostalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnclosingPostalCode(String value) {
        this.enclosingPostalCode = value;
    }

    /**
     * Gets the value of the geoCodingStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeoCodingStatusCode() {
        return geoCodingStatusCode;
    }

    /**
     * Sets the value of the geoCodingStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeoCodingStatusCode(String value) {
        this.geoCodingStatusCode = value;
    }

}
