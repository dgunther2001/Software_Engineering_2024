package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

import engine.computeapi.ComputeEngine;
import engine.computeapi.ComputeEngineDataStream;
import engine.controller.Controller;
import engine.dataapi.DataStore;
import engine.userapi.UserDataStream;


/**
 * System level integration tests
 */ 
public class ComputeEngineIntegrationTest {

  /**
   Calls a user request that percolates through the entire system
   */
	
  @Test
  public void integrationTest(UserDataStream userInput) {
    // simply send a user request and validate the output
	  Controller testController = new Controller();
	  ComputeEngine testComputeEngine = new ComputeEngine();	
	  DataStore testDataStore = new DataStore();
	  
	  testController.receiveUserRequest(userInput);
	  ComputeEngineDataStream engineData = testDataStore.convertData(userInput);
	  
	  testController.sendComputeRequest(engineData);
	  testComputeEngine.receiveComputeRequest(engineData);
	  
	  if(testComputeEngine.validateInput() == false) {
		  fail();
	  }
 
  }
}
