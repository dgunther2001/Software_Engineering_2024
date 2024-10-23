package infrastructure;
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
import engine.userapi.ProtoUser;
import engine.userapi.ProtoUserDataInput;
import engine.userapi.ProtoUserDataStream;
import engine.userapi.UserDataStream;

public class IntegrationUser implements ProtoUser{

		/**
		 * 
		 * @param data
		 * @return
		 */
	    public ProtoUserDataStream sendUserRequest(ProtoUserDataInput data) {

	        List<Integer> rectangles = data.getList(); // grab the input list
	        
	        if (rectangles.size() <= 0) {
	        	throw new IllegalArgumentException("Invalid Number of User Inputs Specified (List Length <= 0)");
	        }
	        
	        ProtoUserDataStream inputStream = new UserDataStream(rectangles,data.getDelimiter(), ""); // turn it into a user data stream
	        return receiveUserRequest(inputStream); // call the controller an set the entry point there
	    }
	    
	    


}

