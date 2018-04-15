package com.chubb.dgmk.caf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.chubb.dgmk.caf.logger.CAFLogger;


public class CAFPropertiesFileDigesterUtil implements ICAFConstants {
	private static CAFLogger logger = CAFLogger.getLogger();
	
	 
    /**
     *  Default constructor
     */
    public CAFPropertiesFileDigesterUtil() {

        super();
    }

    /**
     * <pre>
     * Configures Digester rules and actions and parses the XML file
     * specified. as the first argument.
     * 
     * 
     * @param propertiesXMLFileName String[0]
     * @param environmentNamepace String[1]
     * </pre>
     */
    public static void loadXMLProperties(String[] args, InputStream is) throws IOException, SAXException {

        logger.log(Level.FINE, "loadXMLProperties entered", "CAFPropertiesFileDigesterUtil", "loadXMLProperties");
        
        //Check to make sure the properties directory has been provided.
        if (args[0] == null || args[1] == null)
            throw new IOException("No URL for Propertied File Specified.");

        //Check to make sure the environment parameter has been provided.
        if (args[2] == null)
            throw new IOException("No environment parameter specified.");

        //Set properties file path.
        setPropertiesFilePath(args[0]);

        //Instantiate Digester, disable XML validation and name space awareness
        Digester digester=null;
        try{
         digester = new Digester();
        }catch(Exception e){
        	System.err.println(e);
        	e.printStackTrace();
        }
        digester.setValidating(false);
        digester.setNamespaceAware(false);

        //Instantiate CJSPropertiesFileDigesterUtil class
        digester.addObjectCreate("properties", CAFPropertiesFileDigesterUtil.class);

        //Add setters for all the CorgiPropertiesFileDigesterUtil system level properties
        digester.addBeanPropertySetter("properties/system/consumerName", "consumerName");

        //Add setters for all the CorgiPropertiesFileDigesterUtil properties
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/applicationName", "applicationName");
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/subsystem", "subsystem");
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/failureNotification", "failureNotification");
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/bookOfBusinessSendEndpoint", "bookOfBusinessSendEndpoint");
        //added setter for productRetrievalEndpoint
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/productRetrievalEndpoint", "productRetrievalEndpoint");
        //added setter for branchRetrievalEndpoint
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/branchRetrievalEndpoint", "branchRetrievalEndpoint");
        //added setter for producerRetrievalEndpoint
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/producerRetrievalEndpoint", "producerRetrievalEndpoint");
        //added setter for accountRetrievalEndpoint
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/customerSearchEndpoint", "customerSearchEndpoint");
        //added setter for policyRetrievalEndpoint
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/policyRetrievalEndpoint", "policyRetrievalEndpoint");
        //added setter for contactRetrievalEndpoint
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/contactRetrievalEndpoint", "contactRetrievalEndpoint");
        //added setter for contactRetrievalEndpoint
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/countryRetrievalEndpoint", "countryRetrievalEndpoint");
        //added setter for producer2X6RetrievalEndpoint
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/producer2X6RetrievalEndpoint", "producer2X6RetrievalEndpoint");
        //added setter for userProfileRetrievalEndpoint
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/userProfileRetrievalEndpoint", "userProfileRetrievalEndpoint");
        
        //parse the properties XML file.
        try {
        	digester.parse(is);
        } catch (SAXException e) {

            logger.log(Level.WARNING, "Unable to load required configuration file ", "CAFPropertiesFileDigesterUtil", "loadXMLProperties failed during parsing.");
            throw new SAXException("Unable to load required configuration file " + args[0] + args[1] + " during the load of the CAF application properties.  " + e.toString());
        }

        logger.log(Level.FINE, "loadXMLProperties Exit", "CAFPropertiesFileDigesterUtil", "loadXMLProperties normal exit");
        return;
    }
    
    /**
     * <pre>
     * loadXMLBranches
     * July 21, 2015
     * 
     * Configures Digester rules and actions and parses the XML file
     * specified as the first argument.
     *  
     * @param args propertiesXMLFileName String[0],@param environmentNamepace String[1]
     * @param is
     * @return
     * 
     * </pre>
     */
    public static void loadXMLBranches(String[] args, InputStream is) throws IOException, SAXException {

        logger.log(Level.FINE, "loadXMLBranches entered", "CAFPropertiesFileDigesterUtil", "loadXMLBranches");
        
        //Check to make sure the properties directory has been provided.
        if (args[0] == null || args[1] == null)
            throw new IOException("No URL for Propertied File Specified.");

        //Set properties file path.
        setPropertiesFilePath(args[0]);

        //Instantiate Digester, disable XML validation and name space awareness
        Digester digester = new Digester();
        digester.setValidating(false);
        digester.setNamespaceAware(false);

        //Instantiate CJSPropertiesFileDigesterUtil class
        digester.addObjectCreate("branches", CAFPropertiesFileDigesterUtil.class);
        
        digester.addBeanPropertySetter("branches/branchCode", "branchCode");
        
        //parse the properties XML file.
        try {
        	digester.parse(is);
        } catch (SAXException e) {

            logger.log(Level.WARNING, "Unable to load required branch configuration file ", "CAFPropertiesFileDigesterUtil", "loadXMLBranches failed during parsing.");
            throw new SAXException("Unable to load required branch configuration file " + args[0] + args[1] + " during the load of the CAF application properties.  " + e.toString());
        }

        logger.log(Level.FINE, "loadXMLBranches Exit", "CAFPropertiesFileDigesterUtil", "loadXMLBranches normal exit");
        return;
    }
    

    
    /**
     * Set the value of propertiesFilePath
     * 
     * @param newPropertiesFilePath
     *            java.lang.String
     */
    public static void setPropertiesFilePath(String newPropertiesFilePath) {

        CAFPropertiesUtil.setPropertiesFilePath(newPropertiesFilePath);
    }
    
