package com.chubb.dgmk.caf.wsc.accessors;


import java.util.List;

import com.chubb.dgmk.caf.domain.model.UserInformation;
import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;

import ei.user.profile.AccessAttribute;
import ei.user.profile.GetUserProfileReply;
import ei.user.profile.GetUserProfileRequest;
import ei.user.profile.IndividualName;
import ei.user.profile.TelecommElectronicAddress;
import ei.user.profile.User;
import ei.user.profile.UserAuthorization;
import ei.user.profile.UserProfile;
import ei.user.profile.UserProfileIdentifier;
import ei.user.profile_retrieval_crp31X1x1_http.UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxy;

/**
 * <pre>
 * UserProfileRetrievalAccessor
 * UserProfileRetrievalAccessor class is responsible for retrieving User Profile
 *
 * </pre> 
 */
public class UserProfileRetrievalAccessor {

	/**
	 * <pre>
	 * getEndpoint
	 * 
	 * This method is used to get user profile service end point URL which loaded at the time of application initialization
	 * 
	 * @return the endPoint for the UserProfile service from
	 * the properties file.
	 * 
	 * </pre>
	 */
	public String getEndpoint() {
		String endpoint = CAFPropertiesUtil.getUserProfileRetrievalEndpoint();
		CAFPropertiesUtil.getProducer2X6RetrievalEndpoint();
		CAFPropertiesUtil.getBranchRetrievalEndpoint();
		CAFPropertiesUtil.getBookOfBusinessSendEndpoint();
		
		CAFLogger.logInfo("Endpoint returned for UserProfileRetriever: " + endpoint, "UserProfileRetrievalAccessor", "getEndpoint");

		return endpoint;
	}

	/**
	 * <pre>
	 * getUserInformation
	 * 
	 * This method will call the ICC provider service and will get
	 * the list of products from it
	 * 
	 * @return the list of AtChubb products
	 * 
	 * </pre>
	 */
	public UserInformation getUserInformation(UserInformation userProfile) throws Exception {

		String endpoint = getEndpoint();
		if(null == endpoint){
			endpoint="http://eiuserpfileretcrp31x1-ut:80/Corporate4ServicesWeb/sca/UserProfileRetrievalCRP31X1Http";
		}
		UserInformation userInfo=null;
		//call the service
		Thread.currentThread().setContextClassLoader(getClass().getClassLoader());

		UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxy proxy = new UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxy();
		proxy._getDescriptor().setEndpoint(endpoint);

		try {
			GetUserProfileRequest providerRequest = buildRequest(userProfile);
			
			GetUserProfileReply reply = proxy.getUserProfile(providerRequest);
			if (reply!=null)
			CAFLogger.logFine("User Profile Retrieved :" + reply.toString(), endpoint, endpoint );
			//build the domain object from the service reply
			userInfo=getDomainObjectFromReply(reply);
		
		}catch (Exception e) {
			String msg = "Exception occurred calling UserProfileRetrieverHttp: " + e;
			CAFLogger.logSevere(msg, "UserProfileRetrieverAccessor", "getAtChubbUserProfile");
			e.printStackTrace();
			throw e;

		}
		return userInfo;

	}

	private UserInformation getDomainObjectFromReply(GetUserProfileReply reply) {
		// TODO Auto-generated method stub
		UserInformation userInfo=new UserInformation();
		if(null != reply){
			
			UserProfile profile=reply.getUserProfile();
			userInfo.setExternalUserId(profile.getExternalUserId());
			User user=profile.getUser();
			if(null != user){
				List<IndividualName> names=user.getIndividualName();
				for(IndividualName name: names){
					userInfo.setGivenName(name.getGivenName());
					userInfo.setGivenName(name.getSurname());
					userInfo.setMiddlename(name.getMiddleName());
				}
				
				userInfo.setUserid(user.getUserId());
				userInfo.setUserTypeCode(user.getUserTypeCode());
				userInfo.setUserType(user.getUserTypeDescription());
				List<TelecommElectronicAddress> emails= user.getBPTelecommElectronicAddress();
				for(TelecommElectronicAddress email:emails){
					if(email.getCommDeviceName().equals(ICAFConstants.EMAIL_ADDRESS_STRING)){
						userInfo.setEmail(email.getCommDeviceValue());
					}
				}
			}
			
			List<UserAuthorization> userAuths= profile.getUserAuthorization();
			List<AccessAttribute> userAttrs=null;
			for(UserAuthorization userAuth:userAuths){
				 userAttrs=userAuth.getAccessAttribute();
				 for(AccessAttribute userAttr:userAttrs){
					if( userAttr.getAccessAttributeName().equals(ICAFConstants.PRODUCER_SUB_PRODUCER_KEYS)){
						userInfo.setProducerkeys(userAttr.getAccessAttributeValue());
					}
				 }
			}
			
		}
		
		return userInfo;
	}

	/**
	 * <pre>
	 * buildRequest
	 * 
	 * Create instance of GetUserProfileRequest from ObjectFactory
	 * @return the GetUserProfileRequest Object
	 *  
	 * </pre>
	 */
	private GetUserProfileRequest buildRequest(UserInformation userProfile) throws Exception {

		GetUserProfileRequest request =new GetUserProfileRequest();
		UserProfileIdentifier userProfileIdentifier=new UserProfileIdentifier();
		userProfileIdentifier.setExternalUserId(userProfile.getExternalUserId());
		request.setUserId(userProfile.getUserid());
		request.setUserProfileIdentifier(userProfileIdentifier);
		request.setDataSourceOptionsText(ICAFConstants.DATA_SOURCE_OPTIONS_TEXT_GET_ACCESS_ONLY);
		
		CAFLogger.logInfo("Request object ", "UserProfileRetrievalAccessor", "buildRequest is "+request.toString());
		return request;

	}

}