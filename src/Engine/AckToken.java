package engine;

/**
 * Acknowledgement tokens that get passed around.
 */
public enum AckToken {
    SUCCESS(1, true),
    FAILURE(2, false),
    INVALID_INPUT(3, false),
    INVALID_OUTPUT_SOURCE(4, false),
    INVALID_DELIMITER(5, false);
	
	private final int id;
	private final boolean success;
	
	/**
	 * 
	 * @param Token ID.
	 * @param Boolean for success.
	 */
	private AckToken(int id, boolean success) {
		this.id = id;
		this.success = success;
	}
	
	/**
	 * 
	 * @return The ID of the AckToken.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @return A boolean.
	 */
	public boolean success() {
		return success;
	}
	
}