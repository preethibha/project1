package com.chubb.ecom.dgmk.ga.domain.resource;

import chubb_corporate.business.update_get_access_user_profile_status_reply_ebe4x1.UpdateGetAccessUserProfileStatusReply;

public class UpdateGetAccessUserProfileStatusResource {

	private UpdateGetAccessUserProfileStatusReply updateGetAccessUserProfileStatusReply;
	private String tempPassword;

	public UpdateGetAccessUserProfileStatusReply getUpdateGetAccessUserProfileStatusReply() {
		return updateGetAccessUserProfileStatusReply;
	}

	public void setUpdateGetAccessUserProfileStatusReply(UpdateGetAccessUserProfileStatusReply updateGetAccessUserProfileStatusReply) {
		this.updateGetAccessUserProfileStatusReply = updateGetAccessUserProfileStatusReply;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}
}
