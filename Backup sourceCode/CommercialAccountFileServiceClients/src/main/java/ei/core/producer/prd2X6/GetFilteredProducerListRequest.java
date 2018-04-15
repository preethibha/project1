
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
 * <p>Java class for GetFilteredProducerListRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilteredProducerListRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetFilteredProducerListInputs" type="{http://ei/producer/get_filtered_producer_list_inputs_prd2x6}GetFilteredProducerListInputs" minOccurs="0"/>
 *         &lt;element name="LineOfBusinessName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="WritingCompanyCode" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ProducingBranchNumber" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TransactionEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="LineOfBusinessTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdditionalOptionsText" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ExternalUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExternalVendorUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceConsumerSystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerGroupFilter" type="{http://ei/producer/producer_group_filter}ProducerGroupFilter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFilteredProducerListRequest", namespace = "http://ei/producer/get_filtered_producer_list_request_prd2x6", propOrder = {
    "getFilteredProducerListInputs",
    "lineOfBusinessName",
    "writingCompanyCode",
    "producingBranchNumber",
    "transactionEffectiveDate",
    "lineOfBusinessTypeCode",
    "userId",
    "systemId",
    "additionalOptionsText",
    "externalUserId",
    "externalVendorUserId",
    "serviceConsumerSystemId",
    "producerGroupFilter"
})
public class GetFilteredProducerListRequest {

    @XmlElement(name = "GetFilteredProducerListInputs")
    protected GetFilteredProducerListInputs getFilteredProducerListInputs;
    @XmlElement(name = "LineOfBusinessName")
    protected List<String> lineOfBusinessName;
    @XmlElement(name = "WritingCompanyCode")
    protected List<String> writingCompanyCode;
    @XmlElement(name = "ProducingBranchNumber")
    protected List<String> producingBranchNumber;
    @XmlElement(name = "TransactionEffectiveDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar transactionEffectiveDate;
    @XmlElement(name = "LineOfBusinessTypeCode")
    protected String lineOfBusinessTypeCode;
    @XmlElement(name = "UserId")
    protected String userId;
    @XmlElement(name = "SystemId")
    protected String systemId;
    @XmlElement(name = "AdditionalOptionsText")
    protected List<String> additionalOptionsText;
    @XmlElement(name = "ExternalUserId")
    protected String externalUserId;
    @XmlElement(name = "ExternalVendorUserId")
    protected String externalVendorUserId;
    @XmlElement(name = "ServiceConsumerSystemId")
    protected String serviceConsumerSystemId;
    @XmlElement(name = "ProducerGroupFilter")
    protected List<ProducerGroupFilter> producerGroupFilter;

    /**
     * Gets the value of the getFilteredProducerListInputs property.
     * 
     * @return
     *     possible object is
     *     {@link GetFilteredProducerListInputs }
     *     
     */
    public GetFilteredProducerListInputs getGetFilteredProducerListInputs() {
        return getFilteredProducerListInputs;
    }

    /**
     * Sets the value of the getFilteredProducerListInputs property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFilteredProducerListInputs }
     *     
     */
    public void setGetFilteredProducerListInputs(GetFilteredProducerListInputs value) {
        this.getFilteredProducerListInputs = value;
    }

    /**
     * Gets the value of the lineOfBusinessName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineOfBusinessName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineOfBusinessName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLineOfBusinessName() {
        if (lineOfBusinessName == null) {
            lineOfBusinessName = new ArrayList<String>();
        }
        return this.lineOfBusinessName;
    }

    /**
     * Gets the value of the writingCompanyCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the writingCompanyCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWritingCompanyCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getWritingCompanyCode() {
        if (writingCompanyCode == null) {
            writingCompanyCode = new ArrayList<String>();
        }
        return this.writingCompanyCode;
    }

    /**
     * Gets the value of the producingBranchNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the producingBranchNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducingBranchNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getProducingBranchNumber() {
        if (producingBranchNumber == null) {
            producingBranchNumber = new ArrayList<String>();
        }
        return this.producingBranchNumber;
    }

    /**
     * Gets the value of the transactionEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransactionEffectiveDate() {
        return transactionEffectiveDate;
    }

    /**
     * Sets the value of the transactionEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransactionEffectiveDate(XMLGregorianCalendar value) {
        this.transactionEffectiveDate = value;
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
     * Gets the value of the externalVendorUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalVendorUserId() {
        return externalVendorUserId;
    }

    /**
     * Sets the value of the externalVendorUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalVendorUserId(String value) {
        this.externalVendorUserId = value;
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
     * Gets the value of the producerGroupFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the producerGroupFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducerGroupFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProducerGroupFilter }
     * 
     * 
     */
    public List<ProducerGroupFilter> getProducerGroupFilter() {
        if (producerGroupFilter == null) {
            producerGroupFilter = new ArrayList<ProducerGroupFilter>();
        }
        return this.producerGroupFilter;
    }

}
