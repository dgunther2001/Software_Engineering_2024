package engine;

/**
 * An interface between the user and the actual execution component of the compute engine
 */
public interface ProtoComputeInit {
    /**
     * Sends a compute request to the execution engine with a compute engine data stream value
     */
    public AckToken sendComputeRequest(ProtoComputeEngineDataStream data); // sends AckToken

    /**
     * Function that receives a parsable data stream back from the execution engine
     */
    public ProtoComputeEngineDataStream receiveComputeResponse(); // receives the response

    /**
     * Sends an acknowledgement token to the user and receives the input data
     */
    public void receiveUserRequest(ProtoDataStream data);

    /**
     * Sends a user parsable data stream back to the user
     */
    public ProtoDataStream sendResponseToUser();

    /**
     * Sends a data storagre request and receives a data storage response
     */
    public AckToken dataStorageRequest(DataStorageRequest data);
    
}

