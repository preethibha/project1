
package ei.producer.producer_cross_reference_retrieval_prd6x1_http;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import ei.producer.get_filtered_producer_cross_ref_list_reply_prd6x1.GetFilteredProducerCrossRefListReply;
import ei.producer.get_filtered_producer_cross_ref_list_request_prd6x1.GetFilteredProducerCrossRefListRequest;
import ei.producer.get_producer_cross_reference_reply_prd6x1.GetProducerCrossReferenceReply;
import ei.producer.get_producer_cross_reference_request_prd6x1.GetProducerCrossReferenceRequest;
import ei.producer.get_producer_id_reply_prd6x1.GetProducerIdReply;
import ei.producer.get_producer_id_request_prd6x1.GetProducerIdRequest;

@WebService(name = "ProducerCrossReferenceRetrievalPRD6X1", targetNamespace = "http://ei/producer/producer_cross_reference_retrieval_prd6x1")
@XmlSeeAlso({
    ei.core.addressx5.ObjectFactory.class,
    ei.core.branchx1.ObjectFactory.class,
    ei.core.error_information.ObjectFactory.class,
    ei.core.simplefault.ObjectFactory.class,
    ei.core.status_informationx2.ObjectFactory.class,
    ei.producer.get_filtered_producer_cross_ref_list_inputs_prd6x1.ObjectFactory.class,
    ei.producer.get_filtered_producer_cross_ref_list_reply_prd6x1.ObjectFactory.class,
    ei.producer.get_filtered_producer_cross_ref_list_request_prd6x1.ObjectFactory.class,
    ei.producer.get_producer_cross_reference_reply_prd6x1.ObjectFactory.class,
    ei.producer.get_producer_cross_reference_request_prd6x1.ObjectFactory.class,
    ei.producer.get_producer_id_reply_prd6x1.ObjectFactory.class,
    ei.producer.get_producer_id_request_prd6x1.ObjectFactory.class,
    ei.producer.producer_cross_reference.ObjectFactory.class,
    ei.producer.producer_cross_reference_retrieval_prd6x1.ObjectFactory.class
})
public interface ProducerCrossReferenceRetrievalPRD6X1 {


    /**
     * 
     * @param getProducerCrossReferenceRequest
     * @return
     *     returns ei.producer.get_producer_cross_reference_reply_prd6x1.GetProducerCrossReferenceReply
     * @throws GetProducerCrossReferenceSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetProducerCrossReference", action = "GetProducerCrossReference")
    @WebResult(name = "GetProducerCrossReferenceReply", targetNamespace = "")
    @RequestWrapper(localName = "GetProducerCrossReference", targetNamespace = "http://ei/producer/producer_cross_reference_retrieval_prd6x1", className = "ei.producer.producer_cross_reference_retrieval_prd6x1.GetProducerCrossReference")
    @ResponseWrapper(localName = "GetProducerCrossReferenceResponse", targetNamespace = "http://ei/producer/producer_cross_reference_retrieval_prd6x1", className = "ei.producer.producer_cross_reference_retrieval_prd6x1.GetProducerCrossReferenceResponse")
    public GetProducerCrossReferenceReply getProducerCrossReference(
        @WebParam(name = "GetProducerCrossReferenceRequest", targetNamespace = "")
        GetProducerCrossReferenceRequest getProducerCrossReferenceRequest)
        throws GetProducerCrossReferenceSimpleFaultReplyMsg
    ;

    /**
     * 
     * @param getFilteredProducerCrossRefListRequest
     * @return
     *     returns ei.producer.get_filtered_producer_cross_ref_list_reply_prd6x1.GetFilteredProducerCrossRefListReply
     * @throws GetFilteredProducerCrossRefListSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetFilteredProducerCrossRefList", action = "GetFilteredProducerCrossRefList")
    @WebResult(name = "GetFilteredProducerCrossRefListReply", targetNamespace = "")
    @RequestWrapper(localName = "GetFilteredProducerCrossRefList", targetNamespace = "http://ei/producer/producer_cross_reference_retrieval_prd6x1", className = "ei.producer.producer_cross_reference_retrieval_prd6x1.GetFilteredProducerCrossRefList")
    @ResponseWrapper(localName = "GetFilteredProducerCrossRefListResponse", targetNamespace = "http://ei/producer/producer_cross_reference_retrieval_prd6x1", className = "ei.producer.producer_cross_reference_retrieval_prd6x1.GetFilteredProducerCrossRefListResponse")
    public GetFilteredProducerCrossRefListReply getFilteredProducerCrossRefList(
        @WebParam(name = "GetFilteredProducerCrossRefListRequest", targetNamespace = "")
        GetFilteredProducerCrossRefListRequest getFilteredProducerCrossRefListRequest)
        throws GetFilteredProducerCrossRefListSimpleFaultReplyMsg
    ;

    /**
     * 
     * @param getProducerIdRequest
     * @return
     *     returns ei.producer.get_producer_id_reply_prd6x1.GetProducerIdReply
     * @throws GetProducerIdSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetProducerId", action = "GetProducerId")
    @WebResult(name = "GetProducerIdReply", targetNamespace = "")
    @RequestWrapper(localName = "GetProducerId", targetNamespace = "http://ei/producer/producer_cross_reference_retrieval_prd6x1", className = "ei.producer.producer_cross_reference_retrieval_prd6x1.GetProducerId")
    @ResponseWrapper(localName = "GetProducerIdResponse", targetNamespace = "http://ei/producer/producer_cross_reference_retrieval_prd6x1", className = "ei.producer.producer_cross_reference_retrieval_prd6x1.GetProducerIdResponse")
    public GetProducerIdReply getProducerId(
        @WebParam(name = "GetProducerIdRequest", targetNamespace = "")
        GetProducerIdRequest getProducerIdRequest)
        throws GetProducerIdSimpleFaultReplyMsg
    ;

}
