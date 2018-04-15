package com.chubb.ecom.dgmk.ga.exception;

public class GAUserProfileSystemException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an <code>GAUserProfileSystemException</code> without a detail message.
	 */
	public GAUserProfileSystemException() {
		super();
	}

	/**
	 * Constructs an <code>GAUserProfileSystemException</code> with a detail message.
	 * 
	 * @param s
	 *            the detail message.
	 */
	public GAUserProfileSystemException(String s) {
		super(s);
	}

	/**
	 * Instantiates a new gA user profile system exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public GAUserProfileSystemException(String message, Throwable cause) {
		super(message, cause);
	}
}