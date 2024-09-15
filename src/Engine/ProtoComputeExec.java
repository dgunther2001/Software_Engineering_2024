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
     * Sends computed result back to initializer
     * @param data
     */
    public void sendDataResponse(ProtoComputeEngineDataStream data); // executes the computation and has a response

}
