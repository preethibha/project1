package com.chubb.dgmk.caf.wsc.accessors;

import java.util.ArrayList;
import java.util.List;

import com.chubb.dgmk.caf.domain.model.Contact;
import com.chubb.dgmk.caf.domain.model.Policy;
import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.CAFException;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;
import com.chubb.dgmk.caf.util.StringUtil;

import ei.core.business_contactx2.BusinessContact;
import ei.core.error_information.ErrorInformation;
import ei.core.phone_information.PhoneInformation;
import ei.core.status_informationx2.StatusInformation;
import ei.corporate.account_service_representativex1.AccountServiceRepresentative;
import ei.corporate.contact_retrieval_crp30x1_http.ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy;
import ei.corporate.contact_retrieval_crp30x1_http.GetDefaultContactSimpleFaultReplyMsg;
import ei.corporate.contact_retrieval_crp30x1_http.GetPolicyContactListByDefinedRoleSimpleFaultReplyMsg;
import ei.corporate.get_default_contact_inputs_crp30x1.GetDefaultContactInputs;
import ei.corporate.get_default_contact_outputs_crp30x1.GetDefaultContactOutputs;
import ei.corporate.get_default_contact_reply_crp30x1.GetDefaultContactReply;
import ei.corporate.get_default_contact_request_crp30x1.GetDefaultContactRequest;
import ei.corporate.get_policy_contact_list_by_defined_role_inputs_crp30x1.GetPolicyContactListByDefinedRoleInputs;
import ei.corporate.get_policy_contact_list_by_defined_role_outputs_crp30x1.GetPolicyContactListByDefinedRoleOutputs;
import ei.corporate.get_policy_contact_list_by_defined_role_reply_crp30x1.GetPolicyContactListByDefinedRoleReply;
import ei.corporate.get_policy_contact_list_by_defined_role_request_crp30x1.GetPolicyContactListByDefinedRoleRequest;
import ei.corporate.underwriter_assistantx1.UnderwriterAssistant;
import ei.corporate.underwriterx1.Underwriter;

/**
 * <pre>
 * ChubbContactRetrievalAccessor
 * May 15, 2015
 * 
 * The ChubbContactRetrievalAccessor is responsible for interfacing with the 
 * back end service provider.  Calls to the provider are made via JAX-WS proxies.  
 * Replies from the provider are converted to Contact domain objects
 * and returned to the caller.
 * 
 * </pre>
 *
 */
public class ChubbContactRetrievalAccessor {

	/**
	 * <pre>
	 * getEndpoint
	 * May 15, 2015
	 * 
	 * This method is used to get ChubbContactRetrieval web services end point URL which populated at the time of application loading.
	 * 
	 * @return the end point for the ChubbContactRetrieval service from the properties file.
	 * 
	 * </pre>
	 */
	public String getEndpoint() {

		String endpoint = CAFPropertiesUtil.getContactRetrievalEndpoint();
		CAFLogger.logInfo("Endpoint returned for ChubbContactRetrieval: " + endpoint, "ChubbContactRetrievalAccessor", "getEndpoint");

		return endpoint;

	}

