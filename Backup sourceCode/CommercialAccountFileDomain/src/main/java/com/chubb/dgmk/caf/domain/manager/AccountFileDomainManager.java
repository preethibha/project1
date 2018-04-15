package com.chubb.dgmk.caf.domain.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import com.chubb.dgmk.caf.domain.model.Account;
import com.chubb.dgmk.caf.domain.model.AccountGroup;
import com.chubb.dgmk.caf.domain.model.Policy;
import com.chubb.dgmk.caf.domain.resource.AccountResource;
import com.chubb.dgmk.caf.domain.resource.ContactResource;
import com.chubb.dgmk.caf.domain.resource.CountryDataCache;
import com.chubb.dgmk.caf.domain.resource.CountryResource;
import com.chubb.dgmk.caf.domain.resource.PolicyResource;
import com.chubb.dgmk.caf.domain.resource.ProducerKey;
import com.chubb.dgmk.caf.domain.resource.ResourceRequestResult;
import com.chubb.dgmk.caf.domain.resource.ResultIdentifierResource;
import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.ICAFConstants;
import com.chubb.dgmk.caf.wsc.accessors.CommercialAccountRetrievalAccessor;
import com.chubb.dgmk.caf.wsc.accessors.CommercialPolicyRetrievalAccessor;
import com.chubb.dgmk.caf.wsc.accessors.CountryRetrievalAccessor;
import com.ibm.websphere.command.CommandException;

import ei.core.country.Country;
import ei.core.producer_identifierx2.ProducerIdentifier;

/**
 * <pre>
 * @author P62240B
 * 
 * AccountFileDomainManager
 * May 15, 2015
 * 
 * The AccountFileDomainManager is responsible for handling the Account retrieval process
 * for a given set of parameters. In all cases, if the User is of type "Agent", parameters
 * passed to the service client will include the list of Producer Number / Sub-Producer 
 * Number combinations the current user has access to.
 * 
 * </pre>
 */
public class AccountFileDomainManager {

	/**
	 * <pre>
	 * retrieveAccount
	 * May 15, 2015
	 * 
	 * This method is used to get accounts data based on input parameter from ICC web services and convert response to respective UI Resource.
	 * 
	 * @param name
	 * @param userType
	 * @param producerKeys :List of Producer Number / Producer SubNumber 
	 * 
	 * @return A ResourceRequestResult with a list of accounts and in case of
	 * exception statusCode and stausMessage updated with appropriate status and message.
	 * 
	 * </pre>
	 */
	public ResourceRequestResult retrieveAccount(String name, String userType,
			List<ProducerKey> producerKeys) {

		CAFLogger.logInfo("Entered Account File Domain Manager ",
				"AccountFileDomainManager", "retrieveAccount");

		CommercialAccountRetrievalAccessor accessor = new CommercialAccountRetrievalAccessor();
		List<AccountResource> accountResourceList = new ArrayList<AccountResource>();
		List<ProducerIdentifier> producerIdentifiers = setProducerInformationForAccount(producerKeys);
		ResourceRequestResult result = new ResourceRequestResult();
		try {
			List<Account> accountList = accessor.getCommercialAccounts(name,
					userType, producerIdentifiers);

			// build domain resource class from model resource class
			result = uiResourceFromAccountList(accountResourceList, accountList);

		} catch (Exception e) {
			CAFLogger.logSevere(
					"Exception caught while processing retrieveAccount: "
							+ e.getMessage(), "AccountFileDomainManager",
					"retrieveAccount");
			result.setStatusCode("E");
			result.setStatusMessage(e.getMessage());

			CAFLogger.logInfo("Exited Account File Domain Manager ",
					"AccountFileDomainManager", "retrieveAccount with result "
							+ result.getStatusMessage());
			return result;

		}

		CAFLogger.logInfo("Exited Account File Domain Manager ",
				"AccountFileDomainManager", "retrieveAccount");

		return result;

	}

