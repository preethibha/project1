//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.reporting.generate_book_of_business_report_reply_rpt3x1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ei.reporting.generate_book_of_business_report_reply_rpt3x1 package. 
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

    private final static QName _GenerateBookOfBusinessReportReply_QNAME = new QName("http://ei/reporting/generate_book_of_business_report_reply_rpt3x1", "GenerateBookOfBusinessReportReply");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ei.reporting.generate_book_of_business_report_reply_rpt3x1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenerateBookOfBusinessReportReply }
     * 
     */
    public GenerateBookOfBusinessReportReply createGenerateBookOfBusinessReportReply() {
        return new GenerateBookOfBusinessReportReply();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateBookOfBusinessReportReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/reporting/generate_book_of_business_report_reply_rpt3x1", name = "GenerateBookOfBusinessReportReply")
    public JAXBElement<GenerateBookOfBusinessReportReply> createGenerateBookOfBusinessReportReply(GenerateBookOfBusinessReportReply value) {
        return new JAXBElement<GenerateBookOfBusinessReportReply>(_GenerateBookOfBusinessReportReply_QNAME, GenerateBookOfBusinessReportReply.class, null, value);
    }

}
