
package ei.core.producer.prd2X6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PolicyTypeIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PolicyTypeIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PolicyTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PolicyTypeSubCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PolicyTypeEnglishAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PolicyTypeIdentifier", namespace = "http://ei/core/policy_type_identifierx1", propOrder = {
    "policyTypeCode",
    "policyTypeSubCode",
    "policyTypeEnglishAbbreviation"
})
public class PolicyTypeIdentifier {

    @XmlElement(name = "PolicyTypeCode")
    protected String policyTypeCode;
    @XmlElement(name = "PolicyTypeSubCode")
    protected String policyTypeSubCode;
    @XmlElement(name = "PolicyTypeEnglishAbbreviation")
    protected String policyTypeEnglishAbbreviation;

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
     * Gets the value of the policyTypeEnglishAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyTypeEnglishAbbreviation() {
        return policyTypeEnglishAbbreviation;
    }

    /**
     * Sets the value of the policyTypeEnglishAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyTypeEnglishAbbreviation(String value) {
        this.policyTypeEnglishAbbreviation = value;
    }

}
