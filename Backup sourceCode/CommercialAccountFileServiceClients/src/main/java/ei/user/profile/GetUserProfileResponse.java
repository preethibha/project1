
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
 *         &lt;element name="GetUserProfileReply" type="{http://ei/corporate/get_user_profile_reply_crp31x1}GetUserProfileReply"/>
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
    "getUserProfileReply"
})
@XmlRootElement(name = "GetUserProfileResponse")
public class GetUserProfileResponse {

    @XmlElement(name = "GetUserProfileReply", required = true, nillable = true)
    protected GetUserProfileReply getUserProfileReply;

    /**
     * Gets the value of the getUserProfileReply property.
     * 
     * @return
     *     possible object is
     *     {@link GetUserProfileReply }
     *     
     */
    public GetUserProfileReply getGetUserProfileReply() {
        return getUserProfileReply;
    }

    /**
     * Sets the value of the getUserProfileReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUserProfileReply }
     *     
     */
    public void setGetUserProfileReply(GetUserProfileReply value) {
        this.getUserProfileReply = value;
    }

}
