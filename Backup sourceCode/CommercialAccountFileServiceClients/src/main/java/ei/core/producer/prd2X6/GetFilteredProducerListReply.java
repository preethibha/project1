
package ei.core.producer.prd2X6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetFilteredProducerListReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilteredProducerListReply">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetFilteredProducerListOutputs" type="{http://ei/producer/get_filtered_producer_list_outputs_prd2x6}GetFilteredProducerListOutputs" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StatusInformation" type="{http://ei/core/status_informationx1}StatusInformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFilteredProducerListReply", namespace = "http://ei/producer/get_filtered_producer_list_reply_prd2x6", propOrder = {
    "getFilteredProducerListOutputs",
    "statusInformation"
})
public class GetFilteredProducerListReply {

    @XmlElement(name = "GetFilteredProducerListOutputs")
    protected List<GetFilteredProducerListOutputs> getFilteredProducerListOutputs;
    @XmlElement(name = "StatusInformation")
    protected StatusInformation statusInformation;

    /**
     * Gets the value of the getFilteredProducerListOutputs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getFilteredProducerListOutputs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetFilteredProducerListOutputs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetFilteredProducerListOutputs }
     * 
     * 
     */
    public List<GetFilteredProducerListOutputs> getGetFilteredProducerListOutputs() {
        if (getFilteredProducerListOutputs == null) {
            getFilteredProducerListOutputs = new ArrayList<GetFilteredProducerListOutputs>();
        }
        return this.getFilteredProducerListOutputs;
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

}
