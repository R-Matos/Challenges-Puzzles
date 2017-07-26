import java.util.ArrayList;

public class Asteroid {

	private int verticeCount, velocityX, velocityY;
	private int minX, minY, maxX, maxY;
	private int[][] vertices;
	
	/**
	 * Constructor.
	 * Takes raw input and creates an Asteroid object
	 *
	 * @param rawInput
	 */
	public Asteroid(String rawInput) {
		
		String[] input = rawInput.split(" ");								//Splits string into array elements for easier parsing
		
		this.verticeCount = Integer.parseInt(input[0]);						//Gets number of vertices. Used for range of vertices array
		
		vertices = new int[verticeCount][2];
		for (int i = 1; i < verticeCount*2; i+=2) {							//Populates vertice array	
				vertices[i/2][0] = Integer.parseInt(input[i]);
				vertices[i/2][1] = Integer.parseInt(input[i+1]);			
		}
		
		velocityX = Integer.parseInt(input[input.length-2]);
		velocityY = Integer.parseInt(input[input.length-1]);
		
		verticeRanges();													//Determines max and min ranges of asteroid, used to check for collision
	}
	
	public int getMinX() {
		return minX;
	}
	public int getMinY() {
		return minY;
	}
	public int getMaxX() {
		return maxX;
	}
	public int getMaxY() {
		return maxY;
	}
	public int getVerticeCount() {
		return verticeCount;
	}
	public int[][] getVertices() {
		return vertices;
	}

	
	/**
	 * Checks if another asteroid has collided with current
	 * 
	 * @param asteroid
	 * @return
	 */
	public boolean isCollided(Asteroid asteroid) {
		
		
		//Checks X Axis collision
		if ( (minX <= asteroid.getMinX() && maxX >= asteroid.getMinX()) 
				|| minX <= asteroid.getMaxX() && maxX >= asteroid.getMaxX()) {
			
			//Checks Y Axis collision
			if ( (minY <= asteroid.getMinY() && maxY >= asteroid.getMinY()) 
					|| (minY <= asteroid.getMaxY() && maxY >= asteroid.getMaxY()) ) {
				return true;
			}					
		}		
		return false;
	}
		
	
	
	/**
	 * Simulates asteroid in movements for 1 second by altering vertice positions
	 */
	public void initiateMovement() {
		
		//Updates vertices with new position
		for (int i = 0; i < verticeCount; i++) {
			vertices[i][0] += velocityX;
			vertices[i][1] += velocityY;			
		}	
		
		//Updates vertice ranges
		verticeRanges();		
	}
	
	/**
	 * Calculates area overlap.
	 * Done by getting line intersection vertices, joining them up to become a polygon and finding its area.
	 * @param asteroid
	 * @return
	 */
	public int areaOverlap(Asteroid asteroid) {
		
		//Get coordinates of line intersections
		ArrayList<double[][]> lineIntersections = findLineIntersection(asteroid);
		
		//TODO: DELETE ME
//		for (double[][] element : lineIntersections) {
//			System.out.println(element[0][0]+","+element[0][1]);
//		}
		
		//Connect lines without intersecting (triangular)
		ArrayList<Line> connectedVertices = connectVertices(lineIntersections);
		
		
		 

		
		
		return 0;
	}
	
	
	
