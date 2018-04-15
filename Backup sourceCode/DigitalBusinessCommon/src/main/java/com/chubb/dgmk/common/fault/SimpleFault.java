/**
 * 
 */
package com.chubb.dgmk.common.fault;

import java.io.Serializable;

/**
 * @author NPGM62V
 *
 */
public class SimpleFault 
	implements Serializable
{

    protected String faultMessageText;
    
    public String getFaultMessageText() {
        return faultMessageText;
    }
    public void setFaultMessageText(String value) {
        this.faultMessageText = value;
    }

}