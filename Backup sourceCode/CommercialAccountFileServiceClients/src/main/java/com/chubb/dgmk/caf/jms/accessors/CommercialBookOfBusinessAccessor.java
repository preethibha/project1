package com.chubb.dgmk.caf.jms.accessors;

import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;
import com.chubb.dgmk.caf.util.StringUtil;

import dgmk.comlacct.book_of_business_request.BookOfBusinessRequest;
import dgmk.comlacct.book_of_business_request.ObjectFactory;

/**
 * <pre>
 * CommercialBookOfBusinessAccessor
 * May 14, 2015
 * 
 * The CommercialBookOfBusinessAccessor class is responsible for submitting requests
 * to the CommercialBookOfBusiness application via MQ.  
 * </pre> 
 */
public class CommercialBookOfBusinessAccessor implements ICAFConstants {
	
	/**
	 * <pre>
	 * submitBookOfBusinessRequest
	 * 
	 * May 14, 2015
	 * 
	 * Submit a request to the CommercialBookOfBusiness application by putting a message on the request
	 * queue identified by its JDNI name in the properties file.  Log the JMSMessageID on successful reply.
	 * If an exception occurs during the process, pass it back to the caller.
	 * 
	 * @param producerNumber
	 * @param producerSubNumber
	 * @param emailAddress
	 * </pre>
	 */
	public void submitBookOfBusinessRequest(String producerNumber, String producerSubNumber, String emailAddress) throws Exception{
		
		BookOfBusinessRequest request = buildRequest(producerNumber, producerSubNumber, emailAddress);
		String jmsId;
		try { 
			QueueRequestorImpl msgRequestor = new QueueRequestorImpl(CAFPropertiesUtil.getBookOfBusinessSendEndpoint(), null, TFN_BOB);
			CAFLogger.logInfo("BookOfBusinessSendEndpoint :" + 
					CAFPropertiesUtil.getBookOfBusinessSendEndpoint() + ":", 
					"CommercialBookOfBusinessAccessor", "submitBookOfBusinessRequest");
			String serializedRequest = serializeRequest(request);
			jmsId = msgRequestor.sendMessage(serializedRequest);
			
		} catch (Exception e) {
			CAFLogger.logSevere("Exception occurred processing the submitBookOfBusinessRequest process: " + e.getMessage(), "CommercialBookOfBusinessAccessor", "submitBookOfBusinessRequest");
			throw e;
		}
		CAFLogger.logInfo("Successful PUT to BookOfBusiness Request Queue for Producer: with JMSMessageID:" + jmsId , "CommercialBookOfBusinessAccessor", "submitBookOfBusinessRequest");
		return;
		
	}

	/**
	 * <pre>
	 * buildRequest
	 * 
	 * May 14, 2015
	 * 
	 * Build the request specified by the service provider
	 * 
	 * @param producerNumber
	 * @param producerSubNumber
	 * @param emailAddress
	 * @return BookOfBusinessRequest
	 * </pre>
	 */
	private BookOfBusinessRequest buildRequest(String producerNumber,
			String producerSubNumber, String emailAddress) {
		BookOfBusinessRequest rqst = new ObjectFactory().createBookOfBusinessRequest();
		
		if(producerNumber!=null && !"null".equals(producerNumber) && !"".equals(producerNumber) && producerNumber.length()<7){
			producerNumber=StringUtil.padWithTrailingZeroesStr(producerNumber, 7);
		}

		if(producerSubNumber!=null && !"null".equals(producerSubNumber) && !"".equals(producerSubNumber) && producerSubNumber.length()<5){
			producerSubNumber=StringUtil.padWithTrailingZeroesStr(producerSubNumber, 5);
		}
		
		rqst.setProducerNumber(producerNumber);
		rqst.setSubProducerNumber(producerSubNumber);
		
		rqst.setReportFormat(ICAFConstants.BOB_REPORT_FORMAT);
		rqst.setEmailAddress(emailAddress);
		return rqst;
	}

	/**
	 * <pre>
	 * serializeRequest
	 * 
	 * May 14, 2015
	 * 
	 * Marshal the object to a string 
	 * 
	 * @param request
	 * @return A string representation of the service request object
	 * </pre>
	 */
	private String serializeRequest(BookOfBusinessRequest request) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JAXBContext jaxbContext;
		String requestAsString=null;
		try {
			jaxbContext = JAXBContext.newInstance(BookOfBusinessRequest.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
			ObjectFactory factory = new ObjectFactory();
			JAXBElement<BookOfBusinessRequest> req = factory.createBookOfBusinessRequest(request);
			marshaller.marshal(req, baos);
			requestAsString = baos.toString();
		} catch (JAXBException jaxEx) {
			CAFLogger.logSevere("IO Exception occurred serializing BookOfBusinessRequest : " + jaxEx.getMessage(), "CommercialBookOfBusinessAccessor", "serializeRequest");
			jaxEx.printStackTrace();
		}  catch (Exception ex) {
			CAFLogger.logSevere("IO Exception occurred serializing BookOfBusinessRequest : " + ex.getMessage(), "CommercialBookOfBusinessAccessor", "serializeRequest");
			ex.printStackTrace();
		} 
		
		return requestAsString;
	}
}
