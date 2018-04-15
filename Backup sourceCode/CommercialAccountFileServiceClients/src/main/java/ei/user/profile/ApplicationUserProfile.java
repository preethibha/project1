
package ei.user.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Java class for ApplicationUserProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApplicationUserProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ApplicationUserProfileProperty" type="{http://ei/core/application_user_profile_property}ApplicationUserProfileProperty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ApplicationUserProfileId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceSystemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApplicationUserProfileData" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any processContents='lax' namespace='##other' minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationUserProfile", namespace = "http://ei/core/application_user_profile", propOrder = {
    "applicationUserProfileProperty",
    "applicationUserProfileId",
    "systemId",
    "sourceSystemName",
    "applicationUserProfileData"
})
public class ApplicationUserProfile {

    @XmlElement(name = "ApplicationUserProfileProperty")
    protected List<ApplicationUserProfileProperty> applicationUserProfileProperty;
    @XmlElement(name = "ApplicationUserProfileId")
    protected String applicationUserProfileId;
    @XmlElement(name = "SystemId")
    protected String systemId;
    @XmlElement(name = "SourceSystemName")
    protected String sourceSystemName;
    @XmlElement(name = "ApplicationUserProfileData")
    protected ApplicationUserProfile.ApplicationUserProfileData applicationUserProfileData;

    /**
     * Gets the value of the applicationUserProfileProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicationUserProfileProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicationUserProfileProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApplicationUserProfileProperty }
     * 
     * 
     */
    public List<ApplicationUserProfileProperty> getApplicationUserProfileProperty() {
        if (applicationUserProfileProperty == null) {
            applicationUserProfileProperty = new ArrayList<ApplicationUserProfileProperty>();
        }
        return this.applicationUserProfileProperty;
    }

    /**
     * Gets the value of the applicationUserProfileId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationUserProfileId() {
        return applicationUserProfileId;
    }

    /**
     * Sets the value of the applicationUserProfileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationUserProfileId(String value) {
        this.applicationUserProfileId = value;
    }

    /**
     * Gets the value of the systemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * Sets the value of the systemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemId(String value) {
        this.systemId = value;
    }

    /**
     * Gets the value of the sourceSystemName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceSystemName() {
        return sourceSystemName;
    }

    /**
     * Sets the value of the sourceSystemName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceSystemName(String value) {
        this.sourceSystemName = value;
    }

    /**
     * Gets the value of the applicationUserProfileData property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationUserProfile.ApplicationUserProfileData }
     *     
     */
    public ApplicationUserProfile.ApplicationUserProfileData getApplicationUserProfileData() {
        return applicationUserProfileData;
    }

    /**
     * Sets the value of the applicationUserProfileData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationUserProfile.ApplicationUserProfileData }
     *     
     */
    public void setApplicationUserProfileData(ApplicationUserProfile.ApplicationUserProfileData value) {
        this.applicationUserProfileData = value;
    }


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
     *         &lt;any processContents='lax' namespace='##other' minOccurs="0"/>
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
        "any"
    })
    public static class ApplicationUserProfileData {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * Gets the value of the any property.
         * 
         * @return
         *     possible object is
         *     {@link Element }
         *     {@link Object }
         *     
         */
        public Object getAny() {
            return any;
        }

        /**
         * Sets the value of the any property.
         * 
         * @param value
         *     allowed object is
         *     {@link Element }
         *     {@link Object }
         *     
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }

}
