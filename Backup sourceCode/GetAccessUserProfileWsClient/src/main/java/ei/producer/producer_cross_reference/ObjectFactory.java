
package ei.producer.producer_cross_reference;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ei.producer.producer_cross_reference package. 
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

    private final static QName _ProducerCrossReference_QNAME = new QName("http://ei/producer/producer_cross_reference", "ProducerCrossReference");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ei.producer.producer_cross_reference
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProducerCrossReference }
     * 
     */
    public ProducerCrossReference createProducerCrossReference() {
        return new ProducerCrossReference();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProducerCrossReference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/producer_cross_reference", name = "ProducerCrossReference")
    public JAXBElement<ProducerCrossReference> createProducerCrossReference(ProducerCrossReference value) {
        return new JAXBElement<ProducerCrossReference>(_ProducerCrossReference_QNAME, ProducerCrossReference.class, null, value);
    }

}
