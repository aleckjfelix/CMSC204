package junitlab;
/**
 * @author Alec Felix
 * CMSC 204 Lab03 JUnit
 * GradeBookTest.java
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	private GradeBook book1, book2, book3;

	@BeforeEach
	void setUp() throws Exception {
		book1 = new GradeBook(5);
		book1.addScore(100);
		book1.addScore(50);
		book2 = new GradeBook(5);
		book2.addScore(50);
		book2.addScore(100);
		
		book3 = new GradeBook(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		book1 = null;
		book2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(book1.toString().equals("100.0 50.0"));
		assertTrue(book2.toString().equals("50.0 100.0"));
		
		assertEquals(book1.getScore(),2);
		assertEquals(book2.getScore(),2);
	}

	@Test
	void testSum() {
		assertEquals(book1.sum(),150.0);
		assertEquals(book2.sum(),150.0);
	}

	@Test
	void testMinimum() {
		assertEquals(book1.minimum(),50.0);
		assertEquals(book2.minimum(),50.0);
	}

	@Test
	void testFinalScore() {
		assertEquals(book1.finalScore(),100.0);
		assertEquals(book2.finalScore(),100.0);
		assertEquals(book3.finalScore(),0.0);
	}
}
