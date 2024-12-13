package EndToEnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import engine.computeapi.ComputeEngineDataStream;
import engine.controller.Controller;
import engine.dataapi.DataStore;
import engine.dataapi.DataStream;
import engine.userapi.UserDataStream;

/**
 * Tests the system components and uses input data not from the Client.
 */
public class EndToEnd {
	
	/**
	 * Main method for testing.
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		/*
		 *  Doesn't use the Client, just sends data to the controller and 
		 *  runs it through the entire system.
		 *  
		 *  Going to try to get one test input to work then I will make a loop to test multiple inputs.
		 *  
		 *  First, make a UserDataStream object to hold the input information.
		 *  Second, use the controller's sendDataStoreRequest method to send the user input data to the DataStore.
		 *   
		 *  The datastore will then send the data back to the controller
		 *  
		 *  The userDataStream is sent from the user to the controller.
		 *   
		 */
		
		List<String> input = new ArrayList<String>();
//		
//		for(int i = 0; i < 10000; i++) {
//			for (int j = 0; j < 100; j++) {
//				input.add(Integer.toString((int) ((Math.random() * (100000 - 1)) + 1)));
//			}
//		}
//		
		for(int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				input.add(Integer.toString((int) ((Math.random() * (10 - 1)) + 1)));
			}
		}
		
		System.out.println(input);
		
		
		writeToFile(input, "D:\\Downloads\\Software_Engineering_Stuff\\arbitrary.txt");
		
		//clearFile("D:\\Downloads\\Software_Engineering_Stuff\\arbitrary.txt");
		
		DataStore testDataStore = new DataStore();		
		UserDataStream testUserData = testDataStore.readInputData("D:\\Downloads\\Software_Engineering_Stuff\\arbitrary.txt", ',', "D:\\Downloads\\Software_Engineering_Stuff\\output.txt");
		
		Controller testController = new Controller(testDataStore);
		
		testController.receiveUserRequest(testUserData);
		
		// Have a for loop to iterate through the list and put every integer from the list 
		// into the computeEngineDataStream for computing. For now I will use one input.
		
		// Get one input from the list, convert it to a string, and pass it through the compute engine.
		
		List<String> outData = new ArrayList<String>();
		
		for(int i = 0; i < testUserData.getInput().size(); i++) {	
			// Grab the number of rectangles from the list at index i, and make a CEDS out of it.
			ComputeEngineDataStream inData = new ComputeEngineDataStream(testUserData.getInput().get(i));
			
			// Send a compute request from the controller to the compute engine.
			testController.sendComputeRequest(inData);
			
			// Displaying the area.
			System.out.println("Area of " + testUserData.getInput().get(i) + ": " + inData.getArea());

			
			
		}
		
		
		
//		int listVal = testUserData.getInput().get(0);
//		
//		ComputeEngineDataStream inData = new ComputeEngineDataStream(listVal);
//		
//		testController.sendComputeRequest(inData);
//				
//		System.out.println("Area of " + listVal + ": " + inData.getArea());
		
		// Store the results back into the List and send that list to DataStore.
		// The list is a list of strings.
		// Now send a data store request to store the data stream
		
		//DataStream data = new DataStream();
		
		//testController.sendDataStoreRequest(null);	
		
		
	}
	
	public static void writeToFile(List<String> list, String file) throws FileNotFoundException {
	    try (PrintWriter writer = new PrintWriter(new File(file))) {
	        for (int i = 0; i < list.size(); i++) {
	            writer.print(list.get(i));
	            if (i < list.size() - 1) {
	                writer.print(","); // Add comma after each element except the last one
	            }
	        }
	        System.out.println("Wrote information to file.");
	    } catch (FileNotFoundException e) {
	        System.out.println("Failure");
	        e.printStackTrace();
	    }
	}

	
	public static void clearFile(String file) {
		try(PrintWriter writer = new PrintWriter(new File(file))) {
			writer.print("");
			System.out.println("Cleared file.");
		} catch (FileNotFoundException e) {
			System.out.println("Failed to clear file.");
			e.printStackTrace();
		}
	}

}
