
package ei.core.status_informationx2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ei.core.error_information.ErrorInformation;


/**
 * <p>Java class for StatusInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatusInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorInformation" type="{http://ei/core/error_information}ErrorInformation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusInformation", propOrder = {
    "errorInformation",
    "statusCode"
})
public class StatusInformation {

    @XmlElement(name = "ErrorInformation")
    protected List<ErrorInformation> errorInformation;
    @XmlElement(name = "StatusCode")
    protected String statusCode;

    /**
     * Gets the value of the errorInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errorInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrorInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErrorInformation }
     * 
     * 
     */
    public List<ErrorInformation> getErrorInformation() {
        if (errorInformation == null) {
            errorInformation = new ArrayList<ErrorInformation>();
        }
        return this.errorInformation;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

}
