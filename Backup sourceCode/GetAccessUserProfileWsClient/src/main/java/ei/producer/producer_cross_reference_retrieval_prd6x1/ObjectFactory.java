
package ei.producer.producer_cross_reference_retrieval_prd6x1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import ei.core.simplefault.SimpleFault;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ei.producer.producer_cross_reference_retrieval_prd6x1 package. 
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

    private final static QName _SimpleFaultReply_QNAME = new QName("http://ei/producer/producer_cross_reference_retrieval_prd6x1", "SimpleFaultReply");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ei.producer.producer_cross_reference_retrieval_prd6x1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProducerId }
     * 
     */
    public GetProducerId createGetProducerId() {
        return new GetProducerId();
    }

    /**
     * Create an instance of {@link GetProducerCrossReferenceResponse }
     * 
     */
    public GetProducerCrossReferenceResponse createGetProducerCrossReferenceResponse() {
        return new GetProducerCrossReferenceResponse();
    }

    /**
     * Create an instance of {@link GetFilteredProducerCrossRefListResponse }
     * 
     */
    public GetFilteredProducerCrossRefListResponse createGetFilteredProducerCrossRefListResponse() {
        return new GetFilteredProducerCrossRefListResponse();
    }

    /**
     * Create an instance of {@link GetProducerIdResponse }
     * 
     */
    public GetProducerIdResponse createGetProducerIdResponse() {
        return new GetProducerIdResponse();
    }

    /**
     * Create an instance of {@link GetFilteredProducerCrossRefList }
     * 
     */
    public GetFilteredProducerCrossRefList createGetFilteredProducerCrossRefList() {
        return new GetFilteredProducerCrossRefList();
    }

    /**
     * Create an instance of {@link GetProducerCrossReference }
     * 
     */
    public GetProducerCrossReference createGetProducerCrossReference() {
        return new GetProducerCrossReference();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/producer_cross_reference_retrieval_prd6x1", name = "SimpleFaultReply")
    public JAXBElement<SimpleFault> createSimpleFaultReply(SimpleFault value) {
        return new JAXBElement<SimpleFault>(_SimpleFaultReply_QNAME, SimpleFault.class, null, value);
    }

}
