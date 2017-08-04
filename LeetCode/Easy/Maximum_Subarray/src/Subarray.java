import java.util.ArrayList;

public class Subarray {
	
	private ArrayList<Integer> subarray = new ArrayList<Integer>();
	private ArrayList<Integer> maxSubarray = new ArrayList<Integer>();
	private int subarrayAddition, maxSubarrayAddition;
	
	
	public Subarray(int firstInteger) {
		this.subarray.add(firstInteger);
		this.maxSubarray.add(firstInteger);
		this.subarrayAddition = firstInteger;
		this.maxSubarrayAddition = firstInteger;
	}
	
	
	public void add(int integer) {
		subarray.add(integer);
		subarrayAddition += integer;
		
		if (subarrayAddition > maxSubarrayAddition) {
			maxSubarray = subarray;
			maxSubarrayAddition = subarrayAddition;
		}	
	}


	public ArrayList<Integer> getMaxSubarray() {
		return maxSubarray;
	}
	public int getMaxSubarrayAddition() {
		return maxSubarrayAddition;
	}	

}
