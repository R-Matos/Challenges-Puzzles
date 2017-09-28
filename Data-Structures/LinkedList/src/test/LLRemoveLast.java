package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.LinkedList;

public class LLRemoveLast {
	LinkedList<Integer> linkedList = new LinkedList<Integer>();

	@Test
	public void empty() {
		linkedList.removeLast();
		assertEquals(null, linkedList.toString());
	}

	@Test
	public void singleNode() {
		linkedList.addFirst(1);
		linkedList.removeLast();
		assertEquals(null, linkedList.toString());
	}

	@Test
	public void multipleNodes() {
		linkedList.addFirst(1);
		linkedList.addFirst(2);
		linkedList.addFirst(3);
		linkedList.addFirst(4);
		linkedList.addFirst(5);
		linkedList.removeLast();
		assertEquals("5, 4, 3, 2, ", linkedList.toString());
	}
	
	/** Should take O(n) */
	@Test
	public void timeTaken() {			
		for (int i = 0; i < 100000; i++) {
			linkedList.addLast(i);
		}
		
		long timeBefore = System.currentTimeMillis();
		linkedList.removeLast();
		long timeAfter = System.currentTimeMillis();
		
		long timeTaken = timeAfter - timeBefore;		
		assertEquals(true, timeTaken > 2 && timeTaken < 10);	
	}
	

}
