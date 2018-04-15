package com.chubb.dgmk.caf.domain.resource;



public class ResultIdentifierResource {
	
	public String accountName;
	public String accountGroupId;
	public String wipInsuredNumber;
	public String mailingAddress;
	
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountGroupId() {
		return accountGroupId;
	}
	public void setAccountGroupId(String accountGroupId) {
		this.accountGroupId = accountGroupId;
	}
	public String getWipInsuredNumber() {
		return wipInsuredNumber;
	}
	public void setWipInsuredNumber(String wipInsuredNumber) {
		this.wipInsuredNumber = wipInsuredNumber;
	}
	public String getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	
	

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Account Group Id: " + this.getAccountGroupId());
		sb.append(", Account Name: " + this.getAccountName());
		sb.append(", Mailing Address: " + this.getMailingAddress());
		sb.append(", Wip Insured Number: " + this.getWipInsuredNumber());
	return sb.toString();
	}

}
