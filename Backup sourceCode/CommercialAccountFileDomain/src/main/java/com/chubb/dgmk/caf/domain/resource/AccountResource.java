package com.chubb.dgmk.caf.domain.resource;

import java.util.Comparator;
import java.util.List;

public class AccountResource {
	
	public List<PolicyResource> policies;
	
	private String insuredName;
	private String insuredTypeCode;
	private String wipInsuredNumber;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
    private String cityName;
    private String stateOrProvinceName;	
    private String postalCode;
    private String countryName;
    private String insuredAddress;
    private String postalStateAbbreviation;
    private String countryAbbreviation;
    
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getInsuredTypeCode() {
		return insuredTypeCode;
	}
	public void setInsuredTypeCode(String insuredTypeCode) {
		this.insuredTypeCode = insuredTypeCode;
	}
	public String getWipInsuredNumber() {
		return wipInsuredNumber;
	}
	public void setWipInsuredNumber(String wipInsuredNumber) {
		this.wipInsuredNumber = wipInsuredNumber;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateOrProvinceName() {
		return stateOrProvinceName;
	}
	public void setStateOrProvinceName(String stateOrProvinceName) {
		this.stateOrProvinceName = stateOrProvinceName;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public String getInsuredAddress() {
		return insuredAddress;
	}
	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}
	
	public String getPostalStateAbbreviation() {
		return postalStateAbbreviation;
	}
	public void setPostalStateAbbreviation(String postalStateAbbreviation) {
		this.postalStateAbbreviation = postalStateAbbreviation;
	}
	
	public String getCountryAbbreviation() {
		return countryAbbreviation;
	}
	public void setCountryAbbreviation(String countryAbbreviation) {
		this.countryAbbreviation = countryAbbreviation;
	}


	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Insured Name: " + this.getInsuredName());
		sb.append(", Wip Insured Number: " + this.getWipInsuredNumber());
		sb.append(", Address Line1: " + this.getAddressLine1());
		sb.append(", Address Line2: " + this.getAddressLine2());
		sb.append(", Address Line3: "+ this.getAddressLine3());
		sb.append(", City Name: " + this.getCityName());
		sb.append(", State Or ProvinceName: " + this.getStateOrProvinceName());
		sb.append(", Country Name: " + this.getCountryName());
		sb.append(", Postal Code: " + this.getPostalCode());
		sb.append(", Insured Address: " + this.getInsuredAddress());
		
		
		return sb.toString();
	}
	
	
	/**
	 * Comparator for AccountResource (InsuredName) list to sort by InsuredName
	 */
	public static final Comparator<AccountResource> AccountComparator = new Comparator<AccountResource>(){

		@Override
		public int compare(AccountResource object1, AccountResource object2) {
			return object1.getInsuredName().compareTo(object2.getInsuredName());
		}

	};
}
