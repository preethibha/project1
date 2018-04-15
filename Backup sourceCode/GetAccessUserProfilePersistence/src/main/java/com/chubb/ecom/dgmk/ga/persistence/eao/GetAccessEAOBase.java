package com.chubb.ecom.dgmk.ga.persistence.eao;

import javax.persistence.EntityManager;

import com.chubb.dgmk.common.logger.ILogger;

public class GetAccessEAOBase {

	/** The ga logger. This should be injected by IOC framework */
	protected ILogger logger;

	private EntityManager entityManager;

	/**
	 * @return EntityManager
	 */
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	/**
	 * @param entityManager
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}