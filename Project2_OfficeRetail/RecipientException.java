/**
 * @author Alec Felix CMSC 204 Prof. Thai Project 2: Office Retail
 *         RecipientException.java
 *
 */
public class RecipientException extends Exception {

	/**
	 * Default constructor message: "Recipient Exception."
	 */
	public RecipientException() {
		super("Recipient Exception.");
	}// default constructor

	/**
	 * Constructor with custom message
	 * 
	 * @param message
	 */
	public RecipientException(String message) {
		super(message);
	}// constructor
	
}// RecipientException