	/**
	 * <pre>
	 * retrieveCountryList
	 * May 15, 2015
	 * 
	 * This method will call get the result from provider service and will
	 * call the method uiResourceFromCountryList to map service reply object 
	 * to the UI Resource Object 
	 * 
	 * @return A ResourceRequestResult with a list of Countries.
	 * ErrorCode and ErrorMessage are updated with appropriate status and message.
	 * 
	 * </pre>
	 */
	public ResourceRequestResult retrieveCountryList() {

		CAFLogger.logInfo("Entered RetrieveCountryList ",
				"ContactChubbDomainManager", "retrieveCountryList");

		CountryRetrievalAccessor accessor = new CountryRetrievalAccessor();
		List<CountryResource> rsrc = new ArrayList<CountryResource>();
		ResourceRequestResult result = new ResourceRequestResult();

		try {
			List<Country> countryList = accessor.getCountries();

			if (countryList.isEmpty()) {
				result.setStatusCode("E");
				result.setStatusMessage("WMU countries are not available");
			} else {
				// build domain resource class from model resource class
				result = uiResourceFromCountryList(rsrc, countryList);
			}

		} catch (Exception e) {
			CAFLogger.logSevere(
					"Exception caught while processing retrieveCountryList: "
							+ e.getMessage(), "AccountFileDomainManager",
					"retrieveCountryList");
			result.setStatusCode("E");
			result.setStatusMessage(e.getMessage());

			CAFLogger.logInfo("Exited Retrieve CountryList Manager ",
					"AccountFileDomainManager",
					"retrieveCountryList " + result.getStatusMessage());

			return result;

		}
		CAFLogger.logInfo("Exited Contact Account Domain Manager ",
				"AccountFileDomainManager", "retrieveCountryList with result ");
		return result;

	}

	/**
	 * <pre>
	 * uiResourceFromCountryList
	 * 
	 * May 7, 2015
	 * 
	 * Transform the service reply object to the UI Resource Object
	 * Logic is applied here to filter the list so that only US Producing Countries
	 * are returned
	 * 
	 * @param rsrc List of CountryResource
	 * @param result List of Country
	 * @return ResourceRequestResult which contains country list
	 * 
	 * </pre>
	 */
	private ResourceRequestResult uiResourceFromCountryList(
			List<CountryResource> rsrc, List<Country> result) {

		ResourceRequestResult requestResult = new ResourceRequestResult();

		for (Country country : result) {
			CountryResource countryResource = new CountryResource();
			countryResource.setCountryCode(country.getCountryCode());
			countryResource.setCountryName(country.getCountryName());
			rsrc.add(countryResource);

		}
		CAFLogger.logInfo(" Total Number Of Country Retrived: " + rsrc.size(),
				"AccountFileDomainManager", "uiResourceFromCountryList");
		Collections.sort(rsrc, CountryResource.CountryComparator);
		requestResult.setCountryList(rsrc);
		return requestResult;

	}

	/**
	 * <pre>
	 * retrievePolicies
	 * May 15, 2015
	 * 
	 * This method is used to get policy data based on input parameter from ICC web services and convert response to respective UI Resource.
	 *  
	 * @param policyNumber : 1) policyNumber or 2) insuredNumber or 3)accountGroupNumber
	 * @param userType :Agent or Employee
	 * @param producerKeys :List of Producer Number / Producer SubNumber 
	 * 
	 * @return A ResourceRequestResult with a list of polices associated with account and in case of
	 * exception statusCode and stausMessage updated with appropriate status and message.
	 * 
	 * </pre>
	 * 
	 */
	public ResourceRequestResult retrievePolicies(String policyNumber,
			String accountGroupNumber, String insuredNumber, String userType,
			List<ProducerKey> producerKeys) {

		CAFLogger.logInfo("Entered Account File Domain Manager ",
				"AccountFileDomainManager", "retrievePolicies");

		CommercialPolicyRetrievalAccessor accessor = new CommercialPolicyRetrievalAccessor();
		ResourceRequestResult result = new ResourceRequestResult();

		try {
			List<ei.producer.producer_identifierx1.ProducerIdentifier> producerIdentifiers = setProducerInformationForPolicy(producerKeys);
			AccountGroup acctGrp = accessor.getPolicies(policyNumber,
					accountGroupNumber, insuredNumber, userType,
					producerIdentifiers);

			// build domain resource class from model resource class
			result = uiResourceFromPolicyList(acctGrp);

		} catch (Exception e) {
			CAFLogger.logSevere(
					"Exception caught while processing retrievePolicies: "
							+ e.getMessage(), "AccountFileDomainManager",
					"retrievePolicies");
			result.setStatusCode("E");
			result.setStatusMessage(e.getMessage());

			CAFLogger.logInfo("Exited Account File Domain Manager ",
					"AccountFileDomainManager", "retrievePolicies with result "
							+ result.getStatusMessage());

			return result;
		}

		CAFLogger.logInfo("Exited Account File Domain Manager ",
				"AccountFileDomainManager", "retrievePolicies");

		return result;

	}

