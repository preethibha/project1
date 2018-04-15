package ei.core.producer_prd2X6_http;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import ei.core.producer.prd2X6.GetFilteredProducerListReply;
import ei.core.producer.prd2X6.GetFilteredProducerListRequest;
import ei.core.producer.prd2X6.GetProducerListReply;
import ei.core.producer.prd2X6.GetProducerListRequest;
import ei.core.producer.prd2X6.GetProducerReply;
import ei.core.producer.prd2X6.GetProducerRequest;
import ei.core.producer.prd2X6.GetProducerWithCommissionRatesReply;
import ei.core.producer.prd2X6.GetProducerWithCommissionRatesRequest;
import ei.core.producer.prd2X6.ProducerRetrievalPRD2X6;

public class ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private ei.core.producer_prd2X6_http.ProducerRetrievalPRD2X6HttpService _service = null;
        private ei.core.producer.prd2X6.ProducerRetrievalPRD2X6 _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new ei.core.producer_prd2X6_http.ProducerRetrievalPRD2X6HttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            _service = new ei.core.producer_prd2X6_http.ProducerRetrievalPRD2X6HttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getProducerRetrievalPRD2X6HTTPProducerRetrievalPRD2X6HttpPort();
        }

        public ei.core.producer.prd2X6.ProducerRetrievalPRD2X6 getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("", "ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPort");
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

    public ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public ProducerRetrievalPRD2X6HTTP_ProducerRetrievalPRD2X6HttpPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public GetProducerReply getProducer2X6(GetProducerRequest getProducerRequest) throws GetProducer2X6SimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getProducer2X6(getProducerRequest);
    }

    public GetProducerWithCommissionRatesReply getProducerWithCommissionRates2X6(GetProducerWithCommissionRatesRequest getProducerWithCommissionRatesRequest) throws GetProducerWithCommissionRates2X6SimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getProducerWithCommissionRates2X6(getProducerWithCommissionRatesRequest);
    }

    public GetProducerListReply getProducerList2X6(GetProducerListRequest getProducerListRequest) throws GetProducerList2X6SimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getProducerList2X6(getProducerListRequest);
    }

    public GetFilteredProducerListReply getFilteredProducerList2X6(GetFilteredProducerListRequest getFilteredProducerListRequest) throws GetFilteredProducerList2X6SimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getFilteredProducerList2X6(getFilteredProducerListRequest);
    }

}