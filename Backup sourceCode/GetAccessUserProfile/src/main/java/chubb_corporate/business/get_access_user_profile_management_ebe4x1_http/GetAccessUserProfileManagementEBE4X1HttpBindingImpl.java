package chubb_corporate.business.get_access_user_profile_management_ebe4x1_http;

import org.apache.commons.lang.StringUtils;

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
import chubb_corporate.get_access.error_information.ErrorInformation;
import chubb_corporate.get_access.simple_fault.SimpleFault;
import chubb_corporate.get_access.status_information.StatusInformation;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.domain.manager.GAUserProfileManager;
import com.chubb.ecom.dgmk.ga.domain.resource.AddGetAccessUserProfileReplyResource;
import com.chubb.ecom.dgmk.ga.domain.resource.ResetGetAccessUserPasswordResource;
import com.chubb.ecom.dgmk.ga.domain.resource.UpdateGetAccessUserProfileStatusResource;
import com.chubb.ecom.dgmk.ga.domain.util.GAUserProfileManagerUtil;
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
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;
import com.chubb.ecom.dgmk.ga.model.UserCredential;
import com.chubb.ecom.dgmk.ga.util.GAUserProfileServiceConstants;

import com.ibm.ws.util.Base64;

@javax.jws.WebService(endpointInterface = "chubb_corporate.business.get_access_user_profile_management_ebe4x1_http.GetAccessUserProfileManagementEBE4X1", targetNamespace = "http://chubb_corporate/business/get_access_user_profile_management_ebe4x1_http", serviceName = "GetAccessUserProfileManagementEBE4X1HttpService", portName = "GetAccessUserProfileManagementEBE4X1HTTP_GetAccessUserProfileManagementEBE4X1HttpPort")
public class GetAccessUserProfileManagementEBE4X1HttpBindingImpl {

	/** The logger. This should be injected by IOC framework */
	private ILogger logger;

	/** The GA Manager. This should be injected by IOC framework */
	private GAUserProfileManager gaUserProfileManager;

	@javax.annotation.Resource
	private javax.xml.ws.WebServiceContext wscxt;

