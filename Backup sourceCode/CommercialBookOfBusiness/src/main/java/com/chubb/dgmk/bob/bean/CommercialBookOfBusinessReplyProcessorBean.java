package com.chubb.dgmk.bob.bean;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.chubb.dgmk.bob.domain.manager.BookOfBusinessManager;
import com.chubb.dgmk.bob.logger.BOBLogger;
import com.chubb.dgmk.bob.util.IBOBConstants;
import com.ibm.jms.JMSTextMessage;

import ei.core.source_system_data.SourceSystemData;
import ei.reporting.generate_book_of_business_report_reply_rpt3x1.GenerateBookOfBusinessReportReply;

/**
 * Message-Driven Bean implementation class for: CommercialBookOfBusinessReplyProcessorBean
 *
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"
		) })
public class CommercialBookOfBusinessReplyProcessorBean implements MessageListener {

    /**
     * Default constructor. 
     */
    public CommercialBookOfBusinessReplyProcessorBean() {
    
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	BOBLogger.logInfo("BookOfBusiness reply message :" + 
    			message + ":", 
				"CommercialBookOfBusinessReplyProcessorBean", "onMessage");
		JMSTextMessage msg = (JMSTextMessage)message;
    	GenerateBookOfBusinessReportReply reply = null; //the reply from ICC
    	try {
    		reply = deserialize(msg);
    		
    	} catch (JAXBException jaxEx) {
    		BOBLogger.logSevere("IO Exception occurred serializing BookOfBusinessReply : " + jaxEx.getMessage(), "CommercialBookOfBusinessReplyProcessorBean", "onMessage");
    		jaxEx.printStackTrace();
    	} catch (JMSException e) {
    		BOBLogger.logSevere("JMSException occurred serializing BookOfBusinessReply : " + e.getMessage(), "CommercialBookOfBusinessReplyProcessorBean", "onMessage");
    		e.printStackTrace();
    	}  catch (Exception ex) {
    		BOBLogger.logSevere("IO Exception occurred serializing BookOfBusinessReply : " + ex.getMessage(), "CommercialBookOfBusinessReplyProcessorBean", "onMessage");
    		ex.printStackTrace();
    	} 
    	
    	if(reply != null){
    		processBookOfBusinessReply(reply);
    	}
    }
	  /**
	 * <pre>
	 * 
	 * 
	 * May 14, 2015
	 * 
	 * Unmarshal the object to the ICC Service Reply Message 
	 * 
	 * @param msg
	 * @the JaxB object created by deserializing the XML message
	 * @throws JMSException
	 * @throws JAXBException
	 * </pre>
	 */
	private GenerateBookOfBusinessReportReply deserialize(JMSTextMessage msg) throws JMSException, JAXBException {
		GenerateBookOfBusinessReportReply bobReply =null;
		try{
			ByteArrayInputStream bais = new ByteArrayInputStream(msg.getText().getBytes());
			BOBLogger.logInfo("BookOfBusiness reply message bytearray form of message:" + msg.getText().getBytes() + 
					":", "CommercialBookOfBusinessReplyProcessorBean", "deserialize");
			JAXBContext jaxbContext = JAXBContext.newInstance(ei.reporting.generate_book_of_business_report_reply_rpt3x1.GenerateBookOfBusinessReportReply.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			bobReply = (GenerateBookOfBusinessReportReply)unmarshaller.unmarshal(bais);
		}catch(Exception e){
			throw new RuntimeException();
		}
		if (bobReply != null){
			return bobReply;
		}else{
			return new GenerateBookOfBusinessReportReply();
		}
	}  
	
	
	/**
	 * <pre>
	 * processBookOfBusinessReply
	 * 
	 * May 14, 2015
	 * 
	 * Delegate processing to the manager to handle the reply.
	 * 
	 * @param msg 
	 * </pre>
	 */
	private void processBookOfBusinessReply(GenerateBookOfBusinessReportReply msg) {
		BookOfBusinessManager mgr = new BookOfBusinessManager();
		String producerNumber = "";
		String producerSubNumber = "";
		String emailAddress = "rpanda@chubb.com";
		
		List<SourceSystemData> sourceSystemDataList = msg.getSourceSystemData();
		if(sourceSystemDataList !=null && sourceSystemDataList.size() > 0){
			for(int i=0; i<sourceSystemDataList.size();i++){
				if("EmailAddress".equals(sourceSystemDataList.get(i).getSourceSystemDataName())){
					if(!"".equals(sourceSystemDataList.get(i).getSourceSystemDataValue()) 
							&& sourceSystemDataList.get(i).getSourceSystemDataValue().contains("@")){
						emailAddress = sourceSystemDataList.get(i).getSourceSystemDataValue();
					}
				}
			}
		}
		
		if(msg.getFile() != null){
			byte[] bytes = msg.getFile().getFileBytes();
			File fis = new File(IBOBConstants.BOOK_OF_BUSINESS_ATTACHMENT_NAME);
			try{
				FileOutputStream fos = new FileOutputStream(fis);
		        fos.write(bytes);
		        fos.flush();
		        fos.close();
			}catch (Exception e) {
	
				BOBLogger.logSevere(
						"Exception occurred While sending email : "
								+ e.getMessage(), "CommercialBookOfBusinessReplyProcessorBean",
						"processBookOfBusinessReply");
				e.printStackTrace();
			}
			
			mgr.sendEmail(producerNumber, producerSubNumber, emailAddress, fis);
		}
		else{
			String errorMessage = "Exception occurred processing the processBookOfBusinessReply process";
			BOBLogger.logSevere(
					errorMessage, "CommercialBookOfBusinessReplyProcessorBean",
					"processBookOfBusinessReply");
			mgr.sendErrorEmail(producerNumber, producerSubNumber, errorMessage, emailAddress);
		}
	}

}
