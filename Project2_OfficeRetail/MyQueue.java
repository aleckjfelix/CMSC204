import java.util.LinkedList;

/**
 * 
 * @author Alec Felix 
 * CMSC 204 Prof. Thai 
 * Project 2: Office Retail MyQueue.java
 * MyQueue.java
 * ADT Queue Collection.
 * @param <T> data type
 *
 */
public class MyQueue<T> implements QueueInterface<T> {

	private static final int DEFAULT_SIZE = 100;
	private int maxSize;
	private LinkedList<T> data;

	/**
	 * Constructor. Create Queue with given size
	 * 
	 * @param size
	 */
	public MyQueue(int size) {
		maxSize = size;
		data = new LinkedList<T>();
	}// constructor

	/**
	 * Default constructor. Creates Queue with DEFAULT_SIZE (100)
	 */
	public MyQueue() {
		maxSize = DEFAULT_SIZE;
		data = new LinkedList<T>();
	}// constructor

	/**
	 * Determines if the Queue is empty
	 * 
	 * @return true if MyQueue contains no data.
	 */
	public boolean isEmpty() {
		return data.isEmpty();
	}// isEmpty

	/**
	 * Determines if the Queue is full
	 * 
	 * @return true if MyQueue is full
	 */
	public boolean isFull() {

		return data.size() == maxSize;
	}// isFull

	/**
	 * Deletes and returns the element at the front of the Queue
	 * 
	 * @return
	 * @return the element at the front of the Queue
	 */
	public T dequeue() {
		return data.removeFirst();
	}// dequeue

	/**
	 * Number of elements in the Queue
	 * 
	 * @return the number of elements in the Queue
	 */
	public int size() {

		return data.size();
	}// size

	/**
	 * Adds an element to the end of the Queue
	 * 
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	public boolean enqueue(T e) {
		if (isFull())
			return false;
		data.add(e);

		return true;
	}// enqueue

	/**
	 * Returns the elements of the Queue in an array, [0] is front of Queue, [1] is
	 * next in Queue, etc.
	 * 
	 * @return an array of the Object elements in the Queue
	 */
	public T[] toArray() {
		return (T[]) data.toArray();
	}// dequeue
	/*
	 * public static void main(String [] args) { MyQueue<Integer> q = new
	 * MyQueue<Integer>(10);
	 * 
	 * System.out.println(q.isEmpty()); q.enqueue(1); q.enqueue(2);
	 * System.out.println(q.isEmpty()); System.out.println(q.isFull());
	 * System.out.println(q.dequeue()); q.enqueue(1); q.enqueue(4); q.enqueue(5);
	 * q.enqueue(6); q.enqueue(7); q.enqueue(8); q.enqueue(9); q.enqueue(10);
	 * System.out.println(q.enqueue(11)); System.out.println(q.enqueue(12));
	 * Object[] arr = q.toArray(); for(int i = 0; i < arr.length;i++) {
	 * System.out.println((Integer)arr[i]); }
	 * 
	 * 
	 * }//main
	 */
}// MyQueue
