
package ei.user.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Language complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Language">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LanguageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LanguageGeographicalCoverageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DisplayLanguageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DisplayLanguageGeographicalCoverageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LanguageLocaleDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceSystemLanguageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceSystemLanguageDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Language", namespace = "http://ei/core/languagex1", propOrder = {
    "languageCode",
    "languageGeographicalCoverageCode",
    "displayLanguageCode",
    "displayLanguageGeographicalCoverageCode",
    "languageLocaleDescription",
    "sourceSystemLanguageCode",
    "sourceSystemLanguageDescription"
})
public class Language {

    @XmlElement(name = "LanguageCode")
    protected String languageCode;
    @XmlElement(name = "LanguageGeographicalCoverageCode")
    protected String languageGeographicalCoverageCode;
    @XmlElement(name = "DisplayLanguageCode")
    protected String displayLanguageCode;
    @XmlElement(name = "DisplayLanguageGeographicalCoverageCode")
    protected String displayLanguageGeographicalCoverageCode;
    @XmlElement(name = "LanguageLocaleDescription")
    protected String languageLocaleDescription;
    @XmlElement(name = "SourceSystemLanguageCode")
    protected String sourceSystemLanguageCode;
    @XmlElement(name = "SourceSystemLanguageDescription")
    protected String sourceSystemLanguageDescription;

    /**
     * Gets the value of the languageCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * Sets the value of the languageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageCode(String value) {
        this.languageCode = value;
    }

    /**
     * Gets the value of the languageGeographicalCoverageCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageGeographicalCoverageCode() {
        return languageGeographicalCoverageCode;
    }

    /**
     * Sets the value of the languageGeographicalCoverageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageGeographicalCoverageCode(String value) {
        this.languageGeographicalCoverageCode = value;
    }

    /**
     * Gets the value of the displayLanguageCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayLanguageCode() {
        return displayLanguageCode;
    }

    /**
     * Sets the value of the displayLanguageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayLanguageCode(String value) {
        this.displayLanguageCode = value;
    }

    /**
     * Gets the value of the displayLanguageGeographicalCoverageCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayLanguageGeographicalCoverageCode() {
        return displayLanguageGeographicalCoverageCode;
    }

    /**
     * Sets the value of the displayLanguageGeographicalCoverageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayLanguageGeographicalCoverageCode(String value) {
        this.displayLanguageGeographicalCoverageCode = value;
    }

    /**
     * Gets the value of the languageLocaleDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageLocaleDescription() {
        return languageLocaleDescription;
    }

    /**
     * Sets the value of the languageLocaleDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageLocaleDescription(String value) {
        this.languageLocaleDescription = value;
    }

    /**
     * Gets the value of the sourceSystemLanguageCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceSystemLanguageCode() {
        return sourceSystemLanguageCode;
    }

    /**
     * Sets the value of the sourceSystemLanguageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceSystemLanguageCode(String value) {
        this.sourceSystemLanguageCode = value;
    }

    /**
     * Gets the value of the sourceSystemLanguageDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceSystemLanguageDescription() {
        return sourceSystemLanguageDescription;
    }

    /**
     * Sets the value of the sourceSystemLanguageDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceSystemLanguageDescription(String value) {
        this.sourceSystemLanguageDescription = value;
    }

}
