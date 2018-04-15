
package ei.user.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApplicationUserProfileProperty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApplicationUserProfileProperty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserProfilePropertyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserProfilePropertyValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataSourceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationUserProfileProperty", namespace = "http://ei/core/application_user_profile_property", propOrder = {
    "userProfilePropertyName",
    "userProfilePropertyValue",
    "dataSourceName"
})
public class ApplicationUserProfileProperty {

    @XmlElement(name = "UserProfilePropertyName")
    protected String userProfilePropertyName;
    @XmlElement(name = "UserProfilePropertyValue")
    protected String userProfilePropertyValue;
    @XmlElement(name = "DataSourceName")
    protected String dataSourceName;

    /**
     * Gets the value of the userProfilePropertyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserProfilePropertyName() {
        return userProfilePropertyName;
    }

    /**
     * Sets the value of the userProfilePropertyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserProfilePropertyName(String value) {
        this.userProfilePropertyName = value;
    }

    /**
     * Gets the value of the userProfilePropertyValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserProfilePropertyValue() {
        return userProfilePropertyValue;
    }

    /**
     * Sets the value of the userProfilePropertyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserProfilePropertyValue(String value) {
        this.userProfilePropertyValue = value;
    }

    /**
     * Gets the value of the dataSourceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataSourceName() {
        return dataSourceName;
    }

    /**
     * Sets the value of the dataSourceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataSourceName(String value) {
        this.dataSourceName = value;
    }

}
