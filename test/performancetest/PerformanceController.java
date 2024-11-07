package performancetest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import engine.computeapi.ComputeEngine;
import engine.computeapi.ComputeEngineDataStream;
import engine.computeapi.ProtoComputeEngineDataStream;
import engine.controller.ProtoController;
import engine.dataapi.DataStream;
import engine.dataapi.ProtoDataStore;
import engine.dataapi.ProtoDataStream;
import engine.userapi.ProtoUserDataStream;

public class PerformanceController implements ProtoController {

	/**
	 * Unneeded 
	 */
	@Override
	public ProtoDataStore getDataStore() {
		return null;
	}

	/**
	 * Unneeded 
	 */
	@Override
	public void sendDataStoreRequest(ProtoDataStream data) {
		return;	
	}
	

	@Override
	public ProtoUserDataStream receiveUserRequest(ProtoUserDataStream data) {
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
    	
    	
    	return data;
	}

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


}