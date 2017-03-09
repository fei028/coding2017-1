package com.coding.mybasic;

public class LinkedList implements List {
	
	private Node head;
	private Node last;
	private int size;
	
	public LinkedList() {
	}
	
	@Override
	public void add(Object element) {
		if(head == null){
			addHead(element);
		}else{
			addLast(element);
		}
	}
	
	@Override
	public void add(int index, Object element) {
		if(index == size){
			add(element);
			return;
		}
		
		if(index == 0){
			addFirst(element);
			return;
		}
		checkIndex(index);
		insertElement(index - 1,element);
	}
	
	
	@Override
	public Object get(int index) {
		checkIndex(index);
		Node node = getNodeByIndex(index);
		return node != null ? node.data : null;
	}

	@Override
	public Object remove(int index) {
		
		checkIndex(index);
		Object element = null;
		if(index == 0){
			element = removeFirst();
		}
		else if(index == (size - 1)){
			element = removeLast();
		}
		else {
			element = removeMiddle(index);
		}
		return element;
	}
	
	
	@Override
	public int size() {
		return size;
	}
	

	@Override
	public Iterator iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator{
		private Node node = head;
		int i = 0;
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public Object next() {
			checkIndex(i);
			Object element = node.data;
			node = node.next;
			i++;
			return element;
		}
		
	}

	public void addFirst(Object o){
		Node node = new Node();
		node.data = o;
		node.next = head.next;
		head = node;
		size++;
	}
	public void addLast(Object o){
		Node node = new Node();
		node.data = o;
		node.next = null;
		last.next = node;
		last = node;
		size++;
	}
	public Object removeFirst(){
		return removeFirstNode();
	}
	public Object removeLast(){
		return removeLastNode();
	}
	
	
	/**
	 * 把该链表逆置
	 * 例如链表为 3->7->10 , 逆置后变为  10->7->3
	 */
	public  void reverse(){
		reverse(head,null);
	}
	

	/**
	 * 删除一个单链表的前半部分
	 * 例如：list = 2->5->7->8 , 删除以后的值为 7->8
	 * 如果list = 2->5->7->8->10 ,删除以后的值为7,8,10

	 */
	public  void removeFirstHalf(){
		if(size() <= 1){
			return;
		}
		int index = size() >> 1;
		Node node = getNodeByIndex(index - 1);
		head = node.next;
		node.next = null;
		size -= index;
	}
	
	/**
	 * 从第i个元素开始， 删除length 个元素 ， 注意i从0开始
	 * @param i
	 * @param length
	 */
	public void remove(int i, int length){
		
		checkIndex(i);
		if(length <= 0){
			// 忽略操作
			return;
		}
		int endIndex = i + length - 1;
		removeNodes(i,endIndex);
		// 更新长度
		size -= length;
	}
	

	/**
	 * 假定当前链表和list均包含已升序排列的整数
	 * 从当前链表中取出那些list所指定的元素
	 * 例如当前链表 = 11->101->201->301->401->501->601->701
	 * listB = 1->3->4->6
	 * 返回的结果应该是[101,301,401,601]  
	 * @param list
	 */
	public static int[] getElements(LinkedList list){
		return null;
	}
	
	/**
	 * 已知链表中的元素以值递增有序排列，并以单链表作存储结构。
	 * 从当前链表中中删除在list中出现的元素 

	 * @param list
	 */
	
	public  void subtract(LinkedList list){
		
	}
	
	/**
	 * 已知当前链表中的元素以值递增有序排列，并以单链表作存储结构。
	 * 删除表中所有值相同的多余元素（使得操作后的线性表中所有元素的值均不相同）
	 */
	public  void removeDuplicateValues(){
		
	}
	
	/**
	 * 已知链表中的元素以值递增有序排列，并以单链表作存储结构。
	 * 试写一高效的算法，删除表中所有值大于min且小于max的元素（若表中存在这样的元素）
	 * @param min
	 * @param max
	 */
	public  void removeRange(int min, int max){
		
	}
	
