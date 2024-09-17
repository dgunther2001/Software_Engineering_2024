package engine;
import java.util.ArrayList;

public class DataStore implements ProtoDataStore{
	 DataStorageRequest dataValue;
	 /**
     * Store data in storage
     * use when starting a new computation
     * @param req
     * @return confirmation response
     */
    public DataStoreResponse storeData(DataStorageRequest req) {
    	return null;
    }
    
    /**
     * get data from storage
     * use when you want to send back for further computation
     * @param key
     * @return confirmation response
     */
    public DataLoadResponse getData(DataStoreKey key) {
    	return null;
    }
    
    /**
     * delete data in storage
     * use after the user receives an output
     * @param key
     * @return confirmation response
     */
    public DataDeleteResponse deleteData(DataStoreKey key) {
    	return null;
    }
    
    /**
     * update data in storage
     * use between Reidman box iterations
     * @param key
     * @return confirmation response
     */
    public DataUpdateResponse updateData(DataStoreKey key) {
    	return null;
    }
}
