//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.crm.commercial_customer_search_crm4x4_http;

import javax.xml.ws.WebFault;
import ei.core.simplefault.SimpleFault;

@WebFault(name = "SimpleFault", targetNamespace = "http://ei/crm/commercial_customer_search_crm4x4")
public class NameSearchSimpleFaultReplyMsg
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private SimpleFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NameSearchSimpleFaultReplyMsg(String message, SimpleFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param message
     * @param cause
     */
    public NameSearchSimpleFaultReplyMsg(String message, SimpleFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ei.core.simplefault.SimpleFault
     */
    public SimpleFault getFaultInfo() {
        return faultInfo;
    }

}
