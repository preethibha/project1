package com.chubb.ecom.dgmk.ga.exception;

public class GAUserProfileAuthenticationException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an <code>GAUserProfileAuthenticationException</code> without a detail message.
	 */
	public GAUserProfileAuthenticationException() {
		super();
	}

	/**
	 * Constructs an <code>GAUserProfileAuthenticationException</code> with a detail message.
	 * 
	 * @param s
	 *            the detail message.
	 */
	public GAUserProfileAuthenticationException(String s) {
		super(s);
	}
}