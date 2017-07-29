
/**
 * <h1>Don't Get Rooked</h1>
 * <p>Challenge from ACM ICPC Mid-Central USA 1998.</p>
 * 
 * <h3>TLDR Description</h3>
 * <p>
 * Dots can see vertically and horizontally but not diagonally. <br>
 * Dots can't see over walls. <br>
 * Find out the maximum number of possible dots on the board without them seeing each other. 
 * </p>
 * 
 * <h3>Method</h3>
 * <p>
 * 	<ol type ="1">
 * 		<li>Places dots around walls (horizontally and vertically, not diagonally)</li>
 * 		<li>Remove any conflicts (dots see each other)</li>
 * 		<li>Add additional dots on board where no conflicts arise</li>
 * 		<li>Count number of dots present, this is the maximum possible number</li>
 * 	<ol>
 * </p>
 * 
 * @since 29-07-2017
 * @version 1.0
 * @author RMatos
 * @see <a href="http://acm.hit.edu.cn/hoj/problem/view?id=1086">Challenge Description</a> *
 */

public class Main {

	//'X' are walls, '.' is empty space. 'O' are dots.
	private static final String[][] BOARD = {
			{ ".", "X", ".", "."},
			{ ".", ".", ".", "."}, 
			{ "X", "X", ".", "."}, 
			{ ".", ".", ".", "."} };	
	private static final int BOARD_SIZE = 4;
	
	
	public static void main(String args[]) {
		
		System.out.println("Original Board:"); boardToString();
		
		dotsAroundWalls();		
		System.out.println("Dots surronding walls:"); boardToString();
		
		resolveConflicts();		
		System.out.println("Removed conflicts:"); boardToString();	
		
		addDots();		
		System.out.println("Added dots where possible:"); boardToString();

		int numberOfDots = countDots();
		System.out.println("Maximum number of dots with above board arrangement is: " + numberOfDots);		
	}
	
	
			
