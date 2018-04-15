package com.chubb.dgmk.caf.domain.model;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

public class Policy {
	
	private List<Contact> contacts;
	
	private String acountGroupId;
	private String policyNumber;
	private String insurerProductCode;
	private String productComponentName;
	private String displayProductTypeName;
	private String policyTypeCode;
	private XMLGregorianCalendar expirationDate;
	private String policyStatus;
	private String policyTerm;
	private XMLGregorianCalendar InceptionDate;
	private String producingBranchCode;
	private String servicingBranchCode;
	private String cpNumber;
	private Contact uwContact;
	private Contact uwAssistantContact;
	private Contact asrContact;
	private String policyTypeSubCode;
	private String policyStatusCode;
	
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public String getAcountGroupId() {
		return acountGroupId;
	}
	public void setAcountGroupId(String acountGroupId) {
		this.acountGroupId = acountGroupId;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getInsurerProductCode() {
		return insurerProductCode;
	}
	public void setInsurerProductCode(String insurerProductCode) {
		this.insurerProductCode = insurerProductCode;
	}
	public String getProductComponentName() {
		return productComponentName;
	}
	public void setProductComponentName(String productComponentName) {
		this.productComponentName = productComponentName;
	}
	public String getDisplayProductTypeName() {
		return displayProductTypeName;
	}
	public void setDisplayProductTypeName(String displayProductTypeName) {
		this.displayProductTypeName = displayProductTypeName;
	}
	public String getPolicyTypeCode() {
		return policyTypeCode;
	}
	public void setPolicyTypeCode(String policyTypeCode) {
		this.policyTypeCode = policyTypeCode;
	}
	public XMLGregorianCalendar getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(XMLGregorianCalendar expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	public String getPolicyTerm() {
		return policyTerm;
	}
	public void setPolicyTerm(String policyTerm) {
		this.policyTerm = policyTerm;
	}
	public XMLGregorianCalendar getInceptionDate() {
		return InceptionDate;
	}
	public void setInceptionDate(XMLGregorianCalendar inceptionDate) {
		InceptionDate = inceptionDate;
	}
	public String getProducingBranchCode() {
		return producingBranchCode;
	}
	public void setProducingBranchCode(String producingBranchCode) {
		this.producingBranchCode = producingBranchCode;
	}
	public String getServicingBranchCode() {
		return servicingBranchCode;
	}
	public void setServicingBranchCode(String servicingBranchCode) {
		this.servicingBranchCode = servicingBranchCode;
	}
	
	public String getCpNumber() {
		return cpNumber;
	}
	public void setCpNumber(String cpNumber) {
		this.cpNumber = cpNumber;
	}
	public Contact getUwContact() {
		return uwContact;
	}
	public void setUwContact(Contact uwContact) {
		this.uwContact = uwContact;
	}
	public Contact getUwAssistantContact() {
		return uwAssistantContact;
	}
	public void setUwAssistantContact(Contact uwAssistantContact) {
		this.uwAssistantContact = uwAssistantContact;
	}
	public Contact getAsrContact() {
		return asrContact;
	}
	public void setAsrContact(Contact asrContact) {
		this.asrContact = asrContact;
	}
	public String getPolicyTypeSubCode() {
		return policyTypeSubCode;
	}
	public void setPolicyTypeSubCode(String policyTypeSubCode) {
		this.policyTypeSubCode = policyTypeSubCode;
	}
	public String getPolicyStatusCode() {
		return policyStatusCode;
	}
	public void setPolicyStatusCode(String policyStatusCode) {
		this.policyStatusCode = policyStatusCode;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Acount GroupId: " + this.getAcountGroupId());
		sb.append(", Policy Number: " + this.getPolicyNumber());
		sb.append(", Insurer Product Code: " + this.getInsurerProductCode());
		sb.append(", Product Component Name: " + this.getProductComponentName());
		sb.append(", Display Product Type Name: " + this.getDisplayProductTypeName());
	    sb.append(", Policy Type Code: " + this.getPolicyTypeCode());
	    sb.append(", Expiration Date: " + setDateFormat(this.getExpirationDate()));
	    sb.append(", Policy Status: " +this.getPolicyStatus());
	    sb.append(", Policy Term: " +this.getPolicyTerm());
	    sb.append(", Inception Date: " + setDateFormat(this.getInceptionDate()));
	    sb.append(", Producing Branch Code: " +this.getProducingBranchCode());
	    sb.append(", CpNumber: " +this.getCpNumber());
	    if (this.getUwContact()!=null)
	    sb.append(", uwContact: " +this.getUwContact().toString());
	    sb.append(", Servicing Branch Code: " +this.getServicingBranchCode());
	    if (this.getUwAssistantContact()!=null)
	    sb.append(", uwAssistant Contact: " +this.getUwAssistantContact().toString());
	    if (this.getAsrContact()!=null)
	    sb.append(", asrContact: " +this.getAsrContact().toString());
	    sb.append(", policyTypeSubCode: " +this.getPolicyTypeSubCode());
	    sb.append(", policyStausCode: " +this.getPolicyStatusCode());
		
		
		return sb.toString();
	}
	private String setDateFormat(XMLGregorianCalendar date){
		
		if (date != null)
		{
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy hh:mm");
		GregorianCalendar gc = date.toGregorianCalendar();
		String formatted_date = sdf.format(gc.getTime());
		return formatted_date;
		}
		else
		{
			return null;
		}
	}
}
