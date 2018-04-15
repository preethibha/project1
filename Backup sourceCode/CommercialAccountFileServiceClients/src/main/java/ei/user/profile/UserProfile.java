
package ei.user.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="User" type="{http://ei/core/user}User" minOccurs="0"/>
 *         &lt;element name="RegionAndLanguageSettings" type="{http://ei/core/region_and_language_settings}RegionAndLanguageSettings" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AccessControlGroup" type="{http://ei/core/access_control_group}AccessControlGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ApplicationUserProfile" type="{http://ei/core/application_user_profile}ApplicationUserProfile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="UserAuthorization" type="{http://ei/core/user_authorization}UserAuthorization" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="UserProfileStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserProfileSourceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExternalUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PersonGIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommonUserGIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customization" type="{http://ei/core/customizationx1}Customization" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SourceSystemUserProfileId" type="{http://ei/core/source_system_user_profile_id}SourceSystemUserProfileId" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserProfile", namespace = "http://ei/core/user_profile", propOrder = {
    "user",
    "regionAndLanguageSettings",
    "accessControlGroup",
    "applicationUserProfile",
    "userAuthorization",
    "userProfileStatusCode",
    "userProfileSourceName",
    "externalUserId",
    "personGIN",
    "commonUserGIN",
    "customization",
    "sourceSystemUserProfileId"
})
public class UserProfile {

    @XmlElement(name = "User")
    protected User user;
    @XmlElement(name = "RegionAndLanguageSettings")
    protected List<RegionAndLanguageSettings> regionAndLanguageSettings;
    @XmlElement(name = "AccessControlGroup")
    protected List<AccessControlGroup> accessControlGroup;
    @XmlElement(name = "ApplicationUserProfile")
    protected List<ApplicationUserProfile> applicationUserProfile;
    @XmlElement(name = "UserAuthorization")
    protected List<UserAuthorization> userAuthorization;
    @XmlElement(name = "UserProfileStatusCode")
    protected String userProfileStatusCode;
    @XmlElement(name = "UserProfileSourceName")
    protected String userProfileSourceName;
    @XmlElement(name = "ExternalUserId")
    protected String externalUserId;
    @XmlElement(name = "PersonGIN")
    protected String personGIN;
    @XmlElement(name = "CommonUserGIN")
    protected String commonUserGIN;
    @XmlElement(name = "Customization")
    protected List<Customization> customization;
    @XmlElement(name = "SourceSystemUserProfileId")
    protected List<SourceSystemUserProfileId> sourceSystemUserProfileId;

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Gets the value of the regionAndLanguageSettings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regionAndLanguageSettings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegionAndLanguageSettings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegionAndLanguageSettings }
     * 
     * 
     */
    public List<RegionAndLanguageSettings> getRegionAndLanguageSettings() {
        if (regionAndLanguageSettings == null) {
            regionAndLanguageSettings = new ArrayList<RegionAndLanguageSettings>();
        }
        return this.regionAndLanguageSettings;
    }

    /**
     * Gets the value of the accessControlGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accessControlGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccessControlGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccessControlGroup }
     * 
     * 
     */
    public List<AccessControlGroup> getAccessControlGroup() {
        if (accessControlGroup == null) {
            accessControlGroup = new ArrayList<AccessControlGroup>();
        }
        return this.accessControlGroup;
    }

    /**
     * Gets the value of the applicationUserProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicationUserProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicationUserProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApplicationUserProfile }
     * 
     * 
     */
    public List<ApplicationUserProfile> getApplicationUserProfile() {
        if (applicationUserProfile == null) {
            applicationUserProfile = new ArrayList<ApplicationUserProfile>();
        }
        return this.applicationUserProfile;
    }

    /**
     * Gets the value of the userAuthorization property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userAuthorization property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserAuthorization().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserAuthorization }
     * 
     * 
     */
    public List<UserAuthorization> getUserAuthorization() {
        if (userAuthorization == null) {
            userAuthorization = new ArrayList<UserAuthorization>();
        }
        return this.userAuthorization;
    }

    /**
     * Gets the value of the userProfileStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserProfileStatusCode() {
        return userProfileStatusCode;
    }

    /**
     * Sets the value of the userProfileStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserProfileStatusCode(String value) {
        this.userProfileStatusCode = value;
    }

    /**
     * Gets the value of the userProfileSourceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserProfileSourceName() {
        return userProfileSourceName;
    }

    /**
     * Sets the value of the userProfileSourceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserProfileSourceName(String value) {
        this.userProfileSourceName = value;
    }

    /**
     * Gets the value of the externalUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalUserId() {
        return externalUserId;
    }

    /**
     * Sets the value of the externalUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalUserId(String value) {
        this.externalUserId = value;
    }

    /**
     * Gets the value of the personGIN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonGIN() {
        return personGIN;
    }

    /**
     * Sets the value of the personGIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonGIN(String value) {
        this.personGIN = value;
    }

    /**
     * Gets the value of the commonUserGIN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommonUserGIN() {
        return commonUserGIN;
    }

    /**
     * Sets the value of the commonUserGIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommonUserGIN(String value) {
        this.commonUserGIN = value;
    }

    /**
     * Gets the value of the customization property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customization property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomization().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Customization }
     * 
     * 
     */
    public List<Customization> getCustomization() {
        if (customization == null) {
            customization = new ArrayList<Customization>();
        }
        return this.customization;
    }

    /**
     * Gets the value of the sourceSystemUserProfileId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourceSystemUserProfileId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceSystemUserProfileId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SourceSystemUserProfileId }
     * 
     * 
     */
    public List<SourceSystemUserProfileId> getSourceSystemUserProfileId() {
        if (sourceSystemUserProfileId == null) {
            sourceSystemUserProfileId = new ArrayList<SourceSystemUserProfileId>();
        }
        return this.sourceSystemUserProfileId;
    }

}
