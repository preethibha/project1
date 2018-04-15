package com.chubb.ecom.dgmk.ga.domain.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import chubb_corporate.get_access.access_control_group.AccessControlGroup;
import chubb_corporate.get_access.user_profile_identifier.UserProfileIdentifier;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.connection.GAConnectionFactory;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileFieldFormatException;
import com.chubb.ecom.dgmk.ga.model.StringArray;
import com.chubb.ecom.dgmk.ga.util.GAUserProfilePropertiesUtil;
import com.chubb.ecom.dgmk.ga.util.GAUserProfileServiceConstants;

@RunWith(MockitoJUnitRunner.class)
public class GAUserProfileManagerUtilImplTest {
	
	@Mock
	ILogger gaLoggerMock;
	
//
//	HttpServletRequest mockedRequest;
//
//	/** The GA User Profile manager. */
//	private GAUserProfileManagerUtil userProfileManagerUtil;
//
//	private final String adminUserID = "p627301";
//	private final String adminPassword = "admin123";
//
//	private final String userID = "lcduser1";
//	private final String userPWD = "chubb123";
//	private final String newUserPassword = "chubb321";
//	private final String email = "lcduser1@gmail.com";
//
//	private final String gaAdminId = "websecadm";
//	private UserProfileIdentifier userProfileIdentifier;
//
//	@Before
//	public void setUp() {
//
//		mockedRequest = Mockito.mock(HttpServletRequest.class);
//
//		GAUserProfilePropertiesUtil.setGaAdminId(gaAdminId);
//
//		userProfileIdentifier = new UserProfileIdentifier();
//		userProfileIdentifier.setExternalUserId("lcduser1");
//	}
//
	
