
package ei.user.profile_retrieval_crp31X1x1_http;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import ei.user.profile.GetUserProfileListByEmailReply;
import ei.user.profile.GetUserProfileListByEmailRequest;
import ei.user.profile.GetUserProfileListReply;
import ei.user.profile.GetUserProfileListRequest;
import ei.user.profile.GetUserProfileReply;
import ei.user.profile.GetUserProfileRequest;
import ei.user.profile.ObjectFactory;

@WebService(name = "UserProfileRetrievalCRP31X1", targetNamespace = "http://ei/corporate/user_profile_retrieval_crp31x1")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserProfileRetrievalCRP31X1 {


    /**
     * 
     * @param getUserProfileRequest
     * @return
     *     returns com.chubb.dgmk.caf.was.accessors.GetUserProfileReply
     * @throws GetUserProfileSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetUserProfile", action = "GetUserProfile")
    @WebResult(name = "GetUserProfileReply", targetNamespace = "")
    @RequestWrapper(localName = "GetUserProfile", targetNamespace = "http://ei/corporate/user_profile_retrieval_crp31x1", className = "com.chubb.dgmk.caf.was.accessors.GetUserProfile")
    @ResponseWrapper(localName = "GetUserProfileResponse", targetNamespace = "http://ei/corporate/user_profile_retrieval_crp31x1", className = "com.chubb.dgmk.caf.was.accessors.GetUserProfileResponse")
    public GetUserProfileReply getUserProfile(
        @WebParam(name = "GetUserProfileRequest", targetNamespace = "")
        GetUserProfileRequest getUserProfileRequest)
        throws GetUserProfileSimpleFaultReplyMsg
    ;

    /**
     * 
     * @param getUserProfileListRequest
     * @return
     *     returns com.chubb.dgmk.caf.was.accessors.GetUserProfileListReply
     * @throws GetUserProfileListSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetUserProfileList", action = "GetUserProfileList")
    @WebResult(name = "GetUserProfileListReply", targetNamespace = "")
    @RequestWrapper(localName = "GetUserProfileList", targetNamespace = "http://ei/corporate/user_profile_retrieval_crp31x1", className = "com.chubb.dgmk.caf.was.accessors.GetUserProfileList")
    @ResponseWrapper(localName = "GetUserProfileListResponse", targetNamespace = "http://ei/corporate/user_profile_retrieval_crp31x1", className = "com.chubb.dgmk.caf.was.accessors.GetUserProfileListResponse")
    public GetUserProfileListReply getUserProfileList(
        @WebParam(name = "GetUserProfileListRequest", targetNamespace = "")
        GetUserProfileListRequest getUserProfileListRequest)
        throws GetUserProfileListSimpleFaultReplyMsg
    ;

    /**
     * 
     * @param getUserProfileListByEmailRequest
     * @return
     *     returns com.chubb.dgmk.caf.was.accessors.GetUserProfileListByEmailReply
     * @throws GetUserProfileListByEmailSimpleFaultReplyMsg
     */
    @WebMethod(operationName = "GetUserProfileListByEmail", action = "GetUserProfileListByEmail")
    @WebResult(name = "GetUserProfileListByEmailReply", targetNamespace = "")
    @RequestWrapper(localName = "GetUserProfileListByEmail", targetNamespace = "http://ei/corporate/user_profile_retrieval_crp31x1", className = "com.chubb.dgmk.caf.was.accessors.GetUserProfileListByEmail")
    @ResponseWrapper(localName = "GetUserProfileListByEmailResponse", targetNamespace = "http://ei/corporate/user_profile_retrieval_crp31x1", className = "com.chubb.dgmk.caf.was.accessors.GetUserProfileListByEmailResponse")
    public GetUserProfileListByEmailReply getUserProfileListByEmail(
        @WebParam(name = "GetUserProfileListByEmailRequest", targetNamespace = "")
        GetUserProfileListByEmailRequest getUserProfileListByEmailRequest)
        throws GetUserProfileListByEmailSimpleFaultReplyMsg
    ;

}
