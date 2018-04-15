//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.core.prdct_compnt_rule_group;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ei.core.prdct_compnt_exclusion_variation.PrdctCompntExclusionVariation;
import ei.core.prdct_compnt_hazard.PrdctCompntHazard;
import ei.core.prdct_compnt_loss_value_option.PrdctCompntLossValueOption;
import ei.core.prdct_compnt_product_part.PrdctCompntProductPart;
import ei.core.prdct_compnt_restriction_option.PrdctCompntRestrictionOption;
import ei.core.prdct_compnt_subject_type_part.PrdctCompntSubjectTypePart;


/**
 * The Product Component Rule states the valid operations for a  particular product component classifications.  For example, a rule of  - "Include All" may be allowed to contain  "Services" in the role, "Include All" may be allowed to contain "Coverages" in a role. 
 * 
 * 
 * <p>Java class for PrdctCompntRuleGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrdctCompntRuleGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProductPart" type="{http://ei/core/prdct_compnt_product_part}PrdctCompntProductPart" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Hazard" type="{http://ei/core/prdct_compnt_hazard}PrdctCompntHazard" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ExclusionVariation" type="{http://ei/core/prdct_compnt_exclusion_variation}PrdctCompntExclusionVariation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LossValueOption" type="{http://ei/core/prdct_compnt_loss_value_option}PrdctCompntLossValueOption" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SubjectTypePart" type="{http://ei/core/prdct_compnt_subject_type_part}PrdctCompntSubjectTypePart" minOccurs="0"/>
 *         &lt;element name="RestrictionOption" type="{http://ei/core/prdct_compnt_restriction_option}PrdctCompntRestrictionOption" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ProductComponentRuleGroupGIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductComponentRuleGroupTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductComponentRuleGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperatorGIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrdctCompntRuleGroup", namespace = "http://ei/core/prdct_compnt_rule_group", propOrder = {
    "productPart",
    "hazard",
    "exclusionVariation",
    "lossValueOption",
    "subjectTypePart",
    "restrictionOption",
    "productComponentRuleGroupGIN",
    "productComponentRuleGroupTypeCode",
    "productComponentRuleGroupName",
    "operatorGIN",
    "operatorName"
})
public class PrdctCompntRuleGroup {

    @XmlElement(name = "ProductPart")
    protected List<PrdctCompntProductPart> productPart;
    @XmlElement(name = "Hazard")
    protected List<PrdctCompntHazard> hazard;
    @XmlElement(name = "ExclusionVariation")
    protected List<PrdctCompntExclusionVariation> exclusionVariation;
    @XmlElement(name = "LossValueOption")
    protected List<PrdctCompntLossValueOption> lossValueOption;
    @XmlElement(name = "SubjectTypePart")
    protected PrdctCompntSubjectTypePart subjectTypePart;
    @XmlElement(name = "RestrictionOption")
    protected List<PrdctCompntRestrictionOption> restrictionOption;
    @XmlElement(name = "ProductComponentRuleGroupGIN")
    protected String productComponentRuleGroupGIN;
    @XmlElement(name = "ProductComponentRuleGroupTypeCode")
    protected String productComponentRuleGroupTypeCode;
    @XmlElement(name = "ProductComponentRuleGroupName")
    protected String productComponentRuleGroupName;
    @XmlElement(name = "OperatorGIN")
    protected String operatorGIN;
    @XmlElement(name = "OperatorName")
    protected String operatorName;

    /**
     * Gets the value of the productPart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productPart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductPart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrdctCompntProductPart }
     * 
     * 
     */
    public List<PrdctCompntProductPart> getProductPart() {
        if (productPart == null) {
            productPart = new ArrayList<PrdctCompntProductPart>();
        }
        return this.productPart;
    }

    /**
     * Gets the value of the hazard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hazard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHazard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrdctCompntHazard }
     * 
     * 
     */
    public List<PrdctCompntHazard> getHazard() {
        if (hazard == null) {
            hazard = new ArrayList<PrdctCompntHazard>();
        }
        return this.hazard;
    }

    /**
     * Gets the value of the exclusionVariation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exclusionVariation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExclusionVariation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrdctCompntExclusionVariation }
     * 
     * 
     */
    public List<PrdctCompntExclusionVariation> getExclusionVariation() {
        if (exclusionVariation == null) {
            exclusionVariation = new ArrayList<PrdctCompntExclusionVariation>();
        }
        return this.exclusionVariation;
    }

    /**
     * Gets the value of the lossValueOption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lossValueOption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLossValueOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrdctCompntLossValueOption }
     * 
     * 
     */
    public List<PrdctCompntLossValueOption> getLossValueOption() {
        if (lossValueOption == null) {
            lossValueOption = new ArrayList<PrdctCompntLossValueOption>();
        }
        return this.lossValueOption;
    }

    /**
     * Gets the value of the subjectTypePart property.
     * 
     * @return
     *     possible object is
     *     {@link PrdctCompntSubjectTypePart }
     *     
     */
    public PrdctCompntSubjectTypePart getSubjectTypePart() {
        return subjectTypePart;
    }

    /**
     * Sets the value of the subjectTypePart property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrdctCompntSubjectTypePart }
     *     
     */
    public void setSubjectTypePart(PrdctCompntSubjectTypePart value) {
        this.subjectTypePart = value;
    }

    /**
     * Gets the value of the restrictionOption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the restrictionOption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRestrictionOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrdctCompntRestrictionOption }
     * 
     * 
     */
    public List<PrdctCompntRestrictionOption> getRestrictionOption() {
        if (restrictionOption == null) {
            restrictionOption = new ArrayList<PrdctCompntRestrictionOption>();
        }
        return this.restrictionOption;
    }

    /**
     * Gets the value of the productComponentRuleGroupGIN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductComponentRuleGroupGIN() {
        return productComponentRuleGroupGIN;
    }

    /**
     * Sets the value of the productComponentRuleGroupGIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductComponentRuleGroupGIN(String value) {
        this.productComponentRuleGroupGIN = value;
    }

    /**
     * Gets the value of the productComponentRuleGroupTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductComponentRuleGroupTypeCode() {
        return productComponentRuleGroupTypeCode;
    }

    /**
     * Sets the value of the productComponentRuleGroupTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductComponentRuleGroupTypeCode(String value) {
        this.productComponentRuleGroupTypeCode = value;
    }

    /**
     * Gets the value of the productComponentRuleGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductComponentRuleGroupName() {
        return productComponentRuleGroupName;
    }

    /**
     * Sets the value of the productComponentRuleGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductComponentRuleGroupName(String value) {
        this.productComponentRuleGroupName = value;
    }

    /**
     * Gets the value of the operatorGIN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorGIN() {
        return operatorGIN;
    }

    /**
     * Sets the value of the operatorGIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorGIN(String value) {
        this.operatorGIN = value;
    }

    /**
     * Gets the value of the operatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * Sets the value of the operatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorName(String value) {
        this.operatorName = value;
    }

}
