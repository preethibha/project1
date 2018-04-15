package com.chubb.dgmk.caf.domain.manager.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chubb.dgmk.caf.domain.manager.ContactChubbDomainManager;
import com.chubb.dgmk.caf.domain.model.Branch;
import com.chubb.dgmk.caf.domain.model.Contact;
import com.chubb.dgmk.caf.domain.model.Policy;
import com.chubb.dgmk.caf.domain.model.Product;
import com.chubb.dgmk.caf.domain.resource.BranchResource;
import com.chubb.dgmk.caf.domain.resource.ContactResource;
import com.chubb.dgmk.caf.domain.resource.PolicyResource;
import com.chubb.dgmk.caf.domain.resource.ProducerKey;
import com.chubb.dgmk.caf.domain.resource.ProductResource;
import com.chubb.dgmk.caf.domain.resource.ResourceRequestResult;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;

/**
 * @author NPGM50M
 *
 */
public class ContactChubbDomainManagerTest {

	ContactChubbDomainManager chubbDomainManager;
	ContactChubbDomainManager privateObject;
	Method privateMethod;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		chubbDomainManager=new ContactChubbDomainManager();
		privateObject=new ContactChubbDomainManager();
		
		CAFPropertiesUtil.setCommercialPolicyRetrievalEndpoint("http://eicomlinsdgrppolrtrvlcrm33x1-st/CRM6ServicesWeb/sca/CommercialInsuredGroupPolicyRetrievalCRM33X1Http");
		CAFPropertiesUtil.setContactRetrievalEndpoint("http://eicntctretvlcrp30x1-st/Corporate4ServicesWeb/sca/ContactRetrievalCRP30X1Http");
		CAFPropertiesUtil.setBranchRetrievalEndpoint("http://EIBRRETCRP2X1S/Corporate2ServicesWeb/sca/BranchRetrievalCRP2X1Http");
		CAFPropertiesUtil.setProducerRetrievalEndpoint("http://eiprodretprd2x5-st/Producer2ServicesWeb/sca/ProducerRetrievalPRD2X5Http");
		
	}

	/**
	 * <pre>
	 * 
	 * testRetrievePolicyContactList
	 * June 26, 2015
	 *
	 * This method is used to test retrieve list of ContactResources which will either be the assigned or default contacts
	 * based on policies and context
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrievePolicyContactList() {
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		Contact contact = new Contact();
		contact.setCpNumber("004583528118");
		contact.setRole("UND");
		
		String policyNumber = "000004860880";
		String cpNumber ="030838543600";
		String policyTypeCode = "48";
		String policySubType ="";
		String branchNumber ="0365";
		contacts.add(contact);

		ResourceRequestResult requestResult= chubbDomainManager.retrievePolicyContactList(policyNumber,cpNumber,policyTypeCode, branchNumber, policySubType, contacts);

		assertTrue("Error code should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("Contact list should not empty",requestResult.getPolicyList().size()>0);

	}

	/**
	 * <pre>
	 * 
	 * testRetrievePolicyContactList_No_Record
	 * June 26, 2015
	 *
	 * This method is used to test retrieve list of ContactResources which will either be the assigned or default contacts
	 * based on policies and context
	 * 
	 * This is used to test scenario when no contact is associated with policy.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrievePolicyContactList_No_Record() {
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		Contact contact = new Contact();
		contact.setCpNumber("004583520000");
		contact.setRole("UND");
		
		String policyNumber = "000004860880";
		String cpNumber ="030838543600";
		String policyTypeCode = "48";
		String policySubType ="";
		String branchNumber ="0365";
		contacts.add(contact);

		ResourceRequestResult requestResult= chubbDomainManager.retrievePolicyContactList(policyNumber,cpNumber,policyTypeCode, branchNumber, policySubType, contacts);

		assertTrue("Error code should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("Contact list should be empty",requestResult.getPolicyList().size()==0);

	}

	/**
	 * <pre>
	 * 
	 * testRetrievePolicyContactList_Null
	 * June 26, 2015
	 *
	 * This method is used to test retrieve list of ContactResources which will either be the assigned or default contacts
	 * based on policies and context
	 *  
	 * This is used to test negative scenario when contact set to null.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrievePolicyContactList_Null() {
		String errorMsg="ECRP30003 E The Contact Retrieval Service was unable to process due to a technical error. <Context is required>";
		List<Contact> contacts = new ArrayList<Contact>();
		
		Contact contact = null;
		
		String policyNumber = null;
		String cpNumber =null;
		String policyTypeCode = null;
		String policySubType =null;
		String branchNumber =null;
		contacts.add(contact);

		ResourceRequestResult requestResult= chubbDomainManager.retrievePolicyContactList(policyNumber,cpNumber,policyTypeCode, branchNumber, policySubType, contacts);

		assertTrue("Error code should be E","E".equals(requestResult.getStatusCode()));
		assertTrue("Contact list should be null",requestResult.getContactList()==null);
		assertTrue("Error mesage should not be empty",errorMsg.equals(requestResult.getStatusMessage()));

	}
	
	/**
	 * <pre>
	 * 
	 * testRetrievePolicyContactList_Empty
	 * June 26, 2015
	 *
	 * This method is used to test retrieve list of ContactResources which will either be the assigned or default contacts
	 * based on policies and context
	 *  
	 * This is used to test negative scenario when contact set to blank.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrievePolicyContactList_Empty() {
		String errorMsg="ECRP30003 E The Contact Retrieval Service was unable to process due to a technical error. <Context is required>";
		List<Contact> contacts = new ArrayList<Contact>();
		
		Contact contact = null;
		
		String policyNumber = "";
		String cpNumber ="";
		String policyTypeCode = "";
		String policySubType ="";
		String branchNumber ="";
		contacts.add(contact);

		ResourceRequestResult requestResult= chubbDomainManager.retrievePolicyContactList(policyNumber,cpNumber,policyTypeCode, branchNumber, policySubType, contacts);

		assertTrue("Error code should be E","E".equals(requestResult.getStatusCode()));
		assertTrue("Contact list should be null",requestResult.getContactList()==null);
		assertTrue("Error mesage should not be empty",errorMsg.equals(requestResult.getStatusMessage()));

	}
	
	/**
	 * <pre>
	 * 
	 * testRetrieveDefaultContactList
	 * June 26, 2015
	 *
	 * This method is used to test retrieve list of ContactResources which will either be the assigned or default contacts
	 * based on product , branch and context
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrieveDefaultContactList() {
		String productCode="99999";
		String branchCode="0001";
		String context="uiRequest";

		ResourceRequestResult requestResult= chubbDomainManager.retrieveDefaultContactList(productCode, branchCode, context);
		assertTrue("Error code should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("Contact list should not empty",requestResult.getContactList().size()>0);

	}

	/**
	 * <pre>
	 * 
	 * testRetrieveDefaultContactList_No_Record
	 * June 26, 2015
	 *
	 * This method is used to test retrieve list of ContactResources which will either be the assigned or default contacts
	 * based on product , branch and context
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrieveDefaultContactList_No_Record() {
		
		String productCode="00100";
		String branchCode="0000";
		String context="";

		ResourceRequestResult requestResult= chubbDomainManager.retrieveDefaultContactList(productCode, branchCode, context);
		assertTrue("Error code should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("Contact list should be empty",requestResult.getContactList().size()==0);

	}
	
	/**
	 * <pre>
	 * 
	 * testRetrieveDefaultContactList_Null
	 * June 26, 2015
	 *
	 * This method is used to test retrieve list of ContactResources which will either be the assigned or default contacts
	 * based on product , branch and context
	 *  
	 * This is used to test negative scenario when product ,branch and context set to null.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrieveDefaultContactList_Null() {
		
		String errorMsg="ECRP30003 E The Contact Retrieval Service was unable to process due to a technical error. <Context is required>";
		
		String productCode=null;
		String branchCode=null;
		String context=null;

		ResourceRequestResult requestResult= chubbDomainManager.retrieveDefaultContactList(productCode, branchCode, context);
		assertTrue("Error code should be E","E".equals(requestResult.getStatusCode()));
		assertTrue("Contact list should be null",requestResult.getContactList()==null);
		assertTrue("Error mesage should not be empty",errorMsg.equals(requestResult.getStatusMessage()));

	}

	/**
	 * <pre>
	 * 
	 * testRetrieveDefaultContactList_Empty
	 * June 26, 2015
	 *
	 * This method is used to test retrieve list of ContactResources which will either be the assigned or default contacts
	 * based on product , branch and context
	 *  
	 * This is used to test negative scenario when product ,branch and context set to blank.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrieveDefaultContactList_Empty() {
		
		String errorMsg="ECRP30003 E The Contact Retrieval Service was unable to process due to a technical error. <Context is required>";
		String productCode="";
		String branchCode="";
		String context="";

		ResourceRequestResult requestResult= chubbDomainManager.retrieveDefaultContactList(productCode, branchCode, context);
		assertTrue("Error code should be E","E".equals(requestResult.getStatusCode()));
		assertTrue("Contact list should be null",requestResult.getContactList()==null);
		assertTrue("Error mesage should not be empty",errorMsg.equals(requestResult.getStatusMessage()));

	}

	
	/**
	 * <pre>
	 * 
	 * testRetrieveAtChubbProductList
	 * June 26, 2015
	 *
	 * This method will call get the result from provider service and will
	 * call the method uiResourceFromProductList to map service reply object 
	 * to the UI Resource Object
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrieveAtChubbProductList() {
		ResourceRequestResult requestResult= chubbDomainManager.retrieveAtChubbProductList();

		assertTrue("StatusCode should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("StatusMessage code should be blank","".equals(requestResult.getStatusMessage()));
		assertTrue("Product list should not empty",requestResult.getProductList().size()>0);
	}

	/**
	 * <pre>
	 * 
	 * testRetrieveBranchList
	 * June 26, 2015
	 *
	 * This method will call get the result from provider service and will
	 * call the method uiResourceFromBranchList to map service reply object 
	 * to the UI Resource Object 
	 *  
	 * @return void
	 * 
	 * </pre>
	 */

	@Test
	public final void testRetrieveBranchList() {
		ResourceRequestResult requestResult =chubbDomainManager.retrieveBranchList();

		assertTrue("StatusCode should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("StatusMessage code should be blank","".equals(requestResult.getStatusMessage()));
		assertTrue("Branch list should not empty",requestResult.getBranchList().size()>0);
	}

	/**
	 * <pre>
	 * 
	 * testRetrieveAtChubbProductList
	 * June 26, 2015
	 *
	 * This method will call get the result from provider service and will
	 * call the method uiResourceFromProductList to map service reply object 
	 * to the UI Resource Object
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrieveProducerList() {
		List<ProducerKey> producerKeys =new ArrayList<ProducerKey>();
		String producerNumber="0024617";
		String producerSubNumber="99999";
		ProducerKey producerKey =new ProducerKey(producerNumber, producerSubNumber);
		producerKeys.add(producerKey);

		ResourceRequestResult requestResult =chubbDomainManager.retrieveProducerList(producerKeys);

		assertTrue("StatusCode should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("StatusMessage code should be blank","".equals(requestResult.getStatusMessage()));
		assertTrue("Producer list should not empty",requestResult.getProducerList().size()>0);
	}

	/**
	 * <pre>
	 * 
	 * testRetrieveProducerList_Null
	 * June 26, 2015
	 *
	 * This method will call get the result from provider service and will
	 * call the method uiResourceFromProductList to map service reply object 
	 * to the UI Resource Object
	 *  
	 *  This is used to test negative scenario when producer and sub producer set to null.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrieveProducerList_Null() {
		List<ProducerKey> producerKeys =new ArrayList<ProducerKey>();
		String producerNumber=null;
		String producerSubNumber=null;
		ProducerKey producerKey =new ProducerKey(producerNumber, producerSubNumber);
		producerKeys.add(producerKey);

		ResourceRequestResult requestResult =chubbDomainManager.retrieveProducerList(producerKeys);

		assertTrue("StatusCode should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("StatusMessage code should be blank","".equals(requestResult.getStatusMessage()));
		assertTrue("Producer list should not empty",requestResult.getProducerList().size()>0);
	}
	
	/**
	 * <pre>
	 * 
	 * testRetrieveProducerList_Empty
	 * June 26, 2015
	 *
	 * This method will call get the result from provider service and will
	 * call the method uiResourceFromProductList to map service reply object 
	 * to the UI Resource Object
	 *  
	 * This is used to test negative scenario when producer and sub producer set to blank.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrieveProducerList_Empty() {
		List<ProducerKey> producerKeys =new ArrayList<ProducerKey>();
		String producerNumber="";
		String producerSubNumber="";
		ProducerKey producerKey =new ProducerKey(producerNumber, producerSubNumber);
		producerKeys.add(producerKey);

		ResourceRequestResult requestResult =chubbDomainManager.retrieveProducerList(producerKeys);

		assertTrue("StatusCode should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("StatusMessage code should be blank","".equals(requestResult.getStatusMessage()));
		assertTrue("Producer list should not empty",requestResult.getProducerList().size()>0);
	}
	
	/**
	 * <pre>
	 * 
	 * testUIResourceFromPolicyList
	 * June 26, 2015
	 *
	 * This method is used to test UI Resource Object generated for service reply (policy list).
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testUIResourceFromPolicyList() {
		List<PolicyResource> policyResourceList=new ArrayList<PolicyResource>();
		List<Policy> policyList =new ArrayList<Policy>();
		List<Contact> contactList = new ArrayList<Contact>();

		try {
			Contact contact = new Contact();
			contact.setPhoneNumber("123456");
			contact.setCellPhoneNumber("123456789");
			contact.setEmailAddress("abc@chubb.com");
			contact.setName("xyz");
			contact.setRole("uwriter");
			
			Contact contact1 = new Contact();
			contact1.setPhoneNumber("123456");
			contact1.setCellPhoneNumber("123456789");
			contact1.setEmailAddress("abc@chubb.com");
			contact1.setName("xyz");
			contact1.setRole("uwriter");
			
			contactList.add(contact);
			contactList.add(contact1);

			Policy policy=new Policy();
			policy.setPolicyNumber("7777777");
			policy.setProductComponentName("abc");
			policy.setDisplayProductTypeName("Auto");
			policy.setExpirationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
			policy.setContacts(contactList);
			policyList.add(policy);

			Policy policy1 = new Policy();
			policy1.setPolicyNumber("6666666");
			policy1.setProductComponentName("xyz");
			policy1.setDisplayProductTypeName("Commercial Package");
			policy1.setExpirationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
			policy1.setContacts(contactList);
			policyList.add(policy1);

			Object[] args = {policyResourceList,policyList};

			privateMethod = ContactChubbDomainManager.class.
			getDeclaredMethod("uiResourceFromPolicyList", new Class<?>[]{java.util.List.class,java.util.List.class});
			privateMethod.setAccessible(true);

			ResourceRequestResult requestResult =(ResourceRequestResult) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("policy list should not be empty",requestResult.getPolicyList().size()>0);
			
			assertEquals("Invalid value for ProductComponentName",policyList.get(0).getProductComponentName(),requestResult.getPolicyList().get(0).getProductComponentName());
			assertEquals("Invalid value for ExpirationDate",policyList.get(0).getExpirationDate(),requestResult.getPolicyList().get(0).getExpirationDate());
			assertEquals("Invalid value for PolicyNumber",policyList.get(0).getPolicyNumber(),requestResult.getPolicyList().get(0).getPolicyNumber());
			
			assertEquals("Invalid value for ProductComponentName",policyList.get(1).getProductComponentName(),requestResult.getPolicyList().get(1).getProductComponentName());
			assertEquals("Invalid value for ExpirationDate",policyList.get(1).getExpirationDate(),requestResult.getPolicyList().get(1).getExpirationDate());
			assertEquals("Invalid value for PolicyNumber",policyList.get(1).getPolicyNumber(),requestResult.getPolicyList().get(1).getPolicyNumber());
			
		}catch(Exception e){
			e.printStackTrace();
			fail("Policy list creation failed");
		}
	}

	/**
	 * <pre>
	 * 
	 * testUIResourceFromPolicyList_Empty
	 * June 26, 2015
	 *
	 * This method is used to test UI Resource Object generated for service reply (policy list)
	 * when policyList set to empty.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testUIResourceFromPolicyList_Empty() {
		List<PolicyResource> policyResourceList=new ArrayList<PolicyResource>();
		List<Policy> policyList =new ArrayList<Policy>();

		Object[] args = {policyResourceList,policyList};
		try {

			privateMethod = ContactChubbDomainManager.class.
			getDeclaredMethod("uiResourceFromPolicyList", new Class<?>[]{java.util.List.class,java.util.List.class});
			privateMethod.setAccessible(true);

			ResourceRequestResult requestResult =(ResourceRequestResult) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("policy list should be empty",requestResult.getPolicyList().size()==0);
			
		}catch(Exception e){
			e.printStackTrace();
			fail("Policy list creation failed");
		}
	}
	
	/**
	 * <pre>
	 * 
	 * testUIResourceFromContactList
	 * June 26, 2015
	 *
	 * This method is used to test UI Resource Object generated for service reply (contact list).
	 * 
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testUIResourceFromContactList() {
		List<ContactResource> contactResources=new ArrayList<ContactResource>();
		List<Contact> contacts =new ArrayList<Contact>();
		List<Policy> policyList =new ArrayList<Policy>();
		try {
			Contact contact=new Contact();
			contact.setName("Juanito Doe");
			contact.setGivenName("Juanito Doe");
			contact.setRole("Underwriter");
			contact.setPhoneNumber("908.723.1616");
			contact.setCellPhoneNumber("908.723.1616");
			contact.setEmailAddress("juanito.doe@emial.com");
			contacts.add(contact);

			Contact contact1 = new Contact();
			contact1.setName("Maria Iqbal");
			contact1.setGivenName("Maria Iqbal");
			contact1.setRole("Risk Manager");
			contact1.setPhoneNumber("201.382.1811");
			contact1.setCellPhoneNumber("201.322.0101");
			contact1.setEmailAddress("juanito.doe@emial.com");
			contacts.add(contact1);

			Policy policy=new Policy();
			policy.setPolicyNumber("7777777");
			policy.setDisplayProductTypeName("Auto");
			policy.setExpirationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
			policy.setContacts(contacts);
			policyList.add(policy);

			Policy policy1 = new Policy();
			policy1.setPolicyNumber("6666666");
			policy1.setDisplayProductTypeName("Commercial Package");
			policy1.setExpirationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
			policy1.setContacts(contacts);
			policyList.add(policy1);

			Object[] args = {contactResources,contacts};

			privateMethod = ContactChubbDomainManager.class.
			getDeclaredMethod("uiResourceFromContactList", new Class<?>[]{java.util.List.class,java.util.List.class});
			privateMethod.setAccessible(true);

			ResourceRequestResult requestResult =(ResourceRequestResult) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("Contact list should not be empty",requestResult.getContactList().size()>0);

			assertEquals("Invalid value for Name",contacts.get(0).getGivenName(),requestResult.getContactList().get(0).getName());
			assertEquals("Invalid value for Role",contacts.get(0).getRole(),requestResult.getContactList().get(0).getRole());
			assertEquals("Invalid value for PhoneNumber",contacts.get(0).getPhoneNumber(),requestResult.getContactList().get(0).getPhoneNumber());
			assertEquals("Invalid value for CellPhoneNumber",contacts.get(0).getCellPhoneNumber(),requestResult.getContactList().get(0).getCellPhoneNumber());
			assertEquals("Invalid value for EmailAddress",contacts.get(0).getEmailAddress(),requestResult.getContactList().get(0).getEmailAddress());

			assertEquals("Invalid value for Name",contacts.get(1).getGivenName(),requestResult.getContactList().get(1).getName());
			assertEquals("Invalid value for Role",contacts.get(1).getRole(),requestResult.getContactList().get(1).getRole());
			assertEquals("Invalid value for PhoneNumber",contacts.get(1).getPhoneNumber(),requestResult.getContactList().get(1).getPhoneNumber());
			assertEquals("Invalid value for CellPhoneNumber",contacts.get(1).getCellPhoneNumber(),requestResult.getContactList().get(1).getCellPhoneNumber());
			assertEquals("Invalid value for EmailAddress",contacts.get(1).getEmailAddress(),requestResult.getContactList().get(1).getEmailAddress());

		}catch(Exception e){
			e.printStackTrace();
			fail("Contact list creation failed");
		}
	}
	
	
	/**
	 * <pre>
	 * 
	 * testUIResourceFromContactList
	 * June 26, 2015
	 *
	 * This method is used to test UI Resource Object generated for service reply (contact list)
	 * when contacts set to empty
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testUIResourceFromContactList_Empty() {
		List<ContactResource> contactResources=new ArrayList<ContactResource>();
		List<Contact> contacts =new ArrayList<Contact>();
		
		Object[] args = {contactResources,contacts};
		try {
			privateMethod = ContactChubbDomainManager.class.
			getDeclaredMethod("uiResourceFromContactList", new Class<?>[]{java.util.List.class,java.util.List.class});
			privateMethod.setAccessible(true);

			ResourceRequestResult requestResult =(ResourceRequestResult) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("Contact list should be empty",requestResult.getContactList().size()==0);
		}catch(Exception e){
			e.printStackTrace();
			fail("Contact list creation failed");
		}
	}
	

	/**
	 * <pre>
	 * 
	 * testUIResourceFromProductList
	 * June 26, 2015
	 *
	 * This method is used to test UI Resource Object generated for service reply (product list).
	 * 
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testUIResourceFromProductList() {
		List<ProductResource> productResources=new ArrayList<ProductResource>();
		List<Product> products =new ArrayList<Product>();

		Product product=new Product();
		product.productCode="00010";
		product.productName="Environmental";
		products.add(product);

		product=new Product();
		product.productCode="00011";
		product.productName="Equipment Breakdown";
		products.add(product);

		Object[] args = {productResources,products};
		try {
			privateMethod = ContactChubbDomainManager.class.
			getDeclaredMethod("uiResourceFromProductList", new Class<?>[]{java.util.List.class,java.util.List.class});
			privateMethod.setAccessible(true);

			ResourceRequestResult requestResult =(ResourceRequestResult) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("Product list should not be empty",requestResult.getProductList().size()>0);

			assertEquals("Invalid value for Name",products.get(0).productName,requestResult.getProductList().get(0).getProductName());
			assertEquals("Invalid value for Code",products.get(0).productCode,requestResult.getProductList().get(0).getProductCode());

			assertEquals("Invalid value for Name",products.get(1).productName,requestResult.getProductList().get(1).getProductName());
			assertEquals("Invalid value for Code",products.get(1).productCode,requestResult.getProductList().get(1).getProductCode());

		}catch(Exception e){
			e.printStackTrace();
			fail("Product list creation failed");
		}
	}

	/**
	 * <pre>
	 * 
	 * testUIResourceFromProductList_Empty
	 * June 26, 2015
	 *
	 * This method is used to test UI Resource Object generated for service reply (product list).
	 * when products set to empty.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testUIResourceFromProductList_Empty() {
		List<ProductResource> productResources=new ArrayList<ProductResource>();
		List<Product> products =new ArrayList<Product>();

		Object[] args = {productResources,products};
		try {
			privateMethod = ContactChubbDomainManager.class.
			getDeclaredMethod("uiResourceFromProductList", new Class<?>[]{java.util.List.class,java.util.List.class});
			privateMethod.setAccessible(true);

			ResourceRequestResult requestResult =(ResourceRequestResult) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("Product list should be empty",requestResult.getProductList().size()==0);

		}catch(Exception e){
			e.printStackTrace();
			fail("Product list creation failed");
		}
	}
	
	
	/**
	 * <pre>
	 * 
	 * testUIResourceFromBranchList
	 * June 26, 2015
	 *
	 * This method is used to test UI Resource Object generated for service reply (branch list).
	 * 
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testUIResourceFromBranchList() {
		List<BranchResource> branchResources=new ArrayList<BranchResource>();
		List<Branch> branches =new ArrayList<Branch>();

		Branch branch=new Branch();
		branch.setBranchNumber("0121");
		branch.setBranchName("HARRISBURG");
		branches.add(branch);

		Branch branch1 = new Branch();
		branch1.setBranchNumber("0484");
		branch1.setBranchName("MARSH MELVILLE");
		branches.add(branch1);
		
		CAFPropertiesUtil.getBranchList().clear();
		CAFPropertiesUtil.getBranchList().add("0121");
		CAFPropertiesUtil.getBranchList().add("0484");

		Object[] args = {branchResources,branches};
		try {
			privateMethod = ContactChubbDomainManager.class.
			getDeclaredMethod("uiResourceFromBranchList", new Class<?>[]{java.util.List.class,java.util.List.class});
			privateMethod.setAccessible(true);

			ResourceRequestResult requestResult =(ResourceRequestResult) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("Branch list should not be empty",requestResult.getBranchList().size()>0);

			assertEquals("Invalid value for BranchCode",branches.get(0).getBranchNumber(),requestResult.getBranchList().get(0).getBranchCode());
			assertEquals("Invalid value for BranchName",branches.get(0).getBranchName(),requestResult.getBranchList().get(0).getBranchName());
			
			assertEquals("Invalid value for BranchCode",branches.get(1).getBranchNumber(),requestResult.getBranchList().get(1).getBranchCode());
			assertEquals("Invalid value for BranchName",branches.get(1).getBranchName(),requestResult.getBranchList().get(1).getBranchName());
			
		}catch(Exception e){
			e.printStackTrace();
			fail("Branch list creation failed");
		}
	}
	
	/**
	 * <pre>
	 * 
	 * testUIResourceFromBranchList_Empty
	 * June 26, 2015
	 *
	 * This method is used to test UI Resource Object generated for service reply (branch list)
	 * when branches set to empty.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testUIResourceFromBranchList_Empty() {
		List<BranchResource> branchResources=new ArrayList<BranchResource>();
		List<Branch> branches =new ArrayList<Branch>();

		Object[] args = {branchResources,branches};
		try {
			privateMethod = ContactChubbDomainManager.class.
			getDeclaredMethod("uiResourceFromBranchList", new Class<?>[]{java.util.List.class,java.util.List.class});
			privateMethod.setAccessible(true);

			ResourceRequestResult requestResult =(ResourceRequestResult) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("Branch list should be empty",requestResult.getBranchList().size()==0);

		}catch(Exception e){
			e.printStackTrace();
			fail("Branch list creation failed");
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		chubbDomainManager=null;
		privateObject=null;
	}
}
