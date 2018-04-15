package com.chubb.dgmk.caf.wsc.accessors.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chubb.dgmk.caf.domain.model.Contact;
import com.chubb.dgmk.caf.domain.model.Policy;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.wsc.accessors.ChubbContactRetrievalAccessor;

import ei.corporate.contact_retrieval_crp30x1_http.ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy;
import ei.corporate.get_default_contact_reply_crp30x1.GetDefaultContactReply;
import ei.corporate.get_default_contact_request_crp30x1.GetDefaultContactRequest;
import ei.corporate.get_policy_contact_list_by_defined_role_reply_crp30x1.GetPolicyContactListByDefinedRoleReply;
import ei.corporate.get_policy_contact_list_by_defined_role_request_crp30x1.GetPolicyContactListByDefinedRoleRequest;

public class ChubbContactRetrievalAccessorTest {

	ChubbContactRetrievalAccessor chubbContactRetrievalAccessor;
	ChubbContactRetrievalAccessor privateObject;
	Method privateMethod;

	/**
	 * This method is used to test for setUp test data
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		chubbContactRetrievalAccessor=new ChubbContactRetrievalAccessor();
		privateObject=new ChubbContactRetrievalAccessor();
		
		CAFPropertiesUtil.setCommercialPolicyRetrievalEndpoint("http://eicomlinsdgrppolrtrvlcrm33x1-st/CRM6ServicesWeb/sca/CommercialInsuredGroupPolicyRetrievalCRM33X1Http");
		CAFPropertiesUtil.setContactRetrievalEndpoint("http://eicntctretvlcrp30x1-st/Corporate4ServicesWeb/sca/ContactRetrievalCRP30X1Http");
		CAFPropertiesUtil.setBranchRetrievalEndpoint("http://EIBRRETCRP2X1S/Corporate2ServicesWeb/sca/BranchRetrievalCRP2X1Http");
		CAFPropertiesUtil.setProducerRetrievalEndpoint("http://eiprodretprd2x5-st/Producer2ServicesWeb/sca/ProducerRetrievalPRD2X5Http");
	}

	/**
	 * <pre>
	 * 
	 * testGetEndpoint
	 * June 30, 2015
	 * 
	 * This method is used to test the endPoint for the ContactRetrieval service from
	 * the properties file.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetEndpoint() {
		String endPoint=chubbContactRetrievalAccessor.getEndpoint();
		assertTrue("Invalid endPoint url",endPoint.equals(CAFPropertiesUtil.getContactRetrievalEndpoint()));
	}

	/**
	 * <pre>
	 * 
	 * testGetChubbContacts
	 * June 30, 2015
	 * 
	 * This method is used to test A list of Policies with Contact info valued for each valid parameter.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetChubbContacts() {
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		Contact contact = new Contact();
		contact.setCpNumber("004583528118");
		contact.setRole("UND");
		
		String policyNo = "000004860880";
		String cpNumber ="030838543600";
		String policyTypeCode = "48";
		String policySubType ="";
		String branchNumber ="0365";
		contacts.add(contact);
		
		
		List<Policy> policies;
		try {
			policies = chubbContactRetrievalAccessor.getChubbContacts(policyNo,cpNumber,policyTypeCode,
					branchNumber,policySubType, contacts);
			
			assertTrue("Policy list should not be empty",policies.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * <pre>
	 * 
	 * testGetChubbContacts
	 * June 30, 2015
	 * 
	 * This method is used to test for contacts when product, branch and context set to valid values.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */

	@Test
	public final void testGetDefaultContacts() {

		String productCode="99999";
		String branchCode="0001";
		String context="uiRequest";

		List<Contact> contacts;
		try {
			contacts = chubbContactRetrievalAccessor.getDefaultContacts(productCode, branchCode, context);
			assertTrue("Contact list should not be empty",contacts.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <pre>
	 * 
	 * testGetDefaultContacts_Blank
	 * June 30, 2015
	 * 
	 * This method is used to test for contacts when product, branch and context set to blank values.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetDefaultContacts_Blank() {

		String productCode="";
		String branchCode="";
		String context="";

		List<Contact> contacts;
		try {
			contacts = chubbContactRetrievalAccessor.getDefaultContacts(productCode, branchCode, context);
			assertTrue("Contact list should be empty",contacts.size()==0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	/**
	 * <pre>
	 * 
	 * testGetDefaultContacts_Invalid
	 * June 30, 2015
	 * 
	 * This method is used to test for contacts when product, branch and context set to blank values.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetDefaultContacts_Invalid() {

		String productCode="test";
		String branchCode="test";
		String context="test";

		List<Contact> contacts;
		try {
			contacts = chubbContactRetrievalAccessor.getDefaultContacts(productCode, branchCode, context);
			assertTrue("Contact list should be empty",contacts.size()==0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	/**
	 * <pre>
	 * 
	 * testBuildRequest
	 * June 30, 2015
	 *
	 * This method is used map the CAF Model object to the request object required by the provider service.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testBuildRequest() {
		
		String productCode="0010";
		String branchCode="0121";
		String context="uiRequest";
		
		Object[] args = {productCode,branchCode,context};
		try {
			privateMethod = ChubbContactRetrievalAccessor.class.
			getDeclaredMethod("buildRequest", new Class<?>[]{java.lang.String.class,java.lang.String.class,java.lang.String.class});
			privateMethod.setAccessible(true);

			GetDefaultContactRequest request = (GetDefaultContactRequest) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("Invalid value for Productcode ",productCode.equals(request.getGetDefaultUnderwriterInputs().get(0).getMarketingProductGroupCode()));
			assertTrue("Invalid value for Branch Code  ",branchCode.equals(request.getGetDefaultUnderwriterInputs().get(0).getBranchNumber()));

		}catch(Exception e){
			e.printStackTrace();
			fail("Request creation failed");
		}
	}
	
	/**
	 * <pre>
	 * 
	 * testBuildRequest
	 * June 30, 2015
	 *
	 * This method is used map the CAF Model object to the request object required by the provider service.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testBuildRequest_policyNo() {
		
		String policyNO="000054340534";
		String cpNumber ="002061113200";
		String policyTypeCode ="61";
		String branchNumber = "0001";
		String policySubTypeCode = "01";
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		Object[] args = {policyNO, cpNumber, policyTypeCode,branchNumber, policySubTypeCode, contacts};
		try {
			privateMethod = ChubbContactRetrievalAccessor.class.
			getDeclaredMethod("buildRequest", new Class<?>[]{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.util.List.class});
			privateMethod.setAccessible(true);

			GetPolicyContactListByDefinedRoleRequest request = (GetPolicyContactListByDefinedRoleRequest) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("Invalid value for Policy NO ",policyNO.equals(request.getGetPolicyContactListByDefinedRoleInputs().get(0).getPolicyNumber()));
			assertTrue("Invalid value for PolicyTypeCode ",policyTypeCode.equals(request.getGetPolicyContactListByDefinedRoleInputs().get(0).getPolicyTypeCode()));
			assertTrue("Invalid value for Branch NO ",branchNumber.equals(request.getGetPolicyContactListByDefinedRoleInputs().get(0).getBranchNumber()));
			assertTrue("Invalid value for policySubTypeCode ",policySubTypeCode.equals(request.getGetPolicyContactListByDefinedRoleInputs().get(0).getPolicyTypeSubCode()));
			
			

		}catch(Exception e){
			e.printStackTrace();
			fail("Request creation failed");
		}
	}
	
	/**
	 * <pre>
	 * 
	 * testDomainObjectFromContactProvider
	 * June 30, 2015
	 *
	 * This method is used convert the reply from the provider to CAF domain objects for contact.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testDomainObjectFromContactProvider() {
		
		String productCode="99999";
		String branchCode="0001";
		String context="uiRequest";
		
		Object[] args = {productCode,branchCode,context};
		
		try {
			//Get Request Object
			privateMethod = ChubbContactRetrievalAccessor.class.
			getDeclaredMethod("buildRequest", new Class<?>[]{java.lang.String.class,java.lang.String.class,java.lang.String.class});
			privateMethod.setAccessible(true);
			GetDefaultContactRequest contactRequest = (GetDefaultContactRequest) privateMethod.invoke(privateObject, (Object[])args);
			
			//Create Reply object
			
			String endpoint ="http://wps70UT/Corporate4ServicesWeb/sca/ContactRetrievalCRP30X1Http";
			
			ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy proxy =new ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy();
			proxy._getDescriptor().setEndpoint(endpoint);
			
			GetDefaultContactReply reply = proxy.getDefaultContact(contactRequest);
			
			Object[] args1 = {reply};
			
			privateMethod = ChubbContactRetrievalAccessor.class.
			getDeclaredMethod("domainObjectFromContactProvider", new Class<?>[]{GetDefaultContactReply.class});
			privateMethod.setAccessible(true);

			ArrayList<Contact> contacts=(ArrayList<Contact>) privateMethod.invoke(privateObject, (Object[])args1);
			
			assertTrue("Contact list should not be empty",contacts.size()>0);

		}catch(Exception e){
			e.printStackTrace();
			fail("Contacts creation failed");
		}
	}
	
	/**
	 * <pre>
	 * 
	 * testDomainObjectFromContactProvider_Empty
	 * June 30, 2015
	 *
	 * This method is used convert the reply from the provider to CAF domain objects for contact.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testDomainObjectFromContactProvider_Invalid() {
		
		String productCode="123";
		String branchCode="321";
		String context="uiRequest";
		
		Object[] args = {productCode,branchCode,context};
		
		try {
			//Get Request Object
			privateMethod = ChubbContactRetrievalAccessor.class.
			getDeclaredMethod("buildRequest", new Class<?>[]{java.lang.String.class,java.lang.String.class,java.lang.String.class});
			privateMethod.setAccessible(true);
			GetDefaultContactRequest contactRequest = (GetDefaultContactRequest) privateMethod.invoke(privateObject, (Object[])args);
			
			//Create Reply object
			
			String endpoint ="http://wps70UT/Corporate4ServicesWeb/sca/ContactRetrievalCRP30X1Http";
			
			ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy proxy =new ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy();
			proxy._getDescriptor().setEndpoint(endpoint);
			
			GetDefaultContactReply reply = proxy.getDefaultContact(contactRequest);
			
			Object[] args1 = {reply};
			
			privateMethod = ChubbContactRetrievalAccessor.class.
			getDeclaredMethod("domainObjectFromContactProvider", new Class<?>[]{GetDefaultContactReply.class});
			privateMethod.setAccessible(true);

			ArrayList<Contact> contacts=(ArrayList<Contact>) privateMethod.invoke(privateObject, (Object[])args1);
			
			assertTrue("Contact list should not be empty",contacts.size()==0);

		}catch(Exception e){
			e.printStackTrace();
			fail("Contacts creation failed");
		}
	}
	
	/**
	 * <pre>
	 * 
	 * testDomainObjectFromPolicyProvider
	 * June 30, 2015
	 *
	 * This method is used convert the reply from the provider to CAF domain objects for policy.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testDomainObjectFromPolicyProvider() {

		String policyNO="000081096194";
		String cpNumber ="030838543600";
		String policyTypeCode ="61";
		String branchNumber = "0001";
		String policySubTypeCode = "";
		List<Contact> contacts = new ArrayList<Contact>();
		Object[] args = {policyNO, cpNumber, policyTypeCode,branchNumber, policySubTypeCode, contacts};
		try {
			privateMethod = ChubbContactRetrievalAccessor.class.
			getDeclaredMethod("buildRequest", new Class<?>[]{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.util.List.class});
			privateMethod.setAccessible(true);
			
			GetPolicyContactListByDefinedRoleRequest request = (GetPolicyContactListByDefinedRoleRequest) privateMethod.invoke(privateObject, (Object[])args);
			
			//Create GetPolicyContactListReply from end point using above request
			String endpoint = "http://wps70UT/Corporate4ServicesWeb/sca/ContactRetrievalCRP30X1Http";
			ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy proxy =new ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy();
			proxy._getDescriptor().setEndpoint(endpoint);
			
			GetPolicyContactListByDefinedRoleReply reply = proxy.getPolicyContactListByDefinedRole(request);
			Object[] args1 = {reply};
			privateMethod = ChubbContactRetrievalAccessor.class.
			getDeclaredMethod("domainObjectFromPolicyProvider", new Class<?>[]{GetPolicyContactListByDefinedRoleReply.class});
			privateMethod.setAccessible(true);

			ArrayList<Policy> policies=(ArrayList<Policy>) privateMethod.invoke(privateObject, (Object[])args1);

			assertTrue("Policy list should not be empty",policies.size()>0);

		}catch(Exception e){
			e.printStackTrace();
			fail("Policies creation failed");
		}
	}
	
	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		chubbContactRetrievalAccessor=null;
		privateObject=null;
	}
}