    /**
     * Set the value of applicationName 
     * 
      * 
     * @param newApplicationName
     *            java.lang.String
     */
    public void setApplicationName(String newApplicationName) {

    	CAFPropertiesUtil.setApplicationName(newApplicationName);
    }
    
    /**
     * Set the value of applicationName 
     * 
      * 
     * @param newSubsystem
     *            java.lang.String
     */
    public void setSubsystem(String newSubsystem) {

    	CAFPropertiesUtil.setSubsystem(newSubsystem);
    }
 
    /**
     * Set the value of failureNotification 
     * 
     * 
     * @param newSubsystem
     *            java.lang.String
     */
    public void setFailureNotification(String newFailureNotification) {

    	CAFPropertiesUtil.setFailureNotification(newFailureNotification);
    }
    /**
     * Set the value of bookOfBusinessSendEndpoint
     * 
     * @param bookOfBusinessSendEndpoint
     * 				java.lang.String
     */
    public void setBookOfBusinessSendEndpoint(String bookOfBusinessSendEndpoint) {

    	CAFPropertiesUtil.setBookOfBusinessSendEndpoint(bookOfBusinessSendEndpoint);
    }
    
    /**
     * Set the value of productRetrievalEndpoint 
     * 
     * 
     * @param productRetrievalEndpoint
     *            java.lang.String
     */
    public void setProductRetrievalEndpoint(String productRetrievalEndpoint) {

    	CAFPropertiesUtil.setProductRetrievalEndpoint(productRetrievalEndpoint);
    }
    
    /**
     * Set the value of branchRetrievalEndpoint 
     * 
     * 
     * @param branchRetrievalEndpoint
     *            java.lang.String
     */
    public void setBranchRetrievalEndpoint(String branchRetrievalEndpoint) {
    	
		CAFPropertiesUtil.setBranchRetrievalEndpoint(branchRetrievalEndpoint);
	}
    
    /**
     * Set the value of producerRetrievalEndpoint 
     * 
     * 
     * @param producerRetrievalEndpoint
     *            java.lang.String
     */
    public void setProducerRetrievalEndpoint(String producerRetrievalEndpoint) {
    	
		CAFPropertiesUtil.setProducerRetrievalEndpoint(producerRetrievalEndpoint);
	}
    
    /**
     * Set the value of AccountRetrievalEndpoint 
     * 
     * 
     * @param AccountRetrievalEndpoint
     *            java.lang.String
     */
    public void setCustomerSearchEndpoint(String customerSearchEndpoint) {

    	CAFPropertiesUtil.setAccountRetrievalEndpoint(customerSearchEndpoint);
    }

    
    /**
     * Set the value of policyRetrievalEndpoint 
     * 
     * 
     * @param policyRetrievalEndpoint
     *            java.lang.String
     */
    public void setPolicyRetrievalEndpoint(String policyRetrievalEndpoint) {

    	CAFPropertiesUtil.setCommercialPolicyRetrievalEndpoint(policyRetrievalEndpoint);
    }
    
    /**
     * Set the value of contactRetrievalEndpoint 
     * 
     * 
     * @param contactRetrievalEndpoint
     *            java.lang.String
     */
    public void setContactRetrievalEndpoint(String contactRetrievalEndpoint) {

    	CAFPropertiesUtil.setContactRetrievalEndpoint(contactRetrievalEndpoint);
    }
    
    /**
     * Set the value of countryRetrievalEndpoint 
     * 
     * 
     * @param countryRetrievalEndpoint
     *            java.lang.String
     */
    public void setCountryRetrievalEndpoint(String countryRetrievalEndpoint) {

    	CAFPropertiesUtil.setCountryRetrievalEndpoint(countryRetrievalEndpoint);
    }

    /**
     * Set the value of setDefaultUnderwriterRetrievalEndpoint 
     * 
     * 
     * @param contactRetrievalEndpoint
     *            java.lang.String
     *  End point for contactRetrieval and DefaultUnderwriterRetrieval are same as they hit the same web service        
     */
    public void setDefaultUnderwriterRetrievalEndpoint(String contactRetrievalEndpoint) {

    	CAFPropertiesUtil.setDefaultUnderwriterRetrievalEndpoint(contactRetrievalEndpoint);
    }
    
    public void setBranchCode(String branchCode){
    	CAFPropertiesUtil.addBranchCode(branchCode);
    }
    
   /* public void setProducer2X6RetrievalEndpoint(String producer2x6RetrievalEndpoint) {
		CAFPropertiesUtil.setProducer2X6RetrievalEndpoint(producer2x6RetrievalEndpoint);
	}

	public void setUserProfileRetrievalEndpoint(String userProfileRetrievalEndpoint) {
		CAFPropertiesUtil.setUserProfileRetrievalEndpoint(userProfileRetrievalEndpoint);
	}*/

}