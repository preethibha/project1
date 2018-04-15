package com.chubb.dgmk.caf.wsc.accessors;

import java.util.ArrayList;
import java.util.List;

import com.chubb.dgmk.caf.domain.model.Account;
import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;

import ei.core.producer_identifierx2.ProducerIdentifier;
import ei.crm.commercial_customer_search_crm4x4_http.CommercialCustomerSearchCRM4X4HTTP_CommercialCustomerSearchCRM4X4HttpPortProxy;
import ei.crm.commercial_customer_search_crm4x4_http.NameSearchSimpleFaultReplyMsg;
import ei.crm.insuredx2.Insured;
import ei.crm.name_search_outputs_crm4x4.NameSearchOutputs;
import ei.crm.name_search_reply_crm4x4.NameSearchReply;
import ei.crm.name_search_request_crm4x4.NameSearchRequest;


/**
 * <pre>
 * CommercialAccountRetrievalAccessor
 * May 15, 2015
 * 
 * The CommercialAccountRetrievalAccessor is responsible for interfacing with the 
 * back end service provider.  Calls to the provider are made via JAX-WS proxies.  
 * Replies from the provider are converted to Account domain objects
 * and returned to the caller.
 * 
 * </pre>
 *
 */
public class CommercialAccountRetrievalAccessor implements ICAFConstants {

	/**
	 * <pre>
	 * 
	 * getEndpoint
	 * May 15, 2015
	 * 
	 * This method is used to get CommercialAccountRetrieval web services end point URL which populated at the time of application loading.
	 * 
	 * @return the end point for the CommercialAccountRetrieval service from
	 * the properties file.
	 * 
	 * </pre>
	 */
	public String getEndpoint() {

		String endpoint = CAFPropertiesUtil.getAccountRetrievalEndpoint();
		CAFLogger.logInfo("Endpoint returned for CommercialAccountRetrieval: " + endpoint, "CommercialAccountRetrievalAccessor", "getEndpoint");

		return endpoint;

	}

	/**
	 * <pre>
	 * 
	 * getCommercialAccounts
	 * May 15, 2015
	 * 
	 * This method is used to Invoke the service that returns the Account data matching the input criteria
	 * 
	 * @param name
	 * @param userType (Agent/Employee)
	 * @param producerIdentifiers
	 * 
	 * @return return a list of Accounts
	 * @throws Exception
	 * 
	 * </pre>
	 */
	public List<Account> getCommercialAccounts(String name, String userType, List<ProducerIdentifier> producerIdentifiers) throws Exception{

		String endpoint = getEndpoint();
		ArrayList<Account> accounts = new ArrayList<Account>();

		CommercialCustomerSearchCRM4X4HTTP_CommercialCustomerSearchCRM4X4HttpPortProxy proxy;
		proxy = new CommercialCustomerSearchCRM4X4HTTP_CommercialCustomerSearchCRM4X4HttpPortProxy();
		proxy._getDescriptor().setEndpoint(endpoint);

		//call the service
		try {
			NameSearchRequest nameSearchRequest = buildRequest(name, userType, producerIdentifiers);
			NameSearchReply reply = proxy.nameSearch(nameSearchRequest);
			if (reply !=null)
			CAFLogger.logFine("Response Object :" +  reply.toString() ,  "CommercialAccountRetrievalAccessor", "domainObjectFromAccountProvider");
			//build the domain object from the service reply
			accounts = domainObjectFromAccountProvider(reply);

		} catch (NameSearchSimpleFaultReplyMsg simpleFault) {
			String msg ="Fault returned from CommercialCustomerSearchCRM4X4Http: " + simpleFault.getFaultInfo().getFaultMessageText(); 
			CAFLogger.logSevere(msg, "CommercialAccountRetrievalAccessor", "getCommercialAccounts");
			throw simpleFault;

		}
		catch (Exception e) {
			String msg = "Exception occurred calling CommercialCustomerSearchCRM4X4Http: " + e;
			CAFLogger.logSevere(msg, "CommercialAccountRetrievalAccessor", "getCommercialAccounts");
			e.printStackTrace();
			throw e;
		}

		return accounts;

	}

