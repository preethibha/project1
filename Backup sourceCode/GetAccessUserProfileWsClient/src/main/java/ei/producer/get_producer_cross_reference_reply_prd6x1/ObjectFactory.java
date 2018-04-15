
package ei.producer.get_producer_cross_reference_reply_prd6x1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ei.producer.get_producer_cross_reference_reply_prd6x1 package. 
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

    private final static QName _GetProducerCrossReferenceReply_QNAME = new QName("http://ei/producer/get_producer_cross_reference_reply_prd6x1", "GetProducerCrossReferenceReply");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ei.producer.get_producer_cross_reference_reply_prd6x1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProducerCrossReferenceReply }
     * 
     */
    public GetProducerCrossReferenceReply createGetProducerCrossReferenceReply() {
        return new GetProducerCrossReferenceReply();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducerCrossReferenceReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_producer_cross_reference_reply_prd6x1", name = "GetProducerCrossReferenceReply")
    public JAXBElement<GetProducerCrossReferenceReply> createGetProducerCrossReferenceReply(GetProducerCrossReferenceReply value) {
        return new JAXBElement<GetProducerCrossReferenceReply>(_GetProducerCrossReferenceReply_QNAME, GetProducerCrossReferenceReply.class, null, value);
    }

}
