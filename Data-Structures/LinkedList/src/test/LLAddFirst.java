package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.LinkedList;

public class LLAddFirst {
	LinkedList<Integer> linkedList = new LinkedList<Integer>();
	
	
	@Test
	public void empty() {		
		linkedList.addFirst(1);
		assertEquals("1, ", linkedList.toString());		
	}
	
	@Test
	public void singleNode() {		
		linkedList.addFirst(1);
		linkedList.addFirst(2);
		assertEquals("2, 1, ", linkedList.toString());		
	}
	
	@Test
	public void nultipleNodes() {		
		linkedList.addFirst(1);
		linkedList.addFirst(2);
		linkedList.addFirst(3);
		linkedList.addFirst(4);
		linkedList.addFirst(5);
		assertEquals("5, 4, 3, 2, 1, ", linkedList.toString());		
	}
	
	/** Should take O(1) */
	@Test
	public void timeTaken() {			
		for (int i = 0; i < 100000; i++) {
			linkedList.addFirst(i);
		}
		
		long timeBefore = System.currentTimeMillis();
		linkedList.addFirst(1);
		long timeAfter = System.currentTimeMillis();
		
		long timeTaken = timeAfter - timeBefore;		
		assertEquals(true, timeTaken < 2);		
	}
	
	

}