	/**
	 * <pre>
	 * buildRequest
	 * May 15, 2015
	 *  
	 * This method is used to map provided input to the request object required by ICC web services.
	 *  
	 * @param name
	 * @param userType (Agent/Employee)
	 * @param producerIdentifiers
	 * @return the Provider Request Object
	 * 
	 * </pre>
	 */
	private NameSearchRequest buildRequest(String name, String userType, List<ProducerIdentifier> producerIdentifiers) {

		NameSearchRequest nameSearchRequest =  new NameSearchRequest();
		Insured insured=new Insured();
		insured.setInsuredName(name);
		insured.setInsuredTypeCode(ICAFConstants.LEGAL_ENTITY_INSURED_TYPE_CODE);
		nameSearchRequest.setInsured(insured);
		nameSearchRequest.setSystemId(ICAFConstants.SOURCE_SYSTEM_ID);

		nameSearchRequest.setUserId(ICAFConstants.USER_ID);

		if(userType!=null){
			nameSearchRequest.setUserTypeDescription(userType);
			if(userType.equals(ICAFConstants.ICC_AGENT)){
				setProducerIdentifiersForAcounts(producerIdentifiers, nameSearchRequest);
			}
		}
		nameSearchRequest.getAdditionalOptionsText().add(0,ICAFConstants.ADDITIONAL_OPTIONS_TEXT_ALL_NAMES);
		CAFLogger.logInfo("Request Object Required by ICC Web Services:" +  nameSearchRequest.toString() ,  "CommercialAccountRetrievalAccessor", "buildRequest");
		return nameSearchRequest;

	}

	/**
	 * <pre>
	 * domainObjectFromAccountProvider
	 * May 15, 2015
	 * 
	 * This method is used to convert ICC web-services reply to account domain Objects.
	 * 
	 * @param reply
	 * @return a list of Account domain objects
	 * Convert the reply from the provider to CAF domain objects
	 * 
	 * </pre>
	 */
	private ArrayList<Account> domainObjectFromAccountProvider(NameSearchReply reply) {

		ArrayList<Account> accounts = new ArrayList<Account>();
		List<NameSearchOutputs> accountList = reply.getNameSearchOutputs();

		for (NameSearchOutputs nameSearchOutput:accountList){
			Account account = new Account();
			account.setCPNumber(nameSearchOutput.getInsured().getCPNumber());
			account.setInsuredName(nameSearchOutput.getInsured().getInsuredName());
			account.setWipInsuredNumber(nameSearchOutput.getInsured().getWIPInsuredNumber());
			account.setAddressLine1(nameSearchOutput.getInsured().getMailingAddress().getAddressLine1());
			account.setAddressLine2(nameSearchOutput.getInsured().getMailingAddress().getAddressLine2());
			account.setAddressLine3(nameSearchOutput.getInsured().getMailingAddress().getAddressLine3());
			account.setCityName(nameSearchOutput.getInsured().getMailingAddress().getCityName());
			account.setCountyName(nameSearchOutput.getInsured().getMailingAddress().getCountyName());
			account.setCountryCode(nameSearchOutput.getInsured().getMailingAddress().getCountryCode());
			
			if(!ICAFConstants.USA_COUNTRY_CODE.equalsIgnoreCase(nameSearchOutput.getInsured().getMailingAddress().getCountryCode())){
				account.setCountryName(nameSearchOutput.getInsured().getMailingAddress().getCountryName());
			}
			
			account.setStateOrProvinceName(nameSearchOutput.getInsured().getMailingAddress().getStateOrProvinceName());
			account.setPostalStateAbbreviation(nameSearchOutput.getInsured().getMailingAddress().getPostalStateAbbreviation());
			account.setCountryAbbreviation(nameSearchOutput.getInsured().getMailingAddress().getCountryAbbreviation());
			account.setPostalCode(nameSearchOutput.getInsured().getMailingAddress().getPostalCode());

			accounts.add(account);
		}
		return accounts;

	}

	/**
	 * <pre>
	 * setProducerIdentifiersForAcounts
	 * May 15, 2015
	 * 
	 * Adding produce and sub producer number in web service request for Agent user type.
	 * 
	 * @param producerIdentifiers
	 * @param nameSearchRequest
	 * @return NameSearchRequest object
	 * 
	 * </pre>
	 */
	private NameSearchRequest setProducerIdentifiersForAcounts(List<ProducerIdentifier> producerIdentifiers, NameSearchRequest nameSearchRequest) {

		if(producerIdentifiers.size() > 0){
			for(ProducerIdentifier producerIdentifier : producerIdentifiers){
				nameSearchRequest.getProducerFilterIdentifier().add(producerIdentifier);
			}
		}
		return nameSearchRequest;

	}

}
