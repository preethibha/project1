package com.chubb.ecom.dgmk.ga.domain.resource;

import chubb_corporate.business.add_get_access_user_profile_reply_ebe4x1.AddGetAccessUserProfileReply;

public class AddGetAccessUserProfileReplyResource {

	private AddGetAccessUserProfileReply addGetAccessUserProfileReply;
	private String tempPassword;

	public AddGetAccessUserProfileReply getAddGetAccessUserProfileReply() {
		return addGetAccessUserProfileReply;
	}

	public void setAddGetAccessUserProfileReply(AddGetAccessUserProfileReply addGetAccessUserProfileReply) {
		this.addGetAccessUserProfileReply = addGetAccessUserProfileReply;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}
}
