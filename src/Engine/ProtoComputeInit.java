package engine;

/**
 * An interface between the user and the actual execution component of the compute engine
 */
public interface ProtoComputeInit {
    /**
     * 
     * @param
     */
    public AckToken sendComputeRequest(ProtoDataStream data); // sends AckToken

    /**
     *
     * @return
     */
    public ProtoDataStream receiveResponse(); // receives the response
}
