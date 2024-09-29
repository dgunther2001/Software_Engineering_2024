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
import engine.computeapi.ComputeEngineDataStream;
import engine.dataapi.DataStore;
import engine.dataapi.DataStream;


/**
 * Tests the internals of the user to controller API.
 */
public class TestUserCompute {
	
	/**
	 * Smoke Test
	 */
	@Test
	public void userToController_API() throws Exception {
		
	    User mockUser = Mockito.mock(User.class);
	    
	    ComputeEngine mockComputeEngine = Mockito.mock(ComputeEngine.class);
	    when(mockUser.getComputeEngine()).thenReturn(mockComputeEngine);
	    
		UserDataStream mockUserDataStream = (UserDataStream) Mockito.mock(UserDataStream.class);
		when(mockUser.sendUserRequest(any(ProtoUserDataInput.class))).thenReturn(mockUserDataStream);
		when(mockUserDataStream.getInput()).thenReturn(List.of(1, 3, 10));
		
	    ComputeEngineDataStream mockComputeEngineDataStream = Mockito.mock(ComputeEngineDataStream.class);
	    when(mockComputeEngine.receiveComputeRequest(any(ComputeEngineDataStream.class))).thenReturn(mockComputeEngineDataStream);

	    DataStore mockDataStore = Mockito.mock(DataStore.class);
	    when(mockUser.getDataStore()).thenReturn(mockDataStore);
	    

	    DataStream mockDataStream = Mockito.mock(DataStream.class);
	    
	    
		Controller testController = new Controller(mockUser);
		testController.receiveUserRequest(mockUserDataStream);
	}
	
	
}
