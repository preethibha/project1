package com.chubb.dgmk.caf.domain.resource;

import java.util.Comparator;

public class CountryResource {
	private String countryName;
	private String countryCode;
	

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	



	
	/**
	 * Comparator for CountryResource (country) list to sort by country name
	 */
	public static final Comparator<CountryResource> CountryComparator = new Comparator<CountryResource>(){

		@Override
		public int compare(CountryResource object1, CountryResource object2) {
			return object1.getCountryName().compareTo(object2.getCountryName());
		}

	};
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Country Name: " + this.getCountryName());
		sb.append("Country Code: " + this.getCountryCode());
		
		return sb.toString();
	}
}
