package com.chubb.dgmk.caf.domain.model;

public class PasKey {

	private String producerNumber;
	private String producerSubNumber;
	private String producerName;
	private String streetAddressLine1;
	private String mailingAddress;
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
    private String pasNumber;

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

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	/**
	 * @return the branchName
	 */
	public String getProducerNumber() {
		return producerNumber;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setProducerNumber(String producerNumber) {
		this.producerNumber = producerNumber;
	}

	/**
	 * @return the branchName
	 */
	public String getProducerSubNumber() {
		return producerSubNumber;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setProducerSubNumber(String producerSubNumber) {
		this.producerSubNumber = producerSubNumber;
	}

	/**
	 * @return the branchName
	 */
	public String getProducerName() {
		return producerName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	/**
	 * @return the branchName
	 */
	public String getStreetAddressLine1() {
		return streetAddressLine1;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setStreetAddressLine1(String streetAddressLine1) {
		this.streetAddressLine1 = streetAddressLine1;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
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
	
	

	/**
	 * @return the pasNumber
	 */
	public String getPasNumber() {
		return pasNumber;
	}

	/**
	 * @param pasNumber the pasNumber to set
	 */
	public void setPasNumber(String pasNumber) {
		this.pasNumber = pasNumber;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Producer Number: " + this.getProducerNumber());
		sb.append(", Producer SubNumber: " + this.getProducerSubNumber());
		sb.append(", Producer Name: " + this.getProducerName());
		sb.append(", StreetAddressLine1: " + this.getStreetAddressLine1());
		sb.append(", MailingAddress: " +this.getMailingAddress());
		sb.append(", PasKey: " +this.getPasNumber());

		
		return sb.toString();
	}
}
