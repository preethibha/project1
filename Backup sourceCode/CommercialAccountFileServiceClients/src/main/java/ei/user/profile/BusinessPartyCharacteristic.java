
package ei.user.profile;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for BusinessPartyCharacteristic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusinessPartyCharacteristic">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BPCharacteristicName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BPCharacteristicValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BPCharacteristicAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BPCharacteristicIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="BPCharacteristicDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="BPCharacteristicCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BPCharacteristicAmountTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitOfMeasure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessPartyCharacteristic", namespace = "http://ei/core/business_party_characteristic", propOrder = {
    "bpCharacteristicName",
    "bpCharacteristicValue",
    "bpCharacteristicAmount",
    "bpCharacteristicIndicator",
    "bpCharacteristicDate",
    "bpCharacteristicCurrencyCode",
    "bpCharacteristicAmountTypeName",
    "unitOfMeasure"
})
public class BusinessPartyCharacteristic {

    @XmlElement(name = "BPCharacteristicName")
    protected String bpCharacteristicName;
    @XmlElement(name = "BPCharacteristicValue")
    protected String bpCharacteristicValue;
    @XmlElement(name = "BPCharacteristicAmount")
    protected BigDecimal bpCharacteristicAmount;
    @XmlElement(name = "BPCharacteristicIndicator")
    protected Boolean bpCharacteristicIndicator;
    @XmlElement(name = "BPCharacteristicDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar bpCharacteristicDate;
    @XmlElement(name = "BPCharacteristicCurrencyCode")
    protected String bpCharacteristicCurrencyCode;
    @XmlElement(name = "BPCharacteristicAmountTypeName")
    protected String bpCharacteristicAmountTypeName;
    @XmlElement(name = "UnitOfMeasure")
    protected String unitOfMeasure;

    /**
     * Gets the value of the bpCharacteristicName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBPCharacteristicName() {
        return bpCharacteristicName;
    }

    /**
     * Sets the value of the bpCharacteristicName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBPCharacteristicName(String value) {
        this.bpCharacteristicName = value;
    }

    /**
     * Gets the value of the bpCharacteristicValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBPCharacteristicValue() {
        return bpCharacteristicValue;
    }

    /**
     * Sets the value of the bpCharacteristicValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBPCharacteristicValue(String value) {
        this.bpCharacteristicValue = value;
    }

    /**
     * Gets the value of the bpCharacteristicAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBPCharacteristicAmount() {
        return bpCharacteristicAmount;
    }

    /**
     * Sets the value of the bpCharacteristicAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBPCharacteristicAmount(BigDecimal value) {
        this.bpCharacteristicAmount = value;
    }

    /**
     * Gets the value of the bpCharacteristicIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBPCharacteristicIndicator() {
        return bpCharacteristicIndicator;
    }

    /**
     * Sets the value of the bpCharacteristicIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBPCharacteristicIndicator(Boolean value) {
        this.bpCharacteristicIndicator = value;
    }

    /**
     * Gets the value of the bpCharacteristicDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBPCharacteristicDate() {
        return bpCharacteristicDate;
    }

    /**
     * Sets the value of the bpCharacteristicDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBPCharacteristicDate(XMLGregorianCalendar value) {
        this.bpCharacteristicDate = value;
    }

    /**
     * Gets the value of the bpCharacteristicCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBPCharacteristicCurrencyCode() {
        return bpCharacteristicCurrencyCode;
    }

    /**
     * Sets the value of the bpCharacteristicCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBPCharacteristicCurrencyCode(String value) {
        this.bpCharacteristicCurrencyCode = value;
    }

    /**
     * Gets the value of the bpCharacteristicAmountTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBPCharacteristicAmountTypeName() {
        return bpCharacteristicAmountTypeName;
    }

    /**
     * Sets the value of the bpCharacteristicAmountTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBPCharacteristicAmountTypeName(String value) {
        this.bpCharacteristicAmountTypeName = value;
    }

    /**
     * Gets the value of the unitOfMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Sets the value of the unitOfMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitOfMeasure(String value) {
        this.unitOfMeasure = value;
    }

}
