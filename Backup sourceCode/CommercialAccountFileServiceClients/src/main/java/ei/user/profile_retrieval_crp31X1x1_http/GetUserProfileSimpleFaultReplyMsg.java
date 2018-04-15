
package ei.user.profile_retrieval_crp31X1x1_http;

import javax.xml.ws.WebFault;

import ei.user.profile.SimpleFault;

@WebFault(name = "SimpleFaultReply", targetNamespace = "http://ei/corporate/user_profile_retrieval_crp31x1")
public class GetUserProfileSimpleFaultReplyMsg
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
    public GetUserProfileSimpleFaultReplyMsg(String message, SimpleFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public GetUserProfileSimpleFaultReplyMsg(String message, SimpleFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.chubb.dgmk.caf.was.accessors.SimpleFault
     */
    public SimpleFault getFaultInfo() {
        return faultInfo;
    }

}
