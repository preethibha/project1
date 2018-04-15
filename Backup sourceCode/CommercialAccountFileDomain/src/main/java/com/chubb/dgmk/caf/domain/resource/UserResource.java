/**
 * 
 */
package com.chubb.dgmk.caf.domain.resource;

/**
 * @author npgmh31
 *
 */
public class UserResource {
	
	private String externalUserId;
	
	private String userId;

	public UserResource(String externalUserId, String userId) {
		super();
		this.externalUserId = externalUserId;
		this.userId = userId;
	}

	public UserResource() {
		// TODO Auto-generated constructor stub
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserResource [externalUserId=" + externalUserId + ", userId="
				+ userId + "]";
	}

	/**
	 * @return the externalUserId
	 */
	public String getExternalUserId() {
		return externalUserId;
	}

	/**
	 * @param externalUserId the externalUserId to set
	 */
	public void setExternalUserId(String externalUserId) {
		this.externalUserId = externalUserId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
