package com.chubb.dgmk.caf.util;

import java.util.ArrayList;
import java.util.Properties;

public class CAFPropertiesUtil {

    //Environment Settings
    private static String environment;
    
    //Miscellaneous Settings and Properties
    private static String propertiesFilePath;
    private static String nodeInstanceNameLookupString; // JNDI value for
                                                // chubbNodeInstance
    private static String chubbNodeInstanceName;
    private static String chubbAppWorkspaceRoot;
    private static String realPath;
    private static String chubbServer;
    
    private static String applicationName;   
    private static String subsystem;
    private static String failureNotification;
    
    //Endpoints Settings
    private static String countryRetrievalEndpoint;
    private static String branchRetrievalEndpoint;
    private static String productRetrievalEndpoint;
    private static String bookOfBusinessSendEndpoint;
    private static String producerRetrievalEndpoint;
    private static String policyRetrievalEndpoint;
    private static String accountRetrievalEndpoint;
    private static String contactRetrievalEndpoint;
    private static String defaultUnderwriterRetrievalEndpoint;
       
    private static String chubbMailServer;
    private static ArrayList<String> branches;
    private static ArrayList<String> countries;
    
    private static String producer2X6RetrievalEndpoint;
    private static String userProfileRetrievalEndpoint;
    
    public CAFPropertiesUtil() {

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
        properties.setProperty("subsystem", getSubsystem());
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
     * getSubsystem()
     * <p>
     * Return the value of subsystem.
     * <p>
     * 
     * @return subsystem String
     * 
     */
    public static String getSubsystem() {

        return subsystem;
    }


    /**
     * setSubsystem(String newSubsystem)
     * <p>
     * Set the value of subsystem to newSubsystem.
     * <p>
     * 
     * @param newSubsystem
     *            String
     */
    public static void setSubsystem(String newSubsystem) {

        subsystem = newSubsystem;
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
     * Jan 13, 2005 String getNodeInstanceNameLookupString
     * <p>
     * @return
     */
    public static String getNodeInstanceNameLookupString() {
        
        return nodeInstanceNameLookupString;
    }

    /**
     * setNodeInstanceNameLookupString
     * <p>
     * @param string
     * 
     *  
     */
    public static void setNodeInstanceNameLookupString(String string) {
        
        nodeInstanceNameLookupString = string;
    }

    /**
     * String getChubbNodeInstanceName
     * 
     * @return
     * 
     *  
     */
    public static String getChubbNodeInstanceName() {
        
        return chubbNodeInstanceName;
    }

    /**
     * setChubbNodeInstanceName
     * 
     * @param chubbNodeInstanceName String
     * 
     */
    public static void setChubbNodeInstanceName(String theChubbNodeInstanceName) {
        chubbNodeInstanceName = theChubbNodeInstanceName;
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


    /**
     * chubbAppWorkspaceRoot
     * 
     * @return
     * 
     *  
     */
    public static String getChubbAppWorkspaceRoot() {
        return chubbAppWorkspaceRoot;
    }

    /**
     * setChubbAppWorkspaceRoot
     * 
     * @param string
     * 
     *  
     */
    public static void setChubbAppWorkspaceRoot(String string) {
        chubbAppWorkspaceRoot = string;
    }

    /**
     * 
     * getServerName
     * 
     * @param string
     * 
     * <p>
     * the server name via JNDI
     */
    public static String getChubbServer() {
        return chubbServer;
    }
    
    /**
     * 
     * setServerName
     * 
     * @param string
     * 
     * <p>
     * the server name via JNDI
     */
    public static void setChubbServer(String s) {
        chubbServer = s;
    }

    /**
     * 
     * getApplicationName
     * 
     * return string
     * 
     * <p>
     * 
     */
    
	public static String getApplicationName() {
		return applicationName;
	}

	/**
     * 
     * setApplicationName
     * 
     * @param string
     * 
     * <p>
     * applicationName
     */
    
	public static void setApplicationName(String applicationName) {
		CAFPropertiesUtil.applicationName = applicationName;
	}
	
	/**
     * 
     * getFailureNotification
     * 
     * return string
     * 
     * <p>
     * 
     */
    
	public static String getFailureNotification() {
		return failureNotification;
	}
	
	/**
     * 
     * setFailureNotification
     * 
     * @param string
     * 
     * <p>
     * failureNotification
     */
    
	public static void setFailureNotification(String failureNotification) {
		CAFPropertiesUtil.failureNotification = failureNotification;
	}
	
	/**
     * 
     * setBranchRetrievalEndpoint
     * 
     * @param branchRetrievalEndpoint
     * 
     */
	public static void setBranchRetrievalEndpoint(String branchRetrievalEndpoint) {
		CAFPropertiesUtil.branchRetrievalEndpoint	= branchRetrievalEndpoint;
	}

	/**
	 * @return the countryRetrievalEndpoint
	 */
	public static String getCountryRetrievalEndpoint() {
		return countryRetrievalEndpoint;
	}

	/**
     * 
     * setCountryRetrievalEndpoint
     * 
     * @param countryRetrievalEndpoint
     * 
     */
	public static void setCountryRetrievalEndpoint(String countryRetrievalEndpoint) {
		CAFPropertiesUtil.countryRetrievalEndpoint = countryRetrievalEndpoint;
	}

	/**
	 * @return the branchRetrievalEndpoint
	 */
	public static String getBranchRetrievalEndpoint(){
		return branchRetrievalEndpoint;		
	}
	
	/**
     * 
     * setChubbMailServer
     * 
     * @param chubbMailServer
     * 
     */
	
	public static void setChubbMailServer(String chubbMailServer) {
		CAFPropertiesUtil.chubbMailServer = chubbMailServer;
	}

	/**
	 * @return the chubbMailServer
	 */
	
	public static String getChubbMailServer() {
		return chubbMailServer;
	}
	
	/**
     * 
     * setAccountRetrievalEndpoint
     * 
     * @param accountRetrievalEndpoint
     * 
     */
	
	public static void setAccountRetrievalEndpoint(String accountRetrievalEndpoint) {
		CAFPropertiesUtil.accountRetrievalEndpoint = accountRetrievalEndpoint;
	}

	/**
	 * @return the accountRetrievalEndpoint
	 */
	
	public static String getAccountRetrievalEndpoint() {
		return accountRetrievalEndpoint;
	}
	
	/**
     * 
     * setCommercialPolicyRetrievalEndpoint
     * 
     * @param policyRetrievalEndpoint
     * 
     */

	public static void setCommercialPolicyRetrievalEndpoint(String policyRetrievalEndpoint) {
		CAFPropertiesUtil.policyRetrievalEndpoint = policyRetrievalEndpoint;
	}
	
	/**
	 * @return the policyRetrievalEndpoint
	 */
	public static String getCommercialPolicyRetrievalEndpoint() {
		return policyRetrievalEndpoint;
	}
	
	/**
     * 
     * setContactRetrievalEndpoint
     * 
     * @param contactRetrievalEndpoint
     * 
     */
	
	public static void setContactRetrievalEndpoint(String contactRetrievalEndpoint) {
		CAFPropertiesUtil.contactRetrievalEndpoint = contactRetrievalEndpoint;
	}
	
	/**
	 * @return the contactRetrievalEndpoint
	 */
	public static String getContactRetrievalEndpoint() {
		return contactRetrievalEndpoint;
	}
	
	/**
     * 
     * setProductRetrievalEndpoint
     * 
     * @param productRetrievalEndpoint
     *
     */
	public static void setProductRetrievalEndpoint(String productRetrievalEndpoint) {
		CAFPropertiesUtil.productRetrievalEndpoint	= productRetrievalEndpoint;
	}

	/**
	 * @return the productRetrievalEndpoint
	 */
	public static String getProductRetrievalEndpoint() {
		
		return productRetrievalEndpoint;
	}
	
	/**
     * 
     * setProductRetrievalEndpoint
     * 
     * @param productRetrievalEndpoint
     *
     */
	public static void setProducerRetrievalEndpoint(String producerRetrievalEndpoint) {
		CAFPropertiesUtil.producerRetrievalEndpoint	= producerRetrievalEndpoint;
	}
	
	/**
	 * @return the producerRetrievalEndpoint
	 */
	public static String getProducerRetrievalEndpoint() {
		
		return producerRetrievalEndpoint;
	}
	
	/**
     * 
     * setBookOfBusinessSendEndpoint
     * 
     * @param bookOfBusinessSendEndpoint
     *
     */
	public static void setBookOfBusinessSendEndpoint(String bookOfBusinessSendEndpoint) {
		CAFPropertiesUtil.bookOfBusinessSendEndpoint	= bookOfBusinessSendEndpoint;
	}

	/**
	 * @return the bookOfBusinessSendEndpoint
	 */
	public static String getBookOfBusinessSendEndpoint() {
		return bookOfBusinessSendEndpoint;
	}

	/**
     * 
     * setDefaultUnderwriterRetrievalEndpoint
     * 
     * @param defaultUnderwriterRetrievalEndpoint
     *
     */
	public static void setDefaultUnderwriterRetrievalEndpoint(
			String defaultUnderwriterRetrievalEndpoint) {
		CAFPropertiesUtil.defaultUnderwriterRetrievalEndpoint = defaultUnderwriterRetrievalEndpoint;
	}

	/**
	 * @return the defaultUnderwriterRetrievalEndpoint
	 */
	public static String getDefaultUnderwriterRetrievalEndpoint() {
		return defaultUnderwriterRetrievalEndpoint;
	}
	
	public static String getCommercialCustomerSearchEndpoint() {
		return null;
	}

	
	public static ArrayList<String>  getBranchList(){
		if (branches == null){
			branches = new ArrayList<String>();
		}
		return branches;
	}
	
	public static void addBranchCode(String branchCode) {
		if (!getBranchList().contains(branchCode))
			getBranchList().add(branchCode);
	}
	
	public static ArrayList<String>  getCountryList(){
		if (countries == null){
			countries = new ArrayList<String>();
		}
		return countries;
	}
	
	public static void addCountryCode(String countryCode) {
		if (!getCountryList().contains(countryCode))
			getCountryList().add(countryCode);
	}

	
	public static String getProducer2X6RetrievalEndpoint() {
		return producer2X6RetrievalEndpoint;
	}

	public static void setProducer2X6RetrievalEndpoint(
			String producer2x6RetrievalEndpoint) {
		producer2X6RetrievalEndpoint = producer2x6RetrievalEndpoint;
	}

	public static String getUserProfileRetrievalEndpoint() {
		return userProfileRetrievalEndpoint;
	}

	public static void setUserProfileRetrievalEndpoint(
			String userProfileRetrievalEndpoint) {
		CAFPropertiesUtil.userProfileRetrievalEndpoint = userProfileRetrievalEndpoint;
	}


	
}
