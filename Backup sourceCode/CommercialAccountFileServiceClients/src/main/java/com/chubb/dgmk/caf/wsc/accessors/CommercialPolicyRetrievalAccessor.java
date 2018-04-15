package com.chubb.dgmk.caf.wsc.accessors;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.chubb.dgmk.caf.domain.model.Account;
import com.chubb.dgmk.caf.domain.model.AccountGroup;
import com.chubb.dgmk.caf.domain.model.Contact;
import com.chubb.dgmk.caf.domain.model.Policy;
import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.CAFException;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;
import com.chubb.dgmk.caf.util.StringUtil;

import ei.core.error_information.ErrorInformation;
import ei.core.status_informationx2.StatusInformation;
import ei.crm.commercial_insured_group_policy_retrieval_crm33x1_http.CommercialInsuredGroupPolicyRetrievalCRM33X1HTTP_CommercialInsuredGroupPolicyRetrievalCRM33X1HttpPortProxy;
import ei.crm.commercial_insured_group_policy_retrieval_crm33x1_http.GetCommercialInsuredGroupPolicyListSimpleFaultReplyMsg;
import ei.crm.commercial_insured_group_with_policy_term.CommercialInsuredGroupWithPolicyTerm;
import ei.crm.get_commercial_insured_group_policy_list_reply_crm33x1.GetCommercialInsuredGroupPolicyListReply;
import ei.crm.get_commercial_insured_group_policy_list_request_crm33x1.GetCommercialInsuredGroupPolicyListRequest;
import ei.crm.get_commercial_insured_group_policy_list_request_crm33x1.ObjectFactory;
import ei.crm.insured_with_policy_term.InsuredWithPolicyTerm;
import ei.crm.policy_termx6.PolicyTerm;
import ei.producer.producer_identifierx1.ProducerIdentifier;

/**
 * <pre>
 * CommercialPolicyRetrievalAccessor
 * May 15, 2015
 * 
 * The CommercialPolicyRetrievalAccessor is responsible for interfacing with the 
 * back end service provider. Calls to the provider are made via JAX-WS proxies.  
 * Replies from the provider are converted to AccountGroup domain objects
 * and returned to the caller.
 * 
 * </pre>
 *
 */
public class CommercialPolicyRetrievalAccessor implements ICAFConstants{

	/**
	 * <pre>
	 * getEndpoint
	 * May 15, 2015
	 * 
	 * This method is used to get CommercialPolicyRetrieval web service end point URL which populated at the time of application loading.
	 * 
	 * @return the end point for the CommercialPolicyRetrieval service from
	 * the properties file.
	 * 
	 * </pre>
	 */
	public String getEndpoint() {

		String endpoint = CAFPropertiesUtil.getCommercialPolicyRetrievalEndpoint();
		CAFLogger.logInfo("Endpoint returned for CommercialPolicyRetrieval: " + endpoint, "CommercialPolicyRetrievalAccessor", "getEndpoint");

		return endpoint;

	}

	/**
	 * <pre>
	 * getPolicies
	 * May 15, 2015
	 * 
	 * This method is used Invoke the service that returns the Policy data based on matching the input criteria.
	 * 
	 * @param policyNumber
	 * @param accountGroupNumber
	 * @param insuredNumber
	 * @param userType (Agent/Employee)
	 * @param producerIdentifiers
	 * 
	 * @return a the Account Group that contains the list of Accounts each having a list of Policies
	 * 
	 * @throws Exception
	 * 
	 * </pre>
	 */
	public AccountGroup getPolicies(String policyNumber, String accountGroupNumber, String insuredNumber,String userType,List<ProducerIdentifier> producerIdentifiers) throws Exception {

		String endpoint = getEndpoint();
		AccountGroup acctGrp = new AccountGroup();

		CommercialInsuredGroupPolicyRetrievalCRM33X1HTTP_CommercialInsuredGroupPolicyRetrievalCRM33X1HttpPortProxy proxy = new CommercialInsuredGroupPolicyRetrievalCRM33X1HTTP_CommercialInsuredGroupPolicyRetrievalCRM33X1HttpPortProxy();
		proxy._getDescriptor().setEndpoint(endpoint);

		//call the service
		try {
			GetCommercialInsuredGroupPolicyListRequest commercialInsuredGroupPolicyListRequest = buildRequest(policyNumber, accountGroupNumber, insuredNumber,userType,producerIdentifiers);
			
			GetCommercialInsuredGroupPolicyListReply reply = proxy.getCommercialInsuredGroupPolicyList(commercialInsuredGroupPolicyListRequest);
			if (reply !=null)
			CAFLogger.logFine("Account Group that contains the list of Accounts each having a list of Policies "+ reply.toString(), "CommercialPolicyRetrievalAccessor", "domainObjectFromPolicyProvider");
			//build the domain object from the service reply
			acctGrp = domainObjectFromPolicyProvider(reply);

		} catch (GetCommercialInsuredGroupPolicyListSimpleFaultReplyMsg simpleFault) {

			String msg ="Fault returned from CommercialInsuredGroupPolicyRetrievalCRM33X1HTTP: " + simpleFault.getFaultInfo().getFaultMessageText(); 
			CAFLogger.logSevere(msg, "CommercialPolicyRetrievalAccessor", "getPolicies");
			throw simpleFault;

		} 
		catch (CAFException cafEx){
			String msg ="An error was returned from CommercialInsuredGroupPolicyRetrievalCRM33X1HTTP: " + cafEx.getMessage(); 
			CAFLogger.logSevere(msg, "CommercialPolicyRetrievalAccessor", "getPolicies");
			throw cafEx;
		}
		catch (Exception e) {
			String msg = "Exception occurred calling CommercialInsuredGroupPolicyRetrievalCRM33X1HTTP: " + e;
			CAFLogger.logSevere(msg, "CommercialPolicyRetrievalAccessor", "getPolicies");
			e.printStackTrace();
			throw e;				
		}

		return acctGrp;

	}


