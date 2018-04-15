
package ei.user.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A user is a specific resource that is given access to computer systems.
 * 
 * <p>Java class for User complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="User">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ei/core/business_partyx1}BusinessParty">
 *       &lt;sequence>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BusinessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserOrganizationRoleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", namespace = "http://ei/core/user", propOrder = {
    "userId",
    "userTypeCode",
    "userTypeDescription",
    "businessName",
    "userOrganizationRoleName"
})
public class User
    extends BusinessParty
{

    @XmlElement(name = "UserId")
    protected String userId;
    @XmlElement(name = "UserTypeCode")
    protected String userTypeCode;
    @XmlElement(name = "UserTypeDescription")
    protected String userTypeDescription;
    @XmlElement(name = "BusinessName")
    protected String businessName;
    @XmlElement(name = "UserOrganizationRoleName")
    protected String userOrganizationRoleName;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the userTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserTypeCode() {
        return userTypeCode;
    }

    /**
     * Sets the value of the userTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserTypeCode(String value) {
        this.userTypeCode = value;
    }

    /**
     * Gets the value of the userTypeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserTypeDescription() {
        return userTypeDescription;
    }

    /**
     * Sets the value of the userTypeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserTypeDescription(String value) {
        this.userTypeDescription = value;
    }

    /**
     * Gets the value of the businessName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * Sets the value of the businessName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessName(String value) {
        this.businessName = value;
    }

    /**
     * Gets the value of the userOrganizationRoleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserOrganizationRoleName() {
        return userOrganizationRoleName;
    }

    /**
     * Sets the value of the userOrganizationRoleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserOrganizationRoleName(String value) {
        this.userOrganizationRoleName = value;
    }

}
