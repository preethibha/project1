package chubb_corporate.business.get_access_user_profile_management_ebe4x1_http;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import chubb_corporate.business.add_get_access_user_profile_reply_ebe4x1.AddGetAccessUserProfileReply;
import chubb_corporate.business.add_get_access_user_profile_request_ebe4x1.AddGetAccessUserProfileRequest;
import chubb_corporate.business.change_get_access_user_password_reply_ebe4x1.ChangeGetAccessUserPasswordReply;
import chubb_corporate.business.change_get_access_user_password_request_ebe4x1.ChangeGetAccessUserPasswordRequest;
import chubb_corporate.business.get_access_user_profile_list_reply_ebe4x1.GetAccessUserProfileListReply;
import chubb_corporate.business.get_access_user_profile_list_request_ebe4x1.GetAccessUserProfileListRequest;
import chubb_corporate.business.get_access_user_profile_reply_ebe4x1.GetAccessUserProfileReply;
import chubb_corporate.business.get_access_user_profile_request_ebe4x1.GetAccessUserProfileRequest;
import chubb_corporate.business.reset_get_access_user_password_reply_ebe4x1.ResetGetAccessUserPasswordReply;
import chubb_corporate.business.reset_get_access_user_password_request_ebe4x1.ResetGetAccessUserPasswordRequest;
import chubb_corporate.business.update_get_access_user_profile_reply_ebe4x1.UpdateGetAccessUserProfileReply;
import chubb_corporate.business.update_get_access_user_profile_request_ebe4x1.UpdateGetAccessUserProfileRequest;
import chubb_corporate.business.update_get_access_user_profile_status_reply_ebe4x1.UpdateGetAccessUserProfileStatusReply;
import chubb_corporate.business.update_get_access_user_profile_status_request_ebe4x1.UpdateGetAccessUserProfileStatusRequest;

public class GetAccessUserProfileManagementEBE4X1HTTP_GetAccessUserProfileManagementEBE4X1HttpPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private chubb_corporate.business.get_access_user_profile_management_ebe4x1_http.GetAccessUserProfileManagementEBE4X1HttpService _service = null;
        private chubb_corporate.business.get_access_user_profile_management_ebe4x1_http.GetAccessUserProfileManagementEBE4X1 _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new chubb_corporate.business.get_access_user_profile_management_ebe4x1_http.GetAccessUserProfileManagementEBE4X1HttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            _service = new chubb_corporate.business.get_access_user_profile_management_ebe4x1_http.GetAccessUserProfileManagementEBE4X1HttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getGetAccessUserProfileManagementEBE4X1HTTPGetAccessUserProfileManagementEBE4X1HttpPort();
        }

        public chubb_corporate.business.get_access_user_profile_management_ebe4x1_http.GetAccessUserProfileManagementEBE4X1 getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://chubb_corporate/business/get_access_user_profile_management_ebe4x1_http", "GetAccessUserProfileManagementEBE4X1HTTP_GetAccessUserProfileManagementEBE4X1HttpPort");
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

    public GetAccessUserProfileManagementEBE4X1HTTP_GetAccessUserProfileManagementEBE4X1HttpPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public GetAccessUserProfileManagementEBE4X1HTTP_GetAccessUserProfileManagementEBE4X1HttpPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public AddGetAccessUserProfileReply addGetAccessUserProfile(AddGetAccessUserProfileRequest addGetAccessUserProfileRequest) throws AddGetAccessUserProfileSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().addGetAccessUserProfile(addGetAccessUserProfileRequest);
    }

    public UpdateGetAccessUserProfileReply updateGetAccessUserProfile(UpdateGetAccessUserProfileRequest updateGetAccessUserProfileRequest) throws UpdateGetAccessUserProfileSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().updateGetAccessUserProfile(updateGetAccessUserProfileRequest);
    }

    public UpdateGetAccessUserProfileStatusReply updateGetAccessUserProfileStatus(UpdateGetAccessUserProfileStatusRequest updateGetAccessUserProfileStatusRequest) throws UpdateGetAccessUserProfileStatusSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().updateGetAccessUserProfileStatus(updateGetAccessUserProfileStatusRequest);
    }

    public GetAccessUserProfileListReply getAccessUserProfileList(GetAccessUserProfileListRequest getAccessUserProfileListRequest) throws GetAccessUserProfileListSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getAccessUserProfileList(getAccessUserProfileListRequest);
    }

    public GetAccessUserProfileReply getAccessUserProfile(GetAccessUserProfileRequest getAccessUserProfileRequest) throws GetAccessUserProfileSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getAccessUserProfile(getAccessUserProfileRequest);
    }

    public ResetGetAccessUserPasswordReply resetGetAccessUserPassword(ResetGetAccessUserPasswordRequest resetGetAccessUserPasswordRequest) throws ResetGetAccessUserPasswordSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().resetGetAccessUserPassword(resetGetAccessUserPasswordRequest);
    }

    public ChangeGetAccessUserPasswordReply changeGetAccessUserPassword(ChangeGetAccessUserPasswordRequest changeGetAccessUserPasswordRequest) throws ChangeGetAccessUserPasswordSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().changeGetAccessUserPassword(changeGetAccessUserPasswordRequest);
    }

}