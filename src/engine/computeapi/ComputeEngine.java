package engine.computeapi;

/**
 * The API that receives a request to the compute engine
 */
public class ComputeEngine implements ProtoCompute {

    /**
     * Receives a compute request from the controller
     */
    @Override
    public ComputeEngineDataStream receiveComputeRequest(ComputeEngineDataStream data) {
        return null;
    }

}
