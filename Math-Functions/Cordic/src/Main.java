
/**
 * <p>
* This program allows you to get the sin or cos of an angle to the precision of your choice.
* </p>
* Uses the CORDIC method. <a href="https://en.wikipedia.org/wiki/CORDIC">Wiki Link.</a>
* 
* <h2> Resources Used </h2>
* 
* <ul> 
* https://www.cl.cam.ac.uk/teaching/1314/NumMethods/JPrograms/Cordic.java 
* https://www.youtube.com/watch?v=HjwRdsjIuVQ
* https://szakuljarzuk.wordpress.com/2015/12/20/problem-how-to-calculate-sin-cos-using-cordic-algorithm/
* https://www.youtube.com/watch?v=TJe4RUYiOIgl
* </ul>
*
* @author  Ricardo Matos
* @version 1.0
* @since   20-07-2017
*/

public class Main {
	
	
	public static void main (String args[]){
		
		double radianAngle = 1.1;
		int decimalPrecision = 500;
		
		System.out.println("Sin(1.1) = " + Cordic.sin(radianAngle, decimalPrecision));
		System.out.println("Cos(1.1) = " + Cordic.cos(radianAngle, decimalPrecision));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