	/**
	 * <pre>
	 * uiResourceFromAccountList
	 * May 15, 2015
	 * 
	 * This method is used to Transform the service reply object to the UI Resource Object for account.
	 * 
	 * @param accountResourceList
	 * @param accountList
	 * 
	 * @return Transform the service reply object to the UI Resource Object
	 * 
	 * </pre>
	 */
	private ResourceRequestResult uiResourceFromAccountList(
			List<AccountResource> accountResourceList, List<Account> accountList) {
	//	String countryData = "countryData" ;
		ResourceRequestResult requestResult = new ResourceRequestResult();
		HashMap <String,String> countryNameList = null;
		CountryDataCache cacheableCountryData = CountryDataCache.getInstanceForDynaCache();
		if (cacheableCountryData.getFromDynamicCache(ICAFConstants.COUNTRY_CACHE_KEY)!=null)
		{
			 countryNameList = cacheableCountryData.getFromDynamicCache(ICAFConstants.COUNTRY_CACHE_KEY);
		}
		else 
		{
			cacheableCountryData.putInDynamicCache(ICAFConstants.COUNTRY_CACHE_KEY, ICAFConstants.TIME_TO_LIVE);
			countryNameList = cacheableCountryData.getFromDynamicCache(ICAFConstants.COUNTRY_CACHE_KEY);
		}
		for (Account account : accountList) {
			AccountResource accountResource = new AccountResource();
			accountResource.setInsuredName(account.getInsuredName());
			accountResource.setWipInsuredNumber(account.getWipInsuredNumber());
			accountResource.setAddressLine1(account.getAddressLine1());
			accountResource.setAddressLine2(account.getAddressLine2());
			accountResource.setAddressLine3(account.getAddressLine3());
			accountResource.setCityName(account.getCityName());
			accountResource.setStateOrProvinceName(account.getStateOrProvinceName());
			accountResource.setCountryAbbreviation(account.getCountryAbbreviation());
			accountResource.setPostalCode(account.getPostalCode());
			accountResource.setPostalStateAbbreviation(account.getPostalStateAbbreviation());
			if (countryNameList != null)
			{
				if (!ICAFConstants.USA_COUNTRY_CODE.equalsIgnoreCase(account.getCountryCode()))
				{
				account.setCountryName(countryNameList.get(account.getCountryCode()));
				accountResource.setCountryName(countryNameList.get(account.getCountryCode()));
		//		CAFLogger.logInfo("Country Name In Domain Manager :"+ cacheableCountryData.getCountryMap().get(account.getCountryCode()),"AccountFileDomainManager","uiResourceFromAccountList");
				}
			} else
				accountResource.setCountryName(account.getCountryName());

			accountResource.setInsuredAddress(account.friendlyAddress());
			CAFLogger.logFine("RetrieveAccount with Account: "
					+ accountResource.toString(), "AccountFileDomainManager",
					"uiResourceFromAccountList");
			accountResourceList.add(accountResource);
		}

		Collections
				.sort(accountResourceList, AccountResource.AccountComparator);

		requestResult.setAccountList(accountResourceList);
		return requestResult;

	}

