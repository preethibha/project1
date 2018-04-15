package com.chubb.dgmk.caf.controller.svlt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.wink.json4j.JSONArray;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;

import pagecode.bean.CAFBean;



import com.chubb.dgmk.caf.controller.svlt.filter.ContactList;
import com.chubb.dgmk.caf.domain.manager.AccountFileDomainManager;
import com.chubb.dgmk.caf.domain.manager.BookOfBusinessDomainManager;
import com.chubb.dgmk.caf.domain.manager.ContactChubbDomainManager;
import com.chubb.dgmk.caf.domain.model.Contact;
import com.chubb.dgmk.caf.domain.resource.AccountResource;
import com.chubb.dgmk.caf.domain.resource.ContactResource;
import com.chubb.dgmk.caf.domain.resource.PasKeyResource;
import com.chubb.dgmk.caf.domain.resource.PolicyResource;
import com.chubb.dgmk.caf.domain.resource.ProducerKey;
import com.chubb.dgmk.caf.domain.resource.ResourceRequestResult;
import com.chubb.dgmk.caf.domain.resource.ResultIdentifierResource;
import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.ICAFConstants;

/**
 * <pre>
 * CAFResourceImpl
 * May 15, 2015
 * 
 * The CAFResourceImpl is responsible for implementing REST
 * services to handle requests made from the browser. It delegates
 * requests to the appropriate manager and transforms the response
 * resource object into JSON before returning to the browser
 *
 * </pre> 
 */
@Path("/commercial")
public class CAFResourceImpl {

	@Context
	private HttpServletRequest sessionRequest;

	/**
	 * <pre>
	 * retrieveAccountList
	 * May 19, 2015
	 * 
	 * This method is used to Search for the accounts by name. User Profile attributes are obtained
	 * from session if available, else from calling the UserProfile service. If
	 * user type is found to be "Agent" , user profile attribute of related
	 * producer numbers are added to the request into AccountFileDomainManager.
	 * Return an empty list or a list of Account objects with high-level account
	 * info valued. A list containing a single item may be returned.
	 * In case of single account it returns associated policies instead of returning account. 
	 *  
	 * @param accountRequest :JSON String which contains
	 * 		acctName
	 *            The Account Name to search for
	 * 		relatedAccounts
	 *            Indicates if related accounts should be included in the result
	 *            set (future use) Default to No
	 *            
	 * @return JSON String of ResourceRequestResult with the list of accounts matching the name
	 *         provided.
	 * 
	 * </pre>
	 */
	@POST
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String retrieveAccountList(String accountRequest) {
		
		CAFLogger.logInfo("Entered accounts REST Service", "CAFResourceImpl", "retrieveAccountList");
		com.ibm.json.java.JSONObject jsonRequest;
		try {
			jsonRequest = com.ibm.json.java.JSONObject.parse(accountRequest);
		} catch (IOException e) {
			CAFLogger.logSevere(e.getMessage(), this.getClass().getName(), "retrieveAccountList");
			e.printStackTrace();
			return null;
			
		}
		String name = (String) jsonRequest.get("acctName");
		CAFLogger.logInfo("About to search accounts with name: " + name, "CAFResourceImpl", "retrieveAccountList");
		
		CAFBean cafBean = (CAFBean) sessionRequest.getAttribute("cafBean");
		CAFLogger.logInfo("UserType from bean:  " + cafBean.getUserType(), "CAFResourceImpl", "retrieveAccountList");
		
		String iccUserType="";
		iccUserType = this.setICCUserType(cafBean, iccUserType);
		
		AccountFileDomainManager mgr = new AccountFileDomainManager();
		ResourceRequestResult result = mgr.retrieveAccount(name, iccUserType, cafBean.getProducerKeys());

		// create JSONArray from result and return
		String jsonStr = "";
		// If a single account is returned, call the retrievePolicies service
		// and build the result with the policy list
		try{
			JSONObject jsonObject = createJson(result);

			if("E".equals(result.getStatusCode())){
				jsonObject.put("accountList", createJsonArray(result.getAccountList()));
				jsonObject.put("result", createJson(result));
				jsonStr= jsonObject.toString();
				return jsonStr;
				
			}

			if(result.getAccountList()!=null && result.getAccountList().size()==1){
				List<AccountResource> accountResources=result.getAccountList();
				String insuredNumber=result.getAccountList().get(0).getWipInsuredNumber();
				result = mgr.retrievePolicies(null, null, insuredNumber,iccUserType, cafBean.getProducerKeys());
				jsonObject = createJson(result);
				
				JSONArray policyArr = new JSONArray();
				if(result!=null && result.getPolicyList()!=null){
					for (PolicyResource policy : result.getPolicyList()) {
						policyArr.add(createJson(policy).put("contacts", createJsonArray(policy.getContacts())));
					}
				}
				jsonObject.put("accountSummary", createJson(result.getResultIdResource()));
				jsonObject.put("accountList", createJsonArray(accountResources));
				jsonObject.put("policyList", policyArr);
				jsonObject.put("result", createJson(result));
				jsonStr= jsonObject.toString();
				CAFLogger.logInfo("Search The Account For Insured Number " + insuredNumber,  "CAFResourceImpl", "retrieveAccountList");
			} else {
				jsonObject.put("accountList", createJsonArray(result.getAccountList()));
				jsonObject.put("result", createJson(result));
				jsonStr= jsonObject.toString();
			}
		} catch (JSONException e) {
			String msg = "Exception occurred while creating JSON object: " + e;
			CAFLogger.logSevere(msg, "CAFResourceImpl", "retrieveAccountList");
			e.printStackTrace();
		}
		CAFLogger.logFine("Exited accounts REST Service", "CAFResourceImpl", "retrieveAccountList with response data");
		return jsonStr;

	}

