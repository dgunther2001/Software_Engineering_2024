package engine.dataapi;

/**
 * Prototype interface for the data storage API.
 */
public interface ProtoDataStore {
    
    /**
     * Receives and processes data storage requests.
     */
    public DataStream receiveDataRequest(DataStream data);

}