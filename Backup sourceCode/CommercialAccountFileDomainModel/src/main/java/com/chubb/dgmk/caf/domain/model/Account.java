package com.chubb.dgmk.caf.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

	public List<Policy> policies;
	private String insuredName;
	private String insuredTypeCode;
	private String CPNumber;
	private String wipInsuredNumber;
	private String addressLine1;
	private String addressLine2;
    private String addressLine3;
    private String cityName;
    private String countyName;
    private String stateOrProvinceCode;
    private String stateOrProvinceName;
    private String stateOrProvinceAbbreviation;
    private String postalStateAbbreviation;
    private String postalCode;
    private String countryCode;
    private String countryName;
    private String countryAbbreviation;
    private String isoCountryCode;
    private String locationPlaceCode;
    
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
	public String getCPNumber() {
		return CPNumber;
	}
	public void setCPNumber(String CPNumber) {
		this.CPNumber = CPNumber;
	}
	
	public String getWipInsuredNumber() {
		return wipInsuredNumber;
	}
	public void setWipInsuredNumber(String wipInsuredNumber) {
		this.wipInsuredNumber = wipInsuredNumber;
	}
	public List<Policy> getPolicies() {
		return policies;
	}
	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}
	public String getAddressLine1() {
		if (addressLine1 == null)
			return "";
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		if (addressLine2 == null)
			return "";
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
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getStateOrProvinceCode() {
		return stateOrProvinceCode;
	}
	public void setStateOrProvinceCode(String stateOrProvinceCode) {
		this.stateOrProvinceCode = stateOrProvinceCode;
	}
	public String getStateOrProvinceName() {
		return stateOrProvinceName;
	}
	public void setStateOrProvinceName(String stateOrProvinceName) {
		this.stateOrProvinceName = stateOrProvinceName;
	}
	public String getStateOrProvinceAbbreviation() {
		return stateOrProvinceAbbreviation;
	}
	public void setStateOrProvinceAbbreviation(String stateOrProvinceAbbreviation) {
		this.stateOrProvinceAbbreviation = stateOrProvinceAbbreviation;
	}
	public String getPostalStateAbbreviation() {
		return postalStateAbbreviation;
	}
	public void setPostalStateAbbreviation(String postalStateAbbreviation) {
		this.postalStateAbbreviation = postalStateAbbreviation;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryAbbreviation() {
		return countryAbbreviation;
	}
	public void setCountryAbbreviation(String countryAbbreviation) {
		this.countryAbbreviation = countryAbbreviation;
	}
	public String getIsoCountryCode() {
		return isoCountryCode;
	}
	public void setIsoCountryCode(String isoCountryCode) {
		this.isoCountryCode = isoCountryCode;
	}
	public String getLocationPlaceCode() {
		return locationPlaceCode;
	}
	public void setLocationPlaceCode(String locationPlaceCode) {
		this.locationPlaceCode = locationPlaceCode;
	}
	public void addPolicy(Policy policy) {
		if (getPolicies() == null)
			setPolicies(new ArrayList<Policy>());
		getPolicies().add(policy);
		
	}
	
	public String friendlyAddress(){
		StringBuffer sb = new StringBuffer();
		
		if(this.getAddressLine1()!=null && !"".equals(this.getAddressLine1().trim())){
			sb.append(this.toCamelCase(this.getAddressLine1()) + ", ");
		}
		if(this.getAddressLine2()!=null && !"".equals(this.getAddressLine2().trim())){
			sb.append(this.toCamelCase(this.getAddressLine2()) + ", ");
		}
		if(this.getCityName()!=null && !"".equals(this.getCityName().trim())){
			sb.append(this.toCamelCase(this.getCityName()) + ", ");
		}
		if(this.getPostalStateAbbreviation()!=null && !"".equals(this.getPostalStateAbbreviation().trim())){
			sb.append(this.getPostalStateAbbreviation().toUpperCase() + ", ");
		}
		
		if(this.getCountryName()!=null && !"".equals(this.getCountryName().trim())){
			sb.append(this.toCamelCase(this.getCountryName()) + ", ");
		}
		
		if(this.getPostalCode()!=null && !"".equals(this.getPostalCode().trim())){
			sb.append(this.getPostalCode());
		}
		
		if (sb.length() > 0 && sb.charAt(sb.length()-2)==',') {
			sb.deleteCharAt(sb.length()-2);
		}
	
		return sb.toString();
		
	}
	
	private String toCamelCase(String test1)
	{
	    String[] split = test1.split(" ");

	    String ret = "";
	    for (int i=0;i<split.length;i++)
	    {
	        if (split[i].length()>1)
	        ret=ret+split[i].substring(0,1).toUpperCase()+split[i].substring(1).toLowerCase()+" ";
	        else 
	        ret=ret+split[i]+ " ";

	    }
	return ret.trim();
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" InsuredName: " + this.getInsuredName());
		sb.append(", InsuredTypeCode: " + this.getInsuredTypeCode());
		sb.append(", CPNumber: " + this.getCPNumber());
		sb.append(", wipInsuredNumber: " + this.getWipInsuredNumber());
		sb.append(", AddressLine1: " + this.getAddressLine1());
		sb.append(", AddressLine2: " + this.getAddressLine2());
		sb.append(", AddressLine3: " + this.getAddressLine3());
		sb.append(", City Name: " + this.getCityName());
		sb.append(", County Name: " + this.getCountryName());
		sb.append(", StateOrProvinceName: " + this.getStateOrProvinceName());
		sb.append(", stateOrProvinceCode: " + this.getStateOrProvinceCode());
		sb.append(", stateOrProvinceAbbreviation: " + this.getStateOrProvinceAbbreviation());
		sb.append(", postalStateAbbreviation: " + this.getPostalStateAbbreviation());
		sb.append(", countryCode: " + this.getCountryCode());
		sb.append(", countryAbbreviation: " + this.getCountryAbbreviation());
		sb.append(", Country Name: " + this.getCountryName());
		sb.append(", Postal Code: " + this.getPostalCode());
		sb.append(", isoCountryCode: " + this.getIsoCountryCode());
		sb.append(", locationPlaceCode: " + this.getLocationPlaceCode());
		
		return sb.toString();
	}


    
}
