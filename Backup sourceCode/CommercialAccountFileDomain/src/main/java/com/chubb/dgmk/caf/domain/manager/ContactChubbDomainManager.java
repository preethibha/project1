package com.chubb.dgmk.caf.domain.manager;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.chubb.dgmk.caf.domain.model.Branch;
import com.chubb.dgmk.caf.domain.model.Contact;
import com.chubb.dgmk.caf.domain.model.PasKey;
import com.chubb.dgmk.caf.domain.model.Policy;
import com.chubb.dgmk.caf.domain.model.Product;
import com.chubb.dgmk.caf.domain.model.UserInformation;
import com.chubb.dgmk.caf.domain.resource.BranchResource;
import com.chubb.dgmk.caf.domain.resource.ContactResource;
import com.chubb.dgmk.caf.domain.resource.CountryDataCache;
import com.chubb.dgmk.caf.domain.resource.CountryResource;
import com.chubb.dgmk.caf.domain.resource.PasKeyResource;
import com.chubb.dgmk.caf.domain.resource.PolicyResource;
import com.chubb.dgmk.caf.domain.resource.ProducerKey;
import com.chubb.dgmk.caf.domain.resource.ProducerResource;
import com.chubb.dgmk.caf.domain.resource.ProductResource;
import com.chubb.dgmk.caf.domain.resource.ResourceRequestResult;
import com.chubb.dgmk.caf.domain.resource.UserResource;
import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;
import com.chubb.dgmk.caf.wsc.accessors.BranchRetrievalAccessor;
import com.chubb.dgmk.caf.wsc.accessors.ChubbContactRetrievalAccessor;
import com.chubb.dgmk.caf.wsc.accessors.Producer2X6RetrievalAccessor;
import com.chubb.dgmk.caf.wsc.accessors.ProducerRetrievalAccessor;
import com.chubb.dgmk.caf.wsc.accessors.ProductRetrievalAccessor;
import com.chubb.dgmk.caf.wsc.accessors.UserProfileRetrievalAccessor;

/**
 * <pre>
 * 
 * ContactChubbDomainManager
 * May 15, 2015
 * 
 * The ContactChubbDomainManager is responsible for handling the Contact retrieval process
 * for a given set of parameters.
 * 
 * </pre>
 */
public class ContactChubbDomainManager {

	/**
	 * <pre>
	 * 
	 * retrievePolicyContactList
	 * May 15, 2015
	 * 
	 * This method is used to get contact list based on selected policy (This will default to Underwriter).
	 * 
	 * @param policyNo
	 * @param cpNumber
	 * @param policyTypeCode
	 * @param branchNumber
	 * @param policySubTypeCode
	 * @param contacts
	 * 
	 * @return A ResourceRequestResult with a list of ContactResources which will either be the assigned or default contacts  and in case of
	 * exception statusCode and stausMessage updated with appropriate status and message.
	 * 
	 * </pre>
	 */
	public ResourceRequestResult retrievePolicyContactList(String policyNo,String cpNumber,String policyTypeCode,
			String branchNumber,String policySubTypeCode, List<Contact> contacts){

		CAFLogger.logInfo("Entered Retrieve Policy ContactList ", "ContactChubbDomainManager", "retrievePolicyContactList");

		ChubbContactRetrievalAccessor accessor = new ChubbContactRetrievalAccessor();
		List<PolicyResource> rsrc = new ArrayList<PolicyResource>();
		ResourceRequestResult result =new ResourceRequestResult();

		try{
			List<Policy> policyLst = accessor.getChubbContacts(policyNo, cpNumber, policyTypeCode,branchNumber,policySubTypeCode,contacts);

			//build domain resource class from model resource class
			result=uiResourceFromPolicyList(rsrc, policyLst);

		}catch (Exception e) {
			CAFLogger.logSevere("Exception caught while processing retrievePolicyContactList: " + e.getMessage(), "ContactChubbDomainManager", "retrievePolicyContactList");
			result.setStatusCode("E");
			result.setStatusMessage( e.getMessage());

			CAFLogger.logFine("Exited Retrieve Policy ContactList ", "ContactChubbDomainManager", "retrievePolicyContactList with result "+result.getStatusMessage());

			return result;

		}

		CAFLogger.logInfo("Exited Retrieve Policy ContactList ", "ContactChubbDomainManager", "retrievePolicyContactList");
	

		return result;

	}

