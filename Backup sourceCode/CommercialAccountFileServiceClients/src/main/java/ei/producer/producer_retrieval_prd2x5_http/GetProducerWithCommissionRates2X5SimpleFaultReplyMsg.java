//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.producer.producer_retrieval_prd2x5_http;

import javax.xml.ws.WebFault;
import ei.core.simplefault.SimpleFault;

@WebFault(name = "SimpleFaultReply", targetNamespace = "http://ei/producer/producer_retrieval_prd2x5")
public class GetProducerWithCommissionRates2X5SimpleFaultReplyMsg
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
    public GetProducerWithCommissionRates2X5SimpleFaultReplyMsg(String message, SimpleFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param message
     * @param cause
     */
    public GetProducerWithCommissionRates2X5SimpleFaultReplyMsg(String message, SimpleFault faultInfo, Throwable cause) {
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
