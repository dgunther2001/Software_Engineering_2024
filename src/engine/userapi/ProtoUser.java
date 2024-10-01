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

    /**
     * getter for the compute engine from user object
     * @return
     */
	public ProtoCompute getComputeEngine();

/**
 * getter for the dataStore from User object
 * @return
 */
	public ProtoDataStore getDataStore();


    
}
