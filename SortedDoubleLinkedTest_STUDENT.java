
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Aleck
 * CMSC 204 Prof. Thai Project03 Doubly Linked List
 * SortedDoubleLinkedTest_STUDENT.java
 * 
 * No need to test methods that aren't overriden
 *
 */
public class SortedDoubleLinkedTest_STUDENT {
	SortedDoubleLinkedList<String> linkedString;
	StringComparator comparator;

	@BeforeEach
	void setUp() throws Exception {
		comparator = new StringComparator();
		linkedString = new SortedDoubleLinkedList<String>(comparator);
	}

	@AfterEach
	void tearDown() throws Exception {
		linkedString = null;
		comparator = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			linkedString.addToEnd("A");
			fail("No Exception");
		}catch(UnsupportedOperationException e) {
			
		}
	}

	@Test
	public void testAddToFront() {
		try {
			linkedString.addToFront("A");
			fail("No Exception");
		}catch(UnsupportedOperationException e) {
			
		}
	}
	
	@Test
	public void testAdd() {
		ArrayList<String> ans = new ArrayList<String>();
		ans.add("A");
		ans.add("B");
		ans.add("C");
		linkedString.add("C");
		assertTrue(linkedString.getFirst().equals("C"));
		linkedString.add("A");
		assertTrue(linkedString.getFirst().equals("A"));
		linkedString.add("B");
		assertTrue(linkedString.toArrayList().equals(ans));
		linkedString.add("D");
		ans.add("D");
		assertTrue(linkedString.toArrayList().equals(ans));
		
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
