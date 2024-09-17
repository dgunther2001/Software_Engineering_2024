package engine.user_api;

public interface ProtoUser {

    /**
     * Send a request to send 
     */
    public UserDataStream sendUserRequest(UserDataStream data);
    // receiveUserRequest(data) function in the controller
    // do computations and send back response


}
