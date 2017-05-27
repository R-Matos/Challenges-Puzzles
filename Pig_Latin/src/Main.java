import java.util.ArrayList;
import java.util.Scanner;


/**
* The Pig_Latin program implements an application that translates
* user input into Pig Latin.
* See https://en.wikipedia.org/wiki/Pig_Latin for more information.
*
* @author  Ricardo Matos
* @version 1.0
* @since   27-05-2017
*/


public class Main {
	
	
	public static void main(String args[]) {
	
		//Declarations
		Scanner scanner = new Scanner(System.in);
		String input;
		String[] splitInput;
		ArrayList<String> translatedInput;
				
				
		//User input
		System.out.println("Input string to translate into Pig Latin:");
		input = scanner.nextLine();
		
		//Splits string into words, each word becomes element in array
		splitInput = input.split("\\s");
		
		//Translates input
		translatedInput = translate(splitInput);
		
		//Outputs array
		for (String word : translatedInput) {
			System.out.println(word + " ");
		}
	}
	
	
	/**
	 * Translates words in a string array into Pig Latin.
	 * Then returns the translations as an ArrayList<>
	 * 
	 * @param  splitString is array to be translated. Each element being a word.
	 * @return the ArrayList<String> which contains translated words. Each element being a word.
	 * @since 1.0
	 */
	private static ArrayList<String> translate(String[] splitString) {
		
		String[] vowels = {"a", "e", "i", "o", "u"};
		ArrayList<String> translated = new ArrayList<String>();
		
		
		//Cycles through each word
		for (String word : splitString) {
		
			int firstVowel = 1000;
			String start;
			String end;
			
			//Cycles through each letter.
			for (String letter : vowels) {
				
				//Determines position of first vowel
				if ((word.indexOf(letter) < firstVowel) && (word.indexOf(letter) != -1))	//-1 is not present
					firstVowel = word.indexOf(letter);
			}
			
			//Translates
			start = word.substring(firstVowel);
			end = word.substring(0, firstVowel);
			
			//Translation added to array
			translated.add(start + end + "ay");
		}
		
		return translated;
	}
}
