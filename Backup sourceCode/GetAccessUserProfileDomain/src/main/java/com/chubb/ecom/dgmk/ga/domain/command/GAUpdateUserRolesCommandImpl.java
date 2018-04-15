package com.chubb.ecom.dgmk.ga.domain.command;

import java.sql.SQLException;
import java.util.List;

import chubb_corporate.get_access.access_control_group.AccessControlGroup;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.connection.GAConnectionFactory;
import com.chubb.ecom.dgmk.ga.domain.util.GAUserProfileManagerUtil;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;

import enCommerce.getAccess.API.Connection.ConnectionException;
import enCommerce.getAccess.API.Exceptions.DuplicatedRowsException;
import enCommerce.getAccess.API.Exceptions.ForeignKeyException;
import enCommerce.getAccess.API.Exceptions.InvalidParameterException;
import enCommerce.getAccess.API.Exceptions.InvalidParameterSizeException;
import enCommerce.getAccess.API.Exceptions.NullFieldException;
import enCommerce.getAccess.API.Exceptions.OtherException;

public class GAUpdateUserRolesCommandImpl implements GACommand {

	/** The ga logger. This should be injected by IOC framework */
	private ILogger logger;

	private GAUserProfileManagerUtil userProfileManagerUtil;

	private List<AccessControlGroup> accessControlGroupList;
	private String userLogin;
	private String adminUsername;

	/**
	 * Instantiates a new gA update user roles command impl.
	 * 
	 * @param accessControlGroupList
	 *            the access control group list
	 * @param userLogin
	 *            the user login
	 * @param adminUsername
	 *            the admin username
	 */
	public GAUpdateUserRolesCommandImpl(List<AccessControlGroup> accessControlGroupList, String userLogin, String adminUsername) {
		this.accessControlGroupList = accessControlGroupList;
		this.userLogin = userLogin;
		this.adminUsername = adminUsername;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#execute()
	 */
	public void execute() throws GAUserProfileSystemException {
		
		getLogger().logInfo("Executing update user roles command for user: " + userLogin, this.getClass().getName(), "execute");

		try {

			// group roles
			for (AccessControlGroup accessControlGroup : accessControlGroupList) {

				java.sql.Date startDate = null;
				java.sql.Date endDate = null;

				// determine start date
				if (accessControlGroup.getAccessControlGroupEffectiveDate() != null) {

					java.util.Date dt = accessControlGroup.getAccessControlGroupEffectiveDate().toGregorianCalendar().getTime();
					startDate = new java.sql.Date(dt.getTime());

				} else {
					// lookup existing effective date if not provided - REQUIRED
					startDate = getUserProfileManagerUtil().getExistingEffectiveDate(userLogin, accessControlGroup.getAccessControlGroupCategoryCode(),
							accessControlGroup.getAccessControlGroupCode());

					if (startDate == null) {

						getLogger().logSevere(
								"Error: Problem looking up the effective date For Category Code: "
										+ accessControlGroup.getAccessControlGroupCategoryCode() + " | Role Code: "
										+ accessControlGroup.getAccessControlGroupCode() + "| For User: " + userLogin, this.getClass().getName(),
								"execute");

						throw new GAUserProfileSystemException("Problem looking up the effective date");
					}
				}

				// determine end date
				if (accessControlGroup.getAccessControlGroupExpirationDate() != null) {

					java.util.Date dt = accessControlGroup.getAccessControlGroupExpirationDate().toGregorianCalendar().getTime();
					endDate = new java.sql.Date(dt.getTime());

				} else {
					getLogger().logWarning("The Expiration Date was not provided, setting expiration to NULL (never expire) | For User: " + userLogin, this
							.getClass().getName(), "execute");
				}

				GAConnectionFactory.getUserAPI().updateUserRole(userLogin, accessControlGroup.getAccessControlGroupCategoryCode(),
						accessControlGroup.getAccessControlGroupCode(), startDate, endDate, null, adminUsername);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user roles: Get Access Database not available: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user roles: Get Access Database not available");
		} catch (NullFieldException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user roles: a required field is null: " + e.getMessage(), this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem updating user roles: a required field is null");
		} catch (InvalidParameterSizeException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user roles: the maximum field size is violated: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user roles: the maximum field size is violated");
		} catch (ForeignKeyException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user roles: person_id does not exist or modified_by is not a valid usr_login: " + e.getMessage(), this
					.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem updating user roles: person_id does not exist or modified_by is not a valid usr_login");
		} catch (InvalidParameterException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user roles: " + e.getMessage(), this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException("Problem updating user roles");
		} catch (DuplicatedRowsException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user roles: more than one row is found for user: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user roles: more than one row is found for user");
		} catch (OtherException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user roles: an unidentified error has occurred: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user roles: an unidentified error has occurred");
		} catch (ConnectionException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem updating user roles: GA Repository cannot be established: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem updating user roles: GA Repository cannot be established");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#undo()
	 */
	public void undo(String errorMsg) {
		// no undo for update roles
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
