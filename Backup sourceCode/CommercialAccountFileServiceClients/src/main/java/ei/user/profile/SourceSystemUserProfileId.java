
package ei.user.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This object is used to identify the user profile id for each specific source system. 
 * 
 * <p>Java class for SourceSystemUserProfileId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SourceSystemUserProfileId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserProfileSourceSystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserProfileSourceSystemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceSystemUserProfileId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SourceSystemUserProfileId", namespace = "http://ei/core/source_system_user_profile_id", propOrder = {
    "userProfileSourceSystemId",
    "userProfileSourceSystemName",
    "sourceSystemUserProfileId"
})
public class SourceSystemUserProfileId {

    @XmlElement(name = "UserProfileSourceSystemId")
    protected String userProfileSourceSystemId;
    @XmlElement(name = "UserProfileSourceSystemName")
    protected String userProfileSourceSystemName;
    @XmlElement(name = "SourceSystemUserProfileId")
    protected String sourceSystemUserProfileId;

    /**
     * Gets the value of the userProfileSourceSystemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserProfileSourceSystemId() {
        return userProfileSourceSystemId;
    }

    /**
     * Sets the value of the userProfileSourceSystemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserProfileSourceSystemId(String value) {
        this.userProfileSourceSystemId = value;
    }

    /**
     * Gets the value of the userProfileSourceSystemName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserProfileSourceSystemName() {
        return userProfileSourceSystemName;
    }

    /**
     * Sets the value of the userProfileSourceSystemName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserProfileSourceSystemName(String value) {
        this.userProfileSourceSystemName = value;
    }

    /**
     * Gets the value of the sourceSystemUserProfileId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceSystemUserProfileId() {
        return sourceSystemUserProfileId;
    }

    /**
     * Sets the value of the sourceSystemUserProfileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceSystemUserProfileId(String value) {
        this.sourceSystemUserProfileId = value;
    }

}
