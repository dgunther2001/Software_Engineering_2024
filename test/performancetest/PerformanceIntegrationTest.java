package performancetest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import engine.userapi.UserDataStream;

/**
 * Integration test that checks performance
 */
public class PerformanceIntegrationTest {

		/**
		 * Default performance test
		 * @return
		 */
	public Float defaultRuntime() {
		final Integer NUM_ITERATIONS = 5;
		final Integer BATCH_SIZE = 1000000;
		
		long cumulativeTime = 0;
		float averageTime;
    	long startTime;
    	long endTime;
    	long timeElapsed;
    	
		char delim = '\n';
		String file = "arbitrary.txt";
		
		PerformanceControllerDefault testController = new PerformanceControllerDefault();
		
		// somehow batch data into bitesized lists of 1,000,000 (BATCH_SIZE) elements
		// have a counter that is less than batchsize and store the current v
		
		for (int numIter = 0; numIter < NUM_ITERATIONS; numIter++) {
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
		
		return averageTime;
	}
	
	/**
	 * Optimized performance test
	 * @return
	 */
	public Float optimizedRuntime() {
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
		
		for (int numIter = 0; numIter < NUM_ITERATIONS; numIter++) {
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
		
		return averageTime;
	}
	
	
	/**
	 * Checks the difference in default vs optimized time
	 */
	@Test
	public void pIntegrationTest() {
		Float defaultTime = defaultRuntime();
		Float optimizedTime = optimizedRuntime();
		
		Float timingDifference = defaultTime - optimizedTime;
		
		Float percentImprovement = ((defaultTime - optimizedTime) / defaultTime) * 100;
		
		assert(percentImprovement >= 10);
	}
}
