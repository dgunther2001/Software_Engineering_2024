package engine.controller;

import engine.computeapi.ComputeEngineDataStream;
import engine.computeapi.ComputeEngine;
import engine.dataapi.DataStream;
import engine.userapi.UserDataStream;

/**
 * The controller which acts as the nexus of all of our APIs
 */
public class Controller implements ProtoController{
	
	
    /**
     * Component that receives user requests.
     */
    @Override
    public UserDataStream receiveUserRequest(UserDataStream data) {
    	
    	// conversion logic from UserDataStream to ComputeEngineData Stream
    	// don't pass the value 10, pass the value actually want
    	// also need logic to split this into many many requests
    	ComputeEngineDataStream individualStream = new ComputeEngineDataStream(10 /* CHANGE LATER*/);
        ComputeEngineDataStream returnData =  sendComputeRequest(individualStream);
        
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
    public ComputeEngineDataStream sendComputeRequest(ComputeEngineDataStream data) {	
    	
    	//TODO: access compute engine in the User
    	// all we have to do is use the user engine instead
    	ComputeEngine engine = new ComputeEngine();
    	return engine.receiveComputeRequest(data);
    }

    /**
     * Component that sends request to the Data Storage component.
     */
    @Override
    public DataStream sendDataStoreRequest(DataStream data) {
        return null;
    }

}
