package com.chubb.dgmk.caf.wsc.accessors;

import java.util.ArrayList;
import java.util.List;
import com.chubb.dgmk.caf.domain.model.PasKey;
import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;
import com.chubb.dgmk.caf.util.StringUtil;

import ei.core.producer.prd2X6.Address;
import ei.core.producer.prd2X6.GetProducerListInputs;
import ei.core.producer.prd2X6.GetProducerListOutputs;
import ei.core.producer.prd2X6.GetProducerListReply;
import ei.core.producer.prd2X6.GetProducerListRequest;
import ei.core.producer.prd2X6.ObjectFactory;
import ei.core.producer_prd2X6_http.GetProducerList2X6SimpleFaultReplyMsg;
import ei.core.producer_prd2X6_http.ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPortProxy;


/**
 * <pre>
 * Producer2X6RetrievalAccessor
 * 
 * The Producer2X6RetrievalAccessor class is responsible for retrieving  
 * producer name and address info via an ICC service.
 *
 * </pre> 
 */
public class Producer2X6RetrievalAccessor {

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

		String endpoint = CAFPropertiesUtil.getProducer2X6RetrievalEndpoint();
		CAFLogger.logInfo("Endpoint returned for ProducerRetrieval: " + endpoint, "Producer2X6RetrievalAccessor", "getEndpoint");

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
	public List<PasKey> getProducers(List<PasKey> producerKeys) throws Exception{

		String endpoint = getEndpoint();
		if(null == endpoint){
			endpoint="http://EIPRODRETPRD2X6-ut/Producer2ServicesWeb/sca/ProducerRetrievalPRD2X6Http";
		}
		ArrayList<PasKey> producers = new ArrayList<PasKey>();
		GetProducerListRequest providerRequest = buildRequest(producerKeys);
		
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
		return producers;

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
	public List<PasKey> getPas(List<PasKey> producerKeys) throws Exception{

		String endpoint = getEndpoint();
		ArrayList<PasKey> producers = new ArrayList<PasKey>();
		GetProducerListRequest providerRequest = buildRequest(producerKeys);
		
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
		return producers;

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
	 */
	private GetProducerListRequest buildRequest(List<PasKey> producerKeys) {

		GetProducerListRequest request =  new ObjectFactory().createGetProducerListRequest();

		for(PasKey prod : producerKeys){
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

	}

	/**
	 * <pre>
	 * domainObjectFromProviderReply
	 * May 20, 2015
	 * 
	 * This method will map the ICC provider reply GetProducerListReply to
	 * list of Producer CAF domain objects.
	 * 
	 * @param GetProducerListReply
	 * @return a list of Producer domain objects
	 * 
	 * </pre>
	 */
	private ArrayList<PasKey> domainObjectFromProviderReply(GetProducerListReply reply) {

		ArrayList<PasKey> producers = new ArrayList<PasKey>();

		if(reply!=null && !reply.getGetProducerListOutputs().isEmpty()){
			List<GetProducerListOutputs> producerListOutputs= reply.getGetProducerListOutputs();

			for (GetProducerListOutputs producerList:producerListOutputs){
				PasKey producer = new PasKey();

				if(producerList.getExtendedProducer()!=null && producerList.getExtendedProducer().getProducerIdentifier()!=null){
					/*producer.setProducerName(producerList.getExtendedProducer().get
					producer.setProducerNumber(producerList.getExtendedProducer().get
					producer.setProducerSubNumber(producerList.getExtendedProducer().getProducerIdentifier().getProducerSubNumber());*/
				}

				if(producerList.getExtendedProducer()!=null && producerList.getExtendedProducer().getMailingAddress()!=null){
					producer.setAddressLine1(producerList.getExtendedProducer().getMailingAddress().getAddressLine1());
					producer.setAddressLine2(producerList.getExtendedProducer().getMailingAddress().getAddressLine2());
					producer.setAddressLine3(producerList.getExtendedProducer().getMailingAddress().getAddressLine3());
					producer.setCityName(producerList.getExtendedProducer().getMailingAddress().getCityName());
					producer.setCountyName(producerList.getExtendedProducer().getMailingAddress().getCountyName());
					producer.setCountryCode(producerList.getExtendedProducer().getMailingAddress().getCountryCode());
					
					if(!ICAFConstants.USA_COUNTRY_CODE.equalsIgnoreCase(producerList.getExtendedProducer().getMailingAddress().getCountryCode())){
						producer.setCountryName(producerList.getExtendedProducer().getMailingAddress().getCountryName());
					}
					
					producer.setStateOrProvinceName(producerList.getExtendedProducer().getMailingAddress().getStateOrProvinceName());
					producer.setPostalStateAbbreviation(producerList.getExtendedProducer().getMailingAddress().getPostalStateAbbreviation());
					producer.setCountryAbbreviation(producerList.getExtendedProducer().getMailingAddress().getCountryAbbreviation());
					producer.setPostalCode(producerList.getExtendedProducer().getMailingAddress().getPostalCode());
				
				}

				producers.add(producer);
			}
		}

		CAFLogger.logInfo("Domain object built from PRD2X6 response",  "Producer2X6RetrievalAccessor", "domainObjectFromProviderReply");

		return producers;

	}

	private String toCamelCase(String test1)
	{
	    String[] split = test1.split(" ");

	    String ret = "";
	    for (int i=0;i<split.length;i++)
	    {
	        if (split[i].length()>1)
	        ret=ret+split[i].substring(0,1).toUpperCase()+split[i].substring(1).toLowerCase()+" ";
	        else 
	        ret=ret+split[i]+ " ";

	    }
	return ret.trim();
	}
	
	/**
	 * This method is used to concatenate mailing address of producer
	 * @param mailingAddres
	 * @return
	 */
	public String mailingAddress(Address mailingAddres){
		StringBuffer sb = new StringBuffer();

		if(mailingAddres.getAddressLine1()!=null && !"".equals(mailingAddres.getAddressLine1().trim())){
			sb.append(this.toCamelCase(mailingAddres.getAddressLine1()) + ", ");
		}
		if(mailingAddres.getAddressLine2()!=null && !"".equals(mailingAddres.getAddressLine2().trim())){
			sb.append(this.toCamelCase(mailingAddres.getAddressLine2()) + ", ");
		}
		if(mailingAddres.getAddressLine3()!=null && !"".equals(mailingAddres.getAddressLine3().trim())){
			sb.append(this.toCamelCase(mailingAddres.getAddressLine3()) + ", ");
		}
		if(mailingAddres.getCityName()!=null && !"".equals(mailingAddres.getCityName().trim())){
			sb.append(this.toCamelCase(mailingAddres.getCityName()) + ", ");
		}
		if(mailingAddres.getPostalStateAbbreviation()!=null && !"".equals(mailingAddres.getPostalStateAbbreviation().trim())){
			sb.append(mailingAddres.getPostalStateAbbreviation().toUpperCase() + ", ");
		}
		
		if(!ICAFConstants.USA_COUNTRY_CODE.equalsIgnoreCase(mailingAddres.getCountryCode())){
			if(mailingAddres.getCountryName()!=null && !"".equals(mailingAddres.getCountryName().trim())){
				sb.append(this.toCamelCase(mailingAddres.getCountryName()) + ", ");
			}
		}
		
		if(mailingAddres.getPostalCode()!=null && !"".equals(mailingAddres.getPostalCode().trim())){
			sb.append(mailingAddres.getPostalCode());
		}

		if (sb.length() > 0 && sb.charAt(sb.length()-2)==',') {
			sb.deleteCharAt(sb.length()-2);
		}

		return sb.toString();

	}
}