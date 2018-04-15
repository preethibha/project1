package com.chubb.dgmk.bob.bean;

import java.io.ByteArrayInputStream;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.chubb.dgmk.bob.domain.manager.BookOfBusinessManager;
import com.chubb.dgmk.bob.jaxb.BookOfBusinessRequest;
import com.chubb.dgmk.bob.logger.BOBLogger;

/**
 * Message-Driven Bean implementation class for: CommercialBookOfBusinessBean
 *
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"
		) })
public class CommercialBookOfBusinessBean implements MessageListener {

    /**
     * Default constructor. 
     */
    public CommercialBookOfBusinessBean() {
        
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
	TextMessage msg = (TextMessage)message;
	BookOfBusinessRequest request = null;
	try {
		request = deserialize(msg);
		
	} catch (JAXBException jaxEx) {
		BOBLogger.logSevere("IO Exception occurred serializing BookOfBusinessRequest : " + jaxEx.getMessage(), "CommercialBookOfBusinessAccessor", "serializeRequest");
		jaxEx.printStackTrace();
	} catch (JMSException e) {
		BOBLogger.logSevere("IO Exception occurred serializing BookOfBusinessRequest : " + e.getMessage(), "CommercialBookOfBusinessAccessor", "serializeRequest");
		e.printStackTrace();
	}  catch (Exception ex) {
		BOBLogger.logSevere("IO Exception occurred serializing BookOfBusinessRequest : " + ex.getMessage(), "CommercialBookOfBusinessAccessor", "serializeRequest");
		ex.printStackTrace();

	} 
	
	//Delegate processing to CommercialBookOfBusinessManager
	processBookOfBusinessRequest(request);
		
   }

    /**
	 * <pre>
	 * deserialize
	 * 
	 * May 14, 2015
	 * 
	 * Unmarshal the object to a BookOfBusinessRequest 
	 * 
	 * @param msg
	 * @return BookOfBusinessRequest the JaxB object created by deserializing the XML message
	 * @throws JMSException
	 * @throws JAXBException
	 * </pre>
	 */
	private BookOfBusinessRequest deserialize(TextMessage msg) throws JMSException, JAXBException {
		ByteArrayInputStream bais = new ByteArrayInputStream(msg.getText().getBytes());
		JAXBContext jaxbContext = JAXBContext.newInstance(com.chubb.dgmk.bob.jaxb.BookOfBusinessRequest.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		BookOfBusinessRequest bobRequest = (BookOfBusinessRequest)unmarshaller.unmarshal(bais);
		String producerNumber=bobRequest.getProducerNumber();
		String producerSubNumber =bobRequest.getSubProducerNumber(); 
		BOBLogger.logInfo("Book Of Business generation requested for ProducerNumber: " + producerNumber + " SubProducerNumber: " + producerSubNumber, "CommercialBookOfBusinessBean", "onMessage");
		
		return bobRequest;
	}
	
	/**
	 * <pre>
	 * processBookOfBusinessRequest
	 * 
	 * May 14, 2015
	 * 
	 * Delegate processing to the manager to handle the request.
	 * 
	 * @param request BookOfBusiness request object
	 * </pre>
	 */
	private void processBookOfBusinessRequest(BookOfBusinessRequest request) {
		BookOfBusinessManager mgr = new BookOfBusinessManager();
		String producerNumber = request.getProducerNumber();
		String producerSubNumber = request.getSubProducerNumber();
		String reportFormat = request.getReportFormat();
		String emailAddress = request.getEmailAddress();
		mgr.processBookOfBusinessRequest(producerNumber, producerSubNumber, reportFormat, emailAddress);
		
	}
    
}
