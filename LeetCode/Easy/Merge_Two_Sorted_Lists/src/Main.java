import java.util.Arrays;
import java.util.LinkedList;

/**
 * <h1>Merge Two Sorted Lists</h1>
 * <p>Problem from LeetCode.</p>
 * 
 * <h3>Description</h3>
 * <p>
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * </p>
 * 
 * @since 01-08-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/description/">Problem Description</a>
 */

public class Main {
	
	private static final LinkedList<Integer> LIST_1 = new LinkedList<Integer>(Arrays.asList(1,3,5,7,9));
	private static final LinkedList<Integer> LIST_2 = new LinkedList<Integer>(Arrays.asList(3,5,6,7,8));
	
	
	public static void main(String args[]) {		
		LinkedList<Integer> merged = new LinkedList<Integer>();		
		
		while (true) {
			if (LIST_1.isEmpty()) {
				if (LIST_2.isEmpty())
					outputResult(merged);
				else
					merged.addLast(LIST_2.pop());
			} else if (LIST_2.isEmpty()) {
				if (LIST_1.isEmpty())
					outputResult(merged);
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
	
	private static void outputResult(LinkedList<Integer> list) {
		
		while (!list.isEmpty()) {
			System.out.println(list.pop());
		}
		
		System.exit(0);
	}
}