	/**
	 * <pre>
	 * buildRequest
	 * May 15, 2015
	 * 
	 * This method is used to map provided input parameter to the request object required by ICC web services.
	 * 
	 * @param policyNumber
	 * @param accountGroupNumber
	 * @param insuredNumber
	 * @param userType (Agent/Employee)
	 * @param producerIdentifiers
	 * @return the Provider Request Object
	 * 
	 * </pre>
	 */
	private GetCommercialInsuredGroupPolicyListRequest buildRequest(String policyNumber, String accountGroupNumber, String insuredNumber,String userType,List<ProducerIdentifier> producerIdentifiers) {

		GetCommercialInsuredGroupPolicyListRequest request =  new ObjectFactory().createGetCommercialInsuredGroupPolicyListRequest();

		if(insuredNumber!=null && !"null".equals(insuredNumber) && !"".equals(insuredNumber)){
			insuredNumber=StringUtil.padWithTrailingZeroesStr(insuredNumber, 12);
		}

		if(userType!=null){
			request.setUserTypeDescription(userType);
			if(userType.equals(ICAFConstants.ICC_AGENT)){
				setProducerIdentifiersForPolicy(producerIdentifiers, request);
			}
		}

		if(policyNumber!=null && !"null".equals(policyNumber) && !"".equals(policyNumber)){
			policyNumber=StringUtil.padWithTrailingZeroesStr(policyNumber, 12);
		}

		request.setPolicyNumber(policyNumber);
		request.setCommercialInsuredGroupId(accountGroupNumber);
		request.setWIPInsuredNumber(insuredNumber);
		request.setSystemId(ICAFConstants.SOURCE_SYSTEM_ID);
		request.getAdditionalOptionsText().add(0,ICAFConstants.ADDITIONAL_OPTIONS_TEXT_WMU_POLICY);
		request.setUserId(ICAFConstants.USER_ID);
		CAFLogger.logInfo("Request object ", "CommercialPolicyRetrievalAccessor", "buildRequest is "+request.toString());
		return request;

	}

