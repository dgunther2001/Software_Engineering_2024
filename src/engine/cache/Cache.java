package engine.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Cache for compute engine values
 */
public class Cache {

	/**
	 * The actual cache itself.
	 */
	private ConcurrentMap<Integer, Float> computeEngineCache;
	
	/**
	 * Cache constructor.
	 */
	public Cache() {
		computeEngineCache = new ConcurrentHashMap<>();
	}
	
	/**
	 * Add values to the cache.
	 * @param numRects
	 * @param riemannSum
	 */
	public void addToCache(Integer numRects, Float riemannSum) {
		try {
			computeEngineCache.put(numRects, riemannSum);
		} catch (Throwable t) {
			System.out.println("Caching input error.");
			t.printStackTrace();
		}
	}
	
	/**
	 * Check if a value is in the cache.
	 * @param numRects
	 * @return
	 */
	public Boolean inCache(Integer numRects) {
		return computeEngineCache.containsKey(numRects);
	}
	
	/**
	 * Grab a value from the cache.
	 * @param numRects
	 * @return
	 */
	public Float getCorrespondingValue(Integer numRects) {
		return computeEngineCache.get(numRects);
	}
	
}
