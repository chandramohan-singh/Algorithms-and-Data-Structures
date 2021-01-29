package com.implementation.singleLinkedList;

import com.implementation.doubleLinkedList.Node;

public class SingleCircularLinkedList {
	private Node head;
	private Node tail;
	private int size;

	Node createSingleLinkedList(int value) {
		head = new Node();
		Node node = new Node();
		node.setValue(value);
		node.setNext(node);
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	public void insertInStartingOfLInkedList(int value) {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return;
		}
		Node node = new Node();
		node.setValue(value);
		node.setNext(head);
		head = node;
		tail.setNext(head);
		size++;
	}

	public void insertInLinkedList(int value, int location) {
		Node node = new Node();
		node.setValue(value);
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return;
		} else if (location == 0) {// insert at first position
			System.out.println("Inserting new node at location: " + location);
			node.setNext(head);
			head = node;
			tail.setNext(node);
			size++;
		} else if (location >= size) {// insert at last position
			if(location > size)
				System.out.println("Inserting new node at end of the Linked List as location : " + location + " does not exists.");
			else
				System.out.println("Inserting new node at location: " + location);
			tail.setNext(node);
			tail = node; // to keep track of last node
			tail.setNext(head); // update tail to circularly point head
			size++;
		} else {
			System.out.println("Inserting new node at location: " + location);
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {// loop till we reach specified node
				tempNode = tempNode.getNext();
				index++;
			} // insert new node after tempNode
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
			size++;
		}
	}

	public void insertInLastOfLInkedList(int value) {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return;
		}
		Node node = new Node();
		node.setValue(value);
		node.setNext(head);
		tail.setNext(node);
		size++;
	}

	// Print Linked List
	public void printLinkedList() {
		if (existsLinkedList()) {
			System.out.println("Printing Linked List.");
			Node tempNode = head;
			do {
				System.out.print(tempNode.getValue());
				if (tempNode.getNext() != head) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			} while (tempNode != head);
		} else {
			System.out.println("Linked List does not exists.");
		}
		System.out.println();
	}

	// Traverse Linked List
	public void traverseLinkedList() {
		if (existsLinkedList()) {
			Node tempNode = head;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.getValue());
				if (i != size - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
			System.out.println("\n");
		} else {
			System.out.println("\nLinked List does not exists !");
		}
	}
	
	public boolean isCircularLinkdedList() {
		if (!existsLinkedList()) {
			System.out.println("Linked List does not exists.");
			return false;
		} else {
			// Next of head 
		    Node node = head.getNext(); 
		    while (node != null && node != head) {
		    	node = node.getNext(); 
		    }
		    // If loop stopped because of circular 
		    // condition 
		    return (node == head); 
		}
	}

	// Search given value in Linked List
	boolean searchNode(int nodeValue) {
		if (existsLinkedList()) {
			Node tempNode = head;
			for (int i = 0; i < size; i++) {

				// System.out.print(tempNode.value);
				if (tempNode.getValue() == nodeValue) {
					System.out.print("Found the node at location: " + i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.print("Node not found!! ");

		return false;
	}

	public void deleteFirstNode() {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return;
		} else {
			head = head.getNext();
			tail.setNext(head);
			setSize(getSize() - 1);
			if (getSize() == 0) { // if there are no more nodes in this list
				tail = null;
			}
		}
	}

	public void deletionOfNode(int location) {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return;
		} else if (location == 0) { // If location is first node
			head = head.getNext();
			tail.setNext(head);
			setSize(getSize() - 1);
			if (getSize() == 0) { // if there are no more nodes in this list
				tail = null;
			}
		} else if (location >= getSize()) { // If location is last node
			Node tempNode = head;
			for (int i = 0; i < size - 1; i++) {
				tempNode = tempNode.getNext(); // tempNode points to 2nd last node
			}
			if (tempNode == head) { // if this is the only element in the list
				tail = head = null;
				setSize(getSize() - 1);
				return;
			}
			tempNode.setNext(head);
			tail = tempNode;
			setSize(getSize() - 1);

		} else { // if any inside node is to be deleted
			Node tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the location
			}
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			setSize(getSize() - 1);
		}

	}

	public void deleteLastNode() {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return;
		} else {
			Node tempNode = head;
			while (tempNode.getNext() != tail) {
				tempNode = tempNode.getNext();
			}
			if (tempNode == head) { // if this is the only element in the list
				tail = head = null;
				setSize(getSize() - 1);
				return;
			}
			tempNode.setNext(head); // delete the required node
			tail = tempNode;
			setSize(getSize() - 1);
		}
	}

	// Delete linked list
	public void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List.");
		head = null;
		if (tail == null) {
			System.out.println("Linked List is already deleted, nothing to delete.");
			return;
		} else {
			tail.setNext(null);
			tail = null;
			System.out.println("Linked List deleted successfully.");
		}
	}

	// If head is not null return true otherwise return false
	public boolean existsLinkedList() {
		if (head != null) {
			return true;
		}
		return false;
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

	public void setSize(int size) {
		this.size = size;
	}
}
