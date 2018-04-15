package com.chubb.ecom.dgmk.ga.persistence.eao;

import javax.persistence.EntityManager;

public class GetAccessEAOJPAFactory extends GetAccessEAOFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.persistence.eao.GetAccessEAOFactory#getGetAccessUserProfileEAO()
	 */
	@Override
	public GetAccessUserProfileEAO getGetAccessUserProfileEAO(EntityManager entityManager) {

		return new GetAccessUserProfileEAOImpl(entityManager);
	}

}
