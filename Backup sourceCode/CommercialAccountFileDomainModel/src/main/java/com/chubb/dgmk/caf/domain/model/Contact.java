package com.chubb.dgmk.caf.domain.model;

public class Contact {
	
	private String name;
	private String cpNumber;
	private String role;
	private String givenName;
	private String middleInitial;
	private String surname;
	private String nameSuffix;
	private String emailAddress;
	private String phoneNumber;
	private String cellPhoneNumber;
	private String individualFullName;
	private String nickName;
	public String productName;
	public String branchName;
	
	private String addressLine1;
	private String cityName;
    private String postalCode;
    private String countryCode;
    
  //additional attributes...
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpNumber() {
		return cpNumber;
	}
	public void setCpNumber(String cpNumber) {
		this.cpNumber = cpNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getNameSuffix() {
		return nameSuffix;
	}
	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
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
	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}
	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}
	public String getIndividualFullName() {
		return individualFullName;
	}
	public void setIndividualFullName(String individualFullName) {
		this.individualFullName = individualFullName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Email Address: " + this.getEmailAddress());
		sb.append(", PhoneNumber: " + this.getPhoneNumber());
		sb.append(", Cell Phone Number: " + this.getCellPhoneNumber());
		sb.append(", Given Name: " + this.getGivenName());
		sb.append(", Role: " + this.getRole());
	    sb.append(", cp Number: " +this.getCpNumber());
	    sb.append(", Name: " +this.getName());
		
		
		return sb.toString();
	}
}
