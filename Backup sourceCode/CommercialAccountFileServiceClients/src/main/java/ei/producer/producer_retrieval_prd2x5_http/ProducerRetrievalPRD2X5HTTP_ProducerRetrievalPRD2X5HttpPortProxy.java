package ei.producer.producer_retrieval_prd2x5_http;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import ei.producer.get_filtered_producer_list_reply_prd2x5.GetFilteredProducerListReply;
import ei.producer.get_filtered_producer_list_request_prd2x5.GetFilteredProducerListRequest;
import ei.producer.get_producer_list_reply_prd2x5.GetProducerListReply;
import ei.producer.get_producer_list_request_prd2x5.GetProducerListRequest;
import ei.producer.get_producer_reply_prd2x5.GetProducerReply;
import ei.producer.get_producer_request_prd2x5.GetProducerRequest;
import ei.producer.get_producer_with_commission_rates_reply_prd2x5.GetProducerWithCommissionRatesReply;
import ei.producer.get_producer_with_commission_rates_request_prd2x5.GetProducerWithCommissionRatesRequest;

public class ProducerRetrievalPRD2X5HTTP_ProducerRetrievalPRD2X5HttpPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private ei.producer.producer_retrieval_prd2x5_http.ProducerRetrievalPRD2X5HttpService _service = null;
        private ei.producer.producer_retrieval_prd2x5_http.ProducerRetrievalPRD2X5 _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new ei.producer.producer_retrieval_prd2x5_http.ProducerRetrievalPRD2X5HttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            _service = new ei.producer.producer_retrieval_prd2x5_http.ProducerRetrievalPRD2X5HttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getProducerRetrievalPRD2X5HTTPProducerRetrievalPRD2X5HttpPort();
        }

        public ei.producer.producer_retrieval_prd2x5_http.ProducerRetrievalPRD2X5 getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://ei/producer/producer_retrieval_prd2x5_http", "ProducerRetrievalPRD2X5HTTP_ProducerRetrievalPRD2X5HttpPort");
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

    public ProducerRetrievalPRD2X5HTTP_ProducerRetrievalPRD2X5HttpPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public ProducerRetrievalPRD2X5HTTP_ProducerRetrievalPRD2X5HttpPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public GetProducerReply getProducer2X5(GetProducerRequest getProducerRequest) throws GetProducer2X5SimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getProducer2X5(getProducerRequest);
    }

    public GetProducerWithCommissionRatesReply getProducerWithCommissionRates2X5(GetProducerWithCommissionRatesRequest getProducerWithCommissionRatesRequest) throws GetProducerWithCommissionRates2X5SimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getProducerWithCommissionRates2X5(getProducerWithCommissionRatesRequest);
    }

    public GetProducerListReply getProducerList2X5(GetProducerListRequest getProducerListRequest) throws GetProducerList2X5SimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getProducerList2X5(getProducerListRequest);
    }

    public GetFilteredProducerListReply getFilteredProducerList2X5(GetFilteredProducerListRequest getFilteredProducerListRequest) throws GetFilteredProducerList2X5SimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getFilteredProducerList2X5(getFilteredProducerListRequest);
    }

}