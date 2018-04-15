package com.chubb.dgmk.caf.domain.model;

public class Branch {

	private String branchName;
	private String branchAbbreviation;
	private String branchNumber;
	private String branchCode;
	private String branchPhoneNumber;
	private String branchFaxNumber;
	private String zoneNumber;
	private String branchMailingLabelName;
	private String foreignBranchIndicator;

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the branchAbbreviation
	 */
	public String getBranchAbbreviation() {
		return branchAbbreviation;
	}

	/**
	 * @param branchAbbreviation the branchAbbreviation to set
	 */
	public void setBranchAbbreviation(String branchAbbreviation) {
		this.branchAbbreviation = branchAbbreviation;
	}

	/**
	 * @return the branchNumber
	 */
	public String getBranchNumber() {
		return branchNumber;
	}

	/**
	 * @param branchNumber the branchNumber to set
	 */
	public void setBranchNumber(String branchNumber) {
		this.branchNumber = branchNumber;
	}

	/**
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * @return the branchPhoneNumber
	 */
	public String getBranchPhoneNumber() {
		return branchPhoneNumber;
	}

	/**
	 * @param branchPhoneNumber the branchPhoneNumber to set
	 */
	public void setBranchPhoneNumber(String branchPhoneNumber) {
		this.branchPhoneNumber = branchPhoneNumber;
	}

	/**
	 * @return the branchFaxNumber
	 */
	public String getBranchFaxNumber() {
		return branchFaxNumber;
	}

	/**
	 * @param branchFaxNumber the branchFaxNumber to set
	 */
	public void setBranchFaxNumber(String branchFaxNumber) {
		this.branchFaxNumber = branchFaxNumber;
	}

	/**
	 * @return the zoneNumber
	 */
	public String getZoneNumber() {
		return zoneNumber;
	}

	/**
	 * @param zoneNumber the zoneNumber to set
	 */
	public void setZoneNumber(String zoneNumber) {
		this.zoneNumber = zoneNumber;
	}

	/**
	 * @return the branchMailingLabelName
	 */
	public String getBranchMailingLabelName() {
		return branchMailingLabelName;
	}

	/**
	 * @param branchMailingLabelName the branchMailingLabelName to set
	 */
	public void setBranchMailingLabelName(String branchMailingLabelName) {
		this.branchMailingLabelName = branchMailingLabelName;
	}

	/**
	 * @return the foreignBranchIndicator
	 */
	public String getForeignBranchIndicator() {
		return foreignBranchIndicator;
	}

	/**
	 * @param foreignBranchIndicator the foreignBranchIndicator to set
	 */
	public void setForeignBranchIndicator(String foreignBranchIndicator) {
		this.foreignBranchIndicator = foreignBranchIndicator;
	}
	



	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Branch Name: " + this.getBranchName());
		sb.append(", Branch Abbreviation: " + this.getBranchAbbreviation());
		sb.append(", Branch Number: " + this.getBranchNumber());
		sb.append(", Branch Code: " + this.getBranchCode());
		sb.append(", Branch PhoneNumber: " +this.getBranchPhoneNumber());
		sb.append(", Branch FaxNumber: " +this.getBranchFaxNumber());
		sb.append(", Zone Number: " +this.getZoneNumber());
		sb.append(", Branch MailingLabelName: " +this.getBranchMailingLabelName());
		sb.append(", Foreign Branch Indicator: " +this.getForeignBranchIndicator());
		
		return sb.toString();
	}
}
