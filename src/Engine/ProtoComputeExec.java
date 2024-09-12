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
    public void sendDataResponse(Datastream data);

    /**
     * Executes the computation
     */
    public void doComputation();
}
