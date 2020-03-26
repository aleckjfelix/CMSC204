import java.util.Comparator;

/**
 * 
 * @author Alec Felix CMSC 204 Prof. Thai Project03 Doubly Linked List
 *         SortedDoubleLinkedList.java
 * 
 *         Generic double single-linked list
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	private Comparator<T> comparator;

	/**
	 * Creates an empty list that is associated with the specified comparator.
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}// constructor
	
	/**
	 * Add in order using comparator
	 * @param data
	 * @return
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		Node<T> currentRef = head;
		Node<T> temp;
		int compVal = 0;

		if (size == 0) {
			head = new Node<T>(data);
			tail = head;
			size++;
			return this;
		} else {
			while (currentRef != null) {
				compVal = comparator.compare(data, currentRef.data);

				if (compVal == 0 || compVal < 0) {
					if (head == currentRef) {
						temp = head;
						head = new Node<T>(data);
						head.next = temp;
						temp.prev = head;
						/*
						System.out.println("1");
						newNode.next = head;
						head.prev = newNode;
						head = newNode;
						*/
						size++;
						return this;
					} else {
						temp = new Node<T>(data);
						temp.next = currentRef;
						temp.prev = currentRef.prev;
						currentRef.prev = temp;
						temp.prev.next = temp;
						
						/*
						currentRef.prev.next = newNode;
						newNode.next = currentRef;
						newNode.prev = currentRef.prev;
						currentRef.prev = newNode;
						*/
						size++;
						return this;
					}
				}
				currentRef = currentRef.next;
			} // loop
			System.out.println("3");
			// passed the tail
			temp = tail;
			tail = new Node<T>(data);
			temp.next = tail;
			tail.prev = temp;
			size++;
		}

		return this;
	}// add

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param data
	 * @return
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");

	}// addToEnd

	/**
	 * Adds an element to the front of the list.
	 * 
	 * @param data
	 * @return
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");

	}// addToEnd

	/**
	 * Removes the first instance of the targetData from the list.
	 * 
	 * @param targetData
	 * @param comparator
	 * @return
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		return super.remove(targetData, comparator);
	}// remove
}// SortedDoubleLinkedList