	/**
	 * <pre>
	 * getChubbContacts
	 * May 15, 2015
	 * 
	 * This method is Used to get a list of Policies with key data, CP Numbers identifying contacts, Policy 
	 * producing Branch and policy Line of Business.(Role : default to "Underwriter")
	 * 
	 * @param policyNo
	 * @param cpNumber
	 * @param policyTypeCode
	 * @param branchNumber
	 * @param policySubTypeCode
	 * @param contacts
	 * 
	 * @return A list of Policies with Contact info valued for each
	 * 
	 * @throws Exception
	 * 
	 * </pre>
	 */
	public List<Policy> getChubbContacts(String policyNo,String cpNumber,String policyTypeCode,
			String branchNumber,String policySubTypeCode, List<Contact> contacts) throws Exception{

		String endpoint = getEndpoint();
		List<Policy> policies = new ArrayList<Policy>();
		GetPolicyContactListByDefinedRoleRequest providerRequest = buildRequest(policyNo, cpNumber, policyTypeCode,branchNumber,policySubTypeCode,contacts);
		
		ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy proxy =new ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy();
		proxy._getDescriptor().setEndpoint(endpoint);

		//call the service

		try {

			GetPolicyContactListByDefinedRoleReply reply = proxy.getPolicyContactListByDefinedRole(providerRequest);
			if (reply !=null)
			CAFLogger.logInfo("Returned List of Policies with Policy info ", "ChubbContactRetrievalAccessor", "is "+reply.toString());
			//build the domain object from the service reply
			policies = domainObjectFromPolicyProvider(reply); 
			

		} catch (GetPolicyContactListByDefinedRoleSimpleFaultReplyMsg simpleFault) {
			String msg ="Fault returned from ContactRetrievalCRP30X1Http: " + simpleFault.getFaultInfo().getFaultMessageText(); 
			CAFLogger.logSevere(msg, "ChubbContactRetrievalAccessor", "getChubbContacts");
			throw simpleFault;
		} 
		catch (CAFException cafEx){
			String msg ="An error was returned from ContactRetrievalCRP30X1HTTP: " + cafEx.getMessage(); 
			CAFLogger.logSevere(msg, "ChubbContactRetrievalAccessor", "getChubbContacts");
			throw cafEx;
		}
		catch (Exception e) {
			String msg = "Exception occurred calling ContactRetrievalCRP30X1Http: " + e;
			CAFLogger.logSevere(msg, "ChubbContactRetrievalAccessor", "getChubbContacts");
			e.printStackTrace();
			throw e;
		}
		
	return policies;

	}


	/**
	 * <pre>
	 * getDefaultContacts
	 * May 15, 2015
	 * 
	 * This method is used to get default contacts based on AtChubb product and Producing Branch.
	 * 
	 * @param product  The AtChubb product selected
	 * @param branch	The Producing Branch selected
	 * @param context-Role	The context defining the type of contacts requested; Default is "Underwriter"
	 * @return The list of contacts for the given product, branch and context(Role)
	 * @throws Exception
	 * 
	 * </pre>
	 */
	public List<Contact> getDefaultContacts(String product, String branch, String context) throws Exception {

		String endpoint = getEndpoint();
		List<Contact> contacts = new ArrayList<Contact>();
		GetDefaultContactRequest providerRequest = buildRequest(product, branch, context);

		ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy proxy =new ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy();
		proxy._getDescriptor().setEndpoint(endpoint);

		//call the service
		try {

			GetDefaultContactReply reply = proxy.getDefaultContact(providerRequest);
			if (reply !=null)
			CAFLogger.logFine("The list of contacts for the given product, branch and context(Role) ", "ChubbContactRetrievalAccessor", "is "+reply.toString());
			//build the domain object from the service reply
			contacts = domainObjectFromContactProvider(reply); 
			
		
		} catch (GetDefaultContactSimpleFaultReplyMsg simpleFault) {
			String msg ="Fault returned from ContactRetrievalCRP30X1Http: " + simpleFault.getFaultInfo().getFaultMessageText(); 
			CAFLogger.logSevere(msg, "ChubbContactRetrievalAccessor", "getDefaultContacts");
			throw simpleFault;

		} 
		catch (CAFException cafEx){
			String msg ="An error was returned from ContactRetrievalCRP30X1HTTP: " + cafEx.getMessage(); 
			CAFLogger.logSevere(msg, "ChubbContactRetrievalAccessor", "getDefaultContacts");
			throw cafEx;

		}
		catch (Exception e) {
			String msg = "Exception occurred calling ContactRetrievalCRP30X1Http: " + e;
			CAFLogger.logSevere(msg, "ChubbContactRetrievalAccessor", "getDefaultContacts");
			e.printStackTrace();
			throw e;

		}
		return contacts;

	}

