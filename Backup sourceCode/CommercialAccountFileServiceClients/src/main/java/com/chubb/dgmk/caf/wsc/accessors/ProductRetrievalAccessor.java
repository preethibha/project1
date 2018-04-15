package com.chubb.dgmk.caf.wsc.accessors;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.chubb.dgmk.caf.domain.model.Product;
import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.CAFException;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;
import com.chubb.dgmk.caf.util.StringUtil;

import ei.core.error_information.ErrorInformation;
import ei.core.status_informationx2.StatusInformation;
import ei.product.get_marketing_product_group_list_reply_pdt1x1.GetMarketingProductGroupListReply;
import ei.product.get_marketing_product_group_list_request_pdt1x1.GetMarketingProductGroupListRequest;
import ei.product.product_retrieval_pdt1x1_http.GetProductListSimpleFaultReplyMsg;
import ei.product.product_retrieval_pdt1x1_http.ProductRetrievalPDT1X1HTTP_ProductRetrievalPDT1X1HttpPortProxy;

/**
 * <pre>
 * ProductRetrievalAccessor
 * May 8, 2015
 * 
 * The ProductRetrievalAccessor class is responsible for retrieving the list of 
 * AtChubb products available on the database.Data is obtained from a back-end
 * dataStore via an ICC service call.
 *
 * </pre> 
 */
public class ProductRetrievalAccessor {

	/**
	 * <pre>
	 * getEndpoint
	 * May 7, 2015
	 * 
	 * This method is used to get ProductRetrieval service end point URL which loaded at the time of application initialization
	 * 
	 * @return the endPoint for the ProductRetrieval service from
	 * the properties file.
	 * 
	 * </pre>
	 */
	public String getEndpoint() {

		String endpoint = CAFPropertiesUtil.getProductRetrievalEndpoint();
		CAFLogger.logInfo("Endpoint returned for ProductRetrieval: " + endpoint, "ProductRetrievalAccessor", "getEndpoint");

		return endpoint;
	}

	/**
	 * <pre>
	 * getAtChubbProducts
	 * May 8, 2015
	 * 
	 * This method will call the ICC provider service and will get
	 * the list of products from it
	 * 
	 * @return the list of AtChubb products
	 * 
	 * </pre>
	 */
	public List<Product> getAtChubbProducts() throws Exception {

		String endpoint = getEndpoint();

		ArrayList<Product> products = new ArrayList<Product>();
		//call the service

		ProductRetrievalPDT1X1HTTP_ProductRetrievalPDT1X1HttpPortProxy proxy = new ProductRetrievalPDT1X1HTTP_ProductRetrievalPDT1X1HttpPortProxy();
		proxy._getDescriptor().setEndpoint(endpoint);

		try {
			GetMarketingProductGroupListRequest providerRequest = buildRequest();
			
			GetMarketingProductGroupListReply reply = proxy.getMarketingProductGroupList(providerRequest);
			if (reply!=null)
			CAFLogger.logFine("List Of Product Retrieved :" + reply.toString() ,  "ProducerRetrievalAccessor", "domainObjectFromProviderReply");
			//build the domain object from the service reply
			products = domainObjectFromProviderReply(reply); 

		}catch (GetProductListSimpleFaultReplyMsg simpleFault) {
			String msg ="Fault returned from ProductRetrievalPDT1X1HTTP: " + simpleFault.getFaultInfo().getFaultMessageText(); 
			CAFLogger.logSevere(msg, "ProductRetrievalAccessor", "getAtChubbProducts");
			throw simpleFault;

		} 
		catch (CAFException cafEx){
			String msg ="An error was returned from ProductRetrievalPDT1X1HTTP: " + cafEx.getMessage(); 
			CAFLogger.logSevere(msg, "ProductRetrievalAccessor", "getAtChubbProducts");
			throw cafEx;

		}catch (Exception e) {
			String msg = "Exception occurred calling ProductRetrievalPDT1X1HTTP: " + e;
			CAFLogger.logSevere(msg, "ProductRetrievalAccessor", "getAtChubbProducts");
			e.printStackTrace();
			throw e;

		}
		return products;

	}

	/**
	 * <pre>
	 * buildRequest
	 * 
	 * May 8, 2015
	 * 
	 * Create instance of GetMarketingProductGroupListRequest from ObjectFactory
	 * Map the CAF Model object to the request object required by the provider service
	 * @return the GetMarketingProductGroupListRequest Object
	 *  
	 * </pre>
	 */
	private GetMarketingProductGroupListRequest buildRequest() throws Exception {

		GetMarketingProductGroupListRequest request =new GetMarketingProductGroupListRequest();

		XMLGregorianCalendar asOfDate;
		asOfDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());

		request.setAsOfDate(asOfDate);
		request.setSystemId(ICAFConstants.SOURCE_SYSTEM_ID);
		request.setUserId(ICAFConstants.USER_ID);
		request.setDataSourceOptionsText(ICAFConstants.DATA_SOURCE_OPTIONS_TEXT_DIGITAL);
		CAFLogger.logInfo("Request object ", "ProductRetrievalAccessor", "buildRequest is "+request.toString());
		return request;

	}

	/**
	 * <pre>
	 * domainObjectFromProviderReply
	 * 
	 * May 8, 2015
	 * 
	 * This method will map the ICC provider reply GetMarketingProductGroupListReply to
	 * list of Products CAF domain objects.
	 * 
	 * @param GetMarketingProductGroupListReply
	 * @return a list of Product domain objects
	 * @throws CAFException 
	 * </pre>
	 */
	private ArrayList<Product> domainObjectFromProviderReply(GetMarketingProductGroupListReply reply) throws CAFException {

		StatusInformation statusInfo = reply.getStatusInformation();
		if ("E".equalsIgnoreCase(statusInfo.getStatusCode())){
			List<ErrorInformation> errors = statusInfo.getErrorInformation();
			List<String> messages = new ArrayList<String>();
			for (ErrorInformation error:errors){
				messages.add(error.getErrorDescription());
				
				CAFLogger.logWarning("An error was returned from PDT1X1: " + error.getErrorCode() + ": " + error.getErrorDescription(),  "ProductRetrievalAccessor", "domainObjectFromProviderReply");
			}
			throw new CAFException(StringUtil.concatenateMessage(messages, "; "));
		} else if ("W".equalsIgnoreCase(statusInfo.getStatusCode())){
			{
				List<ErrorInformation> errors = statusInfo.getErrorInformation();
				List<String> messages = new ArrayList<String>();
				for (ErrorInformation error:errors){
					messages.add(error.getErrorDescription());
					CAFLogger.logWarning("A warning was returned from PDT1X1: " + error.getErrorCode() + ": " + error.getErrorDescription(),  "ProductRetrievalAccessor", "domainObjectFromProviderReply");
				}
				throw new CAFException(StringUtil.concatenateMessage(messages, "; "));
			}
		}

		ArrayList<Product> products = new ArrayList<Product>();
		List<ei.core.product.Product> productsList = reply.getProduct();

		for (ei.core.product.Product product:productsList){
			Product prod = new Product();
			prod.productCode = product.getInsurerProductCode();
			prod.productName = product.getProductComponentName();
			
			products.add(prod);
		}

		CAFLogger.logInfo("Domain object built from PDT1X1 response",  "ProductRetrievalAccessor", "domainObjectFromProviderReply");

		return products;

	}

}