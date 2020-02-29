/**
 * 
 * @author Alec Felix CMSC 204 Prof. Thai Project 2: Office Retail
 *         VolunteerLine.java
 *
 */
public class VolunteerLine implements VolunteerLineInterface {
	private MyQueue<Volunteer> line;

	/**
	 * Default constructor. Creates queue using MyQueue default Size.
	 */
	public VolunteerLine() {
		line = new MyQueue<Volunteer>();
	}// default constructor

	/**
	 * Creates queue using given size.
	 * 
	 * @param size
	 */
	public VolunteerLine(int size) {
		line = new MyQueue<Volunteer>(size);
	}// constructor

	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * 
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Queue is full") is queue is full
	 */
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {
		if (!line.enqueue(v))
			throw new VolunteerException("Volunteer Queue is full");

		return true;
	}// addNewVolunteer

	/**
	 * removes volunteer from the volunteer queue line
	 * 
	 * @return Volunteer Object
	 * @throws VolunteerException("Volunteer queue is empty") if queue is empty
	 */
	public Volunteer volunteerTurn() throws VolunteerException {
		if (line.isEmpty())
			throw new VolunteerException("Volunteer Queue is empty");

		return line.dequeue();
	}// volunteerTurn

	/**
	 * checks if there are volunteers in line
	 * 
	 * @return true if volunteer line is empty, true otherwise
	 */
	public boolean volunteerLineEmpty() {
		return line.isEmpty();
	}// volunteerLineEmpty

	/**
	 * Returns an array of the Volunteers in the queue. Because of type erasure by
	 * the JVM at run-time, the array of type T that the generic queue returns from
	 * the call to queue.toArray() is an array of type Object, i.e., Object[] temp.
	 * But since the individual elements of the array are still Volunteers, we can
	 * copy them one by one into a new array of type Volunteer and cast each one to
	 * Volunteer. So create a new array of Volunteers of the same length as temp,
	 * run a for-loop that casts each element of temp to Volunteer and copies it to
	 * the corresponding position in the new array. Then return the new array.
	 * 
	 * @return an array of the Volunteers in the queue
	 */
	public Volunteer[] toArrayVolunteer() {
		Object[] tmp = line.toArray();
		Volunteer[] volunteers = new Volunteer[line.size()];

		for (int i = 0; i < tmp.length; i++) {
			volunteers[i] = (Volunteer) tmp[i];
		}

		return volunteers;
	}// Volunteer

}// VolunteerLine
