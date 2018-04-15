package com.chubb.dgmk.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserBaseDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4517176943347132780L;
	private String externalUserId;
	private Long cmnUserGin;
	private Date effectiveDate;
	private String personGIN;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;
	private String streetAddressLine1;
	private String streetAddressLine2;
	private String cityName;
	private String stateCode;
	private String stateName;
	private String postalCode;
	private String countryCode;
	private String countryName;
	private String producerNumber;
	private String producerSubNumber;
	private String producerName;
	private String orgRoleName;
	private String companyName;
	private String userTypeCode;
	private String userTypeDescription;
	private String statusCode;
	private String languageLocale;
	private String timezone;
	private String delegationCode;
	private String tempPassword;
	private List<RoleDO> roles = new ArrayList<RoleDO>();
	private List<ApplicationDO> applications = new ArrayList<ApplicationDO>();	
	private String prvsnGroupType;
	
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getExternalUserId() {
		return externalUserId;
	}

	public void setExternalUserId(String externalUserId) {
		this.externalUserId = externalUserId;
	}

	public Long getCmnUserGin() {
		return cmnUserGin;
	}

	public void setCmnUserGin(Long cmnUserGin) {
		this.cmnUserGin = cmnUserGin;
	}

	public String getPersonGIN() {
		return personGIN;
	}

	
	public void setPersonGIN(String personGIN) {
		this.personGIN = personGIN;
	}
	
	
	
	public String getPrvsnGroupType() {
		return prvsnGroupType;
	}

	public void setPrvsnGroupType(String prvsnGroupType) {
		this.prvsnGroupType = prvsnGroupType;
	}

	public String getOrgRoleName() {
		return orgRoleName;
	}

	public void setOrgRoleName(String orgRoleName) {
		this.orgRoleName = orgRoleName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStreetAddressLine1() {
		return streetAddressLine1;
	}

	public void setStreetAddressLine1(String streetAddressLine1) {
		this.streetAddressLine1 = streetAddressLine1;
	}

	public String getStreetAddressLine2() {
		return streetAddressLine2;
	}

	public void setStreetAddressLine2(String streetAddressLine2) {
		this.streetAddressLine2 = streetAddressLine2;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getProducerNumber() {
		return producerNumber;
	}

	public void setProducerNumber(String producerNumber) {
		this.producerNumber = producerNumber;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<RoleDO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDO> roles) {
		this.roles = roles;
	}

	public List<ApplicationDO> getApplications() {
		return applications;
	}

	public void setApplications(List<ApplicationDO> applications) {
		this.applications = applications;
	}

	public String getProducerSubNumber() {
		return producerSubNumber;
	}

	public void setProducerSubNumber(String producerSubNumber) {
		this.producerSubNumber = producerSubNumber;
	}

	public String getUserTypeCode() {
		return userTypeCode;
	}

	public void setUserTypeCode(String userTypeCode) {
		this.userTypeCode = userTypeCode;
	}

	public String getUserTypeDescription() {
		return userTypeDescription;
	}

	public void setUserTypeDescription(String userTypeDescription) {
		this.userTypeDescription = userTypeDescription;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getLanguageLocale() {
		return languageLocale;
	}

	public void setLanguageLocale(String languageLocale) {
		this.languageLocale = languageLocale;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getDelegationCode() {
		return delegationCode;
	}

	public void setDelegationCode(String delegationCode) {
		this.delegationCode = delegationCode;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}
}
