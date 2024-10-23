package engine.dataapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import engine.userapi.UserDataInput;
import engine.userapi.UserDataStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Receiving end of the data storage API.
 */
public class DataStore implements ProtoDataStore {
	
	
	/**
	 * Holds the data
	 */
	private DataStream data;
	
	/**
	 * Constructor method
	 */
	public DataStore() {
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
	 * writes to an output file
	 * @return
	 */
	public void receiveUserOutRequest(String filePath, char delim) {
		if (data.getData().size() <= 0 || data == null) {
			throw new IllegalStateException("No data to return");
		}
	    try {
	        File myObj = new File(filePath);
	        FileWriter myWriter = new FileWriter(filePath);
	        for (String s : data.getData()) {
		        myWriter.write(s);
	        }
	        myWriter.close();
	        myObj.createNewFile();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    
		return; 
	}
	
	public UserDataStream readInputData(String filePathIn, char delim, String filePathOut) {
		String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePathIn)));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        List<String> inputIntegersAsString = Arrays.asList(content.split(","));
        
        List<Integer> inputIntegers = new ArrayList<>();
        
        for(String s : inputIntegersAsString) {
        	try {
        		inputIntegers.add(Integer.valueOf(s));
        	} catch (Throwable t) {
        		t.printStackTrace();
        	}
        }
        
        UserDataStream data = new UserDataStream(inputIntegers, delim, filePathOut);
        
        return data;
	}


	

    
}
