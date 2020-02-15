import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Alec Felix CMSC 204 Professor Thai
 * 
 *         PasswordCheckerUtility.java
 * 
 *         provides utility methods that determine password validity and
 *         strength
 * 
 *
 */
public class PasswordCheckerUtility {

	/**
	 * checks if password is valid.length > 6, at least 1 digit, at least 1 upper/lower case.
	 * @param passwordString
	 * @return
	 * @throws LengthException
	 * @throws NoDigitException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String passwordString) throws LengthException, NoDigitException,
			NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException {

		// flags for an invalid password
		boolean digitFound = false, lowercaseAlphaFound = false, uppercaseAlphaFound = false,invalidSequenceFound = false;
		char token, prevToken = '\0';// temp store each char in passwordString
		int occurences = 1;
		// check password length
		if (passwordString.length() < 6)
			throw new LengthException();

		// loop to check other properties of a valid password
		for (int i = 0; i < passwordString.length(); i++) {

			token = passwordString.charAt(i);

			if (token == prevToken)
				occurences++;
			else
				occurences = 1;

			if (occurences == 3)
				invalidSequenceFound = true;

			// ensure password contains a digit
			if (!digitFound && (token >= 48 && token <= 57))
				digitFound = true;
			// ensure password contains lowercase letter
			if (!lowercaseAlphaFound && (token >= 97 && token <= 122))
				lowercaseAlphaFound = true;
			// ensure password contains uppercase letter
			if (!uppercaseAlphaFound && (token >= 65 && token <= 90))
				uppercaseAlphaFound = true;

			prevToken = token;
		} // loop to determine if password is valid

		if (!uppercaseAlphaFound)
			throw new NoUpperAlphaException();
		if (!lowercaseAlphaFound)
			throw new NoLowerAlphaException();
		if (!digitFound)
			throw new NoDigitException();
		if(invalidSequenceFound)
			throw new InvalidSequenceException();

		return true;
	}// isValidPassword

	/**
	 * return true if password is weak length >= 6 && length<= 9
	 * @param passwordString
	 * @return
	 */
	public static boolean isWeakPassword(String passwordString) {
		return passwordString.length() >= 6 && passwordString.length() <= 9;
	}// isWeakPassword

	/**
	 * checks arraylist of passwords.
	 * @param passwords
	 * @return list of invalid passwords
	 */
	public static ArrayList<String> invalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<String>();

		for (int i = 0; i < passwords.size(); i++) {
			try {
				isValidPassword(passwords.get(i));
			} catch (LengthException | NoDigitException | NoUpperAlphaException | NoLowerAlphaException
					| InvalidSequenceException e) {
				invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			} // catch

		} // loop to populate invalidPasswords

		return invalidPasswords;
	}// invalidPasswords
}// PasswordCheckerUtility
