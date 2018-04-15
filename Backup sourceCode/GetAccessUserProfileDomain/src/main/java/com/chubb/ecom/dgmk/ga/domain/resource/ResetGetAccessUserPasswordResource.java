package com.chubb.ecom.dgmk.ga.domain.resource;

import chubb_corporate.business.reset_get_access_user_password_reply_ebe4x1.ResetGetAccessUserPasswordReply;

public class ResetGetAccessUserPasswordResource {

	private ResetGetAccessUserPasswordReply resetGetAccessUserPasswordReply;
	private String tempPassword;
	
	public ResetGetAccessUserPasswordReply getResetGetAccessUserPasswordReply() {
		return resetGetAccessUserPasswordReply;
	}

	public void setResetGetAccessUserPasswordReply(ResetGetAccessUserPasswordReply resetGetAccessUserPasswordReply) {
		this.resetGetAccessUserPasswordReply = resetGetAccessUserPasswordReply;
	}
	
	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}
}
