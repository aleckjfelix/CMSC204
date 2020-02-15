/**
 * 
 * @author Alec Felix CMSC 204 Professor Thai
 * 
 *         NoLowerAlphaException.java
 * 
 *         Represents NoLowerAlpha Exception thrown if no lowercase alphabetic
 *         in password
 *
 */
public class NoLowerAlphaException extends Exception {
	/**
	 * Default constructor
	 */
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}// default constructor

	/**
	 * 
	 * @param message errormessage
	 */
	public NoLowerAlphaException(String message) {
		super(message);
	}// constructor
	
}// NoLowerAlphaException
