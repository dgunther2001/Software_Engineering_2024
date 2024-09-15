package engine;

/**
 * Actual execution component of the compute engine.
 */
public interface ProtoComputeExec {
    /**
     * This sends an acknowledgment token back to the compute initializer, whcih indicates the data was parsed correctly
     */
    public void sendAckTokenToInitializaer();         // send an Acknowledgement token


    /**
     * Sends the result back to the intializer, which will then be parsed and put into data storage via another api
     */
    public void sendDataResponse(ProtoDataStream data); // exectutes the computation and has a response

}
