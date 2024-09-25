package engine.controller;

import engine.computeapi.*;
import engine.dataapi.*;
import engine.userapi.*;

/**
 * The controller which acts as the nexus of all of our APIs
 */
public class Controller implements ProtoController{
	/**
	 * Stores a user class
	 */
	User theUser;
	
	/**
	 * Controller constructor
	 */
	public Controller(User user) {
		this.theUser = user;
	}
	
    /**
     * Component that receives user requests.
     */
    @Override
    public ProtoUserDataStream receiveUserRequest(ProtoUserDataStream data) {
    	
    	// conversion logic from UserDataStream to ComputeEngineData Stream
    	// don't pass the value 10, pass the value actually want
    	// also need logic to split this into many many requests
    	while(data.getInput().iterator().hasNext()) {
    		ProtoComputeEngineDataStream individualStream = new ComputeEngineDataStream(data.getInput().iterator().next());
            ProtoComputeEngineDataStream returnData = sendComputeRequest(individualStream);
            // send data storage request
    	}
        
        // conversion logic to data store value
        // then send a data storage request
        
        // rinse and repeat until all values have been parsed
        
        // then grab all the values from data storage (will need to be another API
        // place them into a List<String> 
        // return that value back to the user
        
        return null;
    }

    /**
     * Component that sends a request to the Compute engine.
     */
    @Override
    public ProtoComputeEngineDataStream sendComputeRequest(ProtoComputeEngineDataStream data) {	
    	// all we have to do is use the user engine instead
    	return theUser.getComputeEngine().receiveComputeRequest(data);
    }

    /**
     * Component that sends request to the Data Storage component.
     */
    @Override
    public DataStream sendDataStoreRequest(DataStream data) {
        return null;
    }

}
