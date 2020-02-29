/**
 * 
 * @author Alec Felix CMSC 204 Prof. Thai Project 2: Office Retail
 *         VolunteerException.java
 *
 */
public class VolunteerException extends Exception {

	/**
	 * Default constructor message: "Volunteer Exception."
	 */
	public VolunteerException() {
		super("Volunteer Exception.");
	}// default constructor

	/**
	 * Constructor with custom message
	 * 
	 * @param message
	 */
	public VolunteerException(String message) {
		super(message);
	}// constructor

}// VolunteerException
