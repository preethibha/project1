package com.chubb.ecom.dgmk.ga.persistence.eao;

import java.util.List;

import com.chubb.ecom.dgmk.ga.exception.GAUserProfileDataException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileDataNotFoundException;
import com.chubb.ecom.dgmk.ga.persistence.entity.AuthRole;
import com.chubb.ecom.dgmk.ga.persistence.entity.User;

public interface GetAccessUserProfileEAO {

	/**
	 * Lookup user login by cmn usr gin.
	 * 
	 * @param commonUserGin
	 *            the common user gin
	 * @return the string list
	 * @throws Exception
	 *             the exception
	 */
	public List<String> lookupUserLoginByCmnUsrGin(String commonUserGin) throws GAUserProfileDataException;

	/**
	 * Lookup user login by email.
	 * 
	 * @param email
	 *            the email
	 * @return the string list
	 * @throws Exception
	 *             the exception
	 */
	public List<String> lookupUserLoginByEmail(String email) throws GAUserProfileDataException;

	/**
	 * Lookup user by user login.
	 *
	 * @param userLogin the user login
	 * @return the user
	 * @throws GAUserProfileDataException the gA user profile data exception
	 * @throws GAUserProfileDataNotFoundException the GA user profile data not found exception
	 */
	public User lookupUserByUserLogin(String userLogin) throws GAUserProfileDataException, GAUserProfileDataNotFoundException;

	/**
	 * Find role by code.
	 *
	 * @param accessControlGroupCategoryCode the access control group category code
	 * @param accessControlGroupCode the access control group code
	 * @return the auth role
	 * @throws GAUserProfileDataException the GA user profile data exception
	 * @throws GAUserProfileDataNotFoundException the GA user profile data not found exception
	 */
	public AuthRole findRoleByCode(String accessControlGroupCategoryCode, String accessControlGroupCode) throws GAUserProfileDataException, GAUserProfileDataNotFoundException;

}