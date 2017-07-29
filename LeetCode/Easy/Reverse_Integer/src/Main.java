/**
 * <h1>Reverse Integer</h1>
 * <p>Problem from LeetCode.</p>
 * <h3>Description</h3>
 * <p>
 * Reverse digits of an integer.<br>
 * The input is assumed to be a 32-bit signed integer. <br>
 * Your function should return 0 when the reversed integer overflows.
 * </p>
 * 
 * @since 29-07-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://leetcode.com/problems/reverse-integer/description/">Problem Description</a> 
 */
public class Main {
	
	private static final int INTEGER = 1534236469;
	
	
	public static void main (String args[]) {
		
		String intToStr = String.valueOf(INTEGER);				//Int to string
		char[] array = intToStr.toCharArray();					//String to array
		
		String reversedStr = "";
		
		for (int i = array.length-1; i >= 0; i--) {
			reversedStr += array[i];
		}
		
		//If -ve sign remove from tail and add to head
		if (reversedStr.substring(reversedStr.length()-1, reversedStr.length()).equals("-")) {
			reversedStr = "-" + reversedStr.substring(0, reversedStr.length()-1);
		}
		
		@SuppressWarnings("unused")
		int reversedInt;
		
		//Catches overflow
		try {
			reversedInt = Integer.parseInt(reversedStr);
		} catch (java.lang.NumberFormatException e ) {
			reversedInt = 0;
		}
		
		System.out.println(reversedStr);		
	}
}
