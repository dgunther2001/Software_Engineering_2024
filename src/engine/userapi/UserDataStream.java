package engine.userapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Prototype of the data passed between user and controller
 */
public class UserDataStream implements ProtoUserDataStream{
	
	// Test input for step 6 in assignment 3.
	List<Integer> testInput = new ArrayList<>(Arrays.asList(1, 10, 25));
		
	// Test get methods for step 6 in assignment 3.
	/**
	 * 
	 * @return Returns the user input.
	 */
	public List<Integer> getInput() {
		return testInput;
	}
	
	/**
	 * 
	 * @param Test input.
	 */
	public UserDataStream(List<Integer> testInput) {
		this.testInput = testInput;
	}
	
}
