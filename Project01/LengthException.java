/**
 * 
 * @author Alec Felix CMSC 204 Professor Thai
 * 
 *         LengthException.java
 * 
 *         Represents Length Exception thrown if length is less than 6
 *         characters in password
 *
 */
public class LengthException extends Exception {

	/**
	 * Default constructor
	 */
	public LengthException() {
		super("The password must be at least 6 characters long");
	}// default constructor

	/**
	 * 
	 * @param message errormessage
	 */
	public LengthException(String message) {
		super(message);
	}// constructor

}// LengthException
