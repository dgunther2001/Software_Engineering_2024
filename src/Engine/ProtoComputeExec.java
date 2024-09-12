package engine;

/**
 * Actual execution component of the compute engine.
 */
public interface ProtoComputeExec {
    public void sendAckTokenToInitializaer();         // send an Acknowledgement token

    public DataStream sendDataResponse();

    public void sendDataResponse(Datastream data);

    public void doComputation();
}
