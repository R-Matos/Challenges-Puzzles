import java.math.BigInteger;

/**
 * <h1>Plus One</h1>
 * <p>Problem from LeetCode.</p>
 * 
 * <h3>Description</h3>
 * <p>
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer. <br>
 * <br>
 * You may assume the integer do not contain any leading zero, except the number 0 itself. <br>
 * <br>
 * The digits are stored such that the most significant digit is at the head of the list.<br>
 * <br>
 * TLDR <br>
 * You've got an integer split into an int array. <br>
 * Increment the int array and output to console
 * </p>
 * 
 * @since 06-08-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://leetcode.com/problems/plus-one/description/">Problem Description</a>
 */
	
public class Main {
	private static final int[] ARRAY = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
	
	
	public static void main (String args[]) {		
		
		//Array to string
		String arrayStr = arrayToString();
		
		//String to BigInteger
		BigInteger arrayBigInt = new BigInteger(arrayStr);
		
		//Increment BigInteger
		arrayBigInt = arrayBigInt.add(new BigInteger("1"));
		
		//BigInteger to string
		arrayStr = arrayBigInt.toString();
		
		//String to int array
		int[] array = stringToArray(arrayStr);
		
		//Outputs int array to console
		outputToConsole(array);		
	}
	

	/**
	 * Array to string
	 */
	private static String arrayToString() {
		String str = "";
		
		for (int element : ARRAY)
			str += String.valueOf(element);
		
		return str;
	}
	
	/**
	 * String to array
	 */
	private static int[] stringToArray(String arrayStr) {
		char[] arrayChar = arrayStr.toCharArray();
		int length = arrayChar.length;
		int[] array = new int[length];
	
		for (int i = 0; i < length; i++) 
			array[i] = Integer.parseInt(String.valueOf(arrayChar[i]));
			
		return array;		
	}

	/**
	 * Outputs incremented array to console
	 */
	private static void outputToConsole(int[] array) {
		
		for (int element : array) {
			System.out.print(element +",");
		}
	}

}