	/**
	 * Instantiates a new get access user profile management ws impl
	 */
	public GetAccessUserProfileManagementEBE4X1HttpBindingImpl() throws GAUserProfileSystemException {

		// get the default manager if object is not set by IOC framework
		if (gaUserProfileManager == null) {

			try {
				gaUserProfileManager = GAUserProfileManagerUtil.getUserProfileManagerServiceLocal();

			} catch (GAUserProfileSystemException ex) {

				getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "addGetAccessUserProfile");

				String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_SYSTEM;
				String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
				String errorDescription = GAUserProfileServiceConstants.ERROR_SYSTEM_MANAGEMENT + " | Additional Info: " + ex.getMessage();
				String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

				SimpleFault faultInfo = new SimpleFault();
				faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
						+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

				throw ex;
			}
		}
	}

	/**
	 * Adds the get access user profile.
	 * 
	 * @param addGetAccessUserProfileRequest
	 *            the add get access user profile request
	 * @return the adds the get access user profile reply
	 * @throws AddGetAccessUserProfileSimpleFaultReplyMsg
	 *             the add get access user profile simple fault reply msg
	 */
	public AddGetAccessUserProfileReply addGetAccessUserProfile(AddGetAccessUserProfileRequest addGetAccessUserProfileRequest)
			throws AddGetAccessUserProfileSimpleFaultReplyMsg {

		AddGetAccessUserProfileReply reply = new AddGetAccessUserProfileReply();

		StatusInformation statusInfo = new StatusInformation();
		statusInfo.setStatusCode(GAUserProfileServiceConstants.SUCCESSFUL);

		getLogger().logInfo("GetAccess EBE4X1 Service called operation: addGetAccessUserProfile", this.getClass().getName(),
				"addGetAccessUserProfile");

		try {

			// check for synthetic single ping test
			if (GAUserProfileServiceConstants.SIMPLE_PING_TEST.equalsIgnoreCase(addGetAccessUserProfileRequest.getSyntheticTransactionTypeCode())) {
				throw new GAUserProfileSyntheticTestException("Simple Ping Test");
			}

			UserCredential userCredential = getUserCredential();

			AddGetAccessUserProfileReplyResource replyResource = gaUserProfileManager.addGetAccessUserProfile(addGetAccessUserProfileRequest,
					userCredential);

			reply = replyResource.getAddGetAccessUserProfileReply();

			// set the temp password in the response header
			javax.xml.ws.handler.MessageContext mcxt = wscxt.getMessageContext();

			javax.servlet.http.HttpServletResponse svletresp = (javax.servlet.http.HttpServletResponse) mcxt
					.get(javax.xml.ws.handler.MessageContext.SERVLET_RESPONSE);

			svletresp.addHeader(GAUserProfileServiceConstants.TEMP_PASSWORD_ATTR,
					new String(Base64.encode(replyResource.getTempPassword().getBytes())));

		} catch (GAUserProfileSyntheticTestException ex) {

			getLogger().logInfo("Synthetic Test:" + ex.getMessage(), this.getClass().getName(), "addGetAccessUserProfile");
			reply.setStatusInformation(statusInfo);
			return reply;

		} catch (GAUserProfileRequiredFieldException ex) {

			setRequiredFieldError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "addGetAccessUserProfile");

		} catch (GAUserProfileAuthenticationException ex) {

			setAuthenticationError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "addGetAccessUserProfile");

		} catch (GAUserProfileFieldFormatException ex) {

			setFieldFormatError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "addGetAccessUserProfile");
		}

		catch (GAUserProfileDataException ex) {

			getLogger().logSevere("Data Source Exception: " + ex.getMessage(), this.getClass().getName(), "addGetAccessUserProfile");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_DATA_SOURCE;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_DATA_SOURCE_MANAGEMENT + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new AddGetAccessUserProfileSimpleFaultReplyMsg("Error on addGetAccessUserProfile", faultInfo);

		} catch (GAUserProfileSystemException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "addGetAccessUserProfile");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_SYSTEM;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_SYSTEM_MANAGEMENT + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new AddGetAccessUserProfileSimpleFaultReplyMsg("Error on addGetAccessUserProfile", faultInfo);

		} catch (GAUserProfileRollbackSuccessfulException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "addGetAccessUserProfile");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_ROLLBACK_SUCCESS;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_ROLLBACK_SUCCESS + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new AddGetAccessUserProfileSimpleFaultReplyMsg("Error on addGetAccessUserProfile", faultInfo);

		} catch (GAUserProfileRollbackUnsuccessfulException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "addGetAccessUserProfile");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_ROLLBACK_NOT_SUCCESS;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_ROLLBACK_NOT_SUCCESS + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new AddGetAccessUserProfileSimpleFaultReplyMsg("Error on addGetAccessUserProfile", faultInfo);
		}

		reply.setStatusInformation(statusInfo);
		return reply;
	}

	/**
	 * Update get access user profile.
	 * 
	 * @param updateGetAccessUserProfileRequest
	 *            the update get access user profile request
	 * @return the update get access user profile reply
	 * @throws UpdateGetAccessUserProfileSimpleFaultReplyMsg
	 *             the update get access user profile simple fault reply msg
	 */
	public UpdateGetAccessUserProfileReply updateGetAccessUserProfile(UpdateGetAccessUserProfileRequest updateGetAccessUserProfileRequest)
			throws UpdateGetAccessUserProfileSimpleFaultReplyMsg {

		UpdateGetAccessUserProfileReply reply = new UpdateGetAccessUserProfileReply();

		StatusInformation statusInfo = new StatusInformation();
		statusInfo.setStatusCode(GAUserProfileServiceConstants.SUCCESSFUL);

		try {

			getLogger().logInfo("GetAccess EBE4X1 Service called operation: updateGetAccessUserProfile", this.getClass().getName(),
					"updateGetAccessUserProfile");

			// check for synthetic single ping test
			if (GAUserProfileServiceConstants.SIMPLE_PING_TEST.equalsIgnoreCase(updateGetAccessUserProfileRequest.getSyntheticTransactionTypeCode())) {
				throw new GAUserProfileSyntheticTestException("Simple Ping Test");
			}

			UserCredential userCredential = getUserCredential();

			reply = gaUserProfileManager.updateGetAccessUserProfile(updateGetAccessUserProfileRequest, userCredential);

		} catch (GAUserProfileSyntheticTestException ex) {

			getLogger().logInfo("Synthetic Test:" + ex.getMessage(), this.getClass().getName(), "updateGetAccessUserProfile");
			reply.setStatusInformation(statusInfo);
			return reply;

		} catch (GAUserProfileFieldFormatException ex) {
			setFieldFormatError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "updateGetAccessUserProfile");

		} catch (GAUserProfileAuthenticationException ex) {
			setAuthenticationError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "updateGetAccessUserProfile");

		} catch (GAUserProfileNotFoundException ex) {
			setNotFoundError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "updateGetAccessUserProfile");

		} catch (GAUserProfileRequiredFieldException ex) {
			setRequiredFieldError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "updateGetAccessUserProfile");

		} catch (GAUserProfileDataException ex) {

			getLogger().logSevere("Data Source Exception: " + ex.getMessage(), this.getClass().getName(), "updateGetAccessUserProfile");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_DATA_SOURCE;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_DATA_SOURCE_MANAGEMENT + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new UpdateGetAccessUserProfileSimpleFaultReplyMsg("Error on updateGetAccessUserProfile", faultInfo);

		} catch (GAUserProfileSystemException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "updateGetAccessUserProfile");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_SYSTEM;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_SYSTEM_MANAGEMENT + " | Additional Info: " + ex.getMessage() + " | Cause: "
					+ ex.getCause();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new UpdateGetAccessUserProfileSimpleFaultReplyMsg("Error on updateGetAccessUserProfile", faultInfo);
		}

		catch (GAUserProfileRollbackSuccessfulException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "updateGetAccessUserProfile");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_ROLLBACK_SUCCESS;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_ROLLBACK_SUCCESS + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new UpdateGetAccessUserProfileSimpleFaultReplyMsg("Error on updateGetAccessUserProfile", faultInfo);

		} catch (GAUserProfileRollbackUnsuccessfulException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "updateGetAccessUserProfile");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_ROLLBACK_NOT_SUCCESS;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_ROLLBACK_NOT_SUCCESS + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new UpdateGetAccessUserProfileSimpleFaultReplyMsg("Error on updateGetAccessUserProfile", faultInfo);
		}

		reply.setStatusInformation(statusInfo);
		return reply;
	}

	/**
	 * Update get access user profile status.
	 * 
	 * @param updateGetAccessUserProfileStatusRequest
	 *            the update get access user profile status request
	 * @return the update get access user profile status reply
	 * @throws UpdateGetAccessUserProfileStatusSimpleFaultReplyMsg
	 *             the update get access user profile status simple fault reply msg
	 */
	public UpdateGetAccessUserProfileStatusReply updateGetAccessUserProfileStatus(
			UpdateGetAccessUserProfileStatusRequest updateGetAccessUserProfileStatusRequest)
			throws UpdateGetAccessUserProfileStatusSimpleFaultReplyMsg {

		UpdateGetAccessUserProfileStatusReply reply = new UpdateGetAccessUserProfileStatusReply();

		StatusInformation statusInfo = new StatusInformation();
		statusInfo.setStatusCode(GAUserProfileServiceConstants.SUCCESSFUL);

		getLogger().logInfo("GetAccess EBE4X1 Service called operation: updateGetAccessUserProfileStatus", this.getClass().getName(),
				"updateGetAccessUserProfileStatus");

		try {

			// check for synthetic single ping test
			if (GAUserProfileServiceConstants.SIMPLE_PING_TEST.equalsIgnoreCase(updateGetAccessUserProfileStatusRequest
					.getSyntheticTransactionTypeCode())) {
				throw new GAUserProfileSyntheticTestException("Simple Ping Test");
			}

			UserCredential userCredential = getUserCredential();

			UpdateGetAccessUserProfileStatusResource replyResource = gaUserProfileManager.updateGetAccessUserProfileStatus(updateGetAccessUserProfileStatusRequest, userCredential);
			
			reply = replyResource.getUpdateGetAccessUserProfileStatusReply();
			
			// set the temp password in the response header
			if(!StringUtils.isEmpty(replyResource.getTempPassword())) {				
				javax.xml.ws.handler.MessageContext mcxt = wscxt.getMessageContext();

				javax.servlet.http.HttpServletResponse svletresp = (javax.servlet.http.HttpServletResponse) mcxt
						.get(javax.xml.ws.handler.MessageContext.SERVLET_RESPONSE);

				svletresp.addHeader(GAUserProfileServiceConstants.TEMP_PASSWORD_ATTR,
						new String(Base64.encode(replyResource.getTempPassword().getBytes())));				
			}

		} catch (GAUserProfileSyntheticTestException ex) {

			getLogger().logInfo("Synthetic Test:" + ex.getMessage(), this.getClass().getName(), "updateGetAccessUserProfileStatus");
			reply.setStatusInformation(statusInfo);
			return reply;

		} catch (GAUserProfileFieldFormatException ex) {
			setFieldFormatError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "updateGetAccessUserProfileStatus");

		} catch (GAUserProfileAuthenticationException ex) {
			setAuthenticationError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(),
					"updateGetAccessUserProfileStatus");

		} catch (GAUserProfileNotFoundException ex) {
			setNotFoundError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "updateGetAccessUserProfileStatus");

		} catch (GAUserProfileRequiredFieldException ex) {
			setRequiredFieldError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(),
					"updateGetAccessUserProfileStatus");

		} catch (GAUserProfileDataException ex) {

			getLogger().logSevere("Data Source Exception: " + ex.getMessage(), this.getClass().getName(), "updateGetAccessUserProfileStatus");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_DATA_SOURCE;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_DATA_SOURCE_MANAGEMENT + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new UpdateGetAccessUserProfileStatusSimpleFaultReplyMsg("Error on updateGetAccessUserProfileStatus", faultInfo);

		} catch (GAUserProfileSystemException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "updateGetAccessUserProfileStatus");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_SYSTEM;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_SYSTEM_MANAGEMENT + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new UpdateGetAccessUserProfileStatusSimpleFaultReplyMsg("Error on updateGetAccessUserProfileStatus", faultInfo);
		}

		reply.setStatusInformation(statusInfo);
		return reply;
	}

	/**
	 * Gets the access user profile list.
	 * 
	 * @param getAccessUserProfileListRequest
	 *            the get access user profile list request
	 * @return the access user profile list
	 * @throws GetAccessUserProfileListSimpleFaultReplyMsg
	 *             the get access user profile list simple fault reply msg
	 */
	public GetAccessUserProfileListReply getAccessUserProfileList(GetAccessUserProfileListRequest getAccessUserProfileListRequest)
			throws GetAccessUserProfileListSimpleFaultReplyMsg {

		GetAccessUserProfileListReply reply = new GetAccessUserProfileListReply();

		StatusInformation statusInfo = new StatusInformation();
		statusInfo.setStatusCode(GAUserProfileServiceConstants.SUCCESSFUL);

		getLogger().logInfo("GetAccess EBE4X1 Service called operation: getAccessUserProfileList", this.getClass().getName(),
				"getAccessUserProfileList");

		try {

			reply = gaUserProfileManager.getAccessUserProfileList(getAccessUserProfileListRequest);

		} catch (GAUserProfileRequiredFieldException ex) {

			setRequiredFieldError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_RETRIEVAL, ex.getMessage(), "getAccessUserProfileList");

		} catch (GAUserProfileDataException ex) {

			getLogger().logSevere("Data Source Exception: " + ex.getMessage(), this.getClass().getName(), "getAccessUserProfileList");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_RETRIEVAL + GAUserProfileServiceConstants.ERROR_CODE_DATA_SOURCE;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_DATA_SOURCE_RETRIEVAL + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new GetAccessUserProfileListSimpleFaultReplyMsg("Error on getAccessUserProfileList", faultInfo);

		} catch (GAUserProfileSystemException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "getAccessUserProfileList");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_RETRIEVAL + GAUserProfileServiceConstants.ERROR_CODE_SYSTEM;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_SYSTEM_RETRIEVAL + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new GetAccessUserProfileListSimpleFaultReplyMsg("Error on getAccessUserProfileList", faultInfo);
		}

		reply.setStatusInformation(statusInfo);
		return reply;
	}

	/**
	 * Gets the access user profile.
	 * 
	 * @param getAccessUserProfileRequest
	 *            the get access user profile request
	 * @return the access user profile
	 * @throws GetAccessUserProfileSimpleFaultReplyMsg
	 *             the get access user profile simple fault reply msg
	 */
	public GetAccessUserProfileReply getAccessUserProfile(GetAccessUserProfileRequest getAccessUserProfileRequest)
			throws GetAccessUserProfileSimpleFaultReplyMsg {

		GetAccessUserProfileReply reply = new GetAccessUserProfileReply();

		StatusInformation statusInfo = new StatusInformation();
		statusInfo.setStatusCode(GAUserProfileServiceConstants.SUCCESSFUL);

		getLogger().logInfo("GetAccess EBE4X1 Service called operation: getAccessUserProfile", this.getClass().getName(), "getAccessUserProfile");

		try {

			reply = gaUserProfileManager.getAccessUserProfile(getAccessUserProfileRequest);

		} catch (GAUserProfileNotFoundException ex) {

			getLogger().logWarning("Profile not found, returning empty response", this.getClass().getName(), "getAccessUserProfile");

		} catch (GAUserProfileMultipleException ex) {

			setMultipleUserProfilesError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_RETRIEVAL, ex.getMessage(), "getAccessUserProfile");

		} catch (GAUserProfileRequiredFieldException ex) {

			setRequiredFieldError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_RETRIEVAL, ex.getMessage(), "getAccessUserProfile");

		} catch (GAUserProfileDataException ex) {

			getLogger().logSevere("Data Source Exception: " + ex.getMessage(), this.getClass().getName(), "getAccessUserProfile");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_RETRIEVAL + GAUserProfileServiceConstants.ERROR_CODE_DATA_SOURCE;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_DATA_SOURCE_RETRIEVAL + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new GetAccessUserProfileSimpleFaultReplyMsg("Error on getAccessUserProfile", faultInfo);

		} catch (GAUserProfileSystemException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "getAccessUserProfile");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_RETRIEVAL + GAUserProfileServiceConstants.ERROR_CODE_SYSTEM;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_SYSTEM_RETRIEVAL + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new GetAccessUserProfileSimpleFaultReplyMsg("Error on getAccessUserProfile", faultInfo);
		}

		reply.setStatusInformation(statusInfo);
		return reply;
	}

	/**
	 * Reset get access user password.
	 * 
	 * @param resetGetAccessUserPasswordRequest
	 *            the reset get access user password request
	 * @return the reset get access user password reply
	 * @throws ResetGetAccessUserPasswordSimpleFaultReplyMsg
	 *             the reset get access user password simple fault reply msg
	 */
	public ResetGetAccessUserPasswordReply resetGetAccessUserPassword(ResetGetAccessUserPasswordRequest resetGetAccessUserPasswordRequest)
			throws ResetGetAccessUserPasswordSimpleFaultReplyMsg {

		ResetGetAccessUserPasswordReply reply = new ResetGetAccessUserPasswordReply();

		StatusInformation statusInfo = new StatusInformation();
		statusInfo.setStatusCode(GAUserProfileServiceConstants.SUCCESSFUL);

		getLogger().logInfo("GetAccess EBE4X1 Service called operation: resetGetAccessUserPassword", this.getClass().getName(),
				"resetGetAccessUserPassword");

		try {

			// check for synthetic single ping test
			if (GAUserProfileServiceConstants.SIMPLE_PING_TEST.equalsIgnoreCase(resetGetAccessUserPasswordRequest.getSyntheticTransactionTypeCode())) {
				throw new GAUserProfileSyntheticTestException("Simple Ping Test");
			}

			UserCredential userCredential = getUserCredential();
			
			ResetGetAccessUserPasswordResource replyResource = gaUserProfileManager.resetGetAccessUserPassword(resetGetAccessUserPasswordRequest, userCredential);
			
			reply = replyResource.getResetGetAccessUserPasswordReply();
			
			// set the temp password in the response header
			if(!StringUtils.isEmpty(replyResource.getTempPassword())) {				
				javax.xml.ws.handler.MessageContext mcxt = wscxt.getMessageContext();

				javax.servlet.http.HttpServletResponse svletresp = (javax.servlet.http.HttpServletResponse) mcxt
						.get(javax.xml.ws.handler.MessageContext.SERVLET_RESPONSE);

				svletresp.addHeader(GAUserProfileServiceConstants.TEMP_PASSWORD_ATTR,
						new String(Base64.encode(replyResource.getTempPassword().getBytes())));				
			}

		} catch (GAUserProfileSyntheticTestException ex) {

			getLogger().logInfo("Synthetic Test:" + ex.getMessage(), this.getClass().getName(), "resetGetAccessUserPassword");
			reply.setStatusInformation(statusInfo);
			return reply;

		} catch (GAUserProfileAuthenticationException ex) {
			setAuthenticationError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "resetGetAccessUserPassword");
			
		} catch (GAUserProfileFieldFormatException ex) {
			setFieldFormatError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "updateGetAccessUserProfile");			

		} catch (GAUserProfileNotFoundException ex) {
			setNotFoundError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "resetGetAccessUserPassword");

		} catch (GAUserProfileRequiredFieldException ex) {
			setRequiredFieldError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "resetGetAccessUserPassword");

		} catch (GAUserProfileDataException ex) {
			getLogger().logSevere("Data Source Exception: " + ex.getMessage(), this.getClass().getName(), "resetGetAccessUserPassword");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_DATA_SOURCE;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_DATA_SOURCE_MANAGEMENT + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new ResetGetAccessUserPasswordSimpleFaultReplyMsg("Error on resetGetAccessUserPassword", faultInfo);

		} catch (GAUserProfileSystemException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "resetGetAccessUserPassword");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_SYSTEM;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_SYSTEM_MANAGEMENT + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new ResetGetAccessUserPasswordSimpleFaultReplyMsg("Error on resetGetAccessUserPassword", faultInfo);
		}

		catch (GAUserProfileRollbackSuccessfulException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "resetGetAccessUserPassword");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_ROLLBACK_SUCCESS;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_ROLLBACK_SUCCESS + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new ResetGetAccessUserPasswordSimpleFaultReplyMsg("Error on resetGetAccessUserPassword", faultInfo);

		} catch (GAUserProfileRollbackUnsuccessfulException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "resetGetAccessUserPassword");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_ROLLBACK_NOT_SUCCESS;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_ROLLBACK_NOT_SUCCESS + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new ResetGetAccessUserPasswordSimpleFaultReplyMsg("Error on resetGetAccessUserPassword", faultInfo);
		}

		reply.setStatusInformation(statusInfo);
		return reply;
	}

	/**
	 * Change get access user password.
	 * 
	 * @param changeGetAccessUserPasswordRequest
	 *            the change get access user password request
	 * @return the change get access user password reply
	 * @throws ChangeGetAccessUserPasswordSimpleFaultReplyMsg
	 *             the change get access user password simple fault reply msg
	 */
	public ChangeGetAccessUserPasswordReply changeGetAccessUserPassword(ChangeGetAccessUserPasswordRequest changeGetAccessUserPasswordRequest)
			throws ChangeGetAccessUserPasswordSimpleFaultReplyMsg {

		ChangeGetAccessUserPasswordReply reply = new ChangeGetAccessUserPasswordReply();

		StatusInformation statusInfo = new StatusInformation();
		statusInfo.setStatusCode(GAUserProfileServiceConstants.SUCCESSFUL);

		getLogger().logInfo("GetAccess EBE4X1 Service called operation: changeGetAccessUserPassword", this.getClass().getName(),
				"changeGetAccessUserPassword");

		try {

			// check for synthetic simple ping test
			if (GAUserProfileServiceConstants.SIMPLE_PING_TEST.equalsIgnoreCase(changeGetAccessUserPasswordRequest.getSyntheticTransactionTypeCode())) {
				throw new GAUserProfileSyntheticTestException("Simple Ping Test");
			}

			UserCredential userCredential = getUserCredential();

			reply = gaUserProfileManager.changeGetAccessUserPassword(changeGetAccessUserPasswordRequest, userCredential);

		} catch (GAUserProfileSyntheticTestException ex) {
			getLogger().logInfo("Synthetic Test:" + ex.getMessage(), this.getClass().getName(), "changeGetAccessUserPassword");
			reply.setStatusInformation(statusInfo);
			return reply;

		} catch (GAUserProfileFieldFormatException ex) {
			setFieldFormatError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "changeGetAccessUserPassword");		
		
		} catch (GAUserProfileNotFoundException ex) {
			setNotFoundError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "changeGetAccessUserPassword");

		} catch (GAUserProfileAuthenticationException ex) {
			setAuthenticationError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "changeGetAccessUserPassword");
		}

		catch (GAUserProfileRequiredFieldException ex) {
			setRequiredFieldError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "changeGetAccessUserPassword");

		} catch (GAUserProfileDataException ex) {

			getLogger().logSevere("Data Source Exception: " + ex.getMessage(), this.getClass().getName(), "changeGetAccessUserPassword");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_DATA_SOURCE;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_DATA_SOURCE_MANAGEMENT + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new ChangeGetAccessUserPasswordSimpleFaultReplyMsg("Error on changeGetAccessUserPassword", faultInfo);

		} catch (GAUserProfileSystemException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "changeGetAccessUserPassword");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_SYSTEM;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_SYSTEM_MANAGEMENT + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new ChangeGetAccessUserPasswordSimpleFaultReplyMsg("Error on changeGetAccessUserPassword", faultInfo);
		}

		reply.setStatusInformation(statusInfo);
		return reply;
	}
	

    /**
     * Change get access user profile identifier.
     *
     * @param changeGetAccessUserProfileIdentifierRequest the change get access user profile identifier request
     * @return the change get access user profile identifier reply
     * @throws ChangeGetAccessUserProfileIdentifierSimpleFaultReplyMsg the change get access user profile identifier simple fault reply msg
     */
    public ChangeGetAccessUserProfileIdentifierReply changeGetAccessUserProfileIdentifier(ChangeGetAccessUserProfileIdentifierRequest changeGetAccessUserProfileIdentifierRequest) throws ChangeGetAccessUserProfileIdentifierSimpleFaultReplyMsg {

    	ChangeGetAccessUserProfileIdentifierReply reply = new ChangeGetAccessUserProfileIdentifierReply();

		StatusInformation statusInfo = new StatusInformation();
		statusInfo.setStatusCode(GAUserProfileServiceConstants.SUCCESSFUL);

		getLogger().logInfo("GetAccess EBE4X1 Service called operation: changeGetAccessUserProfileIdentifier", this.getClass().getName(),
				"changeGetAccessUserProfileIdentifier");

		try {

			// check for synthetic simple ping test
			if (GAUserProfileServiceConstants.SIMPLE_PING_TEST.equalsIgnoreCase(changeGetAccessUserProfileIdentifierRequest.getSyntheticTransactionTypeCode())) {
				throw new GAUserProfileSyntheticTestException("Simple Ping Test");
			}

			UserCredential userCredential = getUserCredential();
			reply = gaUserProfileManager.changeGetAccessUserProfileIdentifier(changeGetAccessUserProfileIdentifierRequest, userCredential);

		} catch (GAUserProfileAuthenticationException ex) {
			setAuthenticationError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "changeGetAccessUserProfileIdentifier");
		} catch (GAUserProfileFieldFormatException ex) {
			setFieldFormatError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "changeGetAccessUserProfileIdentifier");		
		} catch (GAUserProfileRequiredFieldException ex) {
				setRequiredFieldError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "changeGetAccessUserProfileIdentifier");
		
		} catch (GAUserProfileSyntheticTestException ex) {
			getLogger().logInfo("Synthetic Test:" + ex.getMessage(), this.getClass().getName(), "changeGetAccessUserProfileIdentifier");
			reply.setStatusInformation(statusInfo);
			return reply;
		}

		catch (GAUserProfileNotFoundException ex) {
			setNotFoundError(statusInfo, GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT, ex.getMessage(), "changeGetAccessUserProfileIdentifier");
		} 
		catch (GAUserProfileDataException ex) {

			getLogger().logSevere("Data Source Exception: " + ex.getMessage(), this.getClass().getName(), "changeGetAccessUserProfileIdentifier");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_DATA_SOURCE;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_DATA_SOURCE_MANAGEMENT + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new ChangeGetAccessUserProfileIdentifierSimpleFaultReplyMsg("Error on changeGetAccessUserProfileIdentifier", faultInfo);

		} catch (GAUserProfileSystemException ex) {

			getLogger().logSevere("System Exception: " + ex.getMessage(), this.getClass().getName(), "changeGetAccessUserProfileIdentifier");

			String errorCode = GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT + GAUserProfileServiceConstants.ERROR_CODE_SYSTEM;
			String errorSeverity = GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL;
			String errorDescription = GAUserProfileServiceConstants.ERROR_SYSTEM_MANAGEMENT + " | Additional Info: " + ex.getMessage();
			String errorSourceIdentifier = GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER;

			SimpleFault faultInfo = new SimpleFault();
			faultInfo.setFaultMessageText("ERROR CODE: " + errorCode + " | SEVERITY: " + errorSeverity + " | SOURCE IDENTIFIER: "
					+ errorSourceIdentifier + " | DESCRIPTION: " + errorDescription);

			throw new ChangeGetAccessUserProfileIdentifierSimpleFaultReplyMsg("Error on changeGetAccessUserProfileIdentifier", faultInfo);
		}

		reply.setStatusInformation(statusInfo);
		return reply;    	
    	
    }	

	/**
	 * Gets the user credential.
	 * 
	 * @return the user credential
	 * @throws GAUserProfileAuthenticationException
	 *             the gA user profile authentication exception
	 */
	protected UserCredential getUserCredential() throws GAUserProfileAuthenticationException, GAUserProfileSystemException {

		javax.xml.ws.handler.MessageContext mcxt = wscxt.getMessageContext();

		javax.servlet.http.HttpServletRequest svletreq = (javax.servlet.http.HttpServletRequest) mcxt
				.get(javax.xml.ws.handler.MessageContext.SERVLET_REQUEST);

		UserCredential userCredential = new UserCredential();

		if (svletreq != null && svletreq.getHeader(GAUserProfileServiceConstants.ADMIN_USER_ID_ATTR) != null
				&& svletreq.getHeader(GAUserProfileServiceConstants.ADMIN_PASSWORD_ATTR) != null) {

			// IP Address
			userCredential.setIpAddress(svletreq.getRemoteAddr());

			// Admin User credentials
			String adminUserName = new String(Base64.decode(svletreq.getHeader(GAUserProfileServiceConstants.ADMIN_USER_ID_ATTR)));
			userCredential.setAdminUsername(adminUserName);

			String adminPassword = new String(Base64.decode(svletreq.getHeader(GAUserProfileServiceConstants.ADMIN_PASSWORD_ATTR)));
			userCredential.setAdminPassword(adminPassword);

			// User credentials
			if (svletreq.getHeader(GAUserProfileServiceConstants.EXISTING_PASSWORD_ATTR) != null) {
				String existingPassword = new String(Base64.decode(svletreq.getHeader(GAUserProfileServiceConstants.EXISTING_PASSWORD_ATTR)));
				userCredential.setExistingUserPassword(existingPassword);
			}

			if (svletreq.getHeader(GAUserProfileServiceConstants.NEW_PASSWORD_ATTR) != null) {
				String newPassword = new String(Base64.decode(svletreq.getHeader(GAUserProfileServiceConstants.NEW_PASSWORD_ATTR)));
				userCredential.setNewUserPassword(newPassword);
			}

		} else {
			getLogger().logSevere("Admin credentials not found in header", this.getClass().getName(), "getUserCredential");
			throw new GAUserProfileAuthenticationException("Admin credentials not found in header");
		}

		return userCredential;
	}

	/**
	 * Sets the required field error.
	 * 
	 * @param statusInfo
	 *            the status info
	 * @param serviceCode
	 *            the service code
	 * @param message
	 *            the message
	 * @param operationName
	 *            the operation name
	 */
	private void setRequiredFieldError(StatusInformation statusInfo, String serviceCode, String message, String operationName) {

		getLogger().logSevere("Required Field Exception: " + message, this.getClass().getName(), operationName);

		String errorDescription = "";

		if (GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT.equals(serviceCode)) {
			errorDescription = GAUserProfileServiceConstants.ERROR_DATA_FIELD_MISSING_MANAGEMENT;

		} else if (GAUserProfileServiceConstants.ERROR_CODE_RETRIEVAL.equals(serviceCode)) {
			errorDescription = GAUserProfileServiceConstants.ERROR_DATA_FIELD_MISSING_RETRIEVAL;
		}

		ErrorInformation errorInfo = new ErrorInformation();
		errorInfo.setErrorCode(serviceCode + GAUserProfileServiceConstants.ERROR_CODE_DATA_FIELD_MISSING);
		errorInfo.setErrorDescription(errorDescription + " | Additional Info: " + message);
		errorInfo.setErrorSeverityLevel(GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL);
		errorInfo.setErrorSourceIdentifier(GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER);

		statusInfo.setStatusCode(GAUserProfileServiceConstants.ERROR);
		statusInfo.getErrorInformation().add(errorInfo);
	}

	/**
	 * Sets the multiple user profiles error.
	 * 
	 * @param statusInfo
	 *            the status info
	 * @param serviceCode
	 *            the service code
	 * @param message
	 *            the message
	 * @param operationName
	 *            the operation name
	 */
	private void setMultipleUserProfilesError(StatusInformation statusInfo, String serviceCode, String message, String operationName) {

		getLogger().logSevere("Required Field Exception: " + message, this.getClass().getName(), operationName);

		String errorDescription = "";

		if (GAUserProfileServiceConstants.ERROR_CODE_RETRIEVAL.equals(serviceCode)) {
			errorDescription = GAUserProfileServiceConstants.ERROR_MULTIPLE;
		}

		ErrorInformation errorInfo = new ErrorInformation();
		errorInfo.setErrorCode(serviceCode + GAUserProfileServiceConstants.ERROR_CODE_MULTIPLE);
		errorInfo.setErrorDescription(errorDescription + " | Additional Info: " + message);
		errorInfo.setErrorSeverityLevel(GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL);
		errorInfo.setErrorSourceIdentifier(GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER);

		statusInfo.setStatusCode(GAUserProfileServiceConstants.ERROR);
		statusInfo.getErrorInformation().add(errorInfo);
	}

	/**
	 * Sets the authentication error.
	 * 
	 * @param statusInfo
	 *            the status info
	 * @param serviceCode
	 *            the service code
	 * @param message
	 *            the message
	 * @param operationName
	 *            the operation name
	 */
	private void setAuthenticationError(StatusInformation statusInfo, String serviceCode, String message, String operationName) {

		getLogger().logSevere("Authentication Failure: " + message, this.getClass().getName(), operationName);

		String errorDescription = "";

		if (GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT.equals(serviceCode)) {
			errorDescription = GAUserProfileServiceConstants.ERROR_AUTHENTICATION_MANAGEMENT;

		} else if (GAUserProfileServiceConstants.ERROR_CODE_RETRIEVAL.equals(serviceCode)) {
			errorDescription = GAUserProfileServiceConstants.ERROR_AUTHENTICATION_RETRIEVAL;
		}

		ErrorInformation errorInfo = new ErrorInformation();
		errorInfo.setErrorCode(serviceCode + GAUserProfileServiceConstants.ERROR_CODE_AUTHENTICATION);
		errorInfo.setErrorDescription(errorDescription + " | Additional Info: " + message);
		errorInfo.setErrorSeverityLevel(GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL);
		errorInfo.setErrorSourceIdentifier(GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER);

		statusInfo.setStatusCode(GAUserProfileServiceConstants.ERROR);
		statusInfo.getErrorInformation().add(errorInfo);
	}

	/**
	 * Sets the field format error.
	 * 
	 * @param statusInfo
	 *            the status info
	 * @param serviceCode
	 *            the service code
	 * @param message
	 *            the message
	 * @param operationName
	 *            the operation name
	 */
	private void setFieldFormatError(StatusInformation statusInfo, String serviceCode, String message, String operationName) {

		getLogger().logSevere("Invalid Field Format Failure: " + message, this.getClass().getName(), operationName);

		String errorDescription = "";

		if (GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT.equals(serviceCode)) {
			errorDescription = GAUserProfileServiceConstants.ERROR_INVALID_FIELD_FORMAT_MANAGEMENT;

		} else if (GAUserProfileServiceConstants.ERROR_CODE_RETRIEVAL.equals(serviceCode)) {
			errorDescription = GAUserProfileServiceConstants.ERROR_INVALID_FIELD_FORMAT_RETRIEVAL;
		}

		ErrorInformation errorInfo = new ErrorInformation();
		errorInfo.setErrorCode(serviceCode + GAUserProfileServiceConstants.ERROR_CODE_INVALID_FIELD_FORMAT);
		errorInfo.setErrorDescription(errorDescription + " | Additional Info: " + message);
		errorInfo.setErrorSeverityLevel(GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL);
		errorInfo.setErrorSourceIdentifier(GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER);

		statusInfo.setStatusCode(GAUserProfileServiceConstants.ERROR);
		statusInfo.getErrorInformation().add(errorInfo);
	}

	/**
	 * Sets the not found error.
	 * 
	 * @param statusInfo
	 *            the status info
	 * @param serviceCode
	 *            the service code
	 * @param message
	 *            the message
	 * @param operationName
	 *            the operation name
	 */
	private void setNotFoundError(StatusInformation statusInfo, String serviceCode, String message, String operationName) {

		getLogger().logSevere("User Profile Not Found Failure: " + message, this.getClass().getName(), operationName);

		String errorDescription = "";

		if (GAUserProfileServiceConstants.ERROR_CODE_MANAGEMENT.equals(serviceCode)) {
			errorDescription = GAUserProfileServiceConstants.ERROR_NOT_FOUND_MANAGEMENT;

		} else if (GAUserProfileServiceConstants.ERROR_CODE_RETRIEVAL.equals(serviceCode)) {
			errorDescription = GAUserProfileServiceConstants.ERROR_NOT_FOUND_RETRIEVAL;
		}

		ErrorInformation errorInfo = new ErrorInformation();
		errorInfo.setErrorCode(serviceCode + GAUserProfileServiceConstants.ERROR_CODE_NOT_FOUND);
		errorInfo.setErrorDescription(errorDescription + " | Additional Info: " + message);
		errorInfo.setErrorSeverityLevel(GAUserProfileServiceConstants.ERROR_SEVERITY_LEVEL);
		errorInfo.setErrorSourceIdentifier(GAUserProfileServiceConstants.ERROR_SOURCE_IDENTIFIER);

		statusInfo.setStatusCode(GAUserProfileServiceConstants.ERROR);
		statusInfo.getErrorInformation().add(errorInfo);
	}

	/**
	 * Sets the wscxt.
	 * 
	 * @param wscxt
	 *            the new wscxt
	 */
	public void setWscxt(javax.xml.ws.WebServiceContext wscxt) {
		this.wscxt = wscxt;
	}

	/**
	 * Sets the ga user profile manager.
	 * 
	 * @param gaUserProfileManager
	 *            the new ga user profile manager
	 */
	public void setGaUserProfileManager(GAUserProfileManager gaUserProfileManager) {
		this.gaUserProfileManager = gaUserProfileManager;
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