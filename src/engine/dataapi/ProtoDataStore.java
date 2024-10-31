package engine.dataapi;

import java.io.File;
import java.io.IOException;
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
	 * Spits out the list of data
	 * @return
	 */
	public void receiveUserOutRequest(String filePath, char delim);
	
	/**
	 * Reads the input file
	 */
	public UserDataStream readInputData(String filePath, char delim, String filePathOut);

	/**
	 * Actually receives an individual data storage request
	 */
	void receiveDataStoreRequest(ProtoDataStream newData, String filePath, char delim) throws IOException;


}


