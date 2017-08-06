import java.util.LinkedList;

/**
 * <h1>Median of Two Sorted Arrays</h1>
 * <p>Problem from LeetCode.</p>
 * 
 * <h3>Description</h3>
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.<br>
 * <br>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * </p>
 * 
 * @since 06-08-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/description/">Problem Description</a>
 */

public class Main {	
	private static final int[] ARRAY_1 = {1, 2};
	private static final int[] ARRAY_2 = {3, 4};
	
	
	public static void main(String args[]) {		
		LinkedList<Integer> LIST_1 = arrayToList(ARRAY_1);
		LinkedList<Integer> LIST_2 = arrayToList(ARRAY_2);
		
		LinkedList<Integer> merged = mergeLists(LIST_1, LIST_2);
		
		double median = calculateMedian(merged);
		
		System.out.println("Median: " + median );		
	}
	
	/**
	 * Converts int[] into LinkedList
	 */
	private static LinkedList<Integer> arrayToList(int[] array) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for (int element : array)
			list.add(element);
		
		return list;
	}
	
	/**
	 * Merges two ordered LinkedLists into a single ASC LinkedList
	 */
	private static LinkedList<Integer> mergeLists(LinkedList<Integer> LIST_1, LinkedList<Integer> LIST_2) {
		LinkedList<Integer> merged = new LinkedList<Integer>();

		while (true) {
			if (LIST_1.isEmpty()) {
				if (LIST_2.isEmpty())
					return merged;
				else
					merged.addLast(LIST_2.pop());
			} else if (LIST_2.isEmpty()) {
				if (LIST_1.isEmpty())
					return merged;
				else
					merged.addLast(LIST_1.removeFirst());
			} else {
				if (LIST_1.peekFirst().compareTo(LIST_2.peekFirst()) < 0)
					merged.addLast(LIST_1.pop());
				else
					merged.addLast(LIST_2.pop());
			}
		}
	}

	
	/**
	 * Calculates median of a List
	 */
	private static double calculateMedian(LinkedList<Integer> list) {
		int length = list.size();
		double median = 0;
		
		//If length is even
		if (length % 2 == 0) 
		{
			double midpoint1 = list.get(length/2 - 1);
			double midpoint2 = list.get(length/2);
		
			median = (midpoint1 + midpoint2) / 2;
		}
		//If length is odd
		else 
		{
			int midPoint = length/2;
			
			median = list.get(midPoint);		
		}	
		
		return median;
	}
}
