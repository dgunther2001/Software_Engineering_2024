package performancetest;

import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.Test;

import engine.userapi.UserDataStream;

/**
 * Performance test for the compute engine.
 */
public class PerformanceTest {
	
	/**
	 * Timing test for the compute engine
	 */
	public static void main(String[] args) {
		final Integer NUM_ITERATIONS = 10;
		
		PerformanceController testController = new PerformanceController();
		List<Integer> testData = new ArrayList<>();
		
		for (int i = 1; i <= 1000000; i++) {
			testData.add(i);
			testData.add(i);
		}
		
		char delim = '\n';
		String file = "arbitrary.txt";
		
		UserDataStream testUserData = new UserDataStream(testData, delim, file);
		
		
		long cumulativeTime = 0;
		float averageTime;
    	long startTime;
    	long endTime;
    	long timeElapsed;
		
		for (int i = 0; i < NUM_ITERATIONS; i++) {
			
			startTime = System.currentTimeMillis();
			
			testController.receiveUserRequest(testUserData);
			
	    	endTime = System.currentTimeMillis();
	    	
	    	timeElapsed = endTime - startTime;
			cumulativeTime += timeElapsed;
		}
		
		averageTime = cumulativeTime / NUM_ITERATIONS;
		
		System.out.println("Average time of compute execution for given test case over " + NUM_ITERATIONS + " iterations is " + averageTime + " milliseconds.");
	
	}
	
}