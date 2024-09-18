package engine.user_api;

/**
 * The prototype user end of the user controller api
 */
public interface ProtoUser {

    /**
     * Send a request to the controller
     */
    public UserDataStream sendUserRequest(UserDataStream data);
    // receiveUserRequest(data) function in the controller
    // do computations and send back response


}
