package Engine;
public interface ProtoComputeExec {
    public void sendAckTokenToInitializaer();         // send an Acknowledgement token

    public DataStream sendDataResponse();

    public void sendDataResponse(Datastream data);

    public void doComputation();
}
