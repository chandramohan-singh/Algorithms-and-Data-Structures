package linkedList.doubleLinkedList;

public class DoubleLinkedList {

	Node head;
	Node tail;
	int size;

	public Node createDoubleLinkedList(int value) {
		head = new Node();
		Node node = new Node();
		node.setValue(value);
		node.setNext(null);
		node.setPrev(null);
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	public void insertAtStartingOfLinkedList(int value) {
		Node node = new Node();
		node.setValue(value);
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist.");
			return;
		} else {// insert at first position
			node.setNext(head);
			node.setPrev(null);
			head.setPrev(node);
			head = node;
			size++;
		}
	}

	public void insertInLinkedList(int value, int location) {
		Node node = new Node();
		node.setValue(value);
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist.");
			return;
		} else if (location == 0) {// insert at first position
			node.setNext(head);
			node.setPrev(null);
			head.setPrev(node);
			head = node;
		} else if (location >= size) {// insert at last position
			node.setNext(null);
			tail.setNext(node);
			node.setPrev(tail);
			tail = node;
		} else {// insert at specified location
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {// loop till we reach specified node
				tempNode = tempNode.getNext();
				index++;
			}
			node.setPrev(tempNode); // set node prev as tempNode
			node.setNext(tempNode.getNext()); // set node next as tempNode next
			tempNode.setNext(node); // set tempNode as node
			node.getNext().setPrev(node); // set tempNode next prev as node
		}
		size++;
	}

	public void insertAtLastOfLinkedList(int value) {
		Node node = new Node();
		node.setValue(value);
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist.");
			return;
		} else {// insert at first position
			node.setNext(null);
			tail.setNext(node);
			node.setPrev(tail);
			tail = node;
			size++;
		}
	}

	// Traverse the linked list from head to last
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
			System.out.println("Linked List does not exists");
		}
		System.out.println("\n");
	}

	// Traverse the linked list from head to last
	public void traverseLinkedListInReverseOrder() {
		if (existsLinkedList()) {
			Node tempNode = tail;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.getValue());
				if (tempNode.getPrev() != null) {
					System.out.print(" <- ");
				}
				tempNode = tempNode.getPrev();
			}
		} else {
			System.out.println("Linked List does not exists.");
		}
		System.out.println("\n");
	}

	// Search for a node in linked list
	boolean searchNode(int nodeValue) {
		if (existsLinkedList()) {
			Node tempNode = head;
			for (int i = 0; i < size; i++) {
				if (tempNode.getValue() == nodeValue) {
					System.out.println("Found the node at locaiton " + i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.print("Node not found.");
		return false;
	}

	// Delete first node
	public void deleteFirstNode() {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist.");
			return;
		} else {
			if (head.getNext() == null) {
				head = tail = null;
				size--;
				return;
			}
			head = head.getNext();
			head.setPrev(null);
			size--;
		}
	}

	// Delete a node of given location
	public void deletionOfNode(int location) {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist.");
			return;
		} else if (location == 0) { // Delete first element
			if (head.getNext() == null) { // if this is the only node in this list
				head = tail = null;
				size--;
				return;
			} else {
				head = head.getNext();
				head.setPrev(null);
				size--;
			}
		} else if (location >= size) { // If location is not in range or equal, then delete last node
			Node tempNode = tail.getPrev(); // temp node points to 2nd last node
			if (tempNode == null) { // if this is the only element in the list
				tail = head = null;
				size--;
				return;
			}
			tempNode.setNext(null);
			tail = tempNode;
			size--;
		} else { // if any inside node is to be deleted
			Node tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the location
			}
			if(null != tempNode.getNext().getNext()) {
				tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
				tempNode.getNext().setPrev(tempNode);
			} else {
				tempNode.setNext(null);
				tail = tempNode;
			}
			size--;
		}
	}
	
	public void deleteLastNode() {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist.");
			return;
		} else {
			Node tempNode = tail.getPrev(); // tempNode points to 2nd last node
			if (tempNode == null) { // if this is the only element in the list
				tail = head = null;
				size--;
				return;
			}
			tempNode.setNext(null);
			tail = tempNode;
			size--;
		}
	}

	// delete whole linked list
	public void deleteLinkedList() {
		System.out.println("\nDeleting Linked List.");
		Node tempNode = head;
		for (int i = 0; i < size; i++) {
			tempNode.setPrev(null);
			tempNode = tempNode.getNext();
		}
		head = null;
		tail = null;
		System.out.println("Linked List deleted successfully.");
	}

	public int getSize() {
		return size;
	}

	public boolean existsLinkedList() {
		// if head is not null retrun true otherwise return false
		return head != null;
	}
}
