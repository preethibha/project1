package com.chubb.ecom.dgmk.ga.domain.manager;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import chubb_corporate.business.change_get_access_user_password_reply_ebe4x1.ChangeGetAccessUserPasswordReply;
import chubb_corporate.business.change_get_access_user_password_request_ebe4x1.ChangeGetAccessUserPasswordRequest;
import chubb_corporate.business.get_access_user_profile_request_ebe4x1.GetAccessUserProfileRequest;
import chubb_corporate.business.reset_get_access_user_password_request_ebe4x1.ResetGetAccessUserPasswordRequest;
import chubb_corporate.get_access.access_attribute.AccessAttribute;
import chubb_corporate.get_access.user_authorization.UserAuthorization;
import chubb_corporate.get_access.user_profile.UserProfile;
import chubb_corporate.get_access.user_profile_identifier.UserProfileIdentifier;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.domain.command.GACommand;
import com.chubb.ecom.dgmk.ga.domain.command.GACommandFactory;
import com.chubb.ecom.dgmk.ga.domain.command.GACommandFactoryImpl;
import com.chubb.ecom.dgmk.ga.domain.resource.ResetGetAccessUserPasswordResource;
import com.chubb.ecom.dgmk.ga.domain.util.GAUserProfileManagerUtil;
import com.chubb.ecom.dgmk.ga.model.UserCredential;
import com.chubb.ecom.dgmk.ga.util.GAUserProfilePropertiesUtil;
import com.chubb.ecom.dgmk.ga.util.GAUserProfileServiceConstants;

@RunWith(MockitoJUnitRunner.class)
public class GAUserProfileManagerImplTest {

	@Mock
	ILogger gaLoggerMock;

	@Mock
	GACommandFactory gaCommandFactoryMock;

	@Mock
	GAUserProfileManagerUtil userProfileManagerUtil;

	@Mock
	GACommand gaCommand;

	HttpServletRequest mockedRequest;

	/** The GA User Profile manager. */
	private GAUserProfileManagerImpl gaUserProfileManager;

	private final String adminUserID = "p627301";
	private final String adminPassword = "admin123";

	private final String userID = "lcduser1";
	private final String userPWD = "chubb123";
	private final String newUserPassword = "chubb321";
	private final String email = "lcduser1@gmail.com";

	private final String gaAdminId = "websecadm";
	private UserProfileIdentifier userProfileIdentifier;

	@Before
	public void setUp() {
		userProfileManagerUtil = Mockito.mock(GAUserProfileManagerUtil.class);
		/*mockedRequest = Mockito.mock(HttpServletRequest.class);

		gaCommand = Mockito.mock(GACommand.class);
		userProfileManagerUtil = Mockito.mock(GAUserProfileManagerUtil.class);
		gaCommandFactoryMock = Mockito.mock(GACommandFactoryImpl.class);

		gaUserProfileManager = new GAUserProfileManagerImpl();

		// set up mocks for each command
		Mockito.when(
				gaCommandFactoryMock.getUpdateUserPasswordCommand(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
						Mockito.anyBoolean())).thenReturn(gaCommand);
		Mockito.when(gaCommandFactoryMock.getUpdateUserStatusCommand(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(
				gaCommand);

		// inject the mock logger object (**** WHAT IF WE COULD NOT INJECT A MOCK LOGGER OBJECT? TRY COMMENTING THE BELOW LINE AND RUN TEST)
		gaUserProfileManager.setGaCommandFactory(gaCommandFactoryMock);
		gaUserProfileManager.setLogger(gaLoggerMock);
		gaUserProfileManager.setUserProfileManagerUtil(userProfileManagerUtil);

		GAUserProfilePropertiesUtil.setGaAdminId(gaAdminId);

		userProfileIdentifier = new UserProfileIdentifier();
		userProfileIdentifier.setExternalUserId("lcduser1");*/
	}

	/**
	 * Test reset user password
	 */
/*	@Test
	public void testResetGetAccessUserPassword() {

		try {

			Mockito.when(userProfileManagerUtil.isUserLoginTaken(userID)).thenReturn(true);
			Mockito.when(userProfileManagerUtil.authenticateUser(adminUserID, adminPassword)).thenReturn(true);
			Mockito.when(userProfileManagerUtil.validateAdmin(adminUserID, GAUserProfileServiceConstants.PASSWORD_ACTION)).thenReturn(true);

			ResetGetAccessUserPasswordRequest request = new ResetGetAccessUserPasswordRequest();
			request.setUserProfileIdentifier(userProfileIdentifier);

			UserCredential userCredential = new UserCredential(); // the header data
			userCredential.setAdminUsername(adminUserID);
			userCredential.setAdminPassword(adminPassword);
			userCredential.setNewUserPassword(newUserPassword);
			userCredential.setIpAddress("127.1.1.1");

			// reset the password
			ResetGetAccessUserPasswordResource result = gaUserProfileManager.resetGetAccessUserPassword(request, userCredential);

			assertNotNull(result);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}*/

	/**
	 * Test change get access user password.
	 */
	/*@Test
	public void testChangeGetAccessUserPassword() {

		try {

			Mockito.when(userProfileManagerUtil.isUserLoginTaken(userID)).thenReturn(true);
			Mockito.when(userProfileManagerUtil.authenticateUser(adminUserID, adminPassword)).thenReturn(true);
			Mockito.when(userProfileManagerUtil.validateAdmin(adminUserID, GAUserProfileServiceConstants.PASSWORD_ACTION)).thenReturn(true);

			ChangeGetAccessUserPasswordRequest request = new ChangeGetAccessUserPasswordRequest();
			request.setUserProfileIdentifier(userProfileIdentifier);

			UserCredential userCredential = new UserCredential(); // the header data
			userCredential.setAdminUsername(adminUserID);
			userCredential.setAdminPassword(adminPassword);
			userCredential.setExistingUserPassword(userPWD);
			userCredential.setNewUserPassword(newUserPassword);
			userCredential.setIpAddress("127.1.1.1");

			// change the password
			ChangeGetAccessUserPasswordReply result = gaUserProfileManager.changeGetAccessUserPassword(request, userCredential);

			assertNotNull(result);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}*/
	
	@Test
	public final void testGetUserInformation() throws Exception {
		
		GetAccessUserProfileRequest req=new GetAccessUserProfileRequest();
		UserProfileIdentifier upi=new UserProfileIdentifier();
		upi.setExternalUserId("alokeas");
		req.setUserProfileIdentifier(upi);
		UserProfile user=new UserProfile();
		GAUserProfileManagerUtil userProfile=new GAUserProfileManagerUtil();
		
		UserAuthorization userAuthorization = new UserAuthorization();
		userAuthorization.setUserAuthorizationTypeName(GAUserProfileServiceConstants.APPLICATION_KEYS_AUTH_TYPE_NAME);
		userAuthorization.setDataSourceName(GAUserProfileServiceConstants.GA_USER_PROFILE_SOURCE_NAME);
		userProfile.retrievePasInfo("alokeas",userAuthorization);
		for(AccessAttribute ac:userAuthorization.getAccessAttribute()){
			if(ac.getAccessAttributeName().equals(GAUserProfileServiceConstants.PAS_SUB_KEY_ATTR)){
				for(String pas:ac.getAccessAttributeValue()){
					System.out.println(pas);
				}
			}
		}
		System.err.println(user);
	}

}
