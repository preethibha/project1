
package ei.producer.producer_cross_reference_retrieval_prd6x1_http;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "ProducerCrossReferenceRetrievalPRD6X1HttpService", targetNamespace = "http://ei/producer/producer_cross_reference_retrieval_prd6x1_http", wsdlLocation = "WEB-INF/wsdl/ProducerCrossReferenceRetrievalPRD6X1Http.wsdl")
public class ProducerCrossReferenceRetrievalPRD6X1HttpService
    extends Service
{

    private final static URL PRODUCERCROSSREFERENCERETRIEVALPRD6X1HTTPSERVICE_WSDL_LOCATION;
    private final static WebServiceException PRODUCERCROSSREFERENCERETRIEVALPRD6X1HTTPSERVICE_EXCEPTION;
    private final static QName PRODUCERCROSSREFERENCERETRIEVALPRD6X1HTTPSERVICE_QNAME = new QName("http://ei/producer/producer_cross_reference_retrieval_prd6x1_http", "ProducerCrossReferenceRetrievalPRD6X1HttpService");

    static {
            PRODUCERCROSSREFERENCERETRIEVALPRD6X1HTTPSERVICE_WSDL_LOCATION = ei.producer.producer_cross_reference_retrieval_prd6x1_http.ProducerCrossReferenceRetrievalPRD6X1HttpService.class.getResource("/WEB-INF/wsdl/ProducerCrossReferenceRetrievalPRD6X1Http.wsdl");
        WebServiceException e = null;
        if (PRODUCERCROSSREFERENCERETRIEVALPRD6X1HTTPSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'WEB-INF/wsdl/ProducerCrossReferenceRetrievalPRD6X1Http.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        PRODUCERCROSSREFERENCERETRIEVALPRD6X1HTTPSERVICE_EXCEPTION = e;
    }

    public ProducerCrossReferenceRetrievalPRD6X1HttpService() {
        super(__getWsdlLocation(), PRODUCERCROSSREFERENCERETRIEVALPRD6X1HTTPSERVICE_QNAME);
    }

    public ProducerCrossReferenceRetrievalPRD6X1HttpService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PRODUCERCROSSREFERENCERETRIEVALPRD6X1HTTPSERVICE_QNAME, features);
    }

    public ProducerCrossReferenceRetrievalPRD6X1HttpService(URL wsdlLocation) {
        super(wsdlLocation, PRODUCERCROSSREFERENCERETRIEVALPRD6X1HTTPSERVICE_QNAME);
    }

    public ProducerCrossReferenceRetrievalPRD6X1HttpService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PRODUCERCROSSREFERENCERETRIEVALPRD6X1HTTPSERVICE_QNAME, features);
    }

    public ProducerCrossReferenceRetrievalPRD6X1HttpService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProducerCrossReferenceRetrievalPRD6X1HttpService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ProducerCrossReferenceRetrievalPRD6X1
     */
    @WebEndpoint(name = "ProducerCrossReferenceRetrievalPRD6X1HTTP_ProducerCrossReferenceRetrievalPRD6X1HttpPort")
    public ProducerCrossReferenceRetrievalPRD6X1 getProducerCrossReferenceRetrievalPRD6X1HTTPProducerCrossReferenceRetrievalPRD6X1HttpPort() {
        return super.getPort(new QName("http://ei/producer/producer_cross_reference_retrieval_prd6x1_http", "ProducerCrossReferenceRetrievalPRD6X1HTTP_ProducerCrossReferenceRetrievalPRD6X1HttpPort"), ProducerCrossReferenceRetrievalPRD6X1.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProducerCrossReferenceRetrievalPRD6X1
     */
    @WebEndpoint(name = "ProducerCrossReferenceRetrievalPRD6X1HTTP_ProducerCrossReferenceRetrievalPRD6X1HttpPort")
    public ProducerCrossReferenceRetrievalPRD6X1 getProducerCrossReferenceRetrievalPRD6X1HTTPProducerCrossReferenceRetrievalPRD6X1HttpPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ei/producer/producer_cross_reference_retrieval_prd6x1_http", "ProducerCrossReferenceRetrievalPRD6X1HTTP_ProducerCrossReferenceRetrievalPRD6X1HttpPort"), ProducerCrossReferenceRetrievalPRD6X1.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PRODUCERCROSSREFERENCERETRIEVALPRD6X1HTTPSERVICE_EXCEPTION!= null) {
            throw PRODUCERCROSSREFERENCERETRIEVALPRD6X1HTTPSERVICE_EXCEPTION;
        }
        return PRODUCERCROSSREFERENCERETRIEVALPRD6X1HTTPSERVICE_WSDL_LOCATION;
    }

}
