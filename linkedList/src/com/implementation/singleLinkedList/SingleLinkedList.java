package com.implementation.singleLinkedList;

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

	// Insert a value in Linked List at giveb location
	public void insertInLinkedListAtGivenLocation(int value, int location) {
		Node node = new Node();
		node.setValue(value);
		if (!existsLinkedList()) {
			System.out.println("Linked list does not exist.");
			return;
		} else if (location == 0) { // insert at first
			node.setNext(head);
			head = node;
		} else if (location >= size) { // insert at last
			node.setNext(null);
			tail.setNext(node);
			tail = node;
		} else { // insert at given location
			Node tempNode = head;
			int index = 0;
			// loop till we reach specified node
			while (index < location - 1) {
				tempNode = tempNode.getNext();
				index++;
			}
			// tempNode currently pointing to node after which we need to insert a new node
			// nextNode is the immediate next node after new node
			Node nextNode = tempNode.getNext();
			// update reference of tempNode to reference to new node
			tempNode.setNext(node);
			// update newly added nodes next with nextNode.
			node.setNext(nextNode);
		}
		size++;
	}

	// Insert a value in the last of the Linked List
	public void insertAtLastInLinkedList(int value) {
		Node node = new Node();
		node.setValue(value);
		if (!existsLinkedList()) {
			System.out.println("Linked list does not exist.");
			return;
		} else { // insert at last
			node.setNext(null);
			tail.setNext(node);
			tail = node;
		}
		size++;
	}

	// Print Linked List
	public void printLinkedList() {
		if (existsLinkedList()) {
			System.out.println("Printing Linked List.");
			Node tempNode = head;
			while (tempNode != null) {
				System.out.print(tempNode.getValue());
				if (tempNode.getNext() != null) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		} else {
			System.out.println("Linked List does not exists.");
		}
		System.out.println();
	}

	// Print Linked List
	public void traverseLinkedList() {
		if (existsLinkedList()) {
			Node tempNode = head;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.getValue());
				if (tempNode.getNext() != null) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		} else {
			System.out.println("Linked List does not exists !");
		}
		System.out.println();
	}

	// Searches a node with given value
	public boolean searchNode(int nodeValue) {
		if (existsLinkedList()) {
			Node tempNode = head;
			for (int i = 0; i < size; i++) {
				if (tempNode.getValue() == nodeValue) {
					System.out.print("Found the node at location: " + i + "\n");
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.print("Node not found.\n");
		return false;
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

	// Deletes a node having a given value
	public void deletionOfNode(int location) {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return;
		} else if (location >= size) {
			System.out.println("Location does not exists in the link list.");
		} else if (location == 0) { // If location is at starting position
			head = head.getNext();
			size--;
			if (size == 0) { // if there are no more nodes in this list
				tail = null;
			}
		} else if (location == size - 1) { // If location is of last position
			Node tempNode = head;
			for (int i = 0; i < size - 1; i++) {
				tempNode = tempNode.getNext(); // tempNode points to 2nd last node
			}
			if (tempNode == head) { // if this is the only element in the list
				tail = head = null;
				size--;
				return;
			}
			tempNode.setNext(null);
			tail = tempNode;
			size--;
		} else { // if any inside node is to be deleted, traverse till we find the location
			Node tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			size--;
		}
	}

	// Delete a value in the starting of the Linked List
	public void deleteLastNode() {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return;
		} else {
			Node tempNode = head;
			while (tempNode.getNext() != tail) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(null); // delete the required node
			tail = tempNode;
			size--;
		}
	}

	// Deletes entire Linked List
	void deleteLinkedList() {
		head = null;
		tail = null;
		System.out.println("Linked List deleted successfully.");
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
