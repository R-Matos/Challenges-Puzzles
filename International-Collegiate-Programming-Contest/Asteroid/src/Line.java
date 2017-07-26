
/**
 * Creates a line from from two coordinates/vertices
 * @author rmatos
 *
 */

public class Line {
	
	private double[] coords1 = new double[2]; 
	private double[] coords2 = new double[2];
	private double gradient;
	private double yIntercept;
	private boolean isLineVertical = false;
	private boolean isLineHorizontal = false;
	
	public double getGradient() {
		return gradient;
	}
	public double getyIntercept() {
		return yIntercept;
	}	
	public boolean getIsLineVertical() {
		return isLineVertical;
	}
	public boolean getIsLineHorizontal() {
		return isLineHorizontal;
	}
	public double[] getCoords1() {
		return coords1;
	}
	public double[] getCoords2() {
		return coords2;
	}
	
	
	/**
	 * Constructor creates line
	 * 
	 * @param coords1
	 * @param coords2
	 */
	public Line(double vertice1X, double vertice1Y, double vertice2X, double vertice2Y) {
		
		this.coords1[0] = vertice1X;
		this.coords1[1] = vertice1Y;
		
		this.coords2[0] = vertice2X;
		this.coords2[1] = vertice2Y;
		
		this.gradient = calculateGradient();
		
		this.yIntercept = calculateYIntercept();			
	}
	

