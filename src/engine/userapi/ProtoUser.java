package engine.userapi;

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


}
