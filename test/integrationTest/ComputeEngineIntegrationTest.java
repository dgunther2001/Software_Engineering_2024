package integrationTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

import engine.userapi.*;
import engine.controller.*;//real component
import engine.computeapi.*;//another real component
import infrastructure.UserDataInput;//test data input
import infrastructure.UserDataStream;//test output
import infrastructure.IntegrationDataStore;//fake db


/**
 * to test the 2 engine and controller and the api between them
 * the purpose of this is to simulate how these two components work in an isolated environment.
 * I'm only going to call the sendUserRequest(UserDataStream d) to simulate a natural use of the system.
 * It will be isolating only the controller and compute engine because we have a fake db in test\infrastructure 
 * and we're directly pushing values from user so we don't have to worry about that for errors.
 * This is more of a checklist or template for our actual implementation.
 * 
 */
public class ComputeEngineIntegrationTest{

	/**
	 * A call to a compute engine integration test
	 */
	@Test
	public void test() {
		int[] arr = {1, 10, 25};
		User user = new User();
		UserDataInput dataIn = new UserDataInput(arr); // converts to a list<Integer> in the constructor
		
		UserDataStream output = (UserDataStream) user.sendUserRequest(dataIn);
		
		String realOutput = output.toString();
		String expectedOutput = "1\n10\n25\n";
		
		if(realOutput != expectedOutput) fail();//the actual test
		
		
		
	}
}