	/**
	 * <pre>
	 * retrievePolicyList
	 * May 19, 2015
	 * 
	 * This method is used to Search for the policies by either 1)accountGroupID or 2) Insured Number
	 * or 3)Policy Number User Profile attributes are obtained from session if
	 * available, else from calling the UserProfile service. If user type is
	 * found to be "Agent" , user profile attribute of related producer numbers
	 * are added to the request into AccountFileDomainManager. Return
	 * ResourceRequestResult with an empty poicyList or a list containing
	 * PolicyResource objects with high-level policy info A list containing a
	 * single item may be returned.
	 * 
	 * @param policyRequest :A JSON String which contains policyNumber or accountGroupNumber or insuredNumber
	 * @return JSON String of ResourceRequestResult with the list of policies matching the policyNumber or accountGroupNumber or insuredNumber
	 *         provided.
	 *      
	 * </pre>
	 */

	@POST
	@Path("/policies")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String retrievePolicyList(String policyRequest) {

		CAFLogger.logInfo("Entered policies REST Service", "CAFResourceImpl", "retrievePolicyList");

		com.ibm.json.java.JSONObject jsonRequest;
		try {
			jsonRequest = com.ibm.json.java.JSONObject.parse(policyRequest);
		} catch (IOException e) {
			CAFLogger.logSevere(e.getMessage(), this.getClass().getName(), "retrievePolicyList");
			e.printStackTrace();
			return null;
			
		}

		String policyNumber = (String) jsonRequest.get("polNo");
		String insuredNumber = (String) jsonRequest.get("insuredNumber");
		String accountGroupNumber = (String) jsonRequest.get("accountGroupNumber");
		String policyDetail = "Policy Number :" + policyNumber + ", insuredNumber :"+ insuredNumber + ", accountGroupNumber :" + accountGroupNumber;
		CAFLogger.logInfo("About to search policies with " +policyDetail, "CAFResourceImpl", "policiesRequest");

		CAFBean cafBean = (CAFBean) sessionRequest.getAttribute("cafBean");
		CAFLogger.logInfo("UserType from bean:  " + cafBean.getUserType(), "CAFResourceImpl", "retrievePolicyList");
		
		String iccUserType="";
		iccUserType = this.setICCUserType(cafBean, iccUserType);
		
		AccountFileDomainManager mgr = new AccountFileDomainManager();
		ResourceRequestResult result = mgr.retrievePolicies(policyNumber, accountGroupNumber, insuredNumber,iccUserType,cafBean.getProducerKeys());

		// create JSONArray from result and return
		String jsonStr = "";
		try {
			JSONObject jsonObject = createJson(new ResourceRequestResult());
			
			JSONArray policyArr = new JSONArray();
			if(result!=null && result.getPolicyList()!=null){
				for (PolicyResource policy : result.getPolicyList()) {
					policyArr.add(createJson(policy).put("contacts", createJsonArray(policy.getContacts())));
				}
			}
			jsonObject.put("policyList", policyArr);
			jsonObject.put("accountSummary", createJson(result.getResultIdResource()));
			jsonObject.put("result", createJson(result));
			jsonStr= jsonObject.toString();
			if(result.getResultIdResource()!=null) 
			CAFLogger.logFine("ResultId resource:"+result.getResultIdResource().toString(),"CAFResourceImpl","retrievePolicyList");	
			
			
		} catch (JSONException e) {
			String msg = "Exception occurred while creating JSON object: " + e;
			CAFLogger.logSevere(msg, "CAFResourceImpl", "retrievePolicyList");
			e.printStackTrace();
		}
		CAFLogger.logInfo("Exited policies REST Service", "CAFResourceImpl", "retrievePolicyList with response data");
		return jsonStr;
		
	}

