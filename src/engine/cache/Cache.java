package engine.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Cache {

	private ConcurrentMap<Integer, Float> computeEngineCache;
	
	public Cache() {
		computeEngineCache = new ConcurrentHashMap<>();
	}
	
	public void addToCache(Integer numRects, Float riemannSum) {
		try {
			computeEngineCache.put(numRects, riemannSum);
		} catch (Throwable t) {
			System.out.println("Caching input error.");
			t.printStackTrace();
		}
	}
	
	public Boolean inCache(Integer numRects) {
		return computeEngineCache.containsKey(numRects);
	}
	
	public Float getCorrespondingValue(Integer numRects) {
		return computeEngineCache.get(numRects);
	}
	
}
