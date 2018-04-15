//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.producer.extended_producerx3;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.chubb.dgmk.caf.logger.CAFLogger;

import ei.producer.producerx4.Producer;


/**
 * <p>Java class for ExtendedProducer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedProducer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ei/producer/producerx4}Producer">
 *       &lt;sequence>
 *         &lt;element name="ProducerCommercialCancelAndUseDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ProducerCommercialCancelAndUseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerCommercialCancelAndUseSubNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerPersonalCancelAndUseDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ProducerPersonalCancelAndUseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerPersonalCancelAndUseSubNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerBothCancelAndUseDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ProducerBothCancelAndUseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerBothCancelAndUseSubNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedProducer", namespace = "http://ei/producer/extended_producerx3", propOrder = {
    "producerCommercialCancelAndUseDate",
    "producerCommercialCancelAndUseNumber",
    "producerCommercialCancelAndUseSubNumber",
    "producerPersonalCancelAndUseDate",
    "producerPersonalCancelAndUseNumber",
    "producerPersonalCancelAndUseSubNumber",
    "producerBothCancelAndUseDate",
    "producerBothCancelAndUseNumber",
    "producerBothCancelAndUseSubNumber"
})
public class ExtendedProducer
    extends Producer
{

    @XmlElement(name = "ProducerCommercialCancelAndUseDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar producerCommercialCancelAndUseDate;
    @XmlElement(name = "ProducerCommercialCancelAndUseNumber")
    protected String producerCommercialCancelAndUseNumber;
    @XmlElement(name = "ProducerCommercialCancelAndUseSubNumber")
    protected String producerCommercialCancelAndUseSubNumber;
    @XmlElement(name = "ProducerPersonalCancelAndUseDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar producerPersonalCancelAndUseDate;
    @XmlElement(name = "ProducerPersonalCancelAndUseNumber")
    protected String producerPersonalCancelAndUseNumber;
    @XmlElement(name = "ProducerPersonalCancelAndUseSubNumber")
    protected String producerPersonalCancelAndUseSubNumber;
    @XmlElement(name = "ProducerBothCancelAndUseDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar producerBothCancelAndUseDate;
    @XmlElement(name = "ProducerBothCancelAndUseNumber")
    protected String producerBothCancelAndUseNumber;
    @XmlElement(name = "ProducerBothCancelAndUseSubNumber")
    protected String producerBothCancelAndUseSubNumber;

    /**
     * Gets the value of the producerCommercialCancelAndUseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProducerCommercialCancelAndUseDate() {
        return producerCommercialCancelAndUseDate;
    }

    /**
     * Sets the value of the producerCommercialCancelAndUseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProducerCommercialCancelAndUseDate(XMLGregorianCalendar value) {
        this.producerCommercialCancelAndUseDate = value;
    }

    /**
     * Gets the value of the producerCommercialCancelAndUseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerCommercialCancelAndUseNumber() {
        return producerCommercialCancelAndUseNumber;
    }

    /**
     * Sets the value of the producerCommercialCancelAndUseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerCommercialCancelAndUseNumber(String value) {
        this.producerCommercialCancelAndUseNumber = value;
    }

    /**
     * Gets the value of the producerCommercialCancelAndUseSubNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerCommercialCancelAndUseSubNumber() {
        return producerCommercialCancelAndUseSubNumber;
    }

    /**
     * Sets the value of the producerCommercialCancelAndUseSubNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerCommercialCancelAndUseSubNumber(String value) {
        this.producerCommercialCancelAndUseSubNumber = value;
    }

    /**
     * Gets the value of the producerPersonalCancelAndUseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProducerPersonalCancelAndUseDate() {
        return producerPersonalCancelAndUseDate;
    }

    /**
     * Sets the value of the producerPersonalCancelAndUseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProducerPersonalCancelAndUseDate(XMLGregorianCalendar value) {
        this.producerPersonalCancelAndUseDate = value;
    }

    /**
     * Gets the value of the producerPersonalCancelAndUseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerPersonalCancelAndUseNumber() {
        return producerPersonalCancelAndUseNumber;
    }

    /**
     * Sets the value of the producerPersonalCancelAndUseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerPersonalCancelAndUseNumber(String value) {
        this.producerPersonalCancelAndUseNumber = value;
    }

    /**
     * Gets the value of the producerPersonalCancelAndUseSubNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerPersonalCancelAndUseSubNumber() {
        return producerPersonalCancelAndUseSubNumber;
    }

    /**
     * Sets the value of the producerPersonalCancelAndUseSubNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerPersonalCancelAndUseSubNumber(String value) {
        this.producerPersonalCancelAndUseSubNumber = value;
    }

    /**
     * Gets the value of the producerBothCancelAndUseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProducerBothCancelAndUseDate() {
        return producerBothCancelAndUseDate;
    }

    /**
     * Sets the value of the producerBothCancelAndUseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProducerBothCancelAndUseDate(XMLGregorianCalendar value) {
        this.producerBothCancelAndUseDate = value;
    }

    /**
     * Gets the value of the producerBothCancelAndUseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerBothCancelAndUseNumber() {
        return producerBothCancelAndUseNumber;
    }

    /**
     * Sets the value of the producerBothCancelAndUseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerBothCancelAndUseNumber(String value) {
        this.producerBothCancelAndUseNumber = value;
    }

    /**
     * Gets the value of the producerBothCancelAndUseSubNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerBothCancelAndUseSubNumber() {
        return producerBothCancelAndUseSubNumber;
    }

    /**
     * Sets the value of the producerBothCancelAndUseSubNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerBothCancelAndUseSubNumber(String value) {
        this.producerBothCancelAndUseSubNumber = value;
    }
    
   
    @Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("[ ProducerCommercialCancelAndUseDate : " + setDateFormat (this.getProducerCommercialCancelAndUseDate()));
		sb.append(" ,ProducerCommercialCancelAndUseNumber : " + this.getProducerCommercialCancelAndUseNumber());
		sb.append(" ,ProducerCommercialCancelAndUseSubNumber : " + this.getProducerCommercialCancelAndUseSubNumber());
		sb.append(" ,ProducerPersonalCancelAndUseDate : " + setDateFormat (this.getProducerPersonalCancelAndUseDate()));
		sb.append(" ,ProducerPersonalCancelAndUseSubNumber : " + this.getProducerPersonalCancelAndUseSubNumber());
		sb.append(" ,ProducerBothCancelAndUseDate : " + setDateFormat (this.getProducerBothCancelAndUseDate()));
		sb.append(" ,ProducerBothCancelAndUseNumber : " + this.getProducerBothCancelAndUseNumber());
		sb.append(" ,ProducerBothCancelAndUseSubNumber : " + this.getProducerBothCancelAndUseSubNumber() + "]");
		
		
		
		
		
		
		return sb.toString();
	}

    private String setDateFormat(XMLGregorianCalendar date){
    
		if (date != null)
		{
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy hh:mm:ss");
		GregorianCalendar gc = date.toGregorianCalendar();
		String formatted_date = sdf.format(gc.getTime());
		
		return formatted_date;
		}
		else
		{
			return null;
		}
	}

}
