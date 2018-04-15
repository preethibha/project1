package com.chubb.ecom.dgmk.ga.domain.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;

import chubb_corporate.get_access.access_attribute.AccessAttribute;
import chubb_corporate.get_access.access_control_group.AccessControlGroup;
import chubb_corporate.get_access.application_user_profile.ApplicationUserProfile;
import chubb_corporate.get_access.application_user_profile_property.ApplicationUserProfileProperty;
import chubb_corporate.get_access.customization.Customization;
import chubb_corporate.get_access.individual_name.IndividualName;
import chubb_corporate.get_access.language.Language;
import chubb_corporate.get_access.region_and_language_settings.RegionAndLanguageSettings;
import chubb_corporate.get_access.source_system_user_profile_id.SourceSystemUserProfileId;
import chubb_corporate.get_access.standardized_address.StandardizedAddress;
import chubb_corporate.get_access.telecomm_electronic_address.TelecommElectronicAddress;
import chubb_corporate.get_access.time_zone.TimeZone;
import chubb_corporate.get_access.typed_address.TypedAddress;
import chubb_corporate.get_access.user.User;
import chubb_corporate.get_access.user_authorization.UserAuthorization;
import chubb_corporate.get_access.user_profile.UserProfile;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.connection.GAConnectionFactory;
import com.chubb.ecom.dgmk.ga.domain.manager.GAUserProfileManager;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileAuthenticationException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileFieldFormatException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;
import com.chubb.ecom.dgmk.ga.model.StringArray;
import com.chubb.ecom.dgmk.ga.model.UserCredential;
import com.chubb.ecom.dgmk.ga.util.GAUserProfilePropertiesUtil;
import com.chubb.ecom.dgmk.ga.util.GAUserProfileServiceConstants;
import com.entrust.ga.tools.repository.Digester;

public class GAUserProfileManagerUtil {

	/** The ga logger. This should be injected by IOC framework */
	private ILogger logger;

