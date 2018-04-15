package com.chubb.ecom.dgmk.ga.exception;

public class GAUserProfileRollbackUnsuccessfulException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an <code>GAUserProfileRollbackUnsuccessfulException</code> without a detail message.
	 */
	public GAUserProfileRollbackUnsuccessfulException() {
		super();
	}

	/**
	 * Constructs an <code>GAUserProfileRollbackUnsuccessfulException</code> with a detail message.
	 * 
	 * @param s
	 *            the detail message.
	 */
	public GAUserProfileRollbackUnsuccessfulException(String s) {
		super(s);
	}
}