import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * CMSC 204 Professor Thai
 * Town_STUDENT_Test.java
 * @author Alec Felix
 * 
 */
public class Town_STUDENT_Test {
	private Town town;
	@Before
	public void setUp() throws Exception {
		town = new Town("Town 1");
		 
	}

	@After
	public void tearDown() throws Exception {
		town = null;
	}
	
	@Test
	public void testCompareTo() {
		assertEquals(0, town.compareTo(new Town("Town 1")));
		assertEquals(0, town.compareTo(town));
		assertEquals(-1, town.compareTo(new Town("Town 2")));
	}
	
	@Test
	public void testEquals() {
		assertEquals(true, town.equals(new Town("Town 1")));
		assertEquals(true, town.equals(town));
	}
	

}
