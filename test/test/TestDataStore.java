package test;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.util.List;

import engine.controller.Controller;
import engine.dataapi.DataStore;
import engine.dataapi.DataStream;


/**
 * Tests the controller to data storage component of the API.
 */
public class TestDataStore {

	/**
	 * Smoke test.
	 */
	@Test
	public void controllerToDataStore_API() throws Exception {
		
	    Controller mockController = Mockito.mock(Controller.class);
		
		DataStream mockDataStream = Mockito.mock(DataStream.class);
		when(mockDataStream.getData()).thenReturn(List.of("1", "3", "10"));


		DataStore testDataStore = new DataStore();
		//testDataStore.receiveDataStoreRequest(mockDataStream);
	}
	
}
