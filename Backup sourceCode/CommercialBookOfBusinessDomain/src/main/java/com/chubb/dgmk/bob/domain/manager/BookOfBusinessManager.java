package com.chubb.dgmk.bob.domain.manager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.chubb.dgmk.bob.logger.BOBLogger;
import com.chubb.dgmk.bob.util.BOBPropertiesUtil;
import com.chubb.dgmk.bob.util.IBOBConstants;
import ei.core.source_system_data.SourceSystemData;
import ei.producer.producer_identifierx1.ProducerIdentifier;
import ei.reporting.generate_book_of_business_report_request_rpt3x1.GenerateBookOfBusinessReportRequest;
import ei.reporting.generate_book_of_business_report_request_rpt3x1.ObjectFactory;

public class BookOfBusinessManager{
	
	public byte[] byteArray = null;
	
	/**
	 * <pre>
	 * processBookOfBusinessRequest
	 * 
	 * Aug 07, 2015
	 * 
	 * The request is logged to the application log file.  Request the
	 * book of business from the provider and generate an email upon
	 * completion.
	 * If an error is returned while sending the book of business data an Error Email is sent to the user
	 * 
	 * @param producerNumber
	 * @param producerSubNumber
	 * @param reportFormat
	 * @param emailAddress
	 * </pre>
	 */
	public void processBookOfBusinessRequest(String producerNumber,
			String producerSubNumber, String reportFormat, String emailAddress) {

		String errorMessage = sendBookOfBusinessRequest(producerNumber,
				producerSubNumber, reportFormat, emailAddress);
		if (errorMessage != null)
			sendErrorEmail(producerNumber, producerSubNumber, errorMessage, emailAddress);

	}
	
	/**
	 * <pre>
	 * sendBookOfBusinessRequest
	 * 
	 * June 11, 2015
	 * 
	 * Request the book of business from the provider and wait for the
	 * response.  Upon successful completion, send an email to the 
	 * requested emailAddress.  If an error occurs send an email to the
	 * Support Mailbox.
	 * 
	 * @param producerNumber
	 * @param producerSubNumber
	 * @param reportFormat
	 * @param emailAddress
	 * @return null on Success, Error Message on Failure
	 * </pre>
	 */ 
	public String sendBookOfBusinessRequest(String producerNumber,
			String producerSubNumber, String reportFormat, String emailAddress) {
		
		BOBLogger.logInfo("Inside BookOfBusinessManager class" + ":", 
				"BookOfBusinessManager", "sendBookOfBusinessRequest");
		
		String jmsMessageID = "";
		String errorMessage = null;
		
		try { 
			GenerateBookOfBusinessReportRequest generateBookOfBusinessReportRequest = buildRequest(producerNumber,producerSubNumber,reportFormat, emailAddress);
			
			QueueRequestorImpl msgRequestor = new QueueRequestorImpl(BOBPropertiesUtil.getSendDestination(), BOBPropertiesUtil.getReceiveDestination() , BOBPropertiesUtil.getTargetService());
			//QueueRequestorImpl msgRequestor = new QueueRequestorImpl("jms/requestQ_BookOfBusinessProcessor", null , "GenerateBookOfBusiness");
			BOBLogger.logInfo("BookOfBusinessSendDestination queue :" + 
					BOBPropertiesUtil.getSendDestination() + ":", 
					"BookOfBusinessManager", "sendBookOfBusinessRequest");
			String serializedRequest = serializeRequest(generateBookOfBusinessReportRequest);
			jmsMessageID = msgRequestor.sendMessage(serializedRequest);
			BOBLogger.logInfo("JMSId returned from sendMessage method is :" + jmsMessageID + ":", 
					"BookOfBusinessManager", "sendBookOfBusinessRequest");
			
		} catch (Exception e) {
			BOBLogger.logSevere("Exception occurred processing the sendBookOfBusinessRequest process: " + e.getMessage(), "BookOfBusinessManager", "sendBookOfBusinessRequest");
			errorMessage = "Exception occurred processing the sendBookOfBusinessRequest process";
		}
		
		return errorMessage;
	}

