//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.product.product_retrieval_pdt1x1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ei.product.get_product_request_pdt1x1.GetProductRequest;


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
 *         &lt;element name="GetProductRequest" type="{http://ei/product/get_product_request_pdt1x1}GetProductRequest"/>
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
    "getProductRequest"
})
@XmlRootElement(name = "GetProduct")
public class GetProduct {

    @XmlElement(name = "GetProductRequest", required = true, nillable = true)
    protected GetProductRequest getProductRequest;

    /**
     * Gets the value of the getProductRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetProductRequest }
     *     
     */
    public GetProductRequest getGetProductRequest() {
        return getProductRequest;
    }

    /**
     * Sets the value of the getProductRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetProductRequest }
     *     
     */
    public void setGetProductRequest(GetProductRequest value) {
        this.getProductRequest = value;
    }

}