	/**
	 * <pre>
	 * setICCUserType
	 * August 4, 2015
	 * 
	 * This method is used to set user type for accessing ICC services.
	 * 
	 * @param cafBean
	 * @param iccUserType
	 * @return ICC user Type(Agent/ Employee)
	 * 
	 * </pre>
	 */
	private String setICCUserType(CAFBean cafBean, String iccUserType) {
		
		if(cafBean!=null){
			if(ICAFConstants.AGENT.equals(cafBean.getUserType())){
				iccUserType=ICAFConstants.ICC_AGENT;
			}else if(ICAFConstants.EMPLOYEE.equals(cafBean.getUserType())){
				iccUserType=ICAFConstants.ICC_EMPLOYEE;
			}
		}
		return iccUserType;
		
	}

	/**
	 * <pre>
	 * retrieveContactList
	 * May 19, 2015
	 * 
	 * A JSON object with policy key data including producing Branch
	 * and Policy Line of Business --AND--CP Numbers identifying
	 * contacts
	 *   
	 * @param contactRrequest : A JSON String which contains 
	 *           polNo : selected policy number for contact. 
	 *           policyTypeCode : Policy Type Code of selected policy for getting contact.
	 *           branchNumber :	Branch Number of selected policy for getting contact .
	 *           policySubTypCode : Policy Sub Type Code of selected policy for getting contact.
	 *           contacts: List of CP number based on type of contacts for policy.(This will default to Underwriter)
	 *           policyTerm,productComponentName,policyStatus is used to display header section in contact modal window.
	 *            	
	 * @return A JSON String of  ResourceRequestResult with a list of ContactResources which
	 *         will either be the assigned or default contacts
	 *         
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	@POST
	@Path("/contacts")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String retrieveContactList(String contactRrequest) {

		CAFLogger.logInfo("Entered contacts REST Service", "CAFResourceImpl",
				"contacts" + " with data...");

		List<ContactResource> contactResources=new ArrayList<ContactResource>();
		com.ibm.json.java.JSONObject jsonRequest;
		try {
			jsonRequest = com.ibm.json.java.JSONObject.parse(contactRrequest);
		} catch (IOException e) {
			CAFLogger.logSevere(e.getMessage(), this.getClass().getName(), "retrievePolicyList");
			e.printStackTrace();
			return null;
			
		}
		
		String policyNumber = (String) jsonRequest.get("polNo");
		String cpNumber = (String) jsonRequest.get("cpNumber");
		String policyTypeCode = (String) jsonRequest.get("policyTypeCode");
		String branchNumber = (String) jsonRequest.get("branchNumber");
		String policySubTypeCode = (String) jsonRequest.get("policySubTypCode");
		List<com.ibm.json.java.JSONObject> contactsJson = (List<com.ibm.json.java.JSONObject>) jsonRequest.get("contacts");
		
		String policyTerm=(String) jsonRequest.get("policyTerm");
		String displayProductTypeName=(String) jsonRequest.get("displayProductTypeName");
		String policyStatus=(String) jsonRequest.get("policyStatus");
		
		List<Contact> contacts = getPolicyContactsReq(contactsJson);
		
		
		ContactList contactList = new ContactList (policyNumber,cpNumber,policyTypeCode,branchNumber,policySubTypeCode,policyTerm,displayProductTypeName,policyStatus,contactsJson);
		CAFLogger.logFine("About to retrieve Contact List with " + contactList.toString(), "CAFResourceImpl", "retrieveContactList");
		CAFLogger.logInfo("About to retrieve Contact List with Policy Number: " + policyNumber + "And  CpNumber: " + cpNumber , "CAFResourceImpl", "retrieveContactList");
		// parse JSON request to create manager request object
		ContactChubbDomainManager mgr = new ContactChubbDomainManager();
		ResourceRequestResult result = mgr.retrievePolicyContactList(policyNumber,cpNumber,policyTypeCode,
				branchNumber,policySubTypeCode,contacts);

		// create JSONArray from result and return
		String jsonStr = "";
		try {
			JSONObject jsonObject = createJson(result);

			if(result.getPolicyList()!=null && !result.getPolicyList().isEmpty()){
				result.getPolicyList().get(0).setPolicyStatus(policyStatus);
				result.getPolicyList().get(0).setPolicyNumber(policyNumber);
				result.getPolicyList().get(0).setDisplayProductTypeName(displayProductTypeName);
				result.getPolicyList().get(0).setPolicyTerm(policyTerm);

				contactResources=result.getPolicyList().get(0).getContacts();
			}else{
				List<PolicyResource> policyResources =new ArrayList<PolicyResource>();
				PolicyResource  resource =new PolicyResource();

				resource.setPolicyStatus(policyStatus);
				resource.setPolicyNumber(policyNumber);
				resource.setDisplayProductTypeName(displayProductTypeName);
				resource.setPolicyTerm(policyTerm);
				policyResources.add(resource);
				result.setPolicyList(policyResources);
			}

			jsonObject.put("policyList", createJsonArray(result.getPolicyList()));
			jsonObject.put("contactList", createJsonArray(contactResources));
			jsonObject.put("result", createJson(result));
			jsonStr= jsonObject.toString();

		} catch (JSONException e) {
			String msg = "Exception occurred while creating JSON object: " + e;
			CAFLogger.logSevere(msg, "CAFResourceImpl", "retrieveContactList");
			e.printStackTrace();
		}
		CAFLogger.logFine("Exited contacts REST Service", "CAFResourceImpl",
				"contacts" + " with response data"+jsonStr);
		return jsonStr;
		
	}

	/**
	 * <pre>
	 * getPolicyContactsReq
	 *  
	 * This method is used to create contact object based on request.
	 * 
	 * @param contactsJson
	 * @return returns list of contacts with CP number and role
	 * 
	 * </pre>
	 */
	private List<Contact> getPolicyContactsReq(List<com.ibm.json.java.JSONObject> contactsJson) {
		
		List<Contact> contacts =new ArrayList<Contact>();
		for (com.ibm.json.java.JSONObject obj : contactsJson) {
			if(obj !=null){
				Contact contact=new  Contact();
				contact.setCpNumber(obj.get("cpNumber").toString());
				contact.setRole(obj.get("role").toString());
				contacts.add(contact);
			}
		}
		return contacts;
		
	}

