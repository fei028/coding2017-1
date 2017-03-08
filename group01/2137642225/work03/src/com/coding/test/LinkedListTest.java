package com.coding.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coding.mybasic.Iterator;
import com.coding.mybasic.LinkedList;

public class LinkedListTest {

	LinkedList linkedList = null;
	
	@Before
	public void setUp() throws Exception {
		linkedList = new LinkedList();
	}

	@Test
	public void testReverse() {
		linkedList.add(3);
		linkedList.add(7);
		linkedList.add(10);
		linkedList.reverse();
		assertEquals(3, linkedList.size());
		assertEquals(linkedList.get(0), 10);
		assertEquals(linkedList.get(1), 7);
		assertEquals(linkedList.get(2), 3);
		linkedList.add(2);
		assertEquals(linkedList.get(3), 2);
		assertEquals(4, linkedList.size());
	}

	@Test
	public void testRemoveFirstHalf() {
		linkedList.add(2);
		linkedList.add(5);
		linkedList.add(7);
		linkedList.add(8);
		linkedList.removeFirstHalf();
		assertEquals(2, linkedList.size());
		assertEquals(linkedList.get(0), 7);
		assertEquals(linkedList.get(1), 8);
	}

	@Test
	public void testRemoveIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetElements() {
		fail("Not yet implemented");
	}

	@Test
	public void testSubtract() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveDuplicateValues() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveRange() {
		fail("Not yet implemented");
	}

	@Test
	public void testIntersection() {
		fail("Not yet implemented");
	}
	
	@After
	public void after(){
		Iterator iterator = linkedList.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

}
