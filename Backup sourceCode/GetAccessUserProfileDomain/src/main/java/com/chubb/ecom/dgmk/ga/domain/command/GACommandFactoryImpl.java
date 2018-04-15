package com.chubb.ecom.dgmk.ga.domain.command;

import java.util.Hashtable;
import java.util.List;

import chubb_corporate.get_access.access_attribute.AccessAttribute;
import chubb_corporate.get_access.access_control_group.AccessControlGroup;

import com.chubb.ecom.dgmk.ga.domain.resource.UserSnapshotResource;
import com.chubb.ecom.dgmk.ga.domain.resource.UserUpdateRequestResource;

public class GACommandFactoryImpl implements GACommandFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommandFactory#getUpdateUserPasswordCommand(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public GACommand getUpdateUserPasswordCommand(String userLogin, String existingUserPassword, String newUserPassword, String adminUsername,
			boolean changeValidatedPassword) {
		return new GAUpdateUserPasswordCommandImpl(userLogin, existingUserPassword, newUserPassword, adminUsername, changeValidatedPassword);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommandFactory#getUpdateUserStatusCommand(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public GACommand getUpdateUserStatusCommand(String userLogin, String originalUserStatus, String passwordExpiredStatus) {
		return new GAUpdateUserStatusCommandImpl(userLogin, originalUserStatus, passwordExpiredStatus);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommandFactory#getCreateUserCommand(java.util.Hashtable, java.lang.String)
	 */
	@Override
	public GACommand getCreateUserCommand(Hashtable<String, Object> userAttributes, String adminUsername) {
		return new GACreateUserCommandImpl(userAttributes, adminUsername);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommandFactory#getCreateUserRolesCommand(java.util.List, java.lang.String, java.lang.String)
	 */
	@Override
	public GACommand getCreateUserRolesCommand(List<AccessControlGroup> accessControlGroup, String userLogin, String adminUsername) {
		return new GACreateUserRolesCommandImpl(accessControlGroup, userLogin, adminUsername);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommandFactory#getCreateUserAppKeysCommand(java.util.List, java.lang.String, java.lang.String)
	 */
	@Override
	public GACommand getCreateUserAppKeysCommand(List<AccessAttribute> accessAttributeList, String userLogin, String adminUsername) {
		return new GACreateUserAppKeysCommandImpl(accessAttributeList, userLogin, adminUsername);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommandFactory#getCreateUserPlusCommand(java.lang.String, java.util.Hashtable)
	 */
	@Override
	public GACommand getCreateUserPlusCommand(String personGIN, Hashtable<String, Object> userPlusAttributes) {
		return new GACreateUserPlusCommandImpl(personGIN, userPlusAttributes);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommandFactory#getUpdateUserCommand(java.lang.String, com.chubb.ecom.dgmk.ga.domain.resource.UserUpdateRequestResource,
	 * com.chubb.ecom.dgmk.ga.domain.resource.UserSnapshotResource)
	 */
	@Override
	public GACommand getUpdateUserCommand(String adminUser, String personGin, UserUpdateRequestResource userUpdateRequest, UserSnapshotResource userSnapshot) {
		return new GAUpdateUserCommandImpl(adminUser, personGin, userUpdateRequest, userSnapshot);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommandFactory#getDeleteUserRolesCommand(java.util.List, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public GACommand getDeleteUserRolesCommand(List<AccessControlGroup> deleteRolesList, String originalUserLogin, String originalPersonGIN,
			String adminUser) {
		return new GADeleteUserRolesCommandImpl(deleteRolesList, originalUserLogin, originalPersonGIN, adminUser);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommandFactory#getUpdateUserRolesCommand(java.util.List, java.lang.String, java.lang.String)
	 */
	@Override
	public GACommand getUpdateUserRolesCommand(List<AccessControlGroup> updateRolesList, String originalUserLogin, String adminUser) {
		return new GAUpdateUserRolesCommandImpl(updateRolesList, originalUserLogin, adminUser);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommandFactory#getDeleteUserAppKeysCommand(java.util.List, java.lang.String, java.lang.String)
	 */
	@Override
	public GACommand getDeleteUserAppKeysCommand(List<AccessAttribute> deleteAppKeysList, String originalUserLogin, String adminUser) {
		return new GADeleteUserAppKeysCommandImpl(deleteAppKeysList, originalUserLogin, adminUser);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.domain.command.GACommandFactory#getUpdateUserPlusCommand(java.lang.String, java.util.Hashtable)
	 */
	@Override
	public GACommand getUpdateUserPlusCommand(String personGIN, Hashtable<String, Object> userPlusAttributes) {
		return new GAUpdateUserPlusCommandImpl(personGIN, userPlusAttributes);
	}

}
