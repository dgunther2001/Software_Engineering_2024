package engine;

/**
 * Data storage component attached to the controller
 */
public interface DataStore {

    /**
     * Store data in storage
     * use when starting a new computation
     * @param req
     * @return confirmation response
     */
    DataStoreResponse storeData(DataStorageRequest req);
    
    /**
     * get data from storage
     * use when you want to send back for further computation
     * @param key
     * @return confirmation response
     */
    DataLoadResponse getData(DataStoreKey key);
    
    /**
     * delete data in storage
     * use after the user receives an output
     * @param key
     * @return confirmation response
     */
    DataDeleteResponse deleteData(DataStoreKey key);
    
    /**
     * update data in storage
     * use between Reidman box iterations
     * @param key
     * @return confirmation response
     */
    DataUpdateResponse updateData(DataStoreKey key);
    
}
