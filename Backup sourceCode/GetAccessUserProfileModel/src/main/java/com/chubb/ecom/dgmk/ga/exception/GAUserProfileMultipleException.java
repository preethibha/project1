package com.chubb.ecom.dgmk.ga.exception;

public class GAUserProfileMultipleException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an <code>GAUserProfileMultipleException</code> without a detail message.
	 */
	public GAUserProfileMultipleException() {
		super();
	}

	/**
	 * Constructs an <code>GAUserProfileMultipleException</code> with a detail message.
	 * 
	 * @param s
	 *            the detail message.
	 */
	public GAUserProfileMultipleException(String s) {
		super(s);
	}
}