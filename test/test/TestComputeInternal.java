package test;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import engine.computeapi.ComputeEngine;
import engine.computeapi.ComputeEngineDataStream;
import engine.controller.Controller;

/**
 * Test the coontroller to compute engine API.
 */
public class TestComputeInternal {
	
	/**
	 * Smoke test.
	 */
	@Test
	public void controllerToCompute_API() throws Exception {
		
	    Controller mockController = Mockito.mock(Controller.class);
		when(mockController.sendComputeRequest(any(ComputeEngineDataStream.class))).thenReturn(null);
		
		ComputeEngineDataStream mockComputeEngineDataStream = Mockito.mock(ComputeEngineDataStream.class);
		when(mockComputeEngineDataStream.getRectangles()).thenReturn(1);
		
		ComputeEngine testComputeEngine = new ComputeEngine();
		testComputeEngine.receiveComputeRequest(mockComputeEngineDataStream);
	}
	
}
