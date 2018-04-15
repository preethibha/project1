package com.chubb.ecom.dgmk.ga.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;


/**
 * IuaPropertiesFileDigesterUtil loads IUA XML properties using the
 * apache commons Digester utility.
 * 
 * @author p627301
 */
public class GAPropertiesFileDigesterUtil {

	/**
     *  Default constructor
     */
    public GAPropertiesFileDigesterUtil() {
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

    	ILogger logger = GAUserProfileLoggerImpl.getLogger();
	  	
        logger.log(Level.FINE, "loadXMLProperties entered", GAPropertiesFileDigesterUtil.class.getName(), "loadXMLProperties");
        
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
        digester.setUseContextClassLoader(true);

        //Instantiate GAPropertiesFileDigesterUtil class
        digester.addObjectCreate("properties", GAPropertiesFileDigesterUtil.class);

        //Add setters for all the GAPropertiesFileDigesterUtil system level properties
        digester.addBeanPropertySetter("properties/system/gaAdminId", "gaAdminId");
        
        // **Added to retrieve SSO fields retrieval **//
		digester.addObjectCreate("properties/system/SsoDomain",
				SsoDomain.class);
		digester.addSetProperties("properties/system/SsoDomain");
		digester.addSetNext("properties/system/SsoDomain",
				"setSsoDomain");
		// **Added to retrieve SSO fields retrieval **//



        //Add setters for all the GAPropertiesFileDigesterUtil properties
//        digester.addBeanPropertySetter("properties/" + args[2] + "/app/userProfileEndpoint", "userProfileEndpoint");
//        digester.addBeanPropertySetter("properties/" + args[2] + "/app/userProfileUpdateEndpoint", "userProfileUpdateEndpoint");
		 digester.addBeanPropertySetter("properties/" + args[2] + "/app/producer6X1RetrievalEndpoint", "producer6X1RetrievalEndpoint");

        //parse the properties XML file.
        try {
        	digester.parse(is);
        } catch (SAXException e) {

            logger.log(Level.WARNING, "Unable to load required configuration file ", GAPropertiesFileDigesterUtil.class.getName(), "loadXMLProperties normal exit");
            throw new SAXException("Unable to load required configuration file " + args[0] + args[1] + " during the load of the GA User Profile application properties.  " + e.toString());
        }

        logger.log(Level.FINE, "loadXMLProperties Exit", GAPropertiesFileDigesterUtil.class.getName(), "loadXMLProperties normal exit");
        return;
    }

    /**
     * Sets the ga admin id.
     *
     * @param gaAdminId the new ga admin id
     */
    public void setGaAdminId(String gaAdminId) {
		GAUserProfilePropertiesUtil.setGaAdminId(gaAdminId);
	}    
    
    /**
     * Sets the properties file path.
     *
     * @param newPropertiesFilePath the new properties file path
     */
    public static void setPropertiesFilePath(String newPropertiesFilePath) {

        GAUserProfilePropertiesUtil.setPropertiesFilePath(newPropertiesFilePath);
    }
 // **Added to retrieve SSO fields retrieval **//
	public void setSsoDomain(SsoDomain domain) {
		
		GAUserProfilePropertiesUtil.addSsoDomain(domain);

	}
	// **Added to retrieve SSO fields retrieval **//
	public  void setProducer6X1RetrievalEndpoint(
			String producer6x1RetrievalEndpoint) {
		GAUserProfilePropertiesUtil.setProducer6X1RetrievalEndpoint(producer6x1RetrievalEndpoint);
	}
 
}