	/**
	 * <pre>
	 * uiResourceFromPolicyList
	 * May 15, 2015
	 * 
	 * This method is used to Transform the service reply object to the UI Resource Object for policy.
	 * 
	 * @param accountGroup
	 * @return Transform the service reply object to the UI Resource Object
	 * 
	 * </pre>
	 */
	private ResourceRequestResult uiResourceFromPolicyList(
			AccountGroup accountGroup) {

		ResourceRequestResult result = new ResourceRequestResult();
		if (accountGroup == null) {
			result.setStatusCode("W");
			result.setStatusMessage("No policies found");
			return result;

		}

		ResultIdentifierResource resultId = new ResultIdentifierResource();

		if (accountGroup.getAccountGroupId() != null
				&& accountGroup.getAccountGroupId().length() != 0) {
			resultId.setAccountGroupId(accountGroup.getAccountGroupId());
			resultId.setAccountName(accountGroup.getAccountGroupName());
			resultId.setMailingAddress("Mulitple Addresses");
		} else {
			// Get the first account. If there was more than one, it would have
			// been bundled
			// in an Account Group and been assigned an AccountGroupID
			Account acct = accountGroup.getAccounts().get(0);
			resultId.setWipInsuredNumber(acct.getWipInsuredNumber());
			resultId.setAccountName(acct.getInsuredName());
			resultId.setMailingAddress(acct.friendlyAddress());
		}
		CAFLogger.logFine(
				"RetrievePolicies With Result ID " + resultId.toString(),
				"AccountFileDomainManager", "uiResourceFromPolicyList");
		result.setResultIdResource(resultId);

		List<Policy> policyList = new ArrayList<Policy>();
		for (Account account : accountGroup.getAccounts()) {
			policyList.addAll(account.getPolicies());
		}

		List<PolicyResource> policyResourceList = new ArrayList<PolicyResource>();
		List<ContactResource> contactResources = null;
		for (Policy policy : policyList) {
			contactResources = new ArrayList<ContactResource>();

			PolicyResource policyResource = new PolicyResource();
			policyResource.setPolicyNumber(policy.getPolicyNumber());
			policyResource
					.setInsurerProductCode(policy.getInsurerProductCode());
			policyResource.setPolicyTypeCode(policy.getPolicyTypeCode());
			policyResource.setDisplayProductTypeName(policy
					.getDisplayProductTypeName());
			policyResource.setProductComponentName(policy
					.getProductComponentName());
			policyResource.setExpirationDate(policy.getExpirationDate());
			policyResource.setPolicyStatus(policy.getPolicyStatusCode());
			policyResource.setPolicyTerm(policy.getPolicyTerm());
			policyResource.setInceptionDate(policy.getInceptionDate());
			policyResource.setCpNumber(policy.getCpNumber());
			policyResource.setProducingBranchCode(policy
					.getProducingBranchCode());
			policyResource.setServicingBranchCode(policy
					.getServicingBranchCode());
			policyResource.setPolicyTypeSubCode(policy.getPolicyTypeSubCode());

			// Set data for Contacts
			if (policy.getUwContact() != null) {
				ContactResource uwContact = new ContactResource();
				uwContact.setUnderwriterId(policy.getUwContact().getCpNumber());
				uwContact.setRole(policy.getUwContact().getRole());
				contactResources.add(uwContact);
			}
			if (policy.getUwAssistantContact() != null) {
				ContactResource uwAssistantContact = new ContactResource();
				uwAssistantContact.setUnderwriterId(policy
						.getUwAssistantContact().getCpNumber());
				uwAssistantContact.setRole(policy.getUwAssistantContact()
						.getRole());
				contactResources.add(uwAssistantContact);
			}

			if (policy.getAsrContact() != null) {
				ContactResource asrContact = new ContactResource();
				asrContact.setUnderwriterId(policy.getAsrContact()
						.getCpNumber());
				asrContact.setRole(policy.getAsrContact().getRole());
				contactResources.add(asrContact);
			}
			policyResource.setContacts(contactResources);
			CAFLogger.logFine("Exited Account File Domain Manager ",
					"AccountFileDomainManager", "uiResourceFromPolicyList");
			policyResourceList.add(policyResource);

		}

		Collections.sort(policyResourceList, PolicyResource.PolicyComparator);

		result.setPolicyList(policyResourceList);
		return result;

	}

	/**
	 * <pre>
	 * setProducerInformationForAccount
	 * May 15, 2015
	 * 
	 * This method is used to set producer and sub producer key for account in case of Agent login .
	 * 
	 * @param List<ProducerKey> producers
	 * @return List<ProducerIdentifier> object
	 * 
	 * </pre>
	 * 
	 */

	private List<ProducerIdentifier> setProducerInformationForAccount(
			List<ProducerKey> producers) {
		List<ProducerIdentifier> producerIdentifiers = new ArrayList<ProducerIdentifier>();
		if (producers.size() > 0) {
			for (ProducerKey producerKey : producers) {
				ProducerIdentifier producerIdentifier = new ProducerIdentifier();
				producerIdentifier.setProducerNumber(producerKey
						.getProducerNumber());
				producerIdentifier.setProducerSubNumber(producerKey
						.getProducerSubNumber());

				producerIdentifiers.add(producerIdentifier);
			}
		}
		return producerIdentifiers;

	}

	/**
	 * <pre>
	 * setProducerInformationForPolicy
	 * May 15, 2015
	 * 
	 * This method is used to set producer and sub producer key for policy in case of Agent login .
	 * 
	 * @param List<ProducerKey> producers
	 * @return List<ProducerIdentifier> object
	 * 
	 * </pre>
	 */
	private List<ei.producer.producer_identifierx1.ProducerIdentifier> setProducerInformationForPolicy(
			List<ProducerKey> producers) {
		List<ei.producer.producer_identifierx1.ProducerIdentifier> producerIdentifiers = new ArrayList<ei.producer.producer_identifierx1.ProducerIdentifier>();
		if (producers.size() > 0) {
			for (ProducerKey producerKey : producers) {
				ei.producer.producer_identifierx1.ProducerIdentifier producerIdentifier = new ei.producer.producer_identifierx1.ProducerIdentifier();
				producerIdentifier.setProducerNumber(producerKey
						.getProducerNumber());
				producerIdentifier.setProducerSubNumber(producerKey
						.getProducerSubNumber());

				producerIdentifiers.add(producerIdentifier);
			}
		}
		return producerIdentifiers;

	}

}
