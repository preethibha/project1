
package ei.user.profile_retrieval_crp31X1x1_http;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "UserProfileRetrievalCRP31X1HttpService", targetNamespace = "http://ei/corporate/user_profile_retrieval_crp31x1_http", wsdlLocation = "META-INF/wsdl/UserProfileRetrievalCRP31X1Http.wsdl")
public class UserProfileRetrievalCRP31X1HttpService
    extends Service
{

    private final static URL USERPROFILERETRIEVALCRP31X1HTTPSERVICE_WSDL_LOCATION;
    private final static WebServiceException USERPROFILERETRIEVALCRP31X1HTTPSERVICE_EXCEPTION;
    private final static QName USERPROFILERETRIEVALCRP31X1HTTPSERVICE_QNAME = new QName("http://ei/corporate/user_profile_retrieval_crp31x1_http", "UserProfileRetrievalCRP31X1HttpService");

    static {
        USERPROFILERETRIEVALCRP31X1HTTPSERVICE_WSDL_LOCATION = ei.user.profile_retrieval_crp31X1x1_http.UserProfileRetrievalCRP31X1HttpService.class.getClassLoader().getResource("META-INF/wsdl/UserProfileRetrievalCRP31X1Http.wsdl");
        WebServiceException e = null;
        if (USERPROFILERETRIEVALCRP31X1HTTPSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'META-INF/wsdl/UserProfileRetrievalCRP31X1Http.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        USERPROFILERETRIEVALCRP31X1HTTPSERVICE_EXCEPTION = e;
    }

    public UserProfileRetrievalCRP31X1HttpService() {
        super(__getWsdlLocation(), USERPROFILERETRIEVALCRP31X1HTTPSERVICE_QNAME);
    }

    public UserProfileRetrievalCRP31X1HttpService(WebServiceFeature... features) {
        super(__getWsdlLocation(), USERPROFILERETRIEVALCRP31X1HTTPSERVICE_QNAME, features);
    }

    public UserProfileRetrievalCRP31X1HttpService(URL wsdlLocation) {
        super(wsdlLocation, USERPROFILERETRIEVALCRP31X1HTTPSERVICE_QNAME);
    }

    public UserProfileRetrievalCRP31X1HttpService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, USERPROFILERETRIEVALCRP31X1HTTPSERVICE_QNAME, features);
    }

    public UserProfileRetrievalCRP31X1HttpService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserProfileRetrievalCRP31X1HttpService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UserProfileRetrievalCRP31X1
     */
    @WebEndpoint(name = "UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPort")
    public UserProfileRetrievalCRP31X1 getUserProfileRetrievalCRP31X1HTTPUserProfileRetrievalCRP31X1HttpPort() {
        return super.getPort(new QName("http://ei/corporate/user_profile_retrieval_crp31x1_http", "UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPort"), UserProfileRetrievalCRP31X1.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserProfileRetrievalCRP31X1
     */
    @WebEndpoint(name = "UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPort")
    public UserProfileRetrievalCRP31X1 getUserProfileRetrievalCRP31X1HTTPUserProfileRetrievalCRP31X1HttpPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ei/corporate/user_profile_retrieval_crp31x1_http", "UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPort"), UserProfileRetrievalCRP31X1.class, features);
    }

    private static URL __getWsdlLocation() {
        if (USERPROFILERETRIEVALCRP31X1HTTPSERVICE_EXCEPTION!= null) {
            throw USERPROFILERETRIEVALCRP31X1HTTPSERVICE_EXCEPTION;
        }
        return USERPROFILERETRIEVALCRP31X1HTTPSERVICE_WSDL_LOCATION;
    }

}
