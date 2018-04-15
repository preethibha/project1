
package ei.user.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Customization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Customization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomizationTypeReferenceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomizationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomizationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomizationValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomizationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="CustomizationIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customization", namespace = "http://ei/core/customizationx1", propOrder = {
    "customizationTypeReferenceCode",
    "customizationCode",
    "customizationName",
    "customizationValue",
    "customizationDate",
    "customizationIndicator"
})
public class Customization {

    @XmlElement(name = "CustomizationTypeReferenceCode")
    protected String customizationTypeReferenceCode;
    @XmlElement(name = "CustomizationCode")
    protected String customizationCode;
    @XmlElement(name = "CustomizationName")
    protected String customizationName;
    @XmlElement(name = "CustomizationValue")
    protected String customizationValue;
    @XmlElement(name = "CustomizationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar customizationDate;
    @XmlElement(name = "CustomizationIndicator")
    protected Boolean customizationIndicator;

    /**
     * Gets the value of the customizationTypeReferenceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomizationTypeReferenceCode() {
        return customizationTypeReferenceCode;
    }

    /**
     * Sets the value of the customizationTypeReferenceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomizationTypeReferenceCode(String value) {
        this.customizationTypeReferenceCode = value;
    }

    /**
     * Gets the value of the customizationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomizationCode() {
        return customizationCode;
    }

    /**
     * Sets the value of the customizationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomizationCode(String value) {
        this.customizationCode = value;
    }

    /**
     * Gets the value of the customizationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomizationName() {
        return customizationName;
    }

    /**
     * Sets the value of the customizationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomizationName(String value) {
        this.customizationName = value;
    }

    /**
     * Gets the value of the customizationValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomizationValue() {
        return customizationValue;
    }

    /**
     * Sets the value of the customizationValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomizationValue(String value) {
        this.customizationValue = value;
    }

    /**
     * Gets the value of the customizationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCustomizationDate() {
        return customizationDate;
    }

    /**
     * Sets the value of the customizationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCustomizationDate(XMLGregorianCalendar value) {
        this.customizationDate = value;
    }

    /**
     * Gets the value of the customizationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCustomizationIndicator() {
        return customizationIndicator;
    }

    /**
     * Sets the value of the customizationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCustomizationIndicator(Boolean value) {
        this.customizationIndicator = value;
    }

}
