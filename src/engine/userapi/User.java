package engine.userapi;

/**
 * Actual implementation of the user end of the API.
 */
public class User implements ProtoUser{

    /**
     * Sends a user request to the controller
     */
    @Override
    public UserDataStream sendUserRequest(UserDataStream data) {
    	// insantiate controller
    	// UserDataStream returnData = controller.receiveDataStream(data);
        return null;
    }

}
