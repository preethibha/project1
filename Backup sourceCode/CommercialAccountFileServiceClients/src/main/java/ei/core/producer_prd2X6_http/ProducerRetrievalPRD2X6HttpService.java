
package ei.core.producer_prd2X6_http;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import ei.core.producer.prd2X6.ProducerRetrievalPRD2X6;

@WebServiceClient(name = "ProducerRetrievalPRD2X6HttpService", targetNamespace = "http://ei/producer/producer_retrieval_prd2x6_http", wsdlLocation = "META-INF/wsdl/ProducerRetrievalPRD2X6Http.wsdl")
public class ProducerRetrievalPRD2X6HttpService
    extends Service
{

    private final static URL PRODUCERRETRIEVALPRD2X6HTTPSERVICE_WSDL_LOCATION;
    private final static WebServiceException PRODUCERRETRIEVALPRD2X6HTTPSERVICE_EXCEPTION;
    private final static QName PRODUCERRETRIEVALPRD2X6HTTPSERVICE_QNAME = new QName("http://ei/producer/producer_retrieval_prd2x6_http", "ProducerRetrievalPRD2X6HttpService");

    static {
        PRODUCERRETRIEVALPRD2X6HTTPSERVICE_WSDL_LOCATION = ei.core.producer_prd2X6_http.ProducerRetrievalPRD2X6HttpService.class.getClassLoader().getResource("META-INF/wsdl/ProducerRetrievalPRD2X6Http.wsdl");
        WebServiceException e = null;
        if (PRODUCERRETRIEVALPRD2X6HTTPSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'META-INF/wsdl/ProducerRetrievalPRD2X6Http.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        PRODUCERRETRIEVALPRD2X6HTTPSERVICE_EXCEPTION = e;
    }

    public ProducerRetrievalPRD2X6HttpService() {
        super(__getWsdlLocation(), PRODUCERRETRIEVALPRD2X6HTTPSERVICE_QNAME);
    }

    public ProducerRetrievalPRD2X6HttpService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PRODUCERRETRIEVALPRD2X6HTTPSERVICE_QNAME, features);
    }

    public ProducerRetrievalPRD2X6HttpService(URL wsdlLocation) {
        super(wsdlLocation, PRODUCERRETRIEVALPRD2X6HTTPSERVICE_QNAME);
    }

    public ProducerRetrievalPRD2X6HttpService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PRODUCERRETRIEVALPRD2X6HTTPSERVICE_QNAME, features);
    }

    public ProducerRetrievalPRD2X6HttpService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProducerRetrievalPRD2X6HttpService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ProducerRetrievalPRD2X6
     */
    @WebEndpoint(name = "ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPort")
    public ProducerRetrievalPRD2X6 getProducerRetrievalPRD2X6HTTPProducerRetrievalPRD2X6HttpPort() {
        return super.getPort(new QName("http://ei/producer/producer_retrieval_prd2x6_http", "ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPort"), ProducerRetrievalPRD2X6.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProducerRetrievalPRD2X6
     */
    @WebEndpoint(name = "ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPort")
    public ProducerRetrievalPRD2X6 getProducerRetrievalPRD2X6HTTPProducerRetrievalPRD2X6HttpPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ei/producer/producer_retrieval_prd2x6_http", "ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPort"), ProducerRetrievalPRD2X6.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PRODUCERRETRIEVALPRD2X6HTTPSERVICE_EXCEPTION!= null) {
            throw PRODUCERRETRIEVALPRD2X6HTTPSERVICE_EXCEPTION;
        }
        return PRODUCERRETRIEVALPRD2X6HTTPSERVICE_WSDL_LOCATION;
    }

}
