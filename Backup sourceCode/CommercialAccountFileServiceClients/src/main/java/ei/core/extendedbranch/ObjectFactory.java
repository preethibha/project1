//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.core.extendedbranch;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ei.core.extendedbranch package. 
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

    private final static QName _ExtendedBranch_QNAME = new QName("http://ei/core/extendedbranch", "ExtendedBranch");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ei.core.extendedbranch
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExtendedBranch }
     * 
     */
    public ExtendedBranch createExtendedBranch() {
        return new ExtendedBranch();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExtendedBranch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/extendedbranch", name = "ExtendedBranch")
    public JAXBElement<ExtendedBranch> createExtendedBranch(ExtendedBranch value) {
        return new JAXBElement<ExtendedBranch>(_ExtendedBranch_QNAME, ExtendedBranch.class, null, value);
    }

}
