package engine.compute_api;

public interface ProtoCompute {

    public ComputeAckToken receiveComputeRequest(ComputeEngineDataStream data); 

    public void sendComputeResponse(ComputeEngineDataStream data);
    
}
