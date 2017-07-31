import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Roman To Integer</h1>
 * <p>Problem from LeetCode.</p>
 * 
 * <h3>Description</h3>
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * </p>
 * 
 * @since 30-07-2017 <br>
 * @version 1.0 <br>
 * @author RMatos <br>
 * @see <a href="https://leetcode.com/problems/roman-to-integer/description/">Problem Description</a>
 */

public class Main {
	
	//Anonymous class with an initialisation block. Double brace initialisation.
	private static final Map<String, Integer> NUMERAL_INDEX = Collections.unmodifiableMap(
		    new HashMap<String, Integer>() {{
		        put("I", 1);
		        put("V", 5);
		        put("X", 10);
		        put("L", 50);
		        put("C", 100);
		        put("D", 500);
		        put("M", 1000);
		        put("IV", 4);
		        put("IX", 9);
		        put("XL", 40);
		        put("XC", 90);
		        put("CD", 400);
		        put("CM", 900);
		    }});
	private static final String ROMAN_NUMERAL = "MCMLIV";
	
	
	
	
	public static void main(String args[]) {
		
		char[] array = ROMAN_NUMERAL.toCharArray();
		int length = ROMAN_NUMERAL.length();
		int integer = 0;
		
		
		for (int i = 0; i < length; i++) {
			
			//Checks for special case
			if (i+2 <= length) {
				String substring = ROMAN_NUMERAL.substring(i, i+2);
				
				//If special case is present
				if (NUMERAL_INDEX.containsKey(substring)) {
					integer += NUMERAL_INDEX.get(substring);
					i++;
					continue;					
				}
			}
			
			//Normal case
			String substring = ROMAN_NUMERAL.substring(i,i+1);
			integer += NUMERAL_INDEX.get(substring);				
		}	
		
		System.out.println("Roman Numeral "+ ROMAN_NUMERAL +" in decimal is: " + integer);
	}

}
