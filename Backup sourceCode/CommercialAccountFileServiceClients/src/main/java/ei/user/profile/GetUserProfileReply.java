
package ei.user.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetUserProfileReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetUserProfileReply">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserProfile" type="{http://ei/core/user_profile}UserProfile" minOccurs="0"/>
 *         &lt;element name="StatusInformation" type="{http://ei/core/status_informationx2}StatusInformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUserProfileReply", namespace = "http://ei/corporate/get_user_profile_reply_crp31x1", propOrder = {
    "userProfile",
    "statusInformation"
})
public class GetUserProfileReply {

    @XmlElement(name = "UserProfile")
    protected UserProfile userProfile;
    @XmlElement(name = "StatusInformation")
    protected StatusInformation statusInformation;

    /**
     * Gets the value of the userProfile property.
     * 
     * @return
     *     possible object is
     *     {@link UserProfile }
     *     
     */
    public UserProfile getUserProfile() {
        return userProfile;
    }

    /**
     * Sets the value of the userProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserProfile }
     *     
     */
    public void setUserProfile(UserProfile value) {
        this.userProfile = value;
    }

    /**
     * Gets the value of the statusInformation property.
     * 
     * @return
     *     possible object is
     *     {@link StatusInformation }
     *     
     */
    public StatusInformation getStatusInformation() {
        return statusInformation;
    }

    /**
     * Sets the value of the statusInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusInformation }
     *     
     */
    public void setStatusInformation(StatusInformation value) {
        this.statusInformation = value;
    }

}
