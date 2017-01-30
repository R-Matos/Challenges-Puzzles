import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;



public class FakeCoin {
	
	/**
	 * <h1>Reddit Challenge - Intermediate #277 - Fake Coins</h1>
	 * 
	 * <h3>Description</h3>
	 * <p>
	 * Their are some false golden coins, which are lighter then others, in the treasure chest. 
	 * The assistant has weighed the coins, but can not figure out which are false and which are not.<br/>
	 * <br/>
	 * Each coin is labelled with a letter, and is put on the scale in groups or by itself. 
	 * The input consist of the coins on the left side, the coins on the right side and the way the scale tipped. 
	 * This can be left, right or equal when the two sides weight the same.<br/>
	 * <br/>
	 * You must determine which coins are lighter then the others.
	 * It is possible that you can't determine this because you have not in enough info.
	 * And it is possible that the provided data has been inconsistent.<br/>
	 * <br/>
	 * You can assume that there is only 1 fake coin, if not, the data is inconsistent. 
	 * If your solution worked without this assumption, you can leave it like that.
	 * And all real coins weight the same, just like the fake coins. 
	 * But no real weight is necessary to complete the challenge
	 * </p>
	 * 
	 * <h3>Method</h3>
	 * <p>
	 * Each coin will have 3 possible marks. Normal, false & unsure.<br/>
	 * If mean't to mark unsure 
	 *
	 * 1. If scales equal<br/>
	 *  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	1.1 - If duplicate coin on either side<br/>
	 *   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	1.1.1 - If SO mark duplicate as unsure. Mark other coins as normal.<br/>
	 *    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 	1.1.2 - ELSE mark all normal.<br/>
	 * 2. If scales left<br/>
	 *   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	1.1 - Mark all coins on left side as normal<br/>
	 *    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	1.2 - Mark all unmarked coins on right side as unsure. If only normal coins jump to 7.<br/>
	 * 3. If scales right<br/>
	 *  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	1.1 - Mark all coins on right side as normal<br/>
	 *    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	1.2 - Mark all unmarked coins on left side as unsure. If only normal coins jump to 7.<br/>
	 * 4. Repeat steps 1-3 for each line of user input<br/>
	 * 5. If only 1 coin is marked unsure than that coin is false<br/>
	 * 6. If no unsure than no fake coins detected<br/>
	 * 7. If multiple unsure than data is inconsistent/non-sufficient<br/> 
	 * </p>
	 * 
	 * <h3>Links</h3>
	 * <p>
	 * Reddit - https://www.reddit.com/r/dailyprogrammer/comments/4utlaz/20160727_challenge_277_intermediate_fake_coins/
	 * </p>
	 * 
	 * @author RMatos
	 * @version 1.0
	 * @since 25-01-2017
	 */
	
	
	public static void main(String args[]) {
		
		Map<String, String> coins = new HashMap<String, String>();		//Contains coins and marks/states
		List<Input> userInputs;
		
		userInputs = getUserInput();									//Contains user input
		coins = analyseInput(userInputs, coins);						//Updates coins map for current user input
		analyseCoins(coins);
		
		
	}
	
	/**
	 * Outputs result to console then terminates program.
	 * 
	 * @param result Program result
	 * @param coin If fake coin present pass it, if not pass null
	 */
	private static void output(String result, String coin) {
		
		if (result.equalsIgnoreCase("INCONSISTENT")) {					//Inconsistent data
			System.out.println("Data is inconsistent/insubstantial!");
		} else if (result.equalsIgnoreCase("FOUND")) {					//Fake coin found
			System.out.println("Fake Coin: " + coin);
		} else if (result.equalsIgnoreCase("NONE")) {					//No fake coin present
			System.out.println("No fake coins detected!");
		}
		
		 System.exit(0);												//Program terminated
	}