	/**
	 * <pre>
	 * retrieveDefaultContactList
	 * May 19, 2015
	 * 
	 * A JSON object with Producing Branch Code (required) and Product Code (optional)
	 * The type of contact requested. This will default to Underwriter.
	 * 
	 * @param contactRequest : A JSON String which contains 
	 * 			branchCode(required) and productCode (optional)
	 * 
	 * @return A JSON string of ResourceRequestResult with a list of Default ContactResources
	 *         for the given Branch/Product combination
	 * </pre>
	 */
	@POST
	@Path("/defaultContacts")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String retrieveDefaultContactList(String contactRequest) {

		CAFLogger.logInfo("Entered defaultContactList REST Service", "CAFResourceImpl", "retrieveDefaultContactList");

		com.ibm.json.java.JSONObject jsonRequest;
		try {
			jsonRequest = com.ibm.json.java.JSONObject.parse(contactRequest);
		} catch (IOException e) {
			CAFLogger.logSevere(e.getMessage(), this.getClass().getName(), "retrieveDefaultContactList");
			e.printStackTrace();
			return null;
		}

		String branchCode = (String) jsonRequest.get("branchCode");
		String productCode = (String) jsonRequest.get("productCode");
		String branchProductCode = "Brach Code :" + branchCode + ", Product Code :" + productCode;
		CAFLogger.logInfo("About to retrieve default Contact List with " + branchProductCode , 
				"CAFResourceImpl", "retrieveDefaultContactList");


		ContactChubbDomainManager mgr = new ContactChubbDomainManager();
		ResourceRequestResult result = mgr.retrieveDefaultContactList(productCode, branchCode, null);

		// create JSONArray from result and return
		String jsonStr = "";
		try {
			JSONObject jsonObject = createJson(result);
			jsonObject.put("contactList", createJsonArray(result.getContactList()));
			jsonObject.put("result", createJson(result));
			jsonStr= jsonObject.toString();

		} catch (JSONException e) {
			String msg = "Exception occurred while creating JSON object: " + e;
			CAFLogger.logSevere(msg, "CAFResourceImpl", "retrieveDefaultContactList");
			e.printStackTrace();
		}
		CAFLogger.logFine("Exited defaultContactList REST Service", "CAFResourceImpl", "retrieveDefaultContactList with response date "+jsonStr);
		return jsonStr;
		
	}

