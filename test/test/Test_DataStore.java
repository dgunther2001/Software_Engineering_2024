package test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import engine.*;

public class Test_DataStore {
	
	// add test testComputeToDataStore
	/*
	@Test
	public void testComputeToDataStoreAPI() throws Exception {
		
	    DataStoreKey mockDataKey = Mockito.mock(DataStoreKey.class);

		
		ComputeInit testComputeInit = new Compute();
		testComputeInit.getData(mockDataKey);
	}
	*/

	@Test
	public void testDataStoreToComputeAPI() throws Exception {
		
	    DataStoreKey mockDataKey = Mockito.mock(DataStoreKey.class);

		
		DataStore testDataStore= new DataStore();
		testDataStore.getData(mockDataKey);
	}
	
}
