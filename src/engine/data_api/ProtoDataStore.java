package engine.data_api;

public interface ProtoDataStore {
    
    public DataAckToken receiveDataRequest(DataStream data);

    public void sendDataResponse(DataStream data);
}
