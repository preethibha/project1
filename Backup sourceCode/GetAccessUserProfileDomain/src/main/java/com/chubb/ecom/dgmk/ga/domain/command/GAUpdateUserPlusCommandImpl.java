package com.chubb.ecom.dgmk.ga.domain.command;

import java.sql.SQLException;
import java.util.Hashtable;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.connection.GAConnectionFactory;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;

import enCommerce.getAccess.API.Connection.ConnectionException;
import enCommerce.getAccess.API.Exceptions.OtherException;

public class GAUpdateUserPlusCommandImpl implements GACommand {

	/** The ga logger. This should be injected by IOC framework */
	private ILogger logger;

	String personGIN;
	Hashtable<String, Object> userPlusAttributes;

	/**
	 * Instantiates a new gA update user plus command impl.
	 * 
	 * @param personGIN
	 *            the person gin
	 * @param userPlusAttributes
	 *            the user plus attributes
	 */
	public GAUpdateUserPlusCommandImpl(String personGIN, Hashtable<String, Object> userPlusAttributes) {
		this.personGIN = personGIN;
		this.userPlusAttributes = userPlusAttributes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#execute()
	 */
	public void execute() throws GAUserProfileSystemException {
		
		getLogger().logInfo("Executing update user plus command", this.getClass().getName(), "execute");

		// Testing rollback - any data before user plus should be restored
		// throw new GAUserProfileSystemException("TESTING UPDATE USER ROLLBACK");

		try {
			GAConnectionFactory.getUserAPI().updateUserPlus(personGIN, userPlusAttributes);

		} catch (SQLException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user plus data: Get Access Database not available: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user plus data: Get Access Database not available");
		} catch (OtherException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user plus data: usr_login contains invalid characters or non determined error: " + e.getMessage(),
					this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem updating user plus data: usr_login contains invalid characters or non determined error ");
		} catch (ConnectionException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user plus data: GA Repository cannot be established: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user plus data: GA Repository cannot be established");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#undo()
	 */
	public void undo(String errorMsg) {
		// no undo for update user plus
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
