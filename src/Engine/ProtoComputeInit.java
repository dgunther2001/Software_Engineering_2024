package engine;
j
/**
 * An interface between the user and the actual execution component of the compute engine
 */
public interface ProtoComputeInit {
       /**
     * Sends a compute request to the execution engine with a compute engine data stream value
     */
    public AckToken sendComputeRequest(ProtoDataStream data); 

    /**
     * Function that receives a parsable data stream back from the execution engine
     */
    public ProtoDataStream receiveResponse(); // receives the response
}
