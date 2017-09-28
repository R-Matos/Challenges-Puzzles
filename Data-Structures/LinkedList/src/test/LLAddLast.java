package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.LinkedList;

public class LLAddLast {
	LinkedList<Integer> linkedList = new LinkedList<Integer>();
	
	
	@Test
	public void empty() {		
		linkedList.addLast(1);
		assertEquals("1, ", linkedList.toString());		
	}
	
	@Test
	public void singleNode() {		
		linkedList.addLast(1);
		linkedList.addLast(2);
		assertEquals("1, 2, ", linkedList.toString());		
	}
	
	@Test
	public void multipleNodes() {		
		linkedList.addLast(1);
		linkedList.addLast(2);		
		linkedList.addLast(3);
		linkedList.addLast(4);		
		linkedList.addLast(5);
		linkedList.addLast(6);
		assertEquals("1, 2, 3, 4, 5, 6, ", linkedList.toString());		
	}
	
	/** Should take O(1) */
	@Test
	public void timeTaken() {			
		for (int i = 0; i < 100000; i++) {
			linkedList.addLast(i);
		}
		
		long timeBefore = System.currentTimeMillis();
		linkedList.addLast(1);
		long timeAfter = System.currentTimeMillis();
		
		long timeTaken = timeAfter - timeBefore;		
		assertEquals(true, timeTaken < 2);		
	}

}
