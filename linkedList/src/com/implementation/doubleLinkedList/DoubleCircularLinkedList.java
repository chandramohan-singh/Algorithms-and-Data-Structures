package com.implementation.doubleLinkedList;

public class DoubleCircularLinkedList {
	private Node head;
	private Node tail;
	private int size;

	Node createDoubleLinkedList(int nodeValue) {
		head = new Node();
		Node node = new Node();
		node.setValue(nodeValue);
		node.setNext(node);
		node.setPrev(node);
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	public void insertAtStartOfLinkedList(int value) {
		if (!existsLinkedList()) {
			System.out.println("The Linked List does not exits.");
		} else {
			Node node = new Node();
			node.setValue(value);
			node.setNext(head);
			node.setPrev(tail);
			head.setPrev(node);
			tail.setNext(head);
			head = node;
			size++;
		}
	}

	public void insertInLinkedList(int nodeValue, int location) {
		Node node = new Node();
		node.setValue(nodeValue);
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exists.");
			return;
		} else if (location == 0) {// insert at first position
			node.setNext(head);
			node.setPrev(tail);
			head.setPrev(node);
			tail.setNext(node);
			head = node;
		} else if (location >= size) { // insert at last position
			node.setNext(head);
			node.setPrev(tail);
			head.setPrev(node);
			tail.setNext(node);
			tail = node;
		} else {// insert at specified location
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {// loop till we reach specified node
				tempNode = tempNode.getNext();
				index++;
			}
			node.setPrev(tempNode);
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
			node.getNext().setPrev(node);
		}
		size++;
	}

	public void insertAtEndOfLinkedList(int value) {
		if (!existsLinkedList()) {
			System.out.println("The Linked List does not exits.");
		} else {
			Node node = new Node();
			node.setValue(value);
			node.setNext(head);
			node.setPrev(tail);
			head.setPrev(node);
			tail.setNext(node);
			tail = node;
			size++;
		}
	}

	// Printing Linked List
	public void printLinkedList() {
		if (existsLinkedList()) {
			Node tempNode = head;
			do {
				System.out.print(tempNode.getValue());
				if (tempNode.getNext() != head) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			} while (tempNode != head);
		} else {
			System.out.println("Linked List does not exists !");
		}
		System.out.println();
	}

	// Printing Linked List
	public void printLinkedListInReverseOrder() {
		if (existsLinkedList()) {
			Node tempNode = tail;
			do {
				System.out.print(tempNode.getValue());
				if (tempNode.getPrev() != tail) {
					System.out.print(" <- ");
				}
				tempNode = tempNode.getPrev();
			} while (tempNode != tail);
		} else {
			System.out.println("Linked List does not exists !");
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
		} else {
			System.out.println("Linked List does not exists !");
		}
		System.out.println();
	}

	// Traverse Linked List reverse order
	void traverseLinkedListInReverseOrder() {
		if (existsLinkedList()) {
			Node tempNode = tail;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.getValue());
				if (i != size - 1) {
					System.out.print(" <- ");
				}
				tempNode = tempNode.getPrev();
			}
		} else {
			System.out.println("Linked List does not exists !");
		}
	}

	// Searching a specified value in linked list
	public boolean searchNode(int value) {
		if (existsLinkedList()) {
			Node tempNode = head;
			do {
				if (tempNode.getValue() == value) {
					System.out.print("Found the node in the Linked List");
					return true;
				}
				tempNode = tempNode.getNext();
			} while (tempNode != head);
		}
		System.out.print("Node not found.");
		return false;
	}

	public void deleteFirstNode() {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return;
		} else { // we want to delete first element
			if (size == 1) {
				head.setNext(null);
				head.setPrev(null);
				head = tail = null;
				size--;
				return;
			} else {
				head = head.getNext();
				head.setPrev(tail);
				tail.setNext(head);
				size--;
			}
		}
	}

	// Deletes a node having a given value
	public void deletionOfNode(int location) {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return;
		} else if (location == 0) { // we want to delete first element
			if (size == 1) {
				head.setNext(null);
				head.setPrev(null);
				head = tail = null;
				size--;
				return;
			} else {
				head = head.getNext();
				head.setPrev(tail);
				tail.setNext(head);
				size--;
			}
		} else if (location >= size) { // If location is not in range or equal, then delete last node
			if (size == 1) { // if this is the only element in the list
				head.setNext(null);
				head.setPrev(null);
				tail = head = null;
				size--;
				return;
			}
			tail = tail.getPrev();
			tail.setNext(head);
			head.setPrev(tail);
			size--;
		} else { // if any inside node is to be deleted
			Node tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // Traverse till we find the location
			}
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			tempNode.getNext().setPrev(tempNode);
			size--;
		}

	}
	
	public void deleteLastNode() {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return;
		} else { // we want to delete first element
			if (size == 1) {
				head.setNext(null);
				head.setPrev(null);
				head = tail = null;
				size--;
				return;
			} else {
				tail = tail.getPrev();
				head.setPrev(tail);
				tail.setNext(head);
				size--;
			}
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

	// Deletion of linked list
	void deleteLinkedList() {
		System.out.println("\nDeleting Linked List.");
		if (tail == null) {
			System.out.println("Linked List is already deleted.");
			return;
		} else {
			head.setPrev(null);
			tail.setNext(null);
			head = null;
			tail = null;
			System.out.println("Linked List deleted successfully.");
		}
	}

	public int getSize() {
		return size;
	}

	public boolean existsLinkedList() {
		// if head is not null retrun true otherwise return false
		return head != null;
	}
}