	@Test
	public void testValidateRoleAction() {	
		
		GAUserProfileManagerUtil userProfileManagerUtil = new GAUserProfileManagerUtil();
		userProfileManagerUtil.setLogger(gaLoggerMock);
		
		Map<String, List<AccessControlGroup>> rolesActionMap = new HashMap<String, List<AccessControlGroup>>();
		
		List<AccessControlGroup> addList = new ArrayList<AccessControlGroup>();
		AccessControlGroup ab = new AccessControlGroup();
		ab.setAccessControlGroupCategoryCode("A");
		ab.setAccessControlGroupCode("B");
		addList.add(ab);
		
		rolesActionMap.put(GAUserProfileServiceConstants.ADD_ACTION_CODE, addList);
		
		String currentRoles = "A.B";
		
		try {
			userProfileManagerUtil.validateRoleAction(rolesActionMap, currentRoles);
			
		} catch (GAUserProfileFieldFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
//	@Test
//	public void testAddSourceSystemKeys() {
//
//		try {
//			GAConnectionFactory.getUserAPI().deleteSourceSystemKeyFromUser("lcduser100", "Producer", "000540899999", "p627301");
//			GAConnectionFactory.getUserAPI().addSourceSystemKeyToUser("lcduser100", "Producer", "000540899999", "p627301");
//
//		} catch (Exception e) {
//			String rootCause = e.getClass().getSimpleName();
//			System.out.println(rootCause);
//		}
//	}
//
//	@Test
//	public void testChangePassword() {
//
//		try {
//			GAConnectionFactory.getUserAPI().changeValidatedPassword("lcduser1", "chubb124", "s", "p627301");
//
//		} catch (Exception e) {
//			String rootCause = e.getClass().getSimpleName();
//			System.out.println(rootCause);
//		}
//	}
//
//	@Test
//	public void testCreateUserRole() {
//
//		java.sql.Date startDate = null;
//
//		// default to current date
//		Calendar currenttime = Calendar.getInstance();
//		startDate = new java.sql.Date((currenttime.getTime()).getTime());
//
//		String[] userLogins = { "lcduser112" };
//		Object[][] roles = new Object[1][4];
//
//		roles[0][0] = "RCATAG";
//		roles[0][1] = "uXpltzCS";
//		roles[0][2] = startDate;
//		roles[0][3] = null;
//
//		try {
//			GAConnectionFactory.getUserAPI().addRolesToUsersByUser(userLogins, roles, adminUserID);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}
//	
//	@Test
//	public void testUpdateUserRoles() {
//
//		java.sql.Date startDate = null;
//
//		// default to current date
//		Calendar currenttime = Calendar.getInstance();
//		startDate = new java.sql.Date((currenttime.getTime()).getTime());
//
//		try {
//			GAConnectionFactory.getUserAPI().updateUserRole("lcduser1", "RCATAG", "uXpltzCS", startDate, null, null, adminUserID);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}	
//
//	@Test
//	public void testUpdateUser() {
//
//		Hashtable<String, String> colval = new Hashtable<String, String>();
//
//		colval.put("usr_login", "lcduser1");
//		colval.put("status", "ACTIVE");
//		colval.put("person_first_name", "LC User 1");
//		colval.put("person_last_name", "Test");
//		colval.put("person_middle_init", "K");
//		colval.put("person_type_code", "CHBEMP");
//
//		try {
//			// lcduser1
//			GAConnectionFactory.getUserAPI().updateUser("102893", "p627301", colval);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}
//
//	@Test
//	public void testDeleteSourceSystemKey() {
//
//		try {
//			GAConnectionFactory.getUserAPI().deleteSourceSystemKeyFromUser("lcduser1", "Producer", "000540899999", adminUserID);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}
//
//	@Test
//	public void testDeleteUser() {
//
//		try {
//			GAConnectionFactory.getUserAPI().deleteUser("testDelete", adminUserID);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}
//
//	@Test
//	public void testDeleteRole() {
//
//		try {
//
//			ArrayList<String> catcode = new ArrayList<String>();
//			ArrayList<String> rolecode = new ArrayList<String>();
//
//			catcode.add("RCATAG");
//			rolecode.add("aguniv");
//
//			GAConnectionFactory.getUserAPI().deleteUserRole("103297", "RCATAG", "aguniv");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}
//
//	/**
//	 * Test authenticate user
//	 */
//	@Test
//	public void testAuthenticateUser() {
//
//		try {
//			boolean result = userProfileManagerUtil.authenticateUser(adminUserID, adminPassword);
//
//			assertTrue(result);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}
//
//	/**
//	 * Test get validate admin
//	 */
//	@Test
//	public void testValidateAdmin() {
//
//		try {
//			boolean result = userProfileManagerUtil.validateAdmin(userID, adminUserID, GAUserProfileServiceConstants.UPDATE_USER_ACTION);
//
//			assertTrue(result);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}
//
//	/**
//	 * Test generate user login.
//	 */
//	@Test
//	public void testGenerateUserLogin() {
//
//		try {
//			
//			userProfileManagerUtil = new GAUserProfileManagerUtil();
//			
//			String result = userProfileManagerUtil.generateUserLogin(email);
//
//			System.out.println(result);
//
//			assertNotNull(result);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}
//
//	/**
//	 * Test get roles.
//	 */
//	@Test
//	public void testGetRoles() {
//
//		try {
//			String result = userProfileManagerUtil.getRoles(adminUserID);
//
//			assertNotNull(result);
//			assertTrue(result.contains("RCEMP.EMPLYS")); // test contains specific category and role id
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}
//
//	@Test
//	public void testGetEffectiveDate() {
//
//		try {
//			java.sql.Date effectiveDate = userProfileManagerUtil.getExistingEffectiveDate(userID, "RCEMP", "EMPLYS");
//
//			assertNotNull(effectiveDate);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}
//
//	/**
//	 * Test get role array.
//	 */
//	@Test
//	public void testGetRoleArray() {
//
//		try {
//			List<StringArray> result = userProfileManagerUtil.getRoleArray(adminUserID);
//
//			assertNotNull(result);
//			assertEquals(3, result.size());
//			assertTrue(result.get(0).getString().contains("ADMIN")); // test contains specific role
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}

}
