/**
 * 
 */
package com.chubb.dgmk.caf.domain.model;

import java.util.List;

/**
 * @author npgmh31
 *
 */
public class UserInformation {
	private String givenName;
	private String surname;
	private String middlename;
	private String userid;
	private String externalUserId;
	private String email;
	private String userType;
	private String  userTypeCode;
	private List<String> producerkeys;
	private List<String> pasKeys;
	/**
	 * @return the givenName
	 */
	public String getGivenName() {
		return givenName;
	}
	/**
	 * @param givenName the givenName to set
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the middlename
	 */
	public String getMiddlename() {
		return middlename;
	}
	/**
	 * @param middlename the middlename to set
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return the externalUserId
	 */
	public String getExternalUserId() {
		return externalUserId;
	}
	/**
	 * @param externalUserId the externalUserId to set
	 */
	public void setExternalUserId(String externalUserId) {
		this.externalUserId = externalUserId;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the userTypeCode
	 */
	public String getUserTypeCode() {
		return userTypeCode;
	}
	/**
	 * @param userTypeCode the userTypeCode to set
	 */
	public void setUserTypeCode(String userTypeCode) {
		this.userTypeCode = userTypeCode;
	}
	/**
	 * @return the producerkeys
	 */
	public List<String> getProducerkeys() {
		return producerkeys;
	}
	/**
	 * @param producerkeys the producerkeys to set
	 */
	public void setProducerkeys(List<String> producerkeys) {
		this.producerkeys = producerkeys;
	}
	/**
	 * @return the pasKeys
	 */
	public List<String> getPasKeys() {
		return pasKeys;
	}
	/**
	 * @param pasKeys the pasKeys to set
	 */
	public void setPasKeys(List<String> pasKeys) {
		this.pasKeys = pasKeys;
	}
}
