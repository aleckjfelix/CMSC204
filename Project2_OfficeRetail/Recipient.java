/**
 * 
 * @author Alec Felix 
 * CMSC 204 Prof. Thai 
 * Project 2: Office Retail
 * Recipient.java
 * 
 *
 */
public class Recipient {
	private String name;

	/**
	 * Creates Volunteer with given name
	 * 
	 * @param name of volunteer
	 */
	public Recipient(String name) {
		this.name = name;
	}// constructor

	/**
	 * Gives the name of this Volunteer
	 * 
	 * @return name of volunteer.
	 */
	public String getName() {
		return name;
	}// getName

	/**
	 * Sets the name of Volunteer.
	 * 
	 * @param name of Volunteer.
	 *
	 */
	public void setName(String name) {
		this.name = name;
	}// setName

	/**
	 * toString method
	 */
	public String toString() {
		return name;
	}// toString
}
