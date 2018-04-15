package com.chubb.ecom.dgmk.ga.domain.manager;

import chubb_corporate.business.add_get_access_user_profile_request_ebe4x1.AddGetAccessUserProfileRequest;
import chubb_corporate.business.change_get_access_user_password_reply_ebe4x1.ChangeGetAccessUserPasswordReply;
import chubb_corporate.business.change_get_access_user_password_request_ebe4x1.ChangeGetAccessUserPasswordRequest;
import chubb_corporate.business.change_get_access_user_profile_identifier_reply_ebe4x1.ChangeGetAccessUserProfileIdentifierReply;
import chubb_corporate.business.change_get_access_user_profile_identifier_request_ebe4x1.ChangeGetAccessUserProfileIdentifierRequest;
import chubb_corporate.business.get_access_user_profile_list_reply_ebe4x1.GetAccessUserProfileListReply;
import chubb_corporate.business.get_access_user_profile_list_request_ebe4x1.GetAccessUserProfileListRequest;
import chubb_corporate.business.get_access_user_profile_reply_ebe4x1.GetAccessUserProfileReply;
import chubb_corporate.business.get_access_user_profile_request_ebe4x1.GetAccessUserProfileRequest;
import chubb_corporate.business.reset_get_access_user_password_request_ebe4x1.ResetGetAccessUserPasswordRequest;
import chubb_corporate.business.update_get_access_user_profile_reply_ebe4x1.UpdateGetAccessUserProfileReply;
import chubb_corporate.business.update_get_access_user_profile_request_ebe4x1.UpdateGetAccessUserProfileRequest;
import chubb_corporate.business.update_get_access_user_profile_status_request_ebe4x1.UpdateGetAccessUserProfileStatusRequest;

import com.chubb.ecom.dgmk.ga.domain.resource.AddGetAccessUserProfileReplyResource;
import com.chubb.ecom.dgmk.ga.domain.resource.ResetGetAccessUserPasswordResource;
import com.chubb.ecom.dgmk.ga.domain.resource.UpdateGetAccessUserProfileStatusResource;
import com.chubb.ecom.dgmk.ga.domain.resource.UserSnapshotResource;
import com.chubb.ecom.dgmk.ga.domain.resource.UserUpdateRequestResource;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileAuthenticationException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileDataException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileFieldFormatException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileMultipleException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileNotFoundException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileRequiredFieldException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileRollbackSuccessfulException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileRollbackUnsuccessfulException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSyntheticTestException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;
import com.chubb.ecom.dgmk.ga.model.UserCredential;

/**
 * The Interface UserProfileManager.
 */
public interface GAUserProfileManager {

	/**
	 * Reset get access user password.
	 *
	 * @param resetGetAccessUserPasswordRequest the reset get access user password request
	 * @param userCredential the user credential
	 * @return the reset get access user password resource
	 * @throws GAUserProfileRequiredFieldException the gA user profile required field exception
	 * @throws GAUserProfileAuthenticationException the gA user profile authentication exception
	 * @throws GAUserProfileSystemException the gA user profile system exception
	 * @throws GAUserProfileSyntheticTestException the gA user profile synthetic test exception
	 * @throws GAUserProfileDataException the gA user profile data exception
	 * @throws GAUserProfileNotFoundException the gA user profile not found exception
	 * @throws GAUserProfileRollbackSuccessfulException the gA user profile rollback successful exception
	 * @throws GAUserProfileRollbackUnsuccessfulException the gA user profile rollback unsuccessful exception
	 * @throws GAUserProfileFieldFormatException the gA user profile field format exception
	 */
	public ResetGetAccessUserPasswordResource resetGetAccessUserPassword(ResetGetAccessUserPasswordRequest resetGetAccessUserPasswordRequest,
			UserCredential userCredential) throws GAUserProfileRequiredFieldException, GAUserProfileAuthenticationException,
			GAUserProfileSystemException, GAUserProfileSyntheticTestException, GAUserProfileDataException, GAUserProfileNotFoundException,
			GAUserProfileRollbackSuccessfulException, GAUserProfileRollbackUnsuccessfulException, GAUserProfileFieldFormatException;

