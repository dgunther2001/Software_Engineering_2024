package engine.userapi;

import engine.computeapi.ProtoCompute;
import engine.dataapi.ProtoDataStore;

/**
 * The prototype user end of the user controller api
 */
public interface ProtoUser {

    /**
     * Send a request to the controller
     */
    public ProtoUserDataStream sendUserRequest(ProtoUserDataInput data);
    // receiveUserRequest(data) function in the controller
    // do computations and send back response

    
	public ProtoCompute getComputeEngine();


	public ProtoDataStore getDataStore();


    
}
