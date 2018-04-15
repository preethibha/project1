package com.chubb.ecom.dgmk.ga.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AUTH_ROLES database table.
 * 
 */
@Embeddable
public class AuthRolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="GROUP_CODE")
	private String groupCode;

	@Column(name="AUTH_ROLE_CODE")
	private String authRoleCode;

    public AuthRolePK() {
    }
	public String getGroupCode() {
		return this.groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getAuthRoleCode() {
		return this.authRoleCode;
	}
	public void setAuthRoleCode(String authRoleCode) {
		this.authRoleCode = authRoleCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AuthRolePK)) {
			return false;
		}
		AuthRolePK castOther = (AuthRolePK)other;
		return 
			this.groupCode.equals(castOther.groupCode)
			&& this.authRoleCode.equals(castOther.authRoleCode);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.groupCode.hashCode();
		hash = hash * prime + this.authRoleCode.hashCode();
		
		return hash;
    }
}