	/**
	 * Change get access user password.
	 *
	 * @param changeGetAccessUserPasswordRequest the change get access user password request
	 * @param userCredential the user credential
	 * @return the change get access user password reply
	 * @throws GAUserProfileRequiredFieldException the gA user profile required field exception
	 * @throws GAUserProfileAuthenticationException the gA user profile authentication exception
	 * @throws GAUserProfileSystemException the gA user profile system exception
	 * @throws GAUserProfileSyntheticTestException the gA user profile synthetic test exception
	 * @throws GAUserProfileDataException the gA user profile data exception
	 * @throws GAUserProfileNotFoundException the gA user profile not found exception
	 * @throws GAUserProfileFieldFormatException the gA user profile field format exception
	 */
	public ChangeGetAccessUserPasswordReply changeGetAccessUserPassword(ChangeGetAccessUserPasswordRequest changeGetAccessUserPasswordRequest,
			UserCredential userCredential) throws GAUserProfileRequiredFieldException, GAUserProfileAuthenticationException,
			GAUserProfileSystemException, GAUserProfileSyntheticTestException, GAUserProfileDataException, GAUserProfileNotFoundException, GAUserProfileFieldFormatException;

	/**
	 * Change get access user profile identifier.
	 *
	 * @param changeGetAccessUserProfileIdentifierRequest the change get access user profile identifier request
	 * @param userCredential the user credential
	 * @return the change get access user profile identifier reply
	 * @throws GAUserProfileRequiredFieldException the gA user profile required field exception
	 * @throws GAUserProfileAuthenticationException the gA user profile authentication exception
	 * @throws GAUserProfileSystemException the gA user profile system exception
	 * @throws GAUserProfileSyntheticTestException the gA user profile synthetic test exception
	 * @throws GAUserProfileDataException the gA user profile data exception
	 * @throws GAUserProfileNotFoundException the gA user profile not found exception
	 * @throws GAUserProfileFieldFormatException the gA user profile field format exception
	 */
	public ChangeGetAccessUserProfileIdentifierReply changeGetAccessUserProfileIdentifier(ChangeGetAccessUserProfileIdentifierRequest changeGetAccessUserProfileIdentifierRequest,
			UserCredential userCredential) throws GAUserProfileRequiredFieldException, GAUserProfileAuthenticationException,
			GAUserProfileSystemException, GAUserProfileSyntheticTestException, GAUserProfileDataException, GAUserProfileNotFoundException, GAUserProfileFieldFormatException;	
	
	/**
	 * Adds the get access user profile.
	 * 
	 * @param addGetAccessUserProfileRequest
	 *            the add get access user profile request
	 * @param userCredential
	 *            the user credential
	 * @return the add get access user profile reply resource
	 * @throws GAUserProfileRequiredFieldException
	 *             the gA user profile required field exception
	 * @throws GAUserProfileAuthenticationException
	 *             the gA user profile authentication exception
	 * @throws GAUserProfileFieldFormatException
	 *             the gA user profile field format exception
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 * @throws GAUserProfileSyntheticTestException
	 *             the gA user profile synthetic test exception
	 * @throws GAUserProfileRollbackSuccessfulException
	 *             the gA user profile rollback successful exception
	 * @throws GAUserProfileRollbackUnsuccessfulException
	 *             the gA user profile rollback unsuccessful exception
	 * @throws GAUserProfileDataException
	 *             the GA user profile data exception
	 */
	public AddGetAccessUserProfileReplyResource addGetAccessUserProfile(AddGetAccessUserProfileRequest addGetAccessUserProfileRequest,
			UserCredential userCredential) throws GAUserProfileRequiredFieldException, GAUserProfileAuthenticationException,
			GAUserProfileFieldFormatException, GAUserProfileSystemException, GAUserProfileSyntheticTestException,
			GAUserProfileRollbackSuccessfulException, GAUserProfileRollbackUnsuccessfulException, GAUserProfileDataException;

	/**
	 * Restore user profile.
	 *
	 * @param userSnapshot the user snapshot
	 * @param personGIN the person gin
	 * @param userUpdateRequest the user update request
	 * @param adminUser the admin user
	 * @throws GAUserProfileRequiredFieldException the gA user profile required field exception
	 * @throws GAUserProfileFieldFormatException the gA user profile field format exception
	 * @throws GAUserProfileSystemException the gA user profile system exception
	 * @throws GAUserProfileSyntheticTestException the gA user profile synthetic test exception
	 * @throws GAUserProfileDataException the gA user profile data exception
	 * @throws GAUserProfileAuthenticationException the gA user profile authentication exception
	 */
	public void restoreUserProfile(UserSnapshotResource userSnapshot, String personGIN, UserUpdateRequestResource userUpdateRequest, String adminUser)
			throws GAUserProfileRequiredFieldException, GAUserProfileFieldFormatException, GAUserProfileSystemException,
			GAUserProfileSyntheticTestException, GAUserProfileDataException, GAUserProfileAuthenticationException;

