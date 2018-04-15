package com.chubb.dgmk.caf.domain.resource;

import java.util.List;

import com.chubb.dgmk.caf.domain.model.UserInformation;

public class ResourceRequestResult {

	public ResultIdentifierResource getResultIdResource() {
		return resultIdResource;
	}
	public void setResultIdResource(ResultIdentifierResource resultIdResource) {
		this.resultIdResource = resultIdResource;
	}
	public String statusCode="S";
	public String statusMessage="";
	
	public ResultIdentifierResource resultIdResource;
	public List<AccountGroupResource> accountGroupList;
	public List<AccountResource> accountList;
	public List<BranchResource> branchList;
	public List<ContactResource> contactList;
	public List<PolicyResource> policyList;
	public List<ProducerResource> producerList;
	public List<ProductResource> productList;
	public List<CountryResource> countryList;
	public UserInformation userInformation;
	
	/**
	 * @return the userInformation
	 */
	public UserInformation getUserInformation() {
		return userInformation;
	}
	/**
	 * @param userInformation the userInformation to set
	 */
	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}
	public List<CountryResource> getCountryList() {
		return countryList;
	}
	public void setCountryList(List<CountryResource> countryList) {
		this.countryList = countryList;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public List<AccountGroupResource> getAccountGroupList() {
		return accountGroupList;
	}
	public void setAccountGroupList(List<AccountGroupResource> accountGroupList) {
		this.accountGroupList = accountGroupList;
	}
	public List<AccountResource> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<AccountResource> accountList) {
		this.accountList = accountList;
	}
	public List<BranchResource> getBranchList() {
		return branchList;
	}
	public void setBranchList(List<BranchResource> branchList) {
		this.branchList = branchList;
	}
	public List<ContactResource> getContactList() {
		return contactList;
	}
	public void setContactList(List<ContactResource> contactList) {
		this.contactList = contactList;
	}
	public List<PolicyResource> getPolicyList() {
		return policyList;
	}
	public void setPolicyList(List<PolicyResource> policyList) {
		this.policyList = policyList;
	}
	public List<ProducerResource> getProducerList() {
		return producerList;
	}
	public void setProducerList(List<ProducerResource> producerList) {
		this.producerList = producerList;
	}
	public List<ProductResource> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductResource> productList) {
		this.productList = productList;
	}

}
