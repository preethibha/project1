package ei.product.product_retrieval_pdt1x1_http;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import ei.product.get_filtered_product_list_reply_pdt1x1.GetFilteredProductListReply;
import ei.product.get_filtered_product_list_request_pdt1x1.GetFilteredProductListRequest;
import ei.product.get_marketing_product_group_list_reply_pdt1x1.GetMarketingProductGroupListReply;
import ei.product.get_marketing_product_group_list_request_pdt1x1.GetMarketingProductGroupListRequest;
import ei.product.get_product_reply_pdt1x1.GetProductReply;
import ei.product.get_product_request_pdt1x1.GetProductRequest;

public class ProductRetrievalPDT1X1HTTP_ProductRetrievalPDT1X1HttpPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private ei.product.product_retrieval_pdt1x1_http.ProductRetrievalPDT1X1HttpService _service = null;
        private ei.product.product_retrieval_pdt1x1_http.ProductRetrievalPDT1X1 _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new ei.product.product_retrieval_pdt1x1_http.ProductRetrievalPDT1X1HttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            _service = new ei.product.product_retrieval_pdt1x1_http.ProductRetrievalPDT1X1HttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getProductRetrievalPDT1X1HTTPProductRetrievalPDT1X1HttpPort();
        }

        public ei.product.product_retrieval_pdt1x1_http.ProductRetrievalPDT1X1 getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://ei/product/product_retrieval_pdt1x1_http", "ProductRetrievalPDT1X1HTTP_ProductRetrievalPDT1X1HttpPort");
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

    public ProductRetrievalPDT1X1HTTP_ProductRetrievalPDT1X1HttpPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public ProductRetrievalPDT1X1HTTP_ProductRetrievalPDT1X1HttpPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public GetProductReply getProduct(GetProductRequest getProductRequest) throws GetProductSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getProduct(getProductRequest);
    }

    public GetFilteredProductListReply getFilteredProductList(GetFilteredProductListRequest getFilteredProductListRequest) throws GetFilteredProductListSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getFilteredProductList(getFilteredProductListRequest);
    }

    public GetMarketingProductGroupListReply getMarketingProductGroupList(GetMarketingProductGroupListRequest getMarketingProductGroupListRequest) throws GetMarketingProductGroupListSimpleFaultReplyMsg {
        return _getDescriptor().getProxy().getMarketingProductGroupList(getMarketingProductGroupListRequest);
    }

}