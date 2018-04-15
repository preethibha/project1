package com.chubb.dgmk.caf.domain.resource;

import java.util.List;

public class AccountGroupResource {

	public String accountName;
	public String accountGroupId;
	public String wipInsuredNumber;
	public String address;
	
	public List<AccountResource> accounts;
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<AccountResource> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountResource> accounts) {
		this.accounts = accounts;
	}

}
