//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package chubb_corporate.business.get_access_user_profile_management_ebe4x1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import chubb_corporate.business.update_get_access_user_profile_reply_ebe4x1.UpdateGetAccessUserProfileReply;


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
 *         &lt;element name="UpdateGetAccessUserProfileReply" type="{http://chubb_corporate/business/update_get_access_user_profile_reply_ebe4x1}UpdateGetAccessUserProfileReply"/>
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
    "updateGetAccessUserProfileReply"
})
@XmlRootElement(name = "UpdateGetAccessUserProfileResponse")
public class UpdateGetAccessUserProfileResponse
    implements Serializable
{

    @XmlElement(name = "UpdateGetAccessUserProfileReply", required = true, nillable = true)
    protected UpdateGetAccessUserProfileReply updateGetAccessUserProfileReply;

    /**
     * Gets the value of the updateGetAccessUserProfileReply property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateGetAccessUserProfileReply }
     *     
     */
    public UpdateGetAccessUserProfileReply getUpdateGetAccessUserProfileReply() {
        return updateGetAccessUserProfileReply;
    }

    /**
     * Sets the value of the updateGetAccessUserProfileReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateGetAccessUserProfileReply }
     *     
     */
    public void setUpdateGetAccessUserProfileReply(UpdateGetAccessUserProfileReply value) {
        this.updateGetAccessUserProfileReply = value;
    }

}
