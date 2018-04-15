//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.corporate.branch_retrieval_crp2x1_http;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "BranchRetrievalCRP2X1HttpService", targetNamespace = "http://ei/corporate/branch_retrieval_crp2X1_http", wsdlLocation = "META-INF/wsdl/BranchRetrievalCRP2X1Http.wsdl")
public class BranchRetrievalCRP2X1HttpService
    extends Service
{

    private final static URL BRANCHRETRIEVALCRP2X1HTTPSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(ei.corporate.branch_retrieval_crp2x1_http.BranchRetrievalCRP2X1HttpService.class.getName());

    static {
        URL url = null;
        try {
            url = ei.corporate.branch_retrieval_crp2x1_http.BranchRetrievalCRP2X1HttpService.class.getResource("/META-INF/wsdl/BranchRetrievalCRP2X1Http.wsdl");
            if (url == null) throw new MalformedURLException("/META-INF/wsdl/BranchRetrievalCRP2X1Http.wsdl does not exist in the module.");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'META-INF/wsdl/BranchRetrievalCRP2X1Http.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        BRANCHRETRIEVALCRP2X1HTTPSERVICE_WSDL_LOCATION = url;
    }

    public BranchRetrievalCRP2X1HttpService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BranchRetrievalCRP2X1HttpService() {
        super(BRANCHRETRIEVALCRP2X1HTTPSERVICE_WSDL_LOCATION, new QName("http://ei/corporate/branch_retrieval_crp2X1_http", "BranchRetrievalCRP2X1HttpService"));
    }

    /**
     * 
     * @return
     *     returns BranchRetrievalCRP2X1
     */
    @WebEndpoint(name = "BranchRetrievalCRP2X1HTTP_BranchRetrievalCRP2X1HttpPort")
    public BranchRetrievalCRP2X1 getBranchRetrievalCRP2X1HTTPBranchRetrievalCRP2X1HttpPort() {
        return super.getPort(new QName("http://ei/corporate/branch_retrieval_crp2X1_http", "BranchRetrievalCRP2X1HTTP_BranchRetrievalCRP2X1HttpPort"), BranchRetrievalCRP2X1.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BranchRetrievalCRP2X1
     */
    @WebEndpoint(name = "BranchRetrievalCRP2X1HTTP_BranchRetrievalCRP2X1HttpPort")
    public BranchRetrievalCRP2X1 getBranchRetrievalCRP2X1HTTPBranchRetrievalCRP2X1HttpPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ei/corporate/branch_retrieval_crp2X1_http", "BranchRetrievalCRP2X1HTTP_BranchRetrievalCRP2X1HttpPort"), BranchRetrievalCRP2X1.class, features);
    }

}
