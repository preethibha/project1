//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.product.product_retrieval_pdt1x1_http;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import ei.product.get_filtered_product_list_reply_pdt1x1.GetFilteredProductListReply;
import ei.product.get_filtered_product_list_request_pdt1x1.GetFilteredProductListRequest;
import ei.product.get_marketing_product_group_list_reply_pdt1x1.GetMarketingProductGroupListReply;
import ei.product.get_marketing_product_group_list_request_pdt1x1.GetMarketingProductGroupListRequest;
import ei.product.get_product_reply_pdt1x1.GetProductReply;
import ei.product.get_product_request_pdt1x1.GetProductRequest;

@WebService(name = "ProductRetrievalPDT1X1", targetNamespace = "http://ei/product/product_retrieval_pdt1x1")
@XmlSeeAlso({
    ei.core.prdct_compnt_loss_value_option.ObjectFactory.class,
    ei.core.prdct_compnt_cross_reference.ObjectFactory.class,
    ei.core.prdct_compnt_exclusion_variation.ObjectFactory.class,
    ei.core.simplefault.ObjectFactory.class,
    ei.core.prdct_compnt_hazard.ObjectFactory.class,
    ei.core.prdct_compnt_rule_group.ObjectFactory.class,
    ei.core.prdct_compnt_subject_type_part.ObjectFactory.class,
    ei.product.product_availability_inputs_pdt1x1.ObjectFactory.class,
    ei.product.get_filtered_product_list_request_pdt1x1.ObjectFactory.class,
    ei.product.get_marketing_product_group_list_request_pdt1x1.ObjectFactory.class,
    ei.product.get_filtered_product_list_reply_pdt1x1.ObjectFactory.class,
    ei.core.prdct_compnt_statistical_instruction.ObjectFactory.class,
    ei.core.error_information.ObjectFactory.class,
    ei.core.product.ObjectFactory.class,
    ei.core.prdct_compnt_restriction_option.ObjectFactory.class,
    ei.product.get_product_reply_pdt1x1.ObjectFactory.class,
    ei.product.get_product_request_pdt1x1.ObjectFactory.class,
    ei.core.status_informationx2.ObjectFactory.class,
    ei.product.get_marketing_product_group_list_reply_pdt1x1.ObjectFactory.class,
    ei.core.prdct_compnt_product_part.ObjectFactory.class,
    ei.product.product_retrieval_pdt1x1.ObjectFactory.class
})
public interface ProductRetrievalPDT1X1 {


    /**
     * 
     * @param getProductRequest
     * @return
     *     returns ei.product.get_product_reply_pdt1x1.GetProductReply
     * @throws GetProductSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetProduct", action = "GetProduct")
    @WebResult(name = "GetProductReply", targetNamespace = "")
    @RequestWrapper(localName = "GetProduct", targetNamespace = "http://ei/product/product_retrieval_pdt1x1", className = "ei.product.product_retrieval_pdt1x1.GetProduct")
    @ResponseWrapper(localName = "GetProductResponse", targetNamespace = "http://ei/product/product_retrieval_pdt1x1", className = "ei.product.product_retrieval_pdt1x1.GetProductResponse")
    public GetProductReply getProduct(
        @WebParam(name = "GetProductRequest", targetNamespace = "")
        GetProductRequest getProductRequest)
        throws GetProductSimpleFaultReplyMsg
    ;

    /**
     * 
     * @param getFilteredProductListRequest
     * @return
     *     returns ei.product.get_filtered_product_list_reply_pdt1x1.GetFilteredProductListReply
     * @throws GetFilteredProductListSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetFilteredProductList", action = "GetFilteredProductList")
    @WebResult(name = "GetFilteredProductListReply", targetNamespace = "")
    @RequestWrapper(localName = "GetFilteredProductList", targetNamespace = "http://ei/product/product_retrieval_pdt1x1", className = "ei.product.product_retrieval_pdt1x1.GetFilteredProductList")
    @ResponseWrapper(localName = "GetFilteredProductListResponse", targetNamespace = "http://ei/product/product_retrieval_pdt1x1", className = "ei.product.product_retrieval_pdt1x1.GetFilteredProductListResponse")
    public GetFilteredProductListReply getFilteredProductList(
        @WebParam(name = "GetFilteredProductListRequest", targetNamespace = "")
        GetFilteredProductListRequest getFilteredProductListRequest)
        throws GetFilteredProductListSimpleFaultReplyMsg
    ;

    /**
     * 
     * @param getMarketingProductGroupListRequest
     * @return
     *     returns ei.product.get_marketing_product_group_list_reply_pdt1x1.GetMarketingProductGroupListReply
     * @throws GetMarketingProductGroupListSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetMarketingProductGroupList", action = "GetMarketingProductGroupList")
    @WebResult(name = "GetMarketingProductGroupListReply", targetNamespace = "")
    @RequestWrapper(localName = "GetMarketingProductGroupList", targetNamespace = "http://ei/product/product_retrieval_pdt1x1", className = "ei.product.product_retrieval_pdt1x1.GetMarketingProductGroupList")
    @ResponseWrapper(localName = "GetMarketingProductGroupListResponse", targetNamespace = "http://ei/product/product_retrieval_pdt1x1", className = "ei.product.product_retrieval_pdt1x1.GetMarketingProductGroupListResponse")
    public GetMarketingProductGroupListReply getMarketingProductGroupList(
        @WebParam(name = "GetMarketingProductGroupListRequest", targetNamespace = "")
        GetMarketingProductGroupListRequest getMarketingProductGroupListRequest)
        throws GetMarketingProductGroupListSimpleFaultReplyMsg
    ;

}
