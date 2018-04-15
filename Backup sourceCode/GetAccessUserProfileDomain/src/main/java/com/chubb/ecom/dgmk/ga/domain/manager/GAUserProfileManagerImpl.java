package com.chubb.ecom.dgmk.ga.domain.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;

import chubb_corporate.business.add_get_access_user_profile_reply_ebe4x1.AddGetAccessUserProfileReply;
import chubb_corporate.business.add_get_access_user_profile_request_ebe4x1.AddGetAccessUserProfileRequest;
import chubb_corporate.business.change_get_access_user_password_reply_ebe4x1.ChangeGetAccessUserPasswordReply;
import chubb_corporate.business.change_get_access_user_password_request_ebe4x1.ChangeGetAccessUserPasswordRequest;
import chubb_corporate.business.change_get_access_user_profile_identifier_reply_ebe4x1.ChangeGetAccessUserProfileIdentifierReply;
import chubb_corporate.business.change_get_access_user_profile_identifier_request_ebe4x1.ChangeGetAccessUserProfileIdentifierRequest;
import chubb_corporate.business.get_access_user_profile_list_outputs_ebe4x1.GetAccessUserProfileListOutputs;
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
import chubb_corporate.get_access.access_attribute.AccessAttribute;
import chubb_corporate.get_access.access_control_group.AccessControlGroup;
import chubb_corporate.get_access.source_system_user_profile_id.SourceSystemUserProfileId;
import chubb_corporate.get_access.standardized_address.StandardizedAddress;
import chubb_corporate.get_access.status_information.StatusInformation;
import chubb_corporate.get_access.user_authorization.UserAuthorization;
import chubb_corporate.get_access.user_profile.UserProfile;
import chubb_corporate.get_access.user_profile_identifier.UserProfileIdentifier;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.connection.GAConnectionFactory;
import com.chubb.ecom.dgmk.ga.domain.command.GACommand;
import com.chubb.ecom.dgmk.ga.domain.command.GACommandFactory;
import com.chubb.ecom.dgmk.ga.domain.command.GACommandFactoryImpl;
import com.chubb.ecom.dgmk.ga.domain.resource.AddGetAccessUserProfileReplyResource;
import com.chubb.ecom.dgmk.ga.domain.resource.ResetGetAccessUserPasswordResource;
import com.chubb.ecom.dgmk.ga.domain.resource.UpdateGetAccessUserProfileStatusResource;
import com.chubb.ecom.dgmk.ga.domain.resource.UserSnapshotResource;
import com.chubb.ecom.dgmk.ga.domain.resource.UserUpdateRequestResource;
import com.chubb.ecom.dgmk.ga.domain.util.GAUserProfileManagerUtil;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileAuthenticationException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileDataException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileDataNotFoundException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileFieldFormatException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileMultipleException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileNotFoundException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileRequiredFieldException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileRollbackSuccessfulException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileRollbackUnsuccessfulException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSyntheticTestException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;
import com.chubb.ecom.dgmk.ga.model.UserCredential;
import com.chubb.ecom.dgmk.ga.persistence.eao.GetAccessEAOFactory;
import com.chubb.ecom.dgmk.ga.persistence.eao.GetAccessUserProfileEAO;
import com.chubb.ecom.dgmk.ga.util.GAUserProfilePropertiesUtil;
import com.chubb.ecom.dgmk.ga.util.GAUserProfileServiceConstants;
import com.chubb.ecom.dgmk.ga.util.PasswordGenerator;

import enCommerce.getAccess.API.Exceptions.DuplicatedRowsException;
import enCommerce.getAccess.API.Exceptions.InvalidParameterException;
import enCommerce.getAccess.API.Exceptions.OtherException;

/**
 * The Class GAUserProfileManagerImpl is the service manager for GA User Profile.
 */
@Stateless
public class GAUserProfileManagerImpl implements GAUserProfileManager {

	/** The ga logger. This should be injected by IOC framework */
	private ILogger logger;

	private GetAccessUserProfileEAO getAccessEAO;
	private GAUserProfileManagerUtil userProfileManagerUtil;
	private GACommandFactory gaCommandFactory;

