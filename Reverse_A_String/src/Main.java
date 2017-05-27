import java.util.Scanner;



/**
* The Reverse_A_String program implements an application that
* reverses a string.
* String is inputted by user and printed in reverse to console.
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
		char[] charArray;
		char[] invertedArray;
		
		
		//User input
		System.out.println("Input string to reverse:");
		input = scanner.nextLine();
		
		//Converts user input to array
		charArray = input.toCharArray();
		
		//Reverses array
		invertedArray = invertArray(charArray);
		
		//Outputs array
		outputArray(invertedArray);
	}
	
	
	/**
	 * Inverts/reverses a char array.
	 *
	 * @param  original is array to be reversed
	 * @return the char array which is an inversion of the param
	 * @since 1.0
	 */
	private static char[] invertArray(char[] original) {
		
		int length = original.length;		
		char[] inverted = new char[length];
		
		int currentElement = 0;		
		
		for (int i = length-1; i >= 0; i--) {
			inverted[currentElement] = original[i];			
			currentElement++;
		}
		
		return inverted;
	}
	
	
	/**
	 * Ouputs char array to console.
	 *
	 * @param  array is array to be output
	 * @since 1.0
	 */
	private static void outputArray(char[] array) {
		
		for (char c : array) {
			System.out.print(Character.toString(c));
		
		}
		
		System.out.println();
	}
	
}
