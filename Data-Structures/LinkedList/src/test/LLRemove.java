package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.LinkedList;

public class LLRemove {
	LinkedList<Integer> linkedList = new LinkedList<Integer>();

	@Test
	public void empty() {
		assertEquals(false, linkedList.remove(1));
		assertEquals(null, linkedList.toString());
	}

	@Test
	public void singleNodeNotPresent() {
		linkedList.addFirst(2);
		assertEquals(false, linkedList.remove(1));
		assertEquals("2, ", linkedList.toString());
	}
	
	@Test
	public void singleNodePresent() {
		linkedList.addFirst(1);
		assertEquals(true, linkedList.remove(1));
		assertEquals(null, linkedList.toString());
	}

	@Test
	public void multipleNodesPresentMid() {
		linkedList.addFirst(1);
		linkedList.addFirst(2);
		linkedList.addFirst(3);
		linkedList.addFirst(4);
		linkedList.addFirst(5);
		
		assertEquals(true, linkedList.remove(3));
		assertEquals("5, 4, 2, 1, ", linkedList.toString());
	}

	@Test
	public void multipleNodesNotPresent() {
		linkedList.addFirst(1);
		linkedList.addFirst(2);
		linkedList.addFirst(3);
		linkedList.addFirst(4);
		linkedList.addFirst(5);
		
		assertEquals(false, linkedList.remove(6));
	}
	
	@Test
	public void multipleNodesPresentHead() {
		linkedList.addFirst(1);
		linkedList.addFirst(2);
		linkedList.addFirst(3);
		linkedList.addFirst(4);
		linkedList.addFirst(5);
		
		assertEquals(true, linkedList.remove(5));
		assertEquals("4, 3, 2, 1, ", linkedList.toString());
	}
	
	/** Should take O(n). */
	@Test
	public void timeTaken() {			
		for (int i = 0; i <= 1000000; i++) {
			linkedList.addLast(i);
		}
		
		long timeBefore = System.currentTimeMillis();
		linkedList.remove(999999);
		long timeAfter = System.currentTimeMillis();
		
		long timeTaken = timeAfter - timeBefore;		
		assertEquals(true, timeTaken > 2);	
	}

}
