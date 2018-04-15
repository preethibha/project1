package com.chubb.dgmk.caf.wsc.accessors.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chubb.dgmk.caf.domain.model.Product;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;
import com.chubb.dgmk.caf.wsc.accessors.ProductRetrievalAccessor;

import ei.product.get_marketing_product_group_list_reply_pdt1x1.GetMarketingProductGroupListReply;
import ei.product.get_marketing_product_group_list_request_pdt1x1.GetMarketingProductGroupListRequest;
import ei.product.product_retrieval_pdt1x1_http.ProductRetrievalPDT1X1HTTP_ProductRetrievalPDT1X1HttpPortProxy;

public class ProductRetrievalAccessorTest {

	ProductRetrievalAccessor productRetrievalAccessor;
	ProductRetrievalAccessor privateObject;
	Method privateMethod;

	@Before
	public void setUp() throws Exception {
		productRetrievalAccessor=new ProductRetrievalAccessor();
		privateObject=new ProductRetrievalAccessor();
		CAFPropertiesUtil.setProductRetrievalEndpoint("http://EIPRDCTRETRVLPDT1X1-st/ProductServicesWeb/sca/ProductRetrievalPDT1X1Http");
	}

	/**
	 * <pre>
	 * 
	 * testGetEndpoint
	 * June 30, 2015
	 * 
	 * This method is used to test the endPoint for the productRetrieval service from
	 * the properties file.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetEndpoint() {
		String endPointUrl="http://EIPRDCTRETRVLPDT1X1-st/ProductServicesWeb/sca/ProductRetrievalPDT1X1Http";

		String endPoint=productRetrievalAccessor.getEndpoint();

		assertTrue("Invalid endPoint url for policy retrieval",endPointUrl.equals(endPoint));
	}

	/**
	 * <pre>
	 * 
	 * testGetAtChubbProducts
	 * June 30, 2015
	 * 
	 * This method is used to test the endPoint for the productRetrieval service from
	 * the properties file.
	 *  
	 * @return void
	 * 
	 * </pre>
	 */
	@Test
	public final void testGetAtChubbProducts() {
		List<Product> productLst;
		try {
			productLst = productRetrievalAccessor.getAtChubbProducts();
			assertTrue("Product list size should not be empty",productLst.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * <pre>
	 * testDomainObjectFromProviderReply
	 * 
	 * June 30, 2015
	 * 
	 * This test method is used to map the ICC provider reply GetProductListReply to
	 * list of Products CAF domain objects.
	 * 
	 * 
	 * @return void
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testDomainObjectFromProviderReply() {


		GetMarketingProductGroupListRequest providerRequest = new GetMarketingProductGroupListRequest();
		providerRequest.setUserId("p62240b");
		providerRequest.setSystemId(ICAFConstants.SOURCE_SYSTEM_ID);

		ProductRetrievalPDT1X1HTTP_ProductRetrievalPDT1X1HttpPortProxy proxy = new ProductRetrievalPDT1X1HTTP_ProductRetrievalPDT1X1HttpPortProxy();
		proxy._getDescriptor().setEndpoint("http://EIPRDCTRETRVLPDT1X1-st/ProductServicesWeb/sca/ProductRetrievalPDT1X1Http");

		try {
			GetMarketingProductGroupListReply reply = proxy.getMarketingProductGroupList(providerRequest);

			Object[] args = {reply};

			privateMethod = ProductRetrievalAccessor.class.
			getDeclaredMethod("domainObjectFromProviderReply", new Class<?>[]{GetMarketingProductGroupListReply.class});
			privateMethod.setAccessible(true);

			ArrayList<Product> products = (ArrayList<Product>) privateMethod.invoke(privateObject, (Object[])args);

			assertNotNull("Product list should not be empty",products.size()>0);

		}catch(Exception e){
			e.printStackTrace();
			fail("products creation failed");
		}
	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		productRetrievalAccessor=null;
		privateObject=null;
	}
}
