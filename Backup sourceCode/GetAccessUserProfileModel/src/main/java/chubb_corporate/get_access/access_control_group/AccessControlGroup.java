//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-03/09/2011 06:46 PM(foreman)-)
//


package chubb_corporate.get_access.access_control_group;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * An access control group gives you access to application(s).  In Get Access they refer to these as access roles.
 * 
 * 
 * <p>Java class for AccessControlGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccessControlGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccessControlGroupCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccessControlGroupCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccessControlGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccessControlGroupTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccessControlGroupEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="AccessControlGroupExpirationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="UserAccessControlGroupActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccessControlGroup", propOrder = {
    "accessControlGroupCategoryCode",
    "accessControlGroupCode",
    "accessControlGroupName",
    "accessControlGroupTypeCode",
    "accessControlGroupEffectiveDate",
    "accessControlGroupExpirationDate",
    "userAccessControlGroupActionCode"
})
public class AccessControlGroup
    implements Serializable
{

    @XmlElement(name = "AccessControlGroupCategoryCode")
    protected String accessControlGroupCategoryCode;
    @XmlElement(name = "AccessControlGroupCode")
    protected String accessControlGroupCode;
    @XmlElement(name = "AccessControlGroupName")
    protected String accessControlGroupName;
    @XmlElement(name = "AccessControlGroupTypeCode")
    protected String accessControlGroupTypeCode;
    @XmlElement(name = "AccessControlGroupEffectiveDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar accessControlGroupEffectiveDate;
    @XmlElement(name = "AccessControlGroupExpirationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar accessControlGroupExpirationDate;
    @XmlElement(name = "UserAccessControlGroupActionCode")
    protected String userAccessControlGroupActionCode;

    /**
     * Gets the value of the accessControlGroupCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessControlGroupCategoryCode() {
        return accessControlGroupCategoryCode;
    }

    /**
     * Sets the value of the accessControlGroupCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessControlGroupCategoryCode(String value) {
        this.accessControlGroupCategoryCode = value;
    }

    /**
     * Gets the value of the accessControlGroupCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessControlGroupCode() {
        return accessControlGroupCode;
    }

    /**
     * Sets the value of the accessControlGroupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessControlGroupCode(String value) {
        this.accessControlGroupCode = value;
    }

    /**
     * Gets the value of the accessControlGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessControlGroupName() {
        return accessControlGroupName;
    }

    /**
     * Sets the value of the accessControlGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessControlGroupName(String value) {
        this.accessControlGroupName = value;
    }

    /**
     * Gets the value of the accessControlGroupTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessControlGroupTypeCode() {
        return accessControlGroupTypeCode;
    }

    /**
     * Sets the value of the accessControlGroupTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessControlGroupTypeCode(String value) {
        this.accessControlGroupTypeCode = value;
    }

    /**
     * Gets the value of the accessControlGroupEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAccessControlGroupEffectiveDate() {
        return accessControlGroupEffectiveDate;
    }

    /**
     * Sets the value of the accessControlGroupEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAccessControlGroupEffectiveDate(XMLGregorianCalendar value) {
        this.accessControlGroupEffectiveDate = value;
    }

    /**
     * Gets the value of the accessControlGroupExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAccessControlGroupExpirationDate() {
        return accessControlGroupExpirationDate;
    }

    /**
     * Sets the value of the accessControlGroupExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAccessControlGroupExpirationDate(XMLGregorianCalendar value) {
        this.accessControlGroupExpirationDate = value;
    }

    /**
     * Gets the value of the userAccessControlGroupActionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserAccessControlGroupActionCode() {
        return userAccessControlGroupActionCode;
    }

    /**
     * Sets the value of the userAccessControlGroupActionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserAccessControlGroupActionCode(String value) {
        this.userAccessControlGroupActionCode = value;
    }

}
