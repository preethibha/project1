package com.chubb.ecom.dgmk.ga.domain.resource;

import chubb_corporate.get_access.user_profile.UserProfile;

/**
 * The Class UserSnapshotResource is used by the GAUpdateUserCommandImpl.undo method to restore the original user in case of a rollback.
 */
public class UserSnapshotResource {

	private String originalUserLogin;
	private String originalPersonGIN;
	private UserProfile originalUserProfile;

	public String getOriginalPersonGIN() {
		return originalPersonGIN;
	}

	public void setOriginalPersonGIN(String originalPersonGIN) {
		this.originalPersonGIN = originalPersonGIN;
	}

	public void setOriginalUserProfile(UserProfile originalUserProfile) {
		this.originalUserProfile = originalUserProfile;
	}

	public String getOriginalUserLogin() {
		return originalUserLogin;
	}

	public void setOriginalUserLogin(String originalUserLogin) {
		this.originalUserLogin = originalUserLogin;
	}

	public UserProfile getOriginalUserProfile() {
		return originalUserProfile;
	}

	public void setOriginalUser(UserProfile originalUserProfile) {
		this.originalUserProfile = originalUserProfile;
	}

}
