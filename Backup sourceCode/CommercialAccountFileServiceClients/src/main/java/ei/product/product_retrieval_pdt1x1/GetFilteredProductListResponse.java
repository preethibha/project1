//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.product.product_retrieval_pdt1x1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ei.product.get_filtered_product_list_reply_pdt1x1.GetFilteredProductListReply;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetFilteredProductListReply" type="{http://ei/product/get_filtered_product_list_reply_pdt1x1}GetFilteredProductListReply"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getFilteredProductListReply"
})
@XmlRootElement(name = "GetFilteredProductListResponse")
public class GetFilteredProductListResponse {

    @XmlElement(name = "GetFilteredProductListReply", required = true, nillable = true)
    protected GetFilteredProductListReply getFilteredProductListReply;

    /**
     * Gets the value of the getFilteredProductListReply property.
     * 
     * @return
     *     possible object is
     *     {@link GetFilteredProductListReply }
     *     
     */
    public GetFilteredProductListReply getGetFilteredProductListReply() {
        return getFilteredProductListReply;
    }

    /**
     * Sets the value of the getFilteredProductListReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFilteredProductListReply }
     *     
     */
    public void setGetFilteredProductListReply(GetFilteredProductListReply value) {
        this.getFilteredProductListReply = value;
    }

}
