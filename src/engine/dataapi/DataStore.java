package engine.dataapi;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Receiving end of the data storage API.
 */
public class DataStore implements ProtoDataStore {
	private DataStream data;
	
	/**
	 * Constructor to be able to save values
	 */
	public DataStore(int d) {
		data = new DataStream(new ArrayList<String>());	
	}
	
    /**
     * Receives a data request for output and processes it.
     * we're gonna pass an id as well that we'll make in the controller to have a reference to our obj in the db
     * @param newData is the data to be appended and/or stored
     * @param id is the id of the object/list
     * @param file is the user-specified file
     */
    @Override
    public DataStream receiveDataRequest(DataStream newData, String id, File file) {
        // search db or file for id
    	// if no make new db entry for current list and add value
    	// if yes append data to existing entry
    	// return db entry
    	
    	
    	DataStream fileObject = null;
    	try {
    		//for reading a file's object
    		FileInputStream fileIn = new FileInputStream(file);
        	ObjectInputStream objIn = new ObjectInputStream(fileIn);
        	
        	//for writing an object to a file 
        	FileOutputStream fileOut = new FileOutputStream(file);
        	ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        	
    		 while(true) {//check file for existing entry
    			 try {
    				 fileObject = (DataStream) objIn.readObject();
    				 if(fileObject.getId() == id) {
    					  break;
    				 }
    			 }
    			 catch (IOException | ClassNotFoundException e) {
    				 break;
    			 }
    		 }
    		 if(fileObject == null) {//if list wasn't started make a new one 
    			 fileObject = newData;
    			 objOut.writeObject(fileObject);
    			 return fileObject;
    		 }
    		 else {//if a list was started add to it
    			 fileObject.append(newData);
    			 objOut.writeObject(fileObject);
    			 return fileObject;
    		 }
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	return fileObject;//return uninitialized object as a last resort
    }
    
    

    
}
