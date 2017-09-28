package main;

import static org.junit.Assert.assertEquals;

public class Main {
	
	public static void main (String args[]) {
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		int size = 10;
		
		linkedList.addFirst(1);
		linkedList.addFirst(2);
		linkedList.addFirst(3);
		linkedList.addFirst(4);
		linkedList.addFirst(5);
		
		for (Integer integer : linkedList) {
			System.out.println(integer);
		}

	}

}
