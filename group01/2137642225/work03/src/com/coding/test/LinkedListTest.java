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
		linkedList.add(2);
		linkedList.remove(0, 1);
		assertEquals(0, linkedList.size());
		linkedList.add(5);
		linkedList.add(7);
		linkedList.add(8);
		linkedList.remove(0, 2);
		assertEquals(1, linkedList.size());
	}

	@Test
	public void testGetElements() {
		linkedList.add(11);
		linkedList.add(101);
		linkedList.add(201);
		linkedList.add(301);
		linkedList.add(401);
		linkedList.add(501);
		linkedList.add(601);
		linkedList.add(701);
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(6);
		assertEquals(4, list.size());
		int[] elements = linkedList.getElements(list);
		int[] elements2 = new int[]{101,301,401,601};
		assertArrayEquals(elements2, elements);
	}

	@Test
	public void testSubtract() {
		linkedList.add(11);
		linkedList.add(101);
		linkedList.add(201);
		linkedList.add(301);
		linkedList.add(401);
		linkedList.add(501);
		linkedList.add(601);
		linkedList.add(701);
		LinkedList list = new LinkedList();
		list.add(11);
		list.add(101);
		list.add(301);
		list.add(501);
		list.add(601);
		list.add(701);
		linkedList.subtract(list);
		assertEquals(2, linkedList.size());
		assertEquals(201, linkedList.get(0));
		assertEquals(401, linkedList.get(1));
	}

	@Test
	public void testRemoveDuplicateValues() {
		linkedList.add(11);
		linkedList.add(11);
		linkedList.add(101);
		linkedList.add(101);
		linkedList.add(101);
		linkedList.add(201);
		linkedList.add(301);
		linkedList.add(301);
		linkedList.add(401);
		linkedList.add(401);
		linkedList.add(401);
		linkedList.removeDuplicateValues();
		assertEquals(5, linkedList.size());
		assertEquals(11, linkedList.get(0));
		assertEquals(401, linkedList.get(4));
	}

	@Test
	public void testRemoveRange() {
		linkedList.add(11);
		linkedList.add(101);
		linkedList.add(201);
		linkedList.add(301);
		linkedList.add(401);
		linkedList.removeRange(10, 401);
		assertEquals(1, linkedList.size());
		linkedList.add(402);
		assertEquals(2, linkedList.size());
	}

	@Test
	public void testIntersection() {
		
	}
	
	@After
	public void after(){
		Iterator iterator = linkedList.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

}
