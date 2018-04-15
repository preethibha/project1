package com.chubb.ecom.dgmk.ga.domain.command;

import java.sql.SQLException;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.connection.GAConnectionFactory;
import com.chubb.ecom.dgmk.ga.domain.manager.GAUserProfileManager;
import com.chubb.ecom.dgmk.ga.domain.manager.GAUserProfileManagerImpl;
import com.chubb.ecom.dgmk.ga.domain.resource.UserSnapshotResource;
import com.chubb.ecom.dgmk.ga.domain.resource.UserUpdateRequestResource;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileRollbackSuccessfulException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileRollbackUnsuccessfulException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;

import enCommerce.getAccess.API.Connection.ConnectionException;
import enCommerce.getAccess.API.Exceptions.DuplicateUserException;
import enCommerce.getAccess.API.Exceptions.DuplicatedRowsException;
import enCommerce.getAccess.API.Exceptions.ForeignKeyException;
import enCommerce.getAccess.API.Exceptions.InvalidParameterException;
import enCommerce.getAccess.API.Exceptions.InvalidParameterSizeException;
import enCommerce.getAccess.API.Exceptions.MaxUsersException;
import enCommerce.getAccess.API.Exceptions.NullFieldException;
import enCommerce.getAccess.API.Exceptions.OtherException;

public class GAUpdateUserCommandImpl implements GACommand {

	/** The ga logger. This should be injected by IOC framework */
	private ILogger logger;

	private UserUpdateRequestResource userUpdateCommandResource;
	private String adminUsername;
	String personGIN;
	private UserSnapshotResource userSnapshot;

	// update request data

	/**
	 * Instantiates a new gA update user command.
	 * 
	 * @param adminUsername
	 *            the admin username
	 * @param userUpdateCommandResource
	 *            the user update command resource
	 * @param userSnapshot
	 *            the user snapshot
	 */
	public GAUpdateUserCommandImpl(String adminUsername, String personGin, UserUpdateRequestResource userUpdateCommandResource, UserSnapshotResource userSnapshot) {
		this.userUpdateCommandResource = userUpdateCommandResource;
		this.adminUsername = adminUsername;
		this.personGIN = personGin;
		this.userSnapshot = userSnapshot;
	}

	/**
	 * Execute method updates the user in GA.
	 * 
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public void execute() throws GAUserProfileSystemException {

		getLogger().logInfo("Executing update user command", this.getClass().getName(), "execute");

		try {

			GAConnectionFactory.getUserAPI().updateUser(personGIN, adminUsername,
					userUpdateCommandResource.getUserAttributes());

		} catch (SQLException e) {
			e.printStackTrace();
			getLogger()
					.logSevere("Problem updating user: Get Access Database not available: " + e.getMessage(), this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem updating user: Get Access Database not available");
		} catch (NullFieldException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user: a required field is null: " + e.getMessage(), this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem updating user: a required field is null");
		} catch (InvalidParameterSizeException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user: maximum field size is violated: " + e.getMessage(), this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem updating user: maximum field size is violated");
		} catch (ForeignKeyException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user: person_id modifiedby is not a valid usr_login: " + e.getMessage(),
					this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem updating user: person_id modifiedby is not a valid usr_login");
		} catch (InvalidParameterException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user: user to update is not found: " + e.getMessage(), this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem updating user: user to update is not found");
		} catch (DuplicatedRowsException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user: more than one row is found for user: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user: more than one row is found for user");
		} catch (DuplicateUserException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user: more than one row is found for usr_login: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user: more than one row is found for usr_login");
		} catch (OtherException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user: an unidentified error has occurred: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user: an unidentified error has occurred");
		} catch (ConnectionException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user: GA Repository cannot be established: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user: GA Repository cannot be established");
		} catch (MaxUsersException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user: maximum number of users has been reached: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user: maximum number of users has been reached");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user: password changed violation has occurred: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user: password changed violation has occurred");
		}
	}

	/**
	 * Undo method restores the user data from the original user snapshot in GA.
	 * 
	 * Only 1 attempt is made to restore the user, since we don't want to end up with a partial restore
	 * 
	 * @throws GAUserProfileRollbackSuccessfulException
	 *             the gA user profile rollback successful exception
	 * @throws GAUserProfileRollbackUnsuccessfulException
	 *             the gA user profile rollback unsuccessful exception
	 */
	public void undo(String errorMsg) throws GAUserProfileRollbackSuccessfulException, GAUserProfileRollbackUnsuccessfulException {

		boolean rollbackSuccess = false;

		try {
			getLogger().logInfo("Attempting to restore User:" + userSnapshot.getOriginalUserLogin() + " to original state",
					this.getClass().getName(), "undo");

			GAUserProfileManager gaUserProfileManager = new GAUserProfileManagerImpl();
			gaUserProfileManager.restoreUserProfile(userSnapshot, personGIN, userUpdateCommandResource, adminUsername);

			rollbackSuccess = true;

		} catch (Exception ex) {
			getLogger().logSevere(
					"A system error occured. User: " + userSnapshot.getOriginalUserLogin() + " was not restored after attempting a rollback | "
							+ ex.getMessage(), this.getClass().getName(), "undo");
		}

		if (rollbackSuccess) {

			getLogger().logInfo("User: " + userSnapshot.getOriginalUserLogin() + " restored due to a rollback request", this.getClass().getName(),
					"undo");

			throw new GAUserProfileRollbackSuccessfulException("An error occured: " + errorMsg + " | User: " + userSnapshot.getOriginalUserLogin()
					+ " was restored after issuing a rollback");

		} else {

			getLogger().logSevere(
					"An error occured: " + errorMsg + " | User: " + userSnapshot.getOriginalUserLogin()
							+ " was not restored after attempting a rollback request", this.getClass().getName(), "undo");

			throw new GAUserProfileRollbackUnsuccessfulException("An error occured: " + errorMsg + " | User: " + userSnapshot.getOriginalUserLogin()
					+ " was not restored after attempting a rollback request");
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
