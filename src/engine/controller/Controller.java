package engine.controller;

import engine.compute_api.ComputeEngineDataStream;
import engine.user_api.UserDataStream;
import engine.user_api.UserAckToken;
import engine.data_api.DataAckToken;
import engine.data_api.DataStream;


public class Controller implements ProtoController{

    public UserAckToken receiveUserRequest(UserDataStream data) {
        return null;
    }

    public void sendUserResponse(UserDataStream data) {

    }


    public ComputeEngineDataStream sendComputeRequest(ComputeEngineDataStream data) {
        return null;
    }

    
    public DataAckToken sendDataStoreRequest(DataStream data) {
        return null;
    }

}
