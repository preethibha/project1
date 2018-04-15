
package ei.producer.producer_cross_reference;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ei.core.addressx5.Address;
import ei.core.branchx1.Branch;


/**
 * <p>Java class for ProducerCrossReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProducerCrossReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProducingBranch" type="{http://ei/core/branchx1}Branch" minOccurs="0"/>
 *         &lt;element name="PhysicalLocationAddress" type="{http://ei/core/addressx5}Address" minOccurs="0"/>
 *         &lt;element name="TaxPayerIdNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChubbProducerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChubbProducerSubNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChubbProducerAppointmentStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChubbCombineProducerGroupCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChubbProducerSpecialIdentificationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PASSourceProducerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PASMasterProducerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PASNationalProducerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PASProducerStatusDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PASNormalMarketingAdminCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PASProducerCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FormerProducerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerPrimaryContractName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerContractedName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PASCategoryGroupCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PMSSourceProducerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProducerCrossReference", propOrder = {
    "producingBranch",
    "physicalLocationAddress",
    "taxPayerIdNumber",
    "chubbProducerNumber",
    "chubbProducerSubNumber",
    "chubbProducerAppointmentStatusCode",
    "chubbCombineProducerGroupCode",
    "chubbProducerSpecialIdentificationCode",
    "pasSourceProducerCode",
    "pasMasterProducerCode",
    "pasNationalProducerCode",
    "pasProducerStatusDescription",
    "pasNormalMarketingAdminCode",
    "pasProducerCategoryCode",
    "formerProducerName",
    "producerPrimaryContractName",
    "producerContractedName",
    "pasCategoryGroupCode",
    "pmsSourceProducerCode"
})
public class ProducerCrossReference {

    @XmlElement(name = "ProducingBranch")
    protected Branch producingBranch;
    @XmlElement(name = "PhysicalLocationAddress")
    protected Address physicalLocationAddress;
    @XmlElement(name = "TaxPayerIdNumber")
    protected String taxPayerIdNumber;
    @XmlElement(name = "ChubbProducerNumber")
    protected String chubbProducerNumber;
    @XmlElement(name = "ChubbProducerSubNumber")
    protected String chubbProducerSubNumber;
    @XmlElement(name = "ChubbProducerAppointmentStatusCode")
    protected String chubbProducerAppointmentStatusCode;
    @XmlElement(name = "ChubbCombineProducerGroupCode")
    protected String chubbCombineProducerGroupCode;
    @XmlElement(name = "ChubbProducerSpecialIdentificationCode")
    protected String chubbProducerSpecialIdentificationCode;
    @XmlElement(name = "PASSourceProducerCode")
    protected String pasSourceProducerCode;
    @XmlElement(name = "PASMasterProducerCode")
    protected String pasMasterProducerCode;
    @XmlElement(name = "PASNationalProducerCode")
    protected String pasNationalProducerCode;
    @XmlElement(name = "PASProducerStatusDescription")
    protected String pasProducerStatusDescription;
    @XmlElement(name = "PASNormalMarketingAdminCode")
    protected String pasNormalMarketingAdminCode;
    @XmlElement(name = "PASProducerCategoryCode")
    protected String pasProducerCategoryCode;
    @XmlElement(name = "FormerProducerName")
    protected String formerProducerName;
    @XmlElement(name = "ProducerPrimaryContractName")
    protected String producerPrimaryContractName;
    @XmlElement(name = "ProducerContractedName")
    protected String producerContractedName;
    @XmlElement(name = "PASCategoryGroupCode")
    protected String pasCategoryGroupCode;
    @XmlElement(name = "PMSSourceProducerCode")
    protected String pmsSourceProducerCode;

    /**
     * Gets the value of the producingBranch property.
     * 
     * @return
     *     possible object is
     *     {@link Branch }
     *     
     */
    public Branch getProducingBranch() {
        return producingBranch;
    }

    /**
     * Sets the value of the producingBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Branch }
     *     
     */
    public void setProducingBranch(Branch value) {
        this.producingBranch = value;
    }

    /**
     * Gets the value of the physicalLocationAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getPhysicalLocationAddress() {
        return physicalLocationAddress;
    }

    /**
     * Sets the value of the physicalLocationAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setPhysicalLocationAddress(Address value) {
        this.physicalLocationAddress = value;
    }

    /**
     * Gets the value of the taxPayerIdNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxPayerIdNumber() {
        return taxPayerIdNumber;
    }

    /**
     * Sets the value of the taxPayerIdNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxPayerIdNumber(String value) {
        this.taxPayerIdNumber = value;
    }

    /**
     * Gets the value of the chubbProducerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChubbProducerNumber() {
        return chubbProducerNumber;
    }

    /**
     * Sets the value of the chubbProducerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChubbProducerNumber(String value) {
        this.chubbProducerNumber = value;
    }

    /**
     * Gets the value of the chubbProducerSubNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChubbProducerSubNumber() {
        return chubbProducerSubNumber;
    }

    /**
     * Sets the value of the chubbProducerSubNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChubbProducerSubNumber(String value) {
        this.chubbProducerSubNumber = value;
    }

    /**
     * Gets the value of the chubbProducerAppointmentStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChubbProducerAppointmentStatusCode() {
        return chubbProducerAppointmentStatusCode;
    }

    /**
     * Sets the value of the chubbProducerAppointmentStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChubbProducerAppointmentStatusCode(String value) {
        this.chubbProducerAppointmentStatusCode = value;
    }

    /**
     * Gets the value of the chubbCombineProducerGroupCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChubbCombineProducerGroupCode() {
        return chubbCombineProducerGroupCode;
    }

    /**
     * Sets the value of the chubbCombineProducerGroupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChubbCombineProducerGroupCode(String value) {
        this.chubbCombineProducerGroupCode = value;
    }

    /**
     * Gets the value of the chubbProducerSpecialIdentificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChubbProducerSpecialIdentificationCode() {
        return chubbProducerSpecialIdentificationCode;
    }

    /**
     * Sets the value of the chubbProducerSpecialIdentificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChubbProducerSpecialIdentificationCode(String value) {
        this.chubbProducerSpecialIdentificationCode = value;
    }

    /**
     * Gets the value of the pasSourceProducerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPASSourceProducerCode() {
        return pasSourceProducerCode;
    }

    /**
     * Sets the value of the pasSourceProducerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPASSourceProducerCode(String value) {
        this.pasSourceProducerCode = value;
    }

    /**
     * Gets the value of the pasMasterProducerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPASMasterProducerCode() {
        return pasMasterProducerCode;
    }

    /**
     * Sets the value of the pasMasterProducerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPASMasterProducerCode(String value) {
        this.pasMasterProducerCode = value;
    }

    /**
     * Gets the value of the pasNationalProducerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPASNationalProducerCode() {
        return pasNationalProducerCode;
    }

    /**
     * Sets the value of the pasNationalProducerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPASNationalProducerCode(String value) {
        this.pasNationalProducerCode = value;
    }

    /**
     * Gets the value of the pasProducerStatusDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPASProducerStatusDescription() {
        return pasProducerStatusDescription;
    }

    /**
     * Sets the value of the pasProducerStatusDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPASProducerStatusDescription(String value) {
        this.pasProducerStatusDescription = value;
    }

    /**
     * Gets the value of the pasNormalMarketingAdminCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPASNormalMarketingAdminCode() {
        return pasNormalMarketingAdminCode;
    }

    /**
     * Sets the value of the pasNormalMarketingAdminCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPASNormalMarketingAdminCode(String value) {
        this.pasNormalMarketingAdminCode = value;
    }

    /**
     * Gets the value of the pasProducerCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPASProducerCategoryCode() {
        return pasProducerCategoryCode;
    }

    /**
     * Sets the value of the pasProducerCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPASProducerCategoryCode(String value) {
        this.pasProducerCategoryCode = value;
    }

    /**
     * Gets the value of the formerProducerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormerProducerName() {
        return formerProducerName;
    }

    /**
     * Sets the value of the formerProducerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormerProducerName(String value) {
        this.formerProducerName = value;
    }

    /**
     * Gets the value of the producerPrimaryContractName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerPrimaryContractName() {
        return producerPrimaryContractName;
    }

    /**
     * Sets the value of the producerPrimaryContractName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerPrimaryContractName(String value) {
        this.producerPrimaryContractName = value;
    }

    /**
     * Gets the value of the producerContractedName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerContractedName() {
        return producerContractedName;
    }

    /**
     * Sets the value of the producerContractedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerContractedName(String value) {
        this.producerContractedName = value;
    }

    /**
     * Gets the value of the pasCategoryGroupCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPASCategoryGroupCode() {
        return pasCategoryGroupCode;
    }

    /**
     * Sets the value of the pasCategoryGroupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPASCategoryGroupCode(String value) {
        this.pasCategoryGroupCode = value;
    }

    /**
     * Gets the value of the pmsSourceProducerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPMSSourceProducerCode() {
        return pmsSourceProducerCode;
    }

    /**
     * Sets the value of the pmsSourceProducerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPMSSourceProducerCode(String value) {
        this.pmsSourceProducerCode = value;
    }

}
