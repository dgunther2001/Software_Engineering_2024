package test;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import engine.controller.Controller;
import engine.dataapi.DataStore;
import engine.dataapi.DataStream;


/**
 * Tests the controller to data storage component of the API.
 */
public class TestDataStore {

	/*
	 * Smoke test.
	 */
	@Test
	public void controllerToDataStore_API() throws Exception {
		
	    Controller mockController = Mockito.mock(Controller.class);
		when(mockController.sendDataStoreRequest(any(DataStream.class))).thenReturn(null);
		
		DataStream mockDataStream = Mockito.mock(DataStream.class);

		DataStore testDataStore = new DataStore();
		testDataStore.receiveDataRequest(mockDataStream);
	}
	
}
