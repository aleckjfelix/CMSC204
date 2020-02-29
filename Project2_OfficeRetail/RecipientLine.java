/**
 * 
 * @author Alec Felix CMSC 204 Prof. Thai Project 2: Office Retail
 * 
 *
 */
public class RecipientLine implements RecipientLineInterface {
	private MyQueue<Recipient> line;

	/**
	 * Default constructor. Creates queue using MyQueue default Size.
	 */
	public RecipientLine() {
		line = new MyQueue<Recipient>();
	}// default constructor

	/**
	 * Creates queue using given size.
	 * 
	 * @param size
	 */
	public RecipientLine(int size) {
		line = new MyQueue<Recipient>(size);
	}// constructor

	/**
	 * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
	 * 
	 * @param rc a Recipient return true if recipient is queued successfully
	 * @throws RecipientException("The Recipent Queue is Full") if queue is full
	 */
	public boolean addNewRecipient(Recipient rc) throws RecipientException {
		if (!line.enqueue(rc))
			throw new RecipientException("Recipient Queue is full");

		return true;
	}// addNewRecipient

	/**
	 * When it is the recipient turn, recipient will be dequeued from the recipient
	 * line
	 * 
	 * @return a Recipient object
	 * @throws RecipientException("The Recipient Queue is empty") if there is no
	 *                                 Recipient in the line
	 */
	public Recipient recipientTurn() throws RecipientException {
		if (line.isEmpty())
			throw new RecipientException("Recipient Queue is empty");

		return line.dequeue();
	}// recipientTurn

	/**
	 * check if Recipient queue line is empty
	 * 
	 * @return true if queue is empty, false otherwise
	 */
	public boolean recipientLineEmpty() {
		return line.isEmpty();
	}// recipientLineEmpty

	/**
	 * Returns an array of the Recipients in the queue. Because of type erasure by
	 * the JVM at run-time, the array of type T that the generic queue returns from
	 * the call to queue.toArray() is an array of type Object, i.e., Object[] temp.
	 * But since the individual elements of the array are still Recipients, we can
	 * copy them one by one into a new array of type Recipient and cast each one to
	 * Recipient. So create a new array of Recipients of the same length as temp,
	 * run a for-loop that casts each element of temp to Recipient and copies it to
	 * the corresponding position in the new array. Then return the new array.
	 * 
	 * @return an array of the Recipients in the queue
	 */
	public Recipient[] toArrayRecipient() {
		Object[] tmp = line.toArray();
		Recipient[] recipients = new Recipient[line.size()];

		for (int i = 0; i < tmp.length; i++) {
			recipients[i] = (Recipient) tmp[i];
		}

		return recipients;
	}// toArrayRecipient

}//RecipientLine
