package ei.producer.producer_cross_reference_retrieval_prd6x1_http;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;
import com.chubb.ecom.dgmk.ga.util.GAUserProfilePropertiesUtil;


/**
 * <pre>
 * Producer2X6RetrievalAccessor
 * 
 * The Producer2X6RetrievalAccessor class is responsible for retrieving  
 * producer name and address info via an ICC service.
 *
 * </pre> 
 */
public class Producer6X1RetrievalAccessor {
	/** The logger. This should be injected by IOC framework */
	private ILogger logger;
	/**
	 * Sets the logger.
	 * 
	 * @param logger
	 *            the new logger
	 */
	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	/**
	 * Gets the default logger if object is not set by IOC framework
	 * 
	 * @return the logger
	 */
	public ILogger getLogger() {
		if (logger == null) {
			logger = GAUserProfileLoggerImpl.getLogger();
		}
		return logger;
	}

	/**
	 * <pre>
	 * getEndpoint
	 * 
	 * This method is used to get ProducerRetrieval service end point URL which loaded at the time of application initialization
	 *  
	 * @return the end point for the ProducerRetrieval service from
	 * the properties file.
	 * 
	 * </pre>
	 */
	public String getEndpoint() {

		String endpoint = GAUserProfilePropertiesUtil.getProducer6X1RetrievalEndpoint();
		getLogger().logSevere("Endpoint returned for ProducerRetrieval: " + endpoint, "Producer2X6RetrievalAccessor", "getEndpoint");

		return endpoint;

	}

	/**
	 * <pre>
	 * getProducers
	 * 
	 * 
	 * This method will call the ICC provider service and will get
	 * the list of producers from it
	 * 
	 * @param producerKeys A list of Producer objects with only Producer Number/SubNumber data valued
	 * @return the list of Producers for the list of Producer Number/SubNumbers provided
	 * 
	 *  @throws Exception
	 *  
	 * </pre>
	 */
	public String getProducer(String pasKey) throws Exception{

		String endpoint = getEndpoint();
		if(null == endpoint){
			endpoint="http://eiprodxrefprd6x1-ut/Producer2ServicesWeb/sca/ProducerCrossReferenceRetrievalPRD6X1Http";
		}
		return null;
		/*GetProducerIdRequest providerRequest = buildRequest(producerKeys);
		
		ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPortProxy proxy = new ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPortProxy();
		proxy._getDescriptor().setEndpoint(endpoint);

		//call the service

		try {

			GetProducerListReply reply = proxy.getProducerList2X6(providerRequest);
			if (reply!=null)
			CAFLogger.logFine("Domain object built from PRD2X6 response :" + reply.toString() ,  "Producer2X6RetrievalAccessor", "domainObjectFromProviderReply");
			//build the domain object from the service reply
			producers = domainObjectFromProviderReply(reply); 


		} catch (GetProducerList2X6SimpleFaultReplyMsg simpleFault) {
			String msg ="Fault returned from ProducerRetrievalPRD2X6Http: " + simpleFault.getFaultInfo().getFaultMessageText(); 
			CAFLogger.logSevere(msg, "Producer2X6RetrievalAccessor", "getProducers");
			throw simpleFault;

		} catch (Exception e) {
			String msg = "Exception occurred calling ProducerRetrievalPRD2X6Http: " + e;
			CAFLogger.logSevere(msg, "Producer2X6RetrievalAccessor", "getProducers");
			e.printStackTrace();
			throw e; 

		}
		return producers;*/

	}
	
	
	

	/**
	 * <pre>
	 * buildRequest
	 * May 20, 2015
	 * 
	 * This method is used to prepare request object for calling ICC services
	 * 
	 * @param producerKeys : List of Producer object
	 * Map the CAF Model object to the request object required by the provider service
	 * @return the Provider Request Object
	 * 
	 * </pre>
	 *//*
	private GetProducerListRequest buildRequest(List<ProducerPasKeyResource> producerKeys) {

		GetProducerListRequest request =  new ObjectFactory().createGetProducerListRequest();

		for(ProducerPasKeyResource prod : producerKeys){
			GetProducerListInputs input = new GetProducerListInputs();
			String producerNumber=prod.getProducerNumber();
			String producerSubNumber=prod.getProducerSubNumber();
			String pasNumber=prod.getPasNumber();
			
			
			if(producerNumber!=null && !"null".equals(producerNumber) && !"".equals(producerNumber) && producerNumber.length()<7){
				producerNumber=StringUtil.padWithTrailingZeroesStr(producerNumber, 7);
			}

			if(producerSubNumber!=null && !"null".equals(producerSubNumber) && !"".equals(producerSubNumber) && producerSubNumber.length()<5){
				producerSubNumber=StringUtil.padWithTrailingZeroesStr(producerSubNumber, 5);
			}
			
			input.setProducerNumber(producerNumber);
			input.setProducerSubNumber(producerSubNumber);
			input.setPASSourceProducerCode(pasNumber);
			CAFLogger.logFine("Request Object For Calling ICC Services: " + input.toString(), "Producer2X6RetrievalAccessor", "buildRequest");
			request.getGetProducerListInputs().add(input);
		}

		request.setUserId(ICAFConstants.USER_ID);
		request.setSystemId(ICAFConstants.SOURCE_SYSTEM_ID);
		return request;

	}*/

	

	
	
	
}