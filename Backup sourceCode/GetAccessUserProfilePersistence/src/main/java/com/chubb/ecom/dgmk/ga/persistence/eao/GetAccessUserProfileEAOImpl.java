package com.chubb.ecom.dgmk.ga.persistence.eao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileDataException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileDataNotFoundException;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;
import com.chubb.ecom.dgmk.ga.persistence.entity.AuthRole;
import com.chubb.ecom.dgmk.ga.persistence.entity.User;
import com.chubb.ecom.dgmk.ga.persistence.util.GAUserProfilePersistenceConstants;

public class GetAccessUserProfileEAOImpl extends GetAccessEAOBase implements GetAccessUserProfileEAO {

	/**
	 * Instantiates a new gets the access user profile eao impl.
	 * 
	 * @param entityManager
	 *            the entity manager
	 */
	public GetAccessUserProfileEAOImpl(EntityManager entityManager) {
		this.setEntityManager(entityManager);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.persistence.eao.GetAccessUserProfileEAO#lookupUserLoginByCmnUsrGin(java.lang.String)
	 */
	@Override
	public List<String> lookupUserLoginByCmnUsrGin(String commonUserGin) throws GAUserProfileDataException {

		List<User> userList = null;
		List<String> userLoginList = new ArrayList<String>();

		try {

			Query gtQuery = getEntityManager().createNamedQuery(GAUserProfilePersistenceConstants.QUERY_USER_BY_COMMON_USER_GIN).setParameter(
					"commonUserGin", commonUserGin);

			userList = (List<User>) gtQuery.getResultList();

			if (userList != null && !userList.isEmpty()) {
				for (User user : userList) {
					userLoginList.add(user.getUsrLogin());
				}
			}

		} catch (Exception ex) {
			getLogger().logSevere("Exception: " + ex.getMessage(), this.getClass().getName(), "lookupUserLoginByCmnUsrGin");
			throw new GAUserProfileDataException("Data Source error: " + ex.getMessage());
		}

		return userLoginList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.persistence.eao.GetAccessUserProfileEAO#lookupUserLoginByEmail(java.lang.String)
	 */
	@Override
	public List<String> lookupUserLoginByEmail(String email) throws GAUserProfileDataException {

		List<User> userList = null;
		List<String> userLoginList = new ArrayList<String>();

		try {

			Query gtQuery = getEntityManager().createNamedQuery(GAUserProfilePersistenceConstants.QUERY_USER_BY_EMAIL).setParameter("email",
					email.toLowerCase());

			userList = (List<User>) gtQuery.getResultList();

			if (userList != null && !userList.isEmpty()) {
				for (User user : userList) {
					userLoginList.add(user.getUsrLogin());
				}
			}

		} catch (Exception ex) {
			getLogger().logSevere("Exception: " + ex.getMessage(), this.getClass().getName(), "lookupUserLoginByEmail");
			throw new GAUserProfileDataException("Data Source error: " + ex.getMessage());
		}

		return userLoginList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.persistence.eao.GetAccessUserProfileEAO#lookupUserByUserLogin(java.lang.String)
	 */
	@Override
	public User lookupUserByUserLogin(String userLogin) throws GAUserProfileDataException, GAUserProfileDataNotFoundException {

		User user = null;

		try {
			Query gtQuery = getEntityManager().createNamedQuery(GAUserProfilePersistenceConstants.QUERY_USER_BY_USER_LOGIN).setParameter("userLogin",
					userLogin);

			user = (User) gtQuery.getSingleResult();

		} catch (NoResultException ex) {
			getLogger().logWarning("User was not found in GA: " + userLogin, this.getClass().getName(), "findRoleByCode");
			throw new GAUserProfileDataNotFoundException("User was not found in GA: " + userLogin);

		} catch (Exception ex) {
			getLogger().logSevere("Exception: " + ex.getMessage(), this.getClass().getName(), "findRoleByCode");
			throw new GAUserProfileDataException("Data Source error: " + ex.getMessage());
		}

		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chubb.ecom.dgmk.ga.persistence.eao.GetAccessUserProfileEAO#findRoleByCode(java.lang.String, java.lang.String)
	 */
	@Override
	public AuthRole findRoleByCode(String groupCode, String roleCode) throws GAUserProfileDataException, GAUserProfileDataNotFoundException {

		AuthRole role = null;

		try {
			Query gtQuery = getEntityManager().createNamedQuery(GAUserProfilePersistenceConstants.QUERY_ROLE_BY_CODE)
					.setParameter("groupCode", groupCode).setParameter("roleCode", roleCode);

			role = (AuthRole) gtQuery.getSingleResult();

		} catch (NoResultException ex) {
			getLogger().logWarning("Role was not found in GA: " + groupCode + ":" + roleCode, this.getClass().getName(), "findRoleByCode");
			throw new GAUserProfileDataNotFoundException("Role was not found in GA: " + groupCode + ":" + roleCode);

		} catch (Exception ex) {
			getLogger().logSevere("Exception: " + ex.getMessage(), this.getClass().getName(), "findRoleByCode");
			throw new GAUserProfileDataException("Data Source error: " + ex.getMessage());
		}

		return role;
	}

	/**
	 * Sets the logger.
	 * 
	 * @param logger
	 *            the new logger
	 */
	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	/**
	 * Gets the default logger if object is not set by IOC framework
	 * 
	 * @return the logger
	 */
	public ILogger getLogger() {
		if (logger == null) {
			logger = GAUserProfileLoggerImpl.getLogger();
		}
		return logger;
	}

}