
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Aleck
 * CMSC 204 Prof. Thai Project03 Doubly Linked List
 * BasicDoubleLinkedListTest_STUDEN.java
 * 
 *
 */
public class BasicDoubleLinkedListTest_STUDENT {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<String> emptyString;
	StringComparator comparator;

	public ArrayList<Car> fill = new ArrayList<Car>();

	@Before
	public void setUp() throws Exception {
		emptyString = new BasicDoubleLinkedList<String>();
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("A");
		linkedString.addToEnd("B");
		linkedString.addToEnd("C");
		linkedString.addToEnd("D");

		comparator = new StringComparator();

	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(0, emptyString.getSize());
		emptyString.addToEnd("B");
		assertEquals(1, emptyString.getSize());
		emptyString.retrieveLastElement();
		assertEquals(0, emptyString.getSize());
	}

	@Test
	public void testAddToEnd() {
		assertEquals("D", linkedString.getLast());
		linkedString.addToEnd("E");
		assertEquals("E", linkedString.getLast());
	}

	@Test
	public void testAddToFront() {
		assertEquals("A", linkedString.getFirst());
		linkedString.addToFront("0");
		assertEquals("0", linkedString.getFirst());
	}

	@Test
	public void testGetFirst() {
		assertEquals("A", linkedString.getFirst());
		linkedString.addToFront("0");
		assertEquals("0", linkedString.getFirst());

	}

	@Test
	public void testGetLast() {
		assertEquals("D", linkedString.getLast());
		linkedString.addToEnd("E");
		assertEquals("E", linkedString.getLast());

	}

	@Test
	public void testToArrayList() {
		ArrayList<String> list;
		list = linkedString.toArrayList();
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
	}

	@Test
	public void testIteratorSuccessfulNext() {

		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("A", iterator.next());
		assertEquals("B", iterator.next());
		assertEquals("C", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("D", iterator.next());

	}

	@Test
	public void testIteratorSuccessfulPrevious() {
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("A", iterator.next());
		assertEquals("B", iterator.next());
		assertEquals("C", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("D", iterator.next());
		assertEquals(false, iterator.hasNext());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("D", iterator.previous());
		assertEquals("C", iterator.previous());
		assertEquals("B", iterator.previous());
		assertEquals("A", iterator.previous());
		assertEquals(false, iterator.hasPrevious());
	}

	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals("A", iterator.next());
		assertEquals("B", iterator.next());
		assertEquals("C", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("D", iterator.next());
		assertEquals(false, iterator.hasNext());
		try {
			// no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException", false);
		} catch (NoSuchElementException e) {
			assertTrue("Successfully threw a NoSuchElementException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}

	}

	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(false, iterator.hasPrevious());
		try {
			// no more elements in list
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException", false);
		} catch (NoSuchElementException e) {
			assertTrue("Successfully threw a NoSuchElementException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}

	}

	@Test
	public void testIteratorUnsupportedOperationException() {
		ListIterator<String> iterator = linkedString.iterator();
		try {
			// remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException", false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Successfully threw a UnsupportedOperationException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}

	}

	@Test
	public void testRemove() {
		
		

	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals("A", linkedString.retrieveFirstElement());
		assertEquals("B", linkedString.getFirst());
	

	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals("D", linkedString.getLast());
		assertEquals("D", linkedString.retrieveLastElement());
	}

	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}

	}

	private class DoubleComparator implements Comparator<Double> {

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}

	}

	private class CarComparator implements Comparator<Car> {

		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}

	}

	private class Car {
		String make;
		String model;
		int year;

		public Car(String make, String model, int year) {
			this.make = make;
			this.model = model;
			this.year = year;
		}

		public String getMake() {
			return make;
		}

		public String getModel() {
			return model;
		}

		public int getYear() {
			return year;
		}

		public String toString() {
			return (getMake() + " " + getModel() + " " + getYear());
		}
	}
}
