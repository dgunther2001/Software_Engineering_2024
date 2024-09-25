package infrastructure;
import engine.userapi.ProtoUserDataInput;

import java.util.ArrayList;
import java.util.List;

/**
 * An in memory implementation of the user data input
 */
public class UserDataInput implements ProtoUserDataInput{
    
	/**
	 * List containing the input list
	 */
    List<Integer> input = new ArrayList<Integer>();
    
    /**
     * Constructor
     */
    public UserDataInput(int [] arr) {
    	for( int x : arr) {
    		input.add(x);
    	}
    }

    /**
     * Grabs the list
     */
	@Override
	public List<Integer> getList() {
		return this.input;
	}
}
