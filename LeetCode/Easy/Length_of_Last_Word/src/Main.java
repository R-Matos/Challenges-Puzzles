
public class Main {
	
	private static final String STR = "Hello World";
	
	
	public static void main(String args[]) {
		
		 if (STR.trim().equals("")) {
			 System.out.println("Last world length = " + 0);
			 System.exit(0);
		 }
		 
	    String[] array = STR.split(" ");
		int maxWordLength = 0;		
		
		int lastWordLength = array[array.length - 1].length();
		
		System.out.println("Last word length = " + lastWordLength);		
	}

}
