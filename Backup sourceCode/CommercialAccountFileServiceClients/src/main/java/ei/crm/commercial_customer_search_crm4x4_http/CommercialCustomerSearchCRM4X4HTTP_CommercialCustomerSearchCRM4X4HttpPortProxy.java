package ei.crm.commercial_customer_search_crm4x4_http;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import ei.crm.name_search_by_all_names_reply_crm4x4.NameSearchByAllNamesReply;
import ei.crm.name_search_by_all_names_request_crm4x4.NameSearchByAllNamesRequest;
import ei.crm.name_search_by_all_primary_names_reply_crm4x4.NameSearchByAllPrimaryNamesReply;
import ei.crm.name_search_by_all_primary_names_request_crm4x4.NameSearchByAllPrimaryNamesRequest;
import ei.crm.name_search_reply_crm4x4.NameSearchReply;
import ei.crm.name_search_request_crm4x4.NameSearchRequest;

public class CommercialCustomerSearchCRM4X4HTTP_CommercialCustomerSearchCRM4X4HttpPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private ei.crm.commercial_customer_search_crm4x4_http.CommercialCustomerSearchCRM4X4HttpService _service = null;
        private ei.crm.commercial_customer_search_crm4x4_http.CommercialCustomerSearchCRM4X4 _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new ei.crm.commercial_customer_search_crm4x4_http.CommercialCustomerSearchCRM4X4HttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            _service = new ei.crm.commercial_customer_search_crm4x4_http.CommercialCustomerSearchCRM4X4HttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getCommercialCustomerSearchCRM4X4HTTPCommercialCustomerSearchCRM4X4HttpPort();
        }

        public ei.crm.commercial_customer_search_crm4x4_http.CommercialCustomerSearchCRM4X4 getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://ei/crm/commercial_customer_search_crm4x4_http", "CommercialCustomerSearchCRM4X4HTTP_CommercialCustomerSearchCRM4X4HttpPort");
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

    public CommercialCustomerSearchCRM4X4HTTP_CommercialCustomerSearchCRM4X4HttpPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public CommercialCustomerSearchCRM4X4HTTP_CommercialCustomerSearchCRM4X4HttpPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public NameSearchByAllPrimaryNamesReply nameSearchByAllPrimaryNames(NameSearchByAllPrimaryNamesRequest nameSearchByAllPrimaryNamesRequest) throws NameSearchByAllPrimaryNamesSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().nameSearchByAllPrimaryNames(nameSearchByAllPrimaryNamesRequest);
    }

    public NameSearchByAllNamesReply nameSearchByAllNames(NameSearchByAllNamesRequest nameSearchByAllNamesRequest) throws NameSearchByAllNamesSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().nameSearchByAllNames(nameSearchByAllNamesRequest);
    }

    public NameSearchReply nameSearch(NameSearchRequest nameSearchRequest) throws NameSearchSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().nameSearch(nameSearchRequest);
    }

}