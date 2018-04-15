package com.chubb.dgmk.caf.jms.accessors;

import java.util.logging.Level;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.ICAFConstants;
import javax.naming.NamingException;

/**
 * @author p62240b
 * The QueueRequestorImpl is responsible for communicating with MQ targets.
 */
public class QueueRequestorImpl implements ICAFConstants {

	private InitialContext context;
	private ConnectionFactory connectionFactory;
	private TextMessage sendMessage;
	private Connection connection;
	private Session session;
	private Destination sendDestination;
	private Destination receiveDestination;
	private String selectorText = "JMSCorrelationID = '";//JMSMessageID
		
	/**
	 * @param sendDestinationJndi  The JNDI name of the target queue
	 * @param receiveDestinationJndi	The JNDI name of the response queue in a Request/Response scenario; null if request is one-way
	 * @param targetFunction	The TargetFunctionName expected by the service provider
	 * Initialize the Queue Connection and Destinations
	 */
	public QueueRequestorImpl(String sendDestinationJndi, String receiveDestinationJndi, String targetService) {
		
		CAFLogger.getLogger().log(Level.FINE, "In QueueRequestorImpl constructor using sendQueueName: " + 
				sendDestinationJndi + " and receiveQueueName: " + receiveDestinationJndi + " for Target Service: " + targetService, "QueueRequestorImpl", "Constructor");
		
	    try {
	    	
	    	//look up queue info from context
			context = new InitialContext();
			connectionFactory = (ConnectionFactory) context.lookup(CAF_JMS_MQ_CONNFAC);
			sendDestination = (Destination) context.lookup(sendDestinationJndi);
						
			//create a connection
			createConnection();
			
			//update the new session
			if (receiveDestinationJndi != null){
				receiveDestination = (Destination) context.lookup(receiveDestinationJndi);
				sendMessage.setJMSReplyTo(receiveDestination);}
			
			if (targetService != null && targetService.length() >0) 
				sendMessage.setStringProperty("targetService", targetService);

		} catch (Exception e) {
			CAFLogger.getLogger().log(Level.SEVERE, "Exception occurred in QueueRequestorImpl constructor: " + e.getMessage(), "QueueRequestorImpl", "Constructor");
		}
	}
	
	/**
	 * @throws Exception
	 * Establish a connection to the Connection Factory specified
	 */
	protected void createConnection() throws Exception {
		connection = connectionFactory.createConnection();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		sendMessage = session.createTextMessage();
	}
	
	/**
	 * @param messageText  The String message to write to the queue
	 * @return String The response from the service as read from the Reply Queue
	 * @throws Exception
	 * Write the messageText to the established queue.  If an exception occurs, repeat the attempt once more.
	 * Receive the response within the specified wait time and return it to the caller.
	 */
	public String sendAndReceive(String messageText) throws Exception {
		
		MessageConsumer receiver=null;
		String messageId=null;
		
		//send the message
		try {
			messageId = sendMessage(messageText);
		} catch (JMSException e) {
			// Try this a second time
			CAFLogger.getLogger().log(Level.INFO, "Second attempt at creating QueueSender", "QueueRequestorImpl", "sendAndReceive");
			createConnection();
			messageId = sendMessage(messageText);
			CAFLogger.getLogger().log(Level.INFO, "Second attempt at creating QueueSender is successful", "QueueRequestorImpl", "sendAndReceive");
		}

		CAFLogger.getLogger().log(Level.INFO, "Add document message sent successfully.  Corr ID: " + messageId, "QueueRequestorImpl", "sendAndReceive");
	    
		// Receive the response
		String receiveBuffer = null;
		Message receiveMessage = null;
		try {
			String selector = selectorText + messageId + "'";
			receiver = session.createConsumer(receiveDestination, selector);
			receiveMessage = receiver.receive(TIME_TO_WAIT);
		} catch (RuntimeException e) {
			e.printStackTrace();
			CAFLogger.getLogger().log(Level.SEVERE, "An Exception occurred receiving AddDocument response message: " + e.getMessage(), "QueueRequestorImpl", "sendAndReceive");
			throw e;
		} finally {
			receiver.close();		
			session.close();
			connection.close();
			context.close();
		}
		
		if (receiveMessage == null){
			CAFLogger.getLogger().log(Level.SEVERE, "A null response was received from the AddDocument operation.  Possibly this request has timed out waiting for a reply. ", "QueueRequestorImpl", "sendAndReceive");
			return null;
		}

		TextMessage textMessage = (TextMessage)receiveMessage;
		receiveBuffer = textMessage.getText();
		
		return receiveBuffer;
		
	}
	
	/**
	 * @param messageText The message to write to the queue
	 * @return The JMSMessageID
	 * @throws JMSException
	 * Write the messageText to the queue.  On success, respond with the
	 * JMSMessageID.  On failure, throw exception
	 */
	public String sendMessage(String messageText) throws JMSException, NamingException{

		String jmsMessageID=null;
		MessageProducer producer=null;
		try{
			connection.start();
			sendMessage.setText(messageText);
			producer = session.createProducer(sendDestination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			producer.setTimeToLive(TIME_TO_WAIT);
			producer.send(sendMessage);
			jmsMessageID=sendMessage.getJMSMessageID();
		}catch (JMSException e) {
			CAFLogger.getLogger().log(Level.SEVERE, "An Exception occurred sendMessage : " + e.getMessage(), "QueueRequestorImpl", "sendMessage");
			throw e;
		}finally{
			producer.close();
			session.close();
			connection.close();
			context.close();
		}
		return jmsMessageID;
	}

}
