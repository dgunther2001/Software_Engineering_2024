package infrastructure;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import engine.dataapi.DataStream;
import engine.dataapi.ProtoDataStore;
import engine.dataapi.ProtoDataStream;

public class IntegrationDataStore implements ProtoDataStore{

    //couldn't implement ProtoDataStore bs methods don't use the same types of data

	/**
	 * Integration test for receival of a data storage request
	 */
    public List<String> receiveDataRequest(List<Integer> data) {
        List<String> result = new ArrayList<String>();
        for(int i : data){
            result.add(Integer.toString(i));
        }
        return result;
    }

    /**
	 * Holds the data
	 */
	private DataStream data;
	
	/**
	 * Constructor method
	 */
	public IntegrationDataStore() {
		this.data = new DataStream(new ArrayList<>());
	}
	
	/**
	 * Actually receives an individual data storage request
	 */
	@Override
	public void receiveDataStoreRequest(ProtoDataStream newData) {
		data.append(newData);
		
	}
	
	/**
	 * Spits out the list of data
	 * @return
	 */
	public DataStream receiveUserOutRequest() {
		return data;
	}

	/**
	 * will be purged
	 */
	@Override
	public DataStream receiveDataOutputRequest(DataStream newData, String id, File file) {
		// TODO Auto-generated method stub
		return null;
	}

}
