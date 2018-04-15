package com.chubb.ecom.dgmk.ga.model;

public class UserCredential {

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	private String adminUsername;
	private String adminPassword;
	private String existingUserPassword;
	private String newUserPassword;
	private String ipAddress;

	public String getExistingUserPassword() {
		return existingUserPassword;
	}

	public void setExistingUserPassword(String existingUserPassword) {
		this.existingUserPassword = existingUserPassword;
	}

	public String getNewUserPassword() {
		return newUserPassword;
	}

	public void setNewUserPassword(String newUserPassword) {
		this.newUserPassword = newUserPassword;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}
