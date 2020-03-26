import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Alec Felix CMSC 204 Prof. Thai Project03 Doubly Linked List
 *         BasicDoubleLinkedList.java
 * 
 *         !! TO DO !! Create inner class for ListIterator
 * 
 *         Generic double single-linked list
 * @param <T>
 */
public class BasicDoubleLinkedList<T> {
	protected Node<T> head, tail;
	protected int size;

	/**
	 * Default constructor
	 */
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}// constructor

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param data
	 * @return
	 * @throws UnsupportedOperationException
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		Node<T> oldTail;

		if (size == 0) {
			// add first element to list. Will be head and tail.
			head = new Node<T>(data);
			tail = head;
		} else {
			oldTail = tail;
			tail = new Node<T>(data);
			oldTail.next = tail;
			tail.prev = oldTail;
			// tail.next should be null
		}

		size++;
		return this;

	}// addToEnd

	/**
	 * Adds an element to the front of the list.
	 * 
	 * @param data
	 * @return
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) {
		Node<T> oldHead;

		if (size == 0) {
			// add first element to list. Will be head and tail.
			head = new Node<T>(data);
			tail = head;
		} else {
			oldHead = head;
			head = new Node<T>(data); // create new head with data
			oldHead.prev = head;
			head.next = oldHead; // set new head next to old head.
			// prev is alredy null
		}
		size++;
		return this; // idk what to return

	}// addToEnd

	/**
	 * Returns but does not remove the first element from the list.
	 * 
	 * @return T -- Generic object
	 */
	public T getFirst() {
		if (size == 0)
			return null;

		return head.data;

	}// getFirst

	/**
	 * Returns but does not remove the last element from the list.
	 * 
	 * @return T -- Generic object
	 */
	public T getLast() {
		if (size == 0)
			return null;

		return tail.data;

	}// getLast

	/**
	 * Notice you must not traverse the list to compute the size.
	 * 
	 * @return
	 */
	public int getSize() {
		return size;

	}// getSize

	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {

		class DoublyLinkedListIterator implements ListIterator<T> {
			private Node<T> toRight;
			private Node<T> toLeft;

			public DoublyLinkedListIterator(Node<T> first) {
				toRight = first;
				toLeft = null;
			}

			@Override
			public boolean hasNext() {
				return toRight != null;
			}// hasNext

			@Override
			public boolean hasPrevious() {
				return toLeft != null;
			}// hasPrevious

			@Override
			public T next() throws NoSuchElementException {
				if (hasNext()) {
					toLeft = toRight;
					toRight = toRight.next;
					return toLeft.data;
				}

				throw new NoSuchElementException();
			}// next

			@Override
			public T previous() {
				if (hasPrevious()) {
					toRight = toLeft;
					toLeft = toLeft.prev;
					return toRight.data;
				}
				throw new NoSuchElementException();
			}// previous

			@Override
			public void add(T e) throws UnsupportedOperationException {
				throw new UnsupportedOperationException();
			}// add

			@Override
			public int nextIndex() throws UnsupportedOperationException {
				throw new UnsupportedOperationException();
			}// nextIndex

			@Override
			public int previousIndex() throws UnsupportedOperationException {
				throw new UnsupportedOperationException();
			}// previousIndex

			@Override
			public void remove() throws UnsupportedOperationException {
				throw new UnsupportedOperationException();
			}// remove

			@Override
			public void set(T e) throws UnsupportedOperationException {
				throw new UnsupportedOperationException();
			}// set

		}// inner-class DoublyLinkeListIterator
		return new DoublyLinkedListIterator(head);

	}// iterator

	/**
	 * Removes the first instance of the targetData from the list.
	 * 
	 * @param targetData
	 * @param comparator
	 * @return
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		if (size == 0)
			return this; // should I return null?

		Node<T> currentRef = head;

		// loop through linkedlist
		do {
			//System.out.println(comparator.compare(targetData, currentRef.data) == 0);
			if (comparator.compare(targetData, currentRef.data) == 0) {
				//System.out.println(head + "," + currentRef);
				if (head == currentRef) {
					head = head.next;
				} else if(tail == currentRef) {
					tail = tail.prev;
				}else {
					currentRef.prev.next = currentRef.next; // skip over currentRef (deletes it)
				}
				size--;
				return this;
			} // if find targetData in linkedlist
			currentRef = currentRef.next;
		} while (currentRef != null);

		return this; // nothing found return

	}// remove

	/**
	 * Removes and returns the first element from the list.
	 * 
	 * @return
	 */
	public T retrieveFirstElement() {
		if (size == 0)
			return null;

		T firstElement = head.data;

		if (size == 1) {
			head = null;
			tail = null;
		} else {
			head = head.next;
			head.prev = null;
		}

		size--;
		return firstElement;

	}// retrieveFirstElement

	/**
	 * Removes and returns the last element from the list.
	 * 
	 * @return
	 */
	public T retrieveLastElement() {
		if (size == 0)
			return null;

		T lastElement = tail.data;

		if (size == 1) {
			head = null;
			tail = null;
		} else {
			tail = tail.prev;
			tail.next = null;
		}
		size--;
		return lastElement;

	}// retrieveLastElement

	/**
	 * Returns an arraylist of the items in the list from head of list to tail of
	 * list
	 * 
	 * @return
	 */
	public ArrayList<T> toArrayList() {
		if (size == 0)
			return new ArrayList<T>();// empty list

		ArrayList<T> arrayList = new ArrayList<T>();
		Node<T> currentRefrence = head;

		arrayList.add(currentRefrence.data); // add head

		while (currentRefrence.next != null) {
			currentRefrence = currentRefrence.next;// increment to next in linkedlist
			arrayList.add(currentRefrence.data); // add its data
		} // loop through list
		return arrayList;

	}// toArrayList

	class Node<E> {
		protected Node<E> next, prev;
		protected E data;

		public Node(E data) {
			next = null;
			prev = null;
			this.data = data; // !!!!!! Should this be a deep copy???!!!!!
		}

	}// inner-class Node
}// BasicDoubleLinkedList
