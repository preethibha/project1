
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
 *         &lt;element name="GetUserProfileListReply" type="{http://ei/corporate/get_user_profile_list_reply_crp31x1}GetUserProfileListReply"/>
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
    "getUserProfileListReply"
})
@XmlRootElement(name = "GetUserProfileListResponse")
public class GetUserProfileListResponse {

    @XmlElement(name = "GetUserProfileListReply", required = true, nillable = true)
    protected GetUserProfileListReply getUserProfileListReply;

    /**
     * Gets the value of the getUserProfileListReply property.
     * 
     * @return
     *     possible object is
     *     {@link GetUserProfileListReply }
     *     
     */
    public GetUserProfileListReply getGetUserProfileListReply() {
        return getUserProfileListReply;
    }

    /**
     * Sets the value of the getUserProfileListReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUserProfileListReply }
     *     
     */
    public void setGetUserProfileListReply(GetUserProfileListReply value) {
        this.getUserProfileListReply = value;
    }

}
