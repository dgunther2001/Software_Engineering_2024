package engine;

/**
 * Actual execution component of the compute engine.
 */
public interface ProtoComputeExec {
    /**
     * Sends an acknowledgment back to the initializer
     */
    public void sendAckTokenToInitializaer();         // send an Acknowledgement token


    /**
     * Sends computed result back to initalizer
     * @param data
     */
    public void sendDataResponse(ProtoDataStream data); // exectutes the computation and has a response

}
