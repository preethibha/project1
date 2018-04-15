package com.chubb.dgmk.bob.util;

import java.util.Properties;

public class BOBPropertiesUtil {

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

	private static String targetService;   
	private static String jmsConfigJndi;
	private static String receiveDestination;   
	private static String sendDestination;

	private static String chubbMailServer;

	public BOBPropertiesUtil() {
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
	 * getFailureNotification()
	 * <p>
	 * Return the value of failureNotification.
	 * <p>
	 * 
	 * @return failureNotification String
	 * 
	 */
	public static String getFailureNotification() {
		return failureNotification;
	}

	/**
	 * setFailureNotification(String failureNotification)
	 * <p>
	 * Set the value of subsystem to failureNotification.
	 * <p>
	 * 
	 * @param failureNotification
	 *            String
	 */
	public static void setFailureNotification(String failureNotification) {
		BOBPropertiesUtil.failureNotification = failureNotification;
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
	 * getApplicationName() 
	 * <p>
	 * Return the value of applicationName.
	 * <p>
	 * 
	 * @return String
	 */
	public static String getApplicationName() {
		return applicationName;
	}

	/**
	 * setApplicationName(String applicationName)
	 * <p>
	 * Set the value of applicationName.
	 * <p>
	 * 
	 * @param applicationName
	 *            String
	 */
	public static void setApplicationName(String applicationName) {
		BOBPropertiesUtil.applicationName = applicationName;
	}

	/**
	 * getTargetService() 
	 * <p>
	 * Return the value of targetService.
	 * <p>
	 * 
	 * @return String
	 */
	public static String getTargetService() {
		return targetService;
	}

	/**
	 * setTargetService(String targetService)
	 * <p>
	 * Set the value of targetService.
	 * <p>
	 * 
	 * @param targetService
	 *            String
	 */
	public static void setTargetService(String targetService) {
		BOBPropertiesUtil.targetService = targetService;
	}

	/**
	 * getJmsConfigJndi() 
	 * <p>
	 * Return the value of jmsConfigJndi.
	 * <p>
	 * 
	 * @return String
	 */
	public static String getJmsConfigJndi() {
		return jmsConfigJndi;
	}

	/**
	 * setJmsConfigJndi(String jmsConfigJndi)
	 * <p>
	 * Set the value of jmsConfigJndi.
	 * <p>
	 * 
	 * @param jmsConfigJndi
	 *            String
	 */
	public static void setJmsConfigJndi(String jmsConfigJndi) {
		BOBPropertiesUtil.jmsConfigJndi = jmsConfigJndi;
	}

	/**
	 * getReceiveDestination() 
	 * <p>
	 * Return the value of receiveDestination.
	 * <p>
	 * 
	 * @return String
	 */
	public static String getReceiveDestination() {
		return receiveDestination;
	}

	/**
	 * setReceiveDestination(String receiveDestination)
	 * <p>
	 * Set the value of receiveDestination.
	 * <p>
	 * 
	 * @param receiveDestination
	 *            String
	 */
	public static void setReceiveDestination(String receiveDestination) {
		BOBPropertiesUtil.receiveDestination = receiveDestination;
	}

	/**
	 * getSendDestination() 
	 * <p>
	 * Return the value of sendDestination.
	 * <p>
	 * 
	 * @return String
	 */
	public static String getSendDestination() {
		return sendDestination;
	}

	/**
	 * setSendDestination(String sendDestination)
	 * <p>
	 * Set the value of sendDestination.
	 * <p>
	 * 
	 * @param sendDestination
	 *            String
	 */
	public static void setSendDestination(String sendDestination) {
		BOBPropertiesUtil.sendDestination = sendDestination;
	}

	/**
	 * @return the chubbMailServer
	 */

	public static String getChubbMailServer() {
		return chubbMailServer;
	}

	/**
	 * setChubbMailServer(String chubbMailServer)
	 * <p>
	 * Set the value of chubbMailServer.
	 * <p>
	 * 
	 * @param chubbMailServer
	 *            String
	 */
	public static void setChubbMailServer(String chubbMailServer) {
		BOBPropertiesUtil.chubbMailServer = chubbMailServer;
	}
}
