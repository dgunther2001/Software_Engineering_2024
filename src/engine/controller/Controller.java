package engine.controller;


//import engine.computeapi.ComputeEngine;
import engine.computeapi.ProtoComputeEngineDataStream;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.List;

import engine.computeapi.ComputeEngineDataStream;
import engine.userapi.User;
import engine.userapi.ProtoUserDataStream;
import engine.dataapi.ProtoDataStream;
import engine.dataapi.DataStream;

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
    	
    	if (data.getInput() == null || !data.getInput().iterator().hasNext()) {
    	    throw new IllegalArgumentException("Input data can't be null");
    	}
    	
    	Iterator<Integer> dataIt = data.getInput().iterator();
    	while(dataIt.hasNext()) {
    		ProtoComputeEngineDataStream individualStream = new ComputeEngineDataStream(data.getInput().iterator().next());
            ProtoComputeEngineDataStream returnData = sendComputeRequest(individualStream);
            List<String> dataConv = new ArrayList<String>();
            Float currentArea = returnData.getArea();
            
            try {
            	String dataConvAdd = currentArea.toString();
            	dataConv.add(dataConvAdd);
            } catch (Exception e) {
            	System.out.println("Floating point data unable to convert to string for storage.");
            	e.printStackTrace();
            }
           
            if (dataConv.size() != 1) {
            	throw new IllegalStateException("Output of compute engine is invalud size.");
            }
            ProtoDataStream toStore = new DataStream(dataConv);
            
            
            sendDataStoreRequest(toStore);
            dataIt.next();
            // send data storage request
    	}
    	
    	ProtoDataStream finalData = theUser.getDataStore().receiveUserOutRequest();
    	if (finalData.getData().size() != data.getInput().size()) {
    		throw new IllegalStateException("Input array size doesn't match output array size.");
    	}
    	data.setOutput(finalData.getData());
    	return data;
    	
        
        // conversion logic to data store value
        // then send a data storage request
        
        // rinse and repeat until all values have been parsed
        
        // then grab all the values from data storage (will need to be another API
        // place them into a List<String> 
        // return that value back to the user
        
    }

    /**
     * Component that sends a request to the Compute engine.
     */
    @Override
    public ProtoComputeEngineDataStream sendComputeRequest(ProtoComputeEngineDataStream data) {	
    	// all we have to do is use the user engine instead
    	if (data.getRectangles() <= 0) {
    		throw new IllegalArgumentException("Number of rectangles should be greater than or equal to 0.");
    	}
    	return theUser.getComputeEngine().receiveComputeRequest(data);
    }

    /**
     * Component that sends request to the Data Storage component.
     */
    @Override
    public void sendDataStoreRequest(ProtoDataStream data) {
    	if (data.getData().size() != 1) {
    		throw new IllegalArgumentException("Data specified to pass to data store is not a length==1 arraylist of strings.");
    	}
        theUser.getDataStore().receiveDataStoreRequest(data);
    }

}
