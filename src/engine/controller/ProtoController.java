package engine.controller;

import engine.compute_api.ComputeEngineDataStream;
import engine.user_api.UserDataStream;
import engine.user_api.UserAckToken;
import engine.data_api.DataAckToken;
import engine.data_api.DataStream;

public interface ProtoController {

    public UserAckToken receiveUserRequest(UserDataStream data); 

    public void sendUserResponse(UserDataStream data);

    public ComputeEngineDataStream sendComputeRequest(ComputeEngineDataStream data);

    public DataAckToken sendDataStoreRequest(DataStream data);
}
