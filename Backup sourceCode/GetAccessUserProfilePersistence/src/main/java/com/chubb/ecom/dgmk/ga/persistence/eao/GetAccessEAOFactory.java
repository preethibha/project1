package com.chubb.ecom.dgmk.ga.persistence.eao;

import javax.persistence.EntityManager;

public abstract class GetAccessEAOFactory {

	/** The Constant jpa. */
	public static final GetAccessEAOFactory jpa = new GetAccessEAOJPAFactory();

	/**
	 * Gets the gets the access user profile eao.
	 *
	 * @return the gets the access user profile eao
	 */
	public abstract GetAccessUserProfileEAO getGetAccessUserProfileEAO(EntityManager entityManager);
}
