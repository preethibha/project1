package ei.corporate.contact_retrieval_crp30x1_http;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import ei.corporate.get_default_contact_reply_crp30x1.GetDefaultContactReply;
import ei.corporate.get_default_contact_request_crp30x1.GetDefaultContactRequest;
import ei.corporate.get_policy_contact_list_by_defined_role_reply_crp30x1.GetPolicyContactListByDefinedRoleReply;
import ei.corporate.get_policy_contact_list_by_defined_role_request_crp30x1.GetPolicyContactListByDefinedRoleRequest;
import ei.corporate.get_policy_contact_list_reply_crp30x1.GetPolicyContactListReply;
import ei.corporate.get_policy_contact_list_request_crp30x1.GetPolicyContactListRequest;

public class ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private ei.corporate.contact_retrieval_crp30x1_http.ContactRetrievalCRP30X1HttpService _service = null;
        private ei.corporate.contact_retrieval_crp30x1_http.ContactRetrievalCRP30X1 _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new ei.corporate.contact_retrieval_crp30x1_http.ContactRetrievalCRP30X1HttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            _service = new ei.corporate.contact_retrieval_crp30x1_http.ContactRetrievalCRP30X1HttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getContactRetrievalCRP30X1HTTPContactRetrievalCRP30X1HttpPort();
        }

        public ei.corporate.contact_retrieval_crp30x1_http.ContactRetrievalCRP30X1 getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://ei/corporate/contact_retrieval_crp30x1_http", "ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPort");
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

    public ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public ContactRetrievalCRP30X1HTTP_ContactRetrievalCRP30X1HttpPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public GetPolicyContactListReply getPolicyContactList(GetPolicyContactListRequest getPolicyContactListRequest) throws GetPolicyContactListSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getPolicyContactList(getPolicyContactListRequest);
    }

    public GetDefaultContactReply getDefaultContact(GetDefaultContactRequest getDefaultContactRequest) throws GetDefaultContactSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getDefaultContact(getDefaultContactRequest);
    }

    public GetPolicyContactListByDefinedRoleReply getPolicyContactListByDefinedRole(GetPolicyContactListByDefinedRoleRequest getPolicyContactListByDefinedRoleRequest) throws GetPolicyContactListByDefinedRoleSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getPolicyContactListByDefinedRole(getPolicyContactListByDefinedRoleRequest);
    }

}