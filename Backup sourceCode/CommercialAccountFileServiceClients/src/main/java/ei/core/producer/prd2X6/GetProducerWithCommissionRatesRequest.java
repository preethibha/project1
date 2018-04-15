
package ei.core.producer.prd2X6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GetProducerWithCommissionRatesRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetProducerWithCommissionRatesRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetProducerWithCommissionRatesInputs" type="{http://ei/producer/get_producer_with_commission_rates_inputs_prd2x6}GetProducerWithCommissionRatesInputs" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ProducerNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProducerSubNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdditionalOptionsText" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AsOfDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="SourceSystemTransactionTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BookingEntryTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WritingCompanyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceConsumerSystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PASSourceProducerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommissionInputParameter" type="{http://ei/producer/commission_input_parameter}CommissionInputParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ProducerClassificationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetProducerWithCommissionRatesRequest", namespace = "http://ei/producer/get_producer_with_commission_rates_request_prd2x6", propOrder = {
    "getProducerWithCommissionRatesInputs",
    "producerNumber",
    "producerSubNumber",
    "additionalOptionsText",
    "asOfDate",
    "sourceSystemTransactionTypeName",
    "bookingEntryTypeCode",
    "writingCompanyCode",
    "userId",
    "systemId",
    "serviceConsumerSystemId",
    "pasSourceProducerCode",
    "userTypeDescription",
    "commissionInputParameter",
    "producerClassificationName"
})
public class GetProducerWithCommissionRatesRequest {

    @XmlElement(name = "GetProducerWithCommissionRatesInputs")
    protected List<GetProducerWithCommissionRatesInputs> getProducerWithCommissionRatesInputs;
    @XmlElement(name = "ProducerNumber", required = true)
    protected String producerNumber;
    @XmlElement(name = "ProducerSubNumber")
    protected String producerSubNumber;
    @XmlElement(name = "AdditionalOptionsText")
    protected List<String> additionalOptionsText;
    @XmlElement(name = "AsOfDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar asOfDate;
    @XmlElement(name = "SourceSystemTransactionTypeName")
    protected String sourceSystemTransactionTypeName;
    @XmlElement(name = "BookingEntryTypeCode")
    protected String bookingEntryTypeCode;
    @XmlElement(name = "WritingCompanyCode")
    protected String writingCompanyCode;
    @XmlElement(name = "UserId")
    protected String userId;
    @XmlElement(name = "SystemId")
    protected String systemId;
    @XmlElement(name = "ServiceConsumerSystemId")
    protected String serviceConsumerSystemId;
    @XmlElement(name = "PASSourceProducerCode")
    protected String pasSourceProducerCode;
    @XmlElement(name = "UserTypeDescription")
    protected String userTypeDescription;
    @XmlElement(name = "CommissionInputParameter")
    protected List<CommissionInputParameter> commissionInputParameter;
    @XmlElement(name = "ProducerClassificationName")
    protected String producerClassificationName;

    /**
     * Gets the value of the getProducerWithCommissionRatesInputs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getProducerWithCommissionRatesInputs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetProducerWithCommissionRatesInputs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetProducerWithCommissionRatesInputs }
     * 
     * 
     */
    public List<GetProducerWithCommissionRatesInputs> getGetProducerWithCommissionRatesInputs() {
        if (getProducerWithCommissionRatesInputs == null) {
            getProducerWithCommissionRatesInputs = new ArrayList<GetProducerWithCommissionRatesInputs>();
        }
        return this.getProducerWithCommissionRatesInputs;
    }

    /**
     * Gets the value of the producerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerNumber() {
        return producerNumber;
    }

    /**
     * Sets the value of the producerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerNumber(String value) {
        this.producerNumber = value;
    }

    /**
     * Gets the value of the producerSubNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerSubNumber() {
        return producerSubNumber;
    }

    /**
     * Sets the value of the producerSubNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerSubNumber(String value) {
        this.producerSubNumber = value;
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
     * Gets the value of the asOfDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAsOfDate() {
        return asOfDate;
    }

    /**
     * Sets the value of the asOfDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAsOfDate(XMLGregorianCalendar value) {
        this.asOfDate = value;
    }

    /**
     * Gets the value of the sourceSystemTransactionTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceSystemTransactionTypeName() {
        return sourceSystemTransactionTypeName;
    }

    /**
     * Sets the value of the sourceSystemTransactionTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceSystemTransactionTypeName(String value) {
        this.sourceSystemTransactionTypeName = value;
    }

    /**
     * Gets the value of the bookingEntryTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingEntryTypeCode() {
        return bookingEntryTypeCode;
    }

    /**
     * Sets the value of the bookingEntryTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingEntryTypeCode(String value) {
        this.bookingEntryTypeCode = value;
    }

    /**
     * Gets the value of the writingCompanyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWritingCompanyCode() {
        return writingCompanyCode;
    }

    /**
     * Sets the value of the writingCompanyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWritingCompanyCode(String value) {
        this.writingCompanyCode = value;
    }

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
     * Gets the value of the commissionInputParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commissionInputParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommissionInputParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommissionInputParameter }
     * 
     * 
     */
    public List<CommissionInputParameter> getCommissionInputParameter() {
        if (commissionInputParameter == null) {
            commissionInputParameter = new ArrayList<CommissionInputParameter>();
        }
        return this.commissionInputParameter;
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

}
