package engine.computeapi;

/**
 * The prototype for the compute engine api.
 */
public interface ProtoCompute {

    /**
     * Prototype for the receiving end of the Compute Engine.
     */
    public ComputeEngineDataStream receiveComputeRequest(ComputeEngineDataStream data); 

}
