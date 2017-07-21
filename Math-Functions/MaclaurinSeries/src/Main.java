

/**
 * <p>
* This program allows you to get the sin, cos or tan of an angle to the precision of your choice.
* </p>
* Uses the Taylor/Maclaurin expansion. <a href="https://en.wikipedia.org/wiki/Taylor_series">Wiki Link.</a>
* 
* <h2> Resources Used </h2> 
* <ul> 
* https://youtu.be/dp2ovDuWhro
* https://youtu.be/43QNY-edoys
* </ul>
*
* @author  Ricardo Matos
* @version 1.0
* @since   21-07-2017
*/

public class Main {
	
	
	public static void main(String args[]) {
		
		double radianAngle = 1.1;
		int precision = 100;
		
		System.out.println("Sin(1.1): " + Maclaurin.sin(radianAngle, precision));	
		System.out.println("Cos(1.1): " + Maclaurin.cos(radianAngle, precision));	
		System.out.println("Tan(1.1): " + Maclaurin.tan(radianAngle, precision));	
		
	}

}
