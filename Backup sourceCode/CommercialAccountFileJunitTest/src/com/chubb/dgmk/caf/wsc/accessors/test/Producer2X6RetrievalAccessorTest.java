package com.chubb.dgmk.caf.wsc.accessors.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chubb.dgmk.caf.domain.model.PasKey;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.wsc.accessors.Producer2X6RetrievalAccessor;

import ei.core.producer.prd2X6.GetProducerListInputs;
import ei.core.producer.prd2X6.GetProducerListReply;
import ei.core.producer.prd2X6.GetProducerListRequest;
import ei.core.producer.prd2X6.ObjectFactory;
import ei.core.producer_prd2X6_http.ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPortProxy;

public class Producer2X6RetrievalAccessorTest {

	Producer2X6RetrievalAccessor producer2X6RetrievalAccessor;
	Producer2X6RetrievalAccessor privateObject;
	Method privateMethod;
	
	/**
	 * This method is used to setup test data
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		producer2X6RetrievalAccessor=new Producer2X6RetrievalAccessor();
		privateObject=new Producer2X6RetrievalAccessor();
		CAFPropertiesUtil.setProducerRetrievalEndpoint("http://EIPRODRETPRD2X6-ut/Producer2ServicesWeb/sca/ProducerRetrievalPRD2X6Http");
	}

	/**
	 * <pre>
	 * 
	 * testGetEndpoint
	 * June 30, 2015
	 * 
	 * This method is used to test the endPoint for the producerRetrieval service from
	 * the properties file.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetEndpoint() {
		String endPoint=producer2X6RetrievalAccessor.getEndpoint();
		assertTrue("Invalid endPoint url producerRetrieval",CAFPropertiesUtil.getProducerRetrievalEndpoint().equals(endPoint));
	}

	/**
	 * <pre>
	 * 
	 * testGetProducers
	 * June 30, 2015
	 * 
	 * This method is used to test for producers form ICC provider service when set valid criteria.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetProducers() {
		List<PasKey> producerKeys =new ArrayList<PasKey>();
		PasKey producer=new PasKey();
		producer.setProducerNumber("87098");
		producer.setProducerSubNumber("99999");
		
		producerKeys.add(producer);
		
		List<PasKey> producers;
		try {
			producers = producer2X6RetrievalAccessor.getProducers(producerKeys);
			assertTrue("producers list should not be empty",producers.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <pre>
	 * 
	 * testGetProducers_Invalid
	 * June 30, 2015
	 * 
	 * This method is used to test for producers form ICC provider service when set invalid criteria.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetProducers_Invalid() {
		List<PasKey> producerKeys =new ArrayList<PasKey>();
		PasKey producer=new PasKey();
		producer.setProducerNumber("test123");
		producer.setProducerSubNumber("test856");
		
		producerKeys.add(producer);
		
		List<PasKey> producers;
		try {
			producers = producer2X6RetrievalAccessor.getProducers(producerKeys);
			assertTrue("producers list should not be empty",producers.size()==1);
			assertTrue("producers Name should be null",producers.get(0).getProducerName()==null);
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
	 * This method is used to create GetProducerListRequest object for calling  ICC provider service
	 * for producers retrieval .
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public void testBuildRequest() {
		List<PasKey> producerKeys =new ArrayList<PasKey>();
		PasKey producer=new PasKey();
		producer.setProducerNumber("0087098");
		producer.setProducerSubNumber("99999");
		
		producerKeys.add(producer);
		
		Object[] args = {producerKeys};
		try {
			privateMethod = Producer2X6RetrievalAccessor.class.
			getDeclaredMethod("buildRequest", new Class<?>[]{java.util.List.class});
			privateMethod.setAccessible(true);

			GetProducerListRequest requestResult =(GetProducerListRequest) privateMethod.invoke(privateObject, (Object[])args);

			assertTrue("ProducerListInputs list should not be empty",requestResult.getGetProducerListInputs().size()>0);
			
			assertTrue("Invalid value for ProducerNumber",producerKeys.get(0).getProducerNumber().equals(requestResult.getGetProducerListInputs().get(0).getProducerNumber()));
			assertTrue("Invalid value for ProducerSubNumber",producerKeys.get(0).getProducerSubNumber().equals(requestResult.getGetProducerListInputs().get(0).getProducerSubNumber()));

		}catch(Exception e){
			e.printStackTrace();
			fail("GetProducerListRequest creation failed");
		}
	}
	
	
	/**
	 * <pre>
	 * 
	 * testDomainObjectFromProviderReply
	 * June 30, 2015
	 *
	 * This method is used to map the ICC provider reply GetProducerListReply to
	 * list of Producer CAF domain objects.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testDomainObjectFromProviderReply() {
		List<PasKey> producerKeys =new ArrayList<PasKey>();
		PasKey producer=new PasKey();
		producer.setProducerNumber("87098");
		producer.setProducerSubNumber("99999");

		producerKeys.add(producer);

		GetProducerListRequest providerRequest =  new ObjectFactory().createGetProducerListRequest();

		for(PasKey prod : producerKeys){
			GetProducerListInputs input = new GetProducerListInputs();
			input.setProducerNumber(prod.getProducerNumber());
			input.setProducerSubNumber(prod.getProducerSubNumber());
			providerRequest.getGetProducerListInputs().add(input);
		}

		ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPortProxy proxy = new ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPortProxy();
		proxy._getDescriptor().setEndpoint(CAFPropertiesUtil.getProducer2X6RetrievalEndpoint());

		try {

			GetProducerListReply reply = proxy.getProducerList2X6(providerRequest);

			Object[] args = {reply};
			privateMethod = Producer2X6RetrievalAccessor.class.
			getDeclaredMethod("domainObjectFromProviderReply", new Class<?>[]{GetProducerListReply.class});
			privateMethod.setAccessible(true);

			List<PasKey> requestResult = (List<PasKey>) privateMethod.invoke(privateObject, (Object[])args);

			assertTrue("Producer list should not be empty",requestResult.size()==1);
			
		}catch(Exception e){
			e.printStackTrace();
			fail("Producers creation failed");
		}
	}
	
	
	/**
	 * <pre>
	 * 
	 * testDomainObjectFromProviderReply_Invalid
	 * June 30, 2015
	 *
	 * This method is used to map the ICC provider reply GetProducerListReply to
	 * list of Producer CAF domain objects when we set invalid data.
	 * 
	 * @return void
	 * 
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testDomainObjectFromProviderReply_Invalid() {
		List<PasKey> producerKeys =new ArrayList<PasKey>();
		PasKey producer=new PasKey();
		producer.setProducerNumber("test123sd");
		producer.setProducerSubNumber("test85asd");

		producerKeys.add(producer);

		GetProducerListRequest providerRequest =  new ObjectFactory().createGetProducerListRequest();

		for(PasKey prod : producerKeys){
			GetProducerListInputs input = new GetProducerListInputs();
			input.setProducerNumber(prod.getProducerNumber());
			input.setProducerSubNumber(prod.getProducerSubNumber());
			providerRequest.getGetProducerListInputs().add(input);
		}

		ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPortProxy proxy = new ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPortProxy();
		proxy._getDescriptor().setEndpoint(CAFPropertiesUtil.getProducerRetrievalEndpoint());

		try {

			GetProducerListReply reply = proxy.getProducerList2X6(providerRequest);

			Object[] args = {reply};
			privateMethod = Producer2X6RetrievalAccessor.class.
			getDeclaredMethod("domainObjectFromProviderReply", new Class<?>[]{GetProducerListReply.class});
			privateMethod.setAccessible(true);

			List<PasKey> requestResult = (List<PasKey>) privateMethod.invoke(privateObject, (Object[])args);

			assertTrue("Producer list should not be empty",requestResult.size()==1);
			assertTrue("Producer Name should be null",requestResult.get(0).getProducerName()==null);
			
		}catch(Exception e){
			e.printStackTrace();
			fail("Producers creation failed");
		}
	}
	
	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		producer2X6RetrievalAccessor=null;
		privateObject=null;
	}

}
