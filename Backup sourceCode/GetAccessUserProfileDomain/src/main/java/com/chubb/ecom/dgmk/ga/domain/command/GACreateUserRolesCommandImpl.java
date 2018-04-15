package com.chubb.ecom.dgmk.ga.domain.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import chubb_corporate.get_access.access_control_group.AccessControlGroup;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.connection.GAConnectionFactory;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;

import enCommerce.getAccess.API.Exceptions.GeneralDatabaseException;
import enCommerce.getAccess.API.Exceptions.LowOnResourcesException;
import enCommerce.getAccess.API.Exceptions.OtherException;

public class GACreateUserRolesCommandImpl implements GACommand {

	/** The ga logger. This should be injected by IOC framework */
	private ILogger logger;

	List<AccessControlGroup> accessControlGroupList;
	String userLogin;
	String adminUsername;

	/**
	 * Instantiates a new gA create user roles command impl.
	 * 
	 * @param accessControlGroupList
	 *            the access control group list
	 * @param userLogin
	 *            the user login
	 * @param adminUsername
	 *            the admin username
	 */
	public GACreateUserRolesCommandImpl(List<AccessControlGroup> accessControlGroupList, String userLogin, String adminUsername) {
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
		
		getLogger().logInfo("Executing create user roles command for user: " + userLogin, this.getClass().getName(), "execute");

		String[] userLogins = { userLogin };

		ArrayList<String> catcode = new ArrayList<String>();
		ArrayList<String> rolecode = new ArrayList<String>();
		ArrayList<java.sql.Date> startdate = new ArrayList<java.sql.Date>();
		ArrayList<java.sql.Date> enddate = new ArrayList<java.sql.Date>();

		// group roles
		for (AccessControlGroup accessControlGroup : accessControlGroupList) {

			catcode.add(accessControlGroup.getAccessControlGroupCategoryCode());
			rolecode.add(accessControlGroup.getAccessControlGroupCode());

			java.sql.Date startDate = null;
			java.sql.Date endDate = null;

			// determine start date
			if (accessControlGroup.getAccessControlGroupEffectiveDate() != null) {

				java.util.Date dt = accessControlGroup.getAccessControlGroupEffectiveDate().toGregorianCalendar().getTime();
				startDate = new java.sql.Date(dt.getTime());

			} else {
				// default to current date
				Calendar currenttime = Calendar.getInstance();
				startDate = new java.sql.Date((currenttime.getTime()).getTime());
			}

			// determine end date
			if (accessControlGroup.getAccessControlGroupExpirationDate() != null) {

				java.util.Date dt = accessControlGroup.getAccessControlGroupExpirationDate().toGregorianCalendar().getTime();
				endDate = new java.sql.Date(dt.getTime());
			}

			startdate.add(startDate);
			enddate.add(endDate);
		}

		// assign roles to the user
		if (!accessControlGroupList.isEmpty()) {

			Object[][] roles = new Object[accessControlGroupList.size()][4];

			int roleProperyIndex = 0;

			for (int roleArrayIndex = 0; roleArrayIndex < accessControlGroupList.size(); roleArrayIndex++) {

				roles[roleArrayIndex][roleProperyIndex] = catcode.get(roleArrayIndex);
				roles[roleArrayIndex][roleProperyIndex + 1] = rolecode.get(roleArrayIndex);
				roles[roleArrayIndex][roleProperyIndex + 2] = startdate.get(roleArrayIndex);
				roles[roleArrayIndex][roleProperyIndex + 3] = enddate.get(roleArrayIndex);

				roleProperyIndex = 0; // reset
			}

			try {
				GAConnectionFactory.getUserAPI().addRolesToUsersByUser(userLogins, roles, adminUsername);

			} catch (SQLException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem adding user roles for user: Get Access Database not available: " + e.getMessage(), this.getClass()
						.getName(), "execute");
				throw new GAUserProfileSystemException("Problem adding user roles for user: Get Access Database not available");
			} catch (LowOnResourcesException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem adding user roles for user: Resources are low: " + e.getMessage(), this.getClass().getName(), "execute");
				throw new GAUserProfileSystemException("Problem adding user roles for user: Resources are low");
			} catch (GeneralDatabaseException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem adding user roles for user: there is a Database error: " + e.getMessage(), this.getClass().getName(),
						"execute");
				throw new GAUserProfileSystemException("Problem adding user roles for user: there is a Database error");
			} catch (OtherException e) {
				e.printStackTrace();
				getLogger().logSevere("Problem adding user roles for user: an unidentified error has occurred: " + e.getMessage(), this.getClass()
						.getName(), "execute");
				throw new GAUserProfileSystemException("Problem adding user roles for user: an unidentified error has occurred");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#undo()
	 */
	public void undo(String errorMsg) {
		// no undo for create roles, call GACreateUserCommandImpl.undo() to delete user and associated roles
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
