import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * CMSC 204 Professor Thai
 * Road_STUDENT_Test.java
 * @author Alec Felix
 * 
 */
public class Road_STUDENT_Test {
	private Road road;
	
	@Before
	public void setUp() throws Exception {
		road = new Road(new Town("Town 1"), new Town("Town 2"), 2, "Road 1");
	}

	@After
	public void tearDown() throws Exception {
		road = null;
	}
	
	@Test
	public void testCompareTo() {
		assertEquals(0, road.compareTo(new Road(new Town("Town 1"), new Town("Town2"), 2, "Road 1")));
		assertEquals(0, road.compareTo(road));
		assertEquals(0, road.compareTo(new Road(new Town("Town 2"), new Town("Town1"), 2, "Road 1")));
	}
	
	@Test
	public void testEquals() {
		assertEquals(true, road.equals(new Road(new Town("Town 1"), new Town("Town 2"), 2, "Road 1")));
		assertEquals(true, road.equals(road));
	}
	
	@Test
	public void testContains() {
		assertEquals(true, road.contains(new Town("Town 1")));
		assertEquals(true, road.contains(new Town("Town 2")));
		assertEquals(false, road.contains(new Town("Town 3")));
	}
}
