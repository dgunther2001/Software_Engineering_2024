package test;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.util.List;

import engine.controller.Controller;
import engine.userapi.User;
import engine.userapi.UserDataStream;
import engine.userapi.ProtoUserDataInput;

import engine.computeapi.ComputeEngine;
import engine.dataapi.DataStore;
import engine.computeapi.ComputeEngineDataStream;
import engine.userapi.UserDataInput;



/**
 * Tests the internals of the user to controller API.
 */
public class TestUserCompute {
	
	/**
	 * Smoke Test
	 */
	@Test
	public void userToController_API() throws Exception {
		
		Controller mockController = Mockito.mock(Controller.class);
		
		UserDataInput mockInput = Mockito.mock(UserDataInput.class);
		when(mockInput.getList()).thenReturn(List.of(1, 3, 25));
		
	    User testUser = new User();
	   
	    testUser.sendUserRequest(mockInput);
	    
	}
	
	
}
