package engine.userapi;

import java.util.ArrayList;
import java.util.List;
/**
 * user input data
 */
public abstract class ProtoUserDataInput {
	/**
	 * Holds an array of computations
	 */
	List<Integer> inputRectangleNumbers = new ArrayList<Integer>();
	
	/**
	 * Grabs the list
	 */
	public List<Integer> getList() {
		return this.inputRectangleNumbers;
	}
}
