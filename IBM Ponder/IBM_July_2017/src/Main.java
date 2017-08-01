import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;


/**
 * <h1>Ponder This - July 2017</h1>
 * <p>Challenge from IBM.</p>
 * 
 * <h3>Description</h3>
 * <p>
 * This month's challenge is based on an idea from Omid Motahed (thanks!).<br>
 * <br>
 * Find a way to assign a unique digit to each letter such that the 863,172nd digit after 
 * the decimal point of sin(PONDER) and of sin(THIS) are not zeros, but more than a fifth of the 
 * first million digits of sin(PONDER)*sin(THIS) are zeros.<br>
 * <br>
 * The parameters are in degrees, and we count the digits from 1, so for example, sin(100) = 0.9848077530122... 
 * so the fifth digit after the decimal point of sin(100) is zero.
 * </p>
 * 
 * @since 01-08-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://www.research.ibm.com/haifa/ponderthis/challenges/July2017.html">Problem Description</a>
 */

public class Main {
	
	//Randomly guesses instead of recursively searching	
	
	public static void main(String args[]) {
		
		ArrayList<Integer> numbersUsed = new ArrayList<Integer>();
		boolean checkProductsZeros = false;
		
		
		// Loops until first 200,001 digits are 0
		do {

			boolean checkNotZero = false;
			MathContext mc = new MathContext(863173);
			BigDecimal sinPonder;
			BigDecimal sinThis;

			// Loops until pos 863172 is non zero
			do {
				// Loops until suitable numbers are found for array numbersUsed
				numbersUsed = generateNumbers(numbersUsed);

				// Formats numbers from array into integers
				String ponderStr = String.valueOf(numbersUsed.get(0)) + String.valueOf(numbersUsed.get(1))
						+ String.valueOf(numbersUsed.get(2)) + String.valueOf(numbersUsed.get(3))
						+ String.valueOf(numbersUsed.get(4)) + String.valueOf(numbersUsed.get(5));
				String thissStr = String.valueOf(numbersUsed.get(6)) + String.valueOf(numbersUsed.get(7))
						+ String.valueOf(numbersUsed.get(8)) + String.valueOf(numbersUsed.get(9));
				int ponder = Integer.valueOf(ponderStr);
				int thiss = Integer.valueOf(thissStr);

				BigDecimal ponderRadians = new BigDecimal(ponder, mc).multiply(Pi.pi(863173, mc), mc).divide(new BigDecimal (180, mc), mc);			//radians = degrees*pi / 180
				BigDecimal thisRadians = new BigDecimal(thiss, mc).multiply(Pi.pi(863173, mc), mc).divide(new BigDecimal (180, mc), mc);			//radians = degrees*pi / 180
				
				sinPonder = Maclaurin.sin(ponderRadians, 863172);
				sinThis = Maclaurin.sin(thisRadians, 863172);				
				
				// Checks no 0 at position 863172 for either sinPonder or sinThis
				checkNotZero = checkNotZero(numbersUsed, sinPonder, sinThis);

			} while (checkNotZero == false);

			checkProductsZeros = checkProductZeros(sinPonder, sinThis);

		} while (checkProductsZeros == false);	
		
		//Array of integers that matches criteria 
		System.out.println(numbersUsed);
	}
	
	
	

	
	private static boolean checkProductZeros(BigDecimal sinPonder, BigDecimal sinThis) {
		
		BigDecimal product = sinPonder.multiply(sinThis);
		String productStr = product.toPlainString();			
		int decimalPos = productStr.indexOf(".");							//Need to determine decimal pos as sign may shift	
		productStr = productStr.substring(decimalPos+1);
		
		//Checks first 200,001 digits are 0 
		for (int i = 1; i <= 200001; i++) {
			if (productStr.charAt(i) != 0)
				return false;
		}
		
		return true;
	}
	
	
	private static boolean checkNotZero(ArrayList<Integer> numbersUsed, BigDecimal sinPonder, BigDecimal sinThis) {
		
		//Gets numbers at pos 863172, acc to 1dp and doesnt round
		String ponderShifted = sinPonder.movePointRight(863171).setScale(1, RoundingMode.DOWN).toPlainString();
		String thisShifted = sinThis.movePointRight(863171).setScale(1, RoundingMode.DOWN).toPlainString();
				
		//Gets number in int format at pos 863172
		int checkPonder = Integer.valueOf(ponderShifted.substring(ponderShifted.length()-1));
		int checkThis = Integer.valueOf(ponderShifted.substring(ponderShifted.length()-1));
				
		//Check if numbers dont equal 0
		if (checkPonder == 0 && checkThis == 0) {
			return false;
		} else {
			return true;
		}
		
	}
	
	
	
	//Randomly generates numbers 
	private static ArrayList<Integer> generateNumbers(ArrayList<Integer> numbersUsed) {

		Random seed = new Random();

		//Loops until 10 numbers are added to the list
		for (int i = 0; i <= 9; i++) {

			boolean isNumberOK = false;

			// Loops until a unique number is added to the list
			do {
				int integer = seed.nextInt(10);
				isNumberOK = uniqueCheck(numbersUsed, integer);

				if (isNumberOK) {
					numbersUsed.add(integer);
				}

			} while (isNumberOK == false);
		}
		
		return numbersUsed;		
	}
	
	
	
	//Checks number hasnt already been used as needs to be unique
	private static boolean uniqueCheck(ArrayList<Integer> numbersUsed, int numberToCheck) {
		
		for (int number : numbersUsed) {
			if (numberToCheck == number)
				return false;			
		}
		
		return true;	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
