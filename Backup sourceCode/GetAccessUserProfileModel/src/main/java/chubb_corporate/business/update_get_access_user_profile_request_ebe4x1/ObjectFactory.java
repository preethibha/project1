//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-03/09/2011 06:46 PM(foreman)-)
//


package chubb_corporate.business.update_get_access_user_profile_request_ebe4x1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the chubb_corporate.business.update_get_access_user_profile_request_ebe4x1 package. 
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

    private final static QName _UpdateGetAccessUserProfileRequest_QNAME = new QName("http://chubb_corporate/business/update_get_access_user_profile_request_ebe4x1", "UpdateGetAccessUserProfileRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: chubb_corporate.business.update_get_access_user_profile_request_ebe4x1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateGetAccessUserProfileRequest }
     * 
     */
    public UpdateGetAccessUserProfileRequest createUpdateGetAccessUserProfileRequest() {
        return new UpdateGetAccessUserProfileRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateGetAccessUserProfileRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chubb_corporate/business/update_get_access_user_profile_request_ebe4x1", name = "UpdateGetAccessUserProfileRequest")
    public JAXBElement<UpdateGetAccessUserProfileRequest> createUpdateGetAccessUserProfileRequest(UpdateGetAccessUserProfileRequest value) {
        return new JAXBElement<UpdateGetAccessUserProfileRequest>(_UpdateGetAccessUserProfileRequest_QNAME, UpdateGetAccessUserProfileRequest.class, null, value);
    }

}
