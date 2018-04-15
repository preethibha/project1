//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-03/09/2011 06:46 PM(foreman)-)
//


package chubb_corporate.get_access.access_attribute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Access attributes are used to track what can be accessed.   They are defined to be abstract name/value pairs.
 * 
 * <p>Java class for AccessAttribute complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccessAttribute">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccessAttribute" type="{http://chubb_corporate/get_access/access_attribute}AccessAttribute" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AccessAttributeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccessAttributeValue" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AccessAttributeActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccessAttribute", propOrder = {
    "accessAttribute",
    "accessAttributeName",
    "accessAttributeValue",
    "accessAttributeActionCode"
})
public class AccessAttribute
    implements Serializable
{

    @XmlElement(name = "AccessAttribute")
    protected List<AccessAttribute> accessAttribute;
    @XmlElement(name = "AccessAttributeName")
    protected String accessAttributeName;
    @XmlElement(name = "AccessAttributeValue")
    protected List<String> accessAttributeValue;
    @XmlElement(name = "AccessAttributeActionCode")
    protected String accessAttributeActionCode;

    /**
     * Gets the value of the accessAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accessAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccessAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccessAttribute }
     * 
     * 
     */
    public List<AccessAttribute> getAccessAttribute() {
        if (accessAttribute == null) {
            accessAttribute = new ArrayList<AccessAttribute>();
        }
        return this.accessAttribute;
    }

    /**
     * Gets the value of the accessAttributeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessAttributeName() {
        return accessAttributeName;
    }

    /**
     * Sets the value of the accessAttributeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessAttributeName(String value) {
        this.accessAttributeName = value;
    }

    /**
     * Gets the value of the accessAttributeValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accessAttributeValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccessAttributeValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAccessAttributeValue() {
        if (accessAttributeValue == null) {
            accessAttributeValue = new ArrayList<String>();
        }
        return this.accessAttributeValue;
    }

    /**
     * Gets the value of the accessAttributeActionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessAttributeActionCode() {
        return accessAttributeActionCode;
    }

    /**
     * Sets the value of the accessAttributeActionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessAttributeActionCode(String value) {
        this.accessAttributeActionCode = value;
    }

}
