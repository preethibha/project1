package com.chubb.ecom.dgmk.ga.domain.command;

import java.sql.SQLException;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.connection.GAConnectionFactory;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileRollbackSuccessfulException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileRollbackUnsuccessfulException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;

import enCommerce.getAccess.API.Connection.ConnectionException;
import enCommerce.getAccess.API.Exceptions.DuplicatedRowsException;
import enCommerce.getAccess.API.Exceptions.ForeignKeyException;
import enCommerce.getAccess.API.Exceptions.InvalidParameterException;
import enCommerce.getAccess.API.Exceptions.OtherException;

public class GAUpdateUserStatusCommandImpl implements GACommand {

	/** The ga logger. This should be injected by IOC framework */
	private ILogger logger;

	private String userLogin;
	private String userProfileStatus;
	private String originalUserStatus;

	/**
	 * Instantiates a new gA update user status command impl.
	 * 
	 * @param userLogin
	 *            the user login
	 * @param originalUserStatus
	 *            the original user status
	 * @param userProfileStatus
	 *            the user profile status
	 */
	public GAUpdateUserStatusCommandImpl(String userLogin, String originalUserStatus, String userProfileStatus) {
		this.userLogin = userLogin;
		this.originalUserStatus = originalUserStatus;
		this.userProfileStatus = userProfileStatus;		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#execute()
	 */
	public void execute() throws GAUserProfileSystemException {

		getLogger().logInfo("Executing update user status: "+userProfileStatus+ " for user: " + userLogin, this.getClass().getName(), "execute");

		try {
			GAConnectionFactory.getUserAPI().setUserStatus(userLogin, userProfileStatus, 0);

		} catch (SQLException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user status: Get Access Database not available: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user status: Get Access Database not available");
		} catch (ForeignKeyException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user status: status value does not exist: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user status: status value does not exist");
		} catch (InvalidParameterException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user status: usr_login does not exist in the system: " + e.getMessage(),
					this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem updating user status: usr_login does not exist in the system");
		} catch (DuplicatedRowsException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user status: there are more than one usr_login in the system: " + e.getMessage(),
					this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem updating user status: there are more than one usr_login in the system");
		} catch (OtherException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user status: " + e.getMessage(), this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem updating user status: ");
		} catch (ConnectionException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user status: GA Repository cannot be established: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user status: GA Repository cannot be established");
		}
	}

	/**
	 * Undo method restores the original user status.
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

		while (++count < maxTries && !rollbackSuccess) {

			try {
				getLogger().logInfo("Attempt #" + count + " to restore original status for user: " + userLogin, this.getClass().getName(), "undo");

				GAConnectionFactory.getUserAPI().setUserStatus(userLogin, originalUserStatus, 0);
				rollbackSuccess = true;

			} catch (Exception ex) {
				getLogger().logSevere("Problem restoring original status for user: " + userLogin + " | Attempt #" + count + " | " + ex.getMessage(),
						this.getClass().getName(), "undo");
			}
		}

		if (rollbackSuccess) {
			getLogger().logInfo("User: " + userLogin + " original status restored due to a rollback request", this.getClass().getName(), "undo");

			throw new GAUserProfileRollbackSuccessfulException("An error occured: " + errorMsg + " | User: " + userLogin
					+ " original status restored after issuing a rollback");

		} else {
			getLogger().logSevere("User: " + userLogin + " original status could not be restored after attempting a rollback",
					this.getClass().getName(), "undo");

			throw new GAUserProfileRollbackUnsuccessfulException("An error occured: " + errorMsg + " | User: " + userLogin
					+ " original status could not be restored after attempting a rollback request");
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