	/**
	 * <pre>
	 * 
	 * retrieveDefaultContactList
	 * May 15, 2015
	 * 
	 * @param product  The AtChubb product selected
	 * @param branch   The Producing Branch selected
	 * @param context  The context defining the type of contacts requested; Default is "Underwriter"
	 * 
	 * @return A ResourceRequestResult with a list of contacts for the given product, branch and context and in case of
	 * exception statusCode and stausMessage updated with appropriate status and message.
	 * 
	 * </pre>
	 *  
	 */
	public ResourceRequestResult retrieveDefaultContactList(String product, String branch, String context){

		CAFLogger.logInfo("Entered Retrieve Default ContactList ", "ContactChubbDomainManager", "retrieveDefaultContactList");

		ChubbContactRetrievalAccessor accessor = new ChubbContactRetrievalAccessor();
		List<ContactResource> rsrc = new ArrayList<ContactResource>();
		ResourceRequestResult result =new ResourceRequestResult();

		try{
			List<Contact> contactLst = accessor.getDefaultContacts(product, branch, context);

			//build domain resource class from model resource class
			result=uiResourceFromContactList(rsrc, contactLst);

		}
		catch (Exception e) {
			CAFLogger.logSevere("Exception caught while processing retrieveDefaultContactList: " + e.getMessage(), "ContactChubbDomainManager", "retrieveDefaultContactList");
			result.setStatusCode("E");
			result.setStatusMessage( e.getMessage());


			return result;

		}

		CAFLogger.logInfo("Exited Retrieve Default ContactList ", "ContactChubbDomainManager", "retrieveDefaultContactList");
		
		return result;

	}

	/**
	 * <pre>
	 * retrieveAtChubbProductList
	 * 
	 * May 15, 2015
	 * 
	 * This method will call get the result from provider service and will
	 * call the method uiResourceFromProductList to map service reply object 
	 * to the UI Resource Object 
	 * 
	 * @return A ResourceRequestResult with a list of AtChubbProducts.
	 * ErrorCode and ErrorMessage are updated with appropriate status and message.
	 * 
	 * </pre>
	 */
	public ResourceRequestResult retrieveAtChubbProductList(){

		CAFLogger.logInfo("Entered Retrieve At ChubbProductList ", "ContactChubbDomainManager", "retrieveAtChubbProductList");

		ProductRetrievalAccessor accessor = new ProductRetrievalAccessor();
		List<ProductResource> rsrc = new ArrayList<ProductResource>();
		ResourceRequestResult result=new ResourceRequestResult();

		try{
			List<Product> products = accessor.getAtChubbProducts();

			//build domain resource class from model resource class
			result=uiResourceFromProductList(rsrc, products);

		}
		catch (Exception e) {
			CAFLogger.logSevere("Exception caught while processing retrieveAtChubbProductList: " + e.getMessage(), "ContactChubbDomainManager", "retrieveAtChubbProductList");
			result.setStatusCode("E");
			result.setStatusMessage( e.getMessage());

			CAFLogger.logInfo("Exited Retrieve At ChubbProductList ", "ContactChubbDomainManager", "retrieveAtChubbProductList with result "+result.getStatusMessage());

			return result;

		}
		CAFLogger.logInfo("Exited Retrieve At ChubbProductList ", "ContactChubbDomainManager", "retrieveAtChubbProductList");
		

		return result;

	}

