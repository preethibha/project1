
package ei.core.producer.prd2X6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetProducerListOutputs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetProducerListOutputs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExtendedProducer" type="{http://ei/producer/extended_producerx4}ExtendedProducer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetProducerListOutputs", namespace = "http://ei/producer/get_producer_list_outputs_prd2x6", propOrder = {
    "extendedProducer"
})
public class GetProducerListOutputs {

    @XmlElement(name = "ExtendedProducer")
    protected ExtendedProducer extendedProducer;

    /**
     * Gets the value of the extendedProducer property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedProducer }
     *     
     */
    public ExtendedProducer getExtendedProducer() {
        return extendedProducer;
    }

    /**
     * Sets the value of the extendedProducer property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedProducer }
     *     
     */
    public void setExtendedProducer(ExtendedProducer value) {
        this.extendedProducer = value;
    }

}
