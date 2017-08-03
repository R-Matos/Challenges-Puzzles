
public class Term {
	
	private int number;
	private int occurances;
	
		
	public Term(int termNumber) {
		this.number = termNumber;
		this.occurances = 1;
	}
	
	
	public int getNumber() {
		return number;
	}
	public int getOccurances() {
		return occurances;
	}
	
	
	public void increment() {
		this.occurances++;
	}
	
	@Override
	public String toString() {
		return String.valueOf(occurances) + "-" + String.valueOf(number) + "'s, ";
	}
	
}
