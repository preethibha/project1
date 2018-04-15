
package ei.user.profile;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.chubb.dgmk.caf.was.accessors package. 
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

    private final static QName _GetUserProfileReply_QNAME = new QName("http://ei/corporate/get_user_profile_reply_crp31x1", "GetUserProfileReply");
    private final static QName _SourceSystemUserProfileId_QNAME = new QName("http://ei/core/source_system_user_profile_id", "SourceSystemUserProfileId");
    private final static QName _RegionAndLanguageSettings_QNAME = new QName("http://ei/core/region_and_language_settings", "RegionAndLanguageSettings");
    private final static QName _UserProfileIdentifier_QNAME = new QName("http://ei/core/user_profile_identifier", "UserProfileIdentifier");
    private final static QName _SimpleFault_QNAME = new QName("http://ei/core/simplefault", "SimpleFault");
    private final static QName _Customization_QNAME = new QName("http://ei/core/customizationx1", "Customization");
    private final static QName _BusinessParty_QNAME = new QName("http://ei/core/business_partyx1", "BusinessParty");
    private final static QName _Address_QNAME = new QName("http://ei/core/addressx5", "Address");
    private final static QName _User_QNAME = new QName("http://ei/core/user", "User");
    private final static QName _IndividualName_QNAME = new QName("http://ei/core/individual_name", "IndividualName");
    private final static QName _BusinessPartyCharacteristic_QNAME = new QName("http://ei/core/business_party_characteristic", "BusinessPartyCharacteristic");
    private final static QName _UserProfile_QNAME = new QName("http://ei/core/user_profile", "UserProfile");
    private final static QName _AccessControlGroup_QNAME = new QName("http://ei/core/access_control_group", "AccessControlGroup");
    private final static QName _GetUserProfileRequest_QNAME = new QName("http://ei/corporate/get_user_profile_request_crp31x1", "GetUserProfileRequest");
    private final static QName _GetUserProfileListRequest_QNAME = new QName("http://ei/corporate/get_user_profile_list_request_crp31x1", "GetUserProfileListRequest");
    private final static QName _ApplicationUserProfile_QNAME = new QName("http://ei/core/application_user_profile", "ApplicationUserProfile");
    private final static QName _GetUserProfileListReply_QNAME = new QName("http://ei/corporate/get_user_profile_list_reply_crp31x1", "GetUserProfileListReply");
    private final static QName _TypedAddress_QNAME = new QName("http://ei/core/typed_addressx3", "TypedAddress");
    private final static QName _Language_QNAME = new QName("http://ei/core/languagex1", "Language");
    private final static QName _TelecommElectronicAddress_QNAME = new QName("http://ei/core/telecomm_electronic_address", "TelecommElectronicAddress");
    private final static QName _ApplicationUserProfileProperty_QNAME = new QName("http://ei/core/application_user_profile_property", "ApplicationUserProfileProperty");
    private final static QName _ErrorInformation_QNAME = new QName("http://ei/core/error_information", "ErrorInformation");
    private final static QName _StatusInformation_QNAME = new QName("http://ei/core/status_informationx2", "StatusInformation");
    private final static QName _GetUserProfileListOutputs_QNAME = new QName("http://ei/corporate/get_user_profile_list_outputs_crp31x1", "GetUserProfileListOutputs");
    private final static QName _GetUserProfileListByEmailRequest_QNAME = new QName("http://ei/corporate/get_user_profile_list_by_email_request_crp31x1", "GetUserProfileListByEmailRequest");
    private final static QName _AccessAttribute_QNAME = new QName("http://ei/core/access_attribute", "AccessAttribute");
    private final static QName _IndividualIdentifier_QNAME = new QName("http://ei/core/individual_identifierx1", "IndividualIdentifier");
    private final static QName _SimpleFaultReply_QNAME = new QName("http://ei/corporate/user_profile_retrieval_crp31x1", "SimpleFaultReply");
    private final static QName _GetUserProfileListByEmailReply_QNAME = new QName("http://ei/corporate/get_user_profile_list_by_email_reply_crp31x1", "GetUserProfileListByEmailReply");
    private final static QName _UserAuthorization_QNAME = new QName("http://ei/core/user_authorization", "UserAuthorization");
    private final static QName _StandardizedAddress_QNAME = new QName("http://ei/core/standardized_addressx5", "StandardizedAddress");
    private final static QName _TimeZone_QNAME = new QName("http://ei/core/time_zone", "TimeZone");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.chubb.dgmk.caf.was.accessors
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ApplicationUserProfile }
     * 
     */
    public ApplicationUserProfile createApplicationUserProfile() {
        return new ApplicationUserProfile();
    }

    /**
     * Create an instance of {@link SimpleFault }
     * 
     */
    public SimpleFault createSimpleFault() {
        return new SimpleFault();
    }

    /**
     * Create an instance of {@link GetUserProfileListResponse }
     * 
     */
    public GetUserProfileListResponse createGetUserProfileListResponse() {
        return new GetUserProfileListResponse();
    }

    /**
     * Create an instance of {@link GetUserProfileListReply }
     * 
     */
    public GetUserProfileListReply createGetUserProfileListReply() {
        return new GetUserProfileListReply();
    }

    /**
     * Create an instance of {@link GetUserProfileListByEmail }
     * 
     */
    public GetUserProfileListByEmail createGetUserProfileListByEmail() {
        return new GetUserProfileListByEmail();
    }

    /**
     * Create an instance of {@link GetUserProfileListByEmailRequest }
     * 
     */
    public GetUserProfileListByEmailRequest createGetUserProfileListByEmailRequest() {
        return new GetUserProfileListByEmailRequest();
    }

    /**
     * Create an instance of {@link GetUserProfile }
     * 
     */
    public GetUserProfile createGetUserProfile() {
        return new GetUserProfile();
    }

    /**
     * Create an instance of {@link GetUserProfileRequest }
     * 
     */
    public GetUserProfileRequest createGetUserProfileRequest() {
        return new GetUserProfileRequest();
    }

    /**
     * Create an instance of {@link GetUserProfileResponse }
     * 
     */
    public GetUserProfileResponse createGetUserProfileResponse() {
        return new GetUserProfileResponse();
    }

    /**
     * Create an instance of {@link GetUserProfileReply }
     * 
     */
    public GetUserProfileReply createGetUserProfileReply() {
        return new GetUserProfileReply();
    }

    /**
     * Create an instance of {@link GetUserProfileListByEmailResponse }
     * 
     */
    public GetUserProfileListByEmailResponse createGetUserProfileListByEmailResponse() {
        return new GetUserProfileListByEmailResponse();
    }

    /**
     * Create an instance of {@link GetUserProfileListByEmailReply }
     * 
     */
    public GetUserProfileListByEmailReply createGetUserProfileListByEmailReply() {
        return new GetUserProfileListByEmailReply();
    }

    /**
     * Create an instance of {@link GetUserProfileList }
     * 
     */
    public GetUserProfileList createGetUserProfileList() {
        return new GetUserProfileList();
    }

    /**
     * Create an instance of {@link GetUserProfileListRequest }
     * 
     */
    public GetUserProfileListRequest createGetUserProfileListRequest() {
        return new GetUserProfileListRequest();
    }

    /**
     * Create an instance of {@link UserProfileIdentifier }
     * 
     */
    public UserProfileIdentifier createUserProfileIdentifier() {
        return new UserProfileIdentifier();
    }

    /**
     * Create an instance of {@link SourceSystemUserProfileId }
     * 
     */
    public SourceSystemUserProfileId createSourceSystemUserProfileId() {
        return new SourceSystemUserProfileId();
    }

    /**
     * Create an instance of {@link UserProfile }
     * 
     */
    public UserProfile createUserProfile() {
        return new UserProfile();
    }

    /**
     * Create an instance of {@link Customization }
     * 
     */
    public Customization createCustomization() {
        return new Customization();
    }

    /**
     * Create an instance of {@link RegionAndLanguageSettings }
     * 
     */
    public RegionAndLanguageSettings createRegionAndLanguageSettings() {
        return new RegionAndLanguageSettings();
    }

    /**
     * Create an instance of {@link TimeZone }
     * 
     */
    public TimeZone createTimeZone() {
        return new TimeZone();
    }

    /**
     * Create an instance of {@link Language }
     * 
     */
    public Language createLanguage() {
        return new Language();
    }

    /**
     * Create an instance of {@link UserAuthorization }
     * 
     */
    public UserAuthorization createUserAuthorization() {
        return new UserAuthorization();
    }

    /**
     * Create an instance of {@link AccessAttribute }
     * 
     */
    public AccessAttribute createAccessAttribute() {
        return new AccessAttribute();
    }

    /**
     * Create an instance of {@link AccessControlGroup }
     * 
     */
    public AccessControlGroup createAccessControlGroup() {
        return new AccessControlGroup();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link BusinessParty }
     * 
     */
    public BusinessParty createBusinessParty() {
        return new BusinessParty();
    }

    /**
     * Create an instance of {@link TypedAddress }
     * 
     */
    public TypedAddress createTypedAddress() {
        return new TypedAddress();
    }

    /**
     * Create an instance of {@link StandardizedAddress }
     * 
     */
    public StandardizedAddress createStandardizedAddress() {
        return new StandardizedAddress();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link BusinessPartyCharacteristic }
     * 
     */
    public BusinessPartyCharacteristic createBusinessPartyCharacteristic() {
        return new BusinessPartyCharacteristic();
    }

    /**
     * Create an instance of {@link TelecommElectronicAddress }
     * 
     */
    public TelecommElectronicAddress createTelecommElectronicAddress() {
        return new TelecommElectronicAddress();
    }

    /**
     * Create an instance of {@link IndividualName }
     * 
     */
    public IndividualName createIndividualName() {
        return new IndividualName();
    }

    /**
     * Create an instance of {@link IndividualIdentifier }
     * 
     */
    public IndividualIdentifier createIndividualIdentifier() {
        return new IndividualIdentifier();
    }

    /**
     * Create an instance of {@link ApplicationUserProfileProperty }
     * 
     */
    public ApplicationUserProfileProperty createApplicationUserProfileProperty() {
        return new ApplicationUserProfileProperty();
    }

    /**
     * Create an instance of {@link StatusInformation }
     * 
     */
    public StatusInformation createStatusInformation() {
        return new StatusInformation();
    }

    /**
     * Create an instance of {@link ErrorInformation }
     * 
     */
    public ErrorInformation createErrorInformation() {
        return new ErrorInformation();
    }

    /**
     * Create an instance of {@link GetUserProfileListOutputs }
     * 
     */
    public GetUserProfileListOutputs createGetUserProfileListOutputs() {
        return new GetUserProfileListOutputs();
    }

    /**
     * Create an instance of {@link ApplicationUserProfile.ApplicationUserProfileData }
     * 
     */
    public ApplicationUserProfile.ApplicationUserProfileData createApplicationUserProfileApplicationUserProfileData() {
        return new ApplicationUserProfile.ApplicationUserProfileData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserProfileReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/corporate/get_user_profile_reply_crp31x1", name = "GetUserProfileReply")
    public JAXBElement<GetUserProfileReply> createGetUserProfileReply(GetUserProfileReply value) {
        return new JAXBElement<GetUserProfileReply>(_GetUserProfileReply_QNAME, GetUserProfileReply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SourceSystemUserProfileId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/source_system_user_profile_id", name = "SourceSystemUserProfileId")
    public JAXBElement<SourceSystemUserProfileId> createSourceSystemUserProfileId(SourceSystemUserProfileId value) {
        return new JAXBElement<SourceSystemUserProfileId>(_SourceSystemUserProfileId_QNAME, SourceSystemUserProfileId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegionAndLanguageSettings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/region_and_language_settings", name = "RegionAndLanguageSettings")
    public JAXBElement<RegionAndLanguageSettings> createRegionAndLanguageSettings(RegionAndLanguageSettings value) {
        return new JAXBElement<RegionAndLanguageSettings>(_RegionAndLanguageSettings_QNAME, RegionAndLanguageSettings.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserProfileIdentifier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/user_profile_identifier", name = "UserProfileIdentifier")
    public JAXBElement<UserProfileIdentifier> createUserProfileIdentifier(UserProfileIdentifier value) {
        return new JAXBElement<UserProfileIdentifier>(_UserProfileIdentifier_QNAME, UserProfileIdentifier.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Customization }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/customizationx1", name = "Customization")
    public JAXBElement<Customization> createCustomization(Customization value) {
        return new JAXBElement<Customization>(_Customization_QNAME, Customization.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessParty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/business_partyx1", name = "BusinessParty")
    public JAXBElement<BusinessParty> createBusinessParty(BusinessParty value) {
        return new JAXBElement<BusinessParty>(_BusinessParty_QNAME, BusinessParty.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/user", name = "User")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndividualName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/individual_name", name = "IndividualName")
    public JAXBElement<IndividualName> createIndividualName(IndividualName value) {
        return new JAXBElement<IndividualName>(_IndividualName_QNAME, IndividualName.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UserProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/user_profile", name = "UserProfile")
    public JAXBElement<UserProfile> createUserProfile(UserProfile value) {
        return new JAXBElement<UserProfile>(_UserProfile_QNAME, UserProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccessControlGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/access_control_group", name = "AccessControlGroup")
    public JAXBElement<AccessControlGroup> createAccessControlGroup(AccessControlGroup value) {
        return new JAXBElement<AccessControlGroup>(_AccessControlGroup_QNAME, AccessControlGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserProfileRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/corporate/get_user_profile_request_crp31x1", name = "GetUserProfileRequest")
    public JAXBElement<GetUserProfileRequest> createGetUserProfileRequest(GetUserProfileRequest value) {
        return new JAXBElement<GetUserProfileRequest>(_GetUserProfileRequest_QNAME, GetUserProfileRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserProfileListRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/corporate/get_user_profile_list_request_crp31x1", name = "GetUserProfileListRequest")
    public JAXBElement<GetUserProfileListRequest> createGetUserProfileListRequest(GetUserProfileListRequest value) {
        return new JAXBElement<GetUserProfileListRequest>(_GetUserProfileListRequest_QNAME, GetUserProfileListRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplicationUserProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/application_user_profile", name = "ApplicationUserProfile")
    public JAXBElement<ApplicationUserProfile> createApplicationUserProfile(ApplicationUserProfile value) {
        return new JAXBElement<ApplicationUserProfile>(_ApplicationUserProfile_QNAME, ApplicationUserProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserProfileListReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/corporate/get_user_profile_list_reply_crp31x1", name = "GetUserProfileListReply")
    public JAXBElement<GetUserProfileListReply> createGetUserProfileListReply(GetUserProfileListReply value) {
        return new JAXBElement<GetUserProfileListReply>(_GetUserProfileListReply_QNAME, GetUserProfileListReply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TypedAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/typed_addressx3", name = "TypedAddress")
    public JAXBElement<TypedAddress> createTypedAddress(TypedAddress value) {
        return new JAXBElement<TypedAddress>(_TypedAddress_QNAME, TypedAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Language }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/languagex1", name = "Language")
    public JAXBElement<Language> createLanguage(Language value) {
        return new JAXBElement<Language>(_Language_QNAME, Language.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TelecommElectronicAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/telecomm_electronic_address", name = "TelecommElectronicAddress")
    public JAXBElement<TelecommElectronicAddress> createTelecommElectronicAddress(TelecommElectronicAddress value) {
        return new JAXBElement<TelecommElectronicAddress>(_TelecommElectronicAddress_QNAME, TelecommElectronicAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplicationUserProfileProperty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/application_user_profile_property", name = "ApplicationUserProfileProperty")
    public JAXBElement<ApplicationUserProfileProperty> createApplicationUserProfileProperty(ApplicationUserProfileProperty value) {
        return new JAXBElement<ApplicationUserProfileProperty>(_ApplicationUserProfileProperty_QNAME, ApplicationUserProfileProperty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/error_information", name = "ErrorInformation")
    public JAXBElement<ErrorInformation> createErrorInformation(ErrorInformation value) {
        return new JAXBElement<ErrorInformation>(_ErrorInformation_QNAME, ErrorInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/status_informationx2", name = "StatusInformation")
    public JAXBElement<StatusInformation> createStatusInformation(StatusInformation value) {
        return new JAXBElement<StatusInformation>(_StatusInformation_QNAME, StatusInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserProfileListOutputs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/corporate/get_user_profile_list_outputs_crp31x1", name = "GetUserProfileListOutputs")
    public JAXBElement<GetUserProfileListOutputs> createGetUserProfileListOutputs(GetUserProfileListOutputs value) {
        return new JAXBElement<GetUserProfileListOutputs>(_GetUserProfileListOutputs_QNAME, GetUserProfileListOutputs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserProfileListByEmailRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/corporate/get_user_profile_list_by_email_request_crp31x1", name = "GetUserProfileListByEmailRequest")
    public JAXBElement<GetUserProfileListByEmailRequest> createGetUserProfileListByEmailRequest(GetUserProfileListByEmailRequest value) {
        return new JAXBElement<GetUserProfileListByEmailRequest>(_GetUserProfileListByEmailRequest_QNAME, GetUserProfileListByEmailRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccessAttribute }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/access_attribute", name = "AccessAttribute")
    public JAXBElement<AccessAttribute> createAccessAttribute(AccessAttribute value) {
        return new JAXBElement<AccessAttribute>(_AccessAttribute_QNAME, AccessAttribute.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndividualIdentifier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/individual_identifierx1", name = "IndividualIdentifier")
    public JAXBElement<IndividualIdentifier> createIndividualIdentifier(IndividualIdentifier value) {
        return new JAXBElement<IndividualIdentifier>(_IndividualIdentifier_QNAME, IndividualIdentifier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/corporate/user_profile_retrieval_crp31x1", name = "SimpleFaultReply")
    public JAXBElement<SimpleFault> createSimpleFaultReply(SimpleFault value) {
        return new JAXBElement<SimpleFault>(_SimpleFaultReply_QNAME, SimpleFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserProfileListByEmailReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/corporate/get_user_profile_list_by_email_reply_crp31x1", name = "GetUserProfileListByEmailReply")
    public JAXBElement<GetUserProfileListByEmailReply> createGetUserProfileListByEmailReply(GetUserProfileListByEmailReply value) {
        return new JAXBElement<GetUserProfileListByEmailReply>(_GetUserProfileListByEmailReply_QNAME, GetUserProfileListByEmailReply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAuthorization }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/user_authorization", name = "UserAuthorization")
    public JAXBElement<UserAuthorization> createUserAuthorization(UserAuthorization value) {
        return new JAXBElement<UserAuthorization>(_UserAuthorization_QNAME, UserAuthorization.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StandardizedAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/standardized_addressx5", name = "StandardizedAddress")
    public JAXBElement<StandardizedAddress> createStandardizedAddress(StandardizedAddress value) {
        return new JAXBElement<StandardizedAddress>(_StandardizedAddress_QNAME, StandardizedAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeZone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/core/time_zone", name = "TimeZone")
    public JAXBElement<TimeZone> createTimeZone(TimeZone value) {
        return new JAXBElement<TimeZone>(_TimeZone_QNAME, TimeZone.class, null, value);
    }

}
