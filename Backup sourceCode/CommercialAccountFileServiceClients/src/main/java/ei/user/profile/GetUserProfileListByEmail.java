
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
 *         &lt;element name="GetUserProfileListByEmailRequest" type="{http://ei/corporate/get_user_profile_list_by_email_request_crp31x1}GetUserProfileListByEmailRequest"/>
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
    "getUserProfileListByEmailRequest"
})
@XmlRootElement(name = "GetUserProfileListByEmail")
public class GetUserProfileListByEmail {

    @XmlElement(name = "GetUserProfileListByEmailRequest", required = true, nillable = true)
    protected GetUserProfileListByEmailRequest getUserProfileListByEmailRequest;

    /**
     * Gets the value of the getUserProfileListByEmailRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetUserProfileListByEmailRequest }
     *     
     */
    public GetUserProfileListByEmailRequest getGetUserProfileListByEmailRequest() {
        return getUserProfileListByEmailRequest;
    }

    /**
     * Sets the value of the getUserProfileListByEmailRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUserProfileListByEmailRequest }
     *     
     */
    public void setGetUserProfileListByEmailRequest(GetUserProfileListByEmailRequest value) {
        this.getUserProfileListByEmailRequest = value;
    }

}
