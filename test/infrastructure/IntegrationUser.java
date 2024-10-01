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

	//import engine.computeapi.*;

	/**
	 * The base user class
	 */
		
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
		 * will use fake datastore
		 */
		public IntegrationUser(ProtoCompute compute) {
			sysctl = new Controller(this);
			engine = compute;
			dataStore = (ProtoDataStore) new IntegrationDataStore();
		}	
		/**
		 * Instantiates real controller and real datastore
		 * uses fake compute engine
		 * @param store
		 */
		public IntegrationUser(ProtoDataStore store) {
			sysctl = new Controller(this);
			engine = new IntegrationComputeEngine();
			dataStore = store;

		}
		
		/**
		 * Grabs a reference to the compute engine
		 */
		@Override
		public ProtoCompute getComputeEngine() {
			return this.engine;
		}
		
		/**
		 * Allows us to grab the data store
		 * @return
		 */
		@Override
		public ProtoDataStore getDataStore() {
			return this.dataStore;
		}

	    /**
	     * Sends a user request to the controller
	     */
	    @Override
	    public ProtoUserDataStream sendUserRequest(ProtoUserDataInput data) {

	        List<Integer> rectangles = data.getList(); // grab the input list
	        
	        if (rectangles.size() <= 0) {
	        	throw new IllegalArgumentException("Invalid Number of User Inputs Specified (List Length <= 0)");
	        }
	        
	        ProtoUserDataStream inputStream = new UserDataStream(rectangles,data.getDelimiter()); // turn it into a user data stream
	        return sysctl.receiveUserRequest(inputStream); // call the controller an set the entry point there
	    }
	    
	    


}

