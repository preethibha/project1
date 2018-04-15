package com.chubb.ecom.dgmk.ga.domain.command;

import java.sql.SQLException;
import java.util.Hashtable;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.connection.GAConnectionFactory;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;

import enCommerce.getAccess.API.Connection.ConnectionException;
import enCommerce.getAccess.API.Exceptions.OtherException;

public class GACreateUserPlusCommandImpl implements GACommand {

	/** The ga logger. This should be injected by IOC framework */
	private ILogger logger;

	String personGIN;
	Hashtable<String, Object> userPlusAttributes;

	/**
	 * Instantiates a new gA create user plus command impl.
	 * 
	 * @param personGIN
	 *            the person gin
	 * @param userPlusAttributes
	 *            the user plus attributes
	 */
	public GACreateUserPlusCommandImpl(String personGIN, Hashtable<String, Object> userPlusAttributes) {
		this.personGIN = personGIN;
		this.userPlusAttributes = userPlusAttributes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#execute()
	 */
	public void execute() throws GAUserProfileSystemException {
		
		getLogger().logInfo("Executing create user plus command", this.getClass().getName(), "execute");

		// call the user API to create the user plus data
		try {
			GAConnectionFactory.getUserAPI().insertUserPlus(personGIN, userPlusAttributes);

		} catch (SQLException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem creating user plus data: Get Access Database not available: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem creating user plus data: Get Access Database not available");
		} catch (OtherException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem creating user plus data: an unidentified error has occurred: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem creating user plus data: an unidentified error has occurred");
		} catch (ConnectionException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem creating user plus data: GA Repository cannot be established: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem creating user plus data: GA Repository cannot be established");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#undo()
	 */
	public void undo(String errorMsg) {
		// no undo for user plus, call GACreateUserCommandImpl.undo() to delete user and associated user plus data
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
