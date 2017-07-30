/**
 * <h1>Longest Common Prefix</h1>
 * <p>Problem from LeetCode.</p>
 * 
 * <h3>Description</h3>
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * </p>
 * 
 * @since 30-07-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://leetcode.com/problems/longest-common-prefix/description/">Problem Description</a>
 */


public class Main {
	
	private static final String[] STRINGS = {"test", "testing, tes, tester, teslly"};
	 
	
	public static void main(String args[]) {
		int arrayLength = STRINGS.length;
		String longestPrefix = "";
		int longestPrefixLength = 0;
		
		//Ensure array has more than one value
		if (!(arrayLength == 1)) {			
			
			for (int i = 0; i < arrayLength; i++) {
				for (int j = 0; j < arrayLength; j++) {
					
					String prefix = STRINGS[i];
					String str = STRINGS[j];
					
					int length = prefix.length();

					// Ensures: prefix is not compared to itself & prefix is not longer than string
					if (!(i == j) && length <= str.length()) {

						// If prefix matches beginning of string and prefix longer than previously
						// matched prefix
						if (prefix.equals(str.substring(0, length)) && (length > longestPrefixLength)) {
							longestPrefix = prefix;
							longestPrefixLength = length;
						}
					}
				}
			}		
		} else {
			longestPrefix = STRINGS[0];
		}		
		
		System.out.println("Longest prefix is: " + longestPrefix);			
	}
}
