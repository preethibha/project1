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
import chubb_corporate.business.add_get_access_user_profile_reply_ebe4x1.AddGetAccessUserProfileReply;


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
 *         &lt;element name="AddGetAccessUserProfileReply" type="{http://chubb_corporate/business/add_get_access_user_profile_reply_ebe4x1}AddGetAccessUserProfileReply"/>
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
    "addGetAccessUserProfileReply"
})
@XmlRootElement(name = "AddGetAccessUserProfileResponse")
public class AddGetAccessUserProfileResponse
    implements Serializable
{

    @XmlElement(name = "AddGetAccessUserProfileReply", required = true, nillable = true)
    protected AddGetAccessUserProfileReply addGetAccessUserProfileReply;

    /**
     * Gets the value of the addGetAccessUserProfileReply property.
     * 
     * @return
     *     possible object is
     *     {@link AddGetAccessUserProfileReply }
     *     
     */
    public AddGetAccessUserProfileReply getAddGetAccessUserProfileReply() {
        return addGetAccessUserProfileReply;
    }

    /**
     * Sets the value of the addGetAccessUserProfileReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddGetAccessUserProfileReply }
     *     
     */
    public void setAddGetAccessUserProfileReply(AddGetAccessUserProfileReply value) {
        this.addGetAccessUserProfileReply = value;
    }

}
