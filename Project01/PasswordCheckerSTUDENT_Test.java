
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * 
 * @author Alec Felix
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords;

	@Before
	public void setUp() throws Exception {
		String[] p = { "JH##JHKL", "IamTheBest7", "waxUpPP111", "kjsk", "njk2l33", "th1s1sGood", "note31k", "jhdnfhh",
				"dljdDDms", "/0/0s/0/0a/0/01", "doingMyB35T", "hasNODijgit", "nowT2siW0Rks" };
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); // puts strings into the ArrayList
	}

	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Test if the password is less than 8 characters long. This test should throw a
	 * LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("A23a56"));// throw no exception
			PasswordCheckerUtility.isValidPassword("");// should throw length
			assertTrue("Did not throw lengthException", false);
		} catch (LengthException e) {
			assertTrue("Successfully threw a lengthExcepetion", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides lengthException", false);
		}

		try {
		PasswordCheckerUtility.isValidPassword("      ");// should'nt throw length
		}catch(LengthException e) {
			assertTrue("Threw length Exception when it should'nt", false);
		}catch (Exception e) {
			assertTrue("Successfully threw some other exception besides lengthException", true);
		}
	}// testIsValidPasswordTooShort

	/**
	 * Test if the password has at least one uppercase alpha character This test
	 * should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Ab12345"));//no exception
			assertTrue(PasswordCheckerUtility.isValidPassword("ab1234A"));//no exception
			PasswordCheckerUtility.isValidPassword("abdyue");
		}catch (NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlpha Exception", true);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw other Exception when it should'nt", false);
		}
	}//testIsValidPasswordNoUpperAlpha

	/**
	 * Test if the password has at least one lowercase alpha character This test
	 * should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Ab12345"));//no exception
			assertTrue(PasswordCheckerUtility.isValidPassword("ab1234A"));//no exception
			PasswordCheckerUtility.isValidPassword("12345A");
		}catch (NoLowerAlphaException e) {
			assertTrue("Successfully threw noLowerAlpha Exception", true);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw other Exception when it should'nt", false);
		}
	}//testIsValidPasswordNoLowerAlpha

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("a2345678A"));
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("a2345678A");
			assertTrue(weakPwd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception", false);
		}
	}//testIsWeakPassword

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("bbBB11!ss"));
			PasswordCheckerUtility.isValidPassword("\0\0\0123456Aa");
			assertTrue("Did not throw an InvalidSequenceException", false);
		} catch (InvalidSequenceException e) {
			assertTrue("Successfully threw an InvalidSequenceExcepetion", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException", false);
		}
	}

	/**
	 * Test if the password has at least one digit One test should throw a
	 * NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("qWert1"));
			PasswordCheckerUtility.isValidPassword("\0a\0A\0a");
			assertTrue("Did not throw an InvalidSequenceException", false);
		} catch (NoDigitException e) {
			assertTrue("Successfully threw an InvalidSequenceExcepetion", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException", false);
		}
	}//testIsValidPasswordNoDigit

	/**
	 * Test correct passwords This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("\0a\0A\0a1"));
			assertEquals(true, PasswordCheckerUtility.isValidPassword("ValidPassword12"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}//testIsValidPasswordSuccessful

	/**
	 * Test the validPasswords method Check the results of the ArrayList of Strings
	 * returned by the validPasswords method
	 */
	@Test
	public void testValidPasswords() {
			ArrayList<String> results;
			results = PasswordCheckerUtility.invalidPasswords(passwords);//******valid -> invalid
			assertEquals(results.size(),9);
			Scanner scan = new Scanner(results.get(0));
			assertEquals(scan.next(),"JH##JHKL");
			String nextResults = scan.nextLine().toLowerCase();
			assertTrue(nextResults.contains("lowercase"));

			scan = new Scanner(results.get(1));
			assertEquals(scan.next(), "waxUpPP111");
			nextResults = scan.nextLine().toLowerCase();
			assertTrue(nextResults.contains("more than two"));
			
			scan = new Scanner(results.get(2));
			assertEquals(scan.next(), "kjsk");
			nextResults = scan.nextLine().toLowerCase();
			assertTrue(nextResults.contains("6"));

			scan = new Scanner(results.get(3));
			assertEquals(scan.next(), "njk2l33");
			nextResults = scan.nextLine().toLowerCase();
			assertTrue(nextResults.contains("uppercase"));

			scan = new Scanner(results.get(5)); 
			assertEquals(scan.next(), "jhdnfhh");
			nextResults = scan.nextLine().toLowerCase();
			assertTrue(nextResults.contains("uppercase"));

			scan = new Scanner(results.get(6));
			assertEquals(scan.next(), "dljdDDms");
			nextResults = scan.nextLine().toLowerCase();
			assertTrue(nextResults.contains("digit"));
			
			scan = new Scanner(results.get(8));
			assertEquals(scan.next(), "hasNODijgit");
			nextResults = scan.nextLine().toLowerCase();
			assertTrue(nextResults.contains("digit"));
	}

}
