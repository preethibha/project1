package com.chubb.dgmk.bob.controller.svlt;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chubb.dgmk.bob.logger.BOBLogger;
import com.chubb.dgmk.bob.util.BOBPropertiesFileDigesterUtil;
import com.chubb.dgmk.bob.util.BOBPropertiesUtil;
import com.chubb.util.Jndi;

/**
 * Servlet implementation class BOBInitializationServlet
 */
public class BOBInitializationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BOBInitializationServlet() {
        super();
    }

    public void init(ServletConfig servletConfig) throws ServletException {

        super.init(servletConfig);
       
        //load JNDI values into the BOBPropertiesUtil
        loadJNDIProperties();
        
        try {
        	//Load bobproperties.xml file into BOBPropertiesUtil
        	loadBOBPropertiesFile();

        	BOBLogger.logInfo("BOB Properties are loaded successfully", this.getClass().getName(), "init");

        } 
        catch (Exception e) {
        	BOBLogger.logWarning("Init Failed ! " + e.getMessage() + " " + BOBPropertiesUtil.getFailureNotification(), this.getClass().getName(), "init");
            throw new UnavailableException(e.getMessage());
        }
        BOBLogger.logInfo("BOB is initialized and open for business" + " " + BOBPropertiesUtil.getFailureNotification(), this.getClass().getName(), "init");
        return;
    }
    
    
    /**
	 *  Load in the JNID properties from the server 
	 */
	private void loadJNDIProperties(){
		
		String env = Jndi.getChubbLevel();
        
		BOBLogger.logInfo("loadJNDIProperties Entry", this.getClass().getName(), "loadJNDIProperties");

        BOBPropertiesUtil.setChubbAppWorkspaceRoot(Jndi.getChubbAppWorkspaceRoot());
        BOBLogger.logInfo("ChubbAppWorkspaceRoot set to : "+Jndi.getChubbAppWorkspaceRoot(), "BOBInitializationServlet", "loadJNDIProperties");
        
        BOBPropertiesUtil.setChubbNodeInstanceName(Jndi.getChubbNodeInstance());
        BOBLogger.logInfo("ChubbNodeInstanceName set to : "+Jndi.getChubbNodeInstance(), "BOBInitializationServlet", "loadJNDIProperties");
        
        BOBPropertiesUtil.setEnvironment(env);
        BOBLogger.logInfo("ChubbLevel (environment) set to : "+ env, "BOBInitializationServlet", "loadJNDIProperties");
        
        BOBPropertiesUtil.setChubbServer(Jndi.getChubbServer());
        BOBLogger.logInfo("ChubbServer set to : "+Jndi.getChubbServer(), "BOBInitializationServlet", "loadJNDIProperties");
        
        BOBPropertiesUtil.setChubbMailServer(Jndi.getChubbMailServer());
        BOBLogger.logInfo("ChubbMailServer set to : "+Jndi.getChubbMailServer(), "BOBInitializationServlet", "loadJNDIProperties");
 
        BOBLogger.logInfo("loadJNDIProperties Exit", "BOBInitializationServlet", "loadJNDIProperties");
        
        return;
    }
	
    /**
	 * Load the CommercialBookOfBusiness properties file from the described JNDI location
	 * Throw an exception if the file is not present or cannot be read
	 * @throws Exception
	 */
	private void loadBOBPropertiesFile() throws Exception {

		//Load the BOB Application Level properties.
		URL url = null;
        String[] args = new String[3];
		try {
			Properties properties = new Properties();
			properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
								   "com.ibm.ws.naming.util.WsnInitCtxFactory");
			Context jndiContext = new InitialContext(properties);
			url = (URL)jndiContext.lookup("url/bobproperties");
			BOBLogger.logInfo("BOB Properties URL: " + url.toString(), this.getClass().getName(), "loadBOBPropertiesFile");

            args[0] = url.getPath();
            args[1] = url.getFile();
            args[2] = BOBPropertiesUtil.getEnvironment();
	        
	        InputStream is = url.openStream();
        	
        	
			BOBPropertiesFileDigesterUtil.loadXMLProperties(args, is);
		} catch (Exception e) {
			BOBLogger.logSevere("Unable to load BOB properties: " + url.toString() + " in " + args[0] + " environment", this.getClass().getName(), "loadBOBPropertiesFile");
			throw new Exception(e);
		}
		BOBLogger.logInfo("BOB properties initialized from: " + url, this.getClass().getName(), "loadBOBPropertiesFile");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
