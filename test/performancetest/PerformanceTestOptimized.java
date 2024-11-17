package performancetest;

import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.Test;

import engine.userapi.UserDataStream;

/**
 * Performance test for the compute engine.
 */
public class PerformanceTestOptimized {
	
	/**
	 * Timing test for the compute engine
	 */
	public static void main(String[] args) {
		final Integer NUM_ITERATIONS = 5;
		final Integer BATCH_SIZE = 1000000;
		
		long cumulativeTime = 0;
		float averageTime;
    	long startTime;
    	long endTime;
    	long timeElapsed;
    	
		char delim = '\n';
		String file = "arbitrary.txt";
		
		PerformanceControllerOptimized testController = new PerformanceControllerOptimized();
		
		// somehow batch data into bitesized lists of 1,000,000 (BATCH_SIZE) elements
		// have a counter that is less than batchsize and store the current v
		
		for (int num_iter = 0; num_iter < NUM_ITERATIONS; num_iter++) {
			for (int start = 0; start < 100; start++){
				
				startTime = System.currentTimeMillis();
			
				List<Integer> testData = new ArrayList<>();
				
				for (int i = 0; i < 10000; i++) {
					for (int j = 1; j <= 100; j++) {
						testData.add(j);
					}
				}
				
				UserDataStream testUserData = new UserDataStream(testData, delim, file);
				
				testController.receiveUserRequest(testUserData);
				
		    	endTime = System.currentTimeMillis();
		    	
		    	timeElapsed = endTime - startTime;
				cumulativeTime += timeElapsed;
				
				System.gc();
			
			}
		}
		
		
		averageTime = cumulativeTime / NUM_ITERATIONS;
		
		System.out.println("(Optimized) Average time of compute execution for given test case over " + NUM_ITERATIONS + " iterations is " + averageTime + " milliseconds.");
	
	}
	
}