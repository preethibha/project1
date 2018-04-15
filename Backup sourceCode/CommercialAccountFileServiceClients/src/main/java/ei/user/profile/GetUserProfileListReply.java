
package ei.user.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetUserProfileListReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetUserProfileListReply">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetUserProfileListOutputs" type="{http://ei/corporate/get_user_profile_list_outputs_crp31x1}GetUserProfileListOutputs" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "GetUserProfileListReply", namespace = "http://ei/corporate/get_user_profile_list_reply_crp31x1", propOrder = {
    "getUserProfileListOutputs",
    "statusInformation"
})
public class GetUserProfileListReply {

    @XmlElement(name = "GetUserProfileListOutputs")
    protected List<GetUserProfileListOutputs> getUserProfileListOutputs;
    @XmlElement(name = "StatusInformation")
    protected StatusInformation statusInformation;

    /**
     * Gets the value of the getUserProfileListOutputs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getUserProfileListOutputs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetUserProfileListOutputs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetUserProfileListOutputs }
     * 
     * 
     */
    public List<GetUserProfileListOutputs> getGetUserProfileListOutputs() {
        if (getUserProfileListOutputs == null) {
            getUserProfileListOutputs = new ArrayList<GetUserProfileListOutputs>();
        }
        return this.getUserProfileListOutputs;
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
