package engine.dataapi;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Receiving end of the data storage API.
 */
public class DataStore implements ProtoDataStore{
	List<Integer> data;
	
    /**
     * Receives a data request for output and processes it.
     * we're gonna pass an id as well that we'll make in the controller to have a reference to our obj in the db
     */
    @Override
    public DataStream receiveDataRequest(DataStream newData, String id) {
        // search db or file for id
    	// if no make new db entry for current list and add value
    	// if yes append data to existing entry
    	//return db entry
    	return null;
        
    }

    
}
