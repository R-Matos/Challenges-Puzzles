/**
 * <h1>Reverse Integer</h1>
 * <p>Problem from LeetCode.</p>
 * 
 * <h3>Description</h3>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * </p>
 * 
 * @since 30-07-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://leetcode.com/problems/palindrome-number">Problem Description</a> 
 */

public class Main {
	
	private static final int INTEGER = -2147447412;
	
	
	public static void main (String args[]) {
		
		String intStr = String.valueOf(INTEGER);		
		intStr = removeNegative(intStr);
		
		//Determines if odd or even and selects a palindrome method based on it
		boolean isPalindrome = (intStr.length() % 2 == 0) ? isPalindrome("even", intStr) : isPalindrome("odd", intStr);
		
		System.out.println("Is "+INTEGER+" palindrome: " + isPalindrome);
	}
	
	
	
	private static String removeNegative(String str) {
		
		if (str.substring(0,1).equals("-"))
			str = str.substring(1, str.length());
		
		return str;		
	}
	
	
	private static Boolean isPalindrome(String oddOrEven, String str) {		
		int length = str.length();
		String head = str.substring(0, length/2);		
		String tail = (oddOrEven.equalsIgnoreCase("even")) ? 
				str.substring(length / 2, length) : str.substring(length / 2 + 1, length);

		tail = reverseString(tail);
		
		boolean isPalindrome = head.equals(tail);
		return isPalindrome;
	}
	
	

	
	private static String reverseString(String str) {
		String reversedString = "";

		for (int i = str.length() - 1; i >= 0; i--) 
			reversedString = reversedString + str.substring(i, i + 1);		

		return reversedString;
	}
}
