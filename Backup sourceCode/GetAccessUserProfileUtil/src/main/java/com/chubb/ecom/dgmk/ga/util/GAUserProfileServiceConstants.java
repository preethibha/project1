package com.chubb.ecom.dgmk.ga.util;

public interface GAUserProfileServiceConstants {

	// Logging
	public final static String GA_APPLICATION_LOG_PATH = "/GetAccessUserProfileApp/logs/";
	public final static String GA_APPLICATION_LOG_FILE = "GaUserProfile.log";

	// Application
	public final static String SIMPLE_PING_TEST = "SimplePing";
	public final static String FULL_TEST = "Full";
	
	public final static String ADMIN_USER_ID_ATTR = "ApplicationAdminUserId";
	public final static String ADMIN_PASSWORD_ATTR = "ApplicationAdminPassword";
	public final static String EXISTING_PASSWORD_ATTR = "ExistingPassword";
	public final static String NEW_PASSWORD_ATTR = "NewPassword";
	public final static String TEMP_PASSWORD_ATTR = "TemporaryPassword";

	public final static String PASSWORD_EXPIRED_STATUS = "PASSWORD EXPIRED";
	public final static String ACTIVE_STATUS = "ACTIVE";
	public final static String INACTIVE_STATUS = "INACTIVE";

	public final static String PRODUCER_SOURCE_SYSTEM_ID = "Producer";
	public final static String CLIENT_SOURCE_SYSTEM_ID = "Client";

	public final static String APPLICATION_KEYS_AUTH_TYPE_NAME = "ApplicationKeys";
	public final static String APPLICATION_ATTR_AUTH_TYPE_NAME = "ApplicationAttributes";

	public final static String ADD_OPT_INCLUDE_FULL_USER_PROFILE = "IncludeFullUserProfile";
	public final static String ADD_OPT_INCLUDE_ACCESS_CONTROL_GROUP = "IncludeAccessControlGroup";
	public final static String ADD_OPT_INCLUDE_APP_USER_PROFILE = "IncludeApplicationUserProfile";
	public final static String ADD_OPT_INCLUDE_USER_AUHT = "IncludeUserAuthorization";

	public final static String CLIENT_NUMBER_ATTR = "CPNumber";
	public final static String PRODUCER_SUB_KEY_ATTR = "ProducerSubProducerKey";

	// User Profile values
	public final static String GA_USER_PROFILE_SOURCE_NAME = "GetAccess";

	public final static String MAILING_ADDRESS_TYPE_NAME = "MAILING";

	public final static String EMAIL_ADDRESS_COMM_DEVICE_CODE = "0050";
	public final static String EMAIL_ADDRESS_COMM_DEVICE_NAME = "E-MAIL ADDRESS";

	public final static String TELEPHONE_COMM_DEVICE_CODE = "0010";
	public final static String TELEPHONE_COMM_DEVICE_NAME = "TELEPHONE";

	public final static String DELEGATION_CODE_PROPERTY = "DelegationCode";
	public final static String PREF_PRODUCER_PROPERTY = "PreferredProducerNumber";
	public final static String PREF_PRODUCER_SUB_PROPERTY = "PreferredProducerSubNumber";

	public final static String ADD_OPT_BYPASS_STATUS_UPDATE = "BypassStatusUpdate";
	
