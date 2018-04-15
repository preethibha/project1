package com.chubb.dgmk.caf.wsc.accessors.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chubb.dgmk.caf.domain.model.Branch;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.wsc.accessors.BranchRetrievalAccessor;

import ei.corporate.branch_retrieval_crp2x1_http.BranchRetrievalCRP2X1HTTP_BranchRetrievalCRP2X1HttpPortProxy;
import ei.corporate.get_branch_list_reply_crp2x1.GetBranchListReply;

public class BranchRetrievalAccessorTest {

	BranchRetrievalAccessor branchRetrievalAccessor;
	Method privateMethod;
	BranchRetrievalAccessor privateObject;

	/**
	 * This method is used to setup data for test case
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		branchRetrievalAccessor=new BranchRetrievalAccessor();
		privateObject=new BranchRetrievalAccessor();
		
		CAFPropertiesUtil.setBranchRetrievalEndpoint("http://EIBRRETCRP2X1S/Corporate2ServicesWeb/sca/BranchRetrievalCRP2X1Http");
	}

	/**
	 * <pre>
	 * 
	 * testGetEndpoint
	 * June 30, 2015
	 * 
	 * This method is used to test the endPoint for the BranchRetrieval service from
	 * the properties file.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetEndpoint() {
		String endPointUrl="http://EIBRRETCRP2X1S/Corporate2ServicesWeb/sca/BranchRetrievalCRP2X1Http";

		String endPoint=branchRetrievalAccessor.getEndpoint();

		assertTrue("Invalid endPoint url",endPointUrl.equals(endPoint));
	}

	/**
	 * <pre>
	 * 
	 * testGetBranches
	 * June 30, 2015
	 * 
	 * This method is used to test for branch list after calling the ICC provider service.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetBranches() {
		List<Branch> branches;
		try {
			branches = branchRetrievalAccessor.getBranches();
			assertTrue("Branch list should not be empty",branches.size()>0);
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
	 * This method is used to create instance of XMLGregorianCalendar.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testBuildRequest() {

		Object[] args = {};
		try {
			privateMethod = BranchRetrievalAccessor.class.
			getDeclaredMethod("buildRequest", new Class<?>[]{});
			privateMethod.setAccessible(true);

			XMLGregorianCalendar requestResult =(XMLGregorianCalendar) privateMethod.invoke(privateObject, (Object[])args);

			assertNotNull("XMLGregorianCalendar is null",requestResult);

		}catch(Exception e){
			e.printStackTrace();
			fail("XMLGregorianCalendar creation failed");
		}
	}

	/**
	 * <pre>
	 * testDomainObjectFromProviderReply
	 * 
	 * June 30, 2015
	 * 
	 * This test method is used to map the ICC provider reply GetBranchListReply to
	 * list of Branch CAF domain objects.
	 * 
	 * @return void
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testDomainObjectFromProviderReply() {
		GetBranchListReply reply=new GetBranchListReply();

		BranchRetrievalCRP2X1HTTP_BranchRetrievalCRP2X1HttpPortProxy proxy = new BranchRetrievalCRP2X1HTTP_BranchRetrievalCRP2X1HttpPortProxy();
		proxy._getDescriptor().setEndpoint("http://EIBRRETCRP2X1D/Corporate2ServicesWeb/sca/BranchRetrievalCRP2X1Http");

		try {
			reply = proxy.getBranchList(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));

			Object[] args = {reply};

			privateMethod = BranchRetrievalAccessor.class.
			getDeclaredMethod("domainObjectFromProviderReply", new Class<?>[]{GetBranchListReply.class});
			privateMethod.setAccessible(true);

			ArrayList<Branch> branches = (ArrayList<Branch>) privateMethod.invoke(privateObject, (Object[])args);

			assertNotNull("Branch list should not be empty",branches.size()>0);

		}catch(Exception e){
			e.printStackTrace();
			fail("Branches creation failed");
		}
	}

	/**
	 * <pre>
	 * testDomainObjectFromProviderReply_Empty
	 * 
	 * June 30, 2015
	 * 
	 * This test method is used to map the ICC provider reply GetBranchListReply to
	 * list of Branch CAF domain objects when reply set to empty.
	 * 
	 * @return void
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testDomainObjectFromProviderReply_Empty() {
		GetBranchListReply reply=new GetBranchListReply();

		Object[] args = {reply};

		try {
			privateMethod = BranchRetrievalAccessor.class.
			getDeclaredMethod("domainObjectFromProviderReply", new Class<?>[]{GetBranchListReply.class});
			privateMethod.setAccessible(true);

			ArrayList<Branch> branches = (ArrayList<Branch>) privateMethod.invoke(privateObject, (Object[])args);

			assertNotNull("Branch list should be empty",branches.size()==0);

		}catch(Exception e){
			e.printStackTrace();
			fail("Branches creation failed");
		}
	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		branchRetrievalAccessor=null;
		privateObject=null;
	}
}
