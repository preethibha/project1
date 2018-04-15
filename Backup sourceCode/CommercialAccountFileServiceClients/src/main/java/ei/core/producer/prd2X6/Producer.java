
package ei.core.producer.prd2X6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Producer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Producer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MailingAddress" type="{http://ei/core/addressx5}Address" minOccurs="0"/>
 *         &lt;element name="ProducerRoleCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerRoleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerRoleAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcessingOfficeNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducingBranchNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducingBranchCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducingBranchAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FaxNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerEnrollmentOptions" type="{http://ei/producer/producer_enrollment_options}ProducerEnrollmentOptions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NonAppointedProducerIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ProducerClassificationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerClassificationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerAppointmentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ProducerSpecialIdentificationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerOrganizationTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommercialDirectBillIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PersonalDirectBillIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PersonalProcessingOfficeNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommercialProcessingOfficeNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BusinessAddress" type="{http://ei/core/addressx5}Address" minOccurs="0"/>
 *         &lt;element name="ProducerContact" type="{http://ei/producer/producer_contact}ProducerContact" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CommissionRatesByPolicyCategory" type="{http://ei/core/commission_rates_by_policy_category}CommissionRatesByPolicyCategory" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ProducerGroup" type="{http://ei/producer/producer_group}ProducerGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CombineProducerGroupCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommercialStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PersonalStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountersigningStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommercialCancellationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="PersonalCancellationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="CountersigningCancellationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="MainProducerIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MasterProducerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubMasterProducerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerIdentifier" type="{http://ei/core/producer_identifierx4}ProducerIdentifier" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NonResidentProducerLicenseInformation" type="{http://ei/producer/non_resident_producer_license_information}NonResidentProducerLicenseInformation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BusinessPartyCharacteristic" type="{http://ei/core/business_party_characteristic}BusinessPartyCharacteristic" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PersonalProcessingOfficeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerUnderwriterBranchCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageProducerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Producer", namespace = "http://ei/producer/producerx7", propOrder = {
    "mailingAddress",
    "producerRoleCode",
    "producerRoleName",
    "producerRoleAbbreviation",
    "processingOfficeNumber",
    "producingBranchNumber",
    "producingBranchCode",
    "producingBranchAbbreviation",
    "phoneNumber",
    "faxNumber",
    "producerEnrollmentOptions",
    "nonAppointedProducerIndicator",
    "producerClassificationCode",
    "producerClassificationName",
    "producerAppointmentDate",
    "producerSpecialIdentificationCode",
    "producerOrganizationTypeCode",
    "producerTypeCode",
    "zoneNumber",
    "commercialDirectBillIndicator",
    "personalDirectBillIndicator",
    "personalProcessingOfficeNumber",
    "commercialProcessingOfficeNumber",
    "businessAddress",
    "producerContact",
    "commissionRatesByPolicyCategory",
    "producerGroup",
    "combineProducerGroupCode",
    "commercialStatusCode",
    "personalStatusCode",
    "countersigningStatusCode",
    "commercialCancellationDate",
    "personalCancellationDate",
    "countersigningCancellationDate",
    "mainProducerIndicator",
    "masterProducerNumber",
    "subMasterProducerNumber",
    "producerIdentifier",
    "nonResidentProducerLicenseInformation",
    "businessPartyCharacteristic",
    "personalProcessingOfficeCode",
    "producerUnderwriterBranchCode",
    "messageProducerId"
})
@XmlSeeAlso({
    ExtendedProducer.class
})
public class Producer {

