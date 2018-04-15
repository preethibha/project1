
package ei.user.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BusinessParty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusinessParty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IndividualIdentifier" type="{http://ei/core/individual_identifierx1}IndividualIdentifier" minOccurs="0"/>
 *         &lt;element name="IndividualName" type="{http://ei/core/individual_name}IndividualName" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BPTypedAddress" type="{http://ei/core/typed_addressx3}TypedAddress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BPTelecommElectronicAddress" type="{http://ei/core/telecomm_electronic_address}TelecommElectronicAddress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BPDurableKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BPTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BusinessPartyCharacteristic" type="{http://ei/core/business_party_characteristic}BusinessPartyCharacteristic" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BusinessPartyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessParty", namespace = "http://ei/core/business_partyx1", propOrder = {
    "individualIdentifier",
    "individualName",
    "bpTypedAddress",
    "bpTelecommElectronicAddress",
    "bpDurableKey",
    "bpTypeCode",
    "businessPartyCharacteristic",
    "businessPartyName"
})
@XmlSeeAlso({
    User.class
})
public class BusinessParty {

    @XmlElement(name = "IndividualIdentifier")
    protected IndividualIdentifier individualIdentifier;
    @XmlElement(name = "IndividualName")
    protected List<IndividualName> individualName;
    @XmlElement(name = "BPTypedAddress")
    protected List<TypedAddress> bpTypedAddress;
    @XmlElement(name = "BPTelecommElectronicAddress")
    protected List<TelecommElectronicAddress> bpTelecommElectronicAddress;
    @XmlElement(name = "BPDurableKey")
    protected String bpDurableKey;
    @XmlElement(name = "BPTypeCode")
    protected String bpTypeCode;
    @XmlElement(name = "BusinessPartyCharacteristic")
    protected List<BusinessPartyCharacteristic> businessPartyCharacteristic;
    @XmlElement(name = "BusinessPartyName")
    protected String businessPartyName;

    /**
     * Gets the value of the individualIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link IndividualIdentifier }
     *     
     */
    public IndividualIdentifier getIndividualIdentifier() {
        return individualIdentifier;
    }

    /**
     * Sets the value of the individualIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndividualIdentifier }
     *     
     */
    public void setIndividualIdentifier(IndividualIdentifier value) {
        this.individualIdentifier = value;
    }

    /**
     * Gets the value of the individualName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the individualName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndividualName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IndividualName }
     * 
     * 
     */
    public List<IndividualName> getIndividualName() {
        if (individualName == null) {
            individualName = new ArrayList<IndividualName>();
        }
        return this.individualName;
    }

    /**
     * Gets the value of the bpTypedAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bpTypedAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBPTypedAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypedAddress }
     * 
     * 
     */
    public List<TypedAddress> getBPTypedAddress() {
        if (bpTypedAddress == null) {
            bpTypedAddress = new ArrayList<TypedAddress>();
        }
        return this.bpTypedAddress;
    }

    /**
     * Gets the value of the bpTelecommElectronicAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bpTelecommElectronicAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBPTelecommElectronicAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TelecommElectronicAddress }
     * 
     * 
     */
    public List<TelecommElectronicAddress> getBPTelecommElectronicAddress() {
        if (bpTelecommElectronicAddress == null) {
            bpTelecommElectronicAddress = new ArrayList<TelecommElectronicAddress>();
        }
        return this.bpTelecommElectronicAddress;
    }

    /**
     * Gets the value of the bpDurableKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBPDurableKey() {
        return bpDurableKey;
    }

    /**
     * Sets the value of the bpDurableKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBPDurableKey(String value) {
        this.bpDurableKey = value;
    }

    /**
     * Gets the value of the bpTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBPTypeCode() {
        return bpTypeCode;
    }

    /**
     * Sets the value of the bpTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBPTypeCode(String value) {
        this.bpTypeCode = value;
    }

    /**
     * Gets the value of the businessPartyCharacteristic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the businessPartyCharacteristic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusinessPartyCharacteristic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BusinessPartyCharacteristic }
     * 
     * 
     */
    public List<BusinessPartyCharacteristic> getBusinessPartyCharacteristic() {
        if (businessPartyCharacteristic == null) {
            businessPartyCharacteristic = new ArrayList<BusinessPartyCharacteristic>();
        }
        return this.businessPartyCharacteristic;
    }

    /**
     * Gets the value of the businessPartyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessPartyName() {
        return businessPartyName;
    }

    /**
     * Sets the value of the businessPartyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessPartyName(String value) {
        this.businessPartyName = value;
    }

}
