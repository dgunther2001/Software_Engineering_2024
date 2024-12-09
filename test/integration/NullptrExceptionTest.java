package integration;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import engine.controller.Controller;
import engine.userapi.UserDataStream;
import infrastructure.IntegrationDataStore;

/**
 * Nullptr Exception Test
 */
public class NullptrExceptionTest {
	/**
	 * ensure exception is thrown
	 * 
	 * user api is throwing it
	 */
	@Test
	public void testExceptions() {
		List<Integer> arr = new ArrayList<>();
		UserDataStream output = new UserDataStream(arr, '\n', "");
		IntegrationDataStore ds = new IntegrationDataStore();
		Controller testController = new Controller(ds);
		
		boolean throwsException = false;
		try {
			testController.receiveUserRequest(output);
		}catch(Throwable e) {
			throwsException = true;
		}
		assertTrue(throwsException);
	}
}
