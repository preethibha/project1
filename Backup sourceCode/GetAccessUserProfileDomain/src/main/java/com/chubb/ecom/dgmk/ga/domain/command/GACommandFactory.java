package com.chubb.ecom.dgmk.ga.domain.command;

import java.util.Hashtable;
import java.util.List;

import com.chubb.ecom.dgmk.ga.domain.resource.UserSnapshotResource;
import com.chubb.ecom.dgmk.ga.domain.resource.UserUpdateRequestResource;

import chubb_corporate.get_access.access_attribute.AccessAttribute;
import chubb_corporate.get_access.access_control_group.AccessControlGroup;

public interface GACommandFactory {

	/**
	 * Gets the update user password command.
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
	 * @return the update user password command
	 */
	public GACommand getUpdateUserPasswordCommand(String userLogin, String existingUserPassword, String newUserPassword, String adminUsername,
			boolean changeValidatedPassword);

	/**
	 * Gets the update user status command.
	 * 
	 * @param userLogin
	 *            the user login
	 * @param originalUserStatus
	 *            the original user status
	 * @param passwordExpiredStatus
	 *            the password expired status
	 * @return the update user status command
	 */
	public GACommand getUpdateUserStatusCommand(String userLogin, String originalUserStatus, String passwordExpiredStatus);

	/**
	 * Gets the creates the user command.
	 * 
	 * @param userAttributes
	 *            the user attributes
	 * @param adminUsername
	 *            the admin username
	 * @return the creates the user command
	 */
	public GACommand getCreateUserCommand(Hashtable<String, Object> userAttributes, String adminUsername);

	/**
	 * Gets the creates the user roles command.
	 * 
	 * @param accessControlGroup
	 *            the access control group
	 * @param userLogin
	 *            the user login
	 * @param adminUsername
	 *            the admin username
	 * @return the creates the user roles command
	 */
	public GACommand getCreateUserRolesCommand(List<AccessControlGroup> accessControlGroup, String userLogin, String adminUsername);

	/**
	 * Gets the creates the user app keys command.
	 * 
	 * @param accessAttributeList
	 *            the access attribute list
	 * @param userLogin
	 *            the user login
	 * @param adminUsername
	 *            the admin username
	 * @return the creates the user app keys command
	 */
	public GACommand getCreateUserAppKeysCommand(List<AccessAttribute> accessAttributeList, String userLogin, String adminUsername);

	/**
	 * Gets the creates the user plus command.
	 * 
	 * @param personGIN
	 *            the person gin
	 * @param userPlusAttributes
	 *            the user plus attributes
	 * @return the creates the user plus command
	 */
	public GACommand getCreateUserPlusCommand(String personGIN, Hashtable<String, Object> userPlusAttributes);

	/**
	 * Gets the update user command.
	 *
	 * @param adminUser the admin user
	 * @param personGIN the person gin
	 * @param userUpdateRequest the user update request
	 * @param userSnapshot the user snapshot
	 * @return the update user command
	 */
	public GACommand getUpdateUserCommand(String adminUser, String personGIN, UserUpdateRequestResource userUpdateRequest, UserSnapshotResource userSnapshot);

	/**
	 * Gets the delete user roles command.
	 * 
	 * @param deleteRolesList
	 *            the delete roles list
	 * @param originalUserLogin
	 *            the original user login
	 * @param originalPersonGIN
	 *            the original person gin
	 * @param adminUser
	 *            the admin user
	 * @return the delete user roles command
	 */
	public GACommand getDeleteUserRolesCommand(List<AccessControlGroup> deleteRolesList, String originalUserLogin, String originalPersonGIN,
			String adminUser);

	/**
	 * Gets the update user roles command.
	 * 
	 * @param updateRolesList
	 *            the update roles list
	 * @param originalUserLogin
	 *            the original user login
	 * @param adminUser
	 *            the admin user
	 * @return the update user roles command
	 */
	public GACommand getUpdateUserRolesCommand(List<AccessControlGroup> updateRolesList, String originalUserLogin, String adminUser);

	/**
	 * Gets the delete user app keys command.
	 * 
	 * @param deleteAppKeysList
	 *            the delete app keys list
	 * @param originalUserLogin
	 *            the original user login
	 * @param adminUser
	 *            the admin user
	 * @return the delete user app keys command
	 */
	public GACommand getDeleteUserAppKeysCommand(List<AccessAttribute> deleteAppKeysList, String originalUserLogin, String adminUser);

	/**
	 * Gets the update user plus command.
	 * 
	 * @param personGIN
	 *            the person gin
	 * @param userPlusAttributes
	 *            the user plus attributes
	 * @return the update user plus command
	 */
	public GACommand getUpdateUserPlusCommand(String personGIN, Hashtable<String, Object> userPlusAttributes);

}
