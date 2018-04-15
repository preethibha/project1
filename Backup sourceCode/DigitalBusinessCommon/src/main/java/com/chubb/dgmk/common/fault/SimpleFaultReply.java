/**
 * 
 */
package com.chubb.dgmk.common.fault;

import javax.xml.ws.WebFault;

/**
 * @author NPGM62V
 *
 */
@WebFault(name = "SimpleFaultReply",  targetNamespace = "http://provider.dus.dgmk.chubb.com/")
public class SimpleFaultReply 
    extends Exception {
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
    public SimpleFaultReply(String message, SimpleFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param message
     * @param cause
     */
    public SimpleFaultReply(String message, SimpleFault faultInfo, Throwable cause) {
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
