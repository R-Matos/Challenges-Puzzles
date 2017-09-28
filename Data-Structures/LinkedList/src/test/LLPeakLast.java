package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.LinkedList;

public class LLPeakLast {
	LinkedList<Integer> linkedList = new LinkedList<Integer>();
	
	
	@Test(expected = NullPointerException.class)
	public void empty() {		
		assertEquals(null, linkedList.peakLast());		
	}
	
	@Test
	public void singleNode() {		
		linkedList.addFirst(1);
		assertEquals(new Integer (1), linkedList.peakLast());		
	}
	
	@Test
	public void nultipleNodes() {		
		linkedList.addFirst(1);
		linkedList.addFirst(2);
		linkedList.addFirst(3);
		linkedList.addFirst(4);
		linkedList.addFirst(5);
		assertEquals(new Integer (1), linkedList.peakLast());	
	}
	
	/** Should take O(1) */
	@Test
	public void timeTaken() {			
		for (int i = 0; i < 100000; i++) {
			linkedList.addFirst(i);
		}
		
		long timeBefore = System.currentTimeMillis();
		linkedList.peakLast();
		long timeAfter = System.currentTimeMillis();
		
		long timeTaken = timeAfter - timeBefore;		
		assertEquals(true, timeTaken < 2);		
	}
	
	

}