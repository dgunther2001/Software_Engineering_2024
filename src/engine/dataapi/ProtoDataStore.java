package engine.dataapi;

import java.io.File;
import java.util.UUID;

/**
 * Prototype interface for the data storage API.
 */
public interface ProtoDataStore {

	/**
	 * Receives a data request for output and processes it.
	 * we're gonna pass an id as well that we'll make in the controller to have a reference to our obj in the db
	 */
	public DataStream receiveDataRequest(DataStream newData, String id, File file);
}
