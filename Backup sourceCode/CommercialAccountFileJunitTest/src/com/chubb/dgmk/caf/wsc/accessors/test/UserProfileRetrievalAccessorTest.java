package com.chubb.dgmk.caf.wsc.accessors.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chubb.dgmk.caf.domain.model.UserInformation;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.wsc.accessors.UserProfileRetrievalAccessor;

import ei.user.profile.User;
import ei.user.profile.UserProfile;

public class UserProfileRetrievalAccessorTest {

	UserProfileRetrievalAccessor userProfileRetrievalAccessor;
	UserProfileRetrievalAccessor privateObject;
	Method privateMethod;

	@Before
	public void setUp() throws Exception {
		userProfileRetrievalAccessor=new UserProfileRetrievalAccessor();
		privateObject=new UserProfileRetrievalAccessor();
		CAFPropertiesUtil.setUserProfileRetrievalEndpoint("http://eiuserpfileretcrp31x1-ut:80/Corporate4ServicesWeb/sca/UserProfileRetrievalCRP31X1Http");
	}

	/**
	 * <pre>
	 * 
	 * testGetEndpoint
	 * 
	 * This method is used to test the endPoint for the UserRetrieval service from
	 * the properties file.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetEndpoint() {
		String endPointUrl="http://eiuserpfileretcrp31x1-ut:80/Corporate4ServicesWeb/sca/UserProfileRetrievalCRP31X1Http";

		String endPoint=userProfileRetrievalAccessor.getEndpoint();

		assertTrue("Invalid endPoint url for policy retrieval",endPointUrl.equals(endPoint));
	}

	/**
	 * <pre>
	 * 
	 * testGetUserInformation
	 * user
	 * This method is used to test the endPoint for the UserRetrieval service from
	 * the properties file.
	 *  
	 * @return void
	 * 
	 * </pre>
	 * @throws Exception 
	 */
	@Test
	public final void testGetUserInformation() throws Exception {
		UserInformation user=null;
		UserInformation userProfile=new UserInformation();
		userProfile.setExternalUserId("maagt_07");
	
		
		user = userProfileRetrievalAccessor.getUserInformation(userProfile);
			System.out.println("====="+user);
			assertNotNull("User is not null", user);
		

	}

	

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		userProfileRetrievalAccessor=null;
		privateObject=null;
	}
}
