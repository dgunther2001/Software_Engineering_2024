package integration;

import org.junit.jupiter.api.Test;

import engine.dataapi.DataStore;
import engine.userapi.UserDataStream;
import infrastructure.IntegrationUser;
import infrastructure.TestUserDataInput;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * to test the 2 DataStore component and controller and the api between them
 * the purpose of this is to simulate how these two components work in an isolated environment.
 * I'm only going to call the sendUserRequest(UserDataStream d) to simulate a natural use of the system.
 * It will be isolating only the controller and dataStore because we have a fake compute engine in test\infrastructure 
 * and we're directly pushing values from user so we don't have to worry about that for errors.
 * This is more of a checklist or template for our actual implementation.
 * 
 */
public class DataStoreIntegration {

	/**
	 * Integration test compute engine returns the same list as a double so the output should 
	 * be the input just as a double
	 */
	@Test
	public void test() {
		
		int[] arr = {1, 10, 25};
		IntegrationUser user =  new IntegrationUser(new DataStore());
		TestUserDataInput dataIn = new TestUserDataInput(arr, '\n');
		
		UserDataStream output = (UserDataStream) user.sendUserRequest(dataIn);
		
		String realOutput = output.toString();
		String expectedOutput = "1.0\n10.0\n25.0\n";
		
		if(!realOutput.equals(expectedOutput)) {
			fail();//the actual test
		}
	}
	
	/**
	 * Integration test to ensure an exception is thrown for invalid input
	 * the User api is throwing the exception 
	 */
	@Test
	public void testExceptions() {
		int[] arr = {};
		IntegrationUser user =  new IntegrationUser(new DataStore());
		//TestUserDataInput dataIn = new TestUserDataInput(arr, '\n');
		TestUserDataInput dataIn = null;
		
		boolean throwsException = false;
		try {
		UserDataStream output = (UserDataStream) user.sendUserRequest(dataIn);
		}catch(Throwable e) {
			throwsException = true;
		}
		assertTrue(throwsException);
	}
}