	/**
	 * <pre>
	 * retrieveBranchList
	 * May 19, 2015
	 * 
	 * This method is used to get list of US producing branches.
	 * 
	 * @return A JSON string of ResourceRequestResult with a list of US Producing Branches
	 * 
	 * </pre>
	 */
	@GET
	@Path("/branches")
	@Produces(MediaType.APPLICATION_JSON)
	public String retrieveBranchList() {

		CAFLogger.logInfo("Entered retrieveBranchList REST Service",
				"CAFResourceImpl", "branchList");

		ContactChubbDomainManager mgr = new ContactChubbDomainManager();
		ResourceRequestResult result = mgr.retrieveBranchList();
				
		// create JSONArray from result and return
		String jsonStr = "";
		try {
			JSONObject jsonObject = createJson(result);
			jsonObject.put("branchList", createJsonArray(result.getBranchList()));
			jsonObject.put("result", createJson(result));
			jsonStr= jsonObject.toString();
			
		} catch (JSONException e) {
			String msg = "Exception occurred while creating JSON object: " + e;
			CAFLogger
					.logSevere(msg, "CAFResourceImpl", "retrieveBranchList");
			e.printStackTrace();
		}
		CAFLogger.logFine("Exited retrieveBranchList REST Service",
				"CAFResourceImpl", "branchList with response date "+jsonStr);
		
		return jsonStr;
		
	}

	/**
	 * <pre>
	 * retrieveProductList
	 * May 19, 2015
	 * 
	 * This method is used to get a list of AtChubb products.
	 * 
	 * @return A ResourceRequestResult with a list of AtChubb Products
	 * 
	 * </pre>
	 */
	@GET
	@Path("/products")
	@Produces(MediaType.APPLICATION_JSON)
	public String retrieveProductList() {

		CAFLogger.logInfo("Entered retrieveProductList REST Service",
				"CAFResourceImpl", "retrieveProductList");

		ContactChubbDomainManager mgr = new ContactChubbDomainManager();
		ResourceRequestResult result = mgr.retrieveAtChubbProductList();
		
		// create JSONArray from result and return
		String jsonStr = "";
		try {
			JSONObject jsonObject = createJson(result);
			jsonObject.put("productList", createJsonArray(result.getProductList()));
			jsonObject.put("result", createJson(result));
			jsonStr= jsonObject.toString();
			
		} catch (JSONException e) {
			String msg = "Exception occurred while creating JSON object: " + e;
			CAFLogger
					.logSevere(msg, "CAFResourceImpl", "retrieveProductList");
			e.printStackTrace();
		}
		CAFLogger.logFine("Exited retrieveProductList REST Service",
				"CAFResourceImpl", "retrieveProductList with response data "+jsonStr);
		
		return jsonStr;
		
	}

