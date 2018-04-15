package com.chubb.ecom.dgmk.ga.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.chubb.ecom.dgmk.ga.persistence.util.GAUserProfilePersistenceConstants;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the AUTH_ROLES database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = GAUserProfilePersistenceConstants.QUERY_ROLE_BY_CODE, query = "Select role from AuthRole role where role.id.groupCode = :groupCode and role.id.authRoleCode = :roleCode") })

@Table(name = "AUTH_ROLES")
public class AuthRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AuthRolePK id;

	@Column(name = "AR_TYPE")
	private String arType;

	@Column(name = "AUTH_ROLE_DESCN")
	private String authRoleDescn;

	@Column(name = "AUTH_ROLE_NAME")
	private String authRoleName;

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "MODIFIED_BY")
	private BigDecimal modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name = "SOUND_SORT_VALUE")
	private String soundSortValue;

	public AuthRole() {
	}

	public AuthRolePK getId() {
		return this.id;
	}

	public void setId(AuthRolePK id) {
		this.id = id;
	}

	public String getArType() {
		return this.arType;
	}

	public void setArType(String arType) {
		this.arType = arType;
	}

	public String getAuthRoleDescn() {
		return this.authRoleDescn;
	}

	public void setAuthRoleDescn(String authRoleDescn) {
		this.authRoleDescn = authRoleDescn;
	}

	public String getAuthRoleName() {
		return this.authRoleName;
	}

	public void setAuthRoleName(String authRoleName) {
		this.authRoleName = authRoleName;
	}

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public BigDecimal getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(BigDecimal modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getSoundSortValue() {
		return this.soundSortValue;
	}

	public void setSoundSortValue(String soundSortValue) {
		this.soundSortValue = soundSortValue;
	}

}