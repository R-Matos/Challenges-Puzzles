/**
 * <h1>Implement strStr()</h1>
 * <p>Challenge from LeetCode.</p>
 * 
 * <h3>Description</h3>
 * <p>
 * Implement strStr().<br>
 * Returns the index of the first occurrence of needle in haystack, or 
 * -1 if needle is not part of haystack.
 * </p>
 * 
 * @since 02-08-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://leetcode.com/problems/implement-strstr/description/">Problem Description</a>
 */

public class Main {

	private static final String HAYSTACK = "TESTINGbig";
	private static final String NEEDLE = "big";
	
	
	public static void main(String args[]) {
		
		int needleLength = NEEDLE.length();
		int haystackLength = HAYSTACK.length();
		int indexMatch = -1;
		
		//Loops through haystack characters
		for (int i = 0; i < haystackLength; i++) {
			//If within range
			if (haystackLength >= i + needleLength) {
				//If are current haystack position matches needle string
				if (HAYSTACK.substring(i, i + needleLength).equals(NEEDLE)) {
					indexMatch = i;
					break;
				}
			} else {
				break;
			}
		}
		
		System.out.println("Match at index (id -1 no match): " + indexMatch);
		System.out.println("Substring start at match: " + HAYSTACK.substring(indexMatch));		
	}
}