	/**
	 * Update get access user profile.
	 * 
	 * @param updateGetAccessUserProfileRequest
	 *            the update get access user profile request
	 * @param userCredential
	 *            the user credential
	 * @return the update get access user profile reply
	 * @throws GAUserProfileRequiredFieldException
	 *             the gA user profile required field exception
	 * @throws GAUserProfileAuthenticationException
	 *             the gA user profile authentication exception
	 * @throws GAUserProfileFieldFormatException
	 *             the gA user profile field format exception
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 * @throws GAUserProfileNotFoundException
	 *             the gA user profile not found exception
	 * @throws GAUserProfileSyntheticTestException
	 *             the gA user profile synthetic test exception
	 * @throws GAUserProfileDataException
	 *             the gA user profile data exception
	 * @throws GAUserProfileRollbackSuccessfulException
	 *             the gA user profile rollback successful exception
	 * @throws GAUserProfileRollbackUnsuccessfulException
	 *             the gA user profile rollback unsuccessful exception
	 */
	public UpdateGetAccessUserProfileReply updateGetAccessUserProfile(UpdateGetAccessUserProfileRequest updateGetAccessUserProfileRequest,
			UserCredential userCredential) throws GAUserProfileRequiredFieldException, GAUserProfileAuthenticationException,
			GAUserProfileFieldFormatException, GAUserProfileSystemException, GAUserProfileNotFoundException, GAUserProfileSyntheticTestException,
			GAUserProfileDataException, GAUserProfileRollbackSuccessfulException, GAUserProfileRollbackUnsuccessfulException;

	/**
	 * Update get access user profile status.
	 * 
	 * @param updateGetAccessUserProfileStatusRequest
	 *            the update get access user profile status request
	 * @param userCredential
	 *            the user credential
	 * @return the update get access user profile status reply
	 * @throws GAUserProfileRequiredFieldException
	 *             the gA user profile required field exception
	 * @throws GAUserProfileAuthenticationException
	 *             the gA user profile authentication exception
	 * @throws GAUserProfileFieldFormatException
	 *             the gA user profile field format exception
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 * @throws GAUserProfileNotFoundException
	 *             the gA user profile not found exception
	 * @throws GAUserProfileSyntheticTestException
	 *             the gA user profile synthetic test exception
	 * @throws GAUserProfileDataException
	 *             the gA user profile data exception
	 */
	public UpdateGetAccessUserProfileStatusResource updateGetAccessUserProfileStatus(
			UpdateGetAccessUserProfileStatusRequest updateGetAccessUserProfileStatusRequest, UserCredential userCredential)
			throws GAUserProfileRequiredFieldException, GAUserProfileAuthenticationException, GAUserProfileFieldFormatException,
			GAUserProfileSystemException, GAUserProfileNotFoundException, GAUserProfileSyntheticTestException, GAUserProfileDataException;

	/**
	 * Gets the access user profile list.
	 * 
	 * @param getAccessUserProfileListRequest
	 *            the get access user profile list request
	 * @return the access user profile list
	 * @throws GAUserProfileRequiredFieldException
	 *             the gA user profile required field exception
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 * @throws GAUserProfileDataException
	 *             the gA user profile data exception
	 */
	public GetAccessUserProfileListReply getAccessUserProfileList(GetAccessUserProfileListRequest getAccessUserProfileListRequest)
			throws GAUserProfileRequiredFieldException, GAUserProfileSystemException, GAUserProfileDataException;

	/**
	 * Gets the access user profile.
	 * 
	 * @param getAccessUserProfileRequest
	 *            the get access user profile request
	 * @return the access user profile
	 * @throws GAUserProfileRequiredFieldException
	 *             the gA user profile required field exception
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 * @throws GAUserProfileDataException
	 *             the gA user profile data exception
	 * @throws GAUserProfileNotFoundException
	 *             the gA user profile not found exception
	 * @throws GAUserProfileMultipleException
	 *             the gA user profile multiple exception
	 */
	public GetAccessUserProfileReply getAccessUserProfile(GetAccessUserProfileRequest getAccessUserProfileRequest)
			throws GAUserProfileRequiredFieldException, GAUserProfileSystemException, GAUserProfileDataException, GAUserProfileNotFoundException,
			GAUserProfileMultipleException;

}