	/**
	 * <pre>
	 * retrieveProducerList
	 * May 19, 2015
	 * 
	 * This method is used to get producer list.
	 * If user type is found to be "Agent" , user profile attribute of related
	 * producer numbers are added to the request else in case of Employee user provided producer and sub producer number from UI
	 * and based on that this method returns the result.
	 *  
	 * @param producerRequest :
	 *            A JSON object with Producer Number & SubNumber for each
	 *            producer requested.
	 *            
	 * @return A JSON String of ResourceRequestResult with a list of Producers the user has
	 *         access to.
	 * </pre>
	 */
	@POST
	@Path("/producers")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String retrieveProducerList(String producerRequest) {

		CAFLogger.logInfo("Entered retrieveProducerList REST Service",
				"CAFResourceImpl", "producers" + " with data...");

		List<ProducerKey> producers = new ArrayList<ProducerKey>();
		CAFBean cafBean = (CAFBean) sessionRequest.getAttribute("cafBean");
		String iccUserType="";
		iccUserType = this.setICCUserType(cafBean, iccUserType);
		if(producerRequest!=null && producerRequest.length()>2  && iccUserType.equals(ICAFConstants.ICC_EMPLOYEE)){
			com.ibm.json.java.JSONObject jsonRequest;

			try {
				jsonRequest = com.ibm.json.java.JSONObject.parse(producerRequest);
			} catch (IOException e) {
				CAFLogger.logSevere(e.getMessage(), this.getClass().getName(), "retrieveDefaultContactList");
				e.printStackTrace();
				return null;
			}

			String producerNumber = (String) jsonRequest.get("producerNumber");
			String producerSubNumber = (String) jsonRequest.get("producerSubNumber");
			ProducerKey producerKey=new ProducerKey();
			producerKey.setProducerNumber(producerNumber);
			producerKey.setProducerSubNumber(producerSubNumber);

			CAFLogger.logInfo("About to retrieve producerList List with "+ producerKey.toString() , 
					"CAFResourceImpl", "retrieveProducerList"); 
			
			producers.add(producerKey);
		}
		else{
			// Get the producer key data from the CAFBean in session (In case of logged in user is Agent)

			producers = cafBean.getProducerKeys();
		}

		ContactChubbDomainManager mgr = new ContactChubbDomainManager();
		ResourceRequestResult result = mgr.retrieveProducerList(producers);

		// create JSONArray from result and return
		String jsonStr = "";
		try {
			JSONObject jsonObject = createJson(result);
			jsonObject.put("producerList", createJsonArray(result.getProducerList()));
			jsonObject.put("result", createJson(result));
			if(cafBean.getEmailAddress() != null){
				jsonObject.put("emailAddress", cafBean.getEmailAddress());
			}
			jsonStr= jsonObject.toString();

		} catch (JSONException e) {
			String msg = "Exception occurred while creating JSON object: " + e;
			CAFLogger
			.logSevere(msg, "CAFResourceImpl", "retrieveProducerList");
			e.printStackTrace();
		}

		CAFLogger.logFine("Exited retrieveProducerList REST Service",
				"CAFResourceImpl", "producers" + " with data..."+jsonStr);
		
		return jsonStr;
		
	}
	
