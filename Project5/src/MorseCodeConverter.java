import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Project 5: Morse Code Converter 
 * Prof. Thai CMSC 204
 * MorseCodeConverter.java
 * Converts File or String from Morse Code to English
 * @author Alec Felix
 *
 */
public class MorseCodeConverter {
	
	private static MorseCodeTree morseTree = new MorseCodeTree();
	
	/**
	 * default constructor does nothing
	 */
	public MorseCodeConverter() {
		
	}// constructor
	
	/**
	 * Converts a Morse code File to a String representation in English.
	 * @param codeFile - the file to convert
	 * @return English representation as a String
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		Scanner fileReader = new Scanner(codeFile);
		String currentLine;
		String[] words_onCurrentLine;
		String[] letters_forWord;
		StringBuilder english_translation = new StringBuilder("");
		boolean endsWithSlash = false;
		
		while(fileReader.hasNextLine()) {
			currentLine = fileReader.nextLine();
			currentLine = currentLine.trim();
			if(currentLine.length() <1)
				continue;
			endsWithSlash = currentLine.charAt(currentLine.length()-1) == '/';
			words_onCurrentLine = currentLine.split("/");
			System.out.println(endsWithSlash);
			for(int i = 0; i < words_onCurrentLine.length;i++) {
				letters_forWord = words_onCurrentLine[i].split("\\s+");
				for(int j = 0; j < letters_forWord.length;j++) {
					if(letters_forWord[j].equals(""))
						continue;
					english_translation.append(morseTree.fetch(letters_forWord[j]));
				}
				if(i < words_onCurrentLine.length - 1)
					english_translation.append(" ");
			}//loop through each word on line
			if(endsWithSlash)
				english_translation.append(" ");
		}// read file line by line
		
		fileReader.close();
		
		return english_translation.toString();
	}// convertToEnglish
	
	/**
	 * Converts Morse code into English. Splits the string at '/'
	 * Then splits each word by ' ' and converts each letter to English
	 * @param code - the code to be converted
	 * @return the translation in English
	 */
	public static String convertToEnglish(String code) {
		Scanner stringReader = new Scanner(code);
		String currentLine;
		String[] words;
		String[] letters_forWord;
		StringBuilder english_translation = new StringBuilder("");
		
		words = code.split("/");
		for(int i = 0; i < words.length; i++) {
			letters_forWord = words[i].split("\\s+");
			//System.out.println("len: " + letters_forWord.length);
			for(int j = 0; j < letters_forWord.length;j++) {
				if(letters_forWord[j].equals(""))
					continue;
				//letters_forWord[j] = letters_forWord[j].trim();
				//System.out.println("'" + letters_forWord[j] + "'");
				english_translation.append(morseTree.fetch(letters_forWord[j]));
			}
			if(i < words.length - 1)
				english_translation.append(" ");
		}
		return english_translation.toString();
		
	}// convertToEnglish
	
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them
	 * @return the Tree LNR Order as a String
	 */
	public static String printTree() {
		ArrayList<String> data = morseTree.toArrayList();
		StringBuilder result = new StringBuilder("");
		
		for(int i = 0; i < data.size(); i++) {
			result.append(data.get(i));
			if(i < data.size() - 1)
				result.append(" ");
		}
		return result.toString();
	}// printTree
}//MorseCodeConverter
