
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
 *         &lt;element name="GetUserProfileListRequest" type="{http://ei/corporate/get_user_profile_list_request_crp31x1}GetUserProfileListRequest"/>
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
    "getUserProfileListRequest"
})
@XmlRootElement(name = "GetUserProfileList")
public class GetUserProfileList {

    @XmlElement(name = "GetUserProfileListRequest", required = true, nillable = true)
    protected GetUserProfileListRequest getUserProfileListRequest;

    /**
     * Gets the value of the getUserProfileListRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetUserProfileListRequest }
     *     
     */
    public GetUserProfileListRequest getGetUserProfileListRequest() {
        return getUserProfileListRequest;
    }

    /**
     * Sets the value of the getUserProfileListRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUserProfileListRequest }
     *     
     */
    public void setGetUserProfileListRequest(GetUserProfileListRequest value) {
        this.getUserProfileListRequest = value;
    }

}
