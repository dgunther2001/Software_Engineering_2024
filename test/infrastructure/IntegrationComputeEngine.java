package infrastructure;

import engine.computeapi.ProtoCompute;
import engine.computeapi.ProtoComputeEngineDataStream;
public class IntegrationComputeEngine implements ProtoCompute{

	/**
	 * take in single int
	 * return the same int for test purposes
	 * 
	 * Do I have to make a integration EngineDataStream?
	 */
	@Override
	public ProtoComputeEngineDataStream receiveComputeRequest(ProtoComputeEngineDataStream data) {
		
		data.setArea((float)data.getRectangles());
		return data;
	
	}

}
