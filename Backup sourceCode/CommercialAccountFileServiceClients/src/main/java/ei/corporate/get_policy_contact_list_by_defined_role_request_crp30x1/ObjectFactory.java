//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.corporate.get_policy_contact_list_by_defined_role_request_crp30x1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ei.corporate.get_policy_contact_list_by_defined_role_request_crp30x1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetPolicyContactListByDefinedRoleRequest_QNAME = new QName("http://ei/corporate/get_policy_contact_list_by_defined_role_request_crp30x1", "GetPolicyContactListByDefinedRoleRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ei.corporate.get_policy_contact_list_by_defined_role_request_crp30x1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPolicyContactListByDefinedRoleRequest }
     * 
     */
    public GetPolicyContactListByDefinedRoleRequest createGetPolicyContactListByDefinedRoleRequest() {
        return new GetPolicyContactListByDefinedRoleRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPolicyContactListByDefinedRoleRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/corporate/get_policy_contact_list_by_defined_role_request_crp30x1", name = "GetPolicyContactListByDefinedRoleRequest")
    public JAXBElement<GetPolicyContactListByDefinedRoleRequest> createGetPolicyContactListByDefinedRoleRequest(GetPolicyContactListByDefinedRoleRequest value) {
        return new JAXBElement<GetPolicyContactListByDefinedRoleRequest>(_GetPolicyContactListByDefinedRoleRequest_QNAME, GetPolicyContactListByDefinedRoleRequest.class, null, value);
    }

}
