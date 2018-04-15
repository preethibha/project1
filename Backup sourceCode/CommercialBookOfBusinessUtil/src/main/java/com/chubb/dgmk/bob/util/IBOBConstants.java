package com.chubb.dgmk.bob.util;

public interface IBOBConstants {

	//Logging
	public static String BOB_APPLICATION_LOG_PATH = "/CommercialBookOfBusinessApp/logs/";
	public static String BOB_APPLICATION_LOG_FILE = "CommercialBookOfBusiness.log";
	

	//Messaging
	public static int TIME_TO_WAIT = 30000;
	public static String TFN_BOB = "GenerateBookOfBusiness";
	
	//Mail System constants
	public final static String mailServer = "mail.chubb.com";
	public final static String mailPort = "25";
	public final static String mailAttachmentContentType = "application/octet-stream";
	
	//Mail Message constants
	public final static String messageFromAddress = "";
	public final static String messageSubject = "Requested Report: Chubb Book of Business Contact List";
	public final static String messageText = "Attached please find the Chubb Book of Business Contact List you requested."+ "\n" +
											"If you have questions or need further assistance, please contact your Chubb underwriter or our eBusiness Help Desk at 1-877-747-5266 and select option #2 or email ebusinesshelp@chubb.com.";
	
	public final static String errorMessageSubject = "System Error: Chubb Book of Business Contact List";
	public final static String errorMessageText = "Unfortunately, the system was unable to generate the Chubb Book of Business Contact List you requested."+ "\n " +
											"Please contact your Chubb underwriter or our eBusiness Help Desk at 1-877-747-5266 and select option #2 or email ebusinesshelp@chubb.com for assistance." +"\n" +
											"<html><img src=\"https\":\"//static.chubb.com/UXF/atchub/imasges/logo_2x.png\" alt=\"Chubb logo\" /></html>" +
											"This email (which includes any attachments) is intended to be read only by the person(s) to whom it is addressed. " +
											"This email may contain confidential, proprietary information and may be a confidential attorney-client communication, exempt from disclosure under applicable law. " +
											"If you have received this email in error, do not print it, forward it or disseminate or use it or its contents. " +
											"In such event, please notify the sender by return email (or by phone at the number shown above) and delete the email file immediately thereafter. " +
											"Thank you for your cooperation.";
	public final static String messageFileAttachmentName = "";
	
	public static String SOURCE_SYSTEM_ID = "M4"; 
	public static String USER_ID = "ITCMBBP"; 
	public static String TARGET_DOCUMENT_RETURN_TYPE_CODE = "BYTES";
	public static String TEMPLETE_NAME = "Who_Is_My_Underwriter";
	public static String BOOK_OF_BUSINESS_ATTACHMENT_NAME = "BookOfBusinessData.xls";	
		
}