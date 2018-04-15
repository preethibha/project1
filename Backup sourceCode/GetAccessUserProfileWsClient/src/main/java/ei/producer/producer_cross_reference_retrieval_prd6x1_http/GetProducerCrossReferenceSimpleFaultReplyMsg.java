
package ei.producer.producer_cross_reference_retrieval_prd6x1_http;

import javax.xml.ws.WebFault;
import ei.core.simplefault.SimpleFault;

@WebFault(name = "SimpleFaultReply", targetNamespace = "http://ei/producer/producer_cross_reference_retrieval_prd6x1")
public class GetProducerCrossReferenceSimpleFaultReplyMsg
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
    public GetProducerCrossReferenceSimpleFaultReplyMsg(String message, SimpleFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public GetProducerCrossReferenceSimpleFaultReplyMsg(String message, SimpleFault faultInfo, Throwable cause) {
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