	/**
	 * <pre>
	 * domainObjectFromPolicyProvider
	 * May 15, 2015
	 * 
	 * This method is used to convert provider service reply to CAF objects
	 * 
	 * @param reply
	 * @return a list of Policy domain objects
	 * Convert the reply from the provider to CAF domain objects
	 * @throws CAFException
	 * 
	 * </pre>
	 */
	private AccountGroup domainObjectFromPolicyProvider(GetCommercialInsuredGroupPolicyListReply reply) throws CAFException {

		StatusInformation statusInfo = reply.getStatusInformation();
		if ("E".equalsIgnoreCase(statusInfo.getStatusCode())){
			List<ErrorInformation> errors = statusInfo.getErrorInformation();
			List<String> messages = new ArrayList<String>();
			for (ErrorInformation error:errors){
				messages.add(error.getErrorDescription());
				CAFLogger.logWarning("An error was returned from CRM33X1: " + error.getErrorCode() + ": " + error.getErrorDescription(),  "CommercialPolicyRetrievalAccessor", "domainObjectFromPolicyProvider");
			}
			throw new CAFException(StringUtil.concatenateMessage(messages, "; "));
		} else if ("W".equalsIgnoreCase(statusInfo.getStatusCode())){
			{
				List<ErrorInformation> errors = statusInfo.getErrorInformation();
				List<String> messages = new ArrayList<String>();
				for (ErrorInformation error:errors){
					messages.add(error.getErrorDescription());
					CAFLogger.logWarning("A warning was returned from CRM33X1: " + error.getErrorCode() + ": " + error.getErrorDescription(),  "CommercialPolicyRetrievalAccessor", "domainObjectFromPolicyProvider");
				}
				throw new CAFException(StringUtil.concatenateMessage(messages, "; "));
			}
		}

		AccountGroup accountGrp = null;
		ArrayList<Policy> policies = new ArrayList<Policy>();
		CommercialInsuredGroupWithPolicyTerm policyGroup = reply.getCommercialInsuredGroupWithPolicyTerm();
		String inceptionDate="";
		String expirationDate="";
		if(policyGroup!=null && policyGroup.getInsuredWithPolicyTerm()!=null){

			accountGrp = new AccountGroup();

			accountGrp.setAccountGroupId(policyGroup.getCommercialInsuredGroupId());
			accountGrp.setAccountGroupName(policyGroup.getCommercialInsuredGroupName());

			List<InsuredWithPolicyTerm> insuredPolicyTerms = policyGroup.getInsuredWithPolicyTerm();

			for (InsuredWithPolicyTerm insuredWithPolicyTerm:insuredPolicyTerms){

				Account account = new Account();
				accountGrp.addAccount(account);

				account.setInsuredName(insuredWithPolicyTerm.getInsuredName());
				account.setWipInsuredNumber(insuredWithPolicyTerm.getWIPInsuredNumber());
				account.setAddressLine1(insuredWithPolicyTerm.getMailingAddress().getAddressLine1());
				account.setAddressLine2(insuredWithPolicyTerm.getMailingAddress().getAddressLine2());
				account.setCityName(insuredWithPolicyTerm.getMailingAddress().getCityName());
				account.setStateOrProvinceAbbreviation(insuredWithPolicyTerm.getMailingAddress().getStateOrProvinceAbbreviation());
				account.setPostalStateAbbreviation(insuredWithPolicyTerm.getMailingAddress().getPostalStateAbbreviation());
				account.setPostalCode(insuredWithPolicyTerm.getMailingAddress().getPostalCode());
				
				account.setCountryCode(insuredWithPolicyTerm.getMailingAddress().getCountryCode());
				account.setCountryAbbreviation(insuredWithPolicyTerm.getMailingAddress().getCountryAbbreviation());
				
				if(!ICAFConstants.USA_COUNTRY_CODE.equalsIgnoreCase(insuredWithPolicyTerm.getMailingAddress().getCountryCode())){
					account.setCountryName(insuredWithPolicyTerm.getMailingAddress().getCountryName());
				}
				
				List<PolicyTerm> policyTerms = insuredWithPolicyTerm.getPolicyTerm();
				for (PolicyTerm policyTerm:policyTerms){
					Policy policy = new Policy();
					account.addPolicy(policy);

					if(policyGroup!=null && policyGroup.getCommercialInsuredGroupId()!=null){
						policy.setAcountGroupId(policyGroup.getCommercialInsuredGroupId());
					}

					policy.setPolicyNumber(policyTerm.getPolicyNumber());
					policy.setCpNumber(insuredWithPolicyTerm.getCPNumber());

					if(policyTerm.getProductInformation()!=null){

						if(policyTerm.getProductInformation().getInsurerProductCode()!=null){
							policy.setInsurerProductCode(policyTerm.getProductInformation().getInsurerProductCode());	
						}
						if(policyTerm.getProductInformation().getDisplayProductTypeName()!=null){
							policy.setDisplayProductTypeName(policyTerm.getProductInformation().getDisplayProductTypeName());
						}else{
							policy.setDisplayProductTypeName("");
						}

						if(policyTerm.getProductInformation().getProductComponentName()!=null){
							policy.setProductComponentName(policyTerm.getProductInformation().getProductComponentName());	
						}

						if(policyTerm.getProductInformation().getPolicyTypeCode()!=null){
							policy.setPolicyTypeCode(policyTerm.getProductInformation().getPolicyTypeCode());	
						}

						if(policyTerm.getProductInformation().getPolicyTypeSubCode()!=null){
							policy.setPolicyTypeSubCode(policyTerm.getProductInformation().getPolicyTypeSubCode());	
						}
					}

					if(policyTerm.getProducingBranch()!=null && policyTerm.getProducingBranch().getBranchNumber()!=null){
						policy.setProducingBranchCode(policyTerm.getProducingBranch().getBranchNumber());	
					}

					if(policyTerm.getServicingBranch()!=null && policyTerm.getServicingBranch().getBranchNumber()!=null){
						policy.setServicingBranchCode(policyTerm.getServicingBranch().getBranchNumber());	
					}

					policy.setExpirationDate(policyTerm.getExpirationDate());
					policy.setInceptionDate(policyTerm.getInceptionDate());
					policy.setPolicyStatusCode(policyTerm.getOfferingInformation().getOfferingStatusCode());
					
					if(policyTerm.getInceptionDate()!=null){
						inceptionDate =StringUtil.formatDate(policyTerm.getInceptionDate().toGregorianCalendar().getTime());
					}
					if(policyTerm.getExpirationDate()!=null){
						this.setExpiredStatus(policyTerm, policy);
						expirationDate =StringUtil.formatDate(policyTerm.getExpirationDate().toGregorianCalendar().getTime());
					}

					policy.setPolicyTerm(inceptionDate+" / "+expirationDate);

					Contact uwContact =new Contact();
					uwContact.setRole(ICAFConstants.CONTACT_TYPE_ABBR_UND);
					if(policyTerm.getUnderwriter()!=null){
						uwContact.setCpNumber(policyTerm.getUnderwriter().getCPNumber());

					}else{
						uwContact.setCpNumber("");
					}
					policy.setUwContact(uwContact);

					Contact uwAssistantContact =new Contact();
					uwAssistantContact.setRole(ICAFConstants.CONTACT_UNDERWRITER_ASSISTANT);
					if(policyTerm.getUnderwriterAssistant()!=null){
						uwAssistantContact.setCpNumber(policyTerm.getUnderwriterAssistant().getCPNumber());
					}else{
						uwAssistantContact.setCpNumber("");
					}
					policy.setUwAssistantContact(uwAssistantContact);

					Contact asrContact =new Contact();
					asrContact.setRole(ICAFConstants.CONTACT_ACCOUNT_SERVICE_REPRESENTATIVE);
					if(policyTerm.getAccountServiceRepresentative()!=null){
						asrContact.setCpNumber(policyTerm.getAccountServiceRepresentative().getCPNumber());
					}else{
						asrContact.setCpNumber("");
					}
					policy.setAsrContact(asrContact);
					
					
					policies.add(policy);
				}
				CAFLogger.logInfo("Returned Total Number Of Policies For  Wip Insured Name : " + account.getInsuredName()+" is :" + policies.size(), "CommercialPolicyRetrievalAccessor", "domainObjectFromPolicyProvider");
			}
		}

		return accountGrp;

	}

