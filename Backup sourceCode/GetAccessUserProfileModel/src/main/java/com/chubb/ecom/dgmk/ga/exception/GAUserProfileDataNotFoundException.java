package com.chubb.ecom.dgmk.ga.exception;

public class GAUserProfileDataNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an <code>GAUserProfileDataNotFoundException</code> without a detail message.
	 */
	public GAUserProfileDataNotFoundException() {
		super();
	}

	/**
	 * Constructs an <code>GAUserProfileDataNotFoundException</code> with a detail message.
	 * 
	 * @param s
	 *            the detail message.
	 */
	public GAUserProfileDataNotFoundException(String s) {
		super(s);
	}
}