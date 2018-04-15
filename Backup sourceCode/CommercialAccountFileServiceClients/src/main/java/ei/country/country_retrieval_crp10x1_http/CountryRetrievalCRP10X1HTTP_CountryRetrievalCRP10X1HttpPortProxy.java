package ei.country.country_retrieval_crp10x1_http;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.datatype.XMLGregorianCalendar;
import ei.core.country.Country;
import ei.corporate.get_country_list_reply_crp10x1.GetCountryListReply;
import ei.corporate.get_country_request_crp10x1.GetCountryRequest;

public class CountryRetrievalCRP10X1HTTP_CountryRetrievalCRP10X1HttpPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private ei.country.country_retrieval_crp10x1_http.CountryRetrievalCRP10X1HttpService _service = null;
        private ei.country.country_retrieval_crp10x1_http.CountryRetrievalCRP10X1 _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new ei.country.country_retrieval_crp10x1_http.CountryRetrievalCRP10X1HttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            _service = new ei.country.country_retrieval_crp10x1_http.CountryRetrievalCRP10X1HttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getCountryRetrievalCRP10X1HTTPCountryRetrievalCRP10X1HttpPort();
        }

        public ei.country.country_retrieval_crp10x1_http.CountryRetrievalCRP10X1 getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://ei/country/country_retrieval_crp10X1_http", "CountryRetrievalCRP10X1HTTP_CountryRetrievalCRP10X1HttpPort");
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

    public CountryRetrievalCRP10X1HTTP_CountryRetrievalCRP10X1HttpPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public CountryRetrievalCRP10X1HTTP_CountryRetrievalCRP10X1HttpPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public GetCountryListReply getCountryList(XMLGregorianCalendar asOfDate) throws GetCountryListSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getCountryList(asOfDate);
    }

    public Country getCountry(GetCountryRequest getCountryRequest) throws GetCountrySimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getCountry(getCountryRequest);
    }

}