	/**
	 * <pre>
	 * retrieveBranchList
	 * May 15, 2015
	 * 
	 * This method will call get the result from provider service and will
	 * call the method uiResourceFromBranchList to map service reply object 
	 * to the UI Resource Object 
	 * 
	 * @return A ResourceRequestResult with a list of Branches.
	 * ErrorCode and ErrorMessage are updated with appropriate status and message.
	 * 
	 * </pre>
	 */
	public ResourceRequestResult retrieveBranchList(){

		CAFLogger.logInfo("Entered RetrieveBranchList ", "ContactChubbDomainManager", "retrieveBranchList");

		BranchRetrievalAccessor accessor = new BranchRetrievalAccessor();
		List<BranchResource> rsrc = new ArrayList<BranchResource>();
		ResourceRequestResult result =new ResourceRequestResult();

		try{
			List<Branch> branchList = accessor.getBranches();

			if(CAFPropertiesUtil.getBranchList().isEmpty()){
				result.setStatusCode("E");
				result.setStatusMessage("WMU branchs are not available");
			}else{
				//build domain resource class from model resource class
				result = uiResourceFromBranchList(rsrc, branchList);
			}

		}catch (Exception e) {
			CAFLogger.logSevere("Exception caught while processing retrieveBranchList: " + e.getMessage(), "ContactChubbDomainManager", "retrieveBranchList");
			result.setStatusCode("E");
			result.setStatusMessage( e.getMessage());

			CAFLogger.logInfo("Exited Retrieve BranchList Manager ", "ContactChubbDomainManager", "retrieveBranchList "+result.getStatusMessage());

			return result;

		}
		CAFLogger.logInfo("Exited Contact Chubb Domain Manager ", "ContactChubbDomainManager", "retrieveBranchList with result ");	
		return result;

	}

	/**
	 * <pre>
	 * retrieveProducerList
	 * May 19, 2015
	 * 
	 * This method will call get the result from provider service and will
	 * call the method uiResourceFromProducerList to map service reply object 
	 * to the UI Resource Object 
	 * 
	 * @param producerKeys
	 * 
	 * @return A ResourceRequestResult with a list of Producers matching the producerKeys.
	 * ErrorCode and ErrorMessage are updated with appropriate status and message.
	 * 
	 * </pre>
	 */
	public ResourceRequestResult retrieveProducerList(List<ProducerKey> producerKeys){

		Producer2X6RetrievalAccessor accessor = new Producer2X6RetrievalAccessor();
		List<ProducerResource> producerResourceList = new ArrayList<ProducerResource>();
		ResourceRequestResult result =new ResourceRequestResult();

		//Transform the producerKey list ui resource parameter to a model object parameter mapping the code/subcode key values
		List<PasKey> producerParams = new ArrayList<PasKey>();
		for(ProducerKey producerKey : producerKeys){
			PasKey producer = new PasKey();
			producer.setProducerNumber(producerKey.getProducerNumber());
			producer.setProducerSubNumber(producerKey.getProducerSubNumber());

			producerParams.add(producer);
		}

		try{
			List<PasKey> producerList = accessor.getProducers(producerParams);

			//build domain resource class from model resource class
			result = uiResourceFromProducerList(producerResourceList, producerList);

		}catch (Exception e) {
			CAFLogger.logSevere("Exception caught while processing retrieveProducerList: " + e.getMessage(), "ContactChubbDomainManager", "retrieveProducerList");
			result.setStatusCode("E");
			result.setStatusMessage( e.getMessage());
			return result;

		}

		return result;

	}
	
	
	public ResourceRequestResult retrievePasList(List<PasKeyResource> pasKeys){

		Producer2X6RetrievalAccessor accessor = new Producer2X6RetrievalAccessor();
		List<ProducerResource> producerResourceList = new ArrayList<ProducerResource>();
		ResourceRequestResult result =new ResourceRequestResult();

		//Transform the producerKey list ui resource parameter to a model object parameter mapping the code/subcode key values
		List<PasKey> pasParams = new ArrayList<PasKey>();
		for(PasKeyResource pasKey : pasKeys){
			PasKey pas = new PasKey();
			pas.setPasNumber(pasKey.getPasNumber());
			pasParams.add(pas);
		}

		try{
			List<PasKey> producerList = accessor.getPas(pasParams);

			//build domain resource class from model resource class
			result = uiResourceFromProducerList(producerResourceList, producerList);

		}catch (Exception e) {
			CAFLogger.logSevere("Exception caught while processing retrieveProducerList: " + e.getMessage(), "ContactChubbDomainManager", "retrieveProducerList");
			result.setStatusCode("E");
			result.setStatusMessage( e.getMessage());
			return result;

		}

		return result;

	}

