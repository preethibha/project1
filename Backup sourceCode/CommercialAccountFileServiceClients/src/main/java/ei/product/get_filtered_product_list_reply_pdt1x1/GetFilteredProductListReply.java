//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.product.get_filtered_product_list_reply_pdt1x1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ei.core.product.Product;
import ei.core.status_informationx2.StatusInformation;


/**
 * <p>Java class for GetFilteredProductListReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilteredProductListReply">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Product" type="{http://ei/core/product}Product" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "GetFilteredProductListReply", namespace = "http://ei/product/get_filtered_product_list_reply_pdt1x1", propOrder = {
    "product",
    "statusInformation"
})
public class GetFilteredProductListReply {

    @XmlElement(name = "Product")
    protected List<Product> product;
    @XmlElement(name = "StatusInformation")
    protected StatusInformation statusInformation;

    /**
     * Gets the value of the product property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the product property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProduct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Product }
     * 
     * 
     */
    public List<Product> getProduct() {
        if (product == null) {
            product = new ArrayList<Product>();
        }
        return this.product;
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