	/**
	 * This method is used to set Expired status for policies in WRITTEN status 
	 * which have passed their expiration date.
	 * 
	 * @param policyTerm
	 * @param policy
	 * 
	 * return void
	 */
	private void setExpiredStatus(PolicyTerm policyTerm, Policy policy) {
		
		if(ICAFConstants.WRITTEN_KEY.equalsIgnoreCase(policy.getPolicyStatusCode()) || ICAFConstants.WRITTEN_DNR_KEY.equalsIgnoreCase(policy.getPolicyStatusCode())){

			if(policyTerm.getExpirationDate().toGregorianCalendar().compareTo(StringUtil.toXMLGregorianCalendarDateOnly(new GregorianCalendar()).toGregorianCalendar())==-1){
				policy.setPolicyStatusCode(ICAFConstants.POLICY_EXPIRED_STATUS);
			}
		}
		
	}

	/**
	 * <pre>
	 * setProducerIdentifiersForPolicy
	 * May 15, 2015
	 * 
	 * Adding produce and sub producer number in provider service request for user type "Agent".
	 * 
	 * @param List<ProducerIdentifier> producerIdentifiers, GetCommercialInsuredGroupPolicyListRequest request
	 * @return GetCommercialInsuredGroupPolicyListRequest object
	 */
	private GetCommercialInsuredGroupPolicyListRequest setProducerIdentifiersForPolicy(List<ProducerIdentifier> producerIdentifiers, GetCommercialInsuredGroupPolicyListRequest request) {

		if(producerIdentifiers.size() > 0){
			for (ProducerIdentifier producerIdentifier : producerIdentifiers) {
				request.getProducerFilterIdentifier().add(producerIdentifier);
			}
		}
		return request;

	}

}
