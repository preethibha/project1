package com.chubb.dgmk.caf.wsc.accessors.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chubb.dgmk.caf.domain.model.AccountGroup;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;
import com.chubb.dgmk.caf.wsc.accessors.CommercialPolicyRetrievalAccessor;

import ei.crm.commercial_insured_group_policy_retrieval_crm33x1_http.CommercialInsuredGroupPolicyRetrievalCRM33X1HTTP_CommercialInsuredGroupPolicyRetrievalCRM33X1HttpPortProxy;
import ei.crm.get_commercial_insured_group_policy_list_reply_crm33x1.GetCommercialInsuredGroupPolicyListReply;
import ei.crm.get_commercial_insured_group_policy_list_request_crm33x1.GetCommercialInsuredGroupPolicyListRequest;
import ei.crm.get_commercial_insured_group_policy_list_request_crm33x1.ObjectFactory;
import ei.producer.producer_identifierx1.ProducerIdentifier;

public class CommercialPolicyRetrievalAccessorTest {
	CommercialPolicyRetrievalAccessor commercialPolicyRetrievalAccessor; 
	CommercialPolicyRetrievalAccessor privateObject;
	Method privateMethod;
	
	/**
	 * This is used to set test data
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		commercialPolicyRetrievalAccessor=new CommercialPolicyRetrievalAccessor();
		privateObject=new CommercialPolicyRetrievalAccessor();
		CAFPropertiesUtil.setCommercialPolicyRetrievalEndpoint("http://eicomlinsdgrppolrtrvlcrm33x1-st/CRM6ServicesWeb/sca/CommercialInsuredGroupPolicyRetrievalCRM33X1Http");
	}
	
	/**
	 * <pre>
	 * 
	 * testGetEndpoint
	 * June 30, 2015
	 * 
	 * This method is used to test the endPoint for the policyRetrieval service from
	 * the properties file.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetEndpoint() {
		String endPointUrl="http://eicomlinsdgrppolrtrvlcrm33x1-st/CRM6ServicesWeb/sca/CommercialInsuredGroupPolicyRetrievalCRM33X1Http";

		String endPoint=commercialPolicyRetrievalAccessor.getEndpoint();

		assertTrue("Invalid endPoint url for policy retrieval",endPointUrl.equals(endPoint));
	}

	/**
	 * <pre>
	 * 
	 * testGetPolicies_Employee_By_policyNo
	 * June 30, 2015
	 * 
	 * This method is used to test for policy list after calling the ICC provider service using valid criteria.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetPolicies_Employee_By_policyNo() {
		
		List<ProducerIdentifier> producerIdentifiers = new ArrayList<ProducerIdentifier>();
		
		String policyNumber="000081096194";
		String accountGroupNumber=null;
		String insuredNumber=null;
		
		AccountGroup  acctGrp;
		
		try {
			acctGrp = (AccountGroup) commercialPolicyRetrievalAccessor.getPolicies(policyNumber, accountGroupNumber, insuredNumber, ICAFConstants.ICC_EMPLOYEE, producerIdentifiers);
			
			assertTrue("Account list should not be empty",acctGrp.getAccounts().size()>0);
			assertTrue("Policies list should not be empty",policyNumber.equals(acctGrp.getAccounts().get(0).getPolicies().get(0).getPolicyNumber()));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("GetPolicies failed");
		}
		
		
	}

	
	/**
	 * <pre>
	 * 
	 * testGetPolicies_Employee_By_InsuredNo
	 * June 30, 2015
	 * 
	 * This method is used to test for policy list after calling the ICC provider service using invalid criteria.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetPolicies_Employee_By_InsuredNo() {
		
		List<ProducerIdentifier> producerIdentifiers = new ArrayList<ProducerIdentifier>();
		
		String policyNumber=null;
		String accountGroupNumber=null;
		String insuredNumber="000001124346";


		AccountGroup acctGrp;
		try {
			acctGrp = (AccountGroup) commercialPolicyRetrievalAccessor.getPolicies(policyNumber, accountGroupNumber, insuredNumber, ICAFConstants.ICC_EMPLOYEE, producerIdentifiers);
			
			assertTrue("Account list should not be empty",acctGrp.getAccounts().size()>0);
			assertTrue("Policies list should not be empty",acctGrp.getAccounts().get(0).getPolicies().size()>0);
			assertTrue("Invalid value for insuredNumber",insuredNumber.equals(acctGrp.getAccounts().get(0).getWipInsuredNumber()));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("GetPolicies failed");
		}
	}
	
	/**
	 * <pre>
	 * 
	 * testGetPolicies_Agent_By_policyNo
	 * June 30, 2015
	 * 
	 * This method is used to test for policy list after calling the ICC provider service using valid criteria.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetPolicies_Agent_By_policyNo() {
		
		List<ProducerIdentifier> producerIdentifiers = new ArrayList<ProducerIdentifier>();
		ProducerIdentifier producerIdentifier = new ProducerIdentifier();
		
		producerIdentifier.setProducerNumber("0041714");
		producerIdentifier.setProducerSubNumber("99999");
		
		producerIdentifiers.add(producerIdentifier);
		
		ProducerIdentifier producerIdentifier1 = new ProducerIdentifier();
		
		producerIdentifier1.setProducerNumber("0041714");
		producerIdentifier1.setProducerSubNumber("00001");
		
		producerIdentifiers.add(producerIdentifier1);
		
		
		String policyNumber="000004860905";
		String accountGroupNumber=null;
		String insuredNumber=null;
		
		AccountGroup  acctGrp;
		
		try {
			acctGrp = (AccountGroup) commercialPolicyRetrievalAccessor.getPolicies(policyNumber, accountGroupNumber, insuredNumber, ICAFConstants.ICC_AGENT, producerIdentifiers);
			
			assertTrue("Account list should not be empty",acctGrp.getAccounts().size()>0);
			assertTrue("Policies list should not be empty",acctGrp.getAccounts().get(0).getPolicies().size()>0);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("GetPolicies failed");
		}
		
		
	}

	
	/**
	 * <pre>
	 * 
	 * testGetPolicies_Agent_By_InsuredNo
	 * June 30, 2015
	 * 
	 * This method is used to test for policy list after calling the ICC provider service using invalid criteria.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetPolicies_Agent_By_InsuredNo() {
		
		List<ProducerIdentifier> producerIdentifiers = new ArrayList<ProducerIdentifier>();
		ProducerIdentifier producerIdentifier = new ProducerIdentifier();
		producerIdentifier.setProducerNumber("0041714");
		producerIdentifier.setProducerSubNumber("99999");
		
		producerIdentifiers.add(producerIdentifier);
		
		ProducerIdentifier producerIdentifier1 = new ProducerIdentifier();
		producerIdentifier1.setProducerNumber("0041714");
		producerIdentifier1.setProducerSubNumber("00001");
		
		producerIdentifiers.add(producerIdentifier1);
		
		String policyNumber=null;
		String accountGroupNumber=null;
		String insuredNumber="000001124346";


		AccountGroup acctGrp;
		try {
			acctGrp = (AccountGroup) commercialPolicyRetrievalAccessor.getPolicies(policyNumber, accountGroupNumber, insuredNumber, ICAFConstants.ICC_AGENT, producerIdentifiers);

			assertTrue("Account list should not be empty",acctGrp.getAccounts().size()>0);
			assertTrue("Policies list should not be empty",acctGrp.getAccounts().get(0).getPolicies().size()>0);
			assertTrue("Invalid value for insuredNumber",insuredNumber.equals(acctGrp.getAccounts().get(0).getWipInsuredNumber()));

		} catch (Exception e) {
			e.printStackTrace();
			fail("GetPolicies failed");
		}
	}

	
	/**
	 * <pre>
	 * 
	 * testBuildRequest
	 * June 30, 2015
	 *
	 * This method is used to create instance of GetCommercialInsuredGroupPolicyListRequest for service call.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	
	@Test
	public void testBuildRequest() {
		String policyNumber="000000777777";
		String accountGroupNumber="10";
		String insuredNumber="000000012480";
		String userType = ICAFConstants.ICC_AGENT;
		
		List<ProducerIdentifier>  producerKeys=new ArrayList<ProducerIdentifier>();
		ProducerIdentifier producerKey =new ProducerIdentifier();
		producerKey.setProducerNumber("0035795");
		producerKey.setProducerSubNumber("99999");

		producerKeys.add(producerKey);

		Object[] args = {policyNumber, accountGroupNumber, insuredNumber, userType, producerKeys};
		try {
			privateMethod = CommercialPolicyRetrievalAccessor.class.
			getDeclaredMethod("buildRequest", new Class<?>[]{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.util.List.class});
			privateMethod.setAccessible(true);

			GetCommercialInsuredGroupPolicyListRequest requestResult =(GetCommercialInsuredGroupPolicyListRequest) privateMethod.invoke(privateObject, (Object[])args);

			assertTrue("Invalid value for PolicyNumber",policyNumber.equals(requestResult.getPolicyNumber()));
			assertTrue("Invalid value for CommercialInsuredGroupId",accountGroupNumber.equals(requestResult.getCommercialInsuredGroupId()));
			assertTrue("Invalid value for WIPInsuredNumber",insuredNumber.equals(requestResult.getWIPInsuredNumber()));

		}catch(Exception e){
			e.printStackTrace();
			fail("GetCommercialInsuredGroupPolicyListRequest creation failed");
		}
	}

	/**
	 * <pre>
	 * 
	 * testDomainObjectFromPolicyProvider
	 * June 30, 2015
	 *
	 * This method is used to test for Convert the reply from the provider to CAF domain objects.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testDomainObjectFromPolicyProvider() {
		GetCommercialInsuredGroupPolicyListRequest request =  new ObjectFactory().createGetCommercialInsuredGroupPolicyListRequest();
		String policyNumber="000004860905";
		String endpoint = "http://eicomlinsdgrppolrtrvlcrm33x1-st/CRM6ServicesWeb/sca/CommercialInsuredGroupPolicyRetrievalCRM33X1Http";

		CommercialInsuredGroupPolicyRetrievalCRM33X1HTTP_CommercialInsuredGroupPolicyRetrievalCRM33X1HttpPortProxy proxy = new CommercialInsuredGroupPolicyRetrievalCRM33X1HTTP_CommercialInsuredGroupPolicyRetrievalCRM33X1HttpPortProxy();
		proxy._getDescriptor().setEndpoint(endpoint);

		request.setPolicyNumber(policyNumber);
		request.setSystemId(ICAFConstants.SOURCE_SYSTEM_ID);
		request.setUserId(ICAFConstants.USER_ID);

		try {

			GetCommercialInsuredGroupPolicyListReply reply = proxy.getCommercialInsuredGroupPolicyList(request);

			Object[] args = {reply};

			privateMethod = CommercialPolicyRetrievalAccessor.class.
			getDeclaredMethod("domainObjectFromPolicyProvider", new Class<?>[]{GetCommercialInsuredGroupPolicyListReply.class});
			privateMethod.setAccessible(true);

			AccountGroup accountGroup =(AccountGroup) privateMethod.invoke(privateObject, (Object[])args);
			
			assertTrue("Account list should not be empty",accountGroup.getAccounts().size()>0);
			assertTrue("Policies list should not be empty",accountGroup.getAccounts().get(0).getPolicies().size()>0);

		}catch(Exception e){
			e.printStackTrace();
			fail("Get Policies failed");
		}
	}
	
	/**
	 * <pre>
	 * 
	 * testDomainObjectFromPolicyProvider_Invalid
	 * June 30, 2015
	 *
	 * This method is used to test for Convert the reply from the provider to CAF domain objects for invalid input.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testDomainObjectFromPolicyProvider_Invalid() {
		GetCommercialInsuredGroupPolicyListRequest request =  new ObjectFactory().createGetCommercialInsuredGroupPolicyListRequest();
		String policyNumber="test";
		String endpoint = "http://eicomlinsdgrppolrtrvlcrm33x1-st/CRM6ServicesWeb/sca/CommercialInsuredGroupPolicyRetrievalCRM33X1Http";

		CommercialInsuredGroupPolicyRetrievalCRM33X1HTTP_CommercialInsuredGroupPolicyRetrievalCRM33X1HttpPortProxy proxy = new CommercialInsuredGroupPolicyRetrievalCRM33X1HTTP_CommercialInsuredGroupPolicyRetrievalCRM33X1HttpPortProxy();
		proxy._getDescriptor().setEndpoint(endpoint);

		request.setPolicyNumber(policyNumber);
		request.setSystemId(ICAFConstants.SOURCE_SYSTEM_ID);
		request.setUserId(ICAFConstants.USER_ID);

		try {

			GetCommercialInsuredGroupPolicyListReply reply = proxy.getCommercialInsuredGroupPolicyList(request);

			Object[] args = {reply};

			privateMethod = CommercialPolicyRetrievalAccessor.class.
			getDeclaredMethod("domainObjectFromPolicyProvider", new Class<?>[]{GetCommercialInsuredGroupPolicyListReply.class});
			privateMethod.setAccessible(true);

			AccountGroup accountGroup =(AccountGroup) privateMethod.invoke(privateObject, (Object[])args);

			assertTrue("Policies list should not be empty",null == accountGroup);

		}catch(Exception e){
			e.printStackTrace();
			fail("Get Policies failed");
		}
	}
	
	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		commercialPolicyRetrievalAccessor=null;
		privateObject=null;
	}

}
