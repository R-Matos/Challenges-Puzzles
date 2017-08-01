import java.math.BigDecimal;
import java.math.MathContext;

public final class Pi {

	

	//Uses Chudnovsky algorithm method
	//Best explanation found (/w application) https://www.craig-wood.com/nick/articles/pi-chudnovsky/
	
	private Pi() {}

	
	public static BigDecimal pi(int precision, MathContext mc) {

		int k = 1;
		long a_k = precision;
		long aSum = precision;
		long bSum = 0;
		int c = 640320;
		
		
		do {
			a_k *= -(6 * k - 5) * (2 * k - 1) * (6 * k - 1) * 24;
			a_k = (a_k / (k * k * k * 640320 * 3));						
			aSum += a_k;
			bSum += k * a_k;
			k += 1;			
		} while (a_k != 0);
		
		
		BigDecimal root = sqrt(10005*precision, precision);
		BigDecimal temp = root.multiply(new BigDecimal(426880, mc).multiply(new BigDecimal(precision, mc)));   //426880 * root * precision
		BigDecimal total = new BigDecimal(13591409*aSum + 545140134*bSum, mc);		
		
		BigDecimal pi = temp.divide(total);
				
		return pi;
	}
	
	//Uses second order Newton-Raphson convergence.
	public static BigDecimal sqrt(int number, int precision)
	{
		//Used for BigDecimal precision
		MathContext mc = new MathContext(precision);	
		
		//Determine epsilon precision based on precision method argument
		int epsilonPrecision = (precision/4 + 1) * 3;		
		
		String epsilonStr = "0.";
		for (int i = 1; i<= epsilonPrecision; i++) {
			epsilonStr += "0";
		}
		epsilonStr += "1";
		BigDecimal epsilon = new BigDecimal(Float.parseFloat(epsilonStr), mc);
	    
	    
	    BigDecimal guess = new BigDecimal(number*number, mc);//TODO: check
	    BigDecimal low = new BigDecimal(0, mc);
	    BigDecimal high = new BigDecimal(number, mc);
	   
	    int cnt=0;
	    
	    BigDecimal temp = null;
	    BigDecimal temp2 = null;
	    
	    do {
	    	temp = (guess.multiply(guess, mc)).subtract(new BigDecimal(number, mc), mc);
	    	temp = temp.abs(mc);
	    	
	    	//temp > epsilon
	    	if (temp.compareTo(epsilon) == 1) 
	    	{
	    		guess = low.add(high, mc).divide(new BigDecimal(2, mc));
	    		
	    		if (guess.multiply(guess, mc).compareTo(new BigDecimal(2, mc)) == 1) {
	    			high = guess;	    			
	    		} else {
	    			low = guess;
	    		}
	    		cnt++;		
	    	}	    	
	    } while (temp.compareTo(epsilon) == 1);
	   
	    
	    return guess;	    
	}

	
}