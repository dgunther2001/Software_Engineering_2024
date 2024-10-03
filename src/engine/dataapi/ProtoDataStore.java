package engine.dataapi;

import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

/**
 * Prototype interface for the data storage API.
 */
public interface ProtoDataStore {
	/**
	 * Receives a data request for output and processes it.
	 * we're gonna pass an id as well that we'll make in the controller to have a reference to our obj in the db
	 */	
	public DataStream receiveDataOutputRequest(DataStream newData, String id, File file);
	
	/**
	 * Request to store data
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	public void receiveDataStoreRequest(ProtoDataStream data) throws Exception;
	
	/**
	 * Spits out the list of data
	 * @return
	 * @throws Exception 
	 */
	public ProtoDataStream receiveUserOutRequest() throws Exception;
}


