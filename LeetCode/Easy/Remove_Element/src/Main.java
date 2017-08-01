/**
 * <h1>Remove Element</h1>
 * <p>Problem from LeetCode.</p>
 * 
 * <h3>Description</h3>
 * <p>
 * Given an array and a value, remove all instances of that value in place and return the new length.<br>
 * Do not allocate extra space for another array, you must do this in place with constant memory. <br>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.<br>
 * <br>
 * Example:<br>
 * Given input array nums = [3,2,2,3], val = 3 <br>
 * Your function should return length = 2, with the first two elements of nums being 2.
 * </p>
 * 
 * @since 01-08-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://leetcode.com/problems/remove-element/description/">Problem Description</a>
 */

public class Main {
	
	private static final int[] ARRAY = {1, 3, 3, 1};
	private static final int VALUE_TO_IGNORE = 3;
	
	public static void main(String args[]) {
		
		int counter = 0;
		
		for (int integer : ARRAY) {
			if (integer != VALUE_TO_IGNORE)
				counter++;			
		}
		
		System.out.println("Values in array: " + counter);
	}
}
