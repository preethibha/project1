package com.chubb.ecom.dgmk.ga.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.chubb.ecom.dgmk.ga.persistence.util.GAUserProfilePersistenceConstants;

/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = GAUserProfilePersistenceConstants.QUERY_USER_BY_EMAIL, query = "Select user from User user where LOWER(user.email) = :email"),
		@NamedQuery(name = GAUserProfilePersistenceConstants.QUERY_USER_BY_USER_LOGIN, query = "Select user from User user where user.usrLogin = :userLogin") })
		
@Table(name = "USERS")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PERSON_ID")
	private long personId;

	@Temporal(TemporalType.DATE)
	@Column(name = "ACCOUNT_EXP_DATE")
	private Date accountExpDate;

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "CURRENCY_CODE")
	private String currencyCode;

	@Column(name = "DATE_CODE")
	private String dateCode;

	@Column(name = "DELEGATION_CODE")
	private String delegationCode;

	private String descn;

	private String dn;

	private String email;

	@Column(name = "GENERAL_TIMEOUT")
	private BigDecimal generalTimeout;

	@Column(name = "IDLE_TIMEOUT")
	private BigDecimal idleTimeout;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_SUCCESS_LOGIN_DATE")
	private Date lastSuccessLoginDate;

	@Column(name = "LAST_SUCCESS_LOGIN_FROM")
	private String lastSuccessLoginFrom;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UNSUCCESS_LOGIN_DATE")
	private Date lastUnsuccessLoginDate;

	@Column(name = "LAST_UNSUCCESS_LOGIN_FROM")
	private String lastUnsuccessLoginFrom;

	@Column(name = "LOCALE_CODE")
	private String localeCode;

	@Temporal(TemporalType.DATE)
	@Column(name = "LOCK_EXP_DATE")
	private Date lockExpDate;

	@Column(name = "MODIFIED_BY")
	private BigDecimal modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name = "NUMBER_OF_WRONG_LOGINS")
	private BigDecimal numberOfWrongLogins;

	@Column(name = "NUMERIC_CODE")
	private String numericCode;

	private String passwd;

	@Column(name = "PWD_ALGORITHM")
	private String pwdAlgorithm;

	@Temporal(TemporalType.DATE)
	@Column(name = "PWD_EXP_DATE")
	private Date pwdExpDate;

	@Column(name = "PWD_EXP_INTERVAL")
	private BigDecimal pwdExpInterval;

	@Column(name = "SELF_REGISTRATION_ID")
	private String selfRegistrationId;

	private String status;

	@Column(name = "TIME_ZONE_CODE")
	private String timeZoneCode;

	@Column(name = "USR_LOGIN")
	private String usrLogin;

	// bi-directional many-to-one association to UsersPlus
	@OneToMany(mappedBy = "user")
	private List<UsersPlus> usersPluses;

	public User() {
	}

	public long getPersonId() {
		return this.personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public Date getAccountExpDate() {
		return this.accountExpDate;
	}

	public void setAccountExpDate(Date accountExpDate) {
		this.accountExpDate = accountExpDate;
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

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getDateCode() {
		return this.dateCode;
	}

	public void setDateCode(String dateCode) {
		this.dateCode = dateCode;
	}

	public String getDelegationCode() {
		return this.delegationCode;
	}

	public void setDelegationCode(String delegationCode) {
		this.delegationCode = delegationCode;
	}

	public String getDescn() {
		return this.descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public String getDn() {
		return this.dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getGeneralTimeout() {
		return this.generalTimeout;
	}

	public void setGeneralTimeout(BigDecimal generalTimeout) {
		this.generalTimeout = generalTimeout;
	}

	public BigDecimal getIdleTimeout() {
		return this.idleTimeout;
	}

	public void setIdleTimeout(BigDecimal idleTimeout) {
		this.idleTimeout = idleTimeout;
	}

	public Date getLastSuccessLoginDate() {
		return this.lastSuccessLoginDate;
	}

	public void setLastSuccessLoginDate(Date lastSuccessLoginDate) {
		this.lastSuccessLoginDate = lastSuccessLoginDate;
	}

	public String getLastSuccessLoginFrom() {
		return this.lastSuccessLoginFrom;
	}

	public void setLastSuccessLoginFrom(String lastSuccessLoginFrom) {
		this.lastSuccessLoginFrom = lastSuccessLoginFrom;
	}

	public Date getLastUnsuccessLoginDate() {
		return this.lastUnsuccessLoginDate;
	}

	public void setLastUnsuccessLoginDate(Date lastUnsuccessLoginDate) {
		this.lastUnsuccessLoginDate = lastUnsuccessLoginDate;
	}

	public String getLastUnsuccessLoginFrom() {
		return this.lastUnsuccessLoginFrom;
	}

	public void setLastUnsuccessLoginFrom(String lastUnsuccessLoginFrom) {
		this.lastUnsuccessLoginFrom = lastUnsuccessLoginFrom;
	}

	public String getLocaleCode() {
		return this.localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	public Date getLockExpDate() {
		return this.lockExpDate;
	}

	public void setLockExpDate(Date lockExpDate) {
		this.lockExpDate = lockExpDate;
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

	public BigDecimal getNumberOfWrongLogins() {
		return this.numberOfWrongLogins;
	}

	public void setNumberOfWrongLogins(BigDecimal numberOfWrongLogins) {
		this.numberOfWrongLogins = numberOfWrongLogins;
	}

	public String getNumericCode() {
		return this.numericCode;
	}

	public void setNumericCode(String numericCode) {
		this.numericCode = numericCode;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPwdAlgorithm() {
		return this.pwdAlgorithm;
	}

	public void setPwdAlgorithm(String pwdAlgorithm) {
		this.pwdAlgorithm = pwdAlgorithm;
	}

	public Date getPwdExpDate() {
		return this.pwdExpDate;
	}

	public void setPwdExpDate(Date pwdExpDate) {
		this.pwdExpDate = pwdExpDate;
	}

	public BigDecimal getPwdExpInterval() {
		return this.pwdExpInterval;
	}

	public void setPwdExpInterval(BigDecimal pwdExpInterval) {
		this.pwdExpInterval = pwdExpInterval;
	}

	public String getSelfRegistrationId() {
		return this.selfRegistrationId;
	}

	public void setSelfRegistrationId(String selfRegistrationId) {
		this.selfRegistrationId = selfRegistrationId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimeZoneCode() {
		return this.timeZoneCode;
	}

	public void setTimeZoneCode(String timeZoneCode) {
		this.timeZoneCode = timeZoneCode;
	}

	public String getUsrLogin() {
		return this.usrLogin;
	}

	public void setUsrLogin(String usrLogin) {
		this.usrLogin = usrLogin;
	}

	public List<UsersPlus> getUsersPluses() {
		return this.usersPluses;
	}

	public void setUsersPluses(List<UsersPlus> usersPluses) {
		this.usersPluses = usersPluses;
	}

}