	/**
	 * Gets the user profile manager service local.
	 * 
	 * @return the user profile manager service local
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public static GAUserProfileManager getUserProfileManagerServiceLocal() throws GAUserProfileSystemException {

		try {

			InitialContext context = new InitialContext();

			Object obj = context
					.lookup("ejblocal:GetAccessUserProfileApp/GetAccessUserProfileDomain.jar/GAUserProfileManagerImpl#com.chubb.ecom.dgmk.ga.domain.manager.GAUserProfileManager");

			GAUserProfileManager userProfileManager = (GAUserProfileManager) obj;
			return userProfileManager;

		} catch (Exception ex) {
			throw new GAUserProfileSystemException("Problem initializing service: " + ex.getMessage());
		}
	}

	/**
	 * Gets the user status.
	 * 
	 * @param userLogin
	 *            the user login
	 * @return the user status
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public String getUserStatus(String userLogin) throws GAUserProfileSystemException {

		String status = null;

		try {

			String[] fields = { GAUserProfileServiceConstants.ATTR_STATUS };
			String[] infos = GAConnectionFactory.getUserAPI().getUserInfo(userLogin, fields);

			status = infos[0];

		} catch (Exception ex) {
			getLogger().logSevere("Problem getting user status: " + ex.getMessage(), this.getClass().getName(), "getUserStatus");
			throw new GAUserProfileSystemException("Problem getting user status: " + ex.getMessage());
		}

		return status;
	}

	/**
	 * Gets the role array.
	 * 
	 * @param userLogin
	 *            the user login
	 * @return the role array
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public List<StringArray> getRoleArray(String userLogin) throws GAUserProfileSystemException {

		String roles[][] = null;
		List<StringArray> aryary = new ArrayList<StringArray>();

		try {
			getLogger().logInfo("GA Admin id: " + GAUserProfilePropertiesUtil.getGaAdminId(), this.getClass().getName(), "getRoleArray");

			roles = GAConnectionFactory.getUserAPI().getUserRoles(userLogin, GAUserProfilePropertiesUtil.getGaAdminId());

			StringArray strary = null;
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
			java.util.Date today = new java.util.Date();

			for (String[] ary : roles) {
				java.util.Date sdate = null;
				java.util.Date edate = null;
				try {
					if (ary[3] != null && ary[3].length() > 18) {
						if (ary[3].length() > 19)
							sdate = fmt.parse(ary[3].substring(0, 19));
						else
							sdate = fmt.parse(ary[3]);
					}
					if (ary[4] != null && ary[4].length() > 18) {
						if (ary[4].length() > 19)
							edate = fmt.parse(ary[4].substring(0, 19));
						else
							edate = fmt.parse(ary[4]);
					}
				} catch (Exception e) {
					getLogger().logSevere("Error while parsing role start/end date: " + e.getMessage(), this.getClass().getName(), "getRoleArray");
				}

				if (sdate != null && sdate.before(today) && (edate == null || edate.after(today))) {
					strary = new StringArray();
					strary.getString().addAll(Arrays.asList(ary));
					aryary.add(strary);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			getLogger().logSevere("Error getting roles for user. " + ex.getMessage(), this.getClass().getName(), "getRoleArray");
			throw new GAUserProfileSystemException("Error getting roles for user");
		}

		return aryary;
	}

	/**
	 * Gets the app list array.
	 * 
	 * @param userLogin
	 *            the user login
	 * @return the app list array
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public List<StringArray> getAppListArray(String userLogin) throws GAUserProfileSystemException {

		String[][] rsclist = null;
		List<StringArray> aryary = null;

		try {
			String roleStr = getRoles(userLogin);

			if (roleStr != null && roleStr.length() > 0) {
				if (!roleStr.endsWith(","))
					roleStr += ",";
				roleStr = "roles:" + roleStr;
				rsclist = GAConnectionFactory.getResourceAPI().getResourceUrlByRoleCookie(roleStr, true);
			}

			if (rsclist != null && rsclist.length > 0) {
				aryary = new ArrayList<StringArray>();
				StringArray strary = null;
				for (String[] ary : rsclist) {
					strary = new StringArray();
					strary.getString().addAll(Arrays.asList(ary));
					aryary.add(strary);
				}
			}

		} catch (Exception ex) {

			getLogger().logSevere("Error getting apps for user", this.getClass().getName(), "getAppListArray");
			throw new GAUserProfileSystemException("Error getting apps for user");
		}

		return aryary;
	}

	/**
	 * Gets the roles.
	 * 
	 * @param userLogin
	 *            the user login
	 * @return the roles
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public String getRoles(String userLogin) throws GAUserProfileSystemException {

		String rolestr = null;

		try {

			List<StringArray> roles = getRoleArray(userLogin);

			if (roles != null) {
				rolestr = "";
				for (StringArray strary : roles) {
					rolestr += strary.getString().get(0) + "." + strary.getString().get(1) + ",";
				}
			}

		} catch (Exception ex) {

			getLogger().logSevere("Error getting roles for user", this.getClass().getName(), "getRoles");
			throw new GAUserProfileSystemException("Error getting roles for user");
		}

		return rolestr;
	}

	/**
	 * Gets the existing effective date.
	 * 
	 * @param userLogin
	 *            the user login
	 * @param catCode
	 *            the cat code
	 * @param roleCode
	 *            the role code
	 * @return the existing effective date
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public java.sql.Date getExistingEffectiveDate(String userLogin, String catCode, String roleCode) throws GAUserProfileSystemException {

		try {

			Date effectiveDate = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			List<StringArray> roles = getRoleArray(userLogin);

			if (roles != null) {

				for (StringArray strary : roles) {
					String categoryId = strary.getString().get(0);
					String roleId = strary.getString().get(1);

					if (categoryId.equals(catCode) && roleId.equals(roleCode)) {

						String effectiveDateString = strary.getString().get(3);

						if (effectiveDateString != null) {

							effectiveDate = (Date) simpleDateFormat.parse(effectiveDateString);

							// return the effective date
							return new java.sql.Date(effectiveDate.getTime());
						}
					}
				}
			}

		} catch (Exception ex) {
			getLogger().logSevere("Problem getting effective date: " + ex.getMessage(), this.getClass().getName(), "updateUserRoles");
			throw new GAUserProfileSystemException("Problem getting effective date: " + ex.getMessage());
		}

		return null;
	}

	/**
	 * Generate user login.
	 * 
	 * @param emailAddress
	 *            the email address
	 * @return the string
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public String generateUserLogin(String emailAddress) throws GAUserProfileSystemException {

		String userLogin = null;

		try {

			userLogin = emailAddress.substring(0, emailAddress.indexOf('@'));

			boolean userLoginUnique = false;
			int uniqueIdInt = 1;

			while (!userLoginUnique) {

				// check if user id exists
				if (GAConnectionFactory.getUserAPI().isUserLoginTaken(userLogin)) {
					userLogin = userLogin + uniqueIdInt;
					uniqueIdInt++;

				} else {
					userLoginUnique = true;
				}
			}

		} catch (Exception ex) {
			getLogger().logSevere("Problem generating user login: " + ex.getMessage(), this.getClass().getName(), "generateUserLogin");
			throw new GAUserProfileSystemException("Problem generating user login: " + ex.getMessage());
		}

		return userLogin;
	}

	/**
	 * Gets the key array for source system.
	 * 
	 * @param userLogin
	 *            the user login
	 * @param srcSysID
	 *            the src sys id
	 * @return the key array for source system
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public List<String> getKeyArrayforSourceSystem(String userLogin, String srcSysID) throws GAUserProfileSystemException {

		String[] srcKeysArray = null;
		List<String> lst = null;

		try {

			Hashtable<?, ?> hashSrcKeys = GAConnectionFactory.getUserAPI().getUserSourceSystemKeys(userLogin, srcSysID);

			srcKeysArray = (String[]) hashSrcKeys.get("data");

			if (srcKeysArray != null && srcKeysArray.length > 0)
				lst = Arrays.asList(srcKeysArray);

		} catch (Exception ex) {

			getLogger().logSevere("Exception: " + ex.getMessage() + " | For User: " + userLogin, this.getClass().getName(),
					"getKeyArrayforSourceSystem");
			throw new GAUserProfileSystemException("Could not find Source System keys: " + ex.getMessage());
		}

		return lst;
	}

	/**
	 * Gets the person id.
	 * 
	 * @param userLogin
	 *            the user login
	 * @return the person id
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public String getPersonId(String userLogin) throws GAUserProfileSystemException {

		try {
			return GAConnectionFactory.getUserAPI().getPersonID(userLogin);

		} catch (Exception ex) {

			getLogger().logSevere("Exception: " + ex.getMessage() + " | For User: " + userLogin, this.getClass().getName(), "getPersonId");
			throw new GAUserProfileSystemException("Could not find Person Id: " + ex.getMessage());
		}
	}

	/**
	 * Gets the user login by person id.
	 * 
	 * @param personGIN
	 *            the person gin
	 * @return the user login by person id
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public String getUserLoginByPersonId(String personGIN) throws GAUserProfileSystemException {

		try {
			return GAConnectionFactory.getUserAPI().getUserLogin(personGIN);

		} catch (Exception ex) {

			getLogger().logSevere("Exception: " + ex.getMessage(), this.getClass().getName(), "getUserLoginByPersonId");
			throw new GAUserProfileSystemException("Could not find User Login: " + ex.getMessage());
		}
	}

	/**
	 * Authenticate user.
	 * 
	 * @param uid
	 *            the uid
	 * @param inpasswd
	 *            the inpasswd
	 * @return true, if successful
	 * @throws GAUserProfileAuthenticationException
	 *             the gA user profile authentication exception
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public boolean authenticateUser(String uid, String inpasswd) throws GAUserProfileAuthenticationException, GAUserProfileSystemException {

		boolean flag = false;

		Hashtable<?, ?> statusPassword = null;
		String passwd = null;
		String password = null;

		try {

			statusPassword = GAConnectionFactory.getUserAPI().getPasswordStatus(uid);
			passwd = (String) statusPassword.get("password");
			password = Digester.digest(inpasswd);
			
		} catch (Exception ex) {

			getLogger().logSevere("Error authenticating user", this.getClass().getName(), "authenticateUser");
			throw new GAUserProfileSystemException("Error authenticating user");
		}

		if (password.compareTo(passwd) == 0) {

			String status = (String) statusPassword.get("status");

			if (GAUserProfileServiceConstants.ACTIVE_STATUS.equalsIgnoreCase(status))
				flag = true;

			else if (GAUserProfileServiceConstants.PASSWORD_EXPIRED_STATUS.equalsIgnoreCase(status))
				throw new GAUserProfileAuthenticationException("admin password expired.");

			else
				throw new GAUserProfileAuthenticationException("admin inactivated.");

		} else
			throw new GAUserProfileAuthenticationException("admin wrong password");

		return flag;
	}

	/**
	 * Validate admin.
	 * 
	 * @param adminId
	 *            the admin id
	 * @param action
	 *            the action
	 * @return true, if successful
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public boolean validateAdmin(String adminId, String action) throws GAUserProfileSystemException {

		boolean flag = false;

		try {

			Hashtable<?, ?> prevs = GAConnectionFactory.getUserAPI().getUserPrivilege(adminId);

			if (prevs != null && prevs.get("userPriv") != null) {

				String userPriv = (String) prevs.get("userPriv");

				if (userPriv != null && userPriv.length() > 0) {

					if (GAUserProfileServiceConstants.PASSWORD_ACTION.equals(action)
							|| GAUserProfileServiceConstants.CREATE_USER_ACTION.equals(action)
							|| GAUserProfileServiceConstants.UPDATE_USER_ACTION.equals(action)) {

						if (GAUserProfileServiceConstants.FULL_ADMINISTRATION_PRIVILEGE.equalsIgnoreCase(userPriv)
								|| GAUserProfileServiceConstants.USER_ADMINISTRATION_PRIVILEGE.equalsIgnoreCase(userPriv)) {
							flag = true;
						}
					}
				}
			}

		} catch (Exception ex) {
			getLogger().logSevere("Error validating admin user", this.getClass().getName(), "validateAdmin");
			throw new GAUserProfileSystemException("Error validating admin user");
		}

		return flag;
	}

	/**
	 * Gets the app keys for action.
	 * 
	 * @param userAuthorizationList
	 *            the user authorization list
	 * @return the app keys for action
	 */
	public Map<String, List<AccessAttribute>> getAppKeysForAction(List<UserAuthorization> userAuthorizationList) {

		Map<String, List<AccessAttribute>> appKeysForActionResult = null;

		List<AccessAttribute> deleteAppKeysList = new ArrayList<AccessAttribute>();
		List<AccessAttribute> addAppKeysList = new ArrayList<AccessAttribute>();

		if (userAuthorizationList != null) {

			appKeysForActionResult = new Hashtable<String, List<AccessAttribute>>();

			UserAuthorization appKeysUserAuth = null;

			for (UserAuthorization userAuthorization : userAuthorizationList) {
				if (GAUserProfileServiceConstants.APPLICATION_KEYS_AUTH_TYPE_NAME.equals(userAuthorization.getUserAuthorizationTypeName())
						&& GAUserProfileServiceConstants.GA_USER_PROFILE_SOURCE_NAME.equals(userAuthorization.getDataSourceName())) {

					appKeysUserAuth = userAuthorization;
					break;
				}
			}

			if (appKeysUserAuth != null) {

				for (AccessAttribute accessAttribute : appKeysUserAuth.getAccessAttribute()) {

					if (GAUserProfileServiceConstants.DELETE_ACTION_CODE.equals(accessAttribute.getAccessAttributeActionCode().toUpperCase())) {
						deleteAppKeysList.add(accessAttribute);

					} else if (GAUserProfileServiceConstants.ADD_ACTION_CODE.equals(accessAttribute.getAccessAttributeActionCode().toUpperCase())) {
						addAppKeysList.add(accessAttribute);
					}
				}
			}
		}

		appKeysForActionResult.put(GAUserProfileServiceConstants.DELETE_ACTION_CODE, deleteAppKeysList);
		appKeysForActionResult.put(GAUserProfileServiceConstants.ADD_ACTION_CODE, addAppKeysList);

		return appKeysForActionResult;
	}

