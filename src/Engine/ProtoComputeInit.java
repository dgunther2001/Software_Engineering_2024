package engine;

/**
 * An interface between the user and the actual execution component of the compute engine
 */
public interface ProtoComputeInit {
    /**
     * 
     * @param
     */
    public AckToken sendComputeRequest(ProtoComputeEngineDataStream data); // sends AckToken

    /**
     *
     * @return
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
}