	/**
	 * <pre>
	 * buildRequest
	 * May 15, 2015
	 * 
	 * Map the CAF Model object to the request object GetDefaultContactRequest required by the provider service
	 * 
	 * @param product
	 * @param branch
	 * @param context
	 * @return The Provider Request object GetDefaultContactRequest
	 * 
	 * </pre>
	 */
	private GetDefaultContactRequest buildRequest(String product, String branch, String context) {

		GetDefaultContactRequest request =  new GetDefaultContactRequest();
		GetDefaultContactInputs input =new GetDefaultContactInputs();
		input.setBranchNumber(branch);
		input.setMarketingProductGroupCode(product);
		input.getContactTypeAbbreviation().add(0,ICAFConstants.CONTACT_TYPE_ABBR_UND);

		request.getGetDefaultUnderwriterInputs().add(input);
		request.setUserId(ICAFConstants.USER_ID);
		request.setSystemId(ICAFConstants.SOURCE_SYSTEM_ID);
		CAFLogger.logInfo("Provider Request required by the provider service" + input.toString() , "ChubbContactRetrievalAccessor", "buildRequest");
		return request;

	}

	/**
	 * <pre>
	 * buildRequest
	 * May 15, 2015
	 * 
	 * Map the CAF Model object to the request object GetPolicyContactListByDefinedRoleRequest required by the provider service
	 * 
	 * @param policyNo
	 * @param cpNumber
	 * @param policyTypeCode
	 * @param branchNumber
	 * @param policySubTypeCode
	 * @param contacts
	 * @return return the Provider Request Object based on input
	 * 
	 * </pre>
	 */
	private GetPolicyContactListByDefinedRoleRequest buildRequest(String policyNo,String cpNumber,String policyTypeCode,String branchNumber,String policySubTypeCode, List<Contact> contacts) {

		GetPolicyContactListByDefinedRoleRequest request =new GetPolicyContactListByDefinedRoleRequest();
		GetPolicyContactListByDefinedRoleInputs contactListInputs=new GetPolicyContactListByDefinedRoleInputs();

		request.setUserId(ICAFConstants.USER_ID);
		request.setSystemId(ICAFConstants.SOURCE_SYSTEM_ID);

		if(cpNumber!=null && !"null".equals(cpNumber) && !"".equals(cpNumber)){
			cpNumber=StringUtil.padWithTrailingZeroesStr(cpNumber, 12);
		}

		if(policyNo!=null && !"null".equals(policyNo) && !"".equals(policyNo)){
			policyNo=StringUtil.padWithTrailingZeroesStr(policyNo, 12);
			contactListInputs.setPolicyNumber(policyNo);
		}

		if(branchNumber!=null && !"null".equals(branchNumber) && !"".equals(branchNumber)){
			branchNumber=StringUtil.padWithTrailingZeroesStr(branchNumber, 4);
			contactListInputs.setBranchNumber(branchNumber);
		}

		if(policyTypeCode!=null && !"null".equals(policyTypeCode) && !"".equals(policyTypeCode)){
			policyTypeCode=StringUtil.padWithTrailingZeroesStr(policyTypeCode, 2);
			contactListInputs.setPolicyTypeCode(policyTypeCode);
		}

		if(policySubTypeCode!=null && !"null".equals(policySubTypeCode) && !"".equals(policySubTypeCode)){
			policySubTypeCode=StringUtil.padWithTrailingZeroesStr(policySubTypeCode, 2);
			contactListInputs.setPolicyTypeSubCode(policySubTypeCode);
		}

		Underwriter underwriter=new Underwriter();
		UnderwriterAssistant underwriterAssistant =new UnderwriterAssistant();
		AccountServiceRepresentative representative = new AccountServiceRepresentative();

		for (Contact contact : contacts) {
			if(contact != null){
				if(ICAFConstants.CONTACT_TYPE_ABBR_UND.equals(contact.getRole())){
					underwriter.setCPNumber(contact.getCpNumber());
					contactListInputs.setUnderwriter(underwriter);
				}else if(ICAFConstants.CONTACT_UNDERWRITER_ASSISTANT.equals(contact.getRole())){
					underwriterAssistant.setCPNumber(contact.getCpNumber());
					contactListInputs.setUnderwriterAssistant(underwriterAssistant);
				}else if(ICAFConstants.CONTACT_ACCOUNT_SERVICE_REPRESENTATIVE.equals(contact.getRole())){
					representative.setCPNumber(contact.getCpNumber());
					contactListInputs.setAccountServiceRepresentative(representative);
				}
			}
		} 

		contactListInputs.getContactTypeAbbreviation().add(0,ICAFConstants.CONTACT_TYPE_ABBR_UND);

		request.getGetPolicyContactListByDefinedRoleInputs().add(contactListInputs);
		
		CAFLogger.logInfo("Requested policyNo :  " + policyNo + " cp Number: " + cpNumber + " policyTypeCode: " + policyTypeCode, "ChubbContactRetrievalAccessor", "buildRequest");
		CAFLogger.logInfo("Requested Policy Detail " + contactListInputs.toString(), "ChubbContactRetrievalAccessor", "buildRequest");
		return request;

	}

