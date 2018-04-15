
package ei.producer.get_producer_cross_reference_request_prd6x1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetProducerCrossReferenceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetProducerCrossReferenceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceConsumerSystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SyntheticTransactionTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdditionalOptionsText" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ChubbProducerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChubbProducerSubNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PASSourceProducerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PASProducerCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxPayerIdNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StateOrProvinceAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducingBranchAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LineOfBusinessTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "GetProducerCrossReferenceRequest", propOrder = {
    "userId",
    "systemId",
    "serviceConsumerSystemId",
    "syntheticTransactionTypeCode",
    "additionalOptionsText",
    "chubbProducerNumber",
    "chubbProducerSubNumber",
    "pasSourceProducerCode",
    "pasProducerCategoryCode",
    "taxPayerIdNumber",
    "cityName",
    "stateOrProvinceAbbreviation",
    "producingBranchAbbreviation",
    "lineOfBusinessTypeCode",
    "pasCategoryGroupCode",
    "pmsSourceProducerCode"
})
public class GetProducerCrossReferenceRequest {

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
    @XmlElement(name = "ChubbProducerNumber")
    protected String chubbProducerNumber;
    @XmlElement(name = "ChubbProducerSubNumber")
    protected String chubbProducerSubNumber;
    @XmlElement(name = "PASSourceProducerCode")
    protected String pasSourceProducerCode;
    @XmlElement(name = "PASProducerCategoryCode")
    protected String pasProducerCategoryCode;
    @XmlElement(name = "TaxPayerIdNumber")
    protected String taxPayerIdNumber;
    @XmlElement(name = "CityName")
    protected String cityName;
    @XmlElement(name = "StateOrProvinceAbbreviation")
    protected String stateOrProvinceAbbreviation;
    @XmlElement(name = "ProducingBranchAbbreviation")
    protected String producingBranchAbbreviation;
    @XmlElement(name = "LineOfBusinessTypeCode")
    protected String lineOfBusinessTypeCode;
    @XmlElement(name = "PASCategoryGroupCode")
    protected String pasCategoryGroupCode;
    @XmlElement(name = "PMSSourceProducerCode")
    protected String pmsSourceProducerCode;

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
     * Gets the value of the cityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the value of the cityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityName(String value) {
        this.cityName = value;
    }

    /**
     * Gets the value of the stateOrProvinceAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateOrProvinceAbbreviation() {
        return stateOrProvinceAbbreviation;
    }

    /**
     * Sets the value of the stateOrProvinceAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateOrProvinceAbbreviation(String value) {
        this.stateOrProvinceAbbreviation = value;
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
     * Gets the value of the lineOfBusinessTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineOfBusinessTypeCode() {
        return lineOfBusinessTypeCode;
    }

    /**
     * Sets the value of the lineOfBusinessTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineOfBusinessTypeCode(String value) {
        this.lineOfBusinessTypeCode = value;
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
