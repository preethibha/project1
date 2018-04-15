
package ei.core.producer.prd2X6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommissionInputParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommissionInputParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CommissionInputParameterTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommissionInputParameterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommissionInputParameterValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommissionInputParameter", namespace = "http://ei/producer/commission_input_parameter", propOrder = {
    "commissionInputParameterTypeName",
    "commissionInputParameterName",
    "commissionInputParameterValue"
})
public class CommissionInputParameter {

    @XmlElement(name = "CommissionInputParameterTypeName")
    protected String commissionInputParameterTypeName;
    @XmlElement(name = "CommissionInputParameterName")
    protected String commissionInputParameterName;
    @XmlElement(name = "CommissionInputParameterValue")
    protected String commissionInputParameterValue;

    /**
     * Gets the value of the commissionInputParameterTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommissionInputParameterTypeName() {
        return commissionInputParameterTypeName;
    }

    /**
     * Sets the value of the commissionInputParameterTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommissionInputParameterTypeName(String value) {
        this.commissionInputParameterTypeName = value;
    }

    /**
     * Gets the value of the commissionInputParameterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommissionInputParameterName() {
        return commissionInputParameterName;
    }

    /**
     * Sets the value of the commissionInputParameterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommissionInputParameterName(String value) {
        this.commissionInputParameterName = value;
    }

    /**
     * Gets the value of the commissionInputParameterValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommissionInputParameterValue() {
        return commissionInputParameterValue;
    }

    /**
     * Sets the value of the commissionInputParameterValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommissionInputParameterValue(String value) {
        this.commissionInputParameterValue = value;
    }

}