	@PersistenceContext(unitName = "GetAccessPersistence")
	protected EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.manager.GAUserProfileManager# resetGetAccessUserPassword (com.chubb.ecom.dgmk.ga.service.ResetGetAccessUserPasswordRequest,
	 * com.chubb.ecom.dgmk.ga.model.UserCredential)
	 */
	@Override
	public ResetGetAccessUserPasswordResource resetGetAccessUserPassword(ResetGetAccessUserPasswordRequest resetGetAccessUserPasswordRequest,
			UserCredential userCredential) throws GAUserProfileRequiredFieldException, GAUserProfileAuthenticationException,
			GAUserProfileSystemException, GAUserProfileSyntheticTestException, GAUserProfileDataException, GAUserProfileNotFoundException,
			GAUserProfileRollbackSuccessfulException, GAUserProfileRollbackUnsuccessfulException, GAUserProfileFieldFormatException {

		// construct reply object
		ResetGetAccessUserPasswordResource replyResource = new ResetGetAccessUserPasswordResource();
		ResetGetAccessUserPasswordReply reply = new ResetGetAccessUserPasswordReply();

		// determine the user login
		List<String> userLogin = determineUserLogin(resetGetAccessUserPasswordRequest.getUserProfileIdentifier());

		if (getUserProfileManagerUtil().isUserLoginTaken(userLogin.get(0))) {

			// authenticate admin user
			getUserProfileManagerUtil().authenticateAdminUser(userCredential, resetGetAccessUserPasswordRequest.getUserId(), GAUserProfileServiceConstants.PASSWORD_ACTION);

			// lookup current user status (in case of rollback)
			String originalUserStatus = getUserProfileManagerUtil().getUserStatus(userLogin.get(0));
			
			// check for synthetic full test before continuing...
			if (GAUserProfileServiceConstants.FULL_TEST.equalsIgnoreCase(resetGetAccessUserPasswordRequest.getSyntheticTransactionTypeCode())) {
				throw new GAUserProfileSyntheticTestException("Full Test");
			}
			
			getLogger().logInfo(
					userLogin + "'s password requested to be reset by " + resetGetAccessUserPasswordRequest.getUserId() + "; from: "
							+ userCredential.getIpAddress(), this.getClass().getName(), "resetGetAccessUserPassword");			
				
			String newUserPassword = userCredential.getNewUserPassword();
			boolean tempPasswordReset = false;
				
			// If new password was not provided in the HEADER, generate a new temp password and reset status to expired
			if(StringUtils.isEmpty(newUserPassword)) {
					
				getLogger().logInfo("New password was not provided, generating a temp password"
								+ userCredential.getIpAddress(), this.getClass().getName(), "resetGetAccessUserPassword");
				
				tempPasswordReset = true;
				
				newUserPassword = PasswordGenerator.generateTempPassword();  // generate new temp password
				replyResource.setTempPassword(newUserPassword);	
			}
			
			// change the user password.  
			// This command cannot be rolled back due to security reasons.
			// This command must be executed first since it automatically sets the status to ACTIVE, but we need it to be EXPIRED
			GACommand updateUserPasswordCommand = getGaCommandFactory().getUpdateUserPasswordCommand(userLogin.get(0), null,
					newUserPassword, resetGetAccessUserPasswordRequest.getUserId(), false);

			updateUserPasswordCommand.execute();			

			//  if the bypass flag is not provided in the request
			if(!byPassStatusChange(resetGetAccessUserPasswordRequest)) {
				
				// if the new password was not provided (generated a temp password), change the user status to PASSWORD EXPIRED
				if(tempPasswordReset) {
				
					getLogger().logInfo("New password was not provided, resetting status to PASSWORD EXPIRED "
						+ userCredential.getIpAddress(), this.getClass().getName(), "resetGetAccessUserPassword");

					GACommand updateUserStatusCommand = getGaCommandFactory().getUpdateUserStatusCommand(userLogin.get(0), originalUserStatus,
					GAUserProfileServiceConstants.PASSWORD_EXPIRED_STATUS);
					
					try {				
						updateUserStatusCommand.execute();				

					} catch (GAUserProfileSystemException ex) {
						getLogger().logSevere("System Exception: " + ex.getMessage() + " | Rolling back status to: " + originalUserStatus+
								" | Original Password will not be rolled back",
								this.getClass().getName(), "resetGetAccessUserPassword");

						updateUserStatusCommand.undo(ex.getMessage());
					}						
				}
			}

		} else {

			getLogger().logInfo("invalid user ID: " + userLogin, this.getClass().getName(), "resetGetAccessUserPassword");
			throw new GAUserProfileNotFoundException(userLogin + " is invalid user ID");
		}

		replyResource.setResetGetAccessUserPasswordReply(reply);
		return replyResource;
	}


	/**
	 * Check if Bypass status change was requested in Additional Options.
	 *
	 * @param resetGetAccessUserPasswordRequest the reset get access user password request
	 * @return true, if successful
	 */
	protected boolean byPassStatusChange(
			ResetGetAccessUserPasswordRequest resetGetAccessUserPasswordRequest) {
		
		boolean byPassFlag = resetGetAccessUserPasswordRequest.getAdditionalOptionsText().contains(GAUserProfileServiceConstants.ADD_OPT_BYPASS_STATUS_UPDATE);
		getLogger().logInfo("Bypass Status Change in reset password: " + byPassFlag, this.getClass().getName(), "byPassStatusChange");
		
		return byPassFlag;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.chubb.ecom.dgmk.ga.domain.manager.GAUserProfileManager#changeGetAccessUserPassword(chubb_corporate.business.change_get_access_user_password_request_ebe4x1.ChangeGetAccessUserPasswordRequest
	 * , com.chubb.ecom.dgmk.ga.model.UserCredential)
	 */
	@Override
	public ChangeGetAccessUserPasswordReply changeGetAccessUserPassword(ChangeGetAccessUserPasswordRequest changeGetAccessUserPasswordRequest,
			UserCredential userCredential) throws GAUserProfileRequiredFieldException, GAUserProfileAuthenticationException,
			GAUserProfileSystemException, GAUserProfileSyntheticTestException, GAUserProfileDataException, GAUserProfileNotFoundException, GAUserProfileFieldFormatException {

		// construct reply object
		ChangeGetAccessUserPasswordReply reply = new ChangeGetAccessUserPasswordReply();

		// determine the user login
		List<String> userLogin = determineUserLogin(changeGetAccessUserPasswordRequest.getUserProfileIdentifier());

		if (getUserProfileManagerUtil().isUserLoginTaken(userLogin.get(0))) {

			// authenticate admin user
			getUserProfileManagerUtil().authenticateAdminUser(userCredential, changeGetAccessUserPasswordRequest.getUserId(), GAUserProfileServiceConstants.PASSWORD_ACTION);

			// check for synthetic full test before continuing...
			if (GAUserProfileServiceConstants.FULL_TEST.equalsIgnoreCase(changeGetAccessUserPasswordRequest.getSyntheticTransactionTypeCode())) {
				throw new GAUserProfileSyntheticTestException("Full Test");
			}
			
			getLogger().logInfo(
					userLogin + "'s password requested to be changed by " + changeGetAccessUserPasswordRequest.getUserId() + "; from: "
							+ userCredential.getIpAddress(), this.getClass().getName(), "changeGetAccessUserPassword");			

			GACommand updateUserPasswordCommand = getGaCommandFactory().getUpdateUserPasswordCommand(userLogin.get(0),
					userCredential.getExistingUserPassword(), userCredential.getNewUserPassword(), changeGetAccessUserPasswordRequest.getUserId(), true);

			updateUserPasswordCommand.execute();

		} else {
			throw new GAUserProfileNotFoundException(userLogin + " is invalid user ID");
		}

		return reply;
	}
	
	/* (non-Javadoc)
	 * @see com.chubb.ecom.dgmk.ga.domain.manager.GAUserProfileManager#changeGetAccessUserProfileIdentifier(chubb_corporate.business.change_get_access_user_profile_identifier_request_ebe4x1.ChangeGetAccessUserProfileIdentifierRequest, com.chubb.ecom.dgmk.ga.model.UserCredential)
	 */
	@Override
	public ChangeGetAccessUserProfileIdentifierReply changeGetAccessUserProfileIdentifier(
			ChangeGetAccessUserProfileIdentifierRequest changeGetAccessUserProfileIdentifierRequest,
			UserCredential userCredential) throws GAUserProfileRequiredFieldException,
			GAUserProfileAuthenticationException, GAUserProfileSystemException,
			GAUserProfileSyntheticTestException, GAUserProfileDataException,
			GAUserProfileNotFoundException, GAUserProfileFieldFormatException {
		
		// construct reply object
		ChangeGetAccessUserProfileIdentifierReply reply = new ChangeGetAccessUserProfileIdentifierReply();

		// validate PersonGIN request field
		if (StringUtils.isEmpty(changeGetAccessUserProfileIdentifierRequest.getPersonGIN())) {
			throw new GAUserProfileRequiredFieldException("PersonGIN was not provided");			
		}

		// authenticate admin user  
		getUserProfileManagerUtil().authenticateAdminUser(userCredential, changeGetAccessUserProfileIdentifierRequest.getUserId(), GAUserProfileServiceConstants.UPDATE_USER_ACTION);

		// get original user login
		String originalUserLogin = getUserProfileManagerUtil().getUserLoginByPersonId(changeGetAccessUserProfileIdentifierRequest.getPersonGIN());
		
		// check for synthetic full test before continuing...
		if (GAUserProfileServiceConstants.FULL_TEST.equalsIgnoreCase(changeGetAccessUserProfileIdentifierRequest.getSyntheticTransactionTypeCode())) {
			throw new GAUserProfileSyntheticTestException("Full Test");
		}
			
		getLogger().logInfo(
				originalUserLogin + "'s profile identifier requested to be changed by " + changeGetAccessUserProfileIdentifierRequest.getUserId() + "; from: "
				+ userCredential.getIpAddress(), this.getClass().getName(), "changeGetAccessUserProfileIdentifier");			

		// populate the user identifier attributes
		Hashtable<String, Object> userAttributes = populateUpdateUserIdentifierAttributes(changeGetAccessUserProfileIdentifierRequest);
		Hashtable<String, Object> userPlusAttributes = populateUpdateUserIdentifierPlusAttributes(changeGetAccessUserProfileIdentifierRequest);

		// execute Update User Command if requested
		if (!userAttributes.isEmpty()) {
				
			UserUpdateRequestResource userUpdateCommandResource = new UserUpdateRequestResource(userAttributes, null, null,	null);
			GACommand updateUserCommand = getGaCommandFactory().getUpdateUserCommand(changeGetAccessUserProfileIdentifierRequest.getUserId(), 
					changeGetAccessUserProfileIdentifierRequest.getPersonGIN(), userUpdateCommandResource, null);				
				
			updateUserCommand.execute();
		}
			
		// execute Update User Plus Command if requested
		if (!userPlusAttributes.isEmpty()) {
			GACommand updateUserPlusCommand = getGaCommandFactory().getUpdateUserPlusCommand(changeGetAccessUserProfileIdentifierRequest.getPersonGIN(), userPlusAttributes);
			updateUserPlusCommand.execute();
		}			

		return reply;		
	}	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.manager.GAUserProfileManager#addGetAccessUserProfile(com.chubb.ecom.dgmk.ga.service.AddGetAccessUserProfileRequest,
	 * com.chubb.ecom.dgmk.ga.model.UserCredential)
	 */
	@Override
	public AddGetAccessUserProfileReplyResource addGetAccessUserProfile(AddGetAccessUserProfileRequest addGetAccessUserProfileRequest,
			UserCredential userCredential) throws GAUserProfileRequiredFieldException, GAUserProfileAuthenticationException,
			GAUserProfileFieldFormatException, GAUserProfileSystemException, GAUserProfileSyntheticTestException,
			GAUserProfileRollbackSuccessfulException, GAUserProfileRollbackUnsuccessfulException, GAUserProfileDataException {

		// construct reply object
		AddGetAccessUserProfileReplyResource replyResource = new AddGetAccessUserProfileReplyResource();
		AddGetAccessUserProfileReply reply = new AddGetAccessUserProfileReply();

		// authenticate admin user
		getUserProfileManagerUtil().authenticateAdminUser(userCredential, addGetAccessUserProfileRequest.getUserId(), GAUserProfileServiceConstants.CREATE_USER_ACTION);

		getLogger().logInfo("create user profile requested by " + addGetAccessUserProfileRequest.getUserId() + "; from: " + userCredential.getIpAddress(),
				this.getClass().getName(), "addGetAccessUserProfile");		
		
		// validate roles
		validateRoles(addGetAccessUserProfileRequest.getUserProfile().getAccessControlGroup());

		// validate access attributes
		Map<String, List<AccessAttribute>> applicationKeysActionMap = getUserProfileManagerUtil().getAppKeysForAction(
				addGetAccessUserProfileRequest.getUserProfile().getUserAuthorization());

		getUserProfileManagerUtil().validateAccessAttributes(applicationKeysActionMap);

		// populate the user attributes
		Hashtable<String, Object> userAttributes = populateCreateUserAttributes(addGetAccessUserProfileRequest.getUserProfile());

		// populate user plus attributes
		Hashtable<String, Object> userPlusAttributes = populateCreateUserPlusAttributes(addGetAccessUserProfileRequest.getUserProfile());

		// generate and set the temporary password
		String tempPassword = PasswordGenerator.generateTempPassword();

		userAttributes.put(GAUserProfileServiceConstants.ATTR_PASSWORD, tempPassword);
		replyResource.setTempPassword(tempPassword);

		// check for synthetic full test before continuing...
		if (GAUserProfileServiceConstants.FULL_TEST.equalsIgnoreCase(addGetAccessUserProfileRequest.getSyntheticTransactionTypeCode())) {
			throw new GAUserProfileSyntheticTestException("Full Test");
		}

		String userLogin = (String) userAttributes.get(GAUserProfileServiceConstants.ATTR_USER_LOGIN);
		String personGIN = null;

		GACommand createUserCommand = getGaCommandFactory().getCreateUserCommand(userAttributes, addGetAccessUserProfileRequest.getUserId());
		createUserCommand.execute();

		try {

			// lookup person id (PersonGIN)
			personGIN = getUserProfileManagerUtil().getPersonId(userLogin);

			getLogger().logInfo("Created new user with Person ID (PersonGIN): " + personGIN, this.getClass().getName(), "addGetAccessUserProfile");

			// create roles
			GACommand createUserRolesCommand = getGaCommandFactory().getCreateUserRolesCommand(
					addGetAccessUserProfileRequest.getUserProfile().getAccessControlGroup(), userLogin, addGetAccessUserProfileRequest.getUserId());

			createUserRolesCommand.execute();

			// create application keys
			if (applicationKeysActionMap != null) {

				if (!applicationKeysActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE).isEmpty()) {

					GACommand createUserAppKeysCommand = gaCommandFactory
							.getCreateUserAppKeysCommand(applicationKeysActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE), userLogin,
									addGetAccessUserProfileRequest.getUserId());

					createUserAppKeysCommand.execute();
				}
			}

			if (!userPlusAttributes.isEmpty()) {
				GACommand createUserPlusCommand = getGaCommandFactory().getCreateUserPlusCommand(personGIN, userPlusAttributes);
				createUserPlusCommand.execute();
			}

			// set reply values
			reply.setExternalUserId(userLogin);
			reply.setPersonGIN(personGIN);

		} catch (GAUserProfileSystemException ex) {
			getLogger().logSevere("System Exception: " + ex.getMessage() + " | Rolling back create user: " + userLogin, this.getClass().getName(),
					"addGetAccessUserProfile");

			createUserCommand.undo(ex.getMessage());
		}

		replyResource.setAddGetAccessUserProfileReply(reply);

		return replyResource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.manager.GAUserProfileManager# updateGetAccessUserProfile (com.chubb.ecom.dgmk.ga.service.UpdateGetAccessUserProfileRequest,
	 * com.chubb.ecom.dgmk.ga.model.UserCredential)
	 */
	@Override
	public UpdateGetAccessUserProfileReply updateGetAccessUserProfile(UpdateGetAccessUserProfileRequest updateGetAccessUserProfileRequest,
			UserCredential userCredential) throws GAUserProfileRequiredFieldException, GAUserProfileAuthenticationException,
			GAUserProfileFieldFormatException, GAUserProfileSystemException, GAUserProfileNotFoundException, GAUserProfileSyntheticTestException,
			GAUserProfileDataException, GAUserProfileRollbackSuccessfulException, GAUserProfileRollbackUnsuccessfulException {

		// construct reply object
		UpdateGetAccessUserProfileReply reply = new UpdateGetAccessUserProfileReply();

		// authenticate admin user
		getUserProfileManagerUtil().authenticateAdminUser(userCredential, updateGetAccessUserProfileRequest.getUserId(), GAUserProfileServiceConstants.UPDATE_USER_ACTION);

		getLogger().logInfo("update user profile requested by " + updateGetAccessUserProfileRequest.getUserId() + "; from: " + userCredential.getIpAddress(),
				this.getClass().getName(), "updateGetAccessUserProfile");		
				
		String userLogin = null;
		String personGIN = null;

		// check if the external user id was provided
		if (StringUtils.isNotEmpty(updateGetAccessUserProfileRequest.getUserProfile().getExternalUserId())) {
			userLogin = updateGetAccessUserProfileRequest.getUserProfile().getExternalUserId();
			personGIN = getUserProfileManagerUtil().getPersonId(userLogin);

			if (StringUtils.isEmpty(personGIN)) {
				throw new GAUserProfileNotFoundException("Could not determine Person Id for user login: " + userLogin);
			}
		}

		// otherwise lookup the external user id by PersonGIN
		else if (StringUtils.isNotEmpty(updateGetAccessUserProfileRequest.getUserProfile().getPersonGIN())) {
			userLogin = getUserProfileManagerUtil().getUserLoginByPersonId(updateGetAccessUserProfileRequest.getUserProfile().getPersonGIN());
			personGIN = updateGetAccessUserProfileRequest.getUserProfile().getPersonGIN();

			if (StringUtils.isEmpty(userLogin)) {
				throw new GAUserProfileNotFoundException("Could not determine User Login for person id: " + personGIN);
			}

		} else {
			throw new GAUserProfileRequiredFieldException("One of the required profile identifiers (ExternalID, PersonGIN) was not provided");
		}

		// validate roles
		validateRoles(updateGetAccessUserProfileRequest.getUserProfile().getAccessControlGroup());

		// validate access attributes
		Map<String, List<AccessAttribute>> applicationKeysActionMap = getUserProfileManagerUtil().getAppKeysForAction(
				updateGetAccessUserProfileRequest.getUserProfile().getUserAuthorization());

		getUserProfileManagerUtil().validateAccessAttributes(applicationKeysActionMap);

		// populate the user attributes
		Hashtable<String, Object> userAttributes = populateUpdateUserAttributes(updateGetAccessUserProfileRequest.getUserProfile());
		Hashtable<String, Object> userPlusAttributes = new Hashtable<String, Object>();

		// Change made to Validate the Domain name passed in Update request -
		// SSO
		if (validateDomain(updateGetAccessUserProfileRequest.getUserProfile())) {

			// populate user plus attributes
			userPlusAttributes = populateUpdateUserPlusAttributes(updateGetAccessUserProfileRequest
					.getUserProfile());
		} else {
			throw new GAUserProfileRollbackSuccessfulException(
					"One or more UserProfileSourceSystemName in User Profile are INVALID");

		}
		// Change made to Validate the Domain name passed in Update request -
		// SSO
		
		// get a snapshot / backup of original user in case of rollback (we may want to consider persisting this in the future)
		UserProfile originalUser = new UserProfile();
		getUserProfileManagerUtil().retrieveEntireUserInfo(userLogin, originalUser);

		UserSnapshotResource userSnapshot = new UserSnapshotResource();
		userSnapshot.setOriginalUser(originalUser);
		userSnapshot.setOriginalUserLogin(userLogin);
		userSnapshot.setOriginalPersonGIN(personGIN);

		// group roles by action (add/modify/delete)
		Map<String, List<AccessControlGroup>> rolesActionMap = getUserProfileManagerUtil().getRolesForAction(
				updateGetAccessUserProfileRequest.getUserProfile().getAccessControlGroup());

		if (rolesActionMap != null) {

			// lookup current roles
			String currentRoles = getUserProfileManagerUtil().getRoles(userLogin);

			// validate role action
			getUserProfileManagerUtil().validateRoleAction(rolesActionMap, currentRoles);
		}

		// update user application keys
		if (applicationKeysActionMap != null) {

			// all current user application keys
			Map<String, List<String>> currentAppKeysValues = getUserProfileManagerUtil().getAllAppKeyValues(originalUser.getUserAuthorization());

			// validate app keys action
			getUserProfileManagerUtil().validateAppKeysAction(applicationKeysActionMap, currentAppKeysValues);
		}

		// check for synthetic full test before continuing...
		if (GAUserProfileServiceConstants.FULL_TEST.equalsIgnoreCase(updateGetAccessUserProfileRequest.getSyntheticTransactionTypeCode())) {
			throw new GAUserProfileSyntheticTestException("Full Test");
		}

		// update request data object which will be used in execute update user command (userAttributes)
		// in case of rollback this will be used to compare data for (rolesActionMap, applicationKeysActionMap)
		UserUpdateRequestResource userUpdateCommandResource = new UserUpdateRequestResource(userAttributes, rolesActionMap, applicationKeysActionMap,
				userPlusAttributes);

		GACommand updateUserCommand = getGaCommandFactory().getUpdateUserCommand(updateGetAccessUserProfileRequest.getUserId(), personGIN, userUpdateCommandResource,
				userSnapshot);

		updateUserCommand.execute();

		try {

			// update user roles
			if (rolesActionMap != null) {

				// create user roles action
				if (!rolesActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE).isEmpty()) {

					GACommand createUserRolesCommand = getGaCommandFactory().getCreateUserRolesCommand(
							rolesActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE), userLogin, updateGetAccessUserProfileRequest.getUserId());

					createUserRolesCommand.execute();
				}

				// delete user roles action
				if (!rolesActionMap.get(GAUserProfileServiceConstants.DELETE_ACTION_CODE).isEmpty()) {

					GACommand deleteUserRolesCommand = getGaCommandFactory().getDeleteUserRolesCommand(
							rolesActionMap.get(GAUserProfileServiceConstants.DELETE_ACTION_CODE), userLogin, personGIN,
							updateGetAccessUserProfileRequest.getUserId());

					deleteUserRolesCommand.execute();
				}

				// update user roles action
				if (!rolesActionMap.get(GAUserProfileServiceConstants.UPDATE_ACTION_CODE).isEmpty()) {

					GACommand updateUserRolesCommand = getGaCommandFactory().getUpdateUserRolesCommand(
							rolesActionMap.get(GAUserProfileServiceConstants.UPDATE_ACTION_CODE), userLogin, updateGetAccessUserProfileRequest.getUserId());

					updateUserRolesCommand.execute();
				}
			}

			// update user application keys
			if (applicationKeysActionMap != null) {

				// create application keys action
				if (!applicationKeysActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE).isEmpty()) {

					GACommand createUserAppKeysCommand = gaCommandFactory
							.getCreateUserAppKeysCommand(applicationKeysActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE), userLogin,
									updateGetAccessUserProfileRequest.getUserId());

					createUserAppKeysCommand.execute();
				}

				// delete application keys action
				if (!applicationKeysActionMap.get(GAUserProfileServiceConstants.DELETE_ACTION_CODE).isEmpty()) {

					GACommand deleteUserAppKeysCommand = getGaCommandFactory().getDeleteUserAppKeysCommand(
							applicationKeysActionMap.get(GAUserProfileServiceConstants.DELETE_ACTION_CODE), userLogin,
							updateGetAccessUserProfileRequest.getUserId());

					deleteUserAppKeysCommand.execute();
				}
			}

			if (!userPlusAttributes.isEmpty()) {
				GACommand updateUserPlusCommand = getGaCommandFactory().getUpdateUserPlusCommand(personGIN, userPlusAttributes);
				updateUserPlusCommand.execute();
			}

		} catch (GAUserProfileSystemException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage() + " | The update was unsuccessful for User: " + userLogin,
					this.getClass().getName(), "updateGetAccessUserProfile");

			updateUserCommand.undo(ex.getMessage());
		}

		return reply;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.manager.GAUserProfileManager# updateGetAccessUserProfileStatus (com.chubb.ecom.dgmk.ga.service.UpdateGetAccessUserProfileStatusRequest,
	 * com.chubb.ecom.dgmk.ga.model.UserCredential)
	 */
	@Override
	public UpdateGetAccessUserProfileStatusResource updateGetAccessUserProfileStatus(
			UpdateGetAccessUserProfileStatusRequest updateGetAccessUserProfileStatusRequest, UserCredential userCredential)
			throws GAUserProfileRequiredFieldException, GAUserProfileAuthenticationException, GAUserProfileFieldFormatException,
			GAUserProfileSystemException, GAUserProfileNotFoundException, GAUserProfileSyntheticTestException, GAUserProfileDataException {

		// construct reply object
		UpdateGetAccessUserProfileStatusResource replyResource = new UpdateGetAccessUserProfileStatusResource();
		UpdateGetAccessUserProfileStatusReply reply = new UpdateGetAccessUserProfileStatusReply();

		// determine the user login
		List<String> userLogin = determineUserLogin(updateGetAccessUserProfileStatusRequest.getUserProfileIdentifier());

		if (getUserProfileManagerUtil().isUserLoginTaken(userLogin.get(0))) {

			// authenticate admin user
			getUserProfileManagerUtil().authenticateAdminUser(userCredential, updateGetAccessUserProfileStatusRequest.getUserId(), GAUserProfileServiceConstants.UPDATE_USER_ACTION);

			getLogger().logInfo(
					userLogin.get(0) + "'s user profile status change requested by " + updateGetAccessUserProfileStatusRequest.getUserId() + "; from: "
							+ userCredential.getIpAddress(), this.getClass().getName(), "updateGetAccessUserProfileStatus");			
			
			String currentUserProfileStatus = getUserProfileManagerUtil().getUserStatus(userLogin.get(0));
			String userProfileStatus = updateGetAccessUserProfileStatusRequest.getUserProfileStatusCode();

			// check for synthetic full test before continuing...
			if (GAUserProfileServiceConstants.FULL_TEST.equalsIgnoreCase(updateGetAccessUserProfileStatusRequest.getSyntheticTransactionTypeCode())) {
				throw new GAUserProfileSyntheticTestException("Full Test");
			}

			// if user is already ACTIVE there is no need to re-activate, skip
			if (GAUserProfileServiceConstants.ACTIVE_STATUS.equalsIgnoreCase(currentUserProfileStatus)
					&& GAUserProfileServiceConstants.ACTIVE_STATUS.equalsIgnoreCase(userProfileStatus)) {
				getLogger().logWarning(userLogin + " status is already ACTIVE, skipping update profile status.", this.getClass().getName(),
						"updateGetAccessUserProfileStatus");
				
				replyResource.setUpdateGetAccessUserProfileStatusReply(reply);
				return replyResource;
			}

			// validate the requested status to be set
			if (!GAUserProfileServiceConstants.ACTIVE_STATUS.equalsIgnoreCase(userProfileStatus)
					&& !GAUserProfileServiceConstants.INACTIVE_STATUS.equals(userProfileStatus)
				    && !GAUserProfileServiceConstants.PASSWORD_EXPIRED_STATUS.equals(userProfileStatus)) {
				
				throw new GAUserProfileFieldFormatException("Status: " + userProfileStatus + " is not supported");
			}
			
			// If setting to ACTIVE/PASSWORD EXPIRED, reset user agreement fields in UserPlus, regenerate and reset password, return in HEADER
			if (GAUserProfileServiceConstants.ACTIVE_STATUS.equalsIgnoreCase(userProfileStatus) ||
				GAUserProfileServiceConstants.PASSWORD_EXPIRED_STATUS.equalsIgnoreCase(userProfileStatus)) {
				
				// ************ reset user agreement (UserPlus fields CHAR11 - CHAR15) ***********************
				// THE USER AGREEMENTS FOR COMMERCIAL USERS ARE HANDLED IN IUA DB
				String personGIN = getUserProfileManagerUtil().getPersonId(userLogin.get(0));
				if (StringUtils.isEmpty(personGIN)) {
					throw new GAUserProfileNotFoundException("Could not determine Person Id for user login: " + userLogin.get(0));
				}				
				GACommand updateUserPlusCommand = getGaCommandFactory().getUpdateUserPlusCommand(personGIN, resetUserAgreementUserPlusAttributes());
				updateUserPlusCommand.execute();				
				//*************************************************************************************
				
				// generate and set the temporary password
				String tempPassword = PasswordGenerator.generateTempPassword();
				replyResource.setTempPassword(tempPassword);
				
				// change the user password.  
				// This command cannot be rolled back due to security reasons.
				// This command must be executed first since it automatically sets the status to ACTIVE, but we 'may' need it to be EXPIRED				
				GACommand updateUserPasswordCommand = getGaCommandFactory().getUpdateUserPasswordCommand(userLogin.get(0), null,
						tempPassword, updateGetAccessUserProfileStatusRequest.getUserId(), false);

				updateUserPasswordCommand.execute();
			}			

			getLogger().logInfo(
					userLogin.get(0) + "'s user profile status being changed from: " + currentUserProfileStatus + " --> to: " + userProfileStatus,
					this.getClass().getName(), "updateGetAccessUserProfileStatus");

			GACommand updateUserStatusCommand = getGaCommandFactory().getUpdateUserStatusCommand(userLogin.get(0), null, userProfileStatus);
			updateUserStatusCommand.execute();			

		} else {
			throw new GAUserProfileNotFoundException(userLogin + " is invalid user ID");
		}

		replyResource.setUpdateGetAccessUserProfileStatusReply(reply);
		return replyResource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.manager.GAUserProfileManager# getAccessUserProfileList (com.chubb.ecom.dgmk.ga.service.GetAccessUserProfileListRequest)
	 */
	@Override
	public GetAccessUserProfileListReply getAccessUserProfileList(GetAccessUserProfileListRequest getAccessUserProfileListRequest)
			throws GAUserProfileRequiredFieldException, GAUserProfileSystemException, GAUserProfileDataException {

		boolean includeAppUserProfInfo = false;

		// construct reply object
		GetAccessUserProfileListReply gaUserProfileListReply = new GetAccessUserProfileListReply();

		// check whether we should also include the Application User Profile info
		if (getAccessUserProfileListRequest.getAdditionalOptionsText() != null) {
			if (getAccessUserProfileListRequest.getAdditionalOptionsText().contains(GAUserProfileServiceConstants.ADD_OPT_INCLUDE_APP_USER_PROFILE)
					|| getAccessUserProfileListRequest.getAdditionalOptionsText().contains(
							GAUserProfileServiceConstants.ADD_OPT_INCLUDE_FULL_USER_PROFILE)) {

				includeAppUserProfInfo = true;
			}
		}

		// iterate though each user profile identifier
		for (UserProfileIdentifier userProfileIdentifier : getAccessUserProfileListRequest.getUserProfileIdentifier()) {

			try {

				// determine the user login
				List<String> userLoginList = determineUserLogin(userProfileIdentifier);

				// iterate though each user login that was found for the user
				for (String userLogin : userLoginList) {

					// construct user profile list output
					GetAccessUserProfileListOutputs getAccessUserProfileListOutput = new GetAccessUserProfileListOutputs();
					getAccessUserProfileListOutput.setUserProfileIdentifier(userProfileIdentifier);

					if (getUserProfileManagerUtil().isUserLoginTaken(userLogin)) {

						// construct user profile object
						UserProfile userProfile = new UserProfile();

						// retrieve user info
						getUserProfileManagerUtil().retrieveUserInfo(userLogin, userProfile, includeAppUserProfInfo);

						if (getAccessUserProfileListRequest.getAdditionalOptionsText() != null) {

							// check whether we should also include the User Authorization info
							if (getAccessUserProfileListRequest.getAdditionalOptionsText().contains(
									GAUserProfileServiceConstants.ADD_OPT_INCLUDE_USER_AUHT)
									|| getAccessUserProfileListRequest.getAdditionalOptionsText().contains(
											GAUserProfileServiceConstants.ADD_OPT_INCLUDE_FULL_USER_PROFILE)) {

								UserAuthorization userAuthorization = new UserAuthorization();
								userAuthorization.setUserAuthorizationTypeName(GAUserProfileServiceConstants.APPLICATION_KEYS_AUTH_TYPE_NAME);
								userAuthorization.setDataSourceName(GAUserProfileServiceConstants.GA_USER_PROFILE_SOURCE_NAME);

								// retrieve producer & sub-producer info
								getUserProfileManagerUtil().retrieveProducerInfo(userLogin, userAuthorization);
								
								// retrieve pas & sub-pas info
								getUserProfileManagerUtil().retrievePasInfo(userLogin, userAuthorization);
								
								// retrieve client info
								getUserProfileManagerUtil().retrieveClientInfo(userLogin, userAuthorization);

								userProfile.getUserAuthorization().add(userAuthorization);

								// retrieve user apps
								getUserProfileManagerUtil().retrieveUserAppsInfo(userLogin, userProfile);
							}

							// check whether we should also include the Access Control Group info
							if (getAccessUserProfileListRequest.getAdditionalOptionsText().contains(
									GAUserProfileServiceConstants.ADD_OPT_INCLUDE_ACCESS_CONTROL_GROUP)
									|| getAccessUserProfileListRequest.getAdditionalOptionsText().contains(
											GAUserProfileServiceConstants.ADD_OPT_INCLUDE_FULL_USER_PROFILE)) {

								// retrieve user roles
								getUserProfileManagerUtil().retrieveUserRolesInfo(userLogin, userProfile);
							}
						}

						getAccessUserProfileListOutput.getUserProfile().add(userProfile);
						gaUserProfileListReply.getGetAccessUserProfileListOutputs().add(getAccessUserProfileListOutput);
					}
				}

			} catch (GAUserProfileNotFoundException ex) {
				getLogger().logInfo("Profile not found, skipping: ", this.getClass().getName(), "getAccessUserProfileList");
			}
		}

		return gaUserProfileListReply;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.manager.GAUserProfileManager# getAccessUserProfile (com.chubb.ecom.dgmk.ga.service.GetAccessUserProfileRequest)
	 */
	@Override
	public GetAccessUserProfileReply getAccessUserProfile(GetAccessUserProfileRequest getAccessUserProfileRequest)
			throws GAUserProfileRequiredFieldException, GAUserProfileSystemException, GAUserProfileDataException, GAUserProfileNotFoundException,
			GAUserProfileMultipleException {

		// construct reply object
		GetAccessUserProfileReply gaUserProfileReply = new GetAccessUserProfileReply();
		StatusInformation statusInfo = new StatusInformation();

		// construct user profile object
		UserProfile userProfile = new UserProfile();
		gaUserProfileReply.setUserProfile(userProfile);

		statusInfo.setStatusCode(GAUserProfileServiceConstants.SUCCESSFUL);

		// determine the user login
		List<String> userLogin = determineUserLogin(getAccessUserProfileRequest.getUserProfileIdentifier());

		// if multiple user logins found, throw an error
		if (userLogin.size() > 1) {
			throw new GAUserProfileMultipleException("Mulitple user IDs found for this user profile identifier");
		}

		if (getUserProfileManagerUtil().isUserLoginTaken(userLogin.get(0))) {

			// retrieve entire user info
			getUserProfileManagerUtil().retrieveEntireUserInfo(userLogin.get(0), gaUserProfileReply.getUserProfile());

		} else {
			throw new GAUserProfileNotFoundException(userLogin + " is invalid user ID");
		}

		return gaUserProfileReply;
	}

	/**
	 * Determine user login (external user id).
	 * 
	 * @param userProfileIdentifier
	 *            the user profile identifier
	 * @return the list of strings for each external user id found
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 * @throws GAUserProfileRequiredFieldException
	 *             the gA user profile required field exception
	 * @throws GAUserProfileNotFoundException
	 *             the gA user profile not found exception
	 * @throws GAUserProfileDataException
	 *             the gA user profile data exception
	 */
	protected List<String> determineUserLogin(UserProfileIdentifier userProfileIdentifier) throws GAUserProfileSystemException,
			GAUserProfileRequiredFieldException, GAUserProfileNotFoundException, GAUserProfileDataException {

		String userLogin = null;
		List<String> userLoginList = new ArrayList<String>();

		try {

			// check if the external user id was provided
			if (StringUtils.isNotEmpty(userProfileIdentifier.getExternalUserId())) {
				
				getLogger().logInfo("External user id was provided, returning user login: " + userProfileIdentifier.getExternalUserId(),
						this.getClass().getName(), "determineUserLogin");
				
				userLogin = userProfileIdentifier.getExternalUserId();
				userLoginList.add(userLogin);
			}

			// otherwise lookup the external user id by PersonGIN
			else if (StringUtils.isNotEmpty(userProfileIdentifier.getPersonGIN())) {
				
				getLogger().logInfo("Searching for user by Person GIN: " + userProfileIdentifier.getPersonGIN(),
						this.getClass().getName(), "determineUserLogin");
				
				userLogin = GAConnectionFactory.getUserAPI().getUserLogin(userProfileIdentifier.getPersonGIN());

				if (StringUtils.isEmpty(userLogin)) {
					throw new GAUserProfileNotFoundException("Could not find user by PersonGIN: " + userProfileIdentifier.getPersonGIN());
				}

				userLoginList.add(userLogin);
			}

			// otherwise lookup the external user id by CommonUserGIN
			else if (StringUtils.isNotEmpty(userProfileIdentifier.getCommonUserGIN())) {

				getLogger().logInfo("Searching for user by Common User GIN: " + userProfileIdentifier.getCommonUserGIN(),
						this.getClass().getName(), "determineUserLogin");
				
				if (getAccessEAO == null) {
					getAccessEAO = GetAccessEAOFactory.jpa.getGetAccessUserProfileEAO(this.em);
				}

				userLoginList = getAccessEAO.lookupUserLoginByCmnUsrGin(userProfileIdentifier.getCommonUserGIN());

				if (userLoginList.isEmpty()) {
					throw new GAUserProfileNotFoundException("Could not find user by CommonUserGIN: " + userProfileIdentifier.getCommonUserGIN());
				}
			}

			// otherwise lookup the external user id by EmailAddress
			else if (StringUtils.isNotEmpty(userProfileIdentifier.getEmailAddress())) {

				getLogger().logInfo("Searching for user by Email Address: " + userProfileIdentifier.getEmailAddress(),
						this.getClass().getName(), "determineUserLogin");
				
				if (getAccessEAO == null) {
					getAccessEAO = GetAccessEAOFactory.jpa.getGetAccessUserProfileEAO(this.em);
				}

				userLoginList = getAccessEAO.lookupUserLoginByEmail(userProfileIdentifier.getEmailAddress());

				if (userLoginList.isEmpty()) {
					throw new GAUserProfileNotFoundException("Could not find user by Email Address: " + userProfileIdentifier.getEmailAddress());
				}

			} else {
				throw new GAUserProfileRequiredFieldException("Missing a required user profile identifier");
			}

		} catch (GAUserProfileDataException ex) {
			ex.printStackTrace();
			getLogger().logSevere("Data Source Exception: " + ex.getMessage(), this.getClass().getName(), "determineUserLogin");
			throw new GAUserProfileDataException("Could not determine user login: " + ex.getMessage());
		} catch (enCommerce.getAccess.API.Connection.ConnectionException ex) {
			ex.printStackTrace();
			getLogger().logSevere("Exception: " + ex.getMessage(), this.getClass().getName(), "determineUserLogin");
			throw new GAUserProfileSystemException("Could not determine user login: " + ex.getMessage());
		} catch (SQLException ex) {
			ex.printStackTrace();
			getLogger().logSevere("Data Source Exception: " + ex.getMessage(), this.getClass().getName(), "determineUserLogin");
			throw new GAUserProfileDataException("Could not determine user login: " + ex.getMessage());
		} catch (InvalidParameterException ex) {
			ex.printStackTrace();
			getLogger().logSevere("Exception: " + ex.getMessage(), this.getClass().getName(), "determineUserLogin");
			throw new GAUserProfileSystemException("Could not determine user login: " + ex.getMessage());
		} catch (DuplicatedRowsException ex) {
			ex.printStackTrace();
			getLogger().logSevere("Data Source Exception: " + ex.getMessage(), this.getClass().getName(), "determineUserLogin");
			throw new GAUserProfileDataException("Could not determine user login: " + ex.getMessage());
		} catch (OtherException ex) {
			ex.printStackTrace();
			getLogger().logSevere("Exception: " + ex.getMessage(), this.getClass().getName(), "determineUserLogin");
			throw new GAUserProfileSystemException("Could not determine user login: " + ex.getMessage());
		}

		return userLoginList;
	}	
	
	/**
	 * Populate update user identifier attributes.
	 *
	 * @param changeGetAccessUserProfileIdentifierRequest the change get access user profile identifier request
	 * @return the hashtable
	 */
	protected Hashtable<String, Object> populateUpdateUserIdentifierAttributes(ChangeGetAccessUserProfileIdentifierRequest changeGetAccessUserProfileIdentifierRequest) {
		Hashtable<String, Object> userAttributes = new Hashtable<String, Object>();

		// REQUIRED ATTRIBUTES - do not allow empty string (delete)
		if (!StringUtils.isEmpty(changeGetAccessUserProfileIdentifierRequest.getNewExternalUserId())) {
			userAttributes.put(GAUserProfileServiceConstants.ATTR_USER_LOGIN, changeGetAccessUserProfileIdentifierRequest.getNewExternalUserId());
		}

		return userAttributes;		
	}
	
	/**
	 * Populate update user identifier plus attributes.
	 *
	 * @param changeGetAccessUserProfileIdentifierRequest the change get access user profile identifier request
	 * @return the hashtable
	 */
	protected Hashtable<String, Object> populateUpdateUserIdentifierPlusAttributes(ChangeGetAccessUserProfileIdentifierRequest changeGetAccessUserProfileIdentifierRequest) throws GAUserProfileFieldFormatException {

		Hashtable<String, Object> userPlusAttributes = new Hashtable<String, Object>();

		// OPTIONAL ATTRIBUTES - allow empty string (delete)
		
		if (changeGetAccessUserProfileIdentifierRequest.getNewUserId() != null) {
			
			// verify that RACF ID is 7 or 8 chars only if a value was provided.  Empty String will not validate and delete
			if(!StringUtils.isBlank(changeGetAccessUserProfileIdentifierRequest.getNewUserId())) {
				if(changeGetAccessUserProfileIdentifierRequest.getNewUserId().length() <7 || changeGetAccessUserProfileIdentifierRequest.getNewUserId().length() >8) {
			
					getLogger().logSevere("Validation Exception: NewUserID (RACFID) length must 7 or 8 characters",
						this.getClass().getName(), "populateUpdateUserIdentifierPlusAttributes");

					throw new GAUserProfileFieldFormatException("NewUserID (RACFID) length must 7 or 8 characters");
				}
			}
			
			userPlusAttributes.put(GAUserProfileServiceConstants.ATTR_RACF_ID, changeGetAccessUserProfileIdentifierRequest.getNewUserId());
		}

		if (changeGetAccessUserProfileIdentifierRequest.getNewCommonUserGIN() != null) {
			userPlusAttributes.put(GAUserProfileServiceConstants.ATTR_CMN_USER_GIN, changeGetAccessUserProfileIdentifierRequest.getNewCommonUserGIN());
		}

		return userPlusAttributes;	
	}	

	/**
	 * Populate update user attributes.
	 * 
	 * @param userProfile
	 *            the user profile
	 * @return the hashtable
	 */
	protected Hashtable<String, Object> populateUpdateUserAttributes(UserProfile userProfile) {

		Hashtable<String, Object> userAttributes = new Hashtable<String, Object>();

		// REQUIRED ATTRIBUTES - do not allow empty string (delete), skip if empty	
		
		if (StringUtils.isNotEmpty(userProfile.getUserProfileStatusCode())) {
			userAttributes.put(GAUserProfileServiceConstants.ATTR_STATUS, userProfile.getUserProfileStatusCode());
		}

		if (StringUtils.isNotEmpty(userProfile.getUser().getUserTypeCode())) {
			userAttributes.put(GAUserProfileServiceConstants.ATTR_PERSON_TYPE_CODE, userProfile.getUser().getUserTypeCode());
		}
		
		if (userProfile.getUser().getIndividualName() != null && !userProfile.getUser().getIndividualName().isEmpty()) {

			if (StringUtils.isNotEmpty(userProfile.getUser().getIndividualName().get(0).getGivenName())) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_FIRST_NAME, userProfile.getUser().getIndividualName().get(0).getGivenName());
			}

			if (StringUtils.isNotEmpty(userProfile.getUser().getIndividualName().get(0).getSurname())) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_LAST_NAME, userProfile.getUser().getIndividualName().get(0).getSurname());
			}
			
			// optional field, can be empty string
			if (userProfile.getUser().getIndividualName().get(0).getMiddleName() != null) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_MIDDLE_INIT, userProfile.getUser().getIndividualName().get(0).getMiddleName());
			}
		}

		if (userProfile.getRegionAndLanguageSettings() != null && !userProfile.getRegionAndLanguageSettings().isEmpty()) {

			if (userProfile.getRegionAndLanguageSettings().get(0) != null) {

				// language code
				if (userProfile.getRegionAndLanguageSettings().get(0).getLanguage() != null
						&& StringUtils.isNotEmpty(userProfile.getRegionAndLanguageSettings().get(0).getLanguage().getSourceSystemLanguageCode())) {

					userAttributes.put(GAUserProfileServiceConstants.ATTR_LOCALE_CODE, userProfile.getRegionAndLanguageSettings().get(0)
							.getLanguage().getSourceSystemLanguageCode());
				}

				// timezone
				if (userProfile.getRegionAndLanguageSettings().get(0).getTimeZone() != null
						&& StringUtils.isNotEmpty(userProfile.getRegionAndLanguageSettings().get(0).getTimeZone().getTimeZoneAbbreviation())) {

					userAttributes.put(GAUserProfileServiceConstants.ATTR_TIME_ZONE, userProfile.getRegionAndLanguageSettings().get(0).getTimeZone()
							.getTimeZoneAbbreviation());
				}
			}
		}

		// OPTIONAL ATTRIBUTES - allow empty string (delete)

		String emailAddress = getUserProfileManagerUtil().getTelecommDeviceValue(userProfile.getUser().getBPTelecommElectronicAddress(),
				GAUserProfileServiceConstants.EMAIL_ADDRESS_COMM_DEVICE_CODE);
		if (emailAddress != null) {
			userAttributes.put(GAUserProfileServiceConstants.ATTR_EMAIL, emailAddress);
		}

		String phone = getUserProfileManagerUtil().getTelecommDeviceValue(userProfile.getUser().getBPTelecommElectronicAddress(),
				GAUserProfileServiceConstants.TELEPHONE_COMM_DEVICE_CODE);
		if (phone != null) {
			userAttributes.put(GAUserProfileServiceConstants.ATTR_PHONE, phone);
		}

		if (userProfile.getUser().getBusinessName() != null) {
			userAttributes.put(GAUserProfileServiceConstants.ATTR_CHAR1, userProfile.getUser().getBusinessName());
		}

		StandardizedAddress mailingAddress = getUserProfileManagerUtil().getMailingAddress(userProfile.getUser().getBPTypedAddress());

		if (mailingAddress != null) {

			if (mailingAddress.getAddressLine1() != null) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_ADDRESS1, mailingAddress.getAddressLine1());
			}
			if (mailingAddress.getAddressLine2() != null) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_ADDRESS2, mailingAddress.getAddressLine2());
			}
			if (mailingAddress.getCityName() != null) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_CITY, mailingAddress.getCityName());
			}
			if (mailingAddress.getStateOrProvinceName() != null) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_STATE, mailingAddress.getStateOrProvinceName());
			}
			if (mailingAddress.getPostalCode() != null) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_ZIP, mailingAddress.getPostalCode());
			}
			if (mailingAddress.getCountryName() != null) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_COUNTRY, mailingAddress.getCountryName());
			}
		}

		// delegation code
		if (userProfile.getApplicationUserProfile() != null && !userProfile.getApplicationUserProfile().isEmpty()) {

			String delegationCode = getUserProfileManagerUtil().getAppUserProfileValue(
					userProfile.getApplicationUserProfile().get(0).getApplicationUserProfileProperty(),
					GAUserProfileServiceConstants.DELEGATION_CODE_PROPERTY);

			if (delegationCode != null) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_DELEGATION_CODE, delegationCode);
			}
		}

		return userAttributes;
	}

	/**
	 * Populate user attributes.
	 * 
	 * @param userProfile
	 *            the user profile
	 * @return the hashtable
	 * @throws GAUserProfileRequiredFieldException
	 *             the gA user profile required field exception
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	protected Hashtable<String, Object> populateCreateUserAttributes(UserProfile userProfile) throws GAUserProfileRequiredFieldException,
			GAUserProfileSystemException {

		Hashtable<String, Object> userAttributes = new Hashtable<String, Object>();

		// REQUIRED ATTRIBUTES
		String emailAddress = getUserProfileManagerUtil().getTelecommDeviceValue(userProfile.getUser().getBPTelecommElectronicAddress(),
				GAUserProfileServiceConstants.EMAIL_ADDRESS_COMM_DEVICE_CODE);

		if (StringUtils.isEmpty(emailAddress)) {

			getLogger().logSevere("Exception: email address is required", this.getClass().getName(), "populateCreateUserAttributes");
			throw new GAUserProfileRequiredFieldException("email address is required");
		}

		userAttributes.put(GAUserProfileServiceConstants.ATTR_EMAIL, emailAddress);

		String userLogin = "";

		// check if the external user id was provided (to handle clients where this was predefined)
		if (StringUtils.isNotEmpty(userProfile.getExternalUserId())) {
			userLogin = userProfile.getExternalUserId();

		} else {
			// generate unique user login (external user id)
			userLogin = getUserProfileManagerUtil().generateUserLogin(emailAddress);
		}

		// default to ACTIVE if status was not provided
		if (StringUtils.isEmpty(userProfile.getUserProfileStatusCode())) {
			userAttributes.put(GAUserProfileServiceConstants.ATTR_STATUS, GAUserProfileServiceConstants.ACTIVE_STATUS);
		} else {
			userAttributes.put(GAUserProfileServiceConstants.ATTR_STATUS, userProfile.getUserProfileStatusCode());
		}

		userAttributes.put(GAUserProfileServiceConstants.ATTR_USER_LOGIN, userLogin);

		// required user type code
		if (StringUtils.isNotEmpty(userProfile.getUser().getUserTypeCode())) {
			userAttributes.put(GAUserProfileServiceConstants.ATTR_PERSON_TYPE_CODE, userProfile.getUser().getUserTypeCode());
		} else {
			throw new GAUserProfileRequiredFieldException("User type code is required");
		}

		// required first name
		if (StringUtils.isNotEmpty(userProfile.getUser().getIndividualName().get(0).getGivenName())) {
			userAttributes.put(GAUserProfileServiceConstants.ATTR_FIRST_NAME, userProfile.getUser().getIndividualName().get(0).getGivenName());
		} else {
			throw new GAUserProfileRequiredFieldException("User first name is required");
		}

		// required last name
		if (StringUtils.isNotEmpty(userProfile.getUser().getIndividualName().get(0).getSurname())) {
			userAttributes.put(GAUserProfileServiceConstants.ATTR_LAST_NAME, userProfile.getUser().getIndividualName().get(0).getSurname());
		} else {
			throw new GAUserProfileRequiredFieldException("User last name is required");
		}

		// set default values
		userAttributes.put(GAUserProfileServiceConstants.ATTR_LOCALE_CODE, GAUserProfileServiceConstants.ATTR_LOCALE_CODE_DEFAULT);
		userAttributes.put(GAUserProfileServiceConstants.ATTR_DATE_CODE, GAUserProfileServiceConstants.ATTR_DATE_CODE_DEFAULT);
		userAttributes.put(GAUserProfileServiceConstants.ATTR_TIME_ZONE, GAUserProfileServiceConstants.ATTR_TIME_ZONE_DEFAULT);

		if (userProfile.getRegionAndLanguageSettings() != null && !userProfile.getRegionAndLanguageSettings().isEmpty()) {

			if (userProfile.getRegionAndLanguageSettings().get(0) != null) {

				// language code
				if (userProfile.getRegionAndLanguageSettings().get(0).getLanguage() != null
						&& StringUtils.isNotEmpty(userProfile.getRegionAndLanguageSettings().get(0).getLanguage().getSourceSystemLanguageCode())) {

					userAttributes.put(GAUserProfileServiceConstants.ATTR_LOCALE_CODE, userProfile.getRegionAndLanguageSettings().get(0)
							.getLanguage().getSourceSystemLanguageCode());
				}

				// timezone
				if (userProfile.getRegionAndLanguageSettings().get(0).getTimeZone() != null
						&& StringUtils.isNotEmpty(userProfile.getRegionAndLanguageSettings().get(0).getTimeZone().getTimeZoneAbbreviation())) {

					userAttributes.put(GAUserProfileServiceConstants.ATTR_TIME_ZONE, userProfile.getRegionAndLanguageSettings().get(0).getTimeZone()
							.getTimeZoneAbbreviation());
				}
			}
		}

		// OPTIONAL ATTRIBUTES
		String phone = getUserProfileManagerUtil().getTelecommDeviceValue(userProfile.getUser().getBPTelecommElectronicAddress(),
				GAUserProfileServiceConstants.TELEPHONE_COMM_DEVICE_CODE);
		if (StringUtils.isNotEmpty(phone)) {
			userAttributes.put(GAUserProfileServiceConstants.ATTR_PHONE, phone);
		}

		if (StringUtils.isNotEmpty(userProfile.getUser().getBusinessName())) {
			userAttributes.put(GAUserProfileServiceConstants.ATTR_CHAR1, userProfile.getUser().getBusinessName());
		}

		if (StringUtils.isNotEmpty(userProfile.getUser().getIndividualName().get(0).getMiddleName())) {
			userAttributes.put(GAUserProfileServiceConstants.ATTR_MIDDLE_INIT, userProfile.getUser().getIndividualName().get(0).getMiddleName());
		}

		StandardizedAddress mailingAddress = getUserProfileManagerUtil().getMailingAddress(userProfile.getUser().getBPTypedAddress());

		if (mailingAddress != null) {

			if (StringUtils.isNotEmpty(mailingAddress.getAddressLine1())) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_ADDRESS1, mailingAddress.getAddressLine1());
			}
			if (StringUtils.isNotEmpty(mailingAddress.getAddressLine2())) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_ADDRESS2, mailingAddress.getAddressLine2());
			}
			if (StringUtils.isNotEmpty(mailingAddress.getCityName())) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_CITY, mailingAddress.getCityName());
			}
			if (StringUtils.isNotEmpty(mailingAddress.getStateOrProvinceName())) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_STATE, mailingAddress.getStateOrProvinceName());
			}
			if (StringUtils.isNotEmpty(mailingAddress.getPostalCode())) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_ZIP, mailingAddress.getPostalCode());
			}
			if (StringUtils.isNotEmpty(mailingAddress.getCountryName())) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_COUNTRY, mailingAddress.getCountryName());
			}
		}

		// delegation code
		if (userProfile.getApplicationUserProfile() != null && !userProfile.getApplicationUserProfile().isEmpty()) {

			String delegationCode = getUserProfileManagerUtil().getAppUserProfileValue(
					userProfile.getApplicationUserProfile().get(0).getApplicationUserProfileProperty(),
					GAUserProfileServiceConstants.DELEGATION_CODE_PROPERTY);

			if (StringUtils.isNotEmpty(delegationCode)) {
				userAttributes.put(GAUserProfileServiceConstants.ATTR_DELEGATION_CODE, delegationCode);
			}
		}

		return userAttributes;
	}

	/**
	 * Checks if is existing email address.
	 * 
	 * @param emailAddress
	 *            the email address
	 * @return true, if the email is already taken
	 * @throws GAUserProfileDataException
	 *             the gA user profile data exception
	 */
	protected boolean isEmailTaken(String emailAddress) throws GAUserProfileDataException {

		List<String> existingUsers = new ArrayList<String>();

		try {
			existingUsers = getGetAccessEAO().lookupUserLoginByEmail(emailAddress);

		} catch (GAUserProfileDataException ex) {
			getLogger().logSevere("Problem checking if email is taken: " + ex.getMessage(), this.getClass().getName(), "isEmailTaken");
			throw new GAUserProfileDataException("Problem checking if email is taken: " + ex.getMessage());
		}

		if (existingUsers.isEmpty()) {
			return false;

		} else {
			return true;
		}
	}

	/**
	 * Validate roles.
	 * 
	 * @param accessControlGroupList
	 *            the access control group list
	 * @throws GAUserProfileDataException
	 *             the GA user profile data exception
	 * @throws GAUserProfileFieldFormatException
	 *             the gA user profile field format exception
	 */
	public void validateRoles(List<AccessControlGroup> accessControlGroupList) throws GAUserProfileDataException, GAUserProfileFieldFormatException {

		try {

			for (AccessControlGroup accessControlGroup : accessControlGroupList) {
				getLogger().logInfo("Validating requested role: "+accessControlGroup.getAccessControlGroupCategoryCode() +"|"+
						accessControlGroup.getAccessControlGroupCode(), this.getClass().getName(), "validateRoles");
				
				getGetAccessEAO().findRoleByCode(accessControlGroup.getAccessControlGroupCategoryCode(),
						accessControlGroup.getAccessControlGroupCode());
			}

		} catch (GAUserProfileDataNotFoundException ex) {
			getLogger().logSevere("Invalid role: " + ex.getMessage(), this.getClass().getName(), "validateRoles");
			throw new GAUserProfileFieldFormatException("Invalid role: " + ex.getMessage());

		} catch (GAUserProfileDataException ex) {
			getLogger().logSevere("Problem validating roles: " + ex.getMessage(), this.getClass().getName(), "validateRoles");
			throw new GAUserProfileDataException("Problem checking if email is taken: " + ex.getMessage());
		}
	}

	/**
	 * Populate create user plus attributes.
	 * 
	 * @param userProfile
	 *            the user profile
	 * @return the hashtable
	 * @throws GAUserProfileRequiredFieldException
	 *             the gA user profile required field exception
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 * @throws GAUserProfileFieldFormatException
	 *             the gA user profile field format exception
	 */
	protected Hashtable<String, Object> populateCreateUserPlusAttributes(UserProfile userProfile) throws GAUserProfileRequiredFieldException,
			GAUserProfileSystemException, GAUserProfileFieldFormatException {

		Hashtable<String, Object> userPlusAttributes = new Hashtable<String, Object>();

		// OPTIONAL FIELDS

		if (StringUtils.isNotEmpty(userProfile.getUser().getUserOrganizationRoleName())) {
			userPlusAttributes.put(GAUserProfileServiceConstants.ATTR_ORG_ROLE_NAME, userProfile.getUser().getUserOrganizationRoleName());
		}

		if (StringUtils.isNotEmpty(userProfile.getUser().getUserId())) {
			
			// verify that RACF ID is 7 or 8 chars
			if(userProfile.getUser().getUserId().length() <7 || userProfile.getUser().getUserId().length() >8) {
				getLogger().logSevere("Validation Exception: User.UserID (RACFID) length must 7 or 8 characters",
						this.getClass().getName(), "populateCreateUserPlusAttributes");

				throw new GAUserProfileFieldFormatException("User.UserID (RACFID) length must 7 or 8 characters");
			}
			
			userPlusAttributes.put(GAUserProfileServiceConstants.ATTR_RACF_ID, userProfile.getUser().getUserId());
		}

		if (StringUtils.isNotEmpty(userProfile.getCommonUserGIN())) {
			userPlusAttributes.put(GAUserProfileServiceConstants.ATTR_CMN_USER_GIN, userProfile.getCommonUserGIN());
		}

		if (!userProfile.getApplicationUserProfile().isEmpty()) {

			// preferred producer
			String prefProducer = getUserProfileManagerUtil().getAppUserProfileValue(
					userProfile.getApplicationUserProfile().get(0).getApplicationUserProfileProperty(),
					GAUserProfileServiceConstants.PREF_PRODUCER_PROPERTY);

			// preferred producer sub
			String prefProducerSub = getUserProfileManagerUtil().getAppUserProfileValue(
					userProfile.getApplicationUserProfile().get(0).getApplicationUserProfileProperty(),
					GAUserProfileServiceConstants.PREF_PRODUCER_SUB_PROPERTY);

			String prefProducerSubCombo = null;

			if (StringUtils.isNotEmpty(prefProducer) && StringUtils.isNotEmpty(prefProducerSub)) {

				prefProducerSubCombo = prefProducer + prefProducerSub;

				if (prefProducerSubCombo.length() != 12) {

					getLogger().logSevere("Validation Exception: Prefered Producer & Sub combined length must equal 12 characters",
							this.getClass().getName(), "populateCreateUserPlusAttributes");

					throw new GAUserProfileFieldFormatException("Prefered Producer & Sub combined length must equal 12 characters");

				} else {
					userPlusAttributes.put(GAUserProfileServiceConstants.ATTR_PREF_PRODUCER_NUMBER, prefProducerSubCombo);
				}
			}
		}

		return userPlusAttributes;
	}

	/**
	 * Populate update user plus attributes.
	 * 
	 * @param userProfile
	 *            the user profile
	 * @return the hashtable
	 * @throws GAUserProfileFieldFormatException
	 *             the gA user profile field format exception
	 * @throws GAUserProfileRollbackSuccessfulException 
	 */
	protected Hashtable<String, Object> populateUpdateUserPlusAttributes(UserProfile userProfile) throws GAUserProfileFieldFormatException, GAUserProfileRollbackSuccessfulException {

		Hashtable<String, Object> userPlusAttributes = new Hashtable<String, Object>();

		// OPTIONAL ATTRIBUTES - allow empty string (delete)

		if (userProfile.getUser().getUserOrganizationRoleName() != null) {
			userPlusAttributes.put(GAUserProfileServiceConstants.ATTR_ORG_ROLE_NAME, userProfile.getUser().getUserOrganizationRoleName());
		}

		if (userProfile.getUser().getUserId() != null) {
			
			// verify that RACF ID is 7 or 8 chars only if a value was provided.  Empty String will not validate and delete
			if(userProfile.getUser().getUserId() != "") {
				if(userProfile.getUser().getUserId().length() <7 || userProfile.getUser().getUserId().length() >8) {
			
					getLogger().logSevere("Validation Exception: User.UserID (RACFID) length must 7 or 8 characters",
						this.getClass().getName(), "populateUpdateUserPlusAttributes");

					throw new GAUserProfileFieldFormatException("User.UserID (RACFID) length must 7 or 8 characters");
				}
			}
			
			userPlusAttributes.put(GAUserProfileServiceConstants.ATTR_RACF_ID, userProfile.getUser().getUserId());
		}

		if (userProfile.getCommonUserGIN() != null) {
			userPlusAttributes.put(GAUserProfileServiceConstants.ATTR_CMN_USER_GIN, userProfile.getCommonUserGIN());
		}

		if (!userProfile.getApplicationUserProfile().isEmpty()) {

			// preferred producer
			String prefProducer = getUserProfileManagerUtil().getAppUserProfileValue(
					userProfile.getApplicationUserProfile().get(0).getApplicationUserProfileProperty(),
					GAUserProfileServiceConstants.PREF_PRODUCER_PROPERTY);

			// preferred producer sub
			String prefProducerSub = getUserProfileManagerUtil().getAppUserProfileValue(
					userProfile.getApplicationUserProfile().get(0).getApplicationUserProfileProperty(),
					GAUserProfileServiceConstants.PREF_PRODUCER_SUB_PROPERTY);

			if (prefProducer != null && prefProducerSub != null) {

				String prefProducerSubCombo = prefProducer + prefProducerSub; // can be empty ""

				// check length if not empty
				if (prefProducerSubCombo.length() > 0 && prefProducerSubCombo.length() != 12) {

					getLogger().logInfo("Validation Exception: Prefered Producer & Sub combined length must equal 12 characters",
							this.getClass().getName(), "populateUpdateUserPlusAttributes");
					throw new GAUserProfileFieldFormatException("Prefered Producer & Sub combined length must equal 12 characters");

				} else {
					userPlusAttributes.put(GAUserProfileServiceConstants.ATTR_PREF_PRODUCER_NUMBER, prefProducerSubCombo);
				}
			}
					}
		/** Changes made for retrieving new Fields meant for SSO **/
		if(!userProfile.getSourceSystemUserProfileId().isEmpty() && userProfile.getSourceSystemUserProfileId().size()>0){
		List<SourceSystemUserProfileId> srcSystem = userProfile
				.getSourceSystemUserProfileId();
		
		for (SourceSystemUserProfileId sourceSystem : srcSystem) {
			//if (validateDomain(userProfile)) {
				if (sourceSystem.getUserProfileSourceSystemName()!=null && !sourceSystem.getUserProfileSourceSystemName().isEmpty()) {
					userPlusAttributes.put(GAUserProfilePropertiesUtil
							.getGacol(sourceSystem
									.getUserProfileSourceSystemName()),
							sourceSystem.getSourceSystemUserProfileId());
				}
			 else {
				getLogger().logSevere(
						"No Matching UserProfileSourceSystemName in request",
						this.getClass().getName(),
						"populateUpdateUserPlusAttributes");
				throw new GAUserProfileRollbackSuccessfulException();

			}
		}
		getLogger().logInfo(
				"UserPlus updated Successfully with SourceSystemUserProfileId",
				this.getClass().getName(), "populateUpdateUserPlusAttributes");
		}
		

		/** Changes made for retrieving new Fields meant for SSO **/


		return userPlusAttributes;
	}
	
	/**
	 * Validate the Domain Name User Profile
	 * 
	 * @return boolean
	 */

	protected boolean validateDomain(UserProfile userProfile) {
		List<SourceSystemUserProfileId> domainList = userProfile
				.getSourceSystemUserProfileId();
		boolean domain = true;
		if(!domainList.isEmpty() && domainList.size()>0){
		for (SourceSystemUserProfileId temp : domainList) {
			if (GAUserProfilePropertiesUtil.getAppNames().contains(
					temp.getUserProfileSourceSystemName())) {
				getLogger().logInfo("valid Domain found in User's Profile", this.getClass().getName(), "validateDomain");
			} else {
				domain = false;
				return domain;
				
			}
		}
		}
		
		return domain;
	}

	/**
	 * Reset user agreement user plus attributes.
	 *
	 * @return the hashtable
	 */
	protected Hashtable<String, Object> resetUserAgreementUserPlusAttributes() {

		Hashtable<String, Object> userPlusAttributes = new Hashtable<String, Object>();

		// empty the UserAgreement user plus attributes
		userPlusAttributes.put("CHAR11", "");
		userPlusAttributes.put("CHAR12", "");
		userPlusAttributes.put("CHAR13", "");
		userPlusAttributes.put("CHAR14", "");
		userPlusAttributes.put("CHAR15", "");
		
		return userPlusAttributes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.manager.GAUserProfileManager#restoreUserProfile(com.chubb.ecom.dgmk.ga.domain.resource.UserSnapshotResource,
	 * com.chubb.ecom.dgmk.ga.domain.resource.UserUpdateRequestResource, java.lang.String)
	 */
	public void restoreUserProfile(UserSnapshotResource userSnapshot, String personGIN, UserUpdateRequestResource userUpdateRequest, String adminUser)
			throws GAUserProfileRequiredFieldException, GAUserProfileFieldFormatException, GAUserProfileSystemException,
			GAUserProfileSyntheticTestException, GAUserProfileDataException, GAUserProfileAuthenticationException {

		getLogger().logInfo("restore user profile requested", this.getClass().getName(), "restoreUserProfile");

		// populate the user attributes
		Hashtable<String, Object> userAttributes = populateUpdateUserAttributes(userSnapshot.getOriginalUserProfile());

		// populate user plus attributes (The user plus update is the final step and would not have made the transaction so rollback not required)
		// Hashtable<String, Object> userPlusAttributes = populateUpdateUserPlusAttributes(userSnapshot.getOriginalUserProfile());

		// overwrite request data object with the original (userAttributes)
		userUpdateRequest.setUserAttributes(userAttributes);

		GACommand updateUserCommand = getGaCommandFactory().getUpdateUserCommand(adminUser, personGIN, userUpdateRequest, userSnapshot);
		updateUserCommand.execute();

		try {

			// lookup current roles
			String currentRoles = getUserProfileManagerUtil().getRoles(userSnapshot.getOriginalUserLogin());

			// the update roles request
			Map<String, List<AccessControlGroup>> rolesActionMap = userUpdateRequest.getRolesActionMap();

			if (rolesActionMap != null) {

				// DELETE any roles which may have been ADDED
				if (!rolesActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE).isEmpty()) {

					List<AccessControlGroup> deleteRolesList = new ArrayList<AccessControlGroup>();

					for (AccessControlGroup addedRole : rolesActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE)) {

						if (currentRoles.contains(addedRole.getAccessControlGroupCategoryCode() + "." + addedRole.getAccessControlGroupCode())) {
							deleteRolesList.add(addedRole);
						}
					}

					if (!deleteRolesList.isEmpty()) {
						GACommand deleteUserRolesCommand = getGaCommandFactory().getDeleteUserRolesCommand(deleteRolesList,
								userSnapshot.getOriginalUserLogin(), userSnapshot.getOriginalPersonGIN(), adminUser);

						deleteUserRolesCommand.execute();
					}
				}

				// ADD any roles which may have been DELETED
				if (!rolesActionMap.get(GAUserProfileServiceConstants.DELETE_ACTION_CODE).isEmpty()) {

					List<AccessControlGroup> addRolesList = new ArrayList<AccessControlGroup>();

					for (AccessControlGroup deletedRole : rolesActionMap.get(GAUserProfileServiceConstants.DELETE_ACTION_CODE)) {

						if (!currentRoles.contains(deletedRole.getAccessControlGroupCategoryCode() + "." + deletedRole.getAccessControlGroupCode())) {
							addRolesList.add(deletedRole);
						}
					}

					if (!addRolesList.isEmpty()) {
						GACommand createUserRolesCommand = getGaCommandFactory().getCreateUserRolesCommand(addRolesList,
								userSnapshot.getOriginalUserLogin(), adminUser);

						createUserRolesCommand.execute();
					}
				}

				// UPDATE to original any roles which may have been UPDATED
				if (!rolesActionMap.get(GAUserProfileServiceConstants.UPDATE_ACTION_CODE).isEmpty()) {

					List<AccessControlGroup> updateRolesList = new ArrayList<AccessControlGroup>();

					for (AccessControlGroup updatedRole : rolesActionMap.get(GAUserProfileServiceConstants.UPDATE_ACTION_CODE)) {

						if (currentRoles.contains(updatedRole.getAccessControlGroupCategoryCode() + "." + updatedRole.getAccessControlGroupCode())) {

							// find the original user role
							for (AccessControlGroup originalUserRole : userSnapshot.getOriginalUserProfile().getAccessControlGroup()) {

								if ((originalUserRole.getAccessControlGroupCategoryCode() + "." + originalUserRole.getAccessControlGroupCode())
										.equals(updatedRole.getAccessControlGroupCategoryCode() + "." + updatedRole.getAccessControlGroupCode())) {

									updateRolesList.add(originalUserRole);
								}
							}
						}
					}

					if (!updateRolesList.isEmpty()) {
						GACommand updateUserRolesCommand = getGaCommandFactory().getUpdateUserRolesCommand(updateRolesList,
								userSnapshot.getOriginalUserLogin(), adminUser);

						updateUserRolesCommand.execute();
					}
				}
			}

			// lookup current application keys
			UserProfile currentUser = new UserProfile();

			UserAuthorization userAuthorization = new UserAuthorization();
			userAuthorization.setUserAuthorizationTypeName(GAUserProfileServiceConstants.APPLICATION_KEYS_AUTH_TYPE_NAME);
			userAuthorization.setDataSourceName(GAUserProfileServiceConstants.GA_USER_PROFILE_SOURCE_NAME);

			// producer-sub, client info
			getUserProfileManagerUtil().retrieveProducerInfo(userSnapshot.getOriginalUserLogin(), userAuthorization);
			//pas client info
			getUserProfileManagerUtil().retrievePasInfo(userSnapshot.getOriginalUserLogin(), userAuthorization);
			getUserProfileManagerUtil().retrieveClientInfo(userSnapshot.getOriginalUserLogin(), userAuthorization);

			currentUser.getUserAuthorization().add(userAuthorization);

			// all current user application keys
			Map<String, List<String>> currentAppKeysValueMap = getUserProfileManagerUtil().getAllAppKeyValues(currentUser.getUserAuthorization());

			// the update application keys request
			Map<String, List<AccessAttribute>> applicationKeysActionMap = userUpdateRequest.getApplicationKeysActionMap();

			if (applicationKeysActionMap != null) {

				// DELETE any application keys (producer-sub, client) which may have been ADDED
				if (!applicationKeysActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE).isEmpty()) {

					List<AccessAttribute> deleteAppKeysList = new ArrayList<AccessAttribute>();

					for (AccessAttribute addedAppKey : applicationKeysActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE)) {

						List<String> currentAppKeysValues = new ArrayList<String>();

						if (GAUserProfileServiceConstants.PRODUCER_SUB_KEY_ATTR.equals(addedAppKey.getAccessAttributeName())) {
							currentAppKeysValues = currentAppKeysValueMap.get(GAUserProfileServiceConstants.PRODUCER_SOURCE_SYSTEM_ID);
						}  else if (GAUserProfileServiceConstants.PAS_SUB_KEY_ATTR.equals(addedAppKey.getAccessAttributeName())) {
							currentAppKeysValues = currentAppKeysValueMap.get(GAUserProfileServiceConstants.PAS_SOURCE_SYSTEM_ID);
						}else if (GAUserProfileServiceConstants.CLIENT_NUMBER_ATTR.equals(addedAppKey.getAccessAttributeName())) {
							currentAppKeysValues = currentAppKeysValueMap.get(GAUserProfileServiceConstants.PRODUCER_SOURCE_SYSTEM_ID);
						}

						for (String accessAttributeValue : addedAppKey.getAccessAttributeValue()) {
							if (currentAppKeysValues.contains(accessAttributeValue)) {
								deleteAppKeysList.add(addedAppKey);
							}
						}
					}

					if (!deleteAppKeysList.isEmpty()) {
						GACommand deleteUserAppKeysCommand = getGaCommandFactory().getDeleteUserAppKeysCommand(deleteAppKeysList,
								userSnapshot.getOriginalUserLogin(), adminUser);

						deleteUserAppKeysCommand.execute();
					}
				}

				// ADD any application keys (producer-sub, client) which may have been DELETED
				if (!applicationKeysActionMap.get(GAUserProfileServiceConstants.DELETE_ACTION_CODE).isEmpty()) {

					List<AccessAttribute> addAppKeysList = new ArrayList<AccessAttribute>();

					for (AccessAttribute deletedAppKey : applicationKeysActionMap.get(GAUserProfileServiceConstants.DELETE_ACTION_CODE)) {

						List<String> currentAppKeysValues = new ArrayList<String>();

						if (GAUserProfileServiceConstants.PRODUCER_SUB_KEY_ATTR.equals(deletedAppKey.getAccessAttributeName())) {
							currentAppKeysValues = currentAppKeysValueMap.get(GAUserProfileServiceConstants.PRODUCER_SOURCE_SYSTEM_ID);
						}else if (GAUserProfileServiceConstants.PAS_SUB_KEY_ATTR.equals(deletedAppKey.getAccessAttributeName())) {
							currentAppKeysValues = currentAppKeysValueMap.get(GAUserProfileServiceConstants.PAS_SOURCE_SYSTEM_ID);
						} else if (GAUserProfileServiceConstants.CLIENT_NUMBER_ATTR.equals(deletedAppKey.getAccessAttributeName())) {
							currentAppKeysValues = currentAppKeysValueMap.get(GAUserProfileServiceConstants.PRODUCER_SOURCE_SYSTEM_ID);
						}

						for (String accessAttributeValue : deletedAppKey.getAccessAttributeValue()) {
							if (!currentAppKeysValues.contains(accessAttributeValue)) {
								addAppKeysList.add(deletedAppKey);
							}
						}
					}

					if (!addAppKeysList.isEmpty()) {
						GACommand createUserAppKeysCommand = getGaCommandFactory().getCreateUserAppKeysCommand(addAppKeysList,
								userSnapshot.getOriginalUserLogin(), adminUser);

						createUserAppKeysCommand.execute();
					}
				}
			}

			// restore the original user plus data - (The user plus update would not have made the transaction so rollback not required)
			// GACommand updateUserPlusCommand = getGaCommandFactory().getUpdateUserPlusCommand(userSnapshot.getOriginalPersonGIN(), userPlusAttributes);
			// updateUserPlusCommand.execute();

		} catch (GAUserProfileAuthenticationException ex) {
			getLogger().logSevere("Authentication Exception: " + ex.getMessage(), this.getClass().getName(), "restoreUserProfile");

			throw ex;
		} catch (GAUserProfileSystemException ex) {
			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "restoreUserProfile");

			throw ex;
		}
	}

	/**
	 * Sets the gets the access eao.
	 * 
	 * @param getAccessEAO
	 *            the new gets the access eao
	 */
	public void setGetAccessEAO(GetAccessUserProfileEAO getAccessEAO) {
		this.getAccessEAO = getAccessEAO;
	}

	/**
	 * Gets the default GA EAO if object is not set by IOC framework
	 * 
	 * @return the GA EAO
	 */
	public GetAccessUserProfileEAO getGetAccessEAO() {
		if (getAccessEAO == null) {
			getAccessEAO = GetAccessEAOFactory.jpa.getGetAccessUserProfileEAO(this.em);
		}
		return getAccessEAO;
	}

	/**
	 * Sets the user profile manager util.
	 * 
	 * @param userProfileManagerUtil
	 *            the new user profile manager util
	 */
	public void setUserProfileManagerUtil(GAUserProfileManagerUtil userProfileManagerUtil) {
		this.userProfileManagerUtil = userProfileManagerUtil;
	}

	/**
	 * Gets the default user profile manager util if object is not set by IOC framework
	 * 
	 * @return the user profile manager util
	 */
	public GAUserProfileManagerUtil getUserProfileManagerUtil() {
		if (userProfileManagerUtil == null) {
			userProfileManagerUtil = new GAUserProfileManagerUtil();
		}
		return userProfileManagerUtil;
	}

	/**
	 * Sets the ga command factory.
	 * 
	 * @param gaCommandFactory
	 *            the new ga command factory
	 */
	public void setGaCommandFactory(GACommandFactory gaCommandFactory) {
		this.gaCommandFactory = gaCommandFactory;
	}

	/**
	 * Gets the default GA Command Factory if object is not set by IOC framework
	 * 
	 * @return the GA Command Factory
	 */
	public GACommandFactory getGaCommandFactory() {
		if (gaCommandFactory == null) {
			gaCommandFactory = new GACommandFactoryImpl();
		}
		return gaCommandFactory;
	}

	/**
	 * Sets the logger.
	 * 
	 * @param logger
	 *            the new logger
	 */
	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	/**
	 * Gets the default logger if object is not set by IOC framework
	 * 
	 * @return the logger
	 */
	public ILogger getLogger() {
		if (logger == null) {
			logger = GAUserProfileLoggerImpl.getLogger();
		}
		return logger;
	}

}
