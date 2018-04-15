
package ei.core.error_information;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ei.core.error_information package. 
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

    private final static QName _ErrorInformation_QNAME = new QName("http://ei/core/error_information", "ErrorInformation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ei.core.error_information
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ErrorInformation }
     * 
     */
    public ErrorInformation createErrorInformation() {
        return new ErrorInformation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/error_information", name = "ErrorInformation")
    public JAXBElement<ErrorInformation> createErrorInformation(ErrorInformation value) {
        return new JAXBElement<ErrorInformation>(_ErrorInformation_QNAME, ErrorInformation.class, null, value);
    }

}
