package ei.producer.producer_cross_reference_retrieval_prd6x1_http;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import ei.producer.get_filtered_producer_cross_ref_list_reply_prd6x1.GetFilteredProducerCrossRefListReply;
import ei.producer.get_filtered_producer_cross_ref_list_request_prd6x1.GetFilteredProducerCrossRefListRequest;
import ei.producer.get_producer_cross_reference_reply_prd6x1.GetProducerCrossReferenceReply;
import ei.producer.get_producer_cross_reference_request_prd6x1.GetProducerCrossReferenceRequest;
import ei.producer.get_producer_id_reply_prd6x1.GetProducerIdReply;
import ei.producer.get_producer_id_request_prd6x1.GetProducerIdRequest;

public class ProducerCrossReferenceRetrievalPRD6X1HTTP_ProducerCrossReferenceRetrievalPRD6X1HttpPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private ei.producer.producer_cross_reference_retrieval_prd6x1_http.ProducerCrossReferenceRetrievalPRD6X1HttpService _service = null;
        private ei.producer.producer_cross_reference_retrieval_prd6x1_http.ProducerCrossReferenceRetrievalPRD6X1 _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new ei.producer.producer_cross_reference_retrieval_prd6x1_http.ProducerCrossReferenceRetrievalPRD6X1HttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            _service = new ei.producer.producer_cross_reference_retrieval_prd6x1_http.ProducerCrossReferenceRetrievalPRD6X1HttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getProducerCrossReferenceRetrievalPRD6X1HTTPProducerCrossReferenceRetrievalPRD6X1HttpPort();
        }

        public ei.producer.producer_cross_reference_retrieval_prd6x1_http.ProducerCrossReferenceRetrievalPRD6X1 getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("", "ProducerCrossReferenceRetrievalPRD6X1HTTP_ProducerCrossReferenceRetrievalPRD6X1HttpPort");
                _dispatch = _service.createDispatch(portQName, Source.class, Service.Mode.MESSAGE);

                String proxyEndpointUrl = getEndpoint();
                BindingProvider bp = (BindingProvider) _dispatch;
                String dispatchEndpointUrl = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
                if (!dispatchEndpointUrl.equals(proxyEndpointUrl))
                    bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, proxyEndpointUrl);
            }
            return _dispatch;
        }

        public String getEndpoint() {
            BindingProvider bp = (BindingProvider) _proxy;
            return (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
        }

        public void setEndpoint(String endpointUrl) {
            BindingProvider bp = (BindingProvider) _proxy;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

            if (_dispatch != null ) {
                bp = (BindingProvider) _dispatch;
                bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);
            }
        }

        public void setMTOMEnabled(boolean enable) {
            SOAPBinding binding = (SOAPBinding) ((BindingProvider) _proxy).getBinding();
            binding.setMTOMEnabled(enable);
        }
    }

    public ProducerCrossReferenceRetrievalPRD6X1HTTP_ProducerCrossReferenceRetrievalPRD6X1HttpPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public ProducerCrossReferenceRetrievalPRD6X1HTTP_ProducerCrossReferenceRetrievalPRD6X1HttpPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public GetProducerCrossReferenceReply getProducerCrossReference(GetProducerCrossReferenceRequest getProducerCrossReferenceRequest) throws GetProducerCrossReferenceSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getProducerCrossReference(getProducerCrossReferenceRequest);
    }

    public GetFilteredProducerCrossRefListReply getFilteredProducerCrossRefList(GetFilteredProducerCrossRefListRequest getFilteredProducerCrossRefListRequest) throws GetFilteredProducerCrossRefListSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getFilteredProducerCrossRefList(getFilteredProducerCrossRefListRequest);
    }

    public GetProducerIdReply getProducerId(GetProducerIdRequest getProducerIdRequest) throws GetProducerIdSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getProducerId(getProducerIdRequest);
    }

}