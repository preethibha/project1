package com.chubb.dgmk.caf.domain.resource;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.ICAFConstants;


public class PolicyResource {
	
	private List<ContactResource> contacts;
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
	private String cpNumber;
	private String producingBranchCode;
	private String servicingBranchCode;
	private String policyTypeSubCode;
	private String primaryPolicy="";
	
	private static final Map<String, String> DISPALY_STATUS_MAP;
	static {
		Map<String, String> stausMap = new HashMap<String, String>();

		stausMap.put(ICAFConstants.RENEWL_PENDING_KEY, ICAFConstants.RENEWL_PENDING_VAL);
		stausMap.put(ICAFConstants.WRITTEN_KEY, ICAFConstants.WRITTEN_VAL);
		stausMap.put(ICAFConstants.SUBMISSION_KEY, ICAFConstants.SUBMISSION_VAL);
		stausMap.put(ICAFConstants.CANCELLED_KEY, ICAFConstants.CANCELLED_VAL);
		stausMap.put(ICAFConstants.REJECTED_KEY, ICAFConstants.REJECTED_VAL);
		stausMap.put(ICAFConstants.DECLINED_KEY,ICAFConstants.DECLINED_VAL);
		stausMap.put(ICAFConstants.WRITTEN_DNR_KEY, ICAFConstants.WRITTEN_DNR_VAL);
		stausMap.put(ICAFConstants.REINSTATE_KEY, ICAFConstants.REINSTATE_VAL);
		stausMap.put(ICAFConstants.OFFERED_KEY, ICAFConstants.OFFERED_VAL);

		DISPALY_STATUS_MAP = Collections.unmodifiableMap(stausMap);
	}
  
	public List<ContactResource> getContacts() {
		return contacts;
	}
	public void setContacts(List<ContactResource> contacts) {
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
		if(DISPALY_STATUS_MAP.containsKey(policyStatus)){
			this.policyStatus=	DISPALY_STATUS_MAP.get(policyStatus);
		}else{
			this.policyStatus = policyStatus;
		}
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
	public String getCpNumber() {
		return cpNumber;
	}
	public void setCpNumber(String cpNumber) {
		this.cpNumber = cpNumber;
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
	public String getPolicyTypeSubCode() {
		return policyTypeSubCode;
	}
	public void setPolicyTypeSubCode(String policyTypeSubCode) {
		this.policyTypeSubCode = policyTypeSubCode;
	}

	public String getPrimaryPolicy() {
		return primaryPolicy;
	}
	public void setPrimaryPolicy(String primaryPolicy) {
		this.primaryPolicy = primaryPolicy;
	}

	/**
	 * Comparator for PolicyResource (InceptionDate) list to sort by Inception Date
	 */
	public static final Comparator<PolicyResource> PolicyComparator = new Comparator<PolicyResource>(){

		@Override
		public int compare(PolicyResource object1, PolicyResource object2) {
			return object2.getInceptionDate().compare(object1.getInceptionDate());
		}

	};
	
	

	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Policy Number: " + this.getPolicyNumber());
		sb.append(", Product Component Name: " + this.getProductComponentName());
		sb.append(", Insurer Product Code: " + this.getInsurerProductCode());
		sb.append(", Policy Type Code: " + this.getPolicyTypeCode());
		sb.append(", Display Product Type Name: " + this.getDisplayProductTypeName());
	    sb.append(", Policy Status: " + this.getPolicyStatus());
	    sb.append(", Expiration Date: " + setDateFormat(this.getExpirationDate()));
		sb.append(", Policy Term: " + this.getPolicyTerm());
		sb.append(", Inception Date: " + setDateFormat(this.getInceptionDate()));
		sb.append(", Cp Number: " + this.getCpNumber());
		sb.append(", Producing Branch Code: " + this.getProducingBranchCode());
		sb.append(", Cp Number: " + this.getCpNumber());
		sb.append(", Producing Branch Code: " + this.getProducingBranchCode());
		sb.append(", ServicingBranchCode: " + this.getServicingBranchCode());
		sb.append(", Policy Type SubCode: " + this.getPolicyTypeSubCode());
		List <ContactResource> contactResourceList = this.getContacts();
		for (ContactResource contactResource : contactResourceList)
		{
			sb.append(", Cell Phone Number: " + contactResource.getCellPhoneNumber());
			sb.append(", Phone Number: " + contactResource.getPhoneNumber());
			sb.append(", Underwriter Id: " + contactResource.getUnderwriterId());
			sb.append(", Email Address: " + contactResource.getEmailAddress());
			sb.append(", Role: " + contactResource.getRole());
			sb.append(", Name: " + contactResource.getName());
		}
		
		
		return sb.toString();
	}
	
	private String setDateFormat(XMLGregorianCalendar date){
		
		if (date != null)
		{
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy hh:mm:ss");
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
