import java.util.ArrayList;

/**
 * <h1>Maximum Subarray</h1>
 * <p>Problem from LeetCode.</p>
 * 
 * <h3>Description</h3>
 * <p>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.<br>
 * <br>
 * <br>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],<br>
 * <br>
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * </p>
 * 
 * @since 04-08-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://leetcode.com/problems/maximum-subarray/description/">Problem Description</a>
 */


public class Main {
	
	private static int[] ARRAY = {-2,1,-3,4,-1,2,1,-5,4};
	
	public static void main(String args[]) {
		ArrayList<Subarray> subarrays = new ArrayList<Subarray>();
		
		//Edge case 1 element
		if (ARRAY.length == 1)
			System.out.println("Max number & length: " + ARRAY[0]);
		
		for (int integer : ARRAY) {
			
			//If first element
			if (subarrays.isEmpty()) {
				subarrays.add(new Subarray(integer));
			} else {
				for (Subarray array : subarrays) {
					array.add(integer);
				}

				subarrays.add(new Subarray(integer));
			}
		}			

		Subarray maxSubarray = getMaximumSubarray(subarrays);
		
		outputResult(maxSubarray);
	}
	
	
	
	
	static private Subarray getMaximumSubarray(ArrayList<Subarray> subarray) {
		int length = subarray.size();
		int maxNumber = -99999999;
		int maxIndex = -1;
		
		for (int i = 0; i < length; i++) {
			int subarrayMaxNumber = subarray.get(i).getMaxSubarrayAddition();
			if (subarrayMaxNumber > maxNumber) {
				maxIndex = i;
				maxNumber = subarrayMaxNumber;
			}				
		}
		
		return subarray.get(maxIndex);
	}
	
	static private void outputResult(Subarray subarray) {
		String str = "";
		
		ArrayList<Integer> arrayList = subarray.getMaxSubarray();
		
		for (Integer integer : arrayList) {
			str += String.valueOf(integer) + ", ";
		}
		
		System.out.println("Max Array: " + str);
		System.out.println("Max number: "+ subarray.getMaxSubarrayAddition());		
	}
	
}