	/**
	 * <pre>
	 * domainObjectFromPolicyProvider
	 * May 15, 2015
	 * 
	 * This method is used to convert the reply from provider to CAF domain objects (Policy)
	 * 
	 * @param reply
	 * @return a list of Policy domain objects
	 * Convert the reply from the provider to CAF domain objects
	 * @throws CAFException
	 * 
	 * </pre>
	 *  
	 */
	private List<Policy> domainObjectFromPolicyProvider(GetPolicyContactListByDefinedRoleReply reply) throws CAFException{

		List<Contact> contacts = new ArrayList<Contact>();
		List<Policy> policies = new ArrayList<Policy>();

		Policy policy=new Policy();

		StatusInformation statusInfo = reply.getStatusInformation();
		if ("E".equalsIgnoreCase(statusInfo.getStatusCode())){
			List<ErrorInformation> errors = statusInfo.getErrorInformation();
			List<String> messages = new ArrayList<String>();
			for (ErrorInformation error:errors){
				messages.add(error.getErrorDescription());
				CAFLogger.logWarning("An error was returned from CRP30X1: " + error.getErrorCode() + ": " + error.getErrorDescription(),  "ChubbContactRetrievalAccessor", "domainObjectFromPolicyProvider");
			}
			throw new CAFException(StringUtil.concatenateMessage(messages, "; "));
		} else if ("W".equalsIgnoreCase(statusInfo.getStatusCode())){
			{
				List<ErrorInformation> errors = statusInfo.getErrorInformation();
				List<String> messages = new ArrayList<String>();
				for (ErrorInformation error:errors){
					messages.add(error.getErrorDescription());
					CAFLogger.logWarning("A warning was returned from CRP30X1: " + error.getErrorCode() + ": " + error.getErrorDescription(),  "ChubbContactRetrievalAccessor", "domainObjectFromPolicyProvider");
				}
				throw new CAFException(StringUtil.concatenateMessage(messages, "; "));
			}
		}

		Contact contact=null;
		for (GetPolicyContactListByDefinedRoleOutputs policyContactListOutputs  : reply.getGetPolicyContactListByDefinedRoleOutputs()) {
			contact=new Contact();
			policy=new Policy();

			if(policyContactListOutputs.getBusinessContact()!=null){
				BusinessContact businessContact =policyContactListOutputs.getBusinessContact();
				contact.setEmailAddress(businessContact.getEmailInformation().get(0).getEmailAddress());

				for (PhoneInformation phoneInformation : businessContact.getPhoneInformation()) {

					if(ICAFConstants.TELEPHONE.equals(phoneInformation.getPhoneTypeName())){
						contact.setPhoneNumber(phoneInformation.getPhoneNumber());
					}else if(ICAFConstants.MOBILE_PHONE.equals(phoneInformation.getPhoneTypeName())){
						contact.setCellPhoneNumber(phoneInformation.getPhoneNumber());
					}
				}

				contact.setGivenName(businessContact.getContactName());

				if(businessContact.getContactTypeAbbreviation()!=null){

					if(businessContact.getContactTypeAbbreviation().equals(ICAFConstants.CONTACT_TYPE_ABBR_UND)){
						contact.setRole(ICAFConstants.DEFAULT_ROLE);	
					}
					else {
						contact.setRole(businessContact.getContactTypeAbbreviation());	
					}
				}else{
					contact.setRole(ICAFConstants.DEFAULT_ROLE);	
				}
				
				
				contacts.add(contact);
			}

			if(policyContactListOutputs.getPolicyNumber()!=null){
				policy.setPolicyNumber(policyContactListOutputs.getPolicyNumber());
			}else{policy.setPolicyNumber("");}

			if(policyContactListOutputs.getProductComponentName()!=null){
				policy.setProductComponentName(policyContactListOutputs.getProductComponentName());
			}else{
				policy.setProductComponentName("");
			}

			policy.setContacts(contacts);
		
			
			policies.add(policy);
			
		}
		
		return policies;

	}

