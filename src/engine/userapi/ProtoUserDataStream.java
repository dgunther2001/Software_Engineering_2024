package engine.userapi;

import java.util.List;

/**
 * Prototype data sent between user and controller
 * user output data
 */
public interface ProtoUserDataStream {
	
	/**
	 * Grabs the input list
	 */
	public List<Integer> getInput();
	
	/**
	 * Grabs the output list
	 */
	public List<String> getOutput();
	
	/**
	 * Takes in a string and appends it to the output list
	 */
	public void appendOutput(String newValue);
	
	/**
	 * Converts the output to a string
	 */
	public String toString();
	
	/**
	 * Sets the entire output array
	 * @param outputList
	 */
	public void setOutput(List<String> outputList);
}
