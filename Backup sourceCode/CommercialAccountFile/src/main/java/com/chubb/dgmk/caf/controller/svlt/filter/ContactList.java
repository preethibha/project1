package com.chubb.dgmk.caf.controller.svlt.filter;

import java.util.List;

import com.ibm.json.java.JSONObject;

public class ContactList {


	public String policyNumber ;
	public String cpNumber ;
	public String policyTypeCode;
	public String branchNumber ;
	public String policySubTypeCode ;
	public String policyTerm;
	public String displayProductTypeName;
	public String policyStatus;
	public List<com.ibm.json.java.JSONObject> contactsJson;
		
	public ContactList()
	{
		super();
	}	
	
	public List<com.ibm.json.java.JSONObject> getContactsJson() {
		return contactsJson;
	}
	public void setContactsJson(List<com.ibm.json.java.JSONObject> contactsJson) {
		this.contactsJson = contactsJson;
	}
	public ContactList(String policyNumber,String cpNumber,String policyTypeCode,String branchNumber,String policySubTypeCode,String policyTerm,String displayProductTypeName,String policyStatus,List<JSONObject> contactsJson){
		this.setPolicyNumber(policyNumber);
		this.setCpNumber(cpNumber);
		this.setPolicyTypeCode(policyTypeCode);
		this.setBranchNumber(branchNumber);
		this.setPolicySubTypeCode(policySubTypeCode);
		this.setPolicyTerm(policyTerm);
		this.setDisplayProductTypeName(displayProductTypeName);
		this.setPolicyStatus(policyStatus);
		this.setContactsJson(contactsJson);
		
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Policy Number: " + this.getPolicyNumber());
		sb.append(", CP Number: " + this.getCpNumber());
		sb.append(", Policy Type Code" + this.getPolicyTypeCode());
		sb.append(", Branch Number" + this.getBranchNumber());
		sb.append(", Policy Sub Type Code"+ this.getPolicySubTypeCode());
		sb.append(", Policy Term " + this.getPolicyTerm());
		sb.append(", Display Product Type Name" + this.getDisplayProductTypeName());
		sb.append(", Policy Status " + this.getPolicyStatus());
		if (this.getContactsJson()!=null)
		sb.append(", Contacts Json" + this.getContactsJson().toString());
		
		return sb.toString();
	}
		
	public String getPolicyNumber() {
		return policyNumber;
	}


	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}


	public String getCpNumber() {
		return cpNumber;
	}


	public void setCpNumber(String cpNumber) {
		this.cpNumber = cpNumber;
	}


	public String getPolicyTypeCode() {
		return policyTypeCode;
	}


	public void setPolicyTypeCode(String policyTypeCode) {
		this.policyTypeCode = policyTypeCode;
	}


	public String getBranchNumber() {
		return branchNumber;
	}


	public void setBranchNumber(String branchNumber) {
		this.branchNumber = branchNumber;
	}


	public String getPolicySubTypeCode() {
		return policySubTypeCode;
	}


	public void setPolicySubTypeCode(String policySubTypeCode) {
		this.policySubTypeCode = policySubTypeCode;
	}


	public String getPolicyTerm() {
		return policyTerm;
	}


	public void setPolicyTerm(String policyTerm) {
		this.policyTerm = policyTerm;
	}


	public String getDisplayProductTypeName() {
		return displayProductTypeName;
	}


	public void setDisplayProductTypeName(String displayProductTypeName) {
		this.displayProductTypeName = displayProductTypeName;
	}


	public String getPolicyStatus() {
		return policyStatus;
	}


	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}


	

	
	
	
		
	
		
	

	}

