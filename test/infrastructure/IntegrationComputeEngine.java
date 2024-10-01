package infrastructure;

import engine.computeapi.ProtoCompute;
import engine.computeapi.ProtoComputeEngineDataStream;
public class IntegrationComputeEngine implements ProtoCompute{

	/**
	 * take in single int
	 * 
	 * Do I have to make a integration EngineDataStream?
	 */
	@Override
	public ProtoComputeEngineDataStream receiveComputeRequest(ProtoComputeEngineDataStream data) {
		
		return null;
	}

}
