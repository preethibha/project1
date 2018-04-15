package com.chubb.ecom.dgmk.ga.domain.resource;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import chubb_corporate.get_access.access_attribute.AccessAttribute;
import chubb_corporate.get_access.access_control_group.AccessControlGroup;

/**
 * The Class UserSnapshotResource is used by the GAUpdateUserCommandImpl.undo method to restore the original user in case of a rollback.
 */
public class UserUpdateRequestResource {

	/**
	 * Instantiates a new user update command resource.
	 */
	public UserUpdateRequestResource() {
	}

	/**
	 * Instantiates a new user update command resource.
	 * 
	 * @param userAttributes
	 *            the user attributes
	 * @param rolesActionMap
	 *            the roles action map
	 * @param applicationKeysActionMap
	 *            the application keys action map
	 * @param userPlusAttributes
	 *            the user plus attributes
	 */
	public UserUpdateRequestResource(Hashtable<String, Object> userAttributes, Map<String, List<AccessControlGroup>> rolesActionMap,
			Map<String, List<AccessAttribute>> applicationKeysActionMap, Hashtable<String, Object> userPlusAttributes) {

		this.userAttributes = userAttributes;
		this.rolesActionMap = rolesActionMap;
		this.applicationKeysActionMap = applicationKeysActionMap;
		this.userPlusAttributes = userPlusAttributes;
	}

	private Hashtable<String, Object> userAttributes;
	private Map<String, List<AccessControlGroup>> rolesActionMap;
	private Map<String, List<AccessAttribute>> applicationKeysActionMap;
	private Hashtable<String, Object> userPlusAttributes;

	public Hashtable<String, Object> getUserAttributes() {
		return userAttributes;
	}

	public void setUserAttributes(Hashtable<String, Object> userAttributes) {
		this.userAttributes = userAttributes;
	}

	public Map<String, List<AccessControlGroup>> getRolesActionMap() {
		return rolesActionMap;
	}

	public void setRolesActionMap(Map<String, List<AccessControlGroup>> rolesActionMap) {
		this.rolesActionMap = rolesActionMap;
	}

	public Map<String, List<AccessAttribute>> getApplicationKeysActionMap() {
		return applicationKeysActionMap;
	}

	public void setApplicationKeysActionMap(Map<String, List<AccessAttribute>> applicationKeysActionMap) {
		this.applicationKeysActionMap = applicationKeysActionMap;
	}

	public Hashtable<String, Object> getUserPlusAttributes() {
		return userPlusAttributes;
	}

	public void setUserPlusAttributes(Hashtable<String, Object> userPlusAttributes) {
		this.userPlusAttributes = userPlusAttributes;
	}

}
