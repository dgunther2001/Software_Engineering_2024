package test;

import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import engine.*;

public class Test_User_Compute {
	
	// add testComputeToUser

	@Test
	public void testUserToComputeAPI() throws Exception {
	    DataStream mockData = Mockito.mock(DataStream.class);

		
		User testUser = new User();
		testUser.userInputProto(mockData);
	}
	
	
}
