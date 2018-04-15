package com.chubb.dgmk.caf.util;

public interface ICAFConstants {
	
	//Logging
	public static String CAF_APPLICATION_LOG_PATH = "/CommercialAccountFileApp/logs/";
	public static String CAF_APPLICATION_LOG_FILE = "CommercialAccountFile.log";
	
	//Messaging
	public static String CAF_JMS_MQ_CONNFAC = "jms/MQCF";
	public static int TIME_TO_WAIT = 30000;
	public static String TFN_BOB = "GenerateBookOfBusiness";
	
	//Error Messages
	public static String BOB_SUBMITREQUEST_ERROR_MSG = "An exception occurred on the request to generate a Book Of Business Report.  Please contact the Help Desk.";
	
	//CAFFilter constants
	public static int PRODUCER_KEY_MAX_LENGTH  = 12;
	public static int PRODUCER_NUMBER_END_LENGTH  = 7;
	
	//User Type constants
	public static String AGENT  = "UTAGNT";
	public static String EMPLOYEE  = "CHBEMP";
	public static String CUSTOMER  = "Customer";
	public static String LEGAL_ENTITY_INSURED_TYPE_CODE  = "L";
	
	public static String SOURCE_SYSTEM_ID = "M3"; 
	public static String USER_ID = "ITCMACP"; 
	
	public static String CONTACT_TYPE_ABBR_UND = "UND"; //Contact Type Abbreviation
	public static String ADDITIONAL_OPTIONS_TEXT_ALL_NAMES = "AllNames"; 
	public static String ADDITIONAL_OPTIONS_TEXT_WMU_POLICY= "WMU POLICY ENRICHMENT"; 
	public static String DEFAULT_ROLE = "Underwriter";
	public static String DATA_SOURCE_OPTIONS_TEXT_DIGITAL = "Digital";

	public static String TELEPHONE = "TELEPHONE";
	public static String MOBILE_PHONE = "MOBILE PHONE";
	
	public static String LOCAL_ENV = "local";
	public static String CONTACT_UNDERWRITER_ASSISTANT = "UA"; //Underwriter Assistant 
	public static String CONTACT_ACCOUNT_SERVICE_REPRESENTATIVE = "ASR"; //Account Service Representative 
	
	
	public static String ICC_AGENT  = "Agent";
	public static String ICC_EMPLOYEE  = "Employee";
	
	public static String BOB_REPORT_FORMAT  = "EXCEL";
	public static String WMU_BRANCH_PROPERTY_URL  = "url/wmubranches";
	public static String CAF_PROPERTY_URL  = "url/cafproperties";
	public static String USA_COUNTRY_CODE  = "8A";
	public static String COUNTRY_CACHE_KEY  = "countryData";
	public static int TIME_TO_LIVE  = 1440;
	
	public static String RENEWL_PENDING_KEY="0190";//Renewal Pending
	public static String RENEWL_PENDING_VAL="Renewal Pending";
	
	public static String WRITTEN_KEY="0160";//Written
	public static String WRITTEN_VAL="In-Force";
	
	public static String SUBMISSION_KEY="0150";//Submission
	public static String SUBMISSION_VAL="Submission Pending";
	
	public static String CANCELLED_KEY="0010";//Cancelled
	public static String CANCELLED_VAL="Cancelled";
	
	public static String REJECTED_KEY="0130";//Q/Rejected
	public static String REJECTED_VAL="Quote Rejected";
	
	public static String DECLINED_KEY="0060";//Declined
	public static String DECLINED_VAL="Declined";
	
	public static String WRITTEN_DNR_KEY="0180";//WRITTEN DNR
	public static String WRITTEN_DNR_VAL="Non-Renewed";
	
	public static String REINSTATE_KEY="0140";//Reinstate
	public static String REINSTATE_VAL="Reinstate";
	
	public static String OFFERED_KEY="0120";//Q/Offered
	public static String OFFERED_VAL="Quote Offered";
	
	public static String POLICY_EXPIRED_STATUS="Expired";
	
	public static String DATA_SOURCE_OPTIONS_TEXT_GET_ACCESS_ONLY = "GetAccessOnly";
	public static String EMAIL_ADDRESS_STRING  = "E-MAIL ADDRESS";
	public static String PRODUCER_SUB_PRODUCER_KEYS  = "ProducerSubProducerKey";
	
}
