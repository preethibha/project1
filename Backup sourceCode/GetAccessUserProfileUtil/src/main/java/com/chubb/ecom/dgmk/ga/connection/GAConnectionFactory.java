package com.chubb.ecom.dgmk.ga.connection;

import enCommerce.getAccess.API.Connection.enCommConnection;
import enCommerce.getAccess.API.Resource.enCommResourceAPI;
import enCommerce.getAccess.API.User.enCommUserAPI;

public class GAConnectionFactory {

	private static enCommUserAPI userAPI = null;
	private static enCommResourceAPI rscAPI = null;

	/**
	 * Gets the user api.
	 * 
	 * @return the user api
	 */
	public static enCommUserAPI getUserAPI() {
		if (userAPI == null)
			setConnection();

		return userAPI;
	}

	/**
	 * Gets the resource api.
	 * 
	 * @return the resource api
	 */
	public static enCommResourceAPI getResourceAPI() {
		if (rscAPI == null)
			setConnection();

		return rscAPI;
	}

	/**
	 * Sets the connection.
	 */
	private static void setConnection() {
		enCommConnection econn = new enCommConnection();
		userAPI = new enCommUserAPI(econn);
		rscAPI = new enCommResourceAPI(econn);
	}

}