package com.chubb.dgmk.caf.wsc.accessors.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chubb.dgmk.caf.domain.model.Account;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;
import com.chubb.dgmk.caf.wsc.accessors.CommercialAccountRetrievalAccessor;

import ei.core.producer_identifierx2.ProducerIdentifier;
import ei.crm.commercial_customer_search_crm4x4_http.CommercialCustomerSearchCRM4X4HTTP_CommercialCustomerSearchCRM4X4HttpPortProxy;
import ei.crm.name_search_reply_crm4x4.NameSearchReply;
import ei.crm.name_search_request_crm4x4.NameSearchRequest;

public class CommercialAccountRetrievalAccessorTest {

	CommercialAccountRetrievalAccessor commercialAccountRetrievalAccessor;
	CommercialAccountRetrievalAccessor privateObject;
	Method privateMethod;

	/**
	 * This method is used to setup test data
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		commercialAccountRetrievalAccessor=new CommercialAccountRetrievalAccessor();
		privateObject=new CommercialAccountRetrievalAccessor();
		CAFPropertiesUtil.setAccountRetrievalEndpoint("http://EICOMMCUSTSRCHCRM4X4D/CRM2ServicesWeb/sca/CommercialCustomerSearchCRM4X4Http");
	}

	/**
	 * <pre>
	 * 
	 * testGetEndpoint
	 * June 30, 2015
	 * 
	 * This method is used to test the endPoint for the AccountRetrieval service from
	 * the properties file.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetEndpoint() {

		String endPointUrl="http://EICOMMCUSTSRCHCRM4X4D/CRM2ServicesWeb/sca/CommercialCustomerSearchCRM4X4Http";
		String endPoint=commercialAccountRetrievalAccessor.getEndpoint();

		assertTrue("Invalid endPoint url",endPointUrl.equals(endPoint));
	}

	/**
	 * <pre>
	 * 
	 * testGetCommercialAccounts
	 * June 30, 2015
	 * 
	 * 
	 * This method is used to test for accounts data for matching input criteria.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetCommercialAccounts() {

		List<ProducerIdentifier>  producerKeys=new ArrayList<ProducerIdentifier>();
		ProducerIdentifier producerKey =new ProducerIdentifier();
		producerKey.setProducerNumber("0035795");
		producerKey.setProducerSubNumber("99999");

		producerKeys.add(producerKey);

		List<Account> accounts;
		try {
			accounts = commercialAccountRetrievalAccessor.getCommercialAccounts("account1","UTAGNT",producerKeys);
			assertTrue("Account list should not be empty",accounts.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("GetCommercialAccounts failed");
		}

	}

	/**
	 * <pre>
	 * 
	 * testGetCommercialAccounts_Invalid
	 * June 30, 2015
	 * 
	 * This method is used to test for accounts data for invalid input criteria.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetCommercialAccounts_Invalid() {

		List<ProducerIdentifier>  producerKeys=new ArrayList<ProducerIdentifier>();
		ProducerIdentifier producerKey =new ProducerIdentifier();
		producerKey.setProducerNumber("test");
		producerKey.setProducerSubNumber("test");

		producerKeys.add(producerKey);

		try {
			List<Account> accounts = commercialAccountRetrievalAccessor.getCommercialAccounts("123546654","0220",producerKeys);
			assertTrue("Account list should be empty",accounts.size()==0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("GetCommercialAccounts failed");
		}
		

	}

	/**
	 * <pre>
	 * 
	 * testBuildRequest
	 * June 30, 2015
	 *
	 * This method is used to test NameSearchRequest when valid values provided for 
	 * name, role ,includeRelatedAccount and producerIdentifier.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testBuildRequest() {

		List<ProducerIdentifier>  producerKeys=new ArrayList<ProducerIdentifier>();
		ProducerIdentifier producerKey =new ProducerIdentifier();
		producerKey.setProducerNumber("0035795");
		producerKey.setProducerSubNumber("99999");
		producerKeys.add(producerKey);

		String name="Account";
		String role="Agent";
		String includeRelatedAccounts="L";
		Object[] args = {name,role,producerKeys};
		try {
			privateMethod = CommercialAccountRetrievalAccessor.class.
			getDeclaredMethod("buildRequest", new Class<?>[]{java.lang.String.class,java.lang.String.class,java.util.List.class});
			privateMethod.setAccessible(true);

			NameSearchRequest nameSearchRequest =(NameSearchRequest) privateMethod.invoke(privateObject, (Object[])args);

			assertTrue("Invalid value for UserTypeDescription",ICAFConstants.ICC_AGENT.equals(nameSearchRequest.getUserTypeDescription()));
			assertTrue("Invalid value for InsuredName",name.equals(nameSearchRequest.getInsured().getInsuredName()));
			assertTrue("Invalid value for InsuredTypeCode",includeRelatedAccounts.equals(nameSearchRequest.getInsured().getInsuredTypeCode()));
			assertTrue("Invalid value for AdditionalOptionsText","AllNames".equals(nameSearchRequest.getAdditionalOptionsText().get(0)));

			assertTrue("ProducerFilterIdentifier list size should be 1",nameSearchRequest.getProducerFilterIdentifier().size()==1);
			assertTrue("Invalid value for ProducerNumber","0035795".equals(nameSearchRequest.getProducerFilterIdentifier().get(0).getProducerNumber()));
			assertTrue("Invalid value for ProducerSubNumber","99999".equals(nameSearchRequest.getProducerFilterIdentifier().get(0).getProducerSubNumber()));

		}catch(Exception e){
			e.printStackTrace();
			fail("NameSearchRequest creation failed");
		}
	}


	/**
	 * <pre>
	 * 
	 * testDomainObjectFromAccountProvider
	 * June 30, 2015
	 *
	 * This method is used to test reply object created from the provider to CAF domain objects(Account)
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testDomainObjectFromAccountProvider() {
		
		List<ProducerIdentifier>  producerKeys=new ArrayList<ProducerIdentifier>();
		ProducerIdentifier producerKey =new ProducerIdentifier();
		producerKey.setProducerNumber("0035795");
		producerKey.setProducerSubNumber("99999");
		producerKeys.add(producerKey);

		String name="Account";
		String role="UTAGNT";
		
		Object[] args = {name,role,producerKeys};
		try {
			privateMethod = CommercialAccountRetrievalAccessor.class.
			getDeclaredMethod("buildRequest", new Class<?>[]{java.lang.String.class,java.lang.String.class,java.util.List.class});
			privateMethod.setAccessible(true);

			NameSearchRequest nameSearchRequest =(NameSearchRequest) privateMethod.invoke(privateObject, (Object[])args);
			
			//Create reply
			String endpoint = CAFPropertiesUtil.getAccountRetrievalEndpoint();
			CommercialCustomerSearchCRM4X4HTTP_CommercialCustomerSearchCRM4X4HttpPortProxy proxy;
			proxy = new CommercialCustomerSearchCRM4X4HTTP_CommercialCustomerSearchCRM4X4HttpPortProxy();
			proxy._getDescriptor().setEndpoint(endpoint);
			
			NameSearchReply reply = proxy.nameSearch(nameSearchRequest);
			
			Object[] args1 = {reply};
			privateMethod = CommercialAccountRetrievalAccessor.class.
			getDeclaredMethod("domainObjectFromAccountProvider", new Class<?>[]{NameSearchReply.class});
			privateMethod.setAccessible(true);

			ArrayList<Account>  accounts =(ArrayList<Account>) privateMethod.invoke(privateObject, (Object[])args1);

			assertTrue("Account list should not be empty",accounts.size()>0);

		}catch(Exception e){
			e.printStackTrace();
			fail("DomainObjectFromAccountProvider creation failed");
		}
	}

	/**
	 * <pre>
	 * 
	 * testSetProducerIdentifiersForAcounts
	 * June 30, 2015
	 *
	 * This method is used to test nameSearchRequest object created from the ProducerIdentifier.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testSetProducerIdentifiersForAcounts() {
		List<ProducerIdentifier>  producerKeys=new ArrayList<ProducerIdentifier>();
		ProducerIdentifier producerKey =new ProducerIdentifier();
		producerKey.setProducerNumber("87098");
		producerKey.setProducerSubNumber("99999");
		producerKeys.add(producerKey);

		NameSearchRequest nameSearchRequest=new NameSearchRequest();
		Object[] args = {producerKeys,nameSearchRequest};
		try {

			privateMethod = CommercialAccountRetrievalAccessor.class.
			getDeclaredMethod("setProducerIdentifiersForAcounts", new Class<?>[]{java.util.List.class,NameSearchRequest.class});
			privateMethod.setAccessible(true);

			nameSearchRequest  = (NameSearchRequest) privateMethod.invoke(privateObject, (Object[])args);

			assertTrue("ProducerFilterIdentifier list size should be 1",nameSearchRequest.getProducerFilterIdentifier().size()==1);
			assertTrue("Invalid value for ProducerNumber","87098".equals(nameSearchRequest.getProducerFilterIdentifier().get(0).getProducerNumber()));
			assertTrue("Invalid value for ProducerSubNumber","99999".equals(nameSearchRequest.getProducerFilterIdentifier().get(0).getProducerSubNumber()));

		}catch(Exception e){
			e.printStackTrace();
			fail("NameSearchRequest creation failed");
		}
	}

	/**
	 * <pre>
	 * 
	 * testSetProducerIdentifiersForAcounts_Empty
	 * June 30, 2015
	 *
	 * This method is used to test nameSearchRequest object created from the ProducerIdentifier(negative scenario).
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testSetProducerIdentifiersForAcounts_Empty() {
		List<ProducerIdentifier>  producerKeys=new ArrayList<ProducerIdentifier>();

		NameSearchRequest nameSearchRequest=new NameSearchRequest();
		Object[] args = {producerKeys,nameSearchRequest};
		try {

			privateMethod = CommercialAccountRetrievalAccessor.class.
			getDeclaredMethod("setProducerIdentifiersForAcounts", new Class<?>[]{java.util.List.class,NameSearchRequest.class});
			privateMethod.setAccessible(true);

			nameSearchRequest  = (NameSearchRequest) privateMethod.invoke(privateObject, (Object[])args);

			assertTrue("ProducerFilterIdentifier list should be empty",nameSearchRequest.getProducerFilterIdentifier().size()==0);
		}catch(Exception e){
			e.printStackTrace();
			fail("NameSearchRequest creation failed");
		}
	}


	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		commercialAccountRetrievalAccessor=null;
		privateObject=null;
	}
}
