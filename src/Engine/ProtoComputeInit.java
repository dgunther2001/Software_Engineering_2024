package engine;

/**
 * An interface between the user and the actual execution component of the compute engine
 */
public interface ProtoComputeInit {
    /**
     * 
     * @param DataStream
     */
    public void sendComputeRequest(DataStream Data);

    /**
     * @param None
     * @return
     */
    public AckToken processExecAck();
}
