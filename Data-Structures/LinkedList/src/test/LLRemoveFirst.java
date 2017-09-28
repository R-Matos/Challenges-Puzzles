package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.LinkedList;

public class LLRemoveFirst {
	LinkedList<Integer> linkedList = new LinkedList<Integer>();

	@Test
	public void empty() {
		linkedList.removeFirst();
		assertEquals(null, linkedList.toString());
	}

	@Test
	public void singleNode() {
		linkedList.addFirst(1);
		linkedList.removeFirst();
		assertEquals(null, linkedList.toString());
	}

	@Test
	public void multipleNodes() {
		linkedList.addFirst(1);
		linkedList.addFirst(2);
		linkedList.addFirst(3);
		linkedList.addFirst(4);
		linkedList.addFirst(5);
		linkedList.removeFirst();
		assertEquals("4, 3, 2, 1, ", linkedList.toString());
	}
	
	/** Should take O(1) */
	@Test
	public void timeTaken() {			
		for (int i = 0; i < 100000; i++) {
			linkedList.addLast(i);
		}
		
		long timeBefore = System.currentTimeMillis();
		linkedList.removeFirst();
		long timeAfter = System.currentTimeMillis();
		
		long timeTaken = timeAfter - timeBefore;		
		assertEquals(true, timeTaken < 2);		
	}
	

}
