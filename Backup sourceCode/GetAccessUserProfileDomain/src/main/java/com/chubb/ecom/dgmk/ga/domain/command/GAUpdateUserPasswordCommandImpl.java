package com.chubb.ecom.dgmk.ga.domain.command;

import java.sql.SQLException;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.connection.GAConnectionFactory;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileAuthenticationException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileFieldFormatException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;

import enCommerce.getAccess.API.Connection.ConnectionException;
import enCommerce.getAccess.API.Exceptions.DuplicatedRowsException;
import enCommerce.getAccess.API.Exceptions.ForeignKeyException;
import enCommerce.getAccess.API.Exceptions.InvalidParameterException;
import enCommerce.getAccess.API.Exceptions.InvalidParameterSizeException;
import enCommerce.getAccess.API.Exceptions.MinimumLengthException;
import enCommerce.getAccess.API.Exceptions.NullFieldException;
import enCommerce.getAccess.API.Exceptions.OtherException;
import enCommerce.getAccess.API.Exceptions.PasswordHistoryException;
import enCommerce.getAccess.API.Exceptions.PasswordLengthException;
import enCommerce.getAccess.API.Exceptions.PasswordLowerCaseException;
import enCommerce.getAccess.API.Exceptions.PasswordNonAlphaCharacterException;
import enCommerce.getAccess.API.Exceptions.PasswordNumericCharacterException;
import enCommerce.getAccess.API.Exceptions.PasswordRepeatCharacterException;
import enCommerce.getAccess.API.Exceptions.PasswordUpperCaseException;
import enCommerce.getAccess.API.Exceptions.PasswordUserFirstNameException;
import enCommerce.getAccess.API.Exceptions.PasswordUserLastNameException;
import enCommerce.getAccess.API.Exceptions.PasswordUserLoginException;

public class GAUpdateUserPasswordCommandImpl implements GACommand {

	/** The ga logger. This should be injected by IOC framework */
	private ILogger logger;

	private String userLogin;
	private String existingUserPassword;
	private String newUserPassword;
	private String adminUsername;
	private boolean changeValidatedPassword;

	/**
	 * Instantiates a new gA update user password command impl.
	 * 
	 * @param userLogin
	 *            the user login
	 * @param existingUserPassword
	 *            the existing user password
	 * @param newUserPassword
	 *            the new user password
	 * @param adminUsername
	 *            the admin username
	 * @param changeValidatedPassword
	 *            the change validated password
	 */
	public GAUpdateUserPasswordCommandImpl(String userLogin, String existingUserPassword, String newUserPassword, String adminUsername,
			boolean changeValidatedPassword) {

		this.userLogin = userLogin;
		this.existingUserPassword = existingUserPassword;
		this.newUserPassword = newUserPassword;
		this.adminUsername = adminUsername;
		this.changeValidatedPassword = changeValidatedPassword;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#execute()
	 */
	public void execute() throws GAUserProfileSystemException, GAUserProfileAuthenticationException, GAUserProfileFieldFormatException {
		
		getLogger().logInfo("Executing update user password command for user: " + userLogin, this.getClass().getName(), "execute");

		try {

			if (changeValidatedPassword) {
				GAConnectionFactory.getUserAPI().changeValidatedPassword(userLogin, existingUserPassword, newUserPassword, adminUsername);

			} else {
				GAConnectionFactory.getUserAPI().changePassword(userLogin, newUserPassword, adminUsername);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: Get Access Database not available: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem changing user password: Get Access Database not available");
		} catch (NullFieldException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: password is null or empty: " + e.getMessage(), this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem changing user password: password is null or empty");
		} catch (ForeignKeyException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: status does not exist: " + e.getMessage(), this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem changing user password: status does not exist");			
		} catch (MinimumLengthException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: password is too short: " + e.getMessage(), this.getClass().getName(), "execute");
			throw new GAUserProfileFieldFormatException("Problem changing user password: password is too short");
		} catch (InvalidParameterSizeException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: field size for password is violated: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileFieldFormatException("Problem changing user password: field size for password is violated");
		} catch (PasswordLengthException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: password length rule is violated: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileFieldFormatException("Problem changing user password: password length rule is violated");
		} catch (PasswordLowerCaseException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: password lowercase character rule is violated: " + e.getMessage(), this.getClass()
					.getName(), "execute");
			throw new GAUserProfileFieldFormatException("Problem changing user password: password lowercase character rule is violated");
		} catch (PasswordUpperCaseException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: password uppercase character rule is violated: " + e.getMessage(), this.getClass()
					.getName(), "execute");
			throw new GAUserProfileFieldFormatException("Problem changing user password: password uppercase character rule is violated");
		} catch (PasswordNumericCharacterException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: numeric character rule is violated: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileFieldFormatException("Problem changing user password: numeric character rule is violated");
		} catch (PasswordNonAlphaCharacterException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: alpha-numeric rule is violated: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileFieldFormatException("Problem changing user password: alpha-numeric rule is violated");
		} catch (PasswordHistoryException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: password history rule is violated: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileFieldFormatException("Problem changing user password: password history rule is violated");
		} catch (PasswordUserFirstNameException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: user first name rule is violated: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileFieldFormatException("Problem changing user password: user first name rule is violated");
		} catch (PasswordUserLastNameException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: user last name rule is violated: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileFieldFormatException("Problem changing user password: user last name rule is violated");
		} catch (PasswordUserLoginException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: user login rule is violated: " + e.getMessage(), this.getClass().getName(), "execute");
			throw new GAUserProfileFieldFormatException("Problem changing user password: user login rule is violated");
		} catch (PasswordRepeatCharacterException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: repeat character rule is violated: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileFieldFormatException("Problem changing user password: repeat character rule is violated");
		} catch (InvalidParameterException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: usr_login does not exist in the system: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem changing user password: usr_login does not exist in the system");
		} catch (DuplicatedRowsException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: more than one usr_login in the system: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem changing user password: more than one usr_login in the system");
		} catch (OtherException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: an unidentified error has occurred: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem changing user password: an unidentified error has occurred");
		} catch (ConnectionException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: GA Repository cannot be established: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem changing user password: GA Repository cannot be established");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem changing user password: the user cannot be authenticated with old password: " + e.getMessage(), this.getClass()
					.getName(), "execute");
			throw new GAUserProfileAuthenticationException("Problem changing user password: the user cannot be authenticated with old password");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#undo()
	 */
	public void undo(String errorMsg) {
		// no undo for update user password
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
