
package ei.user.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetUserProfileListOutputs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetUserProfileListOutputs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserProfileIdentifier" type="{http://ei/core/user_profile_identifier}UserProfileIdentifier" minOccurs="0"/>
 *         &lt;element name="UserProfile" type="{http://ei/core/user_profile}UserProfile" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUserProfileListOutputs", namespace = "http://ei/corporate/get_user_profile_list_outputs_crp31x1", propOrder = {
    "userProfileIdentifier",
    "userProfile"
})
public class GetUserProfileListOutputs {

    @XmlElement(name = "UserProfileIdentifier")
    protected UserProfileIdentifier userProfileIdentifier;
    @XmlElement(name = "UserProfile")
    protected List<UserProfile> userProfile;

    /**
     * Gets the value of the userProfileIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link UserProfileIdentifier }
     *     
     */
    public UserProfileIdentifier getUserProfileIdentifier() {
        return userProfileIdentifier;
    }

    /**
     * Sets the value of the userProfileIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserProfileIdentifier }
     *     
     */
    public void setUserProfileIdentifier(UserProfileIdentifier value) {
        this.userProfileIdentifier = value;
    }

    /**
     * Gets the value of the userProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserProfile }
     * 
     * 
     */
    public List<UserProfile> getUserProfile() {
        if (userProfile == null) {
            userProfile = new ArrayList<UserProfile>();
        }
        return this.userProfile;
    }

}
