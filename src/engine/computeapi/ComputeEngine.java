package engine.computeapi;

/**
 * The API that receives a request to the compute engine
 */
public class ComputeEngine implements ProtoCompute {

    /**
     * Receives a compute request from the controller
     */
    @Override
    public ProtoComputeEngineDataStream receiveComputeRequest(ProtoComputeEngineDataStream data) {
        // function = x^2
    	// domain = 0 to 1
    	if (data.getRectangles() <= 0) {
    		throw new IllegalArgumentException("Num args have to be > 0");
    	}
    	
    	float rectWidth = 1 / data.getRectangles(); // width of rectangles based on domain and quantity
    	float currentXVal = 0; // current x value on the domain
    	double outputArea = 0; // the current cumulative area
    	
    	// iterate over the number of rectangles
    	for (int i = 0; i < data.getRectangles(); i++) {
    		outputArea = outputArea + rectWidth * Math.pow((double)currentXVal,(double)2); // add the new rectangle's area to the cumulative value
    		currentXVal += rectWidth; // increment the x value based on the rectangle width
    	}
    	
    	data.setArea((float)outputArea); // cast the area in the datastream to a float
    	return data; // return the data stream back
    		
    }

}
