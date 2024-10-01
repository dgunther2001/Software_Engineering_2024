package engine.userapi;

import java.util.List;

/**
 * user input data
 */
public class UserDataInput implements ProtoUserDataInput{
	/**
	 * Holds the number of desired rectangles for a specific computation in a list
	 */
    List<Integer> inputRectangleNumbers;
    
    char delimiter; // holds the delimiter value

    /**
     * Grabs the list of rectangle numbers
     */
    @Override
    public List<Integer> getList() {
    	return inputRectangleNumbers;
    }

    /**
     * Grabs the delimiter
     */
    public char getDelimiter() {
		return this.delimiter;
	}
}
