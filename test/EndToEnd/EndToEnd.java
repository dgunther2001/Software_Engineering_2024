package EndToEnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import engine.computeapi.ComputeEngineDataStream;
import engine.controller.Controller;
import engine.dataapi.DataStore;
import engine.dataapi.DataStream;
import engine.userapi.UserDataStream;

/**
 * Tests the system components and uses input data not from the Client.
 */
public class EndToEnd {
	
	// Can modify to run less tests.
	/**
	 * Number of tests to be ran.
	 */
	private static int NUM_TESTS_PER_RUN = 100;
	
	/**
	 * Main method for testing.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		/*
		 *  Doesn't use the Client, just sends data to the controller and 
		 *  runs it through the entire system.
		 */
		
		long seed = System.currentTimeMillis();
		Random random = new Random(seed);
		runFuzzyTest(seed, random);
		
	}
	
	/**
	 * Method to start the fuzzy test.
	 */
	@Test
	public void testFuzzy() {
		long seed = System.currentTimeMillis();
		Random random = new Random(seed);
		runFuzzyTest(seed, random);
	}
	
	/**
	 * The fuzzy test itself.
	 * @param seed
	 * @param random
	 */
	public static void runFuzzyTest(long seed, Random random) {
		System.out.println("Test running with seed: " + seed);
		List<String> input = new ArrayList<String>();
		for(int i = 0; i < NUM_TESTS_PER_RUN; i++) {
			for(int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					input.add(Integer.toString((int) ((Math.random() * (100000 - 1)) + 1)));
				}
			}
			passDataToSystem(input);
		}
	}
	
	/**
	 * The functionality of passing input data and running it through the controller,
	 * data store, and compute engine.
	 * @param input
	 */
	public static void passDataToSystem(List<String> input) {
		try {
			writeToFile(input, "D:\\Downloads\\Software_Engineering_Stuff\\arbitrary.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File doesn't exist.");
			e.printStackTrace();
		}
		
		DataStore testDataStore = new DataStore();		
		UserDataStream testUserData = testDataStore.readInputData("D:\\Downloads\\Software_Engineering_Stuff\\arbitrary.txt", ',', "D:\\Downloads\\Software_Engineering_Stuff\\output.txt");
		Controller testController = new Controller(testDataStore);
		
		// Make sure the controller can receive a user request.
		try {
			testController.receiveUserRequest(testUserData);
		} catch(Exception e) {
			System.out.println("Failed to pass user data.");
			e.printStackTrace();
		}
		
		// outData will hold the list of computed areas.
		List<String> outData = new ArrayList<String>();
		
		for(int i = 0; i < testUserData.getInput().size(); i++) {	
			// Grab the number of rectangles from the list at index i, and make a CEDS out of it.
			ComputeEngineDataStream inData = new ComputeEngineDataStream(testUserData.getInput().get(i));
			
			// Send a compute request from the controller to the compute engine.
			testController.sendComputeRequest(inData);
			
//			// Displaying the area.
//			System.out.println("Area of " + testUserData.getInput().get(i) + ": " + inData.getArea());

			// Store the results into a List to send to DataStore.
			outData.add(Float.toString(inData.getArea()));
			
		}
		
		System.out.println("Area List: " + outData);
		
		// Now send a data store request to store the data stream
		
		// sendDataStoreRequest throws an exception when the data stream list is not length 1. 
		// However, it still stores the data into the output file.
		// To avoid the error, I just made a list of length 1 containing an empty string, 
		// and passed this to sendDataStoreRequest. When passing this it still stores the data
		// from the outData List, but will now pass the empty string along with the delimiter
		// to the output file. 
		List<String> testList = new ArrayList<String>();
		testList.add("");
		
		DataStream testData = new DataStream(testList);
		testController.sendDataStoreRequest(testData);
		
		try {
			testDataStore.receiveDataStoreRequest(testData, "D:\\Downloads\\Software_Engineering_Stuff\\output.txt", ',');
		} catch (IOException e) {
			System.out.println("File doesn't exist.");
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Writes a list of strings to a file.
	 * @param list
	 * @param file
	 * @throws FileNotFoundException
	 */
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
	
	/**
	 * Clears a file.
	 * @param file
	 */
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
