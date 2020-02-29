/**
 * 
 * @author Alec Felix CMSC 204 Prof. Thai Project 2: Office Retail
 *         DonationPackage.java Represents a Package being donated.
 */
public class DonationPackage {
	private String description;
	private double weight;

	public DonationPackage(String d, double w) {
		description = d;
		weight = w;
	}

	/**
	 * Returns String description of package
	 * 
	 * @return description of package
	 */
	public String getDescription() {
		return description;
	}// getDescription

	/**
	 * set the description for this package.
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}// setDescription

	/**
	 * Return weight of package as double
	 * 
	 * @return weight
	 */
	public double getWeight() {
		return weight;
	}// getWeight

	/**
	 * Sets the weight of this package as a double
	 * 
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}// setWeight

	/**
	 * Package is heavy if grater than or equal to 20lbs
	 * @return true if package is heavy
	 */
	public boolean isHeavy() {
		return weight >= 20;
	}//isHeavy
	
	/**
	 * 
	 */
	public String toString() {
		return description;
	}//toString

}// DonationPackage