	/**
	 * Gets the application attributes.
	 * 
	 * @param userAuthorizationList
	 *            the user authorization list
	 * @return the application attributes
	 */
	public UserAuthorization getApplicationAttributes(List<UserAuthorization> userAuthorizationList) {

		for (UserAuthorization userAuthorization : userAuthorizationList) {
			if (GAUserProfileServiceConstants.APPLICATION_ATTR_AUTH_TYPE_NAME.equals(userAuthorization.getUserAuthorizationTypeName())
					&& GAUserProfileServiceConstants.GA_USER_PROFILE_SOURCE_NAME.equals(userAuthorization.getDataSourceName())) {

				return userAuthorization;
			}
		}

		return null;
	}

	/**
	 * Checks if is user login taken.
	 * 
	 * @param userLogin
	 *            the user login
	 * @return true, if is user login taken
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public boolean isUserLoginTaken(String userLogin) throws GAUserProfileSystemException {

		try {
			return GAConnectionFactory.getUserAPI().isUserLoginTaken(userLogin);

		} catch (Exception ex) {
			getLogger().logSevere("Problem checking if user login taken: " + ex.getMessage(), this.getClass().getName(), "isUserLoginTaken");
			throw new GAUserProfileSystemException("Problem checking if user login taken: " + ex.getMessage());
		}
	}

	/**
	 * Gets the mailing address.
	 * 
	 * @param bpTypedAddress
	 *            the bp typed address
	 * @return the mailing address
	 */
	public StandardizedAddress getMailingAddress(List<TypedAddress> bpTypedAddress) {

		if (bpTypedAddress != null) {

			for (TypedAddress address : bpTypedAddress) {
				if (GAUserProfileServiceConstants.MAILING_ADDRESS_TYPE_NAME.equals(address.getAddressTypeName())) {
					return address.getStandardizedAddress();
				}
			}
		}

		return null;
	}

	/**
	 * Gets the telecomm device value.
	 * 
	 * @param bpTelecommElectronicAddress
	 *            the bp telecomm electronic address
	 * @param deviceCode
	 *            the device code
	 * @return the telecomm device value
	 */
	public String getTelecommDeviceValue(List<TelecommElectronicAddress> bpTelecommElectronicAddress, String deviceCode) {

		if (bpTelecommElectronicAddress != null) {

			for (TelecommElectronicAddress address : bpTelecommElectronicAddress) {
				if (deviceCode.equals(address.getCommDeviceCode())) {
					return address.getCommDeviceValue();
				}
			}
		}

		return null;
	}

	/**
	 * Gets the app user profile value.
	 * 
	 * @param applicationUserProfilePropertyList
	 *            the application user profile property list
	 * @param propertyName
	 *            the property name
	 * @return the app user profile value
	 */
	public String getAppUserProfileValue(List<ApplicationUserProfileProperty> applicationUserProfilePropertyList, String propertyName) {

		if (applicationUserProfilePropertyList != null) {

			for (ApplicationUserProfileProperty applicationUserProfileProperty : applicationUserProfilePropertyList) {
				if (propertyName.equals(applicationUserProfileProperty.getUserProfilePropertyName())) {
					return applicationUserProfileProperty.getUserProfilePropertyValue();
				}
			}
		}

		return null;
	}

	/**
	 * Gets the roles for action.
	 * 
	 * @param accessControlGroupList
	 *            the access control group list
	 * @return the roles for action
	 */
	public Map<String, List<AccessControlGroup>> getRolesForAction(List<AccessControlGroup> accessControlGroupList) {

		Map<String, List<AccessControlGroup>> accessControlGroupResult = null;

		if (accessControlGroupList != null) {

			accessControlGroupResult = new Hashtable<String, List<AccessControlGroup>>();

			List<AccessControlGroup> deleteRolesList = new ArrayList<AccessControlGroup>();
			List<AccessControlGroup> updateRolesList = new ArrayList<AccessControlGroup>();
			List<AccessControlGroup> addRolesList = new ArrayList<AccessControlGroup>();

			for (AccessControlGroup accessControlGroup : accessControlGroupList) {

				if (GAUserProfileServiceConstants.ADD_ACTION_CODE.equals(accessControlGroup.getUserAccessControlGroupActionCode().toUpperCase())) {
					addRolesList.add(accessControlGroup);

				} else if (GAUserProfileServiceConstants.UPDATE_ACTION_CODE.equals(accessControlGroup.getUserAccessControlGroupActionCode()
						.toUpperCase())) {
					updateRolesList.add(accessControlGroup);

				} else if (GAUserProfileServiceConstants.DELETE_ACTION_CODE.equals(accessControlGroup.getUserAccessControlGroupActionCode()
						.toUpperCase())) {
					deleteRolesList.add(accessControlGroup);
				}
			}

			accessControlGroupResult.put(GAUserProfileServiceConstants.DELETE_ACTION_CODE, deleteRolesList);
			accessControlGroupResult.put(GAUserProfileServiceConstants.UPDATE_ACTION_CODE, updateRolesList);
			accessControlGroupResult.put(GAUserProfileServiceConstants.ADD_ACTION_CODE, addRolesList);
		}

		return accessControlGroupResult;
	}

