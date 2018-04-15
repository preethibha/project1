
package ei.core.producer_prd2X6_http;

import javax.xml.ws.WebFault;

import ei.core.producer.prd2X6.SimpleFault;

@WebFault(name = "SimpleFaultReply", targetNamespace = "http://ei/producer/producer_retrieval_prd2x6")
public class GetProducer2X6SimpleFaultReplyMsg
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
    public GetProducer2X6SimpleFaultReplyMsg(String message, SimpleFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public GetProducer2X6SimpleFaultReplyMsg(String message, SimpleFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.test.prd2X6.SimpleFault
     */
    public SimpleFault getFaultInfo() {
        return faultInfo;
    }

}
