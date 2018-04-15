
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
 *         &lt;element name="GetUserProfileListByEmailReply" type="{http://ei/corporate/get_user_profile_list_by_email_reply_crp31x1}GetUserProfileListByEmailReply"/>
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
    "getUserProfileListByEmailReply"
})
@XmlRootElement(name = "GetUserProfileListByEmailResponse")
public class GetUserProfileListByEmailResponse {

    @XmlElement(name = "GetUserProfileListByEmailReply", required = true, nillable = true)
    protected GetUserProfileListByEmailReply getUserProfileListByEmailReply;

    /**
     * Gets the value of the getUserProfileListByEmailReply property.
     * 
     * @return
     *     possible object is
     *     {@link GetUserProfileListByEmailReply }
     *     
     */
    public GetUserProfileListByEmailReply getGetUserProfileListByEmailReply() {
        return getUserProfileListByEmailReply;
    }

    /**
     * Sets the value of the getUserProfileListByEmailReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUserProfileListByEmailReply }
     *     
     */
    public void setGetUserProfileListByEmailReply(GetUserProfileListByEmailReply value) {
        this.getUserProfileListByEmailReply = value;
    }

}
