
package ei.core.producer.prd2X6;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import ei.core.producer_prd2X6_http.GetFilteredProducerList2X6SimpleFaultReplyMsg;
import ei.core.producer_prd2X6_http.GetProducer2X6SimpleFaultReplyMsg;
import ei.core.producer_prd2X6_http.GetProducerList2X6SimpleFaultReplyMsg;
import ei.core.producer_prd2X6_http.GetProducerWithCommissionRates2X6SimpleFaultReplyMsg;

@WebService(name = "ProducerRetrievalPRD2X6", targetNamespace = "http://ei/producer/producer_retrieval_prd2x6")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ProducerRetrievalPRD2X6 {


    /**
     * 
     * @param getProducerRequest
     * @return
     *     returns com.test.prd2X6.GetProducerReply
     * @throws GetProducer2X6SimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetProducer2X6", action = "GetProducer2X6")
    @WebResult(name = "GetProducerReply", targetNamespace = "")
    @RequestWrapper(localName = "GetProducer2X6", targetNamespace = "http://ei/producer/producer_retrieval_prd2x6", className = "com.test.prd2X6.GetProducer2X6")
    @ResponseWrapper(localName = "GetProducer2X6Response", targetNamespace = "http://ei/producer/producer_retrieval_prd2x6", className = "com.test.prd2X6.GetProducer2X6Response")
    public GetProducerReply getProducer2X6(
        @WebParam(name = "GetProducerRequest", targetNamespace = "")
        GetProducerRequest getProducerRequest)
        throws GetProducer2X6SimpleFaultReplyMsg
    ;

    /**
     * 
     * @param getProducerWithCommissionRatesRequest
     * @return
     *     returns com.test.prd2X6.GetProducerWithCommissionRatesReply
     * @throws GetProducerWithCommissionRates2X6SimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetProducerWithCommissionRates2X6", action = "GetProducerWithCommissionRates2X6")
    @WebResult(name = "GetProducerWithCommissionRatesReply", targetNamespace = "")
    @RequestWrapper(localName = "GetProducerWithCommissionRates2X6", targetNamespace = "http://ei/producer/producer_retrieval_prd2x6", className = "com.test.prd2X6.GetProducerWithCommissionRates2X6")
    @ResponseWrapper(localName = "GetProducerWithCommissionRates2X6Response", targetNamespace = "http://ei/producer/producer_retrieval_prd2x6", className = "com.test.prd2X6.GetProducerWithCommissionRates2X6Response")
    public GetProducerWithCommissionRatesReply getProducerWithCommissionRates2X6(
        @WebParam(name = "GetProducerWithCommissionRatesRequest", targetNamespace = "")
        GetProducerWithCommissionRatesRequest getProducerWithCommissionRatesRequest)
        throws GetProducerWithCommissionRates2X6SimpleFaultReplyMsg
    ;

    /**
     * 
     * @param getProducerListRequest
     * @return
     *     returns com.test.prd2X6.GetProducerListReply
     * @throws GetProducerList2X6SimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetProducerList2X6", action = "GetProducerList2X6")
    @WebResult(name = "GetProducerListReply", targetNamespace = "")
    @RequestWrapper(localName = "GetProducerList2X6", targetNamespace = "http://ei/producer/producer_retrieval_prd2x6", className = "com.test.prd2X6.GetProducerList2X6")
    @ResponseWrapper(localName = "GetProducerList2X6Response", targetNamespace = "http://ei/producer/producer_retrieval_prd2x6", className = "com.test.prd2X6.GetProducerList2X6Response")
    public GetProducerListReply getProducerList2X6(
        @WebParam(name = "GetProducerListRequest", targetNamespace = "")
        GetProducerListRequest getProducerListRequest)
        throws GetProducerList2X6SimpleFaultReplyMsg
    ;

    /**
     * 
     * @param getFilteredProducerListRequest
     * @return
     *     returns com.test.prd2X6.GetFilteredProducerListReply
     * @throws GetFilteredProducerList2X6SimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetFilteredProducerList2X6", action = "GetFilteredProducerList2X6")
    @WebResult(name = "GetFilteredProducerListReply", targetNamespace = "")
    @RequestWrapper(localName = "GetFilteredProducerList2X6", targetNamespace = "http://ei/producer/producer_retrieval_prd2x6", className = "com.test.prd2X6.GetFilteredProducerList2X6")
    @ResponseWrapper(localName = "GetFilteredProducerList2X6Response", targetNamespace = "http://ei/producer/producer_retrieval_prd2x6", className = "com.test.prd2X6.GetFilteredProducerList2X6Response")
    public GetFilteredProducerListReply getFilteredProducerList2X6(
        @WebParam(name = "GetFilteredProducerListRequest", targetNamespace = "")
        GetFilteredProducerListRequest getFilteredProducerListRequest)
        throws GetFilteredProducerList2X6SimpleFaultReplyMsg
    ;

}
