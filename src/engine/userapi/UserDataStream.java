package engine.userapi;

import java.util.ArrayList;
import java.util.List;

/**
 * Prototype of the data passed between user and controller
 */
public class UserDataStream implements ProtoUserDataStream{
	/**
	 * input list of integers
	 */
	List<Integer> input = new ArrayList<Integer>();
	
	/**
	 * output list of strings
	 */
	List<String> output = new ArrayList<String>();

	/**
	 * Holds the delimiter
	 */
	char delimiter; 
	
	/**
	 * Filepath
	 */
	String filePath;
	
	/**
	 * Grabs the input array
	 */
	@Override
	public List<Integer> getInput() {
		return this.input;
	}
	
	/**
	 * Grabs the output array
	 */
	@Override
	public List<String> getOutput() {
		return this.output;
	}
	
	/**
	 * Allows us to append to the output array
	 */
	@Override
	public void appendOutput(String newValue) {
		output.add(newValue);
	}
	
	/**
	 * The constructor that requires a list of integer inputs
	 */
	public UserDataStream(List<Integer> inputs, char delimiter, String filePath) {
		this.input = inputs;
		this.delimiter = delimiter;
		this.filePath = filePath;
	}
	
	/**
	 * Converts the output string list to a singular string
	 */
	@Override
	public String toString() {
		String retStr= "";
		for(String listElement : output) {
			retStr = retStr + listElement +"\n";
		}
		return retStr;
	}
	
	/**
	 * Sets the output list
	 */
	@Override
    public void setOutput(List<String> outputList) {
        this.output = outputList;
    }

	/**
	 * grabs the delimiter
	 */
	@Override
	public char getDelimiter() {
		return this.delimiter;
	}
	
	/**
	 * Grab the filepath
	 */
	@Override
	public String getFilePath() {
		return this.filePath;
	}
}
