import java.util.LinkedList;

/**
 * <h1>Valid Parentheses Prefix</h1>
 * <p>Problem from LeetCode.</p>
 * 
 * <h3>Description</h3>
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. <br>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * </p>
 * 
 * <h3>Note</h3>
 * <p>
 * Used LinkedList as FIFO stack
 * </p>
 * 
 * @since 31-07-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://leetcode.com/problems/valid-parentheses/description/">Problem Description</a>
 */

public class Main {
	
	private enum Bracket {
	    NORMAL,
	    SQUARE,
	    BRACE;
	}
	private enum BracketType {
		OPEN,
		CLOSED;
	}
	
	private static final String STR = "()[]{}";
	
	
	public static void main(String args[]) {
		int length = STR.length();
		LinkedList<Bracket> brackets = null;
		LinkedList<BracketType> bracketTypes = null;
		
		for (int i = 0; i < length; i++) {
			if (length >= i+1) {
				String substring = STR.substring(i, i+1);
				
				//If first term
				if (brackets == null) {
					brackets = new LinkedList<Bracket>();
					bracketTypes = new LinkedList<BracketType>();
					brackets.addFirst(getBracket(substring));
					bracketTypes.addFirst(getBracketType(substring));
					
					//First bracket is closed
					if (bracketTypes.peekFirst().equals(BracketType.CLOSED)) {
						System.out.println("false");
						System.exit(0);
					}
				} else {
					//If stack is empty
					if (brackets.isEmpty()) 
					{
						//Add to stack
						brackets.addFirst(getBracket(substring));
						bracketTypes.addFirst(getBracketType(substring));
					} 
					//If last bracket is equal to current
					else if (brackets.peekFirst().equals(getBracket(substring))) 
					{
						//If opposite bracket type (e.g. if open then closed)
						if (!bracketTypes.peekFirst().equals(getBracketType(substring))) {
							//Pop off stack
							brackets.removeFirst();
							bracketTypes.removeFirst();
						} else {
							//Add to stack
							brackets.addFirst(getBracket(substring));
							bracketTypes.addFirst(getBracketType(substring));
						}
					} 
					else 
					{
						//Add to stack
						brackets.addFirst(getBracket(substring));
						bracketTypes.addFirst(getBracketType(substring));
					}
				}						
			}			
		}
		
		if (brackets.isEmpty()) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		
		
	}
	
	
	private static Bracket getBracket(String str) {
		
		if (str.equals("(") || str.equals(")")) 
		{
			return Bracket.NORMAL;
		} 
		else if (str.equals("[") || str.equals("]")) 
		{
			return Bracket.SQUARE;
		}
		else if (str.equals("{") || str.equals("}")) 
		{
			return Bracket.BRACE;
		} else {
			return null;
		}
	}
	
	
	private static BracketType getBracketType(String str) {
		
		if (str.equals("(") || str.equals("[") || str.equals("{"))
		{
			return BracketType.OPEN;
		} 
		else if (str.equals(")") || str.equals("]") || str.equals("}")) 
		{
			return BracketType.CLOSED;
		}
		else
		{
			return null;
		}		
	}	
	
}
