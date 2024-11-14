package performancetest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import engine.cache.Cache;
import engine.computeapi.ComputeEngine;
import engine.computeapi.ComputeEngineDataStream;
import engine.computeapi.ProtoComputeEngineDataStream;
import engine.controller.ProtoController;
import engine.dataapi.DataStream;
import engine.dataapi.ProtoDataStore;
import engine.dataapi.ProtoDataStream;
import engine.userapi.ProtoUserDataStream;

/**
 * Performance controller for the performance test
 */
public class PerformanceControllerDefault implements ProtoController {

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
	
	
	/**
	 * Simplified without data storage component. Simply exists to overclock my CPU.
	 */
	@Override
	public ProtoUserDataStream receiveUserRequest(ProtoUserDataStream data) {
		
		
    	final int MAX_THREADS = 14;
    	
    	if (data == null || data.getInput().size() < 1) {
    	    throw new IllegalArgumentException("Input data can't be null");
    	}
    	
    	Iterator<Integer> dataIt = data.getInput().iterator();
    	ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREADS, new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread myThread = new Thread(r);
				myThread.setDaemon(true);
				return myThread;
			}
    		
    	});
    
		
		List<Future<?>> futures = new ArrayList<>();
		//int counter = 0;
		
    	while(dataIt.hasNext()) {
    		int nextData = dataIt.next();
    		Callable<ProtoComputeEngineDataStream> dataOutput = () -> {
        		ProtoComputeEngineDataStream individualStream = new ComputeEngineDataStream(nextData);
        		return sendComputeRequest(individualStream);
    		};
    		
    		/*
    		if (counter == 5000000) {
    			//System.out.println("Running gc");
    			System.gc(); 
    			counter = 0;
    		} else {
    			counter++;
    		}
    		
    		*/
    		futures.add(threadPool.submit(dataOutput));
    	}
    	
    	
    	return data;
	}

	/**
	 * Identical to the controller.
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


}