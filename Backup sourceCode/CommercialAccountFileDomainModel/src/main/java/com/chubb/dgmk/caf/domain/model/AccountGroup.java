package com.chubb.dgmk.caf.domain.model;

import java.util.ArrayList;
import java.util.List;

public class AccountGroup {

	public String accountGroupId;
	public String accountGroupName;
	public List<Account> accounts;
	
	public String getAccountGroupId() {
		return accountGroupId;
	}
	public void setAccountGroupId(String accountGroupId) {
		this.accountGroupId = accountGroupId;
	}
	public String getAccountGroupName() {
		return accountGroupName;
	}
	public void setAccountGroupName(String accountGroupName) {
		this.accountGroupName = accountGroupName;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public void addAccount(Account account){
		if (getAccounts() == null)
			setAccounts(new ArrayList<Account>());
		getAccounts().add(account);
		
	}
}
