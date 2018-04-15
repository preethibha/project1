package com.chubb.ecom.dgmk.ga.domain.command;

import java.sql.SQLException;
import java.util.List;

import chubb_corporate.get_access.access_control_group.AccessControlGroup;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.connection.GAConnectionFactory;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;

import enCommerce.getAccess.API.Connection.ConnectionException;
import enCommerce.getAccess.API.Exceptions.OtherException;

public class GADeleteUserRolesCommandImpl implements GACommand {

	/** The ga logger. This should be injected by IOC framework */
	private ILogger logger;

	List<AccessControlGroup> accessControlGroupList;
	String userLogin;
	String adminUsername;
	String personId;

	/**
	 * Instantiates a new gA delete user roles command impl.
	 * 
	 * @param accessControlGroupList
	 *            the access control group list
	 * @param userLogin
	 *            the user login
	 * @param personId
	 *            the person id
	 * @param adminUsername
	 *            the admin username
	 */
	public GADeleteUserRolesCommandImpl(List<AccessControlGroup> accessControlGroupList, String userLogin, String personId, String adminUsername) {
		this.accessControlGroupList = accessControlGroupList;
		this.userLogin = userLogin;
		this.adminUsername = adminUsername;
		this.personId = personId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#execute()
	 */
	public void execute() throws GAUserProfileSystemException {
		
		getLogger().logInfo("Executing delete user roles command for user: " + userLogin, this.getClass().getName(), "execute");

		try {

			for (AccessControlGroup accessControlGroup : accessControlGroupList) {

				GAConnectionFactory.getUserAPI().deleteUserRole(personId, accessControlGroup.getAccessControlGroupCategoryCode(),
						accessControlGroup.getAccessControlGroupCode());
			}

		} catch (SQLException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem deleting user roles: Get Access Database not available: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem deleting user roles: Get Access Database not available");
		} catch (OtherException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem deleting user roles: an unidentified error has occurred: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem deleting user roles: an unidentified error has occurred");
		} catch (ConnectionException e) {
			e.printStackTrace();
			getLogger().logSevere("Problem deleting user roles: GA Repository cannot be established: " + e.getMessage(), this.getClass().getName(),
					"execute");
			throw new GAUserProfileSystemException("Problem deleting user roles: GA Repository cannot be established");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			getLogger().logSevere(
					"Problem deleting user roles: attempt is made to delete the administrator role from the super administrator: " + e.getMessage(),
					this.getClass().getName(), "execute");
			throw new GAUserProfileSystemException(
					"Problem deleting user roles: attempt is made to delete the administrator role from the super administrator");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommand#undo()
	 */
	public void undo(String errorMsg) {
		// no undo for delete roles
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
