
package ei.core.producer.prd2X6;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * This element is the name assigned to the Type of Producer Commission Rate  that is being  identified. 
 * Valid options for this element are 'National', 'Standard' or 'Local'.  
 * 
 * 
 * 
 * <p>Java class for ProducerCommissionRate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProducerCommissionRate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProducerCommissionPlanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreferredCommissionRateIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CommissionRateEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="CommissionRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProducerCommissionRate", namespace = "http://ei/core/producer_commission_rate", propOrder = {
    "producerCommissionPlanName",
    "preferredCommissionRateIndicator",
    "commissionRateEffectiveDate",
    "commissionRate"
})
public class ProducerCommissionRate {

    @XmlElement(name = "ProducerCommissionPlanName")
    protected String producerCommissionPlanName;
    @XmlElement(name = "PreferredCommissionRateIndicator")
    protected Boolean preferredCommissionRateIndicator;
    @XmlElement(name = "CommissionRateEffectiveDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar commissionRateEffectiveDate;
    @XmlElement(name = "CommissionRate")
    protected BigDecimal commissionRate;

    /**
     * Gets the value of the producerCommissionPlanName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerCommissionPlanName() {
        return producerCommissionPlanName;
    }

    /**
     * Sets the value of the producerCommissionPlanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerCommissionPlanName(String value) {
        this.producerCommissionPlanName = value;
    }

    /**
     * Gets the value of the preferredCommissionRateIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPreferredCommissionRateIndicator() {
        return preferredCommissionRateIndicator;
    }

    /**
     * Sets the value of the preferredCommissionRateIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPreferredCommissionRateIndicator(Boolean value) {
        this.preferredCommissionRateIndicator = value;
    }

    /**
     * Gets the value of the commissionRateEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCommissionRateEffectiveDate() {
        return commissionRateEffectiveDate;
    }

    /**
     * Sets the value of the commissionRateEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCommissionRateEffectiveDate(XMLGregorianCalendar value) {
        this.commissionRateEffectiveDate = value;
    }

    /**
     * Gets the value of the commissionRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    /**
     * Sets the value of the commissionRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCommissionRate(BigDecimal value) {
        this.commissionRate = value;
    }

}
