package integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

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

	@Test
	public void test() {
		
	}
}
