package integration;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import engine.computeapi.ComputeEngine;
import engine.controller.Controller;
import engine.dataapi.DataStore;
import engine.userapi.User;
import engine.userapi.UserDataStream;
//import engine.controller.*;//real component
//import engine.computeapi.*;//another real component
import infrastructure.TestUserDataInput;//test data input
import infrastructure.TestUserDataStream;//test output
import infrastructure.IntegrationDataStore;//fake db
import infrastructure.IntegrationUser;




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
		IntegrationUser user = new IntegrationUser(new ComputeEngine());//put in the tested component
		TestUserDataInput dataIn = new TestUserDataInput(arr, '\n'); // converts to a list<Integer> in the constructor
		
		UserDataStream output = (UserDataStream) user.sendUserRequest(dataIn);
		
		String realOutput = output.toString();
		String expectedOutput = "1.0\n0.38500008\n0.35360003\n";
		
		
		if(!realOutput.equals(expectedOutput)) {
			fail();//the actual test
		}
		
	}
	
	/**
	 * ensure exception is thrown
	 * 
	 * user api is throwing it
	 */
	@Test
	public void testExceptions() {
		int[] arr = {};
		IntegrationUser user =  new IntegrationUser(new ComputeEngine());
		TestUserDataInput dataIn = new TestUserDataInput(arr, '\n');
		//TestUserDataInput dataIn = null;
		
		boolean throwsException = false;
		try {
		UserDataStream output = (UserDataStream) user.sendUserRequest(dataIn);
		}catch(Throwable e) {
			throwsException = true;
		}
		assertTrue(throwsException);
	}
	
	
}
