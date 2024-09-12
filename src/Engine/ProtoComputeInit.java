package Engine;

public interface ProtoComputeInit {
    public void sendComputeRequest(DataStream Data);

    public AckToken processExecAck();
}