	// GA API User Attributes
	public final static String ATTR_PERSON_ID = "person_id";
	public final static String ATTR_ACCOUNT_EXP_DATE = "account_exp_date";
	public final static String ATTR_ADDRESS_INDICATOR = "address_indicator";
	public final static String ATTR_ADDRESS1 = "addr1";
	public final static String ATTR_ADDRESS2 = "addr2";
	public final static String ATTR_CELL_PHONE = "cell_phone";
	public final static String ATTR_CHAR1 = "char1";
	public final static String ATTR_CHAR2 = "char2";
	public final static String ATTR_CITY = "city";
	public final static String ATTR_COMPANY_NAME = "company_name";
	public final static String ATTR_COUNTRY = "country";
	public final static String ATTR_CURRENCY_CODE = "currency_code";
	public final static String ATTR_DATE_CODE = "date_code";
	public final static String ATTR_DELEGATION_CODE = "delegation_code";
	public final static String ATTR_EMAIL = "email";
	public final static String ATTR_FAX = "fax";
	public final static String ATTR_GENERAL_TIMEOUT = "general_timeout";
	public final static String ATTR_IDLE_TIMEOUT = "idle_timeout";
	public final static String ATTR_LOCALE_CODE = "locale_code";
	public final static String ATTR_LOCALE_CODE_DEFAULT = "en_US";
	public final static String ATTR_DATE_CODE_DEFAULT = "en_US01";
	public final static String ATTR_NUMERIC_CODE = "numeric_code";
	public final static String ATTR_PAGER = "pager";
	public final static String ATTR_PASSWORD = "passwd";
	public final static String ATTR_FIRST_NAME = "person_first_name";
	public final static String ATTR_LAST_NAME = "person_last_name";
	public final static String ATTR_MIDDLE_INIT = "person_middle_init";
	public final static String ATTR_PERSON_TYPE_CODE = "person_type_code";
	public final static String ATTR_PHONE = "phone";
	public final static String ATTR_PASSWORD_EXP_DATE = "pwd_exp_date";
	public final static String ATTR_PASSWORD_EXT_INTERVAL = "pwd_exp_interval";
	public final static String ATTR_STATE = "state";
	public final static String ATTR_STATUS = "status";
	public final static String ATTR_TIME_ZONE = "time_zone_code";
	public final static String ATTR_TIME_ZONE_DEFAULT = "EST";
	public final static String ATTR_USER_LOGIN = "usr_login";
	public final static String ATTR_ZIP = "zip";
	public final static String ATTR_LAST_SUCCESS_LOGIN_DATE = "last_success_login_date";
	public final static String CN_LAST_SUCCESS_LOGIN_DATE = "LastSuccessLoginDate";
	
	// GA API User Plus Attributes
	public final static String ATTR_CMN_USER_GIN = "CHAR6";
	public final static String ATTR_PREF_PRODUCER_NUMBER = "CHAR1";
	public final static String ATTR_RACF_ID = "CHAR4";
	public final static String ATTR_ORG_ROLE_NAME = "CHAR7";

	// Status Codes
	public final static String SUCCESSFUL = "S";
	public final static String WARNING = "W";
	public final static String ERROR = "E";

	// Actions
	public final static String DELETE_USER_ACTION = "deleteUser";
	public final static String CREATE_USER_ACTION = "createUser";
	public final static String UPDATE_USER_ACTION = "updateUser";
	public final static String GET_INFO_ACTION = "getInfo";
	public final static String ROLE_ACTION = "role";
	public final static String PASSWORD_ACTION = "passwd";
	public final static String STATUS_ACTION = "status";

	public final static String ADD_ACTION_CODE = "ADD";
	public final static String UPDATE_ACTION_CODE = "UPDATE";
	public final static String DELETE_ACTION_CODE = "DELETE";

	// Roles
	public final static String ROLE_FOR_DEL = "RCEMP.blkAdm";
	public final static String HELP_DESK_PRIVILEGE = "hlpdsk";
	public final static String ASSIGN_ROLES_PRIVILEGE = "usrrle";
	public final static String USER_DELEGATION_PRIVILEGE = "delcod";
	public final static String USER_ADMINISTRATION_PRIVILEGE = "usradm";
	public final static String FULL_ADMINISTRATION_PRIVILEGE = "system";

	// Error codes
	public final static String ERROR_SEVERITY_LEVEL = "E";
	

	public final static String MANAGEMENT_SERVICE_NAME = "User Profile Management";
	public final static String RETRIEVAL_SERVICE_NAME = "User Profile Retrieval";
	public final static String ERROR_SOURCE_IDENTIFIER = "EBE04";

	public final static String ERROR_CODE_MANAGEMENT = "EPCRP28";
	public final static String ERROR_CODE_RETRIEVAL = "EPCRP31";

	// Error Service messages
	public final static String ERROR_CODE_DATA_FIELD_MISSING = "001";
	public final static String ERROR_DATA_FIELD_MISSING_MANAGEMENT = "A " + MANAGEMENT_SERVICE_NAME + " Service request data field is missing:";
	public final static String ERROR_DATA_FIELD_MISSING_RETRIEVAL = "A " + RETRIEVAL_SERVICE_NAME + " Service request data field is missing:";

