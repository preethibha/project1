/**
 * 
 */
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

import com.chubb.dgmk.caf.domain.manager.AccountFileDomainManager;
import com.chubb.dgmk.caf.domain.model.Account;
import com.chubb.dgmk.caf.domain.model.AccountGroup;
import com.chubb.dgmk.caf.domain.model.Policy;
import com.chubb.dgmk.caf.domain.resource.AccountResource;
import com.chubb.dgmk.caf.domain.resource.ProducerKey;
import com.chubb.dgmk.caf.domain.resource.ResourceRequestResult;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;

import ei.core.producer_identifierx2.ProducerIdentifier;

/**
 * @author NPGM50M
 *
 */
public class AccountFileDomainManagerTest {
	AccountFileDomainManager accountFileDomainManager;
	AccountFileDomainManager privateObject;
	Method privateMethod;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		accountFileDomainManager=new AccountFileDomainManager();
		privateObject=new AccountFileDomainManager();
		
		CAFPropertiesUtil.setCommercialPolicyRetrievalEndpoint("http://eicomlinsdgrppolrtrvlcrm33x1-st/CRM6ServicesWeb/sca/CommercialInsuredGroupPolicyRetrievalCRM33X1Http");
		
		
	}

	/**
	 * <pre>
	 * 
	 * testRetrieveAccount_Employee
	 * June 26, 2015
	 *
	 * This method is used to test retrieve list of account 
	 * based on account name and context, role and a List of Producer Number / sub Producer
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrieveAccount_Employee() {
		List<ProducerKey>  producerKeys=new ArrayList<ProducerKey>();
		
		ResourceRequestResult requestResult =accountFileDomainManager.retrieveAccount("cannon", "Employee",producerKeys);

		assertTrue("StatusCode code should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("StatusMessage code should be blank","".equals(requestResult.getStatusMessage()));
		assertTrue("Account list should not empty",requestResult.getAccountList().size()>0);
	}

	/**
	 * <pre>
	 * 
	 * testRetrieveAccount_Agent
	 * June 26, 2015
	 *
	 * This method is used to test retrieve list of account 
	 * based on account name and context, role and a List of Producer Number / sub Producer
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrieveAccount_Agent() {
		List<ProducerKey>  producerKeys=new ArrayList<ProducerKey>();
		ProducerKey producerKey =new ProducerKey("0041714","00001");
		producerKeys.add(producerKey);

		ResourceRequestResult requestResult =accountFileDomainManager.retrieveAccount("WMU", ICAFConstants.ICC_AGENT, producerKeys);

		assertTrue("StatusCode code should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("StatusMessage code should be blank","".equals(requestResult.getStatusMessage()));
		assertTrue("Account list should not empty",requestResult.getAccountList().size()>0);
	}
	
	/**
	 * <pre>
	 * 
	 * testRetrieveAccount_Invalid_Employee
	 * June 26, 2015
	 *
	 * This method is used to test retrieve list of account 
	 * based on invalid account name and context, role
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrieveAccount_Invalid_Employee() {
		List<ProducerKey>  producerKeys=new ArrayList<ProducerKey>();
		
		ResourceRequestResult requestResult =accountFileDomainManager.retrieveAccount("abcTest", "xyzRole", producerKeys);

		assertTrue("StatusCode code should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("StatusMessage code should be blank","".equals(requestResult.getStatusMessage()));
		assertTrue("Account list should be empty",requestResult.getAccountList().size()==0);
	}
	
	/**
	 * <pre>
	 * 
	 * testRetrieveAccount_Invalid_Agent
	 * June 26, 2015
	 *
	 * This method is used to test retrieve list of account 
	 * based on invalid account name and context, role and a List of Producer Number / sub Producer
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrieveAccount_Invalid_Agent() {
		List<ProducerKey>  producerKeys=new ArrayList<ProducerKey>();
		ProducerKey producerKey =new ProducerKey("0000000","00000");
		producerKeys.add(producerKey);

		ResourceRequestResult requestResult =accountFileDomainManager.retrieveAccount("abcTest", "xyzRole", producerKeys);

		assertTrue("StatusCode code should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("StatusMessage code should be blank","".equals(requestResult.getStatusMessage()));
		assertTrue("Account list should be empty",requestResult.getAccountList().size()==0);
	}

	
	/**
	 * <pre>
	 * 
	 * testRetrievePolicies_Employee
	 * June 26, 2015
	 *
	 * This method is used to test retrieve list of policy
	 * based on valid
	 * 1) Policy Number or 2) Insured Number or 3)Account Group ID
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrievePolicies_Employee() {
		
		List<ProducerKey>  producerKeys=new ArrayList<ProducerKey>();
		
		String policyNumber = "000081096194";
		String accountGroupNumber = null;
		String insuredNumber = null;//000000012480

		ResourceRequestResult requestResult =accountFileDomainManager.retrievePolicies(policyNumber, accountGroupNumber, insuredNumber, ICAFConstants.ICC_EMPLOYEE, producerKeys);

		assertTrue("StatusCode code should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("StatusMessage code should be blank","".equals(requestResult.getStatusMessage()));
		assertTrue("Account list should not empty",requestResult.getPolicyList().size()>0);
	}

	/**
	 * <pre>
	 * 
	 * testRetrievePolicies_Agent
	 * June 26, 2015
	 *
	 * This method is used to test retrieve list of policy
	 * based on valid
	 * 1) Policy Number or 2) Insured Number or 3)Account Group ID
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testRetrievePolicies_Agent() {
		
		List<ProducerKey>  producerKeys=new ArrayList<ProducerKey>();
		ProducerKey producerKey =new ProducerKey("0041714","00001");
		producerKeys.add(producerKey);
		
		ProducerKey producerKey1 =new ProducerKey("0041714","99999");
		producerKeys.add(producerKey1);
		
		String policyNumber = "000004860905";
		String accountGroupNumber = null;
		String insuredNumber = null;//000000012480

		ResourceRequestResult requestResult =accountFileDomainManager.retrievePolicies(policyNumber, accountGroupNumber, insuredNumber, ICAFConstants.ICC_AGENT, producerKeys);

		assertTrue("StatusCode code should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("StatusMessage code should be blank","".equals(requestResult.getStatusMessage()));
		assertTrue("Account list should not empty",requestResult.getPolicyList().size()>0);
	}


	/**
	 * <pre>
	 * 
	 * testUIResourceFromAccountList
	 * June 26, 2015
	 *
	 * This method is used to test UI Resource Object generated for service reply (account list).
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testUIResourceFromAccountList() {
		List<AccountResource> accountResources=new ArrayList<AccountResource>();
		List<Account> accounts =new ArrayList<Account>();

		try {

			Account account=new Account();
			account.setInsuredName("Account Name 1");
			account.setAddressLine1("10 Main Street");
			account.setAddressLine2("AddressLine2");
			account.setAddressLine3("AddressLine3");
			account.setCityName("Sommerville");
			account.setPostalStateAbbreviation("NJ");
			account.setPostalCode("08807");
			account.setCountryName("USA");

			accounts.add(account);

			account=new Account();
			account.setInsuredName("Account Name 1");
			account.setAddressLine1("192 Old Turnpike Rd");
			account.setAddressLine1("10 Main Street");
			account.setAddressLine2("AddressLine2");
			account.setAddressLine3("AddressLine3");
			account.setCityName("Port Murray");
			account.setStateOrProvinceName("NJ");
			account.setPostalCode("07865");
			account.setCountryName("USA");

			accounts.add(account);

			Object[] args = {accountResources,accounts};

			privateMethod = AccountFileDomainManager.class.
			getDeclaredMethod("uiResourceFromAccountList", new Class<?>[]{java.util.List.class,java.util.List.class});
			privateMethod.setAccessible(true);

			ResourceRequestResult requestResult =(ResourceRequestResult) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("Account list should not be empty",requestResult.getAccountList().size()>0);

			assertEquals("Invalid value for InsuredName",accounts.get(0).getInsuredName(),requestResult.getAccountList().get(0).getInsuredName());
			assertEquals("Invalid value for AddressLine1",accounts.get(0).getAddressLine1(),requestResult.getAccountList().get(0).getAddressLine1());
			assertEquals("Invalid value for AddressLine2",accounts.get(0).getAddressLine2(),requestResult.getAccountList().get(0).getAddressLine2());
			assertEquals("Invalid value for AddressLine3",accounts.get(0).getAddressLine3(),requestResult.getAccountList().get(0).getAddressLine3());
			assertEquals("Invalid value for getCityName",accounts.get(0).getCityName(),requestResult.getAccountList().get(0).getCityName());
			assertEquals("Invalid value for StateOrProvinceName",accounts.get(0).getStateOrProvinceName(),requestResult.getAccountList().get(0).getStateOrProvinceName());
			assertEquals("Invalid value for PostalCode",accounts.get(0).getPostalCode(),requestResult.getAccountList().get(0).getPostalCode());
			assertEquals("Invalid value for CountryName",accounts.get(0).getCountryName(),requestResult.getAccountList().get(0).getCountryName());

			assertEquals("Invalid value for InsuredName",accounts.get(1).getInsuredName(),requestResult.getAccountList().get(1).getInsuredName());
			assertEquals("Invalid value for AddressLine1",accounts.get(1).getAddressLine1(),requestResult.getAccountList().get(1).getAddressLine1());
			assertEquals("Invalid value for AddressLine2",accounts.get(1).getAddressLine2(),requestResult.getAccountList().get(1).getAddressLine2());
			assertEquals("Invalid value for AddressLine3",accounts.get(1).getAddressLine3(),requestResult.getAccountList().get(1).getAddressLine3());
			assertEquals("Invalid value for getCityName",accounts.get(1).getCityName(),requestResult.getAccountList().get(1).getCityName());
			assertEquals("Invalid value for StateOrProvinceName",accounts.get(1).getStateOrProvinceName(),requestResult.getAccountList().get(1).getStateOrProvinceName());
			assertEquals("Invalid value for PostalCode",accounts.get(1).getPostalCode(),requestResult.getAccountList().get(1).getPostalCode());
			assertEquals("Invalid value for CountryName",accounts.get(1).getCountryName(),requestResult.getAccountList().get(1).getCountryName());

		}catch(Exception e){
			e.printStackTrace();
			fail("Account list creation failed");
		}
	}

	/**
	 * <pre>
	 * 
	 * testUIResourceFromAccountList_Empty
	 * June 26, 2015
	 *
	 * This method is used to test UI Resource Object generated for service reply (account list)
	 * when accounts set to empty.
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testUIResourceFromAccountList_Empty() {
		List<AccountResource> accountResources=new ArrayList<AccountResource>();
		List<Account> accounts =new ArrayList<Account>();

		try {

			Object[] args = {accountResources,accounts};

			privateMethod = AccountFileDomainManager.class.
			getDeclaredMethod("uiResourceFromAccountList", new Class<?>[]{java.util.List.class,java.util.List.class});
			privateMethod.setAccessible(true);

			ResourceRequestResult requestResult =(ResourceRequestResult) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("Account list should be empty",requestResult.getAccountList().size()==0);
		}catch(Exception e){
			e.printStackTrace();
			fail("Account list creation failed");
		}
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
		AccountGroup accountGroup =new AccountGroup();
		List<Account> accounts=new ArrayList<Account>();
		Account account=new Account();
		try {

			Policy policy=new Policy();
			policy.setPolicyNumber("7777777");
			policy.setDisplayProductTypeName("Auto");
			policy.setInceptionDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
			policy.setExpirationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
			policy.setPolicyTypeCode("30");
			policy.setInsurerProductCode("0010");
			policy.setDisplayProductTypeName("Auto");
			account.addPolicy(policy);
			
			Policy policy1 = new Policy();
			policy1.setPolicyNumber("6666666");
			policy1.setDisplayProductTypeName("Commercial Package");
			policy1.setInceptionDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
			policy1.setExpirationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
			policy1.setPolicyTypeCode("62");
			policy1.setInsurerProductCode("0021");
			policy1.setDisplayProductTypeName("Commercial Package");
			account.addPolicy(policy1);
			
			account.setWipInsuredNumber("000000071875");
			account.setInsuredName("BIG CANYON COMMUNITY ASSOCIATION");
			   
			account.setAddressLine1("1 MAIN STREET");
			account.setCityName("BRIDGEWATER");
			account.setStateOrProvinceCode("29");
			account.setPostalCode("08807");
			
			accounts.add(account);
			accountGroup.addAccount(account);
			
			Object[] args = {accountGroup};

			privateMethod = AccountFileDomainManager.class.
			getDeclaredMethod("uiResourceFromPolicyList", new Class<?>[]{com.chubb.dgmk.caf.domain.model.AccountGroup.class});
			privateMethod.setAccessible(true);

			ResourceRequestResult requestResult =(ResourceRequestResult) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("policy list size should be 2",requestResult.getPolicyList().size()==2);

			assertEquals("Invalid value for ProductComponentName",accounts.get(0).getPolicies().get(0).getProductComponentName(),requestResult.getPolicyList().get(0).getProductComponentName());
			assertEquals("Invalid value for PolicyNumber",accounts.get(0).getPolicies().get(0).getPolicyNumber(),requestResult.getPolicyList().get(0).getPolicyNumber());
			assertEquals("Invalid value for InceptionDate",accounts.get(0).getPolicies().get(0).getInceptionDate(),requestResult.getPolicyList().get(0).getInceptionDate());

			assertEquals("Invalid value for ProductComponentName",accounts.get(0).getPolicies().get(1).getProductComponentName(),requestResult.getPolicyList().get(1).getProductComponentName());
			assertEquals("Invalid value for PolicyNumber",accounts.get(0).getPolicies().get(1).getPolicyNumber(),requestResult.getPolicyList().get(1).getPolicyNumber());
			assertEquals("Invalid value for InceptionDate",accounts.get(0).getPolicies().get(1).getInceptionDate(),requestResult.getPolicyList().get(1).getInceptionDate());

			assertEquals("Invalid value for WipInsuredNumber",accounts.get(0).getWipInsuredNumber(),requestResult.getResultIdResource().getWipInsuredNumber());
			assertEquals("Invalid value for InsuredName",accounts.get(0).getInsuredName(),requestResult.getResultIdResource().getAccountName());
			assertEquals("Invalid value for MailingAddress",accounts.get(0).friendlyAddress(),requestResult.getResultIdResource().getMailingAddress());
			
		}catch(Exception e){
			e.printStackTrace();
			fail("Policy list creation failed");
		}
	}

	/**
	 * <pre>
	 * 
	 * testUIResourceFromPolicyList_NotFound
	 * June 26, 2015
	 *
	 * This method is used to test UI Resource Object generated for service reply (policy list)
	 * when AccountGroup set to null.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testUIResourceFromPolicyList_NotFound() {
		AccountGroup accountGroup =null;
		

		Object[] args = {accountGroup};
		try {

			privateMethod = AccountFileDomainManager.class.
			getDeclaredMethod("uiResourceFromPolicyList", new Class<?>[]{com.chubb.dgmk.caf.domain.model.AccountGroup.class});
			privateMethod.setAccessible(true);

			ResourceRequestResult requestResult =(ResourceRequestResult) privateMethod.invoke(privateObject, (Object[])args);
			
			assertTrue("StatusCode code should be W","W".equals(requestResult.getStatusCode()));
			assertTrue("StatusMessage code should be 'No policies found'","No policies found".equals(requestResult.getStatusMessage()));
			
		}catch(Exception e){
			e.printStackTrace();
			fail("Policy list creation failed");
		}
	}


	/**
	 * <pre>
	 * 
	 * testSetProducerInformationForAccount
	 * June 26, 2015
	 * 
	 * This method is used to create producerIdentifiers when producers list set valid data.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSetProducerInformationForAccount() {
		List<ProducerKey> producers=new ArrayList<ProducerKey>();

		ProducerKey producerKey = new ProducerKey("0035795","99999");
		ProducerKey producerKey1 = new ProducerKey("0024617","00000");

		producers.add(producerKey);
		producers.add(producerKey1);

		Object[] args = {producers};
		try {

			privateMethod = AccountFileDomainManager.class.
			getDeclaredMethod("setProducerInformationForAccount", new Class<?>[]{java.util.List.class});
			privateMethod.setAccessible(true);

			List<ProducerIdentifier> producerIdentifiers = (List<ProducerIdentifier>) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("producerIdentifiers list should not be empty",producerIdentifiers.size()>0);

		}catch(Exception e){
			e.printStackTrace();
			fail("Policy list creation failed");
		}
	}


	/**
	 * <pre>
	 * 
	 * testSetProducerInformationForAccount_Empty
	 * June 26, 2015
	 * 
	 * This method is used to create producerIdentifiers when producers list set to empty.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSetProducerInformationForAccount_Empty() {
		List<ProducerKey> producers=new ArrayList<ProducerKey>();

		Object[] args = {producers};
		try {

			privateMethod = AccountFileDomainManager.class.
			getDeclaredMethod("setProducerInformationForAccount", new Class<?>[]{java.util.List.class});
			privateMethod.setAccessible(true);

			List<ProducerIdentifier> producerIdentifiers = (List<ProducerIdentifier>) privateMethod.invoke(privateObject, (Object[])args);
			assertTrue("producerIdentifiers list should be empty",producerIdentifiers.size()==0);

		}catch(Exception e){
			e.printStackTrace();
			fail("producerIdentifiers creation failed");
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		accountFileDomainManager=null;
		privateObject=null;
	}

}