	/**
	 * Determines and sets vertice ranges. Used for checking for collision
	 */
	private void verticeRanges() {
		
		minX = 100;
		minY = 100;
		maxX = -1;
		maxY = -1;		
		
		for (int i = 0; i < verticeCount; i++) {
			
			//Finds lowest X value
			if (minX > vertices[i][0])
				minX = vertices[i][0];
			
			//Finds lowest Y value
			if (minY > vertices[i][1])
				minY = vertices[i][1];	
			
			//Finds highest X value
			if (maxX < vertices[i][0])
				maxX = vertices[i][0];	
			
			// Finds highest Y value
			if (maxY < vertices[i][1])
				maxY = vertices[i][1];
		}		
	}
		
	
	private ArrayList<double[][]> findLineIntersection(Asteroid asteroid) {
		
		ArrayList<double[][]> lineIntersections = new ArrayList<>();
		
		int greatestVerticeCount = verticeCount;
		int lowestVerticeCount = asteroid.getVerticeCount();

		// Compares every line to each other and saves any intersection coordinates
		for (int i = 0; i < greatestVerticeCount; i++) {

			Line a;
			
			//Creates a line between last and first vertice. Overwritten if not last vertice in loop.
			if (verticeCount > asteroid.getVerticeCount()) {
				a = new Line(vertices[0][0], vertices[0][1], vertices[greatestVerticeCount-1][0], vertices[greatestVerticeCount-1][1]);
			} else {
				a  = new Line(asteroid.getVertices()[0][0], asteroid.getVertices()[0][1], 
							asteroid.getVertices()[greatestVerticeCount-1][0], asteroid.getVertices()[greatestVerticeCount-1][1]);
			}

			// Creates line between vertice j and j+1
			if (verticeCount > asteroid.getVerticeCount() && i != greatestVerticeCount - 1) {
				a = new Line(vertices[i][0], vertices[i][1], vertices[i + 1][0], vertices[i + 1][1]);
			} else if (i != greatestVerticeCount -1) {
				a = new Line(asteroid.getVertices()[i][0], asteroid.getVertices()[i][1],
						asteroid.getVertices()[i+1][0], asteroid.getVertices()[i+1][1]);
			}

			for (int j = 0; j < lowestVerticeCount; j++) {

				Line b;	
				
				//Creates a line between last and first vertice. Overwritten if not last vertice in loop.
				if (verticeCount > asteroid.getVerticeCount()) {
					b  = new Line(asteroid.getVertices()[0][0], asteroid.getVertices()[0][1], 
								asteroid.getVertices()[lowestVerticeCount-1][0], asteroid.getVertices()[lowestVerticeCount-1][1]);
				} else {
					b = new Line(vertices[0][0], vertices[0][1], vertices[lowestVerticeCount-1][0], vertices[lowestVerticeCount-1][1]);
				}

				// Creates line between vertice j and j+1
				if (verticeCount > asteroid.getVerticeCount() && j != lowestVerticeCount - 1) {
					b = new Line(asteroid.getVertices()[j][0], asteroid.getVertices()[j][1],
							asteroid.getVertices()[j + 1][0], asteroid.getVertices()[j + 1][1]);
				} else if (j != lowestVerticeCount - 1) {
					b = new Line(vertices[j][0], vertices[j][1], vertices[j + 1][0], vertices[j + 1][1]);
				}

				// Checks created lines for collision
				double[][] collisionVertice = Line.intersectionVertice(a, b);

				// Check whether collision occured, if did add vertice to lineIntersections	// arraylist
				if (collisionVertice[0][0] != 0.012345 && collisionVertice[0][1] != 0.012345) {
					lineIntersections.add(collisionVertice);
				}
			}
		}		
		
		return lineIntersections;
	}
	
	
	/**
	 * Makes connection between vertices passed in
	 * Makes triangular shapes between vertices
	 * @param vertices
	 * @return
	 */
	private ArrayList<Line> connectVertices(ArrayList<double[][]> vertices) {
		
		ArrayList<Line> lines = new ArrayList<>(); 
		Line newLine;
		
		for (double[][] verticeA : vertices) {			
			for (double[][] verticeB : vertices) {				
			
				//Ensures not the same vertice
				if (!verticeA.equals(verticeB)) { 
					
					//Creates first line if there is none
					if (lines.isEmpty()) {
						newLine = new Line(verticeA[0][0], verticeA[0][1], verticeB[0][0], verticeB[0][1]);
						lines.add(newLine);
					} else {
						newLine = new Line(verticeA[0][0], verticeA[0][1], verticeB[0][0], verticeB[0][1]);
						
						boolean noLineConflict = true;
						
						//Loops through previously created lines
						for (Line line : lines) {
							//Checks new line doesnt intersects with other lines
							if (Line.intersectionVertice(line, newLine)[0][0] != 0.012345) {
								noLineConflict = false;
							}
						}	
						
						//New line is ok - no intersections - add to list
						if (noLineConflict)
							lines.add(newLine);						
					}					
				}
			}			
		}
		
		System.out.println("LINES");
		for (Line line : lines) {
			System.out.println(line.getCoords1()[0] + ", " + line.getCoords1()[1]);
			System.out.println(line.getCoords2()[0] + ", " + line.getCoords2()[1]);
			System.out.println();
		}

		return lines;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
