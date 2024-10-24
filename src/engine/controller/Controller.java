package engine.controller;


//import engine.computeapi.ComputeEngine;
import engine.computeapi.ProtoComputeEngineDataStream;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import engine.computeapi.ComputeEngine;
import engine.computeapi.ComputeEngineDataStream;
import engine.userapi.User;
import engine.userapi.ProtoUser;
import engine.userapi.ProtoUserDataStream;
import engine.dataapi.ProtoDataStream;
import engine.dataapi.DataStore;
import engine.dataapi.DataStream;
import engine.dataapi.ProtoDataStore;

/**
 * The controller which acts as the nexus of all of our APIs
 */
public class Controller implements ProtoController{
	
	/**
	 * Data storage constructor takes in a data storage device
	 * @param ds
	 */
	public Controller(ProtoDataStore ds) {
		this.dataStorage = ds;
	}

	/**
	 * Data storage device
	 */
	private ProtoDataStore dataStorage;
	
	 
	 /**
	  * Return the data store
	  * @return
	  */
	public ProtoDataStore getDataStore() {
		return this.dataStorage;
	}
	
    /**
     * Component that receives user requests.
     */
    @Override
    public ProtoUserDataStream receiveUserRequest(ProtoUserDataStream data) {
    	
    	// conversion logic from UserDataStream to ComputeEngineData Stream
    	// don't pass the value 10, pass the value actually want
    	// also need logic to split this into many many requests
    	
    	final int MAX_THREADS = 50;
    	
    	if (data == null || data.getInput().size() < 1) {
    	    throw new IllegalArgumentException("Input data can't be null");
    	}
    	
    	Iterator<Integer> dataIt = data.getInput().iterator();
    	ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREADS);
    
		
		List<Future<?>> futures = new ArrayList<>();
    	
    	while(dataIt.hasNext()) {
    		int nextData = dataIt.next();
    		Callable<ProtoComputeEngineDataStream> dataOutput = () -> {
        		ProtoComputeEngineDataStream individualStream = new ComputeEngineDataStream(nextData);
    			return sendComputeRequest(individualStream);
    		};
    		futures.add(threadPool.submit(dataOutput));
    	}
    	

    	
    	futures.forEach(future -> {
    		try {
    			List<String> dataConv = new ArrayList<String>();
    			Float currentArea = ((ProtoComputeEngineDataStream) future.get()).getArea();
    	        try {
    	        	String dataConvAdd = currentArea.toString();
    	        	dataConv.add(dataConvAdd);
    	        } catch (Throwable t) {
    	        	System.out.println("Floating point data unable to convert to string for storage.");
    	        	t.printStackTrace();
    	        }
    	        ProtoDataStream toStore = new DataStream(dataConv);
    	        dataStorage.receiveDataStoreRequest(toStore, data.getFilePath());
    		} catch (Throwable t) {
    			t.printStackTrace();
    		}
    	});
    	
    	
    	try {
	    	dataStorage.receiveUserOutRequest(data.getFilePath(), data.getDelimiter());
    	} catch (Throwable t) {
    		t.printStackTrace();
    		return null;
    	}
    	
    	return data;
        
    }

    /**
     * Component that sends a request to the Compute engine.
     */
    @Override
    public ProtoComputeEngineDataStream sendComputeRequest(ProtoComputeEngineDataStream data) {	
    	try {
	    	// all we have to do is use the user engine instead
	    	if (data.getRectangles() <= 0) {
	    		throw new IllegalArgumentException("Number of rectangles should be greater than or equal to 0.");
	    	}
	    	ComputeEngine computeEngine = new ComputeEngine();
	    	return computeEngine.receiveComputeRequest(data);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		return null;
    	}
    }

    /**
     * Component that sends request to the Data Storage component.
     */
    @Override
    public void sendDataStoreRequest(ProtoDataStream data) {
    	try {
	    	if (data.getData().size() != 1) {
	    		throw new IllegalArgumentException("Data specified to pass to data store is not a length==1 arraylist of strings.");
	    	}
    	} catch (Throwable t) {
    		t.printStackTrace();
    	}
    }

}
