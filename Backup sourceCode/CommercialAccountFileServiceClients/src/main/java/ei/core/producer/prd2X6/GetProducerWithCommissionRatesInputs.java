
package ei.core.producer.prd2X6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetProducerWithCommissionRatesInputs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetProducerWithCommissionRatesInputs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LineOfBusinessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LineOfBusinessTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "GetProducerWithCommissionRatesInputs", namespace = "http://ei/producer/get_producer_with_commission_rates_inputs_prd2x6", propOrder = {
    "lineOfBusinessName",
    "lineOfBusinessTypeCode",
    "enterpriseOwnershipCode",
    "policyTypeCode",
    "policyTypeSubCode",
    "marketingProgramCode"
})
public class GetProducerWithCommissionRatesInputs {

    @XmlElement(name = "LineOfBusinessName")
    protected String lineOfBusinessName;
    @XmlElement(name = "LineOfBusinessTypeCode", required = true)
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
