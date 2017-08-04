/**
 * <h1>Length of Last World</h1>
 * <p>Problem from LeetCode.</p>
 * 
 * <h3>Description</h3>
 * <p>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string. <br>
 * <br>
 * If the last word does not exist, return 0. <br>
 * <br>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <br>
 * For example,<br> 
 * Given s = "Hello World",<br>
 * return 5.
 * </p>
 * 
 * @since 04-08-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://leetcode.com/problems/length-of-last-word/description/">Problem Description</a>
 */

public class Main {
	
	private static final String STR = "Hello World";
	
	
	public static void main(String args[]) {
		
		 if (STR.trim().equals("")) {
			 System.out.println("Last world length = " + 0);
			 System.exit(0);
		 }
		 
	    String[] array = STR.split(" ");
		int maxWordLength = 0;		
		
		int lastWordLength = array[array.length - 1].length();
		
		System.out.println("Last word length = " + lastWordLength);		
	}

}
