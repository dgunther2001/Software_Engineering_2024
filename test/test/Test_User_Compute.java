package test;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import engine.controller.Controller;
import engine.user_api.User;
import engine.user_api.UserDataStream;

/**
 * Tests the internals of the user to controller API.
 */
public class Test_User_Compute {
	
	/**
	 * Smoke Test
	 */
	@Test
	public void userToController_API() throws Exception {
		
	    User mockUser = Mockito.mock(User.class);
		when(mockUser.sendUserRequest(any(UserDataStream.class))).thenReturn(null);
		
		UserDataStream mockUserDataStream = Mockito.mock(UserDataStream.class);

		Controller testController = new Controller();
		testController.receiveUserRequest(mockUserDataStream);
	}
	
	
}
