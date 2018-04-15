package com.chubb.ecom.dgmk.ga.exception;

public class GAUserProfileRollbackSuccessfulException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an <code>GAUserProfileRollbackSuccessfulException</code> without a detail message.
	 */
	public GAUserProfileRollbackSuccessfulException() {
		super();
	}

	/**
	 * Constructs an <code>GAUserProfileRollbackSuccessfulException</code> with a detail message.
	 * 
	 * @param s
	 *            the detail message.
	 */
	public GAUserProfileRollbackSuccessfulException(String s) {
		super(s);
	}
}