	/**
	 * <pre>
	 * uiResourceFromPolicyList
	 * May 15,2015
	 * 
	 * Transform the service reply object to the UI Resource Object
	 * 
	 * @param rsrc
	 * @param result
	 * @return Transform the service reply object to the UI Resource Object
	 * 
	 * </pre>
	 */
	private ResourceRequestResult uiResourceFromPolicyList(List<PolicyResource> rsrc,
			List<Policy> result) {

		ResourceRequestResult requestResult = new ResourceRequestResult();
		List <ContactResource> contacts=new ArrayList<ContactResource>();

		PolicyResource policyResource=null;
		ContactResource contactResource=null;

		for (Policy policy : result) {
			policyResource=new PolicyResource();


			for (Contact contact : policy.getContacts()) {
				contactResource=new ContactResource();

				if(contact.getCellPhoneNumber()!=null){
					contactResource.setCellPhoneNumber(contact.getCellPhoneNumber());
				}else {
					contactResource.setCellPhoneNumber("");
				}

				if(contact.getPhoneNumber()!=null){
					contactResource.setPhoneNumber(contact.getPhoneNumber());	
				}else{
					contactResource.setPhoneNumber("");
				}

				if(contact.getEmailAddress()!=null){
					contactResource.setEmailAddress(contact.getEmailAddress());
				}else{
					contactResource.setEmailAddress("");
				}

				if(contact.getRole()!=null){
					contactResource.setRole(contactResource.getDefaultRole(contact.getRole()));
				}else{
					contactResource.setRole("");	
				}

				if(contact.getGivenName()!=null){
					contactResource.setName(contact.getGivenName());
				}else{
					contactResource.setName("");
				}

				contacts.add(contactResource);
			}
			policyResource.setContacts(contacts);

			policyResource.setPolicyNumber(policy.getPolicyNumber());
			policyResource.setProductComponentName(policy.getProductComponentName());
			policyResource.setExpirationDate(policy.getExpirationDate());
			CAFLogger.logInfo("Exited uiResourceFromPolicyList", "ContactChubbDomainManager", "ResourceRequestResult");
	//		CAFLogger.logFine("Exited uiResourceFromPolicyList", "ContactChubbDomainManager", "ResourceRequestResult with  "+policyResource.toString());
			rsrc.add(policyResource);
		}

		requestResult.setPolicyList(rsrc);

		return requestResult;

	}

	/**
	 * <pre>
	 * uiResourceFromContactList
	 * May 15,2015
	 * 
	 * Transform the service reply object to the UI Resource Object for contact list
	 * 
	 * @param rsrc
	 * @param result
	 * 
	 * @return Transform the service reply object to the UI Resource Object
	 * 
	 * </pre>
	 */
	private ResourceRequestResult uiResourceFromContactList(List<ContactResource> rsrc,
			List<Contact> result) {

		ResourceRequestResult requestResult = new ResourceRequestResult();
		ContactResource contactResource=null;

		for (Contact contact:result){
			contactResource = new ContactResource();

			if(contact.getCellPhoneNumber()!=null){
				contactResource.setCellPhoneNumber(contact.getCellPhoneNumber());
			}else {
				contactResource.setCellPhoneNumber("");
			}

			if(contact.getPhoneNumber()!=null){
				contactResource.setPhoneNumber(contact.getPhoneNumber());	
			}else{
				contactResource.setPhoneNumber("");
			}

			if(contact.getEmailAddress()!=null){
				contactResource.setEmailAddress(contact.getEmailAddress());
			}else{
				contactResource.setEmailAddress("");
			}

			if(contact.getRole()!=null){
				contactResource.setRole(contact.getRole());
			}else{
				contactResource.setRole("");	
			}

			if(contact.getGivenName()!=null){
				contactResource.setName(contact.getGivenName());
			}else{
				contactResource.setName("");
			}
			CAFLogger.logFine("Contact uiResourceFromContactList ", "ContactChubbDomainManager", "uiResourceFromContactList with contact resource "+contactResource.toString());
			rsrc.add(contactResource);
		}

		requestResult.setContactList(rsrc);

		return requestResult;

	}
	/**
	 * <pre>
	 * uiResourceFromProductList
	 * 
	 * May 8, 2015
	 * 
	 * Transform the service reply object to the UI Resource Object
	 * 
	 * @param rsrc List of ProductResource
	 * @param result List of Product
	 * @return ResourceRequestResult contains product list
	 * 
	 * </pre>
	 */
	private ResourceRequestResult uiResourceFromProductList(List<ProductResource> rsrc,
			List<Product> result) {

		ResourceRequestResult requestResult = new ResourceRequestResult();
		for(Product product:result){
			ProductResource productResource = new ProductResource();
			productResource.setProductName(product.productName);
			productResource.setProductCode(product.productCode);
			rsrc.add(productResource);
		}
		CAFLogger.logInfo(" Total Number Of Product Retrieved: "+ rsrc.size(), "ContactChubbDomainManager", "uiResourceFromBranchList");
		Collections.sort(rsrc, ProductResource.ProductComparator);
		requestResult.setProductList(rsrc);

		return requestResult;

	}
	/**
	 * <pre>
	 * uiResourceFromBranchList
	 * 
	 * May 7, 2015
	 * 
	 * Transform the service reply object to the UI Resource Object
	 * Logic is applied here to filter the list so that only US Producing Branches
	 * are returned
	 * 
	 * @param rsrc List of BranchResource
	 * @param result List of Branch
	 * @return ResourceRequestResult which contains branch list
	 * 
	 * </pre>
	 */
	private ResourceRequestResult uiResourceFromBranchList(List<BranchResource> rsrc,
			List<Branch> result) {

		ResourceRequestResult requestResult = new ResourceRequestResult();
		List<String> sourceBranchLst=CAFPropertiesUtil.getBranchList();

		for (String branchCode : sourceBranchLst) {
			for (Branch branch:result){
				if(branch.getBranchNumber().equals(branchCode)){
					BranchResource branchResource = new BranchResource();
					branchResource.setBranchCode(branch.getBranchNumber());
					branchResource.setBranchName(branch.getBranchName());
					rsrc.add(branchResource);
					break;
				}
			}
		}
		CAFLogger.logInfo(" Total Number Of Branches Retrived: "+ rsrc.size(), "ContactChubbDomainManager", "uiResourceFromBranchList");
		Collections.sort(rsrc,BranchResource.BranchComparator);
		requestResult.setBranchList(rsrc);
		return requestResult;

	}

