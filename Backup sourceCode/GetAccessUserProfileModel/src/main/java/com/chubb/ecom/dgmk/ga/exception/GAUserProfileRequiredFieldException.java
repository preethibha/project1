package com.chubb.ecom.dgmk.ga.exception;

public class GAUserProfileRequiredFieldException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an <code>GAUserProfileSystemException</code> without a detail message.
	 */
	public GAUserProfileRequiredFieldException() {
		super();
	}

	/**
	 * Constructs an <code>GAUserProfileSystemException</code> with a detail message.
	 * 
	 * @param s
	 *            the detail message.
	 */
	public GAUserProfileRequiredFieldException(String s) {
		super(s);
	}

	/**
	 * Instantiates a new gA user profile required field exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public GAUserProfileRequiredFieldException(String message, Throwable cause) {
		super(message, cause);
	}
}