/**
 * <h1>Implement Search Insert Position</h1>
 * <p>Problem from LeetCode.</p>
 * 
 * <h3>Description</h3>
 * <p>
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * <br><br>
 * You may assume no duplicates in the array.
 * <br><br>
 * Here are few examples: <br>
 * [1,3,5,6], 5 → 2 <br>
 * [1,3,5,6], 2 → 1 <br>
 * [1,3,5,6], 7 → 4 <br>
 * [1,3,5,6], 0 → 0 <br>
 * </p>
 * 
 * @since 02-08-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://leetcode.com/problems/search-insert-position/description/">Problem Description</a>
 */

public class Main {
	
	private static final int[] SORTED_ARRAY = {1, 3, 5, 6};
	private static final int TARGET = 0;
	
	
	public static void main(String args[]) {
		int length = SORTED_ARRAY.length;
		int currentIndex = 0;
		
		if (SORTED_ARRAY[0] > TARGET) {
			System.out.println("Index of target: " + currentIndex);
			System.exit(0);
		}
		
		for (int i = 0; i < length; i++) {
			if (SORTED_ARRAY[i] == TARGET) {				
				System.out.println("Index of target: " + i);
				System.exit(0);
			} else if (SORTED_ARRAY[i] <= TARGET) {
				currentIndex = i;
			} else {
				break;
			}
		}
		
		currentIndex++;
		System.out.println("Index of target: " + currentIndex);
	}
}
