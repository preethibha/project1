//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.corporate.branch_retrieval_crp2x1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ei.crp.get_local_language_branch_reply_crp2x1.GetLocalLanguageBranchReply;


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
 *         &lt;element name="GetLocalLanguageBranchReply" type="{http://ei/crp/get_local_language_branch_reply_crp2x1}GetLocalLanguageBranchReply"/>
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
    "getLocalLanguageBranchReply"
})
@XmlRootElement(name = "GetLocalLanguageBranchResponse")
public class GetLocalLanguageBranchResponse {

    @XmlElement(name = "GetLocalLanguageBranchReply", required = true, nillable = true)
    protected GetLocalLanguageBranchReply getLocalLanguageBranchReply;

    /**
     * Gets the value of the getLocalLanguageBranchReply property.
     * 
     * @return
     *     possible object is
     *     {@link GetLocalLanguageBranchReply }
     *     
     */
    public GetLocalLanguageBranchReply getGetLocalLanguageBranchReply() {
        return getLocalLanguageBranchReply;
    }

    /**
     * Sets the value of the getLocalLanguageBranchReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetLocalLanguageBranchReply }
     *     
     */
    public void setGetLocalLanguageBranchReply(GetLocalLanguageBranchReply value) {
        this.getLocalLanguageBranchReply = value;
    }

}
