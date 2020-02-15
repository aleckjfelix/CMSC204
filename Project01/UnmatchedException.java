/**
 * 
 * @author Alec Felix CMSC 204 Professor Thai
 * 
 *         UnmatchedException.java
 * 
 *         Represents UnmatchedException Exception thrown if password and
 *         retyped password don't match
 *
 */
public class UnmatchedException extends Exception {
	/**
	 * default constructor
	 */
	public UnmatchedException() {
		super("The passwords do not match");
	}// default constructor

	/**
	 * 
	 * @param errorMessage
	 */
	public UnmatchedException(String errorMessage) {
		super(errorMessage);
	}// constructor
}// UnmatchedException
