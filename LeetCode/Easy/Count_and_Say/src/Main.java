import java.util.LinkedList;

/**
 * <h1>Merge Two Sorted Lists</h1>
 * <p>Problem from LeetCode.</p>
 * 
 * <h3>Description</h3>
 * <p>
 * The count-and-say sequence is the sequence of integers with the first five terms as following: <br>
 * <br>
 * 1.     1		<br>
 * 2.     11		<br>
 * 3.     21		<br>
 * 4.     1211		<br>
 * 5.     111221	<br>
 * <br>
 * 1 is read off as "one 1" or 11.					<br>
 * 11 is read off as "two 1s" or 21.				<br>
 * 21 is read off as "one 2, then one 1" or 1211.	<br>
 * <br>
 * Given an integer n, generate the nth term of the count-and-say sequence. <br>
 * <br>
 * Note: Each term of the sequence of integers will be represented as a string.
 * </p>
 * 
 * @since 03-08-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/description/">Problem Description</a>
 */



public class Main {
	
	private static final int INTS = 12111;
	
	
	public static void main(String args[]) {		
		LinkedList<Term> occurrences = new LinkedList<>();
		char[] intsArray = String.valueOf(INTS).toCharArray();
		int currentInt = -1;
		
		//Creates occurrences list
		for (char integerChar : intsArray) {
			int integer = Integer.parseInt(String.valueOf(integerChar));
			
			if (integer == currentInt) {
				occurrences.getFirst().increment();
			} else {
				currentInt = integer;
				occurrences.add(new Term(integer));
			}			
		}
		
		//Outputs list
		String output = "";
		
		while (!occurrences.isEmpty()) {
			output += occurrences.peekLast().toString();
			occurrences.removeLast();
		}
		
		System.out.println(output);
	}
}
