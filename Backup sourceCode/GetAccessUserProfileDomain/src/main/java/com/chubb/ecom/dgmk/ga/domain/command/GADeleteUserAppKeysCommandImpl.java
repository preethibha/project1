package com.chubb.ecom.dgmk.ga.domain.command;

import java.sql.SQLException;
import java.util.List;

import chubb_corporate.get_access.access_attribute.AccessAttribute;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.connection.GAConnectionFactory;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;
import com.chubb.ecom.dgmk.ga.util.GAUserProfileServiceConstants;

import enCommerce.getAccess.API.Connection.ConnectionException;
import enCommerce.getAccess.API.Exceptions.ForeignKeyException;
import enCommerce.getAccess.API.Exceptions.OtherException;

public class GADeleteUserAppKeysCommandImpl implements GACommand {

	/** The ga logger. This should be injected by IOC framework */
	private ILogger logger;

	List<AccessAttribute> applicationKeys;
	String userLogin;
	String adminUsername;

	/**
	 * Instantiates a new gA delete user app keys command impl.
	 * 
	 * @param applicationKeys
	 *            the application keys
	 * @param userLogin
	 *            the user login
	 * @param adminUsername
	 *            the admin username
	 */
	public GADeleteUserAppKeysCommandImpl(List<AccessAttribute> applicationKeys, String userLogin, String adminUsername) {
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
		
		getLogger().logInfo("Executing delete user app keys command for user: " + userLogin, this.getClass().getName(), "execute");

		if (applicationKeys != null) {

			try {

				for (AccessAttribute accessAttribute : applicationKeys) {

					String sourceSystemId = null;

					if (GAUserProfileServiceConstants.PRODUCER_SUB_KEY_ATTR.equals(accessAttribute.getAccessAttributeName())) {
						sourceSystemId = GAUserProfileServiceConstants.PRODUCER_SOURCE_SYSTEM_ID;

					} else if (GAUserProfileServiceConstants.PAS_SUB_KEY_ATTR.equals(accessAttribute.getAccessAttributeName())) {
						sourceSystemId = GAUserProfileServiceConstants.PAS_SOURCE_SYSTEM_ID;
					} else if (GAUserProfileServiceConstants.CLIENT_NUMBER_ATTR.equals(accessAttribute.getAccessAttributeName())) {
						sourceSystemId = GAUserProfileServiceConstants.CLIENT_SOURCE_SYSTEM_ID;
					}

					for (String accessAttributeValue : accessAttribute.getAccessAttributeValue()) {

						GAConnectionFactory.getUserAPI()
								.deleteSourceSystemKeyFromUser(userLogin, sourceSystemId, accessAttributeValue, adminUsername);
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem deleting user application keys: Get Access Database not available: " + e.getMessage(), this.getClass()
						.getName(), "execute");
				throw new GAUserProfileSystemException("Problem deleting user application keys: Get Access Database not available");
			} catch (ForeignKeyException e) {
				e.printStackTrace();
				getLogger().logSevere(
						"Problem deleting user application keys: there are Source System keys associated with this Source System: " + e.getMessage(),
						this.getClass().getName(), "execute");
				throw new GAUserProfileSystemException(
						"Problem deleting user application keys: there are Source System keys associated with this Source System");
			} catch (OtherException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem deleting user application keys: an unidentified error has occurred: " + e.getMessage(), this.getClass()
						.getName(), "execute");
				throw new GAUserProfileSystemException("Problem deleting user application keys: an unidentified error has occurred");
			} catch (ConnectionException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem deleting user application keys: GA Repository cannot be established: " + e.getMessage(), this.getClass()
						.getName(), "execute");
				throw new GAUserProfileSystemException("Problem deleting user application keys: GA Repository cannot be established");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#undo()
	 */
	public void undo(String errorMsg) {
		// no undo for app keys delete
	}

	/**
	 * Sets the logger.
	 * 
	 * @param logger
	 *            the new logger
	 */
	private void setLogger(ILogger logger) {
		this.logger = logger;
	}

	/**
	 * Gets the default logger if object is not set by IOC framework
	 * 
	 * @return the logger
	 */
	private ILogger getLogger() {
		if (logger == null) {
			logger = GAUserProfileLoggerImpl.getLogger();
		}
		return logger;
	}
}
