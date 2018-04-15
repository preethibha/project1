package com.chubb.dgmk.caf.controller.svlt;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pagecode.bean.CAFBean;

import com.chubb.dgmk.caf.domain.manager.ContactChubbDomainManager;
import com.chubb.dgmk.caf.domain.model.UserInformation;
import com.chubb.dgmk.caf.domain.resource.ProducerKey;
import com.chubb.dgmk.caf.domain.resource.ResourceRequestResult;
import com.chubb.dgmk.caf.domain.resource.UserResource;
import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.CAFPropertiesFileDigesterUtil;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;
import com.chubb.util.Jndi;

/**
 * <pre>
 * CAFInitializationServlet
 * Mar 11, 2015
 * 
 * Servlet implementation class CAFInitializationServlet
 * Responsibilities of this class are to read in JNDI environment
 * variable and corresponding properties.
 * 
 * </pre>
 */
public class CAFInitializationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CAFInitializationServlet() {
		super();

	}

	public void init(ServletConfig servletConfig) throws ServletException {

		super.init(servletConfig);

		//load JNDI values into the CAFPropertiesUtil
		loadJNDIProperties();

		//Load lcdproperties.xml file into CAFPropertiesUtil
		try {
			String prefix = getServletContext().getRealPath("/");
			CAFPropertiesUtil.setRealPath(prefix); 

			//Load cafproperties.xml file into CAFPropertiesUtil
			loadCAFPropertiesFile();
			CAFLogger.logInfo("CAF Properties are loaded successfully", this.getClass().getName(), "init");


			//Load cafproperties.xml file into CAFPropertiesUtil
			loadWMUBranchFile();
			CAFLogger.logInfo("WMU Branch Properties are loaded successfully", this.getClass().getName(), "init");
			CAFBean cafBean = new CAFBean();			
			setProfileDataFromCrp31X1(cafBean, null);

		} 
		catch (Exception e) {
			CAFLogger.logWarning("Init Failed ! " + e.getMessage() + " " + CAFPropertiesUtil.getFailureNotification(), this.getClass().getName(), "init");
			throw new UnavailableException(e.getMessage());
		}
		CAFLogger.logInfo("CAF is initialized and open for business" + " " + CAFPropertiesUtil.getFailureNotification(), this.getClass().getName(), "init");
		return;
	}

	/**
	 * <pre>
	 * loadJNDIProperties
	 * Mar 11, 2015
	 * 
	 * This method is used to load the JNID properties from the server
	 * 
	 *  </pre>
	 */
	private void loadJNDIProperties(){

		String env = Jndi.getChubbLevel();

		CAFLogger.logInfo("loadJNDIProperties Entry", this.getClass().getName(), "loadJNDIProperties");

		CAFPropertiesUtil.setChubbAppWorkspaceRoot(Jndi.getChubbAppWorkspaceRoot());
		CAFLogger.logInfo("ChubbAppWorkspaceRoot set to : "+Jndi.getChubbAppWorkspaceRoot(), "CAFInitializationServlet", "loadJNDIProperties");

		CAFPropertiesUtil.setChubbNodeInstanceName(Jndi.getChubbNodeInstance());
		CAFLogger.logInfo("ChubbNodeInstanceName set to : "+Jndi.getChubbNodeInstance(), "CAFInitializationServlet", "loadJNDIProperties");

		CAFPropertiesUtil.setEnvironment(env);
		CAFLogger.logInfo("ChubbLevel (environment) set to : "+ env, "CAFInitializationServlet", "loadJNDIProperties");

		CAFPropertiesUtil.setChubbServer(Jndi.getChubbServer());
		CAFLogger.logInfo("ChubbServer set to : "+Jndi.getChubbServer(), "CAFInitializationServlet", "loadJNDIProperties");

		CAFPropertiesUtil.setChubbMailServer(Jndi.getChubbMailServer());
		CAFLogger.logInfo("ChubbMailServer set to : "+Jndi.getChubbMailServer(), "CAFInitializationServlet", "loadJNDIProperties");

		CAFLogger.logInfo("loadJNDIProperties Exit", "CAFInitializationServlet", "loadJNDIProperties");

		return;
	}

	/**
	 * <pre>
	 * loadCAFPropertiesFile
	 * Mar 11, 2015
	 * 
	 * Load the CommercialAccountFile properties file from the described JNDI location
	 * Throw an exception if the file is not present or cannot be read
	 * @throws Exception
	 * 
	 * </pre>
	 */
	private void loadCAFPropertiesFile() throws Exception {

		//Load the CAF Application Level properties.
		URL url = null;
		String[] args = new String[3];
		try {
			Properties properties = new Properties();
			properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
			"com.ibm.ws.naming.util.WsnInitCtxFactory");
			Context jndiContext = new InitialContext(properties);
			url = (URL)jndiContext.lookup("url/cafproperties");
			CAFLogger.logInfo("CAF Properties URL: " + url.toString(), this.getClass().getName(), "loadCAFPropertiesFile");

			args[0] = url.getPath();
			args[1] = url.getFile();
			args[2] = CAFPropertiesUtil.getEnvironment();

			InputStream is = url.openStream();


			CAFPropertiesFileDigesterUtil.loadXMLProperties(args, is);
		} catch (Exception e) {
			CAFLogger.logSevere("Unable to load CAF properties: " + url.toString() + " in " + args[0] + " environment", this.getClass().getName(), "loadCAFPropertiesFile");
			throw new Exception(e);
		}
		CAFLogger.logInfo("CAF properties initialized from: " + url, this.getClass().getName(), "loadCAFPropertiesFile");
		
	}

	/**
	 * <pre>
	 * loadWMUBranchFile
	 * July 21, 2015
	 * 
	 * Load the CommercialAccountFile properties file from the described JNDI location
	 * Throw an exception if the file is not present or cannot be read
	 * 
	 * @throws Exception
	 * 
	 * </pre>
	 */
	private void loadWMUBranchFile() throws Exception {

		/*
		 * Load the WMU Branch configuration file.  Only branches with codes matching those 
		 * in the wmubranches file should appear in the list of branches on the  Contact Chubb
		 * page
		 */

		URL url = null;
		String[] args = new String[3];
		try {
			Properties properties = new Properties();
			properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
			"com.ibm.ws.naming.util.WsnInitCtxFactory");
			Context jndiContext = new InitialContext(properties);
			url = (URL)jndiContext.lookup("url/wmubranches");
			CAFLogger.logInfo("WMU Branch Properties URL: " + url.toString(), this.getClass().getName(), "loadWMUBranchFile");

			args[0] = url.getPath();
			args[1] = url.getFile();

			InputStream is = url.openStream();


			CAFPropertiesFileDigesterUtil.loadXMLBranches(args, is);
		} catch (Exception e) {
			CAFLogger.logSevere("Unable to load WMU Branch properties: " + url.toString() + " in " + args[0] , this.getClass().getName(), "loadWMUBranchFile");
			throw new Exception(e);
		}
		CAFLogger.logInfo("WMU Branch properties initialized from: " + url, this.getClass().getName(), "loadWMUBranchFile");
		CAFLogger.logInfo("WMU Branch list contains " + CAFPropertiesUtil.getBranchList().size() + " items.", this.getClass().getName(), "loadWMUBranchFile");

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
	
	
	/**
	 * @param cafBean
	 * @param request
	 * Set the user type and producer number list from the GetAccess header.
	 * check whether the incoming string has length more than or equal to 12 or not.
	 * If not show the error message, otherwise split the string to get the producer number and sub producer number
	 * First 7 characters are producer numbers and last 5 characters are sub producers
	 * 
	 */
	private void setProfileDataFromCrp31X1(CAFBean cafBean, HttpServletRequest request) {
		UserInformation userInfo=null;
		String envStr=CAFPropertiesUtil.getEnvironment();
		try{
			UserResource userResource= new UserResource();
			String externalUserId=null;
			String userId=null;
			if(null != request){
			userId = request.getParameter("userId");
			externalUserId = request.getParameter("externalUserId");
			}
			//For local testing
			if(null == externalUserId){
				externalUserId="maagt_07";
			}
			userResource.setExternalUserId(externalUserId);
			userResource.setUserId(userId);
			ContactChubbDomainManager mgr = new ContactChubbDomainManager();
			ResourceRequestResult result = mgr.retrieveUserInfo(userResource);
			
			userInfo = result.getUserInformation();

			if(userInfo==null){
				if(ICAFConstants.LOCAL_ENV.equals(envStr)){
					//setProfileDataStub(cafBean, request);
					return;
				}else{
					CAFLogger.logInfo("GA Header info not found for non-local environment: " + envStr, this.getClass().getName(), "setProfileData");
					throw new Exception();
				}
			}
		}catch (Exception e){
			CAFLogger.logWarning("GA Header info not found. Stack trace follows. ", this.getClass().getName(), "setProfileData");
			e.printStackTrace();
			return;
		}
		
		cafBean.setEmailAddress(userInfo.getEmail());
		cafBean.setUserFirstName(userInfo.getGivenName());
		String userType = userInfo.getUserTypeCode();
		String userId = userInfo.getUserid();
		cafBean.setUserType(userType);
		//cafBean.setUserType("CHBEMP");
		cafBean.setUserId(userId);
		//if user is an agent, continue to collect producer numbers; if employee, we're done
		if (!ICAFConstants.AGENT.equalsIgnoreCase(userType)){
			return;
		}
		
		//get the full set of producer numbers.  Per Brad, this is the compete set.  Concept of Primary or First is out of date
		List<ProducerKey> prodKeys = new ArrayList<ProducerKey>();
		List<String> producerNumbers = userInfo.getProducerkeys();
		if (null == producerNumbers || producerNumbers.size() == 0){
			CAFLogger.logInfo("User: " + userId + "of type: " +userType + " has no associated Producer Numbers " , this.getClass().getName(),"setProfileData");
			return;
		}
		for (String concatProdNumber:producerNumbers){
			if (concatProdNumber.length() == ICAFConstants.PRODUCER_KEY_MAX_LENGTH){
				prodKeys.add(new ProducerKey(concatProdNumber));
			
			}
			else 
				CAFLogger.logInfo("Producer Numbers of incorrect length found.  Bypassing add of value: " + concatProdNumber, this.getClass().getName(),"setProfileData");
		}
		CAFLogger.logInfo("Associated Producer Numbers : " + Arrays.toString(prodKeys.toArray()) + " found for user: " + userId, this.getClass().getName(),"setProfileData");
		cafBean.setProducerKeys(prodKeys);
		CAFLogger.logInfo("User: " + userId+ " has related ProducerKey size : " + prodKeys.size(), this.getClass().getName(),"setProfileData");
	
	}
}


