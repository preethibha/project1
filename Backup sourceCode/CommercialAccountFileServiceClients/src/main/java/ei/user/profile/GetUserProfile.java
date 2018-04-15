
package ei.user.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetUserProfileRequest" type="{http://ei/corporate/get_user_profile_request_crp31x1}GetUserProfileRequest"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getUserProfileRequest"
})
@XmlRootElement(name = "GetUserProfile")
public class GetUserProfile {

    @XmlElement(name = "GetUserProfileRequest", required = true, nillable = true)
    protected GetUserProfileRequest getUserProfileRequest;

    /**
     * Gets the value of the getUserProfileRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetUserProfileRequest }
     *     
     */
    public GetUserProfileRequest getGetUserProfileRequest() {
        return getUserProfileRequest;
    }

    /**
     * Sets the value of the getUserProfileRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUserProfileRequest }
     *     
     */
    public void setGetUserProfileRequest(GetUserProfileRequest value) {
        this.getUserProfileRequest = value;
    }

}
