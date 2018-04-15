//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.country.country_retrieval_crp10x1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import ei.core.simplefault.SimpleFault;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ei.country.country_retrieval_crp10x1 package. 
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

    private final static QName _SimpleFault_QNAME = new QName("http://ei/country/country_retrieval_crp10X1", "SimpleFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ei.country.country_retrieval_crp10x1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCountryResponse }
     * 
     */
    public GetCountryResponse createGetCountryResponse() {
        return new GetCountryResponse();
    }

    /**
     * Create an instance of {@link GetCountryListResponse }
     * 
     */
    public GetCountryListResponse createGetCountryListResponse() {
        return new GetCountryListResponse();
    }

    /**
     * Create an instance of {@link GetCountryList }
     * 
     */
    public GetCountryList createGetCountryList() {
        return new GetCountryList();
    }

    /**
     * Create an instance of {@link GetCountry }
     * 
     */
    public GetCountry createGetCountry() {
        return new GetCountry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/country/country_retrieval_crp10X1", name = "SimpleFault")
    public JAXBElement<SimpleFault> createSimpleFault(SimpleFault value) {
        return new JAXBElement<SimpleFault>(_SimpleFault_QNAME, SimpleFault.class, null, value);
    }

}