	public final static String ERROR_CODE_MULTIPLE_DATA_FIELDS_MISSING = "002";
	public final static String ERROR_MULTIPLE_DATA_FIELDS_MISSING_MANAGEMENT = "One or more " + MANAGEMENT_SERVICE_NAME
			+ " Service request data fields is missing:";
	public final static String ERROR_MULTIPLE_DATA_FIELDS_MISSING_RETRIEVAL = "One or more " + RETRIEVAL_SERVICE_NAME
			+ " Service request data fields is missing:";

	public final static String ERROR_CODE_INVALID_COMBINATION = "003";
	public final static String ERROR_INVALID_COMBINATION_MANAGEMENT = "An invalid combination of " + MANAGEMENT_SERVICE_NAME
			+ " Service request data fields have been identified during cross relational editing:";
	public final static String ERROR_INVALID_COMBINATION_RETRIEVAL = "An invalid combination of " + RETRIEVAL_SERVICE_NAME
			+ " Service request data fields have been identified during cross relational editing:";

	public final static String ERROR_CODE_INVALID_FIELD_FORMAT = "004";
	public final static String ERROR_INVALID_FIELD_FORMAT_MANAGEMENT = "A " + MANAGEMENT_SERVICE_NAME
			+ " Service request data field is not of correct format or length:";
	public final static String ERROR_INVALID_FIELD_FORMAT_RETRIEVAL = "A " + RETRIEVAL_SERVICE_NAME
			+ " Service request data field is not of correct format or length:";

	public final static String ERROR_CODE_DATA_SOURCE = "005";
	public final static String ERROR_DATA_SOURCE_MANAGEMENT = "The " + MANAGEMENT_SERVICE_NAME
			+ " Service was unable to process due to an unavailable Data Source:";
	public final static String ERROR_DATA_SOURCE_RETRIEVAL = "The " + RETRIEVAL_SERVICE_NAME
			+ " Service was unable to process due to an unavailable Data Source:";

	public final static String ERROR_CODE_SYSTEM = "006";
	public final static String ERROR_SYSTEM_MANAGEMENT = "The " + MANAGEMENT_SERVICE_NAME + " Service was unable to process due to a System error:";
	public final static String ERROR_SYSTEM_RETRIEVAL = "The " + RETRIEVAL_SERVICE_NAME + " Service was unable to process due to a System error:";

	public final static String ERROR_CODE_AUTHENTICATION = "007";
	public final static String ERROR_AUTHENTICATION_MANAGEMENT = "The " + MANAGEMENT_SERVICE_NAME + " Service encountered an Authentication Error for the User:";
	public final static String ERROR_AUTHENTICATION_RETRIEVAL = "The " + RETRIEVAL_SERVICE_NAME + " Service encountered an Authentication Error for the User:";

	public final static String ERROR_CODE_NOT_FOUND = "008";
	public final static String ERROR_NOT_FOUND_MANAGEMENT = "The " + MANAGEMENT_SERVICE_NAME + " Service was unable to find the User Profile:";
	public final static String ERROR_NOT_FOUND_RETRIEVAL = "The " + RETRIEVAL_SERVICE_NAME + " Service was unable to find the User Profile:";
	
	public final static String ERROR_CODE_ROLLBACK_SUCCESS = "009";
	public final static String ERROR_ROLLBACK_SUCCESS = "The " + MANAGEMENT_SERVICE_NAME + " Service was unsuccessful. No updates to the User Profile have occured:";
	
	public final static String ERROR_CODE_ROLLBACK_NOT_SUCCESS = "010";
	public final static String ERROR_ROLLBACK_NOT_SUCCESS = "The " + MANAGEMENT_SERVICE_NAME + " Service was unsuccessful.  The rollback to the original User Profile state may be corrupt. A manual rebuild of the User Profile may be required:";

	public final static String ERROR_CODE_MULTIPLE = "011";
	public final static String ERROR_MULTIPLE = "The GetUserProfile operation encountered multiple User Profiles with the same User Profile Identifier.";
	public static final String PAS_SOURCE_SYSTEM_ID = "PAS";	
	public final static String PAS_SUB_KEY_ATTR = "PASSourceProducerCode";
}
