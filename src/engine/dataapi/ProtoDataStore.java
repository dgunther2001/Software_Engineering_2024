package engine.dataapi;

import java.io.File;
import java.util.List;
import java.util.UUID;

import engine.userapi.UserDataInput;
import engine.userapi.UserDataStream;

import java.util.ArrayList;

/**
 * Prototype interface for the data storage API.
 */
public interface ProtoDataStore {
	
	/**
	 * Request to store data
	 * @param data
	 * @return
	 */
	public void receiveDataStoreRequest(ProtoDataStream data);
	
	/**
	 * Spits out the list of data
	 * @return
	 */
	public void receiveUserOutRequest(String filePath, char delim);
	
	/**
	 * Reads the input file
	 */
	public UserDataStream readInputData(String filePath, char delim, String filePathOut);
}


