package integration;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import engine.controller.Controller;
import engine.userapi.UserDataStream;
//import engine.controller.*;//real component
//import engine.computeapi.*;//another real component
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
		
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(10);
		arr.add(25);
		
		UserDataStream output = new UserDataStream(arr, '\n', "");
		IntegrationDataStore ds = new IntegrationDataStore();
		Controller testController = new Controller(ds);
		testController.receiveUserRequest(output);
		
		//DataStream data = ds.receiveData();
		String realOutput = ds.toString();

		String expectedOutput = "1.0\n0.38500008\n0.35360003\n";
		
		
		if(!realOutput.equals(expectedOutput)) {
			fail();//the actual test
		}
		
	}

	
	
}
