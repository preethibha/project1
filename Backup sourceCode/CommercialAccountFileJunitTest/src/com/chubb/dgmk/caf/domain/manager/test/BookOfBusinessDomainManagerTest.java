/**
 * 
 */
package com.chubb.dgmk.caf.domain.manager.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chubb.dgmk.caf.domain.manager.BookOfBusinessDomainManager;
import com.chubb.dgmk.caf.domain.resource.ResourceRequestResult;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;

/**
 * @author NPGM50M
 *
 */
public class BookOfBusinessDomainManagerTest {

	BookOfBusinessDomainManager bookOfBusinessDomainManager;
	Method privateMethod;
	BookOfBusinessDomainManager privateObject;
	
	/**
	 * Test data setup
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bookOfBusinessDomainManager=new BookOfBusinessDomainManager();
		privateObject=new BookOfBusinessDomainManager();
		CAFPropertiesUtil.setBookOfBusinessSendEndpoint("jms/requestQ_BookOfBusiness");
	}

	/**
	 * <pre>
	 * 
	 * testSubmitBookOfBusinessRequest
	 * June 26, 2015
	 *
	 * This method will get the result from provider service and will
	 * call the method uiResourceFromDomain to map service reply object 
	 * to the UI Resource Object
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testSubmitBookOfBusinessRequest() {

		String producerNumber="0083775";
		String producerSubNumber="00000";
		String emailAddress="srupani@chubb.com";

		ResourceRequestResult requestResult =bookOfBusinessDomainManager.submitBookOfBusinessRequest(producerNumber, producerSubNumber, emailAddress);

		assertTrue("StatusCode should be S","S".equals(requestResult.getStatusCode()));
		assertTrue("StatusMessage code should be blank","".equals(requestResult.getStatusMessage()));

	}
	
	
	/**
	 * <pre>
	 * 
	 * testUIResourceFromDomain
	 * June 26, 2015
	 *
	 * This method is used to create ResourceRequestResult for error.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testUIResourceFromDomain() {
		String errorMessage="";
		try {

			Object[] args = {};

			privateMethod = BookOfBusinessDomainManager.class.
			getDeclaredMethod("uiResourceFromDomain", new Class<?>[]{});
			privateMethod.setAccessible(true);

			ResourceRequestResult requestResult =(ResourceRequestResult) privateMethod.invoke(privateObject, (Object[])args);

			assertTrue("StatusCode should be S","S".equals(requestResult.getStatusCode()));
			assertTrue("Invalid StatusErrorMessage",errorMessage.equals(requestResult.getStatusMessage()));
			

		}catch(Exception e){
			e.printStackTrace();
			fail("ResourceRequestResult creation failed");
		}
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		bookOfBusinessDomainManager=null;
		privateObject=null;
	}
}
