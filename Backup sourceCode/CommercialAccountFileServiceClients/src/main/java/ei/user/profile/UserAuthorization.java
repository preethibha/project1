
package ei.user.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * User Authorization is the process of determing which permissions a user should have.   This could be access to an application, features within an application, or data within an application.
 * 
 * 
 * 
 * 
 * 
 * <p>Java class for UserAuthorization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserAuthorization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccessAttribute" type="{http://ei/core/access_attribute}AccessAttribute" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="UserAuthorizationTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceSystemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataSourceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserAuthorization", namespace = "http://ei/core/user_authorization", propOrder = {
    "accessAttribute",
    "userAuthorizationTypeName",
    "sourceSystemName",
    "dataSourceName"
})
public class UserAuthorization {

    @XmlElement(name = "AccessAttribute")
    protected List<AccessAttribute> accessAttribute;
    @XmlElement(name = "UserAuthorizationTypeName")
    protected String userAuthorizationTypeName;
    @XmlElement(name = "SourceSystemName")
    protected String sourceSystemName;
    @XmlElement(name = "DataSourceName")
    protected String dataSourceName;

    /**
     * Gets the value of the accessAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accessAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccessAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccessAttribute }
     * 
     * 
     */
    public List<AccessAttribute> getAccessAttribute() {
        if (accessAttribute == null) {
            accessAttribute = new ArrayList<AccessAttribute>();
        }
        return this.accessAttribute;
    }

    /**
     * Gets the value of the userAuthorizationTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserAuthorizationTypeName() {
        return userAuthorizationTypeName;
    }

    /**
     * Sets the value of the userAuthorizationTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserAuthorizationTypeName(String value) {
        this.userAuthorizationTypeName = value;
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
     * Gets the value of the dataSourceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataSourceName() {
        return dataSourceName;
    }

    /**
     * Sets the value of the dataSourceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataSourceName(String value) {
        this.dataSourceName = value;
    }

}
