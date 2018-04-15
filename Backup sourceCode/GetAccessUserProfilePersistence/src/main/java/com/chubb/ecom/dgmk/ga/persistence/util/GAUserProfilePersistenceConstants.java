package com.chubb.ecom.dgmk.ga.persistence.util;

public interface GAUserProfilePersistenceConstants {

	// Named Query Constants

	public static final String QUERY_USER_BY_EMAIL = "User.findUserByEmail";
	public static final String QUERY_USER_BY_USER_LOGIN = "User.findUserByUserLogin";
	public static final String QUERY_USER_BY_COMMON_USER_GIN = "UserPlus.findUserByCommonUserGin";
	public static final String QUERY_ROLE_BY_CODE = "AuthRole.findRoleByCode";
}
