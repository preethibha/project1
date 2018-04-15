
package ei.user.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserProfileIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserProfileIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExternalUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PersonGIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommonUserGIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceSystemUserProfileId" type="{http://ei/core/source_system_user_profile_id}SourceSystemUserProfileId" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserProfileIdentifier", namespace = "http://ei/core/user_profile_identifier", propOrder = {
    "externalUserId",
    "personGIN",
    "commonUserGIN",
    "emailAddress",
    "sourceSystemUserProfileId"
})
public class UserProfileIdentifier {

    @XmlElement(name = "ExternalUserId")
    protected String externalUserId;
    @XmlElement(name = "PersonGIN")
    protected String personGIN;
    @XmlElement(name = "CommonUserGIN")
    protected String commonUserGIN;
    @XmlElement(name = "EmailAddress")
    protected String emailAddress;
    @XmlElement(name = "SourceSystemUserProfileId")
    protected List<SourceSystemUserProfileId> sourceSystemUserProfileId;

    /**
     * Gets the value of the externalUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalUserId() {
        return externalUserId;
    }

    /**
     * Sets the value of the externalUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalUserId(String value) {
        this.externalUserId = value;
    }

    /**
     * Gets the value of the personGIN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonGIN() {
        return personGIN;
    }

    /**
     * Sets the value of the personGIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonGIN(String value) {
        this.personGIN = value;
    }

    /**
     * Gets the value of the commonUserGIN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommonUserGIN() {
        return commonUserGIN;
    }

    /**
     * Sets the value of the commonUserGIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommonUserGIN(String value) {
        this.commonUserGIN = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the sourceSystemUserProfileId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourceSystemUserProfileId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceSystemUserProfileId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SourceSystemUserProfileId }
     * 
     * 
     */
    public List<SourceSystemUserProfileId> getSourceSystemUserProfileId() {
        if (sourceSystemUserProfileId == null) {
            sourceSystemUserProfileId = new ArrayList<SourceSystemUserProfileId>();
        }
        return this.sourceSystemUserProfileId;
    }

}
