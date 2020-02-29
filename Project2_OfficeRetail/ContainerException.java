/**
 * 
 * @author Alec Felix CMSC 204 Prof. Thai Project 2 Office Retail
 *         ContainerException.java
 *
 */
public class ContainerException extends Exception {

	/**
	 * Default constructor message: "Container Exception."
	 */
	public ContainerException() {
		super("Container Exception.");
	}// default constructor

	/**
	 * Constructor with custom message
	 * 
	 * @param message
	 */
	public ContainerException(String message) {
		super(message);
	}// constructor
	
}// ContainerException