	/**
	 * Retrieve client info.
	 * 
	 * @param userLogin
	 *            the user login
	 * @param userProfile
	 *            the user profile
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public void retrieveClientInfo(String userLogin, UserAuthorization userAuthorization) throws GAUserProfileSystemException {

		try {

			// get the client number
			List<String> clientNumberSysKeyArray = getSourceSystemKeyArray(userLogin, GAUserProfileServiceConstants.CLIENT_SOURCE_SYSTEM_ID);

			if (clientNumberSysKeyArray != null) {

				// construct AccessAttribute object
				AccessAttribute accessAttribute = new AccessAttribute();
				accessAttribute.setAccessAttributeName(GAUserProfileServiceConstants.CLIENT_NUMBER_ATTR);

				for (String clientNumberSysKey : clientNumberSysKeyArray) {
					accessAttribute.getAccessAttributeValue().add(clientNumberSysKey);
				}

				userAuthorization.getAccessAttribute().add(accessAttribute);
			}

		} catch (Exception ex) {
			getLogger().logSevere("Problem getting client info: " + ex.getMessage(), this.getClass().getName(), "retrieveClientInfo");
			throw new GAUserProfileSystemException("Problem getting client info: " + ex.getMessage());
		}
	}

	/**
	 * Retrieve entire user info.
	 * 
	 * @param userLogin
	 *            the user login
	 * @param userProfile
	 *            the user profile
	 * @return the user resource
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public void retrieveEntireUserInfo(String userLogin, UserProfile userProfile) throws GAUserProfileSystemException {

		// retrieve user info
		retrieveUserInfo(userLogin, userProfile, true);

		UserAuthorization userAuthorization = new UserAuthorization();
		userAuthorization.setUserAuthorizationTypeName(GAUserProfileServiceConstants.APPLICATION_KEYS_AUTH_TYPE_NAME);
		userAuthorization.setDataSourceName(GAUserProfileServiceConstants.GA_USER_PROFILE_SOURCE_NAME);

		// retrieve producer & sub-producer info
		retrieveProducerInfo(userLogin, userAuthorization);
		
		// retrieve pas & sub-producer info
		retrievePasInfo(userLogin, userAuthorization);

		// retrieve client info
		retrieveClientInfo(userLogin, userAuthorization);

		userProfile.getUserAuthorization().add(userAuthorization);

		// retrieve user roles
		retrieveUserRolesInfo(userLogin, userProfile);

		// retrieve user apps
		retrieveUserAppsInfo(userLogin, userProfile);
	}

	/**
	 * Retrieve user roles info.
	 * 
	 * @param userLogin
	 *            the user login
	 * @param userProfile
	 *            the user profile
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public void retrieveUserRolesInfo(String userLogin, UserProfile userProfile) throws GAUserProfileSystemException {

		getLogger().logInfo("Looking up roles for user: " + userLogin, this.getClass().getName(), "retrieveUserRolesInfo");

		try {

			List<StringArray> roles = getRoleArray(userLogin);

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate;
			Date endDate;
			GregorianCalendar startDateGregorianCalendar;
			GregorianCalendar endDateGregorianCalendar;

			for (StringArray rolesstrary : roles) {

				List<String> rolesArrayList = rolesstrary.getString();

				if (!rolesArrayList.isEmpty()) {

					// construct AccessControlGroup object
					AccessControlGroup accessControlGroup = new AccessControlGroup();

					if (StringUtils.isNotEmpty(rolesArrayList.get(0))) {
						accessControlGroup.setAccessControlGroupCategoryCode(rolesArrayList.get(0));
					}

					if (StringUtils.isNotEmpty(rolesArrayList.get(1))) {
						accessControlGroup.setAccessControlGroupCode(rolesArrayList.get(1));
					}

					if (StringUtils.isNotEmpty(rolesArrayList.get(2))) {
						accessControlGroup.setAccessControlGroupName(rolesArrayList.get(2));
					}

					if (StringUtils.isNotEmpty(rolesArrayList.get(3))) {

						// format start date
						startDate = simpleDateFormat.parse(rolesArrayList.get(3));
						startDateGregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
						startDateGregorianCalendar.setTime(startDate);

						accessControlGroup.setAccessControlGroupEffectiveDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
								startDateGregorianCalendar.get(Calendar.YEAR), startDateGregorianCalendar.get(Calendar.MONTH) + 1,
								startDateGregorianCalendar.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED));
					}

					if (StringUtils.isNotEmpty(rolesArrayList.get(4))) {

						// format end date
						endDate = simpleDateFormat.parse(rolesArrayList.get(4));
						endDateGregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
						endDateGregorianCalendar.setTime(endDate);

						accessControlGroup.setAccessControlGroupExpirationDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
								endDateGregorianCalendar.get(Calendar.YEAR), endDateGregorianCalendar.get(Calendar.MONTH) + 1,
								endDateGregorianCalendar.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED));
					}

					if (StringUtils.isNotEmpty(rolesArrayList.get(5))) {
						accessControlGroup.setAccessControlGroupTypeCode(rolesArrayList.get(5));
					}

					userProfile.getAccessControlGroup().add(accessControlGroup);
				}
			}

		} catch (Exception ex) {
			getLogger().logSevere("Problem getting user roles info: " + ex.getMessage(), this.getClass().getName(), "retrieveUserRolesInfo");
			throw new GAUserProfileSystemException("Problem getting user roles info: " + ex.getMessage());
		}
	}

	/**
	 * Retrieve user apps info.
	 * 
	 * @param userLogin
	 *            the user login
	 * @param userProfile
	 *            the user profile
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public void retrieveUserAppsInfo(String userLogin, UserProfile userProfile) throws GAUserProfileSystemException {

		try {

			List<StringArray> apps = getAppListArray(userLogin);

			if (apps != null) {

				// construct UserAuthorization object
				UserAuthorization userAuthorization = new UserAuthorization();
				userAuthorization.setUserAuthorizationTypeName(GAUserProfileServiceConstants.APPLICATION_ATTR_AUTH_TYPE_NAME);
				userAuthorization.setDataSourceName(GAUserProfileServiceConstants.GA_USER_PROFILE_SOURCE_NAME);

				for (StringArray appsstrary : apps) {

					List<String> appsArrayList = appsstrary.getString();

					// construct AccessAttribute object for SourceURLId
					AccessAttribute accessAttributeSourceURLId = new AccessAttribute();
					accessAttributeSourceURLId.setAccessAttributeName("SourceURLId");
					accessAttributeSourceURLId.getAccessAttributeValue().add(appsArrayList.get(0));

					// construct AccessAttribute object for SourceURL
					AccessAttribute accessAttributeSourceURL = new AccessAttribute();
					accessAttributeSourceURL.setAccessAttributeName("SourceURL");
					accessAttributeSourceURL.getAccessAttributeValue().add(appsArrayList.get(1));

					accessAttributeSourceURLId.getAccessAttribute().add(accessAttributeSourceURL);

					// construct AccessAttribute object for SourceURLTitleName
					AccessAttribute accessAttributeSourceURLTitleName = new AccessAttribute();
					accessAttributeSourceURLTitleName.setAccessAttributeName("SourceURLTitleName");
					accessAttributeSourceURLTitleName.getAccessAttributeValue().add(appsArrayList.get(2));

					accessAttributeSourceURLId.getAccessAttribute().add(accessAttributeSourceURLTitleName);

					// construct AccessAttribute object for SourceCategoryTitleName
					AccessAttribute accessAttributeSourceCategoryTitleName = new AccessAttribute();
					accessAttributeSourceCategoryTitleName.setAccessAttributeName("SourceCategoryTitleName");
					accessAttributeSourceCategoryTitleName.getAccessAttributeValue().add(appsArrayList.get(5));

					accessAttributeSourceURLId.getAccessAttribute().add(accessAttributeSourceCategoryTitleName);

					userAuthorization.getAccessAttribute().add(accessAttributeSourceURLId);
				}

				// add the user authorization to the reply
				userProfile.getUserAuthorization().add(userAuthorization);
			}

		} catch (Exception ex) {
			getLogger().logSevere("Problem getting user apps info: " + ex.getMessage(), this.getClass().getName(), "retrieveUserAppsInfo");
			throw new GAUserProfileSystemException("Problem getting user apps info: " + ex.getMessage());
		}
	}

	/**
	 * Retrieve producer info.
	 * 
	 * @param userLogin
	 *            the user login
	 * @param userProfile
	 *            the user profile
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public void retrieveProducerInfo(String userLogin, UserAuthorization userAuthorization) throws GAUserProfileSystemException {

		try {

			// get the producer & sub numbers
			List<String> producerNumberSysKeyArray = getSourceSystemKeyArray(userLogin, GAUserProfileServiceConstants.PRODUCER_SOURCE_SYSTEM_ID);

			if (producerNumberSysKeyArray != null) {

				userAuthorization.setUserAuthorizationTypeName(GAUserProfileServiceConstants.APPLICATION_KEYS_AUTH_TYPE_NAME);
				userAuthorization.setDataSourceName(GAUserProfileServiceConstants.GA_USER_PROFILE_SOURCE_NAME);

				// construct AccessAttribute object
				AccessAttribute accessAttribute = new AccessAttribute();
				accessAttribute.setAccessAttributeName(GAUserProfileServiceConstants.PRODUCER_SUB_KEY_ATTR);

				for (String producerNumberSysKey : producerNumberSysKeyArray) {
					accessAttribute.getAccessAttributeValue().add(producerNumberSysKey);
				}

				userAuthorization.getAccessAttribute().add(accessAttribute);
			}

		} catch (Exception ex) {
			getLogger().logSevere("Problem getting producer info: " + ex.getMessage(), this.getClass().getName(), "retrieveProducerInfo");
			throw new GAUserProfileSystemException("Problem getting producer info: " + ex.getMessage());
		}
	}
	
	/**
	 * Retrieve PAS info.
	 * 
	 * @param userLogin
	 *            the user login
	 * @param userProfile
	 *            the user profile
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public void retrievePasInfo(String userLogin, UserAuthorization userAuthorization) throws GAUserProfileSystemException {

		try {

			// get the pas & sub numbers
			List<String> pasNumberSysKeyArray = getSourceSystemKeyArray(userLogin, GAUserProfileServiceConstants.PAS_SOURCE_SYSTEM_ID);

			if (pasNumberSysKeyArray != null) {

				userAuthorization.setUserAuthorizationTypeName(GAUserProfileServiceConstants.APPLICATION_KEYS_AUTH_TYPE_NAME);
				userAuthorization.setDataSourceName(GAUserProfileServiceConstants.GA_USER_PROFILE_SOURCE_NAME);

				// construct AccessAttribute object
				AccessAttribute accessAttribute = new AccessAttribute();
				accessAttribute.setAccessAttributeName(GAUserProfileServiceConstants.PAS_SUB_KEY_ATTR);

				for (String pasNumberSysKey : pasNumberSysKeyArray) {
					accessAttribute.getAccessAttributeValue().add(pasNumberSysKey);
				}

				userAuthorization.getAccessAttribute().add(accessAttribute);
			}

		} catch (Exception ex) {
			getLogger().logSevere("Problem getting pas info: " + ex.getMessage(), this.getClass().getName(), "retrievePasInfo");
			throw new GAUserProfileSystemException("Problem getting pas info: " + ex.getMessage());
		}
	}

	/**
	 * Retrieve user info.
	 * 
	 * @param userLogin
	 *            the user login
	 * @param userProfile
	 *            the user profile
	 * @param includeAppUserProfileInfo
	 *            the include app user profile info
	 * @return the user resource
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public void retrieveUserInfo(String userLogin, UserProfile userProfile, boolean includeAppUserProfileInfo) throws GAUserProfileSystemException {

		try {

			String[] fields = { GAUserProfileServiceConstants.ATTR_FIRST_NAME, GAUserProfileServiceConstants.ATTR_LAST_NAME,
					GAUserProfileServiceConstants.ATTR_USER_LOGIN, GAUserProfileServiceConstants.ATTR_LOCALE_CODE,
					GAUserProfileServiceConstants.ATTR_STATUS, GAUserProfileServiceConstants.ATTR_TIME_ZONE,
					GAUserProfileServiceConstants.ATTR_EMAIL, GAUserProfileServiceConstants.ATTR_ADDRESS1,
					GAUserProfileServiceConstants.ATTR_ADDRESS2, GAUserProfileServiceConstants.ATTR_CITY, GAUserProfileServiceConstants.ATTR_STATE,
					GAUserProfileServiceConstants.ATTR_ZIP, GAUserProfileServiceConstants.ATTR_COUNTRY, GAUserProfileServiceConstants.ATTR_PHONE,
					GAUserProfileServiceConstants.ATTR_DELEGATION_CODE, GAUserProfileServiceConstants.ATTR_CHAR1,
					GAUserProfileServiceConstants.ATTR_PERSON_ID, GAUserProfileServiceConstants.ATTR_MIDDLE_INIT,
					GAUserProfileServiceConstants.ATTR_LAST_SUCCESS_LOGIN_DATE};

			String[] infos = GAConnectionFactory.getUserAPI().getUserInfo(userLogin, fields);
			String[] types = GAConnectionFactory.getUserAPI().getCurrentPersonType(GAConnectionFactory.getUserAPI().getPersonID(userLogin));

			Hashtable<?, ?> upvalues = GAConnectionFactory.getUserAPI().getUserPlus(GAConnectionFactory.getUserAPI().getPersonID(userLogin));

			// set user info fields

			if (StringUtils.isNotEmpty(infos[4])) {
				userProfile.setUserProfileStatusCode(infos[4]);
			}

			userProfile.setUserProfileSourceName(GAUserProfileServiceConstants.GA_USER_PROFILE_SOURCE_NAME);

			if (StringUtils.isNotEmpty(infos[2])) {
				userProfile.setExternalUserId(infos[2]);
			}

			if (StringUtils.isNotEmpty(infos[16])) {
				userProfile.setPersonGIN(infos[16]);
			}

			if (StringUtils.isNotEmpty((String) upvalues.get(GAUserProfileServiceConstants.ATTR_CMN_USER_GIN))) {
				userProfile.setCommonUserGIN((String) upvalues.get(GAUserProfileServiceConstants.ATTR_CMN_USER_GIN));
			}
			
			// RETURN THE FIRST_LOGIN_DATE INDICATOR		
			if (StringUtils.isNotEmpty(infos[18])) {
				
				Customization firstLoginUser = new Customization();
				firstLoginUser.setCustomizationName(GAUserProfileServiceConstants.CN_LAST_SUCCESS_LOGIN_DATE);
				
				// format first login date
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date flDate = simpleDateFormat.parse(infos[18]);
				GregorianCalendar firstLoginGregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
				firstLoginGregorianCalendar.setTime(flDate);
				
				XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(firstLoginGregorianCalendar);
												
				firstLoginUser.setCustomizationDate(xmlDate);
				userProfile.getCustomization().add(firstLoginUser);
			} 			
			
			/** Changes made for retrieving new Fields meant for SSO **/

