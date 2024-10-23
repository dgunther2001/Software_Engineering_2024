package engine.controller;

//import engine.computeapi.ComputeEngineDataStream;
import engine.computeapi.ProtoComputeEngineDataStream;
import engine.dataapi.DataStore;
import engine.dataapi.DataStream;
import engine.dataapi.ProtoDataStream;
//import engine.userapi.UserDataStream;
import engine.userapi.ProtoUserDataStream;
//import engine.userapi.User;

/**
 * Interface for the controller component to extend from.
 */
public interface ProtoController {
	
	 /**
	  * Holds a data storage device
	  */
	 DataStore dataStorage = new DataStore();
	 
	 /**
	  * Return the data store
	  * @return
	  */
	 public DataStore getDataStore();

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
    public void sendDataStoreRequest(ProtoDataStream data);
    
}
