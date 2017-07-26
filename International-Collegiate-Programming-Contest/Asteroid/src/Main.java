import java.util.Scanner;

//https://icpc.baylor.edu/worldfinals/problems/icpc2015.pdf
//http://ucsmp.uchicago.edu/secondary/curriculum/advanced-algebra/demos/polyplotter-aa/
//http://www.webmath.com/equline1.html
//http://www.mathcelebrity.com/parperp.php
//

//TODO: Determines area
//			1. Join vertices with triangles
//			2. Calculate area of each triangle
//			3. Add areas

public class Main {	
	
	private final static String rawInputA = "3 1 3 2 1 0 1 0 0";
	private final static String rawInputB = "3 0 2 2 2 1 0 0 0 ";
	
	public static void main(String args[]) {
		
		
		Scanner scan = new Scanner(System.in); //DELETE ME
		
		//Creates asteroids
		Asteroid a = new Asteroid(rawInputA);
		Asteroid b = new Asteroid(rawInputB);
		
		int timeAtGreatestOverlap = 0;
		int greatestOverlap = 0;
		
		
		while (true) {
		
			// Checks for collision
			if (a.isCollided(b)) {
				
				System.out.println("Collision");
				// Calculates overlap
				int overlap = a.areaOverlap(b);
				
//				// Check if currently greatest overlap
//				if (overlap > greatestOverlap) {
//					greatestOverlap = overlap;
//					timeAtGreatestOverlap = 0;					
//				}				
			}
			
			
			a.initiateMovement();
			b.initiateMovement();
			
			scan.nextLine();			//DELETE ME
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
