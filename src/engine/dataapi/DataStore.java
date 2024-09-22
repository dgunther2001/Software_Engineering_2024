package engine.dataapi;

import engine.computeapi.ComputeEngineDataStream;
import engine.userapi.UserDataStream;

/**
 * Receiving end of the data storage API.
 */
public class DataStore implements ProtoDataStore{

    /**
     * Receives a data request and processes it.
     */
    @Override
    public DataStream receiveDataRequest(DataStream data) {
        return null;
    }
    
    /**
     * 
     * @param Receives the user input data to be converted.
     * @return Returns the data as a ComputeEngineDataStream.
     */
    public ComputeEngineDataStream convertData(UserDataStream data) {
    	ComputeEngineDataStream engineData = new ComputeEngineDataStream();
    	return engineData;
    }

    
}
