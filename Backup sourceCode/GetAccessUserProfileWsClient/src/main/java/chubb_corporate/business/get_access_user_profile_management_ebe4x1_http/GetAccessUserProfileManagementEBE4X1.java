//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package chubb_corporate.business.get_access_user_profile_management_ebe4x1_http;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import chubb_corporate.business.add_get_access_user_profile_reply_ebe4x1.AddGetAccessUserProfileReply;
import chubb_corporate.business.add_get_access_user_profile_request_ebe4x1.AddGetAccessUserProfileRequest;
import chubb_corporate.business.change_get_access_user_password_reply_ebe4x1.ChangeGetAccessUserPasswordReply;
import chubb_corporate.business.change_get_access_user_password_request_ebe4x1.ChangeGetAccessUserPasswordRequest;
import chubb_corporate.business.change_get_access_user_profile_identifier_reply_ebe4x1.ChangeGetAccessUserProfileIdentifierReply;
import chubb_corporate.business.change_get_access_user_profile_identifier_request_ebe4x1.ChangeGetAccessUserProfileIdentifierRequest;
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

@WebService(name = "GetAccessUserProfileManagementEBE4X1", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1")
@XmlSeeAlso({
    chubb_corporate.business.get_access_user_profile_management_ebe4x1.ObjectFactory.class,
    chubb_corporate.get_access.business_party.ObjectFactory.class,
    chubb_corporate.get_access.simple_fault.ObjectFactory.class,
    chubb_corporate.business.change_get_access_user_password_request_ebe4x1.ObjectFactory.class,
    chubb_corporate.get_access.user.ObjectFactory.class,
    chubb_corporate.business.update_get_access_user_profile_reply_ebe4x1.ObjectFactory.class,
    chubb_corporate.business.get_access_user_profile_list_reply_ebe4x1.ObjectFactory.class,
    chubb_corporate.get_access.region_and_language_settings.ObjectFactory.class,
    chubb_corporate.get_access.business_party_characteristic.ObjectFactory.class,
    chubb_corporate.business.reset_get_access_user_password_reply_ebe4x1.ObjectFactory.class,
    chubb_corporate.get_access.customization.ObjectFactory.class,
    chubb_corporate.business.add_get_access_user_profile_request_ebe4x1.ObjectFactory.class,
    chubb_corporate.get_access.individual_name.ObjectFactory.class,
    chubb_corporate.business.change_get_access_user_profile_identifier_request_ebe4x1.ObjectFactory.class,
    chubb_corporate.business.get_access_user_profile_request_ebe4x1.ObjectFactory.class,
    chubb_corporate.business.get_access_user_profile_list_request_ebe4x1.ObjectFactory.class,
    chubb_corporate.get_access.status_information.ObjectFactory.class,
    chubb_corporate.business.change_get_access_user_password_reply_ebe4x1.ObjectFactory.class,
    chubb_corporate.business.add_get_access_user_profile_reply_ebe4x1.ObjectFactory.class,
    chubb_corporate.get_access.telecomm_electronic_address.ObjectFactory.class,
    chubb_corporate.get_access.individual_identifier.ObjectFactory.class,
    chubb_corporate.get_access.typed_address.ObjectFactory.class,
    chubb_corporate.get_access.access_control_group.ObjectFactory.class,
    chubb_corporate.get_access.time_zone.ObjectFactory.class,
    chubb_corporate.business.get_access_user_profile_reply_ebe4x1.ObjectFactory.class,
    chubb_corporate.business.update_get_access_user_profile_status_request_ebe4x1.ObjectFactory.class,
    chubb_corporate.get_access.address.ObjectFactory.class,
    chubb_corporate.get_access.language.ObjectFactory.class,
    chubb_corporate.business.update_get_access_user_profile_request_ebe4x1.ObjectFactory.class,
    chubb_corporate.get_access.application_user_profile.ObjectFactory.class,
    chubb_corporate.get_access.user_profile_identifier.ObjectFactory.class,
    chubb_corporate.business.get_access_user_profile_list_outputs_ebe4x1.ObjectFactory.class,
    chubb_corporate.get_access.standardized_address.ObjectFactory.class,
    chubb_corporate.business.reset_get_access_user_password_request_ebe4x1.ObjectFactory.class,
    chubb_corporate.get_access.error_information.ObjectFactory.class,
    chubb_corporate.business.update_get_access_user_profile_status_reply_ebe4x1.ObjectFactory.class,
    chubb_corporate.business.change_get_access_user_profile_identifier_reply_ebe4x1.ObjectFactory.class,
    chubb_corporate.get_access.access_attribute.ObjectFactory.class,
    chubb_corporate.get_access.application_user_profile_property.ObjectFactory.class,
    chubb_corporate.get_access.source_system_user_profile_id.ObjectFactory.class,
    chubb_corporate.get_access.user_profile.ObjectFactory.class,
    chubb_corporate.get_access.user_authorization.ObjectFactory.class
})
public interface GetAccessUserProfileManagementEBE4X1 {


    /**
     * 
     * @param addGetAccessUserProfileRequest
     * @return
     *     returns chubb_corporate.business.add_get_access_user_profile_reply_ebe4x1.AddGetAccessUserProfileReply
     * @throws AddGetAccessUserProfileSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "AddGetAccessUserProfile", action = "AddGetAccessUserProfile")
    @WebResult(name = "AddGetAccessUserProfileReply", targetNamespace = "")
    @RequestWrapper(localName = "AddGetAccessUserProfile", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.AddGetAccessUserProfile")
    @ResponseWrapper(localName = "AddGetAccessUserProfileResponse", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.AddGetAccessUserProfileResponse")
    public AddGetAccessUserProfileReply addGetAccessUserProfile(
        @WebParam(name = "AddGetAccessUserProfileRequest", targetNamespace = "")
        AddGetAccessUserProfileRequest addGetAccessUserProfileRequest)
        throws AddGetAccessUserProfileSimpleFaultReplyMsg
    ;

    /**
     * 
     * @param updateGetAccessUserProfileRequest
     * @return
     *     returns chubb_corporate.business.update_get_access_user_profile_reply_ebe4x1.UpdateGetAccessUserProfileReply
     * @throws UpdateGetAccessUserProfileSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "UpdateGetAccessUserProfile", action = "UpdateGetAccessUserProfile")
    @WebResult(name = "UpdateGetAccessUserProfileReply", targetNamespace = "")
    @RequestWrapper(localName = "UpdateGetAccessUserProfile", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.UpdateGetAccessUserProfile")
    @ResponseWrapper(localName = "UpdateGetAccessUserProfileResponse", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.UpdateGetAccessUserProfileResponse")
    public UpdateGetAccessUserProfileReply updateGetAccessUserProfile(
        @WebParam(name = "UpdateGetAccessUserProfileRequest", targetNamespace = "")
        UpdateGetAccessUserProfileRequest updateGetAccessUserProfileRequest)
        throws UpdateGetAccessUserProfileSimpleFaultReplyMsg
    ;

    /**
     * 
     * @param updateGetAccessUserProfileStatusRequest
     * @return
     *     returns chubb_corporate.business.update_get_access_user_profile_status_reply_ebe4x1.UpdateGetAccessUserProfileStatusReply
     * @throws UpdateGetAccessUserProfileStatusSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "UpdateGetAccessUserProfileStatus", action = "UpdateGetAccessUserProfileStatus")
    @WebResult(name = "UpdateGetAccessUserProfileStatusReply", targetNamespace = "")
    @RequestWrapper(localName = "UpdateGetAccessUserProfileStatus", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.UpdateGetAccessUserProfileStatus")
    @ResponseWrapper(localName = "UpdateGetAccessUserProfileStatusResponse", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.UpdateGetAccessUserProfileStatusResponse")
    public UpdateGetAccessUserProfileStatusReply updateGetAccessUserProfileStatus(
        @WebParam(name = "UpdateGetAccessUserProfileStatusRequest", targetNamespace = "")
        UpdateGetAccessUserProfileStatusRequest updateGetAccessUserProfileStatusRequest)
        throws UpdateGetAccessUserProfileStatusSimpleFaultReplyMsg
    ;

    /**
     * 
     * @param getAccessUserProfileListRequest
     * @return
     *     returns chubb_corporate.business.get_access_user_profile_list_reply_ebe4x1.GetAccessUserProfileListReply
     * @throws GetAccessUserProfileListSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetAccessUserProfileList", action = "GetAccessUserProfileList")
    @WebResult(name = "GetAccessUserProfileListReply", targetNamespace = "")
    @RequestWrapper(localName = "GetAccessUserProfileList", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.GetAccessUserProfileList")
    @ResponseWrapper(localName = "GetAccessUserProfileListResponse", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.GetAccessUserProfileListResponse")
    public GetAccessUserProfileListReply getAccessUserProfileList(
        @WebParam(name = "GetAccessUserProfileListRequest", targetNamespace = "")
        GetAccessUserProfileListRequest getAccessUserProfileListRequest)
        throws GetAccessUserProfileListSimpleFaultReplyMsg
    ;

    /**
     * 
     * @param getAccessUserProfileRequest
     * @return
     *     returns chubb_corporate.business.get_access_user_profile_reply_ebe4x1.GetAccessUserProfileReply
     * @throws GetAccessUserProfileSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetAccessUserProfile", action = "GetAccessUserProfile")
    @WebResult(name = "GetAccessUserProfileReply", targetNamespace = "")
    @RequestWrapper(localName = "GetAccessUserProfile", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.GetAccessUserProfile")
    @ResponseWrapper(localName = "GetAccessUserProfileResponse", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.GetAccessUserProfileResponse")
    public GetAccessUserProfileReply getAccessUserProfile(
        @WebParam(name = "GetAccessUserProfileRequest", targetNamespace = "")
        GetAccessUserProfileRequest getAccessUserProfileRequest)
        throws GetAccessUserProfileSimpleFaultReplyMsg
    ;

    /**
     * 
     * @param resetGetAccessUserPasswordRequest
     * @return
     *     returns chubb_corporate.business.reset_get_access_user_password_reply_ebe4x1.ResetGetAccessUserPasswordReply
     * @throws ResetGetAccessUserPasswordSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "ResetGetAccessUserPassword", action = "ResetGetAccessUserPassword")
    @WebResult(name = "ResetGetAccessUserPasswordReply", targetNamespace = "")
    @RequestWrapper(localName = "ResetGetAccessUserPassword", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.ResetGetAccessUserPassword")
    @ResponseWrapper(localName = "ResetGetAccessUserPasswordResponse", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.ResetGetAccessUserPasswordResponse")
    public ResetGetAccessUserPasswordReply resetGetAccessUserPassword(
        @WebParam(name = "ResetGetAccessUserPasswordRequest", targetNamespace = "")
        ResetGetAccessUserPasswordRequest resetGetAccessUserPasswordRequest)
        throws ResetGetAccessUserPasswordSimpleFaultReplyMsg
    ;

    /**
     * 
     * @param changeGetAccessUserPasswordRequest
     * @return
     *     returns chubb_corporate.business.change_get_access_user_password_reply_ebe4x1.ChangeGetAccessUserPasswordReply
     * @throws ChangeGetAccessUserPasswordSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "ChangeGetAccessUserPassword", action = "ChangeGetAccessUserPassword")
    @WebResult(name = "ChangeGetAccessUserPasswordReply", targetNamespace = "")
    @RequestWrapper(localName = "ChangeGetAccessUserPassword", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.ChangeGetAccessUserPassword")
    @ResponseWrapper(localName = "ChangeGetAccessUserPasswordResponse", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.ChangeGetAccessUserPasswordResponse")
    public ChangeGetAccessUserPasswordReply changeGetAccessUserPassword(
        @WebParam(name = "ChangeGetAccessUserPasswordRequest", targetNamespace = "")
        ChangeGetAccessUserPasswordRequest changeGetAccessUserPasswordRequest)
        throws ChangeGetAccessUserPasswordSimpleFaultReplyMsg
    ;

    /**
     * 
     * @param changeGetAccessUserProfileIdentifierRequest
     * @return
     *     returns chubb_corporate.business.change_get_access_user_profile_identifier_reply_ebe4x1.ChangeGetAccessUserProfileIdentifierReply
     * @throws ChangeGetAccessUserProfileIdentifierSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "ChangeGetAccessUserProfileIdentifier", action = "ChangeGetAccessUserProfileIdentifier")
    @WebResult(name = "ChangeGetAccessuserProfileIdentifierReply", targetNamespace = "")
    @RequestWrapper(localName = "ChangeGetAccessUserProfileIdentifier", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.ChangeGetAccessUserProfileIdentifier")
    @ResponseWrapper(localName = "ChangeGetAccessUserProfileIdentifierResponse", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1", className = "chubb_corporate.business.get_access_user_profile_management_ebe4x1.ChangeGetAccessUserProfileIdentifierResponse")
    public ChangeGetAccessUserProfileIdentifierReply changeGetAccessUserProfileIdentifier(
        @WebParam(name = "ChangeGetAccessUserProfileIdentifierRequest", targetNamespace = "")
        ChangeGetAccessUserProfileIdentifierRequest changeGetAccessUserProfileIdentifierRequest)
        throws ChangeGetAccessUserProfileIdentifierSimpleFaultReplyMsg
    ;

}
