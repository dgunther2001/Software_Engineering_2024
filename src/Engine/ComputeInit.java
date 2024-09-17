package engine;

/**
 * Actual implementation of thecompute engine intermediary
 */
public class ComputeInit {
	ProtoComputeEngineDataStream sendToComputeExec;
	ProtoDataStream sendToUser;
	DataStorageRequest sendToDataStore;
    /**
     * Sends a compute request to the execution engine
     */
    public AckToken sendComputeRequest(ProtoComputeEngineDataStream data) {
        return null;
    }

    /**
     * Receives back an execution engine result (an integer)
     */
    public ProtoComputeEngineDataStream receiveComputeResponse() {
        return null;
    }

    /**
     * takes in a user request
     */
    public void receiveUserRequest(ProtoDataStream data) {

    }

    /**
     * this is the final response sent to the user
     */
    public ProtoDataStream sendResponseToUser() {
        return null;
    }
}
