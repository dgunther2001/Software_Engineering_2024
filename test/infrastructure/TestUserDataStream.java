package infrastructure;

import java.util.ArrayList;
import java.util.List;

import engine.userapi.ProtoUserDataStream;

/**
 * This is the data passed to and from the user to the controller
 */
public class TestUserDataStream implements ProtoUserDataStream {
	
	/**
	 * Holds an input list
	 */
	List<Integer> input = new ArrayList<Integer>();
	
	/**
	 * Holds an output list
	 */
	List<String> output = new ArrayList<String>();
	
	/**
	 * Constructor
	 */
	public TestUserDataStream(List<Integer> inputs) {
		this.input = inputs;
	}
	
	/**
	 * Conversion of output to a singular string
	 */
	public String toString() {
		String retStr= "";
		for(String listElement : output) {
			retStr = retStr + listElement +"\n";
		}
		return retStr;
	}

	/**
	 * Grab the input
	 */
	@Override
	public List<Integer> getInput() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Grab the output
	 */
	@Override
	public List<String> getOutput() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Append to the output array
	 */
	@Override
	public void appendOutput(String newValue) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Sets the output list
	 */
	@Override
    public void setOutput(List<String> outputList) {
        this.output = outputList;
    }
}