	/**
	 * Places dots surrounding walls. Horizontally and vertically not diagonally.
	 */
	private static void dotsAroundWalls() {
		
		//Loops through each board element
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				
				if (BOARD[i][j].equals("X")) {
					surroundWall(i, j);
				}
			}
		}	
	}
	
	
	/**
	 * Surrounds a single wall with dots.  Horizontally and vertically not diagonally.
	 * @param i x position of wall
	 * @param j y position of wall
	 */
	private static void surroundWall(int i , int j) {
		
		//Below ensures not on edge and element not occupied
		
		//Up
		if (i != 0 && BOARD[i-1][j].equals("."))
			BOARD[i-1][j] = "O";
		
		//Down
		if (i != BOARD_SIZE-1 && BOARD[i+1][j].equals("."))
			BOARD[i+1][j] = "O";
		
		//Left
		if (j != 0 && BOARD[i][j-1].equals("."))
			BOARD[i][j-1] = "O";
				
		//Right
		if (j != BOARD_SIZE-1 && BOARD[i][j+1].equals("."))
			BOARD[i][j+1] = "O";
		
	}

	
	/**
	 * Removes 'O' conflicts. Can't have more than one 'O' in a row or column unless a wall is in the way.
	 */
	private static void resolveConflicts() {
		
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				
				if (BOARD[i][j].equals("O")) {
					removeDotConflicts(i, j);
				}
			}
		}		
	}
	
	
	/**
	 * Removes 'O' conflicts so that only one 'O' is in a row and column unless a wall is in the way
	 * @param x x position of dot
	 * @param y y position of dot
	 */
	private static void removeDotConflicts(int x, int y) {
		
		//Below ensures not on edge and element is a dot
		
		// Up
		if (x > 0) {
			for (int i = x - 1; i >= 0; i--) {
				if (BOARD[i][y].equals("X"))
					break;
				else if (BOARD[i][y].equals("O"))
					BOARD[i][y] = ".";
			}
		}

		// Down
		if (x < BOARD_SIZE) {
			for (int i = x + 1; i < BOARD_SIZE; i++) {
				if (BOARD[i][y].equals("X"))
					break;
				else if (BOARD[i][y].equals("O"))
					BOARD[i][y] = ".";
			}
		}

		// Left
		if (y > 0) {
			for (int j = y - 1; j >= 0; j--) {
				if (BOARD[x][j].equals("X"))
					break;
				else if (BOARD[x][j].equals("O"))
					BOARD[x][j] = ".";
			}
		}

		// Right
		if (y < BOARD_SIZE) {
			for (int j = y + 1; j < BOARD_SIZE; j++) {
				if (BOARD[x][j].equals("X"))
					break;
				else if (BOARD[x][j].equals("O"))
					BOARD[x][j] = ".";
			}
		}
		
	}
	
	
	/**
	 * Adds dots to any element that doesn't conflict and has a '.' (empty)
	 * 
	 */
	private static void addDots() {
		
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				
				//If empty
				if (BOARD[i][j].equals(".")) {
					
					//If no conflicts
					if (!checkConflicts(i,j))
						BOARD[i][j] = "O";
				}
			}
		}	
	}
	
	
	/**
	 * Checks for conflicts and returns boolean based on result
	 * @param x x position of empty spot
	 * @param y y position of empty spot
	 * @return boolean; true if conflict present, false if dot can be placed in empty spot with no conflicts
	 */
	private static boolean checkConflicts(int x, int y) {

		// Up
		if (x > 0) {
			for (int i = x - 1; i >= 0; i--) {
				if (BOARD[i][y].equals("X"))
					break;
				else if (BOARD[i][y].equals("O"))
					return true;
			}
		}

		// Down
		if (x < BOARD_SIZE) {
			for (int i = x + 1; i < BOARD_SIZE; i++) {
				if (BOARD[i][y].equals("X"))
					break;
				else if (BOARD[i][y].equals("O"))
					return true;
			}
		}

		// Left
		if (y > 0) {
			for (int j = y - 1; j >= 0; j--) {
				if (BOARD[x][j].equals("X"))
					break;
				else if (BOARD[x][j].equals("O"))
					return true;
			}
		}

		// Right
		if (y < BOARD_SIZE) {
			for (int j = y + 1; j < BOARD_SIZE; j++) {
				if (BOARD[x][j].equals("X"))
					break;
				else if (BOARD[x][j].equals("O"))
					return true;
			}
		}
		
		return false;
	}

	/**
	 * Counts how many dots are present on the board
	 * @return int containing number of dot
	 */
	private static int countDots() {		
		int counter = 0;
		
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				
				//If empty
				if (BOARD[i][j].equals("O")) 
					counter++;
				
			}
		}	
		
		return counter;
	}
	
	/**
	 * Outputs current board state to console
	 */
	private static void boardToString() {
		
		switch (BOARD_SIZE) {
		case 1 :
			System.out.println("[" + BOARD[0][0] + "]");
			System.out.println();
			break;
		case 2 :
			System.out.println("[" + BOARD[0][0] + "]" + "[" + BOARD[0][1] + "]");
			System.out.println("[" + BOARD[1][0] + "]" + "[" + BOARD[1][1] + "]");
			System.out.println();
			break;
		case 3 :
			System.out.println("[" + BOARD[0][0] + "]" + "[" + BOARD[0][1] + "]" + "[" + BOARD[0][2] + "]");
			System.out.println("[" + BOARD[1][0] + "]" + "[" + BOARD[1][1] + "]" + "[" + BOARD[1][2] + "]");
			System.out.println("[" + BOARD[2][0] + "]" + "[" + BOARD[2][1] + "]" + "[" + BOARD[2][2] + "]");
			System.out.println();
			break;
		case 4 : 
			System.out.println("[" + BOARD[0][0] + "]" + "[" + BOARD[0][1] + "]" + "[" + BOARD[0][2] + "]" + "[" + BOARD[0][3] + "]");
			System.out.println("[" + BOARD[1][0] + "]" + "[" + BOARD[1][1] + "]" + "[" + BOARD[1][2] + "]" + "[" + BOARD[1][3] + "]");
			System.out.println("[" + BOARD[2][0] + "]" + "[" + BOARD[2][1] + "]" + "[" + BOARD[2][2] + "]" + "[" + BOARD[2][3] + "]");
			System.out.println("[" + BOARD[3][0] + "]" + "[" + BOARD[3][1] + "]" + "[" + BOARD[3][2] + "]" + "[" + BOARD[3][3] + "]");
			System.out.println();
			break;
		}
			
	}			
			
}
