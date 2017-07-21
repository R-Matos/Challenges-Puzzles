import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;




public class Cordic {
 
	private static MathContext mc;
    private static BigDecimal[] lookup;
    private static int iterations;
    private static BigDecimal K;
 
    private Cordic() { }
    
 
    /** Calculates sin of the angle theta.
     *  Amount of digits after decimal point are equal to the precision.
     * 
     * @param theta Angle to solve
     * @param precision Decimal point(s) precision
     * @return answer as BigDecimal
     */
    public static BigDecimal sin(BigDecimal theta, int precision) {
    	setup(theta, precision);
        return sinCos(theta, iterations)[1].setScale(precision, RoundingMode.HALF_UP);
    }
    
    /** Calculates sin of the angle theta.
     *  Amount of digits after decimal point are equal to the precision.
     * 
     * @param theta Angle to solve
     * @param precision Decimal point(s) precision
     * @return answer as BigDecimal
     */
    public static BigDecimal sin(double theta, int precision) {
    	BigDecimal thetaBD = new BigDecimal(theta);
    	setup(thetaBD, precision);
    	thetaBD = new BigDecimal(theta, mc);
        return sinCos(thetaBD, iterations)[1].setScale(precision, RoundingMode.HALF_UP);
    }
 
    
    /** Calculates cos of the angle theta.
     *  Amount of digits after decimal point are equal to the precision.
     * 
     * @param theta Angle to solve
     * @param precision Decimal point(s) precision
     * @return answer as BigDecimal
     */
	public static BigDecimal cos(BigDecimal theta, int precision) {

		setup(theta, precision);
		return sinCos(theta, iterations)[0].setScale(precision, RoundingMode.HALF_UP);
	}

	/** Calculates cos of the angle theta.
     *  Amount of digits after decimal point are equal to the precision.
     * 
     * @param theta Angle to solve
     * @param precision Decimal point(s) precision
     * @return answer as BigDecimal
     */
	public static BigDecimal cos(double theta, int precision) {
		BigDecimal thetaBD = new BigDecimal(theta);
		setup(thetaBD, precision);
		thetaBD = new BigDecimal(theta, mc);
		 return sinCos(thetaBD, iterations)[0].setScale(precision, RoundingMode.HALF_UP);
}
 
    
    
    
    private static void setup(BigDecimal theta, int precision) {        	 

        BigDecimal halfPi = new BigDecimal(1.57079632679);
       
    	if (theta.compareTo(new BigDecimal(0)) == -1|| theta.compareTo(halfPi) == 1) {
             throw new IllegalArgumentException("Required value 0 < x < Pi/2");
         }
    	
    	iterations = (precision * 4) + 1;
    	mc = new MathContext(iterations);
    	calculateK(iterations);
        createLookupTable(iterations);    	
    }
    
    //Calculates K instead of having a final constant for increased accuracy
    private static void calculateK(int iterations) {
    
    	K = new BigDecimal(1, mc);
    	BigDecimal current;
    	
    	for(int i = 0; i < iterations; i++) {
    		current = new BigDecimal(1 / Math.sqrt(1 + (Math.pow(2, (-2)*i))), mc);		//Ki = products of [1/(sqrt(1+(2^-2*i)))]
    		K = K.multiply(current); 
    	}
    }

    
    private static void createLookupTable(int iterations) {
        lookup = new BigDecimal[iterations];
        for (int i=0; i<iterations; i++) {
            lookup[i] = new BigDecimal(Math.atan(1 / Math.pow(2,i)), mc);															//atan(2^-i);
        }        
    }

    
    
    private static BigDecimal[] sinCos(BigDecimal theta, int iterations) {
       
        BigDecimal x = K;
        BigDecimal y = new BigDecimal(0, mc);
        BigDecimal z = theta;
        BigDecimal v = new BigDecimal(1, mc);
        
        for (int i=0; i<iterations; i++) {        	
            BigDecimal d = (z.compareTo(new BigDecimal(-0.00000000001)) == 1) ? new BigDecimal(+1, mc) : new BigDecimal(-1, mc); //z>=0 if +1 else -1
            
            BigDecimal tx = x.subtract(d.multiply(y, mc).multiply(v, mc), mc);													//x - d * y * v;
            BigDecimal ty = y.add(d.multiply(x, mc).multiply(v, mc), mc);														//y + d * x * v;
            BigDecimal tz = z.subtract(d.multiply(lookup[i], mc));																//z - d * lookup[i]
          
            x = tx; 
            y = ty; 
            z = tz;
            v = v.multiply(new BigDecimal(0.5, mc), mc);   
        }
        
        BigDecimal[] result = {x,y};
        return result;
    } 
}