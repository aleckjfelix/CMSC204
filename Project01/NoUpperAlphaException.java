/**
 * 
 * @author Alec Felix CMSC 204 Professor Thai
 * 
 *         NoUpperAlphaException.java
 *
 *         Represents NoUpperAlpha Exception thrown if no uppercase alphabetic
 *         character in password
 */
public class NoUpperAlphaException extends Exception {

	/**
	 * Default constructor
	 */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");

	}// default constructor

	/**
	 * 
	 * @param message errormessage
	 */
	public NoUpperAlphaException(String message) {
		super(message);
	}// constructor

}// NoUpperAlphaException