	/**
	 * <pre>
	 * buildRequest
	 * 
	 * May 21, 2015 
	 * 
	 * Create instance of GenerateBookOfBusinessReportRequest
	 * @return the GenerateBookOfBusinessReportRequest Object
	 * @throws Exception 
	 * </pre>
	 */
	
	private GenerateBookOfBusinessReportRequest buildRequest(String producerNumber,
			String producerSubNumber, String reportFormat, String emailAddress) throws Exception {
	
		ProducerIdentifier producer = new ProducerIdentifier();
		GenerateBookOfBusinessReportRequest request = new ObjectFactory().createGenerateBookOfBusinessReportRequest();
		producer.setProducerNumber(producerNumber);
		producer.setProducerSubNumber(producerSubNumber);
		request.getProducerIdentifier().add(producer);
		request.setTargetDocumentFormatCode(reportFormat);
		request.setUserId(IBOBConstants.USER_ID);
		request.setSystemId(IBOBConstants.SOURCE_SYSTEM_ID);
		request.setTargetDocumentReturnTypeCode(IBOBConstants.TARGET_DOCUMENT_RETURN_TYPE_CODE);
		request.setTemplateName(IBOBConstants.TEMPLETE_NAME);
		
		request.getSourceSystemData().add(new SourceSystemData());
		request.getSourceSystemData().get(0).setSourceSystemDataName("EmailAddress");
		request.getSourceSystemData().get(0).setSourceSystemDataValue(emailAddress);
		
		return request;
	}
	
	/**
	 * <pre>
	 * serializeRequest
	 * 
	 * June 11, 2015
	 * 
	 * Marshal the object to a string 
	 * 
	 * @param request
	 * @return A string representation of the service request object
	 * </pre>
	 */
	private String serializeRequest(GenerateBookOfBusinessReportRequest request) throws JAXBException,Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JAXBContext jaxbContext;
		String requestAsString=null;
		try {
			jaxbContext = JAXBContext.newInstance(GenerateBookOfBusinessReportRequest.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
			ObjectFactory factory = new ObjectFactory();
			JAXBElement<GenerateBookOfBusinessReportRequest> req = factory.createGenerateBookOfBusinessReportRequest(request);
			marshaller.marshal(req, baos);
			requestAsString = baos.toString();
		} catch (JAXBException jaxEx) {
			BOBLogger.logSevere("IO Exception occurred serializing BookOfBusinessRequest : " + jaxEx.getMessage(), "CommercialBookOfBusinessAccessor", "serializeRequest");
			jaxEx.printStackTrace();
			throw jaxEx;
		}  catch (Exception ex) {
			BOBLogger.logSevere("IO Exception occurred serializing BookOfBusinessRequest : " + ex.getMessage(), "CommercialBookOfBusinessAccessor", "serializeRequest");
			ex.printStackTrace();
			throw ex;
		} 
		
		return requestAsString;
	}
	
