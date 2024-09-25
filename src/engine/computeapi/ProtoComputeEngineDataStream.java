package engine.computeapi;

/**
 * Data stream passed around via the Controller and Compute Engine
 */
public interface ProtoComputeEngineDataStream {
	
	/**
	 * Grabs the number of desired rectangles to compute
	 */
	public Integer getRectangles();
	
	/**
	 * Grabs the computed area
	 */
	public float getArea();
	
	/**
	 * Sets the area (defaults to 0
	 */
	public void setArea(float newArea);
}
