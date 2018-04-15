
package ei.user.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetUserProfileListByEmailRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetUserProfileListByEmailRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceConsumerSystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SyntheticTransactionTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdditionalOptionsText" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DataSourceOptionsText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUserProfileListByEmailRequest", namespace = "http://ei/corporate/get_user_profile_list_by_email_request_crp31x1", propOrder = {
    "userId",
    "systemId",
    "serviceConsumerSystemId",
    "syntheticTransactionTypeCode",
    "additionalOptionsText",
    "dataSourceOptionsText",
    "userTypeDescription",
    "emailAddress"
})
public class GetUserProfileListByEmailRequest {

    @XmlElement(name = "UserId")
    protected String userId;
    @XmlElement(name = "SystemId")
    protected String systemId;
    @XmlElement(name = "ServiceConsumerSystemId")
    protected String serviceConsumerSystemId;
    @XmlElement(name = "SyntheticTransactionTypeCode")
    protected String syntheticTransactionTypeCode;
    @XmlElement(name = "AdditionalOptionsText")
    protected List<String> additionalOptionsText;
    @XmlElement(name = "DataSourceOptionsText")
    protected String dataSourceOptionsText;
    @XmlElement(name = "UserTypeDescription")
    protected String userTypeDescription;
    @XmlElement(name = "EmailAddress")
    protected String emailAddress;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the systemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * Sets the value of the systemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemId(String value) {
        this.systemId = value;
    }

    /**
     * Gets the value of the serviceConsumerSystemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceConsumerSystemId() {
        return serviceConsumerSystemId;
    }

    /**
     * Sets the value of the serviceConsumerSystemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceConsumerSystemId(String value) {
        this.serviceConsumerSystemId = value;
    }

    /**
     * Gets the value of the syntheticTransactionTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSyntheticTransactionTypeCode() {
        return syntheticTransactionTypeCode;
    }

    /**
     * Sets the value of the syntheticTransactionTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSyntheticTransactionTypeCode(String value) {
        this.syntheticTransactionTypeCode = value;
    }

    /**
     * Gets the value of the additionalOptionsText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalOptionsText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalOptionsText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAdditionalOptionsText() {
        if (additionalOptionsText == null) {
            additionalOptionsText = new ArrayList<String>();
        }
        return this.additionalOptionsText;
    }

    /**
     * Gets the value of the dataSourceOptionsText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataSourceOptionsText() {
        return dataSourceOptionsText;
    }

    /**
     * Sets the value of the dataSourceOptionsText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataSourceOptionsText(String value) {
        this.dataSourceOptionsText = value;
    }

    /**
     * Gets the value of the userTypeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserTypeDescription() {
        return userTypeDescription;
    }

    /**
     * Sets the value of the userTypeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserTypeDescription(String value) {
        this.userTypeDescription = value;
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

}
