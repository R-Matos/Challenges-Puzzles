/**
 * <h1>Two Sum</h1>
 * <p>Problem from LeetCode.</p>
 * 
 * <h3>Description</h3>
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target. <br>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * </p>
 * 
 * @since 29-07-2017
 * @version 1.0
 * @author RMatos
 * @see <a href="https://leetcode.com/problems/two-sum/description/">Problem Description</a> 
 */

public class Main {
	
	private static int[] NUMS = {2,11,11,7};
	private static int TARGET = 9;
	
	
	public static void main (String args[]) {
		
		for (int i = 0; i < NUMS.length; i++) {
			for (int j = 0; j < NUMS.length; j++) {
				
				if (NUMS[i]+NUMS[j] == TARGET && i != j) {
					System.out.println("Elements: ["+i+"] & ["+j+"]");
				}
			}			 
		}	
	}
}