    @XmlElement(name = "MailingAddress")
    protected Address mailingAddress;
    @XmlElement(name = "ProducerRoleCode")
    protected String producerRoleCode;
    @XmlElement(name = "ProducerRoleName")
    protected String producerRoleName;
    @XmlElement(name = "ProducerRoleAbbreviation")
    protected String producerRoleAbbreviation;
    @XmlElement(name = "ProcessingOfficeNumber")
    protected String processingOfficeNumber;
    @XmlElement(name = "ProducingBranchNumber")
    protected String producingBranchNumber;
    @XmlElement(name = "ProducingBranchCode")
    protected String producingBranchCode;
    @XmlElement(name = "ProducingBranchAbbreviation")
    protected String producingBranchAbbreviation;
    @XmlElement(name = "PhoneNumber")
    protected String phoneNumber;
    @XmlElement(name = "FaxNumber")
    protected String faxNumber;
    @XmlElement(name = "ProducerEnrollmentOptions")
    protected List<ProducerEnrollmentOptions> producerEnrollmentOptions;
    @XmlElement(name = "NonAppointedProducerIndicator")
    protected Boolean nonAppointedProducerIndicator;
    @XmlElement(name = "ProducerClassificationCode")
    protected String producerClassificationCode;
    @XmlElement(name = "ProducerClassificationName")
    protected String producerClassificationName;
    @XmlElement(name = "ProducerAppointmentDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar producerAppointmentDate;
    @XmlElement(name = "ProducerSpecialIdentificationCode")
    protected String producerSpecialIdentificationCode;
    @XmlElement(name = "ProducerOrganizationTypeCode")
    protected String producerOrganizationTypeCode;
    @XmlElement(name = "ProducerTypeCode")
    protected String producerTypeCode;
    @XmlElement(name = "ZoneNumber")
    protected String zoneNumber;
    @XmlElement(name = "CommercialDirectBillIndicator")
    protected String commercialDirectBillIndicator;
    @XmlElement(name = "PersonalDirectBillIndicator")
    protected String personalDirectBillIndicator;
    @XmlElement(name = "PersonalProcessingOfficeNumber")
    protected String personalProcessingOfficeNumber;
    @XmlElement(name = "CommercialProcessingOfficeNumber")
    protected String commercialProcessingOfficeNumber;
    @XmlElement(name = "BusinessAddress")
    protected Address businessAddress;
    @XmlElement(name = "ProducerContact")
    protected List<ProducerContact> producerContact;
    @XmlElement(name = "CommissionRatesByPolicyCategory")
    protected List<CommissionRatesByPolicyCategory> commissionRatesByPolicyCategory;
    @XmlElement(name = "ProducerGroup")
    protected List<ProducerGroup> producerGroup;
    @XmlElement(name = "CombineProducerGroupCode")
    protected String combineProducerGroupCode;
    @XmlElement(name = "CommercialStatusCode")
    protected String commercialStatusCode;
    @XmlElement(name = "PersonalStatusCode")
    protected String personalStatusCode;
    @XmlElement(name = "CountersigningStatusCode")
    protected String countersigningStatusCode;
    @XmlElement(name = "CommercialCancellationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar commercialCancellationDate;
    @XmlElement(name = "PersonalCancellationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar personalCancellationDate;
    @XmlElement(name = "CountersigningCancellationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar countersigningCancellationDate;
    @XmlElement(name = "MainProducerIndicator")
    protected String mainProducerIndicator;
    @XmlElement(name = "MasterProducerNumber")
    protected String masterProducerNumber;
    @XmlElement(name = "SubMasterProducerNumber")
    protected String subMasterProducerNumber;
    @XmlElement(name = "ProducerIdentifier")
    protected List<ProducerIdentifier> producerIdentifier;
    @XmlElement(name = "NonResidentProducerLicenseInformation")
    protected List<NonResidentProducerLicenseInformation> nonResidentProducerLicenseInformation;
    @XmlElement(name = "BusinessPartyCharacteristic")
    protected List<BusinessPartyCharacteristic> businessPartyCharacteristic;
    @XmlElement(name = "PersonalProcessingOfficeCode")
    protected String personalProcessingOfficeCode;
    @XmlElement(name = "ProducerUnderwriterBranchCode")
    protected String producerUnderwriterBranchCode;
    @XmlElement(name = "MessageProducerId")
    protected String messageProducerId;

    /**
     * Gets the value of the mailingAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getMailingAddress() {
        return mailingAddress;
    }

    /**
     * Sets the value of the mailingAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setMailingAddress(Address value) {
        this.mailingAddress = value;
    }

    /**
     * Gets the value of the producerRoleCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerRoleCode() {
        return producerRoleCode;
    }

    /**
     * Sets the value of the producerRoleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerRoleCode(String value) {
        this.producerRoleCode = value;
    }

    /**
     * Gets the value of the producerRoleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerRoleName() {
        return producerRoleName;
    }

    /**
     * Sets the value of the producerRoleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerRoleName(String value) {
        this.producerRoleName = value;
    }

    /**
     * Gets the value of the producerRoleAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerRoleAbbreviation() {
        return producerRoleAbbreviation;
    }

    /**
     * Sets the value of the producerRoleAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerRoleAbbreviation(String value) {
        this.producerRoleAbbreviation = value;
    }

    /**
     * Gets the value of the processingOfficeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessingOfficeNumber() {
        return processingOfficeNumber;
    }

    /**
     * Sets the value of the processingOfficeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessingOfficeNumber(String value) {
        this.processingOfficeNumber = value;
    }

    /**
     * Gets the value of the producingBranchNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducingBranchNumber() {
        return producingBranchNumber;
    }

    /**
     * Sets the value of the producingBranchNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducingBranchNumber(String value) {
        this.producingBranchNumber = value;
    }

    /**
     * Gets the value of the producingBranchCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducingBranchCode() {
        return producingBranchCode;
    }

    /**
     * Sets the value of the producingBranchCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducingBranchCode(String value) {
        this.producingBranchCode = value;
    }

    /**
     * Gets the value of the producingBranchAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducingBranchAbbreviation() {
        return producingBranchAbbreviation;
    }

    /**
     * Sets the value of the producingBranchAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducingBranchAbbreviation(String value) {
        this.producingBranchAbbreviation = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the faxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Sets the value of the faxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxNumber(String value) {
        this.faxNumber = value;
    }

    /**
     * Gets the value of the producerEnrollmentOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the producerEnrollmentOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducerEnrollmentOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProducerEnrollmentOptions }
     * 
     * 
     */
    public List<ProducerEnrollmentOptions> getProducerEnrollmentOptions() {
        if (producerEnrollmentOptions == null) {
            producerEnrollmentOptions = new ArrayList<ProducerEnrollmentOptions>();
        }
        return this.producerEnrollmentOptions;
    }

    /**
     * Gets the value of the nonAppointedProducerIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNonAppointedProducerIndicator() {
        return nonAppointedProducerIndicator;
    }

    /**
     * Sets the value of the nonAppointedProducerIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNonAppointedProducerIndicator(Boolean value) {
        this.nonAppointedProducerIndicator = value;
    }

    /**
     * Gets the value of the producerClassificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerClassificationCode() {
        return producerClassificationCode;
    }

    /**
     * Sets the value of the producerClassificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerClassificationCode(String value) {
        this.producerClassificationCode = value;
    }

    /**
     * Gets the value of the producerClassificationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerClassificationName() {
        return producerClassificationName;
    }

    /**
     * Sets the value of the producerClassificationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerClassificationName(String value) {
        this.producerClassificationName = value;
    }

    /**
     * Gets the value of the producerAppointmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProducerAppointmentDate() {
        return producerAppointmentDate;
    }

    /**
     * Sets the value of the producerAppointmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProducerAppointmentDate(XMLGregorianCalendar value) {
        this.producerAppointmentDate = value;
    }

    /**
     * Gets the value of the producerSpecialIdentificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerSpecialIdentificationCode() {
        return producerSpecialIdentificationCode;
    }

    /**
     * Sets the value of the producerSpecialIdentificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerSpecialIdentificationCode(String value) {
        this.producerSpecialIdentificationCode = value;
    }

    /**
     * Gets the value of the producerOrganizationTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerOrganizationTypeCode() {
        return producerOrganizationTypeCode;
    }

    /**
     * Sets the value of the producerOrganizationTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerOrganizationTypeCode(String value) {
        this.producerOrganizationTypeCode = value;
    }

    /**
     * Gets the value of the producerTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerTypeCode() {
        return producerTypeCode;
    }

    /**
     * Sets the value of the producerTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerTypeCode(String value) {
        this.producerTypeCode = value;
    }

    /**
     * Gets the value of the zoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoneNumber() {
        return zoneNumber;
    }

    /**
     * Sets the value of the zoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoneNumber(String value) {
        this.zoneNumber = value;
    }

    /**
     * Gets the value of the commercialDirectBillIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommercialDirectBillIndicator() {
        return commercialDirectBillIndicator;
    }

    /**
     * Sets the value of the commercialDirectBillIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommercialDirectBillIndicator(String value) {
        this.commercialDirectBillIndicator = value;
    }

    /**
     * Gets the value of the personalDirectBillIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalDirectBillIndicator() {
        return personalDirectBillIndicator;
    }

    /**
     * Sets the value of the personalDirectBillIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalDirectBillIndicator(String value) {
        this.personalDirectBillIndicator = value;
    }

    /**
     * Gets the value of the personalProcessingOfficeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalProcessingOfficeNumber() {
        return personalProcessingOfficeNumber;
    }

    /**
     * Sets the value of the personalProcessingOfficeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalProcessingOfficeNumber(String value) {
        this.personalProcessingOfficeNumber = value;
    }

    /**
     * Gets the value of the commercialProcessingOfficeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommercialProcessingOfficeNumber() {
        return commercialProcessingOfficeNumber;
    }

    /**
     * Sets the value of the commercialProcessingOfficeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommercialProcessingOfficeNumber(String value) {
        this.commercialProcessingOfficeNumber = value;
    }

    /**
     * Gets the value of the businessAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getBusinessAddress() {
        return businessAddress;
    }

    /**
     * Sets the value of the businessAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setBusinessAddress(Address value) {
        this.businessAddress = value;
    }

    /**
     * Gets the value of the producerContact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the producerContact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducerContact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProducerContact }
     * 
     * 
     */
    public List<ProducerContact> getProducerContact() {
        if (producerContact == null) {
            producerContact = new ArrayList<ProducerContact>();
        }
        return this.producerContact;
    }

    /**
     * Gets the value of the commissionRatesByPolicyCategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commissionRatesByPolicyCategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommissionRatesByPolicyCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommissionRatesByPolicyCategory }
     * 
     * 
     */
    public List<CommissionRatesByPolicyCategory> getCommissionRatesByPolicyCategory() {
        if (commissionRatesByPolicyCategory == null) {
            commissionRatesByPolicyCategory = new ArrayList<CommissionRatesByPolicyCategory>();
        }
        return this.commissionRatesByPolicyCategory;
    }

    /**
     * Gets the value of the producerGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the producerGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducerGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProducerGroup }
     * 
     * 
     */
    public List<ProducerGroup> getProducerGroup() {
        if (producerGroup == null) {
            producerGroup = new ArrayList<ProducerGroup>();
        }
        return this.producerGroup;
    }

    /**
     * Gets the value of the combineProducerGroupCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCombineProducerGroupCode() {
        return combineProducerGroupCode;
    }

    /**
     * Sets the value of the combineProducerGroupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCombineProducerGroupCode(String value) {
        this.combineProducerGroupCode = value;
    }

    /**
     * Gets the value of the commercialStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommercialStatusCode() {
        return commercialStatusCode;
    }

    /**
     * Sets the value of the commercialStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommercialStatusCode(String value) {
        this.commercialStatusCode = value;
    }

    /**
     * Gets the value of the personalStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalStatusCode() {
        return personalStatusCode;
    }

    /**
     * Sets the value of the personalStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalStatusCode(String value) {
        this.personalStatusCode = value;
    }

    /**
     * Gets the value of the countersigningStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountersigningStatusCode() {
        return countersigningStatusCode;
    }

    /**
     * Sets the value of the countersigningStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountersigningStatusCode(String value) {
        this.countersigningStatusCode = value;
    }

    /**
     * Gets the value of the commercialCancellationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCommercialCancellationDate() {
        return commercialCancellationDate;
    }

    /**
     * Sets the value of the commercialCancellationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCommercialCancellationDate(XMLGregorianCalendar value) {
        this.commercialCancellationDate = value;
    }

    /**
     * Gets the value of the personalCancellationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPersonalCancellationDate() {
        return personalCancellationDate;
    }

    /**
     * Sets the value of the personalCancellationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPersonalCancellationDate(XMLGregorianCalendar value) {
        this.personalCancellationDate = value;
    }

    /**
     * Gets the value of the countersigningCancellationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCountersigningCancellationDate() {
        return countersigningCancellationDate;
    }

    /**
     * Sets the value of the countersigningCancellationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCountersigningCancellationDate(XMLGregorianCalendar value) {
        this.countersigningCancellationDate = value;
    }

    /**
     * Gets the value of the mainProducerIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainProducerIndicator() {
        return mainProducerIndicator;
    }

    /**
     * Sets the value of the mainProducerIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainProducerIndicator(String value) {
        this.mainProducerIndicator = value;
    }

    /**
     * Gets the value of the masterProducerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterProducerNumber() {
        return masterProducerNumber;
    }

    /**
     * Sets the value of the masterProducerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterProducerNumber(String value) {
        this.masterProducerNumber = value;
    }

    /**
     * Gets the value of the subMasterProducerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubMasterProducerNumber() {
        return subMasterProducerNumber;
    }

    /**
     * Sets the value of the subMasterProducerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubMasterProducerNumber(String value) {
        this.subMasterProducerNumber = value;
    }

    /**
     * Gets the value of the producerIdentifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the producerIdentifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducerIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProducerIdentifier }
     * 
     * 
     */
    public List<ProducerIdentifier> getProducerIdentifier() {
        if (producerIdentifier == null) {
            producerIdentifier = new ArrayList<ProducerIdentifier>();
        }
        return this.producerIdentifier;
    }

    /**
     * Gets the value of the nonResidentProducerLicenseInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nonResidentProducerLicenseInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNonResidentProducerLicenseInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NonResidentProducerLicenseInformation }
     * 
     * 
     */
    public List<NonResidentProducerLicenseInformation> getNonResidentProducerLicenseInformation() {
        if (nonResidentProducerLicenseInformation == null) {
            nonResidentProducerLicenseInformation = new ArrayList<NonResidentProducerLicenseInformation>();
        }
        return this.nonResidentProducerLicenseInformation;
    }

    /**
     * Gets the value of the businessPartyCharacteristic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the businessPartyCharacteristic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusinessPartyCharacteristic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BusinessPartyCharacteristic }
     * 
     * 
     */
    public List<BusinessPartyCharacteristic> getBusinessPartyCharacteristic() {
        if (businessPartyCharacteristic == null) {
            businessPartyCharacteristic = new ArrayList<BusinessPartyCharacteristic>();
        }
        return this.businessPartyCharacteristic;
    }

    /**
     * Gets the value of the personalProcessingOfficeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalProcessingOfficeCode() {
        return personalProcessingOfficeCode;
    }

    /**
     * Sets the value of the personalProcessingOfficeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalProcessingOfficeCode(String value) {
        this.personalProcessingOfficeCode = value;
    }

    /**
     * Gets the value of the producerUnderwriterBranchCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerUnderwriterBranchCode() {
        return producerUnderwriterBranchCode;
    }

    /**
     * Sets the value of the producerUnderwriterBranchCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerUnderwriterBranchCode(String value) {
        this.producerUnderwriterBranchCode = value;
    }

    /**
     * Gets the value of the messageProducerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageProducerId() {
        return messageProducerId;
    }

    /**
     * Sets the value of the messageProducerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageProducerId(String value) {
        this.messageProducerId = value;
    }

}
