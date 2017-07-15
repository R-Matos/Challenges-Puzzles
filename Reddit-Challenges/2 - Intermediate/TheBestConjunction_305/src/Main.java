import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <h1>Reddit Challenge - Intermediate #305 - The Best Conjunction</h1>
 * 
 * <h3>Description</h3>
 * 
 * <p>
 * Your job is to find the best conjunction—that is, find the word with the most sub-words inside of 
 * it given a list of English words. Some example include:
 * </p>
 * <ul> - Something (3 words: So, me, thing)</ul>
 * <ul> - Awesomeness (3 words: awe, some, ness) </ul>
 * 
 * <h3>Bonus</h3>
 * 
 * <p>
 * Each sub-word must include the last letter of the previous subword. 
 * For example "counterrevolutionary" would become "count, terre, evolution, nary"
 * </p>
 * <p>
 * Instead of simply the last letter, allow any number of letters to be shared between words 
 * (e.g. consciencestricken => conscience, sciences, stricken
 * </p>
 * 
 * @author RMatos
 * @version 1.0
 * @since 15-07-2017
 */

public class Main {
	
	final static File file = new File("wordlist.txt");
	final static String str = "hello world";
	
	
	public static void main(String args[]) {
		
		ArrayList<String> wordCombinations = new ArrayList<String>();
		
		int length = str.length();
		
		//Goes through every possible combination 
		for (int i = 0; i <= length; i++) {
			for (int j = 1; j <= length; j++) {
				
				//Prevents negative substring
				if (j > i) {
					String substring = str.substring(i, j);
					boolean isWord = checkWord(substring);
					
					if (isWord)
						wordCombinations.add(substring);		
				}					
			}
		}
		
		System.out.println(wordCombinations);		
	}
	
	
	private static boolean checkWord(String strToCheck) {
		
		try {
	      //Use buffering, reading one line at a time
	      BufferedReader input =  new BufferedReader(new FileReader(file));
	      try {
	        String line = null;
	        
	        /* readLine:
	        * returns the content of a line MINUS the newline.
	        * returns null at end of the stream.
	        * returns an empty String if two newlines appear in a row.
	        */
	        while (( line = input.readLine()) != null){
	        	if (line.toLowerCase().equals(strToCheck.toLowerCase()))
	        		return true;
	        }
	      }
	      finally 
	      {
	        input.close();
	      }
	    }
	    catch (IOException ex)
	    {
	      ex.printStackTrace();
	    }
	    
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}