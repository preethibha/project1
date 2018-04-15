package com.chubb.ecom.dgmk.ga.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Properties;

import com.chubb.ecom.dgmk.ga.util.SsoDomain;;

/**
 * IuaPropertiesUtil
 * <p>
 * This singleton contains all the properties setting for Enterprise User Admin
 * <p>
 * 
 *
 */
public class GAUserProfilePropertiesUtil   {

	//Environment Settings
    private static String environment;
    
    //Miscellaneous Settings and Properties
    private static String propertiesFilePath;
    private static String realPath;
    private static String chubbNodeInstanceName;
    private static String chubbAppWorkspaceRoot;
    private static String chubbServer;  
    private static String producer6X1RetrievalEndpoint;
    //Application Properties
    private static String gaAdminId;
    
 // **Added to retrieve SSO fields retrieval **//
    
    private static List<SsoDomain> ssoDomainList =new ArrayList<SsoDomain>();
    
	  public static void addSsoDomain( SsoDomain ssoDomain) {
		  try {
		  ssoDomainList.add( ssoDomain );
		  }
		  catch (Exception e){
			  e.printStackTrace();
		  }
	   }

	
    
    public static String getGacol(String appName) {
		for(SsoDomain dom:ssoDomainList) {
			if(dom.getValue().equals(appName)) {
				return dom.getGacol();
			}
		}
		return null;
	}
  public static String getDomValue(String col){
    
    	for (SsoDomain dom:ssoDomainList){
    		if (dom.getGacol().equals(col)){
    			
    			return dom.getValue();
    		}
    	}
    	return "";
    }
	
	public static List<String> getAppNames() {
		 List<String> appList = new ArrayList<String>();
		 for(SsoDomain dom:ssoDomainList) {
			 appList.add(dom.getValue());
		 }
		 return appList;
	}
	//**Added to retrieve SSO fields retrieval **//

	
    /**
     * CorgiPropertiesUtil constructor
     */

    public GAUserProfilePropertiesUtil() {

        super();
    }
	
    /**
     * getProperties() 
     * <p>
     * Return a Properties hashtable containing all of the RTF properties.
     * <p>
     * 
     * @return properties Properties
     */
    public static Properties getProperties() {

        Properties properties = new Properties();

        properties.setProperty("propertiesFilePath", getPropertiesFilePath());
        properties.setProperty("environment", getEnvironment());

        return properties;
    }
    

    
    /**
     * getEnvironment() 
     * <p>
     * Return the value of environment.
     * <p>
     * 
     * @return environment String
     */
    public static String getEnvironment() {

        return environment;
    }
    
    /**
     * setEnvironment(String newEnvironment)
     * <p>
     * Set the value of environment to newEnvironment.
     * <p>
     * 
     * @param newEnvironment
     *            String
     */
    public static void setEnvironment(String newEnvironment) {

        environment = newEnvironment;
    }

        
    /**
     * getPropertiesFilePath() Jul 2, 2004
     * <p>
     * Return the value of propertiesFilePath.
     * <p>
     * 
     * @return propertiesFilePath String
     */
    public static String getPropertiesFilePath() {

        return propertiesFilePath;
    }

    /**
     * setPropertiesFilePath(String newPropertiesFilePath)
     * <p>
     * Set the value of propertiesFilePath to newPropertiesFilePath.
     * <p>
     * 
     * @param newPropertiesFilePath String
     */
    public static void setPropertiesFilePath(String newPropertiesFilePath) {

        propertiesFilePath = newPropertiesFilePath;
    }

    /**
     * String getRealPath
     * 
     * @return
     * 
     * Called JAXB Mapper classes
     */
    public static String getRealPath() {
        return realPath;
    }

    /**
     * setRealPath
     * 
     * @param prefix
     * 
     * Called the initialization servlet
     *  
     */
    public static void setRealPath(String prefix) {
        realPath = prefix;

    }
    
    public static void setGaAdminId(String gaAdminId) {
    	GAUserProfilePropertiesUtil.gaAdminId = gaAdminId;
    }
    
    public static String getGaAdminId() {
		return gaAdminId;
	}    

	public static String getChubbNodeInstanceName() {
		return chubbNodeInstanceName;
	}

	public static void setChubbNodeInstanceName(String chubbNodeInstanceName) {
		GAUserProfilePropertiesUtil.chubbNodeInstanceName = chubbNodeInstanceName;
	}

	public static String getChubbAppWorkspaceRoot() {
		return chubbAppWorkspaceRoot;
	}

	public static void setChubbAppWorkspaceRoot(String chubbAppWorkspaceRoot) {
		GAUserProfilePropertiesUtil.chubbAppWorkspaceRoot = chubbAppWorkspaceRoot;
	}

	public static String getChubbServer() {
		return chubbServer;
	}

	public static void setChubbServer(String chubbServer) {
		GAUserProfilePropertiesUtil.chubbServer = chubbServer;
	}



	public static String getProducer6X1RetrievalEndpoint() {
		return producer6X1RetrievalEndpoint;
	}



	public static void setProducer6X1RetrievalEndpoint(
			String producer6x1RetrievalEndpoint) {
		GAUserProfilePropertiesUtil.producer6X1RetrievalEndpoint = producer6x1RetrievalEndpoint;
	}

}