package engine.controller;

import engine.computeapi.ComputeEngineDataStream;
import engine.computeapi.ProtoComputeEngineDataStream;
import engine.dataapi.DataStream;
import engine.userapi.UserDataStream;
import engine.userapi.ProtoUserDataStream;
import engine.userapi.User;

/**
 * Interface for the controller component to extend from.
 */
public interface ProtoController {

    /**
     * Receive and process a user request
     */
	 public ProtoUserDataStream receiveUserRequest(ProtoUserDataStream data); 

    /**
     * Send a compute request.
     */
	 public ProtoComputeEngineDataStream sendComputeRequest(ProtoComputeEngineDataStream data);

    /**
     * Send a data storage request.
     */
    public DataStream sendDataStoreRequest(DataStream data);
}
