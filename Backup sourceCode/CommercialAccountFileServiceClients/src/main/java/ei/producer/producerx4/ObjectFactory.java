//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.producer.producerx4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ei.producer.producerx4 package. 
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

    private final static QName _Producer_QNAME = new QName("http://ei/producer/producerx4", "Producer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ei.producer.producerx4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Producer }
     * 
     */
    public Producer createProducer() {
        return new Producer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Producer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/producerx4", name = "Producer")
    public JAXBElement<Producer> createProducer(Producer value) {
        return new JAXBElement<Producer>(_Producer_QNAME, Producer.class, null, value);
    }

}
