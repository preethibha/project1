package com.chubb.dgmk.bob.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.chubb.dgmk.bob.logger.BOBLogger;


public class BOBPropertiesFileDigesterUtil implements IBOBConstants {
	private static BOBLogger logger = BOBLogger.getLogger();
	 
    /**
     *  Default constructor
     */
    public BOBPropertiesFileDigesterUtil() {

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

        logger.log(Level.FINE, "loadXMLProperties entered", "BOBPropertiesFileDigesterUtil", "loadXMLProperties");
        
        //Check to make sure the properties directory has been provided.
        if (args[0] == null || args[1] == null)
            throw new IOException("No URL for Propertied File Specified.");

        //Check to make sure the environment parameter has been provided.
        if (args[2] == null)
            throw new IOException("No environment parameter specified.");

        //Set properties file path.
        setPropertiesFilePath(args[0]);

        //Instantiate Digester, disable XML validation and name space awareness
        Digester digester = new Digester();
        digester.setValidating(false);
        digester.setNamespaceAware(false);

        //Instantiate BOBPropertiesFileDigesterUtil class
        digester.addObjectCreate("properties", BOBPropertiesFileDigesterUtil.class);

        //Add setters for all the BOBPropertiesFileDigesterUtil properties
        
        //added setter for applicationName
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/applicationName", "applicationName");
        //added setter for subsystem
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/subsystem", "subsystem");
      //added setter for failureNotification
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/failureNotification", "failureNotification");
        //added setter for targetService
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/targetService", "targetService");
        //added setter for jmsConfigJndi
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/jmsConfigJndi", "jmsConfigJndi");
        //added setter for receiveDestination
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/receiveDestination", "receiveDestination");
        //added setter for sendDestination
        digester.addBeanPropertySetter("properties/" + args[2] + "/app/sendDestination", "sendDestination");
        
        //parse the properties XML file.
        try {
        	digester.parse(is);
        } catch (SAXException e) {

            logger.log(Level.WARNING, "Unable to load required configuration file ", "BOBPropertiesFileDigesterUtil", "loadXMLProperties normal exit");
            throw new SAXException("Unable to load required configuration file " + args[0] + args[1] + " during the load of the Corgi application properties.  " + e.toString());
        }

        logger.log(Level.FINE, "loadXMLProperties Exit", "BOBPropertiesFileDigesterUtil", "loadXMLProperties normal exit");
        return;
    }
    
     
    /**
     * Set the value of propertiesFilePath
     * 
     * @param newPropertiesFilePath
     *            java.lang.String
     */
    public static void setPropertiesFilePath(String newPropertiesFilePath) {

        BOBPropertiesUtil.setPropertiesFilePath(newPropertiesFilePath);
    }
    
    /**
     * Set the value of applicationName 
     * 
      * 
     * @param newApplicationName
     *            java.lang.String
     */
    public void setApplicationName(String newApplicationName) {

    	BOBPropertiesUtil.setApplicationName(newApplicationName);
    }
    
    /**
     * Set the value of subsystem 
     * 
      * 
     * @param newSubsystem
     *            java.lang.String
     */
    public void setSubsystem(String newSubsystem) {

    	BOBPropertiesUtil.setSubsystem(newSubsystem);
    }
    
    /**
     * Set the value of failureNotification 
     * 
     * 
     * @param newSubsystem
     *            java.lang.String
     */
    public void setFailureNotification(String newFailureNotification) {

    	BOBPropertiesUtil.setFailureNotification(newFailureNotification);
    }
    
    /**
     * Set the value of targetService 
     * 
      * 
     * @param newTargetService
     *            java.lang.String
     */
    public void setTargetService(String newTargetService) {

    	BOBPropertiesUtil.setTargetService(newTargetService);
    }
    
    /**
     * Set the value of jmsConfigJndi 
     * 
      * 
     * @param newJmsConfigJndi
     *            java.lang.String
     */
    public void setJmsConfigJndi(String newJmsConfigJndi) {

    	BOBPropertiesUtil.setJmsConfigJndi(newJmsConfigJndi);
    }
    
    /**
     * Set the value of receiveDestination 
     * 
      * 
     * @param newReceiveDestination
     *            java.lang.String
     */
    public void setReceiveDestination(String newReceiveDestination) {

    	BOBPropertiesUtil.setReceiveDestination(newReceiveDestination);
    }
    
    /**
     * Set the value of sendDestination 
     * 
      * 
     * @param newSendDestination
     *            java.lang.String
     */
    public void setSendDestination(String sendDestination) {

    	BOBPropertiesUtil.setSendDestination(sendDestination);
    }
 }