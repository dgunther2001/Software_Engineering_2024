package test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import engine.*;

public class Test_Compute_Internal {
	
	// add a comparable test for testInitToExec()
	@Test
	public void testInitToExecAPI() throws Exception {
	    ComputeEngineDataStream mockData = Mockito.mock(ComputeEngineDataStream.class);
	
	    ComputeInit testInit = new ComputeInit();
	    testInit.sendComputeRequest(mockData);
	}
	
	@Test
	public void testExecToInitAPI() throws Exception {
		
	    ComputeEngineDataStream mockData = Mockito.mock(ComputeEngineDataStream.class);

		
		ComputeExec testExec = new ComputeExec();
		testExec.sendDataResponse(mockData);
	}
	
}
