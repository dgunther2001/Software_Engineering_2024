package EndToEnd;

import java.util.ArrayList;
import java.util.List;

import engine.controller.Controller;
import engine.userapi.UserDataStream;
import engine.dataapi.DataStore;

/**
 * Tests the system components and uses input data not from the Client.
 */
public class EndToEnd {
	
	/**
	 * Main method for testing.
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 *  Doesn't use the Client, just sends data to the controller and 
		 *  runs it through the entire system.
		 *  
		 *  Going to try to get one test input to work then I will make a loop to test multiple inputs.
		 *  
		 *  First, make a UserDataStream object to hold the input information.
		 *  Second, use the controller's sendDataStoreRequest method to send the user input data to the DataStore.
		 *   
		 */
		
		List<Integer> input = new ArrayList<Integer>();
		
		UserDataStream testUserData = new UserDataStream(input, '\n', "arbitrary.txt");
		DataStore data = new DataStore();
		Controller testController = new Controller(data);
		
		
		
		
	}

}
