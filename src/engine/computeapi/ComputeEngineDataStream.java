package engine.computeapi;

/**
 * The data stream passed between the controller and the compute engine.
 */
public class ComputeEngineDataStream implements ProtoComputeEngineDataStream{
	private Integer numRectangles;
	private float area;
	
	/**
	 * Pass in a number of rectangles, and initialize area to 0
	 * @param numRect
	 */
	public ComputeEngineDataStream(Integer numRect) {
		area = 0;
		numRectangles = numRect;
	}
	
	public Integer getRectangles() {
		return this.numRectangles;
	}
	
	public float getArea() {
		return this.area;
	}
	
	public void setArea(float newArea) {
		area = newArea;
	}
	
}
