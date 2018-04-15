//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.reporting.commercial_policy_book_of_business_reporting_rpt3x1_http;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import ei.reporting.generate_book_of_business_report_reply_rpt3x1.GenerateBookOfBusinessReportReply;
import ei.reporting.generate_book_of_business_report_request_rpt3x1.GenerateBookOfBusinessReportRequest;

@WebService(name = "CommercialPolicyBookOfBusinessReportingRPT3X1", targetNamespace = "http://ei/reporting/commercial_policy_book_of_business_reporting_rpt3x1")
@XmlSeeAlso({
    ei.reporting.generate_book_of_business_report_reply_rpt3x1.ObjectFactory.class,
    ei.producer.producer_identifierx1.ObjectFactory.class,
    ei.core.document_url_information.ObjectFactory.class,
    ei.core.file.ObjectFactory.class,
    ei.core.languagex1.ObjectFactory.class,
    ei.core.error_information.ObjectFactory.class,
    ei.core.simplefault.ObjectFactory.class,
    ei.reporting.commercial_policy_book_of_business_reporting_rpt3x1.ObjectFactory.class,
    ei.reporting.generate_book_of_business_report_request_rpt3x1.ObjectFactory.class,
    ei.core.status_informationx2.ObjectFactory.class,
    ei.core.source_system_data.ObjectFactory.class
})
public interface CommercialPolicyBookOfBusinessReportingRPT3X1 {


    /**
     * 
     * @param generateBookOfBusinessReportRequest
     * @return
     *     returns ei.reporting.generate_book_of_business_report_reply_rpt3x1.GenerateBookOfBusinessReportReply
     * @throws GenerateBookOfBusinessReportSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GenerateBookOfBusinessReport", action = "GenerateBookOfBusinessReport")
    @WebResult(name = "GenerateBookOfBusinessReportReply", targetNamespace = "")
    @RequestWrapper(localName = "GenerateBookOfBusinessReport", targetNamespace = "http://ei/reporting/commercial_policy_book_of_business_reporting_rpt3x1", className = "ei.reporting.commercial_policy_book_of_business_reporting_rpt3x1.GenerateBookOfBusinessReport")
    @ResponseWrapper(localName = "GenerateBookOfBusinessReportResponse", targetNamespace = "http://ei/reporting/commercial_policy_book_of_business_reporting_rpt3x1", className = "ei.reporting.commercial_policy_book_of_business_reporting_rpt3x1.GenerateBookOfBusinessReportResponse")
    public GenerateBookOfBusinessReportReply generateBookOfBusinessReport(
        @WebParam(name = "GenerateBookOfBusinessReportRequest", targetNamespace = "")
        GenerateBookOfBusinessReportRequest generateBookOfBusinessReportRequest)
        throws GenerateBookOfBusinessReportSimpleFaultReplyMsg
    ;

}
