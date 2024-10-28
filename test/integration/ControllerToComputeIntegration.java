package integration;

import org.junit.jupiter.api.Test;

import engine.computeapi.ComputeEngine;
import engine.computeapi.ComputeEngineDataStream;
import engine.controller.Controller;
import engine.dataapi.DataStore;

import static org.junit.jupiter.api.Assertions.fail;

public class ControllerToComputeIntegration {
	
	/**
	 * Integration test between the compute engine and controller.
	 */
	@Test
	public void test() {
		DataStore ds = new DataStore();
		ComputeEngine testEngine = new ComputeEngine();
		ComputeEngineDataStream data = new ComputeEngineDataStream(3);
		Controller testController = new Controller(ds);
		
		try {
			testController.sendComputeRequest(data);
			try {
				testEngine.receiveComputeRequest(data);
			} catch(IllegalArgumentException e) {
				e.printStackTrace();
				fail();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			fail();
		}
	}
	
}