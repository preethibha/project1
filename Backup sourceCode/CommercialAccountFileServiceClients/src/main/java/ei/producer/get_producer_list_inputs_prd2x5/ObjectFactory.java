//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.producer.get_producer_list_inputs_prd2x5;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ei.producer.get_producer_list_inputs_prd2x5 package. 
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

    private final static QName _GetProducerListInputs_QNAME = new QName("http://ei/producer/get_producer_list_inputs_prd2x5", "GetProducerListInputs");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ei.producer.get_producer_list_inputs_prd2x5
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProducerListInputs }
     * 
     */
    public GetProducerListInputs createGetProducerListInputs() {
        return new GetProducerListInputs();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducerListInputs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_producer_list_inputs_prd2x5", name = "GetProducerListInputs")
    public JAXBElement<GetProducerListInputs> createGetProducerListInputs(GetProducerListInputs value) {
        return new JAXBElement<GetProducerListInputs>(_GetProducerListInputs_QNAME, GetProducerListInputs.class, null, value);
    }

}
