/**
 * <h1>Reddit Challenge - Easy #277 - Simplifying Fractions</h1>
 * 
 * <h3>Description</h3>
 * <p>
 * A fraction exists of a numerator (top part) and a denominator (bottom part) as you probably all know.
 * Simplifying (or reducing) fractions means to make the fraction as simple as possible. 
 * Meaning that the denominator is a close to 1 as possible. 
 * This can be done by dividing the numerator and denominator by their greatest common divisor.
 * </p>
 * 
 * <h3>Method</h3>
 * <p>
 * 1. Check to see if numerator and denominator are the same number, making the simplified 'fraction' 1.<br/>  
 * 2. Determine which number is smallest; denominator or numerator.<br/> 
 * 3. Check to see if smallest number is in fact the HCF. Jump to 5.<br/> 
 *  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	3.1 - If SO then HCF has been found.<br/> 
 *  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	3.2 - If NOT smallest number is / 2 and used as start for determining HCF.<br/> 
 * 4. That number is then checked for whether it is fully divisible by numerator and denominator <br/> 
 *  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	4.1 - If SO then HCF has been found. Jump to 5.<br/> 
 *   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	4.2 - If NOT decrement number and retry step 4.<br/> 
 *    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	4.3 - If number is 0 there is no HCF.<br/> 
 *  5. Output Result. If HCF is found. <br/> 
 *    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	5.1 - If SO output simplified fraction & HCF<br/> 
 *    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	5.2 - If NOT output that no HCF is found and therefore fraction can't be simplified<br/> 
 * </p>
 * 
 * <h3>Links</h3>
 * <p>
 * Reddit - https://www.reddit.com/r/dailyprogrammer/comments/4uhqdb/20160725_challenge_277_easy_simplifying_fractions/
 * </p>
 * 
 * @author RMatos
 * @version 1.0
 * @since 24-01-2017
 */



public class SimplifyFraction {

	public static void main(String[] args) {
		
		int numerator = 4096;										//Numerator of fraction to simplify
		int denominator = 1024;										//Denominator of fraction to simplify
		int possibleHCF;											//Holds the current best possible candidate for HCF
		boolean isHCF = false;
		String simplifiedFraction;
		
		//Checks to see if numerator and denominator are the same
		if (numerator == denominator) {
			simplifiedFraction = "1";
		}
		
		possibleHCF = lowestNumber(numerator, denominator);			//Determines which is lower and assigns it possibleHCF	
		isHCF = isHCF(numerator, denominator, possibleHCF);			//Determines whether possibleHCF is an HCF
		
		if (isHCF == false) {										//Initial check to see if numerator/denominator is the HCF.
			possibleHCF /= 2;										//If not starts possibleHCF as half of lowest number. Reduces search time.
		}
		
		
		//Loops till finds HCF
		while (isHCF == false) {
			
			possibleHCF -= 1;										//Decrements possibleHCF to retry each loop till HCF is found
			
			if (possibleHCF == 0) {									//Once possibleHCF reaches 0 it's determined that there is no HCF
				isHCF = true;
			} else {
				isHCF = isHCF(numerator, denominator, possibleHCF);	
			}
		}
		
		simplifiedFraction = simplifiedFraction(numerator, denominator, possibleHCF);
		System.out.println(simplifiedFraction);
	}
	
	
	
	/**
	 * Method returns lowest number out of numerator or denominator
	 * 
	 * @param numerator Numerator of fraction
	 * @param denominator Denominator of fraction
	 * @return as int. Lowest number
	 */
	private static int lowestNumber(int numerator, int denominator) {
		
		if (numerator < denominator) {										//Returns lowest number
			return numerator;
		} else {
			return denominator;
		}
	}
	
	
	/**
	 * Method determines whether a number is HCF.
	 * Does this by checking whether the possibleHCF is fully divisible for both numerator 
	 * and denominator.
	 * 
	 * @param numerator Numerator of fraction
	 * @param denominator Denominator of fraction
	 * @param possibleHCF Number to check if is the HCF
	 * @return as boolean. Whether possibleHCF is the HCF.
	 */
	private static boolean isHCF(int numerator, int denominator, int possibleHCF) {
		
		int numeratorRemainder = numerator % possibleHCF;
		int denominatorRemainder = denominator % possibleHCF;
		
		if ((numeratorRemainder == 0) && (denominatorRemainder == 0)) {
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Method simplifies fraction. Then returns it as a String format ready for output to console.
	 * 
	 * @param numerator Numerator of fraction
	 * @param denominator Denominator of fraction
	 * @param hcf Highest common factor
	 * @return as String. Simplified fraction and HCF.
	 */
	private static String simplifiedFraction(int numerator, int denominator, int hcf) {
		
		//Fraction can't be simplified as no HCF was found. 
		if (hcf == 0) {
			String noHCFString = "No HCF was found. Fraction can not be simplified";
			System.out.println(noHCFString);
		}
		
		
		int simplifiedNumerator = numerator / hcf;
		int simplifiedDenominator = denominator / hcf;
		
		String simplifiedFraction = simplifiedNumerator + "/" + simplifiedDenominator + " | HCF=" + hcf;
		
		return simplifiedFraction;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
