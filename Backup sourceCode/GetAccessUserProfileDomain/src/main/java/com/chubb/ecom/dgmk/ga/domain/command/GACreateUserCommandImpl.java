package com.chubb.ecom.dgmk.ga.domain.command;

import java.sql.SQLException;
import java.util.Hashtable;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.connection.GAConnectionFactory;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileRollbackSuccessfulException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileRollbackUnsuccessfulException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;
import com.chubb.ecom.dgmk.ga.util.GAUserProfileServiceConstants;

import enCommerce.getAccess.API.Connection.ConnectionException;
import enCommerce.getAccess.API.Exceptions.DuplicateUserException;
import enCommerce.getAccess.API.Exceptions.DuplicatedRowsException;
import enCommerce.getAccess.API.Exceptions.ForeignKeyException;
import enCommerce.getAccess.API.Exceptions.InvalidParameterException;
import enCommerce.getAccess.API.Exceptions.InvalidParameterSizeException;
import enCommerce.getAccess.API.Exceptions.MaxUsersException;
import enCommerce.getAccess.API.Exceptions.NullFieldException;
import enCommerce.getAccess.API.Exceptions.OtherException;
import enCommerce.getAccess.API.Exceptions.PrimaryKeyException;

public class GACreateUserCommandImpl implements GACommand {

	/** The ga logger. This should be injected by IOC framework */
	private ILogger logger;

	Hashtable<String, Object> userAttributes;
	String adminUsername;

	/**
	 * Instantiates a new gA create user command.
	 * 
	 * @param userAttributes
	 *            the user attributes
	 * @param adminUser
	 *            the admin user
	 */
	public GACreateUserCommandImpl(Hashtable<String, Object> userAttributes, String adminUsername) {
		this.userAttributes = userAttributes;
		this.adminUsername = adminUsername;
	}

	/**
	 * Execute method creates the user in GA.
	 * 
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public void execute() throws GAUserProfileSystemException {

		getLogger().logInfo("Executing create user command", this.getClass().getName(), "execute");

		try {
			GAConnectionFactory.getUserAPI().createUser(adminUsername, userAttributes);

		} catch (SQLException e) {
			e.printStackTrace();
			getLogger()
					.logSevere("Problem creating user: Get Access Database not available: " + e.getMessage(), this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem creating user: Get Access Database not available");
		} catch (PrimaryKeyException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem creating user: the login already exists in the system: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem creating user: the login already exists in the system");
		} catch (NullFieldException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem creating user: a required field is null: " + e.getMessage(), this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem creating user: a required field is null");
		} catch (InvalidParameterSizeException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem creating user: the maximum field size is violated: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem creating user: the maximum field size is violated");
		} catch (ForeignKeyException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem creating user: person_id does not exist or createdby is not a valid usr_login: " + e.getMessage(),
					this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem creating user: person_id does not exist or createdby is not a valid usr_login");
		} catch (InvalidParameterException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem creating user: cannot retrieve person_id from createdby: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem creating user: cannot retrieve person_id from createdby");
		} catch (DuplicatedRowsException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem creating user: more than one person_id exists for createdby: " + e.getMessage(),
					this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem creating user: more than one person_id exists for createdby");
		} catch (DuplicateUserException e) {
			e.printStackTrace();
			getLogger()
					.logSevere("Problem creating user: login already exist in the system: " + e.getMessage(), this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem creating user: login already exist in the system");
		} catch (OtherException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem creating user: an unidentified error has occurred: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem creating user: an unidentified error has occurred");
		} catch (ConnectionException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem creating user: GA Repository cannot be established: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem creating user: GA Repository cannot be established");
		} catch (MaxUsersException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem creating user: the maximum number of users has been reached: " + e.getMessage(),
					this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem creating user: the maximum number of users has been reached");
		}
	}

	/**
	 * Undo method deletes the user from GA.
	 * 
	 * 3 Attempts are made in case of an exception
	 * 
	 * @throws GAUserProfileRollbackSuccessfulException
	 *             the gA user profile rollback successful exception
	 * @throws GAUserProfileRollbackUnsuccessfulException
	 *             the gA user profile rollback unsuccessful exception
	 */
	public void undo(String errorMsg) throws GAUserProfileRollbackSuccessfulException, GAUserProfileRollbackUnsuccessfulException {

		int count = 0;
		int maxTries = 3;
		boolean rollbackSuccess = false;

		String userLogin = (String) userAttributes.get(GAUserProfileServiceConstants.ATTR_USER_LOGIN);

		while (++count < maxTries && !rollbackSuccess) {

			try {
				getLogger().logInfo("Attempt #" + count + " to delete user: " + userLogin, this.getClass().getName(), "undo");

				// Delete user will also cascade delete user roles, user plus, source info, etc.
				GAConnectionFactory.getUserAPI().deleteUser(userLogin, adminUsername);

				rollbackSuccess = true;

			} catch (Exception ex) {
				getLogger().logSevere("Problem deleting user: " + userLogin + " | Attempt #" + count + " | " + ex.getMessage(),
						this.getClass().getName(), "undo");
			}
		}

		if (rollbackSuccess) {

			getLogger().logInfo("User: " + userLogin + " deleted due to a rollback request", this.getClass().getName(), "undo");
			throw new GAUserProfileRollbackSuccessfulException("A system error occured: " + errorMsg + " | User: " + userLogin
					+ " was deleted after issuing a rollback");

		} else {

			getLogger().logSevere("An error occured: " + errorMsg + " | User: " + userLogin + " was not deleted after attempting a rollback request",
					this.getClass().getName(), "undo");

			throw new GAUserProfileRollbackUnsuccessfulException("An error occured: " + errorMsg + " | User: " + userLogin
					+ " was not deleted after attempting a rollback request");
		}
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
