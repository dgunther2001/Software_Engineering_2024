
package test;

import java.io.File;

import engine.controller.Controller;
import engine.userapi.UserDataStream;


public class TestUser {
	
	// TODO 3: change the type of this variable to the name you're using for your
	// User <-> ComputeEngine API; also update the parameter passed to the constructor
	private final Controller coordinator;

	/**
	 * 
	 * @param coordinator
	 */
	public TestUser(Controller coordinator) {
		this.coordinator = coordinator;
	}

	/**
	 * 
	 * @param outputPath
	 */
	public void run(String outputPath) {
		char delimiter = ';';
		String inputPath = "test/test" + File.separatorChar + "testInputFile.test";
		UserDataStream data = coordinator.getDataStore().readInputData(inputPath, outputPath, delimiter);
		coordinator.receiveUserRequest(data, delimiter);
		coordinator.getDataStore().receiveUserOutRequest(outputPath, delimiter);
	}

}