			List<String> applist = GAUserProfilePropertiesUtil.getAppNames();
			for (int i = 0; i < applist.size(); i++) {
				SourceSystemUserProfileId sourceSystem = new SourceSystemUserProfileId();
				sourceSystem.setUserProfileSourceSystemName(applist.get(i));
				sourceSystem.setSourceSystemUserProfileId((String) upvalues
						.get(GAUserProfilePropertiesUtil.getGacol(applist
								.get(i))));
				userProfile.getSourceSystemUserProfileId().add(sourceSystem);
			}
			getLogger().logInfo(
					"SourceSystemUserProfileId retrieved in response",
					this.getClass().getName(), "retrieveUserInfo");

			/** Changes made for retrieving new Fields meant for SSO **/
			
			// construct User object
			User user = new User();

			if (StringUtils.isNotEmpty((String) upvalues.get(GAUserProfileServiceConstants.ATTR_RACF_ID))) {
				user.setUserId((String) upvalues.get(GAUserProfileServiceConstants.ATTR_RACF_ID));
			}

			if (StringUtils.isNotEmpty((String) upvalues.get(GAUserProfileServiceConstants.ATTR_ORG_ROLE_NAME))) {
				user.setUserOrganizationRoleName((String) upvalues.get(GAUserProfileServiceConstants.ATTR_ORG_ROLE_NAME));
			}

