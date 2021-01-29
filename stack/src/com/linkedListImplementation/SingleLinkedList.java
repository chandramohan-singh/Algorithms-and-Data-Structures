package com.linkedListImplementation;

/**
 * 
 * @author Chandra Mohan Singh
 *
 */
public class SingleLinkedList {
	private Node head;
	private Node tail;
	private int size;

	// Create Single LinkedList
	public Node createSingleLinkedList(int value) {
		head = new Node();
		Node node = new Node();
		node.setValue(value);
		node.setNext(null);
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	// Insert a value in the starting of the Linked List
	public void insertAtStartInLinkedList(int value) {
		Node node = new Node();
		node.setValue(value);
		if (!existsLinkedList()) {
			System.out.println("Linked list does not exist.");
			return;
		} else { // insert at first
			node.setNext(head);
			head = node;
		}
		size++;
	}

	// Delete a value in the starting of the Linked List
	public void deleteFirstNode() {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return;
		} else {
			head = head.getNext();
			size--;
			if (size == 0) { // if there are no more nodes in this list
				tail = null;
			}
		}
	}

	// If head is not null return true otherwise return false
	public boolean existsLinkedList() {
		return head != null;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

}
