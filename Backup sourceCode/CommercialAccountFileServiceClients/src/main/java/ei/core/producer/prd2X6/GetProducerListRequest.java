
package ei.core.producer.prd2X6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetProducerListRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetProducerListRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetProducerListInputs" type="{http://ei/producer/get_producer_list_inputs_prd2x6}GetProducerListInputs" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AdditionalOptionsText" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ExternalUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExternalVendorUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceConsumerSystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LineOfBusinessTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetProducerListRequest", namespace = "http://ei/producer/get_producer_list_request_prd2x6", propOrder = {
    "getProducerListInputs",
    "additionalOptionsText",
    "externalUserId",
    "externalVendorUserId",
    "userId",
    "systemId",
    "serviceConsumerSystemId",
    "lineOfBusinessTypeCode"
})
public class GetProducerListRequest {

    @XmlElement(name = "GetProducerListInputs")
    protected List<GetProducerListInputs> getProducerListInputs;
    @XmlElement(name = "AdditionalOptionsText")
    protected List<String> additionalOptionsText;
    @XmlElement(name = "ExternalUserId")
    protected String externalUserId;
    @XmlElement(name = "ExternalVendorUserId")
    protected String externalVendorUserId;
    @XmlElement(name = "UserId")
    protected String userId;
    @XmlElement(name = "SystemId")
    protected String systemId;
    @XmlElement(name = "ServiceConsumerSystemId")
    protected String serviceConsumerSystemId;
    @XmlElement(name = "LineOfBusinessTypeCode")
    protected String lineOfBusinessTypeCode;

    /**
     * Gets the value of the getProducerListInputs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getProducerListInputs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetProducerListInputs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetProducerListInputs }
     * 
     * 
     */
    public List<GetProducerListInputs> getGetProducerListInputs() {
        if (getProducerListInputs == null) {
            getProducerListInputs = new ArrayList<GetProducerListInputs>();
        }
        return this.getProducerListInputs;
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

}
