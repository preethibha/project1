
package ei.producer.get_filtered_producer_cross_ref_list_reply_prd6x1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ei.producer.get_filtered_producer_cross_ref_list_reply_prd6x1 package. 
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

    private final static QName _GetFilteredProducerCrossRefListReply_QNAME = new QName("http://ei/producer/get_filtered_producer_cross_ref_list_reply_prd6x1", "GetFilteredProducerCrossRefListReply");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ei.producer.get_filtered_producer_cross_ref_list_reply_prd6x1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFilteredProducerCrossRefListReply }
     * 
     */
    public GetFilteredProducerCrossRefListReply createGetFilteredProducerCrossRefListReply() {
        return new GetFilteredProducerCrossRefListReply();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilteredProducerCrossRefListReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_filtered_producer_cross_ref_list_reply_prd6x1", name = "GetFilteredProducerCrossRefListReply")
    public JAXBElement<GetFilteredProducerCrossRefListReply> createGetFilteredProducerCrossRefListReply(GetFilteredProducerCrossRefListReply value) {
        return new JAXBElement<GetFilteredProducerCrossRefListReply>(_GetFilteredProducerCrossRefListReply_QNAME, GetFilteredProducerCrossRefListReply.class, null, value);
    }

}
