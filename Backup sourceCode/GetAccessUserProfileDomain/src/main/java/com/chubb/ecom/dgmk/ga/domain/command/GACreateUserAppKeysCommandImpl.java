package com.chubb.ecom.dgmk.ga.domain.command;

import java.sql.SQLException;
import java.util.List;

import chubb_corporate.get_access.access_attribute.AccessAttribute;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.connection.GAConnectionFactory;
import com.chubb.ecom.dgmk.ga.domain.util.GAUserProfileManagerUtil;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;
import com.chubb.ecom.dgmk.ga.util.GAUserProfileServiceConstants;

import enCommerce.getAccess.API.Connection.ConnectionException;
import enCommerce.getAccess.API.Exceptions.DuplicatedRowsException;
import enCommerce.getAccess.API.Exceptions.ForeignKeyException;
import enCommerce.getAccess.API.Exceptions.InvalidParameterException;
import enCommerce.getAccess.API.Exceptions.InvalidParameterSizeException;
import enCommerce.getAccess.API.Exceptions.NullFieldException;
import enCommerce.getAccess.API.Exceptions.OtherException;
import enCommerce.getAccess.API.Exceptions.PrimaryKeyException;

public class GACreateUserAppKeysCommandImpl implements GACommand {

	/** The ga logger. This should be injected by IOC framework */
	private ILogger logger;

	private GAUserProfileManagerUtil userProfileManagerUtil;

	List<AccessAttribute> applicationKeys;
	String userLogin;
	String adminUsername;

	/**
	 * Instantiates a new gA create user app keys command impl.
	 * 
	 * @param applicationKeys
	 *            the application keys
	 * @param userLogin
	 *            the user login
	 * @param adminUsername
	 *            the admin username
	 */
	public GACreateUserAppKeysCommandImpl(List<AccessAttribute> applicationKeys, String userLogin, String adminUsername) {
		this.applicationKeys = applicationKeys;
		this.userLogin = userLogin;
		this.adminUsername = adminUsername;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#execute()
	 */
	public void execute() throws GAUserProfileSystemException {

		getLogger().logInfo("Executing create user app keys command for user: " + userLogin, this.getClass().getName(), "execute");

		if (applicationKeys != null) {

			try {

				// lookup current source systems for user
				List<String> currentUserSourceSystems = getUserProfileManagerUtil().getCurrentUserSourceSystems(userLogin);

				for (AccessAttribute accessAttribute : applicationKeys) {

					String sourceSystemId = null;

					if (GAUserProfileServiceConstants.PRODUCER_SUB_KEY_ATTR.equals(accessAttribute.getAccessAttributeName())) {
						sourceSystemId = GAUserProfileServiceConstants.PRODUCER_SOURCE_SYSTEM_ID;

					}  else if (GAUserProfileServiceConstants.PAS_SUB_KEY_ATTR.equals(accessAttribute.getAccessAttributeName())) {
						sourceSystemId = GAUserProfileServiceConstants.PAS_SOURCE_SYSTEM_ID;
					}else if (GAUserProfileServiceConstants.CLIENT_NUMBER_ATTR.equals(accessAttribute.getAccessAttributeName())) {
						sourceSystemId = GAUserProfileServiceConstants.CLIENT_SOURCE_SYSTEM_ID;
					}

					// create Source System if does not exist, before adding the keys
					if (!currentUserSourceSystems.contains(sourceSystemId)) {
						GAConnectionFactory.getUserAPI().addSourceSystemToUser(userLogin, sourceSystemId, adminUsername);
					}

					for (String accessAttributeValue : accessAttribute.getAccessAttributeValue()) {
						GAConnectionFactory.getUserAPI().addSourceSystemKeyToUser(userLogin, sourceSystemId, accessAttributeValue, adminUsername);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem creating user application keys: Get Access Database not available: " + e.getMessage(), this.getClass()
						.getName(), "execute");
				throw new GAUserProfileSystemException("Problem creating user application keys: Get Access Database not available");
			} catch (PrimaryKeyException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem creating user application keys: trying to add data that already exists: " + e.getMessage(), this.getClass()
						.getName(), "execute");
				throw new GAUserProfileSystemException("Problem creating user application keys: trying to add data that already exists");
			} catch (NullFieldException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem creating user application keys: a required field is null: " + e.getMessage(), this.getClass().getName(),
						"execute");
				throw new GAUserProfileSystemException("Problem creating user application keys: a required field is null");
			} catch (InvalidParameterException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem creating user application keys: createdBy does not exist in the Repository: " + e.getMessage(), this
						.getClass().getName(), "execute");
				throw new GAUserProfileSystemException("Problem creating user application keys: createdBy does not exist in the Repository");
			} catch (InvalidParameterSizeException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem creating user application keys: the maximum field size is exceeded: " + e.getMessage(), this.getClass()
						.getName(), "execute");
				throw new GAUserProfileSystemException("Problem creating user application keys: the maximum field size is exceeded");
			} catch (ForeignKeyException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem creating user application keys: userLogin does not exist: " + e.getMessage(), this.getClass().getName(),
						"execute");
				throw new GAUserProfileSystemException("Problem creating user application keys: userLogin does not exist");
			} catch (DuplicatedRowsException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem creating user application keys: createdBy is duplicated in the Repository: " + e.getMessage(), this
						.getClass().getName(), "execute");
				throw new GAUserProfileSystemException("Problem creating user application keys: createdBy is duplicated in the Repository");
			} catch (OtherException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem creating user application keys: an unidentified error has occurred: " + e.getMessage(), this.getClass()
						.getName(), "execute");
				throw new GAUserProfileSystemException("Problem creating user application keys: an unidentified error has occurred");
			} catch (ConnectionException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem creating user application keys: GA Repository cannot be established: " + e.getMessage(), this.getClass()
						.getName(), "execute");
				throw new GAUserProfileSystemException("Problem creating user application keys: GA Repository cannot be established");
			} catch (Exception e) {
				e.printStackTrace();
				getLogger().logSevere("Problem creating user application keys: " + e.getMessage(), this.getClass().getName(), "execute");
				throw new GAUserProfileSystemException("Problem creating user application keys");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#undo()
	 */
	public void undo(String errorMsg) {
		// no undo for app keys, call GACreateUserCommandImpl.undo() to delete user and associated app keys
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
