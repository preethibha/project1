package ei.corporate.branch_retrieval_crp2x1_http;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.datatype.XMLGregorianCalendar;
import ei.core.extendedbranch.ExtendedBranch;
import ei.corporate.get_branch_list_reply_crp2x1.GetBranchListReply;
import ei.corporate.get_branch_request_crp2x1.GetBranchRequest;
import ei.corporate.get_producing_branch_list_reply_crp2x1.GetProducingBranchListReply;
import ei.corporate.get_producing_branch_list_request_crp2x1.GetProducingBranchListRequest;
import ei.crp.get_local_language_branch_reply_crp2x1.GetLocalLanguageBranchReply;
import ei.crp.get_local_language_request_crp2x1.GetLocalLanguageBranchRequest;

public class BranchRetrievalCRP2X1HTTP_BranchRetrievalCRP2X1HttpPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private ei.corporate.branch_retrieval_crp2x1_http.BranchRetrievalCRP2X1HttpService _service = null;
        private ei.corporate.branch_retrieval_crp2x1_http.BranchRetrievalCRP2X1 _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new ei.corporate.branch_retrieval_crp2x1_http.BranchRetrievalCRP2X1HttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            _service = new ei.corporate.branch_retrieval_crp2x1_http.BranchRetrievalCRP2X1HttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getBranchRetrievalCRP2X1HTTPBranchRetrievalCRP2X1HttpPort();
        }

        public ei.corporate.branch_retrieval_crp2x1_http.BranchRetrievalCRP2X1 getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://ei/corporate/branch_retrieval_crp2X1_http", "BranchRetrievalCRP2X1HTTP_BranchRetrievalCRP2X1HttpPort");
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

    public BranchRetrievalCRP2X1HTTP_BranchRetrievalCRP2X1HttpPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public BranchRetrievalCRP2X1HTTP_BranchRetrievalCRP2X1HttpPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public ExtendedBranch getBranch(GetBranchRequest getBranchRequest) throws GetBranchSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getBranch(getBranchRequest);
    }

    public GetBranchListReply getBranchList(XMLGregorianCalendar asOfDate) throws GetBranchListSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getBranchList(asOfDate);
    }

    public GetLocalLanguageBranchReply getLocalLanguageBranch(GetLocalLanguageBranchRequest getLocalLanguageBranchRequest) throws GetLocalLanguageBranchSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getLocalLanguageBranch(getLocalLanguageBranchRequest);
    }

    public GetProducingBranchListReply getProducingBranchList(GetProducingBranchListRequest getProducingBranchListRequest) throws GetProducingBranchListSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getProducingBranchList(getProducingBranchListRequest);
    }

}