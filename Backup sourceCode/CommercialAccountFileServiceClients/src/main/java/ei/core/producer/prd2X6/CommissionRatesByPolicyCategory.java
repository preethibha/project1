
package ei.core.producer.prd2X6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommissionRatesByPolicyCategory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommissionRatesByPolicyCategory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProducerCommissionRate" type="{http://ei/core/producer_commission_rate}ProducerCommissionRate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LineOfBusinessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LineOfBusinessTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EnterpriseOwnershipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PolicyTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PolicyTypeSubCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MarketingProgramCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommissionRatesByPolicyCategory", namespace = "http://ei/core/commission_rates_by_policy_category", propOrder = {
    "producerCommissionRate",
    "lineOfBusinessName",
    "lineOfBusinessTypeCode",
    "enterpriseOwnershipCode",
    "policyTypeCode",
    "policyTypeSubCode",
    "marketingProgramCode"
})
public class CommissionRatesByPolicyCategory {

    @XmlElement(name = "ProducerCommissionRate")
    protected List<ProducerCommissionRate> producerCommissionRate;
    @XmlElement(name = "LineOfBusinessName")
    protected String lineOfBusinessName;
    @XmlElement(name = "LineOfBusinessTypeCode")
    protected String lineOfBusinessTypeCode;
    @XmlElement(name = "EnterpriseOwnershipCode")
    protected String enterpriseOwnershipCode;
    @XmlElement(name = "PolicyTypeCode")
    protected String policyTypeCode;
    @XmlElement(name = "PolicyTypeSubCode")
    protected String policyTypeSubCode;
    @XmlElement(name = "MarketingProgramCode")
    protected String marketingProgramCode;

    /**
     * Gets the value of the producerCommissionRate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the producerCommissionRate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducerCommissionRate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProducerCommissionRate }
     * 
     * 
     */
    public List<ProducerCommissionRate> getProducerCommissionRate() {
        if (producerCommissionRate == null) {
            producerCommissionRate = new ArrayList<ProducerCommissionRate>();
        }
        return this.producerCommissionRate;
    }

    /**
     * Gets the value of the lineOfBusinessName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineOfBusinessName() {
        return lineOfBusinessName;
    }

    /**
     * Sets the value of the lineOfBusinessName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineOfBusinessName(String value) {
        this.lineOfBusinessName = value;
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
     * Gets the value of the enterpriseOwnershipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnterpriseOwnershipCode() {
        return enterpriseOwnershipCode;
    }

    /**
     * Sets the value of the enterpriseOwnershipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnterpriseOwnershipCode(String value) {
        this.enterpriseOwnershipCode = value;
    }

    /**
     * Gets the value of the policyTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyTypeCode() {
        return policyTypeCode;
    }

    /**
     * Sets the value of the policyTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyTypeCode(String value) {
        this.policyTypeCode = value;
    }

    /**
     * Gets the value of the policyTypeSubCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyTypeSubCode() {
        return policyTypeSubCode;
    }

    /**
     * Sets the value of the policyTypeSubCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyTypeSubCode(String value) {
        this.policyTypeSubCode = value;
    }

    /**
     * Gets the value of the marketingProgramCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarketingProgramCode() {
        return marketingProgramCode;
    }

    /**
     * Sets the value of the marketingProgramCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarketingProgramCode(String value) {
        this.marketingProgramCode = value;
    }

}
