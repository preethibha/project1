package ei.user.profile_retrieval_crp31X1x1_http;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import ei.user.profile.GetUserProfileListByEmailReply;
import ei.user.profile.GetUserProfileListByEmailRequest;
import ei.user.profile.GetUserProfileListReply;
import ei.user.profile.GetUserProfileListRequest;
import ei.user.profile.GetUserProfileReply;
import ei.user.profile.GetUserProfileRequest;

public class UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private ei.user.profile_retrieval_crp31X1x1_http.UserProfileRetrievalCRP31X1HttpService _service = null;
        private ei.user.profile_retrieval_crp31X1x1_http.UserProfileRetrievalCRP31X1 _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new ei.user.profile_retrieval_crp31X1x1_http.UserProfileRetrievalCRP31X1HttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            _service = new ei.user.profile_retrieval_crp31X1x1_http.UserProfileRetrievalCRP31X1HttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getUserProfileRetrievalCRP31X1HTTPUserProfileRetrievalCRP31X1HttpPort();
        }

        public ei.user.profile_retrieval_crp31X1x1_http.UserProfileRetrievalCRP31X1 getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("", "UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPort");
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

    public UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public GetUserProfileReply getUserProfile(GetUserProfileRequest getUserProfileRequest) throws GetUserProfileSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getUserProfile(getUserProfileRequest);
    }

    public GetUserProfileListReply getUserProfileList(GetUserProfileListRequest getUserProfileListRequest) throws GetUserProfileListSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getUserProfileList(getUserProfileListRequest);
    }

    public GetUserProfileListByEmailReply getUserProfileListByEmail(GetUserProfileListByEmailRequest getUserProfileListByEmailRequest) throws GetUserProfileListByEmailSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getUserProfileListByEmail(getUserProfileListByEmailRequest);
    }

}