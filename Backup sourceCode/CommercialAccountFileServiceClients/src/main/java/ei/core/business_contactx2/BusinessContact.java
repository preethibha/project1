//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.core.business_contactx2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ei.core.email_information.EmailInformation;
import ei.core.phone_information.PhoneInformation;
import ei.core.typed_address.TypedAddress;


/**
 * <p>Java class for BusinessContact complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusinessContact">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TypedAddress" type="{http://ei/core/typed_address}TypedAddress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PhoneInformation" type="{http://ei/core/phone_information}PhoneInformation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EmailInformation" type="{http://ei/core/email_information}EmailInformation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ContactName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BusinessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactTitleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactOrderPreferenceTypeNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ContactTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactTypeAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CPNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceSystemBusinessContactId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessContact", namespace = "http://ei/core/business_contactx2", propOrder = {
    "typedAddress",
    "phoneInformation",
    "emailInformation",
    "contactName",
    "contactTypeCode",
    "businessName",
    "contactTitleName",
    "contactOrderPreferenceTypeNumber",
    "contactTypeDescription",
    "contactTypeAbbreviation",
    "cpNumber",
    "sourceSystemBusinessContactId"
})
public class BusinessContact {

    @XmlElement(name = "TypedAddress")
    protected List<TypedAddress> typedAddress;
    @XmlElement(name = "PhoneInformation")
    protected List<PhoneInformation> phoneInformation;
    @XmlElement(name = "EmailInformation")
    protected List<EmailInformation> emailInformation;
    @XmlElement(name = "ContactName")
    protected String contactName;
    @XmlElement(name = "ContactTypeCode")
    protected String contactTypeCode;
    @XmlElement(name = "BusinessName")
    protected String businessName;
    @XmlElement(name = "ContactTitleName")
    protected String contactTitleName;
    @XmlElement(name = "ContactOrderPreferenceTypeNumber")
    protected Integer contactOrderPreferenceTypeNumber;
    @XmlElement(name = "ContactTypeDescription")
    protected String contactTypeDescription;
    @XmlElement(name = "ContactTypeAbbreviation")
    protected String contactTypeAbbreviation;
    @XmlElement(name = "CPNumber")
    protected String cpNumber;
    @XmlElement(name = "SourceSystemBusinessContactId")
    protected String sourceSystemBusinessContactId;

    /**
     * Gets the value of the typedAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typedAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypedAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypedAddress }
     * 
     * 
     */
    public List<TypedAddress> getTypedAddress() {
        if (typedAddress == null) {
            typedAddress = new ArrayList<TypedAddress>();
        }
        return this.typedAddress;
    }

    /**
     * Gets the value of the phoneInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phoneInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhoneInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhoneInformation }
     * 
     * 
     */
    public List<PhoneInformation> getPhoneInformation() {
        if (phoneInformation == null) {
            phoneInformation = new ArrayList<PhoneInformation>();
        }
        return this.phoneInformation;
    }

    /**
     * Gets the value of the emailInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the emailInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmailInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmailInformation }
     * 
     * 
     */
    public List<EmailInformation> getEmailInformation() {
        if (emailInformation == null) {
            emailInformation = new ArrayList<EmailInformation>();
        }
        return this.emailInformation;
    }

    /**
     * Gets the value of the contactName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets the value of the contactName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactName(String value) {
        this.contactName = value;
    }

    /**
     * Gets the value of the contactTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactTypeCode() {
        return contactTypeCode;
    }

    /**
     * Sets the value of the contactTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactTypeCode(String value) {
        this.contactTypeCode = value;
    }

    /**
     * Gets the value of the businessName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * Sets the value of the businessName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessName(String value) {
        this.businessName = value;
    }

    /**
     * Gets the value of the contactTitleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactTitleName() {
        return contactTitleName;
    }

    /**
     * Sets the value of the contactTitleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactTitleName(String value) {
        this.contactTitleName = value;
    }

    /**
     * Gets the value of the contactOrderPreferenceTypeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getContactOrderPreferenceTypeNumber() {
        return contactOrderPreferenceTypeNumber;
    }

    /**
     * Sets the value of the contactOrderPreferenceTypeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setContactOrderPreferenceTypeNumber(Integer value) {
        this.contactOrderPreferenceTypeNumber = value;
    }

    /**
     * Gets the value of the contactTypeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactTypeDescription() {
        return contactTypeDescription;
    }

    /**
     * Sets the value of the contactTypeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactTypeDescription(String value) {
        this.contactTypeDescription = value;
    }

    /**
     * Gets the value of the contactTypeAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactTypeAbbreviation() {
        return contactTypeAbbreviation;
    }

    /**
     * Sets the value of the contactTypeAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactTypeAbbreviation(String value) {
        this.contactTypeAbbreviation = value;
    }

    /**
     * Gets the value of the cpNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPNumber() {
        return cpNumber;
    }

    /**
     * Sets the value of the cpNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPNumber(String value) {
        this.cpNumber = value;
    }

    /**
     * Gets the value of the sourceSystemBusinessContactId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceSystemBusinessContactId() {
        return sourceSystemBusinessContactId;
    }

    /**
     * Sets the value of the sourceSystemBusinessContactId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceSystemBusinessContactId(String value) {
        this.sourceSystemBusinessContactId = value;
    }
    

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
			
		sb.append(", Contact Name: " + this.getContactName());
		sb.append(", Contact Type Code: " + this.getContactTypeCode());
		sb.append(", Contact Type Description: "+ this.getContactTypeAbbreviation());
		sb.append(", CP Number: " + this.getCPNumber());
		
	
		

		return sb.toString();
	}


}
