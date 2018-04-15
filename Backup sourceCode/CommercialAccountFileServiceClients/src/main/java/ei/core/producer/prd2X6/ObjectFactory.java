
package ei.core.producer.prd2X6;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.test.prd2X6 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetFilteredProducerListInputs_QNAME = new QName("http://ei/producer/get_filtered_producer_list_inputs_prd2x6", "GetFilteredProducerListInputs");
    private final static QName _BusinessPartyCharacteristic_QNAME = new QName("http://ei/core/business_party_characteristic", "BusinessPartyCharacteristic");
    private final static QName _Address_QNAME = new QName("http://ei/core/addressx5", "Address");
    private final static QName _GetProducerListOutputs_QNAME = new QName("http://ei/producer/get_producer_list_outputs_prd2x6", "GetProducerListOutputs");
    private final static QName _GetProducerWithCommissionRatesRequest_QNAME = new QName("http://ei/producer/get_producer_with_commission_rates_request_prd2x6", "GetProducerWithCommissionRatesRequest");
    private final static QName _CommissionInputParameter_QNAME = new QName("http://ei/producer/commission_input_parameter", "CommissionInputParameter");
    private final static QName _ProducerContact_QNAME = new QName("http://ei/producer/producer_contact", "ProducerContact");
    private final static QName _GetProducerWithCommissionRatesInputs_QNAME = new QName("http://ei/producer/get_producer_with_commission_rates_inputs_prd2x6", "GetProducerWithCommissionRatesInputs");
    private final static QName _ProducerIdentifier_QNAME = new QName("http://ei/core/producer_identifierx4", "ProducerIdentifier");
    private final static QName _GetFilteredProducerListReply_QNAME = new QName("http://ei/producer/get_filtered_producer_list_reply_prd2x6", "GetFilteredProducerListReply");
    private final static QName _StatusInformation_QNAME = new QName("http://ei/core/status_informationx1", "StatusInformation");
    private final static QName _ExtendedProducer_QNAME = new QName("http://ei/producer/extended_producerx4", "ExtendedProducer");
    private final static QName _ProducerCommissionRate_QNAME = new QName("http://ei/core/producer_commission_rate", "ProducerCommissionRate");
    private final static QName _Producer_QNAME = new QName("http://ei/producer/producerx7", "Producer");
    private final static QName _GetProducerListRequest_QNAME = new QName("http://ei/producer/get_producer_list_request_prd2x6", "GetProducerListRequest");
    private final static QName _SimpleFaultReply_QNAME = new QName("http://ei/producer/producer_retrieval_prd2x6", "SimpleFaultReply");
    private final static QName _GetProducerListReply_QNAME = new QName("http://ei/producer/get_producer_list_reply_prd2x6", "GetProducerListReply");
    private final static QName _ProducerGroup_QNAME = new QName("http://ei/producer/producer_group", "ProducerGroup");
    private final static QName _GetProducerRequest_QNAME = new QName("http://ei/producer/get_producer_request_prd2x6", "GetProducerRequest");
    private final static QName _ProducerEnrollmentOptions_QNAME = new QName("http://ei/producer/producer_enrollment_options", "ProducerEnrollmentOptions");
    private final static QName _GetProducerListInputs_QNAME = new QName("http://ei/producer/get_producer_list_inputs_prd2x6", "GetProducerListInputs");
    private final static QName _GetProducerReply_QNAME = new QName("http://ei/producer/get_producer_reply_prd2x6", "GetProducerReply");
    private final static QName _GetProducerWithCommissionRatesReply_QNAME = new QName("http://ei/producer/get_producer_with_commission_rates_reply_prd2x6", "GetProducerWithCommissionRatesReply");
    private final static QName _NonResidentProducerLicenseInformation_QNAME = new QName("http://ei/producer/non_resident_producer_license_information", "NonResidentProducerLicenseInformation");
    private final static QName _SimpleFault_QNAME = new QName("http://ei/core/simplefault", "SimpleFault");
    private final static QName _GetFilteredProducerListOutputs_QNAME = new QName("http://ei/producer/get_filtered_producer_list_outputs_prd2x6", "GetFilteredProducerListOutputs");
    private final static QName _GetFilteredProducerListRequest_QNAME = new QName("http://ei/producer/get_filtered_producer_list_request_prd2x6", "GetFilteredProducerListRequest");
    private final static QName _CommissionRatesByPolicyCategory_QNAME = new QName("http://ei/core/commission_rates_by_policy_category", "CommissionRatesByPolicyCategory");
    private final static QName _PolicyTypeIdentifier_QNAME = new QName("http://ei/core/policy_type_identifierx1", "PolicyTypeIdentifier");
    private final static QName _ProducerGroupFilter_QNAME = new QName("http://ei/producer/producer_group_filter", "ProducerGroupFilter");
    private final static QName _Error_QNAME = new QName("http://ei/core/error", "Error");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.test.prd2X6
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SimpleFault }
     * 
     */
    public SimpleFault createSimpleFault() {
        return new SimpleFault();
    }

    /**
     * Create an instance of {@link GetFilteredProducerList2X6Response }
     * 
     */
    public GetFilteredProducerList2X6Response createGetFilteredProducerList2X6Response() {
        return new GetFilteredProducerList2X6Response();
    }

    /**
     * Create an instance of {@link GetFilteredProducerListReply }
     * 
     */
    public GetFilteredProducerListReply createGetFilteredProducerListReply() {
        return new GetFilteredProducerListReply();
    }

    /**
     * Create an instance of {@link GetProducerList2X6 }
     * 
     */
    public GetProducerList2X6 createGetProducerList2X6() {
        return new GetProducerList2X6();
    }

    /**
     * Create an instance of {@link GetProducerListRequest }
     * 
     */
    public GetProducerListRequest createGetProducerListRequest() {
        return new GetProducerListRequest();
    }

    /**
     * Create an instance of {@link GetProducer2X6 }
     * 
     */
    public GetProducer2X6 createGetProducer2X6() {
        return new GetProducer2X6();
    }

    /**
     * Create an instance of {@link GetProducerRequest }
     * 
     */
    public GetProducerRequest createGetProducerRequest() {
        return new GetProducerRequest();
    }

    /**
     * Create an instance of {@link GetProducerList2X6Response }
     * 
     */
    public GetProducerList2X6Response createGetProducerList2X6Response() {
        return new GetProducerList2X6Response();
    }

    /**
     * Create an instance of {@link GetProducerListReply }
     * 
     */
    public GetProducerListReply createGetProducerListReply() {
        return new GetProducerListReply();
    }

    /**
     * Create an instance of {@link GetProducer2X6Response }
     * 
     */
    public GetProducer2X6Response createGetProducer2X6Response() {
        return new GetProducer2X6Response();
    }

    /**
     * Create an instance of {@link GetProducerReply }
     * 
     */
    public GetProducerReply createGetProducerReply() {
        return new GetProducerReply();
    }

    /**
     * Create an instance of {@link GetProducerWithCommissionRates2X6Response }
     * 
     */
    public GetProducerWithCommissionRates2X6Response createGetProducerWithCommissionRates2X6Response() {
        return new GetProducerWithCommissionRates2X6Response();
    }

    /**
     * Create an instance of {@link GetProducerWithCommissionRatesReply }
     * 
     */
    public GetProducerWithCommissionRatesReply createGetProducerWithCommissionRatesReply() {
        return new GetProducerWithCommissionRatesReply();
    }

    /**
     * Create an instance of {@link GetFilteredProducerList2X6 }
     * 
     */
    public GetFilteredProducerList2X6 createGetFilteredProducerList2X6() {
        return new GetFilteredProducerList2X6();
    }

    /**
     * Create an instance of {@link GetFilteredProducerListRequest }
     * 
     */
    public GetFilteredProducerListRequest createGetFilteredProducerListRequest() {
        return new GetFilteredProducerListRequest();
    }

    /**
     * Create an instance of {@link GetProducerWithCommissionRates2X6 }
     * 
     */
    public GetProducerWithCommissionRates2X6 createGetProducerWithCommissionRates2X6() {
        return new GetProducerWithCommissionRates2X6();
    }

    /**
     * Create an instance of {@link GetProducerWithCommissionRatesRequest }
     * 
     */
    public GetProducerWithCommissionRatesRequest createGetProducerWithCommissionRatesRequest() {
        return new GetProducerWithCommissionRatesRequest();
    }

    /**
     * Create an instance of {@link GetFilteredProducerListOutputs }
     * 
     */
    public GetFilteredProducerListOutputs createGetFilteredProducerListOutputs() {
        return new GetFilteredProducerListOutputs();
    }

    /**
     * Create an instance of {@link ProducerIdentifier }
     * 
     */
    public ProducerIdentifier createProducerIdentifier() {
        return new ProducerIdentifier();
    }

    /**
     * Create an instance of {@link ExtendedProducer }
     * 
     */
    public ExtendedProducer createExtendedProducer() {
        return new ExtendedProducer();
    }

    /**
     * Create an instance of {@link Producer }
     * 
     */
    public Producer createProducer() {
        return new Producer();
    }

    /**
     * Create an instance of {@link NonResidentProducerLicenseInformation }
     * 
     */
    public NonResidentProducerLicenseInformation createNonResidentProducerLicenseInformation() {
        return new NonResidentProducerLicenseInformation();
    }

    /**
     * Create an instance of {@link BusinessPartyCharacteristic }
     * 
     */
    public BusinessPartyCharacteristic createBusinessPartyCharacteristic() {
        return new BusinessPartyCharacteristic();
    }

    /**
     * Create an instance of {@link ProducerGroup }
     * 
     */
    public ProducerGroup createProducerGroup() {
        return new ProducerGroup();
    }

    /**
     * Create an instance of {@link CommissionRatesByPolicyCategory }
     * 
     */
    public CommissionRatesByPolicyCategory createCommissionRatesByPolicyCategory() {
        return new CommissionRatesByPolicyCategory();
    }

    /**
     * Create an instance of {@link ProducerCommissionRate }
     * 
     */
    public ProducerCommissionRate createProducerCommissionRate() {
        return new ProducerCommissionRate();
    }

    /**
     * Create an instance of {@link ProducerContact }
     * 
     */
    public ProducerContact createProducerContact() {
        return new ProducerContact();
    }

    /**
     * Create an instance of {@link ProducerEnrollmentOptions }
     * 
     */
    public ProducerEnrollmentOptions createProducerEnrollmentOptions() {
        return new ProducerEnrollmentOptions();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link StatusInformation }
     * 
     */
    public StatusInformation createStatusInformation() {
        return new StatusInformation();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link ProducerGroupFilter }
     * 
     */
    public ProducerGroupFilter createProducerGroupFilter() {
        return new ProducerGroupFilter();
    }

    /**
     * Create an instance of {@link GetFilteredProducerListInputs }
     * 
     */
    public GetFilteredProducerListInputs createGetFilteredProducerListInputs() {
        return new GetFilteredProducerListInputs();
    }

    /**
     * Create an instance of {@link PolicyTypeIdentifier }
     * 
     */
    public PolicyTypeIdentifier createPolicyTypeIdentifier() {
        return new PolicyTypeIdentifier();
    }

    /**
     * Create an instance of {@link GetProducerListOutputs }
     * 
     */
    public GetProducerListOutputs createGetProducerListOutputs() {
        return new GetProducerListOutputs();
    }

    /**
     * Create an instance of {@link GetProducerListInputs }
     * 
     */
    public GetProducerListInputs createGetProducerListInputs() {
        return new GetProducerListInputs();
    }

    /**
     * Create an instance of {@link CommissionInputParameter }
     * 
     */
    public CommissionInputParameter createCommissionInputParameter() {
        return new CommissionInputParameter();
    }

    /**
     * Create an instance of {@link GetProducerWithCommissionRatesInputs }
     * 
     */
    public GetProducerWithCommissionRatesInputs createGetProducerWithCommissionRatesInputs() {
        return new GetProducerWithCommissionRatesInputs();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilteredProducerListInputs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_filtered_producer_list_inputs_prd2x6", name = "GetFilteredProducerListInputs")
    public JAXBElement<GetFilteredProducerListInputs> createGetFilteredProducerListInputs(GetFilteredProducerListInputs value) {
        return new JAXBElement<GetFilteredProducerListInputs>(_GetFilteredProducerListInputs_QNAME, GetFilteredProducerListInputs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessPartyCharacteristic }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/business_party_characteristic", name = "BusinessPartyCharacteristic")
    public JAXBElement<BusinessPartyCharacteristic> createBusinessPartyCharacteristic(BusinessPartyCharacteristic value) {
        return new JAXBElement<BusinessPartyCharacteristic>(_BusinessPartyCharacteristic_QNAME, BusinessPartyCharacteristic.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/addressx5", name = "Address")
    public JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<Address>(_Address_QNAME, Address.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducerListOutputs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_producer_list_outputs_prd2x6", name = "GetProducerListOutputs")
    public JAXBElement<GetProducerListOutputs> createGetProducerListOutputs(GetProducerListOutputs value) {
        return new JAXBElement<GetProducerListOutputs>(_GetProducerListOutputs_QNAME, GetProducerListOutputs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducerWithCommissionRatesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_producer_with_commission_rates_request_prd2x6", name = "GetProducerWithCommissionRatesRequest")
    public JAXBElement<GetProducerWithCommissionRatesRequest> createGetProducerWithCommissionRatesRequest(GetProducerWithCommissionRatesRequest value) {
        return new JAXBElement<GetProducerWithCommissionRatesRequest>(_GetProducerWithCommissionRatesRequest_QNAME, GetProducerWithCommissionRatesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommissionInputParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/commission_input_parameter", name = "CommissionInputParameter")
    public JAXBElement<CommissionInputParameter> createCommissionInputParameter(CommissionInputParameter value) {
        return new JAXBElement<CommissionInputParameter>(_CommissionInputParameter_QNAME, CommissionInputParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProducerContact }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/producer_contact", name = "ProducerContact")
    public JAXBElement<ProducerContact> createProducerContact(ProducerContact value) {
        return new JAXBElement<ProducerContact>(_ProducerContact_QNAME, ProducerContact.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducerWithCommissionRatesInputs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_producer_with_commission_rates_inputs_prd2x6", name = "GetProducerWithCommissionRatesInputs")
    public JAXBElement<GetProducerWithCommissionRatesInputs> createGetProducerWithCommissionRatesInputs(GetProducerWithCommissionRatesInputs value) {
        return new JAXBElement<GetProducerWithCommissionRatesInputs>(_GetProducerWithCommissionRatesInputs_QNAME, GetProducerWithCommissionRatesInputs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProducerIdentifier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/producer_identifierx4", name = "ProducerIdentifier")
    public JAXBElement<ProducerIdentifier> createProducerIdentifier(ProducerIdentifier value) {
        return new JAXBElement<ProducerIdentifier>(_ProducerIdentifier_QNAME, ProducerIdentifier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilteredProducerListReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_filtered_producer_list_reply_prd2x6", name = "GetFilteredProducerListReply")
    public JAXBElement<GetFilteredProducerListReply> createGetFilteredProducerListReply(GetFilteredProducerListReply value) {
        return new JAXBElement<GetFilteredProducerListReply>(_GetFilteredProducerListReply_QNAME, GetFilteredProducerListReply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/status_informationx1", name = "StatusInformation")
    public JAXBElement<StatusInformation> createStatusInformation(StatusInformation value) {
        return new JAXBElement<StatusInformation>(_StatusInformation_QNAME, StatusInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExtendedProducer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/extended_producerx4", name = "ExtendedProducer")
    public JAXBElement<ExtendedProducer> createExtendedProducer(ExtendedProducer value) {
        return new JAXBElement<ExtendedProducer>(_ExtendedProducer_QNAME, ExtendedProducer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProducerCommissionRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/producer_commission_rate", name = "ProducerCommissionRate")
    public JAXBElement<ProducerCommissionRate> createProducerCommissionRate(ProducerCommissionRate value) {
        return new JAXBElement<ProducerCommissionRate>(_ProducerCommissionRate_QNAME, ProducerCommissionRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Producer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/producerx7", name = "Producer")
    public JAXBElement<Producer> createProducer(Producer value) {
        return new JAXBElement<Producer>(_Producer_QNAME, Producer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducerListRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_producer_list_request_prd2x6", name = "GetProducerListRequest")
    public JAXBElement<GetProducerListRequest> createGetProducerListRequest(GetProducerListRequest value) {
        return new JAXBElement<GetProducerListRequest>(_GetProducerListRequest_QNAME, GetProducerListRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/producer_retrieval_prd2x6", name = "SimpleFaultReply")
    public JAXBElement<SimpleFault> createSimpleFaultReply(SimpleFault value) {
        return new JAXBElement<SimpleFault>(_SimpleFaultReply_QNAME, SimpleFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducerListReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_producer_list_reply_prd2x6", name = "GetProducerListReply")
    public JAXBElement<GetProducerListReply> createGetProducerListReply(GetProducerListReply value) {
        return new JAXBElement<GetProducerListReply>(_GetProducerListReply_QNAME, GetProducerListReply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProducerGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/producer_group", name = "ProducerGroup")
    public JAXBElement<ProducerGroup> createProducerGroup(ProducerGroup value) {
        return new JAXBElement<ProducerGroup>(_ProducerGroup_QNAME, ProducerGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducerRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_producer_request_prd2x6", name = "GetProducerRequest")
    public JAXBElement<GetProducerRequest> createGetProducerRequest(GetProducerRequest value) {
        return new JAXBElement<GetProducerRequest>(_GetProducerRequest_QNAME, GetProducerRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProducerEnrollmentOptions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/producer_enrollment_options", name = "ProducerEnrollmentOptions")
    public JAXBElement<ProducerEnrollmentOptions> createProducerEnrollmentOptions(ProducerEnrollmentOptions value) {
        return new JAXBElement<ProducerEnrollmentOptions>(_ProducerEnrollmentOptions_QNAME, ProducerEnrollmentOptions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducerListInputs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_producer_list_inputs_prd2x6", name = "GetProducerListInputs")
    public JAXBElement<GetProducerListInputs> createGetProducerListInputs(GetProducerListInputs value) {
        return new JAXBElement<GetProducerListInputs>(_GetProducerListInputs_QNAME, GetProducerListInputs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducerReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_producer_reply_prd2x6", name = "GetProducerReply")
    public JAXBElement<GetProducerReply> createGetProducerReply(GetProducerReply value) {
        return new JAXBElement<GetProducerReply>(_GetProducerReply_QNAME, GetProducerReply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducerWithCommissionRatesReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_producer_with_commission_rates_reply_prd2x6", name = "GetProducerWithCommissionRatesReply")
    public JAXBElement<GetProducerWithCommissionRatesReply> createGetProducerWithCommissionRatesReply(GetProducerWithCommissionRatesReply value) {
        return new JAXBElement<GetProducerWithCommissionRatesReply>(_GetProducerWithCommissionRatesReply_QNAME, GetProducerWithCommissionRatesReply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NonResidentProducerLicenseInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/non_resident_producer_license_information", name = "NonResidentProducerLicenseInformation")
    public JAXBElement<NonResidentProducerLicenseInformation> createNonResidentProducerLicenseInformation(NonResidentProducerLicenseInformation value) {
        return new JAXBElement<NonResidentProducerLicenseInformation>(_NonResidentProducerLicenseInformation_QNAME, NonResidentProducerLicenseInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/simplefault", name = "SimpleFault")
    public JAXBElement<SimpleFault> createSimpleFault(SimpleFault value) {
        return new JAXBElement<SimpleFault>(_SimpleFault_QNAME, SimpleFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilteredProducerListOutputs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_filtered_producer_list_outputs_prd2x6", name = "GetFilteredProducerListOutputs")
    public JAXBElement<GetFilteredProducerListOutputs> createGetFilteredProducerListOutputs(GetFilteredProducerListOutputs value) {
        return new JAXBElement<GetFilteredProducerListOutputs>(_GetFilteredProducerListOutputs_QNAME, GetFilteredProducerListOutputs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilteredProducerListRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/get_filtered_producer_list_request_prd2x6", name = "GetFilteredProducerListRequest")
    public JAXBElement<GetFilteredProducerListRequest> createGetFilteredProducerListRequest(GetFilteredProducerListRequest value) {
        return new JAXBElement<GetFilteredProducerListRequest>(_GetFilteredProducerListRequest_QNAME, GetFilteredProducerListRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommissionRatesByPolicyCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/commission_rates_by_policy_category", name = "CommissionRatesByPolicyCategory")
    public JAXBElement<CommissionRatesByPolicyCategory> createCommissionRatesByPolicyCategory(CommissionRatesByPolicyCategory value) {
        return new JAXBElement<CommissionRatesByPolicyCategory>(_CommissionRatesByPolicyCategory_QNAME, CommissionRatesByPolicyCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolicyTypeIdentifier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/policy_type_identifierx1", name = "PolicyTypeIdentifier")
    public JAXBElement<PolicyTypeIdentifier> createPolicyTypeIdentifier(PolicyTypeIdentifier value) {
        return new JAXBElement<PolicyTypeIdentifier>(_PolicyTypeIdentifier_QNAME, PolicyTypeIdentifier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProducerGroupFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/producer/producer_group_filter", name = "ProducerGroupFilter")
    public JAXBElement<ProducerGroupFilter> createProducerGroupFilter(ProducerGroupFilter value) {
        return new JAXBElement<ProducerGroupFilter>(_ProducerGroupFilter_QNAME, ProducerGroupFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Error }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/error", name = "Error")
    public JAXBElement<Error> createError(Error value) {
        return new JAXBElement<Error>(_Error_QNAME, Error.class, null, value);
    }

}
