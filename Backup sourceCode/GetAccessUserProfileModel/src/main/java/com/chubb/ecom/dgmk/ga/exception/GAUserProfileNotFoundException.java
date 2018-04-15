package com.chubb.ecom.dgmk.ga.exception;

public class GAUserProfileNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an <code>GAUserProfileNotFoundException</code> without a detail message.
	 */
	public GAUserProfileNotFoundException() {
		super();
	}

	/**
	 * Constructs an <code>GAUserProfileNotFoundException</code> with a detail message.
	 * 
	 * @param s
	 *            the detail message.
	 */
	public GAUserProfileNotFoundException(String s) {
		super(s);
	}
}