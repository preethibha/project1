//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package chubb_corporate.business.get_access_user_profile_management_ebe4x1_http;

import javax.xml.ws.WebFault;
import chubb_corporate.get_access.simple_fault.SimpleFault;

@WebFault(name = "SimpleFaultReply", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1")
public class GetAccessUserProfileSimpleFaultReplyMsg
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
    public GetAccessUserProfileSimpleFaultReplyMsg(String message, SimpleFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param message
     * @param cause
     */
    public GetAccessUserProfileSimpleFaultReplyMsg(String message, SimpleFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: chubb_corporate.get_access.simple_fault.SimpleFault
     */
    public SimpleFault getFaultInfo() {
        return faultInfo;
    }

}
