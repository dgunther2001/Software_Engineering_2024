package engine.controller;

import engine.computeapi.ComputeEngineDataStream;
import engine.dataapi.DataStream;
import engine.userapi.UserDataStream;

/**
 * The controller which acts as the nexus of all of our APIs
 */
public class Controller implements ProtoController{

    /**
     * Component that receives user requests.
     */
    @Override
    public UserDataStream receiveUserRequest(UserDataStream data) {
        return null;
    }

    /**
     * Component that sends a request to the Compute engine.
     */
    @Override
    public ComputeEngineDataStream sendComputeRequest(ComputeEngineDataStream data) {
        return null;
    }

    /**
     * Component that sends request to the Data Storage component.
     */
    @Override
    public DataStream sendDataStoreRequest(DataStream data) {
        return null;
    }

}