	/**
	 * 假设当前链表和参数list指定的链表均以元素依值递增有序排列（同一表中的元素值各不相同）
	 * 现要求生成新链表C，其元素为当前链表和list中元素的交集，且表C中的元素有依值递增有序排列
	 * @param list
	 */
	public  LinkedList intersection( LinkedList list){
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private Object removeMiddle(int index) {
		Node temp = getNodeByIndex(index - 1);
		Node removeNode = temp.next;
		Object element = removeNode.data;
		temp.next = removeNode.next;
		removeNode = null;
		size--;
		return element;
	}

	/**
	 * 检查index index >=0 且  < size
	 * @param index 
	 * @throws Exception
	 */
	private void checkIndex(int index) {
		if(index < 0){
			throw new RuntimeException("index 必须大于0");
		}
		// 越界
		if(index >= size){
			throw new RuntimeException("index 必须小于size:" + size);
		}
	}
	
	/**
	 * 添加head
	 * @param element
	 */
	private void addHead(Object element) {
		head = new Node();
		head.data = element;
		head.next = null;
		last = head;
		size++;
	}
	/**
	 * 插入序号在0-size之间的元素,不包含0和size位置 
	 * @param index
	 * @param element
	 */
	private void insertElement(int index, Object element) {
		
		Node temp = getNodeByIndex(index);
		if(temp != null){
			Node node = new Node();
			node.data = element;
			node.next = temp.next;
			temp.next = node;
		}
		size++;
	}
	/**
	 * 获取下标为index的元素
	 * @param index
	 * @return
	 */
	private Node getNodeByIndex(int index) {
		Node temp = head;
		int i = 0;
		
		while(i < size){
			if(i == index){
				return temp;
			}
			temp = temp.next;
			i++;
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param startNode
	 * @param size
	 * @return
	 */
	private Node getNode(Node startNode,int size) {
		Node temp = startNode;
		int i = 0;
		
		while(i < size){
			if(i == size){
				return temp;
			}
			temp = temp.next;
			i++;
		}
		
		return null;
	}
	/**
	 * 移除最后一个元素
	 * @return
	 */
	private Object removeLastNode() {
		Node node = getNodeByIndex(size - 2);
		Node lastNode = node.next;
		Object element = lastNode.data;
		lastNode = null;
		last = node;
		size--;
		return element;
	}
	/**
	 * 移除第一个元素
	 * @return
	 */
	private Object removeFirstNode() {
		Node node = head.next;
		Object element = head.data;
		head = null;
		head = node;
		size--;
		return element;
	}
	
	/**
	 * 逆置链表 curNode.next = nextNode
	 * @param curNode 当前加点
	 * @param nextNode curNode节点的下一个节点
	 */
	private void reverse(Node curNode, Node nextNode) {
		
		if(curNode != null){
			reverse(curNode.next, curNode);
		} else {// 到了链表末尾
			return;
		}
		// 两个相邻节点之间 前后关系逆置 next反转
		curNode.next = nextNode;
		// next更改完毕 交换头尾节点
		if(nextNode == null){
			swapHeadTailNode();
		}
	}
	
	/**
	 * 交换头尾节点
	 */
	private void swapHeadTailNode() {
		Node temp = head;
		head = last;
		last = temp;
	}
	
	/**
	 * 移除从下标为startIndex到下标为endIndex的节点
	 * @param startIndex
	 * @param endIndex
	 */
	private void removeNodes(int startIndex, int endIndex) {
		if(startIndex == 0){
			// 全部删除
			if(endIndex == (size() - 1)){
				head = null;
				last = head;
			} else {
				Node node = getNodeByIndex(endIndex);
				head = node.next;
				node = null;
			}
		} else {
			// 删除到尾部
			if(endIndex == (size() - 1)){
				// 获取删除的第一个节点的前一个节点 变为尾
				Node newLast = getNodeByIndex(startIndex - 1);
				newLast.next = null;
				last = newLast;
			} else {
				Node node = getNodeByIndex(startIndex - 1);
				Node node2 = getNode(node, endIndex + 1 - startIndex);
				node.next = node2;
			}
		}
	}
	
	private static class Node{
		Object data;
		Node next;
		public Node() {
		}
		@SuppressWarnings("unused")
		public Node(Object data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
	}
}