			if (StringUtils.isNotEmpty(types[0])) {
				user.setUserTypeCode(types[0]);
			}

			if (StringUtils.isNotEmpty(infos[15])) {  
				user.setBusinessName(infos[15]);
			}

			if (StringUtils.isNotEmpty(types[1])) {
				user.setUserTypeDescription(types[1]);
			}

			// construct IndividualName object
			IndividualName individualName = new IndividualName();

			if (StringUtils.isNotEmpty(infos[0])) {
				individualName.setGivenName(infos[0]);
			}

			if (StringUtils.isNotEmpty(infos[17])) {
				individualName.setMiddleName(infos[17]);
			}

			if (StringUtils.isNotEmpty(infos[1])) {
				individualName.setSurname(infos[1]);
			}

			user.getIndividualName().add(individualName);

			if (StringUtils.isNotEmpty(infos[6])) {

				// construct TelecommElectronicAddress object for Email Address
				TelecommElectronicAddress telecommElectronicAddressEmail = new TelecommElectronicAddress();
				telecommElectronicAddressEmail.setCommDeviceCode(GAUserProfileServiceConstants.EMAIL_ADDRESS_COMM_DEVICE_CODE);
				telecommElectronicAddressEmail.setCommDeviceName(GAUserProfileServiceConstants.EMAIL_ADDRESS_COMM_DEVICE_NAME);
				telecommElectronicAddressEmail.setCommDeviceValue(infos[6]);

				user.getBPTelecommElectronicAddress().add(telecommElectronicAddressEmail);
			}

			if (StringUtils.isNotEmpty(infos[13])) {

				// construct TelecommElectronicAddress object for Phone Number
				TelecommElectronicAddress telecommElectronicAddressPhone = new TelecommElectronicAddress();
				telecommElectronicAddressPhone.setCommDeviceCode(GAUserProfileServiceConstants.TELEPHONE_COMM_DEVICE_CODE);
				telecommElectronicAddressPhone.setCommDeviceName(GAUserProfileServiceConstants.TELEPHONE_COMM_DEVICE_NAME);
				telecommElectronicAddressPhone.setCommDeviceValue(infos[13]);

				user.getBPTelecommElectronicAddress().add(telecommElectronicAddressPhone);
			}

			// construct TypedAddress for Business Partner
			TypedAddress bpTypedAddress = new TypedAddress();

			// construct StandardizedAddress object
			StandardizedAddress standardizedAddress = new StandardizedAddress();

			if (StringUtils.isNotEmpty(infos[7])) {
				standardizedAddress.setAddressLine1(infos[7]);
			}

			if (StringUtils.isNotEmpty(infos[8])) {
				standardizedAddress.setAddressLine2(infos[8]);
			}

			if (StringUtils.isNotEmpty(infos[9])) {
				standardizedAddress.setCityName(infos[9]);
			}

			if (StringUtils.isNotEmpty(infos[10])) {
				standardizedAddress.setStateOrProvinceName(infos[10]);
			}

			if (StringUtils.isNotEmpty(infos[11])) {
				standardizedAddress.setPostalCode(infos[11]);
			}

			if (StringUtils.isNotEmpty(infos[12])) {
				standardizedAddress.setCountryName(infos[12]);
			}

			bpTypedAddress.setAddressTypeName(GAUserProfileServiceConstants.MAILING_ADDRESS_TYPE_NAME);
			bpTypedAddress.setStandardizedAddress(standardizedAddress);

			user.getBPTypedAddress().add(bpTypedAddress);

			userProfile.setUser(user);

			// construct RegionAndLanguageSettings object
			RegionAndLanguageSettings regionAndLanguageSettings = new RegionAndLanguageSettings();

			if (StringUtils.isNotEmpty(infos[3])) {

				// construct Language object
				Language language = new Language();
				language.setSourceSystemLanguageCode(infos[3]);
				regionAndLanguageSettings.setLanguage(language);
			}

			if (StringUtils.isNotEmpty(infos[5])) {

				// construct Timezone object
				TimeZone timeZone = new TimeZone();
				timeZone.setTimeZoneAbbreviation(infos[5]);
				regionAndLanguageSettings.setTimeZone(timeZone);
			}

			if (regionAndLanguageSettings.getLanguage() != null || regionAndLanguageSettings.getTimeZone() != null) {
				userProfile.getRegionAndLanguageSettings().add(regionAndLanguageSettings);
			}

