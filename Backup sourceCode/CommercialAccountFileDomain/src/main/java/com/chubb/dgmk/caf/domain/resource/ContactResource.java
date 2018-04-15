package com.chubb.dgmk.caf.domain.resource;

import com.chubb.dgmk.caf.util.ICAFConstants;

public class ContactResource {
	
	private String underwriterId; //cpNumber
	private String name;
	private String phoneNumber;
	private String productName;
	private String branchName;
	private String emailAddress;
	private String cellPhoneNumber;
	private String role;
	//additional attributes...
	public String getUnderwriterId() {
		return underwriterId;
	}
	public void setUnderwriterId(String underwriterId) {
		this.underwriterId = underwriterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}
	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getDefaultRole(String role) {
		if(ICAFConstants.CONTACT_UNDERWRITER_ASSISTANT.equalsIgnoreCase(role)
				|| ICAFConstants.CONTACT_ACCOUNT_SERVICE_REPRESENTATIVE.equalsIgnoreCase(role)
				|| ICAFConstants.CONTACT_TYPE_ABBR_UND.equalsIgnoreCase(role)
		){
			role= ICAFConstants.DEFAULT_ROLE;
		}
		
		return role;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Under Writer Id: " + this.getUnderwriterId());
		sb.append("Phone Number: " + this.getPhoneNumber());
		sb.append("Product Name: " + this.getProductName());
		sb.append("Branch Name: " + this.getBranchName());
		sb.append("Email Address: " + this.getEmailAddress());
		sb.append("Cell Phone Number: " + this.getCellPhoneNumber());
		sb.append("Name: " + this.getName());
		sb.append("Role: " + this.getRole());
		
		
		return sb.toString();
	}
	
}
