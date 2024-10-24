package infrastructure;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import engine.dataapi.DataStream;
import engine.dataapi.ProtoDataStore;
import engine.dataapi.ProtoDataStream;
import engine.userapi.UserDataStream;

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
	public void receiveDataStoreRequest(ProtoDataStream newData, String filePath) throws IOException{
		data.append(newData);
		
	}
	
	/**
	 * Spits out the list of data
	 * @return
	 */
	public DataStream receiveData() {
		return data;
	}

	/**
	 * Irrelevant for the integration test
	 */
	@Override
	public void receiveUserOutRequest(String filePath, char delim) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Irrelevant for the integration test
	 */
	@Override
	public UserDataStream readInputData(String filePath, char delim, String filePathOut) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Spits out the data as a string
	 */
	public String toString() {
		String retStr= "";
		for(String listElement : data.getData()) {
			retStr = retStr + listElement +"\n";
		}
		return retStr;
	}



}