	@POST
	@Path("/pas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String retrievePasList(String producerRequest) {

		CAFLogger.logInfo("Entered retrieveProducerList REST Service",
				"CAFResourceImpl", "producers" + " with data...");

		List<PasKeyResource> producers = new ArrayList<PasKeyResource>();
		CAFBean cafBean = (CAFBean) sessionRequest.getAttribute("cafBean");
		CAFLogger.logInfo("UserType from bean:  " + cafBean.getUserType(), "CAFResourceImpl", "retrieveAccountList");
		String iccUserType="";
		iccUserType = this.setICCUserType(cafBean, iccUserType);
		if(producerRequest!=null && producerRequest.length()>2 && iccUserType.equals(ICAFConstants.ICC_EMPLOYEE)){
			com.ibm.json.java.JSONObject jsonRequest;

			try {
				jsonRequest = com.ibm.json.java.JSONObject.parse(producerRequest);
			} catch (IOException e) {
				CAFLogger.logSevere(e.getMessage(), this.getClass().getName(), "retrieveDefaultContactList");
				e.printStackTrace();
				return null;
			}

			String pasNumber = (String) jsonRequest.get("pasNumber");
			//String pasSubNumber = (String) jsonRequest.get("pasSubNumber");
			PasKeyResource pasKey=new PasKeyResource();
			pasKey.setPasNumber(pasNumber);
			producers.add(pasKey);
		

			CAFLogger.logInfo("About to retrieve producerList List with "+ pasKey.toString() , 
					"CAFResourceImpl", "retrieveProducerList"); 
			
			
		}
		else{
			// Get the producer key data from the CAFBean in session (In case of logged in user is Agent)

			producers = cafBean.getPasKeys();
		}

		ContactChubbDomainManager mgr = new ContactChubbDomainManager();
		ResourceRequestResult result = mgr.retrievePasList(producers);

		// create JSONArray from result and return
		String jsonStr = "";
		try {
			JSONObject jsonObject = createJson(result);
			jsonObject.put("producerList", createJsonArray(result.getProducerList()));
			jsonObject.put("result", createJson(result));
			if(cafBean.getEmailAddress() != null){
				jsonObject.put("emailAddress", cafBean.getEmailAddress());
			}
			jsonStr= jsonObject.toString();

		} catch (JSONException e) {
			String msg = "Exception occurred while creating JSON object: " + e;
			CAFLogger
			.logSevere(msg, "CAFResourceImpl", "retrieveProducerList");
			e.printStackTrace();
		}

		CAFLogger.logFine("Exited retrieveProducerList REST Service",
				"CAFResourceImpl", "producers" + " with data..."+jsonStr);
		
		return null;
		
	}


	/**
	 * <pre>
	 * requestBookOfBusiness
	 * May 19, 2015
	 * 
	 * This method is used for sending Book of business data on requested E-mail
	 * 
	 * @param bobRequest :
	 *            A JSON object with Producer Number & SubNumber for each
	 *            producer requested
	 *            
	 * @return A JSON String of ResourceRequestResult object with status = "S" on successful
	 *         send. If an exception occurs, update status to "E" along with a
	 *         friendly message. Append the exception message for problem
	 *         reporting
	 *  </pre>         
	 */

