//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package chubb_corporate.get_access.time_zone;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A 'Time Zone' refers to any of 24 regions loosely divided by longitude, where the same standard time is kept.  The Greenwich Meridian, also known as the prime meridian or International Meridian, is the "starting point" for dividing the Earth's surface into time zones. Each time zone is 15 degrees of longitude wide (with local variations) and the local time is one hour earlier than the zone immediately to the east on the map.
 * 
 * <p>Java class for TimeZone complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeZone">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TimeZoneCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeZoneAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeZoneName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CoordinatedUniversalTimeOffsetValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeZone", namespace = "http://chubb_corporate/get_access/time_zone", propOrder = {
    "timeZoneCode",
    "timeZoneAbbreviation",
    "timeZoneName",
    "coordinatedUniversalTimeOffsetValue"
})
public class TimeZone
    implements Serializable
{

    @XmlElement(name = "TimeZoneCode")
    protected String timeZoneCode;
    @XmlElement(name = "TimeZoneAbbreviation")
    protected String timeZoneAbbreviation;
    @XmlElement(name = "TimeZoneName")
    protected String timeZoneName;
    @XmlElement(name = "CoordinatedUniversalTimeOffsetValue")
    protected String coordinatedUniversalTimeOffsetValue;

    /**
     * Gets the value of the timeZoneCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZoneCode() {
        return timeZoneCode;
    }

    /**
     * Sets the value of the timeZoneCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZoneCode(String value) {
        this.timeZoneCode = value;
    }

    /**
     * Gets the value of the timeZoneAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZoneAbbreviation() {
        return timeZoneAbbreviation;
    }

    /**
     * Sets the value of the timeZoneAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZoneAbbreviation(String value) {
        this.timeZoneAbbreviation = value;
    }

    /**
     * Gets the value of the timeZoneName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZoneName() {
        return timeZoneName;
    }

    /**
     * Sets the value of the timeZoneName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZoneName(String value) {
        this.timeZoneName = value;
    }

    /**
     * Gets the value of the coordinatedUniversalTimeOffsetValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordinatedUniversalTimeOffsetValue() {
        return coordinatedUniversalTimeOffsetValue;
    }

    /**
     * Sets the value of the coordinatedUniversalTimeOffsetValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordinatedUniversalTimeOffsetValue(String value) {
        this.coordinatedUniversalTimeOffsetValue = value;
    }

}