	/**
	 * <pre>
	 * sendEmail
	 * 
	 * June 10, 2015
	 * 
	 * Format an email with a descriptive message indicating completion of
	 * the requested Book of Business along with input parameters and a link
	 * to the report. 
	 * 
	 * @param producerNumber
	 * @param producerSubNumber
	 * @param emailAddress
	 * </pre>
	 */
	public void sendEmail(String producerNumber, String producerSubNumber,
			String emailAddress, File file) {

		try {

			MimeMessage message = new MimeMessage(createSession());

			// Set the to and from addresses and the subject
			if(!"".equals(IBOBConstants.messageFromAddress)){
				message.setFrom(new InternetAddress(IBOBConstants.messageFromAddress));
			}
			InternetAddress toAddress = null;
			if(emailAddress != null){
				toAddress = new InternetAddress(emailAddress);
			}
			
			//Create Recipient Adddress List
			if (toAddress != null){
				message.setRecipient(Message.RecipientType.TO, toAddress);
			}
			
			message.setSubject(IBOBConstants.messageSubject);

			// Create a new multipart object for the body of the email
			Multipart multipart = new MimeMultipart();

			//Added
			DataSource source = new FileDataSource(file);
			
			// Create a MimeBodyPart and set it with the Excel workbook
			BodyPart messageBodyPart = new MimeBodyPart();  
			messageBodyPart.setHeader("Content-Type", "application/vnd.ms-excel");
		    messageBodyPart.setDataHandler(new DataHandler(source));
		    messageBodyPart.setFileName(IBOBConstants.BOOK_OF_BUSINESS_ATTACHMENT_NAME);
		    
		    // Add the MimeBodyPart to the multipart object
		    multipart.addBodyPart(messageBodyPart,0);
			//End
		    
		    // Create a MimeBodyPart and set it with the email text
			MimeBodyPart bodyText = new MimeBodyPart();
			bodyText.setContent(IBOBConstants.messageText, "text/html; charset=utf-8");
			multipart.addBodyPart(bodyText,1);

			// Set the message with the multipart contents
			message.setContent(multipart);

			// Send the email
			Transport.send(message);
		} catch (Exception e) {

			BOBLogger.logSevere(
					"Exception occurred While sending email : "
							+ e.getMessage(), "BookOfBusinessManager",
					"sendEmail");
			e.printStackTrace();
		}

	}

	/**
	 * <pre>
	 * sendErrorEmail
	 * 
	 * June 10, 2015
	 * 
	 * Format an email with a descriptive message indicating failure to 
	 * generate the requested Book of Business along with input parameters 
	 * and the error that occurred.  Send the message to the IT Support Mailbox
	 * defined in the properties file.
	 * 
	 * @param producerNumber
	 * @param producerSubNumber
	 * @param errorMessage
	 * </pre>
	 */
	public void sendErrorEmail(String producerNumber, String producerSubNumber,
			String errorMessage, String emailAddress) {

		try {

			MimeMessage message = new MimeMessage(createSession());

			// Set the to and from addresses and the subject
			if(!"".equals(IBOBConstants.messageFromAddress)){
				message.setFrom(new InternetAddress(IBOBConstants.messageFromAddress));
			}
			InternetAddress toAddress = null;
			if(emailAddress != null){
				toAddress = new InternetAddress(emailAddress);
			}
			
			//Create Recipient Adddress List
			if (toAddress != null){
				message.setRecipient(Message.RecipientType.TO, toAddress);
			}
			message.setSubject(IBOBConstants.errorMessageSubject);

			// Create a new multipart object for the body of the email
			Multipart multipart = new MimeMultipart();

			// Create a MimeBodyPart and set it with the email text
			MimeBodyPart bodyText = new MimeBodyPart();
			bodyText.setContent(IBOBConstants.errorMessageText, "text/html; charset=utf-8");
			
			// Add the MimeBodyPart to the multipart object
			multipart.addBodyPart(bodyText);

			// Set the message with the multipart contents
			message.setContent(multipart);

			// Send the email
			Transport.send(message);
		} catch (Exception e) {
			BOBLogger.logSevere(
					"Exception occurred While sending email : "
							+ e.getMessage(), "BookOfBusinessManager",
					"sendEmail");
			e.printStackTrace();
		}

	}

	/**
	 * <pre>
	 * createSession
	 * June 10, 2015
	 * 
	 * This method creates a new Java Mail Session this instance.
	 *     
	 *  - Create a session by calling Session's getDefaultInstance method
	 *    passing in properties and null
	 *    
	 *  - Set your session property to the Session instance just created
	 * 
	 * </pre>
	 */
	private Session createSession() {

		Properties properties = new Properties();
		properties.put("mail.smtp.host", IBOBConstants.mailServer);
		properties.put("mail.smtp.port", IBOBConstants.mailPort);

		return Session.getDefaultInstance(properties, null);

	}

}
