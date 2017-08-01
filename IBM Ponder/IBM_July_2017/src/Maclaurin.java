import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;



public class Maclaurin {

	
	private static int iterations;
	private static MathContext mc;
	
	
	private Maclaurin() {}
	
	/** Calculates sin of the angle theta; sin(theta)
	 * 
	 * @param theta angle trying to solve in radians
	 * @param precision number of digits after decimal place, rounds normally
	 * @return sin(theta) as BigDecimal
	 */
	public static BigDecimal sin(BigDecimal theta, int precision) {	
		setup(precision);
		return solveSin(theta).setScale(precision, RoundingMode.HALF_UP);
	}
	
	/** Calculates sin of the angle theta; sin(theta)
	 * 
	 * @param theta angle trying to solve in radians
	 * @param precision number of digits after decimal place, rounds normally
	 * @return sin(theta) as BigDecimal
	 */
	public static BigDecimal sin(Double theta, int precision) {	
		setup(precision);
		BigDecimal thetaBD = new BigDecimal(theta, mc);
		return solveSin(thetaBD).setScale(precision, RoundingMode.HALF_UP);
	}
	

	/** Calculates cos of the angle theta; cos(theta)
	 * 
	 * @param theta angle trying to solve in radians
	 * @param precision number of digits after decimal place, rounds normally
	 * @return cos(theta) as BigDecimal
	 */
	public static BigDecimal cos(BigDecimal theta, int precision) {	
		setup(precision);
		return solveCos(theta).setScale(precision, RoundingMode.HALF_UP);
	}
	
	/** Calculates cos of the angle theta; cos(theta)
	 * 
	 * @param theta angle trying to solve in radians
	 * @param precision number of digits after decimal place, rounds normally
	 * @return cos(theta) as BigDecimal
	 */
	public static BigDecimal cos(Double theta, int precision) {	
		setup(precision);
		BigDecimal thetaBD = new BigDecimal(theta, mc);
		return solveCos(thetaBD).setScale(precision, RoundingMode.HALF_UP);
	}
	
	
	/** Calculates tan of the angle theta; tan(theta)
	 * 
	 * @param theta angle trying to solve in radians
	 * @param precision number of digits after decimal place, rounds normally
	 * @return tan(theta) as BigDecimal
	 */
	public static BigDecimal tan(BigDecimal theta, int precision) {	
		setup(precision);
		
		BigDecimal sin = solveSin(theta);
		BigDecimal cos = solveCos(theta);
		BigDecimal tan = sin.divide(cos, mc);
		return tan.setScale(precision, RoundingMode.HALF_UP);
	}
	
	/** Calculates tan of the angle theta; tan(theta)
	 * 
	 * @param theta angle trying to solve in radians
	 * @param precision number of digits after decimal place, rounds normally
	 * @return tan(theta) as BigDecimal
	 */
	public static BigDecimal tan(Double theta, int precision) {	
		setup(precision);
		BigDecimal thetaBD = new BigDecimal(theta, mc);
		
		BigDecimal sin = solveSin(thetaBD);
		BigDecimal cos = solveCos(thetaBD);
		BigDecimal tan = sin.divide(cos, mc);
		return tan.setScale(precision, RoundingMode.HALF_UP);
	}
		
	
	
	
	
	private static void setup(int precision) {		
		iterations = precision + 4;		
		mc = new MathContext(iterations);
	}
	
	
	
	
	private static BigDecimal solveSin(BigDecimal theta) {
		
		BigDecimal answer = new BigDecimal(0, mc);
		BigDecimal a, bDividend, bDivisor;
		
		//Loop for each iteration which is calculated from precision
		for (int i = 1; i <= iterations; i++) {
			
			a = new BigDecimal(-1, mc).pow(i+1, mc);											// (-1)^(n+1)
			bDividend = theta.pow(2*i-1);														// x^(2n-1)
			bDivisor = new BigDecimal(2*i-1, mc);												// (2n-1)
			
			//Calculate bDivisor which is a factorial
			for (int n = bDivisor.intValue()-1; n >= 1; n--) {									// (2n-1)!
				bDivisor = bDivisor.multiply( new BigDecimal(n, mc), mc);
			}
			
			answer = answer.add( a.multiply(bDividend.divide(bDivisor, mc) , mc), mc);			// answer += a * (bDivided / bDivisor)
		}
	
		return answer;		
	}
	

	private static BigDecimal solveCos(BigDecimal theta) {
		
		BigDecimal answer = new BigDecimal(0, mc);
		BigDecimal dividendA, dividendB, divisor;
		
		//Loop for each iteration which is calculated from precision
		for (int i = 0; i < iterations; i++) {
			
			dividendA = new BigDecimal(-1, mc).pow(i);											// (-1)^n
			dividendB = theta.pow(2*i);															// theta^(2n)
			
			if (i == 0) {
				divisor = new BigDecimal(1, mc);												//0! = 1
			} else {
				divisor = new BigDecimal(2*i, mc);												// 2n
			}
			
			
			//Calculates divisor which is a factorial
			for (int n = divisor.intValue() -1; n >= 1; n--) {									// (2n)!
				divisor = divisor.multiply( new BigDecimal(n, mc), mc);
			} 
			
			answer = answer.add(dividendA.multiply(dividendB, mc).divide(divisor, mc) ,mc);		// answer += (dividendA * dividendB) / divisor
		}
	
		return answer;		
	}
}
