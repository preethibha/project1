//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.corporate.get_default_contact_reply_crp30x1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ei.core.status_informationx2.StatusInformation;
import ei.corporate.get_default_contact_outputs_crp30x1.GetDefaultContactOutputs;


/**
 * <p>Java class for GetDefaultContactReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetDefaultContactReply">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetDefaultUnderwriterOutputs" type="{http://ei/corporate/get_default_contact_outputs_crp30x1}GetDefaultContactOutputs" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StatusInformation" type="{http://ei/core/status_informationx2}StatusInformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDefaultContactReply", namespace = "http://ei/corporate/get_default_contact_reply_crp30x1", propOrder = {
    "getDefaultUnderwriterOutputs",
    "statusInformation"
})
public class GetDefaultContactReply {

    @XmlElement(name = "GetDefaultUnderwriterOutputs")
    protected List<GetDefaultContactOutputs> getDefaultUnderwriterOutputs;
    @XmlElement(name = "StatusInformation")
    protected StatusInformation statusInformation;

    /**
     * Gets the value of the getDefaultUnderwriterOutputs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getDefaultUnderwriterOutputs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetDefaultUnderwriterOutputs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetDefaultContactOutputs }
     * 
     * 
     */
    public List<GetDefaultContactOutputs> getGetDefaultUnderwriterOutputs() {
        if (getDefaultUnderwriterOutputs == null) {
            getDefaultUnderwriterOutputs = new ArrayList<GetDefaultContactOutputs>();
        }
        return this.getDefaultUnderwriterOutputs;
    }

    /**
     * Gets the value of the statusInformation property.
     * 
     * @return
     *     possible object is
     *     {@link StatusInformation }
     *     
     */
    public StatusInformation getStatusInformation() {
        return statusInformation;
    }

    /**
     * Sets the value of the statusInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusInformation }
     *     
     */
    public void setStatusInformation(StatusInformation value) {
        this.statusInformation = value;
    }
    
    

    
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		List<GetDefaultContactOutputs> getDefaultUnderwriterOutputsList = this.getGetDefaultUnderwriterOutputs();
		for (GetDefaultContactOutputs getDefaultContactOutputs : getDefaultUnderwriterOutputsList)
			{
				sb.append("GetDefaultContactOutputs: " + getDefaultContactOutputs.toString());
			}
		
		return sb.toString();
	}

}
