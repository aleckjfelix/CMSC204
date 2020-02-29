/**
 * 
 * @author Alec Felix
 * CMSC 204 Prof. Thai
 * Project 2: Office Retail
 * DonationManager.java
 *
 */
public class DonationManager implements DonationManageInterface{
	public Container container;
	public VolunteerLine v_line;
	public RecipientLine r_line;
	private DonationPackage last_donated_pckg;
	
	/**
	 * default constructor
	 */
	public DonationManager() {
		container = new Container(5);
		v_line = new VolunteerLine(5);
		r_line = new RecipientLine(5);
	}//default constructor
	
	public DonationManager(int containerSize, int volunteerSize, int recipientSize) {
		container = new Container(containerSize);
		v_line = new VolunteerLine(volunteerSize);
		r_line = new RecipientLine(recipientSize);
	}//constructor
	
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException if container is full
	 */
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		container.loadContainer(dPackage); // throws an Exception
		return true;
	}//managerLoadContainer

	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Line is full") if the Volunteer Line queue is full
	 */
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		v_line.addNewVolunteer(v); // throws Exception
		return true;
	}//managerQueueVolunteer

	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param rc a Recipient
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throws RecipientException("Recipient Line is full") if the Recipient line is full
	 */
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		r_line.addNewRecipient(r); // throws Exception
		return true;
	}//managerQueueRecipient

	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  volunteer line and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @throws VolunteerException("Volunteer Queue is empty") if there are no volunteers
	 * @throws ContainerExcpetion("Contain is empty") if the container is empty
	 * @throws RecipientException("Recipient Queue is empty") if there are no recipients
	 * @return 0 if successful, 1 if VolunteerException, 2 if
	 */
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		if(v_line.volunteerLineEmpty())
			throw new VolunteerException("Volunteer Queue is empty");
		else if (r_line.recipientLineEmpty())
			throw new RecipientException("Recipient Queue is empty");
		else if (container.containerEmpty())
			throw new ContainerException("The Container is Empty");
		
		r_line.recipientTurn(); //throws RecipientException
		v_line.volunteerTurn(); //throws VolunteerException
		
		last_donated_pckg = container.removePackageFromContainer(); // throws ContainerException
		
		return (int)last_donated_pckg.getWeight();
			
	}//donatePackage

	/**
	 * Returns an array of DonationPackages
	 * @return an array of Donation Packages
	 */
	public DonationPackage[] managerArrayPackage() {
		return container.toArrayPackage();
	}//managerArrayPackage

	/**
	 * Returns an array of Volunteers
	 * @return an array of Volunteers
	 */
	public Volunteer[] managerArrayVolunteer() {
		return v_line.toArrayVolunteer();
	}//managerArrayVolunteer

	/**
	 * Returns an array of Recipients
	 * @return an array of Recipients
	 */
	public Recipient[] managerArrayRecipient() {
		return r_line.toArrayRecipient();
	}//managerArrayRecipient
	
	/**
	 * @returns string representation of package
	 */
	public String toString() {
		return last_donated_pckg.getDescription();
	}//toString

}//DonationManager
