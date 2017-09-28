package main;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Boundary conditions:
 * - empty
 * - single
 * - beginning
 * - last
 * - middle
 * @author Public
 *
 * @param <E>
 */
public class LinkedList<E> implements Iterable<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;

	class Node<E> {
		Node<E> next;
		E data;
		
		public Node(E obj) {
			data = obj;
			next = null;
		}
	}
	
	class IteratorHelper implements Iterator<E> {
		Node<E> index;
		int counter = 0;
		
		public IteratorHelper() {
			index = head;
		}

		@Override
		public boolean hasNext() {
			if (counter < size)
				return true;
			else
				return false;
		}

		@Override
		public E next() {
			//Reached end
			if (!hasNext())
				throw new NoSuchElementException();
			
			E value = (E) index.data;
			
			index = index.next;
			counter++;
			
			return value;
		}
		
	}
	
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}
	
	
	
	/**
	 * Constructor.
	 * Initialises the data structure
	 */
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;		
	}
	
	/**
	 * Adds new object to the beginning of the data structure
	 * @param obj Object to add
	 */
	public void addFirst(E obj) {
		Node<E> newNode = new Node<E>(obj);
		
		//New node points to previously first node
		newNode.next = head;
		//Point head to new node, now first
		head = newNode;
		
		//Only 1 node
		if (head.next == null)
			tail = head;
		
		size++;
	}

	/** 
	 * Adds new object to the end of the data structure 
	 * @param Object to add
	 * */
	public void addLast(E obj) {
		//Empty
		if (head == null) {
			addFirst(obj);
			return;
		}
		
		Node<E> newNode = new Node<E>(obj);
		//Point last node to new node
		tail.next = newNode;
		//Point tail to new node, last node
		tail = newNode;
		
		size++;
	}
	
	/** Removes first node in the list */
	public void removeFirst() {
		//Empty
		if (head == null)
			return;
		
		head = head.next;
		size--;
	}
	
	public void removeLast() {
		Node<E> tmp = head;
		
		//Single node
		if (head == tail) {
			removeFirst();
			size--;
			return;
		}
		
		//Until no more nodes to search
		while (tmp != null) {
			//Points tail to node prior to end node
			if (tmp.next == tail) {
				tail = tmp;
				tail.next = null;
				tmp = null;
			}
			//Next node
			if (tmp != null)
				tmp = tmp.next;
		}
		size--;
	}
	
	public boolean remove(E obj) {		
		Node<E> tmp = head;
		boolean isRemoved = false;
		
		//Empty
		if (head == null)
			return false;		
		
		//Single Node or obj found at head
		if (((Comparable<E>)head.data).compareTo(obj) == 0) {
				removeFirst();
				return true;
		}
		//obj found at tail
		else if (((Comparable<E>)tail.data).compareTo(obj) == 0) {
			removeLast();
			return true;
		}
		if (head == tail)
			return false;
		
		
		//Search list
		while (!isRemoved) {
			//If obj is found
			if (((Comparable<E>)tmp.next.data).compareTo(obj) == 0) {
				tmp.next = tmp.next.next;
				isRemoved = true;
				size--;
			} else {
				//Not found, next node
				tmp = tmp.next;
				
				//If reached end
				if (tmp.next ==  null) 
					break;
			}		
		}
		
		return isRemoved;
	}

	public E peakFirst() {
		return head.data;
	}
	
	public E peakLast() {
		return tail.data;
	}
	
	
	
	/** Outputs the data structure in a string format */
	@Override
	public String toString() {
		//Empty
		if (head == null)
			return null;		
		
		String str = "";
		Node<E> tmp = head;
		
		while(tmp != null) {
			str += String.valueOf(tmp.data) + ", ";
			tmp = tmp.next;			
		}
		
		return str;
	}


	
	
}