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
	
	private AckToken(int id, boolean success) {
		this.id = id;
		this.success = success;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean success() {
		return success;
	}
	
}