	/**
	 * <pre>
	 * uiResourceFromProducerList
	 * May 19, 2015
	 * 
	 * Transform the service reply object to the UI Resource Object
	 * 
	 * @param rsrc
	 * @param result
	 * @return Transform the service reply object to the UI Resource Object
	 * 
	 * </pre>
	 */
	private ResourceRequestResult uiResourceFromProducerList(List<ProducerResource> rsrc,
			List<PasKey> result) {

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
		for (PasKey producer : result){
			ProducerResource producerResource = new ProducerResource();

			producerResource.setProducerName(producer.getProducerName());
			producerResource.setProducerNumber(producer.getProducerNumber());
			producerResource.setProducerSubNumber(producer.getProducerSubNumber());
			if (countryNameList != null)
			{
				if (!ICAFConstants.USA_COUNTRY_CODE.equalsIgnoreCase(producer.getCountryCode()))
				{
					producer.setCountryName(countryNameList.get(producer.getCountryCode()));
					CAFLogger.logInfo("Country Name In Domain Manager :"	+ countryNameList.get(producer.getCountryCode()),"ContactChubbDomainManager","uiResourceFromProducerList");
				}
			} else
				producer.setCountryName(producer.getCountryName());
			//producerResource.setMailingAddress(producer.getMailingAddress());
			producerResource.setMailingAddress(producer.friendlyAddress());
			producerResource.setProdAndProdSubNumber(producerResource.getProducerNumber()+"-"+producerResource.getProducerSubNumber());
			rsrc.add(producerResource);
		}
		requestResult.setProducerList(rsrc);

		return requestResult;

	}
	
	public ResourceRequestResult retrieveUserInfo(UserResource resource){

		UserProfileRetrievalAccessor accessor = new UserProfileRetrievalAccessor();
		ResourceRequestResult result =new ResourceRequestResult();

		try{
			UserInformation info=new UserInformation();
			info.setUserid(resource.getUserId());
			info.setExternalUserId(resource.getExternalUserId());
			UserInformation resultInfo= accessor.getUserInformation(info);
			
			result.setUserInformation(resultInfo);

		}catch (Exception e) {
			CAFLogger.logSevere("Exception caught while processing retrieveProducerList: " + e.getMessage(), "ContactChubbDomainManager", "retrieveProducerList");
			result.setStatusCode("E");
			result.setStatusMessage( e.getMessage());
			return result;

		}

		return result;

	}

}
                                                                   