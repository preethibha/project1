
package ei.producer.get_filtered_producer_cross_ref_list_request_prd6x1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ei.producer.get_filtered_producer_cross_ref_list_inputs_prd6x1.GetFilteredProducerCrossRefListInputs;


/**
 * <p>Java class for GetFilteredProducerCrossRefListRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilteredProducerCrossRefListRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetFilteredProducerCrossRefListInputs" type="{http://ei/producer/get_filtered_producer_cross_ref_list_inputs_prd6x1}GetFilteredProducerCrossRefListInputs" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceConsumerSystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SyntheticTransactionTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdditionalOptionsText" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFilteredProducerCrossRefListRequest", propOrder = {
    "getFilteredProducerCrossRefListInputs",
    "userId",
    "systemId",
    "serviceConsumerSystemId",
    "syntheticTransactionTypeCode",
    "additionalOptionsText"
})
public class GetFilteredProducerCrossRefListRequest {

    @XmlElement(name = "GetFilteredProducerCrossRefListInputs")
    protected List<GetFilteredProducerCrossRefListInputs> getFilteredProducerCrossRefListInputs;
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

    /**
     * Gets the value of the getFilteredProducerCrossRefListInputs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getFilteredProducerCrossRefListInputs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetFilteredProducerCrossRefListInputs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetFilteredProducerCrossRefListInputs }
     * 
     * 
     */
    public List<GetFilteredProducerCrossRefListInputs> getGetFilteredProducerCrossRefListInputs() {
        if (getFilteredProducerCrossRefListInputs == null) {
            getFilteredProducerCrossRefListInputs = new ArrayList<GetFilteredProducerCrossRefListInputs>();
        }
        return this.getFilteredProducerCrossRefListInputs;
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

}
