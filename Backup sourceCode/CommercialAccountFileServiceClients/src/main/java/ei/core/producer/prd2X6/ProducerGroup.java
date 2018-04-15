
package ei.core.producer.prd2X6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ProducerGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProducerGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProducerGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrganizationTypeAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrganizationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerGroupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerGroupTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerGroupTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CombineProducerGroupCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProducerGroupMemberEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ProducerGroupMemberExpirationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="RowEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="RowExpirationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProducerGroup", namespace = "http://ei/producer/producer_group", propOrder = {
    "producerGroupName",
    "organizationTypeAbbreviation",
    "organizationCode",
    "producerGroupId",
    "producerGroupTypeCode",
    "producerGroupTypeName",
    "combineProducerGroupCode",
    "producerGroupMemberEffectiveDate",
    "producerGroupMemberExpirationDate",
    "rowEffectiveDate",
    "rowExpirationDate"
})
public class ProducerGroup {

    @XmlElement(name = "ProducerGroupName")
    protected String producerGroupName;
    @XmlElement(name = "OrganizationTypeAbbreviation")
    protected String organizationTypeAbbreviation;
    @XmlElement(name = "OrganizationCode")
    protected String organizationCode;
    @XmlElement(name = "ProducerGroupId")
    protected String producerGroupId;
    @XmlElement(name = "ProducerGroupTypeCode")
    protected String producerGroupTypeCode;
    @XmlElement(name = "ProducerGroupTypeName")
    protected String producerGroupTypeName;
    @XmlElement(name = "CombineProducerGroupCode")
    protected String combineProducerGroupCode;
    @XmlElement(name = "ProducerGroupMemberEffectiveDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar producerGroupMemberEffectiveDate;
    @XmlElement(name = "ProducerGroupMemberExpirationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar producerGroupMemberExpirationDate;
    @XmlElement(name = "RowEffectiveDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar rowEffectiveDate;
    @XmlElement(name = "RowExpirationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar rowExpirationDate;

    /**
     * Gets the value of the producerGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerGroupName() {
        return producerGroupName;
    }

    /**
     * Sets the value of the producerGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerGroupName(String value) {
        this.producerGroupName = value;
    }

    /**
     * Gets the value of the organizationTypeAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationTypeAbbreviation() {
        return organizationTypeAbbreviation;
    }

    /**
     * Sets the value of the organizationTypeAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationTypeAbbreviation(String value) {
        this.organizationTypeAbbreviation = value;
    }

    /**
     * Gets the value of the organizationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * Sets the value of the organizationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationCode(String value) {
        this.organizationCode = value;
    }

    /**
     * Gets the value of the producerGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerGroupId() {
        return producerGroupId;
    }

    /**
     * Sets the value of the producerGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerGroupId(String value) {
        this.producerGroupId = value;
    }

    /**
     * Gets the value of the producerGroupTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerGroupTypeCode() {
        return producerGroupTypeCode;
    }

    /**
     * Sets the value of the producerGroupTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerGroupTypeCode(String value) {
        this.producerGroupTypeCode = value;
    }

    /**
     * Gets the value of the producerGroupTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerGroupTypeName() {
        return producerGroupTypeName;
    }

    /**
     * Sets the value of the producerGroupTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerGroupTypeName(String value) {
        this.producerGroupTypeName = value;
    }

    /**
     * Gets the value of the combineProducerGroupCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCombineProducerGroupCode() {
        return combineProducerGroupCode;
    }

    /**
     * Sets the value of the combineProducerGroupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCombineProducerGroupCode(String value) {
        this.combineProducerGroupCode = value;
    }

    /**
     * Gets the value of the producerGroupMemberEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProducerGroupMemberEffectiveDate() {
        return producerGroupMemberEffectiveDate;
    }

    /**
     * Sets the value of the producerGroupMemberEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProducerGroupMemberEffectiveDate(XMLGregorianCalendar value) {
        this.producerGroupMemberEffectiveDate = value;
    }

    /**
     * Gets the value of the producerGroupMemberExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProducerGroupMemberExpirationDate() {
        return producerGroupMemberExpirationDate;
    }

    /**
     * Sets the value of the producerGroupMemberExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProducerGroupMemberExpirationDate(XMLGregorianCalendar value) {
        this.producerGroupMemberExpirationDate = value;
    }

    /**
     * Gets the value of the rowEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRowEffectiveDate() {
        return rowEffectiveDate;
    }

    /**
     * Sets the value of the rowEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRowEffectiveDate(XMLGregorianCalendar value) {
        this.rowEffectiveDate = value;
    }

    /**
     * Gets the value of the rowExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRowExpirationDate() {
        return rowExpirationDate;
    }

    /**
     * Sets the value of the rowExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRowExpirationDate(XMLGregorianCalendar value) {
        this.rowExpirationDate = value;
    }

}