			if (includeAppUserProfileInfo) {

				// construct ApplicationUserProfile object
				ApplicationUserProfile applicationUserProfile = new ApplicationUserProfile();

				if (StringUtils.isNotEmpty(infos[14])) {

					// construct ApplicationUserProfileProperty object for Delegation Code property
					ApplicationUserProfileProperty applicationProfilePropDelegation = new ApplicationUserProfileProperty();
					applicationProfilePropDelegation.setUserProfilePropertyName(GAUserProfileServiceConstants.DELEGATION_CODE_PROPERTY);
					applicationProfilePropDelegation.setUserProfilePropertyValue(infos[14]);
					applicationProfilePropDelegation.setDataSourceName(GAUserProfileServiceConstants.GA_USER_PROFILE_SOURCE_NAME);

					applicationUserProfile.getApplicationUserProfileProperty().add(applicationProfilePropDelegation);
				}

				// get the Preferred producer & sub numbers
				String preferredProducerNumberSysKey = (String) upvalues.get(GAUserProfileServiceConstants.ATTR_PREF_PRODUCER_NUMBER);

				if (StringUtils.isNotEmpty(preferredProducerNumberSysKey) && preferredProducerNumberSysKey.length() >= 12) {

					String prefProducerNumber = preferredProducerNumberSysKey.substring(0, 7);
					String prefSubProducerNumber = preferredProducerNumberSysKey.substring(7, preferredProducerNumberSysKey.length());

					// construct ApplicationUserProfileProperty object for Producer Number property
					ApplicationUserProfileProperty applicationProfilePropPrefProducer = new ApplicationUserProfileProperty();
					applicationProfilePropPrefProducer.setUserProfilePropertyName(GAUserProfileServiceConstants.PREF_PRODUCER_PROPERTY);
					applicationProfilePropPrefProducer.setUserProfilePropertyValue(prefProducerNumber);
					applicationProfilePropPrefProducer.setDataSourceName(GAUserProfileServiceConstants.GA_USER_PROFILE_SOURCE_NAME);

					applicationUserProfile.getApplicationUserProfileProperty().add(applicationProfilePropPrefProducer);

					// construct ApplicationUserProfileProperty object for Producer Sub Number property
					ApplicationUserProfileProperty applicationProfilePropPrefProducerSub = new ApplicationUserProfileProperty();
					applicationProfilePropPrefProducerSub.setUserProfilePropertyName(GAUserProfileServiceConstants.PREF_PRODUCER_SUB_PROPERTY);
					applicationProfilePropPrefProducerSub.setUserProfilePropertyValue(prefSubProducerNumber);
					applicationProfilePropPrefProducerSub.setDataSourceName(GAUserProfileServiceConstants.GA_USER_PROFILE_SOURCE_NAME);

					applicationUserProfile.getApplicationUserProfileProperty().add(applicationProfilePropPrefProducerSub);
				}

				userProfile.getApplicationUserProfile().add(applicationUserProfile);
			}

		} catch (Exception ex) {
			getLogger().logSevere("Problem getting user info: " + ex.getMessage(), this.getClass().getName(), "retrieveUserInfo");
			throw new GAUserProfileSystemException("Problem getting user info: " + ex.getMessage());
		}
	}

	/**
	 * Gets the Source System key array.
	 * 
	 * @param userLogin
	 *            the user login
	 * @param srcSysID
	 *            the src sys id
	 * @return the producer number array
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public List<String> getSourceSystemKeyArray(String userLogin, String srcSysID) throws GAUserProfileSystemException {

		List<String> srcKeysArray = new ArrayList<String>();

		try {
			srcKeysArray = getKeyArrayforSourceSystem(userLogin, srcSysID);

		} catch (Exception ex) {
			getLogger().logSevere("Problem getting source system keys: " + ex.getMessage(), this.getClass().getName(), "getSourceSystemKeyArray");
			throw new GAUserProfileSystemException("Problem getting source system keys: " + ex.getMessage());
		}

		return srcKeysArray;
	}

	/**
	 * Gets the all app key values for each access attribute.
	 * 
	 * @param userAuthorizationList
	 *            the user authorization list
	 * @return the all app key values
	 */
	public Map<String, List<String>> getAllAppKeyValues(List<UserAuthorization> userAuthorizationList) {

		Map<String, List<String>> resultMap = new HashMap<String, List<String>>();

		List<String> producerSubAppKeysValues = new ArrayList<String>();
		List<String> clientAppKeysValues = new ArrayList<String>();

		UserAuthorization appKeysUserAuth = null;
		for (UserAuthorization userAuthorization : userAuthorizationList) {
			if (GAUserProfileServiceConstants.APPLICATION_KEYS_AUTH_TYPE_NAME.equals(userAuthorization.getUserAuthorizationTypeName())
					&& GAUserProfileServiceConstants.GA_USER_PROFILE_SOURCE_NAME.equals(userAuthorization.getDataSourceName())) {

				appKeysUserAuth = userAuthorization;
				break;
			}
		}

		if (appKeysUserAuth != null) {
			for (AccessAttribute accessAttribute : appKeysUserAuth.getAccessAttribute()) {

				// group all of the producer / sub access attributes
				if (GAUserProfileServiceConstants.PRODUCER_SUB_KEY_ATTR.equals(accessAttribute.getAccessAttributeName())) {
					for (String accessAttributeValue : accessAttribute.getAccessAttributeValue()) {
						producerSubAppKeysValues.add(accessAttributeValue);
					}
				}

				// group all of the client access attributes
				if (GAUserProfileServiceConstants.CLIENT_NUMBER_ATTR.equals(accessAttribute.getAccessAttributeName())) {
					for (String accessAttributeValue : accessAttribute.getAccessAttributeValue()) {
						clientAppKeysValues.add(accessAttributeValue);
					}
				}
			}

			resultMap.put(GAUserProfileServiceConstants.PRODUCER_SOURCE_SYSTEM_ID, producerSubAppKeysValues);
			resultMap.put(GAUserProfileServiceConstants.CLIENT_SOURCE_SYSTEM_ID, clientAppKeysValues);
		}

		return resultMap;
	}

	/**
	 * Authenticate admin user.
	 * 
	 * @param userCredential
	 *            the user credential
	 * @param modifiedById
	 *            the modified by id
	 * @param action
	 *            the action
	 * @throws GAUserProfileAuthenticationException
	 *             the gA user profile authentication exception
	 * @throws GAUserProfileSystemException
	 *             the gA user profile system exception
	 */
	public void authenticateAdminUser(UserCredential userCredential, String modifiedById, String action) throws GAUserProfileAuthenticationException,
			GAUserProfileSystemException {

		if (StringUtils.isEmpty(modifiedById)) {
			throw new GAUserProfileAuthenticationException("Modified by user id not found in the request");
		}

		boolean isValidAdmin = false;

		isValidAdmin = authenticateUser(userCredential.getAdminUsername(), userCredential.getAdminPassword());

		if (!isValidAdmin || !validateAdmin(userCredential.getAdminUsername(), action)) {
			throw new GAUserProfileAuthenticationException(userCredential.getAdminUsername() + " has no right to perform this action");
		}

	}

	/**
	 * Validate role action.
	 * 
	 * @param rolesActionMap
	 *            the roles action map
	 * @param currentRoles
	 *            the current roles
	 * @throws GAUserProfileFieldFormatException
	 *             the gA user profile field format exception
	 */
	public void validateRoleAction(Map<String, List<AccessControlGroup>> rolesActionMap, String currentRoles)
			throws GAUserProfileFieldFormatException {

		// Check if the role requested to be added already exists
		if (!rolesActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE).isEmpty()) {
			
//			List<AccessControlGroup> rolesToUpdate = new ArrayList<AccessControlGroup>();

			for( Iterator<AccessControlGroup> it = rolesActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE).iterator(); it.hasNext() ; ) {

				AccessControlGroup addRole = it.next();
				
				if (currentRoles.contains(addRole.getAccessControlGroupCategoryCode() + "." + addRole.getAccessControlGroupCode())) {

					getLogger().logWarning(
							"Role: " + addRole.getAccessControlGroupCategoryCode() + "." + addRole.getAccessControlGroupCode()
									+ " already exists for this user", this.getClass().getName(), "validateRoleAction");
					
					// remove the existing role from the ADD action list since it already exists
					it.remove();
					
					// add to UPDATE action list 
					// rolesToUpdate.add(addRole);
				}
			}
			
			// add the list of roles to update
//			for(AccessControlGroup updateRole : rolesToUpdate) {
//				rolesActionMap.get(GAUserProfileServiceConstants.UPDATE_ACTION_CODE).add(updateRole);	
//			}
		}

		// Validate that the role(s) being deleted exist for this user