	/**
	 * Goes through each user input, determines coins state & whether data is consistent.
	 * 
	 * @param userInputs List containing user input. Each entry is a scale state
	 * @param coins Map containing coins & their state. Will be populated here from data in userInputs
	 */
	private static Map<String, String> analyseInput(List<Input> userInputs, Map<String, String> coins) {
		
		//For each user input in the userInput list
		for (Input currentInput : userInputs) {
		    
			int leftSize = currentInput.getLeft().length();
			int rightSize = currentInput.getRight().length();
			boolean isUnsurePresent = false;																			//Used to determine if at least 1 coin is unsure when scales tilted left or right.
																											 //If not then all coins were already marked normal meaning data is inconsistent
			//Action depends on balance of scales
			if (currentInput.getBalance().equalsIgnoreCase("EQUAL")) {
				
				//Determines whether there is a duplicate coin on the left & right side
				for (int i = 0; i < leftSize; i++) {
					for (int j = 0; j < rightSize; j++) {

						String leftChar = String.valueOf(currentInput.getLeft().charAt(i));
						String rightChar = String.valueOf(currentInput.getRight().charAt(j));
						
						if (leftChar.equals(rightChar)) {													//If there's a duplicate coin
							if (coins.containsKey(leftChar) && coins.get(leftChar).equals("normal")) {			//If duplicated coin is already set and is normal	
								output("INCONSISTENT", null);
							} else if (!coins.containsKey(leftChar)) {											//Currently doesn't have coin
								coins.put(leftChar, "unsure");														//Adds coin as unsure
							}
						} else {																			//If no duplicate coin.
							coins.put(leftChar, "normal");														//Adds coins to list. Normal as scales is balanced.
							coins.put(rightChar, "normal");
						}
					}
				}
				
				isUnsurePresent = true;																			//Only used for left and right balance.
				
			} else if (currentInput.getBalance().equalsIgnoreCase("LEFT")) {
				
				//Marks all on left side as normal
				for (int i = 0; i < leftSize; i++) {
					String leftChar = String.valueOf(currentInput.getLeft().charAt(i));
					coins.put(leftChar, "normal");
				}
				
				//Marks any coins on right side unmarked as unsure. If no unsure present data is inconsistent.
				for (int i = 0; i < rightSize; i++) {
					String rightChar = String.valueOf(currentInput.getRight().charAt(i));
					
					if (!coins.containsKey(rightChar)) {														//If list doesn't contain key
						coins.put(rightChar, "unsure");
						isUnsurePresent = true;
					} else if (coins.containsKey(rightChar) && !coins.get(rightChar).equals("normal")) {		//If list contains key but its not marked normal.
						coins.put(rightChar, "unsure");
						isUnsurePresent = true;
					}
				}
				
			} else if (currentInput.getBalance().equalsIgnoreCase("RIGHT")) {
				
				//Marks all on right side as normal
				for (int i = 0; i < rightSize; i++) {
					String rightChar = String.valueOf(currentInput.getRight().charAt(i));
					coins.put(rightChar, "normal");
				}
				
				//Marks any coins on right side unmarked as unsure. If no unsure present data is inconsistent.
				for (int i = 0; i < leftSize; i++) {
					String leftChar = String.valueOf(currentInput.getLeft().charAt(i));
					
					if  (!coins.containsKey(leftChar)) {
						coins.put(leftChar, "unsure");
						isUnsurePresent = true;
					} else if (coins.containsKey(leftChar) && !coins.get(leftChar).equals("normal")) {
						coins.put(leftChar, "unsure");
						isUnsurePresent = true;
					}
				}
			}
			
			//Data consistency check
			if (!isUnsurePresent) {
				output("INCONSISTENT", null);
			}
		}
		
		return coins;
	}
	

	
	
	/**
	 * Goes through each coin, determines final results & calls output() depending on results.
	 * 
	 * @param coins Map of coins.
	 */
	private static void analyseCoins(Map<String, String> coins) {
		
		int unsureCounter = 0;
		String fakeCoin = null;
		
		//Cycles through each coin
		for (Entry<String, String> currentInput : coins.entrySet()) {
			
			//Determines whether a coin is marked unsure
			if (currentInput.getValue().equalsIgnoreCase("UNSURE")) {
				fakeCoin = currentInput.getKey();
				unsureCounter += 1;
			}
		}
		
		//Determines result
		if (unsureCounter == 0) {										//No fake coins
			output("NONE", null);		
		} else if (unsureCounter == 1) {								//Fake coin detected
			output("FOUND", fakeCoin);
		} else if (unsureCounter >= 2) {								//Inconsistent data
			output("INCONSISTENT", null);
		}
		
		
	}
	
	
	
	/**
	 * Obtains user input, validates & returns as a list
	 * 
	 * @return as Input. List containing user input
	 */
	private static List<Input> getUserInput() {
		
		Scanner scanner = new Scanner(System.in);		
		List<Input> userInputs = new ArrayList<Input>();	
		
		
		//Instructions for users
		System.out.println("Input data in the format below:");
		System.out.println("[coin(s) left side] [coin(s) right side] [whether scale tilts left/right/equal]\n");
		System.out.println("You can input as many as you'd like. Examples below:\n");
		System.out.println("Example 1: 'b x equal'");
		System.out.println("Example 2: 'abci efjk left'\n");
		System.out.println("To delete an erronus input type 'DELETE'");
		System.out.println("To begin computation type 'COMPUTE'");
		

		//Variables for input validation
		boolean validInput = false;
		String inputLeft = null;
		String inputRight = null;
		String inputBalance = null;
		

		//Stores user input if validate correctly.
		//Loops until user states is finished.
		inputLoop : while (true) {
			
			//Loop reset
			validInput = false;
			System.out.println("");
			
			
			//User inputs
			String[] input = scanner.nextLine().split(" ");					//Splits user input into an array between whitespace.					
			inputLeft = input[0];											//First input is ensured
			
			
			//Prevents crash. If user only inputs single command array will be out-of-bounds.
			if (input[0].equalsIgnoreCase("COMPUTE")) 
			{	
				//Check for empty list
				if (userInputs.isEmpty()) {
					System.out.println("Can't compute an empty list.");
				} else {
					scanner.close();
					return userInputs;											//Returns list
				}
				continue inputLoop;
			} 
			else if (input[0].equalsIgnoreCase("DELETE"))
			{				
				//Check for empty list
				if (userInputs.isEmpty()) {
					System.out.println("List is empty, nothing to delete");
				} else {
					System.out.println("DELETED: "								//Text containing deleted elements for user.
							+ userInputs.get(userInputs.size()-1).toString());
					userInputs.remove(userInputs.size()-1);						//Deletes previous entry
					
				}	
				continue inputLoop;
			} 
			else 
			{								
				//User inputs
				inputRight = input[1];
				inputBalance = input[2];	
				
				//Validates
				if (input[2].equalsIgnoreCase("LEFT") || input[2].equalsIgnoreCase("RIGHT") || input[2].equalsIgnoreCase("EQUAL")) {
					validInput = true;
				} 
			}
			
			
			//If data incorrectly prompts user to reenter. Correctly stores input in userInputs list.
			if (validInput == false) 
			{
				System.out.println("Incorrect input format. Please re-enter.");
			} 
			else 
			{
				userInputs.add(new Input(inputLeft, inputRight, inputBalance));
			}
			
			
		} //END OF INPUT LOOP
	} //END OF METHOD
}



