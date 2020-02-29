import java.util.LinkedList;

/**
 * 
 * @author Alec Felix CMSC 204 Prof. Thai Project 2: Office Retail MyStack.java
 *         ADT Stack Collection.
 * @param <T> data type
 *
 */
public class MyStack<T> implements StackInterface<T> {

	private static final int DEFAULT_SIZE = 100;
	private int maxSize;
	private LinkedList<T> data;

	/**
	 * Constructor. Create Stack with given size
	 * 
	 * @param size
	 */
	public MyStack(int size) {
		maxSize = size;
		data = new LinkedList<T>();
	}// constructor

	/**
	 * Default constructor. Creates Stack with DEFAULT_SIZE (100)
	 */
	public MyStack() {
		maxSize = DEFAULT_SIZE;
		data = new LinkedList<T>();
	}// constructor

	/**
	 * Determines if Stack is empty
	 * 
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty() {
		return data.isEmpty();
	}// isEmpty

	/**
	 * Determines if Stack is full
	 * 
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull() {
		return data.size() == maxSize;
	}// isFull

	/**
	 * Deletes and returns the element at the top of the Stack
	 * 
	 * @return the element at the top of the Stack
	 */
	public T pop() {
		return data.removeLast();
	}// pop

	/**
	 * Number of elements in the Stack
	 * 
	 * @return the number of elements in the Stack
	 */
	public int size() {
		return data.size();
	}// size

	/**
	 * Adds an element to the top of the Stack
	 * 
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	public boolean push(T e) {
		if (isFull())
			return false;
		data.add(e);
		return true;
	}// push

	/**
	 * Returns the elements of the Stack in an array, [0] is top of Stack, [1] is
	 * next in Stack, etc.
	 * 
	 * @return an array of the Objects in the Stack
	 */
	public T[] toArray() {
		Object[] data_flipped = data.toArray();
		Object[] data_array = new Object[data_flipped.length];

		for (int i = 0; i < data_flipped.length; i++) {
			data_array[i] = data_flipped[data_flipped.length - 1 - i];
		}

		return (T[]) data_array;
	}// toArray
	/*
	 * public static void main(String[] args) { MyStack<Integer> q = new
	 * MyStack<Integer>(10);
	 * 
	 * System.out.println(q.isEmpty()); q.push(1); q.push(2);
	 * System.out.println(q.isEmpty()); System.out.println(q.isFull());
	 * System.out.println(q.pop()); q.push(3); q.push(4); q.push(5); q.push(6);
	 * q.push(7); q.push(8); q.push(9); q.push(10); System.out.println(q.push(11));
	 * System.out.println(q.push(12)); Object[] arr = q.toArray(); for (int i = 0; i
	 * < arr.length; i++) { System.out.println((Integer) arr[i]); }
	 * 
	 * }// main
	 */
}
