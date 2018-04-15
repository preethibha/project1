package com.chubb.ecom.dgmk.ga.util;

import org.apache.commons.lang.RandomStringUtils;

public class PasswordGenerator {

	/**
	 * Randomly generated temporary password.
	 * 
	 * Rules:
	 *  - 8 positions in length
	 *  - Must include at least 1 numeric and 2 alphanumeric
	 *  - Must include 1 lower-case and 1 upper-case alphanumerics
	 * 
	 * @return the string
	 */
	public static String generateTempPassword() {
		
		return RandomStringUtils.randomAlphanumeric(4) + RandomStringUtils.randomNumeric(4);
	}
}