//		if (!rolesActionMap.get(GAUserProfileServiceConstants.DELETE_ACTION_CODE).isEmpty()) {
//
//			for (AccessControlGroup deleteRole : rolesActionMap.get(GAUserProfileServiceConstants.DELETE_ACTION_CODE)) {
//
//				if (!currentRoles.contains(deleteRole.getAccessControlGroupCategoryCode() + "." + deleteRole.getAccessControlGroupCode())) {
//
//					getLogger().logSevere(
//							"Role: " + deleteRole.getAccessControlGroupCategoryCode() + "." + deleteRole.getAccessControlGroupCode()
//									+ " does not exist for this user", this.getClass().getName(), "validateRoleAction");
//					throw new GAUserProfileFieldFormatException("Role: " + deleteRole.getAccessControlGroupCategoryCode() + "."
//							+ deleteRole.getAccessControlGroupCode() + " does not exist for this user");
//				}
//			}
//		}
	}

	/**
	 * Gets the current user source systems.
	 * 
	 * @param userLogin
	 *            the user login
	 * @return the current user source systems
	 */
	public List<String> getCurrentUserSourceSystems(String userLogin) throws Exception {

		List<String> currentSourceSystems = new ArrayList<String>();

		Hashtable userSourceSystems = GAConnectionFactory.getUserAPI().getUserSourceSystems(userLogin);
		String[][] userSourceSystemsData = (String[][]) userSourceSystems.get("data");

		for (int i = 0; i < userSourceSystemsData.length;) {
			currentSourceSystems.add(userSourceSystemsData[i][0]);
			i++;
		}

		return currentSourceSystems;
	}

	/**
	 * Validate app keys action.
	 * 
	 * @param applicationKeysActionMap
	 *            the application keys action map
	 * @param currentAppKeysValues
	 *            the current app keys values
	 * @throws GAUserProfileFieldFormatException
	 *             the gA user profile field format exception
	 */
	public void validateAppKeysAction(Map<String, List<AccessAttribute>> applicationKeysActionMap, Map<String, List<String>> currentAppKeysValueMap)
			throws GAUserProfileFieldFormatException {

		// Validate that the application key(s) being added do not already exist for this user
		if (!applicationKeysActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE).isEmpty()) {

			for (AccessAttribute addAppKey : applicationKeysActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE)) {

				List<String> currentAppKeysValues = new ArrayList<String>();

				if (GAUserProfileServiceConstants.PRODUCER_SUB_KEY_ATTR.equals(addAppKey.getAccessAttributeName())) {
					currentAppKeysValues = currentAppKeysValueMap.get(GAUserProfileServiceConstants.PRODUCER_SOURCE_SYSTEM_ID);
				} else if (GAUserProfileServiceConstants.CLIENT_NUMBER_ATTR.equals(addAppKey.getAccessAttributeName())) {
					currentAppKeysValues = currentAppKeysValueMap.get(GAUserProfileServiceConstants.PRODUCER_SOURCE_SYSTEM_ID);
				}

				for (String accessAttributeValue : addAppKey.getAccessAttributeValue()) {
					if (currentAppKeysValues.contains(accessAttributeValue)) {

						getLogger().logSevere("Application key: " + addAppKey.getAccessAttributeValue() + " already exists for this user",
								this.getClass().getName(), "validateAppKeysAction");
						throw new GAUserProfileFieldFormatException("Application key: " + addAppKey.getAccessAttributeValue()
								+ " already exists for this user");
					}
				}
			}
		}

		// Validate that the application key(s) being deleted exist for this user
		if (!applicationKeysActionMap.get(GAUserProfileServiceConstants.DELETE_ACTION_CODE).isEmpty()) {

			for (AccessAttribute deleteAppKey : applicationKeysActionMap.get(GAUserProfileServiceConstants.DELETE_ACTION_CODE)) {

				List<String> currentAppKeysValues = new ArrayList<String>();

				if (GAUserProfileServiceConstants.PRODUCER_SUB_KEY_ATTR.equals(deleteAppKey.getAccessAttributeName())) {
					currentAppKeysValues = currentAppKeysValueMap.get(GAUserProfileServiceConstants.PRODUCER_SOURCE_SYSTEM_ID);
				} else if (GAUserProfileServiceConstants.CLIENT_NUMBER_ATTR.equals(deleteAppKey.getAccessAttributeName())) {
					currentAppKeysValues = currentAppKeysValueMap.get(GAUserProfileServiceConstants.CLIENT_SOURCE_SYSTEM_ID);
				}

				for (String accessAttributeValue : deleteAppKey.getAccessAttributeValue()) {
					if (!currentAppKeysValues.contains(accessAttributeValue)) {

						getLogger().logSevere("Application key: " + deleteAppKey.getAccessAttributeValue() + " does not exist for this user",
								this.getClass().getName(), "validateAppKeysAction");
						throw new GAUserProfileFieldFormatException("Application key: " + deleteAppKey.getAccessAttributeValue()
								+ " does not exist for this user");
					}
				}
			}
		}
	}

	/**
	 * Validate access attributes.
	 * 
	 * @param applicationKeysActionMap
	 *            the application keys action map
	 * @throws GAUserProfileFieldFormatException
	 *             the gA user profile field format exception
	 */
	public void validateAccessAttributes(Map<String, List<AccessAttribute>> applicationKeysActionMap) throws GAUserProfileFieldFormatException {

		if (applicationKeysActionMap != null) {

			// validate Add action attributes
			if (!applicationKeysActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE).isEmpty()) {
				for (AccessAttribute accessAttribute : applicationKeysActionMap.get(GAUserProfileServiceConstants.ADD_ACTION_CODE)) {
					if (!GAUserProfileServiceConstants.PRODUCER_SUB_KEY_ATTR.equals(accessAttribute.getAccessAttributeName())
							&&!GAUserProfileServiceConstants.PAS_SUB_KEY_ATTR.equals(accessAttribute.getAccessAttributeName())
							&& !GAUserProfileServiceConstants.CLIENT_NUMBER_ATTR.equals(accessAttribute.getAccessAttributeName())) {

						getLogger().logSevere(
								"Field Format Exception: Requesting to add an invalid Access Attribute name: "
										+ accessAttribute.getAccessAttributeName(), this.getClass().getName(), "validateAppKeys");
						throw new GAUserProfileFieldFormatException("Requesting to add an invalid Access Attribute name: "
								+ accessAttribute.getAccessAttributeName());
					}
				}
			}

			// validate Delete action attributes
			if (!applicationKeysActionMap.get(GAUserProfileServiceConstants.DELETE_ACTION_CODE).isEmpty()) {
				for (AccessAttribute accessAttribute : applicationKeysActionMap.get(GAUserProfileServiceConstants.DELETE_ACTION_CODE)) {
					if (!GAUserProfileServiceConstants.PRODUCER_SUB_KEY_ATTR.equals(accessAttribute.getAccessAttributeName())
							&&!GAUserProfileServiceConstants.PAS_SUB_KEY_ATTR.equals(accessAttribute.getAccessAttributeName())
							&& !GAUserProfileServiceConstants.CLIENT_NUMBER_ATTR.equals(accessAttribute.getAccessAttributeName())) {

						getLogger().logSevere(
								"Field Format Exception: Requesting to delete an invalid Access Attribute name: "
										+ accessAttribute.getAccessAttributeName(), this.getClass().getName(), "validateAppKeys");
						throw new GAUserProfileFieldFormatException("Requesting to delete an invalid Access Attribute name: "
								+ accessAttribute.getAccessAttributeName());
					}
				}
			}
		}
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
