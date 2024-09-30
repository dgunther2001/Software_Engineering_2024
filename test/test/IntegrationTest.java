package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import engine.computeapi.ComputeEngine;
import engine.controller.Controller;
import engine.dataapi.DataStore;
import engine.userapi.ProtoUserDataInput;
import engine.userapi.User;



/**
 * System level integration tests
 */ 
public class IntegrationTest extends ProtoUserDataInput {

  /**
   Calls a user request that percolates through the entire system
   */
  @Test
  public void integrationTest() {
	  // simply send a user request and validate the output
	  // Could have one test to test a valid user input and one to test an invalid user input.
	  // May just surround method calls in a try/catch block. If an exception is thrown the test will fail.
	  
	  ProtoUserDataInput firstTestData = new User();
	  User testUser = new User();
	  DataStore testDataStore = new DataStore();
	  Controller testController = new Controller(testUser);
	  ComputeEngine testCompEng = new ComputeEngine();
	
	  testController.receiveUserRequest(testUser.sendUserRequest(firstTestData)); // The controller will receive a user input request
	  
	  testController.sendComputeRequest(null); // will send the compute request based off the user input
	  
	  testCompEng.receiveComputeRequest(null); // will receive the compute request
	  
	  // will have a method here to get the data back from the compute engine
	  
	  // will have another method here to send the data from the compute engine back to the user
	  
	  
	  
  }

}
