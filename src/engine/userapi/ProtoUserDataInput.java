package engine.userapi;

import java.util.ArrayList;
import java.util.List;
/**
 * user input data
 */
public interface ProtoUserDataInput {
	/**
	 * Holds an array of computations
	 */
	List<Integer> inputRectangleNumbers = new ArrayList<Integer>();

	/**
	 * Holds the delimiter
	 */
	char delimiter = ' ';
	
	/**
	 * Grabs the list
	 */
	public List<Integer> getList();

	public char getDelimiter();
}
