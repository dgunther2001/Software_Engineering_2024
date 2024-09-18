package engine.controller;

import engine.compute_api.ComputeEngineDataStream;
import engine.data_api.DataStream;
import engine.user_api.UserDataStream;

/**
 * Interface for the controller component to extend from.
 */
public interface ProtoController {

    /**
     * Receive and process a user request
     */
    public UserDataStream receiveUserRequest(UserDataStream data); 

    /**
     * Send a compute request.
     */
    public ComputeEngineDataStream sendComputeRequest(ComputeEngineDataStream data);

    /**
     * Send a data storage request.
     */
    public DataStream sendDataStoreRequest(DataStream data);
}
