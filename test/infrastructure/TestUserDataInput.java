package infrastructure;
import engine.userapi.ProtoUserDataInput;

import java.util.ArrayList;
import java.util.List;

/**
 * An in memory implementation of the user data input
 */
public class TestUserDataInput implements ProtoUserDataInput{
    
	/**
	 * List containing the input list
	 */
    List<Integer> input = new ArrayList<Integer>();

	/**
	 * Delimiter
	 * 
	 */
	char delimiter = '\n';
    
    /**
     * Constructor
     */
    public TestUserDataInput(int [] arr, char delimiter) {
    	for( int x : arr) {
    		input.add(x);
    	}
		this.delimiter = delimiter;
    }

    /**
     * Grabs the list
     */
	@Override
	public List<Integer> getList() {
		return this.input;
	}

	/**
	 * Returns the delimiter
	 */
	@Override
	public char getDelimiter() {
		return this.delimiter;
	}
}
