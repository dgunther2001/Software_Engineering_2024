package engine.userapi;

/**
 * Actual implementation of the user end of the API.
 */

import java.util.List;

import engine.computeapi.ComputeEngine;
import engine.computeapi.ProtoCompute;
import engine.controller.Controller;
import engine.controller.ProtoController;
import engine.dataapi.DataStore;
import engine.dataapi.ProtoDataStore;

//import engine.computeapi.*;

/**
 * The base user class
 */
public class User implements ProtoUser{
	

	
	
	/**
	 * Instantiates all of the needed system components and stores them in the user
	 */
	public User() {
	}	
	

    /**
     * Sends a user request to the controller
     */
    //@Override
    /*
    public ProtoUserDataStream sendUserRequest(ProtoUserDataInput data) {
    	try {
	        List<Integer> rectangles = data.getList(); // grab the input list
	        
	        if (rectangles.size() <= 0) {
	        	throw new IllegalArgumentException("Invalid Number of User Inputs Specified (List Length <= 0)");
	        }
	        
	        ProtoUserDataStream inputStream = new UserDataStream(rectangles,data.getDelimiter()); // turn it into a user data stream
	        return sysctl.receiveUserRequest(inputStream); // call the controller an set the entry point there
 
    	} catch (Throwable t) {
    		t.printStackTrace();
    		return null;
    	}
    }
    */



}
