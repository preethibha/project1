
package ei.core.producer.prd2X6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ProducerEnrollmentOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProducerEnrollmentOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EnrollmentOptionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EnrollmentSelectionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EnrollmentEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProducerEnrollmentOptions", namespace = "http://ei/producer/producer_enrollment_options", propOrder = {
    "enrollmentOptionCode",
    "enrollmentSelectionDate",
    "enrollmentEffectiveDate"
})
public class ProducerEnrollmentOptions {

    @XmlElement(name = "EnrollmentOptionCode")
    protected String enrollmentOptionCode;
    @XmlElement(name = "EnrollmentSelectionDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar enrollmentSelectionDate;
    @XmlElement(name = "EnrollmentEffectiveDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar enrollmentEffectiveDate;

    /**
     * Gets the value of the enrollmentOptionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnrollmentOptionCode() {
        return enrollmentOptionCode;
    }

    /**
     * Sets the value of the enrollmentOptionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnrollmentOptionCode(String value) {
        this.enrollmentOptionCode = value;
    }

    /**
     * Gets the value of the enrollmentSelectionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnrollmentSelectionDate() {
        return enrollmentSelectionDate;
    }

    /**
     * Sets the value of the enrollmentSelectionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnrollmentSelectionDate(XMLGregorianCalendar value) {
        this.enrollmentSelectionDate = value;
    }

    /**
     * Gets the value of the enrollmentEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnrollmentEffectiveDate() {
        return enrollmentEffectiveDate;
    }

    /**
     * Sets the value of the enrollmentEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnrollmentEffectiveDate(XMLGregorianCalendar value) {
        this.enrollmentEffectiveDate = value;
    }

}
