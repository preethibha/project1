//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package chubb_corporate.get_access.simple_fault;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the chubb_corporate.get_access.simple_fault package. 
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

    private final static QName _SimpleFault_QNAME = new QName("http://chubb_corporate/get_access/simple_fault", "SimpleFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: chubb_corporate.get_access.simple_fault
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SimpleFault }
     * 
     */
    public SimpleFault createSimpleFault() {
        return new SimpleFault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chubb_corporate/get_access/simple_fault", name = "SimpleFault")
    public JAXBElement<SimpleFault> createSimpleFault(SimpleFault value) {
        return new JAXBElement<SimpleFault>(_SimpleFault_QNAME, SimpleFault.class, null, value);
    }

}