	/**
	 * <pre>
	 * domainObjectFromContactProvider
	 * May 15 ,2015
	 * 
	 * This method is used to convert the reply from provider to CAF domain objects (Contact)
	 * 
	 * @param reply
	 * @return a list of Contact domain objects
	 * Convert the reply from the provider to CAF domain objects
	 * 
	 * @throws CAFException
	 * 
	 * </pre>
	 */
	private List<Contact> domainObjectFromContactProvider(GetDefaultContactReply reply) throws CAFException{

		StatusInformation statusInfo = reply.getStatusInformation();
		if ("E".equalsIgnoreCase(statusInfo.getStatusCode())){
			List<ErrorInformation> errors = statusInfo.getErrorInformation();
			List<String> messages = new ArrayList<String>();
			for (ErrorInformation error:errors){
				messages.add(error.getErrorDescription());
				CAFLogger.logWarning("An error was returned from CRP30X1: " + error.getErrorCode() + ": " + error.getErrorDescription(),  "ChubbContactRetrievalAccessor", "domainObjectFromContactProvider");
			}
			throw new CAFException(StringUtil.concatenateMessage(messages, "; "));
		} else if ("W".equalsIgnoreCase(statusInfo.getStatusCode())){
			{
				List<ErrorInformation> errors = statusInfo.getErrorInformation();
				List<String> messages = new ArrayList<String>();
				for (ErrorInformation error:errors){
					messages.add(error.getErrorDescription());
					CAFLogger.logWarning("A warning was returned from CRP30X1: " + error.getErrorCode() + ": " + error.getErrorDescription(),  "ChubbContactRetrievalAccessor", "domainObjectFromContactProvider");
				}
				throw new CAFException(StringUtil.concatenateMessage(messages, "; "));
			}
		}

		List<Contact> contacts = new ArrayList<Contact>();
		Contact contact=null;
		for (GetDefaultContactOutputs defaultContactOutputs  : reply.getGetDefaultUnderwriterOutputs()) {
			contact=new Contact();

			if(defaultContactOutputs.getBranch()!=null){
				contact.setBranchName(defaultContactOutputs.getBranch().getBranchName());
			}

			for (BusinessContact businessContact : defaultContactOutputs.getBusinessContact()) {

				contact.setEmailAddress(businessContact.getEmailInformation().get(0).getEmailAddress());

				for (PhoneInformation phoneInformation : businessContact.getPhoneInformation()) {

					if(ICAFConstants.TELEPHONE.equals(phoneInformation.getPhoneTypeName())){
						contact.setPhoneNumber(phoneInformation.getPhoneNumber());
					}else if(ICAFConstants.MOBILE_PHONE.equals(phoneInformation.getPhoneTypeName())){
						contact.setCellPhoneNumber(phoneInformation.getPhoneNumber());
					}
				}

				contact.setGivenName(businessContact.getContactName());

				if(businessContact.getContactTypeAbbreviation()!=null){

					if(businessContact.getContactTypeAbbreviation().equals(ICAFConstants.CONTACT_TYPE_ABBR_UND)){
						contact.setRole(ICAFConstants.DEFAULT_ROLE);	
					}
					else {
						contact.setRole(businessContact.getContactTypeAbbreviation());	
					}
				}else{
					contact.setRole(ICAFConstants.DEFAULT_ROLE);	
				}
				
			}
			contacts.add(contact);
		}

		return contacts;

	}

}
