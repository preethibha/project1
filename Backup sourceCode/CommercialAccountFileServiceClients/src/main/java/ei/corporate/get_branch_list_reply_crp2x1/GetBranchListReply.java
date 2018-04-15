//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.corporate.get_branch_list_reply_crp2x1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ei.core.extendedbranch.ExtendedBranch;


/**
 * <p>Java class for GetBranchListReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBranchListReply">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExtendedBranch" type="{http://ei/core/extendedbranch}ExtendedBranch" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBranchListReply", namespace = "http://ei/corporate/get_branch_list_reply_crp2x1", propOrder = {
    "extendedBranch"
})
public class GetBranchListReply {

    @XmlElement(name = "ExtendedBranch")
    protected List<ExtendedBranch> extendedBranch;

    /**
     * Gets the value of the extendedBranch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extendedBranch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtendedBranch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtendedBranch }
     * 
     * 
     */
    public List<ExtendedBranch> getExtendedBranch() {
        if (extendedBranch == null) {
            extendedBranch = new ArrayList<ExtendedBranch>();
        }
        return this.extendedBranch;
    }
    
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		List<ExtendedBranch> extendedBranchList = this.getExtendedBranch();
		
		for (ExtendedBranch extendedBranch : extendedBranchList)
		{
			sb.append("Branch Name: " + extendedBranch.toString());
		}
		
		return sb.toString();
	}

}
