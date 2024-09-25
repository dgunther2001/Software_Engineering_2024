package engine.userapi;

/**
 * Actual implementation of the user end of the API.
 */

import engine.controller.Controller;
import engine.controller.ProtoController;
import engine.dataapi.*;

import java.util.List;

import engine.computeapi.*;

/**
 * The base user class
 */
public class User implements ProtoUser{
	
	/**
	 * Holds the controller
	 */
	ProtoController sysctl;
	
	/**
	 * Holds the compute engine
	 */
	ProtoCompute engine;
	
	/**
	 * Holds the data storage class
	 */
	ProtoDataStore dataStore; 
	
	/**
	 * Instantiates all of the needed system components and stores them in the user
	 */
	public User() {
		sysctl = new Controller(this);
		engine = new ComputeEngine();
		dataStore = new DataStore();
	}	
	
	/**
	 * Grabs a reference to the compute engine
	 */
	public ProtoCompute getComputeEngine() {
		return this.engine;
	}

    /**
     * Sends a user request to the controller
     */
    @Override
    public ProtoUserDataStream sendUserRequest(ProtoUserDataInput data) {
        List<Integer> rectangles = data.getList(); // grab the input list
        UserDataStream inputStream = new UserDataStream(rectangles); // turn it into a user data stream
        return sysctl.receiveUserRequest(inputStream); // call the controller an set the entry point there
    }
    
    


}
