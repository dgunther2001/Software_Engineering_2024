package engine;

/**
 * An interface between the user and the actual execution component of the compute engine
 */
public interface ProtoComputeInit {
    public void sendComputeRequest(DataStream Data);

    public AckToken processExecAck();
}
