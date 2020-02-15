/**
 * 
 * @author Alec Felix CMSC 204 Professor Thai
 * 
 *         InvalidSequenceException.java
 *
 *         Represents InvalidSequence Exception thrown if more than 2 of same
 *         character in password
 */
public class InvalidSequenceException extends Exception {
	
	/**
	 * Default constructor
	 */
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}// default constructor

	/**
	 * 
	 * @param errorMessage errormessage
	 */
	public InvalidSequenceException(String errorMessage) {
		super(errorMessage);
	}// constructor
	
}// InvalidSequenceException
