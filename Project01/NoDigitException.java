/**
 * 
 * @author Alec Felix CMSC 204 Professor Thai
 * 
 *         NoDigitException.java
 * 
 *         Represents NoDigit Exception thrown if no digit in password
 *
 */
public class NoDigitException extends Exception {

	/**
	 * Default constructor
	 */
	public NoDigitException() {
		super("The password must contain at least one digit");
	}// default constructor

	/**
	 * 
	 * @param message errormessage
	 */
	public NoDigitException(String message) {
		super(message);
	}// constructor

}// NoDigitException
