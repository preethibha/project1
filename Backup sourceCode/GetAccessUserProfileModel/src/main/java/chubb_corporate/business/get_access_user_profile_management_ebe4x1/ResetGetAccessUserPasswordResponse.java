//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-03/09/2011 06:46 PM(foreman)-)
//


package chubb_corporate.business.get_access_user_profile_management_ebe4x1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import chubb_corporate.business.reset_get_access_user_password_reply_ebe4x1.ResetGetAccessUserPasswordReply;


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
 *         &lt;element name="ResetGetAccessUserPasswordReply" type="{http://chubb_corporate/business/reset_get_access_user_password_reply_ebe4x1}ResetGetAccessUserPasswordReply"/>
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
    "resetGetAccessUserPasswordReply"
})
@XmlRootElement(name = "ResetGetAccessUserPasswordResponse")
public class ResetGetAccessUserPasswordResponse
    implements Serializable
{

    @XmlElement(name = "ResetGetAccessUserPasswordReply", required = true, nillable = true)
    protected ResetGetAccessUserPasswordReply resetGetAccessUserPasswordReply;

    /**
     * Gets the value of the resetGetAccessUserPasswordReply property.
     * 
     * @return
     *     possible object is
     *     {@link ResetGetAccessUserPasswordReply }
     *     
     */
    public ResetGetAccessUserPasswordReply getResetGetAccessUserPasswordReply() {
        return resetGetAccessUserPasswordReply;
    }

    /**
     * Sets the value of the resetGetAccessUserPasswordReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResetGetAccessUserPasswordReply }
     *     
     */
    public void setResetGetAccessUserPasswordReply(ResetGetAccessUserPasswordReply value) {
        this.resetGetAccessUserPasswordReply = value;
    }

}
