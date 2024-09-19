package test;

import org.junit.jupiter.api.Test;


import engine.computeapi.ComputeEngine;
import engine.computeapi.ComputeEngineDataStream;
import engine.controller.Controller;
import engine.userapi.UserDataStream;


/**
 * System level integration tests
 */ 
public class IntegrationTest {

  /**
   Calls a user request that percolates through the entire system
   */
	
  @Test
  public void integrationTest(ComputeEngineDataStream data, UserDataStream userInput) {
    // simply send a user request and validate the output
	  Controller testController = new Controller();
	  ComputeEngine testComputeEngine = new ComputeEngine();
	  
	  testController.receiveUserRequest(userInput);

	  
	  
	  
  }
}
