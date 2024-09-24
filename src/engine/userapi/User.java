package engine.userapi;

/**
 * Actual implementation of the user end of the API.
 */

import engine.controller.*;
import engine.dataapi.*;
import engine.computeapi.*;

public class User implements ProtoUser{
	
	ProtoController sysctl;
	ProtoCompute engine;
	ProtoDataStore dataStore; 
	
	public User() {
		sysctl = new Controller();
		engine = new ComputeEngine();
		dataStore = new DataStore();
	}	

    /**
     * Sends a user request to the controller
     */
    @Override
    public ProtoUserDataStream sendUserRequest(ProtoUserDataInput data) {
        return null;
    }
    
    


}