	/**
	 * Calculates gradient. Needed for line equation.
	 * 
	 * @return
	 */
	private double calculateGradient() {
		
		double numerator, denominator, m;
		
		//Special case: vertical line. Gradient = 0;
		if (coords2[0] == coords1[0]) {
			isLineVertical = true;
			return 0;
		}
		
		//Special case: horizontal line. Gradient = 0;
		if (coords2[1] == coords1[1]) {
			isLineHorizontal = true;
			return 0;
		}
		
		//m = (y2-y1) / (x2-x1)
		numerator = coords2[1] - coords1[1];
		denominator = coords2[0] - coords1[0];
		m  = numerator / denominator;		
		
		return m;
	}

	
	/**
	 * Calculates y intercept. Needed for line equation.
	 * @return
	 */
	private double calculateYIntercept() {
		
		double c;
		
		//y = mx + c --> c = y -mx
		c = coords2[1] - (gradient * coords2[0]);
		
		return c;
	}
	
	
	/**
	 * Checks two line objects for whether they intersect.
	 * If the intersect returns vertice.
	 * If not returns 0.012345 for both x and y
	 * @param a
	 * @param b
	 * @return
	 */
	public static double[][] intersectionVertice(Line a, Line b) {
		
		double[][] lineVertice = new double[1][2];
		
		
//		double numerator = b.getyIntercept() - a.getyIntercept();			// (c2 - c1)
//		double denominator = (a.getGradient() - b.getGradient());			// (m1 - m2)
//		
//		double x = numerator / denominator;								//x = (c2 - c1) / (m1 - m2)			
//		
//		double y1 = a.getGradient() * x + a.getyIntercept();			//y = mx + c
//		double y2 = b.getGradient() * x + b.getyIntercept();			//y = mx + c
//		
//		//If lines are equal
		if (a.getGradient() == b.getGradient() && a.getyIntercept() == b.getyIntercept()) {
			lineVertice[0][0] = 0;
			lineVertice[0][1] = 0;
			return lineVertice;
		}
		
		
		
		
		
		//Special Case: Line A horizontal, Line B vertical
		if (a.isLineHorizontal && b.isLineVertical) {			

			lineVertice[0][1] = b.coords1[0];
			lineVertice[0][0] = a.coords1[1];
			
			//Range check X
			if (a.coords1[0] > a.coords2[0]) {
				if (b.coords1[0] > a.coords2[0] && b.coords1[0] < a.coords1[0]) 
					return lineVertice;				
			} else {
				if (b.coords1[0] < a.coords2[0] && b.coords1[0] > a.coords1[0])
					return lineVertice;
			}
			
			//Range check Y
			if (b.coords1[1] > b.coords2[1]) {
				if (a.coords1[1] > b.coords2[1] && a.coords1[1] < b.coords1[1])
					return lineVertice;				
			} else {
				if (a.coords1[1] < b.coords2[1] && a.coords1[1] > b.coords1[1])
					return lineVertice;	
			}				
			
			//No Intersection
			lineVertice[0][0] = 0.012345;
			lineVertice[0][1] = 0.012345;
			
			return lineVertice;	
		}
		
		//Special Case: Line B horizontal, Line A vertical
		if (a.isLineVertical && b.isLineHorizontal) {				

			lineVertice[0][1] = a.coords1[0];
			lineVertice[0][0] = b.coords1[1];
			
			//Range check X
			if (b.coords1[0] > b.coords2[0]) {
				if (a.coords1[0] > b.coords2[0] && a.coords1[0] < b.coords1[0]) 
					return lineVertice;				
			} else {
				if (a.coords1[0] < b.coords2[0] && a.coords1[0] > b.coords1[0])
					return lineVertice;
			}
			
			//Range check Y
			if (a.coords1[1] > a.coords2[1]) {
				if (b.coords1[1] > a.coords2[1] && b.coords1[1] < a.coords1[1])
					return lineVertice;				
			} else {
				if (b.coords1[1] < a.coords2[1] && b.coords1[1] > a.coords1[1])
					return lineVertice;	
			}				
			
			//No Intersection
			lineVertice[0][0] = 0.012345;
			lineVertice[0][1] = 0.012345;
			return lineVertice;	
		}
		
		
		//Special Case: Line A is vertical (gradient = 0)
		if (a.isLineVertical) {

			//y = mx + c
			lineVertice[0][1] = (b.gradient) * a.coords1[0] + b.yIntercept; 
			lineVertice[0][0] = a.coords1[0];
			
			if (b.coords1[0] > b.coords2[0]) {
				if (a.coords1[0] < b.coords1[0] && a.coords1[0] > b.coords2[0]) 
					return lineVertice;
			} else {
				if (a.coords1[0] > b.coords1[0] && a.coords1[0] < b.coords2[0]) 
					return lineVertice;
			}
			
			//No Intersection
			lineVertice[0][0] = 0.012345;
			lineVertice[0][1] = 0.012345;
			return lineVertice;			
		}
		
		//Special Case: Line B is vertical (gradient = 0)
		if (b.isLineVertical) {

			//y = mx + c
			lineVertice[0][1] = (a.gradient) * b.coords1[0] + a.yIntercept; 
			lineVertice[0][0] = b.coords1[0];
			
			//Checks vertical line is between x ranges of other line (intersects)
			if (a.coords1[0] > a.coords2[0]) {
				if (b.coords1[0] < a.coords1[0] && b.coords1[0] > a.coords2[0]) 
					return lineVertice;
			} else {
				if (b.coords1[0] > a.coords1[0] && b.coords1[0] < a.coords2[0]) 
					return lineVertice;
			}
			
			//No Intersection
			lineVertice[0][0] = 0.012345;
			lineVertice[0][1] = 0.012345;
			return lineVertice;			
		}
		
		
		//Special Case: Line A is horizontal
		if (a.isLineHorizontal) {
			
			lineVertice[0][0] = (a.coords1[1] - b.getyIntercept()) / b.getGradient();
			lineVertice[0][1] = a.coords1[1];
			
			if (b.coords1[1] > b.coords2[1]) {
				if (a.coords1[1] > b.coords2[1] && a.coords1[1] < b.coords1[1]) 
					return lineVertice;
			} else {
				if (a.coords1[1] < b.coords2[1] && a.coords1[1] > b.coords1[1]) 
					return lineVertice;
			}
			
			//No Intersection
			lineVertice[0][0] = 0.012345;
			lineVertice[0][1] = 0.012345;
			return lineVertice;
		}
		
		
		//Special Case: Line B is horizontal
		if (b.isLineHorizontal) {
			
			lineVertice[0][0] = (b.coords1[1] - a.getyIntercept()) / a.getGradient();
			lineVertice[0][1] = b.coords1[1];
			
			if (a.coords1[1] > a.coords2[1]) {
				if (b.coords1[1] > a.coords2[1] && b.coords1[1] < a.coords1[1]) 
					return lineVertice;
			} else {
				if (b.coords1[1] < a.coords2[1] && b.coords1[1] > a.coords1[1]) 
					return lineVertice;
			}
			
			//No Intersection
			lineVertice[0][0] = 0.012345;
			lineVertice[0][1] = 0.012345;
			return lineVertice;
		}
		
		//Normal case below (rest of method)		
		double numerator = b.getyIntercept() - a.getyIntercept();			// (c2 - c1)
		double denominator = (a.getGradient() - b.getGradient());			// (m1 - m2)
		
		//Stops division by 0
		if (denominator == 0) {
			lineVertice[0][0] = 0.012345;
			lineVertice[0][1] = 0.012345;
		} else {
			
			double x = numerator / denominator;								//x = (c2 - c1) / (m1 - m2)			
			
			double y1 = a.getGradient() * x + a.getyIntercept();			//y = mx + c
			double y2 = b.getGradient() * x + b.getyIntercept();			//y = mx + c
				
			//If lines are equal
//			if (a.getGradient() == b.getGradient() && a.getyIntercept() == b.getyIntercept()) {
//				lineVertice[0][0] = x;
//				lineVertice[0][1] = y1;
//			}
	
			
			//Checks there is an intersection. Ensure not conflict for sharing same vertice.
			if (y1 == y2 
					&& !(a.coords1[0] == b.coords1[0] && a.coords1[1] == b.coords1[1])
					&& !(a.coords1[0] == b.coords2[0] && a.coords1[1] == b.coords2[1])					
					&& !(a.coords2[0] == b.coords1[0] && a.coords2[1] == b.coords1[1])
					&& !(a.coords2[0] == b.coords2[0] && a.coords2[1] == b.coords2[1])) {
				
//				boolean aWithinRange = false;
//				boolean bWithinRange = false;
//				
//				//Ensure intersection is within range
//				if (a.coords1[1] > a.coords2[1]) {
//					if (y1 >= a.coords1[1] && y1 <= a.coords1[1])
//						aWithinRange = true;
//				} else {
//					if (y1 <= a.coords1[1] && y1 >= a.coords1[1])
//						aWithinRange = true;
//				}			
//				
//				if (b.coords1[1] > b.coords2[1]) {
//					if (y1 >= b.coords2[1] && y1 <= b.coords1[1])
//						bWithinRange = true;
//				} else {
//					if (y1 <= b.coords2[1] && y1 >= b.coords1[1])
//						bWithinRange = true;					
//				}
//				
//				if (aWithinRange && bWithinRange) {
					//Intersection
					lineVertice[0][0] = x;
					lineVertice[0][1] = y1;
					return lineVertice;
//				}
				
			}
			// No Intersection
			lineVertice[0][0] = 0.012345;
			lineVertice[0][1] = 0.012345;
		}
		
		return lineVertice;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