	@POST
	@Path("/bookOfBusiness")
	@Produces(MediaType.APPLICATION_JSON)
	public String requestBookOfBusiness(String bobRequest){

		CAFLogger.logInfo(
				"Entered requestBookOfBusiness REST Service with data:... "+bobRequest,
				"CAFResourceImpl", "bookOfBusiness");

		ResourceRequestResult result =new ResourceRequestResult();

		if(bobRequest!=null && bobRequest.length()>2){
			com.ibm.json.java.JSONObject jsonRequest;

			try {
				jsonRequest = com.ibm.json.java.JSONObject.parse(bobRequest);
			} catch (IOException e) {
				CAFLogger.logSevere(e.getMessage(), this.getClass().getName(), "retrieveDefaultContactList");
				e.printStackTrace();
				return null;
				
			}

			String producerNumber = (String) jsonRequest.get("producerNumber");
			String producerSubNumber = (String) jsonRequest.get("subProducerNumber");
			String emailAddress = (String) jsonRequest.get("emailAddress");
			String producerDetail = "Producer Number :" + producerNumber + ", Producer SubNumber :"+ producerSubNumber + ", Email Address :" + emailAddress;
			
			CAFLogger.logInfo("About to retrieve producerList List with "+ producerDetail , 
					"CAFResourceImpl", "requestBookOfBusiness");
			
			if(!"".equals(emailAddress)){
				BookOfBusinessDomainManager mgr = new BookOfBusinessDomainManager();
				result = mgr.submitBookOfBusinessRequest(
						producerNumber, producerSubNumber, emailAddress);
			}else{
				result.setStatusCode("E");
				result.setStatusMessage("Please provide user email address");
			}
		}
		else{
			result.setStatusCode("E");
			result.setStatusMessage("Please select producer before sending mail");
		}

		// create JSONArray from result and return
		String jsonStr = "";
		try {

			JSONObject jsonObject = createJson(result);
			jsonObject.put("result", createJson(result));
			jsonStr= jsonObject.toString();
		} catch (JSONException e) {
			String msg = "Exception occurred while creating JSON object: " + e;
			CAFLogger
			.logSevere(msg, "CAFResourceImpl", "requestBookOfBusiness");
			e.printStackTrace();

		}

		CAFLogger.logFine(
				"Entered requestBookOfBusiness REST Service with data:... ",
				"CAFResourceImpl", "bookOfBusiness with response data "+jsonStr);
		
		return jsonStr;
		
	}

	/**
	 * <pre>
	 * createJson
	 * 
	 * This method is used to create JSON object.
	 * 
	 * @param object
	 * @return A JSON representation of the request object for ResourceRequestResult.
	 * @throws JSONException
	 *             An exception is thrown if the object cannot be created
	 * 
	 * </pre>
	 */
		
	private JSONObject createJson(ResourceRequestResult object) throws JSONException {
		
		JSONObject jsonObject = new JSONObject(object);
		jsonObject=cleanJson(jsonObject);

		return jsonObject;
		
	}
	
	/**
	 * <pre>
	 * createJson 
	 * 
	 * This method is used to create JSON object for ResultIdentifierResource.
	 * 
	 * @param object
	 * @return return JSON object of ResultIdentifierResource.
	 * @throws JSONException
	 * 
	 * </pre>
	 */
	private JSONObject createJson(ResultIdentifierResource object) throws JSONException {
		
		JSONObject jsonObject = new JSONObject(object);
		jsonObject=cleanJson(jsonObject);

		return jsonObject;
		
	}

	/**
	 * <pre>
	 * createJson 
	 * 
	 * This method is used to create JSON object for PolicyResource.
	 * 
	 * @param object
	 * @return return JSON object of PolicyResource.
	 * @throws JSONException
	 * 
	 * </pre>
	 */
	private JSONObject createJson(PolicyResource object) throws JSONException {
		
		JSONObject jsonObject = new JSONObject(object);
		jsonObject=cleanJson(jsonObject);

		return jsonObject;
		
	}
	
	/**
	 * <pre>
	 * createJsonArray 
	 * 
	 * This method is used to create JSON array.
	 * 
	 * @param List
	 * @return A JSON Array formed by list of JSON objects
	 * @throws JSONException
	 *             An exception is thrown if the object cannot be created
	 *             
	 * </pre>
	 */
	private JSONArray createJsonArray(List<?> resourceList) throws JSONException {
		
		JSONArray typeArray = new JSONArray();
		if(resourceList== null){
			return null;
		}else{
			for (Object obj : resourceList) {
				JSONObject jsonObj = new JSONObject(obj);
				cleanJson(jsonObj);
				typeArray.add(jsonObj);
			}
		}
		return typeArray;
		
	}

	/**
	 * <pre>
	 * cleanJson 
	 * 
	 * This method is used to remove extraneous fields from the JSON object.
	 * 
	 * @param jsonObject
	 *            Remove extraneous fields from the JSON object
	 * @throws JSONException 
	 * 
	 * </pre>
	 */
	private JSONObject cleanJson(JSONObject jsonObject) throws JSONException{
		
		jsonObject.remove("_classname");
		jsonObject.remove("_type");
		jsonObject.remove("class");
		return jsonObject;
		
	}
}
