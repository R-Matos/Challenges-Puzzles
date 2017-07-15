import java.math.BigInteger;


/**
 * <h1>Reddit Challenge - Intermediate #322 - Largest Palindrome</h1>
 * 
 * <h3>Description</h3>
 * 
 * <p>
 * Write a program that, given an integer input n, prints the largest integer 
 * that is a palindrome and has two factors both of string length n.
 * <p>
 * 
 * @author RMatos
 * @version 1.0
 * @since 15-07-2017
 */

public class Main {

	final static int factorLength = 5;
	
	
	public static void main (String args[]) {
		
		
		int initialFactor = getInitialFactor();
		

		//Loops till outputs first palindrome then exits
		for (int i = initialFactor; i >= 0; i--) {
			for (int j = initialFactor; j >= 0; j--) {
				
				BigInteger factorsMultiplied = BigInteger.valueOf(i * j);
				boolean isPalindrome = isPalindrome(factorsMultiplied);
				
				if (isPalindrome) {
					System.out.println(i + ", " + j + " --> " + factorsMultiplied);
					System.exit(0);
				}				
			}			
		}
		
		
		
	}
	
	
	//Gets max possible factor from factorLength
	private static int getInitialFactor() {
		
		String tens = "9";
		String initialFactorStr = "";
		int initialFactor;
		
		//Get max possible number in string format
		for (int i = 1; i <= factorLength; i++) {
			initialFactorStr = initialFactorStr + tens;			
		}
		
		//Convert string format to int
		initialFactor = Integer.parseInt(initialFactorStr);	
		
		return initialFactor;		
	}
	
	
	//Checks if value is palindrome
	private static boolean isPalindrome(BigInteger factorsMultiplied) {
		
		String factorsMultipliedStr = String.valueOf(factorsMultiplied); 
		String head;
		String tail;
		
		//Checks that length can be evenly divided
		if (factorsMultipliedStr.length() % 2 != 0) {
			return false;
		}
		
		head = factorsMultipliedStr.substring(0, factorsMultipliedStr.length() / 2);
		tail = factorsMultipliedStr.substring(factorsMultipliedStr.length() / 2);
		tail = reverseString(tail);
		
		System.out.println("head: " + head);
		System.out.println("tail: " + tail);
		
		//Checks if palindrome; head is equal to tail
		if (head.equals(tail)) {
			return true;
		} else {
			return false;
		}		
	}
	
	
	//Reverses a string
	private static String reverseString(String str) {
		
		String reversedString = "";
		
		for (int i = str.length()-1; i>=0 ; i--) {
			reversedString = reversedString + str.substring(i, i+1);
		}
		
		return reversedString;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
